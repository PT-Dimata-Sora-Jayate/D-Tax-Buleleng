/**
 *
 * Responsive website using AngularJS
 * http://www.script-tutorials.com/responsive-website-using-angularjs/
 *
 * Licensed under the MIT license.
 * http://www.opensource.org/licenses/mit-license.php
 *
 * Copyright 2013, Script Tutorials
 * http://www.script-tutorials.com/
 */

'use strict';

// optional controllers
//DASHBOAR CONTROL
function HomeCtrl($scope, $http, $timeout) {
    
    var command = $("#command").val();
    var approot = $("#approot").val();
    var onSuccess = null;
    var getDate = $("#FRM_FIELD_TANGGALBAYAR_DASHBOARD").val();
    var currentDate = $("#FRM_FIELD_CURRENT_DATE").val();
    datePicker(".datePickerDashboard", "dd MM yyyy");
    
    

    getTime('#displayTime');
    
    //TARGET VS REALISASI CHART
    var dataSend = {
	"FRM_FIELD_CHART_DATA_FOR" : "targetvsrealisasi",
	"FRM_FIELD_VIEW_TYPE":"renderchart",
	"command":command,
	"FRM_FIELD_CHART_TYPE" : "column"
    };
    var onDone = function(data){
	
	renderChart('targetvsrealisasi', data);
	
    }
    getData("targetvsrealisasi", approot, dataSend, onDone, null, "ChartHandler");
    
    //TOTAL PAJAK CHART
    dataSend = {
	"FRM_FIELD_CHART_DATA_FOR" : "totalpajak",
	"FRM_FIELD_VIEW_TYPE":"renderchart",
	"command":command,
	"FRM_FIELD_CHART_TYPE" : "pie"
    };
    onDone = function(data){
	var totalText = null;
	Highcharts.setOptions({
	    load : function(event) {
		var total = 0;
		for(var i=0, len=this.series[0].yData.length; i<len; i++){
		    total += this.series[0].yData[i];
		}
		
		totalText = this.renderer.text('Total: ' + total,this.plotLeft,this.plotTop - 20).attr({zIndex: 5}).add()
	    },
	    events : function(chart) {
		console.log(totalText);
		var total = 0;
		for(var i=0, len=this.series[0].yData.length; i<len; i++){
		    if (this.series[0].points[i].visible){
			total += this.series[0].yData[i];
		    }
		}
		totalText.element.innerHTML = 'Total: ' + total;
	    }
	});
	renderChart('totalpajak', data);
	
    }
    getData("totalpajak", approot, dataSend, onDone, null, "ChartHandler");
    
    
    //PENDAPATAN PER JENIS PAJAK
    dataSend = {
	"FRM_FIELD_CHART_DATA_FOR" : "pendapatanperjenispajak",
	"FRM_FIELD_VIEW_TYPE":"renderchart",
	"command":command,
	"FRM_FIELD_CHART_TYPE" : "column"
    };
    onDone = function(data){
	renderChart('pendapatanperjenispajak', data);
    }
    getData("pendapatanperjenispajak", approot, dataSend, onDone, null, "ChartHandler");
    
    //PERSENTASE PENDAPATAN PER JENIS PAJAK
    dataSend = {
	"FRM_FIELD_CHART_DATA_FOR" : "persentasependapatanperjenispajak",
	"FRM_FIELD_VIEW_TYPE":"renderchart",
	"command":command,
	"FRM_FIELD_CHART_TYPE" : "pie"
    };
    onDone = function(data){
	renderChart('persentasependapatanperjenispajak', data);
    }
    getData("persentasependapatanperjenispajak", approot, dataSend, onDone, null, "ChartHandler");
    
    
    //TABLE DAYLY, WEEKLY, MONTHLY AND YEARLY
    var tablePendapatanDaerah = function(elementId, repeat, viewType){
	getDate = $("#FRM_FIELD_TANGGALBAYAR_DASHBOARD").val();
	onDone = null;
	onSuccess = function(data){
	    $("#"+successElement+"-progress").fadeIn("medium");
	};
	var successElement = elementId;
	if(repeat == true){
	    $("#"+successElement+"-progress").html("<i class='fa fa-refresh'></i> Memperbaharui Data");
	    onSuccess = function(data){
		$("#"+successElement).html(data.HTML_DATA);
		$("#"+successElement+"-progress").html("<i class='fa fa-check'></i> Berhasil Memperbaharui Data");
	    }
	    elementId = null;
	}
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE" : viewType,
	    "command":command,
	    "FRM_FIELD_TANGGALBAYAR_DASHBOARD" : getDate
	}
	getData(elementId, approot, dataSend, onDone, onSuccess, "ChartHandler");
	
	var timeOut = function(){
	    setTimeout(function(){
		tablePendapatanDaerah(successElement, true, viewType);
	    }, 60000);
	};
	
	if(getDate == currentDate){
	    timeOut();
	}else{
	    clearTimeout(timeOut());
	}
    }
    tablePendapatanDaerah("reportperhari", false, "reportperhari");
    tablePendapatanDaerah("reportperbulan", false, "reportperbulan");
    
    $("#FRM_FIELD_TANGGALBAYAR_DASHBOARD").change(function(){
	$("#reportperhari-progress").hide();
	$("#reportperbulan-progress").hide();
	tablePendapatanDaerah("reportperhari", false, "reportperhari");
	tablePendapatanDaerah("reportperbulan", false, "reportperbulan");
    });
}

//MANUAL DATA PAJAK CONTROL
function ManualDataPajak($scope, $http) {
    
     $("form#FRM_NAME_SEARCHDATAPAJAK").submit(function(){
	$("#btnSearch").html("Please wait...").attr({"disabled":"true"});
        var command = $("#command").val();
        var approot = $("#approot").val();
	var dataSend = $(this).serialize();
        var rangeDate = $("#FRM_FIELD_RANGEDATE").val();
        
         if(rangeDate!=""){
            getData("VIEW_CONTENT", approot, dataSend, null, null, "InputDataPajak");
        }else{
            alert("Range tanggal tidak boleh kosong");
        }
        $("#btnSearch").removeAttr("disabled").html("<i class='fontello-loop'></i> Search");
	return false;
        
    });
    
    /*jika tombol search di klik*/
    $("#btnSearch").click(function(){
        document.FRM_NAME_SEARCHDATAPAJAK.command.value="1";
        var approot = $("#approot").val();
        var rangeDate = $("#FRM_FIELD_RANGEDATE").val();
        var dataSend = $("#FRM_NAME_SEARCHDATAPAJAK").serialize();
        
        if(rangeDate!=""){
            getData("VIEW_CONTENT", approot, dataSend, null, null, "InputDataPajak");
        }else{
            alert("Range tanggal tidak boleh kosong");
        }
        
        $("#btnSearch").removeAttr("disabled").html("<i class='fontello-loop'></i> Search");
	return false;
    });
    
    $("#btnDownload").click(function(){
        document.FRM_NAME_SEARCHDATAPAJAK.command.value="4";
        var approot = $("#approot").val();
        var rangeDate = $("#FRM_FIELD_RANGEDATE").val();
        var dataSend = $("#FRM_NAME_SEARCHDATAPAJAK").serialize();
        if(rangeDate!=""){
            getData("VIEW_CONTENT", approot, dataSend, null, null, "InputDataPajak");
        }else{
            alert("Range tanggal tidak boleh kosong");
        }
        
        $("#btnSearch").removeAttr("disabled").html("<i class='fontello-loop'></i> Search");
	return false;
    });
    
    
}

