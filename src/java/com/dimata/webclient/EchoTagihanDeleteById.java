/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.webclient;
import com.dimata.dtaxintegration.entity.tagihan.TagihanDelete;
import java.io.ByteArrayOutputStream;
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
/**
 *
 * @author dimata005
 */
public class EchoTagihanDeleteById {
    
//            public static void main(String[] args) {
//
//        String resp_status = new String();
//        String resp_code = new String();
//        try {
//            // TODO code application logic here
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//            String url = AppSetting.IP_BANK_BPD;//"http://192.168.201.78:88/index.asmx";
//            TagihanDelete tagihanDeleteInstansi = new TagihanDelete();
//            tagihanDeleteInstansi.setsUser(AppSetting.USERNAME_PBB);
//            tagihanDeleteInstansi.setsPassword(AppSetting.PWD_PBB);
//            tagihanDeleteInstansi.setsInstansi(AppSetting.INSTANSI_PBB);
//            tagihanDeleteInstansi.setsNoId("0");
//            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(tagihanDeleteInstansi), url);
//            soapResponse.writeTo(System.out);
//
//            soapResponse.writeTo(out);
//            String raw_respon = new String(out.toByteArray());
//            System.out.println("SOAP Respon = "+raw_respon);
//            resp_code = StringUtils.substringBetween(raw_respon,"<code>","</code>");
//
//            System.out.println("=============================================");
//            System.out.println("GET STATUS");
//            System.out.println("Respone Code = "+ resp_code);
//            System.out.println("status = "+ resp_status);
//            System.out.println("=============================================");
//
//        } catch (Exception ex) {
//
//            ex.printStackTrace();
//
//          }
//      }
    private static String logErorDeteleDataTagihan="";

    /**
     * @return the logErorDeteleDataTagihan
     */
    public static String getLogErorDeteleDataTagihan() {
        return logErorDeteleDataTagihan;
    }

    /**
     * @param aLogErorDeteleDataTagihan the logErorDeteleDataTagihan to set
     */
    public static void setLogErorDeteleDataTagihan(String aLogErorDeteleDataTagihan) {
        logErorDeteleDataTagihan = aLogErorDeteleDataTagihan;
    }
    
    public synchronized String action(TagihanDelete tagihanDeleteInstansi){
        String resp_code = new String();
        String resp_message = new String();
        setLogErorDeteleDataTagihan("");
         String raw_respon ="";
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSetting.IP_BANK_BPD;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(tagihanDeleteInstansi), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            raw_respon = new String(out.toByteArray());
            System.out.println("SOAP Respon = "+raw_respon);
            resp_code = StringUtils.substringBetween(raw_respon,"<code>","</code>");
            resp_message=StringUtils.substringBetween(raw_respon,"<message>","</message>");

            System.out.println("=============================================");
            System.out.println("GET STATUS");
            System.out.println("Respone Code = "+ resp_code);
            System.out.println("Respone Message = "+ resp_message);
            System.out.println("=============================================");
            
            if(resp_code.equals("00")){
                setLogErorDeteleDataTagihan("Data Berhasil di Hapus");
            }else{
                setLogErorDeteleDataTagihan("Data Gagal di Hapus");
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            setLogErorDeteleDataTagihan("Data Gagal di Hapus, Eror "+ex+" Respon : "+raw_respon);
        }
        return resp_code;
    }

    public static SOAPMessage createSOAPRequest(TagihanDelete tagihanDeleteInstansi) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://tempuri.org/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("example", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("tagihan_delete_by_id", "example");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("sUser", "example");
        soapBodyElem1.addTextNode(""+tagihanDeleteInstansi.getsUser());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("sPassword", "example");
        soapBodyElem2.addTextNode(""+tagihanDeleteInstansi.getsPassword());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("sInstansi", "example");
        soapBodyElem3.addTextNode(""+tagihanDeleteInstansi.getsInstansi());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("sNoid", "example");
        soapBodyElem4.addTextNode(""+tagihanDeleteInstansi.getsNoId());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "tagihan_delete_by_id");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
}
