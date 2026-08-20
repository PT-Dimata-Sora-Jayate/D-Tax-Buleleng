<%-- 
    Document   : report_global_phr_excel
    Created on : Jul 7, 2015, 2:53:07 PM
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

    public String drawListDataPaymentPhrDispenda(int iCommand, Vector objectClass, long gradeId) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        ctrlist.setBorder(1);
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("GROUP USAHA", "200px");//2
        ctrlist.addHeader("POKOK", "200px");//2
        ctrlist.addHeader("DENDA", "200px");//2
        ctrlist.addHeader("JUMLAH", "200px");//2
         
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
            PaymentPhr paymentPhr = (PaymentPhr) objectClass.get(i);
            count=count+1;
            rowx = new Vector(1, 1);
            String sts = "";
            if(paymentPhr.getNpwpd().equals("1")){
                sts="HOTEL";
            }else if( paymentPhr.getNpwpd().equals("2")){
                sts="RESTAURANT";
            }else if( paymentPhr.getNpwpd().equals("3")){    
                sts="HIBURAN";
            }else if( paymentPhr.getNpwpd().equals("5")){    
                sts="PPJ";    
            }else{
                sts="ABT";
            }
            rowx.add(""+count);//1
            rowx.add(""+sts);//2
            rowx.add(""+paymentPhr.getPokok());//3
            rowx.add(""+paymentPhr.getDenda());//4
            rowx.add(""+paymentPhr.getJumlahBayar());//5
            total=total+paymentPhr.getJumlahBayar();
            pokok=pokok+paymentPhr.getPokok();
            denda=denda+paymentPhr.getDenda();
            
            lstData.add(rowx);
        }
        
        rowx = new Vector(1, 1);

        rowx.add("");//1
        rowx.add("<b>Total<b>");//7
        rowx.add(""+FRMHandler.userFormatStringDecimal(pokok));//8
        rowx.add(""+FRMHandler.userFormatStringDecimal(denda));//8
        rowx.add(""+FRMHandler.userFormatStringDecimal(total));//8
        
        lstData.add(rowx);

        return ctrlist.draw();
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
        oDate =startDate;
        oEnd = startEnd;
    }
    /*data table payment*/
    Vector listPaymentPhr = new Vector();
    /*order_date BETWEEN TO_DATE ('2014/02/01', 'yyyy/mm/dd')
      AND TO_DATE ('2014/02/28', 'yyyy/mm/dd');*/
    whereClause = PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS]+"='0'"
                  +" AND "+PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]
                  +" BETWEEN TO_DATE ('"+oDate+"','YYYY-MM-DD HH24:MI:SS')"
                  +" AND TO_DATE ('"+oEnd+"','YYYY-MM-DD HH24:MI:SS')"
                  +" GROUP BY SUBSTR(NPWPD, 0, 1) ";
    
    listPaymentPhr = PstPaymentPhr.listSum(0, 0, whereClause, "");
    
%>
 <%@ page contentType="application/x-msexcel" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Report PHR GLOBAL Summary</title>
    </head>
    <body class="skin-blue">
        <table width="100%" cellspacing="0" cellpadding="3">
            <tr align="left" valign="top">
                  <td height="14" valign="middle" colspan="3" class="command">
                   <b><strong>
                    REPORT PHR GLOBAL SUMMARY 
                    </strong></b>
                    </td>
                </tr>
             <tr align="left" valign="top">
                  <td  valign="middle" colspan="3" class="command">
                      <h2><%=AppSetting.REPORT_INSTANSI%></h2>
                  </td>
            </tr>
            <tr align="left" valign="top">
                  <td  valign="middle" colspan="6" class="command">
                      <h3><%=AppSetting.REPORT_DINAS%></h3>
                  </td>
            </tr>
            <tr align="left" valign="top">
                  <td  valign="middle" colspan="3" class="command">
                      <h4><%=AppSetting.REPORT_INSTANSI_ALAMAT%></h4>
                  </td>
            </tr>
             <tr align="left" valign="top">
                  <td valign="middle" colspan="3" class="command">
                      <h4>Dari Tanggal <%=startDate%> S/D <%=startEnd%></h4>
                  </td>
            </tr>
            <tr align="left" valign="top">
                <td valign="middle" colspan="3" class="command">&nbsp;
                </td>
            </tr>
        </table>
        <%=drawListDataPaymentPhrDispenda(iCommand, listPaymentPhr, oidDriver)%>
    </body>
</html>
