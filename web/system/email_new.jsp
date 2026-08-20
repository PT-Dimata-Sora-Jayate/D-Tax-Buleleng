<%-- 
    Document   : email
    Created on : Feb 24, 2014, 9:59:28 AM
    Author     : Fitra
--%>

<%@page import="com.dimata.common.form.email.FrmSettingEmail"%>
<%@page import="com.dimata.common.entity.email.PstSettingEmail"%>
<%@page import="com.dimata.common.form.email.CtrlSettingEmail"%>
<%@page import="com.dimata.common.entity.email.SettingEmail"%>
<%@page import="com.dimata.util.Command"%>

<%@page import = "com.dimata.common.entity.email.PstSettingEmail"%> 
import com.dimata.common.entity.email.SettingEmail;
<%@page import="com.dimata.gui.jsp.ControlLine"%>
<%@page import="com.dimata.qdep.form.FRMMessage"%>
<%@page import="com.dimata.qdep.form.FRMQueryString"%>
<%@page import="com.dimata.gui.jsp.ControlList"%>
<%@page import="java.util.Vector"%>
<%@ page language = "java" %>
<!-- package java -->
<%@ page import = "com.dimata.util.*,
                   com.dimata.common.jsp.JspInfo" %>
<!-- package qdep -->
<%@ page import = "com.dimata.gui.jsp.*" %>
<%@ page import = "com.dimata.qdep.form.*" %>
<!--package common -->
<%@ page import = "com.dimata.common.entity.periode.*" %>
<%@ page import = "com.dimata.common.form.periode.*" %>

<%@ page import = "java.util.*,
                   com.dimata.common.entity.email.SettingEmail,
                   com.dimata.gui.jsp.ControlList,
                   com.dimata.gui.jsp.ControlLine,
                   com.dimata.qdep.form.FRMQueryString,
                   com.dimata.util.Command"%>

<%@ include file = "../main/javainit.jsp" %>
<% int  appObjCode = AppObjInfo.composeObjCode(AppObjInfo.G1_ADMIN, AppObjInfo.G2_ADMIN_SYSTEM, AppObjInfo.OBJ_ADMIN_SYSTEM_APP_SET); %>
<%@ include file = "../main/checkuser.jsp" %>

<!-- Jsp Block -->
<%!
/* this constant used to list text of listHeader */
public static final String textListHeader[][] =
{
	{"Email Name","Password","Host","Port","Status","Batas Input"},
	{"Period Name","Type","Start Date","End Date","Status","Last Entry"}
};

public String drawList(int language,Vector objectClass, long idEmail)
{
       
	
	ControlList ctrlist = new ControlList();
	ctrlist.setAreaWidth("100%");
	ctrlist.setListStyle("listgen");
	ctrlist.setTitleStyle("listgentitle");
	ctrlist.setCellStyle("listgensell");
	ctrlist.setHeaderStyle("listgentitle");
	ctrlist.addHeader(textListHeader[language][0],"3%");
	ctrlist.addHeader(textListHeader[language][1],"5%");
	ctrlist.addHeader(textListHeader[language][2],"15%");
	ctrlist.addHeader(textListHeader[language][3],"15%");
	
	
	
	// untuk header pada PDF
	
	
	ctrlist.setLinkRow(0);
	ctrlist.setLinkSufix("");
	Vector lstData = ctrlist.getData();
	Vector lstLinkData = ctrlist.getLinkData();
	ctrlist.setLinkPrefix("javascript:cmdEdit('");
	ctrlist.setLinkSufix("')");
	ctrlist.reset();
	
	int index = -1;
		
	for (int i = 0; i < objectClass.size(); i++) {
		SettingEmail settingEmail = (SettingEmail)objectClass.get(i);
		Vector rowx = new Vector();
		  if (idEmail == settingEmail.getOID()) {
                index = i;
            }
		
				
		rowx.add(settingEmail.getEmailName()); 
		rowx.add(settingEmail.getPassword());
		rowx.add(settingEmail.getHost());
                rowx.add(settingEmail.getPort());
		
		

		lstData.add(rowx);
		lstLinkData.add(String.valueOf(settingEmail.getOID()));
	}
	return ctrlist.draw(index);
}
%>
<%
int iCommand = FRMQueryString.requestCommand(request);
int start = FRMQueryString.requestInt(request, "start");
int prevCommand = FRMQueryString.requestInt(request, "prev_command");
long oidEmail = FRMQueryString.requestLong(request, "hidden_email");
String periodTitle = "Periode"; //JspInfo.txtMaterialInfo[SESS_LANGUAGE][JspInfo.MATERIAL_PERIOD];
//Date dt = FRMQueryString.requestDate(request, ""+FrmSettingEmail.fieldNames[FrmSettingEmail.FRM_FIELD_LAST_ENTRY]+"");