//OTOMATIS DATA PAJAK
function OtomaticDataPajak($scope, $http) {
    
    var interval=0;
    
    //cek status thread apakah running atau tidak
    checkStatusThread();
    
    $("#btnStart").click(function(){
        document.FRM_NAME_SEARCHDATAPAJAK.FRM_FIELD_TYPE_INPUT_DATA.value="1";
        document.FRM_NAME_SEARCHDATAPAJAK.command.value="51";
        var approot = $("#approot").val();
        var dataSend = $("#FRM_NAME_SEARCHDATAPAJAK").serialize();
        getData("VIEW_CONTENT_AUTOMATIC", approot, dataSend, null, null, "InputDataPajak");
        interval =  setInterval(function() {checkStatusNote();},1000);
        $("#btnStart").fadeOut("medium");
        $("#btnStop").show();
        //$("#btnStop").removeAttr("disabled");
        //5000ms = 5 detik
	return false;
        
    });
    
    function checkStatusThread(){
        document.FRM_NAME_SEARCHDATAPAJAK.FRM_FIELD_TYPE_INPUT_DATA.value="3";
        var approot = $("#approot").val();
        var dataSend = $("#FRM_NAME_SEARCHDATAPAJAK").serialize();
        var onSuccess = function(data){
           if(data.HTML_DATA=="running"){
                $("#btnStart").fadeOut("medium");
                $("#btnStop").show();
                checkStatusNote();
           }else{
                $("#btnStop").fadeOut("medium");
                $("#btnStart").show();
           }
        };
        getData("VIEW_CONTENT_AUTOMATIC", approot, dataSend, null, onSuccess, "InputDataPajak");
    }
    
    function checkStatusNote(){
        document.FRM_NAME_SEARCHDATAPAJAK.FRM_FIELD_TYPE_INPUT_DATA.value="2";
        var approot = $("#approot").val();
        var dataSend = $("#FRM_NAME_SEARCHDATAPAJAK").serialize();
        getData("VIEW_CONTENT_AUTOMATIC", approot, dataSend, null, null, "InputDataPajak");
    }
    
    $("#btnStop").click(function(){
       // alert("klik");
        document.FRM_NAME_SEARCHDATAPAJAK.command.value="52";
        document.FRM_NAME_SEARCHDATAPAJAK.FRM_FIELD_TYPE_INPUT_DATA.value="1";
        var approot = $("#approot").val();
        var dataSend = $("#FRM_NAME_SEARCHDATAPAJAK").serialize();
        getData("VIEW_CONTENT_AUTOMATIC", approot, dataSend, null, null, "InputDataPajak");
        clearInterval(interval);
       // alert("klik2");
        $("#btnStop").fadeOut("medium");
        $("#btnStart").show();
	return false;
    });
    
}

//TampilkanListUser
function TampilkanListUser($scope, $http) {
    var command = $("#command").val();
    var approot = $("#approot").val();
    var onDone = null;
    var dataSend = null;
    var onSuccess = null;
    var modalUserEdit = "#useredit";
    var oid=null;
    var isCorrect = null;
    modalSetting(modalUserEdit, null, true, false);
    var openmodaluser = function(){
	$(".showuseredit").click(function(){
	    command = $("#command").val();
	    oid = $(this).data("oid");
	    $("#USER_OID").val(oid);
	    //SHOW MODAL
	    $(modalUserEdit).modal("show");

	    //SET OR RESET VALUE INPUT
	    if(oid != 0){
		dataSend = {
		    "FRM_FIELD_VIEW_TYPE" : "getdatauser",
		    "user_oid" : oid,
		    "command" : command
		};
		onDone = null;
		onSuccess = function(data){
		    $("#LOGIN_ID").val(data.LOGIN_ID_DATA);
		    $("#PASSWORD").val(data.PASSWORD_DATA);
		    $("#CFRM_PASSWORD").val(data.CFM_PASSWORD_DATA);
		    $("#FULL_NAME").val(data.FULL_NAME_DATA);
		    $("#EMAIL").val(data.EMAIL_DATA);
		    $("#DESCRIPTION").val(data.DESC_DATA);
		    $("#USER_STATUS").val(data.STATUS_DATA);
		    $("#USER_GROUP_NEW").val(data.GROUP_DATA);
		    
		};
		getData(null, approot, dataSend, onDone, onSuccess, "UserListHandler");
	    }else{
		$(":input","#APP_USER").not(":hidden").val('');
	    }

	    //REMOVE ERROR
	    $("#APP_USER").find(".errormessage").hide();
	    $("#APP_USER").find(".form-group").removeClass("has-error");


	    dataSend = {
		"FRM_FIELD_VIEW_TYPE" : "viewgroupassigned",
		"user_oid" : oid,
		"command" : command
	    };
	    getData("groupassigned", approot, dataSend, null, null, "UserListHandler");
	});
    }
    openmodaluser();
    
    var loadlistuser = function(){
	command = $("#command").val();
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE" : "getlistuser",
	    "command" : command
	};
	onDone = function(data){
	    openmodaluser();
	};
	onSuccess = null;
	getData("listuser", approot, dataSend, onDone, onSuccess, "UserListHandler");
    };
    
    $("form#APP_USER").submit(function(){
	
	validate("#LOGIN_ID", "text", "has-error", null, 1);
	validate("#PASSWORD", "text", "has-error", null, 1);
	
	var getPassword = $("#PASSWORD").val();
	validate("#CFRM_PASSWORD", "text", "has-error", getPassword, 1);
	validate("#FULL_NAME", "text", "has-error", null, 1);
	validate("#EMAIL", "email", "has-error", null, 0);
	
	isCorrect = $(this).find(".has-error").length;
	if(isCorrect == 0){
	    var currentHtml = $("#btnsimpanuser").html();
	    $("#btnsimpanuser").html("Harap Tunggu...").attr({"disabled":"true"});
	    dataSend = $(this).serialize();
	    onDone = loadlistuser;
	    onSuccess = function(data){
		$("#btnsimpanuser").removeAttr("disabled").html(currentHtml);
		$(modalUserEdit).modal("hide");
		notifications(data);
	    };
	    getData(null, approot, dataSend, onDone, onSuccess, "UserListHandler");
	}
	return false;
    });
}


