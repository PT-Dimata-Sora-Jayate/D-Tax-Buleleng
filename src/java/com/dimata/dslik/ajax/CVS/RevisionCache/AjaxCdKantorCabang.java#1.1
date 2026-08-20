/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.ajax;

import com.dimata.dslik.entity.contentdata.ContentDataKantorCabang;
import com.dimata.dslik.entity.contentdata.PstContentDataKantorCabang;
import com.dimata.dslik.form.contentdata.CtrlContentDataKantorCabang;
import com.dimata.dslik.form.contentdata.FrmContentDataKantorCabang;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Dewa
 */
public class AjaxCdKantorCabang extends HttpServlet {

    //DATATABLES
    private String searchTerm;
    private String colName;
    private int colOrder;
    private String dir;
    private int start;
    private int amount;

    //OBJECT
    private JSONObject jSONObject = new JSONObject();
    private JSONArray jSONArray = new JSONArray();

    //LONG
    private long oid = 0;
    private long oidReturn = 0;

    //STRING
    private String dataFor = "";
    private String oidDelete = "";
    private String approot = "";
    private String htmlReturn = "";
    private String dateStart = "";
    private String dateEnd = "";

    //INT
    private int iCommand = 0;
    private int iErrCode = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //LONG
        this.oid = FRMQueryString.requestLong(request, "FRM_FIELD_OID");
        this.oidReturn = 0;

        //STRING
        this.dataFor = FRMQueryString.requestString(request, "FRM_FIELD_DATA_FOR");
        this.oidDelete = FRMQueryString.requestString(request, "FRM_FIELD_OID_DELETE");
        this.approot = FRMQueryString.requestString(request, "FRM_FIELD_APPROOT");
        this.htmlReturn = "";

        //INT
        this.iCommand = FRMQueryString.requestCommand(request);
        this.iErrCode = 0;

        //OBJECT
        this.jSONObject = new JSONObject();

