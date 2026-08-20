/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.ajax;

import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.entity.masterdata.PstPeriodeCabang;
import com.dimata.dslik.session.proses.ManagerDilimitedText;
import com.dimata.dslik.session.proses.ManagerDilimitedTextSummary;
import com.dimata.dslik.session.proses.ManagerTransferData;
import com.dimata.dslik.session.proses.ManagerTransferDataAgunan;
import com.dimata.dslik.session.proses.ManagerTransferDataBankGaransi;
import com.dimata.dslik.session.proses.ManagerTransferDataDebitur;
import com.dimata.dslik.session.proses.ManagerTransferDataKredit;
import com.dimata.dslik.session.proses.ManagerTransferDataPengurusPemilik;
import com.dimata.dslik.session.proses.MonitorReplikasiDatabase;
import com.dimata.dslik.session.proses.ReplikasiDatabase;
import com.dimata.qdep.form.FRMQueryString;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dimata005
 */
public class AjaxProsesTransfer extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet AjaxProsesTransfer</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet AjaxProsesTransfer at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }

        try (PrintWriter out = response.getWriter()) {
            //int 
            String htlm = "";
            int type = FRMQueryString.requestInt(request, "datatype");
            int dataview = FRMQueryString.requestInt(request, "dataview");
            boolean privStart = FRMQueryString.requestBoolean(request, "privstart");
            boolean privStop = FRMQueryString.requestBoolean(request, "privstop");
                    
            switch (dataview) {
                case 0:
                    
                    switch (type) {
                        case 0:
                            //all segment
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses : </b> " + ManagerTransferData.getStatusProsesStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Debitur : </b> " + ManagerTransferData.getStatusDebiturStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Kredit : </b> " + ManagerTransferData.getStatusKreditStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Bank Garansi : </b> " + ManagerTransferData.getStatusBankGaransiStatic() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div> ";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Agunan : </b> " + ManagerTransferData.getStatusAgunanStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div> ";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Pengurus / Pemilik : </b> " + ManagerTransferData.getStatusPengurusStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>     ";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div> ";
                            break;
                            
                        case 1:
                            //debitur
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses : </b> " + ManagerTransferDataDebitur.getStatusProsesStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b> " + ManagerTransferDataDebitur.getStart() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Debitur : </b> " + ManagerTransferDataDebitur.getStatusDebiturStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b> " + ManagerTransferDataDebitur.getEnd() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div> ";
                            break;
                        case 2:
                            //kredit
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b> " + ManagerTransferDataKredit.getStart() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses : </b> " + ManagerTransferDataKredit.getStatusProsesStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Kredit : </b> " + ManagerTransferDataKredit.getStatusKreditStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>End : </b> " + ManagerTransferDataKredit.getEnd() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div> ";
                            break;
                        case 3:
                            //agunan
                            htlm = "";
                            htlm = htlm + "<div class=\"box-body\">";
                            htlm = htlm + "<div class=\"row\">";
                            htlm = htlm + "<div class=\"col-md-12\">";
                            htlm = htlm + "<b>Start : </b>" + ManagerTransferDataAgunan.getStart() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class=\"row\">";
                            htlm = htlm + "<div class=\"col-md-12\">";
                            htlm = htlm + "<b>Proses : </b>" + ManagerTransferDataAgunan.getStatusProsesStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class=\"row\">";
                            htlm = htlm + "<div class=\"col-md-12\">";
                            htlm = htlm + "<b>Agunan : </b> " + ManagerTransferDataAgunan.getStatusAgunanStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div> ";
                            htlm = htlm + "<div class=\"row\">";
                            htlm = htlm + "<div class=\"col-md-12\">";
                            htlm = htlm + "<b>End : </b>" + ManagerTransferDataAgunan.getEnd() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id=\"countryElement\">";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            break;
                        case 4:
                            //bank garansi
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b> " + ManagerTransferDataBankGaransi.getStart() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses : </b> " + ManagerTransferDataBankGaransi.getStatusProsesStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Bank Garansi : </b> " + ManagerTransferDataBankGaransi.getStatusBankGaransiStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>End : </b> " + ManagerTransferDataBankGaransi.getEnd() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "</div> ";
                            break;
                        case 5:
                            //pengurus
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b>" + ManagerTransferDataPengurusPemilik.getStart() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses : </b>" + ManagerTransferDataPengurusPemilik.getStatusProsesStatic() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + " <div class='col-md-12'>";
                            htlm = htlm + " <b>Pengurus / Pemilik : </b>" + ManagerTransferDataPengurusPemilik.getStatusPengurusStatic() + "<br>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>      ";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>End : </b>" + ManagerTransferDataPengurusPemilik.getEnd() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>";
                            break;
                        case 7:
                            //dilimited text
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b>" + ManagerDilimitedText.getStart() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Individu: </b>" + ManagerDilimitedText.getStatusDebiturPerOrangan() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Badan Usaha : </b>" + ManagerDilimitedText.getStatusDebiturBadanUsaha() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Kredit : </b>" + ManagerDilimitedText.getStatusKredit() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Kredit Join: </b>" + ManagerDilimitedText.getStatusKreditJoin() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Surat Berharga: </b>" + ManagerDilimitedText.getStatusSuratBerharga() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Irrevocable : </b>" + ManagerDilimitedText.getStatusIrrevocable() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur BankGaransi : </b>" + ManagerDilimitedText.getStatusBankGaransi() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Fasilitas Lainnya: </b>" + ManagerDilimitedText.getStatusFasilitasLainnya() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur DataAgunan : </b>" + ManagerDilimitedText.getStatusDataAgunan() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Penjamin : </b>" + ManagerDilimitedText.getStatusPenjamin() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Pengurus atau Pemilik: </b>" + ManagerDilimitedText.getStatusPengurusPemilik() + "<br>";
                            htlm = htlm + "<b>Proses Delimited Text Debitur Laporan Keungan : </b>" + ManagerDilimitedText.getStatusLaporanKeuangan() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>End : </b>" + ManagerDilimitedText.getEnd() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>";
                            break;
                            
                        case 6:
                            htlm = "";
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Start : </b>" + ManagerDilimitedTextSummary.getStart() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Proses dan Delimited Summary Laporan: </b>" + ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+ "<br>";
                            htlm = htlm + "<b>Proses Data : </b>" + ManagerDilimitedTextSummary.getStatusSummaryPelaporanProsesTransferData()+ "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Delimited Text Proses </b>" + ManagerDilimitedTextSummary.getStatusDilimitedTextSummary() + "<br>";
                            htlm = htlm + "<b>End : </b>" + ManagerDilimitedTextSummary.getEnd() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div id='countryElement'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>";
                            break;
                            
                        case 8:
                            htlm = "";
                            
                            Vector vReplikasiDatabase = new Vector();
                            vReplikasiDatabase =   MonitorReplikasiDatabase.list(0, 0, "","");
                            ReplikasiDatabase replikasiDatabase= new ReplikasiDatabase();
                            if(vReplikasiDatabase!=null){
                                if(vReplikasiDatabase.size()>0){
                                    replikasiDatabase = (ReplikasiDatabase) vReplikasiDatabase.get(0);
                                }
                            }
                            
                            Vector vMaster = new Vector();
                            vMaster =   MonitorReplikasiDatabase.lisMasterStatus();
                            ReplikasiDatabase master = new ReplikasiDatabase();
                            if(vMaster!=null){
                                if(vMaster.size()>0){
                                    master = (ReplikasiDatabase) vMaster.get(0);
                                }
                            }
                            
                            htlm = htlm + "<div class='box-body'>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Time : </b>" + new Date() + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>SERVER MASTER (192.168.168.101)</b><br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>Slave Running : </b>" + MonitorReplikasiDatabase.slaveRunning()+ "<br>";
                            htlm = htlm + "<b>File : </b>" + master.getMasterFile()+ "<br>";
                            htlm = htlm + "<b>Positions : </b>" + master.getMasterPosition() + "<br>";
                            htlm = htlm + "<b>Bin Log DO DB : </b>" + master.getBinLogDoDb()+ "<br>";
                            htlm = htlm + "<b>Bin Log Ignore DB : </b>" + master.getBinLogIgnoreDb()+ "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>"
                                    ;
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
                            htlm = htlm + "<b>SERVER SLAVE (192.168.168.100)</b><br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "<div class='col-md-12'>";
//                            htlm = htlm + "<b>Slave_IO_Running : </b>" + replikasiDatabase.getSlaveIoRunning()+ "<br>";
//                            htlm = htlm + "<b>Slave_SQL_Running : </b>" + replikasiDatabase.getSlaveSQLRunning()+ "<br>";
//                            htlm = htlm + "<b>LastErrno : </b>" + replikasiDatabase.getLastErrno()+ "<br>";
//                            htlm = htlm + "<b>LastError : </b>" + replikasiDatabase.getLastError()+ "<br>";
                            htlm = htlm + "<b> Slave_IO_State: </b>" + replikasiDatabase.getSlaveIoState()+ "<br>";
                            htlm = htlm + "<b> Master_Host:</b>" + replikasiDatabase.getMasterHost()+ "<br>";
                            htlm = htlm + "<b> Master_User: </b>" + replikasiDatabase.getMasterUser()+ "<br>";
                            htlm = htlm + "<b> Master_Port: </b>" + replikasiDatabase.getMasterPort()+ "<br>";
                            htlm = htlm + "<b> Connect_Retry: </b>" + replikasiDatabase.getConnectRetry()+ "<br>";
                            htlm = htlm + "<b> Master_Log_File:  </b>" + replikasiDatabase.getMasterLogFile()+ "<br>";
                            htlm = htlm + "<b> Read_Master_Log_Pos:  </b>" + replikasiDatabase.getReadMasterLogPos()+ "<br>";
                            htlm = htlm + "<b> Relay_Log_File:  </b>" + replikasiDatabase.getRelayLogFile()+ "<br>";
                            htlm = htlm + "<b> Relay_Log_Pos:  </b>" + replikasiDatabase.getRelayLogPos()+ "<br>";
                            htlm = htlm + "<b> Relay_Master_Log_File: </b>" + replikasiDatabase.getRelayMasterLogFile()+ "<br>";
                            htlm = htlm + "<b> Slave_IO_Running: </b>" + replikasiDatabase.getSlaveIoRunning()+ "<br>";
                            htlm = htlm + "<b> Slave_SQL_Running: </b>" + replikasiDatabase.getSlaveSQLRunning()+ "<br>";
                            htlm = htlm + "<b> Replicate_Do_DB: </b>" + replikasiDatabase.getReplicateDoDB()+ "<br>";
                            htlm = htlm + "<b> Replicate_Ignore_DB: </b>" + replikasiDatabase.getReplicateIgnoreDb()+ "<br>";
                            htlm = htlm + "<b> Replicate_Do_Table: </b>" + replikasiDatabase.getReplicateDoTable()+ "<br>";
                            htlm = htlm + "<b> Replicate_Ignore_Table: </b>" + replikasiDatabase.getReplicateIgnoreTable()+ "<br>";
                            htlm = htlm + "<b> Replicate_Wild_Do_Table: </b>" + replikasiDatabase.getReplicateWildDoTable()+ "<br>";
                            htlm = htlm + "<b> Replicate_Wild_Ignore_Table: </b>" + replikasiDatabase.getReplicateWildIgnoreTable()+ "<br>";
                            htlm = htlm + "<b> Last_Errno:</b>" + replikasiDatabase.getLastErrno()+ "<br>";
                            htlm = htlm + "<b> Last_Error:</b>" + replikasiDatabase.getLastError()+ "<br>";
                            htlm = htlm + "<b> Skip_Counter: </b>" + replikasiDatabase.getSkipCounter()+ "<br>";
                            htlm = htlm + "<b> Exec_Master_Log_Pos: </b>" + replikasiDatabase.getExecMasterLogPos()+ "<br>";
                            htlm = htlm + "<b> Relay_Log_Space:</b>" + replikasiDatabase.getRelayLogSpace()+ "<br>";
                            htlm = htlm + "<b> Until_Condition: </b>" + replikasiDatabase.getUntilcondition()+ "<br>";
                            htlm = htlm + "<b> Until_Log_File:</b>" + replikasiDatabase.getUntilLogFile()+ "<br>";
                            htlm = htlm + "<b> Until_Log_Pos: </b>" + replikasiDatabase.getUntilLogPos()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_Allowed: </b>" + replikasiDatabase.getMasterSSLAllowed()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_CA_File:</b>" + replikasiDatabase.getMasterSSLCAFile()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_CA_Path:</b>" + replikasiDatabase.getMasterSSLCAPath()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_Cert:</b>" + replikasiDatabase.getMasterSSLCert()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_Cipher:</b>" + replikasiDatabase.getMasterSSLCipher()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_Key:</b>" + replikasiDatabase.getMasterSSLKey()+ "<br>";
                            htlm = htlm + "<b> Seconds_Behind_Master: </b>" + replikasiDatabase.getSecondBehindMaster()+ "<br>";
                            htlm = htlm + "<b> Master_SSL_Verify_Server_Cert: </b>" + replikasiDatabase.getMasterSSLVerifyServerCert()+ "<br>";
                            htlm = htlm + "<b> Last_IO_Errno:</b>" + replikasiDatabase.getLastIOErrno()+ "<br>";
                            htlm = htlm + "<b> Last_IO_Error:</b>" + replikasiDatabase.getLastError()+ "<br>";
                            htlm = htlm + "<b> Last_SQL_Errno: </b>" + replikasiDatabase.getLastSQLErrno()+ "<br>";
                            htlm = htlm + "<b> Last_SQL_Error:</b>" + replikasiDatabase.getLastError()+ "<br>";
                            htlm = htlm + "<b> Replicate_Ignore_Server_Ids:</b>" + replikasiDatabase.getReplicateIgnoreServerIds()+ "<br>";
                            htlm = htlm + " </div>";
                            htlm = htlm + "</div>";
                            htlm = htlm + "<div class='row'>";
                            htlm = htlm + "</div>";
                            htlm = htlm + " </div>";
                            
                        default:
                            break;
                    }
                    
                    break;

                case 1:
                    //proses untuk button 
                    switch (type) {
                        case 0:
                            //all segment
                            htlm = "";
                            break;
                            
                        case 1:
                            //debitur
                            htlm = "";
                            break;
                        case 2:
                            //kredit
                            htlm = "";
                            break;
                        case 3:
                            //agunan
                            htlm = "";
                            break;
                        case 4:
                            //bank garansi
                            htlm = "";
                            break;
                        case 5:
                            //pengurus
                            htlm = "";
                            break;
                        case 6:
                            //dilimited text
                            String stopSts = "";
                            String startSts = "";
                            String startStsReload = "";
                            if (ManagerDilimitedTextSummary.getStatus()) {
                                startSts = "disabled=\"true\"";
                                stopSts = "";
                            } else {
                                startSts = "";
                                startStsReload="";
                                stopSts = "disabled=\"true\"";
                            }
                            if (ManagerDilimitedTextSummary.getStatusReload()) {
                                startSts ="disabled=\"true\"";
                                startStsReload="";
                                stopSts = "disabled=\"true\"";
                            }else{
                                startSts = "";
                                startStsReload="";
                                stopSts = "disabled=\"true\"";
                            }
                            //cek apakah semua data cabang sudah di approve, semua data atau tidak
                            htlm = "";
                            htlm = htlm + "<div class='box-footer'>";
                                if(privStart){
                                    htlm = htlm + "<button style=\"margin-left:20px\" class=\"btn btn-primary btnaddgeneral\" onClick=\"javascript:cmdStart()\" data-oid=\"0\" data-for=\"showform\" "+startSts+">";
                                        htlm = htlm + "<i class=\"fa fa-star\"></i> Start";
                                    htlm = htlm + "</button>";
                                }
                                
                                if(privStop){
                                    htlm = htlm + "<button style=\"margin-left:20px\" class='btn btn-danger btndeleteareatype' onClick=\"javascript:cmdStop()\" data-for='country'  "+stopSts+" >";
                                        htlm = htlm + "<i class='fa fa-stop'></i> Stop";
                                    htlm = htlm + "</button>";
                                }
                                
                                if(true){
                                        htlm = htlm + "<button style=\"margin-left:20px\" class='btn btn-info btndeleteareatype' onClick=\"javascript:cmdLoad()\" data-for='country'  "+startStsReload+" >";
                                            htlm = htlm + "<i class='fa fa-recycle'></i> Reload Delimited Text Only";
                                        htlm = htlm + "</button>";
                                }
                            htlm = htlm + "</div>";
                            
                            break;
                            
                        case 7:
                            //dilimited text
                            stopSts = "";
                            startSts = "";
                            if (ManagerDilimitedText.getStatus()) {
                                startSts = "disabled=\"true\"";
                                stopSts = "";
                            } else {
                                startSts = "";
                                stopSts = "disabled=\"true\"";
                            }
                            //tambahkan fungsi pengecekan periode yang aktive, update dengan periode tsb
                            Periode periode = new Periode();
                            long periodeId=0;
                            try{
                                Vector listPeriode = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'", "");
                                if(listPeriode != null){
                                    periode = (Periode) listPeriode.get(0);
                                    periodeId = periode.getOID();
                                }
                            }catch(Exception ex){
                            }
                            int xxx = PstPeriodeCabang.getCount(PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_STATUS]+"=0 AND "+PstPeriodeCabang.fieldNames[PstPeriodeCabang.FLD_PERIODE_ID]+"='"+periodeId+"'");
                            if(xxx==0){
                                htlm = "";
                                htlm = htlm + "<div class='box-footer'>";
                                
                                    if(privStart){
                                        htlm = htlm + "<button class=\"btn btn-primary btnaddgeneral\" onClick=\"javascript:cmdStart()\" data-oid=\"0\" data-for=\"showform\" "+startSts+">";
                                            htlm = htlm + "<i class=\"fa fa-star\"></i> Start";
                                        htlm = htlm + "</button>";
                                    }
                                    
                                    if(privStop){
                                        htlm = htlm + "<button class='btn btn-danger btndeleteareatype' onClick=\"javascript:cmdStop()\" data-for='country'  "+stopSts+" >";
                                            htlm = htlm + "<i class='fa fa-stop'></i> Stop";
                                        htlm = htlm + "</button>";
                                    }
                                    
                                    
                                htlm = htlm + "</div>";
                            }else{
                                
                                htlm = htlm + "<div class='box-body'>";
                                htlm = htlm + "<div class='row'>";
                                htlm = htlm + "<div class='col-md-12'>";
                                htlm = htlm + "<b>Proses Delimited Text Belum Bisa di Lakukan, Data Belum Semua di Approve di Cabang</b>";
                                htlm = htlm + " </div>";
                                htlm = htlm + "</div>";
                                htlm = htlm + " </div>";
                            }    
                                
                                
                            break;
                        default:
                            break;
                    }
                    break;
                    
                default:
                    break;
            }

            out.println("" + htlm);
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