//TampilkanGroupList
function TampilkanGroupList($scope, $http, $timeout) {
    var command = $("#command").val();
    var approot = $("#approot").val();
    var modalGroupList = "#groupedit";
    var groupOid = null;
    var onDone = null;
    var onSuccess = null;
    var dataSend = null;
    var sessLang = $("#FRM_FIELD_LANGUAGE").val();
    modalSetting(modalGroupList, null, true, false);
    var isCorrect = null;
    
    var checkPriv = function(groupOid){
	$("#group_oid").val(groupOid);
	dataSend = {
	    "command":command,
	    "FRM_FIELD_VIEW_TYPE" : "getpriv",
	    "group_oid" : groupOid,
	    "FRM_FIELD_LANGUAGE" : sessLang
	};
	if(groupOid != 0){
	    onSuccess = function(data){
		$("#APP_GROUP_NAME").val(data.GROUP_NAME);
		$("#APP_GROUP_DESCR").html(data.GROUP_DESC);
		$("#APP_GROUP_REG_DATE").val(data.GROUP_REG_DATE);
		
	    };
	}else{
	    onSuccess = null;
	}
	onDone = null;
		
	getData("listprivchb", approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
    };
    var openmodalgroup = function(){
	$(".addeditgroup").click(function(){
	    groupOid = $(this).data("groupOid");
	    command = $("#command").val();
	    checkPriv(groupOid);
	    $(modalGroupList).modal("show");
	    if(groupOid != 0){

	    }else{
		$("#APP_GROUP_DESCR").val('');
		$(":input :textbox","#APP_GROUP").not(":hidden").val('');
		
	    }
	});
    };
    openmodalgroup();
    
    var loadlistgroup = function(){
	command = $("#command").val();
	dataSend = {
	    "command":command,
	    "FRM_FIELD_VIEW_TYPE" : "getlistgroup",
	    "FRM_FIELD_LANGUAGE" : sessLang
	};
	onDone = function(data){
	    openmodalgroup();
	};
	onSuccess = null;
	getData("listgroup", approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
    };
    
    $("form#APP_GROUP").submit(function(){
	var currentHtml = $("#buttongroupedit").html();
	$("#buttongroupedit").html("Harap Tunggu...").attr({"disabled":"true"});
	validate("#APP_GROUP_NAME", "text", "has-error", null, 1);
	validate("#APP_GROUP_DESCR", "text", "has-error", null, 1);
	validate("#APP_GROUP_REG_DATE", "text", "has-error", null, 1);
	isCorrect = $(this).find(".has-error").length;
	if(isCorrect == 0){
	    dataSend = $(this).serialize();
	    onDone = function(data){
		loadlistgroup();
	    };
	    onSuccess = function(data){
		notifications(data);
		$(modalGroupList).modal("hide");
		$("#buttongroupedit").removeAttr("disabled").html(currentHtml);
	    };
	    getData(null, approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
	}
	return false;
    });
    datePicker(".datePicker", "dd MM yyyy");
}


//TampilkanPrivilage
function TampilkanPrivilage($scope, $http) {
    var command = $("#command").val();
    var approot = $("#approot").val();
    var onDone = null;
    var dataSend = null;
    var onSuccess = null;
    var modalPriv = "#privedit";
    var modalModul = "#moduledit";
    var modalModulObj = "#modulobj";
    var sessLang = $("#FRM_FIELD_LANGUAGE").val();
    
    var isCorrect = null;
    var oid=null;
    var privOid = null;
    var titleNew = $("#titlenew").val();
    var titleEdit = $("#titleedit").val();
    
    modalSetting(modalPriv, null, true, false);
    modalSetting(modalModul, null, true, false);
    modalSetting(modalModulObj, null, true, false);
    
    var openprivmodal = function(){
	$(".showprivedit").click(function(){
	    privOid = $(this).data("oid");
	    command = $("#command").val();
	    $("#privedit").modal("show");
	    $("#btnhakakses").data("oid",privOid);
	    if(privOid != 0){
		$("#titlemodal").html(titleEdit);
		dataSend = {
		    "command" : command,
		    "FRM_FIELD_VIEW_TYPE" : "getdatapriv",
		    "priv_oid" : ""+privOid+"",
		    "FRM_FIELD_LANGUAGE" : sessLang
		};
		onDone = null
		onSuccess = function(data){
		    $('#APP_PRIV_NAME').val(data.PRIV_NAME);
		    $("#APP_PRIV_DESCR").val(data.PRIV_DESC);
		    $("#APP_PRIV_REG_DATE").val(data.PRIV_REG_DATE);
		    $("#priv_oid").val(privOid);
		    
		};
		getData(null, approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
		$("#btnhakakses").fadeIn("medium");
	    }else{
		$("#titlemodal").html(titleNew);
		$(":input","#APP_PRIVILEGE").not(":hidden").val('');
		$("#priv_oid").val(privOid);
		$("#btnhakakses").hide();
	    }

	});
    }
    openprivmodal();
    
    var loadlistpriv = function(oid){
	command = $("#command").val();
	dataSend = {
	    "command" : command,
	    "FRM_FIELD_VIEW_TYPE" : "listpriv",
	    "user_oid" : oid,
	    "FRM_FIELD_LANGUAGE" : sessLang
	};
	onDone = openprivmodal;
	onSuccess = null;
	getData("listpriv", approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
    }
    
    var openmodalmodullist = function(){
	$("#btnhakakses").click(function(){
	    command = $("#command").val();
	    $(modalModul).modal("show");
	    privOid = $(this).data("oid");
	    dataSend = {
		"command" : command,
		"FRM_FIELD_VIEW_TYPE" : "listmodul",
		"priv_oid" : privOid,
		"FRM_FIELD_LANGUAGE" : sessLang
	    };
	    onDone = openmodulmodal;
	    onSuccess = function(data){
		$("#privname").html(data.PRIV_NAME);
		$("#privdesc").html(data.PRIV_DESC);
		$("#addprivobj").data("privOid",data.PRIV_OID);
	    };
	    getData("listprivobj", approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
	});
	
    }
    openmodalmodullist();
    
    //SAVE PRIVILEGE
    $("form#APP_PRIVILEGE").submit(function(){
	command = $("#command").val();
	var currentHtml = $("#buttonprivedit").html();
	$("#buttonprivedit").html("Harap Tunggu...").attr({"disabled":"true"});
	validate("#APP_PRIV_NAME", "text", "has-error", null, 1);
	validate("#APP_PRIV_DESCR", "text", "has-error", null, 1);
	validate("#APP_PRIV_REG_DATE", "text", "has-error", null, 1);
	
	isCorrect = $(this).find(".has-error").length;
	if(isCorrect == 0){
	    dataSend = $(this).serialize();
	    onSuccess = function(data){
		notifications(data);
		$("#privedit").modal("hide");
		loadlistpriv(oid);
		$("#buttonprivedit").removeAttr("disabled").html(currentHtml);
	    };
	    if(privOid == 0){
		onDone = function(data){
		    $(modalModul).modal("show");
		    dataSend = {
			"command" : command,
			"FRM_FIELD_VIEW_TYPE" : "listmodul",
			"priv_oid" : ""+data.PRIV_OID+"",
			"user_oid" : oid,
			"FRM_FIELD_LANGUAGE" : sessLang
		    };
		    onDone = null;
		    onSuccess = function(data){
			$("#privname").html(data.PRIV_NAME);
			$("#privdesc").html(data.PRIV_DESC);
			$("#addprivobj").data("privOid",data.PRIV_OID);
		    };
		    getData("listprivobj", approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
		    
		    
		}
	    }
	    
	    getData(null, approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
	}
	return false;
    });
    
    //OPEN MODUL MODAL
    var openmodulmodal = function(){
	$(".addeditmodul").click(function(){
	    var privObjOid = $(this).data("privObjOid");
	    var privOid = $(this).data("privOid");
	    $("#APP_PRIV_ID").val(privOid);
	    $("#priv_obj_oid").val(privObjOid);
	    command = $(this).data("command");
	    $(modalModulObj).modal("show");
	    onDone = function(data){
		$("#APP_G1_IDX").change(function(){
		    onDone = null;
		    onSuccess = null;
		    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "APP_G2_IDX", "getgroup2");
		    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "APP_OBJ_IDX", "getobjidx");
		    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "commands", "getcommands");
		});

		$("#APP_G2_IDX").change(function(){
		    onDone = null;
		    onSuccess = null;
		    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "APP_OBJ_IDX", "getobjidx");
		    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "commands", "getcommands");
		});

		$("#APP_OBJ_IDX").change(function(){
		    onDone = null;
		    onSuccess = null;
		    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "commands", "getcommands");
		});
	    };
	    onSuccess = null;
	    checkContent(privObjOid, privOid, sessLang, command, onDone, onSuccess, "contentmodulobj","addeditmodul");
	});
    }
    openmodulmodal();
    
    
    //SAVE MODUL
    $("form#APP_PRIVILEGE_OBJ").submit(function(){
	var currentHtml = $("#buttonsaveobj").html();
	$("#buttonsaveobj").html("Harap Tunggu...").attr({"disabled":"true"});
	onDone = function(data){
	    command = $("#command").val();
	    dataSend = {
		"command" : command,
		"FRM_FIELD_VIEW_TYPE" : "listmodul",
		"priv_oid" : ""+data.PRIV_OID+"",
		"user_oid" : oid,
		"FRM_FIELD_LANGUAGE" : sessLang
	    };
	    onSuccess = null;
	    onDone = openmodulmodal;
	    getData("listprivobj", approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
	};
	dataSend = $(this).serialize();
	onSuccess = function(data){
	    $(modalModulObj).modal("hide");
	    notifications(data);
	    $("#buttonsaveobj").removeAttr("disabled").html(currentHtml);
	};
	getData(null, approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
    });
    
    //CHECK CONTENT
    var checkContent = function(privObjOid, privOid, sessLang, command, onDone, onSuccess, elementId, viewType){
	var group1 = $("#APP_G1_IDX").val();
	var group2 = $("#APP_G2_IDX").val();
	var idxObj = $("#APP_OBJ_IDX").val();
	dataSend = {
	    "priv_obj_oid" : privObjOid,
	    "priv_oid" : privOid,
	    "FRM_FIELD_VIEW_TYPE" : viewType,
	    "command" : command,
	    "FRM_FIELD_LANGUAGE" : sessLang,
	    "APP_G1_IDX" : group1,
	    "APP_G2_IDX" : group2,
	    "APP_OBJ_IDX" : idxObj
	};
	getData(elementId, approot, dataSend, onDone, onSuccess, "PrivilegeHandler");
    }
    datePicker(".datePickerDashboard", "dd MM yyyy");
}




//INPUT TARGET CONTROL
function InputTarget($scope, $http, $timeout){
    
   var jenisPajak = $('#FRM_FIELD_PAJAK_DETAIL_ID').val();
    var tahunTarget = $("#FRM_FIELD_TAHUN_TARGET").val();
    var sumberTarget = $("#FRM_FIELD_SUMBER_TARGET").val();
    var tahunSumber = $("#FRM_FIELD_TAHUN_SUMBER").val();
    var command = $("#command").val();
    var approot = $("#approot").val();
    var privAdd = $("#privadd").val();
    var privupdate = $("#privupdate").val();
    
    var disableinput = function(privAdd, privupdate){
	if((privAdd == false || privAdd == "false") && (privupdate == false || privupdate == "false")){
	    $("#allkenaikan").attr({"disabled":"true"});
	    $(".percent").attr({"disabled":"true"});
	    $(".amountTarget").attr({"disabled":"true"});
	    
	    
	}
    };
    var dataSend = {
	"FRM_FIELD_PAJAK_DETAIL_ID" : jenisPajak,
	"FRM_FIELD_TAHUN_TARGET" : tahunTarget,
	"FRM_FIELD_SUMBER_TARGET" : sumberTarget,
	"FRM_FIELD_VIEW_TYPE":"viewtarget",
	"FRM_FIELD_TAHUN_SUMBER" : tahunSumber,
	"command":command
    };
    
    
    //CALCULATE TARGET
    var onDone = function(data) {
	calculate();
	getPercent();
	disableinput(privAdd, privupdate);
	
    }
    
    var onSuccess = function(data){
	notifications(data);
    };
    //ONLOAD (FIRST / DEFAULT DATA)
    getData("VIEW_CONTENT", approot, dataSend, onDone, null, "InputTargetHandler");
    
    
    //COMBOBOX CHANGED (JENIS PAJAK, TAHUN SUMBER, JENIS SUMBER)
    $(".showDataTarget").change(function(){
	jenisPajak = $("#FRM_FIELD_PAJAK_DETAIL_ID").val();
	tahunTarget = $("#FRM_FIELD_TAHUN_TARGET").val();
	sumberTarget = $("#FRM_FIELD_SUMBER_TARGET").val();
	tahunSumber = $("#FRM_FIELD_TAHUN_SUMBER").val();
	
	dataSend = {
	    "FRM_FIELD_PAJAK_DETAIL_ID" : jenisPajak,
	    "FRM_FIELD_TAHUN_TARGET" : tahunTarget,
	    "FRM_FIELD_SUMBER_TARGET" : sumberTarget,
	    "FRM_FIELD_VIEW_TYPE":"viewtarget",
	    "FRM_FIELD_TAHUN_SUMBER" : tahunSumber,
	    "command":command
	};
	
	getData("VIEW_CONTENT", approot, dataSend, onDone, null,"InputTargetHandler");
    });
    
    //SPECIIALY FOR TAHUN TARGET (BECAUSE IF CHANGED SET THE VALUE OF TAHUN SUMBER)
    $("#FRM_FIELD_TAHUN_TARGET").change(function(){
	
	
	//SET NEW VALUE OF TAHUN SUMBER
	tahunTarget = $("#FRM_FIELD_TAHUN_TARGET").val();
	tahunSumber = tahunTarget-1;
	jenisPajak = $("#FRM_FIELD_PAJAK_DETAIL_ID").val();
	sumberTarget = $("#FRM_FIELD_SUMBER_TARGET").val();
	
	var dataSend = {
	    "FRM_FIELD_TAHUN_TARGET" : tahunTarget,
	    "FRM_FIELD_VIEW_TYPE":"viewtahunsumber",
	    "command":command
	};
	getData("FRM_FIELD_TAHUN_SUMBER",approot, dataSend, onDone, null, "InputTargetHandler");
	
	
	//DISPLAY THE DATA TARGET
	dataSend = {
	    "FRM_FIELD_PAJAK_DETAIL_ID" : jenisPajak,
	    "FRM_FIELD_TAHUN_TARGET" : tahunTarget,
	    "FRM_FIELD_SUMBER_TARGET" : sumberTarget,
	    "FRM_FIELD_VIEW_TYPE":"viewtarget",
	    "FRM_FIELD_TAHUN_SUMBER" : tahunSumber,
	    "command":command
	};
	getData("VIEW_CONTENT",approot, dataSend, onDone, null, "InputTargetHandler");
	
	
	
    });
    
    $("form#FRM_NAME_DATATARGET").submit(function(){
	$("#btnSave").html("Please wait...").attr({"disabled":"true"});
	dataSend = $(this).serialize();
	jenisPajak = $("#FRM_FIELD_PAJAK_DETAIL_ID").val();
	tahunTarget = $("#FRM_FIELD_TAHUN_TARGET").val();
	sumberTarget = $("#FRM_FIELD_SUMBER_TARGET").val();
	tahunSumber = $("#FRM_FIELD_TAHUN_SUMBER").val();
	onDone = function(data){
	    
	    dataSend = {
		"FRM_FIELD_PAJAK_DETAIL_ID" : jenisPajak,
		"FRM_FIELD_TAHUN_TARGET" : tahunTarget,
		"FRM_FIELD_SUMBER_TARGET" : sumberTarget,
		"FRM_FIELD_VIEW_TYPE":"viewtarget",
		"FRM_FIELD_TAHUN_SUMBER" : tahunSumber,
		"command":command
	    };
	    onDone = function(data){
		calculate();
		getPercent();
		disableinput(privAdd, privupdate);
	    }
	    getData("VIEW_CONTENT",approot,dataSend,onDone, null, "InputTargetHandler");
	    $("#btnSave").removeAttr("disabled").html("<i class='fa fa-check'></i> Simpan");
	}
        onSuccess = null;
	getData(null, approot, dataSend, onDone, onSuccess, "InputTargetHandler");
	return false;
    });
    
   
}

//PENCAPAIN HARI INI CONTROL
function PencapaianHariIni($scope, $http, $timeout) {
    
    datePicker(".datePicker", "yyyy-mm-dd");
    
    var command = $("#command").val();
    var approot = $("#approot").val();
    var pajakType = $("#pajakType").val();
    var pajakTypes = pajakType.split(",");
    var dateSelect = $(".datePicker").val();
    var dataSend;
    var onDone;
    
    //PENDAPATAN PER JENIS PAJAK
    var pendapatanPerJenisPajak = function(approot, dataSend, onSuccess, onDone, command, dateSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pendapatanperjenispajakhariini",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_TANGGALBAYAR" : dateSelect
	};
	var onDone = function(data){
	    renderChart('pendapatanperjenispajakhariini', data);
	};
	getData("pendapatanperjenispajakhariini", approot, dataSend, onDone, null, "ChartHandler");
    };
    
    
    //PERSENTASE PENDAPATAN PER JENIS PAJAK
    var persentasePendapatanPerJenisPajak = function(approot, dataSend, onSuccess, onDone, command, dateSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "persentasependapatanperjenispajakhariini",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "pie",
	    "FRM_FIELD_TANGGALBAYAR" : dateSelect

	};
	onDone = function(data){
	    renderChart('persentasependapatanperjenispajakhariini', data);
	};
	getData("persentasependapatanperjenispajakhariini", approot, dataSend, onDone, null, "ChartHandler");
    };
    
    
    var pencapaian = function(approot, dataSend, onSuccess, onDone, command, pajakTypes, dateSelect){
	onDone = function(data){
	    renderChart('pencapaian', data);
	};
	for(var i=0; i < pajakTypes.length; i++){
	    dataSend = {
		"FRM_FIELD_CHART_DATA_FOR" : "pencapaian",
		"FRM_FIELD_VIEW_TYPE":"renderchart",
		"command":command,
		"FRM_FIELD_CHART_TYPE" : "spline",
		"FRM_FIELD_PAJAK_TYPE" : ""+pajakTypes[i]+"",
		"FRM_FIELD_TANGGALBAYAR" : dateSelect

	    };
	    getData("pencapaian"+pajakTypes[i], approot, dataSend, onDone, null, "ChartHandler");
	    
	    dataSend = {
		"FRM_FIELD_CHART_DATA_FOR" : "pencapaian",
		"FRM_FIELD_VIEW_TYPE":"pencapaiantable",
		"command":command,
		"FRM_FIELD_CHART_TYPE" : "area",
		"FRM_FIELD_PAJAK_TYPE" : ""+pajakTypes[i]+"",
		"FRM_FIELD_TANGGALBAYAR" : dateSelect

	    };
	    getData("pencapaiantable"+pajakTypes[i], approot, dataSend, null, null, "ChartHandler");

	}
    };
    
    //PENDAPATAN PER JENIS PAJAK
    pendapatanPerJenisPajak(approot, dataSend, null, onDone, command, dateSelect);
    
    //PERSENTASE PENDAPATAN PER JENIS PAJAK
    persentasePendapatanPerJenisPajak(approot, dataSend, null, onDone, command, dateSelect);
    
    //PENCAPAIAN
    pencapaian(approot, dataSend, null, onDone, command, pajakTypes, dateSelect);
    
    $(".datePicker").change(function(){
	var dateSelect = $(this).val();
	//PENDAPATAN PER JENIS PAJAK
	pendapatanPerJenisPajak(approot, dataSend, null, onDone, command, dateSelect);

	//PERSENTASE PENDAPATAN PER JENIS PAJAK
	persentasePendapatanPerJenisPajak(approot, dataSend, null, onDone, command, dateSelect);

	//PENCAPAIAN
	pencapaian(approot, dataSend, null, onDone, command, pajakTypes, dateSelect);
    });
    
}

//PENCAPAIAN PADA BULAN TERTENTU
function PencapaianPadaBulan($scope, $http, $timeout){
    var command = $("#command").val();
    var approot = $("#approot").val();
    var bulanSelect = $("#FRM_FIELD_BULAN").val();
    var onSuccess = null;
    var dataSend = null;
    var onDone = null;
    
    //PENDAPATAN PER JENIS PAJAK
    var pendapatanPerJenisPajak = function(bulanSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pendapatanpadabulantertentu",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_BULAN" : bulanSelect
	};
	onDone = function(data){
	    renderChart('pendapatanpadabulantertentu', data);
	};

	getData("pendapatanpadabulantertentu", approot, dataSend, onDone, null, "ChartHandler");
    };
    pendapatanPerJenisPajak(bulanSelect);
    
    
    //PERSENTASE PENDAPATAN PER JENIS PAJAK
    var persentasePendapatanPerJenisPajak = function(bulanSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "persenpendapatanpadabulantertentu",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "pie",
	    "FRM_FIELD_BULAN" : bulanSelect

	};

	onDone = function(data){
	    renderChart('persenpendapatanpadabulantertentu', data);
	};

	getData("persenpendapatanpadabulantertentu", approot, dataSend, onDone, null, "ChartHandler");
    };
    persentasePendapatanPerJenisPajak(bulanSelect);
    
    
    //PENDAPATAN PAJAK AKUMULASI
    var pendapatanPajakAkumulasi = function(bulanSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pendapatanpajakakumulasi",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN" : bulanSelect

	};

	onDone = function(data){
	    renderChart('pendapatanpajakakumulasi', data);
	};

	getData("pendapatanpajakakumulasi", approot, dataSend, null, onDone, "ChartHandler");
    };
    pendapatanPajakAkumulasi(bulanSelect);
    
    //PENDAPATAN PAJAK AKUMULASI PHR
    var pendapatanPajakAkumulasiPhr = function(bulanSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pendapatanpajakakumulasiphr",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN" : bulanSelect

	};

	onDone = function(data){
	    renderChart('pendapatanpajakakumulasiphr', data);
	};

	getData("pendapatanpajakakumulasiphr", approot, dataSend, onDone, null, "ChartHandler");
    };
    pendapatanPajakAkumulasiPhr(bulanSelect);
    
    //PENDAPATAN PER HARI
    var pendapatanPerHari = function(bulanSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pendapatanperhari",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN" : bulanSelect

	};

	onDone = function(data){
	    renderChart('pendapatanperhari', data);
	};

	getData("pendapatanperhari", approot, dataSend, onDone, null, "ChartHandler");
    };
    pendapatanPerHari(bulanSelect);
    
    //AKUMULASI PER JENIS PAJAK
    var akumulasiPerJenisPajak = function(bulanSelect){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "akumulasiperjenispajak",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN" : bulanSelect

	};

	onDone = function(data){
	    renderChart('akumulasiperjenispajak', data);
	};

	getData("akumulasiperjenispajak", approot, dataSend, onDone, null, "ChartHandler");
    };
    akumulasiPerJenisPajak(bulanSelect);
    
    
    //TAHUN CHANGE
    $("#FRM_FIELD_TAHUN").change(function(){
	var tahunSelect = $(this).val();
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE" : "getbulan",
	    "command":command,
	    "FRM_FIELD_TAHUN" : tahunSelect
	};
	
	onSuccess = function(data){
	    $("#FRM_FIELD_BULAN").html(data.HTML_DATA);
	};
	
	onDone = function(data){
	    bulanSelect = $("#FRM_FIELD_BULAN").val();
	    
	    
	    //PENDAPATAN PER JENIS PAJAK
	    pendapatanPerJenisPajak(bulanSelect);
	    
	    //PERSENTASE PENDAPATAN PER JENIS PAJAK
	    persentasePendapatanPerJenisPajak(bulanSelect);
	    
	    //PENDAPATAN PAJAK AKUMULASI
	    pendapatanPajakAkumulasi(bulanSelect);
	    
	    //PENDAPATAN PAJAK AKUMULASI PHR
	    pendapatanPajakAkumulasiPhr(bulanSelect);
	    
	    //PENDAPATAN PER HARI
	    pendapatanPerHari(bulanSelect);
	    
	    //AKUMULASI PER JENIS PAJAK
	    akumulasiPerJenisPajak(bulanSelect);
	};
	getData(null, approot, dataSend, onDone, onSuccess, "PadaBulanHandler");
    });
    
    
    //BULAN CHANGE
    $("#FRM_FIELD_BULAN").change(function(){
	bulanSelect = $(this).val();
	
	//PENDAPATAN PER JENIS PAJAK
	pendapatanPerJenisPajak(bulanSelect);
	
	//PERSENTASE PENDAPATAN PER JENIS PAJAK
	persentasePendapatanPerJenisPajak(bulanSelect);
	
	//PENDAPATAN PAJAK AKUMULASI
	pendapatanPajakAkumulasi(bulanSelect);
	
	//PENDAPATAN PAJAK AKUMULASI PHR
	pendapatanPajakAkumulasiPhr(bulanSelect);
	
	//PENDAPATAN PER HARI
	pendapatanPerHari(bulanSelect);
	
	//AKUMULASI PER JENIS PAJAK
	akumulasiPerJenisPajak(bulanSelect);
    });
}

