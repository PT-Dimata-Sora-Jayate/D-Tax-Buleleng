/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.dtaxintegrationsisda.entity.piutang;

/**
 *
 * @author Diana
 */
/* package java */
import java.sql.*;

/* package qdep */
import com.dimata.util.lang.I_Language;
import com.dimata.dtaxintegrationsisda.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import java.util.Vector;

public class PstTaKartuPajakPungut extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    
    public static final String TBL_TAKARTUPAJAKPUNGUT = "Ta_Kartu_Pajak_Pungut";
    public static final int FLD_TAHUN = 0;
    public static final int FLD_NO_SPT = 1;
    public static final int FLD_TGL_SPT = 2;
    public static final int FLD_NO_POKOK_WP = 3;
    public static final int FLD_JN_WAJIB_PAJAK = 4;
    public static final int FLD_JN_USAHA_WP = 5;
    public static final int FLD_KD_USAHA = 6;
    public static final int FLD_JN_PAJAK = 7;
    public static final int FLD_JN_PEMUNGUTAN = 8;
    public static final int FLD_JN_PENETAPAN = 9;
    public static final int FLD_MASA1=10;
    public static final int FLD_MASA2=11;
    
    public static final int FLD_KD_URUSAN=12;
    public static final int FLD_KD_BIDANG=13;
    public static final int FLD_KD_UNIT=14;
    public static final int FLD_KD_SUB=15;
    public static final int FLD_NM_PENERIMA=16;
    public static final int FLD_NIP_PENERIMA=17;
    public static final int FLD_JBT_PENERIMA=18;
    public static final int FLD_TGL_TERIMA=19;
    public static final int FLD_KETERANGAN=20;
    public static final int FLD_KD_NILAI=21;
    
     public static String[] fieldNames = {
        "Tahun",
        "No_SPT",
        "Tgl_SPT",
        "No_Pokok_WP",
        "Jn_Wajib_Pajak",
        "Jn_Usaha_WP",
        "Kd_Usaha",
        "Jn_Pajak",
        "Jn_Pemungutan",
        "Jn_Penetapan",
        "Masa1",
        "Masa2",
        "Kd_Urusan",
        "Kd_Bidang",
        "Kd_Unit",
        "Kd_Sub",
        "Nm_Penerima",
        "Nip_Penerima",
        "Jbt_Penerima",
        "Tgl_terima",
        "Keterangan",
        "Kd_Nilai"
        
    };
    
    public static int[] fieldTypes = {
        TYPE_INT,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_DATE,
        TYPE_DATE,
        
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_INT
        
    };

    public PstTaKartuPajakPungut() {
    }

    public PstTaKartuPajakPungut(int i) throws DBException {
        super(new PstTaKartuPajakPungut());
    }

    public PstTaKartuPajakPungut(String sOid) throws DBException {
        super(new PstTaKartuPajakPungut(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstTaKartuPajakPungut(long lOid) throws DBException {
        super(new PstTaKartuPajakPungut(0));
        String sOid = "0";
        try {
            sOid = String.valueOf(lOid);
        } catch (Exception e) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public int getFieldSize() {
        return fieldNames.length;
    }

    public String getTableName() {
        return TBL_TAKARTUPAJAKPUNGUT;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstTaKartuPajakPungut().getClass().getName();
    }
    
    public static TaKartuPajakPungut fetchExc(long oid) throws DBException {
        try {
            TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
            PstTaKartuPajakPungut pstTaKartuPajakPungut = new PstTaKartuPajakPungut(oid);
            entTaKartuPajakPungut.setOID(oid);
            entTaKartuPajakPungut.setTahun(pstTaKartuPajakPungut.getInt(FLD_TAHUN));
            entTaKartuPajakPungut.setNoSpt(pstTaKartuPajakPungut.getString(FLD_NO_SPT));
            entTaKartuPajakPungut.setTglSpt(pstTaKartuPajakPungut.getDate(FLD_TGL_SPT));
            entTaKartuPajakPungut.setNoPokokWp(pstTaKartuPajakPungut.getString(FLD_NO_POKOK_WP));
            entTaKartuPajakPungut.setJnWajibPajak(pstTaKartuPajakPungut.getInt(FLD_JN_WAJIB_PAJAK));
            entTaKartuPajakPungut.setJnUsahaWp(pstTaKartuPajakPungut.getInt(FLD_JN_USAHA_WP));
            entTaKartuPajakPungut.setKdUsaha(pstTaKartuPajakPungut.getInt(FLD_KD_USAHA));
            entTaKartuPajakPungut.setJnPajak(pstTaKartuPajakPungut.getInt(FLD_JN_PAJAK));
            entTaKartuPajakPungut.setJnPemungutan(pstTaKartuPajakPungut.getInt(FLD_JN_PEMUNGUTAN));
            entTaKartuPajakPungut.setJnPenetapan(pstTaKartuPajakPungut.getInt(FLD_JN_PENETAPAN));
            entTaKartuPajakPungut.setMasa1(pstTaKartuPajakPungut.getDate(FLD_MASA1));
            entTaKartuPajakPungut.setMasa2(pstTaKartuPajakPungut.getDate(FLD_MASA2));
            
            entTaKartuPajakPungut.setKdUrusan(pstTaKartuPajakPungut.getInt(FLD_KD_URUSAN));
            entTaKartuPajakPungut.setKdBidang(pstTaKartuPajakPungut.getInt(FLD_KD_BIDANG));
            entTaKartuPajakPungut.setKdUnit(pstTaKartuPajakPungut.getInt(FLD_KD_UNIT));
            entTaKartuPajakPungut.setKdSub(pstTaKartuPajakPungut.getInt(FLD_KD_SUB));
            entTaKartuPajakPungut.setNmPenerima(pstTaKartuPajakPungut.getString(FLD_NM_PENERIMA));
            entTaKartuPajakPungut.setNipPenerima(pstTaKartuPajakPungut.getString(FLD_NIP_PENERIMA));
            entTaKartuPajakPungut.setJbtPenerima(pstTaKartuPajakPungut.getString(FLD_JBT_PENERIMA));
            entTaKartuPajakPungut.setTglTerima(pstTaKartuPajakPungut.getDate(FLD_TGL_TERIMA));
            entTaKartuPajakPungut.setKeterangan(pstTaKartuPajakPungut.getString(FLD_KETERANGAN));
            entTaKartuPajakPungut.setKdNilai(pstTaKartuPajakPungut.getInt(FLD_KD_NILAI));
            return entTaKartuPajakPungut;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakPungut(0), DBException.UNKNOWN);
        }
    }
    public long fetchExc(Entity ent) throws Exception {
        TaKartuPajakPungut entTaKartuPajakPungut = fetchExc(ent.getOID());
        ent = (Entity) entTaKartuPajakPungut;
        return entTaKartuPajakPungut.getOID();
    }

    public long updateExc(TaKartuPajakPungut entTaKartuPajakPungut) throws Exception {
        try{
            if (entTaKartuPajakPungut.getOID()!= 0) {
               PstTaKartuPajakPungut pstTaKartuPajakPungut = new PstTaKartuPajakPungut(entTaKartuPajakPungut.getOID()); 
               pstTaKartuPajakPungut.setInt(FLD_TAHUN,entTaKartuPajakPungut.getTahun());
               pstTaKartuPajakPungut.setString(FLD_NO_SPT, entTaKartuPajakPungut.getNoSpt());
               pstTaKartuPajakPungut.setDate(FLD_TGL_SPT, entTaKartuPajakPungut.getTglSpt());
               pstTaKartuPajakPungut.setString(FLD_NO_POKOK_WP, entTaKartuPajakPungut.getNoPokokWp());
               pstTaKartuPajakPungut.setInt(FLD_JN_WAJIB_PAJAK, entTaKartuPajakPungut.getJnWajibPajak());
               pstTaKartuPajakPungut.setInt(FLD_JN_USAHA_WP, entTaKartuPajakPungut.getJnUsahaWp());
               pstTaKartuPajakPungut.setInt(FLD_KD_USAHA, entTaKartuPajakPungut.getKdUsaha());
               pstTaKartuPajakPungut.setInt(FLD_JN_PAJAK, entTaKartuPajakPungut.getJnPajak());
               pstTaKartuPajakPungut.setInt(FLD_JN_PEMUNGUTAN, entTaKartuPajakPungut.getJnPemungutan());
               pstTaKartuPajakPungut.setInt(FLD_JN_PENETAPAN, entTaKartuPajakPungut.getJnPenetapan());
               pstTaKartuPajakPungut.setDate(FLD_MASA1, entTaKartuPajakPungut.getMasa1());
               pstTaKartuPajakPungut.setDate(FLD_MASA2, entTaKartuPajakPungut.getMasa2());
            
               pstTaKartuPajakPungut.setInt(FLD_KD_URUSAN, entTaKartuPajakPungut.getKdUrusan());
               pstTaKartuPajakPungut.setInt(FLD_KD_BIDANG, entTaKartuPajakPungut.getKdBidang());
               pstTaKartuPajakPungut.setInt(FLD_KD_UNIT, entTaKartuPajakPungut.getKdUnit());
               pstTaKartuPajakPungut.setInt(FLD_KD_SUB, entTaKartuPajakPungut.getKdSub());
               pstTaKartuPajakPungut.setString(FLD_NM_PENERIMA, entTaKartuPajakPungut.getNmPenerima());
               pstTaKartuPajakPungut.setString(FLD_NIP_PENERIMA, entTaKartuPajakPungut.getNipPenerima());
               pstTaKartuPajakPungut.setString(FLD_JBT_PENERIMA,entTaKartuPajakPungut.getJbtPenerima());
               pstTaKartuPajakPungut.setDate(FLD_TGL_TERIMA, entTaKartuPajakPungut.getTglTerima());
               pstTaKartuPajakPungut.setString(FLD_KETERANGAN, entTaKartuPajakPungut.getKeterangan());
               pstTaKartuPajakPungut.setInt(FLD_KD_NILAI, entTaKartuPajakPungut.getKdNilai());
               
               pstTaKartuPajakPungut.update();
                
                return entTaKartuPajakPungut.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakPungut(0), DBException.UNKNOWN);
        }
        return 0;
    }
    
    public long updateExc(Entity ent) throws Exception {
        return updateExc((TaKartuPajakPungut) ent);
    }
    
     public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstTaKartuPajakPungut pstTaKartuPajakPungut = new PstTaKartuPajakPungut(oid);
            pstTaKartuPajakPungut.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakPungut(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity ent) throws Exception {
        if (ent == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(ent.getOID());
    }
    public static synchronized long insertExc( TaKartuPajakPungut entTaKartuPajakPungut) throws DBException {
        try {
               PstTaKartuPajakPungut pstTaKartuPajakPungut = new PstTaKartuPajakPungut(0);
               pstTaKartuPajakPungut.setInt(FLD_TAHUN,entTaKartuPajakPungut.getTahun());
               pstTaKartuPajakPungut.setString(FLD_NO_SPT, entTaKartuPajakPungut.getNoSpt());
               pstTaKartuPajakPungut.setDate(FLD_TGL_SPT, entTaKartuPajakPungut.getTglSpt());
               pstTaKartuPajakPungut.setString(FLD_NO_POKOK_WP, entTaKartuPajakPungut.getNoPokokWp());
               pstTaKartuPajakPungut.setInt(FLD_JN_WAJIB_PAJAK, entTaKartuPajakPungut.getJnWajibPajak());
               pstTaKartuPajakPungut.setInt(FLD_JN_USAHA_WP, entTaKartuPajakPungut.getJnUsahaWp());
               pstTaKartuPajakPungut.setInt(FLD_KD_USAHA, entTaKartuPajakPungut.getKdUsaha());
               pstTaKartuPajakPungut.setInt(FLD_JN_PAJAK, entTaKartuPajakPungut.getJnPajak());
               pstTaKartuPajakPungut.setInt(FLD_JN_PEMUNGUTAN, entTaKartuPajakPungut.getJnPemungutan());
               pstTaKartuPajakPungut.setInt(FLD_JN_PENETAPAN, entTaKartuPajakPungut.getJnPenetapan());
               pstTaKartuPajakPungut.setDate(FLD_MASA1, entTaKartuPajakPungut.getMasa1());
               pstTaKartuPajakPungut.setDate(FLD_MASA2, entTaKartuPajakPungut.getMasa2());
            
               pstTaKartuPajakPungut.setInt(FLD_KD_URUSAN, entTaKartuPajakPungut.getKdUrusan());
               pstTaKartuPajakPungut.setInt(FLD_KD_BIDANG, entTaKartuPajakPungut.getKdBidang());
               pstTaKartuPajakPungut.setInt(FLD_KD_UNIT, entTaKartuPajakPungut.getKdUnit());
               pstTaKartuPajakPungut.setInt(FLD_KD_SUB, entTaKartuPajakPungut.getKdSub());
               pstTaKartuPajakPungut.setString(FLD_NM_PENERIMA, entTaKartuPajakPungut.getNmPenerima());
               pstTaKartuPajakPungut.setString(FLD_NIP_PENERIMA, entTaKartuPajakPungut.getNipPenerima());
               pstTaKartuPajakPungut.setString(FLD_JBT_PENERIMA,entTaKartuPajakPungut.getJbtPenerima());
               pstTaKartuPajakPungut.setDate(FLD_TGL_TERIMA, entTaKartuPajakPungut.getTglTerima());
               pstTaKartuPajakPungut.setString(FLD_KETERANGAN, entTaKartuPajakPungut.getKeterangan());
               pstTaKartuPajakPungut.setInt(FLD_KD_NILAI, entTaKartuPajakPungut.getKdNilai());
               
               pstTaKartuPajakPungut.insert();
               //entTaKartuPajakPungut.setOID(pstTaKartuPajakPungut.getlong(FLD_TAHUN));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakPungut(0), DBException.UNKNOWN);
        }
        return entTaKartuPajakPungut.getOID();
    }

    public long insertExc(Entity ent) throws Exception {
        return insertExc((TaKartuPajakPungut) ent);
    }

    public static void resultToObject(ResultSet rs, TaKartuPajakPungut entTaKartuPajakPungut) {
        
        try {
            
            entTaKartuPajakPungut.setTahun(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_TAHUN]));
            entTaKartuPajakPungut.setNoSpt(rs.getString(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_NO_SPT]));
            entTaKartuPajakPungut.setTglSpt(rs.getDate(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_TGL_SPT]));
            entTaKartuPajakPungut.setNoPokokWp(rs.getString(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_NO_POKOK_WP]));
            entTaKartuPajakPungut.setJnWajibPajak(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_JN_WAJIB_PAJAK]));
            entTaKartuPajakPungut.setJnUsahaWp(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_JN_USAHA_WP]));
            entTaKartuPajakPungut.setKdUsaha(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KD_USAHA]));
            entTaKartuPajakPungut.setJnPajak(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_JN_PAJAK]));
            entTaKartuPajakPungut.setJnPemungutan(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_JN_PEMUNGUTAN]));
            entTaKartuPajakPungut.setJnPenetapan(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_JN_PENETAPAN]));
            entTaKartuPajakPungut.setMasa1(rs.getDate(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_MASA1]));
            entTaKartuPajakPungut.setMasa2(rs.getDate(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_MASA2]));
            
            entTaKartuPajakPungut.setKdUrusan(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KD_URUSAN]));
            entTaKartuPajakPungut.setKdBidang(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KD_BIDANG]));
            entTaKartuPajakPungut.setKdUnit(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KD_UNIT]));
            entTaKartuPajakPungut.setKdSub(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KD_SUB]));
            entTaKartuPajakPungut.setNmPenerima(rs.getString(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_NM_PENERIMA]));
            entTaKartuPajakPungut.setNipPenerima(rs.getString(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_NIP_PENERIMA]));
            entTaKartuPajakPungut.setJbtPenerima(rs.getString(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_JBT_PENERIMA]));
            entTaKartuPajakPungut.setTglTerima(rs.getDate(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_TGL_TERIMA]));
            entTaKartuPajakPungut.setKeterangan(rs.getString(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KETERANGAN]));
            entTaKartuPajakPungut.setKdNilai(rs.getInt(PstTaKartuPajakPungut.fieldNames[PstTaKartuPajakPungut.FLD_KD_NILAI]));
            
        } catch (Exception e) {
        }
    }

    public static Vector listAll() {
        return list(0, 500, "", "");
    }

    public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKPUNGUT;
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
                TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
                resultToObject(rs, entTaKartuPajakPungut );
                lists.add(entTaKartuPajakPungut );
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

    public static boolean checkOID(long entTaKartuPajakPungut ) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKPUNGUT + " WHERE "
                    + PstTaKartuPajakPungut .fieldNames[PstTaKartuPajakPungut .FLD_TAHUN] + " = " + entTaKartuPajakPungut ;
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }

    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstTaKartuPajakPungut .fieldNames[PstTaKartuPajakPungut .FLD_TAHUN] + ") FROM " + TBL_TAKARTUPAJAKPUNGUT;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            return count;
        } catch (Exception e) {
            return 0;
        } finally {
            DBResultSet.close(dbrs);
        }
    }

    public static int findLimitStart(long oid, int recordToGet, String whereClause, String orderClause) {
        int size = getCount(whereClause);
        int start = 0;
        boolean found = false;
        for (int i = 0; (i < size) && !found; i = i + recordToGet) {
            Vector list = list(i, recordToGet, whereClause, orderClause);
            start = i;
            if (list.size() > 0) {
                for (int ls = 0; ls < list.size(); ls++) {
                    TaKartuPajakPungut entTakartuPajakPungut = (TaKartuPajakPungut) list.get(ls);
                    if (oid == entTakartuPajakPungut.getOID()) {
                        found = true;
                    }
                }
            }
        }
        if ((start >= size) && (size > 0)) {
            start = start - recordToGet;
        }
        return start;
    }

    public static int findLimitCommand(int start, int recordToGet, int vectSize) {
        int cmd = Command.LIST;
        int mdl = vectSize % recordToGet;
        vectSize = vectSize + (recordToGet - mdl);
        if (start == 0) {
            cmd = Command.FIRST;
        } else {
            if (start == (vectSize - recordToGet)) {
                cmd = Command.LAST;
            } else {
                start = start + recordToGet;
                if (start <= (vectSize - recordToGet)) {
                    cmd = Command.NEXT;
                    System.out.println("next.......................");
                } else {
                    start = start - recordToGet;
                    if (start > 0) {
                        cmd = Command.PREV;
                        System.out.println("prev.......................");
                    }
                }
            }
        }
        return cmd;
    }
    
