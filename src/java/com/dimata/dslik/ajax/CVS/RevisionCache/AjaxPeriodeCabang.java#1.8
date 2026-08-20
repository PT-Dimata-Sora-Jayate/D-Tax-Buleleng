/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.ajax;

import com.dimata.dslik.entity.agunan.PstAgunan;
import com.dimata.dslik.entity.bankgaransi.PstBankGaransi;
import com.dimata.dslik.entity.debitur.PstDebitur;
import com.dimata.dslik.entity.debiturbdnusaha.PstDebiturBdnUsaha;
import com.dimata.dslik.entity.fasilitaslain.PstFasilitasLain;
import com.dimata.dslik.entity.irrevocablelc.PstIrrevocableLc;
import com.dimata.dslik.entity.kredit.PstKredit;
import com.dimata.dslik.entity.kreditjoinaccount.PstKreditJoinAccount;
import com.dimata.dslik.entity.laporankeuangandebitur.PstLaporanKeuanganDebitur;
import com.dimata.dslik.entity.masterdata.CabangBank;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PeriodeCabang;
import com.dimata.dslik.entity.masterdata.PstCabangBank;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.entity.masterdata.PstPeriodeCabang;
import com.dimata.dslik.entity.pengurusataupemilik.PstPengurusAtauPemilik;
import com.dimata.dslik.entity.penjamin.PstPenjamin;
import com.dimata.dslik.entity.suratberharga.PstSuratBerharga;
import com.dimata.dslik.form.masterdata.CtrlPeriodeCabang;
import com.dimata.dslik.form.masterdata.FrmPeriodeCabang;
import com.dimata.gui.jsp.ControlCombo;
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
public class AjaxPeriodeCabang extends HttpServlet {

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
    
    //BOOLEAN
    private boolean privApprove = false;

    //STRING
    private String dataFor = "";
    private String oidDelete = "";
    private String approot = "";
    private String htmlReturn = "";
    private String dateStart = "";
    private String dateEnd = "";
    private String kodeCabang = "";
    private int userGroup =0;
    
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
        this.kodeCabang = FRMQueryString.requestString(request, "FRM_KODE_CABANG");
        this.userGroup = FRMQueryString.requestInt(request, "FRM_USER_GROUP");
        
        this.htmlReturn = "";
        