//PERBANDINGAN 2 TAHUN
function Perbandingan2Tahun($scope, $http, $timeout){
    var perbandinganTahun = [];
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = $(".FRM_FIELD_TAHUN").val();
    var dataSend = null
    var onDone = null;
    
    $('.FRM_FIELD_TAHUN').each(function(i){
	perbandinganTahun[i] = $(this).val();
    });
    
    $(".FRM_FIELD_TAHUN").change(function(){
	$('.FRM_FIELD_TAHUN').each(function(i){
	    perbandinganTahun[i] = $(this).val();
	});
	$(".startYear").html(perbandinganTahun[0]);
	$(".endYear").html(perbandinganTahun[1]);
	
	//PERBANDINGAN 2 TAHUN
	perbandingan2Tahun(perbandinganTahun.toString());
	
	//TABEL PERBANDINGAN 2 TAHUN
	tabelPerbandingan2Tahun(perbandinganTahun.toString());
	
	//PERBANDINGAN PER JENIS PAJAK
	perbandinganPerJenisPajak(perbandinganTahun.toString());
	
	//PERBANDINGAN PER JENIS PAJAK NON PHR
	perbandinganPerJenisPajakNonPHR(perbandinganTahun.toString());
	
	//PERBANDINGAN PER BULAN
	perbandinganPerBulan(perbandinganTahun.toString());
	
	//TABLE PERBANDINGAN PER BULAN
	tabelPerbandinganPerBulan(perbandinganTahun.toString());
	
    });
    
    //PERBANDINGAN 2 TAHUN
    var perbandingan2Tahun = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandingan2tahun",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('perbandingan2tahun', data);
	};
	getData("perbandingan2tahun", approot, dataSend, onDone, null, "ChartHandler");
    }
    perbandingan2Tahun(perbandinganTahun.toString());
    
    //TABEL PERBANDINGAN 2 TAHUN
    var tabelPerbandingan2Tahun = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelperbandingan2tahun",
	    "command":command,
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	getData("tabelperbandingan2tahun", approot, dataSend, null, null, "ChartHandler");
    }
    tabelPerbandingan2Tahun(perbandinganTahun.toString());
    
    //PERBANDINGAN PER JENIS PAJAK
    var perbandinganPerJenisPajak = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandinganperjenispajak",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('perbandinganperjenispajak', data);
	};
	getData("perbandinganperjenispajak", approot, dataSend, onDone, null, "ChartHandler");
    }
    perbandinganPerJenisPajak(perbandinganTahun.toString());
    
    //PERBANDINGAN PER JENIS PAJAK
    var perbandinganPerJenisPajakNonPHR = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandinganperjenispajaknonphr",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('perbandinganperjenispajaknonphr', data);
	};
	getData("perbandinganperjenispajaknonphr", approot, dataSend, onDone, null, "ChartHandler");
    }
    perbandinganPerJenisPajakNonPHR(perbandinganTahun.toString());
    
    //PERBANDINGAN PER BULAN
    var perbandinganPerBulan = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandinganperbulan",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('perbandinganperbulan', data);
	};
	getData("perbandinganperbulan", approot, dataSend, onDone, null, "ChartHandler");
    }
    perbandinganPerBulan(perbandinganTahun.toString());
    
    //TABEL PERBANDINGAN PER BULAN
    var tabelPerbandinganPerBulan = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelperbandinganperbulan",
	    "command":command,
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	getData("tabelperbandinganperbulan", approot, dataSend, null, null, "ChartHandler");
    }
    tabelPerbandinganPerBulan(perbandinganTahun.toString());
    
    //TABEL PERBANDINGAN 2 TAHUN
    var tabelPerbandingan2Tahun = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelperbandingan2tahun",
	    "command":command,
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	getData("tabelperbandingan2tahun", approot, dataSend, null, null, "ChartHandler");
    }
    tabelPerbandingan2Tahun(perbandinganTahun.toString());
    
}

