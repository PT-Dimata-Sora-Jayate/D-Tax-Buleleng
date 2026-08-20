/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.ajax;

import com.dimata.common.entity.logger.PstLogSysHistory;
import com.dimata.dslik.entity.agunan.PstAgunan;
import com.dimata.dslik.entity.contentdata.*;
import com.dimata.dslik.entity.debitur.PstDebitur;
import com.dimata.dslik.entity.kredit.Kredit;
import com.dimata.dslik.entity.kredit.PstKredit;
import com.dimata.dslik.entity.kreditjoinaccount.KreditJoinAccount;
import com.dimata.dslik.entity.kreditjoinaccount.PstKreditJoinAccount;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.form.contentdata.*;
import com.dimata.dslik.form.kreditjoinaccount.*;
import com.dimata.dslik.form.kreditjoinaccount.FrmKreditJoinAccount;
import com.dimata.gui.jsp.ControlCombo;
import com.dimata.gui.jsp.ControlList;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
public class AjaxKreditJoin extends HttpServlet {
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
    
    private long userId=0;
    private String userName="";

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
        this.cif = FRMQueryString.requestString(request, "FRM_FIELD_CIF");
        
        //BOOLEAN
        this.privAdd = FRMQueryString.requestBoolean(request, "privadd");
        this.privDelete = FRMQueryString.requestBoolean(request, "privdelete");
        this.privUpdate = FRMQueryString.requestBoolean(request, "privupdate");
	this.privView = FRMQueryString.requestBoolean(request, "privview");
        
