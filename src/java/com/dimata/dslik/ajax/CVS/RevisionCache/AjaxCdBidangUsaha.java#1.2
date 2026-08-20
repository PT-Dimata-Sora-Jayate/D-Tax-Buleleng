/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.ajax;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dimata.dslik.entity.contentdata.ContentDataBidangUsaha;
import com.dimata.dslik.entity.contentdata.PstContentDataBidangUsaha;
import com.dimata.dslik.form.contentdata.CtrlContentDataBidangUsaha;
import com.dimata.dslik.form.contentdata.FrmContentDataBidangUsaha;
import com.dimata.gui.jsp.ControlCombo;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author dimata005
 */
public class AjaxCdBidangUsaha extends HttpServlet {

    
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
    
    //BOOLEAN
    private boolean privUpdate = false;
    private boolean privDelete = false;
    //INT
    private int iCommand = 0;
    private int iErrCode = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, JSONException {
        
        //LONG
	this.oid = FRMQueryString.requestLong(request, "FRM_FIELD_OID");
	this.oidReturn=0;
	
	//STRING
	this.dataFor = FRMQueryString.requestString(request, "FRM_FIELD_DATA_FOR");
	this.oidDelete = FRMQueryString.requestString(request, "FRM_FIELD_OID_DELETE");
	this.approot = FRMQueryString.requestString(request, "FRM_FIELD_APPROOT");
        
	this.htmlReturn = "";
	//BOOLEAN
        this.privDelete = FRMQueryString.requestBoolean(request, "privdelete");
        this.privUpdate = FRMQueryString.requestBoolean(request, "privupdate");
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
           case Command.DELETE :
		commandDelete(request);
	    break;
		
	    case Command.DELETEALL : 
		commandDeleteAll(request);
	    break;
	    default : commandNone(request);
	}
	try{
	    
	    this.jSONObject.put("FRM_FIELD_HTML", this.htmlReturn);
	    this.jSONObject.put("FRM_FIELD_RETURN_OID", this.oidReturn);
	}catch(JSONException jSONException){
	    jSONException.printStackTrace();
	}
	
