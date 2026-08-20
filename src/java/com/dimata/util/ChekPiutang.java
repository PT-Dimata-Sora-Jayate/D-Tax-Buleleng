/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */ 
package com.dimata.util;

import com.dimata.dtaxintegration.entity.inquery.Pbb;
import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbb;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class ChekPiutang {
    /**
     * digunakan pada upload manual
     * digunakan untuk chek pajak 2015 kebelakang, jika pajak masa 2016-2022 sudah terbayar
     * maka pajak massa 2015 kebelakang tidak muncul
     * @param Tahun
     * @return  
     */
    
    
    public boolean chekPenghilangan(String NOP, int tahun){
        boolean status = true;
        Diskon diskon =  new Diskon();
        
        if(tahun<=2018){
            //mencari pajak 2016-2022 apakah sudah bayar
            String wrClause = "NOP = '"+NOP+"' AND THN_PAJAK_SPPT BETWEEN '2020' and '2024' ";
            Vector dataPajak = getListPBBV2(wrClause);
//            Vector dataPajak = listIpprotax(0, 0, wrClause, "");
            if(dataPajak.size()>0){
                for (int i = 0; i < dataPajak.size(); i++) {
                    Pbb pbb = (Pbb) dataPajak.get(i);

                    //chek pembayaran cicilan
                    String wherePembayaran = "NOP="+pbb.getId()+" AND THN_PAJAK_SPPT="+pbb.getTahun();
                    Vector listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");

                    double totalPembayaran = 0;
                    double pembayaranPertama = 0;
                    double pembayaranDenda = 0;
                    java.util.Date tglDendaSeharusnya = null;
                    java.util.Date tglDendaPembayaranPertama= null;
                    if (listPembayaran.size()>0){
                        for (int a=0; i < listPembayaran.size();a++){
                            PaymentPbb paymentPbb = (PaymentPbb) listPembayaran.get(i);
                            totalPembayaran += (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt());
                            System.out.println("WHERE : "+totalPembayaran);
                            pembayaranDenda += paymentPbb.getDendaSppt();
                            if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0){
                                    tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                            }
                            if (paymentPbb.getPembayaranSpptKe() == 1){
                                    tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                                    pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                            }
                        }
                    }
                    double jumlahTagihan = Double.valueOf(pbb.getJumlahTagihan());

                    //2017-132 Hitung pensentasi denda
                    String tglJatuhTempoStr = pbb.getTglJthTempo();
                    SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
                    Date tglJatuhTempo = null;
                    try {
                        tglJatuhTempo = formatterDate.parse(tglJatuhTempoStr);  // Parse the string to a Date object
                    } catch (ParseException e) {
                        e.printStackTrace();  // Handle the exception if the string can't be parsed
                    }
                    Calendar endCalendar = Calendar.getInstance();
                    double persentaseDenda = diskon.perdentaseDenda(endCalendar, Integer.valueOf(pbb.getTahun()), tglJatuhTempo);

                    double denda = 0;

                    //2017-132
                    //hitung jumlah bayar denda
                    double countDenda = (jumlahTagihan-totalPembayaran) * persentaseDenda;
                    try {
                        NumberFormat formatter = new DecimalFormat("#0.00");
                        String condenda = formatter.format(countDenda);
                        countDenda = Double.valueOf(condenda);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    //denda = Math.ceil(countDenda);//Math.ceil((jumlahTagihan-totalPembayaran) * persentaseDenda);
                    denda = Math.round(countDenda);


                    //2017-132
                    //untuk penetapan denda yang di hilangkan berdasarkan tahun
                    //denda = diskon.diskonDenda(tahun, denda);
                    //untuk kompensasi denda
                    denda = diskon.konpensasiDenda(Integer.valueOf(pbb.getTahun()), denda, persentaseDenda, (jumlahTagihan-totalPembayaran));

                    try {
                            String sDate1="2021-01-31";  
                            Date dateDenda=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
                            if (new Date().before(dateDenda)){
                                    denda = 0;
                            }
                    } catch (Exception exc){

                    }

                    double totPambayaran = 0;
                    if ((jumlahTagihan - totalPembayaran) > 0){
                            totPambayaran = (jumlahTagihan - totalPembayaran);
                    }

                    //2017-132
                    //hitung diskon pajak
                    totPambayaran = diskon.diskonPajak(Integer.valueOf(pbb.getTahun()), totPambayaran);
                    double ygHarusDibayar=totPambayaran+denda;
                    if (ygHarusDibayar <= 0){
                            continue;
                    }

                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
        
        return status;
    }
    
    /**
     * digunakan pada cretae file
     * digunakan untuk chek pajak 2015 kebelakang, jika pajak masa 2016-2022 sudah terbayar
     * maka pajak massa 2015 kebelakang tidak muncul
     * @param Tahun
     * @return 
     */
    public static Hashtable<String, Vector> chkPenghilangPiutang(){
        boolean status = true;
        Diskon diskon =  new Diskon();
        Hashtable hashtable = new Hashtable();
        
        //mencari pajak 2016-2022 apakah sudah bayar
        String wrClause = " THN_PAJAK_SPPT BETWEEN '2016' and '2022' ";
        Vector dataPajak = listIpprotax(0, 0, wrClause, "");
        if(dataPajak.size()>0){
            for (int i = 0; i < dataPajak.size(); i++) {
                Pbb pbb = (Pbb) dataPajak.get(i);

                //chek pembayaran cicilan
                String wherePembayaran = "NOP="+pbb.getId()+" AND THN_PAJAK_SPPT="+pbb.getTahun();
                Vector listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");

                double totalPembayaran = 0;
                double pembayaranPertama = 0;
                double pembayaranDenda = 0;
                java.util.Date tglDendaSeharusnya = null;
                java.util.Date tglDendaPembayaranPertama= null;
                if (listPembayaran.size()>0){
                    for (int a=0; i < listPembayaran.size();a++){
                        PaymentPbb paymentPbb = (PaymentPbb) listPembayaran.get(i);
                        totalPembayaran += (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt());
                        System.out.println("WHERE : "+totalPembayaran);
                        pembayaranDenda += paymentPbb.getDendaSppt();
                        if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0){
                                tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                        }
                        if (paymentPbb.getPembayaranSpptKe() == 1){
                                tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                                pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                        }
                    }
                }
                double jumlahTagihan = Double.valueOf(pbb.getJumlahTagihan());

                //2017-132 Hitung pensentasi denda
                String tglJatuhTempoStr = pbb.getTglJthTempo();
                    SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
                    Date tglJatuhTempo = null;
                    try {
                        tglJatuhTempo = formatterDate.parse(tglJatuhTempoStr);  // Parse the string to a Date object
                    } catch (ParseException e) {
                        e.printStackTrace();  // Handle the exception if the string can't be parsed
                    }
                Calendar endCalendar = Calendar.getInstance();
                double persentaseDenda = diskon.perdentaseDenda(endCalendar, Integer.valueOf(pbb.getTahun()), tglJatuhTempo);

                double denda = 0;

                //2017-132
                //hitung jumlah bayar denda
                double countDenda = (jumlahTagihan-totalPembayaran) * persentaseDenda;
                try {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    String condenda = formatter.format(countDenda);
                    countDenda = Double.valueOf(condenda);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //denda = Math.ceil(countDenda);//Math.ceil((jumlahTagihan-totalPembayaran) * persentaseDenda);
                denda = Math.round(countDenda);


                //2017-132
                //untuk penetapan denda yang di hilangkan berdasarkan tahun
                //denda = diskon.diskonDenda(tahun, denda);
                //untuk kompensasi denda
                denda = diskon.konpensasiDenda(Integer.valueOf(pbb.getTahun()), denda, persentaseDenda, (jumlahTagihan-totalPembayaran));

                try {
                        String sDate1="2021-01-31";  
                        Date dateDenda=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
                        if (new Date().before(dateDenda)){
                                denda = 0;
                        }
                } catch (Exception exc){

                }

                double totPambayaran = 0;
                if ((jumlahTagihan - totalPembayaran) > 0){
                        totPambayaran = (jumlahTagihan - totalPembayaran);
                }

                //2017-132
                //hitung diskon pajak
                totPambayaran = diskon.diskonPajak(Integer.valueOf(pbb.getTahun()), totPambayaran);
                double ygHarusDibayar=totPambayaran+denda;
                if (ygHarusDibayar <= 0){
                        continue;
                }

            }
        }
        
        return hashtable;
    }
    
    public static Vector getListPBBV2(String where) {

        Diskon diskon =  new Diskon();
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB ";
            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));//14

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));//NJOPTKP_SPPT

				
                double jumlahTagihan = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
                Date tglJatuhTempo = rs.getDate("TGL_JATUH_TEMPO_SPPT");
                Calendar startCalendar = Calendar.getInstance();

                //digunakan untuk tes denda hari ini(mengubah stae hari ini)
                //SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		//String dateInString = "01-01-2023 10:20:56";
		//Date date = sdf.parse(dateInString);

                Calendar endCalendar = Calendar.getInstance();
                //endCalendar.setTime(date);

                String strJatuhTempoNew = diskon.jatuhTempo;//untuk menghitung denda
                String strJatuhTempoNew21 = diskon.jatuhTempo21;//untuk menghitung denda
                String strJatuhTempoNew22 = diskon.jatuhTempo22;//untuk menghitung denda
                String strJatuhTempoNew23 = diskon.jatuhTempo23;//untuk menghitung denda

                Date dtJatuhTempo = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew);
                Date dtJatuhTempo21 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew21);
                Date dtJatuhTempo22 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew22);
                Date dtJatuhTempo23 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew23);
                //endCalendar.setTime(new Date());
                int tahun = 0;
                try {
                    tahun = Integer.valueOf(pbb.getTahun());
                    if (tahun > 2018 && tahun < 2021){
                        startCalendar.setTime(dtJatuhTempo);
                    }else if(tahun == 2021){
                        startCalendar.setTime(dtJatuhTempo21);
                    }else if(tahun == 2022){
                        startCalendar.setTime(dtJatuhTempo22);
                    }else if(tahun == 2023){
                        startCalendar.setTime(dtJatuhTempo23);
                    }else {
                        startCalendar.setTime(tglJatuhTempo);
                    }
                } catch (Exception exc){
                        startCalendar.setTime(tglJatuhTempo);
                }

                int tunggakan = 0;
                int diffYear =0;
                int diffMonth = 0;	
                int typePembayaran = 0;

                String wherePembayaran = "NOP="+pbb.getId()+" AND THN_PAJAK_SPPT="+pbb.getTahun();
                Vector listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");

                double totalPembayaran = 0;
                double pembayaranPertama = 0;
                double pembayaranDenda = 0;
                java.util.Date tglDendaSeharusnya = null;
                java.util.Date tglDendaPembayaranPertama= null;
                if (listPembayaran.size()>0){
                        for (int i=0; i < listPembayaran.size();i++){
                                PaymentPbb paymentPbb = (PaymentPbb) listPembayaran.get(i);
                                totalPembayaran += (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt());
                                System.out.println("WHERE : "+totalPembayaran);
                                pembayaranDenda += paymentPbb.getDendaSppt();
                                if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0){
                                        tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                                }
                                if (paymentPbb.getPembayaranSpptKe() == 1){
                                        tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                                        pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                                }
                        }
                }
                // add by dhama untuk proses debug
