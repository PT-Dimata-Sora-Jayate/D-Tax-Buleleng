/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.webclient;
import com.dimata.dtaxintegration.entity.inquery.Payment;
import com.dimata.dtaxintegration.entity.laporan.LaporanPayment;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import org.apache.commons.lang.StringUtils;

import org.w3c.dom.*;
/**
 *
 * @author dimata005
 */
public class EchoLaporanPayment {

//      public static void main(String[] args) {
//        String resp_status = new String();
//        String resp_code = new String();
//        //InqueryProses inqueryProses = new InqueryProses();
//        LaporanPayment laporanPayment = new LaporanPayment();
//        try {
//            // TODO code application logic here
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//            String url = "http://192.168.201.78:88/index.asmx";
//            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(laporanPayment), url);
//            soapResponse.writeTo(System.out);
//
//            soapResponse.writeTo(out);
//            String raw_respon = new String(out.toByteArray());
//            System.out.println("SOAP Respon = "+raw_respon);
//            resp_code = StringUtils.substringBetween(raw_respon,"<code>","</code>");
//            resp_status=StringUtils.substringBetween(raw_respon,"<no_id>","</no_id>");
//            System.out.println("=============================================");
//            System.out.println("GET STATUS");
//            System.out.println("Respone Code = "+ resp_code);
//            System.out.println("status = "+ resp_status);
//            System.out.println("=============================================");
//            
//            
//            Source sourceContent = soapResponse.getSOAPPart().getContent();
//            TransformerFactory tf = TransformerFactory.newInstance();  
//            Transformer transformer = tf.newTransformer();  
//            DOMResult result = new DOMResult();  
//            transformer.transform(sourceContent, result);  
//            Document doc = (Document) result.getNode(); 
//            
//             String tag = "Table";
//             String attr = "diffgr:id";
//             String attrValue = "Table1";
//             NodeList list = doc.getElementsByTagName("Table");
//             Element tableNode = null;
//             int count =0;
//             for (int i = 0; i < list.getLength(); i++) {
//                    count=count+1;
//                    tableNode = ((Element) list.item(i));
//
//                    String childInstansi = "instansi";
//                    Node nodeInstansi = (Node) tableNode.getElementsByTagName(childInstansi).item(0);
//                    String instansi = nodeInstansi.getTextContent();
//                     
//                    String childNoId = "no_id";
//                    Node nodeNoId = (Node) tableNode.getElementsByTagName(childNoId).item(0);
//                    String no_id = nodeNoId.getTextContent();
//                    
//                    String childNama = "nama";
//                    Node nodeNama = (Node) tableNode.getElementsByTagName(childNama).item(0);
//                    String nama = nodeNama.getTextContent();
//                    
//                    String childTagihan = "tagihan";
//                    Node nodeTagihan = (Node) tableNode.getElementsByTagName(childTagihan).item(0);
//                    String tagihan = nodeTagihan.getTextContent();
//                    
//                    String childBiaya = "biaya_adm";
//                    Node nodeBiaya = (Node) tableNode.getElementsByTagName(childBiaya).item(0);
//                    String biaya = nodeBiaya.getTextContent();
//                    
//                    String childTgl = "tgl_tx";
//                    Node nodeTgl = (Node) tableNode.getElementsByTagName(childTgl).item(0);
//                    String tgl_tx = nodeTgl.getTextContent();
//                    
//                    String childStatus = "sts_reversal";
//                    Node nodeStatus = (Node) tableNode.getElementsByTagName(childStatus).item(0);
//                    String sts_reversal = nodeStatus.getTextContent();
//                    
//                    String childId = "id";
//                    Node nodeId = (Node) tableNode.getElementsByTagName(childId).item(0);
//                    String id = nodeId.getTextContent();
//                    
//                    System.out.println("No = "+ count);
//                    System.out.println("instansi = "+ instansi);
//                    System.out.println("noId = "+ no_id);
//                    System.out.println("nama = "+ nama);
//                    System.out.println("tagihan = "+ tagihan);
//                    System.out.println("biayaAdm = "+ biaya);
//                    System.out.println("tanggal = "+ tgl_tx);
//                    System.out.println("status = "+ sts_reversal);
//                    System.out.println("id = "+ id);
//                    System.out.println("=============================================");
//             }
//            
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
    
    
    public Vector getListPayment(LaporanPayment laporanPayment){
        String resp_code = new String();
        String resp_message = new String();
        Vector listPayment=new Vector();
        try {
            
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            String url = AppSetting.IP_BANK_BPD;//"http://192.168.201.78:88/index.asmx";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(laporanPayment), url);
            soapResponse.writeTo(System.out);

            soapResponse.writeTo(out);
            String raw_respon = new String(out.toByteArray());
            System.out.println("SOAP Respon = "+raw_respon);
            resp_code = StringUtils.substringBetween(raw_respon,"<code>","</code>");
            resp_message=StringUtils.substringBetween(raw_respon,"<Table>","</Table>");
            
            //StringUtils.
            System.out.println("=============================================");
            System.out.println("GET STATUS");
            System.out.println("Respone Code = "+ resp_code);
            System.out.println("Respone Message = "+ resp_message);
            System.out.println("=============================================");
            
            Source sourceContent = soapResponse.getSOAPPart().getContent();
            TransformerFactory tf = TransformerFactory.newInstance();  
            Transformer transformer = tf.newTransformer();  
            DOMResult result = new DOMResult();  
            transformer.transform(sourceContent, result);  
            Document doc = (Document) result.getNode(); 
            
             String tag = "Table";
             String attr = "diffgr:id";
             String attrValue = "Table1";
             NodeList list = doc.getElementsByTagName("Table");
             Element tableNode = null;
             int count =0;
             for (int i = 0; i < list.getLength(); i++) {
                 
                    Payment payment = new Payment();
                    
                    count=count+1;
                    tableNode = ((Element) list.item(i));

                    String childInstansi = "instansi";
                    Node nodeInstansi = (Node) tableNode.getElementsByTagName(childInstansi).item(0);
                    String instansi = nodeInstansi.getTextContent();
                     
                    String childNoId = "no_id";
                    Node nodeNoId = (Node) tableNode.getElementsByTagName(childNoId).item(0);
                    String no_id = nodeNoId.getTextContent();
                    
                    String childNama = "nama";
                    Node nodeNama = (Node) tableNode.getElementsByTagName(childNama).item(0);
                    String nama = nodeNama.getTextContent();
                    
                    String childTagihan = "tagihan";
                    Node nodeTagihan = (Node) tableNode.getElementsByTagName(childTagihan).item(0);
                    String tagihan = nodeTagihan.getTextContent();
                    
                    String childBiaya = "biaya_adm";
                    Node nodeBiaya = (Node) tableNode.getElementsByTagName(childBiaya).item(0);
                    String biaya = nodeBiaya.getTextContent();
                    
                    String childTgl = "tgl_tx";
                    Node nodeTgl = (Node) tableNode.getElementsByTagName(childTgl).item(0);
                    String tgl_tx = nodeTgl.getTextContent();
                    
                    String childStatus = "sts_reversal";
                    Node nodeStatus = (Node) tableNode.getElementsByTagName(childStatus).item(0);
                    String sts_reversal = nodeStatus.getTextContent();
                    
                    String childId = "id";
                    Node nodeId = (Node) tableNode.getElementsByTagName(childId).item(0);
                    String id = nodeId.getTextContent();
                    
//                    System.out.println("No = "+ count);
//                    System.out.println("instansi = "+ instansi);
//                    System.out.println("noId = "+ no_id);
//                    System.out.println("nama = "+ nama);
//                    System.out.println("tagihan = "+ tagihan);
//                    System.out.println("biayaAdm = "+ biaya);
//                    System.out.println("tanggal = "+ tgl_tx);
//                    System.out.println("status = "+ sts_reversal);
//                    System.out.println("id = "+ id);
//                    System.out.println("=============================================");
                    
                    payment.setInstansi(instansi);
                    payment.setNoId(no_id);
                    payment.setNama(nama);
                    payment.setTagihan(tagihan);
                    payment.setBiayaAdm(biaya);
                    payment.setTglTx(tgl_tx);
                    payment.setStsReversal(sts_reversal);
                    payment.setId(id);
                    listPayment.add(payment);
             }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listPayment;
    }

   public static SOAPMessage createSOAPRequest(LaporanPayment laporanPayment) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://tempuri.org/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("example", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("laporan_payment", "example");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("sUser", "example");
        soapBodyElem1.addTextNode(""+laporanPayment.getsUser());
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("sPassword", "example");
        soapBodyElem2.addTextNode(""+laporanPayment.getsPassword());
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("sInstansi", "example");
        soapBodyElem3.addTextNode(""+laporanPayment.getsInstansi());
        SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("sDate", "example");
        soapBodyElem4.addTextNode(""+laporanPayment.getsDate());

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "laporan_payment");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("n/Request SOAP Message: n/");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
}
