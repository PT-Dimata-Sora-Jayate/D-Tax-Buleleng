<%@page import="com.dimata.util.Formater"%>
<%@page import="com.dimata.webclient.AppSetting"%>
<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.dimata.wponline.entity.wajibpajakonline.WajibPajak"%>
<%@page import="com.dimata.wponline.form.wajibpajakonline.CtrlWajibPajak"%>
<%@page import="com.dimata.wponline.form.wajibpajakonline.FrmWajibPajak"%>
<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.gui.jsp.ControlLine"%>
<%@page import="com.dimata.wponline.entity.wajibpajakonline.PstWajibPajak"%>
<%@page import="com.dimata.gui.jsp.ControlList"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" %>

<%@ include file ="../../main/javainit.jsp" %>
<% int  appObjCode = AppObjInfo.composeObjCode(AppObjInfo.G1_ADMIN , AppObjInfo.G2_ADMIN_USER, AppObjInfo.OBJ_ADMIN_USER_USER); %>
<%@ include file = "../../main/checkuser.jsp" %>

<%!
    public static final String textListTitleHeader[][] =
    {
        {"WP ID","Nama User","Password","Nama Wajib Pajak","Alamat","NOP","Telepon","Fax","Status","Email","Kode Konfirmasi","Tgl Pendaftaran"},
        {"WP ID","User Name","Password","Nama Wajib Pajak","Alamat","NOP","telepon","Fax","Status","Email","Kode Konfirmasi","Tgl Pendaftaran"}
    };
    
    public static final String statusText[]={"Registrasi","Konfirmasi","Approve","Reject"};
    
    public String drawListWajibPajak(int language,Vector objectClass)
    {
            String temp = ""; 
            String regdatestr = "";

            ControlList ctrlist = new ControlList();
            ctrlist.setAreaWidth("90%");
            ctrlist.setListStyle("listgen");
            ctrlist.setTitleStyle("listgentitle");
            ctrlist.setCellStyle("listgensell");
            ctrlist.setHeaderStyle("listgentitle");
            ctrlist.addHeader(textListTitleHeader[language][1],"20%");
            ctrlist.addHeader(textListTitleHeader[language][9],"35%");
            ctrlist.addHeader(textListTitleHeader[language][3],"35%");
            ctrlist.addHeader(textListTitleHeader[language][11],"10%");
            ctrlist.addHeader(textListTitleHeader[language][8],"10%");
           

            ctrlist.setLinkRow(0);
            ctrlist.setLinkSufix("");

            Vector lstData = ctrlist.getData();

            Vector lstLinkData 	= ctrlist.getLinkData();

            ctrlist.setLinkPrefix("javascript:cmdEdit('");
            ctrlist.setLinkSufix("')");
            ctrlist.reset();

            for (int i = 0; i < objectClass.size(); i++) {
                     WajibPajak wajibPajak = (WajibPajak)objectClass.get(i);

                     Vector rowx = new Vector();

                     rowx.add(String.valueOf(wajibPajak.getNamaUser()));
                     rowx.add(String.valueOf(wajibPajak.getEmail()));
                     rowx.add(String.valueOf(wajibPajak.getNamaWajibPajak()));
                     rowx.add(String.valueOf(wajibPajak.getTglPendaftaran()));
                     rowx.add(String.valueOf(statusText[Integer.parseInt(wajibPajak.getStatus())]));		 

                     lstData.add(rowx);
                     lstLinkData.add(String.valueOf(wajibPajak.getOID()));
            }						

            return ctrlist.drawBootstrapStrip();
    }
    
    %>
    
    <%

    /* VARIABLE DECLARATION */
    int recordToGet = 0;

    String order = " " + PstWajibPajak.fieldNames[PstWajibPajak.FLD_NAMA_WAJIB_PAJAK];

    Vector listWajibPajak = new Vector(1,1);
    ControlLine ctrLine = new ControlLine();

    /* GET REQUEST FROM HIDDEN TEXT */
    int iCommand = FRMQueryString.requestCommand(request);
    int start = 0;//FRMQueryString.requestInt(request, "start"); 
    long wajibPajakOid = FRMQueryString.requestLong(request,"wp_oid");
    int listCommand = FRMQueryString.requestInt(request, "list_command");
    if(listCommand==Command.NONE)
     listCommand = Command.LIST;

    CtrlWajibPajak ctrlWajibPajak = new CtrlWajibPajak(request);

    int vectSize = PstWajibPajak.getCount(""); 
    start = ctrlWajibPajak.actionList(listCommand, start,vectSize,recordToGet);
    
    String tanggalDaftar = FRMQueryString.requestString(request, "tanggalDaftar");
    
    String email = FRMQueryString.requestString(request, "email");
    String namaWajibPajak = FRMQueryString.requestString(request,"namaWajibPajak");
    String status = FRMQueryString.requestString(request,"status");
    int statusInt=-1;
    String whereClause="1=1";
    String oDate = "";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    if (tanggalDaftar!=""){
        if(AppSetting.SQL_VERSION == AppSetting.DBSVR_ORACLE){
             Date transaksiDate = formatter.parse(tanggalDaftar);
             oDate = Formater.formatDate(transaksiDate,"dd-MMM-yy");
                
             /*whereClause += " AND "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_TGL_PENDAFTARAN]
                  +" BETWEEN TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')"
                  +" AND TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')";*/
             whereClause += " AND "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_TGL_PENDAFTARAN]+" LIKE '%"+ oDate.toUpperCase() +"%'";
        }else{
            whereClause += " AND "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_TGL_PENDAFTARAN]+"= '"+ tanggalDaftar +"'";
        }
    }
    if (email!=""){
        whereClause += " AND "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_EMAIL]+"= '"+ email +"'";
    }
    if (status!=""){
        whereClause += " AND "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_STATUS]+"= '"+status+"'";
        statusInt = Integer.parseInt(status);
    }
    if (namaWajibPajak!=""){
        whereClause += " AND "+PstWajibPajak.fieldNames[PstWajibPajak.FLD_NAMA_WAJIB_PAJAK]+" LIKE '%"+ namaWajibPajak +"%'";
    }
    
    listWajibPajak = PstWajibPajak.list(start,recordToGet, whereClause , order);

    %>



