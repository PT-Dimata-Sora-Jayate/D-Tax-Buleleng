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
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Ardiadi
 */
public class PstPajakTypeDetail extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_PAJAKTYPEDETAIL = "bi_pajak_type_detail";
    public static final int FLD_PAJAK_DETAIL_ID = 0;
    public static final int FLD_PAJAK_TYPE_ID = 1;
    public static final int FLD_PAJAK_DETAIL_NAME = 2;
    public static final int FLD_PAJAK_QUERY = 3;
    public static final int FLD_PAJAK_QUERY_COLOMN_DATE = 4;
    
    
    public static final int PHR_HOTEL = 1;
    public static final int PHR_RESTO = 2;
    public static final int PHR_ABT = 3;
    public static final int PHR_PENERANGAN = 4;
    

    public static String[] fieldNames = {
        "PAJAK_DETAIL_ID",
        "PAJAK_TYPE_ID",
        "PAJAK_DETAIL_NAME",
        "PAJAK_QUERY",
        "PAJAK_QUERY_COLOMN_DATE"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_LONG,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING
    };

    public PstPajakTypeDetail() {
    }

    public PstPajakTypeDetail(int i) throws DBException {
        super(new PstPajakTypeDetail());
    }

    public PstPajakTypeDetail(String sOid) throws DBException {
        super(new PstPajakTypeDetail(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPajakTypeDetail(long lOid) throws DBException {
        super(new PstPajakTypeDetail(0));
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
        return TBL_PAJAKTYPEDETAIL;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPajakTypeDetail().getClass().getName();
    }

    public static PajakTypeDetail fetchExc(long oid) throws DBException {
        try {

            PajakTypeDetail entPajakTypeDetail = new PajakTypeDetail();
            PstPajakTypeDetail pstPajakTypeDetail = new PstPajakTypeDetail(oid);
            entPajakTypeDetail.setOID(oid);
            entPajakTypeDetail.setPajakTypeId(pstPajakTypeDetail.getlong(FLD_PAJAK_TYPE_ID));
            entPajakTypeDetail.setPajakDetailName(pstPajakTypeDetail.getString(FLD_PAJAK_DETAIL_NAME));
            entPajakTypeDetail.setPajakQuery(pstPajakTypeDetail.getString(FLD_PAJAK_QUERY));
            entPajakTypeDetail.setColomDate(pstPajakTypeDetail.getString(FLD_PAJAK_QUERY_COLOMN_DATE));

            return entPajakTypeDetail;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakTypeDetail(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        PajakTypeDetail entPajakTypeDetail = fetchExc(entity.getOID());
        entity = (Entity) entPajakTypeDetail;
        return entPajakTypeDetail.getOID();
    }

    public static synchronized long updateExc(PajakTypeDetail entPajakTypeDetail) throws DBException {
        try {
            if (entPajakTypeDetail.getOID() != 0) {

                PstPajakTypeDetail pstPajakTypeDetail = new PstPajakTypeDetail(entPajakTypeDetail.getOID());
                pstPajakTypeDetail.setLong(FLD_PAJAK_TYPE_ID, entPajakTypeDetail.getPajakTypeId());
                pstPajakTypeDetail.setString(FLD_PAJAK_DETAIL_NAME, entPajakTypeDetail.getPajakDetailName());
                pstPajakTypeDetail.setString(FLD_PAJAK_QUERY, entPajakTypeDetail.getPajakQuery());
                pstPajakTypeDetail.setString(FLD_PAJAK_QUERY_COLOMN_DATE, entPajakTypeDetail.getColomDate());
                pstPajakTypeDetail.update();
                return entPajakTypeDetail.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakTypeDetail(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((PajakTypeDetail) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPajakTypeDetail pstPajakTypeDetail = new PstPajakTypeDetail(oid);
            pstPajakTypeDetail.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakTypeDetail(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(PajakTypeDetail entPajakTypeDetail) throws DBException {
        try {
            PstPajakTypeDetail pstPajakTypeDetail = new PstPajakTypeDetail(0);
            pstPajakTypeDetail.setLong(FLD_PAJAK_TYPE_ID, entPajakTypeDetail.getPajakTypeId());
            pstPajakTypeDetail.setString(FLD_PAJAK_DETAIL_NAME, entPajakTypeDetail.getPajakDetailName());
            pstPajakTypeDetail.setString(FLD_PAJAK_QUERY, entPajakTypeDetail.getPajakQuery());
            pstPajakTypeDetail.setString(FLD_PAJAK_QUERY_COLOMN_DATE, entPajakTypeDetail.getColomDate());

            pstPajakTypeDetail.insert();
            entPajakTypeDetail.setOID(pstPajakTypeDetail.getLong(FLD_PAJAK_DETAIL_ID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakTypeDetail(0), DBException.UNKNOWN);
        }
        return entPajakTypeDetail.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((PajakTypeDetail) entity);
    }

    public static void resultToObject(ResultSet rs, PajakTypeDetail entPajakTypeDetail) {
        try {
            
            entPajakTypeDetail.setOID(rs.getLong(PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID]));
            entPajakTypeDetail.setPajakTypeId(rs.getLong(PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_TYPE_ID]));
            entPajakTypeDetail.setPajakDetailName(rs.getString(PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_NAME]));
            entPajakTypeDetail.setPajakQuery(rs.getString(PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_QUERY]));
            entPajakTypeDetail.setColomDate(rs.getString(PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_QUERY_COLOMN_DATE]));
            
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
            String sql = "SELECT * FROM " + TBL_PAJAKTYPEDETAIL;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            /*if (limitStart == 0 && recordToGet == 0) {
                sql = sql + "";
            } else {
                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }*/
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                PajakTypeDetail entPajakTypeDetail = new PajakTypeDetail();
                resultToObject(rs, entPajakTypeDetail);
                lists.add(entPajakTypeDetail);
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
    
    public static Vector listJoin(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT pajakDetail.* FROM " + TBL_PAJAKTYPEDETAIL +" pajakDetail "
		    + "INNER JOIN "+PstPajakType.TBL_PAJAKTYPE+" pajakType "
		    + "ON pajakDetail."+fieldNames[FLD_PAJAK_TYPE_ID]+"=pajakType."+PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID];
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
                PajakTypeDetail entPajakTypeDetail = new PajakTypeDetail();
                resultToObject(rs, entPajakTypeDetail);
                lists.add(entPajakTypeDetail);
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

    public static boolean checkOID(long entPajakTypeDetailId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_PAJAKTYPEDETAIL + " WHERE "
                    + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID] + " = " + entPajakTypeDetailId;
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
            String sql = "SELECT COUNT(" + PstPajakTypeDetail.fieldNames[PstPajakTypeDetail.FLD_PAJAK_DETAIL_ID] + ") FROM " + TBL_PAJAKTYPEDETAIL;
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
                    PajakTypeDetail entPajakTypeDetail = (PajakTypeDetail) list.get(ls);
                    if (oid == entPajakTypeDetail.getOID()) {
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
