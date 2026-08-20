/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.wponline.ajax;

import com.dimata.util.Command;
import com.dimata.wponline.entity.wajibpajakonline.PstWajibPajak;
import com.dimata.wponline.entity.wajibpajakonline.WajibPajak;
import com.dimata.wponline.form.wajibpajakonline.CtrlWajibPajak;
import com.dimata.wponline.form.wajibpajakonline.FrmWajibPajak;
import com.dimata.common.entity.email.PstSettingEmail;
import com.dimata.common.entity.email.SettingEmail;
import com.dimata.common.session.email.SessEmail;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.wponline.session.SessUserWPOnlineSession;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AjaxWajibPajak extends HttpServlet{
    private String generateTemplateEmail(String domainRoot, String contextPath,String userName){
        String container ="";
        container +="<table width=\"100%\" border=\"0\">";
        container +="<tr style=\"background-color:#ffffff\">";
        container +="<td style=\"font-size:12px;color:#787878;padding:26px 26px 26px 26px;border-bottom:1px solid #dddddd; width:50%\">";
        container +="<img src='"+domainRoot+""+contextPath+"/images/logodispenda.jpg'>";
        container +="</td>";
        container +="<td style=\"width:50%;text-align:center ;border-bottom:1px solid #dddddd;font-size:20px;color:#787878;padding:26px 26px 26px 26px; font-family:Calibri;\">";
        container +="<b>ONLINE PAJAK</b><br>KABUPATEN GIANYAR";
        container +="</td>";
        container +="</tr>";
        container +="<tr>";
        container +="<td colspan=\"2\" style=\"padding:10px;background-color:#ffffff;border-bottom:1px solid #dddddd;\" >";
        container +="<span style=\"line-height:36px;font-family:Calibri;letter-spacing:.6px;color:#b18767;font-size:20px;font-weight:400;padding-bottom:1%;display:block\">Yang terhormat "+userName+"...</span>";
        container +="<p style=\"font-size:13px;color:#3e3e3e;line-height:20px;display:block; font-family:Tahoma, Geneva, sans-serif\">";
        container +="Selamat datang di Sistem Pajak Online Kabupaten Gianyar.<br><br>";
        container +="Data anda sudah berhasil didaftarkan pada sistem. Apabila proses verifikasi sudah selesai dilakukan, anda akan dikirimkan email aktivasi oleh admin kami. <br><br>";
        container +="Hormat Kami,<br>";
        container +="Tim Online Pajak Kabupaten Gianyar";
        container +="<br><br>";
        container +="<span style=\"font-family:Calibri;color:#999;font-size:13px;\">Email ini tidak dapat menerima balasan.</span>";
        container +="</p>";
        container +="<br>";
        container +="</td></tr><tr><td colspan=\"2\" style=\"width:100%; height:50px; background-color:#00BA8B;\"></tr></table>";
       
        return container;
    }
    
    private String generateTemplateEmailKonfirmasi(String contextPath,String domainRoot,String userName,String kodeKonfirmasi,String email){
        String container ="";
       
        container +="<table width=\"100%\" border=\"0\">";
        container +="<tr style=\"background-color:#ffffff\">";
        container +="<td style=\"font-size:12px;color:#787878;padding:26px 26px 26px 26px;border-bottom:1px solid #dddddd; width:50%\">";
        container +="<img src='"+domainRoot+""+contextPath+"/images/logodispenda.jpg'>";
        container +="</td>";
        container +="<td style=\"width:50%;text-align:center ;border-bottom:1px solid #dddddd;font-size:20px;color:#787878;padding:26px 26px 26px 26px; font-family:Calibri;\">";
        container +="<b>ONLINE PAJAK</b><br>KABUPATEN GIANYAR";
        container +="</td>";
        container +="</tr>";
        container +="<tr>";
        container +="<td colspan=\"2\" style=\"padding:10px;background-color:#ffffff;border-bottom:1px solid #dddddd;\" >";
        container +="<span style=\"line-height:36px;font-family:Calibri;letter-spacing:.6px;color:#b18767;font-size:20px;font-weight:400;padding-bottom:1%;display:block\">Yang terhormat "+userName+"...</span>";
        container +="<p style=\"font-size:13px;color:#3e3e3e;line-height:20px;display:block; font-family:Tahoma, Geneva, sans-serif\">";
        container +="Selamat datang di Sistem Pajak Online Kabupaten Gianyar.<br><br>";
        container +="Silahkan klik <a href='"+domainRoot+""+contextPath+"/wppbbonline/wp-pbb-online-konfirmasi.jsp?kode="+kodeKonfirmasi+"&email="+email+"'>link ini</a>  untuk proses konfirmasi<br><br>";
        container +="Hormat Kami,<br>";
        container +="Tim Online Pajak Kabupaten Gianyar";
        container +="<br><br>";
        container +="<span style=\"font-family:Calibri;color:#999;font-size:13px;\">Email ini tidak dapat menerima balasan.</span>";
        container +="</p>";
        container +="<br>";
        container +="</td></tr><tr><td colspan=\"2\" style=\"width:100%; height:50px; background-color:#00BA8B;\"></tr></table>";
        
        return container;
    }
    
    private String generateTemplateEmailApprove(String domainRoot, String contextPath,String namaWajibPajak, String userName, String password){
        String container ="";
        container +="<table width=\"100%\" border=\"0\">";
        container +="<tr style=\"background-color:#ffffff\">";
        container +="<td style=\"font-size:12px;color:#787878;padding:26px 26px 26px 26px;border-bottom:1px solid #dddddd; width:50%\">";
        container +="<img src='"+domainRoot+""+contextPath+"/images/logodispenda.jpg'>";
        container +="</td>";
        container +="<td style=\"width:50%;text-align:center ;border-bottom:1px solid #dddddd;font-size:20px;color:#787878;padding:26px 26px 26px 26px; font-family:Calibri;\">";
        container +="<b>ONLINE PAJAK</b><br>KABUPATEN GIANYAR";
        container +="</td>";
        container +="</tr>";
        container +="<tr>";
        container +="<td colspan=\"2\" style=\"padding:10px;background-color:#ffffff;border-bottom:1px solid #dddddd;\" >";
        container +="<span style=\"line-height:36px;font-family:Calibri;letter-spacing:.6px;color:#b18767;font-size:20px;font-weight:400;padding-bottom:1%;display:block\">Yang terhormat "+namaWajibPajak+"...</span>";
        container +="<p style=\"font-size:13px;color:#3e3e3e;line-height:20px;display:block; font-family:Tahoma, Geneva, sans-serif\">";
        container +="Akun anda sudah di approve oleh tim kami.<br><br>";
        container +="Silahkan anda login ke sistem pajak dengan username dan password yang sudah anda daftarkan. <br>";
        container +="username : "+userName+" <br>";
        container +="password : "+password+" <br><br>";
        container +="Hormat Kami,<br>";
        container +="Tim Online Pajak Kabupaten Gianyar";
        container +="<br><br>";
        container +="<span style=\"font-family:Calibri;color:#999;font-size:13px;\">Email ini tidak dapat menerima balasan.</span>";
        container +="</p>";
        container +="<br>";
        container +="</td></tr><tr><td colspan=\"2\" style=\"width:100%; height:50px; background-color:#00BA8B;\"></tr></table>";
       
        return container;
    }
    private String generateTemplateEmailReject(String domainRoot,String contextPath,String namaWajibPajak,String reason){
        String container ="";
        container +="<table width=\"100%\" border=\"0\">";
        container +="<tr style=\"background-color:#ffffff\">";
        container +="<td style=\"font-size:12px;color:#787878;padding:26px 26px 26px 26px;border-bottom:1px solid #dddddd; width:50%\">";
        container +="<img src='"+domainRoot+""+contextPath+"/images/logodispenda.jpg'>";
        container +="</td>";
        container +="<td style=\"width:50%;text-align:center ;border-bottom:1px solid #dddddd;font-size:20px;color:#787878;padding:26px 26px 26px 26px; font-family:Calibri;\">";
        container +="<b>ONLINE PAJAK</b><br>KABUPATEN GIANYAR";
        container +="</td>";
        container +="</tr>";
        container +="<tr>";
        container +="<td colspan=\"2\" style=\"padding:10px;background-color:#ffffff;border-bottom:1px solid #dddddd;\" >";
        container +="<span style=\"line-height:36px;font-family:Calibri;letter-spacing:.6px;color:#b18767;font-size:20px;font-weight:400;padding-bottom:1%;display:block\">Yang terhormat "+namaWajibPajak+"...</span>";
        container +="<p style=\"font-size:13px;color:#3e3e3e;line-height:20px;display:block; font-family:Tahoma, Geneva, sans-serif\">";
        container +="Dengan sangat menyesal,<br>";
        container +="Kami tidak dapat melakukan approve pada akun anda dengan alasan sebagai berikut<br>";
        container +=""+reason+"<br><br>";
        container +="Silahkan hubungi admin kami untuk keterangan lebih lanjut <br><br>";
      
        container +="Hormat Kami,<br>";
        container +="Tim Online Pajak Kabupaten Gianyar";
        container +="<br><br>";
        container +="<span style=\"font-family:Calibri;color:#999;font-size:13px;\">Email ini tidak dapat menerima balasan.</span>";
        container +="</p>";
        container +="<br>";
        container +="</td></tr><tr><td colspan=\"2\" style=\"width:100%; height:50px; background-color:#00BA8B;\"></tr></table>";
       
        return container;
    }
    private String generateTemplateEmailForgetPassword(String domainRoot,String contextPath, String namaWajibPajak, String userName, String password){
        String container ="";
       
        container +="<table width=\"100%\" border=\"0\">";
        container +="<tr style=\"background-color:#ffffff\">";
        container +="<td style=\"font-size:12px;color:#787878;padding:26px 26px 26px 26px;border-bottom:1px solid #dddddd; width:50%\">";
        container +="<img src='"+domainRoot+""+contextPath+"/images/logodispenda.jpg'>";
        container +="</td>";
        container +="<td style=\"width:50%;text-align:center ;border-bottom:1px solid #dddddd;font-size:20px;color:#787878;padding:26px 26px 26px 26px; font-family:Calibri;\">";
        container +="<b>ONLINE PAJAK</b><br>KABUPATEN GIANYAR";
        container +="</td>";
        container +="</tr>";
        container +="<tr>";
        container +="<td colspan=\"2\" style=\"padding:10px;background-color:#ffffff;border-bottom:1px solid #dddddd;\" >";
        container +="<span style=\"line-height:36px;font-family:Calibri;letter-spacing:.6px;color:#b18767;font-size:20px;font-weight:400;padding-bottom:1%;display:block\">Yang terhormat "+namaWajibPajak+"...</span>";
        container +="<p style=\"font-size:13px;color:#3e3e3e;line-height:20px;display:block; font-family:Tahoma, Geneva, sans-serif\">";
        container +="Berikut kami kirimkan Username dan Password anda. Silahkan login ke sistem pajak menggunakan Username dan Password sebagai berikut: <br>";
        container +="username : "+userName+" <br>";
        container +="password : "+password+" <br><br>";
        container +="Hormat Kami,<br>";
        container +="Tim Online Pajak Kabupaten Gianyar";
        container +="<br><br>";
        container +="<span style=\"font-family:Calibri;color:#999;font-size:13px;\">Email ini tidak dapat menerima balasan.</span>";
        container +="</p>";
        container +="<br>";
        container +="</td></tr><tr><td colspan=\"2\" style=\"width:100%; height:50px; background-color:#00BA8B;\"></tr></table>";
        
        return container;
    }
    public int cekCaptcha(HttpServletRequest request){
        int result =1;
        String kaptchaExpected = (String)request.getSession().getAttribute(com.dimata.wpupload.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
	String kaptchaReceived = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_TELP]);
        if (kaptchaExpected.equals(kaptchaReceived)){
            result=0;
        }
        return result;
    }
    
    public int cekUserName(HttpServletRequest request){
        String nameUser = request.getParameter("user");
        Vector listWajibPajak ;       
        listWajibPajak = PstWajibPajak.list(0, 0,PstWajibPajak.fieldNames[PstWajibPajak.FLD_NAMA_USER]+"='"+nameUser+"'","");
        int jumlahData = listWajibPajak.size();
        
        return jumlahData;
    }
    
    public int cekEmail(HttpServletRequest request){
        String email = request.getParameter("email");
        Vector listWajibPajak ;       
        listWajibPajak = PstWajibPajak.list(0, 0,PstWajibPajak.fieldNames[PstWajibPajak.FLD_EMAIL]+"='"+email+"'","");
        int jumlahData = listWajibPajak.size();
        
        return jumlahData;
    }
    
    public int saveUserName(HttpServletRequest request,int cmd,long oIdCustomer){
        int result =0;
        
        CtrlWajibPajak ctrlWajibPajak = new CtrlWajibPajak(request);
        result = ctrlWajibPajak.action(cmd, result);
        //apabila penyimpanan user berhasil, dilanjutkan dengan mengirim email konfirmasi  user tersebut
        if(result==0){
            String emailUser = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
            String namaWajibPajak = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]);
            String contextPath = request.getParameter("CONTEXT");
            String kodeKonfirmasi = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]);
            String email = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
            
            Vector settingEmail=PstSettingEmail.list(0,0,"","");
            SettingEmail detailSettingEmail = (SettingEmail)settingEmail.get(0);
            String domainRoot = detailSettingEmail.getDomainRoot();
            SessEmail sessEmail = new SessEmail();
            String templateEmail = generateTemplateEmailKonfirmasi(contextPath,domainRoot ,namaWajibPajak,kodeKonfirmasi,email);
            String resultEmail = sessEmail.sendEamil(emailUser, "Konfirmasi Pendaftaran", templateEmail);
            if(resultEmail.equals("Email Sucseed")){
                result=0;
            }else{
                result=1;
            }
        }
        return result;
    }
    
    public int editWajibPajak(HttpServletRequest request,int cmd,long oIdCustomer){
        int result =0;
        
        CtrlWajibPajak ctrlWajibPajak = new CtrlWajibPajak(request);
        result = ctrlWajibPajak.action(Command.SAVE, oIdCustomer);
         //apabila edit wajib pajak berhasil, dilanjutkan dengan mengirim email konfirmasi  user tersebut
        if(result==0 ){
            if (cmd!=Command.EDIT2){
                String emailUser = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
                String namaWajibPajak = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]);
                String contextPath = request.getParameter("CONTEXT");
                String email = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
                Vector settingEmail=PstSettingEmail.list(0,0,"","");
                SettingEmail detailSettingEmail = (SettingEmail)settingEmail.get(0);
                String domainRoot = detailSettingEmail.getDomainRoot();
                SessEmail sessEmail = new SessEmail();
                String templateEmail = generateTemplateEmail(domainRoot, contextPath, namaWajibPajak);
                String resultEmail = sessEmail.sendEamil(emailUser, "Konfirmasi Pendaftaran", templateEmail);
            }
        }
        
        return result;
    }
    
    public String cekKonfirmationLink(HttpServletRequest request){
        
        String email = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
        String kodeKonfirmasi = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]);
        
        String result ="";
        Vector listWajibPajak ;       
        listWajibPajak = PstWajibPajak.list(0, 0,PstWajibPajak.fieldNames[PstWajibPajak.FLD_EMAIL]+"='"+email+"' and "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_KODE_KONFIRMASI]+"='"+kodeKonfirmasi+"'","");
        int jumlahData = listWajibPajak.size();
        if(jumlahData>0){
           WajibPajak wajibPajak = (WajibPajak) listWajibPajak.get(0);
           result = Long.toString(wajibPajak.getOID());
        }else{
           result = "0";
        }
                
        return result;
    }
    
    public String getWajibPajakByOid(HttpServletRequest request){
        
        Long oId = Long.valueOf(request.getParameter("oId"));
        String result = "";
        WajibPajak wajibPajak = new WajibPajak();
        try {
            wajibPajak = PstWajibPajak.fetchExc(oId);
        } catch (DBException ex) {
            Logger.getLogger(AjaxWajibPajak.class.getName()).log(Level.SEVERE, null, ex);
        }
        result = wajibPajak.getNamaUser();
        result += ";" + wajibPajak.getPassword();
        result += ";" + wajibPajak.getNamaWajibPajak();
        result += ";" + wajibPajak.getAlamat();
        result += ";" + wajibPajak.getNop();
        result += ";" + wajibPajak.getTelp();
        result += ";" + wajibPajak.getFax();
        result += ";" + wajibPajak.getStatus();
        result += ";" + wajibPajak.getEmail();
        result += ";" + wajibPajak.getKodeKonfirmasi();
        return result;
    }
    
    public int approveWajibPajak(HttpServletRequest request,long oIdCustomer){
        int result =0;
        CtrlWajibPajak ctrlWajibPajak = new CtrlWajibPajak(request);
        result = ctrlWajibPajak.action(Command.SAVE, oIdCustomer);
        if(result==0){
            String emailUser = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
            String namaWajibPajak = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]);
            String contextPath = request.getParameter("context");
            String userName = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_USER]);
            String password = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_PASSWORD]);
            Vector settingEmail=PstSettingEmail.list(0,0,"","");
            SettingEmail detailSettingEmail = (SettingEmail)settingEmail.get(0);
            String domainRoot = detailSettingEmail.getDomainRoot();
            SessEmail sessEmail = new SessEmail();
            String templateEmail = generateTemplateEmailApprove(domainRoot, contextPath, namaWajibPajak, userName, password);
            String resultEmail = sessEmail.sendEamil(emailUser, "Konfirmasi Pendaftaran", templateEmail);
        }
        return result;
    }
    
    public int rejectWajibPajak(HttpServletRequest request,long oIdCustomer){
        int result =0;
        CtrlWajibPajak ctrlWajibPajak = new CtrlWajibPajak(request);
        result = ctrlWajibPajak.action(Command.SAVE, oIdCustomer);
        if(result==0){
            String emailUser = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
            String namaWajibPajak = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]);
            String contextPath = request.getParameter("context");
            String alasanReject = request.getParameter("alasanReject");
            SessEmail sessEmail = new SessEmail();
            Vector settingEmail=PstSettingEmail.list(0,0,"","");
            SettingEmail detailSettingEmail = (SettingEmail)settingEmail.get(0);
            String domainRoot = detailSettingEmail.getDomainRoot();
            String templateEmail = generateTemplateEmailReject(domainRoot,contextPath, namaWajibPajak, alasanReject);
            String resultEmail = sessEmail.sendEamil(emailUser, "Konfirmasi Pendaftaran", templateEmail);
        }
        return result;
    }
    
    public int resendLink(HttpServletRequest request,long oIdCustomer){
        int result = 0;
        String emailUser = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]);
        String namaWajibPajak = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]);
        String contextPath = request.getParameter("context");
        String kodeKonfirmasi = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]);
        
        Vector settingEmail=PstSettingEmail.list(0,0,"","");
        SettingEmail detailSettingEmail = (SettingEmail)settingEmail.get(0);
        String domainRoot = detailSettingEmail.getDomainRoot();
        SessEmail sessEmail = new SessEmail();
        String templateEmail = generateTemplateEmailKonfirmasi(contextPath,domainRoot ,namaWajibPajak,kodeKonfirmasi,emailUser);
        String resultEmail = sessEmail.sendEamil(emailUser, "Konfirmasi Pendaftaran", templateEmail);
        if(resultEmail.equals("Email Sucseed")){
            result=0;
        }else{
            result=1;
        }
        return result;
    }
    
    public int loginUserOnline(HttpServletRequest request){
        int result = 1;
        int dologin = 0;
        String namaUser = request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_USER]);
        String password=request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_PASSWORD]);
        String noTelp=request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_TELP]);
        
        String remoteIP = request.getRemoteAddr();
	int maxidle = FRMQueryString.requestInt(request, "maxidle");
	SessUserWPOnlineSession userWPOnlineSession = new SessUserWPOnlineSession(remoteIP );
	
        dologin=userWPOnlineSession.doLogin(namaUser,password);
        HttpSession session = request.getSession();
        if(dologin == SessUserWPOnlineSession.DO_LOGIN_OK){
            WajibPajak userWajibPajak = userWPOnlineSession.getWajibPajak();
            session.setMaxInactiveInterval(maxidle);
            session.putValue(SessUserWPOnlineSession.HTTP_SESSION_WPNAME, userWajibPajak.getNamaUser());
        }
        
        if (dologin==0){
            result = 0;
        }else{
            result = 1;
        }
        
        return result;
    }
    
    public String getChangePassword(HttpServletRequest request){
        String container ="";
        String email = request.getParameter("email");
        Vector listWajibPajak = new Vector(1,1);
        WajibPajak wajibPajak = new WajibPajak();
        
        listWajibPajak = PstWajibPajak.list(0,0,""+PstWajibPajak.fieldNames[PstWajibPajak.FLD_EMAIL]+"='"+email+"'", "");
        wajibPajak = (WajibPajak)listWajibPajak.get(0);
        container +="<form method =\"post\" name='"+FrmWajibPajak.FRM_WAJIB_PAJAK+"' id='"+FrmWajibPajak.FRM_WAJIB_PAJAK+"'>";
        container +="<input type=\"hidden\" name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_WP_ID]+"' id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_WP_ID]+"' value='"+wajibPajak.getOID()+"'>";
        container +="<input type=\"hidden\" name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_STATUS]+"' id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_STATUS]+"' value='"+wajibPajak.getStatus()+"''>";
        container +="<input type=\"hidden\" name=\"Command\" id=\"Command\" value='"+Command.EDIT2+"'>";
        container +="<input type=\"hidden\" name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]+"' id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]+"' value=\"0\"> ";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_USER]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_USER]+"' value='"+wajibPajak.getNamaUser()+"''>";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]+"' value='"+wajibPajak.getNamaWajibPajak()+"''>  ";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_ALAMAT]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_ALAMAT]+"' value='"+wajibPajak.getAlamat()+"''>";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NOP]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_NOP]+"' value='"+wajibPajak.getNop()+"''>";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_TELP]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_TELP]+"' value='"+wajibPajak.getTelp()+"''>";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_FAX]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_FAX]+"' value='"+wajibPajak.getFax()+"''>";
        container +="<input type=\"hidden\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_EMAIL]+"' value='"+wajibPajak.getEmail()+"''>";
        container +="<div class=\"widget-header\"><i class=\"icon-wrench\"></i><h3> UBAH PASSWORD</h3></div>";
        container +="<div class=\"widget-content\" style='border:none'>";
        container +="<div class=\"widget big-stats-container\">";
        container +="<div class=\"widget-content\" style='border:none'>";
        container +="<div class=\"row\">";
        container +="<div class=\"span6\"><div class=\"span2\" ><b>Password Saat Ini</b></div><div class=\"span3\" >: <input type=\"password\" id=\"curentPassword\" name=\"curentPassword\" class=\"form-control\">";
        container +="</div></div></div>";
       
        //------indicator
        container +="<div class=\"row\" id='error_curentPassword' style='display:none'>";
        container +="<div class=\"span6\"><div class=\"span2\" >&nbsp;</div><div class=\"span3\" style='color:red' > &nbsp;&nbsp; Password tidak sesuai";
        container +="</div></div></div>";
        //------
        container +="<div class=\"row\">";
        container +="<div class=\"span6\"><div class=\"span2\" ><b>Password Baru</b></div><div class=\"span3\" >: <input disabled type=\"password\" id='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_PASSWORD]+"' name='"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_PASSWORD]+"' class=\"form-control\">";
        container +="</div></div></div>";
        //------indicator
        container +="<div class=\"row\" id='error_"+FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_PASSWORD]+"' style='display:none'>";
        container +="<div class=\"span6\"><div class=\"span2\" >&nbsp;</div><div class=\"span3\" style='color:red' > &nbsp;&nbsp; Password tidak boleh kosong";
        container +="</div></div></div>";
        //------
        container +="<div class=\"row\">";
        container +="<div class=\"span6\"><div class=\"span2\" ><b>Ulang Password Baru</b></div><div class=\"span3\" >: <input disabled type=\"password\" id=\"newPassword2\" name=\"newPassword2\" class=\"form-control\">";
        container +="</div></div></div>";
        //------indicator
        container +="<div class=\"row\" id='error_newPassword2' style='display:none'>";
        container +="<div class=\"span6\"><div class=\"span2\" >&nbsp;</div><div class=\"span3\" style='color:red' > &nbsp;&nbsp; Ulang Password tidak sesuai";
        container +="</div></div></div>";
        //------
        container +="</div></div></div></div>";
        container +="<div class=\"modal-footer\"><button disabled id=\"simpan\" type=\"button\" class=\"btn btn-primary\" id=\"buttonSubmit\" >Simpan</button>";
        container +="<button type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button></div>";
        container +="</form>";
        return container;
    }
    
    public int cekCurentPassword(HttpServletRequest request){
        int result = 0;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Vector listWajibPajak = new Vector();
        listWajibPajak = PstWajibPajak.list(0,0,""+PstWajibPajak.fieldNames[PstWajibPajak.FLD_EMAIL]+"='"+email+"' and "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_PASSWORD]+"='"+password+"'", "");
        result = listWajibPajak.size();
        return result;
    }
    
    public String getContentAfterChangePassword(int result){
        String container="";
        if (result==0){
            container +="<div class=\"widget-header\"><i class=\"icon-wrench\"></i><h3> UBAH PASSWORD</h3></div>";
            container +="<div class=\"widget-content\" style='border:none'>";
            container +="<div class=\"widget big-stats-container\">";
            container +="<div class=\"widget-content\" style='border:none'>";
            container +="<div class=\"row\">";
            container +="<div style='margin-left:7%;' class='alert alert-success' id='modal-error'><b><i class='icon-ok '></i> Sukses :</b> Password anda sudah berhasil diperbaharui...</div>";
            container +="</div>";         
            container +="</div></div></div></div>";
            container +="<div class=\"modal-footer\">";
            container +="<button type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button></div>";   
        }else{
            container +="<div class=\"widget-header\"><i class=\"icon-wrench\"></i><h3> UBAH PASSWORD</h3></div>";
            container +="<div class=\"widget-content\" style='border:none'>";
            container +="<div class=\"widget big-stats-container\">";
            container +="<div class=\"widget-content\" style='border:none'>";
            container +="<div class=\"row\">";
            container +="<div style='margin-left:7%;' class='alert alert-danger' id='modal-error'><b><i class='icon-warning-sign '></i> Sukses :</b> Password anda sudah berhasil diperbaharui...</div>";
            container +="</div>";         
            container +="</div></div></div></div>";
            container +="<div class=\"modal-footer\">";
            container +="<button type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button></div>";   
        }
        return container;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int command = Integer.parseInt(request.getParameter("Command"));
        if(command==Command.ASK){
            int result = cekUserName(request);
            response.getWriter().write(Integer.toString(result));
        }else if (command==Command.GET){
            String result = cekKonfirmationLink(request);
            response.getWriter().write(result);
        }else if (command==Command.VIEW){
            String result = getWajibPajakByOid(request);
            response.getWriter().write(result);
        }else if (command==Command.FIRST){
            String result = getForgetPassword();
            response.getWriter().write(result);
        }else if (command==Command.NEXT){
            String result = getLoadingForgetPassword();
            response.getWriter().write(result);
        }else if (command==Command.SEARCH){
            String result = sendUserNameAndPassword(request);
            response.getWriter().write(result);
        }else if (command==Command.START){
            int result = cekEmail(request);
            response.getWriter().write(Integer.toString(result));
        }else if (command==Command.RESET){
            String result = getChangePassword(request);
            response.getWriter().write(result);
        }else if (command==Command.DETAIL){
            int result = cekCurentPassword(request);
            response.getWriter().write(Integer.toString(result));
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
        int command = Integer.parseInt(request.getParameter("Command"));
        if(command==Command.SAVE){
           long oId = Long.parseLong(request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_WP_ID]));
           int result =  saveUserName(request,command,oId);
           response.getWriter().write(Integer.toString(result));
        }else if (command==Command.RETRY){
           int result = cekCaptcha(request);
           response.getWriter().write(Integer.toString(result));
        }else if (command==Command.EDIT){
           long oId = Long.parseLong(request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_WP_ID]));
           int result =  editWajibPajak(request,command,oId);
           response.getWriter().write(Integer.toString(result));
        }else if (command==Command.RECONFIRM){
            long oId = Long.parseLong(request.getParameter("wp_oid"));
            int result =  approveWajibPajak(request,oId);
            response.getWriter().write(Integer.toString(result));
        }else if (command==Command.LOCK){
            long oId = Long.parseLong(request.getParameter("wp_oid"));
            int result =  rejectWajibPajak(request,oId);
            response.getWriter().write(Integer.toString(result));
        }else if(command==Command.REPOSTING){
            long oId = Long.parseLong(request.getParameter("wp_oid"));
            int result =  resendLink(request,oId);
            response.getWriter().write(Integer.toString(result));
        }else if (command==Command.LOGIN){
            int result = loginUserOnline(request);
            response.getWriter().write(Integer.toString(result));
        }else if (command==Command.EDIT2){
            long oId = Long.parseLong(request.getParameter(FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_WP_ID]));
            int result =  editWajibPajak(request,command,oId);
            String sResult=getContentAfterChangePassword(result);
            response.getWriter().write(sResult);
        }
    }
    
    public String getForgetPassword(){
        String result ="";
        result += "<div class=\"modal-header\">";
        result += "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>";
        result += "<h4 class=\"modal-title\" id=\"modal-title\">LUPA PASSWORD</h4>";
        result += "</div>";
        result += "<div class=\"modal-body\" id=\"modal-body\">";
        result += "<p>Masukkan email akun anda. Sistem akan mengirimkan <b>Nama User</b> dan <b>Password</b> ke alamat tersebut..</p>";
        
        result += "<input type=\"email\" placeholder=\"Email..\" id=\"emailUser\" class=\"controls\" style=\"width: 98%\">";
        result += "<div class='alert alert-danger' id='modal-error' style=\"display: none\"></div>";
        result += "</div>";
        result += "<div class=\"modal-footer\">";
        result += "<button id=\"btnKirim\" type=\"button\" class=\"btn btn-primary\" >Kirim</button>";
        result += "<button type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button>";
        result += "</div>";
      
        return result;
    }
    
    public String getLoadingForgetPassword(){
        String result ="";
        
        result += "<div class=\"modal-header\">";
        result += "<button id='btnTutup1' type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>";
        result += "<h4 class=\"modal-title\" id=\"modal-title\">PROSES PENGIRIMAN</h4>";
        result += "</div>";
        result += "<div class=\"modal-body\" id=\"modal-body\">";
        result += "<p>Mohon tunggu proses pengiriman...</p>";
        result += "</div>";
        result += "<div style=\"width: 96%; margin-left: 2%;\" class=\"progress progress-striped active\">";
        result += "<div class=\"bar\" style=\"width: 100%;\"></div>";
        result += "</div>";
        result += "<div class=\"modal-footer\">";
        result += "<button id='btnTutup2' type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button>";
        result += "</div>";
        
        return result;
    }
    
    public String getUnregisteredEmail(){
        String result ="";
        
        result += "<div class=\"modal-header\">";
        result += "<button id='btnTutup1' type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>";
        result += "<h4 class=\"modal-title\" id=\"modal-title\">VALIDASI EMAIL</h4>";
        result += "</div>";
        result += "<div class=\"modal-body\" id=\"modal-body\">";
        result += "<div class='alert alert-danger' id='modal-error'><b><i class='icon-warning-sign'></i> Kesalahan :</b> Mohon maaf, email yang anda masukkan tidak terdaftar...</div>";
        result += "</div>";
        result += "<div class=\"modal-footer\">";
        result += "<button id='btnTutup2' type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button>";
        result += "</div>";
        
        return result;
    }
    
    public String sendUserNameAndPassword(HttpServletRequest request){
        String result = "";
        
        String email = request.getParameter("email");
        String context = request.getParameter("context");
        
        Vector listWajibPajak ;       
        listWajibPajak = PstWajibPajak.list(0, 0,PstWajibPajak.fieldNames[PstWajibPajak.FLD_EMAIL]+"='"+email+"'","");
        int jumlahData = listWajibPajak.size();
        if (jumlahData>0){
            //detil data pengguna pajak
            WajibPajak wajibPajak = (WajibPajak)listWajibPajak.get(0);
            
            //settingan email
            Vector settingEmail=PstSettingEmail.list(0,0,"","");
            SettingEmail detailSettingEmail = (SettingEmail)settingEmail.get(0);
            String domainRoot = detailSettingEmail.getDomainRoot();
            
            //kirim email
            SessEmail sessEmail = new SessEmail();
            String templateEmail = generateTemplateEmailForgetPassword(domainRoot, context,wajibPajak.getNamaWajibPajak(), wajibPajak.getNamaUser(), wajibPajak.getPassword());
            String resultEmail = sessEmail.sendEamil(wajibPajak.getEmail(), "Data Username dan Passwrd", templateEmail);
            if(resultEmail.equals("Email Sucseed")){
                //get content emaill success
                result = getSendEmailSuccess();
            }else{
                //get content email gagal dikirim
                result = getSendEmailFailed();
            }
        }else{
            //get content yang menyatakan email tersebut tidak terdaftar
            result = getUnregisteredEmail();
        }
        
        return result;
    }
    
    public String getSendEmailSuccess(){
        String result ="";
        
        result += "<div class=\"modal-header\">";
        result += "<button id='btnTutup1' type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>";
        result += "<h4 class=\"modal-title\" id=\"modal-title\">INFORMASI</h4>";
        result += "</div>";
        result += "<div class=\"modal-body\" id=\"modal-body\">";
        result += "<div class='alert alert-success' id='modal-error'><b><i class='icon-ok '></i> Sukses :</b> Name User dan Password sudah dikirimkan ke alamat email anda.<br> Silahkan cek kotak masuk email anda. Terimakasih...</div>";
        result += "</div>";
        result += "<div class=\"modal-footer\">";
        result += "<button id='btnTutup2' type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button>";
        result += "</div>";
        
        return result;
    }
    
    public String getSendEmailFailed(){
        String result ="";
        
        result += "<div class=\"modal-header\">";
        result += "<button id='btnTutup1' type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>";
        result += "<h4 class=\"modal-title\" id=\"modal-title\">KESALAHAN</h4>";
        result += "</div>";
        result += "<div class=\"modal-body\" id=\"modal-body\">";
        result += "<div class='alert alert-danger' id='modal-error'><b><i class='icon-warning-sign'></i> Kesalahan :</b> Mohon maaf, pengiriman email gagal dilakukan. Silahkan cek koneksi internet anda. Terimakasih..</div>";
        result += "</div>";
        result += "<div class=\"modal-footer\">";
        result += "<button id='btnTutup2' type=\"button\" data-dismiss=\"modal\" class=\"btn btn-danger\">Tutup</button>";
        result += "</div>";
        
        return result;
    }
}
