/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.bi.DataPajak;
import com.dimata.dtaxintegration.entity.bi.DataTarget;
import com.dimata.dtaxintegration.entity.bi.PajakTypeDetail;
import com.dimata.dtaxintegration.entity.bi.PstDataPajak;
import com.dimata.dtaxintegration.entity.bi.PstDataTarget;
import com.dimata.dtaxintegration.entity.bi.PstPajakType;
import com.dimata.dtaxintegration.entity.bi.PstPajakTypeDetail;
import com.dimata.dtaxintegration.form.bi.CtrlDataTarget;
import com.dimata.dtaxintegration.form.bi.FrmDataTarget;
import com.dimata.gui.jsp.ControlList;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ardiadi
 */
public class InputTargetHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	
	
	//STRING DATA
	String viewtype = FRMQueryString.requestString(request, "FRM_FIELD_VIEW_TYPE");
	String returnHtml = "";
	String returnChart = "";
	String returnTypeMessage = "";
	String frmMsg = "";
	String dataChart = FRMQueryString.requestString(request, "FRM_FIELD_CHART_DATA_FOR");
	String chartType = FRMQueryString.requestString(request, "FRM_FIELD_CHART_TYPE");
	//TYPE OF CHART AVAILABLE
	
	
	//LONG DATA
	long jenisPajak = FRMQueryString.requestLong(request, FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_PAJAK_DETAIL_ID]);
	long sumberPajak = FRMQueryString.requestLong(request, "FRM_FIELD_SUMBER_TARGET");
	
	
	//INT DATA
	int tahunPajak = FRMQueryString.requestInt(request, FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_TAHUN_TARGET]);
	int tahunSumber = FRMQueryString.requestInt(request, FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_TAHUN_SUMBER]);
	int iCommand = FRMQueryString.requestCommand(request);
	int iErrCode = 0;
	
	
	
    
	
	//COMMAND NONE
	if(iCommand == Command.NONE){
	    
	    
	/////RESULT TO SHOW DATA TARGET
	    if(viewtype.equals("viewtarget")){
		
		PajakTypeDetail pajakTypeDetail;
		
		try{
		    pajakTypeDetail = PstPajakTypeDetail.fetchExc(jenisPajak);
		}catch(Exception ex){
		    pajakTypeDetail = new PajakTypeDetail();
		}
		
		returnHtml += ""
		+ "<br><br>"
		+ "<div class='row'>"
		    + "<div class='col-md-12'>"
			+ "<b>"+pajakTypeDetail.getPajakDetailName()+"</b>"
		    + "</div>"
		+ "</div>";
		returnHtml+=drawList(iCommand, jenisPajak, tahunPajak, sumberPajak, tahunSumber);
		
		
		
	/////RESULT TO SHOW TAHUN SUMBER RANGE
	    }else if(viewtype.equals("viewtahunsumber")){
		int startYear = tahunPajak-1;
		int pastYear = tahunPajak-4;
		for(int i = startYear; i>=startYear-3; i--){
		    returnHtml+=""
		    + "<option value='"+i+"'>"+i+"</option>";
		}
	    

	    }
	    
	}else if(iCommand == Command.SAVE){
	    if(viewtype.equals("savetarget")){
		CtrlDataTarget ctrlDataTarget = new CtrlDataTarget(request);
		iErrCode = ctrlDataTarget.action(iCommand, 0, request);
		frmMsg = ctrlDataTarget.getMessage();
		returnHtml+="<b>"+frmMsg.toUpperCase()+"</b><br>";
		if(frmMsg.toLowerCase().indexOf("sukses") == -1 && frmMsg.toLowerCase().indexOf("success") == -1 && frmMsg.toLowerCase().indexOf("berhasil") == -1){
		    returnTypeMessage += "danger";
		    returnHtml += "<i class='fa fa-exclamation'></i> Gagal meyimpan data target!";
		}else{
		     //returnTypeMessage += "success";
		     returnHtml += "<i class='fa fa-check'></i> Berhasil meyimpan data target!";
		}
		
	    }
	}
	
	
	
	
	JSONObject jSONObject = new JSONObject();
	
	try{
	    
	    jSONObject.put("HTML_DATA", returnHtml);
	    jSONObject.put("MSG_TYPE", returnTypeMessage);
	}catch(JSONException ex){
	    returnHtml = "{'HTML_DATA':'"+ex.toString()+"'}";
	}
	
	response.getWriter().println(jSONObject);
	
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }
    
    
    
    
    
    //FUNCTION TO DRAW TABLE
    public String drawList(int iCommand, long oidPajakType, 
	    int oidTahunPajak, long oidSumberPajak, int oidTahunSumber) {
	
	
	ControlList ctrlist = new ControlList();

	ctrlist.setAreaWidth("100%"); //untuk mengatur width(lebar) table
	ctrlist.setAreaStyle("listgen"); //untuk mengatur nama class table
	ctrlist.setTitleStyle("tableheader"); //untuk mengatur nama class didalam kolom dalam baris table
	ctrlist.setCellStyle("cellStyle");
	ctrlist.setHeaderStyle("tableheader"); //mengatur nama class baris table
	ctrlist.addHeader("Bulan");
	ctrlist.addHeader("Sumber "+oidTahunSumber);
	ctrlist.addHeader("Kenaikan<div class='input-group'>"
			    + "<input type='text' name='allkenaikan' id='allkenaikan' class='form-control'>"
			    + "<div class='input-group-addon'>"
				+ "%"
			    + "</div>"
			+ "</div>");
	ctrlist.addHeader("Target "+oidTahunPajak);

	//membuat link dirow 0
	ctrlist.setLinkRow(0);
	ctrlist.setLinkSufix("");
	Vector lstData = ctrlist.getData();
	//membuat link menuju ke edit

	ctrlist.reset();

	int index = -1;
	
	Vector listTarget = new Vector(1,1);
	Vector listTargetSumber = new Vector(1,1);
	
	Vector rowx = new Vector(1, 1);
	DateFormatSymbols dfs = new DateFormatSymbols();
	String[] monthName = dfs.getMonths();
	
	DataTarget dataTarget;
	DataTarget dataTargetSumber;
	DataPajak dataPajak;
	
	String month = "";
	for (int i = 0; i < monthName.length-1; i++) {
	    if((i+1) > 9){
		month = ""+i;
	    }else{
		month = "0"+i;
	    }
	    listTarget = PstDataTarget.list(0, 0,
			""+PstDataTarget.fieldNames[PstDataTarget.FLD_TAHUN_TARGET]+"='"+oidTahunPajak+"' "
			+ "AND "+PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID]+"='"+oidPajakType+"' "
			+ "AND "+PstDataTarget.fieldNames[PstDataTarget.FLD_BULAN]+"='"+i+"'", "");
	    
	    double jumlahTarget = 0;
	    if(oidSumberPajak == 0){
		listTargetSumber = PstDataTarget.list(0, 0,
			""+PstDataTarget.fieldNames[PstDataTarget.FLD_TAHUN_TARGET]+"='"+oidTahunSumber+"' "
			+ "AND "+PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID]+"='"+oidPajakType+"' "
			+ "AND "+PstDataTarget.fieldNames[PstDataTarget.FLD_BULAN]+"='"+i+"'", "");
		
		if(listTargetSumber.size() != 0){
		    dataTargetSumber = (DataTarget) listTargetSumber.get(0);
		}else{
		    dataTargetSumber = new DataTarget();
		}
		jumlahTarget = dataTargetSumber.getJumlah();
	    }else{
		//GET PENCAPAIAN PER MONTH
		listTargetSumber = PstDataPajak.listPendapatanPerJenisPajak(0, 0,
			"EXTRACT(YEAR FROM dataPajak."+PstDataPajak.fieldNames[PstDataPajak.FLD_TANGGALBAYAR]+")='"+oidTahunSumber+"' "
			+ "AND EXTRACT(MONTH FROM dataPajak."+PstDataPajak.fieldNames[PstDataPajak.FLD_TANGGALBAYAR]+")='"+(i+1)+"' "
			+ "AND pajakDetail."+PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID]+"='"+oidPajakType+"'", 
			"", "pajakType."+PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_NAME]);
		
		if(listTargetSumber.size() != 0){
		    dataPajak = (DataPajak) listTargetSumber.get(0);
		}else{
		    dataPajak = new DataPajak();
		}
		
		jumlahTarget = dataPajak.getJumlahPajak();
	    }
	    
	    if(listTarget.size() != 0){
		dataTarget = (DataTarget) listTarget.get(0);
	    }else{
		dataTarget = new DataTarget();
	    }
	    
	    
	    
	    String displayKenaikan = "";
	    if(jumlahTarget == 0){
		displayKenaikan="<input type='text' name='displaykenaikan' value='"+dataTarget.getKenaikan()+"' class='form-control' disabled='true'>"
			+ "<input type='hidden' name='"+FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_KENAIKAN]+"' value='"+dataTarget.getKenaikan()+"' class='form-control percent' required='required'>";
	    }else{
		displayKenaikan = "<input type='text' name='"+FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_KENAIKAN]+"' value='"+dataTarget.getKenaikan()+"' class='form-control percent' required='required'>";
	    }
	    
	    rowx = new Vector(1, 1);
	    rowx.add(""+monthName[i]+""
		    + "<input type='hidden' name='"+FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_BULAN]+"' value='"+i+"'>");
	    rowx.add("<input type='hidden' name='JUMLAH_SUMBER' class='amountSumber' value='"+Formater.formatNumber(jumlahTarget,"###############")+"'>"
		    + ""+Formater.formatNumber(jumlahTarget, "#,###"));
	    rowx.add("<div class='input-group'>"
			+ displayKenaikan 
			+ "<div class='input-group-addon'>"
			    + "%"
			+ "</div>"
		    + "</div>");
	    rowx.add("<input type='text' name='"+FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_JUMLAH]+"' value='"+Formater.formatNumber(dataTarget.getJumlah(), "#,###")+"' class='form-control amountTarget' required='required'>");
	    lstData.add(rowx);
	}
	return ctrlist.drawBootstrapStrip();
    }

}