//PERKEMBANGAN 3 TAHUN
function Perbandingan3Tahun($scope, $http, $timeout){
    var perbandinganTahun = [];
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = null;
    getTahun = $("#FRM_FIELD_TAHUN_3_TAHUN").val();
    var startFrom = Number(getTahun)-2;
    var pajakType = $("#pajakType").val();
    var pajakTypes = pajakType.split(",");
    
    for(var i = 0; i<=2; i++){
	perbandinganTahun[i] = startFrom + i;
    }
    var dataSend = null;
    var onDone = null;
    
    
    
    //TAHUUN CHANGED
    $("#FRM_FIELD_TAHUN_3_TAHUN").change(function(){
	startFrom = Number($(this).val())-2;
	for(var i = 0; i<=2; i++){
	    perbandinganTahun[i] = startFrom + i;
	}
	
	//PERBANDINGAN 3 TAHUN
	Perbandingan3Tahun(perbandinganTahun.toString());
	
	//TABEL PERBANDINGAN 3 TAHUN
	tabelPerbandingan3Tahun(perbandinganTahun.toString());
	
	//PERBANDINGAN PER JENIS PAJAK
	perbandinganPerJenisPajak(pajakTypes,perbandinganTahun.toString());
	
	
	//PERBANDINGAN PER BULAN
	perbandinganPerBulan3Tahun(perbandinganTahun.toString());
    });
    
    
    //PERBANDINGAN PER JENIS PAJAK
    var perbandingan3Tahun = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandingan3tahun",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('perbandingan3tahun', data);
	};
	getData("perbandingan3tahun", approot, dataSend, onDone, null, "ChartHandler");
    }
    perbandingan3Tahun(perbandinganTahun.toString());
    
    
    //TABEL PERBANDINGAN 3 TAHUN
    var tabelPerbandingan3Tahun = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelperbandingan3tahun",
	    "command":command,
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	getData("tabelperbandingan3tahun", approot, dataSend, null, null, "ChartHandler");
    }
    tabelPerbandingan3Tahun(perbandinganTahun.toString());
    
    
    //PERBANDINGAN PER JENIS PAJAK
    var perbandinganPerJenisPajak = function(pajakTypes, perbandinganTahun){
	for(var i=0; i < pajakTypes.length; i++){
	    dataSend = {
		"FRM_FIELD_CHART_DATA_FOR" : "perbandinganperjenispajak",
		"FRM_FIELD_VIEW_TYPE":"renderchart",
		"command":command,
		"FRM_FIELD_CHART_TYPE" : "column",
		"FRM_FIELD_PAJAK_TYPE" : ""+pajakTypes[i]+"",
		"FRM_FIELD_TAHUN":perbandinganTahun,
		"FRM_FIELD_COLOR":i

	    };
	    onDone = function(data){
		renderChart('perbandingan3tahun', data);
	    };
	    getData("perbandinganperjenispajak"+pajakTypes[i], approot, dataSend, onDone, null, "ChartHandler");
	}
    }
    perbandinganPerJenisPajak(pajakTypes,perbandinganTahun.toString());
    
    //PERBANDINGAN PER BULAN
    var perbandinganPerBulan3Tahun = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandinganperbulan3tahun",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('perbandinganperbulan3tahun', data);
	};
	getData("perbandinganperbulan3tahun", approot, dataSend, onDone, null, "ChartHandler");
    }
    perbandinganPerBulan3Tahun(perbandinganTahun.toString());
}

