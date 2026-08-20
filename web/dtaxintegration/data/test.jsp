<%-- 
    Document   : test
    Created on : Sep 22, 2020, 12:27:30 AM
    Author     : gndiw
--%>

<%@page import="javax.xml.soap.MimeHeaders"%>
<%@page import="com.oschrenk.io.Base64"%>
<%@page import="java.io.File"%>
<%@page import="javax.xml.soap.SOAPElement"%>
<%@page import="javax.xml.soap.SOAPBody"%>
<%@page import="javax.xml.soap.SOAPEnvelope"%>
<%@page import="javax.xml.soap.SOAPPart"%>
<%@page import="javax.xml.soap.MessageFactory"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="javax.xml.soap.SOAPConnection"%>
<%@page import="javax.xml.soap.SOAPConnectionFactory"%>
<%@page import="javax.xml.soap.SOAPMessage"%>
<%@page import="com.dimata.dtaxintegration.entity.tagihan.FileSent"%>
<%@page import="com.dimata.webclient.AppSetting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    
    public static void run(){
        FileSent fileSent = new FileSent();
        fileSent.setsUser(AppSetting.USERNAME_PBB);//1
        fileSent.setsPassword(AppSetting.PWD_PBB);//2
        fileSent.setsInstansi(AppSetting.INSTANSI_PBB);//6
        fileSent.setLocation(AppSetting.PBB_LOCATION_FILE+"\\2020\\09\\20200922");
        fileSent.setFileName(AppSetting.INSTANSI_PBB+"__2020-09-22_0005");
        fileSent.setFileNameZip(AppSetting.INSTANSI_PBB+"_2020-09-22_0005.zip");
        fileSent.setTahunStart("1994");
        fileSent.setTahunEnd("2020");   

        String patchFileUploadZip = "C:\\Dimata\\File\\2020\\09\\20200922\\PBB_BULELENG_2020-09-22_0005.zip";

        try {
            ByteArrayOutputStream outs = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSetting.IP_BANK_BPD;//"http://192.168.201.78:88/index.asmx";

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(fileSent, patchFileUploadZip), url);
        } catch (Exception exc){}
    }

     public static SOAPMessage createSOAPRequest(FileSent fileSent, String lokasi) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
                SOAPMessage soapMessage = messageFactory.createMessage();
                SOAPPart soapPart = soapMessage.getSOAPPart();
        try {
            
        
		String serverURI = "http://tempuri.org/";
		System.out.println(" --------------------------------------- ");
		System.out.println(" LOKASI PATH "+lokasi);
		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("example", serverURI);

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("upload_file", "example");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("sUser", "example");
		soapBodyElem1.addTextNode("" + fileSent.getsUser());
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("sPassword", "example");
		soapBodyElem2.addTextNode("" + fileSent.getsPassword());
		SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("sInstansi", "example");
		soapBodyElem3.addTextNode("" + fileSent.getsInstansi());

		File file = new File(lokasi);
		//byte[] imageBytes = new byte[(int) file.length()];
		//String test = "realhowto";
		//byte[] bFile = new byte[(int) file.length()];
		//String file = readFile(lokasi);
		//String file = readFile(lokasi);
		String res1 = Base64.encodeFromFile(lokasi);
		//SOAPElement soapBodyElem4 =soapBodyElem.addChildElement("Data", "example").addAttribute(new QName("EncodingType"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary");
		SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Data", "example");
		soapBodyElem4.addTextNode(res1);


		SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("fileName", "example");
		soapBodyElem5.addTextNode("" + fileSent.getFileNameZip());

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "upload_file");

		soapMessage.saveChanges();

		/* Print the request message */
		System.out.print("n/Request SOAP Message: n/");
		soapMessage.writeTo(System.out);
        System.out.println();
        } catch (Exception exc){
            System.out.println("Exception kirim data :"+exc.toString());
        
        }
        
		
		
        return soapMessage;
    }
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=run()%></h1>
    </body>
</html>
