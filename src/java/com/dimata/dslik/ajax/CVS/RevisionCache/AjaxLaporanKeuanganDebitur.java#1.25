/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.ajax;

import com.dimata.common.entity.logger.PstLogSysHistory;
import com.dimata.dslik.entity.agunan.PstAgunan;
import com.dimata.dslik.entity.contentdata.*;
import com.dimata.dslik.entity.debitur.PstDebitur;
import com.dimata.dslik.entity.laporankeuangandebitur.LaporanKeuanganDebitur;
import com.dimata.dslik.entity.laporankeuangandebitur.PstLaporanKeuanganDebitur;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.form.contentdata.*;
import com.dimata.dslik.form.laporankeuangandebitur.*;
import com.dimata.gui.jsp.ControlCombo;
import com.dimata.gui.jsp.ControlList;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
 * @author Ardiadi
 */
public class AjaxLaporanKeuanganDebitur extends HttpServlet {

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
    private String cif = "";
    
    //BOOLEAN
    private boolean privAdd = false;
    private boolean privUpdate = false;
    private boolean privDelete = false;
    private boolean privView = false;
    //INT
    private int iCommand = 0;
    private int iErrCode = 0;
    
    private long userId = 0;
    private String userName = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        //LONG
	this.oid = FRMQueryString.requestLong(request, "FRM_FIELD_OID");
	this.oidReturn=0;
	
	//STRING
	this.dataFor = FRMQueryString.requestString(request, "FRM_FIELD_DATA_FOR");
	this.oidDelete = FRMQueryString.requestString(request, "FRM_FIELD_OID_DELETE");
	this.approot = FRMQueryString.requestString(request, "FRM_FIELD_APPROOT");
	this.htmlReturn = "";
	this.cif= FRMQueryString.requestString(request, "FRM_FIELD_CIF");
        
	//INT
	this.iCommand = FRMQueryString.requestCommand(request);
	this.iErrCode = 0;
        
        //BOOLEAN
        this.privAdd = FRMQueryString.requestBoolean(request, "privadd");
        this.privDelete = FRMQueryString.requestBoolean(request, "privdelete");
        this.privUpdate = FRMQueryString.requestBoolean(request, "privupdate");
	this.privView = FRMQueryString.requestBoolean(request, "privview");
        
	//OBJECT
	this.jSONObject = new JSONObject();
	
	switch(this.iCommand){
	    case Command.SAVE :
		commandSave(request);
	    break;
		
	    case Command.LIST :
		commandList(request, response);
	    break;
		
	    case Command.DELETEALL : 
		commandDeleteAll(request);
	    break;
	    
	    case Command.DELETE : 
		commandDelete(request);
	    break;
		
	    default : commandNone(request);
	}
	try{
	    
	    this.jSONObject.put("FRM_FIELD_HTML", this.htmlReturn);
	    this.jSONObject.put("FRM_FIELD_RETURN_OID", this.oidReturn);
	    this.jSONObject.put("FRM_FIELD_DATE_START", this.dateStart);
	    this.jSONObject.put("FRM_FIELD_DATE_END", this.dateEnd);
	}catch(JSONException jSONException){
	    jSONException.printStackTrace();
	}
	
