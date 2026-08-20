/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.print;

import com.dimata.dtaxintegration.entity.payment.PaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PaymentPhr;
import com.dimata.dtaxintegration.entity.payment.PaymentRetribusi;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhr;
import com.dimata.dtaxintegration.entity.payment.PstPaymentRetribusi;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Formater;
import com.lowagie.text.Element;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Table;
import com.lowagie.text.Chunk;
import com.lowagie.text.PageSize;
import com.lowagie.text.Document;
import com.lowagie.text.Cell;


import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.awt.*;

import java.io.ByteArrayOutputStream;

import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class print_payment_bank extends HttpServlet {
    
    // setting the color values
    public static final Color border = new Color(0x00, 0x00, 0x00);
    public static final Color borderwhite = new Color(255, 255, 255);
    public static final Color bgColor = new Color(240, 240, 240);
    // setting some fonts in the color chosen by the user
    public static final Font fontHeaderBig = new Font(Font.TIMES_NEW_ROMAN, 10, Font.NORMAL, border);
    public static final Font fontHeader = new Font(Font.TIMES_NEW_ROMAN, 9, Font.NORMAL, border);
    public static final Font addrFont = new Font(Font.TIMES_NEW_ROMAN, 9, Font.NORMAL, border);
    public static final Font fontImage = new Font(Font.TIMES_NEW_ROMAN, 10, Font.BOLD, border);
    public static final Font tableContent = new Font(Font.TIMES_NEW_ROMAN, 11, Font.NORMAL, border);
    public static final Font fontContent = new Font(Font.TIMES_NEW_ROMAN, 11, Font.BOLD, border);
    public static final Font fontContentSmall = new Font(Font.TIMES_NEW_ROMAN, 7, Font.NORMAL, border);

    public void init(ServletConfig config) throws ServletException {

        super.init(config);

    }

    /**
     * Destroys the servlet.
     *
     */
    public void destroy() {
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        int jenis_pajak = FRMQueryString.requestInt(request, "typepajak");
        String idpaymentbank = FRMQueryString.requestString(request, "idpaymentbank");

        String whereClause = "";
        Vector listPayment = new Vector();
        String name1="";
        String name2="";
        if(jenis_pajak==1){//phr
            whereClause="psb."+PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_IDPAYMENT]+"='"+idpaymentbank+"'";
            listPayment = PstPaymentPhr.listInnerJoin(0, 0, whereClause, "");
            name1="Bukti Pembayaran BPD Bali Payment";
            name2="";
        }else if (jenis_pajak==2){//bphtb
            
            whereClause="psb."+PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_ID_PAYMENT_BANK]+"='"+idpaymentbank+"'";
            listPayment = PstPaymentBphtb.listInnerJoin(0, 0, whereClause, "");
            name1="SURAT SETORAN PAJAK DAERAH (SSPD)";
            name2="BEA PEROLEHAN HAK ATAS TANAH DAN BANGUNAN";
        }else if (jenis_pajak==3){//pbb
            
            whereClause=PstPaymentPbb.fieldNames[PstPaymentPbb.FLD_ID_PAYMENT_BANK]+"='"+idpaymentbank+"'";
            listPayment = PstPaymentPbb.listInnerJoin(0, 0, whereClause, "");
            //name1="";
            name1="PEMERINTAH KABUPATEN GIANYAR";
            name2="SURAT SETORAN PAJAK DAERAH (SSPD)";
            
        }else if (jenis_pajak==4){//retribusi
            
            whereClause=PstPaymentRetribusi.fieldNames[PstPaymentRetribusi.FLD_IDPAYMENTBANK]+"='"+idpaymentbank+"'";
            listPayment = PstPaymentRetribusi.list(0, 0, whereClause, "");
            name1="Bukti Pembayaran BPD Bali Payment";
            name2="";
        }else{
            
        }  
        
        Document document = new Document(PageSize.A4, 20, 20, 10, 50);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //System.out.println("masuk--0");
        try {

            // step2.2: creating an instance of the writer
            PdfWriter writer = PdfWriter.getInstance(document, baos);

            // step 3.1: adding some metadata to the document
            document.addSubject("This is a subject.");

            document.addSubject("This is a subject two.");

            document.open();

            //System.out.println("masuk--2");
            document.add(getTitle(name1,name2));

            
            //document.add(getContent(writer, document, listPayment));
            if(jenis_pajak==1){//phr
                document.add(getContentPhr(writer, document, listPayment));
            }else if (jenis_pajak==2){//bphtb
                document.add(getContentBphtb(writer, document, listPayment));
            }else if (jenis_pajak==3){//pbb
                document.add(getContentPbb(writer, document, listPayment));
            }else if (jenis_pajak==4){//retribusi
                document.add(getContentRetribusi(writer, document, listPayment));
            }else{
            }  

        } catch (DocumentException de) {

            System.err.println(de.getMessage());

            de.printStackTrace();

        }

        // step 5: closing the document
        document.close();

        // we have written the pdfstream to a ByteArrayOutputStream,
        // now we are going to write this outputStream to the ServletOutputStream
        // after we have set the contentlength (see http://www.lowagie.com/iText/faq.html#msie)
        response.setContentType("application/pdf");

        response.setContentLength(baos.size());

        ServletOutputStream out = response.getOutputStream();

        baos.writeTo(out);

        out.flush();

        // }
        // else{
        // }
    }

    public static Table getTitle(String name1, String name2) {

        /* start creating content */
        try {

            int contentWith[] = {40, 20, 20};

            Table content = new Table(3);

            content.setWidth(100);

            content.setWidths(contentWith);

            content.setAlignment(0);

            content.setBorderWidth(0);

            content.setCellpadding(0);

            content.setCellspacing(1);

            Cell cnt = new Cell(new Chunk(""+name1, fontHeaderBig));

            cnt.setColspan(3);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

            content.addCell(cnt);

            //--
            cnt = new Cell(new Chunk(""+name2, fontHeaderBig));

            cnt.setColspan(3);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

            content.addCell(cnt);

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;
    }

    public static Table getContentPhr(PdfWriter writer, Document document, Vector result) {

        try {

            Table content = getHeader();

            int adult = 0;

            int child = 0;

            int TotalLOS = 0;

            int count = 0;
            double total = 0.0;

            if (result != null && result.size() > 0) {

                for (int i = 0; i < result.size(); i++) {

                    try {

                        PaymentPhr paymentPhr = (PaymentPhr)  result.get(i);
                        
                        
                        //row 1
                        Cell cnt = new Cell(new Chunk("INSTANSI ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(" DISPENDA KABUPATEN GIANYAR", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 2
                        cnt = new Cell(new Chunk("NPWPD ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPhr.getNpwpd(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        //row 3
                        cnt = new Cell(new Chunk("NAMA ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPhr.getNama(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        //row 4
                        cnt = new Cell(new Chunk("ALAMAT ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPhr.getAlamat(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);

                        content.addCell(cnt);
                        
                        //row 5
                        cnt = new Cell(new Chunk("BULAN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPhr.getMasaPajak(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);

                        content.addCell(cnt);
                        
                        
                        //row 6
                        cnt = new Cell(new Chunk("TAHUN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPhr.getTahunPajak(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 7
                        cnt = new Cell(new Chunk("POKOK ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPhr.getPokok(), "#,###"), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("DENDA ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPhr.getDenda(), "#,###"), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 9
                        cnt = new Cell(new Chunk("JUMLAH TAGIHAN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPhr.getJumlahBayar(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 10
                        cnt = new Cell(new Chunk("ADMIN BANK ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentPhr.getBiayaAdministrasi(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 11
                        cnt = new Cell(new Chunk(" ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                         //row 12
                        cnt = new Cell(new Chunk("TOTAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPhr.getJumlahBayar(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        //row 13
                        cnt = new Cell(new Chunk("JUMLAH BAYAR", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPhr.getJumlahBayar(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                         //row 13
                        cnt = new Cell(new Chunk("KEMBALI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("0.00", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("TANGGAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentPhr.getTanggal(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("NO BUKTI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentPhr.getIdPayment(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("PT. Bank BPD Bali menyatakan struk ini sebagai", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("bukti pembayaran yang sah mohon disimpan", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("Teller : ", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        

                    } catch (Exception exc1) {
                        System.out.println(exc1);
                    }
                }

            }

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;

    }
    
    
    public static Table getContentBphtb(PdfWriter writer, Document document, Vector result) {

        try {

            Table content = getHeader();

            int adult = 0;

            int child = 0;

            int TotalLOS = 0;

            int count = 0;
            double total = 0.0;

            if (result != null && result.size() > 0) {

                for (int i = 0; i < result.size(); i++) {

                    try {

                        PaymentBphtb paymentBphtb = (PaymentBphtb)  result.get(i);
                        
                        
                        //row 1
                        Cell cnt = new Cell(new Chunk("INSTANSI ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(" DISPENDA KABUPATEN GIANYAR", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setBorderColor(borderwhite);
                         
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 2
                        cnt = new Cell(new Chunk("NOMOR TIB  ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentBphtb.getNoTib(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        //row 4
                        cnt = new Cell(new Chunk("NAMA WP ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentBphtb.getNama(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        //row 5
                        cnt = new Cell(new Chunk("NOP ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentBphtb.getNop(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 6
                        cnt = new Cell(new Chunk("LETAK OBJECT PAJAK ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentBphtb.getAlamat(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 7
                        cnt = new Cell(new Chunk("POKOK ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentBphtb.getPokok(), "#,###"), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("DENDA ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentBphtb.getDenda(), "#,###"), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 9
                        cnt = new Cell(new Chunk("BPHTB DIBAYAR ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        //cnt.setBorderColor(borderwhite);
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentBphtb.getPokok()+paymentBphtb.getDenda(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        content.addCell(cnt);
                        
                        
                        //row 10
                        cnt = new Cell(new Chunk("BIAYA ADM ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("0.00", fontContentSmall));//2
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        content.addCell(cnt);
                        
                        
                        //row 11
                        cnt = new Cell(new Chunk(" ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        content.addCell(cnt);
                        
                        
                         //row 12
                        cnt = new Cell(new Chunk("TOTAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentBphtb.getPokok()+paymentBphtb.getDenda(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 13
                        cnt = new Cell(new Chunk("JUMLAH BAYAR", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentBphtb.getJumlahBayar(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                         //row 13
                        cnt = new Cell(new Chunk("KEMBALI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("0.00", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("TANGGAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentBphtb.getTglBayar(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("NO BUKTI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentBphtb.getIdPaymentBank(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("PT. Bank BPD Bali menyatakan struk ini sebagai", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("bukti pembayaran yang sah mohon disimpan", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("Teller : ", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        

                    } catch (Exception exc1) {
                        System.out.println(exc1);
                    }
                }

            }

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;

    }
    
    
    
    public static Table getContentPbb(PdfWriter writer, Document document, Vector result) {

        try {

            Table content = getHeader();

            int adult = 0;

            int child = 0;

            int TotalLOS = 0;

            int count = 0;
            double total = 0.0;

            if (result != null && result.size() > 0) {

                for (int i = 0; i < result.size(); i++) {

                    try {

                        PaymentPbb paymentPbb = (PaymentPbb)  result.get(i);
                        
                        //row 1
                        Cell cnt = new Cell(new Chunk("INSTANSI ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(" DISPENDA KABUPATEN GIANYAR ", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 2
                        cnt = new Cell(new Chunk("NOP ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getNop(), fontContentSmall));//2
                        cnt.setColspan(3);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        //row 3
                        cnt = new Cell(new Chunk("NAMA ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getNama(), fontContentSmall));//2
                        cnt.setColspan(3);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                         cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 4
                        cnt = new Cell(new Chunk("NPWP ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("-", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 5
                        cnt = new Cell(new Chunk("ALAMAT WP ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getAlamat(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 6
                        cnt = new Cell(new Chunk("LETAK OBJECT PAJAK ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getLetakObject(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 7
                        cnt = new Cell(new Chunk("TAHUN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getThnPajakSppt(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("TGL JATUH TEMPO ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getTanggalJatuhTempo(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("LUAS BUMI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getLuasBumi(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 8
                        cnt = new Cell(new Chunk("LUAS BANGUNAN", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getLuasBng(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                         //row 8
                        cnt = new Cell(new Chunk("NJOP Bumi", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getNjopBumi(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 8
                        cnt = new Cell(new Chunk("NJOP Bangunan", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getNjopBng(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("NJOPTKP", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getNjoptkp(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("DENDA", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentPbb.getDendaSppt(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 8
                        cnt = new Cell(new Chunk("FORMULA", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        String pengali ="";
                        if(paymentPbb.getJmlSpptYgDibayar() > 1000000000){
                            pengali="0,2";
                        }else{
                            pengali="0,1";
                        }
                        cnt = new Cell(new Chunk("(NJOP Bumi + NJOP Bangunan - NJOPTKP) x "+pengali+" Persen + Denda", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 9
                        cnt = new Cell(new Chunk("JUMLAH TAGIHAN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPbb.getJmlSpptYgDibayar(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 10
                        cnt = new Cell(new Chunk("BIAYA ADM ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("0.0", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 11
                        cnt = new Cell(new Chunk(" ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                         //row 12
                        cnt = new Cell(new Chunk("TOTAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentPbb.getJmlSpptYgDibayar(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 13
                        cnt = new Cell(new Chunk("JUMLAH BAYAR", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentPbb.getJmlSpptYgDibayar(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                         //row 13
                        cnt = new Cell(new Chunk("KEMBALI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("0.00", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("TANGGAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentPbb.getTglPembayaranSppt(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("NO BUKTI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                       cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentPbb.getIdPaymentBank(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("PT. Bank BPD Bali menyatakan struk ini sebagai", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("bukti pembayaran yang sah mohon disimpan", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("Teller : ", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        

                    } catch (Exception exc1) {
                        System.out.println(exc1);
                    }
                }

            }

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;

    }
    
    public static Table getContentRetribusi(PdfWriter writer, Document document, Vector result) {

        try {

            Table content = getHeader();

            int adult = 0;

            int child = 0;

            int TotalLOS = 0;

            int count = 0;
            double total = 0.0;

            if (result != null && result.size() > 0) {

                for (int i = 0; i < result.size(); i++) {

                    try {

                        PaymentRetribusi paymentRetribusi = (PaymentRetribusi)  result.get(i);
                        
                        
                        //row 1
                        Cell cnt = new Cell(new Chunk("INSTANSI ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(" DISPENDA KABUPATEN GIANYAR", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setBorderColor(borderwhite);
                         
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 2
                        cnt = new Cell(new Chunk("NO REKENING  ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentRetribusi.getNoRekening(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        //row 4
                        cnt = new Cell(new Chunk("NAMA ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentRetribusi.getNama(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        
                        cnt.setBorderColor(borderwhite);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        //row 5
                        cnt = new Cell(new Chunk("KETERANGAN TRANSAKSI ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(" Setoran", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 6
                        cnt = new Cell(new Chunk("TANGGAL TAGIHAN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+paymentRetribusi.getTanggalTagihan(), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 7
                        cnt = new Cell(new Chunk("JUMLAH SETORAN ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentRetribusi.getJumlahTagihan(), "#,###"), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 8
                        cnt = new Cell(new Chunk("ADMIN BANK ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk(""+Formater.formatNumber(0, "#,###"), fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);
                        
                        
                        //row 11
                        cnt = new Cell(new Chunk(" ", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(3);
                        cnt.setBorderColor(borderwhite);
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        content.addCell(cnt);
                        
                        
                         //row 12
                        cnt = new Cell(new Chunk("TOTAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentRetribusi.getJumlahTagihan(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 13
                        cnt = new Cell(new Chunk("JUMLAH BAYAR", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+Formater.formatNumber(paymentRetribusi.getJumlahTagihan(), "#,###"), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                         //row 13
                        cnt = new Cell(new Chunk("KEMBALI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("0.00", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("TANGGAL", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentRetribusi.getTanggalPembayaran(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 14
                        cnt = new Cell(new Chunk("NO BUKTI", fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        
                        cnt.setBorderColor(borderwhite);
                       
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk(""+paymentRetribusi.getIdPaymentBank(), fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        
                        //row 15
                        cnt = new Cell(new Chunk("PT. Bank BPD Bali menyatakan struk ini sebagai", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("bukti pembayaran yang sah mohon disimpan", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        
                        //row 15
                        cnt = new Cell(new Chunk("Teller : ", fontContentSmall));//2
                        
                        cnt.setColspan(4);
                        
                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
                        cnt.setBorderColor(borderwhite);
                        content.addCell(cnt);
                        

                    } catch (Exception exc1) {
                        System.out.println(exc1);
                    }
                }

            }

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;

    }
    
    
    public static Table getHeader() throws Exception {

        int contentWith[] = {15,10,15,60};

        Table content = new Table(4);

        content.setWidth(100);

        content.setWidths(contentWith);

        content.setAlignment(0);

        content.setBorderWidth(0);

        content.setCellpadding(0);

        content.setCellspacing(1);
        
        
        return content;

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     */
    public String getServletInfo() {

        return "Short description";

    }
}
