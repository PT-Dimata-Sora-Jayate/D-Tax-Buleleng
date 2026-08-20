/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package com.dimata.webclient.bphtb;

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
public class EchoTagihanDeleteByRecordIdBphtb {
    public static String status = "";
    public static String code = "";
    public static String getStatus(){
        return status;
    }
    public static String getCode(){
        return code;
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

                if(data.opt("code").equals("00")){
                    SessSimpatdaBphtb.deleteHistory(tagihanDeleteInstansi.getsNoId(),tagihanDeleteInstansi.getsInstansi());
                }

                this.code = ""+data.opt("code");
                status = ""+data.opt("message");

                //log API
                pstLogApi.setLogApiBpd("ws_tagihan_delete_by_record_id", ""+data.opt("message"), "Upload Manual BPHTB", ""+data.opt("code"));
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API
                pstLogApi.setLogApiBpd("ws_tagihan_delete_by_record_id", ""+resp_code, "Upload Manual BPHTB", "99");
                status = "Error Cause : "+resp_code;
                this.code = "99"; 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //log API 
            pstLogApi.setLogApiBpd("ws_tagihan_delete_by_record_id", ""+ex.getMessage(), "Upload Manual BPHTB", "99");
            status = "Gagal Hapus Tagihan Pada Bank";
            this.code = "99"; 
        }
        return resp_code;
    }

    public static SOAPMessage createSOAPRequest(TagihanDelete tagihanDeleteInstansi) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:tagihanDeleteByRecordId";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_tagihan_delete_by_record_id", "urn", ""));
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username").addTextNode(""+tagihanDeleteInstansi.getsUser());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password").addTextNode(""+tagihanDeleteInstansi.getsPassword());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("instansi").addTextNode(""+tagihanDeleteInstansi.getsInstansi());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("noid").addTextNode(""+tagihanDeleteInstansi.getsNoId());
        SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("recordid").addTextNode(""+tagihanDeleteInstansi.getsRecordId());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "tagihan_delete_by_record_id");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
}
