/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.print;

import com.dimata.dslik.ajax.AjaxPelaporan;
import com.dimata.dslik.entity.agunan.PstAgunan;
import com.dimata.dslik.entity.bankgaransi.PstBankGaransi;
import com.dimata.dslik.entity.debiturbdnusaha.PstDebiturBdnUsaha;
import com.dimata.dslik.entity.debiturindividu.PstDebiturIndividu;
import com.dimata.dslik.entity.fasilitaslain.PstFasilitasLain;
import com.dimata.dslik.entity.irrevocablelc.PstIrrevocableLc;
import com.dimata.dslik.entity.kredit.PstKredit;
import com.dimata.dslik.entity.kreditjoinaccount.PstKreditJoinAccount;
import com.dimata.dslik.entity.laporankeuangandebitur.PstLaporanKeuanganDebitur;
import com.dimata.dslik.entity.pengurusataupemilik.PstPengurusAtauPemilik;
import com.dimata.dslik.entity.penjamin.PstPenjamin;
import com.dimata.dslik.entity.suratberharga.PstSuratBerharga;
import com.dimata.gui.jsp.ControlList;
import com.dimata.qdep.form.FRMQueryString;
import java.io.ByteArrayOutputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Vector;




public class pelaporan_per_segment_detail extends HttpServlet {
    
