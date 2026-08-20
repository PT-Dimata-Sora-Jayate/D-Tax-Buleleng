/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package com.dimata.webclient.bphtb;

import com.dimata.webclient.*;
import com.dimata.dtaxintegration.entity.inquery.Payment;
import com.dimata.dtaxintegration.entity.laporan.LaporanPayment;
import com.dimata.dtaxintegration.entity.logsApi.PstLogApi;
import com.dimata.dtaxintegration.session.bphtb.DTaxIntegrationManagerPaymentBphtb;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import org.w3c.dom.*;
/**
 *
 * @author dimata005
 */
public class EchoLaporanPaymentDetailBphtb {
   
   public Vector getListPaymentDetailBPHTB(LaporanPayment laporanPayment){
        String resp_code = new String();
        String resp_message = new String();
        Vector listPayment=new Vector();
        PstLogApi pstLogApi = new PstLogApi();
        
        try {
            
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(laporanPayment), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            
            resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
            if(resp_code  != null){
                resp_code = resp_code.replace("&quot;", "'");
                JSONObject data = new JSONObject(resp_code);
                JSONArray dataList = (JSONArray) data.getJSONArray("data");
                
                //log API
                DTaxIntegrationManagerPaymentBphtb.code = ""+data.opt("code");
                DTaxIntegrationManagerPaymentBphtb.status = ""+data.opt("message");
                pstLogApi.setLogApiBpd("ws_laporan_payment_detail", ""+data.opt("message"), "Manual Payment BPHTB", ""+data.opt("code"));

                 int count =0;
                 for (int i = 0; i < dataList.length(); i++) {

                        Payment payment = new Payment();

                        count=count+1;
                        JSONObject getData = (JSONObject) dataList.getJSONObject(i);

                        payment.setId(String.valueOf(getData.opt("noBukti")));
                        payment.setInstansi(String.valueOf(getData.opt("instansi")));
                        payment.setNoId(String.valueOf(getData.opt("No BPHTB")));
                        payment.setNama(String.valueOf(getData.opt("nama")));
                        payment.setTagihan(String.valueOf(getData.opt("tagihan")));
                        payment.setKetTagihan(String.valueOf(getData.opt("Terbilang")));
                        payment.setTglTx(String.valueOf(getData.opt("tgl_tx")));
                        payment.setStsBayar(String.valueOf(getData.opt("sts_bayar")));
                        payment.setKdCab(String.valueOf(getData.opt("kd_cab")));
                        payment.setKdUser(String.valueOf(getData.opt("kd_user")));
                        payment.setStsReversal(String.valueOf(getData.opt("sts_reversal")));
                        payment.setNOP(String.valueOf(getData.opt("NOP")));

                        listPayment.add(payment);
                 }

                DTaxIntegrationManagerPaymentBphtb.status = "Jumlah Download Data : "+count;
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API
                pstLogApi.setLogApiBpd("ws_laporan_payment_detail", ""+resp_code, "Download BPHTB", "99");
                DTaxIntegrationManagerPaymentBphtb.code = "99";
                DTaxIntegrationManagerPaymentBphtb.status = "Gagal Penarikan Pembayaran Dari Bank";
            }
        } catch (Exception ex) {
            //log API
            pstLogApi.setLogApiBpd("ws_laporan_payment_detail", ""+ex.getMessage(), "Download BPHTB", "99");
            DTaxIntegrationManagerPaymentBphtb.code = "99";
            DTaxIntegrationManagerPaymentBphtb.status = "Gagal Penarikan Pembayaran Dari Bank";
        }
        return listPayment;
    }
   
