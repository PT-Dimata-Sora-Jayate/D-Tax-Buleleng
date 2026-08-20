/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    var approot = $("#approot").val();

    $(".export").click(function(){
	var exportTo = $(this).data("exportTo");
        var getSelector = $(this).data("selector");
        var fileName = $(this).data("fileName");
	var getHtml = $(getSelector).html();
	$("#exportTo").val(exportTo);
	var currentHtml = $(this).html();
	$(this).html("Please wait...").attr({"disabled" : "true"});
	$("#dataexport").val(getHtml.replace(/\<table class=\"table /g,"<table border='1' "));
        $("#filename").val(fileName)
	$("form#exportform").submit();
	$(this).removeAttr("disabled").html(currentHtml);
    });
});