        //BOOLEAN
        this.privApprove = FRMQueryString.requestBoolean(request, "privapprove");

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
        if (this.dataFor.equals("update")) {
            this.htmlReturn = savePeriodeCabang(request);
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
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_CABANG_ID],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_ID],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_CABANG_ID],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_KETERANGAN],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_STATUS],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_USER_ID],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_CREATE],
                PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_POSTING]
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
        this.kodeCabang = FRMQueryString.requestString(request, "FRM_KODE_CABANG");
        this.userGroup = FRMQueryString.requestInt(request, "FRM_USER_GROUP");
        int amount = 10;
        int start = 0;
        int col = 0;
        String dir = "asc";
        String sStart = request.getParameter("iDisplayStart");
        String sAmount = request.getParameter("iDisplayLength");
        String sCol = request.getParameter("iSortCol_0");
        String sdir = request.getParameter("sSortDir_0");
        
        //tambahkan fungsi pengecekan periode yang aktive, update dengan periode tsb
        Periode periode = new Periode();
        long periodeId=0;
        try{
            Vector listPeriode = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'", "");
            if(listPeriode != null){
                periode = (Periode) listPeriode.get(0);
                periodeId = periode.getOID();
            }
        }catch(Exception ex){
        }
        
        
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
                whereClause += "AND (dp." + PstPeriode.fieldNames[PstPeriode.FLD_NAMA] + " LIKE '%" + searchTerm + "%'"
                        + " OR dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_NAMA_CABANG] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_KETERANGAN] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_STATUS] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_USER_ID] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_CREATE] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_POSTING] + " LIKE '%" + searchTerm + "%')";
                if(userGroup!=4){
                     whereClause += " AND dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_KODE_CABANG] + "='"+this.kodeCabang+"'";
                }
                if(periodeId!=0){
                    whereClause += " AND dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_ID] + "='"+periodeId+"'";
                }
            } else {
                whereClause += " (dp." + PstPeriode.fieldNames[PstPeriode.FLD_NAMA] + " LIKE '%" + searchTerm + "%'"
                        + " OR dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_NAMA_CABANG] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_KETERANGAN] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_STATUS] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_USER_ID] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_CREATE] + " LIKE '%" + searchTerm + "%'"
                        + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_POSTING] + " LIKE '%" + searchTerm + "%')";
                if(userGroup!=4){
                    whereClause += " AND dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_KODE_CABANG] + "='"+this.kodeCabang+"'";
                }
                if(periodeId!=0){
                    whereClause += " AND dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_ID] + "='"+periodeId+"'";
                }
            }
        }

        String colName = cols[col];
        int total = -1;

        if (dataFor.equals("list")) {
            total = PstPeriodeCabang.getCountJoin(whereClause);
        }

        this.amount = amount;

        this.colName = colName;
        this.dir = dir;
        this.start = start;
        this.colOrder = col;

        try {
            result = getData(total, request, dataFor, periodeId);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return result;
    }

    public JSONObject getData(int total, HttpServletRequest request, String datafor, long periodeId) {

        int totalAfterFilter = total;
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        PeriodeCabang periodeCabang = new PeriodeCabang();
        String whereClause = "";
        String order = "";
        boolean privUpdate = FRMQueryString.requestBoolean(request, "privUpdate");

        String appRoot = FRMQueryString.requestString(request, "FRM_FLD_APP_ROOT");

        if (this.searchTerm == null) {
            whereClause += "";
        } else {
            if (datafor.equals("list")) {

                if (whereClause.length() > 0) {
                    whereClause += "AND (dp." + PstPeriode.fieldNames[PstPeriode.FLD_NAMA] + " LIKE '%" + searchTerm + "%'"
                            + " OR dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_NAMA_CABANG] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_KETERANGAN] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_STATUS] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_USER_ID] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_CREATE] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_POSTING] + " LIKE '%" + searchTerm + "%')";
                    if(userGroup!=4){
                        whereClause += " AND dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_KODE_CABANG] + "='"+this.kodeCabang+"'";
                    }
                    if(periodeId!=0){
                        whereClause += " AND dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_ID] + "='"+periodeId+"'";
                    }
                } else {
                    whereClause += " (dp." + PstPeriode.fieldNames[PstPeriode.FLD_NAMA] + " LIKE '%" + searchTerm + "%'"
                            + " OR dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_NAMA_CABANG] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_KETERANGAN] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_STATUS] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_USER_ID] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_CREATE] + " LIKE '%" + searchTerm + "%'"
                            + " OR dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_TANGGAL_POSTING] + " LIKE '%" + searchTerm + "%')";
                    if(userGroup!=4){
                        whereClause += " AND dcb." + PstCabangBank.fieldNames[PstCabangBank.FLD_KODE_CABANG] + "='"+this.kodeCabang+"'";
                    }
                    if(periodeId!=0){
                        whereClause += " AND dpc." + PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_ID] + "='"+periodeId+"'";
                    }
                }
            }
        }

        if (this.colOrder >= 0) {
            order += "" + colName + " " + dir + "";
        }

        Vector listData = new Vector(1, 1);
        if (datafor.equals("list")) {
            listData = PstPeriodeCabang.listJoin(start, amount, whereClause, order);
        }

        for (int i = 0; i <= listData.size() - 1; i++) {
            JSONArray ja = new JSONArray();
            if (datafor.equals("list")) {
                periodeCabang = (PeriodeCabang) listData.get(i);
                String status = "";
                if(periodeCabang.getStatus() == 0){
                    status = "Data belum lengkap";
                }else if(periodeCabang.getStatus() == 1){
                    status = "Approve";
                }
                ja.put("" + (this.start + i + 1));
                ja.put("" + periodeCabang.getNamaPeriode());
                ja.put("" + periodeCabang.getNamaCabang());
                ja.put("" + periodeCabang.getKeterangan());
                ja.put("" + status);
                ja.put("" + periodeCabang.getUserId());
                ja.put("" + periodeCabang.getTanggalCreate());
                ja.put("" + periodeCabang.getTanggalPosting());
                String buttonAprove = "";
                if (periodeCabang.getStatus() == 0 && privApprove && dataLengkap(periodeCabang.getOID())) {
                    buttonAprove ="<button type='button' class='btn btn-warning btnupdate' data-oid='" + periodeCabang.getOID() + "' data-for='update' data-command = '" + Command.SAVE + "'><i class='fa fa-pencil'></i> Approve</button>";
                }
                ja.put(buttonAprove);
                      //+"<button type='button' class='btn btn-warning btneditgeneral' data-oid='" + periodeCabang.getOID() + "' data-for='showform'><i class='fa fa-pencil'></i> Edit</button>"
                       //+ "<button class='btn btn-danger button-delete' type='button' data-oid='" + periodeCabang.getOID() + "' data-for='delete' data-command = '" + Command.DELETE + "'>Delete</button>");

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
        PeriodeCabang periodeCabang = new PeriodeCabang();
        if (oid != 0) {
            try {
                periodeCabang = PstPeriodeCabang.fetchExc(oid);
            } catch (Exception e) {
            }
        }
        
        Vector vperiode =  PstPeriode.listAll();
        Vector valuePeriode = new Vector();
        Vector keyPeriode = new Vector();
        
        for (int i = 0; i < vperiode.size(); i++) {
            Periode periode = (Periode) vperiode.get(i);
            valuePeriode.add(""+periode.getOID());
            keyPeriode.add(""+periode.getNama());
        }
        
        Vector vCabangBank =  PstCabangBank.listAll();
        Vector valueCabangBank = new Vector();
        Vector keyCabangBank = new Vector();
        
        for (int i = 0; i < vCabangBank.size(); i++) {
            CabangBank cabangBank = (CabangBank) vCabangBank.get(i);
            valueCabangBank.add(""+cabangBank.getOID());
            keyCabangBank.add(""+cabangBank.getNamaCabang());
        }
        
        String returnData = ""
            + "<div class='row'>"
                + "<div class='col-md-12'>"
                    + "<div class='form-group'>"
                        + "<label>Nama Periode</label>"
                        //+ "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_PERIODE_ID] + "' value='" + periodeCabang.getPeriodeId()+ "'>"
                        + ControlCombo.drawBootsratap(""+FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_PERIODE_ID], null, "", valuePeriode, keyPeriode, "required='required' onchange=\"javascript:changeFunc();\" ", "form-control") 
                    + "</div>"
                    + "<div class='form-group'>"
                        + "<label>Nama Cabang</label>"
                        //+ "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_CABANG_ID] + "' value='" + periodeCabang.getCabangId()+ "'>"
                        + ControlCombo.drawBootsratap(""+FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_CABANG_ID], null, "", valueCabangBank, keyCabangBank, "required='required' onchange=\"javascript:changeFunc();\" ", "form-control") 
                    + "</div>"
                    + "<div class='form-group'>"
                        + "<label>Keterangan</label>"
                        + "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_KETERANGAN] + "' value='" + periodeCabang.getKeterangan()+ "'>"
                    + "</div>"
                    + "<div class='form-group'>"
                        + "<label>Status</label>"
                        + "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_STATUS] + "' value='" + periodeCabang.getStatus()+ "'>"
                    + "</div>"
                    + "<div class='form-group'>"
                        + "<label>User ID</label>"
                        + "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_USER_ID] + "' value='" + periodeCabang.getUserId()+ "'>"
                    + "</div>"
                    + "<div class='form-group'>"
                        + "<label>Tanggal Create</label>"
                        + "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_TANGGAL_CREATE] + "' value='" + periodeCabang.getTanggalCreate()+ "'>"
                    + "</div>"
                    + "<div class='form-group'>"
                        + "<label>Tanggal Posting</label>"
                        + "<input type='text' class='form-control' name='" + FrmPeriodeCabang.fieldNames[FrmPeriodeCabang.FRM_FIELD_TANGGAL_POSTING] + "' value='" + periodeCabang.getTanggalPosting()+ "'>"
                    + "</div>"
                + "</div>"
            + "</div>";

        return returnData;
    }

    public String savePeriodeCabang(HttpServletRequest request) {
        String returnData = "";
        CtrlPeriodeCabang ctrlPeriodeCabang = new CtrlPeriodeCabang(request);
        ctrlPeriodeCabang.actionUpdateStatus(iCommand, oid, oidDelete);
        returnData = ctrlPeriodeCabang.getMessage();
        return returnData;
    }

    public String deleteAll(HttpServletRequest request) {
        String returnData = "";
        CtrlPeriodeCabang ctrlPeriodeCabang = new CtrlPeriodeCabang(request);
        ctrlPeriodeCabang.action(iCommand, oid, oidDelete);
        returnData = ctrlPeriodeCabang.getMessage();
        return returnData;
    }
    
    private boolean dataLengkap(long periodeCabangId){
        boolean isCorrect = false;
        String whereClause = "";
        
        PeriodeCabang periodeCabang = new PeriodeCabang();
        String kodeCabang = "";
        if(periodeCabangId != 0){
            try{
                periodeCabang = PstPeriodeCabang.fetchExc(periodeCabangId);
                CabangBank cabangBank = PstCabangBank.fetchExc(periodeCabang.getCabangId());
                kodeCabang = cabangBank.getKodeCabang();
            }catch(Exception ex){
                
            }
        }
        int count = 0;
        
        //Pengurus Pemilik
        whereClause="pengurus."+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND pengurus."+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' "
                + "AND pengurus."+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
        
        count = PstPengurusAtauPemilik.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Laporan Keuangan
        whereClause = " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstLaporanKeuanganDebitur.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Fasilitas Lainnya
        whereClause = " fl."+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND fl."+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND fl."+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstFasilitasLain.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Bank Garansi
        whereClause = " bg."+PstBankGaransi.fieldNames[PstBankGaransi.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND bg."+PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND bg."+PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstBankGaransi.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Irrevocable
        whereClause = " ilc."+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND ilc."+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND ilc."+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstIrrevocableLc.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //KreditJoin
        whereClause = " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstKreditJoinAccount.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Surat Berharga
        whereClause = " sb."+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND sb."+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND sb."+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstSuratBerharga.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Kredit
        whereClause = " kredit."+PstKredit.fieldNames[PstKredit.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND kredit."+PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND kredit."+PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstKredit.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Penjamin
        whereClause = " penjamin."+PstPenjamin.fieldNames[PstPenjamin.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND penjamin."+PstPenjamin.fieldNames[PstPenjamin.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND penjamin."+PstPenjamin.fieldNames[PstPenjamin.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstPenjamin.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Agunan
        whereClause = " agunan."+PstAgunan.fieldNames[PstAgunan.FLD_STATUS_DATA_PERUBAHAN]+" IS NULL "
                + " AND agunan."+PstAgunan.fieldNames[PstAgunan.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + "AND agunan."+PstAgunan.fieldNames[PstAgunan.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstAgunan.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Badan Usaha
        whereClause = " debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + " AND debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS_NSB]+"!='1' "
                + " AND debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_KTR_CABANG]+"='"+kodeCabang+"' ";
        count = PstDebitur.getCountJoin(whereClause,""+periodeCabang.getPeriodeId(), kodeCabang);//PstDebiturBdnUsaha.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        
        //Indivindu
        whereClause = " debitur."+PstDebitur.fieldNames[PstDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL "
                + " AND debitur."+PstDebitur.fieldNames[PstDebitur.FLD_PERIODE_ID]+"='"+periodeCabang.getPeriodeId()+"' "
                + " AND debitur."+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS_NSB]+"='1' "
                + "AND debitur."+PstDebitur.fieldNames[PstDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"' ";
        count = PstDebitur.getCountJoin(whereClause,""+periodeCabang.getPeriodeId(), kodeCabang);//PstDebitur.getCountJoin(whereClause);
        if(count > 0){
            return false;
        }else{
            isCorrect = true;
        }
        return isCorrect;
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
