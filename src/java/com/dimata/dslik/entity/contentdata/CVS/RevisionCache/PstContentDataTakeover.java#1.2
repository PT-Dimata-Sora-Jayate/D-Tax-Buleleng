/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.entity.contentdata;

import java.sql.*;
import com.dimata.util.lang.I_Language;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import java.util.Vector;

/**
 *
 * @author Dewa
 */
public class PstContentDataTakeover extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_CONTENT_DATA_TAKEOVER = "dslik_cd_takeover";
    public static final int FLD_TAKEOVER_OID = 0;
    public static final int FLD_NAMA_TAKEOVER = 1;
    public static final int FLD_KODE_CORE_BANKING = 2;
    public static final int FLD_KODE_OJK = 3;

    public static String[] fieldNames = {
        "TAKEOVER_OID",
        "NAMA_TAKEOVER",
        "KODE_CORE_BANKING",
        "KODE_OJK"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING
    };

    public PstContentDataTakeover() {
    }

    public PstContentDataTakeover(int i) throws DBException {
        super(new PstContentDataTakeover());
    }

    public PstContentDataTakeover(String sOid) throws DBException {
        super(new PstContentDataTakeover(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstContentDataTakeover(long lOid) throws DBException {
        super(new PstContentDataTakeover(0));
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
        return TBL_CONTENT_DATA_TAKEOVER;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstContentDataTakeover().getClass().getName();
    }

    public static ContentDataTakeover fetchExc(long oid) throws DBException {
        try {
            ContentDataTakeover entContentDataTakeover = new ContentDataTakeover();
            PstContentDataTakeover pstContentDataTakeover = new PstContentDataTakeover(oid);
            entContentDataTakeover.setOID(oid);
            entContentDataTakeover.setNamaTakeover(pstContentDataTakeover.getString(FLD_NAMA_TAKEOVER));
            entContentDataTakeover.setKodeCoreBanking(pstContentDataTakeover.getString(FLD_KODE_CORE_BANKING));
            entContentDataTakeover.setKodeOjk(pstContentDataTakeover.getString(FLD_KODE_OJK));
            return entContentDataTakeover;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstContentDataTakeover(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        ContentDataTakeover entContentDataTakeover = fetchExc(entity.getOID());
        entity = (Entity) entContentDataTakeover;
        return entContentDataTakeover.getOID();
    }

    public static synchronized long updateExc(ContentDataTakeover entContentDataTakeover) throws DBException {
        try {
            if (entContentDataTakeover.getOID() != 0) {
                PstContentDataTakeover pstContentDataTakeover = new PstContentDataTakeover(entContentDataTakeover.getOID());
                pstContentDataTakeover.setString(FLD_NAMA_TAKEOVER, entContentDataTakeover.getNamaTakeover());
                pstContentDataTakeover.setString(FLD_KODE_CORE_BANKING, entContentDataTakeover.getKodeCoreBanking());
                pstContentDataTakeover.setString(FLD_KODE_OJK, entContentDataTakeover.getKodeOjk());
                pstContentDataTakeover.update();
                return entContentDataTakeover.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstContentDataTakeover(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((ContentDataTakeover) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstContentDataTakeover pstContentDataTakeover = new PstContentDataTakeover(oid);
            pstContentDataTakeover.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstContentDataTakeover(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(ContentDataTakeover entContentDataTakeover) throws DBException {
        try {
            PstContentDataTakeover pstContentDataTakeover = new PstContentDataTakeover(0);
            pstContentDataTakeover.setString(FLD_NAMA_TAKEOVER, entContentDataTakeover.getNamaTakeover());
            pstContentDataTakeover.setString(FLD_KODE_CORE_BANKING, entContentDataTakeover.getKodeCoreBanking());
            pstContentDataTakeover.setString(FLD_KODE_OJK, entContentDataTakeover.getKodeOjk());
            pstContentDataTakeover.insert();
            entContentDataTakeover.setOID(pstContentDataTakeover.getlong(FLD_TAKEOVER_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstContentDataTakeover(0), DBException.UNKNOWN);
        }
        return entContentDataTakeover.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((ContentDataTakeover) entity);
    }

    public static void resultToObject(ResultSet rs, ContentDataTakeover entContentDataTakeover) {
        try {
            entContentDataTakeover.setOID(rs.getLong(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_TAKEOVER_OID]));
            entContentDataTakeover.setNamaTakeover(rs.getString(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_NAMA_TAKEOVER]));
            entContentDataTakeover.setKodeCoreBanking(rs.getString(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_KODE_CORE_BANKING]));
            entContentDataTakeover.setKodeOjk(rs.getString(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_KODE_OJK]));
        } catch (Exception e) {
        }
    }
    
    public static void resultToObjectWithoutOid(ResultSet rs, ContentDataTakeover entContentDataTakeover) {
        try {
            entContentDataTakeover.setNamaTakeover(rs.getString(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_NAMA_TAKEOVER]));
            entContentDataTakeover.setKodeOjk(rs.getString(PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_KODE_OJK]));
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
            String sql = "SELECT * FROM " + TBL_CONTENT_DATA_TAKEOVER;
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
                ContentDataTakeover entContentDataTakeover = new ContentDataTakeover();
                resultToObject(rs, entContentDataTakeover);
                lists.add(entContentDataTakeover);
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
    
    public static Vector listWithoutOid(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT "+fieldNames[FLD_KODE_OJK]+","
                    + fieldNames[FLD_NAMA_TAKEOVER]+" "
                    + "FROM " + TBL_CONTENT_DATA_TAKEOVER;
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
                ContentDataTakeover entContentDataTakeover = new ContentDataTakeover();
                resultToObjectWithoutOid(rs, entContentDataTakeover);
                lists.add(entContentDataTakeover);
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

    public static boolean checkOID(long entContentDataTakeoverId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_CONTENT_DATA_TAKEOVER + " WHERE "
                    + PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_TAKEOVER_OID] + " = " + entContentDataTakeoverId;
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
            String sql = "SELECT COUNT(" + PstContentDataTakeover.fieldNames[PstContentDataTakeover.FLD_TAKEOVER_OID] + ") FROM " + TBL_CONTENT_DATA_TAKEOVER;
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
                    ContentDataTakeover entContentDataTakeover = (ContentDataTakeover) list.get(ls);
                    if (oid == entContentDataTakeover.getOID()) {
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
