   package com.dimata.webclient.bphtb;

import com.dimata.dtaxintegration.entity.logsApi.PstLogApi;
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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class EchoTestBphtb {
   public static void main(String[] args) {
      new String();
      new String();

      try {
         String Str = new String("1.0113.04.01");
         System.out.print("Return Value :");
         System.out.println(Str.substring(10));
         System.out.print("Return Value :");
         System.out.print("Return Value :");
         System.out.println(Str.substring(0, 2));
      } catch (Exception var4) {
         var4.printStackTrace();
      }

   }

   public String action() {
       try {
            // Setup SSL context to bypass certificate validation
            TrustManager[] trustAll = new TrustManager[] {
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                }
            };

            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAll, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to disable SSL validation: " + e.getMessage();
        }
      new String();
      String resp_code = new String();
      String raw_respon = "";
      System.setProperty("https.protocols", "TLSv1.2");

      try {
         ByteArrayOutputStream out = new ByteArrayOutputStream();
         SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
         SOAPConnection soapConnection = soapConnectionFactory.createConnection();
         String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;
         SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
         soapResponse.writeTo(System.out);
         soapResponse.writeTo(out);
         raw_respon = new String(out.toByteArray());
         System.out.println("CON BPHTB=>" + resp_code + " | " + url);
         resp_code = StringUtils.substringBetween(raw_respon, "<return xsi:type=\"xsd:string\">", "</return>");
         resp_code = resp_code.replace("&quot;", "'");
         JSONObject data = new JSONObject(resp_code);
         if (data.opt("code").equals("00")) {
            resp_code = "TERHUBUNG DENGAN BAIK";
         } else if (resp_code.equals("01")) {
            resp_code = "GAGAL";
         } else {
            resp_code = "Tidak memiliki wewenang akses";
         }
      } catch (Exception var10) {
         var10.printStackTrace();
         PstLogApi pstLogApi = new PstLogApi();
         pstLogApi.setLogApiBpd("ws_echo_test", "" + var10.getMessage(), "Dashboard", "99");
         resp_code = "<font style=\"color: red\">GAGAL TERKONEKSI PADA BANK</font>";
      }

      return resp_code;
   }

   public static SOAPMessage createSOAPRequest() throws Exception {
      MessageFactory messageFactory = MessageFactory.newInstance();
      SOAPMessage soapMessage = messageFactory.createMessage();
      SOAPPart soapPart = soapMessage.getSOAPPart();
      String serverURI = "urn:echotest";
      SOAPEnvelope envelope = soapPart.getEnvelope();
      envelope.addNamespaceDeclaration("urn", serverURI);
      SOAPBody soapBody = envelope.getBody();
      SOAPBodyElement soapBodyElem = soapBody.addBodyElement(envelope.createName("ws_echo_test", "urn", ""));
      SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username").addTextNode("" + AppSettingBphtb.USERNAME_BPHTB);
      SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password").addTextNode("" + AppSettingBphtb.PWD_BPHTB);
      MimeHeaders headers = soapMessage.getMimeHeaders();
      headers.addHeader("SOAPAction", serverURI + "echo_test");
      soapMessage.saveChanges();
      System.out.print("n/Request SOAP Message: n/");
      soapMessage.writeTo(System.out);
      System.out.println();
      return soapMessage;
   }
}
  