	response.getWriter().print(this.jSONObject);
        
    }
    
    public void commandNone(HttpServletRequest request){
	if(this.dataFor.equals("showform")){
	    this.htmlReturn = chanelForm(request);
	}
    }
    
    public void commandSave(HttpServletRequest request){
	CtrlContentDataBidangUsaha ccdbbu = new CtrlContentDataBidangUsaha(request);
	this.iErrCode = ccdbbu.action(this.iCommand, this.oid);
	String message = ccdbbu.getMessage();
	this.htmlReturn = "<i class='fa fa-info'></i> "+message;
    }
    
    public void commandDeleteAll(HttpServletRequest request){
	CtrlContentDataBidangUsaha ccdbbu = new CtrlContentDataBidangUsaha(request);
	this.iErrCode = ccdbbu.action(this.iCommand, this.oid);
	String message = ccdbbu.getMessage();
	this.htmlReturn = "<i class='fa fa-info'></i> "+message;
    }
    
     public void commandDelete(HttpServletRequest request){
	CtrlContentDataBidangUsaha ccdbbu = new CtrlContentDataBidangUsaha(request);
	this.iErrCode = ccdbbu.action(this.iCommand, this.oid);
	String message = ccdbbu.getMessage();
	this.htmlReturn = "<i class='fa fa-info'></i> "+message;
    }
    
    public void commandList(HttpServletRequest request, HttpServletResponse response){
	if(this.dataFor.equals("list")){
	    String[] cols = { 
                //apa saja yang dicari ketika search
                PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_NAMA_BIDANG_USAHA],
                PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_CORE_BANKING],
                PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_OJK]
            
            };
	    jSONObject = listDataTables(request, response, cols, this.dataFor, this.jSONObject);
	}
    }
    
    public JSONObject listDataTables (HttpServletRequest request, HttpServletResponse response, String[] cols, String dataFor, JSONObject result){
        this.searchTerm = FRMQueryString.requestString(request, "sSearch");
        
        String appRoot = FRMQueryString.requestString(request, "FRM_FLD_APP_ROOT");
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
        
	
        
        String whereClause = "";
        
        if(dataFor.equals("list")){
	    whereClause += " ("+PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_NAMA_BIDANG_USAHA]+" LIKE '%"+this.searchTerm+"%' "
            + "OR "+PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_CORE_BANKING]+" LIKE '%"+this.searchTerm+"%' "
            + "OR " +PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_OJK]+" like '%"+this.searchTerm+"%' )";
        }
	
        String colName = cols[col];
        int total = -1;
	
	if(dataFor.equals("list")){
	    total = PstContentDataBidangUsaha.getCount(whereClause);
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
        ContentDataBidangUsaha cdbbu = new ContentDataBidangUsaha();
	
	String whereClause = "";
        String order ="";
	
        String appRoot = FRMQueryString.requestString(request, "FRM_FLD_APP_ROOT");

        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
	     if(dataFor.equals("list")){
                 whereClause += " ("+PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_NAMA_BIDANG_USAHA]+" LIKE '%"+this.searchTerm+"%' "
            + "OR "+PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_CORE_BANKING]+" LIKE '%"+this.searchTerm+"%' "
            + "OR " +PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_OJK]+" like '%"+this.searchTerm+"%' )";
            }
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
	
        Vector listData = new Vector(1,1);
	if(datafor.equals("list")){
            listData = PstContentDataBidangUsaha.list(this.start, this.amount, whereClause, order);
	}
         
        for (int i =0 ; i<=listData.size()-1;i++){
	    JSONArray ja = new JSONArray();
	    if(datafor.equals("list")){
		cdbbu = (ContentDataBidangUsaha) listData.get(i);
		ja.put(""+(this.start+i+1));//1
		ja.put(""+cdbbu.getNamaBidangUsaha());//2
                ja.put(""+cdbbu.getKodeCoreBanking());//3
                ja.put(""+cdbbu.getKodeOjk());//4                
                
		String buttonUpdate = "";
		if(privUpdate){
		    buttonUpdate += "<button class='btn btn-warning btneditgeneral' data-oid='"+cdbbu.getOID()+"' data-for='showform' type='button'><i class='fa fa-pencil'></i> Edit</button> ";
		}
                
                if(privDelete){
		    buttonUpdate += "<button class='btn btn-danger btn-delete' data-oid='"+cdbbu.getOID()+"' data-for='delete' type='button'><i class='fa fa-trash'></i> Delete</div>";
		}
                buttonUpdate += "";
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
    
    public String chanelForm(HttpServletRequest request){
	
	//CHECK DATA
	ContentDataBidangUsaha cdbbu = new ContentDataBidangUsaha();
	if(this.oid != 0){
	    try{
		cdbbu = PstContentDataBidangUsaha.fetchExc(this.oid);
	    }catch(Exception ex){
		ex.printStackTrace();
	    }
	}
        
        String textListHeader[][] = {
            {"No", "Nama Bidang Usaha", "Kode Core Banking", "Kode OJK"},
            {"No", "Nama Bidang Usaha", "Kode Core Banking", "Kode OJK"}
        };
        
        Vector valTypeConnection = new Vector();
        Vector viewTypeConnection = new Vector();
        valTypeConnection.add("0");
        viewTypeConnection.add("Aktive");
        valTypeConnection.add("1");
        viewTypeConnection.add("Non Aktive");
        
        int SESS_LANGUAGE=0;
        
	String returnData = ""
	+ "<div class='row'>"
	    + "<div class='col-md-12'>"
                + "<input type='hidden' name='"+FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_BIDANG_USAHA_OID]+"'  id='"+FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_BIDANG_USAHA_OID]+"' class='form-control' value='"+cdbbu.getOID()+"'>"
                + "<div class='form-group'>"
		    + "<label>"+textListHeader[SESS_LANGUAGE][1]+"</label>"
		    + "<input type='text' name='"+FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_NAMA_BIDANG_USAHA]+"'  id='"+ FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_NAMA_BIDANG_USAHA]+"' class='form-control' value='"+cdbbu.getNamaBidangUsaha()+"'>"
		+ "</div>"
                + "<div class='form-group'>"
		    + "<label>"+textListHeader[SESS_LANGUAGE][2]+"</label>"
		    + "<input type='text' name='"+ FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_KODE_CORE_BANKING]+"'  id='"+ FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_KODE_CORE_BANKING]+"' class='form-control' value='"+cdbbu.getKodeCoreBanking()+"'>"
		+ "</div>"
                + "<div class='form-group'>"
		    + "<label>"+textListHeader[SESS_LANGUAGE][3]+"</label>"
		    + "<input type='text' name='"+ FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_KODE_OJK]+"'  id='"+ FrmContentDataBidangUsaha.fieldNames[FrmContentDataBidangUsaha.FRM_FIELD_KODE_OJK]+"' class='form-control' value='"+cdbbu.getKodeOjk()+"'>"
		+ "</div>"                
	    + "</div>"
	+ "</div>";
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(AjaxDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(AjaxDatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
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