//PROYEKSI PENDAPATAN
function ProyeksiPendapatan($scope, $http, $timeout){
    var perbandinganTahun = [];
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = null;
    getTahun = $("#FRM_FIELD_TAHUN_PROYEKSI").val();
    var startFrom = Number(getTahun)-2;
    var pajakType = $("#pajakType").val();
    var pajakTypes = pajakType.split(",");
    
    for(var i = 0; i<=2; i++){
	perbandinganTahun[i] = startFrom + i;
    }
    var dataSend = null;
    var onDone = null;
    
    
    
    //TAHUUN CHANGED
    $("#FRM_FIELD_TAHUN_PROYEKSI").change(function(){
	startFrom = Number($(this).val())-2;
	for(var i = 0; i<=2; i++){
	    perbandinganTahun[i] = startFrom + i;
	}
	
	$(".proyeksi").html($(this).val());
	//PROYEKSI PENDAPATAN
	proyeksiPendapatan(perbandinganTahun.toString());
	
	//TABEL PROYEKSI PENDAPATAN
	tabelProyeksiPendapatan(perbandinganTahun.toString());
	
	//PROYEKSI PENDAPATAN PER JENIS PAJAK
	proyeksiPerJenisPajak(pajakTypes,perbandinganTahun.toString());
	
	//PROYEKSI PER BULAN
	proyeksiPerBulan(perbandinganTahun.toString());
    });
    
    
    //PERBANDINGAN PER JENIS PAJAK
    var proyeksiPendapatan = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "proyeksipendapatan",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('proyeksipendapatan', data);
	};
	getData("proyeksipendapatan", approot, dataSend, onDone, null, "ChartHandler");
    }
    proyeksiPendapatan(perbandinganTahun.toString());
    
    //TABEL PERBANDINGAN 3 TAHUN
    var tabelProyeksiPendapatan = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelproyeksipendapatan",
	    "command":command,
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	getData("tabelproyeksipendapatan", approot, dataSend, null, null, "ChartHandler");
    }
    tabelProyeksiPendapatan(perbandinganTahun.toString());
    
    //PROYEKSI PER JENIS PAJAK
    var proyeksiPerJenisPajak = function(pajakTypes, perbandinganTahun){
	for(var i=0; i < pajakTypes.length; i++){
	    dataSend = {
		"FRM_FIELD_CHART_DATA_FOR" : "proyeksiperjenispajak",
		"FRM_FIELD_VIEW_TYPE":"renderchart",
		"command":command,
		"FRM_FIELD_CHART_TYPE" : "column",
		"FRM_FIELD_PAJAK_TYPE" : ""+pajakTypes[i]+"",
		"FRM_FIELD_TAHUN":perbandinganTahun,
		"FRM_FIELD_COLOR":i

	    };
	    onDone = function(data){
		renderChart('proyeksiperjenispajak', data);
	    };
	    getData("proyeksiperjenispajak"+pajakTypes[i], approot, dataSend, onDone, null, "ChartHandler");
	}
    }
    proyeksiPerJenisPajak(pajakTypes,perbandinganTahun.toString());
    
    //PROYEKSI PER BULAN
    var proyeksiPerBulan = function(perbandinganTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "proyeksiperbulan",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_TAHUN":perbandinganTahun
	};
	onDone = function(data){
	    renderChart('proyeksiperbulan', data);
	};
	getData("proyeksiperbulan", approot, dataSend, onDone, null, "ChartHandler");
    }
    proyeksiPerBulan(perbandinganTahun.toString());
}

//TAMPILKAN TARGET
function TampilkanTarget($scope, $http, $timeout){
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = null;
    getTahun = $("#FRM_FIELD_TAHUN_TARGET_TAMPIL").val();
    var dataSend = null;
    var onDone = null;
    $(".targetYear").html(""+getTahun);
    
    $("#FRM_FIELD_TAHUN_TARGET_TAMPIL").change(function(){
	getTahun = $(this).val();
	$(".targetYear").html(""+getTahun);
	
	//TARGET PAJAK
	targetPajak(getTahun);
	
	//TARGET PAJAK NON PHR
	targetPajakNonPhr(getTahun);
	
	//PERSENTASE TARGET PAJAK
	persentaseTargetPajak(getTahun);
	
	//TABEL TARGET PAJAK
	tabelTargetPajak(getTahun);
	
	//TARGET PAJAK PHR
	targetPajakPhrHotel(getTahun);
	
	//TARGET PAJAK PHR NON HOTEL
	targetPajakPhrNonHotel(getTahun);
    });
    
    //TARGET PAJAK
    var targetPajak = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "targetpajak",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN":getTahun+"-01"
	};
	onDone = function(data){
	    renderChart('targetpajak', data);
	};
	getData("targetpajak", approot, dataSend, onDone, null, "ChartHandler");
    };
    targetPajak(getTahun);
    
    //TARGET PAJAK NON PHR
    var targetPajakNonPhr = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "targetpajaknonphr",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN":getTahun+"-01"
	};
	onDone = function(data){
	    renderChart('targetpajaknonphr', data);
	};
	getData("targetpajaknonphr", approot, dataSend, onDone, null, "ChartHandler");
    };
    targetPajakNonPhr(getTahun);
    
    //PERSENTASE TARGET PAJAK
    var persentaseTargetPajak = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "persentasetargetpajak",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "pie",
	    "FRM_FIELD_BULAN":getTahun+"-01"
	};
	onDone = function(data){
	    renderChart('persentasetargetpajak', data);
	};
	getData("persentasetargetpajak", approot, dataSend, onDone, null, "ChartHandler");
    };
    persentaseTargetPajak(getTahun);
    
    //PERSENTASE TARGET PAJAK
    var tabelTargetPajak = function(getTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE" : "tabeltargetpajak",
	    "command":command,
	    "FRM_FIELD_BULAN":getTahun+"-01"
	};
	getData("tabeltargetpajak", approot, dataSend, null, null, "ChartHandler");
    };
    tabelTargetPajak(getTahun);
    
    //TARGET PAJAK PHR
    var targetPajakPhrHotel = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "targetpajakphrhotel",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN":getTahun+"-01"
	};
	onDone = function(data){
	    renderChart('targetpajakphrhotel', data);
	};
	getData("targetpajakphrhotel", approot, dataSend, onDone, null, "ChartHandler");
    };
    targetPajakPhrHotel(getTahun);
    
    //TARGET PAJAK PHR NON HOTEL
    var targetPajakPhrNonHotel = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "targetpajakphrnonhotel",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN":getTahun+"-01"
	};
	onDone = function(data){
	    renderChart('targetpajakphrnonhotel', data);
	};
	getData("targetpajakphrnonhotel", approot, dataSend, onDone, null, "ChartHandler");
    };
    targetPajakPhrNonHotel(getTahun);
}

