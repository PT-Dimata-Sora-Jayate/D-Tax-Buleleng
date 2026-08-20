<%-- 
    Document   : payment_phr
    Created on : May 19, 2015, 7:00:57 PM
    Author     : dimata005
--%>
<%@page import="com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi"%>
<%@page import="com.dimata.common.entity.logger.PstLogSysHistory"%>
<%@page import="com.dimata.webclient.AppSetting"%>
<%@page import="com.dimata.webclient.EchoTagihanDeleteById"%>
<%@page import="com.dimata.dtaxintegration.entity.tagihan.TagihanDelete"%>
<%@page import="com.dimata.webclient.EchoTagihanDeleteByRecordId"%>
<%@page import="com.dimata.dtaxintegration.entity.tagihan.Tagihan"%>
<%@page import="com.dimata.dtaxintegration.entity.inquery.InqueryProses"%>
<%@page import="com.dimata.webclient.Inquery"%>
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

    public String drawListDataPaymentPhrBpd(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("ID BANK", "200px");//2
        ctrlist.addHeader("ID", "200px");//2
        ctrlist.addHeader("NAMA", "200px");//3
        ctrlist.addHeader("ALAMAT", "200px");//5
        ctrlist.addHeader("BULAN", "200px");//6
        ctrlist.addHeader("TAHUN", "200px");//7
        ctrlist.addHeader("POKOK", "200px");//8
        ctrlist.addHeader("DENDA", "200px");//9
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//10
        ctrlist.addHeader("STATUS BAYAR", "200px");//11
        ctrlist.addHeader("ACTION", "200px");//11
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
            Tagihan tagihan = (Tagihan) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+tagihan.getId());//2
            rowx.add(""+tagihan.getNoId());//2
            rowx.add(""+tagihan.getNama());//3
            rowx.add(""+tagihan.getAlamat());//5
            rowx.add(""+tagihan.getBulan());//6
            rowx.add(""+tagihan.getTahun());//7
            rowx.add(""+tagihan.getPokok());//8
            rowx.add(""+tagihan.getDenda());//9
            rowx.add(""+tagihan.getTagihan());//10
            String statusBayar="";
            if(tagihan.getStsBayar().equals("0")){
                statusBayar="Belum Bayar";
                rowx.add(""+statusBayar);//11
                if(AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_OPEN_PHR){
                    rowx.add("<center><input type=\"checkbox\" name=\"delete_status_"+i+"\" value=\"'"+tagihan.getId()+"','"+tagihan.getNoId()+"'\" class=\"form-control\" size=\"10\"></center>");
                } else if (AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_PHRH){
                    rowx.add("<center><input type=\"checkbox\" name=\"delete_status_"+i+"\" value=\"'"+tagihan.getId()+"','"+tagihan.getNoId()+"'\" class=\"form-control\" size=\"10\"></center>");
                }else{
                    rowx.add("<center><input type=\"checkbox\" name=\"delete_status_"+i+"\" value=\"'"+tagihan.getId()+"'\" class=\"form-control\" size=\"10\"></center>");
                }
            }else{
                statusBayar="Sudah Bayar";
                rowx.add(""+statusBayar);//11
                if(AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_OPEN_PHR){
                    rowx.add("<center><input type=\"hidden\" name=\"delete_status_"+i+"\" value=\"'"+tagihan.getId()+"','"+tagihan.getNoId()+"'\" class=\"form-control\" size=\"10\"></center>");
                } else if (AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_PHRH){
                    rowx.add("<center><input type=\"hidden\" name=\"delete_status_"+i+"\" value=\"'"+tagihan.getId()+"','"+tagihan.getNoId()+"'\" class=\"form-control\" size=\"10\"></center>");
                }else{
                    rowx.add("<center><input type=\"hidden\" name=\"delete_status_"+i+"\" value=\"'"+tagihan.getId()+"'\" class=\"form-control\" size=\"10\"></center>");
                }
            }
            
            total=total+Double.parseDouble(tagihan.getTagihan());
            
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("");//1
        rowx.add("");//2
        rowx.add("");//3
        rowx.add("");//4
        rowx.add("");//5
        rowx.add("");//6
        rowx.add("");//7
        rowx.add("");//8
        rowx.add("<b>Total<b>");//9
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//10
        rowx.add("");//10
            
        lstData.add(rowx);

        return ctrlist.drawBootstrapStrip();
    }

    public String drawListDataPaymentPhrDispenda(int iCommand, Vector objectClass, long gradeId,  Vector objectClassBpd) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("ID", "200px");//2
        ctrlist.addHeader("NAMA", "200px");//3
        ctrlist.addHeader("ALAMAT", "200px");//3
        ctrlist.addHeader("BULAN", "200px");//4
        ctrlist.addHeader("TAHUN", "200px");//5
        ctrlist.addHeader("POKOK", "200px");//5
        ctrlist.addHeader("DENDA", "200px");//5
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//6
        ctrlist.addHeader("ACTION", "200px");//6 
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
            Simpatda simpatda = (Simpatda) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+simpatda.getId());//2
            rowx.add(""+simpatda.getNamaSimpatda());//3
            rowx.add(""+simpatda.getAlamat());//3
            rowx.add(""+simpatda.getBulanSimpatda());//4
            rowx.add(""+simpatda.getTahunSimpatda());//5
            rowx.add(""+simpatda.getPokok());//5
            rowx.add(""+simpatda.getDenda());//5
            rowx.add(""+simpatda.getJumlahPajakSimpatda());//6
            boolean sudahTransfer = false;
            if(AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_OPEN_PHR){
               sudahTransfer =getCountOpenPhr(simpatda.getId(),objectClassBpd);
            }else{
               sudahTransfer =getCount(simpatda.getBulanSimpatda(), simpatda.getTahunSimpatda(), objectClassBpd);
            }

            if(sudahTransfer){
               rowx.add("data sudah di bank <input class=\"check\" type=\"hidden\" id=\"status_"+i+"\" name=\"status_"+i+"\" > ");     
            }else{
               try{
                    int xxx = PstLogHistoryTransaksi.deleteloghistoryperidmasapajak(simpatda.getId(), simpatda.getTahunSimpatda(),simpatda.getBulanSimpatda());
                }catch(Exception ex){
                } 
               rowx.add("<center><input class=\"check\" type=\"checkbox\" id=\"status_"+i+"\" name=\"status_"+i+"\" value=\"'"+simpatda.getId()+"';'"+simpatda.getTahunSimpatda()+"';'"+simpatda.getBulanSimpatda()+"';'"+simpatda.getJumlahPajakSimpatda()+"';'"+simpatda.getKeterangan()+"'\" size=\"10\"></center>");
            }
            total = total+Double.parseDouble(simpatda.getJumlahPajakSimpatda());
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("");//2
        rowx.add("");//3
        rowx.add("");//3
        rowx.add("");//3
        rowx.add("");//3
        rowx.add("");//3
        rowx.add("<b>Total<b>");//4
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//5
        
        lstData.add(rowx);

        return ctrlist.drawBootstrapStrip();
    }

     
    public static boolean getCount(String bulan, String tahun,  Vector objectClassBpd) {
        boolean hasil=false;
        try {
            for (int i = 0; i < objectClassBpd.size(); i++) {
               Tagihan tagihan = (Tagihan) objectClassBpd.get(i);
               if(tagihan.getTahun().equals(tahun) && tagihan.getBulan().equals(bulan)){
                hasil=true;
                return hasil;
               }
            }
        } catch (Exception e) {
        } finally {
        }
        return hasil;
    }

    public static boolean getCountOpenPhr(String idInvoice,Vector objectClassBpd) {
        boolean hasil=false;
        try {
            for (int i = 0; i < objectClassBpd.size(); i++) {
               Tagihan tagihan = (Tagihan) objectClassBpd.get(i);
               if(tagihan.getNoId().equals(idInvoice)){
                hasil=true;
                return hasil;
               }
            }
        } catch (Exception e) {
        } finally {
        }
        return hasil;
    }