/* variable declaration */
int recordToGet = 10;
String msgString = "";
int iErrCode = FRMMessage.NONE;
String whereClause = "";
String orderClause = PstSettingEmail.fieldNames[PstSettingEmail.FLD_EMAIL_NAME];

CtrlSettingEmail ctrlSettingEmail = new CtrlSettingEmail(request);
ControlLine ctrLine = new ControlLine();
Vector listEmail = new Vector(1,1);
String locationTitle = textListHeader[SESS_LANGUAGE][0];
    

iErrCode = ctrlSettingEmail.action(iCommand,oidEmail);
FrmSettingEmail frmSettingEmail = ctrlSettingEmail.getForm();

int vectSize = PstSettingEmail.getCount(whereClause);
SettingEmail settingEmail = ctrlSettingEmail.getSettingEmail();


if((iCommand == Command.SAVE) && (iErrCode == FRMMessage.NONE))
	//start = PstSettingEmail.findLimitStart(settingEmail.getOID(),recordToGet, whereClause, "");

if((iCommand == Command.FIRST || iCommand == Command.PREV )||
  (iCommand == Command.NEXT || iCommand == Command.LAST)){
		start = ctrlSettingEmail.actionList(iCommand,start,vectSize,recordToGet);
}

listEmail = PstSettingEmail.list(start,recordToGet,whereClause,orderClause);
if (listEmail.size()<1 && start>0)
{
	 if (vectSize - recordToGet > recordToGet)
			start = start - recordToGet;
	 else{
		 start = 0 ;
		 iCommand = Command.FIRST;
		 prevCommand = Command.FIRST;
	 }
	 listEmail = PstSettingEmail.list(start,recordToGet,whereClause,orderClause);
}
%>

<html><!-- #BeginTemplate "/Templates/main.dwt" --><!-- DW6 -->
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
<script language="JavaScript">
function cmdSave(){
	document.frmsettingemail.command.value="<%=Command.SAVE%>";
	document.frmsettingemail.prev_command.value="<%=prevCommand%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
	}

function cmdEdit(oidEmail){
	document.frmsettingemail.hidden_email.value=oidEmail;
	document.frmsettingemail.command.value="<%=Command.EDIT%>";
	document.frmsettingemail.prev_command.value="<%=prevCommand%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
	}

function cmdBack(){
	document.frmsettingemail.command.value="<%=Command.BACK%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
	}

   function cmdAdd(){
                document.frmsettingemail.hidden_email.value="0";
                document.frmsettingemail.command.value="<%=Command.ADD%>";
                document.frmsettingemail.prev_command.value="<%=prevCommand%>";
                document.frmsettingemail.action="email.jsp";
                document.frmsettingemail.submit();
            }

function cmdListFirst(){
	document.frmsettingemail.command.value="<%=Command.FIRST%>";
	document.frmsettingemail.prev_command.value="<%=Command.FIRST%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
}

function cmdListPrev(){
	document.frmsettingemail.command.value="<%=Command.PREV%>";
	document.frmsettingemail.prev_command.value="<%=Command.PREV%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
	}

function cmdListNext(){
	document.frmsettingemail.command.value="<%=Command.NEXT%>";
	document.frmsettingemail.prev_command.value="<%=Command.NEXT%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
}

function cmdListLast(){
	document.frmsettingemail.command.value="<%=Command.LAST%>";
	document.frmsettingemail.prev_command.value="<%=Command.LAST%>";
	document.frmsettingemail.action="email.jsp";
	document.frmsettingemail.submit();
}

function backMenu(){
	document.frmsettingemail.action="<%=approot%>/management/main_material.jsp";
	document.frmsettingemail.submit();
}

