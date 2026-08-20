<%-- 
    Document   : userlist
    Created on : Apr 11, 2015, 12:37:21 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.gui.jsp.ControlCombo"%>
<%@page import="com.dimata.util.Command"%>
<%@page import="com.dimata.gui.jsp.ControlLine"%>
<%@page import="com.dimata.qdep.form.FRMMessage"%>
<%@page import="com.dimata.qdep.form.FRMQueryString"%>
<%@page import="com.dimata.gui.jsp.ControlList"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file = "../main/javainit.jsp" %>
<%@ include file = "../main/checkuser.jsp" %>
<%!
public static final String textListTitleHeader[][] =
{
	{"Sistem","Daftar Pemakai","ID Pemakai","Nama Lengkap","Status","Tambah Pemakai Baru"},
	{"System","User LIst","User ID","Full Name","Status","Add New User"}
};

public String drawListAppUser(int language,Vector objectClass)
{
	String temp = ""; 
	String regdatestr = "";
	
	ControlList ctrlist = new ControlList();
	ctrlist.setAreaWidth("90%");
	ctrlist.setListStyle("listgen");
	ctrlist.setTitleStyle("listgentitle");
	ctrlist.setCellStyle("listgensell");
	ctrlist.setHeaderStyle("listgentitle");
	ctrlist.addHeader(textListTitleHeader[language][2],"20%");
	ctrlist.addHeader(textListTitleHeader[language][3],"70%");
	ctrlist.addHeader(textListTitleHeader[language][4],"10%");

	ctrlist.setLinkRow(0);
        ctrlist.setLinkSufix("");

	Vector lstData = ctrlist.getData();

	Vector lstLinkData 	= ctrlist.getLinkData();

	ctrlist.setLinkPrefix("javascript:cmdEdit('");
	ctrlist.setLinkSufix("')");
	ctrlist.reset();

	for (int i = 0; i < objectClass.size(); i++) {
		 AppUser appUser = (AppUser)objectClass.get(i);

		 Vector rowx = new Vector();
		 
		 rowx.add(String.valueOf(appUser.getLoginId()));
		 rowx.add(String.valueOf(appUser.getFullName()));
		 rowx.add(String.valueOf(AppUser.getStatusTxt(appUser.getUserStatus())));		 
		 		 
		 lstData.add(rowx);
		 lstLinkData.add(String.valueOf(appUser.getOID()));
	}						

	return ctrlist.draw();
}

%>
<%

/* VARIABLE DECLARATION */
int recordToGet = 10;

String order = " " + PstAppUser.fieldNames[PstAppUser.FLD_LOGIN_ID];

Vector listAppUser = new Vector(1,1);
ControlLine ctrLine = new ControlLine();

/* GET REQUEST FROM HIDDEN TEXT */
int iCommand = FRMQueryString.requestCommand(request);
int start = FRMQueryString.requestInt(request, "start"); 
long appUserOID = FRMQueryString.requestLong(request,"user_oid");
int listCommand = FRMQueryString.requestInt(request, "list_command");
if(listCommand==Command.NONE)
 listCommand = Command.LIST;

CtrlAppUser ctrlAppUser = new CtrlAppUser(request);
 
int vectSize = PstAppUser.getCount(""); 
start = ctrlAppUser.actionList(listCommand, start,vectSize,recordToGet);

listAppUser = PstAppUser.listPartObj(start,recordToGet, "" , order);

%>
<html>
    <head>
        <style>
            .h {
                font-size:10px;
            }
            .r {
                font-size:8px;
            }
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dimata Saras</title>

        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="../../styles/bootstrap3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="../../styles/bootstrap3.1/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="../../styles/bootstrap3.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="../../styles/bootstrap3.1/css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="../../styles/bootstrap3.1/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <link href="../../styles/bootstrap3.1/css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="../../styles/bootstrap3.1/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="../../styles/bootstrap3.1/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="../../styles/bootstrap3.1/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="../../styles/bootstrap3.1/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="../../styles/bootstrap3.1/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    
    <script language="JavaScript">
    <% if (privAdd){%>
    function addNew(){
            document.frmAppUser.user_oid.value="0";
            document.frmAppUser.list_command.value="<%=listCommand%>";
            document.frmAppUser.command.value="<%=Command.ADD%>";
            document.frmAppUser.action="useredit.jsp";
            document.frmAppUser.submit();
    }
    <%}%>

    function cmdEdit(oid){
            document.frmAppUser.user_oid.value=oid;
            document.frmAppUser.list_command.value="<%=listCommand%>";
            document.frmAppUser.command.value="<%=Command.EDIT%>";
            document.frmAppUser.action="useredit.jsp";
            document.frmAppUser.submit();
    }

    function cmdListFirst(){
            document.frmAppUser.command.value="<%=Command.FIRST%>";
            document.frmAppUser.list_command.value="<%=Command.FIRST%>";
            document.frmAppUser.action="userlist.jsp";
            document.frmAppUser.submit();
    }

    function cmdListPrev(){
            document.frmAppUser.command.value="<%=Command.PREV%>";
            document.frmAppUser.list_command.value="<%=Command.PREV%>";
            document.frmAppUser.action="userlist.jsp";
            document.frmAppUser.submit();
    }

    function cmdListNext(){
            document.frmAppUser.command.value="<%=Command.NEXT%>";
            document.frmAppUser.list_command.value="<%=Command.NEXT%>";
            document.frmAppUser.action="userlist.jsp";
            document.frmAppUser.submit();
    }

    function cmdListLast(){
            document.frmAppUser.command.value="<%=Command.LAST%>";
            document.frmAppUser.list_command.value="<%=Command.LAST%>";
            document.frmAppUser.action="userlist.jsp";
            document.frmAppUser.submit();
    }

    </script>
    </head>
    <body class="skin-blue">
        <%@ include file = "../../header_mobile.jsp" %> 
        <div class="wrapper row-offcanvas row-offcanvas-left">

            <!-- Left side column. contains the logo and sidebar -->
            <%@ include file = "../../menu_left_mobile_report.jsp" %> 

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Dashboard
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Dashboard</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                    <form name="frmAppUser" method ="post">
                        <div class="box">
                            <div class="box-header">
                                <div class="row">
                                    <div class="col-md-12">
                                        <h3 class="box-title">User List</h3>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>

                    </form>

                </section><!-- /.content -->

            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->

        <!-- add new calendar event modal -->


        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- jQuery UI 1.10.3 -->
        <script src="../../styles/bootstrap3.1/js/jquery-ui-1.10.3.min.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="../../styles/bootstrap3.1/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Morris.js charts -->
        <script src="../../styles/bootstrap3.1/libs/raphael/raphael-min.js"></script>
        <script src="../../styles/bootstrap3.1/js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="../../styles/bootstrap3.1/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="../../styles/bootstrap3.1/js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="../../styles/bootstrap3.1/js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- fullCalendar -->
        <script src="../../styles/bootstrap3.1/js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="../../styles/bootstrap3.1/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="../../styles/bootstrap3.1/js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="../../styles/bootstrap3.1/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="../../styles/bootstrap3.1/js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="../../styles/bootstrap3.1/js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="../../styles/bootstrap3.1/js/AdminLTE/dashboard.js" type="text/javascript"></script>
    </body>
</html>
