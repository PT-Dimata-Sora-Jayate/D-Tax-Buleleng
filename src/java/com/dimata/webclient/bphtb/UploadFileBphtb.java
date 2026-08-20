/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.webclient.bphtb;

/** 
 *
 * @author dimata005 
 */
import com.dimata.dtaxintegration.entity.inquery.InqueryProses;
import com.dimata.dtaxintegration.entity.loghistory.LogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.logsApi.PstLogApi;
import com.dimata.dtaxintegration.entity.tagihan.CreateFileBphtb;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.dtaxintegration.entity.tagihan.Tagihan;
import com.dimata.dtaxintegration.entity.tagihan.TagihanDelete;
import com.dimata.dtaxintegration.session.DTaxIntegrationManagerAutoBphtb;
import com.dimata.dtaxintegration.session.bphtb.DTaxIntegrationMonitorBphtb;
import com.dimata.dtaxintegration.session.bphtb.DTaxManagerBphtb;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSettingBphtb;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.commons.lang.StringUtils;
import com.oschrenk.io.Base64;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.xml.soap.SOAPBodyElement;
import org.json.JSONObject;

public class UploadFileBphtb {

    public String actionBPHTB(FileSent fileSent) {
        String resp_status = new String();
        String resp_code = new String();
        DTaxManagerBphtb dTaxManagerBphtbx = new DTaxManagerBphtb();
        String statusProses = "";
        PstLogApi pstLogApi = new PstLogApi();
        try {
//            int startYear = Integer.parseInt(fileSent.getTahunStart());
//            int endYear = Integer.parseInt(fileSent.getTahunEnd());
//            if(startYear<=endYear){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
                SOAPConnection soapConnection = soapConnectionFactory.createConnection();
                String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;
                String patchFileUpload = "";
                String patchFileUploadZip = "";
                try {
                    CreateFileBphtb sent = new CreateFileBphtb();
                    if (AppSettingBphtb.TYPE_APP_BACKOFFICE == 1) {
                        patchFileUpload = CreateFileBphtb.sentBphtbIprotax(fileSent);
                    } else {
                        //patchFileUpload = CreateFileBphtb.sentPbb(fileSent);
                    } 
                    if (!DTaxManagerBphtb.running) {
                      resp_status = "Stop";
                      return resp_status;
                    } 
                    statusProses = " / Proses ZIP File on Location " + fileSent.getLocation();
                    DTaxManagerBphtb.statusProses += statusProses;
                    patchFileUploadZip = CreateFileBphtb.zipFile(new File(patchFileUpload), fileSent, 1);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } 
                if (!DTaxManagerBphtb.running) {
                  resp_status = "Stop";
                  return resp_status;
                } 

                DTaxManagerBphtb.statusProses += statusProses + "<br> / Proses Transfer File to BPD Jangan di STOP! ";
                SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(fileSent, patchFileUploadZip), url);
                soapResponse.writeTo(System.out);
                soapResponse.writeTo(out);
                String raw_respon = new String(out.toByteArray());
                resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
                if(resp_code  != null){
                    resp_code = resp_code.replace("&quot;", "'");
                    JSONObject data = new JSONObject(resp_code);

                    DTaxManagerBphtb.resStatus = resp_code;
                    boolean delHistory = true;
                    if (data.opt("code").equals("00")) {
                      DTaxManagerBphtb.statusProses = statusProses + " / Proses pengiriman Berhasil ";
                      delHistory = false;
                    } else if (data.opt("code").equals("03")) {
                      DTaxManagerBphtb.statusProses = statusProses + " / <b style='color: red;'>Proses pengiriman Gagal </b>";
                    } else if (data.opt("code").equals("05")) {
                      DTaxManagerBphtb.statusProses = statusProses + " / <b style='color: red;'>Format atau nama file tidak cocok </b>";
                    } else if (data.opt("code").equals("01")) {
                      DTaxManagerBphtb.statusProses = statusProses + " / <b style='color: red;'>Tidak memiliki wewenang akses </b>";
                    } else if (data.opt("code").equals("11")) {
                      DTaxManagerBphtb.statusProses = statusProses + " / <b style='color: red;'>Tidak diijinkan mengupload data pada jam operasional bank</b>";
                    } else {
                      DTaxManagerBphtb.statusProses = statusProses + " / <b style='color: red;'>Proses pengiriman Gagal <br> Cause :"+data.opt("data")+"</b>";
                    } 
                    
                    if(delHistory){
                        PstLogHistoryTransaksi.deleteloghistoryperinstansi(AppSettingBphtb.INSTANSI_BPHTB);
                        System.out.println("Delete History BPHTB");
                    }
                    DTaxManagerBphtb.resStatus = resp_code;
                    DTaxManagerBphtb.code = ""+data.opt("code");
                    //log API 
                    pstLogApi.setLogApiBpd("ws_upload_bulk", ""+data.opt("message"), "Upload File BPHTB", ""+data.opt("code"));
                }else{
                    resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                    //log API
                    pstLogApi.setLogApiBpd("ws_upload_bulk", ""+resp_code, "Upload BPHTB", "99");
                    DTaxManagerBphtb.code = "99";
                    DTaxManagerBphtb.statusProses = statusProses + " <br>/ Gagal Upload";
                }
//            }else{
//                DTaxManagerBphtb.statusProses = "Error Cause : Awal Tahun Harus Lebih Kecil Dari Akhir Tahun";
//                DTaxManagerBphtb.code = "99"; 
//            }
        } catch (Exception ex) {
            //log API
            pstLogApi.setLogApiBpd("ws_upload_bulk", ""+ex.getMessage(), "Upload BPHTB", "99");
            DTaxManagerBphtb.code = "99";
            DTaxManagerBphtb.statusProses = statusProses + " <br>/ Gagal Upload";
        } 
        return resp_status;
      }

    public static SOAPMessage createSOAPRequest(FileSent fileSent, String lokasi) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:uploadBulk";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_upload_bulk", "urn", ""));
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username").addTextNode("" + fileSent.getsUser());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password").addTextNode("" + fileSent.getsPassword());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("instansi").addTextNode("" + fileSent.getsInstansi());

        File file = new File(lokasi);
        InputStream input = new FileInputStream(lokasi);
        System.out.println(input);
        //byte[] imageBytes = new byte[(int) file.length()];
        //String test = "realhowto";
        //byte[] bFile = new byte[(int) file.length()];
        //String file = readFile(lokasi);
        //String file = readFile(lokasi);
        String res1 = Base64.encodeFromFile(lokasi);//decodecontent
        //byte[] encodedBytes = java.util.Base64.getEncoder().encode(lokasi.getBytes());//base64encodedfilecontent
        //SOAPElement soapBodyElem4 =soapBodyElem.addChildElement("Data", "example").addAttribute(new QName("EncodingType"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("base64encodedfilecontent").addTextNode(res1);
        
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("namafile").addTextNode("" + fileSent.getFileNameZip());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI + "upload_bulk");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
    
    public String autoUploadBPHTB() {
        DTaxManagerBphtb dTaxManagerBphtbx = new DTaxManagerBphtb();
        try {
            // TODO code application logic here
            Date dtNow = new Date();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = Formater.formatDate(dtNow, "yyyy-MM-dd");
            String oDate = Formater.formatDate(dtNow, "yyyy-MM-dd HH:mm:ss");

            String sql = "";
            if (AppSettingBphtb.SQL_VERSION == AppSettingBphtb.DBSVR_ORACLE) {
                sql = "SELECT * FROM VIEW_BPHTB WHERE TGL_REKAM BETWEEN TO_DATE('" + date + " 00:00:00','YYYY-MM-DD HH24:MI:SS') "
                        + "AND TO_DATE('" + date + " 23:59:00','YYYY-MM-DD HH24:MI:SS') OR TGL_TERBIT_SSB_WP "
                        + "= TO_DATE('" + date + "','YYYY-MM-DD')";
            }if (AppSettingBphtb.SQL_VERSION == AppSettingBphtb.DBSVR_MSSQL) {
                sql = "SELECT * FROM VIEW_BPHTB WHERE "
                        + "(TGL_REKAM BETWEEN '" + date + " 00:00:00' AND '" + date + " 23:59:00'"
                        + " OR TGL_TERBIT_SSB_WP BETWEEN '" + date + " 00:00:00' AND '" + date + " 23:59:00') "
                        + " order by TGL_REKAM desc";
            }
            DBResultSet dbrs = null;   
            try {
                dbrs = DBHandler.execQueryResultNew(sql);
                DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Proses Auto Upload penetapan baru dimulai :" + Formater.formatDate(new Date(), "dd-MM-yyyy kk:mm") + "<br>";
                ResultSet rs = dbrs.getResultSet();
                int no = 0;
                while (rs.next()) {
                    no++;
                    DTaxIntegrationManagerAutoBphtb.jmlTagihan +=1;
                    
                    String noId = rs.getString("NO_ID");
                    String strJumlahTagihan = rs.getString("JUM_TAGIHAN");
                    String sNoId = rs.getString("SNOID");

                    InqueryBphtb inquery = new InqueryBphtb();
                    InqueryProses inqueryProses = new InqueryProses();
                    inqueryProses.setsUser(AppSettingBphtb.USERNAME_BPHTB);
                    inqueryProses.setsPassword(AppSettingBphtb.PWD_BPHTB);
                    inqueryProses.setsInstansi(AppSettingBphtb.INSTANSI_BPHTB);
                    inqueryProses.setsNoId(noId);
                    
                    String weClause = ""+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_ID]+" = "+noId;
                    Vector listBank = PstLogHistoryTransaksi.list(0, 0, weClause, "");
                    DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + no + ". Proses NO ID :" + noId + ", Tagihan Pokok : " + strJumlahTagihan + "<br>";
                    if (listBank.size() > 0) {
                        LogHistoryTransaksi tagihan = (LogHistoryTransaksi) listBank.get(0);
                        double totalTagihan = Double.valueOf(strJumlahTagihan);
                        double tagihanBank = Double.valueOf(tagihan.getJumlahPajak());
                        if (totalTagihan != tagihanBank) {
                            //delete dulu
                            DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Tagihan sudah ada pada bank, namun total tagihan berbeda, mencoba menghapus..<br>";
                            EchoTagihanDeleteByRecordIdBphtb echoTagihanDeleteByRecordId = new EchoTagihanDeleteByRecordIdBphtb();
                            TagihanDelete tagihanDelete = new TagihanDelete();
                            tagihanDelete.setsUser(AppSettingBphtb.USERNAME_BPHTB);
                            tagihanDelete.setsPassword(AppSettingBphtb.PWD_BPHTB);
                            tagihanDelete.setsInstansi(AppSettingBphtb.INSTANSI_BPHTB);
                            tagihanDelete.setsNoId(noId);
                            tagihanDelete.setsRecordId(tagihan.getId());
                            String respCode = echoTagihanDeleteByRecordId.action(tagihanDelete);

                            if (respCode.equals("00")) {
                                DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Berhasil dihapus<br>";
                                DTaxIntegrationMonitorBphtb dtax = new DTaxIntegrationMonitorBphtb();
                                String whereSent = " WHERE NO_ID='" + noId + "' AND SNOID='" + sNoId + "'";
                                dtax.sentBphtb(whereSent);
                            }

                        } else {
                            DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Tagihan sudah ada pada bank!<br><br>";
                            DTaxIntegrationManagerAutoBphtb.tagihanBank +=1;
                        }
                    } else {
                        DTaxIntegrationMonitorBphtb dtax = new DTaxIntegrationMonitorBphtb();
                        String whereSent = " WHERE NO_ID='" + noId + "' AND SNOID='" + sNoId + "'";
                        dtax.sentBphtb(whereSent);
                    }

                }
            } catch (Exception exc) {
                System.out.println(exc.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

     private static String hexEncode(String in) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < (in.length() - 2) + 1; i = i + 2) {
            int c = Integer.parseInt(in.substring(i, i + 2), 16);
            char chr = (char) c;
            sb.append(chr);
        }
        return sb.toString();
    }
    
    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
// File is too large
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
    
   private static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
}
