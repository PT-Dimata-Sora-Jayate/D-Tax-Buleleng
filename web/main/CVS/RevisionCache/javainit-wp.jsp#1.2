<%-- 
    Document   : javainit
    Created on : Feb 23, 2014, 4:56:31 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.saras.entity.admin.AppUser"%>
<%@page import="com.dimata.saras.session.admin.SessUserSession"%>
<%@page import="com.dimata.wpupload.entity.wpuser.AppUserWP"%>
<%@page import="com.dimata.wpupload.session.SessUserWPSession"%>
<%
System.out.println("request.getRequestedSessionId() : "+request.getRequestedSessionId());
System.out.println("request.getRequestedSessionId() : "+request.getRemoteHost());
System.out.println("request.getRequestedSessionId() : "+request.getRemoteHost());
System.out.println("request.getRequestedSessionId() : "+request.getServerName());

// application path
String approot=request.getContextPath();
String printrootx=approot+"/servlet/com.dimata.dtaxintegration";


int SETTING_DEFAULT = 0;
int SETTING_COLONIAS = 1;
int specsetting = SETTING_COLONIAS;

/** Variabel jenis Menu */
int MENU_DEFAULT = 0;
int MENU_PER_TRANS = 1;
int MENU_ICON = 2;

// user is logging in or not
boolean isLoggedIn = false;
int userGroupNewStatus = -1;
String userName = "";
long userId = 0;
String userIdWP="";

//add session 20120711 by mirahu 
session.setMaxInactiveInterval(60 * 60 * 1);
/*
SessUserSession userSession = (SessUserSession) session.getValue(SessUserSession.HTTP_SESSION_NAME);
try{
    if(userSession==null){
        userSession= new SessUserSession();
    }else{
        if(userSession.isLoggedIn()==true){
            isLoggedIn  = true;
            AppUser appUser = userSession.getAppUser();
            userGroupNewStatus = appUser.getUserGroupNew();
            userName = appUser.getLoginId();
            userId = appUser.getOID();
        }
    }
}catch (Exception exc){
    System.out.println(" >>> Exception during check login");
}*/
SessUserWPSession userSessionWp = (SessUserWPSession) session.getValue(SessUserWPSession.HTTP_SESSION_WPNAME);
try{
    if(userSessionWp==null){
        userSessionWp= new SessUserWPSession();
	response.sendRedirect(approot+"/");
    }else{
        if(userSessionWp.isLoggedIn()==true){
            isLoggedIn  = true;
            AppUserWP appUserWp = userSessionWp.getAppUser();
            userGroupNewStatus = appUserWp.getUserGroupNew();
            userIdWP = appUserWp.getUserId();
            userId = appUserWp.getOID();
        }else{
            userSessionWp= new SessUserWPSession();
        }
    }
}catch (Exception exc){
    System.out.println(" >>> Exception during check login : "+exc);
}
/**
 * set language
 */
String strLanguage = "";
if (session.getValue("APPLICATION_LANGUAGE") != null) {
    strLanguage = String.valueOf(session.getValue("APPLICATION_LANGUAGE"));
}
int langDefault = com.dimata.util.lang.I_Language.LANGUAGE_DEFAULT;
int langForeign = com.dimata.util.lang.I_Language.LANGUAGE_FOREIGN;
int SESS_LANGUAGE = (strLanguage!=null && strLanguage.length() > 0) ? Integer.parseInt(strLanguage) : 0;

%>
