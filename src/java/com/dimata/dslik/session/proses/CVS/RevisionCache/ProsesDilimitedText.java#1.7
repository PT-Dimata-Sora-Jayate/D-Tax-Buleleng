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
                                //SELECT KODE_KOLEKTIBILITAS, JML_HARI_TUNGGAKAN FROM dslik_kredit;
                                //ManagerDilimitedTextSummary.setStatusSummaryPelaporan("Set Up Periode Pertama "+periode.getNama());
                                ManagerDilimitedTextSummary.setStatusSummaryPelaporan(ManagerDilimitedTextSummary.getStatusSummaryPelaporan()+"<br> Set Up Periode Pertama "+periode.getNama());
                                long movePengurusPemilikId = MoveDataCrosPeriode.moveDataSummaryFasilitasKredit(periode.getOID());
                                long moveKredit = MoveDataCrosPeriode.moveDataSummaryBankGaransi(periode.getOID());
                                /*
                                SELECT DISTINCT 
                                'D' AS FLAG_DETAIL, 
                                dslik_kredit.NO_REKENING, 
                                dslik_kredit.CIF, 
                                'F01' AS JENIS_SEGMENT, 
                                dslik_kredit.KODE_KOLEKTIBILITAS AS KODE_KOLEKTIBILITAS_1, 
                                dslik_kredit.JML_HARI_TUNGGAKAN AS JML_HARI_TUNGGAKAN_1,
                                0 AS KODE_KOLEKTIBLITAS_2,
                                0 AS JML_HARI_TUNGGAKAN_2,
                                0 AS KODE_KOLEKTIBILITAS_3,
                                0 AS JML_HARI_TUNGGAKAN_3,
                                0 AS KODE_KOLEKTIBILITAS_4,
                                0 AS JML_HARI_TUNGGAKAN_4,
                                0 AS KODE_KOLEKTIBILITAS_5,
                                0 AS JML_HARI_TUNGGAKAN_5,
                                0 AS KODE_KOLEKTIBILITAS_6,
                                0 AS JML_HARI_TUNGGAKAN_6,
                                0 AS KODE_KOLEKTIBILITAS_7,
                                0 AS JML_HARI_TUNGGAKAN_7,
                                0 AS KODE_KOLEKTIBILITAS_8,
                                0 AS JML_HARI_TUNGGAKAN_8,
                                0 AS KODE_KOLEKTIBILITAS_9,
                                0 AS JML_HARI_TUNGGAKAN_9,
                                0 AS KODE_KOLEKTIBILITAS_10,
                                0 AS JML_HARI_TUNGGAKAN_10,
                                0 AS KODE_KOLEKTIBILITAS_11,
                                0 AS JML_HARI_TUNGGAKAN_11,
                                0 AS KODE_KOLEKTIBILITAS_12,
                                0 AS JML_HARI_TUNGGAKAN_12
                                FROM dslik_kredit INNER JOIN 
                                dslik_debitur ON dslik_kredit.CIF=dslik_debitur.CIF
                                WHERE dslik_kredit.PERIODE_ID='504404638737922849';


                                SELECT DISTINCT 
                                'D' AS FLAG_DETAIL, 
                                dslik_bank_garansi.NO_REKENING, 
                                dslik_bank_garansi.CIF, 
                                'F05' AS JENIS_SEGMENT, 
                                dslik_bank_garansi.KODE_KOLEKTIBILITAS AS KODE_KOLEKTIBILITAS_1, 
                                0 AS JML_HARI_TUNGGAKAN_1,
                                0 AS KODE_KOLEKTIBLITAS_2,
                                0 AS JML_HARI_TUNGGAKAN_2,
                                0 AS KODE_KOLEKTIBILITAS_3,
                                0 AS JML_HARI_TUNGGAKAN_3,
                                0 AS KODE_KOLEKTIBILITAS_4,
                                0 AS JML_HARI_TUNGGAKAN_4,
                                0 AS KODE_KOLEKTIBILITAS_5,
                                0 AS JML_HARI_TUNGGAKAN_5,
                                0 AS KODE_KOLEKTIBILITAS_6,
                                0 AS JML_HARI_TUNGGAKAN_6,
                                0 AS KODE_KOLEKTIBILITAS_7,
                                0 AS JML_HARI_TUNGGAKAN_7,
                                0 AS KODE_KOLEKTIBILITAS_8,
                                0 AS JML_HARI_TUNGGAKAN_8,
                                0 AS KODE_KOLEKTIBILITAS_9,
                                0 AS JML_HARI_TUNGGAKAN_9,
                                0 AS KODE_KOLEKTIBILITAS_10,
                                0 AS JML_HARI_TUNGGAKAN_10,
                                0 AS KODE_KOLEKTIBILITAS_11,
                                0 AS JML_HARI_TUNGGAKAN_11,
                                0 AS KODE_KOLEKTIBILITAS_12,
                                0 AS JML_HARI_TUNGGAKAN_12
                                FROM dslik_bank_garansi INNER JOIN 
                                dslik_debitur ON dslik_bank_garansi.CIF=dslik_debitur.CIF
                                WHERE dslik_bank_garansi.PERIODE_ID='504404638737922849';
                                */
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
            
            //ManagerDilimitedTextSummary.running=false;
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp_status;
    }
    
    
    
}
