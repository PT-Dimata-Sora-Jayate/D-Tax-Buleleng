<%-- 
    Document   : report_pbb_excel
    Created on : Jul 7, 2015, 2:43:30 PM
    Author     : dimata005
--%>

<%-- 
    Document   : payment_pbb
    Created on : May 19, 2015, 7:05:00 PM
    Author     : dimata005
--%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentPbb"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentPbb"%>
<%-- 
    Document   : payment_phr
    Created on : May 19, 2015, 7:00:57 PM
    Author     : dimata005
--%>

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
<%//@ include file = "../../main/checkuser.jsp" %>


<%!//proses yang akan ditampilkan

    public String drawListDataPaymentPBBDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        ctrlist.setBorder(1);
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NOP", "200px");//3
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
            PaymentPbb paymentPbb = (PaymentPbb) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+paymentPbb.getIdPaymentBank());//2
            rowx.add(""+paymentPbb.getNop());//3
            rowx.add(""+paymentPbb.getThnPajakSppt());//4
            rowx.add(""+paymentPbb.getJmlSpptYgDibayar());//6
            rowx.add(""+paymentPbb.getStatus());
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
        
        
        return ctrlist.draw();
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
        oDate =startDate;
        oEnd = startEnd;
    }
    
    /*data table payment*/
    Vector listPaymentPBB = new Vector();
    whereClause = PstPaymentPbb.fieldNames[PstPaymentPbb.FLD_STATUS]+"='0'"
                  +" AND "+PstPaymentPbb.fieldNames[PstPaymentPbb.FLD_TGLPEMBAYARANSPPT]
                  +" BETWEEN TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')"
                  +" AND TO_DATE ('"+oEnd+"','YYYY-MM-DD HH24:MI:SS')";
    
    listPaymentPBB = PstPaymentPbb.list(0, 0, whereClause, "");
    
%>
<%@ page contentType="application/x-msexcel" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Report PBB Summary</title>
    </head>
    <body class="skin-blue">
        <table width="100%" cellspacing="0" cellpadding="3">
                <tr align="left" valign="top">
                  <td height="14" valign="middle" colspan="3" class="command">
                   <b><strong>
                        REPORT PBB SUMMARY <%=startDate%> S/D <%=startEnd%>
                    </strong></b>
                    </td>
                </tr>
        </table>
         <%=drawListDataPaymentPBBDispenda(iCommand, listPaymentPBB, oidDriver)%>
    </body>
</html>
