<%-- 
    Document   : automatic_payment_pbb
    Created on : Aug 10, 2015, 11:36:16 PM
    Author     : xml
--%>

<%@page import="com.dimata.dtaxintegration.session.DTaxIntegrationManagerPaymentPbb"%>
<%@page import="com.dimata.dtaxintegration.session.DTaxIntegrationManager"%>
<%-- 
    Document   : pbb
    Created on : May 22, 2015, 6:09:28 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.dtaxintegration.entity.tagihan.FileSent"%>
<%@page import="com.dimata.webclient.UploadFile"%>
<%@page import="com.dimata.dtaxintegration.entity.inquery.Pbb"%>
<%-- 
    Document   : report_bbm_summary
    Created on : May 1, 2015, 10:06:28 AM
    Author     : dimata005
--%>
<%@page import="com.dimata.util.Formater"%>
<%@page import="java.util.Date"%>
<%@page import="com.dimata.dtaxintegration.entity.inquery.Simpatda"%>
<%@page import="com.dimata.dtaxintegration.session.SessSimpatda"%>
<%@page import="com.dimata.dtaxintegration.session.SrcReport"%>
<%@page import="com.dimata.qdep.form.FRMHandler"%>
<%@page import="com.dimata.gui.jsp.ControlDate"%>
<%@page import="com.dimata.gui.jsp.ControlCombo"%>
<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.gui.jsp.ControlLine"%>
<%@page import="com.dimata.qdep.form.FRMMessage"%>
<%@page import="com.dimata.qdep.form.FRMQueryString"%>
<%@page import="com.dimata.gui.jsp.ControlList"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<%@ include file = "../../main/javainit.jsp" %>
<% //int  appObjCode = AppObjInfo.composeObjCode(AppObjInfo.G1_LOGIN, AppObjInfo.G2_LOGIN, AppObjInfo.OBJ_LOGIN_LOGIN); %>
<%@ include file = "../../main/checkuser.jsp" %>