//KOMPOSISI PHR
function KomposisiPHR($scope, $http, $timeout){
    var command = $("#command").val();
    var approot = $("#approot").val();
    var dataSend = null;
    var onDone = null;
    var padaBulan = $("#FRM_FIELD_BULAN_KOMPOSISI_PHR").val();
    
    $("#FRM_FIELD_BULAN_KOMPOSISI_PHR").change(function(){
	padaBulan = $(this).val();
	$(".forYear").html(padaBulan);
	//TARGET VS REALISASI
	komposisiPhrSampaiHariIni(padaBulan);
	
	//PERSENTASE TARGET VS REALISASI
	persenKomposisiPhrSampaiHariIni(padaBulan);
	
	//PENCAPAIAN PHR LINE
	pencapaianPhrLine(padaBulan);
	
	//PENCAPAIAN PHR STACK
	pencapaianPhrStack(padaBulan);
	
	//TABEL PENCAPAIAN PER BULAN
	tabelPendapatanPHRPerbulan(padaBulan);
	
    })
    
    //TARGET VS REALISASI CHART
    var komposisiPhrSampaiHariIni = function(padaBulan){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "komposisiphr",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_BULAN":padaBulan+"-01"
	};
	onDone = function(data){

	    renderChart('komposisiphr', data);
	}
	getData("komposisiphr", approot, dataSend, onDone, null, "ChartHandler");
    };
    komposisiPhrSampaiHariIni(padaBulan);
    
    var persenKomposisiPhrSampaiHariIni = function(padaBulan){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "persenkomposisiphr",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "pie",
	    "FRM_FIELD_BULAN":padaBulan+"-01"
	};
	onDone = function(data){

	    renderChart('persenkomposisiphr', data);
	}
	getData("persenkomposisiphr", approot, dataSend, onDone, null, "ChartHandler");
    };
    persenKomposisiPhrSampaiHariIni(padaBulan);
    
    var tabelKomposisiPhrSampaiHariIni = function(padaBulan){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelkomposisiphr",
	    "command":command,
	    "FRM_FIELD_BULAN":padaBulan+"-01"
	};
	getData("tabelkomposisiphr", approot, dataSend, null, null, "ChartHandler");
    };
    tabelKomposisiPhrSampaiHariIni(padaBulan);
    
    var pencapaianPhrLine = function(padaBulan){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pencapaianphrline",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN":padaBulan+"-01"
	};
	onDone = function(data){

	    renderChart('pencapaianphrline', data);
	}
	getData("pencapaianphrline", approot, dataSend, onDone, null, "ChartHandler");
    };
    pencapaianPhrLine(padaBulan);
    
    var pencapaianPhrStack = function(padaBulan){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "pencapaianphrstackline",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_BULAN":padaBulan+"-01"
	};
	onDone = function(data){

	    renderChart('pencapaianphrstackline', data);
	}
	getData("pencapaianphrstackline", approot, dataSend, onDone, null, "ChartHandler");
    };
    pencapaianPhrStack(padaBulan);
    
    var tabelPendapatanPHRPerbulan = function(padaBulan){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelpencapaianphrperbulan",
	    "command":command,
	    "FRM_FIELD_BULAN":padaBulan+"-01"
	};
	getData("tabelpencapaianphrperbulan", approot, dataSend, null, null, "ChartHandler");
    };
    tabelPendapatanPHRPerbulan(padaBulan);
    
}

//TOP 10 WP
function Top10WP($scope, $http, $timeout){
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = null;
    var oidPajakDetail = null;
    var onDone = null
    var dataSend = null;
    var pajakDetailName = null;
    getTahun = $("#FRM_FIELD_TAHUN_WP").val();
    oidPajakDetail = $("#FRM_FIELD_PAJAKDETAILID").val();
    pajakDetailName = $("#FRM_FIELD_PAJAKDETAILID option:selected").text();
    $(".wp").html(pajakDetailName);
    
    $(".WP_FILTER").change(function(){
	getTahun = $("#FRM_FIELD_TAHUN_WP").val();
	oidPajakDetail = $("#FRM_FIELD_PAJAKDETAILID").val();
	pajakDetailName = $("#FRM_FIELD_PAJAKDETAILID option:selected").text();
	$(".wp").html(pajakDetailName)
	//PENDAPATAN PAJAK AKUMULASI PHR
	top10WPColumn(getTahun, oidPajakDetail, pajakDetailName);
	
	//PENDAPATAN PAJAK AKUMULASI PHR
	top10WPLine(getTahun, oidPajakDetail, pajakDetailName);
	
	//PENDAPATAN PAJAK AKUMULASI PHR
	tabelTop10WP(getTahun, oidPajakDetail, pajakDetailName);
    });
    
    //PENDAPATAN PAJAK AKUMULASI PHR
    var top10WPColumn = function(getTahun, oidPajakDetail, pajakDetailName){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "top10wpcolumn",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_BULAN" : getTahun+"-01",
	    "FRM_FIELD_PAJAKDETAILID" : oidPajakDetail,
	    "FRM_FIELD_PAJAK_DETAIL_NAME" : pajakDetailName

	};

	onDone = function(data){
	    renderChart('top10wpcolumn', data);
	};

	getData("top10wpcolumn", approot, dataSend, onDone, null, "ChartHandler");
    };
    top10WPColumn(getTahun, oidPajakDetail, pajakDetailName);
    
    //PENDAPATAN PAJAK AKUMULASI PHR
    var top10WPLine = function(getTahun, oidPajakDetail){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "top10wpline",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "spline",
	    "FRM_FIELD_BULAN" : getTahun+"-01",
	    "FRM_FIELD_PAJAKDETAILID" : oidPajakDetail,
	    "FRM_FIELD_PAJAK_DETAIL_NAME" : pajakDetailName

	};

	onDone = function(data){
	    renderChart('top10wpline', data);
	};

	getData("top10wpline", approot, dataSend, onDone, null, "ChartHandler");
    };
    top10WPLine(getTahun, oidPajakDetail, pajakDetailName);
    
    //PENDAPATAN PAJAK AKUMULASI PHR
    var tabelTop10WP = function(getTahun, oidPajakDetail){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabeltop10wp",
	    "command":command,
	    "FRM_FIELD_BULAN" : getTahun+"-01",
	    "FRM_FIELD_PAJAKDETAILID" : oidPajakDetail,
	    "FRM_FIELD_PAJAK_DETAIL_NAME" : pajakDetailName

	};

	getData("tabeltop10wp", approot, dataSend, null, null, "ChartHandler");
    };
    tabelTop10WP(getTahun, oidPajakDetail, pajakDetailName);
    
}

//PER DESA (TOP 20)
function PerDesa($scope, $http, $timeout){
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = null;
    var onDone = null
    var dataSend = null;
    getTahun = $("#FRM_FIELD_TAHUN_DESA").val();
    
    $("#FRM_FIELD_TAHUN_DESA").change(function(){
	getTahun = $(this).val();
	
	//PENDAPATAN PAJAK PER DESA (TOP 20)
	perDesa(getTahun);
	
	//TABEL PENDAPATAN PER DESA (TOP 20)
	tabelPerDesa(getTahun);
    });
    
    //PENDAPATAN PAJAK PER DESA (TOP 20)
    var perDesa = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perdesa",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_BULAN" : getTahun+"-01",

	};

	onDone = function(data){
	    renderChart('perdesa', data);
	};

	getData("perdesa", approot, dataSend, onDone, null, "ChartHandler");
    };
    perDesa(getTahun);
    
    //TABEL PENDAPATAN PAJAK PER DESA (TOP 20)
    var tabelPerDesa = function(getTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelperdesa",
	    "command":command,
	    "FRM_FIELD_BULAN" : getTahun+"-01",

	};

	getData("tabelperdesa", approot, dataSend, null, null, "ChartHandler");
    };
    tabelPerDesa(getTahun);
    
    
}

