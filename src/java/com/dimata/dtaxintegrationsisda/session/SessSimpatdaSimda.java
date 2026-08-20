/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegrationsisda.session;

import com.dimata.dtaxintegrationsisda.db.DBHandler;
import com.dimata.dtaxintegrationsisda.db.DBResultSet;
import com.dimata.dtaxintegrationsisda.entity.piutang.PstTaKartuPajakHotel;
import com.dimata.dtaxintegrationsisda.entity.piutang.PstTaKartuPajakPungut;
import com.dimata.dtaxintegrationsisda.entity.piutang.RefSettingan;
import com.dimata.dtaxintegrationsisda.entity.piutang.TaKartuPajakHotel;
import com.dimata.dtaxintegrationsisda.entity.piutang.TaKartuPajakPungut;
import com.dimata.dtaxintegrationsisda.entity.piutang.ViewSptpdSimda;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class SessSimpatdaSimda {
    
    
    public void prosesInsertSimda(String var) {
       
            String[] splits = var.split(",");
            int count=0;
            
            String NoSptpd = ""; //1
            String NoSspd= "";//2
            String Npwdp= "";//3
            String MasaPajak= "";//4
            String TahunPajak= "";//5
            String KodePajak= "";//6
            String NoRekening= "";//7
            String NoSubrekening= "";//8
            String Tarif= "";//9
            
            String Omzet= "";//10
            String Pajak= "";//11
            String ServiceTax= "";//12
            String Denda= "";//13
            String Pengurangan= "";//14
            String HarusDibayar= "";//15
            String Date = "";
            String typePajak="";
            
            ViewSptpdSimda viewSptpdSimda = new ViewSptpdSimda();
            for(String asset: splits){
                if(asset!=""){
                       String[] splitsDua = asset.split(";");
                       for(String value: splitsDua){
                           count=count+1;
                           if(count==1){
                               NoSptpd=value;
                               viewSptpdSimda.setNoSptpd(NoSptpd);
                           }
                           if(count==2){
                               NoSspd=value;
                               viewSptpdSimda.setNoSspd(NoSspd);
                           }
                           if(count==3){
                               Npwdp=value;
                               viewSptpdSimda.setNpwdp(Npwdp);
                           }
                           
                           if(count==4){
                               MasaPajak=value;
                               viewSptpdSimda.setMasaPajak(MasaPajak);
                           }
                           
                           if(count==5){
                               TahunPajak=value;
                               viewSptpdSimda.setTahunPajak(TahunPajak);
                           }
                           
                           if(count==6){
                               KodePajak=value;
                               viewSptpdSimda.setKodePajak(KodePajak);
                           }
                           
                           if(count==7){
                               NoRekening=value;
                               viewSptpdSimda.setNoRekening(NoRekening);
                           }
                           
                           if(count==8){
                               NoSubrekening=value;
                               viewSptpdSimda.setNoSubrekening(NoSubrekening);
                           }
                           
                           if(count==9){
                               Tarif=value;
                               try{
                                   viewSptpdSimda.setTarif(Double.parseDouble(Tarif));
                               }catch(Exception ex){
                                   viewSptpdSimda.setTarif(0);
                               }
                               
                           }
                           
                           if(count==10){
                               Omzet=value;
                               try{
                                   viewSptpdSimda.setOmzet(Double.parseDouble(Omzet));
                               }catch(Exception ex){
                                   viewSptpdSimda.setOmzet(0);
                               }
                           }
                           
                           if(count==11){
                               Pajak=value;
                               try{
                                   viewSptpdSimda.setPajak(Double.parseDouble(Pajak));
                               }catch(Exception ex){
                                   viewSptpdSimda.setPajak(0);
                               }
                           }
                           
                           if(count==12){
                               ServiceTax=value;
                               try{
                                   viewSptpdSimda.setServiceTax(Double.parseDouble(ServiceTax));
                               }catch(Exception ex){
                                   viewSptpdSimda.setServiceTax(0);
                               }
                           }
                           
                           if(count==13){
                               Denda=value;
                               try{
                                   viewSptpdSimda.setDenda(Double.parseDouble(Denda));
                               }catch(Exception ex){
                                   viewSptpdSimda.setDenda(0);
                               }
                           }
                           
                           if(count==14){
                               Pengurangan=value;
                               try{
                                   viewSptpdSimda.setPengurangan(Double.parseDouble(Pengurangan));
                               }catch(Exception ex){
                                   viewSptpdSimda.setPengurangan(0);
                               }
                           }
                           
                           if(count==15){
                               HarusDibayar=value;
                               try{
                                   viewSptpdSimda.setHarusDibayar(Double.parseDouble(HarusDibayar));
                               }catch(Exception ex){
                                   viewSptpdSimda.setHarusDibayar(0);
                               }
                           }
                           
                           
                           if(count==16){
                               typePajak=value;
                               try{
                                   viewSptpdSimda.setTypePajak(typePajak);
                               }catch(Exception ex){
                                   viewSptpdSimda.setHarusDibayar(0);
                               }
                           }
                           
                           if(count==17){
                               
                                Date=value;
                                String DATE_FORMAT_NOW = "yyyy-MM-dd";
                                Date date2 = new Date();
                                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
                                   try {
                                       date2 = sdf.parse(Date);
                                       viewSptpdSimda.setTglRekam(date2);
                                   }catch(Exception e){
                                       //handle exception
                                       date2 = new Date();
                                       viewSptpdSimda.setTglRekam(date2);
                                   }
                                   
                               //proses insert hotel
                               switch (viewSptpdSimda.getTypePajak()) {
                                   case "1":
                                       sentPhrHotel(viewSptpdSimda);
                                       //proses insert restaurant    
                                       break;
                                   case "2":
                                       break;
                                   case "3":
                                       break;
                               }
                                   
                               viewSptpdSimda = new ViewSptpdSimda();
                               count=0;
                           }
                       } 
                }
            }
    }
    
    /**
     * proses data dari SIMPATDA ke SIMDA
     * @param viewSptpdSimda 
     */
    public void sentPhrHotel(ViewSptpdSimda viewSptpdSimda) {
        
                 try{
                        TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
                        TaKartuPajakHotel entTaKartuPajakHotel = new TaKartuPajakHotel();
                        
                        entTaKartuPajakPungut.setTahun(Integer.valueOf(viewSptpdSimda.getTahunPajak()));
                        entTaKartuPajakPungut.setNoSpt(viewSptpdSimda.getNoSptpd()+"/01/I/SPTPD/"+viewSptpdSimda.getTahunPajak());
                        entTaKartuPajakPungut.setTglSpt(viewSptpdSimda.getTglRekam());
                        String NPWP_Gab = getNoWpSimda(viewSptpdSimda.getNpwdp());
                        entTaKartuPajakPungut.setNoPokokWp(NPWP_Gab);
                        
                        entTaKartuPajakPungut.setJnWajibPajak(1);
                        entTaKartuPajakPungut.setJnUsahaWp(1);
                        entTaKartuPajakPungut.setKdUsaha(1);
                        entTaKartuPajakPungut.setJnPajak(1);
                        entTaKartuPajakPungut.setJnPemungutan(1);
                        entTaKartuPajakPungut.setJnPenetapan(1);
                        
                        //cek dari masa pajak di set tanggal 1 dan tanggal akhir.
                        //int lastDay = 0;Integer.parseInt(masaPajak)
                        int masapajak = Integer.parseInt(viewSptpdSimda.getMasaPajak());
                        //int tahunPajak = Integer.valueOf(viewSptpdSimda.getTahunPajak());
                        Date Date  = getDate(masapajak,Integer.valueOf(viewSptpdSimda.getTahunPajak()));
                        int lastDay = getLastDay(masapajak,Integer.valueOf(viewSptpdSimda.getTahunPajak()));
                        Date startDate = (Date)Date.clone();
                        startDate.setDate(1);
                        Date endDate = (Date) Date.clone();
                        endDate.setDate(lastDay);
                        
                        entTaKartuPajakPungut.setMasa1(startDate);
                        entTaKartuPajakPungut.setMasa2(endDate);

                        entTaKartuPajakPungut.setKdUrusan(1);
                        entTaKartuPajakPungut.setKdBidang(20);
                        entTaKartuPajakPungut.setKdUnit(5);
                        entTaKartuPajakPungut.setKdSub(1);
                        entTaKartuPajakPungut.setNmPenerima("Drs. I Ketut Astawa Suyasa");
                        entTaKartuPajakPungut.setNipPenerima("19581222 199102 1 001");
                        entTaKartuPajakPungut.setJbtPenerima("Kepala Dinas Pendapatan Kabupaten Buleleng");
                        entTaKartuPajakPungut.setTglTerima(viewSptpdSimda.getTglRekam()); //date
                        entTaKartuPajakPungut.setKeterangan("");
                        entTaKartuPajakPungut.setKdNilai(0);
                        
                        //insert pajak pungut
                        PstTaKartuPajakPungut.insertExc(entTaKartuPajakPungut);
                        
                        entTaKartuPajakHotel.setTahun(Integer.valueOf(viewSptpdSimda.getTahunPajak()));
                        entTaKartuPajakHotel.setNoSpt(viewSptpdSimda.getNoSptpd()+"/01/I/SPTPD/"+viewSptpdSimda.getTahunPajak());
                        entTaKartuPajakHotel.setKdRek1(4);
                        entTaKartuPajakHotel.setKdRek2(1);
                        entTaKartuPajakHotel.setKdRek3(1);
                        entTaKartuPajakHotel.setKdRek4(1);
                        entTaKartuPajakHotel.setKdRek5(1);
                        entTaKartuPajakHotel.setKdRek6(1);
                        entTaKartuPajakHotel.setDasarPengenaan(viewSptpdSimda.getOmzet());
                        entTaKartuPajakHotel.setPajakTerhutang(viewSptpdSimda.getHarusDibayar());
                        entTaKartuPajakHotel.setTarifPajak(viewSptpdSimda.getTarif());
                        entTaKartuPajakHotel.setKas(0);
                        entTaKartuPajakHotel.setPembukuan(0);

                        //insert Pajak Hotel
                        PstTaKartuPajakHotel.insertExc(entTaKartuPajakHotel);
                      
                 }  catch (Exception e) {
                    System.out.println("Err Sent CDR :" + e);
                 }
    }
    
     public int getLastDay(int month, int year) {
        int lastDay = 0;

        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, 1);
        lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        return lastDay;
    }
     
    public Date getDate (int month, int year) {
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(Calendar.MONTH, month - 1);
            calendar.set(Calendar.YEAR, year);
            Date date = calendar.getTime();
            
            return date;
    }
     
     
     public String getNoWpSimda(String npwpd) {
        String convertNPWPD = "";
        convertNPWPD=npwpd.substring(2,6);
        String whereClauseSqlServer = " No_Pokok_WP like '%000"+convertNPWPD+"%' ";
        String NPWP_Gab = "";
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT NPWP_Gab FROM Ta_Wajib_Pajak";
            if (whereClauseSqlServer != null && whereClauseSqlServer.length() > 0) {
                sql = sql + " WHERE " + whereClauseSqlServer;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
           
            while (rs.next()) {
                NPWP_Gab = rs.getString(1);
            }
            rs.close();
            return NPWP_Gab;
        } catch (Exception e) {
            return NPWP_Gab;
        } finally {
            DBResultSet.close(dbrs);
        }
    }
     
    public String getCompNoWpSimda(String npwpd) {
        String convertNPWPD = "";
        convertNPWPD=npwpd.substring(2,6);
        String whereClauseSqlServer = " No_Pokok_WP like '%000"+convertNPWPD+"%' ";
        String NPWP_Gab = "";
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT Nama_WP FROM Ta_Wajib_Pajak";
            if (whereClauseSqlServer != null && whereClauseSqlServer.length() > 0) {
                sql = sql + " WHERE " + whereClauseSqlServer;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
           
            while (rs.next()) {
                NPWP_Gab = rs.getString(1);
            }
            rs.close();
            return NPWP_Gab;
        } catch (Exception e) {
            return NPWP_Gab;
        } finally {
            DBResultSet.close(dbrs);
        }
    }  
     
    public Vector getTahunPerhitungan() {
        Vector tahunPerhitungan = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT Tahun FROM Ref_Setting order by Tahun DESC";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
           
            while (rs.next()) {
                RefSettingan refSettingan = new RefSettingan();
                refSettingan.setTahun(rs.getInt("Tahun"));
                tahunPerhitungan.add(refSettingan);
            }
            rs.close();
            return tahunPerhitungan;
        } catch (Exception e) {
            return tahunPerhitungan;
        } finally {
            DBResultSet.close(dbrs);
        }
    }  
     
     
}
