<%-- 
    Document   : report_bphtb_harian_excel
    Created on : Apr 22, 2016, 11:42:07 PM
    Author     : Administrator
--%>
<%-- 
    Document   : report_bphtb_harian
    Created on : Apr 22, 2016, 10:08:06 PM
    Author     : Administrator
--%>
<%-- 
    Document   : payment_bphtb
    Created on : May 19, 2015, 7:05:38 PM
    Author     : dimata005
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.dimata.dtaxintegration.session.DTaxIntegrationMonitor"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentBphtb"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentBphtb"%>
<%-- 
    Document   : payment_phr
    Created on : May 19, 2015, 7:00:57 PM
    Author     : dimata005
--%>

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
    public String drawListDataPaymentDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("NO", "200px");//1
        ctrlist.addHeader("TANGGAL", "200px");//2
        ctrlist.addHeader("POKOK", "200px");//2
        ctrlist.addHeader("DENDA", "200px");//2
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//10
        
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
        double pokok=0.0;
        double denda=0.0;
        for (int i = 0; i < objectClass.size(); i++) {
            
            //Simpatda simpatda = (Simpatda) objectClass.get(i);
            PaymentBphtb paymentBphtb = (PaymentBphtb) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentBphtb.getPokok()));//2
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentBphtb.getDenda()));//3
            rowx.add(""+FRMHandler.userFormatStringDecimal(paymentBphtb.getJumlahBayar()));//4
            total=total+paymentBphtb.getJumlahBayar();
            pokok =pokok+paymentBphtb.getPokok();
            denda=denda+paymentBphtb.getDenda();
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("<b>Total</b>");//3
        rowx.add(""+FRMHandler.userFormatStringDecimal(pokok));//4
        rowx.add(""+FRMHandler.userFormatStringDecimal(denda));//4
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//4
        
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
    
     /*service*/
    /*if(iCommand==Command.POSTING){
        DTaxIntegrationMonitor dtaxIntegration = new DTaxIntegrationMonitor();
        dtaxIntegration.inputPaymentBphtb(startDate, "");
    }*/
    
    /*webservice bpd*/
    /*EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
    LaporanPayment laporanPayment = new LaporanPayment();
    laporanPayment.setsUser("BPHTB_GIANYAR");
    laporanPayment.setsPassword("123456");
    laporanPayment.setsInstansi("BPHTB_GIANYAR");
    laporanPayment.setsNoId("");
    laporanPayment.setsDate(""+startDate);
    listReportDetail = echoLaporan.getListPaymentDetailBPHTB(laporanPayment);*/
    
    /*data table payment*/
    Vector listPayment = new Vector();
    whereClause = PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_STATUS]+"='0'"
                  +" AND "+PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_TANGGAL_BAYAR]
                  +" BETWEEN TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')"
                  +" AND TO_DATE ('"+oEnd+"','YYYY-MM-DD HH24:MI:SS')";
    //listPayment = PstPaymentBphtb.list(0, 0, whereClause, "");
    listPayment = PstPaymentBphtb.listSum(0, 0, whereClause, 
            ""+PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_TANGGAL_BAYAR]+" ASC ", 
            ""+PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_TANGGAL_BAYAR]);
    
%>
<%@ page contentType="application/x-msexcel" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Report Harian PHR</title>
    </head>
    <body class="skin-blue">
        <table width="100%" cellspacing="0" cellpadding="3">
                <tr align="left" valign="top">
                  <td height="14" valign="middle" colspan="3" class="command">
                   <b><strong>
                        REPORT HARIAN BPHTB <%=startDate%> S/D <%=startEnd%>
                    </strong></b>
                    </td>
                </tr>
        </table>
         <%=drawListDataPaymentDispenda(iCommand, listPayment, oidDriver)%>
    </body>
</html>