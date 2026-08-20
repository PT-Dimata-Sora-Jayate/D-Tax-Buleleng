/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

import com.dimata.dslik.entity.contentdata.PstContentDataBentukBadanUsaha;
import com.dimata.dslik.entity.contentdata.PstContentDataKabupatenKota;
import com.dimata.dslik.entity.contentdata.*;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import java.sql.ResultSet;

/**
 *
 * @author Dewa
 */
public class SessGetContentDataOjk {
    
    //contoh
    public static String getContentDataBentukBdnUsh (String kodeBadanUsahaCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeBadanUsahaCoreBanking.replace("\\s", "");
            String sql = "SELECT * FROM " + PstContentDataBentukBadanUsaha.TBL_CONTENT_DATA_BENTUK_BADAN_USAHA + " WHERE "
                    + PstContentDataBentukBadanUsaha.fieldNames[PstContentDataBentukBadanUsaha.FLD_KODE_CORE_BANKING] + " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataBentukBadanUsaha.fieldNames[PstContentDataBentukBadanUsaha.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Kab/Kota
    public static String getContentDataKabKota (String kodeKabKotaCoreBanking) {
        DBResultSet dbrs = null; 
        String result = "";
        try {
            String xData=kodeKabKotaCoreBanking.replace("\\s", "");
            String sql = "SELECT * FROM " + PstContentDataKabupatenKota.TBL_CONTENT_DATA_KABUPATEN_KOTA + " WHERE "
                    + PstContentDataKabupatenKota.fieldNames[PstContentDataKabupatenKota.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKabupatenKota.fieldNames[PstContentDataKabupatenKota.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Negara Domisisli
    public static String getContentDataNegaraDomisili (String kodeNegaraDomCoreBanking) {
        DBResultSet dbrs = null;
        
        String result = "";
        try {
            String xData=kodeNegaraDomCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataKodeNegaraDomisili.TBL_CONTENT_DATA_KODE_NEGARA_DOMISILI + " WHERE "
                    + PstContentDataNegaraDomisili.fieldNames[PstContentDataNegaraDomisili.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataNegaraDomisili.fieldNames[PstContentDataNegaraDomisili.FLD_KODE_OJK]);
            } 
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Pekerjaan
    public static String getContentDataKodePekerjaan (String kodePekerjaanCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodePekerjaanCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataKodePekerjaan.TBL_CONTENT_DATA_KODE_PEKERJAAN + " WHERE "
                    + PstContentDataKodePekerjaan.fieldNames[PstContentDataKodePekerjaan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKodePekerjaan.fieldNames[PstContentDataKodePekerjaan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
        
    //Kode Sumber Penghasilan 
    public static String getContentDataKodeSumberPenghasilan (String kodePenghasilanCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodePenghasilanCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataSumberPenghasilan.TBL_CONTENT_DATA_SUMBER_PENGHASILAN + " WHERE "
                    + PstContentDataSumberPenghasilan.fieldNames[PstContentDataSumberPenghasilan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSumberPenghasilan.fieldNames[PstContentDataSumberPenghasilan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Golongan Debitur 
    public static String getContentDataKodeGolDeb (String kodeGolDebCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeGolDebCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataGolonganDebitur.TBL_CONTENT_DATA_GOLONGAN_DEBITUR + " WHERE "
                    + PstContentDataGolonganDebitur.fieldNames[PstContentDataGolonganDebitur.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataGolonganDebitur.fieldNames[PstContentDataGolonganDebitur.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Kantor Cabang 
    public static String getContentDataKodeKantorCabang (String kodeKantorCabCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
       
        try {
             String xData=kodeKantorCabCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataKantorCabang.TBL_CONTENT_DATA_KANTOR_CABANG + " WHERE "
                    + PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKantorCabang.fieldNames[PstContentDataKantorCabang.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Bidang Usaha 
    public static String getContentDataKodeBidangUsaha (String kodeKantorCabCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeKantorCabCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataBidangUsaha.TBL_CONTENT_DATA_BIDANG_USAHA + " WHERE "
                    + PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataBidangUsaha.fieldNames[PstContentDataBidangUsaha.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Lembaga Pemeringkat
    public static String getContentDataKodeLembagaPemeringkat (String kodeLembagaCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeLembagaCoreBanking!=null?kodeLembagaCoreBanking.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataLembagaPemeringkat.TBL_CONTENT_DATA_LEMBAGA_PEMERINGKAT + " WHERE "
                    + PstContentDataLembagaPemeringkat.fieldNames[PstContentDataLembagaPemeringkat.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataLembagaPemeringkat.fieldNames[PstContentDataLembagaPemeringkat.FLD_KODE_OJK]);
            }
            
            if(result.equals("") || result==null){
                result="99";
            }
            
            rs.close();
        } catch (Exception e) {
            ////System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Sifat Kredit
    public static String getContentDataKodeSifatKredit (String kodeSifatKreditCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeSifatKreditCoreBanking!=null?kodeSifatKreditCoreBanking.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataSifatKredit.TBL_CONTENT_DATA_SIFAT_KREDIT + " WHERE "
                    + PstContentDataSifatKredit.fieldNames[PstContentDataSifatKredit.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSifatKredit.fieldNames[PstContentDataSifatKredit.FLD_KODE_OJK]);
            }
            //default bawa ke yang lainnnya
            if(result.equals("") || result==null){
                result="9";
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jenis Kredit
    public static String getContentDataKodeJenisKredit (String kodeJenisKreditCoreBanking, String noRekening) {
        DBResultSet dbrs = null;
        String result = "";
        result=getContentDataKodeJenisKreditByRekening(noRekening);
        if(result.equals("")){
            try {
                String xData=kodeJenisKreditCoreBanking!=null?kodeJenisKreditCoreBanking.replace("\\s", ""):"";
                String sql = " SELECT * FROM " + PstContentDataJenisKredit.TBL_CONTENT_DATA_JENIS_KREDIT + " WHERE "
                        + PstContentDataJenisKredit.fieldNames[PstContentDataJenisKredit.FLD_KODE_CORE_BANKING] + 
                        " = '" + xData+"'";
                dbrs = DBHandler.execQueryResult(sql);
                ResultSet rs = dbrs.getResultSet();
                while (rs.next()) {
                    result = rs.getString(PstContentDataJenisKredit.fieldNames[PstContentDataJenisKredit.FLD_KODE_OJK]);
                }
                if(result.equals("")){
                        result="05";
                }
                rs.close();
            } catch (Exception e) {
                //System.out.println("err : " + e.toString());            
            } finally {
                DBResultSet.close(dbrs);
                return result;
            }
        }                
        return result;
    }
    
    
    public static String getContentDataKodeJenisKreditByRekening (String noRekening) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=noRekening!=null?noRekening.replace("\\s", ""):"";
            String sql = " SELECT * FROM dslik_cd_jenis_kredit_mapping_kredit WHERE KODE_CORE_BANKING" + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJenisKredit.fieldNames[PstContentDataJenisKredit.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Kategori Debitur
    public static String getContentDataKategoriDeb (String kodeKatDeb) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeKatDeb!=null?kodeKatDeb.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataKategoriDebitur.TBL_CONTENT_DATA_KATEGORI_DEBITUR + " WHERE "
                    + PstContentDataKategoriDebitur.fieldNames[PstContentDataKategoriDebitur.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKategoriDebitur.fieldNames[PstContentDataKategoriDebitur.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode skim/Akad Pembiayaan
    public static String getContentDataKodeSkimAkad (String kodeSkimAkad) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeSkimAkad!=null?kodeSkimAkad.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataSkimAkadPembiayaan.TBL_CONTENT_DATA_SKIM_AKAD_PEMBIAYAAN + " WHERE "
                    + PstContentDataSkimAkadPembiayaan.fieldNames[PstContentDataSkimAkadPembiayaan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSkimAkadPembiayaan.fieldNames[PstContentDataSkimAkadPembiayaan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jenis Penggunaan
    public static String getContentDataJenisPenggunaan (String kodeJenisPengunaan) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeJenisPengunaan!=null?kodeJenisPengunaan.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataJenisPenggunaan.TBL_CONTENT_DATA_JENIS_PENGGUNAAN + " WHERE "
                    + PstContentDataJenisPenggunaan.fieldNames[PstContentDataJenisPenggunaan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJenisPenggunaan.fieldNames[PstContentDataJenisPenggunaan.FLD_KODE_OJK]);
            }
            if(result.equals("") || result==null){
                result="99";
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Orientasi Penggunaan
    public static String getContentDataOrientasiPenggunaan (String kodeOrientasiPengunaan) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
             String xData=kodeOrientasiPengunaan!=null?kodeOrientasiPengunaan.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataOrientasiPenggunaan.TBL_CONTENT_DATA_ORIENTASI_PENGGUNAAN + " WHERE "
                    + PstContentDataOrientasiPenggunaan.fieldNames[PstContentDataOrientasiPenggunaan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataOrientasiPenggunaan.fieldNames[PstContentDataOrientasiPenggunaan.FLD_KODE_OJK]);
            }
            if(result.equals("") || result==null){
                result="9";
            }
            
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Sektor Ekonomi
    public static String getContentDataSektorEkonomi (String kodeSektorEkonomi) {
        DBResultSet dbrs = null;
        String result = "";
         
        try {
            String xData=kodeSektorEkonomi!=null?kodeSektorEkonomi.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataSektorEkonomi.TBL_CONTENT_DATA_SEKTOR_EKONOMI + " WHERE "
                    + PstContentDataSektorEkonomi.fieldNames[PstContentDataSektorEkonomi.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSektorEkonomi.fieldNames[PstContentDataSektorEkonomi.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Valuta
    public static String getContentDataKodeValuta (String kodeValuta) {
        DBResultSet dbrs = null;
        String result = "";
         
        try {
            String xData=kodeValuta!=null?kodeValuta.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataKodeValuta.TBL_CONTENT_DATA_KODE_VALUTA + " WHERE "
                    + PstContentDataKodeValuta.fieldNames[PstContentDataKodeValuta.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKodeValuta.fieldNames[PstContentDataKodeValuta.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    
    public static String getContentDataKodeValutaAngka (String kodeValuta) {
        DBResultSet dbrs = null;
        String result = "";
         
        try {
            String xData=kodeValuta!=null?kodeValuta.replace("\\s", ""):"";
            String sql = " SELECT * FROM dslik_cd_kode_valuta_angka WHERE KODE_CORE_BANKING "+ 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString("KODE_OJK");
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Takeover
    public static String getContentDataTakeover (String takeover) {
        DBResultSet dbrs = null;
        String result = "";
          
        try {
            String xData=takeover!=null?takeover.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataTakeover.TBL_CONTENT_DATA_TAKEOVER + " WHERE "
                    + PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Kolektibilitas
    public static String getContentDataKodeKolektibilitas (String kodeKolektibilitas) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeKolektibilitas!=null?kodeKolektibilitas.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataKolektibilitas.TBL_CONTENT_DATA_KOLEKTIBILITAS + " WHERE "
                    + PstContentDataKolektibilitas.fieldNames[PstContentDataKolektibilitas.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKolektibilitas.fieldNames[PstContentDataKolektibilitas.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Sebab Macet
    public static String getContentDataKodeSebabMacet (String kodeSebabMacet) {
        DBResultSet dbrs = null;
        String result = "";
       
        try {
             String xData=kodeSebabMacet!=null?kodeSebabMacet.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataSebabMacet.TBL_CONTENT_DATA_SEBAB_MACET + " WHERE "
                    + PstContentDataSebabMacet.fieldNames[PstContentDataSebabMacet.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSebabMacet.fieldNames[PstContentDataSebabMacet.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Cara Restrukturisasi
    public static String getContentDataKodeCaraRestrukturisasi (String kodeCaraRestruksisasi) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeCaraRestruksisasi!=null?kodeCaraRestruksisasi.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataCaraRestrukturisasi.TBL_CONTENT_CARA_RESTRUKTURISASI + " WHERE "
                    + PstContentDataCaraRestrukturisasi.fieldNames[PstContentDataCaraRestrukturisasi.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataCaraRestrukturisasi.fieldNames[PstContentDataCaraRestrukturisasi.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Kondisi
    public static String getContentDataKodeKondisi (String kodeCaraRestruksisasi) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeCaraRestruksisasi!=null?kodeCaraRestruksisasi.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataKondisi.TBL_CONTENT_DATA_KONDISI + " WHERE "
                    + PstContentDataKondisi.fieldNames[PstContentDataKondisi.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKondisi.fieldNames[PstContentDataKondisi.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jenis Garansi
    public static String getContentDataKodeJenisGaransi (String kodeJenisGaransi) {
        DBResultSet dbrs = null;
        String result = "";
         
        try {
            String xData=kodeJenisGaransi!=null?kodeJenisGaransi.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataJenisGaransi.TBL_CONTENT_DATA_JENIS_GARANSI + " WHERE "
                    + PstContentDataJenisGaransi.fieldNames[PstContentDataJenisGaransi.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJenisGaransi.fieldNames[PstContentDataJenisGaransi.FLD_KODE_OJK]);
            }
            if(result.equals("") || result==null){
                result="90";
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Tujuan Garansi
    public static String getContentDataKodeTujuanGaransi (String kodeTujuanGaransi) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeTujuanGaransi!=null?kodeTujuanGaransi.replace("\\s", ""):"";
            String sql = " SELECT * FROM " + PstContentDataTujuanGaransi.TBL_CONTENT_DATA_TUJUAN_GARANSI + " WHERE "
                    + PstContentDataTujuanGaransi.fieldNames[PstContentDataTujuanGaransi.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataTujuanGaransi.fieldNames[PstContentDataTujuanGaransi.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jenis Agunan
    public static String getContentDataKodeJenisAgunan (String kodeJenisAgunan) {
        DBResultSet dbrs = null;
        String result = "";
        
        try {
            String xData=kodeJenisAgunan.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataJenisAgunan.TBL_CONTENT_DATA_JENIS_AGUNAN + " WHERE "
                    + PstContentDataJenisAgunan.fieldNames[PstContentDataJenisAgunan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJenisAgunan.fieldNames[PstContentDataJenisAgunan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jenis Pengikatan
    public static String getContentDataKodeJenisPengikatan (String kodeJenisPengikatan) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeJenisPengikatan.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataJenisPengikatan.TBL_CONTENT_DATA_JENIS_PENGIKATAN + " WHERE "
                    + PstContentDataJenisPengikatan.fieldNames[PstContentDataJenisPengikatan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJenisPengikatan.fieldNames[PstContentDataJenisPengikatan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jenis Identitas
    public static String getContentDataJenisIdentitas(String jenisIdentitas) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=jenisIdentitas.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataJenisIdentitas.TBL_CONTENT_DATA_JENIS_IDENTITAS + " WHERE "
                    + PstContentDataJenisIdentitas.fieldNames[PstContentDataJenisIdentitas.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJenisIdentitas.fieldNames[PstContentDataJenisIdentitas.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
           // //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Jabatan
    public static String getContentDataKodeJabatan(String kodeJabatan) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeJabatan.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataJabatan.TBL_CONTENT_DATA_JABATAN + " WHERE "
                    + PstContentDataJabatan.fieldNames[PstContentDataJabatan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataJabatan.fieldNames[PstContentDataJabatan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //contoh
    public static String getContentDataStatusPendidikan (String kodeStatusPendidikan) {
        DBResultSet dbrs = null;
        String result = "";
        if(kodeStatusPendidikan==null){
            result="00";
        }
        try {
            String xData=kodeStatusPendidikan.replace("\\s", "");
            String sql = "SELECT * FROM " + PstContentDataStatusPendidikan.TBL_CONTENT_DATA_STATUS_PENDIDIKAN+ " WHERE "
                    + PstContentDataStatusPendidikan.fieldNames[PstContentDataStatusPendidikan.FLD_KODE_CORE_BANKING] + " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataStatusPendidikan.fieldNames[PstContentDataStatusPendidikan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    
    //Kode suku bunga
    public static String getContentSukuBunga(String kodeSukuBungCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeSukuBungCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataSukuBunga.TBL_CONTENT_DATA_SUKU_BUNGA + " WHERE "
                    + PstContentDataSukuBunga.fieldNames[PstContentDataSukuBunga.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSukuBunga.fieldNames[PstContentDataSukuBunga.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //kode penghasilan
    public static String getContentKodePenghasilan(String kodePenghasilan) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodePenghasilan.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataSumberPenghasilan.TBL_CONTENT_DATA_SUMBER_PENGHASILAN+ " WHERE "
                    + PstContentDataSumberPenghasilan.fieldNames[PstContentDataSumberPenghasilan.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSumberPenghasilan.fieldNames[PstContentDataSumberPenghasilan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());   
            result="";
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    public static String getContentDataKodeProgramPemerintah (String kodeProgramPemerintah) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeProgramPemerintah.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataKodeProgramPemerintah.TBL_CONTENT_DATA_KODE_PROGRAM_PEMERINTAH + " WHERE "
                    + PstContentDataKodeProgramPemerintah.fieldNames[PstContentDataKodeProgramPemerintah.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKodeProgramPemerintah.fieldNames[PstContentDataKodeProgramPemerintah.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    
    public static String getContentDataKodeKondisiBankGaransi(String kodeKondisiBankGaransi) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeKondisiBankGaransi.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataKondisiBankGaransi.TBL_CONTENT_DATA_KONDISI_BANK_GARANSI + " WHERE "
                    + PstContentDataKondisiBankGaransi.fieldNames[PstContentDataKondisiBankGaransi.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataKondisiBankGaransi.fieldNames[PstContentDataKondisiBankGaransi.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    //Kode Sumber Penghasilan 
    public static String getContentDataKodeSumberDanaKredit(String kodePenghasilanCoreBanking) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodePenghasilanCoreBanking.replace("\\s", "");
            String sql = " SELECT * FROM " + PstContentDataSumberDanaKredit.TBL_CONTENT_DATA_SUMBER_DANA_KREDIT+ " WHERE "
                    + PstContentDataSumberDanaKredit.fieldNames[PstContentDataSumberDanaKredit.FLD_KODE_CORE_BANKING] + 
                    " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataSumberDanaKredit.fieldNames[PstContentDataSumberDanaKredit.FLD_KODE_OJK]);
            }
            if(result.equals("") || result==null){
                result="002";
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());            
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    public static String getContentDataStatusAgunan (String kodeStatusAgunan) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeStatusAgunan.replace("\\s", "");
            String sql = "SELECT * FROM " + PstContentDataStatusAgunan.TBL_CONTENT_DATA_STATUS_AGUNAN+ " WHERE "
                    + PstContentDataStatusAgunan.fieldNames[PstContentDataStatusAgunan.FLD_KODE_CORE_BANKING] + " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataStatusAgunan.fieldNames[PstContentDataStatusAgunan.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    public static String getContentDataHubunganDenganPelapor (String kodeStatusAgunan) {
        DBResultSet dbrs = null;
        String result = "";
        try {
            String xData=kodeStatusAgunan.replace("\\s", "");
            String sql = "SELECT * FROM " + PstContentDataHubDgnPelapor.TBL_CONTENT_DATA_HUB_DGN_PELAPOR+ " WHERE "
                    + PstContentDataHubDgnPelapor.fieldNames[PstContentDataHubDgnPelapor.FLD_KODE_CORE_BANKING] + " = '" + xData+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getString(PstContentDataHubDgnPelapor.fieldNames[PstContentDataHubDgnPelapor.FLD_KODE_OJK]);
            }
            rs.close();
        } catch (Exception e) {
            //System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
}

