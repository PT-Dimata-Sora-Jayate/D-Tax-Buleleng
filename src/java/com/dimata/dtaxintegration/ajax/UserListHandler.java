/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.biadmin.AppGroup;
import com.dimata.dtaxintegration.entity.biadmin.AppUser;
import com.dimata.dtaxintegration.entity.biadmin.PstAppGroup;
import com.dimata.dtaxintegration.entity.biadmin.PstAppUser;
import com.dimata.dtaxintegration.entity.biadmin.PstUserGroup;
import com.dimata.dtaxintegration.form.biadmin.CtrlAppUser;
import com.dimata.dtaxintegration.form.biadmin.FrmAppUser;
import com.dimata.dtaxintegration.session.biadmin.SessAppUser;
import com.dimata.gui.jsp.ControlCheckBox;
import com.dimata.gui.jsp.ControlList;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UserListHandler extends HttpServlet {

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
    
    public static final String textListTitleHeader[][]
	= {
	    {"Sistem", "Daftar Pemakai", "ID Pemakai", "Nama Lengkap", "Status", "Tambah Pemakai Baru"},
	    {"System", "User LIst", "User ID", "Full Name", "Status", "Add New User"}
	};
    public static final String textListTitleHeaderForm[][]=
    {
	//0,                    1,          2,          3,                  4,              5,      6,          7,              8,              9,              10,                 11,                     12                               13                          14                                15              16                 17                                        18
        {"Manajemen Pemakai","ID Pemakai","Pasword","Konfirmasi Pasword","Nama Lengkap","Email","Keterangan","Status Pemakai","Grup Pemakai","Simpan Pemakai","Hapus Pemakai","Kembali ke Daftar Pemakai","Proses OK..kembali ke list","Assign Final Document Transaction Location","Assign Data Exchange Location"," Assign Day Login","Assign Time","Assign View Sales/Stock Report Location","Nama Perusahaan","Assign Create Location Document"},
	{"User Management","User ID","Password","Confirm Password","Full Name","Email","Description","User Status","User Group","Save User","Delete User","Back to User List","Processing OK..back to list","Assign Final Document Transaction Location","Assign Data Exchange Location","Assign Day Login","Assign Time","Assign View Sales/Stock Report Location","Company","Assign Create Location Document"}
    };
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	
	//STRING DATA
	String viewType = FRMQueryString.requestString(request, "FRM_FIELD_VIEW_TYPE");
	String frmMsg = "";
	String html = "";
	String message = "";
	String idPemakai = "";
	String password = "";
	String cfmPassword = "";
	String namaLengkap = "";
	String email = "";
	String keterangan = "";
	String statusPemakai = "";
	String groupPemakai = "";
	
	//LONG DATA
	long userOid = FRMQueryString.requestLong(request, "user_oid");
	
	
	//JSON OBJECT
	JSONObject jsonData = new JSONObject();
	
	//INT DATA
	int iCommand = FRMQueryString.requestCommand(request);
	
	
	if(iCommand == Command.NONE){
	    if(viewType.equals("viewgroupassigned")){
		html = ctrCheckBox(userOid);
		
		if(html == null){
		    html = "Data tidak ditemukan.";
		}else{
		    html = html;
		}
	    }else if(viewType.equals("getlistuser")){
		Vector listAppUser = new Vector(1,1);
		String order = " " + PstAppUser.fieldNames[PstAppUser.FLD_LOGIN_ID];
		listAppUser = PstAppUser.listPartObj(0, 0, "", order);
		html = drawListAppUser(iCommand, listAppUser);
	    }else if(viewType.equals("getdatauser")){
		AppUser appUser;
		try{
		    appUser = PstAppUser.fetch(userOid);
		}catch(Exception ex){
		    appUser = new AppUser();
		}
		
		idPemakai = appUser.getLoginId();
		password = appUser.getPassword();
		cfmPassword = appUser.getPassword();
		namaLengkap = appUser.getFullName();
		email = appUser.getEmail();
		keterangan = appUser.getDescription();
		statusPemakai = ""+appUser.getUserStatus();
		groupPemakai = ""+appUser.getUserGroupNew();
	    }
	}else if(iCommand == Command.SAVE){
	    try{
		if(viewType.equals("saveuserlist")){
		    CtrlAppUser ctrlAppUser = new CtrlAppUser(request);
		    ctrlAppUser.action(iCommand, userOid, request);
		    frmMsg = ctrlAppUser.getMessage();
		    if(frmMsg.toLowerCase().indexOf("sukses") == -1 && frmMsg.toLowerCase().indexOf("success") == -1 && frmMsg.toLowerCase().indexOf("berhasil") == -1){
			
			html += "<i class='fa fontello-info'></i> "+frmMsg;
		    }else{
			 //returnTypeMessage += "success";
			 html += "<i class='fa fontello-ok'></i> "+frmMsg;
		    }
		    message = "info";
		}
	    }catch(Exception ex){
		frmMsg = ex.toString();
	    }
	    
	}
	
	try{
	    jsonData.put("HTML_DATA", html);
	    jsonData.put("LOGIN_ID_DATA", idPemakai);
	    jsonData.put("PASSWORD_DATA", password);
	    jsonData.put("CFM_PASSWORD_DATA", cfmPassword);
	    jsonData.put("FULL_NAME_DATA", namaLengkap);
	    jsonData.put("EMAIL_DATA", email);
	    jsonData.put("DESC_DATA", keterangan);
	    jsonData.put("STATUS_DATA", statusPemakai);
	    jsonData.put("GROUP_DATA", groupPemakai);
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
    
    public String ctrCheckBox(long userID){
	ControlCheckBox chkBx=new ControlCheckBox();
	chkBx.setCellSpace("0");
	chkBx.setCellStyle("");
	chkBx.setWidth(3);
	chkBx.setTableAlign("left");
	chkBx.setCellWidth("10%");

        try
		{
            Vector checkValues = new Vector(1,1);
            Vector checkCaptions = new Vector(1,1);
            Vector allGroups = PstAppGroup.list(0, 0, "", "");

            if(allGroups!=null)
			{
                int maxV = allGroups.size();
                for(int i=0; i< maxV; i++)
				{
                    AppGroup appGroup = (AppGroup) allGroups.get(i);
                    checkValues.add(Long.toString(appGroup.getOID()));
                    checkCaptions.add("&nbsp;&nbsp;"+appGroup.getGroupName());
                }
            }

            Vector checkeds = new Vector(1,1);
            PstUserGroup pstUg = new PstUserGroup(0);
            Vector groups = SessAppUser.getUserGroup(userID);

            if(groups!=null)
			{
                int maxV = groups.size();
                for(int i=0; i< maxV; i++)
				{
                    AppGroup appGroup = (AppGroup) groups.get(i);
                    checkeds.add(Long.toString(appGroup.getOID()));
                }
            }

            chkBx.setTableWidth("100%");

            String fldName = FrmAppUser.fieldNames[FrmAppUser.FRM_USER_GROUP];
            return chkBx.draw(fldName,checkValues,checkCaptions,checkeds);

        } catch (Exception exc){
            return "No group assigned";
        }

    }
    
    public String drawListAppUser(int language, Vector objectClass) {
        String temp = "";
        String regdatestr = "";

        ControlList ctrlist = new ControlList();
        ctrlist.setAreaWidth("90%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("listgentitle");
        ctrlist.setCellStyle("listgensell");
        ctrlist.setHeaderStyle("listgentitle");
        ctrlist.addHeader(textListTitleHeader[language][2], "20%");
        ctrlist.addHeader(textListTitleHeader[language][3], "70%");
        ctrlist.addHeader(textListTitleHeader[language][4], "10%");

        ctrlist.setLinkRow(0);
        ctrlist.setLinkSufix("");

        Vector lstData = ctrlist.getData();

        ctrlist.reset();

        for (int i = 0; i < objectClass.size(); i++) {
            AppUser appUser = (AppUser) objectClass.get(i);

            Vector rowx = new Vector();

            rowx.add("<a href='javascript:' class='showuseredit' data-oid='"+appUser.getOID()+"'>"+String.valueOf(appUser.getLoginId())+"</a>");
            rowx.add(String.valueOf(appUser.getFullName()));
            rowx.add(String.valueOf(AppUser.getStatusTxt(appUser.getUserStatus())));

            lstData.add(rowx);
        }

        return ctrlist.drawBootstrapStrip();
    }
}
