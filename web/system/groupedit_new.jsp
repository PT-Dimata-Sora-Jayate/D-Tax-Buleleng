<%-- 
    Document   : groupedit_new
    Created on : Jul 17, 2015, 3:55:26 PM
    Author     : dimata005
--%>
<%@page import="com.dimata.gui.jsp.ControlDate"%>
<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.saras.entity.admin.AppGroup"%>
<%@page import="com.dimata.saras.form.admin.CtrlAppGroup"%>
<%@page import="com.dimata.gui.jsp.ControlLine"%>
<%@page import="com.dimata.saras.form.admin.FrmAppGroup"%>
<%@page import="com.dimata.saras.session.admin.SessAppGroup"%>
<%@page import="com.dimata.saras.entity.admin.AppPriv"%>
<%@page import="com.dimata.saras.entity.admin.PstAppPriv"%>
<%@page import="com.dimata.saras.entity.admin.PstGroupPriv"%>
<%@page import="java.util.Vector"%>
<%@page import="com.dimata.gui.jsp.ControlCheckBox"%>
<%@ page language="java" %>
<%@ include file = "../main/javainit.jsp" %>
<% int  appObjCode = AppObjInfo.composeObjCode(AppObjInfo.G1_ADMIN , AppObjInfo.G2_ADMIN_USER, AppObjInfo.OBJ_ADMIN_USER_GROUP); %>
<%@ include file = "../main/checkuser.jsp" %>

<%!
public static final String listTextGlobal[][] = {
	{"Managemen Pemakai","Kelompok","Daftar","Edit"},
	{"User Management","Group","List","Edit"}
};