//     public static Vector listTaPungut(int limitStart, int recordToGet, String whereClause, String order) {
//         //java.sql.Statement s;
//         //java.sql.ResultSet rs;
//         try {
//            Vector lists = new Vector();
//            
//            Connection con = SqlServerConnection.getConnection();
//            try {
//                String sql = "SELECT * FROM " + PstTaKartuPajakPungut.TBL_TAKARTUPAJAKPUNGUT;
//                if (whereClause != null && whereClause.length() > 0) {
//                    sql = sql + " WHERE " + whereClause;
//                }
//                if (order != null && order.length() > 0) {
//                    sql = sql + " ORDER BY " + order;
//                }
//                if (limitStart == 0 && recordToGet == 0) {
//                    sql = sql + "";
//                } else {
//                    sql = sql + " LIMIT " + limitStart + "," + recordToGet;
//                }
//                //dbrs = DBHandler.execQueryResult(sql);
//                //ResultSet rs = dbrs.getResultSet();
//                s = con.createStatement();
//                rs = s.executeQuery(sql);
//                while (rs.next()) {
//                    TaKartuPajakPungut taKartuPajakPungut = new TaKartuPajakPungut();
//                    resultToObject(rs, taKartuPajakPungut);
//                    lists.add(taKartuPajakPungut);
//                }
//                rs.close();
//                return lists;
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                if (con != null) {
//                    con.close();
//                }
//            }
//            return new Vector();
//            
//        } catch (Exception ex) {
//                    Logger.getLogger(PstTaKartuPajakHotel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return new Vector();
//    }
    
      public static Vector listTest(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM Ref_Kelas ";
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
                TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
                entTaKartuPajakPungut.setNipPenerima("aaa");
                entTaKartuPajakPungut.setNoPokokWp(rs.getString("Nm_Kelas"));
                lists.add(entTaKartuPajakPungut );
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
  
    
    public static Vector listJoinHotel(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            /*
            select tp.*, ph.* from Ta_Kartu_Pajak_Pungut as tp
            inner join Ta_Kartu_Pajak_Hotel as ph
            on tp.No_SPT = ph.No_SPT
            where tp.No_Pokok_WP like '%0162%';
            */
            String sql =" SELECT tp.*, ph.* FROM "+TBL_TAKARTUPAJAKPUNGUT+" as tp"+
                        " INNER JOIN "+PstTaKartuPajakHotel.TBL_TAKARTUPAJAKHOTEL+" as ph "+
                        " ON tp.No_SPT = ph.No_SPT ";
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
                Vector vDataPajak= new Vector();
                TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
                resultToObject(rs, entTaKartuPajakPungut );
                vDataPajak.add(entTaKartuPajakPungut);
                        
                TaKartuPajakHotel entKartuPajakHotel = new TaKartuPajakHotel();
                PstTaKartuPajakHotel.resultToObject(rs, entKartuPajakHotel);
                vDataPajak.add(entKartuPajakHotel);
                
                lists.add(vDataPajak );
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
    
    
    public static Vector listJoinRestoran(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            /*
            select tp.*, ph.* from Ta_Kartu_Pajak_Pungut as tp
            inner join Ta_Kartu_Pajak_Hotel as ph
            on tp.No_SPT = ph.No_SPT
            where tp.No_Pokok_WP like '%0162%';
            */
            String sql =" SELECT tp.*, ph.* FROM "+TBL_TAKARTUPAJAKPUNGUT+" as tp"+
                        " INNER JOIN "+PstTaKartuPajakRestoran.TBL_TAKARTUPAJAKRESTORAN+" as ph "+
                        " ON tp.No_SPT = ph.No_SPT ";
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
                Vector vDataPajak= new Vector();
                TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
                resultToObject(rs, entTaKartuPajakPungut );
                vDataPajak.add(entTaKartuPajakPungut);
                        
                TaKartuPajakRestoran entKartuPajakRestoran = new TaKartuPajakRestoran();
                PstTaKartuPajakRestoran.resultToObject(rs, entKartuPajakRestoran);
                vDataPajak.add(entKartuPajakRestoran);
                
                lists.add(vDataPajak );
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
    
    
    public static Vector listJoinHiburan(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            /*
            select tp.*, ph.* from Ta_Kartu_Pajak_Pungut as tp
            inner join Ta_Kartu_Pajak_Hotel as ph
            on tp.No_SPT = ph.No_SPT
            where tp.No_Pokok_WP like '%0162%';
            */
            String sql =" SELECT tp.*, ph.* FROM "+TBL_TAKARTUPAJAKPUNGUT+" as tp"+
                        " INNER JOIN "+PstTaKartuPajakHiburan.TBL_TAKARTUPAJAKHIBURAN+" as ph "+
                        " ON tp.No_SPT = ph.No_SPT ";
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
                Vector vDataPajak= new Vector();
                TaKartuPajakPungut entTaKartuPajakPungut = new TaKartuPajakPungut();
                resultToObject(rs, entTaKartuPajakPungut );
                vDataPajak.add(entTaKartuPajakPungut);
                        
                TaKartuPajakHiburan entTaKartuPajakHiburan = new TaKartuPajakHiburan();
                PstTaKartuPajakHiburan.resultToObject(rs, entTaKartuPajakHiburan);
                vDataPajak.add(entTaKartuPajakHiburan);
                
                lists.add(vDataPajak );
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
    
}
