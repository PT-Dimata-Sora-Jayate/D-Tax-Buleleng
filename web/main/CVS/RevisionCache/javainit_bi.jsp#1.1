<%-- 
    Document   : javainit_bi
    Created on : Nov 24, 2015, 10:03:23 PM
    Author     : dimata005
--%>


<%@page import="com.dimata.dtaxintegration.entity.biadmin.AppUser"%>
<%@page import="com.dimata.dtaxintegration.session.biadmin.SessUserSession"%>
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

//add session 20120711 by mirahu 
session.setMaxInactiveInterval(60 * 60 * 2);
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
