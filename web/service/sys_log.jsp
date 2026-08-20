<%-- 
    Document   : sys_log
    Created on : May 8, 2015, 12:14:04 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.dtaxintegration.entity.inquery.Simpatda"%>
<%@page import="com.dimata.dtaxintegration.session.SessSimpatda"%>
<%@page import="com.dimata.dtaxintegration.session.DTaxIntegrationManager"%>
<%@page import="com.dimata.util.Command"%>
<%@ page language = "java" %>

<!-- package java -->

<%@ page import = "java.util.*" %>

<!-- package dimata -->

<%@ page import = "com.dimata.util.*" %>

<!-- package qdep -->

<%@ page import = "com.dimata.gui.jsp.*" %>

<%@ page import = "com.dimata.qdep.form.*" %>

<!--package hanoman -->
<%!//proses yang akan ditampilkan

    public String drawList(int iCommand, Vector objectClass) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");
        ctrlist.addHeader("ID", "200px");
        ctrlist.addHeader("BULAN", "200px");
        ctrlist.addHeader("TAHUN", "200px");
        ctrlist.addHeader("NAMA", "200px");
        ctrlist.addHeader("JUMLAH_PAJAK", "200px");
        ctrlist.addHeader("INSTANSI", "200px");
        ctrlist.addHeader("NO_SSPD", "200px");
        ctrlist.addHeader("NPWD", "200px");
         
        if (iCommand != Command.EDIT) {
            ctrlist.setLinkRow(0);
        }
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();
        int count=0;
        
        Vector rowx = new Vector(1, 1);
        
        for (int i = 0; i < objectClass.size(); i++) {
            Simpatda simpatda = (Simpatda) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            rowx.add(""+count);
            rowx.add(""+simpatda.getId());
            rowx.add(""+simpatda.getBulanSimpatda());
            rowx.add(""+simpatda.getTahunSimpatda());
            rowx.add(""+simpatda.getNamaSimpatda());
            rowx.add(""+simpatda.getJumlahPajakSimpatda());
            rowx.add(""+simpatda.getInstansi());
            rowx.add(""+simpatda.getNoSspdSimpatda());
            rowx.add(""+simpatda.getNpwpd());
            
            lstData.add(rowx);
        }
        return ctrlist.draw();
    }
%>

<%
    int prevCommand = FRMQueryString.requestInt(request, "prev_command");

    int iCommand = FRMQueryString.requestCommand(request);

    DTaxIntegrationManager dTaxIntegrationManager = new DTaxIntegrationManager();

    int start = 0;

    if (request.getParameter("start") != null) {

        start = Integer.parseInt(request.getParameter("start"));

    }
    switch (iCommand) {

        case Command.START:

            dTaxIntegrationManager.startMonitor();

            break;



        case Command.STOP:

            dTaxIntegrationManager.stopMonitor();

            break;

    }
    //----------
    boolean running = dTaxIntegrationManager.getStatus();
    
    Vector vSimpatda = new Vector();
%>

<!-- End of Jsp Block -->

<html><!-- #BeginTemplate "/Templates/main_s_3.dwt" -->

    <head>

        <!-- #BeginEditable "doctitle" --> 

        <title>Hanoman - Monitoring Service</title>

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

        <!-- #EndEditable -->

        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

        <script language="JavaScript">

        <!--



        //-->

        </script>


    </head>



    <body bgcolor="#FFFFFF" text="#000000" leftmargin="3" topmargin="3">

        <table width="100%" border="0" cellpadding="0" cellspacing="0">

            <tr> 

                <td width="100%" height="180" align="center" valign="top">

                    <table width="98%" border="0" cellpadding="1" cellspacing="0">

                        <!--DWLayoutTable-->

                        <tr> 

                            <td align="center" valign="top" class="frmcontents"><table width="100%" border="0" cellpadding="0" cellspacing="0">

                                    <!--DWLayoutTable-->

                                    <tr> 

                                        <td  height="178" align="center" valign="middle" class="contents">

                                            <table width="100%" border="0" cellspacing="2" cellpadding="2">

                                                <tr>

                                                    <td>

                                                        <!-- #BeginEditable "contents" -->



                                                        <form name="fr_syslog" method="post" action="">

                                                            <input type="hidden" name="command" value="<%=iCommand%>">	  			  
                                                            <input type="hidden" name="start" value="<%=start%>">
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
                                                                <tr> 

                                                                    <td colspan="3" class="title"><b>View Tabel</b></td>

                                                                </tr>
                                                                <tr> 

                                                                    <td colspan="3" class="title"><input type="button" name="Submit2" value="  Search  " onClick="javascript:cmdSearch()" class="formElemen"></td>

                                                                </tr>
                                                                <tr> 

                                                                    <td colspan="3"><%=drawList(iCommand,vSimpatda)%> </td>

                                                                </tr>

                                                                <tr> 

                                                                    <td colspan="3" align="right"> 

                                                                        <table width="26%" border="0" cellspacing="2" cellpadding="3" align="left">

                                                                            <tr> 

                                                                                <td></td>

                                                                            </tr>

                                                                        </table>

                                                                    </td>

                                                                </tr>

                                                            </table>

                                                        </form>

                                                        <!-- #EndEditable --> </td>

                                                </tr>

                                            </table>



                                        </td>

                                    </tr>

                                </table></td>

                        </tr>

                    </table></td>

                <td width="1">&nbsp;</td>

            </tr>

            <tr>
                <td height="15" colspan="4"  align="center" valign="top" collspan="2"></td>
            </tr>
            <tr>
                <td height="15" colspan="4"  align="center" valign="top" collspan="2"></td>
            </tr>
            <td colspan="2" height="20"> <!-- #BeginEditable "footer" -->

            </td>

        </table>





    </body>

    <!-- #EndTemplate --></html>