   public static SOAPMessage createSOAPRequest(LaporanPayment laporanPayment) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:laporanPaymentDetail";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_laporan_payment_detail", "urn", ""));
        
        soapBodyElem.addChildElement("username").addTextNode(""+laporanPayment.getsUser());
        soapBodyElem.addChildElement("password").addTextNode(""+laporanPayment.getsPassword());
        soapBodyElem.addChildElement("instansi").addTextNode(""+laporanPayment.getsInstansi());
        soapBodyElem.addChildElement("tanggal").addTextNode(""+laporanPayment.getsDate());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "laporan_payment_detail");

        soapMessage.saveChanges();

        /* Print the request message */
        soapMessage.writeTo(System.out);

        return soapMessage;
    }
    public Vector getListPaymentDetailIprotax(LaporanPayment laporanPayment){
        String resp_code = new String();
        String resp_message = new String();
        Vector listPayment=new Vector();
        PstLogApi pstLogApi = new PstLogApi();
        
        try {
            
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(laporanPayment), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            
            resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
            if(resp_code  != null){
                resp_code = resp_code.replace("&quot;", "'");
                JSONObject data = new JSONObject(resp_code);
                JSONArray dataList = (JSONArray) data.getJSONArray("data");

                //log API
                DTaxIntegrationManagerPaymentBphtb.code = ""+data.opt("code");
                //pstLogApi.setLogApiBpd("ws_laporan_payment_detail", ""+data.opt("message"), "Payment BPHTB", ""+data.opt("code"));

                 int count =0;
                 for (int i = 0; i < dataList.length(); i++) {
                    Payment payment = new Payment();

                    count=count+1;
                    JSONObject getData = (JSONObject) dataList.getJSONObject(i);

                    payment.setId(String.valueOf(getData.opt("noBukti")));
                    payment.setInstansi(String.valueOf(getData.opt("instansi")));
                    payment.setNoId(String.valueOf(getData.opt("No BPHTB")));
                    payment.setNama(String.valueOf(getData.opt("nama")));
                    payment.setTagihan(String.valueOf(getData.opt("tagihan")));
                    payment.setKetTagihan(String.valueOf(getData.opt("Terbilang")));
                    payment.setTglTx(String.valueOf(getData.opt("tgl_tx")));
                    payment.setStsBayar(String.valueOf(getData.opt("sts_bayar")));
                    payment.setKdCab(String.valueOf(getData.opt("kd_cab")));
                    payment.setKdUser(String.valueOf(getData.opt("kd_user")));
                    payment.setStsReversal(String.valueOf(getData.opt("sts_reversal")));
                    payment.setNOP(String.valueOf(getData.opt("NOP")));

                    listPayment.add(payment);
                 }
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API 
                pstLogApi.setLogApiBpd("ws_tagihan_insert", ""+resp_code, "Payment BPHTB", "99");
                DTaxIntegrationManagerPaymentBphtb.status = "Gagal Penarikan Payment Dari Bank";
                DTaxIntegrationManagerPaymentBphtb.code = "99";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //log API
            pstLogApi.setLogApiBpd("ws_laporan_payment_detail", ""+ex.toString(), "Payment BPHTB", "99");
            DTaxIntegrationManagerPaymentBphtb.status = "Gagal Penarikan Payment Dari Bank";
            DTaxIntegrationManagerPaymentBphtb.code = "99";
        }
        return listPayment;
    }
    
    public Vector getListPaymentDetailIprotaxStlBukti(LaporanPayment laporanPayment){
        String resp_code = new String();
        String resp_message = new String();
        Vector listPayment=new Vector();
        PstLogApi pstLogApi = new PstLogApi();
        
        try {
            
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequestSthNoBukti(laporanPayment), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            
            resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
            if(resp_code  != null){
                resp_code = resp_code.replace("&quot;", "'");
                JSONObject data = new JSONObject(resp_code);
                JSONArray dataList = (JSONArray) data.getJSONArray("data");

                //log API
                DTaxIntegrationManagerPaymentBphtb.status =  "Berhasil Get Data Dari Bank";
                DTaxIntegrationManagerPaymentBphtb.code = ""+data.opt("code");
                //pstLogApi.setLogApiBpd("ws_laporan_payment_detail_setelah_no_bukti", ""+data.opt("message"), "Automatic Payment BPHTB", ""+data.opt("code"));

                 int count =0;
                 for (int i = 0; i < dataList.length(); i++) {

                    Payment payment = new Payment();

                    count=count+1;
                    JSONObject getData = (JSONObject) dataList.getJSONObject(i);

                    payment.setId(String.valueOf(getData.opt("noBukti")));
                    payment.setInstansi(String.valueOf(getData.opt("instansi")));
                    payment.setNoId(String.valueOf(getData.opt("No BPHTB")));
                    payment.setNama(String.valueOf(getData.opt("nama")));
                    payment.setTagihan(String.valueOf(getData.opt("tagihan")));
                    payment.setKetTagihan(String.valueOf(getData.opt("Terbilang")));
                    payment.setTglTx(String.valueOf(getData.opt("tgl_tx")));
                    payment.setStsBayar(String.valueOf(getData.opt("sts_bayar")));
                    payment.setKdCab(String.valueOf(getData.opt("kd_cab")));
                    payment.setKdUser(String.valueOf(getData.opt("kd_user")));
                    payment.setStsReversal(String.valueOf(getData.opt("sts_reversal")));
                    payment.setNOP(String.valueOf(getData.opt("NOP")));

                    listPayment.add(payment);
                 }
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API
                pstLogApi.setLogApiBpd("ws_laporan_payment_detail_setelah_no_bukti", ""+resp_code, "Automatic Payment BPHTB", "99");
                DTaxIntegrationManagerPaymentBphtb.status = "Gagal Penarikan Payment Dari Bank";
                DTaxIntegrationManagerPaymentBphtb.code = "99";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            DTaxIntegrationManagerPaymentBphtb.status = "<br> Tidak terkoneksi ke BPD Payment : ";
            //log API
            pstLogApi.setLogApiBpd("ws_laporan_payment_detail_setelah_no_bukti", ""+ex.toString(), "Automatic Payment BPHTB", "99");
            DTaxIntegrationManagerPaymentBphtb.status = "Gagal Penarikan Payment Dari Bank";
            DTaxIntegrationManagerPaymentBphtb.code = "99";
        }
        return listPayment;
    }
    
   public static SOAPMessage createSOAPRequestSthNoBukti(LaporanPayment laporanPayment) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:laporanPaymentDetailSetelahNoBukti";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_laporan_payment_detail_setelah_no_bukti", "urn", ""));
        
        soapBodyElem.addChildElement("username").addTextNode(""+laporanPayment.getsUser());
        soapBodyElem.addChildElement("password").addTextNode(""+laporanPayment.getsPassword());
        soapBodyElem.addChildElement("instansi").addTextNode(""+laporanPayment.getsInstansi());
        soapBodyElem.addChildElement("tanggal").addTextNode(""+laporanPayment.getsDate());
        soapBodyElem.addChildElement("nobukti").addTextNode(""+laporanPayment.getsNoId());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "laporan_payment_detail_setelah_no_bukti");

        soapMessage.saveChanges();

        /* Print the request message */
        soapMessage.writeTo(System.out);

        return soapMessage;
    }
   
}
