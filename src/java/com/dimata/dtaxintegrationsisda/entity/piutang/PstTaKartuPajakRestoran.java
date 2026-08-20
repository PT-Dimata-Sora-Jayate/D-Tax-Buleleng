/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.dtaxintegrationsisda.entity.piutang;

/**
 *
 * @author AYUKI
 */
import java.sql.*;

/* package qdep */
import com.dimata.util.lang.I_Language;
import com.dimata.dtaxintegrationsisda.db.*;
import static com.dimata.dtaxintegrationsisda.db.I_DBType.TYPE_FLOAT;
import static com.dimata.dtaxintegrationsisda.db.I_DBType.TYPE_STRING;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;
import com.dimata.util.Command;
import java.util.Vector;

public class PstTaKartuPajakRestoran extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    
    public static final String TBL_TAKARTUPAJAKRESTORAN = "TA_KARTU_PAJAK_RESTORAN";
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
    public static final int FLD_TARIF_PAJAK = 10;
    
    public static final int FLD_JML_MEJA = 11;
    public static final int FLD_JML_KURSI = 12;
    public static final int FLD_JML_PENGUNJUNG = 13;
    public static final int FLD_KAS = 14;
    public static final int FLD_PEMBUKUAN = 15;
    
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
        "JmlMeja",
        "JmlKursi",
        "JmlPengunjung",
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
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_INT,
        TYPE_INT
    };
    
    public PstTaKartuPajakRestoran(){
        
    }
    
    public PstTaKartuPajakRestoran(int i) throws DBException {
        super(new PstTaKartuPajakRestoran());
    }
    
    public PstTaKartuPajakRestoran(String sOid) throws DBException {
        super(new PstTaKartuPajakRestoran(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstTaKartuPajakRestoran(long lOid) throws DBException {
        super(new PstTaKartuPajakRestoran(0));
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
       

    @Override
    public int getFieldSize() {
        return fieldNames.length;
    }

    @Override
    public String getTableName() {
        return TBL_TAKARTUPAJAKRESTORAN;
    }

      public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }
    @Override
    public String getPersistentName() {
        return new PstTaKartuPajakRestoran().getClass().getName();
    }

    public static TaKartuPajakRestoran fetchExc(long oid) throws DBException {
        try {
            TaKartuPajakRestoran entTaKartuPajakRestoran = new TaKartuPajakRestoran();
            PstTaKartuPajakRestoran pstTaKartuPajakRestoran = new PstTaKartuPajakRestoran(oid);
            entTaKartuPajakRestoran.setOID(oid);
            entTaKartuPajakRestoran.setTahun(pstTaKartuPajakRestoran.getInt(FLD_TAHUN));
            entTaKartuPajakRestoran.setNoSPT(pstTaKartuPajakRestoran.getString(FLD_NO_SPT));
            entTaKartuPajakRestoran.setKdRek1(pstTaKartuPajakRestoran.getInt(FLD_KD_REK_1));
            entTaKartuPajakRestoran.setKdRek2(pstTaKartuPajakRestoran.getInt(FLD_KD_REK_2));
            entTaKartuPajakRestoran.setKdRek3(pstTaKartuPajakRestoran.getInt(FLD_KD_REK_3));
            entTaKartuPajakRestoran.setKdRek4(pstTaKartuPajakRestoran.getInt(FLD_KD_REK_4));
            entTaKartuPajakRestoran.setKdRek5(pstTaKartuPajakRestoran.getInt(FLD_KD_REK_5));
            entTaKartuPajakRestoran.setKdRek6(pstTaKartuPajakRestoran.getInt(FLD_KD_REK_6));
            entTaKartuPajakRestoran.setDasarPengenaan(pstTaKartuPajakRestoran.getdouble(FLD_DASAR_PENGENAAN));
            entTaKartuPajakRestoran.setPajakTerhutang(pstTaKartuPajakRestoran.getdouble(FLD_PAJAK_TERHUTANG));
            entTaKartuPajakRestoran.setTarifPajak(pstTaKartuPajakRestoran.getdouble(FLD_TARIF_PAJAK));
            
            entTaKartuPajakRestoran.setJmlMeja(pstTaKartuPajakRestoran.getdouble(FLD_JML_MEJA));
            entTaKartuPajakRestoran.setJmlKursi(pstTaKartuPajakRestoran.getdouble(FLD_JML_KURSI)); 
            entTaKartuPajakRestoran.setJmlPengunjung(pstTaKartuPajakRestoran.getdouble(FLD_JML_PENGUNJUNG));
            entTaKartuPajakRestoran.setKas(pstTaKartuPajakRestoran.getInt(FLD_KAS));
            entTaKartuPajakRestoran.setPembukuan(pstTaKartuPajakRestoran.getInt(FLD_PEMBUKUAN));
           
            return entTaKartuPajakRestoran;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakRestoran(0), DBException.UNKNOWN);
        }
    }
    
    public long fetchExc(Entity entity) throws Exception {
        TaKartuPajakRestoran entTaKartuPajakRestoran = fetchExc(entity.getOID());
        entity = (Entity) entTaKartuPajakRestoran;
        return entTaKartuPajakRestoran.getOID();
    }
    
    public static synchronized long updateExc(TaKartuPajakRestoran entTaKartuPajakRestoran) throws DBException {
        try {
            if (entTaKartuPajakRestoran.getOID() != 0) {
                
                PstTaKartuPajakRestoran pstTaKartuPajakRestoran = new PstTaKartuPajakRestoran(entTaKartuPajakRestoran.getOID());
                pstTaKartuPajakRestoran.setInt(FLD_TAHUN, entTaKartuPajakRestoran.getTahun());
                pstTaKartuPajakRestoran.setString(FLD_NO_SPT, entTaKartuPajakRestoran.getNoSPT());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_1, entTaKartuPajakRestoran.getKdRek1());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_2, entTaKartuPajakRestoran.getKdRek2());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_3, entTaKartuPajakRestoran.getKdRek3());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_4,entTaKartuPajakRestoran.getKdRek4());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_5, entTaKartuPajakRestoran.getKdRek5());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_6, entTaKartuPajakRestoran.getKdRek6());
                pstTaKartuPajakRestoran.setDouble(FLD_DASAR_PENGENAAN, entTaKartuPajakRestoran.getDasarPengenaan());
                pstTaKartuPajakRestoran.setDouble(FLD_PAJAK_TERHUTANG, entTaKartuPajakRestoran.getPajakTerhutang());
                pstTaKartuPajakRestoran.setDouble(FLD_TARIF_PAJAK, entTaKartuPajakRestoran.getTarifPajak());
                
                pstTaKartuPajakRestoran.setDouble(FLD_JML_MEJA, entTaKartuPajakRestoran.getJmlMeja());
                pstTaKartuPajakRestoran.setDouble(FLD_JML_KURSI, entTaKartuPajakRestoran.getJmlKursi());
                pstTaKartuPajakRestoran.setDouble(FLD_JML_PENGUNJUNG, entTaKartuPajakRestoran.getJmlPengunjung());
                pstTaKartuPajakRestoran.setInt(FLD_KAS, entTaKartuPajakRestoran.getKas());
                pstTaKartuPajakRestoran.setInt(FLD_PEMBUKUAN, entTaKartuPajakRestoran.getPembukuan());
                
                pstTaKartuPajakRestoran.update();
                
                return entTaKartuPajakRestoran.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakRestoran(0), DBException.UNKNOWN);
        }
        return 0;
    }


    @Override
    public long updateExc(Entity entity) throws Exception {
        return updateExc((TaKartuPajakRestoran) entity);
    }
    
    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstTaKartuPajakRestoran pstTaKartuPajakRestoran = new PstTaKartuPajakRestoran(oid);
            pstTaKartuPajakRestoran.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakRestoran(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }
    
     public static synchronized long insertExc(TaKartuPajakRestoran entTaKartuPajakRestoran) throws DBException {
        try {
            
                PstTaKartuPajakRestoran pstTaKartuPajakRestoran = new PstTaKartuPajakRestoran(0);
                pstTaKartuPajakRestoran.setInt(FLD_TAHUN, entTaKartuPajakRestoran.getTahun());
                pstTaKartuPajakRestoran.setString(FLD_NO_SPT, entTaKartuPajakRestoran.getNoSPT());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_1, entTaKartuPajakRestoran.getKdRek1());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_2, entTaKartuPajakRestoran.getKdRek2());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_3, entTaKartuPajakRestoran.getKdRek3());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_4,entTaKartuPajakRestoran.getKdRek4());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_5, entTaKartuPajakRestoran.getKdRek5());
                pstTaKartuPajakRestoran.setInt(FLD_KD_REK_6, entTaKartuPajakRestoran.getKdRek6());
                pstTaKartuPajakRestoran.setDouble(FLD_DASAR_PENGENAAN, entTaKartuPajakRestoran.getDasarPengenaan());
                pstTaKartuPajakRestoran.setDouble(FLD_PAJAK_TERHUTANG, entTaKartuPajakRestoran.getPajakTerhutang());
                pstTaKartuPajakRestoran.setDouble(FLD_TARIF_PAJAK, entTaKartuPajakRestoran.getTarifPajak());
                
                pstTaKartuPajakRestoran.setDouble(FLD_JML_MEJA, entTaKartuPajakRestoran.getJmlMeja());
                pstTaKartuPajakRestoran.setDouble(FLD_JML_KURSI, entTaKartuPajakRestoran.getJmlKursi());
                pstTaKartuPajakRestoran.setDouble(FLD_JML_PENGUNJUNG, entTaKartuPajakRestoran.getJmlPengunjung());
                pstTaKartuPajakRestoran.setInt(FLD_KAS, entTaKartuPajakRestoran.getKas());
                pstTaKartuPajakRestoran.setInt(FLD_PEMBUKUAN, entTaKartuPajakRestoran.getPembukuan());
            
            
                pstTaKartuPajakRestoran.insert();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakRestoran(0), DBException.UNKNOWN);
        }
        return entTaKartuPajakRestoran.getOID();
    }
    @Override
    public long insertExc(Entity entity) throws Exception {
        return insertExc((TaKartuPajakRestoran) entity);
    }
    
    public static void resultToObject(ResultSet rs, TaKartuPajakRestoran entTaKartuPajakRestoran) {
        
        try {
            
           // entTaKartuPajakRestoran.setOID(rs.getLong(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_TAKARTUPAJAKRESTORANID]));
            entTaKartuPajakRestoran.setTahun(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_TAHUN]));
            entTaKartuPajakRestoran.setNoSPT(rs.getString(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_NO_SPT]));
            entTaKartuPajakRestoran.setKdRek1(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KD_REK_1]));
            entTaKartuPajakRestoran.setKdRek2(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KD_REK_2]));
            entTaKartuPajakRestoran.setKdRek3(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KD_REK_3]));
            entTaKartuPajakRestoran.setKdRek4(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KD_REK_4]));
            entTaKartuPajakRestoran.setKdRek5(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KD_REK_5]));
            entTaKartuPajakRestoran.setKdRek6(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KD_REK_6]));
            entTaKartuPajakRestoran.setDasarPengenaan(rs.getDouble(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_DASAR_PENGENAAN]));
            entTaKartuPajakRestoran.setPajakTerhutang(rs.getDouble(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_PAJAK_TERHUTANG]));
            entTaKartuPajakRestoran.setTarifPajak(rs.getDouble(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_TARIF_PAJAK]));
           
            
            entTaKartuPajakRestoran.setJmlMeja(rs.getDouble(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_JML_MEJA]));
            entTaKartuPajakRestoran.setJmlKursi(rs.getDouble(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_JML_KURSI]));
            entTaKartuPajakRestoran.setJmlPengunjung(rs.getDouble(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_JML_PENGUNJUNG]));
            entTaKartuPajakRestoran.setKas(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_KAS]));
            entTaKartuPajakRestoran.setPembukuan(rs.getInt(PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_PEMBUKUAN]));
            
            
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
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKRESTORAN;
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
                TaKartuPajakRestoran entTaKartuPajakRestoran = new TaKartuPajakRestoran();
                resultToObject(rs, entTaKartuPajakRestoran);
                lists.add(entTaKartuPajakRestoran);
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

    public static boolean checkOID(long entTaKartuPajakRestoranId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKRESTORAN + " WHERE "
                    + PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_DASAR_PENGENAAN] + " = " + entTaKartuPajakRestoranId;
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
            String sql = "SELECT COUNT(" + PstTaKartuPajakRestoran.fieldNames[PstTaKartuPajakRestoran.FLD_JML_KURSI] + ") FROM " + TBL_TAKARTUPAJAKRESTORAN;
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
                    TaKartuPajakRestoran entTaKartuPajakRestoran = (TaKartuPajakRestoran) list.get(ls);
                    if (oid == entTaKartuPajakRestoran.getOID()) {
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