//PER DESA (TOP 20)
function PerKecamatan($scope, $http, $timeout){
    var command = $("#command").val();
    var approot = $("#approot").val();
    var getTahun = null;
    var onDone = null
    var dataSend = null;
    getTahun = $("#FRM_FIELD_TAHUN_KECAMATAN").val();
    $(".kecamatan").html(getTahun);
    
    $("#FRM_FIELD_TAHUN_KECAMATAN").change(function(){
	getTahun = $(this).val();
	$(".kecamatan").html(getTahun);
	//PENDAPATAN PAJAK PER KECAMATAN
	perKecamatan(getTahun);
	
	//TABEL PENDAPATAN PER KECAMATAN
	tabelPerKecamatan(getTahun);
	
	//PERBANDINGAN KECAMATAN
	perbandinganKecamatan(getTahun); 
	
    });
    
    //PENDAPATAN PAJAK PER KECAMATAN
    var perKecamatan = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "persenperkecamatan",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "pie",
	    "FRM_FIELD_BULAN" : getTahun+"-01",

	};

	onDone = function(data){
	    renderChart('persenperkecamatan', data);
	};

	getData("persenperkecamatan", approot, dataSend, onDone, null, "ChartHandler");
    };
    perKecamatan(getTahun);  
    
    //PENDAPATAN PAJAK PER KECAMATAN
    var tabelPerKecamatan = function(getTahun){
	dataSend = {
	    "FRM_FIELD_VIEW_TYPE":"tabelperkecamatan",
	    "command":command,
	    "FRM_FIELD_BULAN" : getTahun+"-01",

	};

	onDone = function(data){
	    renderChart('tabelperkecamatan', data);
	};

	getData("tabelperkecamatan", approot, dataSend, null, null, "ChartHandler");
    };
    tabelPerKecamatan(getTahun);
    
    //PERBANDINGAN PAJAK PER KECAMATAN
    var perbandinganKecamatan = function(getTahun){
	dataSend = {
	    "FRM_FIELD_CHART_DATA_FOR" : "perbandingankecamatan",
	    "FRM_FIELD_VIEW_TYPE":"renderchart",
	    "command":command,
	    "FRM_FIELD_CHART_TYPE" : "column",
	    "FRM_FIELD_BULAN" : getTahun+"-01",

	};

	onDone = function(data){
	    renderChart('perbandingankecamatan', data);
	};

	getData("perbandingankecamatan", approot, dataSend, onDone, null, "ChartHandler");
    };
    perbandinganKecamatan(getTahun);  
    
}

//AJAX GENERAL FUNCNTION
function getData(viewContentId, approot, dataSend, onDone, onSuccess, link){
    
    $("#"+viewContentId).html("<div class='progress progress-bar progress-bar-striped active' style='width:100%;'><b>Please wait</b></div>").fadeIn("medium");
    
    $.ajax({
	type	    : "POST",
	url	    : ""+approot+"/"+link,
	data	    : dataSend,
	cache	    : false,
	dataType    : "json",
	success	    : function(data){
	    
	    if(viewContentId != null){
		$("#"+viewContentId).html(data.HTML_DATA).fadeIn("medium");
	    }
	    
	    
	    if(onSuccess != null){
		onSuccess(data);
	    }
	},
	error	    : function(jqXHR, exception) {
            if (jqXHR.status === 0) {
                alert('Not connect.n Verify Network.');
            } else if (jqXHR.status == 404) {
                alert('Requested page not found. [404]');
            } else if (jqXHR.status == 500) {
                alert('Internal Server Error [500].');
            } else if (exception === 'parsererror') {
                alert('Requested JSON parse failed.');
            } else if (exception === 'timeout') {
                alert('Time out error.');
            } else if (exception === 'abort') {
                alert('Ajax request aborted.');
            } else {
                alert('Uncaught Error.n' + jqXHR.responseText);
            }
        }
    }).done(function(data){
	if(onDone != null){
	    onDone(data);
	}
    });
}

//FORMAT NUMBER
function formatNumber(number){
    return number.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, "$1,");
}

//CALCULATE NUMBER
function calculate(){
    //SET ALL INPUT TARGET
    $("#allkenaikan").keyup(function(){
	$(".percent").val($(this).val());
	$("tbody tr").each(function() {

	    var amountSumber = $(this).find(".amountSumber").val();
	    var percent = $(this).find(".percent").val()/100;
	    var target = Number(amountSumber)+(Number(amountSumber)*percent);
	    $(this).find(".amountTarget").val(formatNumber(target));
	});
    });
    $(".percent").on("keyup",function(){
	$("tbody tr").each(function() {

	    var amountSumber = $(this).find(".amountSumber").val();
	    var percent = $(this).find(".percent").val()/100;
	    var target = Number(amountSumber)+(Number(amountSumber)*percent);
	    $(this).find(".amountTarget").val(formatNumber(target));
	});
    });
}

//GET PERCENT OF KENAIKAN
function getPercent(){
    $(".amountTarget").on("keyup",function(){
	$("tbody tr").each(function(){
	    var amountSumber = $(this).find(".amountSumber").val();
	    var amountTargetString = $(this).find(".amountTarget").val();
	    var amountTarget = amountTargetString.replace(/,/g,"");
	    if(Number(amountSumber) > 0){
		var percent = ((Number(amountTarget)-Number(amountSumber))/Number(amountSumber))*100;
	    }else{
		var percent = 0;
	    }
	    
	    $(this).find(".percent").val(percent);
	})
    })
}

//RENDER THE CHART
function renderChart(chartId, data){
    
    var chartOptions = data.CHART_DATA;
    
    var chart = new Highcharts.Chart(chartOptions);
    
}

//DATEPICKER
function datePicker(contentId, formatDate){
    $(contentId).datepicker({
	format : formatDate
    });
    $(contentId).on('changeDate', function(ev){
	$(this).datepicker('hide');
    });
}

function modalSetting(element, backdropType, closeOnKeyboard, show){
    
    if(backdropType == null){
	backdropType = "static";
    }else{
	backdropType = backdropType;
    }
    
    if(closeOnKeyboard == null){
	backdropType = true;
    }else{
	backdropType = backdropType;
    }
    
    if(show == null){
	show = false;
    }else{
	show = show;
    }
    
    $(element).modal({
	"backdrop":backdropType,
	"keyboard":closeOnKeyboard,
	"show":show
    });
}

function validate(element, checkfor, classError, matchValue, minLength){
    var elementValue = $(element).val();
    var errormessage = function(element, msg){
	var checkelement = $(element).parent().find(".errormessage").length;
	if(checkelement == 0){
	    $(element).parent().append("<label class='errormessage'><i class='fa fontello-info'></i> "+msg+"</label>");
	}else{
	    $(element).parent().find(".errormessage").html("<i class='fa fontello-info'></i> "+msg).show();
	}
    };
    switch (checkfor){
	case "text" :
	    if(minLength != null && elementValue.length < minLength){
		$(element).focus();
		$(element).parent().addClass(classError);
		errormessage(element, "Data Diperlukan.");
		
	    }else if(matchValue != null && elementValue != matchValue){
		$(element).focus();
		$(element).parent().addClass(classError);
		errormessage(element, "Data Tidak Sesuai.");
	    }else{
		$(element).parent().removeClass(classError).find(".errormessage").hide();
	    }
	break;
	
	case "email" :
	    if(minLength != null && elementValue.length < minLength){
		$(element).focus();
		$(element).parent().addClass(classError);
		errormessage(element, "Data Diperlukan.");
	    }else if(elementValue.length > 0){
		if(elementValue.indexOf("@") == -1 || elementValue.indexOf(".") == -1){
		    $(element).focus();
		    $(element).parent().addClass(classError);
		    errormessage(element, "Format Email Salah.");
		}else if(matchValue != null && elementValue == matchValue){
		    $(element).focus();
		    $(element).parent().addClass(classError);
		    errormessage(element, "Email Tidak Sesuai.");
		}
	    }else{
		$(element).parent().removeClass(classError).find(".errormessage").hide();
	    }
	break;
	default : 
	    $(element).parent().removeClass(classError);
	    $(element).parent().removeClass(classError).find(".errormessage").hide();
    }
}

function notifications(data){
    $("#notifications").notify({
	message: { html : data.HTML_DATA },
	type    : data.MSG_TYPE,
	transition : 'fade'
    }).show();
}

function getTime(elementId) {
    var now = new Date(),
	now = checkTime(now.getHours())+':'+checkTime(now.getMinutes())+':'+checkTime(now.getSeconds());
    $(elementId).html("<h4 class='box-title'>"+now+"</div>");
	
    setTimeout(function(){
	getTime(elementId);
    },500);
   
}

function checkTime(i) {
    return (i < 10) ? "0" + i : i;
}
