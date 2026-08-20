/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.print;

import com.dimata.dtaxintegration.entity.payment.PaymentPhr;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhr;
import com.dimata.qdep.form.FRMQueryString;
import com.lowagie.text.Element;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Table;
import com.lowagie.text.Chunk;
import com.lowagie.text.PageSize;
import com.lowagie.text.Document;
import com.lowagie.text.Cell;

import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;

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
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Vector;

public class report_phr_pdf extends HttpServlet {

    // setting the color values
    public static final Color border = new Color(0x00, 0x00, 0x00);
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

        int start = FRMQueryString.requestInt(request, "start");
        int prevCommand = FRMQueryString.requestInt(request, "prev_command");
        long oidDriver = FRMQueryString.requestLong(request, "hidden_driver_id");
        String gradeDelete = FRMQueryString.requestString(request, "gradeDelete");

        String startDate = FRMQueryString.requestString(request, "tanggalStart");
        String oDate = "";//FRMQueryString.requestString(request, "tanggalEnd");

        String startEnd = FRMQueryString.requestString(request, "tanggalEnd");
        String oEnd = "";//FRMQueryString.requestString(request, "tanggalEnd");

        Date newDay = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (startDate.equals("")) {
            startDate = Formater.formatDate(newDay, "yyyy-MM-dd");
            startEnd = Formater.formatDate(newDay, "yyyy-MM-dd");
            Date transaksiDate = new Date();
            try {
                transaksiDate = transaksiDate = formatter.parse(startDate);
            } catch (Exception ex) {
            }
            oDate = Formater.formatDate(transaksiDate, "yyyy-MM-dd HH:mm:ss");
            oEnd = Formater.formatDate(transaksiDate, "yyyy-MM-dd HH:mm:ss");
        } else {
            oDate = startDate;
            oEnd = startEnd;
        }
        /*data table payment*/
        Vector listPaymentPhr = new Vector();
        String whereClause = "";
        if (AppSetting.SQL_VERSION == AppSetting.DBSVR_ORACLE) {
            whereClause = PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS] + "='0'"
                    + " AND " + PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]
                    + " BETWEEN TO_DATE ('" + oDate + "','YYYY-MM-DD HH24:MI:SS')"
                    + " AND TO_DATE ('" + oEnd + "','YYYY-MM-DD HH24:MI:SS')";
        } else {
            whereClause = PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS] + "='0'"
                    + " AND " + PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]
                    + " BETWEEN ('" + oDate + "')"
                    + " AND ('" + oEnd + "')";
        }

        listPaymentPhr = PstPaymentPhr.list(0, 0, whereClause, "");

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
            document.add(getTitle(startDate, startEnd));

            document.add(getContent(writer, document, listPaymentPhr));

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

    public static Table getTitle(String startDate, String startEnd) {

        /* start creating content */
        try {

            int contentWith[] = {40, 20, 20, 20};

            Table content = new Table(4);

            content.setWidth(100);

            content.setWidths(contentWith);

            content.setAlignment(0);

            content.setBorderWidth(0);

            content.setCellpadding(0);

            content.setCellspacing(1);

            Cell cnt = new Cell(new Chunk("" + AppSetting.REPORT_INSTANSI, fontHeaderBig));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            cnt = new Cell(new Chunk("" + AppSetting.REPORT_DINAS, fontHeaderBig));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            cnt = new Cell(new Chunk("" + AppSetting.REPORT_INSTANSI_ALAMAT, fontHeaderBig));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            cnt = new Cell(new Chunk("", fontHeaderBig));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            //--
            cnt = new Cell(new Chunk("LAPORAN PENERIMAAN DETAIL HARIAN PAJAK PHR ", fontHeaderBig));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            cnt = new Cell(new Chunk("TANGGAL " + startDate.substring(0, 11) + " s/d " + startEnd.substring(0, 11), fontHeader));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            cnt = new Cell(new Chunk("", fontHeader));

            cnt.setColspan(4);

            cnt.setBorderColor(new Color(255, 255, 255));

            cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

            content.addCell(cnt);

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;
    }

    public static Table getContent(PdfWriter writer, Document document, Vector result) {

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

                        PaymentPhr paymentPhr = (PaymentPhr) result.get(i);

                        total = total + paymentPhr.getJumlahBayar();

                        count = count + 1;

                        Cell cnt = new Cell(new Chunk("" + (count), fontContentSmall));//1

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

                        content.addCell(cnt);

                        String sts = "";

                        cnt = new Cell(new Chunk("" + paymentPhr.getIdPayment(), fontContentSmall));//2

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + paymentPhr.getNpwpd(), fontContentSmall));//3

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + paymentPhr.getNama(), fontContentSmall));//4

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + paymentPhr.getTanggal(), fontContentSmall));//5

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + paymentPhr.getMasaPajak(), fontContentSmall));//6

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + paymentPhr.getTahunPajak(), fontContentSmall));//7

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + Formater.formatNumber(paymentPhr.getJumlahBayar(), "#,###"), fontContentSmall)); //8

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                        content.addCell(cnt);

                        cnt = new Cell(new Chunk("" + paymentPhr.getStatus(), fontContentSmall)); //9

                        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

                        content.addCell(cnt);

                    } catch (Exception exc1) {
                        System.out.println(exc1);
                    }
                }

                //-------------
//                Cell cnt = new Cell(new Chunk("TOTAL                :         Rp. " + FRMHandler.userFormatStringDecimal(total) + " ", fontHeader));
//
//                cnt.setColspan(9);
//
//                cnt.setBackgroundColor(bgColor);
//
//                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);
//
//                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);
//
//                content.addCell(cnt);
                Cell cnt = new Cell(new Chunk("", fontContentSmall));//1

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

                content.addCell(cnt);

                String sts = "";

                cnt = new Cell(new Chunk("", fontContentSmall));//2

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("", fontContentSmall));//3

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("", fontContentSmall));//4

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("", fontContentSmall));//5

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("", fontContentSmall));//6

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("TOTAL", fontContentSmall));//7

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_LEFT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("" + Formater.formatNumber(total, "#,###"), fontContentSmall)); //8

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_RIGHT);

                content.addCell(cnt);

                cnt = new Cell(new Chunk("", fontContentSmall)); //9

                cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

                cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

                content.addCell(cnt);

            }

            return content;

        } catch (Exception e) {

            System.out.println(e.toString());

        }

        return null;

    }

    public static Table getHeader() throws Exception {

        int contentWith[] = {5, 10, 10, 20, 10, 10, 10, 15, 10};

        Table content = new Table(9);

        content.setWidth(100);

        content.setWidths(contentWith);

        content.setAlignment(0);

        content.setBorderWidth(0);

        content.setCellpadding(0);

        content.setCellspacing(1);

        Cell cnt = new Cell(new Chunk("NO", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("SSPD", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("NPWPD", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("NAMA", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("DATE", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("BULAN", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("TAHUN", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("JUMLAH_BAYAR", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

        cnt = new Cell(new Chunk("STATUS", fontContentSmall));

        cnt.setBackgroundColor(bgColor);

        cnt.setVerticalAlignment(Element.ALIGN_MIDDLE);

        cnt.setHorizontalAlignment(Element.ALIGN_CENTER);

        content.addCell(cnt);

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
