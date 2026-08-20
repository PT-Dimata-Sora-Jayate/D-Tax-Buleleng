<%-- 
    Document   : print_payment_bank
    Created on : Dec 19, 2015, 8:46:46 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentRetribusi"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentRetribusi"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentPbb"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentPbb"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentBphtb"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentBphtb"%>
<%-- 
    Document   : payment_phr
    Created on : May 19, 2015, 7:00:57 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.webclient.AppSetting"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dimata.dtaxintegration.session.DTaxIntegrationMonitor"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentPhr"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentPhr"%>
<%@page import="com.dimata.dtaxintegration.entity.inquery.Payment"%>
<%@page import="com.dimata.webclient.EchoLaporanPaymentDetail"%>
<%@page import="com.dimata.dtaxintegration.entity.laporan.LaporanPayment"%>
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


<%!
    //proses yang akan ditampilkan
    public String drawListDataPaymentPhrDispenda(int iCommand, Vector objectClass, long gradeId) {
        ControlList ctrlist = new ControlList();
        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NPWPD", "200px");//3
        ctrlist.addHeader("NAMA", "200px");//4
        ctrlist.addHeader("DATE", "200px");//5
        ctrlist.addHeader("BULAN", "200px");//6
        ctrlist.addHeader("TAHUN", "200px");//7
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//8
        ctrlist.addHeader("ACTION", "200px");//9
         
        if (iCommand != Command.EDIT) {
            ctrlist.setLinkRow(0);
        }
        
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();

        int index = -1;
        int count=0;
        Vector rowx = new Vector(1, 1);
        double total=0.0;
        
        for (int i = 0; i < objectClass.size(); i++) {
            
            //Simpatda simpatda = (Simpatda) objectClass.get(i);
            PaymentPhr paymentPhr = (PaymentPhr) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+paymentPhr.getIdPayment());//2
            rowx.add(""+paymentPhr.getNpwpd());//3
            rowx.add(""+paymentPhr.getNama());//3
            rowx.add(""+paymentPhr.getTanggal());//4
            rowx.add(""+paymentPhr.getMasaPajak());//6
            rowx.add(""+paymentPhr.getTahunPajak());//7
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentPhr.getJumlahBayar()));//8
            rowx.add("<button type=\"button\" class=\"btn btn-primary\" onclick=\"javascript:cmdPrintPdf('1','"+paymentPhr.getIdPayment()+"')\">Print PHR</button>");//8
            
            total=total+paymentPhr.getJumlahBayar();
            
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("");//1
        rowx.add("");//2
        rowx.add("");//3
        rowx.add("");//4
        rowx.add("");//6
        rowx.add("<b>Total<b>");//7
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//8
        rowx.add("");//8
        
        lstData.add(rowx);
        
        return ctrlist.drawBootstrapStrip();
    }
    
    public String drawListDataPaymentBphtbDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("NO", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("TIB", "200px");//2
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//10
        ctrlist.addHeader("ACTION", "200px");//10
        
        if (iCommand != Command.EDIT) {
            ctrlist.setLinkRow(0);
        }
        
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();

        int index = -1;
        int count=0;
        Vector rowx = new Vector(1, 1);
        double total=0.0;
        
        for (int i = 0; i < objectClass.size(); i++) {
            
            //Simpatda simpatda = (Simpatda) objectClass.get(i);
            PaymentBphtb paymentBphtb = (PaymentBphtb) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+paymentBphtb.getIdPaymentBank());//2
            rowx.add(""+paymentBphtb.getNoTib());//3
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentBphtb.getJumlahBayar()));//4
            rowx.add("<button type=\"button\" class=\"btn btn-primary\" onclick=\"javascript:cmdPrintPdf('2','"+paymentBphtb.getIdPaymentBank()+"')\">Print BPHTB</button>");//4
            total=total+paymentBphtb.getJumlahBayar();
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("");//2
        rowx.add("<b>Total</b>");//3
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//4
        rowx.add("");//1
         
        lstData.add(rowx);

        return ctrlist.drawBootstrapStrip();
    }
    
     public String drawListDataPaymentPbbDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("NO", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NOP", "200px");//3
        ctrlist.addHeader("TAHUN", "200px");//7
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//10
        ctrlist.addHeader("ACTION", "200px");//10
        
        if (iCommand != Command.EDIT) {
            ctrlist.setLinkRow(0);
        }
        
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();

        int index = -1;
        int count=0;
        Vector rowx = new Vector(1, 1);
        double total=0.0;
        
        for (int i = 0; i < objectClass.size(); i++) {
            
            PaymentPbb paymentPbb = (PaymentPbb) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+paymentPbb.getIdPaymentBank());//2
            rowx.add(""+paymentPbb.getNop());//3
            rowx.add(""+paymentPbb.getThnPajakSppt());//4
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentPbb.getJmlSpptYgDibayar()));//6
            rowx.add("<button type=\"button\" class=\"btn btn-primary\" onclick=\"javascript:cmdPrintPdf('3','"+paymentPbb.getIdPaymentBank()+"')\">Print PBB</button>");//4
            total=total+paymentPbb.getJmlSpptYgDibayar();
            
            lstData.add(rowx);
        }
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("");//2
        rowx.add("");//3
        rowx.add("<b>Total</b>");//4
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//6
        rowx.add("");
        
        lstData.add(rowx);
        
        
        return ctrlist.drawBootstrapStrip();
    }
     
     public String drawListDataPaymentRetribusiDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NO REKENING", "200px");//2
        ctrlist.addHeader("NAMA", "200px");//10
        ctrlist.addHeader("SETORAN", "200px");//10
        ctrlist.addHeader("TANGGAL SETORAN", "200px");//10
        ctrlist.addHeader("ACTION", "200px");//10
        
        if (iCommand != Command.EDIT) {
            ctrlist.setLinkRow(0);
        }
        
        ctrlist.setLinkSufix("");
        Vector lstData = ctrlist.getData();
        Vector lstLinkData = ctrlist.getLinkData();
        ctrlist.reset();

        int index = -1;
        int count=0;
        Vector rowx = new Vector(1, 1);
        double total=0.0;
        
        for (int i = 0; i < objectClass.size(); i++) {
            
            //Simpatda simpatda = (Simpatda) objectClass.get(i);
            PaymentRetribusi paymentRetribusi = (PaymentRetribusi) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
             total=total+paymentRetribusi.getJumlahTagihan();
            rowx.add(""+count);//1
            rowx.add(""+paymentRetribusi.getIdPaymentBank());//2
            rowx.add(""+paymentRetribusi.getNoRekening());//3
            rowx.add(""+paymentRetribusi.getNama());//4
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentRetribusi.getJumlahTagihan()));//4
            rowx.add(""+paymentRetribusi.getTanggalPembayaran());//4
            rowx.add("<button type=\"button\" class=\"btn btn-primary\" onclick=\"javascript:cmdPrintPdf('4','"+paymentRetribusi.getIdPaymentBank()+"')\">Print Retribusi</button>");//4
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);

        rowx.add("");//1
        rowx.add("");//2
        rowx.add("");//3
        rowx.add("<b>Total</b>");//4
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//4
        rowx.add("");//4
        rowx.add("");//4
        
        lstData.add(rowx);
        

        return ctrlist.drawBootstrapStrip();
    } 
    
