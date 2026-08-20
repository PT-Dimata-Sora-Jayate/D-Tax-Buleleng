/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.biadmin.AppGroup;
import com.dimata.dtaxintegration.entity.biadmin.AppObjInfo;
import com.dimata.dtaxintegration.entity.biadmin.AppPriv;
import com.dimata.dtaxintegration.entity.biadmin.AppPrivilegeObj;
import com.dimata.dtaxintegration.entity.biadmin.PstAppGroup;
import com.dimata.dtaxintegration.entity.biadmin.PstAppPriv;
import com.dimata.dtaxintegration.entity.biadmin.PstAppPrivilegeObj;
import com.dimata.dtaxintegration.entity.biadmin.PstGroupPriv;
import com.dimata.dtaxintegration.form.biadmin.CtrlAppGroup;
import com.dimata.dtaxintegration.form.biadmin.CtrlAppPriv;
import com.dimata.dtaxintegration.form.biadmin.CtrlAppPrivilegeObj;
import com.dimata.dtaxintegration.form.biadmin.FrmAppGroup;
import com.dimata.dtaxintegration.form.biadmin.FrmAppPrivilegeObj;
import com.dimata.dtaxintegration.session.biadmin.SessAppGroup;
import com.dimata.gui.jsp.ControlCheckBox;
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
import org.json.JSONObject;

/**
 *
 * @author Ardiadi
 */
