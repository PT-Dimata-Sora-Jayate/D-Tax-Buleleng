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


<%!//proses yang akan ditampilkan

    public String drawListDataPaymentPhrDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NPWPD", "200px");//2
        ctrlist.addHeader("NAMA", "200px");//3
        ctrlist.addHeader("DATE", "200px");//4
        ctrlist.addHeader("BULAN", "200px");//6
        ctrlist.addHeader("TAHUN", "200px");//7
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//10
        ctrlist.addHeader("STATUS", "200px");//10
         
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
            rowx.add(""+paymentPhr.getStatus());//8
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
%>

<% //proses yang tidak akan ditampilkan hanya diserver side

    int iCommand = FRMQueryString.requestCommand(request);
    int start = FRMQueryString.requestInt(request, "start");
    int prevCommand = FRMQueryString.requestInt(request, "prev_command");
    long oidDriver = FRMQueryString.requestLong(request, "hidden_driver_id");
    String gradeDelete = FRMQueryString.requestString(request, "gradeDelete");
    
    String startDate = FRMQueryString.requestString(request, "tanggalStart");
    String oDate = "";//FRMQueryString.requestString(request, "tanggalEnd");
    
    String startEnd = FRMQueryString.requestString(request, "tanggalEnd");
    String oEnd = "";//FRMQueryString.requestString(request, "tanggalEnd");
    
    double exchangeRate = FRMQueryString.requestDouble(request, "exchangeRate");
    double pemotongan = FRMQueryString.requestDouble(request, "pemotongan");
    
    /*variable declaration*/

    int recordToGet = 15;
    String msgString = "";
    int iErrCode = FRMMessage.NONE;
    String whereClause = "";
    String orderClause = "";//PstTransportServiceOrder.fieldNames[PstTransportServiceOrder.FLD_ID];
    ControlLine ctrLine = new ControlLine();
    Vector listReportDetail = new Vector(1, 1);

    //membuat command menjadi none kembali setelah menjalankan delete all
    if (iCommand == Command.DELETEALL && iErrCode == FRMMessage.NONE) {
        iCommand = Command.NONE;
    }

    /* end switch*/

    //int vectSize = PstTransportServiceOrder.getCount(whereClause);

    /*switch list Student*/

    if (iCommand == Command.FIRST || iCommand == Command.NEXT || iCommand == Command.PREV || iCommand == Command.LAST) {
        start = 0;//ctrlTransportServiceOrder.action(iCommand, start, vectSize, recordToGet);
    }

    /* get record to display */
    Date newDay=new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    if(startDate.equals("")){
        startDate=Formater.formatDate(newDay,"yyyy-MM-dd");
        startEnd=Formater.formatDate(newDay,"yyyy-MM-dd");
        Date transaksiDate = formatter.parse(startDate);
        oDate = Formater.formatDate(transaksiDate,"yyyy-MM-dd HH:mm:ss");
        oEnd = Formater.formatDate(transaksiDate,"yyyy-MM-dd HH:mm:ss");
    }else{
        String dateStringTransaksi = startDate;
        String dateEndStringTransaksi = startEnd;
        try {
                Date transaksiDate = formatter.parse(dateStringTransaksi);
                oDate = Formater.formatDate(transaksiDate,"yyyy-MM-dd HH:mm:ss");
                
                Date transaksiEndDate = formatter.parse(dateEndStringTransaksi);
                oEnd = Formater.formatDate(transaksiEndDate,"yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    /*if(iCommand==Command.POSTING){
        DTaxIntegrationMonitor dtaxIntegration = new DTaxIntegrationMonitor();
        dtaxIntegration.inputPaymentPHR(startDate, "");
    }*/
    
    /*webservice bpd*/
    /*EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
    LaporanPayment laporanPayment = new LaporanPayment();
    laporanPayment.setsUser("PHR_GIANYAR");
    laporanPayment.setsPassword("123456");
    laporanPayment.setsInstansi("PHR_GIANYAR");
    laporanPayment.setsNoId("");
    laporanPayment.setsDate(""+startDate);
    listReportDetail = echoLaporan.getListPaymentDetailPHR(laporanPayment);*/
    
    /*data table payment*/
    Vector listPaymentPhr = new Vector();
    /*order_date BETWEEN TO_DATE ('2014/02/01', 'yyyy/mm/dd')
      AND TO_DATE ('2014/02/28', 'yyyy/mm/dd');*/
    if(AppSetting.SQL_VERSION == AppSetting.DBSVR_ORACLE){
        whereClause = PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS]+"='0'"
                  +" AND "+PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]
                  +" BETWEEN TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')"
                  +" AND TO_DATE ('"+oEnd+"','YYYY-MM-DD HH24:MI:SS')";
    }else{
        whereClause = PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS]+"='0'"
                  +" AND "+PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]
                  +" BETWEEN ('"+oDate+"')"
                  +" AND ('"+oEnd+"')";
    }
    
    
    listPaymentPhr = PstPaymentPhr.list(0, 0, whereClause, "");
    
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
                document.driver.action="report_phr.jsp";
                document.driver.submit();
            }
            
            function cmdPrintExcel(){
                var myWindow = window.open("report_phr_excel.jsp?tanggalStart=<%=oDate%>&tanggalEnd=<%=oEnd%>&exchangeRate=<%=exchangeRate%>&pemotongan=<%=pemotongan%>", "MsgWindow", "toolbar=no, scrollbars=yes, resizable=yes, top=500, left=500, width=1500, height=800");
                if (window.focus) 
                 {
                   myWindow.focus();
                 }
            }
            
            function cmdPrintPdf(){
                var myWindow = window.open("<%=printrootx%>.print.report_phr_pdf?tanggalStart=<%=oDate%>&tanggalEnd=<%=oEnd%>&exchangeRate=<%=exchangeRate%>&pemotongan=<%=pemotongan%>","",'scrollbars=yes,status=yes,width=750,height=600,resizable=yes');
                if (window.focus) 
                 {
                   myWindow.focus();
                 }
            }
            	

            
             function cmdPrint(){
                window.print();
            }

        </script>
        <style type="text/css">
            .page {
                width: 29.7cm;
                min-height: 21cm;
                padding:1cm;
                margin: 1cm auto;
                border: 1px #D3D3D3 solid;
                border-radius: 5px;
                background: white;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
            }
            .subpage {
                min-height: 21cm;
            }

            .printable{
                display:none;
            }

            .modal-lg-print{
                max-width: 1366px;
                width: 96.5%;
            }

            @page{
                size: portrait;
                margin: 0;
            }

            @media print{
                .printable{
                        display: block;
                        visibility: visible;
                }
                .nonprint{
                        display: none;
                        visibility: hidden;
                }
                .page {
                    margin:0;
                    width: 7.5 cm;
                    min-height: 10cm;
                    background: white;
                    border:none;
                }
                .box-default{
                    border:1px solid #ccc;
                    border-top:3px solid #ccc;
                }

                td,th{
                    font-size: 8px;
                }
            }
            
        </style> 
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
                        <small>Report PHR</small>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content" >
                    <form name="driver"  method ="post" action="" role="form">
                        <input type="hidden" name="command" value="<%=iCommand%>">
                        <input type="hidden" name="start" value="<%=start%>">
                        <input type="hidden" name="prev_command" value="<%=prevCommand%>">
                        <input type="hidden" name="hidden_driver_id" value="<%=oidDriver%>">
                        <input type="hidden" name="menu" value="13">
                        <input type="hidden" name="tree" value="5">
                        <div class="row">
                            <div class="col-xs-12">
                               <div class="box">
                                   <div class="box-header">
                                       &nbsp;
                                   </div>    
                                   <div class="box-header">
                                       <div class="col-xs-2"><label>Show From Date</label>
                                           <input name="tanggalStart" id="datepicker" type="text" class="form-control" placeholder="yyyy-MM-dd" value="<%=startDate%>">
                                       </div>
                                       <div class="col-xs-2"><label>To Date Date</label>
                                           <div class="input-group">  
                                           <input name="tanggalEnd" id="datepickerdua" type="text" class="form-control" placeholder="yyyy-MM-dd" value="<%=startEnd%>">
                                            <span class="input-group-btn">
                                                <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right"  onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                            </span>
                                            </div>
                                       </div>
                                       <div class="col-xs-2"><label>&nbsp;</label>  
                                       </div>
                                       <% if(userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_REPORT,AppObjInfo.G2_REPORT_PHR, AppObjInfo.OBJ_REPORT_DETAIL_PHR, AppObjInfo.COMMAND_PRINT)){ %>
                                           <div class="col-xs-2"><label>&nbsp;</label>  
                                               <button  onclick="javascript:cmdPrintExcel()" type="button" class="btn btn-danger pull-right">Export Excel</button>
                                           </div>
                                           <div class="col-xs-2"><label>&nbsp;</label>  
                                               <button  onclick="javascript:cmdPrintPdf()" type="button" class="btn btn-info pull-right">Export Pdf</button>
                                           </div>
                                       <%}%>     
                                    </div>
                                    <%//=drawListDataPaymentPhrBpd(iCommand, listReportDetail, oidDriver)%>
                                    <%=drawListDataPaymentPhrDispenda(iCommand, listPaymentPhr, oidDriver)%>
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
        <script language="JavaScript">
            function cmdPrintPdfx(start, end) {
                 ajaxScriptParentPage("ajaxDataReportSource.jsp","Search Data PHR",1,"#myModalView",start,end, "#modal-title", "#modal-body");
            }
            
            function ajaxScriptParentPage(pageTarget, titlePage, pageShow, modalTemplate,start, end, titleId, bodyId){
                $(titleId).html(titlePage);
                $(modalTemplate).modal("show");
                $(bodyId).html("Harap tunggu ...");
                $.ajax({
                    type	: "POST",
                    url	: pageTarget,
                    data	: {"searchType":"parent", 
                                "pageShow":pageShow,
                                "tanggalStart":start,
                                "tanggalEnd":end
                            },
                    cache	: false,
                    success	: function(data){
                        $(bodyId).html(data);
                        $(".print-body").html(data).fadeIn("medium");

                    },
                    error : function(){
                        $(bodyId).html("Data not found");
                    }
                });
            }

            //agar modal tidak close saat are di luar form di klik
            $("#myModalView").modal({
                            backdrop:"static",
                            keyboard:false,
                            show:false
            });

            function ajaxFunctionChildPage(ajaxFunction){
                return ajaxFunction;
            }
        </script>
        <div class="printable">
            <span class="print-body"></span>
        </div>
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
    </body>
</html>
