/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package com.dimata.webclient.bphtb;

import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.logsApi.PstLogApi;
import com.dimata.dtaxintegration.entity.tagihan.TagihanDelete;
import com.dimata.dtaxintegration.session.bphtb.SessSimpatdaBphtb;
import com.dimata.webclient.AppSettingBphtb;
import java.io.ByteArrayOutputStream;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
/**
 *
 * @author dimata005
 */
public class EchoTagihanDeleteInstansiBphtb {
    public static String message = "";
    public static String proses = "";
    public static String status = "";
    public static String prosesBPD = "";
    public static String getStatus(){
        return status;
    }
    public static String getProsesBPD(){
        return prosesBPD;
    }
    public static String getProses(){
        return proses;
    }
    
    public String action(TagihanDelete tagihanDeleteInstansi){
        String resp_code = new String();
        String resp_message = new String();
        PstLogApi pstLogApi = new PstLogApi();
        
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(tagihanDeleteInstansi), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
            if(resp_code  != null){
                resp_code = resp_code.replace("&quot;", "'");
                JSONObject data = new JSONObject(resp_code);

                resp_message = (String)data.opt("code");
                if(data.opt("code").equals("00")){
                    //hapus data di log
                    String whereDelete = ""+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_INSTANSI]+"='"+AppSettingBphtb.INSTANSI_BPHTB+"'";
                    SessSimpatdaBphtb.deleteExc(whereDelete);
                }

                //log API 
                this.prosesBPD = ""+data.opt("code");
                status = "Berhasil Hapus Tagihan Pada Bank";
                pstLogApi.setLogApiBpd("ws_tagihan_delete_by_instansi", ""+data.opt("message"), "Delete BPHTB", ""+data.opt("code"));
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API
                pstLogApi.setLogApiBpd("ws_tagihan_delete_by_instansi", ""+resp_code, "Delete BPHTB", "99");
                status = "Gagal Hapus Tagihan Pada Bank";
                this.prosesBPD = "99"; 
            }
        } catch (Exception ex) {
            //log API
            pstLogApi.setLogApiBpd("ws_tagihan_delete_by_instansi", ""+ex.getMessage(), "Delete BPHTB", "99");
            status = "Gagal Hapus Tagihan Pada Bank";
            this.prosesBPD = "99"; 
        }
        return resp_message;
    }

     public static SOAPMessage createSOAPRequest(TagihanDelete tagihanDeleteInstansi) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:tagihanDeleteByInstansi";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_tagihan_delete_by_instansi", "urn", ""));
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username").addTextNode(""+tagihanDeleteInstansi.getsUser());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password").addTextNode(""+tagihanDeleteInstansi.getsPassword());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("instansi").addTextNode(""+tagihanDeleteInstansi.getsInstansi());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "tagihan_delete_instansi");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
}
