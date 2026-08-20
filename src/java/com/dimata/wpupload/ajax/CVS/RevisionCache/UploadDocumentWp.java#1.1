/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.wpupload.ajax;

import com.dimata.qdep.form.FRMQueryString;
import com.dimata.webclient.AppSetting;
import com.dimata.wpupload.entity.esptpd.PstESPTPD;
import com.dimata.wpupload.form.esptpd.FrmESPTPD;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author dimata005
 */
public class UploadDocumentWp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String item1=null,item2=null,item3=null, item4=null, item5=null, npwpd=null, posisiupload="0";
        String message="";
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                
                for (FileItem item : multiparts) {
                    if(item.isFormField()){
                        if(item.getFieldName().equals("masapajaklapor")){   
                          item1=item.getString();
                        }
                        if(item.getFieldName().equals("tahunpajaklapor")){   
                             item2=item.getString();
                        }
                        if(item.getFieldName().equals("npwpdpajaklapor")){   
                             item3=item.getString();
                             npwpd=item.getString();
                             if(!item3.equals("")){
                                 item3 = item3.replace(".", "");
                             }
                        }
                        if(item.getFieldName().equals("rootpro")){   
                             item4=item.getString();
                        }
                        
                        if(item.getFieldName().equals("messageString")){   
                             item5=item.getString();
                        }
                        
                        if(item.getFieldName().equals("posisiupload")){   
                             posisiupload=item.getString();
                        }
                    }
                } 
                
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        String typeFile = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());
                        if(typeFile.equals(".jpg") || typeFile.equals(".xlsx") || typeFile.equals(".jpeg") || typeFile.equals(".xls") || typeFile.equals(".pdf")){
                            if(item5.equals("SUCCESS")){
                                item.write(new File(AppSetting.WP_UPLOAD_LOCATION_FILE + File.separator +item2+item1+"_"+item3+"_"+name));
                                String namaFile = item3+"_"+item2+item1+"_"+name;
                                long update = PstESPTPD.updateDataEsptpd(item2,item1,npwpd,namaFile);
                            }
                        }
                    }
                }
                
                message="submitrespon=ok&messageStringRespon='"+item5+"'&masapajaklapor='"+item1+"'&tahunpajaklapor='"+item2+"'";
                request.setAttribute("message", "File Uploaded Successfully");
                
            } catch (Exception ex) {
                message="submitrespon=ok&messageStringRespon='"+item5+"'&masapajaklapor='"+item1+"'&tahunpajaklapor='"+item2+"'";
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            message="submitrespon=ok&messageString='"+item5+"'";
            request.setAttribute("message","Sorry this Servlet only handles file upload request");
        }
        
        if(posisiupload.equals("1")){
            response.sendRedirect(item4+"/wpupload/wp-listlaporan.jsp?"+message); 
        }else{
            response.sendRedirect(item4+"/wpupload/wp-namabadan.jsp?"+message); 
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
