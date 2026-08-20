/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package com.dimata.webclient.bphtb;
import com.dimata.dtaxintegration.entity.inquery.InqueryProses;
import com.dimata.dtaxintegration.entity.logsApi.PstLogApi;
import com.dimata.dtaxintegration.entity.tagihan.Tagihan;
import com.dimata.webclient.AppSettingBphtb;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
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
import org.json.JSONArray;
import org.json.JSONObject;

import org.w3c.dom.*;
/**
 *
 * @author dimata005
 */
public class InqueryBphtb {
    public static String code = "";
    public static String getCode(){
        return code;
    }
    public String action(InqueryProses inqueryProses){
        String resp_code = new String();
        String resp_message = new String();
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(inqueryProses), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            System.out.println("SOAP Respon = "+raw_respon);
            resp_code = StringUtils.substringBetween(raw_respon,"<code>","</code>");
            resp_message=StringUtils.substringBetween(raw_respon,"<message>","</message>");
            
            System.out.println("=============================================");
            System.out.println("GET STATUS");
            System.out.println("Respone Code = "+ resp_code);
            System.out.println("Respone Code = "+ resp_message);
            System.out.println("=============================================");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp_code;
    }
    
    public Vector InqueryBPHTB(InqueryProses inqueryProses){
        String resp_code = new String();
        String resp_message = new String();
        Vector listTagihan =new Vector();
        PstLogApi pstLogApi = new PstLogApi();
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(inqueryProses), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            
            resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
            if(resp_code  != null){
                resp_code = resp_code.replace("&quot;", "'");
                JSONObject data = new JSONObject(resp_code);
                JSONArray dataList = (JSONArray) data.getJSONArray("data");

                //log API
                this.code = ""+data.opt("code");
                EchoTagihanDeleteByRecordIdBphtb.status = "Berhasil Mengambil Data";
                pstLogApi.setLogApiBpd("ws_inquiry_tagihan", ""+data.opt("message"), "Upload Manual BPHTB", ""+data.opt("code"));

                for (int i = 0; i < dataList.length(); i++) {
                        JSONObject getData = (JSONObject) dataList.getJSONObject(i);
                        Tagihan tagihan = new Tagihan();

                        tagihan.setId(getData.getString("recordId"));//1
                        tagihan.setNoId(getData.getString("No BPHTB"));
                        tagihan.setNama(getData.getString("nama"));//2
                        tagihan.setTagihan(getData.getString("tagihan"));//3
                        tagihan.setInstansiId(getData.getString("instansi"));//4
                        tagihan.setNop(getData.getString("NOP"));
                        tagihan.setnPWP(getData.getString("PPAT"));
                        tagihan.setTagihan(getData.getString("tagihan"));
                        tagihan.setStsBayar(getData.getString("sts_bayar"));

                        listTagihan.add(tagihan);
                 }
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API
                pstLogApi.setLogApiBpd("ws_inquiry_tagihan", ""+resp_code, "Upload Manual BPHTB", "99");
                this.code = "99";
                EchoTagihanDeleteByRecordIdBphtb.status = "Error Cause : "+resp_code;
            }
        } catch (Exception ex) {
            //log API
            pstLogApi.setLogApiBpd("ws_inquiry_tagihan", ""+ex.getMessage(), "Upload Manual BPHTB", "99");
            this.code = "99";
            EchoTagihanDeleteByRecordIdBphtb.status = "Error Cause : "+resp_code;
        }
        return listTagihan;
    }
    
    public static SOAPMessage createSOAPRequest(InqueryProses inqueryProses) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:inquiryTagihan";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_inquiry_tagihan", "urn", ""));
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username").addTextNode(""+inqueryProses.getsUser());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password").addTextNode(""+inqueryProses.getsPassword());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("instansi").addTextNode(""+inqueryProses.getsInstansi());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("noid").addTextNode(""+inqueryProses.getsNoId());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "inquiry_tagihan");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
}
