<%@page import="com.dimata.wponline.entity.wajibpajakonline.WajibPajak"%>
<%@page import="com.dimata.wponline.entity.wajibpajakonline.PstWajibPajak"%>
<%@page import="com.dimata.wponline.form.wajibpajakonline.FrmWajibPajak"%>
<%@page import="com.dimata.wponline.form.wajibpajakonline.CtrlWajibPajak"%>
<%@page import="com.dimata.wponline.ajax.AjaxWajibPajak"%>


<%@page import="com.dimata.gui.jsp.ControlCombo"%>
<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.qdep.form.FRMMessage"%>
<%@page import="com.dimata.qdep.form.FRMQueryString"%>
<%@page import="com.dimata.gui.jsp.ControlLine"%>
<%@page import="com.dimata.gui.jsp.ControlCheckBox"%>
<%@page import="com.dimata.saras.entity.admin.AppObjInfo"%>
<%@page import="com.dimata.saras.session.admin.SessAppUser"%>

<%@page import="java.util.Vector"%>

<%@ include file ="../../main/javainit.jsp" %>
<% int  appObjCode = AppObjInfo.composeObjCode(AppObjInfo.G1_ADMIN , AppObjInfo.G2_ADMIN_USER, AppObjInfo.OBJ_ADMIN_USER_USER); %>
<%@ include file = "../../main/checkuser.jsp" %>

<%!

public static final String textListTitleHeader[][] =
{
    {"WP ID","Nama User","Password","Nama Wajib Pajak","Alamat","NOP","Telepon","Fax","Status","Email","Kode Konfirmasi","Kembali","Approve","Reject","Kirim Ulang Link Konfirmasi"},
    {"WP ID","User Name","Password","Nama Wajib Pajak","Alamat","NOP","telepon","Fax","Status","Email","Kode Konfirmasi","Kembali","Approve","Reject","Kirim Ulang Link Konfirmasi"}
};

public static final String statusText[]={"Registrasi","Konfirmasi","Approve","Reject"};

%>

<%

/* VARIABLE DECLARATION */

ControlLine ctrLine = new ControlLine();

/* GET REQUEST FROM HIDDEN TEXT */
int iCommand = FRMQueryString.requestCommand(request);

long wpOid = FRMQueryString.requestLong(request,"wp_oid");

WajibPajak wajibPajak = new WajibPajak();
CtrlWajibPajak ctrlWajibPajak = new CtrlWajibPajak(request);
FrmWajibPajak frmWajibPajak = ctrlWajibPajak.getForm();
PstWajibPajak pstWajibPajak = new PstWajibPajak();
int excCode = FRMMessage.NONE;
String msgString =  "";

wajibPajak=pstWajibPajak.fetchExc(wpOid);