<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Data Tables</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link rel="stylesheet" href="../../styles/datepicker/css/jquery.ui.all.css">
        <link href="../../styles/bootstrap3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="../../styles/bootstrap3.1/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="../../styles/bootstrap3.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
        <link href="../../styles/bootstrap3.1/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="../../styles/bootstrap3.1/css/AdminLTE.css" rel="stylesheet" type="text/css" />
    </head>
    <script language="JavaScript">
        function cmdEdit(oid){
            document.frmWajibPajak.wp_oid.value=oid;
            document.frmWajibPajak.list_command.value="<%=listCommand%>";
            document.frmWajibPajak.command.value="<%=Command.EDIT%>";
            document.frmWajibPajak.action="user-online-edit.jsp";
            document.frmWajibPajak.submit();
        }
        
        function cmdSearch(){
            document.frmWajibPajak.command.value="<%=Command.SEARCH%>";
            document.frmWajibPajak.action="user-online.jsp";
            document.frmWajibPajak.submit();
        }

    </script>
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
                             <form name="frmWajibPajak" method="post" action="">
                                  <input type="hidden" name="command" value="">
                                  <input type="hidden" name="wp_oid" value="<%=wajibPajakOid%>">
                                  <input type="hidden" name="vectSize" value="<%=vectSize%>">
                                  <input type="hidden" name="start" value="<%=start%>">
                                  <input type="hidden" name="list_command" value="<%=listCommand%>">
                                   <input type="hidden" name="menu" value="61">
                                   <input type="hidden" name="tree" value="8">
                                  <div class="box-header">
                                    <div class="col-xs-2"><label>Tanggal</label>
                                        <div class="input-group">  
                                            <input name="tanggalDaftar" id="tanggalDaftar" type="text" class="form-control" placeholder="yyyy-MM-dd" value="<%= tanggalDaftar%>">
                                        
                                         </div>
                                    </div>
                                    <div class="col-xs-2"><label>Email</label>
                                        <div class="input-group">  
                                            <input name="email" id="email" type="text" class="form-control" placeholder="Email" value="<%= email%>">
                                        
                                         </div>
                                    </div>
                                    <div class="col-xs-2"><label>Nama Wajib Pajak</label>
                                        <div class="input-group">  
                                        <input name="namaWajibPajak" id="namaWajibPajak" type="text" class="form-control" placeholder="Nama User" value="<%= namaWajibPajak %>">
                                        
                                         </div>
                                    </div>
                                    <div class="col-xs-2"><label>Status</label>
                                        <div class="input-group">  
                                            <select class="form-control" name="status" id="status">
                                                <option value="">--Semua status--</option>
                                                <%
                                                    for (int i =0;i<=3;i++){
                                                        if (i==statusInt){
                                                            out.println("<option selected value='"+i+"'>"+statusText[i]+"</option>");
                                                        }else{
                                                            out.println("<option value='"+i+"'>"+statusText[i]+"</option>");
                                                        }
                                                        
                                                        
                                                    }
                                                %>
                                            </select>
                                         </div>
                                    </div>
                                      <div class="col-xs-2"><label>&nbsp;</label>
                                        <div class="input-group">  
                                            <button id='search' type='button' class='btn btn-success'><i class="glyphicon glyphicon-search"></i> Search</button>
                                        
                                         </div>
                                    </div>
                                   </div>
                                  <table width="100%" cellspacing="0" cellpadding="0">
                                    <tr> 
                                      <td colspan="2" class="listtitle">
                                        <hr size="1">
                                      </td>
                                    </tr>
                                  </table>
                                  <% if ((listWajibPajak!=null)&&(listWajibPajak.size()>0)){ %>
                                  <%=drawListWajibPajak(SESS_LANGUAGE, listWajibPajak)%> 
                                  <%}%>
                                  <table width="100%">
                                    <tr> 
                                      <td colspan="2"> 
                                            <span class="command"> 
                                            <% 
                                             int cmd = 0;
                                             if ((iCommand == Command.FIRST || iCommand == Command.PREV )|| 
                                                  (iCommand == Command.NEXT || iCommand == Command.LAST))
                                                          cmd =iCommand; 
                                             else{
                                                    if(iCommand == Command.NONE)
                                                          cmd = Command.FIRST;
                                             } 
                                             ctrLine.setLocationImg(approot+"/images");
                                             ctrLine.initDefault();						   
                                            %>
                                            <%=ctrLine.drawImageListLimit(cmd,vectSize,start,recordToGet)%> 
                                            </span>				  
                                            </td>
                                    </tr>
                                   
                                    <tr> 
                                      <td width="13%">&nbsp;</td>
                                      <td width="87%">&nbsp;</td>
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
        <script src="../../styles/bootstrap3.1/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="../../styles/bootstrap3.1/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../styles/bootstrap3.1/js/AdminLTE/app.js" type="text/javascript"></script>
        <script src="../../styles/datepicker/js/jquery.ui.core.js"></script>
        <script src="../../styles/datepicker/js/jquery.ui.widget.js"></script>
        <script src="../../styles/datepicker/js/jquery.ui.datepicker.js"></script>
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
            $(function() {
                $( "#tanggalDaftar" ).datepicker({ dateFormat: "yy-mm-dd" });
            });
            
            $('#search').click(function(){
                
                cmdSearch();
            });
        </script>
    </body>