<%@ page import="com.dimata.saras.entity.admin.AppObjInfo"%>
<%@ page import="com.dimata.qdep.system.I_SystemInfo"%>
<%
    if (userSession == null || isLoggedIn == false) {
        response.sendRedirect(approot + "/index.jsp");
    }
%>

<%
    boolean privAdd = true;//userSession.checkPrivilege(AppObjInfo.composeCode(appObjCode, AppObjInfo.COMMAND_ADD));
    boolean privUpdate = true;//userSession.checkPrivilege(AppObjInfo.composeCode(appObjCode, AppObjInfo.COMMAND_UPDATE));
    boolean privDelete =true;// userSession.checkPrivilege(AppObjInfo.composeCode(appObjCode, AppObjInfo.COMMAND_DELETE));
    boolean privStart =true;// userSession.checkPrivilege(AppObjInfo.composeCode(appObjCode, AppObjInfo.COMMAND_START));
    boolean privStop =true;//userSession.checkPrivilege(AppObjInfo.composeCode(appObjCode, AppObjInfo.COMMAND_STOP));
%>