%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Data Tables</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="../../styles/bootstrap3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="../../styles/bootstrap3.1/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="../../styles/bootstrap3.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
 
        <link href="../../styles/bootstrap3.1/css/AdminLTE.css" rel="stylesheet" type="text/css" />

         <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="../styles/bootstrap3.1/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="../styles/bootstrap3.1/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script language="JavaScript">
        </script>
        
    </head>
    <body class="skin-blue">
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
                        Tables
                        <small>User Online</small>
                    </h1>
                </section>
                <!-- Main content -->
                <section class="content">
                     <div class="box">
                         <div class="box-body table-responsive">
                             <form name="<%= FrmWajibPajak.FRM_WAJIB_PAJAK%>" id="<%= FrmWajibPajak.FRM_WAJIB_PAJAK%>" method="post" action="">
                                 <input type="hidden" id="Command" name="Command" value="">
                                  <input type="hidden" name="wp_oid" id="wp_oid" value="<%=wpOid%>">
                                  <input type="hidden" name="context" id="context" value="<%= request.getContextPath()%>">
                                  <input type="hidden" name="alasanReject" id="alasanReject" value="">
                                  <input type="hidden" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]%>" id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_KODE_KONFIRMASI]%>" value="<%= wajibPajak.getKodeKonfirmasi()%>">
                                  <table width="100%" cellpadding="0" border="0" cellspacing="2">
                                    
                                    <tr>
                                      <td colspan="3" class="txtheading1"></td>
                                    </tr>
                                    <tr>
                                      <td colspan="3" height="26" class="bigtitleflash">
                                        <hr size="1">
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%" height="26"> <%=textListTitleHeader[SESS_LANGUAGE][1]%></td>
                                      <td width="2%" height="26">:</td>
                                      <td width="84%" height="26">
                                          <input readonly type="text" value="<%= wajibPajak.getNamaUser()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_NAMA_USER]%>" class="formElemen" id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_NAMA_USER]%>">
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%=textListTitleHeader[SESS_LANGUAGE][2]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input readonly type="password" id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_PASSWORD]%>" value="<%= wajibPajak.getPassword()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_PASSWORD]%>" class="formElemen"></td>
                                    </tr>
                                    <tr>
                                      <td width="14%"> <%=textListTitleHeader[SESS_LANGUAGE][3]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input readonly type="text" id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]%>" value="<%= wajibPajak.getNamaWajibPajak()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_NAMA_WAJIB_PAJAK]%>"class="formElemen" >
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"> <%=textListTitleHeader[SESS_LANGUAGE][4]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <textarea id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_ALAMAT]%>" readonly name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_ALAMAT]%>"><%= wajibPajak.getAlamat()%></textarea>
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"><%=textListTitleHeader[SESS_LANGUAGE][5]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_NOP]%>" readonly type="text" value="<%= wajibPajak.getNop()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_NOP]%>" class="formElemen">
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%" valign="top"> <%=textListTitleHeader[SESS_LANGUAGE][6]%></td>
                                      <td width="2%" valign="top">:</td>
                                      <td width="84%">
                                          <input id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_TELP]%>" readonly type="text" value="<%= wajibPajak.getTelp()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_TELP]%>" class="formElemen">
                             
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"> <%=textListTitleHeader[SESS_LANGUAGE][7]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_FAX]%>" readonly type="text" value="<%= wajibPajak.getFax()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_FAX]%>" class="formElemen">
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"> <%=textListTitleHeader[SESS_LANGUAGE][8]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input type="hidden" value="<%= wajibPajak.getStatus()%>" name="<%= frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_STATUS]%>" id="<%= frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_STATUS]%>" class="formElemen">
                      
                                          <input readonly type="text" value="<%= statusText[Integer.parseInt(wajibPajak.getStatus())]%>" name="status_show" class="formElemen">
                                          
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%"> <%=textListTitleHeader[SESS_LANGUAGE][9]%></td>
                                      <td width="2%">:</td>
                                      <td width="84%">
                                          <input id="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_EMAIL]%>" readonly type="text" value="<%= wajibPajak.getEmail()%>" name="<%=frmWajibPajak.fieldNames[frmWajibPajak.FRM_FIELD_EMAIL]%>" class="formElemen">
                                          
                                      </td>
                                    </tr>
                                    <tr>
                                      <td width="14%" valign="top" height="14" nowrap>&nbsp;</td>
                                      <td width="2%" height="14">&nbsp;</td>
                                      <td width="84%" height="14">&nbsp;</td>
                                    </tr>
                                    
                                    <tr>
                                      <td width="14%" valign="top" height="14" nowrap>&nbsp;</td>
                                      <td width="2%" height="14">&nbsp;</td>
                                      <td width="84%" height="14">&nbsp;</td>
                                    </tr>
                                    
                                    <tr>
                                      <td colspan="3" class="command">
                                          <button id='back' type='button' class='btn btn-primary'><i class='glyphicon glyphicon-arrow-left'></i> Kembali</button>
                                         
                                          <%
                                            int userOnlineStatus = Integer.parseInt(wajibPajak.getStatus());
                                            if (userOnlineStatus==1){
                                                out.println("<button id='approve' type='button' class='btn btn-success'><i class='glyphicon glyphicon-ok'></i> Approve</button>");
                                            }else{
                                                out.println("<button id='approve' disabled dis type='button' class='btn btn-success'><i class='glyphicon glyphicon-ok'></i> Approve</button>");
                                            }
                                            if (userOnlineStatus==1){
                                                out.println("<button id='reject' type='button' class='btn btn-danger'><i class='glyphicon glyphicon-remove'></i> Reject</button>");
                                            }else{
                                                out.println("<button id='reject' disabled type='button' class='btn btn-danger'><i class='glyphicon glyphicon-remove'></i> Reject</button>");
                                            }
                                            
                                            if (userOnlineStatus==0){
                                                out.println("<button id='resend' type='button' class='btn btn-warning'><i class='glyphicon glyphicon-repeat'></i> Kirim Ulang Link</button>");
                                            }else{
                                                out.println("<button id='resend' disabled type='button' class='btn btn-warning'><i class='glyphicon glyphicon-repeat'></i> Kirim Ulang Link</button>");
                                            }
                                          %>
                                          
                                          
                                       </td>
                                      
                                    </tr>
                                   
                                    
                                  
                                    <tr>
                                      <td width="14%">&nbsp;</td>
                                      <td width="2%">&nbsp;</td>
                                      <td width="84%">&nbsp;</td>
                                    </tr>
                                  </table>
                                </form>
                         </div>
                     </div>
                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->
        <!-- jQuery 2.0.2 -->
        <script src="../../styles/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="../../styles/bootstrap3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        
        <script>
            $(document).ready(function(){
                
                
	
                $('#reportSystem').on('hidden.bs.modal', function (e) {
                    window.location ="<%= request.getContextPath()%>/dtaxintegration/masterdata/user-online.jsp";
                })
                $('#approve').click(function(){
                    $('#messageModal').html('Mohon tunggu proses approve...')
                    $('#<%=FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_STATUS]%>').val('2');
                    $('#Command').val(<%= Command.RECONFIRM%>);
                    $('#reportSystem').modal({
                        backdrop: 'static',
                        keyboard: false
                      })
                    $("#btnTutup").attr({"disabled":true});
                    $("#btnTutup2").attr({"disabled":true});
                    $.ajax({
                         type	: "POST",
                         url	: "<%= request.getContextPath() %>/AjaxWajibPajak",
                         data	: $('#<%= FrmWajibPajak.FRM_WAJIB_PAJAK%>').serialize(),
                         cache	: false,
                         success	: function(data){
         
                             if (data==0){
                                 $("#informasiModal").html('INFORMASI');
                                $("#reportMessage").html('Approve berhasil dilakukan...');
                                $("#btnTutup").removeAttr("disabled");
                                $("#btnTutup2").removeAttr("disabled");

                             }
                         },
                         error : function(data){
                            $("#informasiModal").html('KESALAHAN KONEKSI');
                            $("#reportMessage").html('Konfirmasi gagal dilakukan,<br>Silahkan periksa koneksi internet anda...');
                            $("#btnTutup").removeAttr("disabled");
                            $("#btnTutup2").removeAttr("disabled");
                         }
                     });
                    
                });
                
                $('#reject').click(function(){
                    $('#<%=FrmWajibPajak.fieldNames[FrmWajibPajak.FRM_FIELD_STATUS]%>').val('3');
                    $('#Command').val(<%= Command.LOCK%>);
                    $("#btnTutup3").removeAttr("disabled");
                    $("#btnSimpan").removeAttr("disabled");
                    $('#reportSystem2').modal('show');
                    $('#peringatan').fadeOut();
                    $('#reason').val('');
                  
                });
                
                $('#reason').change(function(){                            
                    var reason = $('#reason').val();
                    $('#peringatan').fadeOut();
                    $('#alasanReject').val(reason);
                           
                });
                
                $('#reason').keyup(function(){
                    $('#peringatan').fadeOut();
                });
                
                $('#btnSimpan').click(function(){
                    var reason = $('#reason').val();
                     if (reason.length==0){
                        $('#peringatan').html('Silahkan masukkan alasan anda melakukan reject...');
                        $('#peringatan').fadeIn();
                    }else{
                        $("#btnSimpan").html("Mohon Tunggu...").attr({"disabled":true});
                        $("#btnTutup3").attr({"disabled":true});
                        $('#peringatan').fadeOut();
                        $.ajax({
                            type	: "POST",
                            url	: "<%= request.getContextPath() %>/AjaxWajibPajak",
                            data	: $('#<%= FrmWajibPajak.FRM_WAJIB_PAJAK%>').serialize(),
                            cache	: false,
                            success	: function(data){

                                if (data==0){
                                    $("#reportMessage2").html('<center>Proses reject berhasil dilakukan...</center>');
                                    $("#btnSimpan").html("Simpan");
                                    $("#btnTutup3").removeAttr("disabled");
                                    $("#btnSimpan").removeAttr("disabled");
                                    window.location ="<%= request.getContextPath()%>/dtaxintegration/masterdata/user-online.jsp";
                                   
                                }
                            }
                        });
                    }
                });
                
                $('#resend').click(function(){
                    $('#Command').val(<%= Command.REPOSTING%>);
                    $('#messageModal').html('Mohon tunggu link sedang dikirim ulang...')                  
                    $('#reportSystem').modal({
                        backdrop: 'static',
                        keyboard: false
                      })
                    $("#btnTutup").attr({"disabled":true});
                    $("#btnTutup2").attr({"disabled":true});
                    $.ajax({
                         type	: "POST",
                         url	: "<%= request.getContextPath() %>/AjaxWajibPajak",
                         data	: $('#<%= FrmWajibPajak.FRM_WAJIB_PAJAK%>').serialize(),
                         cache	: false,
                         success: function(data){
         
                             if (data==0){
                                $("#informasiModal").html('INFORMASI');
                                $("#reportMessage").html('Link berhasil dikirim...');
                                $("#btnTutup").removeAttr("disabled");
                                $("#btnTutup2").removeAttr("disabled");

                             }
                         },
                         error : function(data){
                            $("#informasiModal").html('KESALAHAN KONEKSI');
                            $("#reportMessage").html('Pengiriman link gagal dilakukan,<br>Silahkan periksa koneksi internet anda...');
                            $("#btnTutup").removeAttr("disabled");
                            $("#btnTutup2").removeAttr("disabled");
                         }
                     });
                });
                $('#back').click(function(){
                    window.location="<%= request.getContextPath()%>/dtaxintegration/masterdata/user-online.jsp";
                
                });
            });
            
        </script>
        <div id="reportSystem" class="modal fade" tabindex="-1">
            <div class="modal-dialog modal-sm" style="width:400px;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnTutup2" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="informasiModal">INFORMASI</h4>
                    </div>
                    <div class="modal-body">
                        <div id="reportMessage" style="text-align: center;">
                            <p id="messageModal"></p>
                            <center>
                            <img src="../../styles/wpupload/Image/loading.gif">
                            </center>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="btnTutup" type="button" data-dismiss="modal" class="btn btn-danger">Tutup</button>
                    </div>
                </div>
           </div>
        </div>
        
        <div id="reportSystem2" class="modal fade" tabindex="-1">
            <div class="modal-dialog modal-sm" style="width:400px;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button id="btnTutup3" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="informasiModal2">INFORMASI</h4>
                    </div>
                    
                    <div class="modal-body">
                        <div class="alert alert-warning " id="peringatan" role="alert" style="margin-left:0px;text-align: center; display: none">
                            
                        </div>
                        <div id="reportMessage2" style="text-align: center;">
                            <textarea id="reason" class="form-control" placeholder="Silahkan masukkan alasan anda melakukan reject user ini"></textarea>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button id="btnSimpan" type="button"  class="btn btn-primary">Simpan</button>
                      </div>
                </div>
           </div>
        </div>
    </body>