	//INT
	this.iCommand = FRMQueryString.requestCommand(request);
	this.iErrCode = 0;
	
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
        }else if (this.dataFor.equals("showform2")){
            this.htmlReturn = showForm2(request);
        }else if(this.dataFor.equals("showlistkreditjoin")){
            this.htmlReturn = showListForm(request);
        }else if(this.dataFor.equals("loadsummary") || this.dataFor.equals("loadsummarynull")){
            this.htmlReturn = getSummary(request);
        }
    }
    
    public void commandSave(HttpServletRequest request){
	if (this.dataFor.equals("showform")) {
             //history
            this.htmlReturn = saveKreditJoin(request);
        }
    }
    
    public String saveKreditJoin(HttpServletRequest request) {
        //history
        String returnData = "";
        oid = FRMQueryString.requestLong(request, "FRM_FIELD_KREDIT_JOIN_OID");
        userId = FRMQueryString.requestLong(request, "useroid");
        userName = FRMQueryString.requestString(request, "username");
        CtrlKreditJoinAccount ctrlKreditJoinAccount = new CtrlKreditJoinAccount(request);
        ctrlKreditJoinAccount.action(iCommand, oid,userId,userName);
        returnData = ctrlKreditJoinAccount.getMessage();
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
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KREDIT_JOIN_ACNT_OID],
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF],
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING],
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]
            };
	    jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
	}else if (this.dataFor.equals("listkreditjoin") || this.dataFor.equals("listkreditjoinhome")){
            String[] cols = { 
                "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KREDIT_JOIN_ACNT_OID]+"",
                "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+"",
                "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"",
                "sk."+PstContentDataSifatKredit.fieldNames[PstContentDataSifatKredit.FLD_SIFAT_KREDIT]+"",
                "jk."+PstContentDataJenisKredit.fieldNames[PstContentDataJenisKredit.FLD_NAMA_JENIS_KREDIT]+"",
                "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_AKAD]+""
            };
            jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
        }else if(this.dataFor.equals("showlistkreditjoin")){
	    String[] cols = { 
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KREDIT_JOIN_ACNT_OID],
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF],
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING],
                PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]
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
        String noRekening = FRMQueryString.requestString(request, "norekening");
        String kodeJenisKredit = FRMQueryString.requestString(request, "kodejeniskredit");
        String status = FRMQueryString.requestString(request, "FRM_FIELD_STATUS_DATA");
        String whereClause = "";
        int userGroup = FRMQueryString.requestInt(request, "usergroup");
        String kodeCabang = FRMQueryString.requestString(request, "kodecabang");
        if(userGroup != 4){
            if(whereClause.length() > 0){
                whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }else{
                whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }
        }
        
        if(dataFor.equals("listdatasearch")){
	    if(cif.length() > 0){
                if(whereClause.length() > 0){
                    whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cif+"'";
                }else{
                    whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cif+"'";
                }
            }

            if(noRekening.length() > 0){
                if(whereClause.length() > 0){
                    whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+"='"+noRekening+"'";
                }else{
                    whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+"='"+noRekening+"'";
                }
            }

            if(kodeJenisKredit.length() > 0){
                if(whereClause.length() > 0){
                    whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+"='"+kodeJenisKredit+"'";
                }else{
                    whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+"='"+kodeJenisKredit+"'";
                }
            }
	    if(whereClause.length() > 0){
		whereClause += " AND (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
	    }else{
		whereClause += " (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
	    }
	}else if (dataFor.equals("listkreditjoin") || this.dataFor.equals("listkreditjoinhome")){
            whereClause = " 1=1";
            String cifParam = FRMQueryString.requestString(request, "FRM_FIELD_CIF");
            whereClause +=""
                + " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cifParam+"'"
                + " AND ("
                    + " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" like '%"+this.searchTerm+"%'"
                    + " OR sk."+PstContentDataSifatKredit.fieldNames[PstContentDataSifatKredit.FLD_SIFAT_KREDIT]+" like '%"+this.searchTerm+"%'"
                    + " OR jk."+PstContentDataJenisKredit.fieldNames[PstContentDataJenisKredit.FLD_NAMA_JENIS_KREDIT]+" like '%"+this.searchTerm+"%'"
                    + " OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_AKAD]+" like '%"+this.searchTerm+"%'"
                + ")";
        }else if(dataFor.equals("showlistkreditjoin")){
            if(status.equals("0")){
                if(whereClause.length() > 0){
                    whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                }else{
                    whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                }
            }else{
                if(whereClause.length() > 0){
                    whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                }else{
                    whereClause += "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                }
            }
	    if(whereClause.length() > 0){
		whereClause += " AND (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
	    }else{
		whereClause += " (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                        + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
	    }
        }
	
        String colName = cols[col];
        int total = -1;
	
	if(dataFor.equals("listdatasearch")){
	    total = PstKreditJoinAccount.getCountJoin(whereClause);
	}else if (dataFor.equals("listkreditjoin") || this.dataFor.equals("listkreditjoinhome")){
            total = PstKreditJoinAccount.getCountJoin(whereClause);
        }else if(dataFor.equals("showlistkreditjoin")){
            total = PstKreditJoinAccount.getCountJoin(whereClause);
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
        KreditJoinAccount kreditJoinAccount = new KreditJoinAccount();
	
        approot = FRMQueryString.requestString(request, "FRM_FIELD_APPROOT");
        privView = FRMQueryString.requestBoolean(request, "privview");
	String cif = FRMQueryString.requestString(request, "cif");
        String noRekening = FRMQueryString.requestString(request, "norekening");
        String kodeJenisKredit = FRMQueryString.requestString(request, "kodejeniskredit");
        String whereClause = "";
        String order ="";
        String appRoot = FRMQueryString.requestString(request, "FRM_FLD_APP_ROOT");
        String status = FRMQueryString.requestString(request, "FRM_FIELD_STATUS_DATA");
        int userGroup = FRMQueryString.requestInt(request, "usergroup");
        String kodeCabang = FRMQueryString.requestString(request, "kodecabang");
        if(userGroup != 4){
            if(whereClause.length() > 0){
                whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }else{
                whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
            }
        }
        
        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
	     
            if(dataFor.equals("listdatasearch")){
                if(cif.length() > 0){
                    if(whereClause.length() > 0){
                        whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cif+"'";
                    }else{
                        whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cif+"'";
                    }
                }

                if(noRekening.length() > 0){
                    if(whereClause.length() > 0){
                        whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+"='"+noRekening+"'";
                    }else{
                        whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+"='"+noRekening+"'";
                    }
                }

                if(kodeJenisKredit.length() > 0){
                    if(whereClause.length() > 0){
                        whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+"='"+kodeJenisKredit+"'";
                    }else{
                        whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+"='"+kodeJenisKredit+"'";
                    }
                }
                if(whereClause.length() > 0){
                    whereClause += " AND (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
                }else{
                    whereClause += " (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
                }
            }else if (dataFor.equals("listkreditjoin") || this.dataFor.equals("listkreditjoinhome")){
                whereClause = " 1=1";
                String cifParam = FRMQueryString.requestString(request, "FRM_FIELD_CIF");
                whereClause +=""
                    + " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cifParam+"'"
                    + " AND ("
                        + " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" like '%"+this.searchTerm+"%'"
                        + " OR sk."+PstContentDataSifatKredit.fieldNames[PstContentDataSifatKredit.FLD_SIFAT_KREDIT]+" like '%"+this.searchTerm+"%'"
                        + " OR jk."+PstContentDataJenisKredit.fieldNames[PstContentDataJenisKredit.FLD_NAMA_JENIS_KREDIT]+" like '%"+this.searchTerm+"%'"
                        + " OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_AKAD]+" like '%"+this.searchTerm+"%'"
                    + ")";
            }else if(dataFor.equals("showlistkreditjoin")){
                if(status.equals("0")){
                    if(whereClause.length() > 0){
                        whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                    }else{
                        whereClause += " kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+"='"+status+"'";
                    }
                }else{
                    if(whereClause.length() > 0){
                        whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                    }else{
                        whereClause += "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
                    }
                }
                if(whereClause.length() > 0){
                    whereClause += " AND (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
                }else{
                    whereClause += " (kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_NO_REKENING]+" LIKE '%"+this.searchTerm+"%' "
                            + "OR kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_JENIS]+" LIKE '%"+this.searchTerm+"%')";
                }
            }
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
	
        Vector listData = new Vector(1,1);
	if(datafor.equals("listdatasearch")){
	    listData = PstKreditJoinAccount.listJoin(this.start, this.amount,whereClause,order);
	}else if (datafor.equals("listkreditjoin") || this.dataFor.equals("listkreditjoinhome")){
            listData = PstKreditJoinAccount.listJoin(this.start, this.amount,whereClause,order);
        }else if (datafor.equals("showlistkreditjoin")){
            listData = PstKreditJoinAccount.listJoin(this.start, this.amount,whereClause,order);
        }
         
        
        
        for (int i =0 ; i<=listData.size()-1;i++){
	    JSONArray ja = new JSONArray();
            String buttonUpdate = "";
	    if(datafor.equals("listdatasearch")){
		kreditJoinAccount = (KreditJoinAccount) listData.get(i);
		ja.put(""+(this.start+i+1));
                ja.put(""+kreditJoinAccount.getCif());
                ja.put(""+kreditJoinAccount.getNoRekening());
                ja.put(""+kreditJoinAccount.getKodeJenis());
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+kreditJoinAccount.getDebiturOid()+"&type="+kreditJoinAccount.getDebiturType()+"&cif="+kreditJoinAccount.getCif()+"&activetab=AjaxKreditJoin&otheroid="+kreditJoinAccount.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
		ja.put(buttonUpdate);
		
		array.put(ja);
	    }else if (datafor.equals("listkreditjoin")){
                kreditJoinAccount = (KreditJoinAccount) listData.get(i);
                ja.put(""+(this.start+i+1));
                ja.put(""+(kreditJoinAccount.getNoRekening()));
                ja.put(""+(kreditJoinAccount.getCif()));
                ja.put(""+(kreditJoinAccount.getSifatKredit()));
                ja.put(""+(kreditJoinAccount.getJenisKredit()));
                ja.put(""+(kreditJoinAccount.getKodeAkad()));
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+kreditJoinAccount.getDebiturOid()+"&type="+kreditJoinAccount.getDebiturType()+"&cif="+kreditJoinAccount.getCif()+"&activetab=AjaxKreditJoin&otheroid="+kreditJoinAccount.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
                
                int count  = PstLogSysHistory.getCount(PstLogSysHistory.fieldNames[PstLogSysHistory.FLD_LOG_DOCUMENT_ID]+"='"+kreditJoinAccount.getOID()+"' "
                        + "AND "+PstLogSysHistory.fieldNames[PstLogSysHistory.FLD_LOG_LOGIN_NAME]+" LIKE '%Transfer%'");
                
                if(count == 0){
                    buttonUpdate += "<div class='btn btn-default'><input type='checkbox' class='deletelist' value='"+kreditJoinAccount.getOID()+"'></div>";
                }
                ja.put(buttonUpdate);
                array.put(ja);
            }else if (datafor.equals("listkreditjoinhome")){
                kreditJoinAccount = (KreditJoinAccount) listData.get(i);
                ja.put(""+(this.start+i+1));
                ja.put(""+(kreditJoinAccount.getNoRekening()));
                ja.put(""+(kreditJoinAccount.getCif()));
                ja.put(""+(kreditJoinAccount.getSifatKredit()));
                ja.put(""+(kreditJoinAccount.getJenisKredit()));
                ja.put(""+(kreditJoinAccount.getKodeAkad()));
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+kreditJoinAccount.getDebiturOid()+"&type="+kreditJoinAccount.getDebiturType()+"&cif="+kreditJoinAccount.getCif()+"&activetab=AjaxKreditJoin&otheroid="+kreditJoinAccount.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
                }
                ja.put(buttonUpdate);
                array.put(ja);
            }else if(datafor.equals("showlistkereditjoin")){
		kreditJoinAccount = (KreditJoinAccount) listData.get(i);
		ja.put(""+(this.start+i+1));
                ja.put(""+kreditJoinAccount.getCif());
                ja.put(""+kreditJoinAccount.getNoRekening());
                ja.put(""+kreditJoinAccount.getKodeJenis());
                if(privView){
                    buttonUpdate += "<a href='"+approot+"/dslik/perlengkapandata/perlengkapandata.jsp?command=8&oid="+kreditJoinAccount.getDebiturOid()+"&type="+kreditJoinAccount.getDebiturType()+"&cif="+kreditJoinAccount.getCif()+"&activetab=AjaxKreditJoin&otheroid="+kreditJoinAccount.getOID()+"' class='btn btn-warning'><i class='fa fa-pencil'></i> View</a>";
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
            String where = PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cif+"'";
            countData = PstKreditJoinAccount.getCount(where);
        }
        
        if (cif.length()==0){
            returnData = ""
            +"<div class='row'>"
                +"<div class='col-md-12'>"
                        +"<div class='box'>"
                            +"<div class='box-header'>"
                                +"<h3 class='box-title'>List Kredit Join</h3>"
                            +"</div>"
                            +"<div class=\"box-body\">"
                                //
                                + "<div id='tableKreditJoin'>"
                                    + "<table class='table table-bordered table-striped'>"
                                        + "<thead>"
                                            + "<tr>"
                                                + "<td>No</td>"                                           
                                                + "<td>No Rekening</td>"
                                                + "<td>CIF</td>"
                                                + "<td>Kode Sifat Kredit</td>"
                                                + "<td>Kode Jenis Kredit</td>"
                                                + "<td>Kode Skim/Akad Pembiayaan</td>"                                         
                                                + "<td>Aksi</td>"
                                            + "</tr>"
                                        + "</thead>"
                                    + "</table>"
                                + "</div>"
                            +"</div>"
                             +"<div class='box-header'>";
            
                                if(privAdd){
                                    returnData += "<button type='button' class='btn btn-primary btnaddgeneralkreditjoin' data-oid='0' data-for ='showform2' data-target='AjaxKreditJoin' data-command='"+Command.NONE+"'><i class='fa fa-plus'></i> Tambah Data Kredit Join </button>";
                                }
                                
                                if(privDelete){
                                    returnData += " <button type='button' class='btn btn-danger' id='delete' data-for='deleteitem' data-target='AjaxKreditJoin' data-command='"+Command.DELETEALL+"'><i class='fa fa-trash'></i> Hapus Data Kredit Join</button>";
                                }
                                
                                returnData+=""
                            +"</div>"
                        +"</div>"
                +"</div>"
            +"</div>"           
            +"<div id='kreditjoinform'></div>";
        }else{
            if (countData>0){
                returnData = ""
                +"<div class='row'>"
                    +"<div class='col-md-12'>"
                            +"<div class='box'>"
                                +"<div class='box-header'>"
                                    +"<h3 class='box-title'>List Kredit Join</h3>"
                                +"</div>"
                                +"<div class=\"box-body\">"
                                    //
                                    + "<div id='tableKreditJoin'>"
                                        + "<table class='table table-bordered table-striped'>"
                                            + "<thead>"
                                                + "<tr>"
                                                    + "<td>No</td>"                                           
                                                    + "<td>No Rekening</td>"
                                                    + "<td>CIF</td>"
                                                    + "<td>Kode Sifat Kredit</td>"
                                                    + "<td>Kode Jenis Kredit</td>"
                                                    + "<td>Kode Skim/Akad Pembiayaan</td>"                                         
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
        
        KreditJoinAccount kija = new KreditJoinAccount();
        kija.setCif(this.cif);
        String kodeCabang = FRMQueryString.requestString(request, "FRM_KODE_CABANG");
        kija.setKodeKantorCabang(kodeCabang);
        Date dNow = new Date();
        String tglAkadAwal = "";
        String tglAkadAkhir= "";
        String tglAwalKredit = "";
        String tglMulai = "";
        String tglJatuhTempo = "";
        String tglMacet = "";
        String tglRestrukturisasiAwal = "";
        String tglRestrukturisasiAkhir = "";
        String tglKondisi = "";
        String openDate = "";
        long oidPeriodeWrite = 0;
        if (oid != 0) {
            try {
                kija = PstKreditJoinAccount.fetchExc(oid);
            } catch (Exception e) {
                String returnData = "alert('Terjadi Kesalahan "+e.getStackTrace()+"')";
                e.printStackTrace();
            }
            if (kija.getTglAkadAwal()==null){
                tglAkadAwal = "";
            }else{
                tglAkadAwal = Formater.formatDate(kija.getTglAkadAwal(), "yyyy-MM-dd");
            }
            if (kija.getTglAkadAkhir()==null){
                tglAkadAkhir = "";
            }else{
                tglAkadAkhir = Formater.formatDate(kija.getTglAkadAkhir(),"yyyy-MM-dd");
            }
            if (kija.getTglAwalKredit()==null){
                tglAwalKredit = "";
            }else{
                tglAwalKredit = Formater.formatDate(kija.getTglAwalKredit(), "yyyy-MM-dd");
            }
            if (kija.getTglMulai()==null){
                tglMulai = "";
            }else{
                tglMulai = Formater.formatDate(kija.getTglMulai(), "yyyy-MM-dd");
            }
            
            if (kija.getTglJatuhTempo()==null){
                tglJatuhTempo = "";
            }else{
                tglJatuhTempo = Formater.formatDate(kija.getTglJatuhTempo(), "yyyy-MM-dd");
            }
            
            if (kija.getTglMacet()==null){
                tglMacet = "";
            }else{
                tglMacet = Formater.formatDate(kija.getTglMacet(), "yyy-MM-dd");
            }
            if (kija.getTglRestrukturisasiAwal()==null){
                tglRestrukturisasiAwal = "";
            }else{
                tglRestrukturisasiAwal = Formater.formatDate(kija.getTglRestrukturisasiAwal(), "yyyy-MM-dd");
            }
            if (kija.getTglRestruktirisasiAkhir()==null){
                tglRestrukturisasiAkhir = "";
            }else{
                tglRestrukturisasiAkhir = Formater.formatDate(kija.getTglRestruktirisasiAkhir(), "yyyy-MM-dd");
            }
            if (kija.getTglKondisi()==null){
                tglKondisi = "";
            }else{
                tglKondisi = Formater.formatDate(kija.getTglKondisi(), "yyyy-MM-dd");
            }
            if (kija.getOpenDate()==null){
                openDate = "";
            }else{
                openDate = Formater.formatDate(kija.getOpenDate(), "yyyy-MM-dd");
            }
            
            oidPeriodeWrite = kija.getPeriodeId();
        }else{
            Vector listPeriode = PstPeriode.list(0, 1, " "+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'", "");
            Periode entPeriode = (Periode) listPeriode.get(0);
            oidPeriodeWrite = entPeriode.getOID();
        }
        
        //tampilkan listAgunan berdasarkan cif
        Vector listKija = new Vector();
        if(!cif.equals("")){
                String where = PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_CIF]+"='"+cif+"'";
                listKija = PstKreditJoinAccount.list(0,0, ""+where, "");
        }
        
	String returnData = ""
        + "<input type='hidden' value='"+oidPeriodeWrite+"' name ='FRM_FIELD_PERIODE_ID' id='oidPeriode'>"
                 
	+ "<div class='row'>"
	    + "<div class='col-md-6'>"
		+ "<div class='form-horizontal' style='padding:10px;background:#fff;border:5px solid #f1f1f1;'>"
		    + "<h4>View Kredit Join</h4>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_NO_REKENING]+"'></i> "
			+ "No. Rekening <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
                            + "<input type='hidden' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_STATUS_PERUBAHAN_DATA] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_STATUS_PERUBAHAN_DATA] +"' value='0' >";
                            Vector kreditKey = new Vector(1,1);
                            Vector kreditVal = new Vector(1,1);
                            Vector listKredit = PstKredit.list(0, 0, ""+PstKredit.fieldNames[PstKredit.FLD_CIF]+"='"+kija.getCif()+"' "
                                    + "AND "+PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+"='"+kija.getKodeKantorCabang()+"'", "");
                            
                            if(listKredit.size() > 0){
                                for(int i = 0; i < listKredit.size(); i++){
                                    Kredit kredit = (Kredit) listKredit.get(i);
                                    kreditKey.add(""+kredit.getNoRekening());
                                    kreditVal.add(""+kredit.getNoRekening());
                                }
                            }
                            returnData+=""
			    + ControlCombo.draw(FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NO_REKENING], "-- Pilih --", kija.getNoRekening(), kreditKey, kreditVal, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_NO_REKENING]+"' data-type='text'", "form-control")
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_CIF]+"'></i> "
			+ "CIF <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_CIF] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_CIF] +"' value='"+kija.getCif()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_CIF]+"' data-type='text' data-number='true' data-alpha='true' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_SQUENCE_DEBJOIN]+"'></i> "
			+ "Squence Debitur Anggota Join Account <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_SQUENCE_DEBJOIN] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_SQUENCE_DEBJOIN] +"' value='"+kija.getSquenceDebJoin()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_SQUENCE_DEBJOIN]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_SIFAT]+"'></i> "
			+ "Kode Sifat Kredit <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			    //start comboBox
			    Vector vCdSifat =  PstContentDataSifatKredit.listWithoutOid(0,0,"","");
                            Vector valueCdSifat = new Vector();
                            Vector keyCdSifat = new Vector();
                            valueCdSifat.add("");
                            keyCdSifat.add("-- Pilih --");
                            for (int i = 0; i < vCdSifat.size(); i++) {
                                ContentDataSifatKredit kdSifat = (ContentDataSifatKredit) vCdSifat.get(i);
                                valueCdSifat.add(String.valueOf(kdSifat.getKodeOjk()));
                                keyCdSifat.add(""+kdSifat.getSifatKredit());
                            }
                          
                            returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_SIFAT], null, ""+kija.getKodeSifat(), valueCdSifat, keyCdSifat, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_SIFAT]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                            returnData += "</div>"
                            //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_JENIS]+"'></i> "
			+ "Kode Jenis Kredit <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			   //start comboBox
			    Vector vCdJenis =  PstContentDataJenisKredit.listtanpaoid(0,0,"","");
                            Vector valueCdJenis = new Vector();
                            Vector keyCdJenis = new Vector();
                            valueCdJenis.add("");
                            keyCdJenis.add("-- Pilih --");
                            for (int i = 0; i < vCdJenis.size(); i++) {
                                ContentDataJenisKredit kdJenis = (ContentDataJenisKredit) vCdJenis.get(i);
                                valueCdJenis.add(String.valueOf(kdJenis.getKodeOjk()));
                                keyCdJenis.add(""+kdJenis.getNamaJenisKredit());
                            }
                          
                            returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_JENIS], null, ""+kija.getKodeJenis(), valueCdJenis, keyCdJenis, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_JENIS]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                            returnData += "</div>"
                            //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_AKAD]+"'></i> "
			+ "Kode Skim/Akad Pembiayaan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			    //start comboBox
			    Vector vCdSkim =  PstContentDataSkimAkadPembiayaan.listWithoutOid(0,0,"","");
                            Vector valueCdSkim = new Vector();
                            Vector keyCdSkim = new Vector();
                            valueCdSkim.add("");
                            keyCdSkim.add("-- Pilih --");
                            for (int i = 0; i < vCdSkim.size(); i++) {
                                ContentDataSkimAkadPembiayaan kdSkim = (ContentDataSkimAkadPembiayaan) vCdSkim.get(i);
                                valueCdSkim.add(String.valueOf(kdSkim.getKodeOjk()));
                                keyCdSkim.add(""+kdSkim.getNamaAkadPembiayaan());
                            }
                          
                            returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_AKAD], null, ""+kija.getKodeAkad(), valueCdSkim, keyCdSkim, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_AKAD]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                            returnData += "</div>"
                            //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AWAL]+"'></i> "
			+ "No. Akad Awal <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AWAL] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AWAL] +"' value='"+kija.getNoAkadAwal()+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AWAL]+"' data-type='text' data-number='true' data-alpha='true' data-special=\" _/()'.-\">"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AWAL]+"'></i> "
			+ "Tanggal Akad Awal <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AWAL] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AWAL] +"' value='"+tglAkadAwal+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AWAL]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AKHIR]+"'></i> "
			+ "No. Akad Akhir <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AKHIR] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AKHIR] +"' value='"+kija.getNoAkadAkhir()+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_NO_AKAD_AKHIR]+"' data-type='text' data-number='true' data-alpha='true' data-special=\" _/()'.-\">"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AKHIR]+"'></i> "
			+ "Tanggal Akad Akhir <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AKHIR] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AKHIR] +"' value='"+tglAkadAkhir+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_AKAD_AKHIR]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_BARU_PERPANJANGAN]+"'></i> "
			+ "Baru Perpanjangan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_BARU_PERPANJANGAN] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_BARU_PERPANJANGAN] +"' value='"+kija.getBaruPerpanjangan()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_BARU_PERPANJANGAN]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_AWAL_KREDIT]+"'></i> "
			+ "Tanggal Awal Kredit <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_AWAL_KREDIT] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_AWAL_KREDIT] +"' value='"+tglAwalKredit+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_AWAL_KREDIT]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_MULAI]+"'></i> "
			+ "Tanggal Mulai <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_MULAI] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_MULAI] +"' value='"+tglMulai+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_MULAI]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_JATUH_TEMPO]+"'></i> "
			+ "Tanggal Jatuh Tempo <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_JATUH_TEMPO] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_JATUH_TEMPO] +"' value='"+tglJatuhTempo+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_JATUH_TEMPO]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_KAT_DEB]+"'></i> "
			+ "Kode Kategori Debitur <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			    //start comboBox
			    Vector vCdKatDeb =  PstContentDataKategoriDebitur.listWithoutOid(0,0,"","");
                            Vector valueCdKatDeb = new Vector();
                            Vector keyCdKatDeb = new Vector();
                            valueCdKatDeb.add("");
                            keyCdKatDeb.add("-- Pilih --");
                            for (int i = 0; i < vCdKatDeb.size(); i++) {
                                ContentDataKategoriDebitur kdKatDeb = (ContentDataKategoriDebitur) vCdKatDeb.get(i);
                                valueCdKatDeb.add(String.valueOf(kdKatDeb.getKodeOjk()));
                                keyCdKatDeb.add(""+kdKatDeb.getNamaKategoriDebitur());
                            }
                          
                            returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_KAT_DEB], null, ""+kija.getKodeKatDeb(), valueCdKatDeb, keyCdKatDeb, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_KAT_DEB]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                            returnData += "</div>"
                            //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_JENIS_PENGGUNAAN]+"'></i> "
			+ "Kode Jenis Pengunaan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			    //start comboBox
			    Vector vCdJenisPenggunaan =  PstContentDataJenisPenggunaan.listTanpaOid(0,0,"","");
                            Vector valueCdJenisPenggunaan = new Vector();
                            Vector keyCdJenisPenggunaan = new Vector();
                            valueCdJenisPenggunaan.add("");
                            keyCdJenisPenggunaan.add("-- Pilih --");
                            for (int i = 0; i < vCdJenisPenggunaan.size(); i++) {
                                ContentDataJenisPenggunaan kdJenisPenggunaan = (ContentDataJenisPenggunaan) vCdJenisPenggunaan.get(i);
                                valueCdJenisPenggunaan.add(String.valueOf(kdJenisPenggunaan.getKodeOjk()));
                                keyCdJenisPenggunaan.add(""+kdJenisPenggunaan.getJenisPenggunaan());
                            }
                          
                            returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_JENIS_PENGGUNAAN], null, ""+kija.getKodeJenisPenggunaan(), valueCdJenisPenggunaan, keyCdJenisPenggunaan, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_JENIS_PENGGUNAAN]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                            returnData += "</div>"
                            //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_ORIENTASI_PENGGUNAAN]+"'></i> "
			+ "Kode Orientasi Penggunaan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdOrientasi =  PstContentDataOrientasiPenggunaan.listWithoutOid(0,0,"","");
                                Vector valueCdOrientasi = new Vector();
                                Vector keyCdOrientasi = new Vector();
                                valueCdOrientasi.add("");
                                keyCdOrientasi.add("-- Pilih --");
                                for (int i = 0; i < vCdOrientasi.size(); i++) {
                                    ContentDataOrientasiPenggunaan KdOrientasi = (ContentDataOrientasiPenggunaan) vCdOrientasi.get(i);
                                    valueCdOrientasi.add(String.valueOf(KdOrientasi.getKodeOjk()));
                                    keyCdOrientasi.add(""+KdOrientasi.getNamaOrientasiPenggunaan());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_ORIENTASI_PENGGUNAAN], null, ""+kija.getKodeOrientasiPenggunaan(), valueCdOrientasi, keyCdOrientasi, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_ORIENTASI_PENGGUNAAN]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_SEKTOR_EKONOMI]+"'></i> "
			+ "Kode Sektor Ekonomi <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdSektor =  PstContentDataSektorEkonomi.listWithoutOid(0,0,"","");
                                Vector valueCdSektor = new Vector();
                                Vector keyCdSektor = new Vector();
                                valueCdSektor.add("");
                                keyCdSektor.add("-- Pilih --");
                                for (int i = 0; i < vCdSektor.size(); i++) {
                                    ContentDataSektorEkonomi KdSektorEkonomi = (ContentDataSektorEkonomi) vCdSektor.get(i);
                                    valueCdSektor.add(String.valueOf(KdSektorEkonomi.getKodeOjk()));
                                    keyCdSektor.add(""+KdSektorEkonomi.getNamaSektorEkonomi());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_SEKTOR_EKONOMI], null, ""+kija.getKodeSektorEkonomi(), valueCdSektor, keyCdSektor, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_SEKTOR_EKONOMI]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_KAB]+"'></i> "
			+ "Kode Kab/Kota (DATI 2) Lokasi Proyek/Penggunaan Kredit <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			   //start comboBox
                                Vector vCdKab =  PstContentDataKabupatenKota.listWithoutOid(0,0,"","");
                                Vector valueCdKab = new Vector();
                                Vector keyCdKab = new Vector();
                                valueCdKab.add("");
                                keyCdKab.add("-- Pilih --");
                                for (int i = 0; i < vCdKab.size(); i++) {
                                    ContentDataKabupatenKota KdKab = (ContentDataKabupatenKota) vCdKab.get(i);
                                    valueCdKab.add(String.valueOf(KdKab.getKodeOjk()));
                                    keyCdKab.add(""+KdKab.getNamaKabupatenKota());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_KAB], null, ""+kija.getKodeKab(), valueCdKab, keyCdKab, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_KAB]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_NILAI_PROYEK]+"'></i> "
			+ "Nilai Proyek <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NILAI_PROYEK] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NILAI_PROYEK] +"' value='"+Formater.formatNumber(kija.getNilaiProyek(),"###,###,##0")+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_NILAI_PROYEK]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_VALUTA]+"'></i> "
			+ "Kode Valuta <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdValuta =  PstContentDataKodeValuta.listWithoutOid(0,0,"","");
                                Vector valueCdValuta = new Vector();
                                Vector keyCdValuta = new Vector();
                                valueCdValuta.add("");
                                keyCdValuta.add("-- Pilih --");
                                for (int i = 0; i < vCdValuta.size(); i++) {
                                    ContentDataKodeValuta KdValuta = (ContentDataKodeValuta) vCdValuta.get(i);
                                    valueCdValuta.add(String.valueOf(KdValuta.getKodeOjk()));
                                    keyCdValuta.add(""+KdValuta.getNamaValuta());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_VALUTA], null, ""+kija.getKodeValuta(), valueCdValuta, keyCdValuta, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_VALUTA]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_PROSENTASE_BUNGA]+"'></i> "
			+ "Prosentase Suku Bunga/Imbalan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_PROSENTASE_BUNGA] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_PROSENTASE_BUNGA] +"' value='"+kija.getProsentaseBunga()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_PROSENTASE_BUNGA]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_JENIS_BUNGA]+"'></i> "
			+ "Jenis Suku Bunga/Imbalan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                                Vector listSukuBunga = PstContentDataSukuBunga.listWithoutOid(0, 0, "", "");
                                Vector sukuBungaKey = new Vector(1,1);
                                Vector sukuBungaVal = new Vector(1,1);
                                if(listSukuBunga.size() > 0){
                                    for(int i = 0; i < listSukuBunga.size(); i++){
                                        ContentDataSukuBunga contentDataSukuBunga = (ContentDataSukuBunga) listSukuBunga.get(i);
                                        sukuBungaKey.add(""+contentDataSukuBunga.getKodeOjk());
                                        sukuBungaVal.add(""+contentDataSukuBunga.getNamaSukuBunga());
                                    }
                                }
                                returnData+=""
			    + ControlCombo.draw(FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_JENIS_BUNGA], "-- Pilih --", ""+kija.getJenisBunga(), sukuBungaKey, sukuBungaVal, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_JENIS_BUNGA]+"' data-type='text'", "form-control")
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KREDIT_PROGRAM_PEMERINTAH]+"'></i> "
			+ "Kredit Program Pemerintah <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                            Vector listProgramPemerintah = PstContentDataKodeProgramPemerintah.listtanpaoid(0, 0, "", "");
                            Vector programPemerintahKey = new Vector(1,1);
                            Vector programPemerintahVal = new Vector(1,1);
                            if(listProgramPemerintah.size() > 0){
                                for(int i = 0; i < listProgramPemerintah.size(); i++){
                                    ContentDataKodeProgramPemerintah contentDataKodeProgramPemerintah = (ContentDataKodeProgramPemerintah) listProgramPemerintah.get(i);
                                    programPemerintahKey.add(""+contentDataKodeProgramPemerintah.getKodeOjk());
                                    programPemerintahVal.add(""+contentDataKodeProgramPemerintah.getNamaProgramPemerintah());
                                }
                            }
                                    
                            returnData+=""
			    + ControlCombo.draw(FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KREDIT_PROGRAM_PEMERINTAH], "-- Pilih --", ""+kija.getKreditPrgPemerintah(), programPemerintahKey, programPemerintahVal, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KREDIT_PROGRAM_PEMERINTAH]+"' data-type='text'", "form-control")
			+ "</div>"
		    + "</div>"
		+ "</div>"
	    + "</div>"
	    + "<div class='col-md-6'>"
		+ "<div class='form-horizontal' style='padding:10px;background:#fff;border:5px solid #f1f1f1;'>"
		    + "<h4>&nbsp;</h4>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TAKEOVER]+"'></i> "
			+ "Takeover Dari <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdTakeOver =  PstContentDataTakeover.listWithoutOid(0,0,"","");
                                Vector valueCdTakeOver = new Vector();
                                Vector keyCdTakeOver = new Vector();
                                valueCdTakeOver.add("");
                                keyCdTakeOver.add("-- Pilih --");
                                for (int i = 0; i < vCdTakeOver.size(); i++) {
                                    ContentDataTakeover KdTakeover = (ContentDataTakeover) vCdTakeOver.get(i);
                                    valueCdTakeOver.add(String.valueOf(KdTakeover.getKodeOjk()));
                                    keyCdTakeOver.add(""+KdTakeover.getNamaTakeover());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TAKEOVER], null, ""+kija.getTakeover(), valueCdTakeOver, keyCdTakeOver, " onchange=\"javascript:changeFunc();\" data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TAKEOVER]+"' data-type='text' ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_SUMBER_DANA]+"'></i> "
			+ "Sumber Dana <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                            Vector listSumberDana = PstContentDataSumberDanaKredit.listWithoutOid(0, 0, "", "");
                            Vector sumberDanaKey = new Vector(1,1);
                            Vector sumberDanaVal = new Vector(1,1);
                            if(listSumberDana.size() > 0){
                                for(int i = 0; i < listSumberDana.size(); i++){
                                    ContentDataSumberDanaKredit contentDataSumberDanaKredit = (ContentDataSumberDanaKredit) listSumberDana.get(i);
                                    sumberDanaKey.add(""+contentDataSumberDanaKredit.getKodeOjk());
                                    sumberDanaVal.add(""+contentDataSumberDanaKredit.getSumberDanaKredit());
                                }
                            }
                            returnData +=""
			    + ControlCombo.draw(FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_SUMBER_DANA], "-- Pilih --", ""+kija.getSumberDana(), sumberDanaKey, sumberDanaVal, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_SUMBER_DANA]+"' data-type='text'", "form-control")
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_PLAFON_AWAL]+"'></i> "
			+ "Plafon Awal <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_PLAFON_AWAL] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_PLAFON_AWAL] +"' value='"+Formater.formatNumber(kija.getPlafonAwal(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_PLAFON_AWAL]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_PLAFON]+"'></i> "
			+ "Plafon <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_PLAFON] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_PLAFON] +"' value='"+Formater.formatNumber(kija.getPlafon(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_PLAFON]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_REALISASI]+"'></i> "
			+ "Realisasi/Pencairan Bulan Berjalan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_REALISASI] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_REALISASI] +"' value='"+Formater.formatNumber(kija.getRealisasi(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_REALISASI]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_DENDA]+"'></i> "
			+ "Denda <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_DENDA] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_DENDA] +"' value='"+Formater.formatNumber( kija.getDenda(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_DENDA]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_BAKI_DEBET]+"'></i> "
			+ "Baki Debet <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_BAKI_DEBET] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_BAKI_DEBET] +"' value='"+Formater.formatNumber(kija.getBakiDebet(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_BAKI_DEBET]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_NILAI_UANG_ASAL]+"'></i> "
			+ "Nilai Dalam Mata Uang Asal <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NILAI_UANG_ASAL] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_NILAI_UANG_ASAL] +"' value='"+Formater.formatNumber(kija.getNilaiUangAsal(),"###,###,##0")+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_NILAI_UANG_ASAL]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_KOLEKTIBILITAS]+"'></i> "
			+ "Kode Kolektibilitas <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdKolektibilitas =  PstContentDataKolektibilitas.listWitoutOid(0,0,"","");
                                Vector valueCdKolektibilitas = new Vector();
                                Vector keyCdKolektibilitas = new Vector();
                                valueCdKolektibilitas.add("");
                                keyCdKolektibilitas.add("-- Pilih --");
                                for (int i = 0; i < vCdKolektibilitas.size(); i++) {
                                    ContentDataKolektibilitas KdKolektibilitas = (ContentDataKolektibilitas) vCdKolektibilitas.get(i);
                                    valueCdKolektibilitas.add(String.valueOf(KdKolektibilitas.getKodeOjk()));
                                    keyCdKolektibilitas.add(""+KdKolektibilitas.getNamaKolektibilitas());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_KOLEKTIBILITAS], null, ""+kija.getKodeKolektibilitas(), valueCdKolektibilitas, keyCdKolektibilitas, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_KOLEKTIBILITAS]+"' data-type='text' onchange=\"javascript:changeFunc();\" ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_MACET]+"'></i> "
			+ "Tanggal Macet <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_MACET] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_MACET] +"' value='"+tglMacet+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_MACET]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_SEBAB_MACET]+"'></i> "
			+ "Kode Sebab Macet <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdMacet =  PstContentDataSebabMacet.listWithoutOid(0,0,"","");
                                Vector valueCdMacet = new Vector();
                                Vector keyCdMacet = new Vector();
                                valueCdMacet.add("");
                                keyCdMacet.add("-- Pilih --");
                                for (int i = 0; i < vCdMacet.size(); i++) {
                                    ContentDataSebabMacet KdMacet = (ContentDataSebabMacet) vCdMacet.get(i);
                                    valueCdMacet.add(String.valueOf(KdMacet.getKodeOjk()));
                                    keyCdMacet.add(""+KdMacet.getSebabMacet());
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_SEBAB_MACET], null, ""+kija.getKodeSebabMacet(), valueCdMacet, keyCdMacet, "onchange=\"javascript:changeFunc();\" data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_SEBAB_MACET]+"' data-type='text' ", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_POKOK]+"'></i> "
			+ "Tunggakan Pokok <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_POKOK] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_POKOK] +"' value='"+Formater.formatNumber(kija.getTunggakanPokok(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_POKOK]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_BUNGA]+"'></i> "
			+ "Tunggakan Bunga <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control numeric' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_BUNGA] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_BUNGA] +"' value='"+Formater.formatNumber(kija.getTunggakanBunga(),"###,###,##0")+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TUNGGAKAN_BUNGA]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_JML_HARI_TUNGGAKAN]+"'></i> "
			+ "Jumlah Hari Tunggakan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_JML_HARI_TUNGGAKAN] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_JML_HARI_TUNGGAKAN] +"' value='"+kija.getJmlHariTunggakan()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_JML_HARI_TUNGGAKAN]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_TUNGGAKAN]+"'></i> "
			+ "Frekuensi Tunggakan <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_TUNGGAKAN] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_TUNGGAKAN] +"' value='"+kija.getFrekuensiTunggakan()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_TUNGGAKAN]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_RESTRUKTURISASI]+"'></i> "
			+ "Frekuensi Restrukturisasi <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_RESTRUKTURISASI] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_RESTRUKTURISASI] +"' value='"+kija.getFrekuensiRestrukturisasi()+"' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_FREKUENSI_RESTRUKTURISASI]+"' data-type='text' data-number='true' data-alpha='false' data-special=''>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTURISASI_AWAL]+"'></i> "
			+ "Tanggal Restrukturisasi Awal <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTURISASI_AWAL] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTURISASI_AWAL] +"' value='"+tglRestrukturisasiAwal+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTURISASI_AWAL]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTIRISASI_AKHIR]+"'></i> "
			+ "Tanggal Restrukturisasi Akhir <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTIRISASI_AKHIR] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTIRISASI_AKHIR] +"' value='"+tglRestrukturisasiAkhir+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_RESTRUKTIRISASI_AKHIR]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_CARA]+"'></i> "
			+ "Kode Cara Restrukturisasi <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>";
                            Vector vCdCara =  PstContentDataCaraRestrukturisasi.listWitoutOid(0,0,"","");
                            Vector valueCdCara = new Vector();
                            Vector keyCdCara = new Vector();
                            valueCdCara.add("");
                            keyCdCara.add("-- Pilih --");
                            for (int i = 0; i < vCdCara.size(); i++) {
                                ContentDataCaraRestrukturisasi KdCara = (ContentDataCaraRestrukturisasi) vCdCara.get(i);
                                valueCdCara.add(String.valueOf(KdCara.getKodeOjk()));
                                keyCdCara.add(""+KdCara.getCaraRestrukturisasi());
                            }
			    returnData += ""
                            + ControlCombo.draw(FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_CARA], null, ""+kija.getKodeCara(), valueCdCara, keyCdCara, " data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_CARA]+"' data-type='text' ", "form-control")
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODE_KONDISI]+"'></i> "
			+ "Kode Kondisi <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
			    //start comboBox
                                Vector listKondisi = PstContentDataKondisi.listTanpaOid(0, 0, "", "");
                                Vector kondisiKey = new Vector(1,1);
                                Vector kondisiVal = new Vector(1,1);
                                if(listKondisi.size() > 0){
                                    for(int i = 0; i < listKondisi.size(); i++){
                                        ContentDataKondisi contentDataKondisi = (ContentDataKondisi) listKondisi.get(i);
                                        kondisiKey.add(""+contentDataKondisi.getKodeOjk());
                                        kondisiVal.add(""+contentDataKondisi.getNamaKondisi());
                                    }
                                }

                                returnData += ControlCombo.draw(""+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODE_KONDISI], "-- Pilih --", ""+kija.getKodeKondisi(), kondisiKey, kondisiVal, "data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODE_KONDISI]+"' data-type='text'", "form-control");
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_TGL_KONDISI]+"'></i> "
			+ "Tanggal Kondisi <i style='color:red'>c*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<div class='input-group'>"
				+ "<input type='text' class='form-control datepicker' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_KONDISI] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_TGL_KONDISI] +"' value='"+tglKondisi+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_TGL_KONDISI]+"' data-type='text'>"
				+ "<div class='input-group-addon'>"
				    + "<i class='fa fa-calendar'></i>"
				+ "</div>"
			    + "</div>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KETERANGAN]+"'></i> "
			+ "Keterangan <i style='color:red'>o*</i></label>"
                        + "<div class='col-sm-8'>"
			    + "<input type='text' class='form-control' name='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KETERANGAN] +"' id='"+ FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KETERANGAN] +"' value='"+kija.getKeterangan()+"' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KETERANGAN]+"' data-type='text'>"
			+ "</div>"
		    + "</div>"
		    + "<div class='form-group'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_KODEKANTOR_CABANG]+"'></i> "
			+ "Kode Kantor Cabang <i style='color:red'>m*</i></label>"
                        + "<div class='col-sm-8'>";
                                //start comboBox
                                Vector vCdKantor =  PstContentDataKantorCabang.list(0,0,""+PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK]+"='"+kija.getKodeKantorCabang()+"'","");
                                ContentDataKantorCabang KdKantor =  new ContentDataKantorCabang();
                                for (int i = 0; i < vCdKantor.size(); i++) {
                                    KdKantor = (ContentDataKantorCabang) vCdKantor.get(i);
                                }

                                returnData +="<input type='hidden' name='"+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODEKANTOR_CABANG]+"' value='"+kija.getKodeKantorCabang()+"'>"
                                        + "<input type='text' readonly='readonly' data-required='required' data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_KODEKANTOR_CABANG]+"' data-type='text' value='"+KdKantor.getKodeOjk()+" "+KdKantor.getNamaKantorCabang()+"' name='DISPLAY_"+FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_KODEKANTOR_CABANG]+"' class='form-control'>";
                                returnData += "</div>"
                                //end comboBox
		    + "</div>"
		    + "<div class='form-group hidden'>"
			+ "<label class='control-label col-sm-4'>"
                        + "<i class='fa fa-question-circle' data-toggle='tooltip' data-placement='right' title='"+FrmKreditJoinAccount.fieldQuestion[FrmKreditJoinAccount.FRM_FIELD_OPERASI_DATA]+"'></i> "
			+ "Operasi Data<font color='red'>*</font></label>"
                        + "<div class='col-sm-8'>";
                            Vector operasiDataKey = new Vector(1,1);
                            Vector operasiDataVal = new Vector(1,1);
                            for(int i = 0; i < PstDebitur.operasiData.length; i++){
                                operasiDataKey.add(""+PstDebitur.operasiDataKey[i]);
                                operasiDataVal.add(""+PstDebitur.operasiData[i]);
                            }
                            returnData+=""
			    + ControlCombo.draw(FrmKreditJoinAccount.fieldNames[FrmKreditJoinAccount.FRM_FIELD_OPERASI_DATA], "-- Pilih --", ""+kija.getOperasiData(), operasiDataKey, operasiDataVal, " data-error-message='"+FrmKreditJoinAccount.fieldError[FrmKreditJoinAccount.FRM_FIELD_OPERASI_DATA]+"' data-type='text' ", "form-control")
			+ "</div>"
		    + "</div>"
		+ "</div>"
	    + "</div>"
	+ "</div>";
	
	
	return returnData;
    }
    
     public String drawListKija(int iCommand, Vector objectClass) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("NO", "200px");//1        
        ctrlist.addHeader("No Rekening", "200px");//2
        ctrlist.addHeader("CIF", "200px");//10
        ctrlist.addHeader("Kode Sifat Kredit", "200px");//10
        ctrlist.addHeader("Kode Jenis Kredit", "200px");//10
        ctrlist.addHeader("Kode Skim/Akad Pembiayaan", "200px");//10
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
            KreditJoinAccount kija = (KreditJoinAccount) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+kija.getNoRekening());//3
            rowx.add(""+kija.getCif());//4
            rowx.add(""+kija.getKodeSifat());//4
            rowx.add(""+kija.getKodeJenis());//4
            rowx.add(""+kija.getKodeAkad());//4
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
                    + "<label>No Rekening</label>"
                    + "<input type='text' name='norekening' class='form-control' id='norekening'>"
                + "</div>"
            + "</div>"
            + "<div class='col-sm-3'>"
                + "<div class='form-group'>"
                    + "<label>Kode Jenis Kredit</label>"
                    + "<input type='text' name='kodejeniskredit' class='form-control' id='kodejeniskredit'>"
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
                            + "<th>No Rekening</th>"
                            + "<th>Kode Jenis Kredit</th>"
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
                        + "<th>No Rekening</th>"
                        + "<th>Kode Jenis Kredit</th>"
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
            whereClause = "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+"='0'";
        }else{
            whereClause = "kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_STATUS_PERUBAHAN_DATA]+" IS NULL";
        }
        
        if(userGroup != 4){
            whereClause += " AND kj."+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_KODE_KANTOR_CABANG]+"='"+kodeCabang+"'";
        }
        
        int summary = PstKreditJoinAccount.getCountJoin(whereClause);
        returnData +=""+summary;
        return returnData;
    }
    
    public String deleteItem(HttpServletRequest request){
        String returnData = "";
        CtrlKreditJoinAccount ctrlKreditJoinAccount = new CtrlKreditJoinAccount(request);
        ctrlKreditJoinAccount.action(this.iCommand, this.oid, oidDelete);
        String msg = "<i class='fa fa-info'></i> "+ctrlKreditJoinAccount.getMessage();
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