%>

<% //proses yang tidak akan ditampilkan hanya diserver side

    int iCommand = FRMQueryString.requestCommand(request);
    int start = FRMQueryString.requestInt(request, "start");
    int prevCommand = FRMQueryString.requestInt(request, "prev_command");
    long oidDriver = FRMQueryString.requestLong(request, "hidden_driver_id");
    int jenis_pajak = FRMQueryString.requestInt(request, "jenis_pajak");
    String npwpd = FRMQueryString.requestString(request, "npwpd");
    String nop = FRMQueryString.requestString(request, "nop");
    String tib = FRMQueryString.requestString(request, "tib");
    String norekening = FRMQueryString.requestString(request, "norekening");
    
    /*variable declaration*/

    int recordToGet = 15;
    String msgString = "";
    int iErrCode = FRMMessage.NONE;
    String whereClause = "";
    ControlLine ctrLine = new ControlLine();
    /*data table payment*/
    Vector listPayment = new Vector();
    String id = "";
    
    if(iCommand==Command.SEARCH){
        
        if(jenis_pajak==1){//phr
            whereClause=PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_NPWD]+"='"+npwpd+"'";
            listPayment = PstPaymentPhr.list(0, 0, whereClause, "");
            
        }else if (jenis_pajak==2){//bphtb
            
            whereClause=PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_NOTIB]+"='"+tib+"'";
            listPayment = PstPaymentBphtb.list(0, 0, whereClause, "");
            
        }else if (jenis_pajak==3){//pbb
            
            whereClause=PstPaymentPbb.fieldNames[PstPaymentPbb.FLD_NOP]+"='"+nop+"'";
            listPayment = PstPaymentPbb.list(0, 0, whereClause, "");
            
        }else if (jenis_pajak==4){//retribusi
            
            whereClause=PstPaymentRetribusi.fieldNames[PstPaymentRetribusi.FLD_NOREKENING]+"='"+norekening+"'";
            listPayment = PstPaymentRetribusi.list(0, 0, whereClause, "");
            
        }else{
            
        }   
    } 
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
            
            function cmdPrint(){
                document.driver.command.value="<%=Command.PRINT%>";
                document.driver.action="report_phr.jsp";
                document.driver.submit();
            }
            
            function cmdSearch(){
                document.driver.command.value="<%=Command.SEARCH%>";
                document.driver.hidden_driver_id.value="0";
                document.driver.prev_command.value="<%=prevCommand%>";
                document.driver.action="print_payment_bank.jsp";
                document.driver.submit();
            }
            
            function cmdPrintPdf(typepajak, idpaymentbank){
                var myWindow = window.open("<%=printrootx%>.print.print_payment_bank?typepajak="+typepajak+"&idpaymentbank="+idpaymentbank+"","",'scrollbars=yes,status=yes,width=750,height=600,resizable=yes');
                if (window.focus) 
                 {
                   myWindow.focus();
                 }
            }
            
            function changeFunc() {
                    var selectBox = document.getElementById("jenis_pajak");
                    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                    //alert(selectedValue);
                    if(selectedValue=="1"){
                        //alert(selectedValue);
                        document.getElementById('phr').style.visibility = "visible";
                        document.getElementById('pbb').style.visibility = "hidden";
                        document.getElementById('bphtb').style.visibility = "hidden";
                        document.getElementById('retribusi').style.visibility = "hidden";
                        document.driver.npwpd.value="";
                    }else if(selectedValue=="2"){
                        //alert(selectedValue);
                        document.getElementById('bphtb').style.visibility = "visible";
                        document.getElementById('phr').style.visibility = "hidden";
                        document.getElementById('pbb').style.visibility = "hidden";
                        document.getElementById('retribusi').style.visibility = "hidden";
                        document.driver.tib.value="";
                    }else if(selectedValue=="3"){
                       // alert(selectedValue);
                        document.getElementById('pbb').style.visibility = "visible";
                        document.getElementById('phr').style.visibility = "hidden";
                        document.getElementById('bphtb').style.visibility = "hidden";
                        document.getElementById('retribusi').style.visibility = "hidden";
                        document.driver.nop.value="";
                    }else if(selectedValue=="4"){
                       // alert(selectedValue);
                        document.getElementById('retribusi').style.visibility = "visible";
                        document.getElementById('phr').style.visibility = "hidden";
                        document.getElementById('pbb').style.visibility = "hidden";
                        document.getElementById('bphtb').style.visibility = "hidden";
                        document.driver.norekening.value="";
                    }else{
                        document.getElementById('retribusi').style.visibility = "hidden";
                        document.getElementById('phr').style.visibility = "hidden";
                        document.getElementById('pbb').style.visibility = "hidden";
                        document.getElementById('bphtb').style.visibility = "hidden";
                    }
            }

        </script>
    </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <%@ include file = "../../header_mobile.jsp" %> 
        <div class="wrapper row-offcanvas row-offcanvas-left nonprint">
            <!-- Left side column. contains the logo and sidebar -->
            <%@ include file = "../../menu_left_mobile.jsp" %> 

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header " >
                    <h1>
                        Pajak dan Retribusi Daerah Terintegrasi Pembayaran Online
                        <small>Cetak Pembayaran</small>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content" >
                    <form name="driver"  method ="post" action="" role="form">
                        <input type="hidden" name="command" value="<%=iCommand%>">
                        <input type="hidden" name="start" value="<%=start%>">
                        <input type="hidden" name="prev_command" value="<%=prevCommand%>">
                        <input type="hidden" name="hidden_driver_id" value="<%=oidDriver%>">
                        <input type="hidden" name="menu" value="101">
                        <input type="hidden" name="tree" value="5">
                        <div class="row">
                            <div class="col-xs-12">
                               <div class="box">
                                   <div class="box-header">
                                       &nbsp;
                                   </div>    
                                   <div class="box-header">
                                       <div class="col-xs-2"><label>Jenis Pajak</label>
                                           <%
                                            Vector valueTipePajak =  new Vector();
                                            Vector keyTipePajak = new  Vector();
                                            valueTipePajak.add("0");
                                            keyTipePajak.add("Select Jenis Pajak");
                                            valueTipePajak.add("1");
                                            keyTipePajak.add("PHR");
                                            valueTipePajak.add("2");
                                            keyTipePajak.add("BPHTB");
                                            valueTipePajak.add("3");
                                            keyTipePajak.add("PBB");
                                            valueTipePajak.add("4");
                                            keyTipePajak.add("RETRIBUSI");
                                           %>
                                           <%=ControlCombo.drawBootsratap("jenis_pajak", null, ""+jenis_pajak, valueTipePajak, keyTipePajak, "required='required' onchange=\"javascript:changeFunc();\" ", "form-control") %>
                                       </div>
                                       <div class="col-xs-2" id="phr"><label>No NPWPD</label>
                                            <div class="input-group">  
                                                <input name="npwpd"  type="text" class="form-control" value="<%=npwpd%>">
                                                <span class="input-group-btn">
                                                     <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right"  onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                </span>
                                            </div>
                                        </div>
                                       <div class="col-xs-2" id="pbb"><label>NOP</label>
                                            <div class="input-group">  
                                                <input name="nop"  type="text" class="form-control" value="<%=nop%>">
                                                <span class="input-group-btn">
                                                     <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right"  onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="col-xs-3" id="bphtb"><label>TIB</label>
                                            <div class="input-group">  
                                                <input name="tib"  type="text" class="form-control" value="<%=tib%>">
                                                <span class="input-group-btn">
                                                     <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right"  onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                </span>
                                            </div>
                                        </div>
                                       <div class="col-xs-3" id="retribusi"><label>NO REKENING</label>
                                            <div class="input-group">  
                                                <input name="norekening"  type="text" class="form-control" value="<%=norekening%>">
                                                <span class="input-group-btn">
                                                     <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right"  onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                </span>
                                            </div>
                                        </div>  
                                    </div>
                                    <%
                                    if(jenis_pajak==1){//phr
                                    %>
                                        <%=drawListDataPaymentPhrDispenda(iCommand, listPayment, oidDriver)%>
                                    <%    
                                    }else if (jenis_pajak==2){//bphtb
                                    %>
                                        <%=drawListDataPaymentBphtbDispenda(iCommand, listPayment, oidDriver)%>
                                    <%
                                    }else if (jenis_pajak==3){//pbb
                                    %>
                                        <%=drawListDataPaymentPbbDispenda(iCommand, listPayment, oidDriver)%>
                                    <%
                                    }else if (jenis_pajak==4){//retribusi
                                    %>
                                        <%=drawListDataPaymentRetribusiDispenda(iCommand, listPayment, oidDriver)%>
                                    <%
                                    }else{

                                    }   
                                    %>   
                                    
                                    
                                </div><!-- /.box -->
                            </div>
                        </div>     
                    </form>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
            <div id="myModalView" class="modal fade" tabindex="-1">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="modal-title"></h4>
                        </div>
                        <div class="modal-body" id="modal-body">
                        </div>
                        <div class="modal-footer"><br><br>
                            <button type="button" class="btn btn-primary" onclick="javascript:cmdPrint()">Print</button>
                            <button type="button" data-dismiss="modal" class="btn btn-danger">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- ./wrapper -->
       
        <!-- jQuery 2.0.2 -->
        <script type="text/javascript" src="../../styles/jquery.min.js"></script>
        <!-- jQuery UI 1.10.3 -->
        <script src="../../styles/bootstrap3.1/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="../../styles/bootstrap3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="../../styles/bootstrap3.1/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="../../styles/bootstrap3.1/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="../../styles/bootstrap3.1/js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- page script -->
        <script src="../../styles/datepicker/js/jquery.ui.datepicker.js"></script>
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
        <script type="text/javascript">
            var selectBox = document.getElementById("jenis_pajak");
            var selectedValue = selectBox.options[selectBox.selectedIndex].value;
            //alert(selectedValue);
            /*if(selectedValue=="0"){
                document.getElementById('retribusi').style.visibility = "hidden";
                document.getElementById('phr').style.visibility = "hidden";
                document.getElementById('pbb').style.visibility = "hidden";
                document.getElementById('bphtb').style.visibility = "hidden";
            }*/
            if(selectedValue=="1"){
                //alert(selectedValue);
                document.getElementById('phr').style.visibility = "visible";
                document.getElementById('pbb').style.visibility = "hidden";
                document.getElementById('bphtb').style.visibility = "hidden";
                document.getElementById('retribusi').style.visibility = "hidden";
            }else if(selectedValue=="2"){
                //alert(selectedValue);
                document.getElementById('bphtb').style.visibility = "visible";
                document.getElementById('phr').style.visibility = "hidden";
                document.getElementById('pbb').style.visibility = "hidden";
                document.getElementById('retribusi').style.visibility = "hidden";
            }else if(selectedValue=="3"){
               // alert(selectedValue);
                document.getElementById('pbb').style.visibility = "visible";
                document.getElementById('phr').style.visibility = "hidden";
                document.getElementById('bphtb').style.visibility = "hidden";
                document.getElementById('retribusi').style.visibility = "hidden";
            }else if(selectedValue=="4"){
               // alert(selectedValue);
                document.getElementById('retribusi').style.visibility = "visible";
                document.getElementById('phr').style.visibility = "hidden";
                document.getElementById('pbb').style.visibility = "hidden";
                document.getElementById('bphtb').style.visibility = "hidden";
            }else{
                document.getElementById('retribusi').style.visibility = "hidden";
                document.getElementById('phr').style.visibility = "hidden";
                document.getElementById('pbb').style.visibility = "hidden";
                document.getElementById('bphtb').style.visibility = "hidden";
            }
        </script>
    </body>
</html>