<% //proses yang tidak akan ditampilkan hanya diserver side

    int prevCommand = FRMQueryString.requestInt(request, "prev_command");

    int iCommand = FRMQueryString.requestCommand(request);

    DTaxIntegrationManagerPaymentPbb dTaxIntegrationManagerPaymentPbb = new DTaxIntegrationManagerPaymentPbb();

    int start = 0;

    if (request.getParameter("start") != null) {

        start = Integer.parseInt(request.getParameter("start"));

    }
    switch (iCommand) {

        case Command.START:

            dTaxIntegrationManagerPaymentPbb.startMonitor();

            break;



        case Command.STOP:

            dTaxIntegrationManagerPaymentPbb.stopMonitor();

            break;

    }
    boolean running = dTaxIntegrationManagerPaymentPbb.getStatus();
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pajak dan Retribusi Daerah Terintegrasi Pembayaran Online</title>
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

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="../../styles/bootstrap3.1/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="../../styles/bootstrap3.1/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script language="JavaScript">

            function cmdStop(){

                document.fr_syslog.command.value="<%= Command.STOP%>";

                document.fr_syslog.start.value="0";

                document.fr_syslog.submit();
	  
            }
            
            
            function cmdSearch(){
                document.fr_syslog.command.value="<%= Command.SEARCH%>";

                document.fr_syslog.start.value="0";

                document.fr_syslog.submit();
            }
            
            function cmdStart(){

                document.fr_syslog.start.value="0";

                document.fr_syslog.command.value="<%= Command.START%>";	  

                document.fr_syslog.submit();

            }



            function cmdListLog(){

                document.fr_syslog.command.value="<%= Command.LIST%>";

                document.fr_syslog.start.value="0";

                document.fr_syslog.submit();

            }

  

            function cmdClearLog(){

                if(confirm("Are you sure you want to delete all existing log?\nWarning...\nThis can not be undone!!!")){

                    document.fr_syslog.command.value="<%= Command.DELETE%>";		  

                    document.fr_syslog.submit();

                }

            } 



            function cmdListFirst(){

                document.fr_syslog.command.value="<%=Command.FIRST%>";

                document.fr_syslog.action="sys_log.jsp";

                document.fr_syslog.submit();

            }



            function cmdListPrev(){

                document.fr_syslog.command.value="<%=Command.PREV%>";

                document.fr_syslog.action="sys_log.jsp";

                document.fr_syslog.submit();

            }

            function cmdListNext(){

                document.fr_syslog.command.value="<%=Command.NEXT%>";

                document.fr_syslog.action="sys_log.jsp";

                document.fr_syslog.submit();

            }

            function cmdListLast(){

                document.fr_syslog.command.value="<%=Command.LAST%>";

                document.fr_syslog.action="sys_log.jsp";

                document.fr_syslog.submit();

            }

            function backMenu(){	
                document.fr_syslog.submit();

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
        <div id="theLockPane" class="LockOff"></div>
        <!-- header logo: style can be found in header.less -->
        <%@ include file = "../../header_mobile.jsp" %> 
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <%@ include file = "../../menu_left_mobile.jsp" %> 
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>Pajak dan Retribusi Daerah Terintegrasi Pembayaran Online
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <form name="fr_syslog"  method ="post" action="" role="form">
                        <input type="hidden" name="command" value="<%=iCommand%>">
                        <input type="hidden" name="start" value="<%=start%>">
                        <input type="hidden" name="prev_command" value="<%=prevCommand%>">
                        <input type="hidden" name="start" value="<%=start%>">
                        <input type="hidden" name="menu" value="40">
                        <input type="hidden" name="tree" value="6">
                        <div class="row">
                            <div class="col-xs-12">
                               <div class="box">
                                   <div class="box-header">
                                       &nbsp;
                                   </div>    
                                   <div class="box-header">
                                       <div class="col-xs-12"><label> Download Otomatis Pembayaran PBB</label>
                                           <table width="85%" border="0" cellspacing="1" cellpadding="1" align="center">

                                                                <tr> 

                                                                    <td colspan="3" class="title"><b>Monitoring Service</b></td>

                                                                </tr>

                                                                <tr> 

                                                                    <td width="40%">&nbsp;</td>

                                                                    <td width="4%">&nbsp;</td>

                                                                    <td width="56%">&nbsp;</td>

                                                                </tr>

                                                                <tr> 

                                                                    <td colspan="2">&nbsp;</td>

                                                                    <td width="56%">&nbsp;</td>

                                                                </tr>

                                                                <tr> 

                                                                    <td width="40%"> 

                                                                        <div align="right"><b>STATUS&nbsp;&nbsp;</b></div>

                                                                    </td>

                                                                    <td colspan="2"> 

                                                                        <% if (running) {%>

                                                                        <font color="#009900">Running...</font> 

                                                                        <%} else {%>

                                                                        <font color="#FF0000">Stopped</font> 

                                                                        <%}%>

                                                                    </td>

                                                                </tr>

                                                                <tr> 

                                                                    <td width="40%">&nbsp;</td>

                                                                    <td colspan="2"> 

                                                                        <% String stopSts = "";

                                                                            String startSts = "";

                                                                            if (running) {

                                                                                startSts = "disabled=\"true\"";

                                                                                stopSts = "";

                                                                            } else {

                                                                                startSts = "";

                                                                                stopSts = "disabled=\"true\"";

                                    }%>

                                                                        <%//if(hasExecutePriv){%>

                                                                        <input type="button" name="Button" value="  Start  " onClick="javascript:cmdStart()" class="formElemen" <%=startSts%>>

                                                                        <input type="button" name="Submit2" value="  Stop  " onClick="javascript:cmdStop()" class="formElemen" <%=stopSts%>>

                                                                        <%//}%>

                                                                    </td>

                                                                </tr>

                                                                <tr> 

                                                                    <td colspan="3"> 

                                                                        <hr>

                                                                    </td>

                                                                </tr>

                                                            </table>
                                       </div>
                                    </div>
                                </div><!-- /.box -->
                            </div>
                        </div>      
                    </form>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- jQuery 2.0.2 -->
        <script src="../../styles/bootstrap3.1/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../styles/bootstrap3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="../../styles/bootstrap3.1/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="../../styles/bootstrap3.1/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../styles/bootstrap3.1/js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- page script -->
        <script src="../../styles/datepicker/js/jquery.ui.core.js"></script>
        <script src="../../styles/datepicker/js/jquery.ui.widget.js"></script>
        <script src="../../styles/datepicker/js/jquery.ui.datepicker.js"></script>

        <script type="text/javascript">
            $(function() {
                //$("#example1").dataTable();
                $('#example2').dataTable({
                    "bPaginate": true,
                    "bLengthChange": false,
                    "bFilter": false,
                    "bSort": true,
                    "bInfo": true,
                    "bAutoWidth": false
                });
            });
            
        </script>
        <script>
            $(function() {
                    $( "#datepicker" ).datepicker({ dateFormat: "yy-mm-dd" });
            });
	</script>
        <script>
            $(function() {
                    $( "#datepickerdua" ).datepicker({ dateFormat: "yy-mm-dd" });
            });
	</script>
         <script>
            $(function() {
                    $( "#datepickertiga" ).datepicker({ dateFormat: "yy-mm-dd" });
            });
	</script>
        
    </body>
</html>