//-------------- script control line -------------------
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
            <form name="frmsettingemail" method ="post" action="">
              <input type="hidden" name="command" value="<%=iCommand%>">
                                                                                     
                                                                                    <input type="hidden" name="vectSize" value="<%=vectSize%>">
                                                                                    <input type="hidden" name="start" value="<%=start%>">
                                                                                    <input type="hidden" name="prev_command" value="<%=prevCommand%>">
                                                                                    <input type="hidden" name="commandRefresh" value= "0">
                                                                                    <input type="hidden" name="hidden_email" value="<%=oidEmail%>">		  
              <input type="hidden" name="<%=FrmSettingEmail.FRM_SETTING_EMAIL%>" method="POST" action="">
              <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr align="left" valign="top"> 
					<td height="8" valign="middle" colspan="3"> 
					  <hr size="1">
					</td>
                                        
				</tr>                							  
                <tr align="left" valign="top"> 
                  <td height="8"  colspan="3"> 
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr align="left" valign="top"> 
                        <td height="14" valign="middle" colspan="3" class="comment">&nbsp;<u><%=SESS_LANGUAGE==com.dimata.util.lang.I_Language.LANGUAGE_DEFAULT ? "Daftar "+locationTitle : locationTitle+" List"%></u></td>                      
					  </tr>
                      <tr align="left" valign="top"> 
                        <td height="22" valign="middle" colspan="3"> <%= drawList(SESS_LANGUAGE,listEmail, oidEmail)%> </td>
                      </tr>
                      <tr align="left" valign="top"> 
                        <td height="8" align="left" colspan="3" class="command"> 
                          <span class="command"> 
                          <% 
						  int cmd = 0;
						  if(iCommand==Command.FIRST || iCommand==Command.PREV || iCommand==Command.NEXT || iCommand==Command.LAST){
							  cmd =iCommand; 
						  }else{
							  if(iCommand==Command.NONE || prevCommand==Command.NONE)
								cmd = Command.FIRST;
							  else 
								cmd =prevCommand; 
						  } 						  
                          ctrLine.setLocationImg(approot+"/images");
						  ctrLine.initDefault();							
                          out.println(ctrLine.drawImageListLimit(cmd, vectSize, start, recordToGet));
						  %> 
						  </span>
						</td>
                      </tr>
                      
                      <%/* if(iCommand != Command.NONE){
                        iCommand = Command.LIST;
                          
                      }*/
                      %>
					  <%
					           if(iCommand==Command.NONE
                                                   &&  iCommand!=Command.LIST
						   
						   || iCommand==Command.BACK 
						   || (iCommand==Command.SAVE&&iErrCode==0) || (iCommand==Command.DELETE && iErrCode==0)){
					  %>					  
                      <tr align="left" valign="top"> 
                        <td> 
                          <%if(((iCommand==Command.ADD)&&(iCommand==Command.EDIT)&&(iCommand==Command.ASK)) && (iCommand ==Command.NONE) ||(iCommand != Command.SAVE&&iErrCode ==0) || (iCommand==Command.DELETE && iErrCode ==0)){%>
                          <table cellpadding="0" cellspacing="0" border="0">
                            <tr> 
                              <td width="4"><img src="<%=approot%>/images/spacer.gif" width="1" height="1"></td>
                              <td width="24"><a href="javascript:cmdAdd()" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image261','','<%=approot%>/images/BtnNewOn.jpg',1)"><img name="Image261" border="0" src="<%=approot%>/images/BtnNew.jpg" width="24" height="24" alt="<%=ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_ADD,true)%>"></a></td>
                              <td width="6"><img src="<%=approot%>/images/spacer.gif" width="1" height="1"></td>
                              <td height="22" valign="middle" colspan="3" width="172"><a href="javascript:cmdAdd()" class="command"><%=ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_ADD,true)%></a></td>
                            </tr>
                          </table>
                          <%}%>
                        </td>
                      </tr>
		<%}%>					  
                    </table>
                  </td>
                </tr>
				
                <tr align="left" valign="top"> 
                  <td height="8" valign="middle" colspan="3"> 
				  
                    <%
					  if((iCommand ==Command.ADD)
						||(iCommand==Command.EDIT)
						||(iCommand==Command.ASK)					  
					    ||((iCommand==Command.SAVE) && iErrCode>0) || (iCommand==Command.DELETE && iErrCode>0))
					  {
					%>
                  <table width="100%" border="0" cellspacing="2" cellpadding="2">
                 
                      
                                                                                                    <tr align="left" valign="top">
                                                                                                                    <td valign="top" width="18%">Email Name</td>
                                                                                                                    <td width="82%">
                                                                                                                        <input type="text" name="<%=frmSettingEmail.fieldNames[FrmSettingEmail.FRM_EMAIL_NAME]%>"  value="<%= settingEmail.getEmailName()%>" class="elemenForm" size="35">
                                                                                                                        * <%=frmSettingEmail.getErrorMsg(FrmSettingEmail.FRM_EMAIL_NAME)%>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                                <tr align="left" valign="top">
                                                                                                                    <td valign="top" width="18%"> Password </td>
                                                                                                                    <td width="82%">
                                                                                                                        <input type="password" name="<%=frmSettingEmail.fieldNames[FrmSettingEmail.FRM_PASSWORD]%>"  value="<%= settingEmail.getPassword()%>" class="elemenForm" size="35">
                                                                                                                        * <%=frmSettingEmail.getErrorMsg(FrmSettingEmail.FRM_PASSWORD)%></td>
                                                                                                                </tr>
                                                                                                                
                                                                                                                  <tr align="left" valign="top">
                                                                                                                    <td valign="top" width="18%"> Host </td>
                                                                                                                    <td width="82%">
                                                                                                                        <input type="text" name="<%=frmSettingEmail.fieldNames[FrmSettingEmail.FRM_HOST]%>"  value="<%= settingEmail.getHost()%>" class="elemenForm" size="35">
                                                                                                                        * <%=frmSettingEmail.getErrorMsg(FrmSettingEmail.FRM_HOST)%></td>
                                                                                                                </tr>
                                                                                                                
                                                                                                                
                                                                                                                  <tr align="left" valign="top">
                                                                                                                    <td valign="top" width="18%"> Port </td>
                                                                                                                    <td width="82%">
                                                                                                                        <input type="text" name="<%=frmSettingEmail.fieldNames[FrmSettingEmail.FRM_PORT]%>"  value="<%= settingEmail.getPort()%>" class="elemenForm" size="35">
                                                                                                                        * <%=frmSettingEmail.getErrorMsg(FrmSettingEmail.FRM_PORT)%></td>
                                                                                                                </tr>
                                                                                                                 </table>
                                                                                                        </td>
                                                                                                    </tr>
                      <tr align="left" valign="top" > 
                        <td colspan="2" class="command"> 
                           <%
							ctrLine.setLocationImg(approot+"/images");
							
							// set image alternative caption
							ctrLine.setSaveImageAlt(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_SAVE,true));
							ctrLine.setBackImageAlt(SESS_LANGUAGE==com.dimata.util.lang.I_Language.LANGUAGE_DEFAULT ? ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_BACK,true) : ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_BACK,true)+" List");							
							ctrLine.setDeleteImageAlt(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_ASK,true));							
							ctrLine.setEditImageAlt(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_CANCEL,false));														

							ctrLine.initDefault();
							ctrLine.setTableWidth("100%");
							String scomDel = "javascript:cmdAsk('"+oidEmail+"')";
							String sconDelCom = "javascript:cmdConfirmDelete('"+oidEmail+"')";
							String scancel = "javascript:cmdEdit('"+oidEmail+"')";
							ctrLine.setCommandStyle("command");
							ctrLine.setColCommStyle("command");
							
							// set command caption
							ctrLine.setSaveCaption(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_SAVE,true));
							ctrLine.setBackCaption(SESS_LANGUAGE==com.dimata.util.lang.I_Language.LANGUAGE_DEFAULT ? ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_BACK,true) : ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_BACK,true)+" List");							
							ctrLine.setDeleteCaption(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_ASK,true));							
							ctrLine.setConfirmDelCaption(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_DELETE,true));														
							ctrLine.setCancelCaption(ctrLine.getCommand(SESS_LANGUAGE,locationTitle,ctrLine.CMD_CANCEL,false));							
							
							
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
                          <%= ctrLine.drawImage(iCommand, iErrCode, msgString)%></td>
                      </tr>
                    </table>
                    <%}%>
					
                  </td>
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
