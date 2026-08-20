/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

import com.dimata.dslik.entity.masterdata.OutletConnection;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.util.Formater;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class ProsesDilimitedText {
    public String actionDilimitedTextDebitur() {
        return "";
    }
    
    public String actionDilimitedText(FileSent fileSent, OutletConnection outletConnection) {
        String resp_status = new String();
        String resp_code = new String();
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            String patchFileUpload = "";
            try {
                CreateFile sent = new CreateFile();
                patchFileUpload = sent.sentDataToDilimited(fileSent,outletConnection);
                if(!ManagerDilimitedText.running){
                    resp_status="Stop";
                    return resp_status;
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp_status;
    }
    
    public String actionDilimitedTextIntial(FileSent fileSent, OutletConnection outletConnection) {
        String resp_status = new String();
        String resp_code = new String();
        try {
            // TODO code application logic here
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            String patchFileUpload = "";
            try {
                CreateFile sent = new CreateFile();
                patchFileUpload = sent.sentDataToDilimitedIntial(fileSent,outletConnection);
                if(!ManagerDilimitedText.running){
                    resp_status="Stop";
                    return resp_status;
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp_status;
    }
    
    public String actionProsesSummaryData(FileSent fileSent, OutletConnection outletConnection) {
        String resp_status = new String();
        String resp_code = new String();
        try {
            // TODO code application logic here
            //proses transfer data tiap periode 
            String date1 = Formater.formatDate(fileSent.getStartDateSummary(),"MMMM-yyyy");//"JAN-2015";
            String date2 = Formater.formatDate(fileSent.getEndDateSummary(),"MMMM-yyyy");//"APR-2015";

            DateFormat formater = new SimpleDateFormat("MMM-yyyy");
            DateFormat formaterDua = new SimpleDateFormat("yyyy-MM-dd");

            Calendar beginCalendar = Calendar.getInstance();
            Calendar finishCalendar = Calendar.getInstance();

            try {
                beginCalendar.setTime(formater.parse(date1));
                finishCalendar.setTime(formater.parse(date2));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int urut=0;
            
            //proses delete data sebelumnya
            if(fileSent.getTypeDilimitedSummary()==0){
                long deleteData = MoveDataCrosPeriode.deleteFasilitasSummary();
                deleteData = MoveDataCrosPeriode.deleteDataIntial();
                ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+" Delete data summary fasilitas ");
                while (beginCalendar.before(finishCalendar)) {
                    String date = formaterDua.format(beginCalendar.getTime()).toUpperCase();
                    urut=urut+1;
                    //cek periode ID
                    Periode periode = new Periode();
                    try{
                        Vector listPeriode = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_TGL_AWAL]+" BETWEEN '"+date+"' AND '"+date+"'", "");
                        if(listPeriode != null){
                            periode = (Periode) listPeriode.get(0);
                            if(urut==1){
                                
                                ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+"<br> Set Up Periode Pertama "+periode.getNama());
                                long movePengurusPemilikId = MoveDataCrosPeriode.moveDataSummaryFasilitasKredit(periode.getOID());
                                long moveKredit = MoveDataCrosPeriode.moveDataSummaryBankGaransi(periode.getOID());
                                
                                //pemindahan data kredit lunas
                                long moveDataKredit = MoveDataCrosPeriode.moveDataKreditInitial(periode.getOID());
                                long moveDataBankGaransi = MoveDataCrosPeriode.moveDataBankGaransiInitial(periode.getOID());
                                
                                long moveDataDebitur = MoveDataCrosPeriode.moveDataDebiturInitial(periode.getOID());
                                long moveDataAgunan = MoveDataCrosPeriode.moveDataAgunanInitial(periode.getOID());
                                long moveDataPengurus = MoveDataCrosPeriode.moveDataPengurusPemilikInitial(periode.getOID());
                                long moveDataPenjamin = MoveDataCrosPeriode.moveDataPenjaminInitial(periode.getOID());
                                
                            }else{
                                
                                ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+"<br> Set Up Next Periode "+periode.getNama());
                                int totalMoveKredit = MoveDataCrosPeriode.countMoveDataSummaryKreditPerPeriode(periode.getOID(), urut);
                                ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+"<br> Total Data Kredit "+periode.getNama() +" : "+totalMoveKredit);
                                long moveKreditPerPeriode = MoveDataCrosPeriode.moveDataSummaryKreditPerPeriode(periode.getOID(), urut, totalMoveKredit,0);//update
                                long moveKreditPerPeriodex = MoveDataCrosPeriode.moveDataSummaryKreditPerPeriode(periode.getOID(), urut, totalMoveKredit,1);//insert

                                int totalBankGaransi  = MoveDataCrosPeriode.countMoveDataSummaryBankGaransiPerPeriode(periode.getOID(), urut);
                                ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+"<br> Total Data Bank Garansi "+periode.getNama() +" : "+totalBankGaransi);
                                long moveBankGaransiPerPeriode = MoveDataCrosPeriode.moveDataSummaryBankGaransiPerPeriode(periode.getOID(), urut, totalBankGaransi,0); //update
                                long moveBankGaransiPerPeriodex = MoveDataCrosPeriode.moveDataSummaryBankGaransiPerPeriode(periode.getOID(), urut, totalBankGaransi,1);//insert
                                
                                //pemindahan data kredit lunas
                                if(periode.getOID()!=fileSent.getPeriodeId()){
                                    long moveDataKredit = MoveDataCrosPeriode.moveDataKreditInitial(periode.getOID());
                                    long moveDataBankGaransi = MoveDataCrosPeriode.moveDataBankGaransiInitial(periode.getOID());
                                    
                                    long moveDataDebitur = MoveDataCrosPeriode.moveDataDebiturInitial(periode.getOID());
                                    long moveDataAgunan = MoveDataCrosPeriode.moveDataAgunanInitial(periode.getOID());
                                    long moveDataPengurus = MoveDataCrosPeriode.moveDataPengurusPemilikInitial(periode.getOID());
                                    long moveDataPenjamin = MoveDataCrosPeriode.moveDataPenjaminInitial(periode.getOID());
                                }else{
                                    System.out.println("hehehhe");
                                }                                
                            }
                        }
                    }catch(Exception ex){
                        ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+"<br> Set Up Next Periode "+date+" Data Kosong");    
                    }
                    beginCalendar.add(Calendar.MONTH, 1);
                }
            }
            //jika proses sudah selesai, lanjut ke proses dilimited text
            
            try {
                // TODO code application logic here
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                String patchFileUpload = "";
                try {
                    CreateFile sent = new CreateFile();
                    fileSent.setTypeSegment(Configurasi.FLD_SEGMENT_SUMMARY_FASILITAS);
                    patchFileUpload = sent.sentDataToDilimited(fileSent,outletConnection);
                    if(!ManagerDilimitedTextSummary.running){
                        resp_status="Stop";
                        return resp_status;
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
            //proses create jadi file zip
            Date newDate = new Date();
            ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan() + "<br> Proses ZIP : " + Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));
            try{
                    FileSent.zipFolder(""+fileSent.getLocation(), ""+fileSent.getLocation()+".zip");
            }catch(Exception ex){
            }
            
            newDate = new Date();
            ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusProses() + "End Proses : " + Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return resp_status;
    }
    
    
    
}
