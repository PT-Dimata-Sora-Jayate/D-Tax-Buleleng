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
import com.dimata.qdep.db.*;
import static com.dimata.qdep.db.I_DBType.TYPE_DATE;
import static com.dimata.qdep.db.I_DBType.TYPE_FLOAT;
import static com.dimata.qdep.db.I_DBType.TYPE_ID;
import static com.dimata.qdep.db.I_DBType.TYPE_LONG;
import static com.dimata.qdep.db.I_DBType.TYPE_PK;
import static com.dimata.qdep.db.I_DBType.TYPE_STRING;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;
import com.dimata.util.Command;
import java.util.Vector;


public class PstViewSptpdSimda extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    
    public static final String TBL_VIEWSPTPDSIMDA = "VIEW_SPTPD_SIMDA";
    public static final int FLD_NO_SPTPD = 0;
    public static final int FLD_NO_SSPD = 1;
    public static final int FLD_NPWPD = 2;
    public static final int FLD_MASA_PAJAK = 3;
    public static final int FLD_TAHUN_PAJAK = 4;
    public static final int FLD_KODE_PAJAK = 5;
    public static final int FLD_NO_REKENING = 6;
    public static final int FLD_NO_SUBREKENING = 7;
    public static final int FLD_TARIF = 8;
    public static final int FLD_OMZET=9;
    public static final int FLD_PAJAK=10;
    
    public static final int FLD_SERVICE_TAX=11;
    public static final int FLD_DENDA=12;
    public static final int FLD_PENGURANGAN=13;
    public static final int FLD_HARUS_DIBAYAR=14;
    public static final int FLD_TGL_REKAM=15;

    
    public static String[] fieldNames = {
        "NO_SPTPD",
        "NO_SSPD",
        "NPWPD",
        "MASA_PAJAK",
        "TAHUN_PAJAK",
        "KODE_PAJAK",
        "NO_REKENING",
        "NO_SUBREKENING",
        "TARIF",
        "OMZET",
        "PAJAK",
        
        "SERVICE_TAX",
        "DENDA",
        "PENGURANGAN",
        "HARUS_DIBAYAR",
        "TGL_REKAM"
        
    };
    
    public static int[] fieldTypes = {
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_DATE,
       
        
    };
    
    

    public PstViewSptpdSimda(){
        
    }
    
    public PstViewSptpdSimda(int i) throws DBException {
        super(new PstViewSptpdSimda());
    }
    
    public PstViewSptpdSimda(String sOid) throws DBException {
        super(new PstViewSptpdSimda(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstViewSptpdSimda(long lOid) throws DBException {
        super(new PstViewSptpdSimda(0));
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
        return TBL_VIEWSPTPDSIMDA;
    }

      public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }
    @Override
    public String getPersistentName() {
        return new PstViewSptpdSimda().getClass().getName();
    }

    
    public static ViewSptpdSimda fetchExc(long oid) throws DBException {
        try {
            ViewSptpdSimda entViewSptpdSimda = new ViewSptpdSimda();
            PstViewSptpdSimda pstViewSptpdSimda = new PstViewSptpdSimda(oid);
            entViewSptpdSimda.setOID(oid);
            entViewSptpdSimda.setNoSptpd(pstViewSptpdSimda.getString(FLD_NO_SPTPD));
            entViewSptpdSimda.setNoSspd(pstViewSptpdSimda.getString(FLD_NO_SSPD));
            entViewSptpdSimda.setNpwdp(pstViewSptpdSimda.getString(FLD_NPWPD));
            entViewSptpdSimda.setMasaPajak(pstViewSptpdSimda.getString(FLD_MASA_PAJAK));
            entViewSptpdSimda.setTahunPajak(pstViewSptpdSimda.getString(FLD_TAHUN_PAJAK));
            entViewSptpdSimda.setKodePajak(pstViewSptpdSimda.getString(FLD_KODE_PAJAK));
            entViewSptpdSimda.setNoRekening(pstViewSptpdSimda.getString(FLD_NO_REKENING));
            entViewSptpdSimda.setNoSubrekening(pstViewSptpdSimda.getString(FLD_NO_SUBREKENING));
            entViewSptpdSimda.setTarif(pstViewSptpdSimda.getdouble(FLD_TARIF));
            entViewSptpdSimda.setOmzet(pstViewSptpdSimda.getdouble(FLD_OMZET));
            entViewSptpdSimda.setPajak(pstViewSptpdSimda.getdouble(FLD_PAJAK));
            
            entViewSptpdSimda.setServiceTax(pstViewSptpdSimda.getdouble(FLD_SERVICE_TAX));
            entViewSptpdSimda.setDenda(pstViewSptpdSimda.getdouble(FLD_DENDA)); 
            entViewSptpdSimda.setPengurangan(pstViewSptpdSimda.getdouble(FLD_PENGURANGAN));
            entViewSptpdSimda.setHarusDibayar(pstViewSptpdSimda.getdouble(FLD_HARUS_DIBAYAR));
            entViewSptpdSimda.setTglRekam(pstViewSptpdSimda.getDate(FLD_TGL_REKAM));
           
            return entViewSptpdSimda;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstViewSptpdSimda(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        ViewSptpdSimda entViewSptpdSimda = fetchExc(entity.getOID());
        entity = (Entity) entViewSptpdSimda;
        return entViewSptpdSimda.getOID();
    }
    
    public static synchronized long updateExc(ViewSptpdSimda entViewSptpdSimda) throws DBException {
        try {
            if (entViewSptpdSimda.getOID() != 0) {
                
                PstViewSptpdSimda pstViewSptpdSimda = new PstViewSptpdSimda(entViewSptpdSimda.getOID());
                pstViewSptpdSimda.setString(FLD_NO_SPTPD, entViewSptpdSimda.getNoSptpd());
                pstViewSptpdSimda.setString(FLD_NO_SSPD, entViewSptpdSimda.getNoSspd());
                pstViewSptpdSimda.setString(FLD_NPWPD, entViewSptpdSimda.getNpwdp());
                pstViewSptpdSimda.setString(FLD_MASA_PAJAK, entViewSptpdSimda.getMasaPajak());
                pstViewSptpdSimda.setString(FLD_TAHUN_PAJAK, entViewSptpdSimda.getTahunPajak());
                pstViewSptpdSimda.setString(FLD_KODE_PAJAK,entViewSptpdSimda.getKodePajak());
                pstViewSptpdSimda.setString(FLD_NO_REKENING, entViewSptpdSimda.getNoRekening());
                pstViewSptpdSimda.setString(FLD_NO_SUBREKENING, entViewSptpdSimda.getNoSubrekening());
                pstViewSptpdSimda.setDouble(FLD_TARIF, entViewSptpdSimda.getTarif());
                pstViewSptpdSimda.setDouble(FLD_OMZET, entViewSptpdSimda.getOmzet());
                pstViewSptpdSimda.setDouble(FLD_PAJAK, entViewSptpdSimda.getPajak());
                
                pstViewSptpdSimda.setDouble(FLD_SERVICE_TAX, entViewSptpdSimda.getServiceTax());
                pstViewSptpdSimda.setDouble(FLD_DENDA, entViewSptpdSimda.getDenda());
                pstViewSptpdSimda.setDouble(FLD_PENGURANGAN, entViewSptpdSimda.getPengurangan());
                pstViewSptpdSimda.setDouble(FLD_HARUS_DIBAYAR, entViewSptpdSimda.getHarusDibayar());
                pstViewSptpdSimda.setDate(FLD_TGL_REKAM, entViewSptpdSimda.getTglRekam());
                
                pstViewSptpdSimda.update();
                
                return entViewSptpdSimda.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstViewSptpdSimda(0), DBException.UNKNOWN);
        }
        return 0;
    }

    
    @Override
    public long updateExc(Entity entity) throws Exception {
        return updateExc((ViewSptpdSimda) entity);
    }
    
    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstViewSptpdSimda pstViewSptpdSimda = new PstViewSptpdSimda(oid);
            pstViewSptpdSimda.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstViewSptpdSimda(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity ent) throws Exception {
        if (ent == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(ent.getOID());
    }
    
    public static synchronized long insertExc(ViewSptpdSimda entViewSptpdSimda) throws DBException {
        try {
            
            PstViewSptpdSimda pstViewSptpdSimda = new PstViewSptpdSimda(0);
            pstViewSptpdSimda.setString(FLD_NO_SPTPD, entViewSptpdSimda.getNoSptpd());
            pstViewSptpdSimda.setString(FLD_NO_SSPD, entViewSptpdSimda.getNoSspd());
            pstViewSptpdSimda.setString(FLD_NPWPD, entViewSptpdSimda.getNpwdp());
            pstViewSptpdSimda.setString(FLD_MASA_PAJAK, entViewSptpdSimda.getMasaPajak());
            pstViewSptpdSimda.setString(FLD_TAHUN_PAJAK, entViewSptpdSimda.getTahunPajak());
            pstViewSptpdSimda.setString(FLD_KODE_PAJAK, entViewSptpdSimda.getKodePajak());
            pstViewSptpdSimda.setString(FLD_NO_REKENING, entViewSptpdSimda.getNoRekening());
            pstViewSptpdSimda.setString(FLD_NO_SUBREKENING, entViewSptpdSimda.getNoSubrekening());
            pstViewSptpdSimda.setDouble(FLD_TARIF, entViewSptpdSimda.getTarif());
            pstViewSptpdSimda.setDouble(FLD_OMZET, entViewSptpdSimda.getOmzet());
            pstViewSptpdSimda.setDouble(FLD_PAJAK, entViewSptpdSimda.getPajak());
            
            pstViewSptpdSimda.setDouble(FLD_SERVICE_TAX, entViewSptpdSimda.getServiceTax());
            pstViewSptpdSimda.setDouble(FLD_DENDA, entViewSptpdSimda.getDenda());
            pstViewSptpdSimda.setDouble(FLD_PENGURANGAN, entViewSptpdSimda.getPengurangan());
            pstViewSptpdSimda.setDouble(FLD_HARUS_DIBAYAR, entViewSptpdSimda.getHarusDibayar());
            pstViewSptpdSimda.setDate(FLD_TGL_REKAM, entViewSptpdSimda.getTglRekam());
            
            
            pstViewSptpdSimda.insert();
            //entViewSptpdSimda.setOID(pstViewSptpdSimda.getlong(FLD_VIEWSPTPDSIMDAID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstViewSptpdSimda(0), DBException.UNKNOWN);
        }
        return entViewSptpdSimda.getOID();
    }
    
    public long insertExc(Entity entity) throws Exception {
        return insertExc((ViewSptpdSimda) entity);
    }
    
    public static void resultToObject(ResultSet rs, ViewSptpdSimda entViewSptpdSimda) {
        
        try {
            
           // entViewSptpdSimda.setOID(rs.getLong(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_VIEWSPTPDSIMDAID]));
            entViewSptpdSimda.setNoSptpd(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NO_SPTPD]));
            entViewSptpdSimda.setNoSspd(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NO_SSPD]));
            entViewSptpdSimda.setNpwdp(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NPWPD]));
            entViewSptpdSimda.setMasaPajak(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_MASA_PAJAK]));
            entViewSptpdSimda.setTahunPajak(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_TAHUN_PAJAK]));
            entViewSptpdSimda.setKodePajak(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_KODE_PAJAK]));
            entViewSptpdSimda.setNoRekening(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NO_REKENING]));
            entViewSptpdSimda.setNoSubrekening(rs.getString(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NO_SUBREKENING]));
            entViewSptpdSimda.setTarif(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_TARIF]));
            entViewSptpdSimda.setOmzet(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_OMZET]));
            entViewSptpdSimda.setPajak(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_PAJAK]));
           
            
            entViewSptpdSimda.setServiceTax(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_SERVICE_TAX]));
            entViewSptpdSimda.setDenda(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_DENDA]));
            entViewSptpdSimda.setPengurangan(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_PENGURANGAN]));
            entViewSptpdSimda.setHarusDibayar(rs.getDouble(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_HARUS_DIBAYAR]));
            entViewSptpdSimda.setTglRekam(rs.getDate(PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_TGL_REKAM]));
            
            
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
            String sql = "SELECT * FROM " + TBL_VIEWSPTPDSIMDA;
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
                ViewSptpdSimda entViewSptpdSimda = new ViewSptpdSimda();
                resultToObject(rs, entViewSptpdSimda);
                lists.add(entViewSptpdSimda);
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

    public static boolean checkOID(long entViewSptpdSimdaId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_VIEWSPTPDSIMDA + " WHERE "
                    + PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NO_SPTPD] + " = " + entViewSptpdSimdaId;
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
            String sql = "SELECT COUNT(" + PstViewSptpdSimda.fieldNames[PstViewSptpdSimda.FLD_NO_SPTPD] + ") FROM " + TBL_VIEWSPTPDSIMDA;
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
                    ViewSptpdSimda entViewSptpdSimda = (ViewSptpdSimda) list.get(ls);
                    if (oid == entViewSptpdSimda.getOID()) {
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
    