public static final String listTextTableHeader[][] = {
	{"No.","Nama","Deskripsi","Hak Akses","Tanggal Pembuatan"},
	{"No.","Name","Description","Privilege","Creation Date"}
};

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
            Vector allPrivs = PstAppPriv.list(0, 0, "", ""+PstAppPriv.fieldNames[PstAppPriv.FLD_PRIV_NAME]+" ASC ");
            if(allPrivs!=null){
                int maxV = allPrivs.size(); 
                for(int i=0; i< maxV; i++){
                    AppPriv appPriv = (AppPriv) allPrivs.get(i);
                    checkValues.add(Long.toString(appPriv.getOID()));
                    checkCaptions.add(appPriv.getPrivName());
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

%>
<%

/* VARIABLE DECLARATION */ 

ControlLine ctrLine = new ControlLine();

/* GET REQUEST FROM HIDDEN TEXT */
int iCommand = FRMQueryString.requestCommand(request);

long appGroupOID = FRMQueryString.requestLong(request,"group_oid");
int start = FRMQueryString.requestInt(request, "start"); 

CtrlAppGroup ctrlAppGroup = new CtrlAppGroup(request);

FrmAppGroup frmAppGroup = ctrlAppGroup.getForm();
 
int iErrCode = ctrlAppGroup.action(iCommand,appGroupOID);
String msgString = ctrlAppGroup.getMessage();
AppGroup appGroup = ctrlAppGroup.getAppGroup();
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>dTaxIntegration | Data Tables</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="../styles/bootstrap3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="../styles/bootstrap3.1/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="../styles/bootstrap3.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
        <link href="../styles/bootstrap3.1/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="../styles/bootstrap3.1/css/AdminLTE.css" rel="stylesheet" type="text/css" />

         <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="../styles/bootstrap3.1/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="../styles/bootstrap3.1/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script language="JavaScript">
            function cmdCancel(){
                    //document.frmAppGroup.group_oid.value=oid;
                    document.frmAppGroup.command.value="<%=Command.EDIT%>";
                    document.frmAppGroup.action="groupedit_new.jsp";
                    document.frmAppGroup.submit();
            }

            <% if(privAdd || privUpdate) {%>
            function cmdSave(){
                    document.frmAppGroup.command.value="<%=Command.SAVE%>";
                    document.frmAppGroup.action="groupedit_new.jsp";
                    document.frmAppGroup.submit();
            }

            <%}%>

            <% if(privDelete) {%>
            function cmdAsk(oid){
                    document.frmAppGroup.group_oid.value=oid;
                    document.frmAppGroup.command.value="<%=Command.ASK%>";
                    document.frmAppGroup.action="groupedit_new.jsp";
                    document.frmAppGroup.submit();
            }
            function cmdDelete(oid){
                    document.frmAppGroup.group_oid.value=oid;
                    document.frmAppGroup.command.value="<%=Command.DELETE%>";
                    document.frmAppGroup.action="groupedit_new.jsp";
                    document.frmAppGroup.submit();
            }
            <%}%>
            function cmdBack(oid){
                    document.frmAppGroup.group_oid.value=oid;
                    document.frmAppGroup.command.value="<%=Command.LIST%>";
                    document.frmAppGroup.action="grouplist_new.jsp";
                    document.frmAppGroup.submit();
            }

            function hideObjectForEmployee(){
            } 

            function hideObjectForLockers(){ 
            }

            function hideObjectForCanteen(){
            }

            function hideObjectForClinic(){
            }

            function hideObjectForMasterdata(){
            }

            function showObjectForMenu(){
            }

            <!--
            function MM_swapImgRestore() { //v3.0
              var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
            }

            function MM_preloadImages() { //v3.0
              var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
                var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
                if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
            }

            function MM_findObj(n, d) { //v4.0
              var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
                d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
              if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
              for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
              if(!x && document.getElementById) x=document.getElementById(n); return x;
            }

            function MM_swapImage() { //v3.0
              var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
               if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
            }
            //-->
        </script>
    </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <%@ include file = "../header_mobile.jsp" %> 
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
             <%@ include file = "../menu_left_mobile.jsp" %> 
             
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Tables
                        <small>User List</small>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                     <div class="box">
                         <div class="box-body table-responsive">
                             <form name="frmAppGroup" method="post" action="">
                                  <input type="hidden" name="command" value="">
                                  <input type="hidden" name="group_oid" value="<%=appGroupOID%>">
                                  <input type="hidden" name="start" value="<%=start%>">
                                  <table width="100%">
                                    <%if(((iCommand==Command.SAVE)&&(frmAppGroup.errorSize()>0))
                                        ||(iCommand==Command.ADD)||(iCommand==Command.EDIT)||(iCommand==Command.ASK)){%>
                                    <tr> 
                                      <td colspan="3" class="txtheading1"></td>
                                    </tr>
                                    <tr> 
                                      <td colspan="3" height="20" class="bigtitleflash">&nbsp;</td>
                                    </tr>
                                    <tr> 
                                      <td width="13%" valign="top"><strong><%=listTextTableHeader[SESS_LANGUAGE][1]%></strong></td>
                                                      <td width="2%" valign="top"><strong>:</strong></td>
                                      <td width="85%"> 
                                        <input type="text" name="<%=frmAppGroup.fieldNames[frmAppGroup.FRM_GROUP_NAME] %>" value="<%=appGroup.getGroupName()%>" class="formElemen" size="30">
                                        * &nbsp;<%= frmAppGroup.getErrorMsg(frmAppGroup.FRM_GROUP_NAME) %></td>
                                    </tr>
                                    <tr> 
                                      <td width="13%" valign="top"><strong><%=listTextTableHeader[SESS_LANGUAGE][2]%></strong></td>
                                                      <td width="2%" valign="top"><strong>:</strong></td>
                                      <td width="85%"> 
                                        <textarea name="<%=frmAppGroup.fieldNames[frmAppGroup.FRM_DESCRIPTION] %>" cols="40" rows="3" class="formElemen"><%=appGroup.getDescription()%></textarea>
                                      </td>
                                    </tr>
                                    <tr> 
                                      <td width="13%" valign="top" height="14" nowrap><strong><%=listTextTableHeader[SESS_LANGUAGE][3]%></strong></td>
                                                      <td width="2%" valign="top"><strong>:</strong></td>
                                      <td width="85%"> <%=ctrCheckBox(appGroupOID)%> </td>
                                    <tr> 
                                      <td width="13%" valign="top" height="14" nowrap><strong><%=listTextTableHeader[SESS_LANGUAGE][4]%></strong></td>
                                                      <td width="2%" valign="top"><strong>:</strong></td>
                                      <td width="85%"> <%=ControlDate.drawDate(frmAppGroup.fieldNames[FrmAppGroup.FRM_REG_DATE], appGroup.getRegDate(),"formElemen",  0, -30)%> </td>
                                    <tr> 
                                      <td colspan="3">&nbsp;</td>
                                    <tr> 
                                      <td colspan="3" class="command"> 
                                        <%
                                                                    String cmdTitle = listTextGlobal[SESS_LANGUAGE][1];

                                                                    ctrLine.setSaveImageAlt(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_SAVE,true));
                                                                    ctrLine.setDeleteImageAlt(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_ASK,true));
                                                                    ctrLine.setBackImageAlt(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_BACK,true));							
                                                                    ctrLine.setEditImageAlt(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_CANCEL,false));

                                                                    ctrLine.setLocationImg(approot+"/images");
                                                                    ctrLine.initDefault();
                                                                    ctrLine.setTableWidth("80%");
                                                                    ctrLine.setCommandStyle("command");
                                                                    ctrLine.setColCommStyle("command");
                                                                    String scomDel = "javascript:cmdAsk('"+appGroupOID+"')";
                                                                    String sconDelCom = "javascript:cmdDelete('"+appGroupOID+"')";
                                                                    String scancel = "javascript:cmdCancel('"+appGroupOID+"')";

                                                                    ctrLine.setBackCaption(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_BACK,true));
                                                                    ctrLine.setSaveCaption(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_SAVE,true));
                                                                    ctrLine.setDeleteCaption(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_ASK,true));
                                                                    ctrLine.setConfirmDelCaption(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_DELETE,true));
                                                                    ctrLine.setAddCaption(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_ADD,true));
                                                                    ctrLine.setCancelCaption(ctrLine.getCommand(SESS_LANGUAGE,cmdTitle,ctrLine.CMD_CANCEL,false));

                                                                    if (privDelete){
                                                                            ctrLine.setConfirmDelCommand(sconDelCom);
                                                                            ctrLine.setDeleteCommand(scomDel);
                                                                            ctrLine.setEditCommand(scancel);
                                                                    }else{ 
                                                                            ctrLine.setConfirmDelCaption("");
                                                                            ctrLine.setDeleteCaption("");
                                                                            ctrLine.setEditCaption("");
                                                                    }

                                                                    if(privAdd == false  && privUpdate == false){
                                                                            ctrLine.setSaveCaption("");
                                                                    }

                                                                    if (privAdd == false){
                                                                            ctrLine.setAddCaption("");
                                                                    }
                                                                    %>
                                        <%= ctrLine.drawImage(iCommand, iErrCode, msgString)%> </td>
                                    </tr>
                                    <% } else { %>
                                    <tr> 
                                      <td width="13%">&nbsp; Processing OK .. back to list. </td>
                                      <td width="87%" colspan="2">&nbsp; <a href="javascript:cmdBack()">click here</a> 
                                        <script language="JavaScript">
                                                                    cmdBack();
                                                            </script>
                                      </td>
                                    </tr>
                                    <% } %>
                                    <tr> 
                                      <td colspan="3">&nbsp;</td>
                                    </tr>
                                  </table>
                                </form>
                         </div>
                     </div>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- jQuery 2.0.2 -->
        <script src="../styles/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../styles/bootstrap3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="../styles/bootstrap3.1/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="../styles/bootstrap3.1/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../styles/bootstrap3.1/js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- page script -->
        <script type="text/javascript">
            $(function() {
                $("#example1").dataTable();
                $('#example2').dataTable({
                    "bPaginate": true,
                    "bLengthChange": false,
                    "bFilter": false,
                    "bSort": true,
                    "bInfo": true,
                    "bAutoWidth": false
                });
            });
            $('#compose-modal').modal(
                {
                    backdrop:'static',
                    show:false
                }
            );
        </script>
    </body>
</html>