<%-- 
    Document   : report_wp_excel
    Created on : Mar 2, 2016, 2:54:09 PM
    Author     : dimata005
--%>

<%-- 
    Document   : report_wp
    Created on : Aug 21, 2015, 9:32:37 PM
    Author     : Administrator
--%>
<%@page import="com.dimata.wpupload.entity.esptpd.ESPTPD"%>
<%@page import="com.dimata.wpupload.entity.esptpd.PstESPTPD"%>
<%@page import="com.dimata.dtaxintegration.session.SessReportWp"%>
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
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NAMA", "200px");//3
        ctrlist.addHeader("DATE", "200px");//4
        ctrlist.addHeader("ALAMAT", "200px");//5
        ctrlist.addHeader("BULAN", "200px");//6
        ctrlist.addHeader("TAHUN", "200px");//7
        ctrlist.addHeader("POKOK", "200px");//8
        ctrlist.addHeader("DENDA", "200px");//9
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
            Payment payment = (Payment) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+payment.getId());//2
            rowx.add(""+payment.getNama());//3
            rowx.add(""+payment.getInstansi());//4
            rowx.add(""+payment.getAlamatWp());//5
            rowx.add(""+payment.getBulan());//6
            rowx.add(""+payment.getTahun());//7
            rowx.add(""+payment.getPokok());//8
            rowx.add(""+payment.getDenda());//9
            rowx.add(""+payment.getTagihan());//10
            rowx.add(""+payment.getStsReversal());//10
            
            total=total+Double.parseDouble(payment.getTagihan());
            
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        //rowx.add("");
        //rowx.add("");
        //rowx.add("<b>Total<b>");
       // rowx.add(""+FRMHandler.userFormatStringDecimal(total));
        
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

    public String drawListDataPaymentPhrDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("NPWPD", "200px");//2
        ctrlist.addHeader("NAMA BADAN", "200px");//3
        ctrlist.addHeader("TANGGAL", "200px");//4
        ctrlist.addHeader("MASA PAJAK", "200px");//5
        ctrlist.addHeader("TAHUN", "200px");//6
        ctrlist.addHeader("OMZET", "200px");//7
        ctrlist.addHeader("TARIF", "200px");//8
        ctrlist.addHeader("JUMLAH PAJAK", "200px");//9
        ctrlist.addHeader("SERVICE", "200px");//10
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//11
         
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
            ESPTPD eSPTPD = (ESPTPD) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            
            rowx.add(""+count);//1
            rowx.add(""+eSPTPD.getENPWPD());//2
            rowx.add(""+eSPTPD.getNamaBadan());//3
            rowx.add(""+eSPTPD.getETglRekam());//4
            rowx.add(""+eSPTPD.getEMasaPajak());//5
            rowx.add(""+eSPTPD.getETahunPajak());//6
            rowx.add(""+eSPTPD.getEJumlahOmzet());//7
            rowx.add(""+eSPTPD.getETarif());//8
            rowx.add(""+FRMHandler.userFormatStringDecimal(eSPTPD.getEJumlahPajak()));//9
            rowx.add(""+FRMHandler.userFormatStringDecimal(eSPTPD.getEServiceTax()));//10
            rowx.add(""+FRMHandler.userFormatStringDecimal(eSPTPD.getEHarusBayar()));//11
            
            total=total+eSPTPD.getEHarusBayar();//10
            
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);
        
        rowx.add("");//1
        rowx.add("");//1
        rowx.add("");//2
        rowx.add("");//3
        rowx.add("");//4
        rowx.add("");//6
        rowx.add("");//7
        rowx.add("");//8
        rowx.add("");//9
        rowx.add("<b>Total<b>");//10
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//11
        
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
        oDate =startDate;
        oEnd = startEnd;
    }
    /*data table payment*/
    Vector listReportWp = new Vector();
    whereClause = ""+PstESPTPD.fieldNames[PstESPTPD.FLD_TGL_REKAM]
                  +" BETWEEN TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')"
                  +" AND TO_DATE ('"+oEnd+"','YYYY-MM-DD HH24:MI:SS')";
    listReportWp = SessReportWp.list(0, 0, whereClause, "");
    
%>
 <%@ page contentType="application/x-msexcel" %>
<html>
     <head>
        <meta charset="UTF-8">
        <title>Report RETRIBUSI Summary</title>
    </head>
    <body class="skin-blue">
        <table width="100%" cellspacing="0" cellpadding="3">
            <tr align="left" valign="top">
                  <td height="14" valign="middle" colspan="3" class="command">
                   <b><strong>
                        REPORT WP ONLINE <%=startDate%> S/D <%=startEnd%>
                    </strong></b>
                    </td>
                </tr>
        </table>
       <%=drawListDataPaymentPhrDispenda(iCommand, listReportWp, oidDriver)%>
    </body>
</html>
