<%-- 
    Document   : ajaxDataReportSource
    Created on : Aug 23, 2015, 8:22:40 PM
    Author     : dimata005
--%>
<%@page import="com.dimata.webclient.AppSetting"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PstPaymentPhr"%>
<%@page import="com.dimata.util.Formater"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.dimata.qdep.form.FRMHandler"%>
<%@page import="com.dimata.dtaxintegration.entity.payment.PaymentPhr"%>
<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.gui.jsp.ControlList"%>
<%@page import="java.util.Vector"%>
<%@page import="com.dimata.qdep.form.FRMQueryString"%>

<%!
     public String drawListReportPhr(Vector objectClass) {

        ControlList ctrlist = new ControlList();

        ctrlist.setAreaWidth("100%");
        ctrlist.setListStyle("listgen");
        ctrlist.setTitleStyle("tableheader");
        ctrlist.setCellStyle("cellStyle");
        ctrlist.setHeaderStyle("tableheader");
        ctrlist.setBorder(1);
        
        ctrlist.addHeader("No", "200px");//1
        ctrlist.addHeader("SSPD", "200px");//2
        ctrlist.addHeader("NPWPD", "200px");//2
        ctrlist.addHeader("NAMA", "200px");//3
        ctrlist.addHeader("DATE", "200px");//4
        ctrlist.addHeader("BULAN", "200px");//6
        ctrlist.addHeader("TAHUN", "200px");//7
        ctrlist.addHeader("JUMLAH_BAYAR", "200px");//10
        ctrlist.addHeader("STATUS", "200px");//10
        
        
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
            rowx.add(""+paymentPhr.getJumlahBayar());//8
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

        return ctrlist.draw();
    }
%>    
<%
    int pageShow = FRMQueryString.requestInt(request, "pageShow");
    String name = FRMQueryString.requestString(request, "studentName");
    String searchType = FRMQueryString.requestString(request, "searchType");
    long oid = FRMQueryString.requestLong(request, "oid");
    String startDate = FRMQueryString.requestString(request, "tanggalStart");
    String oDate = "";//FRMQueryString.requestString(request, "tanggalEnd");
    
    String startEnd = FRMQueryString.requestString(request, "tanggalEnd");
    String oEnd = "";//FRMQueryString.requestString(request, "tanggalEnd");
    String start="";
    String end ="";
    
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
                start=Formater.formatDate(transaksiDate,"yyyy-MM-dd");
                
                Date transaksiEndDate = formatter.parse(dateEndStringTransaksi);
                oEnd = Formater.formatDate(transaksiEndDate,"yyyy-MM-dd HH:mm:ss");
                end = Formater.formatDate(transaksiEndDate,"yyyy-MM-dd");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    String whereClause="";
    
    switch(pageShow){
	case 1://report PHR
            Vector listPaymentPhr = new Vector();
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
            <div>
              <div class="col-md-12">
                    <div class="row">
                             <center><h3>Laporan Pajak PHR <br>
                                DINAS PENDAPATAN KABUPATEN GIANYAR <br></h3>
                                 <h5>Dari Tanggal <%=start%> s/d <%=end%></h5>
                            </center>
                            <hr>
                    </div>
                    <div class="row" id="resultSearchPrint">
                         <%=drawListReportPhr(listPaymentPhr)%>
                    </div>
              </div>
            </div>
            <%
            break;
            
	case 2: 
           
            %>
             
            <%
            break;
            
        case 3:  
           
            %>
              
            <%
           break;
        case 4:
             %>
            
            <%
            break;
            
          case 5:   
             %>
              
            <%
              break;
	default:
	    
	break;
    }
%>