%>

<% 
    //proses yang tidak akan ditampilkan hanya diserver side
    int iCommand = FRMQueryString.requestCommand(request);
    int start = FRMQueryString.requestInt(request, "start");
    int prevCommand = FRMQueryString.requestInt(request, "prev_command");
    long oidDriver = FRMQueryString.requestLong(request, "hidden_driver_id");
    String gradeDelete = FRMQueryString.requestString(request, "gradeDelete");
    
    String startDate = FRMQueryString.requestString(request, "tanggalStart");
    String oDate = "";
    String sNoId = FRMQueryString.requestString(request, "sNoId");
    String sNomorInvoice = FRMQueryString.requestString(request, "sNomorInvoice");
    String idbank = FRMQueryString.requestString(request, "idbank");
    
    String idtagihan = FRMQueryString.requestString(request, "idtagihan");
    String tahun = FRMQueryString.requestString(request, "tahun");
    String bulan = FRMQueryString.requestString(request, "bulan");
    
    /*variable declaration*/
    String whereClause = "";
    Vector listReportDetail = new Vector(1, 1);
    
    /*Delete*/
    EchoTagihanDeleteByRecordId echoTagihanDeleteByRecordId = new EchoTagihanDeleteByRecordId();
    echoTagihanDeleteByRecordId.setLogErorDeteleDataTagihanByRecord("");
    if(iCommand==Command.DELETE){
        TagihanDelete tagihanDelete = new TagihanDelete();
        String[] splits = idtagihan.split(",");
        for(String asset: splits){
            if(asset!=""){
                if(!asset.equals("")){
                    tagihanDelete.setsUser(AppSetting.USERNAME_PHR);
                    tagihanDelete.setsPassword(AppSetting.PWD_PHR);
                    tagihanDelete.setsInstansi(AppSetting.INSTANSI_PHR);
                    tagihanDelete.setsNoId(splits[1]);
                    tagihanDelete.setsRecordId(splits[0]);
                    echoTagihanDeleteByRecordId.action(tagihanDelete);
                    idtagihan="";
                }
            }
        }
    }
    
    EchoTagihanDeleteById echoTagihanDeleteById = new EchoTagihanDeleteById();
    echoTagihanDeleteById.setLogErorDeteleDataTagihan("");
    if(iCommand==Command.DELETE2){
        TagihanDelete tagihanDelete = new TagihanDelete();    
        if(!sNoId.equals("")){
            tagihanDelete.setsUser(AppSetting.USERNAME_PHR);
            tagihanDelete.setsPassword(AppSetting.PWD_PHR);
            tagihanDelete.setsInstansi(AppSetting.INSTANSI_PHR);
            tagihanDelete.setsNoId(sNoId);
            tagihanDelete.setsRecordId("");
            echoTagihanDeleteById.action(tagihanDelete);
            idtagihan="";
            try{
                int xxx = PstLogHistoryTransaksi.deleteloghistoryperid(sNoId);
            }catch(Exception ex){
            }
        }
    }
    
    DTaxIntegrationMonitor dTax = new DTaxIntegrationMonitor();
    dTax.setLogErorPosting("");
    if(iCommand==Command.POSTING){    
        if(!idtagihan.equals("")){
            switch (AppSetting.TYPE_APP_BACKOFFICE) {
                case AppSetting.APP_OPEN_PHR:
                    dTax.prosesSimpatdaOpenPhr(idtagihan);
                    break;
                case AppSetting.APP_PHRH:
                    dTax.prosesSimpatdaPhrH(idtagihan);
                    break;
                default:
                    dTax.prosesSimpatda(idtagihan);
                    break;
            }
        }
        idtagihan="";
    }
    
    /*webservice bpd*/
    Inquery inquery = new Inquery();
    InqueryProses inqueryProses = new InqueryProses();
    inqueryProses.setsUser(AppSetting.USERNAME_PHR);
    inqueryProses.setsPassword(AppSetting.PWD_PHR);
    inqueryProses.setsInstansi(AppSetting.INSTANSI_PHR);
    inqueryProses.setsNoId(sNoId);
    inqueryProses.setsNoInvoice(sNomorInvoice);
    listReportDetail = inquery.InqueryPHR(inqueryProses);
    
    /*data table payment*/
    Vector listTagihanPhr = new Vector();
    switch (AppSetting.TYPE_APP_BACKOFFICE) {
        case AppSetting.APP_OPEN_PHR:
            whereClause = ""; 
            if(!sNoId.equals("")){
                    whereClause = " WHERE npwpd='"+sNoId+"' ";
            }
            if(!sNomorInvoice.equals("")){
                if(whereClause.equals("")){
                    whereClause = " WHERE sNoId='"+sNomorInvoice+"' ";
                }else{
                    whereClause = " AND sNoId='"+sNomorInvoice+"' ";
                }
            }else{
                if(whereClause.equals("")){
                    whereClause = " WHERE sNoId='"+sNomorInvoice+"' ";
                }
            }
            listTagihanPhr = SessSimpatda.getListSimpatdaOpenPhr(whereClause);
            break;
        case AppSetting.APP_PHRH:
            whereClause = ""; 
            if(!sNoId.equals("")){
                    whereClause = " WHERE npwpd_search='"+sNoId+"' ";
            }
            if(!sNomorInvoice.equals("")){
                if(whereClause.equals("")){
                    whereClause = " WHERE kode_id='"+sNomorInvoice+"' ";
                }else{
                    whereClause = " AND kode_id='"+sNomorInvoice+"' ";
                }
            }else{
                if(whereClause.equals("")){
                    whereClause = " WHERE kode_id='"+sNomorInvoice+"' ";
                }
            }
            listTagihanPhr = SessSimpatda.getListSimpatdaPhrH(whereClause);
            break;
        default:
            whereClause = " WHERE ID='"+sNoId+"' "; ;//PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]+" = TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')";
            listTagihanPhr = SessSimpatda.getListSimpatda(whereClause);
            break;
    }
    
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pajak dan Retribusi Daerah Terintegrasi Pembayaran Online</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="<%=approot%>/imgcompany/favicon.ico" rel="shortcut icon" />
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
                document.driver.command.value="<%=Command.POSTING%>";
                document.driver.action="payment_phr.jsp";
                document.driver.submit();
            }
            
            function cmdSearch(){
                document.driver.command.value="<%=Command.SEARCH%>";
                document.driver.hidden_driver_id.value="0";
                document.driver.prev_command.value="<%=prevCommand%>";
                document.driver.action="manual_phr.jsp";
                document.driver.submit();
            }
            
            function cmdPostingDelete(idBank){
                document.driver.idbank.value=idBank;
                document.driver.command.value="<%=Command.DELETE%>";
                document.driver.action="manual_phr.jsp";
                document.driver.submit();
            }
            
            function cmdPosting(id, tahun, bulan){
                document.driver.idtagihan.value=id;
                document.driver.tahun.value=tahun;
                document.driver.bulan.value=bulan;
                document.driver.command.value="<%=Command.POSTING%>";
                document.driver.action="manual_phr.jsp";
                document.driver.submit();
            }
            
            function cmdAction(){
               if (confirm('Yakin Proses ? ')) {  
                    var val = '';
                    <%
                    for (int a=0; a<listTagihanPhr.size();a++){
                    %>
                        if(eval("driver.status_"+<%=a%>+".checked")==true){
                            val = val + eval("driver.status_"+<%=a%>+".value") + ',';
                        }
                    <%
                    }
                    %>
                    document.driver.idtagihan.value=val;
                    document.driver.command.value="<%=Command.POSTING%>";
                    document.driver.action="manual_phr.jsp";
                    document.driver.submit(); 
                    lockScreen('Proses Posting tagihan PHR ke Bank BPD, Silahkan menunggu...');
                }
            }
            
            function cmdActionDelete(){
                if (confirm('Yakin Proses ? ')) {  
                    var val = '';
                    <%
                    for (int a=0; a<listReportDetail.size();a++){
                    %>
                        if(eval("driver.delete_status_"+<%=a%>+".checked")==true){
                            val = val + eval("driver.delete_status_"+<%=a%>+".value") + ',';
                        }
                    <%
                    }
                    %>
                    document.driver.idtagihan.value=val;
                    document.driver.command.value="<%=Command.DELETE%>";
                    document.driver.action="manual_phr.jsp";
                    document.driver.submit(); 
                    lockScreen('Proses Delete Tagihan PHR di BANK BPD, Silahkan menunggu...');
                }
            }
            
            
             function cmdActionDeleteAll(){
                if (confirm('Yakin Proses ? ')) {  
                    document.driver.command.value="<%=Command.DELETE2%>";
                    document.driver.action="manual_phr.jsp";
                    document.driver.submit(); 
                    lockScreen('Proses Delete Tagihan PHR di BANK BPD, Silahkan menunggu...');
                }
            }
            function check()
                {
                    <%
                    for (int a=0; a<listTagihanPhr.size();a++){
                    %>
                    document.getElementById("status_<%=a%>").checked = true;
                    <%
                    }
                    %>
                }
            function uncheck()
                {
                    <%
                    for (int a=0; a<listTagihanPhr.size();a++){
                    %>
                    document.getElementById("status_<%=a%>").checked = false;
                    <%
                    }
                    %>
                }
            
             function lockScreen(str)
                {
                    var lock = document.getElementById('theLockPane');
                    if (lock)
                        lock.className = 'LockOn';

                    lock.innerHTML = str;
                }
                
        </script>
        <style type="text/css">

            .LockOff {
                display: none;
                visibility: hidden;
            }

            .LockOn {
                display: block;
                visibility: visible;
                position: absolute;
                z-index: 999;
                top: 0px;
                left: 0px;
                width: 105%;
                height: 105%;
                background-color: #ccc;
                text-align: center;
                padding-top: 20%;
                filter: alpha(opacity=75);
                opacity: 0.75;
                font-size: 250%;
            }
        </style>
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
                    <h1>
                       Pajak dan Retribusi Daerah Terintegrasi Pembayaran Online
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                    <form name="driver"  method ="post" action="" role="form">
                        <input type="hidden" name="command" value="<%=iCommand%>">
                        <input type="hidden" name="start" value="<%=start%>">
                        <input type="hidden" name="prev_command" value="<%=prevCommand%>">
                        <input type="hidden" name="hidden_driver_id" value="<%=oidDriver%>">
                         <input type="hidden" name="idbank" value="<%=idbank%>">
                         <input type="hidden" name="idtagihan" value="<%=idtagihan%>">
                         <input type="hidden" name="tahun" value="<%=tahun%>">
                         <input type="hidden" name="bulan" value="<%=bulan%>">
                         <input type="hidden" name="menu" value="2">
                        <input type="hidden" name="tree" value="1">
                        <div class="row">
                            <div class="col-xs-12">
                               <div class="box">
                                   <div class="box-header">
                                       &nbsp;
                                   </div>    
                                   <div class="box-header">
                                       <div class="col-xs-12"><label>DATA BANK</label></div>  
                                       <div class="col-xs-3"><label> No NPWPD </label>  
                                            <div class="input-group">   
                                                 <input name="sNoId" type="text" class="form-control" placeholder="Inputkan No NPWPD" value="<%=sNoId%>" size="25">
                                                 <%if(AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_TYPE_GIANYAR){%>
                                                    <span class="input-group-btn">
                                                         <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right" onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                     </span>
                                                 <%}%>
                                            </div>    
                                       </div>
                                       <%if(AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_OPEN_PHR){%>
                                            <div class="col-xs-3"><label> No Invoice </label> 
                                                 <div class="input-group">   
                                                     <input name="sNomorInvoice" type="text" class="form-control" placeholder="Inputkan No Invoice" value="<%=sNomorInvoice%>" size="25">
                                                     <span class="input-group-btn">
                                                         <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right" onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                     </span>
                                                 </div>
                                            </div>
                                       <%}%>   
                                       <%if(AppSetting.TYPE_APP_BACKOFFICE==AppSetting.APP_PHRH){%>
                                            <div class="col-xs-3"><label> No Invoice </label> 
                                                 <div class="input-group">   
                                                     <input name="sNomorInvoice" type="text" class="form-control" placeholder="Inputkan No Invoice" value="<%=sNomorInvoice%>" size="25">
                                                     <span class="input-group-btn">
                                                         <button type='button' name='seach' id='search-btn' class="btn btn-success pull-right" onclick="javascript:cmdSearch()"><i class="fa fa-search"></i></button>
                                                     </span>
                                                 </div>
                                            </div>
                                       <%}%>   
                                       <% if(userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_PROSES_INTEGRASI,AppObjInfo.G2_PHR,AppObjInfo.OBJ_UPLOAD_MANUAL_PHR, AppObjInfo.COMMAND_DELETE)){ %>
                                            <div class="col-xs-3">
                                                <button  onclick="javascript:cmdActionDeleteAll()" type="button" class="btn btn-foursquare pull-right">DELETE All</button>
                                                 
                                            </div>
                                            <div class="col-xs-3">
                                                 <button  onclick="javascript:cmdActionDelete()" type="button" class="btn btn-danger pull-left">DELETE/RECORD</button>
                                                 
                                            </div>
                                       <%}%>         
                                    </div>
                                    <%=drawListDataPaymentPhrBpd(iCommand, listReportDetail, oidDriver)%>
                                </div><!-- /.box -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                               <div class="box">
                                   <div class="box-header">
                                       &nbsp;
                                   </div>
                                   <div class="box-header">
                                        <div class="col-xs-12"><label>DATA BAPENDA</label></div>  
                                        <% if(userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_PROSES_INTEGRASI,AppObjInfo.G2_PHR,AppObjInfo.OBJ_UPLOAD_MANUAL_PHR, AppObjInfo.COMMAND_UPLOAD)){ %>
                                            <div class="col-xs-12">
                                                 <button  onclick="javascript:cmdAction()" type="button" class="btn btn-primary pull-right">UPLOAD</button>
                                                 <button onclick="javascript:check()" type="button" >Pilih semua</button>
                                                 <button onclick="javascript:uncheck()" type="button" >Tidak di pilih semua</button>
                                            </div>
                                        <%}%>
                                   </div>  
                                   <%=drawListDataPaymentPhrDispenda(iCommand, listTagihanPhr, oidDriver,listReportDetail)%>
                                </div><!-- /.box -->
                            </div>
                        </div>  
                                
                         <div class="row">
                            <div class="col-xs-12">
                               <div class="box">
                                   <div class="box-header">
                                       &nbsp;
                                   </div>
                                   <div class="box-header">
                                        <div class="col-xs-12"><label>Log Error Data</label></div>  
                                   </div>  
                                   <%=inquery.getLogErorInquery()%><br>
                                   <%=dTax.getLogErorPosting()%><br>
                                   <%=echoTagihanDeleteByRecordId.getLogErorDeteleDataTagihanByRecord()%><br>
                                   <%=echoTagihanDeleteById.getLogErorDeteleDataTagihan()%>
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

        </script>
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
        <script type="text/javascript">
            $(function() {
                    $( "#datepickertiga" ).datepicker({ dateFormat: "yy-mm-dd" });
            });
	</script>
    </body>
</html>
