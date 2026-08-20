<%-- 
    Document   : home_check_replikasi
    Created on : Mar 13, 2017, 10:46:07 AM
    Author     : dimata005
--%>
<%@page import="com.dimata.dslik.entity.debiturindividu.PstDebiturIndividu"%>
<%@page import="com.dimata.dslik.entity.admin.PstAppUser"%>
<%@page import="com.dimata.qdep.form.FRMQueryString"%>
<%@page import="com.dimata.gui.jsp.ControlCombo"%>
<%@page import="com.dimata.dslik.entity.masterdata.CabangBank"%>
<%@page import="com.dimata.dslik.entity.masterdata.PstCabangBank"%>
<%@page import="com.dimata.dslik.session.proses.SessionProsesPerlengkapan"%>
<%@page import="com.dimata.dslik.entity.kreditjoinaccount.PstKreditJoinAccount"%>
<%@page import="java.util.Date"%>
<%@page import="com.dimata.dslik.entity.pengurusataupemilik.PstPengurusAtauPemilik"%>
<%@page import="com.dimata.dslik.entity.laporankeuangandebitur.PstLaporanKeuanganDebitur"%>
<%@page import="com.dimata.dslik.entity.fasilitaslain.PstFasilitasLain"%>
<%@page import="com.dimata.dslik.entity.bankgaransi.PstBankGaransi"%>
<%@page import="com.dimata.dslik.entity.irrevocablelc.PstIrrevocableLc"%>
<%@page import="com.dimata.dslik.entity.suratberharga.PstSuratBerharga"%>
<%@page import="com.dimata.dslik.entity.kredit.PstKredit"%>
<%@page import="com.dimata.dslik.entity.penjamin.PstPenjamin"%>
<%@page import="com.dimata.dslik.entity.agunan.PstAgunan"%>
<%@page import="com.dimata.dslik.entity.debitur.PstDebitur"%>
<%@page import="com.dimata.util.Formater"%>
<%@page import="java.util.Vector"%>
<%@page import="com.dimata.dslik.entity.masterdata.PstPeriode"%>
<%@page import="com.dimata.dslik.entity.masterdata.Periode"%>
<%@page import="com.dimata.util.Command"%>
<!DOCTYPE html>
<%@include file="main/javainit_slik.jsp" %>
<%@include file="main/checkuser_slik.jsp" %>
<%
    boolean privView = userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_REPLIKASI, AppObjInfo.G2_REPLIKASI, AppObjInfo.OBJ_REPLIKASI, AppObjInfo.COMMAND_VIEW);
    boolean privDelete = userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_REPLIKASI, AppObjInfo.G2_REPLIKASI, AppObjInfo.OBJ_REPLIKASI, AppObjInfo.COMMAND_DELETE);
    boolean privUpdate = userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_REPLIKASI, AppObjInfo.G2_REPLIKASI, AppObjInfo.OBJ_REPLIKASI, AppObjInfo.COMMAND_UPDATE);
    //boolean privViewMaster = userSession.checkPrivG1G2ObjCommand(AppObjInfo.G1_MODUL_MASTER_DATA, AppObjInfo.G2_PROFILE_BANK, AppObjInfo.OBJ_BANK, AppObjInfo.COMMAND_VIEW);
%>
<%
String cabang = FRMQueryString.requestString(request, "cabangpersegment");
int iCommand = FRMQueryString.requestCommand(request);
if(userSession.checkPrivG1G2Obj(AppObjInfo.G1_ADMIN, AppObjInfo.G2_ADMIN_USER, AppObjInfo.OBJ_ADMIN_USER_USER)){
    if(iCommand==Command.UPDATE){
        if(userId!=0){
            long xxx = PstAppUser.updateCabangBank(cabang, userId);
            String remoteIP = request.getRemoteAddr();
            SessUserSession userSess = new SessUserSession(remoteIP );
            int dologinx=userSess.reDoLogin(userId);
            session.putValue(SessUserSession.HTTP_SESSION_NAME, userSess);
            kd_bank=cabang;
        }
    }
}
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>SLIK | HOME</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <%@include file="template-component/css-component.jsp" %>
    </head>
    <body class="<%=skin%>">
        <div class="wrapper">
            <input type="hidden" name="usergroup" id="usergroup" value="<%= getUserGroup %>">
            <input type="hidden" name="kodecabang" id="kodecabang" value="<%= kd_bank %>">
            <input type="hidden" name="periode" id="periode" value="<%= periode.getOID() %>">
            <input type="hidden" name="privupdate" id="privupdate" value="<%= privUpdate %>">
            <input type="hidden" name="privview" id="privview" value="<%= privView %>">
            <%@include file="template-component/header-component.jsp" %>
            <%@include file="template-component/sidebar-component.jsp" %>
            <!-- Content Wrapper. Contains page content -->
            <script language="JavaScript">   
            </script>
            <%
                if(privView){
            %>
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Dashboard
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-home"></i> Dashboard</a></li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class='box box-primary'>
                                <div class="box-header">
                                    <h3 class="box-title">
                                       Periode yang aktif : <%= (periode.getTglAwal() == null ? "" : Formater.formatDate(periode.getTglAwal(), "MMMM yyyy"))%>
                                    </h3>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <hr>
                                        </div>
                                    </div>  
                                    <div class="row">
                                        <div class="col-md-12">
                                            <center><h3>STATUS REPLIKASI</h3></center>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div id="dynamicOrder">
                                            </div> 
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <hr>
                                        </div>
                                    </div>    
                                </div>
                            </div>
                        </div><!-- ./col -->
                    </div><!-- /.row -->
                </section><!-- /.content -->
            </div><!-- /.content-wrapper -->
            <%
                }
            %>
            <div class='control-sidebar-bg'></div>
            
            
            <div id="showlistmodal" class="modal fade" tabindex="-1">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <div class="modal-body ">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="box-body" id="showlistmodal-body">

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="othermodal" class="modal fade" tabindex="-1">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title"></h4>
                        </div>
                        <form id="clear">
                            <input type="hidden" name="FRM_FIELD_DATA_FOR" value="clearlist">
                            <input type="hidden" name="command" value="<%= Command.DELETEALL %>">
                            <input type="hidden" name="target" id="target">
                            <div class="modal-body ">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box-body" id="otherform-body">
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <%
                                    if(privDelete){
                                        %>
                                            <button type="submit" class="btn btn-danger" id="savebtn"><i class="fa fa-trash"></i> Delete</button>
                                        <%
                                    }
                                %>

                                <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <%@include file="template-component/footer-component.jsp" %>
            <%@include file="template-component/plugins-component.jsp" %>
            <script language="JavaScript">
                function ajaxProsesTransfer(url,data,type,appendTo,another,optional){

                  $.ajax({
                      url : ""+url+"",
                      data: ""+data+"",
                      type : ""+type+"",
                      async : false,
                      cache: false,
                      success : function(data) {
                          if (appendTo!=""){
                              $(''+appendTo+'').html(data);
                          }

                      }
                  }).done(function(){

                  });
              }

              function loadData(){
                  var data="datatype=8";
                  ajaxProsesTransfer("<%=approot%>/AjaxProsesTransfer",data,"GET","#dynamicOrder","loadData","");
              }

              //load data pertama kalinya
              loadData();

              //untuk membuat load data
              setInterval(function() {
                  loadData();

              },1000);
            </script>
            
        </div><!-- ./wrapper -->?
    </body>
</html>
