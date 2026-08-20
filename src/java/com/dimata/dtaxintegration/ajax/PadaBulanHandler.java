/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.ajax;

import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormatSymbols;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author Ardiadi
 */
public class PadaBulanHandler extends HttpServlet {

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
	PrintWriter out = response.getWriter();
	
	//STRING DATA
	String viewType = FRMQueryString.requestString(request, "FRM_FIELD_VIEW_TYPE");
	String returnHtml = "";
	
	
	//INT DATA
	int tahunSelect = FRMQueryString.requestInt(request, "FRM_FIELD_TAHUN");
	int iCommand = FRMQueryString.requestCommand(request);
	
	
	//DATE DATA
	Date currentDate = new Date();
	DateFormatSymbols dfs = new DateFormatSymbols();
	String[] monthName = dfs.getMonths();
	
	
	//JSON OBJECT DATA
	JSONObject jSONObject = new JSONObject();
	

	if(iCommand == Command.NONE){
	    if(viewType.equals("getbulan")){
		int selectedVal = 0;
		if(tahunSelect == Integer.parseInt(Formater.formatDate(currentDate,"yyyy"))){
		    selectedVal = Integer.parseInt(Formater.formatDate(currentDate,"MM"))-1;
		}else if(tahunSelect < Integer.parseInt(Formater.formatDate(currentDate,"yyyy"))){
		    selectedVal = monthName.length-2;
		}else{
		    selectedVal = selectedVal;
		}
		
		for(int i =0; i < monthName.length-1; i++){
		    String monthKey = "";
		    if((i+1) > 9){
			monthKey = tahunSelect+"-"+(i+1);
		    }else{
			monthKey = tahunSelect+"-0"+(i+1);
		    }
		    if(i == selectedVal){
			returnHtml += "<option value='"+monthKey+"' selected>"+monthName[i]+" "+Formater.formatDate(Formater.formatDate(""+tahunSelect,"yy"),"yy")+"</option>";
		    }else{
			returnHtml += "<option value='"+monthKey+"'>"+monthName[i]+" "+Formater.formatDate(Formater.formatDate(""+tahunSelect,"yy"),"yy")+"</option>";
		    }
		}
	    }
	}
	
	try{
	    jSONObject.put("HTML_DATA", returnHtml);
	}catch(Exception ex){
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>
}
