<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.common.entity.email.SettingEmail" %>
<%@page import="com.dimata.common.entity.email.PstSettingEmail" %>
<%@page import="com.dimata.common.form.email.CtrlSettingEmail" %>
<%@page import="com.dimata.common.form.email.FrmSettingEmail" %>

<%@page import="com.dimata.saras.entity.admin.AppObjInfo"%>
<%@page import="com.dimata.saras.session.admin.SessAppUser"%>

<%@page import="java.util.Vector"%>

<%@ include file ="../../main/javainit.jsp" %>
<% int  appObjCode = AppObjInfo.composeObjCode(AppObjInfo.G1_ADMIN , AppObjInfo.G2_ADMIN_USER, AppObjInfo.OBJ_ADMIN_USER_USER); %>
<%@ include file = "../../main/checkuser.jsp" %>

<%!
    public static final String textListTitleHeader[][] =
    {
        {"Email Id","Email Name","Password","Host","Port","CC Email","Domain Root"},
        {"Email Id","Email Name","Password","Host","Port","CC Email","Domain Root"}
    };
    
    public static final String textListButtonTitle[][] =
    {
        {"Kembali","Simpan"},
        {"Kembali","Simpan"}
    };
    
    
%>
<%
    Vector listSettingEmail = new Vector(1, 1);
    SettingEmail entSettingEmail = new SettingEmail();
    FrmSettingEmail frmSettingEmail = new FrmSettingEmail();    
    listSettingEmail = PstSettingEmail.list(0, 0, "","");
    entSettingEmail = (SettingEmail)listSettingEmail.get(0);
    
    //get data from form 
    int iCommand = FRMQueryString.requestInt(request,"Command");
    long oId = FRMQueryString.requestLong(request,"oId");
    
    if(iCommand == Command.SAVE){
	CtrlSettingEmail ctrlSettingEmail = new CtrlSettingEmail(request);
        int result = ctrlSettingEmail.action(iCommand, oId);
    }
    
%>


<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Data Tables</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="../../styles/bootstrap3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="../../styles/bootstrap3.1/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="../../styles/bootstrap3.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
 
        <link href="../../styles/bootstrap3.1/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        
        <script language="JavaScript">
            
        </script>
        
    </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <%@ include file = "../../header_mobile.jsp" %> 
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
             <%@ include file = "../../menu_left_mobile.jsp" %> 
             
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Tables
                        <small>User Online</small>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                     <div class="box">
                         <div class="box-body table-responsive">
                             <form action="setting-email.jsp" name="<%= FrmSettingEmail.FRM_SETTING_EMAIL%>" id="<%= FrmSettingEmail.FRM_SETTING_EMAIL%>" method="post" action="">
                                 <input type="hidden" id="Command" name="Command" value="<%=Command.SAVE%>">
                                 <input type="hidden" name="oId" id="oId" value="<%= entSettingEmail.getOID()%>">
                                 <input type="hidden" name="menu" value="62">
                                   <input type="hidden" name="tree" value="8">
                                  <table width="100%" cellpadding="0" border="0" cellspacing="2">
                                    
                                    <tr>
                                      <td colspan="3" class="txtheading1"></td>
                                    </tr>
                                    <tr>
                                      <td colspan="3" height="26" class="bigtitleflash">
                                        <hr size="1">
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%" height="26"><%= textListTitleHeader[0][1]%></td>
                                      <td width="2%" height="26">:</td>
                                      <td width="84%" height="26">
                                          <input size="40" required="required"  type="text" value="<%= entSettingEmail.getEmailName()%>" name="<%= FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_EMAIL_NAME]%>"  class="formElemen" >*
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%= textListTitleHeader[0][2]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input size="40" required="required"  type="password" name="<%= FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_PASSWORD]%>" value="<%= entSettingEmail.getPassword()%>" class="formElemen">*</td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%= textListTitleHeader[0][3]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input  type="text" required="required" value="<%= entSettingEmail.getHost()%>"  name="<%= FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_HOST]%>" >*
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%= textListTitleHeader[0][4]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input size="10" required="required" type="text" value="<%= entSettingEmail.getPort()%>"  name="<%= FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_PORT]%>" >*
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%= textListTitleHeader[0][5]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input required="required" size="40" type="email"  name="<%= FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_CC_EMAIL]%>" value="<%= entSettingEmail.getCcEmail()%>" >*
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%= textListTitleHeader[0][6]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input required="required" size="40" type="text" name="<%= FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_DOMAIN_ROOT]%>" value="<%= entSettingEmail.getDomainRoot()%>" >*
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%" valign="top" height="14" nowrap>&nbsp;</td>
                                      <td width="2%" height="14">&nbsp;</td>
                                      <td width="84%" height="14">&nbsp;</td>
                                    </tr>
                                    
                                    <tr>
                                      <td width="14%" valign="top" height="14" nowrap>&nbsp;</td>
                                      <td width="2%" height="14">&nbsp;</td>
                                      <td width="84%" height="14">&nbsp;</td>
                                    </tr>
                                    
                                    <tr>
                                      <td colspan="3" class="command">
                                            
                                          <button id='back' type='submit' class='btn btn-success'><i class='glyphicon glyphicon-floppy-save'></i> <%= textListButtonTitle[0][1]%></button>
                                      
                                       </td>
                                      
                                    </tr>
                                   
                                    
                                  
                                    <tr>
                                      <td width="14%">&nbsp;</td>
                                      <td width="2%">&nbsp;</td>
                                      <td width="84%">&nbsp;</td>
                                    </tr>
                                  </table>
                                </form>
                         </div>
                     </div>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- jQuery 2.0.2 -->
        <script src="../../styles/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../styles/bootstrap3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        
        
    </body>