        switch (this.iCommand) {
            case Command.SAVE:
                commandSave(request);
                break;

            case Command.LIST:
                commandList(request, response);
                break;

            case Command.DELETEALL:
                commandDeleteAll(request);
                break;

            case Command.DELETE:
                commandDelete(request);
                break;

            default:
                commandNone(request);
        }
        try {

            this.jSONObject.put("FRM_FIELD_HTML", this.htmlReturn);
            this.jSONObject.put("FRM_FIELD_RETURN_OID", this.oidReturn);
            this.jSONObject.put("FRM_FIELD_DATE_START", this.dateStart);
            this.jSONObject.put("FRM_FIELD_DATE_END", this.dateEnd);
        } catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }

        response.getWriter().print(this.jSONObject);

    }

    public void commandNone(HttpServletRequest request) {
        if (this.dataFor.equals("showform")) {
            this.htmlReturn = showForm(request);
        }
    }

    public void commandSave(HttpServletRequest request) {
        if (this.dataFor.equals("showform")) {
            this.htmlReturn = saveKantorCabang(request);
        }
    }

    public void commandDeleteAll(HttpServletRequest request) {
        if (this.dataFor.equals("deleteAll")) {
            this.htmlReturn = deleteAll(request);
        }
    }

    public void commandList(HttpServletRequest request, HttpServletResponse response) {
        if (this.dataFor.equals("list")) {
            String[] cols = {
                PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KANTOR_CABANG_OID],
                PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_NAMA_KANTOR_CABANG],
                PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_CORE_BANKING],
                PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK]
            };
            jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
        }
    }

    public void commandDelete(HttpServletRequest request) {
        if (this.dataFor.equals("delete")) {
            this.htmlReturn = deleteAll(request);
        }
    }

    public JSONObject listDataTables(HttpServletRequest request, HttpServletResponse response, String[] cols, String dataFor, JSONObject result) {
        this.searchTerm = FRMQueryString.requestString(request, "sSearch");
        int amount = 10;
        int start = 0;
        int col = 0;
        String dir = "asc";
        String sStart = request.getParameter("iDisplayStart");
        String sAmount = request.getParameter("iDisplayLength");
        String sCol = request.getParameter("iSortCol_0");
        String sdir = request.getParameter("sSortDir_0");

        if (sStart != null) {
            start = Integer.parseInt(sStart);
            if (start < 0) {
                start = 0;
            }
        }
        if (sAmount != null) {
            amount = Integer.parseInt(sAmount);
            if (amount < 10) {
                amount = 10;
            }
        }
        if (sCol != null) {
            col = Integer.parseInt(sCol);
            if (col < 0) {
                col = 0;
            }
        }
        if (sdir != null) {
            if (!sdir.equals("asc")) {
                dir = "desc";
            }
        }

        String whereClause = "";

        if (dataFor.equals("list")) {

            if (whereClause.length() > 0) {
                whereClause += "AND (" + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_NAMA_KANTOR_CABANG] + " LIKE '%" + searchTerm + "%' "
                        + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_CORE_BANKING] + " LIKE '%" + searchTerm + "%'"
                        + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK] + " LIKE '%" + searchTerm + "%')";
            } else {
                whereClause += " (" + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_NAMA_KANTOR_CABANG] + " LIKE '%" + searchTerm + "%' "
                        + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_CORE_BANKING] + " LIKE '%" + searchTerm + "%'"
                        + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK] + " LIKE '%" + searchTerm + "%')";
            }
        }

        String colName = cols[col];
        int total = -1;

        if (dataFor.equals("list")) {
            total = PstContentDataKantorCabang.getCount(whereClause);
        }

        this.amount = amount;

        this.colName = colName;
        this.dir = dir;
        this.start = start;
        this.colOrder = col;

        try {
            result = getData(total, request, dataFor);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }

    public JSONObject getData(int total, HttpServletRequest request, String datafor) {

        int totalAfterFilter = total;
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        ContentDataKantorCabang contentDataKantorCabang = new ContentDataKantorCabang();
        String whereClause = "";
        String order = "";
        boolean privUpdate = FRMQueryString.requestBoolean(request, "privUpdate");

        String appRoot = FRMQueryString.requestString(request, "FRM_FLD_APP_ROOT");

        if (this.searchTerm == null) {
            whereClause += "";
        } else {
            if (datafor.equals("list")) {

                if (whereClause.length() > 0) {
                    whereClause += "AND (" + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_NAMA_KANTOR_CABANG] + " LIKE '%" + searchTerm + "%' "
                            + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_CORE_BANKING] + " LIKE '%" + searchTerm + "%'"
                            + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK] + " LIKE '%" + searchTerm + "%')";
                } else {
                    whereClause += " (" + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_NAMA_KANTOR_CABANG] + " LIKE '%" + searchTerm + "%' "
                            + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_CORE_BANKING] + " LIKE '%" + searchTerm + "%'"
                            + " OR " + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK] + " LIKE '%" + searchTerm + "%')";
                }
            }
        }

        if (this.colOrder >= 0) {
            order += "" + colName + " " + dir + "";
        }

        Vector listData = new Vector(1, 1);
        if (datafor.equals("list")) {
            listData = PstContentDataKantorCabang.list(start, amount, whereClause, order);
        }

        for (int i = 0; i <= listData.size() - 1; i++) {
            JSONArray ja = new JSONArray();
            if (datafor.equals("list")) {
                contentDataKantorCabang = (ContentDataKantorCabang) listData.get(i);
                ja.put("" + (this.start + i + 1));
                ja.put("" + contentDataKantorCabang.getNamaKantorCabang());
                ja.put("" + contentDataKantorCabang.getKodeCoreBanking());
                ja.put("" + contentDataKantorCabang.getKodeOjk());
                ja.put("<button type='button' class='btn btn-warning btneditgeneral' data-oid='" + contentDataKantorCabang.getOID() + "' data-for='showform'><i class='fa fa-pencil'></i> Edit</button>"
                        + "<button class='btn btn-danger button-delete' type='button' data-oid='" + contentDataKantorCabang.getOID() + "' data-for='delete' data-command = '" + Command.DELETE + "'>Delete</button>");

                array.put(ja);
            }
        }

        totalAfterFilter = total;

        try {
            result.put("iTotalRecords", total);
            result.put("iTotalDisplayRecords", totalAfterFilter);
            result.put("aaData", array);
        } catch (Exception e) {

        }

        return result;
    }

    public String showForm(HttpServletRequest request) {
        ContentDataKantorCabang contentDataKantorCabang = new ContentDataKantorCabang();
        if (oid != 0) {
            try {
                contentDataKantorCabang = PstContentDataKantorCabang.fetchExc(oid);
            } catch (Exception e) {
            }
        }
        String returnData = ""
                + "<div class='row'>"
                + "<div class='col-md-12'>"
                + "<div class='form-group'>"
                + "<label>Nama Kantor Cabang</label>"
                + "<input type='text' class='form-control' name='" + FrmContentDataKantorCabang.fieldNames[FrmContentDataKantorCabang.FRM_FIELD_NAMA_KANTOR_CABANG] + "' value='" + contentDataKantorCabang.getNamaKantorCabang()+ "'>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Kode Core Banking</label>"
                + "<input type='text' class='form-control' name='" + FrmContentDataKantorCabang.fieldNames[FrmContentDataKantorCabang.FRM_FIELD_KODE_CORE_BANKING] + "' value='" + contentDataKantorCabang.getKodeCoreBanking() + "'>"
                + "</div>"
                + "<div class='form-group'>"
                + "<label>Kode OJK</label>"
                + "<input type='text' class='form-control' name='" + FrmContentDataKantorCabang.fieldNames[FrmContentDataKantorCabang.FRM_FIELD_KODE_OJK] + "' value='" + contentDataKantorCabang.getKodeOjk() + "'>"
                + "</div>"
                + "</div>"
                + "</div>";

        return returnData;
    }

    public String saveKantorCabang(HttpServletRequest request) {
        String returnData = "";
        CtrlContentDataKantorCabang contentDataKantorCabang = new CtrlContentDataKantorCabang(request);
        contentDataKantorCabang.action(iCommand, oid, oidDelete);
        returnData = contentDataKantorCabang.getMessage();
        return returnData;
    }

    public String deleteAll(HttpServletRequest request) {
        String returnData = "";
        CtrlContentDataKantorCabang contentDataKantorCabang = new CtrlContentDataKantorCabang(request);
        contentDataKantorCabang.action(iCommand, oid, oidDelete);
        returnData = contentDataKantorCabang.getMessage();
        return returnData;
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
