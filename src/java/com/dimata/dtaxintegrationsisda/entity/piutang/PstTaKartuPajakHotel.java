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

public class PstTaKartuPajakHotel extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    public static final String TBL_TAKARTUPAJAKHOTEL = "Ta_Kartu_Pajak_Hotel";
    public static final int FLD_TAHUN = 0;
    public static final int FLD_NO_SPT = 1;
    public static final int FLD_KD_REK_1 = 2;
    public static final int FLD_KD_REK_2 = 3;
    public static final int FLD_KD_REK_3 = 4;
    public static final int FLD_KD_REK_4 = 5;
    public static final int FLD_KD_REK_5 = 6;
    public static final int FLD_KD_REK_6 = 7;
    public static final int FLD_DASAR_PENGENAAN = 8;
    public static final int FLD_PAJAK_TERHUTANG = 9;
    public static final int FLD_TARIF_PAJAK=10;
    public static final int FLD_KAS=11;
    public static final int FLD_PEMBUKUAN=12;
    
     public static String[] fieldNames = {
        "Tahun",
        "No_SPT",
        "Kd_Rek_1",
        "Kd_Rek_2",
        "Kd_Rek_3",
        "Kd_Rek_4",
        "Kd_Rek_5",
        "Kd_Rek_6",
        "DasarPengenaan",
        "PajakTerhutang",
        "TarifPajak",
        "Kas",
        "Pembukuan"
       
    };
    
    public static int[] fieldTypes = {
        TYPE_INT,
        TYPE_STRING,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_INT,
        TYPE_INT
          
    };
     public PstTaKartuPajakHotel() {
    }

    public PstTaKartuPajakHotel(int i) throws DBException {
        super(new PstTaKartuPajakHotel());
    }

    public PstTaKartuPajakHotel(String sOid) throws DBException {
        super(new PstTaKartuPajakHotel(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstTaKartuPajakHotel(long lOid) throws DBException {
        super(new PstTaKartuPajakHotel(0));
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
        return TBL_TAKARTUPAJAKHOTEL;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstTaKartuPajakHotel().getClass().getName();
    }
    
    
    public static TaKartuPajakHotel fetchExc(long oid) throws DBException {
        try {
            TaKartuPajakHotel entTaKartuPajakHotel = new TaKartuPajakHotel();
            PstTaKartuPajakHotel pstTaKartuPajakHotel = new PstTaKartuPajakHotel(oid);
            entTaKartuPajakHotel.setOID(oid);
            entTaKartuPajakHotel.setTahun(pstTaKartuPajakHotel.getInt(FLD_TAHUN));
            entTaKartuPajakHotel.setNoSpt(pstTaKartuPajakHotel.getString(FLD_NO_SPT));
            entTaKartuPajakHotel.setKdRek1(pstTaKartuPajakHotel.getInt(FLD_KD_REK_1));
            entTaKartuPajakHotel.setKdRek2(pstTaKartuPajakHotel.getInt(FLD_KD_REK_2));
            entTaKartuPajakHotel.setKdRek3(pstTaKartuPajakHotel.getInt(FLD_KD_REK_3));
            entTaKartuPajakHotel.setKdRek4(pstTaKartuPajakHotel.getInt(FLD_KD_REK_4));
            entTaKartuPajakHotel.setKdRek5(pstTaKartuPajakHotel.getInt(FLD_KD_REK_5));
            entTaKartuPajakHotel.setKdRek6(pstTaKartuPajakHotel.getInt(FLD_KD_REK_6));
            entTaKartuPajakHotel.setDasarPengenaan(pstTaKartuPajakHotel.getdouble(FLD_DASAR_PENGENAAN));
            entTaKartuPajakHotel.setPajakTerhutang(pstTaKartuPajakHotel.getdouble(FLD_PAJAK_TERHUTANG));
            entTaKartuPajakHotel.setTarifPajak(pstTaKartuPajakHotel.getdouble(FLD_TARIF_PAJAK));
            entTaKartuPajakHotel.setKas(pstTaKartuPajakHotel.getInt(FLD_KAS));
            entTaKartuPajakHotel.setPembukuan(pstTaKartuPajakHotel.getInt(FLD_PEMBUKUAN));
            return entTaKartuPajakHotel;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHotel(0), DBException.UNKNOWN);
        }
    }
    public long fetchExc(Entity ent) throws Exception {
        TaKartuPajakHotel entTaKartuPajakHotel = fetchExc(ent.getOID());
        ent = (Entity) entTaKartuPajakHotel;
        return entTaKartuPajakHotel.getOID();
    }

    public long updateExc(TaKartuPajakHotel entTaKartuPajakHotel) throws Exception {
        try{
            if (entTaKartuPajakHotel.getOID()!= 0) {
               PstTaKartuPajakHotel pstTaKartuPajakHotel = new PstTaKartuPajakHotel(entTaKartuPajakHotel.getOID()); 
               pstTaKartuPajakHotel.setInt(FLD_TAHUN,entTaKartuPajakHotel.getTahun());
               pstTaKartuPajakHotel.setString(FLD_NO_SPT, entTaKartuPajakHotel.getNoSpt());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_1, entTaKartuPajakHotel.getKdRek1());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_2, entTaKartuPajakHotel.getKdRek2());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_3, entTaKartuPajakHotel.getKdRek3());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_4, entTaKartuPajakHotel.getKdRek4());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_5, entTaKartuPajakHotel.getKdRek5());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_6, entTaKartuPajakHotel.getKdRek6());
               pstTaKartuPajakHotel.setDouble(FLD_DASAR_PENGENAAN, entTaKartuPajakHotel.getDasarPengenaan());
               pstTaKartuPajakHotel.setDouble(FLD_PAJAK_TERHUTANG, entTaKartuPajakHotel.getPajakTerhutang());
               pstTaKartuPajakHotel.setDouble(FLD_TARIF_PAJAK, entTaKartuPajakHotel.getTarifPajak());
               pstTaKartuPajakHotel.setInt(FLD_KAS, entTaKartuPajakHotel.getKas());
               pstTaKartuPajakHotel.setInt(FLD_PEMBUKUAN, entTaKartuPajakHotel.getPembukuan());
            
                pstTaKartuPajakHotel.update();
                
                return entTaKartuPajakHotel.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHotel(0), DBException.UNKNOWN);
        }
        return 0;
    }
    
    public long updateExc(Entity ent) throws Exception {
        return updateExc((TaKartuPajakHotel) ent);
    }
       public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstTaKartuPajakPungut pstTaKartuPajakPungut = new PstTaKartuPajakPungut(oid);
            pstTaKartuPajakPungut.delete();
        } catch (Exception e) {
           
        }
        return oid;
    }
     
   public long deleteExc(Entity ent) throws Exception {
        if (ent == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(ent.getOID());
    }
   
    public static synchronized long insertExc( TaKartuPajakHotel entTaKartuPajakHotel) throws DBException {
        try {
               PstTaKartuPajakHotel pstTaKartuPajakHotel = new PstTaKartuPajakHotel(0); 
               pstTaKartuPajakHotel.setInt(FLD_TAHUN,entTaKartuPajakHotel.getTahun());
               pstTaKartuPajakHotel.setString(FLD_NO_SPT, entTaKartuPajakHotel.getNoSpt());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_1, entTaKartuPajakHotel.getKdRek1());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_2, entTaKartuPajakHotel.getKdRek2());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_3, entTaKartuPajakHotel.getKdRek3());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_4, entTaKartuPajakHotel.getKdRek4());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_5, entTaKartuPajakHotel.getKdRek5());
               pstTaKartuPajakHotel.setInt(FLD_KD_REK_6, entTaKartuPajakHotel.getKdRek6());
               pstTaKartuPajakHotel.setDouble(FLD_DASAR_PENGENAAN, entTaKartuPajakHotel.getDasarPengenaan());
               pstTaKartuPajakHotel.setDouble(FLD_PAJAK_TERHUTANG, entTaKartuPajakHotel.getPajakTerhutang());
               pstTaKartuPajakHotel.setDouble(FLD_TARIF_PAJAK, entTaKartuPajakHotel.getTarifPajak());
               pstTaKartuPajakHotel.setInt(FLD_KAS, entTaKartuPajakHotel.getKas());
               pstTaKartuPajakHotel.setInt(FLD_PEMBUKUAN, entTaKartuPajakHotel.getPembukuan());
            
                pstTaKartuPajakHotel.insert();
            //entTaKartuPajakHotel.setOID(pstTaKartuPajakHotel.getlong(FLD_TAHUN));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHotel(0), DBException.UNKNOWN);
        }
        return entTaKartuPajakHotel.getOID();
    }

    public long insertExc(Entity ent) throws Exception {
        return insertExc((TaKartuPajakHotel) ent);
    }
    
    public static void resultToObject(ResultSet rs, TaKartuPajakHotel entTaKartuPajakHotel) { 
        try {
            entTaKartuPajakHotel.setTahun(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_TAHUN]));
            entTaKartuPajakHotel.setNoSpt(rs.getString(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_NO_SPT]));
            entTaKartuPajakHotel.setKdRek1(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KD_REK_1]));
            entTaKartuPajakHotel.setKdRek2(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KD_REK_2]));
            entTaKartuPajakHotel.setKdRek3(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KD_REK_3]));
            entTaKartuPajakHotel.setKdRek4(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KD_REK_4]));
            entTaKartuPajakHotel.setKdRek5(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KD_REK_5]));
            entTaKartuPajakHotel.setKdRek6(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KD_REK_6]));
            entTaKartuPajakHotel.setDasarPengenaan(rs.getDouble(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_DASAR_PENGENAAN]));
            entTaKartuPajakHotel.setPajakTerhutang(rs.getDouble(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_PAJAK_TERHUTANG]));
            entTaKartuPajakHotel.setTarifPajak(rs.getDouble(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_TARIF_PAJAK]));
            entTaKartuPajakHotel.setKas(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_KAS]));
            entTaKartuPajakHotel.setPembukuan(rs.getInt(PstTaKartuPajakHotel.fieldNames[PstTaKartuPajakHotel.FLD_PEMBUKUAN]));
        
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
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKHOTEL;
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
                TaKartuPajakHotel entTaKartuPajakHotel = new TaKartuPajakHotel();
                resultToObject(rs, entTaKartuPajakHotel );
                lists.add(entTaKartuPajakHotel );
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

    public static boolean checkOID(long entTaKartuPajakHotel ) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKHOTEL + " WHERE "
                    + PstTaKartuPajakHotel .fieldNames[PstTaKartuPajakHotel .FLD_TAHUN] + " = " + entTaKartuPajakHotel ;
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
            String sql = "SELECT COUNT(" + PstTaKartuPajakHotel .fieldNames[PstTaKartuPajakHotel .FLD_TAHUN] + ") FROM " + TBL_TAKARTUPAJAKHOTEL;
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
    
   
    
    
}

            