    public final static int SEGMEN_DEBITUR_INDIVIDU = 0;
    public final static int SEGMEN_DEBITUR_BADAN_USAHA = 1;
    public final static int SEGMEN_PENGURUS_PEMILIK = 2;
    public final static int SEGMEN_KREDIT = 3;
    public final static int SEGMEN_BANK_GARANSI = 4;
    public final static int SEGMEN_AGUNAN = 5;
    public final static int SEGMEN_PENJAMIN = 6;
    public final static int SEGMEN_LAPORAN_KEUANGAN_DEBITUR = 7;
    public final static int SEGMEN_SURAT_BERHARGA = 8;
    public final static int SEGMEN_KREDIT_JOIN = 9;
    public final static int SEGMEN_IRREVOCABLE_LC = 10;
    public final static int SEGMEN_FASILITAS_LAINNYA = 11;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String htmldata = FRMQueryString.requestString(request, "htmldata");
        String cabang = FRMQueryString.requestString(request, "cabangpersegment");
        long periodeId = FRMQueryString.requestLong(request, "periodepersegment");
        int getSegment = FRMQueryString.requestInt(request, "segment");
        int kelengkapan = FRMQueryString.requestInt(request, "kelengkapan");
    
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        try {

            PdfWriter writer = PdfWriter.getInstance(document, baos);
            document.addSubject("This is a subject.");
            document.addSubject("This is a subject two.");
            document.open();

            // step 4
            String str = "";//+getPerSegmentReport(periodeId, cabang, getSegment,kelengkapan);
            if(getSegment==-1){
                for(int i = 0; i < AjaxPelaporan.segmenNames.length; i++){
                   str=str+getPerSegmentReport(periodeId, cabang, i,kelengkapan);
                }
            }else{
                 str=getPerSegmentReport(periodeId, cabang, getSegment,kelengkapan);
            }
            

            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));

        } catch (DocumentException de) {

            System.err.println(de.getMessage());

            de.printStackTrace();

        }

        // step 5: closing the document
        document.close();

        response.setContentType("application/pdf");
        response.setContentLength(baos.size());
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public String getPerSegmentReport(long periode, String cabang, int segment, int kelengkapan){
        String returnData = "";
        String whereClause = "";
        Vector listObj = new Vector(1,1);
        switch(segment){
            case SEGMEN_AGUNAN :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstAgunan.fieldNames[PstAgunan.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstAgunan.fieldNames[PstAgunan.FLD_STATUS_DATA_PERUBAHAN]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstAgunan.fieldNames[PstAgunan.FLD_STATUS_DATA_PERUBAHAN]+" IS NULL ";
                }else{}

                listObj = PstAgunan.list(0,0,PstAgunan.fieldNames[PstAgunan.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, ""+PstAgunan.fieldNames[PstAgunan.FLD_KODE_REGISTER_AGUNAN]+" ASC");
            break;
                
            case SEGMEN_BANK_GARANSI :
                
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstBankGaransi.fieldNames[PstBankGaransi.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstBankGaransi.fieldNames[PstBankGaransi.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstBankGaransi.list(0,0, PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause,""+PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]+" ASC");
            break;
                
            case SEGMEN_DEBITUR_BADAN_USAHA :
                if(cabang.length() > 0){
                    whereClause +=" AND dup."+PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstDebiturBdnUsaha.listJoinReport(0,0,"dslik_debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERIODE_ID]+"='"+periode+"' "
                        + "AND dslik_debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS_NSB]+"!='1'"
                        + ""+whereClause, "dslik_debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_CIF]+" ASC",periode,cabang);
            break;
                
            case SEGMEN_FASILITAS_LAINNYA :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstFasilitasLain.list(0,0,""+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_NO_REKENING]+" ASC");
            break;
                
            case SEGMEN_IRREVOCABLE_LC :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstIrrevocableLc.list(0,0,""+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_NO_REKENING]+" ASC");
            break;
                
            case SEGMEN_KREDIT :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstKredit.list(0,0,""+PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+" ASC");
            break;
                
            case SEGMEN_KREDIT_JOIN :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstKreditJoinAccount.list(0,0,""+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" ASC");
            break;
                
            case SEGMEN_LAPORAN_KEUANGAN_DEBITUR :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstLaporanKeuanganDebitur.list(0,0,""+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" ASC");
            break;
                
            case SEGMEN_PENGURUS_PEMILIK :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstPengurusAtauPemilik.list(0,0,""+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_NO_IDENTITAS]+" ASC");
            break;
                
            case SEGMEN_PENJAMIN : 
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstPenjamin.fieldNames[PstPenjamin.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstPenjamin.fieldNames[PstPenjamin.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstPenjamin.fieldNames[PstPenjamin.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstPenjamin.list(0,0,""+PstPenjamin.fieldNames[PstPenjamin.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstPenjamin.fieldNames[PstPenjamin.FLD_NO_ID_PENJAMIN]+" ASC");
            break;
                
            case SEGMEN_SURAT_BERHARGA :
                if(cabang.length() > 0){
                    whereClause +=" AND "+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstSuratBerharga.list(0,0,""+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_PERIODE_ID]+"='"+periode+"'"
                        + ""+whereClause, PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_NO_REKENING]+" ASC");
            break;
            default:
                if(cabang.length() > 0){
                    whereClause +=" AND dup."+PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+"='"+cabang+"' ";
                }
                if(kelengkapan==1){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+"='0' ";
                }else if(kelengkapan ==2 ){
                    whereClause +=" AND "+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL ";
                }else{}
                listObj = PstDebiturIndividu.listJoinReport(0,0,"dslik_debitur."+PstDebiturIndividu.fieldNames[PstDebiturIndividu.FLD_PERIODE_ID]+"='"+periode+"' "
                        + "AND dslik_debitur."+PstDebiturIndividu.fieldNames[PstDebiturIndividu.FLD_KODE_JENIS_NSB]+"='1'"
                        + ""+whereClause, "dslik_debitur."+PstDebiturIndividu.fieldNames[PstDebiturIndividu.FLD_CIF]+" ASC",periode,cabang);
            break;
        }
        
        
        return drawReportPerSegment(0, listObj, segment);
    }
    
    
     public String drawReportPerSegment(int iCommand, Vector objectClass, int segment) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("NO", "200px");//1
        ctrlist.addHeader("Cabang", "200px");//2
        ctrlist = AjaxPelaporan.draControlList(ctrlist, segment);
        
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();

        int index = -1;
        int count=0;
        Vector rowx = new Vector(1, 1);
        double total=0.0;
        
        lstData = AjaxPelaporan.drawRowx(objectClass,segment,lstData);

        return ctrlist.drawPdf();
    }
    
}
