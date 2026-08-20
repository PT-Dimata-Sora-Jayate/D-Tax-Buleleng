/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.bi;

import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.qdep.db.I_DBInterface;
import com.dimata.qdep.db.I_DBType;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;
import com.dimata.util.Command;
import com.dimata.util.lang.I_Language;
import com.dimata.webclient.AppSetting;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Ardiadi
 */
public class PstDataTarget extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_DATATARGET = "bi_data_target";
    public static final int FLD_TARGET_ID = 0;
    public static final int FLD_PAJAK_DETAIL_ID = 1;
    public static final int FLD_BULAN = 2;
    public static final int FLD_TAHUN_SUMBER = 3;
    public static final int FLD_JUMLAH = 4;
    public static final int FLD_KENAIKAN = 5;
    public static final int FLD_TAHUN_TARGET = 6;

    public static String[] fieldNames = {
        "TARGET_ID",
        "PAJAK_DETAIL_ID",
        "BULAN",
        "TAHUN_SUMBER",
        "JUMLAH",
        "KENAIKAN",
        "TAHUN_TARGET"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_LONG,
        TYPE_INT,
        TYPE_INT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_INT
    };

    public PstDataTarget() {
    }

    public PstDataTarget(int i) throws DBException {
        super(new PstDataTarget());
    }

    public PstDataTarget(String sOid) throws DBException {
        super(new PstDataTarget(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstDataTarget(long lOid) throws DBException {
        super(new PstDataTarget(0));
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
        return TBL_DATATARGET;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstDataTarget().getClass().getName();
    }

    public static DataTarget fetchExc(long oid) throws DBException {
        try {
            DataTarget entDataTarget = new DataTarget();
            PstDataTarget pstDataTarget = new PstDataTarget(oid);
            entDataTarget.setOID(oid);
            entDataTarget.setPajakDetailId(pstDataTarget.getlong(FLD_PAJAK_DETAIL_ID));
            entDataTarget.setBulan(pstDataTarget.getInt(FLD_BULAN));
            entDataTarget.setTahunSumber(pstDataTarget.getInt(FLD_TAHUN_SUMBER));
            entDataTarget.setJumlah(pstDataTarget.getdouble(FLD_JUMLAH));
            entDataTarget.setKenaikan(pstDataTarget.getdouble(FLD_KENAIKAN));
            entDataTarget.setTahunTarget(pstDataTarget.getInt(FLD_TAHUN_TARGET));
            return entDataTarget;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDataTarget(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        DataTarget entDataTarget = fetchExc(entity.getOID());
        entity = (Entity) entDataTarget;
        return entDataTarget.getOID();
    }

    public static synchronized long updateExc(DataTarget entDataTarget) throws DBException {
        try {
            if (entDataTarget.getOID() != 0) {
                PstDataTarget pstDataTarget = new PstDataTarget(entDataTarget.getOID());
                pstDataTarget.setLong(FLD_PAJAK_DETAIL_ID, entDataTarget.getPajakDetailId());
                pstDataTarget.setInt(FLD_BULAN, entDataTarget.getBulan());
                pstDataTarget.setInt(FLD_TAHUN_SUMBER, entDataTarget.getTahunSumber());
                pstDataTarget.setDouble(FLD_JUMLAH, entDataTarget.getJumlah());
                pstDataTarget.setDouble(FLD_KENAIKAN, entDataTarget.getKenaikan());
                pstDataTarget.setInt(FLD_TAHUN_TARGET, entDataTarget.getTahunTarget());
                pstDataTarget.update();
                return entDataTarget.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDataTarget(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((DataTarget) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstDataTarget pstDataTarget = new PstDataTarget(oid);
            pstDataTarget.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDataTarget(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(DataTarget entDataTarget) throws DBException {
        try {
            PstDataTarget pstDataTarget = new PstDataTarget(0);
            pstDataTarget.setLong(FLD_PAJAK_DETAIL_ID, entDataTarget.getPajakDetailId());
            pstDataTarget.setInt(FLD_BULAN, entDataTarget.getBulan());
            pstDataTarget.setInt(FLD_TAHUN_SUMBER, entDataTarget.getTahunSumber());
            pstDataTarget.setDouble(FLD_JUMLAH, entDataTarget.getJumlah());
            pstDataTarget.setDouble(FLD_KENAIKAN, entDataTarget.getKenaikan());
            pstDataTarget.setInt(FLD_TAHUN_TARGET, entDataTarget.getTahunTarget());
            pstDataTarget.insert();
            entDataTarget.setOID(pstDataTarget.getlong(FLD_TARGET_ID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDataTarget(0), DBException.UNKNOWN);
        }
        return entDataTarget.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((DataTarget) entity);
    }

    public static void resultToObject(ResultSet rs, DataTarget entDataTarget) {
        try {
            entDataTarget.setOID(rs.getLong(PstDataTarget.fieldNames[PstDataTarget.FLD_TARGET_ID]));
            entDataTarget.setPajakDetailId(rs.getLong(PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID]));
            entDataTarget.setBulan(rs.getInt(PstDataTarget.fieldNames[PstDataTarget.FLD_BULAN]));
            entDataTarget.setTahunSumber(rs.getInt(PstDataTarget.fieldNames[PstDataTarget.FLD_TAHUN_SUMBER]));
            entDataTarget.setJumlah(rs.getDouble(PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH]));
            entDataTarget.setKenaikan(rs.getDouble(PstDataTarget.fieldNames[PstDataTarget.FLD_KENAIKAN]));
            entDataTarget.setTahunTarget(rs.getInt(PstDataTarget.fieldNames[PstDataTarget.FLD_TAHUN_TARGET]));
        } catch (Exception e) {
        }
    }

    public static void resultToObjectPerJenisPajak(ResultSet rs, DataTarget entDataTarget) {
        try {

            entDataTarget.setJumlah(rs.getDouble(PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH]));
            entDataTarget.setPajakName(rs.getString(PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_NAME]));
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
            String sql = "SELECT * FROM " + TBL_DATATARGET;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
//            if (limitStart == 0 && recordToGet == 0) {
//                sql = sql + "";
//            } else {
//                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
//            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                DataTarget entDataTarget = new DataTarget();
                resultToObject(rs, entDataTarget);
                lists.add(entDataTarget);
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

    public static double getTotalTarget(int limitStart, int recordToGet, String whereClause, String order) {
        double lists = 0;
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT SUM(" + fieldNames[FLD_JUMLAH] + ") " + fieldNames[FLD_JUMLAH] + " FROM " + TBL_DATATARGET;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
//            if (limitStart == 0 && recordToGet == 0) {
//                sql = sql + "";
//            } else {
//                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
//            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                lists = rs.getDouble(fieldNames[FLD_JUMLAH]);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return 0;
    }

    public static double getTotalTargetPerPajakType(int limitStart, int recordToGet, String whereClause, String order) {
        double lists = 0;
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT SUM(target." + fieldNames[FLD_JUMLAH] + ")" + fieldNames[FLD_JUMLAH] + " "
                    + "FROM " + TBL_DATATARGET + " target "
                    + "INNER JOIN " + PstPajakTypeDetail.TBL_PAJAKTYPEDETAIL + " pajakDetail "
                    + "ON target." + PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID] + "=pajakDetail." + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID];
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            
            if(AppSetting.SQL_VERSION==AppSetting.DBSVR_ORACLE){
                sql = sql + "";
            }else{
                if (limitStart == 0 && recordToGet == 0) {
                    sql = sql + "";
                } else {
                    sql = sql + " LIMIT " + limitStart + "," + recordToGet;
                }
            }
            
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                lists = rs.getDouble(fieldNames[FLD_JUMLAH]);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return 0;
    }

    public static double getTotalKenaikanPerPajakType(int limitStart, int recordToGet, String whereClause, String order) {
        double lists = 0;
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT SUM(target." + fieldNames[FLD_KENAIKAN] + ") " + fieldNames[FLD_KENAIKAN] + " "
                    + "FROM " + TBL_DATATARGET + " target "
                    + "INNER JOIN " + PstPajakTypeDetail.TBL_PAJAKTYPEDETAIL + " pajakDetail "
                    + "ON target." + PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID] + "=pajakDetail." + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID];
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
                lists = rs.getDouble(fieldNames[FLD_KENAIKAN]);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return 0;
    }

    public static Vector listPerJenisPajak(int limitStart, int recordToGet, String whereClause, String order, String groupby) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT pajakType." + PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_NAME] + ", ";
            
            if(AppSetting.SQL_VERSION==AppSetting.DBSVR_ORACLE){
                sql=sql+"(CASE WHEN SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + ") > 0 THEN SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + ") ELSE 0 END) " + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + " ";
            }else{
                sql=sql+"IF(SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + ") > 0,SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + "),0) " + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + " ";
            }
            
            sql=sql+ "FROM " + PstPajakType.TBL_PAJAKTYPE + "  pajakType "
                    + "INNER JOIN " + PstPajakTypeDetail.TBL_PAJAKTYPEDETAIL + "  pajakDetail "
                    + "ON pajakType." + PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID] + "=pajakDetail." + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID] + " "
                    + "LEFT JOIN " + PstDataTarget.TBL_DATATARGET + " target "
                    + "ON pajakDetail." + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID] + "=target." + PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID];

            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (groupby != null && groupby.length() > 0) {
                sql = sql + " GROUP BY " + groupby;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            if(AppSetting.SQL_VERSION==AppSetting.DBSVR_ORACLE){
                sql = sql + "";
            }else{
                if (limitStart == 0 && recordToGet == 0) {
                    sql = sql + "";
                } else {
                    sql = sql + " LIMIT " + limitStart + "," + recordToGet;
                }
            }
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                DataTarget entDataTarget = new DataTarget();
                resultToObjectPerJenisPajak(rs, entDataTarget);
                lists.add(entDataTarget);
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
    
    public static Vector listPerJenisPajak(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT";
            
            if(AppSetting.SQL_VERSION==AppSetting.DBSVR_ORACLE){
                sql=sql+"(CASE WHEN SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + ") > 0 THEN SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + ") ELSE 0 END) " + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + " ";
            }else{
                sql=sql+"IF(SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + ") > 0,SUM(target." + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + "),0) " + PstDataTarget.fieldNames[PstDataTarget.FLD_JUMLAH] + " ";
            }
            
            sql=sql+ "FROM " + PstPajakType.TBL_PAJAKTYPE + "  pajakType "
                    + "INNER JOIN " + PstPajakTypeDetail.TBL_PAJAKTYPEDETAIL + "  pajakDetail "
                    + "ON pajakType." + PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID] + "=pajakDetail." + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID] + " "
                    + "LEFT JOIN " + PstDataTarget.TBL_DATATARGET + " target "
                    + "ON pajakDetail." + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID] + "=target." + PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID];

            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            if(AppSetting.SQL_VERSION==AppSetting.DBSVR_ORACLE){
                sql = sql + "";
            }else{
                if (limitStart == 0 && recordToGet == 0) {
                    sql = sql + "";
                } else {
                    sql = sql + " LIMIT " + limitStart + "," + recordToGet;
                }
            }
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                DataTarget entDataTarget = new DataTarget();
                resultToObjectPerJenisPajak(rs, entDataTarget);
                lists.add(entDataTarget);
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

    public static Vector listTargetBasedOnTarget(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM " + TBL_DATATARGET;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
//            if (limitStart == 0 && recordToGet == 0) {
//                sql = sql + "";
//            } else {
//                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
//            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                DataTarget entDataTarget = new DataTarget();
                resultToObject(rs, entDataTarget);
                lists.add(entDataTarget);
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

    public static boolean checkOID(long entDataTargetId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_DATATARGET + " WHERE "
                    + PstDataTarget.fieldNames[PstDataTarget.FLD_TARGET_ID] + " = " + entDataTargetId;
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
            String sql = "SELECT COUNT(" + PstDataTarget.fieldNames[PstDataTarget.FLD_TARGET_ID] + ") FROM " + TBL_DATATARGET;
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
                    DataTarget entDataTarget = (DataTarget) list.get(ls);
                    if (oid == entDataTarget.getOID()) {
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
