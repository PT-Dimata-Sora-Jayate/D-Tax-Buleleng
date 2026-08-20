 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.webclient.bphtb;

import com.dimata.dtaxintegration.entity.logsApi.PstLogApi;
import com.dimata.dtaxintegration.entity.tagihan.TagihanInsert;
import com.dimata.dtaxintegration.session.DTaxIntegrationManagerAutoBphtb;
import com.dimata.webclient.AppSettingBphtb;
import java.io.ByteArrayOutputStream;
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
import org.json.JSONObject;
/**
 *
 * @author dimata005
 */
public class EchoTagihanInsertBphtb {
    public String action(TagihanInsert tagihanInsert){
        String resp_code = new String();
        String code = new String();
        PstLogApi pstLogApi = new PstLogApi();
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(tagihanInsert), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            
            resp_code = StringUtils.substringBetween(raw_respon,"<return xsi:type=\"xsd:string\">","</return>");
            if(resp_code  != null){
                resp_code = resp_code.replace("&quot;", "'");
                JSONObject data = new JSONObject(resp_code);

                code = ""+data.opt("code");
                
                EchoTagihanDeleteByRecordIdBphtb.code =  ""+data.opt("code");
                EchoTagihanDeleteByRecordIdBphtb.status = ""+data.optString("message");

                //log API
                //pstLogApi.setLogApiBpd("ws_tagihan_insert", ""+data.opt("message"), "Upload BPHTB", ""+data.opt("code"));
                //EchoTagihanDeleteByRecordIdBphtb.status = "Berhasil Upload Tagihan";
            }else{
                resp_code = StringUtils.substringBetween(raw_respon,"<faultstring xsi:type=\"xsd:string\">","</faultstring>");
                //log API
                pstLogApi.setLogApiBpd("ws_tagihan_insert", ""+resp_code, "Upload BPHTB", "99");
                EchoTagihanDeleteByRecordIdBphtb.code =  "99";
                EchoTagihanDeleteByRecordIdBphtb.status = "Gagal Upload Tagihan";
                DTaxIntegrationManagerAutoBphtb.code =  "99";
            }
        } catch (Exception ex) {
            //log API
            pstLogApi.setLogApiBpd("ws_tagihan_insert", ""+ex.getMessage(), "Upload BPHTB", "99");
            EchoTagihanDeleteByRecordIdBphtb.code =  "99";
            EchoTagihanDeleteByRecordIdBphtb.status = "Gagal Upload Tagihan";
            DTaxIntegrationManagerAutoBphtb.code =  "99";
        }
        return code;
    }

    public static SOAPMessage createSOAPRequest(TagihanInsert tagihanInsert) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "urn:tagihanInsert";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("urn", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_tagihan_insert", "urn", ""));
        
        soapBodyElem.addChildElement("username").addTextNode(""+tagihanInsert.getsUser());
        soapBodyElem.addChildElement("password").addTextNode(""+tagihanInsert.getSPassword());
        soapBodyElem.addChildElement("noid").addTextNode(""+tagihanInsert.getSNoId());
        soapBodyElem.addChildElement("nama").addTextNode(""+tagihanInsert.getSNama());
        soapBodyElem.addChildElement("tagihan").addTextNode(""+tagihanInsert.getJumTagihan());
        soapBodyElem.addChildElement("instansi").addTextNode(""+tagihanInsert.getSInstansi());
        soapBodyElem.addChildElement("ket_1_val").addTextNode("" + tagihanInsert.getSKet_1());
        soapBodyElem.addChildElement("ket_2_val").addTextNode("" + tagihanInsert.getSKet_2());
        soapBodyElem.addChildElement("ket_3_val").addTextNode("" + tagihanInsert.getSKet_3());
        soapBodyElem.addChildElement("ket_4_val").addTextNode("" + tagihanInsert.getSKet_4());
        soapBodyElem.addChildElement("ket_5_val").addTextNode("" + tagihanInsert.getSKet_5());
        soapBodyElem.addChildElement("ket_6_val").addTextNode("" + tagihanInsert.getSKet_6());
        soapBodyElem.addChildElement("ket_7_val").addTextNode("" + tagihanInsert.getSKet_7());
        soapBodyElem.addChildElement("ket_8_val").addTextNode("" + tagihanInsert.getSKet_8());
        soapBodyElem.addChildElement("ket_9_val").addTextNode("" + tagihanInsert.getSKet_9());
        soapBodyElem.addChildElement("ket_10_val").addTextNode("" + tagihanInsert.getSKet_10());
        soapBodyElem.addChildElement("ket_11_val").addTextNode("" + tagihanInsert.getSKet_11());
        soapBodyElem.addChildElement("ket_12_val").addTextNode("" + tagihanInsert.getSKet_12());
        soapBodyElem.addChildElement("ket_13_val").addTextNode("" + tagihanInsert.getSKet_13());
        soapBodyElem.addChildElement("ket_14_val").addTextNode("" + tagihanInsert.getSKet_14());
        soapBodyElem.addChildElement("ket_15_val").addTextNode("" + tagihanInsert.getSKet_15());
        soapBodyElem.addChildElement("ket_16_val").addTextNode("" + tagihanInsert.getSKet_16());
        soapBodyElem.addChildElement("ket_17_val").addTextNode("" + tagihanInsert.getSKet_17());
        soapBodyElem.addChildElement("ket_18_val").addTextNode("" + tagihanInsert.getSKet_18());
        soapBodyElem.addChildElement("ket_19_val").addTextNode("" + tagihanInsert.getSKet_19());
        soapBodyElem.addChildElement("ket_20_val").addTextNode("" + tagihanInsert.getSKet_20());
        soapBodyElem.addChildElement("ket_21_val").addTextNode("" + tagihanInsert.getSKet_21());
        soapBodyElem.addChildElement("ket_22_val").addTextNode("" + tagihanInsert.getSKet_22());
        soapBodyElem.addChildElement("ket_23_val").addTextNode("" + tagihanInsert.getSKet_23());
        soapBodyElem.addChildElement("ket_24_val").addTextNode("" + tagihanInsert.getSKet_24());
        soapBodyElem.addChildElement("ket_25_val").addTextNode("" + tagihanInsert.getSKet_25());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "tagihan_insert");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
}