//                if (pbb.getTahun().equals("2022")){ 
//                int diffYearw = 0 ; 
//                }
                diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
                if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH)){
                    diffMonth += 1;
                }
                if (diffMonth > 0){
                    tunggakan = diffMonth;
                }
//
                double persentaseDenda = 0;
                if (tunggakan > 0){
                    if (tunggakan > 24){
                        persentaseDenda = 24.0 * (2.0/100.0);
                    } else{
                        persentaseDenda = tunggakan * (2.0/100.0);
                    }
                }

                //2017-132 Hitung pensentasi denda
                persentaseDenda = diskon.perdentaseDenda(endCalendar, tahun, tglJatuhTempo);

                double denda = 0;

                //2017-132
                //hitung jumlah bayar denda
                double countDenda = (jumlahTagihan-totalPembayaran) * persentaseDenda;
                try {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    String condenda = formatter.format(countDenda);
                    countDenda = Double.valueOf(condenda);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //denda = Math.ceil(countDenda);//Math.ceil((jumlahTagihan-totalPembayaran) * persentaseDenda);
                denda = Math.round(countDenda);


                //2017-132
                //untuk penetapan denda yang di hilangkan berdasarkan tahun
                //denda = diskon.diskonDenda(tahun, denda);
                //untuk kompensasi denda-tidak di pakai
                //denda di kosongkan sampai 31 desember 2022
                denda = diskon.konpensasiDenda(tahun, denda, persentaseDenda, (jumlahTagihan-totalPembayaran));

                try {
                        String sDate1="2021-01-31";  
                        Date dateDenda=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
                        if (new Date().before(dateDenda)){
                                denda = 0;
                        }
                } catch (Exception exc){

                }
                //pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");
                pbb.setTerbilang("");

                //proses perhitungan jumlah tagihan dan denda
                double totPambayaran = 0; //Double.valueOf(pbb.getJumlahTagihan());//0;//SessPbbIprotax.PerhitunganPbbYangHarusDibayar(pbb.getId(), pbb.getTahun(), pbb.getJumlahTagihan());
                if ((jumlahTagihan - totalPembayaran) > 0){
                        totPambayaran = (jumlahTagihan - totalPembayaran);
                }

                /*count denda adm sppt*/
                //double denda=Math.ceil(Double.valueOf(pbb.getDenda()));//SessPbbIprotax.PerhitunganDenda(pbb.getId(),  pbb.getTahun(), pbb.getTglJatuhTempo(), pbb.getJumlahTagihan(),totPambayaran);
                /*total yang harus dibayarkan*/

                //2017-132
                //hitung diskon pajak
                totPambayaran = diskon.diskonPajak(tahun, totPambayaran);
                double ygHarusDibayar=totPambayaran+denda;
                if (ygHarusDibayar <= 0){
                        continue;
                }
                pbb.setJumlahTagihan(String.valueOf(ygHarusDibayar));
                try{
                        pbb.setPokok(String.valueOf(totPambayaran));
                }catch(Exception ex){
                }
                try{
                        pbb.setDenda(String.valueOf(denda));
                }catch(Exception ex){
                }
				
                //pbb.setDenda(rs.getString("DENDA"));
                //pbb.setPokok(rs.getString("POKOK"));
                
                pbb.setNjkpSppt(rs.getDouble("NJKP_SPPT"));
                pbb.setTarifSppt(rs.getDouble("TARIF_SPPT"));
               

                pbb.setTerbilang("");

                //chek apakah tagihan 2016-2022 yang dimiliki wp sudah terbayar 
                ChekPiutang chek = new ChekPiutang();
                if(chek.chekPenghilangan(pbb.getId(),Integer.valueOf(pbb.getTahun()))){
                    continue;
                }

                result.add(pbb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
    
    public static Vector listIpprotax(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM VIEW_PBB ";
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            if (limitStart == 0 && recordToGet == 0) {
                sql = sql + "";
            } else {
                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                Pbb pbb = new Pbb();
                
                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId 
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));
                
                pbb.setNjkpSppt(rs.getDouble("NJKP_SPPT"));
                pbb.setTarifSppt(rs.getDouble("TARIF_SPPT"));
                
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN_MURNI"));
                
                lists.add(pbb);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
    
    /**
     * Fungsi chek tagihan 2016-2022 yang belum bayar
     * di left join ke VIEW_PEMBAYARAN_PBB karena ada pajak yang tidak ke update pada kolom STATUS_PEMBAYARAN_SPPT pada tabel SPPT 
     * @param limitStart
     * @param recordToGet
     * @param whereClause
     * @param order
     * @return 
     */
    public static  Hashtable<String, Vector>  chekBelumBayar(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        Hashtable hashtable = new Hashtable();
        DBResultSet dbrs = null;
        try {
            String sql =    "select * from (\n" +
                            "select \n" +
                            "VIEW_PEMBAYARAN_PBB.NOP AS NOP_BYR,\n" +
                            "VIEW_PBB_ALL.* \n" +
                            "from VIEW_PBB_ALL  \n" +
                            "LEFT JOIN VIEW_PEMBAYARAN_PBB \n" +
                            "ON VIEW_PEMBAYARAN_PBB.NOP = VIEW_PBB_ALL.NOP \n" +
                            "AND VIEW_PEMBAYARAN_PBB.THN_PAJAK_SPPT = VIEW_PBB_ALL.THN_PAJAK_SPPT \n";
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            
                    sql +=  ") AS data ";
            
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            if (limitStart == 0 && recordToGet == 0) {
                sql = sql + "";
            } else {
                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            String currNop = "";
            while (rs.next()) {
                Pbb pbb = new Pbb();
                
                String nop = rs.getString("NOP");
                if (!currNop.equals(nop) && !currNop.equals("")){
                    hashtable.put(currNop, lists);
                    lists = new Vector();
                } 
                
                currNop = nop; 
                pbb.setNop(rs.getString("NOP_BYR"));
                pbb.setTahun(rs.getString("TAHUN"));
                lists.add(pbb);
            }
            if (lists.size()>0){
                hashtable.put(currNop, lists);
            }
            
            rs.close();
            return hashtable;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Hashtable<>();
    }
}
