/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.wpupload.ajax;

/**
 *
 * @author dimata005
 */

import com.dimata.qdep.form.FRMQueryString;
import com.dimata.wpupload.entity.wpuser.AppUserWP;
import com.dimata.wpupload.entity.wpuser.PstAppUserWP;
import com.dimata.wpupload.form.wpuser.FrmAppUserWP;
import com.dimata.wpupload.session.SessUserWPSession;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ardiadi
 */
public class MasterAjax extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	
	String currentPass = FRMQueryString.requestString(request,"currentpassword");
        String user = FRMQueryString.requestString(request, "userNameWp");
	String newPass = FRMQueryString.requestString(request,"newpassword");
	String verifyPass = FRMQueryString.requestString(request, "verifiypassword");
	int typeAjax = FRMQueryString.requestInt(request, "typeAjax");
        String comboBox="";
        switch(typeAjax){
            case 1:
                try{
                    if(newPass.equals(verifyPass)){
                        if(!user.equals("") && !newPass.equals("") && !currentPass.equals("")){
                            String whereNewPass = PstAppUserWP.fieldNames[PstAppUserWP.FLD_USER_ID] +" = '" + user+"' AND "+PstAppUserWP.fieldNames[PstAppUserWP.FLD_PASSWORD]+" = '"+currentPass+"'";
                            int checkUser = PstAppUserWP.getCount(whereNewPass);
                            if(checkUser>=1){//berhasil
                                int result = PstAppUserWP.updateNewPassword(user, currentPass, newPass);
                                if(result>=1){//berhasil
                                    comboBox="<br><br><b>Password berhasil di update, silahkan keluar dari sistem dan login kembali menggunakan password yang baru !</b>";
                                }else{
                                    comboBox="<br><br><b>Password gagal di update!, silahkan ulangi lagi</b><br>";
                                    comboBox += drawFormChangeUserPassword();
                                }
                            }else{
                                    comboBox="<br><br><b><i>Password yang anda masukkan salah, silahkan ulangi lagi</i></b><br>";
                                    comboBox += drawFormChangeUserPassword();
                            }    
                        }else{
                            comboBox="<br><br><b><i>Data yang di inputkan tidak lengkap, silahkan ulangi lagi</i></b><br>";
                            comboBox += drawFormChangeUserPassword();
                        }
                    }else{
                        comboBox ="<br><br><b><i>password baru dan password verifikasi yang di inputkan berbeda,silahkan ulangi lagi !</i></b><br>";
                        comboBox += drawFormChangeUserPassword();
                    }
                }catch (Exception e) {
                
                }
                
                break;
            default:
                break;
        }
	response.getWriter().println(comboBox);
    }

    
     public static String drawFormChangeUserPassword(){
        String comboBox="";
        try {
            comboBox += "<div class=\"widget-content\" id=\"resultPassword\">";
            comboBox += "<div class=\"widget big-stats-container\">";
            comboBox += "<div class=\"widget-content\">";
                comboBox += "<div class=\"row\">";
                    comboBox += "<div class=\"span12\">&nbsp;</div>";
                comboBox += "</div>";
                comboBox += "<div class=\"row\">";
                    comboBox += "<div class=\"span12\">";
                            comboBox += "<div class=\"span2\">";
                                comboBox += "<b>Password Saat Ini</b>";
                            comboBox += "</div>";
                            comboBox += "<div class=\"span3\">";
                                comboBox += ": <input type=\"password\" name=\"currentpassword\" value=\"\" class=\"form-control\" required>";
                            comboBox += "</div>";
                    comboBox += "</div>";
                comboBox += "</div>";
                comboBox += "<div class=\"row\">";
                    comboBox += "<div class=\"span12\">";
                            comboBox += "<div class=\"span2\">";
                                comboBox += "<b>Password Baru</b>";
                            comboBox += "</div>";
                            comboBox += "<div class=\"span3\">";
                                comboBox += ": <input type=\"password\" name=\"newpassword\" id=\"pass1\" value=\"\" class=\"form-control\" required>";
                            comboBox += "</div>";
                    comboBox += "</div>";
                comboBox += "</div>";
                comboBox += "<div class=\"row\">";
                    comboBox += "<div class=\"span12\">";
                            comboBox += "<div class=\"span2\">";
                                comboBox += "<b>Verifikasi Password Baru</b>";
                            comboBox += "</div>";
                            comboBox += "<div class=\"span3\">";
                                comboBox += ": <input type=\"password\" name=\"verifiypassword\" id=\"pass2\" value=\"\" class=\"form-control\" required onkeyup=\"checkPass(); return false;\">";
                                comboBox += "<span id=\"confirmMessage\" class=\"confirmMessage\"></span>";
                            comboBox += "</div>";
                    comboBox += "</div>";
                comboBox += "</div>";
            comboBox += "</div>";
          comboBox += "</div>";
        comboBox += "</div>";
        } catch (Exception e) {
        }
        return comboBox;
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