public class PrivilegeHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static final String listTextTableHeader[][] = {
	{"No.","Modul","Kelompok 1","Kelompok 2","Hak Akses"},
	{"No.","Modul","Group 1","Group 2", "Privilege"}
    };
    
    public static final String listTextTableHeaderPriv[][] = {
	{"No.","Nama","Deskripsi","Tanggal Pembuatan"},
	{"No.","Name","Description","Creation Date"}
    };
    
    
    public static final String listTextGlobal[][] = {
	{"","Hak Akses","Daftar","Edit","Nama Hak Akses","Deskripsi","Hak Akses Modul",
	 "","Tidak Ada Hak Akses","Tambah","Ubah"},
	{"User Management","Privilege","List","Edit","Privilege Name","Description","Module Access",
	 "Module Access List","No Privilege Available","Add","Edit"}
    };
    
    public static final String listTextGlobalGroup[][] = {
	    {"Managemen Pemakai","Kelompok","Daftar","Edit","Tidak Ada Kelompok"},
	    {"User Management","Group","List","Edit","No Group Available"}
    };

    public static final String listTextTableHeaderGroup[][] = {
	    {"No.","Nama","Deskripsi","Tanggal Pembuatan"},
	    {"No.","Name","Description","Creation Date"}
    };
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	
	
	
	//STRING DATA
	String viewType = FRMQueryString.requestString(request, "FRM_FIELD_VIEW_TYPE");
	String frmMsg = "";
	String html = "";
	String message = "";
	String privName = "";
	String privDesc = "";
	String privRegDate = "";
	String groupName = "";
	String groupDesc = "";
	String groupDate = "";
	String cmdIdxString[] = request.getParameterValues(FrmAppPrivilegeObj.fieldNames[FrmAppPrivilegeObj.FRM_COMMANDS]);
	
	//LONG DATA
	long userOid = FRMQueryString.requestLong(request, "user_oid");
	long privOid = FRMQueryString.requestLong(request, "priv_oid");
	long privObjectOid = FRMQueryString.requestLong(request, "priv_obj_oid");
	long groupOid = FRMQueryString.requestLong(request, "group_oid");
	
	
	
	//JSON OBJECT
	JSONObject jsonData = new JSONObject();
	
	//INT DATA
	int iCommand = FRMQueryString.requestCommand(request);
	int sessLang = FRMQueryString.requestInt(request, "FRM_FIELD_LANGUAGE");
	//GET MODULES ACCESS
	int appObjG1 = FRMQueryString.requestInt(request, FrmAppPrivilegeObj.fieldNames[FrmAppPrivilegeObj.FRM_G1_IDX]);
	int appObjG2 = FRMQueryString.requestInt(request, FrmAppPrivilegeObj.fieldNames[FrmAppPrivilegeObj.FRM_G2_IDX]);
	int appObjIdx = FRMQueryString.requestInt(request, FrmAppPrivilegeObj.fieldNames[FrmAppPrivilegeObj.FRM_OBJ_IDX]);
		
		
		
	
	//STATIC
	
	
	if(iCommand == Command.NONE){
	    if(viewType.equals("listmodul")){
		//GET PRIV
		AppPriv appPriv;
		if(privOid != 0){
		    appPriv = PstAppPriv.fetch(privOid);
		    privName = appPriv.getPrivName();
		    privDesc = appPriv.getDescr();
		}else{
		    appPriv = new AppPriv();
		}
		
		Vector listPriv = PstAppPrivilegeObj.listWithCmd_ByPrivOID_GroupByObj(0, 0, 
			privOid, "");
			
		
		html = drawListPrivObj(sessLang, 0, listPriv);
	    }else if(viewType.equals("listpriv")){
		Vector listAppPriv = PstAppPriv.list(0,0, "" , PstAppPriv.fieldNames[PstAppPriv.FLD_PRIV_NAME]);
		html = drawListAppPriv(sessLang, 0, listAppPriv, privOid);
	    }else if(viewType.equals("getdatapriv")){
		AppPriv appPriv;
		try{
		    appPriv = PstAppPriv.fetch(privOid);
		}catch(Exception ex){
		    appPriv = new AppPriv();
		}
		
		privName = appPriv.getPrivName();
		privDesc = appPriv.getDescr();
		privRegDate = Formater.formatDate(appPriv.getRegDate(), "dd MMMM yyyy");
	    }else if(viewType.equals("getpriv")){
		html = ctrCheckBox(groupOid);
		AppGroup appGroup;
		if(groupOid != 0){
		    appGroup = PstAppGroup.fetch(groupOid);
		}else{
		    appGroup = new AppGroup();
		}
		
		groupName = appGroup.getGroupName();
		groupDesc = appGroup.getDescription();
		if(appGroup.getRegDate() != null){
		    groupDate = Formater.formatDate(appGroup.getRegDate(),"dd MMMM yyyy");
		}
		
	    }else if(viewType.equals("getlistgroup")){
		 String order = " " + PstAppGroup.fieldNames[PstAppGroup.FLD_GROUP_NAME];
		 Vector listAppGroup = new Vector(1,1);
		 listAppGroup = PstAppGroup.list(0,0, "" , order);
		 html = drawListAppGroup(sessLang, 0, listAppGroup);
	    }
	}else if(iCommand == Command.ADD || iCommand == Command.EDIT){
	    if(viewType.equals("addeditmodul")){
		CtrlAppPrivilegeObj ctrlAppPrivilegeObj = new CtrlAppPrivilegeObj(request);
		FrmAppPrivilegeObj frmAppPrivilegeObj = ctrlAppPrivilegeObj.getForm();
		
		AppPrivilegeObj x = ctrlAppPrivilegeObj.getAppPrivObj();
		
		AppPriv appPriv = PstAppPriv.fetch(privOid);
		int iErrCode = ctrlAppPrivilegeObj.action(iCommand, privObjectOid);
		
		AppPrivilegeObj appPrivilegeObj = ctrlAppPrivilegeObj.getAppPrivObj();
		int vectSize = PstAppPrivilegeObj.getCountByPrivOID_GroupByObj(privOid);
		
		if(iCommand == Command.EDIT){
		    appObjG1 = (AppObjInfo.getIdxGroup1(appPrivilegeObj.getCode()));
		    appObjG2 = (AppObjInfo.getIdxGroup2(appPrivilegeObj.getCode()));
		    appObjIdx = (AppObjInfo.getIdxObject(appPrivilegeObj.getCode()));
		    
		    appObjG1 = appObjG1<0 ? 0 : appObjG1;
		    appObjG2 = appObjG2<0 ? 0 : appObjG2;
		    appObjIdx = appObjIdx<0 ? 0 : appObjIdx;
		}
		
		html += ""
		+ "<div class='form-group'>"
		    + "<label>"+listTextTableHeader[sessLang][1]+"</label>";
		    if(iCommand == Command.ADD){
			html += ""
			+ "<select name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G1_IDX]+"' class='form-control' id='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G1_IDX]+"'>";

			    for(int ig1 = 0; ig1 < AppObjInfo.titleG1.length; ig1++){
				String select = (appObjG1 == ig1) ? "" : "";
				try{
				    html += ""
				    + "<option value='"+ig1+"' "+select+">"+AppObjInfo.titleG1[ig1]+"</option>";
				}catch(Exception ex){

				}
			    }

			html +=""
			+ "</select>";
		    }else{
			html+=""
			+ "<div class='form-control' style='border:none;'>"
			    + ""+AppObjInfo.titleG1[appObjG1]+""
			    + "<input type='hidden' name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G1_IDX]+"' value='"+appObjG1+"'>"
			+ "</div>";
		    }
		html+=""
		+ "</div>"
		+ "<div class='form-group'>"
		    + "<label>"+listTextTableHeader[sessLang][2]+"</label>";
		    
		    if(iCommand == Command.ADD){
			html+=""
			+ "<select name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G2_IDX]+"' class='form-control' id='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G2_IDX]+"'>";
			
			for(int ig2 = 0; ig2 < AppObjInfo.titleG2[appObjG1].length; ig2++){
			    String select = (appObjG2 == ig2) ? "" : "";
			    try{
				html+="<option value='"+ig2+"' "+select+">"+AppObjInfo.titleG2[appObjG1][ig2]+"</option>";
			    }catch(Exception ex){
				
			    }
			}
			
			html+=""
			+ "</select>";
		    }else{
			html+=""
			+ "<div class='form-control' style='border:none;'>"
			    + ""+AppObjInfo.titleG2[appObjG1][appObjG2]+""
			    + "<input type='hidden' name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G2_IDX]+"' value='"+appObjG2+"' id='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_G2_IDX]+"'>"
			+ "</div>";
		    }
		html+=""
		+ "</div>"
		+ "<div class='form-group'>"
		    + "<label>"+listTextTableHeader[sessLang][3]+"</label>";
		    
		    if(iCommand == Command.ADD){
			html+=""
			+ "<select name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_OBJ_IDX]+"' class='form-control' id='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_OBJ_IDX]+"'>";
			    for(int iobj = 0; iobj < AppObjInfo.objectTitles[appObjG1][appObjG2].length; iobj++){
				String select = (appObjIdx == iobj) ? "" : "";
				
				try{
				    html+="<option value='"+iobj+"' "+select+">"+ ""+AppObjInfo.objectTitles[appObjG1][appObjG2][iobj]+ "</option>";
				}catch(Exception ex){
				    
				}
			    }
			html+=""
			+ "</select>";
		    }else{
			html+=""
			+ "<div class='form-control' style='border:none;'>"
			    + ""+AppObjInfo.objectTitles[appObjG1][appObjG2][appObjIdx]+""
			    + "<input type='hidden' name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_OBJ_IDX]+"' value='"+appObjIdx+"'>"
			+ "</div>";
		    }
		
		html+=""
		+ "</div>"
		+ "<div class='form-group'>"
		    + "<label>"+listTextTableHeader[sessLang][4]+"</label>"
		    + "<div class='form-control' style='border:none;' id='commands'>";
		    
		    for(int id = 0; id < AppObjInfo.objectCommands[appObjG1][appObjG2][appObjIdx].length; id++){
			int iCmd = AppObjInfo.objectCommands[appObjG1][appObjG2][appObjIdx][id];
			String checked = appPrivilegeObj.existCommand(iCmd) ? "checked" : "";
			
			html+=""
			+ "<input type='checkbox' name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_COMMANDS]+"' value='"+iCmd+"' "+checked+">"
			+ " "+AppObjInfo.strCommand[iCmd]+" &nbsp;&nbsp;&nbsp;&nbsp;";
		    }
		    html+=""
		    + "</div>"
		+ "</div>";
	    }else if(viewType.equals("getgroup2")){
			
		for(int ig2 = 0; ig2 < AppObjInfo.titleG2[appObjG1].length; ig2++){
		    String select = (appObjG2 == ig2) ? "" : "";
		    try{
			html+="<option value='"+ig2+"' "+select+">"+AppObjInfo.titleG2[appObjG1][ig2]+"</option>";
		    }catch(Exception ex){

		    }
		}
	    }else if(viewType.equals("getobjidx")){
		for(int iobj = 0; iobj < AppObjInfo.objectTitles[appObjG1][appObjG2].length; iobj++){
		    String select = (appObjIdx == iobj) ? "" : "";

		    try{
			html+="<option value='"+iobj+"' "+select+">"+ ""+AppObjInfo.objectTitles[appObjG1][appObjG2][iobj]+ "</option>";
		    }catch(Exception ex){

		    }
		}
	    }else if(viewType.equals("getcommands")){
		CtrlAppPrivilegeObj ctrlAppPrivilegeObj = new CtrlAppPrivilegeObj(request);
		FrmAppPrivilegeObj frmAppPrivilegeObj = ctrlAppPrivilegeObj.getForm();
		AppPrivilegeObj appPrivilegeObj = ctrlAppPrivilegeObj.getAppPrivObj();
		for(int id = 0; id < AppObjInfo.objectCommands[appObjG1][appObjG2][appObjIdx].length; id++){
		    int iCmd = AppObjInfo.objectCommands[appObjG1][appObjG2][appObjIdx][id];
		    String checked = appPrivilegeObj.existCommand(iCmd) ? "checked" : "";

		    html+=""
		    + "<input type='checkbox' name='"+frmAppPrivilegeObj.fieldNames[frmAppPrivilegeObj.FRM_COMMANDS]+"' value='"+iCmd+"' "+checked+">"
		    + " "+AppObjInfo.strCommand[iCmd]+" &nbsp;&nbsp;&nbsp;&nbsp;";
		}
	    }
	    
	}else if(iCommand == Command.SAVE){
	    try{
		if(viewType.equals("saveprivilege")){
		    CtrlAppPriv ctrlAppPriv = new CtrlAppPriv(request);
		    ctrlAppPriv.action(iCommand, privOid, 0, 0, 0, request);
		    frmMsg = ctrlAppPriv.getMessage();
		    
		    AppPriv appPriv = ctrlAppPriv.getAppPriv();
		    if(frmMsg.toLowerCase().indexOf("sukses") == -1 && frmMsg.toLowerCase().indexOf("success") == -1 && frmMsg.toLowerCase().indexOf("berhasil") == -1){
			
			html += "<i class='fa fontello-info'></i> "+frmMsg;
		    }else{
			 //returnTypeMessage += "success";
			 html += "<i class='fa fontello-ok'></i> "+frmMsg;
		    }
		    
		    message +="info";
		    privOid = appPriv.getOID();
		}else if(viewType.equals("savemodulobj")){
		    CtrlAppPrivilegeObj ctrlAppPrivilegeObj = new CtrlAppPrivilegeObj(request);
		    ctrlAppPrivilegeObj.action(iCommand, privObjectOid);
		    AppPrivilegeObj appPrivilegeObj = ctrlAppPrivilegeObj.getAppPrivObj();
		    frmMsg = ctrlAppPrivilegeObj.getMessage();
		    if(frmMsg.toLowerCase().indexOf("sukses") == -1 && frmMsg.toLowerCase().indexOf("success") == -1 && frmMsg.toLowerCase().indexOf("berhasil") == -1){
			
			html += "<i class='fa fontello-info'></i> "+frmMsg;
		    }else{
			 //returnTypeMessage += "success";
			 html += "<i class='fa fontello-ok'></i> "+frmMsg;
		    }
		    message = "info";
		    privOid = appPrivilegeObj.getPrivId();
		}else if(viewType.equals("savegroup")){
		    CtrlAppGroup ctrlAppGroup = new CtrlAppGroup(request);
		    ctrlAppGroup.action(iCommand, groupOid);
		    frmMsg = ctrlAppGroup.getMessage();
		    if(frmMsg.toLowerCase().indexOf("sukses") == -1 && frmMsg.toLowerCase().indexOf("success") == -1 && frmMsg.toLowerCase().indexOf("berhasil") == -1){
			
			html += "<i class='fa fontello-info'></i> "+frmMsg;
		    }else{
			 //returnTypeMessage += "success";
			 html += "<i class='fa fontello-ok'></i> "+frmMsg;
		    }
		    message = "info";
		}
	    }catch(Exception ex){
		message = ex.toString();
	    }
	    
	}
	
	try{
	    jsonData.put("HTML_DATA", html);
	    jsonData.put("MSG_TYPE", message);
	    jsonData.put("PRIV_OID", ""+privOid);
	    jsonData.put("PRIV_NAME", privName);
	    jsonData.put("PRIV_DESC", privDesc);
	    jsonData.put("PRIV_REG_DATE",privRegDate);
	    jsonData.put("GROUP_NAME", groupName);
	    jsonData.put("GROUP_DESC", groupDesc);
	    jsonData.put("GROUP_REG_DATE",groupDate);
	}catch(Exception ex){
	}
	
	response.getWriter().println(jsonData);
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
    
    public String drawListPrivObj(int language, int start, Vector objectClass) {
	String temp = "";
	String regdatestr = "";

	ControlList ctrlist = new ControlList();
	ctrlist.setAreaWidth("100%");
	ctrlist.setListStyle("listgen");
	ctrlist.setTitleStyle("listgentitle");
	ctrlist.setCellStyle("listgensell");
	ctrlist.setHeaderStyle("listgentitle");
	ctrlist.setCellSpacing("1");
	
	ctrlist.addHeader(listTextTableHeader[language][0], "3%");
	ctrlist.addHeader(listTextTableHeader[language][1], "20%");
	ctrlist.addHeader(listTextTableHeader[language][2], "20%");
	ctrlist.addHeader(listTextTableHeader[language][3], "20%");	
	ctrlist.addHeader(listTextTableHeader[language][4], "27%");

	ctrlist.setLinkRow(1);
        ctrlist.setLinkSufix("");
	
	Vector lstData = ctrlist.getData();

	Vector lstLinkData 	= ctrlist.getLinkData();					
	
	ctrlist.reset();
	
	for (int i = 0; i < objectClass.size(); i++) {
		 AppPrivilegeObj appPrivObj = (AppPrivilegeObj) objectClass.get(i);

		 Vector rowx = new Vector();
		 rowx.add(String.valueOf(i+1));
		 rowx.add("<a href='javascript:' class='addeditmodul' data-command='"+Command.EDIT+"' data-priv-obj-oid='"+appPrivObj.getOID()+"' data-priv-oid='"+appPrivObj.getPrivId()+"'>"+AppObjInfo.getTitleObject(appPrivObj.getCode())+"</a>");
		 rowx.add(AppObjInfo.getTitleGroup1(appPrivObj.getCode()));
		 rowx.add(AppObjInfo.getTitleGroup2(appPrivObj.getCode()));
		 
		 
		 Vector cmdInts = appPrivObj.getCommands();
		 String cmdStr = new String("");
		 for(int ic=0;ic< cmdInts.size() ; ic++){
			cmdStr =cmdStr + AppObjInfo.getStrCommand(((Integer)cmdInts.get(ic)).intValue())+", ";
		 }
		 if(cmdStr.length()>0)
			cmdStr = cmdStr.substring(0, cmdStr.length()-2);
		 
		 rowx.add(cmdStr);
		 
		 lstData.add(rowx);
		 lstLinkData.add(String.valueOf(appPrivObj.getOID()));
	}						

	return ctrlist.drawBootstrapStrip();
    }
    
    public String drawListAppPriv(int language, int start, Vector objectClass, long privId) {
	String temp = "";
	String regdatestr = "";
	
	ControlList ctrlist = new ControlList();
	ctrlist.setAreaWidth("100%");
	ctrlist.setListStyle("listgen");
	ctrlist.setTitleStyle("listgentitle");
	ctrlist.setCellStyle("listgensell");
	ctrlist.setHeaderStyle("listgentitle");
	ctrlist.setCellSpacing("1");
	
	ctrlist.addHeader(listTextTableHeaderPriv[language][0],"5%");
	ctrlist.addHeader(listTextTableHeaderPriv[language][1],"20%");
	ctrlist.addHeader(listTextTableHeaderPriv[language][2],"60%");
	ctrlist.addHeader(listTextTableHeaderPriv[language][3],"15%");
        ctrlist.addHeader(listTextGlobal[language][10]+" "+listTextGlobal[language][6],"15%");
        
	ctrlist.setLinkRow(1);
	ctrlist.setLinkSufix("");
	Vector lstData = ctrlist.getData();
	Vector lstLinkData 	= ctrlist.getLinkData();						
	
	ctrlist.reset();
	int index = -1;							
	for (int i = 0; i < objectClass.size(); i++) {
		 AppPriv appPriv = (AppPriv)objectClass.get(i);

		 Vector rowx = new Vector();
		 
		 if(privId == appPriv.getOID())
		 	index = i;
			
		 rowx.add("<div align=\"center\">"+String.valueOf(i+1)+"</div>");
		 rowx.add("<a href='javascript:' data-oid='"+appPriv.getOID()+"' class='showprivedit'>"+String.valueOf(appPriv.getPrivName())+"</a>");		 
		 rowx.add(String.valueOf(appPriv.getDescr()));
		 try{
			 Date regdate = appPriv.getRegDate();
			 regdatestr = Formater.formatDate(regdate, "dd MMMM yyyy");
		 }catch(Exception e){
			 regdatestr = "";
		 }
		 
		 rowx.add(regdatestr);
		 rowx.add("<a href='javascript:' data-oid='"+appPriv.getOID()+"' class='showprivedit'>Edit</a>");		 
		 lstData.add(rowx);
		 lstLinkData.add(String.valueOf(appPriv.getOID()));
	}						

	return ctrlist.drawBootstrapStrip();
    }
    public String ctrCheckBox(long groupID) { 
	ControlCheckBox chkBx=new ControlCheckBox();
	chkBx.setCellSpace("0");		
	chkBx.setCellStyle("");
	chkBx.setTableWidth("100%");
	chkBx.setWidth(4);
	chkBx.setTableAlign("left");
	chkBx.setCellWidth("10%");

	try{
	    Vector checkValues = new Vector(1,1);
	    Vector checkCaptions = new Vector(1,1);	        
	    Vector allPrivs = PstAppPriv.list(0, 0, "", "");

	    if(allPrivs!=null){
		int maxV = allPrivs.size(); 
		for(int i=0; i< maxV; i++){
		    AppPriv appPriv = (AppPriv) allPrivs.get(i);
		    checkValues.add(Long.toString(appPriv.getOID()));
		    checkCaptions.add("&nbsp;&nbsp;"+appPriv.getPrivName());
		}
	    }

	    Vector checkeds = new Vector(1,1);

	    PstGroupPriv pstGp = new PstGroupPriv(0);
	    Vector privs = SessAppGroup.getGroupPriv(groupID);

	    if(privs!=null){
		int maxV = privs.size(); 
		for(int i=0; i< maxV; i++){
		    AppPriv appPriv = (AppPriv) privs.get(i);
		    checkeds.add(Long.toString(appPriv.getOID()));
		}
	    }


	    String fldName = FrmAppGroup.fieldNames[FrmAppGroup.FRM_GROUP_PRIV];
	    return chkBx.draw(fldName,checkValues,checkCaptions,checkeds);

	} catch (Exception exc){
	    return "No privilege";
	}

    }
    
    public String drawListAppGroup(int language, int start, Vector objectClass) {
	String temp = "";
	String regdatestr = "";
	
	ControlList ctrlist = new ControlList();
	ctrlist.setAreaWidth("100%");
	ctrlist.setListStyle("listgen");
	ctrlist.setTitleStyle("listgentitle");
	ctrlist.setCellStyle("listgensell");
	ctrlist.setHeaderStyle("listgentitle");
	ctrlist.setCellSpacing("1");
	
	ctrlist.addHeader(listTextTableHeaderGroup[language][0],"5%");
	ctrlist.addHeader(listTextTableHeaderGroup[language][1],"20%");
	ctrlist.addHeader(listTextTableHeaderGroup[language][2],"60%");
	ctrlist.addHeader(listTextTableHeaderGroup[language][3],"15%");		

	ctrlist.setLinkRow(1);
	ctrlist.setLinkSufix("");
	Vector lstData = ctrlist.getData();
	
	ctrlist.reset();
								
	for (int i = 0; i < objectClass.size(); i++) {
		 AppGroup appGroup = (AppGroup)objectClass.get(i);

		 Vector rowx = new Vector();
		 
		 rowx.add("<div align=\"center\">"+(start+i+1)+"</div>");
		 rowx.add("<a href='javascript:' class='addeditgroup' data-group-oid='"+appGroup.getOID()+"'>"+appGroup.getGroupName()+"</a>");		 
		 rowx.add(String.valueOf(appGroup.getDescription()));
		 try{
			 Date regdate = appGroup.getRegDate();
                         if(regdate==null){
                             regdate = new Date();
                         }
			 regdatestr = Formater.formatDate(regdate, "dd MMMM yyyy");
		 }catch(Exception e){
			 regdatestr = "";
		 }
		 
		 rowx.add(regdatestr);
		 		 
		 lstData.add(rowx);
	}						

	return ctrlist.drawBootstrapStrip();
    }
}

