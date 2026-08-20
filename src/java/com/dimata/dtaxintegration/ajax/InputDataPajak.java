/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.bi.DataPajak;
import com.dimata.dtaxintegration.entity.bi.PajakTypeDetail;
import com.dimata.dtaxintegration.entity.bi.PstPajakTypeDetail;
import com.dimata.dtaxintegration.entity.bi.SearchDataPajak;
import com.dimata.dtaxintegration.session.DTaxManagerAutomaticDataPajakBI;
import com.dimata.dtaxintegration.session.SessDataPajak;
import com.dimata.gui.jsp.ControlList;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ardiadi
 */
public class InputDataPajak extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        //STRING DATA
        int command = FRMQueryString.requestInt(request, "command");
        long viewtype = FRMQueryString.requestLong(request, "FRM_FIELD_PAJAKDETAILID");
        String rangeDate = FRMQueryString.requestString(request, "FRM_FIELD_RANGEDATE");
        int typeInputData = FRMQueryString.requestInt(request, "FRM_FIELD_TYPE_INPUT_DATA");

        String returnHtml = "";
        String returnTypeMessage = "";
        String frmMsg = "";
        JSONObject jSONObject = new JSONObject();
        SearchDataPajak searchDataPajak = new SearchDataPajak();
        DTaxManagerAutomaticDataPajakBI dTaxManagerAutomaticDataPajakBI = new DTaxManagerAutomaticDataPajakBI();

        switch (typeInputData) {

            case SessDataPajak.TARIK_MANUAL_DATA:

                //manual tarik data pajak
                if (viewtype != 0 && !rangeDate.equals("")) {
                    PajakTypeDetail pajakTypeDetail = new PajakTypeDetail();
                    try {

                        pajakTypeDetail = PstPajakTypeDetail.fetchExc(viewtype);
                        String query = pajakTypeDetail.getPajakQuery();
                        String[] smartDateSplits;
                        smartDateSplits = rangeDate.split("\\-");

                        String startDate = "";
                        String endDate = "";
                        if (smartDateSplits.length > 0) {
                            startDate = smartDateSplits[0];
                            endDate = smartDateSplits[1];
                        }
                        //oDate = Formater.formatDate(transaksiDate,"yyyy-MM-dd HH:mm:ss");
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        Date dStartDate = new Date();
                        try {
                            dStartDate = df.parse(startDate);
                            startDate = Formater.formatDate(dStartDate, "yyyy-MM-dd");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        Date dEndDate = new Date();
                        try {
                            dEndDate = df.parse(endDate);
                            endDate = Formater.formatDate(dEndDate, "yyyy-MM-dd");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        searchDataPajak.setPajakDetailId(viewtype);
                        searchDataPajak.setStartDate(startDate);
                        searchDataPajak.setEndDate(endDate);
                        searchDataPajak.setQueryPajak(query);
                        searchDataPajak.setColomDate(pajakTypeDetail.getColomDate());

                        /*returnHtml+="Pajak Type "+pajakTypeDetail.getPajakDetailName()+"<br>";
                         returnHtml+="Start Date "+ Formater.formatDate(searchDataPajak.getStartDate(), "dd-MM-yyyy")+"<br>";
                         returnHtml+="End Date "+Formater.formatDate(  searchDataPajak.getEndDate(), "dd-MM-yyyy")+"<br>";
                         */
                        //hapus data pajak sebelumnya
                        if(command==Command.SAVE){
                            int hasilDelete = SessDataPajak.deleteDataPajak(searchDataPajak);
                        }
                        
                        //ambil data
                        Vector vDataPajak = SessDataPajak.getListDataPajak(searchDataPajak);

                        //simpan data
                        int xxx = SessDataPajak.action(command, searchDataPajak, vDataPajak, pajakTypeDetail);

                        //ambil data dari database meaning
                        Vector vDataPajakMeaning = SessDataPajak.getListDataPajakMeaning(searchDataPajak);

                        //tampilkan di halaman
                        returnHtml += ""
                                + "<div class='row'>"
                                + "<div class='col-md-6'>"
                                + "<center><b><h2>Data Sumber</h2></b></center>"
                                + "</div>"
                                + "<div class='col-md-6'>"
                                + "<center><b><h2>Data Meaning<h2></b></center>"
                                + "</div>"
                                + "</div>";

                        returnHtml += ""
                                + "<div class='row'>"
                                + "<div class='col-md-6'>"
                                + "" + drawList(vDataPajak) + ""
                                + "</div>"
                                + "<div class='col-md-6'>"
                                + "" + drawList(vDataPajakMeaning) + ""
                                + "</div>"
                                + "</div>";

                    //returnHtml+=drawList(vDataPajak);
                    } catch (Exception ex) {
                    }

                }
                break;

            case SessDataPajak.TARIK_AUTOMATIC_DATA:
                //start tombol automatic input data per hari
                switch (command) {
                    case Command.START:
                        dTaxManagerAutomaticDataPajakBI.startMonitor();
                        break;

                    case Command.STOP:
                        dTaxManagerAutomaticDataPajakBI.stopMonitor();
                        break;

                }
                break;

            case SessDataPajak.CEK_NOTE_TARIK_DATA:
                if (DTaxManagerAutomaticDataPajakBI.running) {
                returnHtml = "" + dTaxManagerAutomaticDataPajakBI.getNote();
                } else {
                    returnHtml="Service OFF";
                }
                break;

            case SessDataPajak.CEK_STATUS_THREAD_TARIK_DATA:
                if (DTaxManagerAutomaticDataPajakBI.running) {
                    returnHtml = "running";
                } else {
                    returnHtml = "stop";
                }

                break;

            default:
                break;

        }

        try {
            jSONObject.put("HTML_DATA", returnHtml);
            jSONObject.put("MSG_TYPE", returnTypeMessage);
        } catch (JSONException ex) {
            returnHtml = "{'HTML_DATA':'" + ex.toString() + "'}";
        }

        response.getWriter().println(jSONObject);
    }

     public String drawList(Vector vDataPajak) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%"); //untuk mengatur width(lebar) table
        ctrlist.setAreaStyle("listgen"); //untuk mengatur nama class table
        ctrlist.setTitleStyle("tableheader"); //untuk mengatur nama class didalam kolom dalam baris table
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader"); //mengatur nama class baris table
        ctrlist.addHeader("No");//0
        ctrlist.addHeader("ID");//1
        ctrlist.addHeader("Nama");//2
        //ctrlist.addHeader("Kecamatan");//3
        //ctrlist.addHeader("Kelurahan");//4
        ctrlist.addHeader("Tahun");//5
        ctrlist.addHeader("Bulan");//6
        ctrlist.addHeader("Jumlah Bayar");//7
        ctrlist.setLinkRow(0);
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        ctrlist.reset();
        int index = -1;
        Vector rowx = new Vector(1, 1);
        int no = 0;
        double total=0.0;
        for (int i = 0; i < vDataPajak.size(); i++) {
            DataPajak dataPajak = (DataPajak) vDataPajak.get(i);
            rowx = new Vector(1, 1);
            no = no + 1;
            rowx.add("" + no);//0
            rowx.add("" + dataPajak.getId());//1
            rowx.add("" + dataPajak.getNama());//6
            rowx.add("" + dataPajak.getTahun());//4
            rowx.add("" + dataPajak.getBulan());//5
            rowx.add("" + FRMHandler.userFormatStringDecimal(dataPajak.getJumlahPajak()));//7
            total=total+dataPajak.getJumlahPajak();
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        rowx.add("");//0
        rowx.add("");//1
        rowx.add("");//6
        rowx.add("");//4
        rowx.add("");//5
        rowx.add("" + FRMHandler.userFormatStringDecimal(total));//7
        lstData.add(rowx);
        
        return ctrlist.drawBootstrapStrip();
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
}