	response.getWriter().print(this.jSONObject);
        
    }
    
    public void commandNone(HttpServletRequest request){
	if(this.dataFor.equals("showform")){
	    this.htmlReturn = showForm(request);
	}else if(this.dataFor.equals("searchform")){
            this.htmlReturn = searchForm(request);
        }else if(this.dataFor.equals("showlistlaporankeuangandebitur")){
            this.htmlReturn = showListForm(request);
        }else if (this.dataFor.equals("showform2")){
            this.htmlReturn = showForm2(request);
        }else if(this.dataFor.equals("loadsummary") || this.dataFor.equals("loadsummarynull")){
            this.htmlReturn = getSummary(request);
        }
    }
    
    public void commandSave(HttpServletRequest request){
	if (this.dataFor.equals("showform")) {
            this.htmlReturn = saveLapKeuDeb(request);
        }
    }
        
    public String saveLapKeuDeb(HttpServletRequest request) {
        String returnData = "";
        oid = FRMQueryString.requestLong(request, "FRM_FIELD_LAPORAN_OID");
        userId = FRMQueryString.requestLong(request, "useroid");
        userName = FRMQueryString.requestString(request, "username");
        CtrlLaporanKeuanganDebitur ctrlLaporan = new CtrlLaporanKeuanganDebitur(request);
        ctrlLaporan.action(iCommand, oid,userId,userName);
        returnData = ctrlLaporan.getMessage();
        return returnData;
    }
    
    public void commandDeleteAll(HttpServletRequest request){
	if(this.dataFor.equals("deleterateplan")){
	    
	}else if(this.dataFor.equals("deleteitem")){
            this.htmlReturn = deleteItem(request);
        }
    }
    
    
    
    public void commandList(HttpServletRequest request, HttpServletResponse response){
	if(this.dataFor.equals("listdatasearch")){
	    String[] cols = { 
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_LAPORAN_KEUANGAN_DEBITUR_OID],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]
            };
	    jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
	}else if(this.dataFor.equals("showlistlaporankeuangandebitur")){
	    String[] cols = { 
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_LAPORAN_KEUANGAN_DEBITUR_OID],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]
            };
	    jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
	}else if (this.dataFor.equals("listdatalaporan") || this.dataFor.equals("listdatalaporanhome")){
            String[] cols = { 
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_LAPORAN_KEUANGAN_DEBITUR_OID],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PENDAPATAN_USAHA_OPR],
                PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_LABA_RUGI_PERIODE]
            };
             jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
        }    
    }
    
    public void commandDelete(HttpServletRequest request){
	if(this.dataFor.equals("deleterule")){
	    //deleteRules(request);
	}
    }
    
    public JSONObject listDataTables (HttpServletRequest request, HttpServletResponse response, String[] cols, String dataFor, JSONObject result){
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
            if (col < 0 )
                col = 0;
        }
        if (sdir != null) {
            if (!sdir.equals("asc"))
            dir = "desc";
        }
        
	
        String cif = FRMQueryString.requestString(request, "cif");
        String aset = FRMQueryString.requestString(request, "aset");
        String pinjamanjangkapanjang = FRMQueryString.requestString(request, "pinjamanjangkapanjang");
        String status = FRMQueryString.requestString(request, "FRM_FIELD_STATUS_DATA");
        String whereClause = "";
        
        int userGroup = FRMQueryString.requestInt(request, "usergroup");
        String kodeCabang = FRMQueryString.requestString(request, "kodecabang");
        
        if(userGroup != 4){
            if(whereClause.length() > 0){
                whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }else{
                whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }
        }
        if(dataFor.equals("listdatasearch")){
	    if(cif.length() > 0){
                if(whereClause.length() > 0){
                    whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cif+"'";
                }else{
                    whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cif+"'";
                }
            }

            if(aset.length() > 0){
                if(whereClause.length() > 0){
                    whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+"='"+aset+"'";
                }else{
                    whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+"='"+aset+"'";
                }
            }

            if(pinjamanjangkapanjang.length() > 0){
                if(whereClause.length() > 0){
                    whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+"='"+pinjamanjangkapanjang+"'";
                }else{
                    whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+"='"+pinjamanjangkapanjang+"'";
                }
            }
	    if(whereClause.length() > 0){
		whereClause += " AND (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
	    }else{
		whereClause += " (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
	    }
	}else if(dataFor.equals("showlistlaporankeuangandebitur")){
            if(status.equals("0")){
                if(whereClause.length() > 0){
                    whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                }else{
                    whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                }
            }else{
                if(whereClause.length() > 0){
                    whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                }else{
                    whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                }
            }
	    if(whereClause.length() > 0){
		whereClause += " AND (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
	    }else{
		whereClause += " (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
	    }
        }else if (dataFor.equals("listdatalaporan") || this.dataFor.equals("listdatalaporanhome")){
            String cifParam = FRMQueryString.requestString(request, "FRM_FIELD_CIF");
            whereClause = " "
                + " 1=1"
                + " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cifParam+"'"
                + " AND ( laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" like '%"+this.searchTerm+"%'"
                + " OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" like '%"+this.searchTerm+"%'"
                + " OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PENDAPATAN_USAHA_OPR]+" like '%"+this.searchTerm+"%'"
                + " OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_LABA_RUGI_PERIODE]+" like '%"+this.searchTerm+"%')";
        }
	
        String colName = cols[col];
        int total = -1;
	
	if(dataFor.equals("listdatasearch") || dataFor.equals("listdatalaporan") || this.dataFor.equals("listdatalaporanhome")){
	    total = PstLaporanKeuanganDebitur.getCountJoin(whereClause);
	}else if(dataFor.equals("showlistlaporankeuangandebitur")){
            total = PstLaporanKeuanganDebitur.getCountJoin(whereClause);
        }
        
        this.amount = amount;
       
        this.colName = colName;
        this.dir = dir;
        this.start = start;
        this.colOrder = col;
        
        try {
            result = getData(total, request, dataFor);
        } catch(Exception ex){
            System.out.println(ex);
        }
       
       return result;
    }
    
    public JSONObject getData(int total, HttpServletRequest request, String datafor){
        
        int totalAfterFilter = total;
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        LaporanKeuanganDebitur laporanKeuanganDebitur = new LaporanKeuanganDebitur();
	approot = FRMQueryString.requestString(request, "FRM_FIELD_APPROOT");
        privView = FRMQueryString.requestBoolean(request, "privview");
	String cif = FRMQueryString.requestString(request, "cif");
        String aset = FRMQueryString.requestString(request, "aset");
        String pinjamanjangkapanjang = FRMQueryString.requestString(request, "pinjamanjangkapanjang");
        String whereClause = "";
        String order ="";
        String appRoot = FRMQueryString.requestString(request, "FRM_FLD_APP_ROOT");
        String status = FRMQueryString.requestString(request, "FRM_FIELD_STATUS_DATA");
        
        int userGroup = FRMQueryString.requestInt(request, "usergroup");
        String kodeCabang = FRMQueryString.requestString(request, "kodecabang");
        
        if(userGroup != 4){
            if(whereClause.length() > 0){
                whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }else{
                whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }
        }
        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
	     if(datafor.equals("listdatasearch")){
                if(cif.length() > 0){
                    if(whereClause.length() > 0){
                        whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cif+"'";
                    }else{
                        whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cif+"'";
                    }
                }

                if(aset.length() > 0){
                    if(whereClause.length() > 0){
                        whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+"='"+aset+"'";
                    }else{
                        whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+"='"+aset+"'";
                    }
                }

                if(pinjamanjangkapanjang.length() > 0){
                    if(whereClause.length() > 0){
                        whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+"='"+pinjamanjangkapanjang+"'";
                    }else{
                        whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+"='"+pinjamanjangkapanjang+"'";
                    }
                }
		if(whereClause.length() > 0){
                    whereClause += " AND (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
                }else{
                    whereClause += " (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
                }
            }else if(dataFor.equals("showlistlaporankeuangandebitur")){
                if(status.equals("0")){
                    if(whereClause.length() > 0){
                        whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                    }else{
                        whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                    }
                }else{
                    if(whereClause.length() > 0){
                        whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                    }else{
                        whereClause += " laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                    }
                }
                if(whereClause.length() > 0){
                    whereClause += " AND (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
                }else{
                    whereClause += " (laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" LIKE '%"+this.searchTerm+"%')";
                }
            }else if (dataFor.equals("listdatalaporan") || this.dataFor.equals("listdatalaporanhome")){
                String cifParam = FRMQueryString.requestString(request, "FRM_FIELD_CIF");
                whereClause = " "
                    + " 1=1"
                    + " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cifParam+"'"
                    + " AND ( laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_ASET]+" like '%"+this.searchTerm+"%'"
                    + " OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PINJAMAN_JNK_PNJG]+" like '%"+this.searchTerm+"%'"
                    + " OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PENDAPATAN_USAHA_OPR]+" like '%"+this.searchTerm+"%'"
                    + " OR laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_LABA_RUGI_PERIODE]+" like '%"+this.searchTerm+"%')";
            }
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
	
        Vector listData = new Vector(1,1);
	if(datafor.equals("listdatasearch") || datafor.equals("listdatalaporan") || this.dataFor.equals("listdatalaporanhome")){
	    listData = PstLaporanKeuanganDebitur.listJoin(start, amount, whereClause, order);
	}else if(datafor.equals("showlistlaporankeuangandebitur")){
	    listData = PstLaporanKeuanganDebitur.listJoin(start, amount, whereClause, order);
	}
         
        
        
        for (int i =0 ; i<=listData.size()-1;i++){
	    JSONArray ja = new JSONArray();
            String buttonUpdate = "";
	    if(datafor.equals("listdatasearch")){
		laporanKeuanganDebitur = (LaporanKeuanganDebitur) listData.get(i);
		ja.put(""+(this.start+i+1));
                ja.put(""+laporanKeuanganDebitur.getCif());
                ja.put(""+laporanKeuanganDebitur.getAset());
                ja.put(""+laporanKeuanganDebitur.getPinjamanJnkPnjg());
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+laporanKeuanganDebitur.getDebiturOid()+"&type="+laporanKeuanganDebitur.getDebiturType()+"&cif="+laporanKeuanganDebitur.getCif()+"&activetab=AjaxLaporanKeuanganDebitur&otheroid="+laporanKeuanganDebitur.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
		ja.put(buttonUpdate);
		
		array.put(ja);
	    }else if(datafor.equals("showlistlaporankeuangandebitur")){
		laporanKeuanganDebitur = (LaporanKeuanganDebitur) listData.get(i);
		ja.put(""+(this.start+i+1));
                ja.put(""+laporanKeuanganDebitur.getCif());
                ja.put(""+laporanKeuanganDebitur.getAset());
                ja.put(""+laporanKeuanganDebitur.getPinjamanJnkPnjg());
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+laporanKeuanganDebitur.getDebiturOid()+"&type="+laporanKeuanganDebitur.getDebiturType()+"&cif="+laporanKeuanganDebitur.getCif()+"&activetab=AjaxLaporanKeuanganDebitur&otheroid="+laporanKeuanganDebitur.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
		ja.put(buttonUpdate);
		
		array.put(ja);
	    }else if (datafor.equals("listdatalaporan")){
                laporanKeuanganDebitur = (LaporanKeuanganDebitur) listData.get(i);
		ja.put(""+(this.start+i+1));
                ja.put(""+(laporanKeuanganDebitur.getCif()));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getAset(),"###,###,##0")));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getPinjamanJnkPnjg(),"###,###,##0")));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getPendapatanUsahaOpr(),"###,###,##0")));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getLabaRugiPeriode(),"###,###,##0")));
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+laporanKeuanganDebitur.getDebiturOid()+"&type="+laporanKeuanganDebitur.getDebiturType()+"&cif="+laporanKeuanganDebitur.getCif()+"&activetab=AjaxLaporanKeuanganDebitur&otheroid="+laporanKeuanganDebitur.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
                int count  = PstLogSysHistory.getCount(PstLogSysHistory.fieldNames[PstLogSysHistory.FLD_LOG_DOCUMENT_ID]+"='"+laporanKeuanganDebitur.getOID()+"' "
                        + "AND "+PstLogSysHistory.fieldNames[PstLogSysHistory.FLD_LOG_LOGIN_NAME]+" LIKE '%Transfer%'");
                
                if(count == 0){
                    buttonUpdate += "<div class='btn btn-default'><input type='checkbox' class='deletelist' value='"+laporanKeuanganDebitur.getOID()+"'></div>";
                }
                ja.put(buttonUpdate);
                array.put(ja);
            }else if (datafor.equals("listdatalaporanhome")){
                laporanKeuanganDebitur = (LaporanKeuanganDebitur) listData.get(i);
		ja.put(""+(this.start+i+1));
                ja.put(""+(laporanKeuanganDebitur.getCif()));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getAset(),"###,###,##0")));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getPinjamanJnkPnjg(),"###,###,##0")));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getPendapatanUsahaOpr(),"###,###,##0")));
                ja.put(""+(Formater.formatNumber(laporanKeuanganDebitur.getLabaRugiPeriode(),"###,###,##0")));
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+laporanKeuanganDebitur.getDebiturOid()+"&type="+laporanKeuanganDebitur.getDebiturType()+"&cif="+laporanKeuanganDebitur.getCif()+"&activetab=AjaxLaporanKeuanganDebitur&otheroid="+laporanKeuanganDebitur.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
                ja.put(buttonUpdate);
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
    
    
    public String showForm(HttpServletRequest request){

        int needAdd = 0;
        String cif = "";
        int countData = 0;
        String returnData="";
        
        try {
            needAdd = FRMQueryString.requestInt(request, "FRM_FIELD_NEED_ADD");
        } catch (Exception e) {
            needAdd = 0;
        }
        
        try {
            cif = FRMQueryString.requestString(request, "FRM_FIELD_CIF");
        } catch (Exception e) {
            cif = "";
        }
        
        if (cif.length()>0){
            String where = PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_CIF]+"='"+cif+"'";
            countData = PstLaporanKeuanganDebitur.getCount(where);
        }
        
        if (cif.length()==0){
            returnData = ""

            +"<div class='row'>"
                +"<div class='col-md-12'>"
                        +"<div class='box'>"
                            +"<div class='box-header'>"
                                +"<h3 class='box-title'>List Laporan Keuangan Debitur</h3>"
                            +"</div>"
                            +"<div class=\"box-body\">"
                                + "<div id='tableLaporanKeuangan'>"
                                    + "<table class='table table-bordered table-striped'>"
                                        + "<thead>"
                                            + "<tr>"
                                                + "<td>No</td>"                                          
                                                + "<td>CIF</td>"
                                                + "<td>Aset</td>"
                                                + "<td>Pinjaman Jangka Panjang</td>"
                                                + "<td>Pendapatan Usaha Operasional</td>"
                                                + "<td>Laba Rugi Periode</td>"
                                                + "<td>Aksi</td>"
                                            + "</tr>"
                                        + "</thead>"
                                    + "</table>"
                                + "</div>"
                            +"</div>"
                             +"<div class='box-header'>";
                                if(privAdd){
                                    returnData += "<button type='button' class='btn btn-primary btnaddgenerallaporan' data-oid='0' data-for ='showform2' data-target='AjaxLaporanKeuanganDebitur' data-command='"+Command.NONE+"'><i class='fa fa-plus'></i> Tambah Data Keuangan Debitur</button>";
                                }
                                
                                if(privDelete){
                                    returnData += " <button type='button' class='btn btn-danger' id='delete' data-for='deleteitem' data-target='AjaxLaporanKeuanganDebitur' data-command='"+Command.DELETEALL+"'><i class='fa fa-trash'></i> Hapus Data Keuangan Debitur</button>";
                                }
                                returnData +=""
                            +"</div>"
                        +"</div>"
                +"</div>"
            +"</div>"
            + "<div id='formlaporan'></div>";
        }else{
            if (countData>0){
                returnData = ""
                +"<div class='row'>"
                    +"<div class='col-md-12'>"
                            +"<div class='box'>"
                                +"<div class='box-header'>"
                                    +"<h3 class='box-title'>List Laporan Keuangan Debitur</h3>"
                                +"</div>"
                                +"<div class=\"box-body\">"
                                    + "<div id='tableLaporanKeuangan'>"
                                        + "<table class='table table-bordered table-striped'>"
                                            + "<thead>"
                                                + "<tr>"
                                                    + "<td>No</td>"                                          
                                                    + "<td>CIF</td>"
                                                    + "<td>Aset</td>"
                                                    + "<td>Pinjaman Jangka Panjang</td>"
                                                    + "<td>Pendapatan Usaha Operasional</td>"
                                                    + "<td>Laba Rugi Periode</td>"
                                                    + "<td>Aksi</td>"
                                                + "</tr>"
                                            + "</thead>"
                                        + "</table>"
                                    + "</div>"
                                +"</div>"                               
                            +"</div>"
                    +"</div>"
                +"</div>";
               
            }
        }
	
	
	return returnData;
    }
    
    public String showForm2(HttpServletRequest request){
        
        LaporanKeuanganDebitur laporan = new LaporanKeuanganDebitur();
        laporan.setCif(this.cif);
        String kodeCabang = FRMQueryString.requestString(request, "FRM_KODE_CABANG");
        laporan.setKodeKantorCabang(kodeCabang);
        Date dNow = new Date();
        String openDate = "";
        long oidPeriodeWrite = 0;
        String posisiLaporan = "";
        if(oid!=0){
            try {
                laporan = PstLaporanKeuanganDebitur.fetchExc(oid);
            } catch (Exception e) {
                String returnData = "alert('Terjadi Kesalahan "+e.getStackTrace()+"')";
                e.printStackTrace();
            }
            if (laporan.getOpenDate()==null){
                openDate = "";
            }else{
                openDate = Formater.formatDate(laporan.getOpenDate(), "yyyy-MM-dd");
            }
            
            if(laporan.getPosisiLaporanKeuanganTahunan() != null){
                posisiLaporan = Formater.formatDate(laporan.getPosisiLaporanKeuanganTahunan(),"yyyy-MM-dd");
            }
            
            
            
            oidPeriodeWrite = laporan.getPeriodeId();
        }
        else {
            openDate = Formater.formatDate(dNow, "yyyy-MM-dd");
            posisiLaporan = Formater.formatDate(dNow, "yyyy-MM-dd");
            Vector listPeriode = PstPeriode.list(0, 1, " "+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'", "");
            Periode entPeriode = (Periode) listPeriode.get(0);
            oidPeriodeWrite = entPeriode.getOID();
        }
        
        
        
	String returnData = ""
        + "<input type='hidden' value='"+oidPeriodeWrite+"' name ='FRM_FIELD_PERIODE_ID' id='oidPeriode'>"                 
	+ "<div class='row'>"
	    + "<div class='col-md-6'>"
		+ "<div class='form-horizontal' style='padding:10px;background:#fff;border:5px solid #f1f1f1;'>"
		    + "<h4>View Laporan Keuangan Debitur</h4>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_CIF]+"'></i> "
                            + "CIF <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_CIF] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_CIF] +"' value='"+laporan.getCif()+"' data-required='required' data-number='true' data-alpha='true' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_CIF]+"'>"
			+ "</div>"
		    + "</div>"
                    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_POSISI_LAPORAN_KEUANGAN_TAHUNAN]+"'></i> "
                            + "Posisi Laporan Keuangan Tahunan  <i style='color:red;'>m</i></label>"
			+ "<div class='col-sm-8'>"
                            + "<div class='input-group'>"
                                + "<input type='text' class='form-control datepicker' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_POSISI_LAPORAN_KEUANGAN_TAHUNAN] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_POSISI_LAPORAN_KEUANGAN_TAHUNAN] +"' value='"+posisiLaporan+"' data-required='required' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_POSISI_LAPORAN_KEUANGAN_TAHUNAN]+"'>"
                                + "<div class='input-group-addon'>"
                                    + "<i class='fa fa-calendar'></i>"
                                + "</div>"
                            + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET]+"'></i> "
                            + "Aset <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET] +"' value='"+Formater.formatNumber(laporan.getAset(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR]+"'></i> "
                            + "Aset Lancar <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR] +"' value='"+Formater.formatNumber(laporan.getAsetLancar(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_KAS_DAN_SETARA_KAS]+"'></i> "
                            + "Kas dan Setara Kas (Aset Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_KAS_DAN_SETARA_KAS] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_KAS_DAN_SETARA_KAS] +"' value='"+Formater.formatNumber(laporan.getKasDanSetaraKas(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_KAS_DAN_SETARA_KAS]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_LNCR]+"'></i> "
                            + "Piutang Usaha/Pembiayaan (Aset Lancar <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_LNCR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_LNCR] +"' value='"+Formater.formatNumber(laporan.getPiutangUsahaAstLncr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_LNCR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_LNCR]+"'></i> "
                            + "Investasi/Aset Keuangan Lainnya (Aset Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_LNCR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_LNCR] +"' value='"+Formater.formatNumber(laporan.getInvestasiAstLncr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_LNCR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR_LAIN]+"'></i> "
                            + "Aset Lancar Lainnya (Aset Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR_LAIN] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR_LAIN] +"' value='"+Formater.formatNumber(laporan.getAsetLancarLain(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_LANCAR_LAIN]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TIDAK_LANCAR]+"'></i> "
                            + "Aset Tidak Lancar (Aset Tidak Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TIDAK_LANCAR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TIDAK_LANCAR] +"' value='"+Formater.formatNumber(laporan.getAsetTidakLancar(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TIDAK_LANCAR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_TDK_LNCR]+"'></i> "
                            + "Piutang Usaha/Pembiayaan (Aset Tidak Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_TDK_LNCR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_TDK_LNCR] +"' value='"+Formater.formatNumber(laporan.getPiutangUsahaAstTdkLncr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_PIUTANG_USAHA_AST_TDK_LNCR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_TDK_LNCR]+"'></i> "
                            + "Investasi/Aset Keuangan Lainnya (Aset Tidak Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_TDK_LNCR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_TDK_LNCR] +"' value='"+Formater.formatNumber(laporan.getInvestasiAstTdkLncr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_INVESTASI_AST_TDK_LNCR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TDK_LNCR_LAIN]+"'></i> "
                            + "Aset Tidak Lancar Lainnya (Aset Tidak Lancar) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TDK_LNCR_LAIN] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TDK_LNCR_LAIN] +"' value='"+Formater.formatNumber(laporan.getAsetTdkLncrLain(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_ASET_TDK_LNCR_LAIN]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS]+"'></i> "
                            + "Liabilitas <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS] +"' value='"+Formater.formatNumber(laporan.getLiabilitas(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK]+"'></i> "
                            + "Liabilitas Jangka Pendek <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK] +"' value='"+Formater.formatNumber(laporan.getLiabilitasJnkPndk(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNDK]+"'></i> "
                            + "Pinjaman Jangka Pendek(Liabilitas Jangka Pendek) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNDK] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNDK] +"' value='"+Formater.formatNumber(laporan.getPinjamanJnkPndk(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNDK]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNDK]+"'></i> "
                            + "Utang Usaha(Liabilitas Jangka Pendek) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNDK] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNDK] +"' value='"+Formater.formatNumber(laporan.getUtangUsahaLiaJnkPndk(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNDK]+"'>"
			+ "</div>"
		    + "</div>"
		+ "</div>"
	    + "</div>"
	    + "<div class='col-md-6'>"
		+ "<div class='form-horizontal' style='padding:10px;background:#fff;border:5px solid #f1f1f1;'>"
		    + "<h4>&nbsp;</h4>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK_LAIN]+"'></i> "
                            + "Liabilitas Jangka Pendek Lainnya (Liabilitas Jangka Pendek) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK_LAIN] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK_LAIN] +"' value='"+Formater.formatNumber(laporan.getLiabilitasJnkPndkLain(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNDK_LAIN]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG]+"'></i> "
                            + "Liabilitas Jangka Penjang <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG] +"' value='"+Formater.formatNumber(laporan.getLiabilitasJnkPnjg(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNJG]+"'></i> "
                            + "Pinjaman Jangka Panjang <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNJG] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNJG] +"' value='"+Formater.formatNumber(laporan.getPinjamanJnkPnjg(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_PINJAMAN_JNK_PNJG]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNJG]+"'></i> "
                            + "Utang Usaha (Liabilitas Jangka Panjang) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNJG] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNJG] +"' value='"+Formater.formatNumber(laporan.getUtangUsahaLiaJnkPnjg(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_UTANG_USAHA_LIA_JNK_PNJG]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG_LAIN]+"'></i> "
                            + "Liabilitas Jangka Panjang Lainnya (Liabilitas Jangka Panjang) <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG_LAIN] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG_LAIN] +"' value='"+Formater.formatNumber(laporan.getLiabilitasJnkPnjgLain(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LIABILITAS_JNK_PNJG_LAIN]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_EKUITAS]+"'></i> "
                            + "Ekuitas <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_EKUITAS] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_EKUITAS] +"' value='"+Formater.formatNumber(laporan.getEkuitas(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='-' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_EKUITAS]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_PENDAPATAN_USAHA_OPR]+"'></i> "
                            + "Pendapatan Usaha/Operasional <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PENDAPATAN_USAHA_OPR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PENDAPATAN_USAHA_OPR] +"' value='"+Formater.formatNumber(laporan.getPendapatanUsahaOpr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_PENDAPATAN_USAHA_OPR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_POKOK_PEND]+"'></i> "
                            + "Beban Pokok Pendapatan/Beban Operasional <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_POKOK_PEND] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_POKOK_PEND] +"' value='"+Formater.formatNumber(laporan.getBebanPokokPend(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_POKOK_PEND]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_BRUTO]+"'></i> "
                            + "Laba/Rugi Bruto <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_BRUTO] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_BRUTO] +"' value='"+Formater.formatNumber(laporan.getLabaRugiBruto(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='-' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_BRUTO]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_PEND_LAIN_NON_OPR]+"'></i> "
                            + "Pendapatan Lain-lain/Non-Operasional <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PEND_LAIN_NON_OPR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_PEND_LAIN_NON_OPR] +"' value='"+Formater.formatNumber(laporan.getPendLainNonOpr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_PEND_LAIN_NON_OPR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_LAIN_NON_OPR]+"'></i> "
                            + "Beban Lain-lain/Non-Operasional <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_LAIN_NON_OPR] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_LAIN_NON_OPR] +"' value='"+Formater.formatNumber(laporan.getBebanLainNonOpr(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_BEBAN_LAIN_NON_OPR]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_SBLM_PAJAK]+"'></i> "
                            + "Laba/Rugi Sebelum Pajak <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_SBLM_PAJAK] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_SBLM_PAJAK] +"' value='"+Formater.formatNumber(laporan.getLabaRugiSblmPajak(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='-' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_SBLM_PAJAK]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_PERIODE]+"'></i> "
                            + "Laba/Rugi Periode/Tahun Berjalan <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_PERIODE] +"' id='"+ FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_PERIODE] +"' value='"+Formater.formatNumber(laporan.getLabaRugiPeriode(),"###,###,##0")+"' data-required='required' data-number='true' data-alpha='false' data-special='-' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_LABA_RUGI_PERIODE]+"'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                            + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmLaporanKeuanganDebitur.fieldQuestion[FrmLaporanKeuanganDebitur.FRM_FIELD_KODE_KANTOR_CABANG]+"'></i> "
                            + "Kode Kantor Cabang <i style='color:red;'>m*</i></label>"
			+ "<div class='col-sm-8'>";
			   //start comboBox
                                Vector vCdKantor =  PstContentDataKantorCabang.listWithoutOid(0,0,""+PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK]+"='"+laporan.getKodeKantorCabang()+"'","");
                                ContentDataKantorCabang KdKantor = new ContentDataKantorCabang();
                                for (int i = 0; i < vCdKantor.size(); i++) {
                                    KdKantor = (ContentDataKantorCabang) vCdKantor.get(i);
                                }

                                returnData += "<input type='hidden' name='"+FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_KODE_KANTOR_CABANG]+"' value='"+KdKantor.getKodeOjk()+"'>"
                                        + "<input type='text' name='DISPLAY_"+FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_KODE_KANTOR_CABANG]+"' value='"+KdKantor.getKodeOjk()+" "+KdKantor.getNamaKantorCabang()+"' readonly='readonly' data-required='required' class='form-control' data-type='text' data-error-message='"+FrmLaporanKeuanganDebitur.fieldError[FrmLaporanKeuanganDebitur.FRM_FIELD_KODE_KANTOR_CABANG]+"'>";
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		  + "<div class='form-group hidden'>"
                        + "<input type='hidden' name='"+FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_STATUS_PERUBAHAN_DATA]+"' value='0'>"
			+ "<label class='control-label col-sm-4'>Operasi Data<font color='red'>*</font></label>"
			+ "<div class='col-sm-8'>";
                            Vector operasiDataKey = new Vector(1,1);
                            Vector operasiDataVal = new Vector(1,1);
                            for(int i = 0; i < PstDebitur.operasiData.length; i++){
                                operasiDataKey.add(""+PstDebitur.operasiDataKey[i]);
                                operasiDataVal.add(""+PstDebitur.operasiData[i]);
                            }
                            returnData +=""
			    + ControlCombo.draw(FrmLaporanKeuanganDebitur.fieldNames[FrmLaporanKeuanganDebitur.FRM_FIELD_OPERASI_DATA], "-- Pilih --", ""+laporan.getOperasiData(), operasiDataKey, operasiDataVal, "", "form-control")
			+ "</div>"
		    + "</div>"
                    
		+ "</div>"
	    + "</div>"
	+ "</div>";
	
	
	return returnData;
    }
    
    public String drawListLapKeuDeb(int iCommand, Vector objectClass) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("NO", "200px");//1
        ctrlist.addHeader("CIF", "200px");//2
        ctrlist.addHeader("Aset", "200px");//10
        ctrlist.addHeader("Pinjaman Jangka Panjang", "200px");//10
        ctrlist.addHeader("Pendapatan Usaha Operasional", "200px");//10
        ctrlist.addHeader("Laba Rugi Periode", "200px");//10
        ctrlist.addHeader("Aksi", "200px");//10
        
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();

        int index = -1;
        int count=0;
        Vector rowx = new Vector(1, 1);
        double total=0.0;
        
        for (int i = 0; i < objectClass.size(); i++) {
            LaporanKeuanganDebitur laporan = (LaporanKeuanganDebitur) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+laporan.getAset());//3
            rowx.add(""+laporan.getCif());//4
            rowx.add(""+laporan.getPinjamanJnkPnjg());//4
            rowx.add(""+laporan.getPendapatanUsahaOpr());//4
            rowx.add(""+laporan.getLabaRugiPeriode());//4
            rowx.add("<button type='button' class='btn btn-primary btnaddgeneral' data-oid='1' data-command='1'><i class='fa fa-plus'></i>View Data</button>");//4
            
            lstData.add(rowx);
        }

        return ctrlist.drawBootstrapStrip();
    }
    
    public String searchForm(HttpServletRequest request){
        String returnData = ""
        + "<div class='row'>"
            + "<div class='col-sm-3'>"
                + "<div class='form-group'>"
                    + "<label>CIF</label>"
                    + "<input type='text' name='cif' class='form-control' id='cif'>"
                    + "<input type='hidden' name='type' id='type' value='2'>"
                + "</div>"
            + "</div>"
            + "<div class='col-sm-3'>"
                + "<div class='form-group'>"
                    + "<label>Aset</label>"
                    + "<input type='text' name='aset' class='form-control' id='aset'>"
                + "</div>"
            + "</div>"
            + "<div class='col-sm-3'>"
                + "<div class='form-group'>"
                    + "<label>Pinjaman Jangka Panjang</label>"
                    + "<input type='text' name='pinjamanjangkapanjang' class='form-control' id='pinjamanjangkapanjang'>"
                + "</div>"
            + "</div>"
             + "<div class='col-sm-3'>"
                + "<div class='form-group'>"
                    + "<label>&nbsp;</label>"
                    + "<button name='search' type='button' class='btn btn-primary form-control' id='btnsearch'><i class='fa fa-search'></i> Cari</button>"
                + "</div>"
            + "</div>"
        + "</div>"
        + "<hr>"
        + "<div class='row'>"
            + "<div class='col-sm-12' id='searchElement'>"
                + "<table class='table table-striped table-bordered'>"
                    + "<thead>"
                        + "<tr>"
                            + "<th>No.</th>"
                            + "<th>CIF</th>"
                            + "<th>Aset</th>"
                            + "<th>Pinjaman Jangka Panjang</th>"
                            + "<th>Aksi</th>"
                        + "</tr>"
                    + "</thead>"
                + "</table>"
            + "</div>"
        + "</div>";
        
        return returnData;
    }
    
    public String showListForm(HttpServletRequest request){
        String returnData = "";
        returnData+=""
        + "<div id='showListElement'>"
            + "<table class='table table-bordered table-striped'>"
                + "<thead>"
                    + "<tr>"
                        + "<th>No.</th>"
                        + "<th>CIF</th>"
                        + "<th>Aset</th>"
                        + "<th>Pinjaman Jangka Panjang</th>"
                        + "<th>Aksi</th>"
                    + "</tr>"
                + "</thead>"
            + "</table>"
        + "</div>";
        return returnData;
    }
    
    public String getSummary(HttpServletRequest request){
        String returnData = "";
        int userGroup = FRMQueryString.requestInt(request, "usergroup");
        String kodeCabang = FRMQueryString.requestString(request, "kodecabang");
        String whereClause = "";
        if(this.dataFor.equals("loadsummary")){
            whereClause = "laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+"='0'";
        }else{
            whereClause = "laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
        }
        
        if(userGroup != 4){
            whereClause += " AND laporan."+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
        }
        
        int summary = PstLaporanKeuanganDebitur.getCountJoin(whereClause);
        returnData +=""+summary;
        return returnData;
    }
    
    public String deleteItem(HttpServletRequest request){
        String returnData = "";
        CtrlLaporanKeuanganDebitur ctrlLaporanKeuanganDebitur = new CtrlLaporanKeuanganDebitur(request);
        ctrlLaporanKeuanganDebitur.action(this.iCommand, this.oid, oidDelete);
        String msg = "<i class='fa fa-info'></i> "+ctrlLaporanKeuanganDebitur.getMessage();
        returnData = msg;
        return returnData;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
