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
public class PstPajakType extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_PAJAKTYPE = "bi_pajak_type";
    public static final int FLD_PAJAK_TYPE_ID = 0;
    public static final int FLD_PAJAK_NAME = 1;
    
    //HARDCODE PAJAK TYPE
    public static final int PHR = 1;
    public static final int BPHTB = 2;
    public static final int RETRIBUSI = 3;
    public static final int PBB = 4;
    
    
    public static String[] fieldNames = {
        "PAJAK_TYPE_ID",
        "PAJAK_NAME"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING
    };
    
    
    public static final String TBL_PAJAK_PHR = "PHR";
    public static final String TBL_PAJAK_PBB = "PBB";
    public static final String TBL_PAJAK_BPHTB = "BPHTB";
    public static final String TBL_PAJAK_RETRIBUSI = "Retribusi";
    
    public PstPajakType() {
    }

    public PstPajakType(int i) throws DBException {
        super(new PstPajakType());
    }

    public PstPajakType(String sOid) throws DBException {
        super(new PstPajakType(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPajakType(long lOid) throws DBException {
        super(new PstPajakType(0));
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
        return TBL_PAJAKTYPE;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPajakType().getClass().getName();
    }

    public static PajakType fetchExc(long oid) throws DBException {
        try {
            PajakType entPajakType = new PajakType();
            PstPajakType pstPajakType = new PstPajakType(oid);
            entPajakType.setOID(oid);
            entPajakType.setPajakTypeName(pstPajakType.getString(FLD_PAJAK_NAME));
            return entPajakType;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakType(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        PajakType entPajakType = fetchExc(entity.getOID());
        entity = (Entity) entPajakType;
        return entPajakType.getOID();
    }

    public static synchronized long updateExc(PajakType entPajakType) throws DBException {
        try {
            if (entPajakType.getOID() != 0) {
                PstPajakType pstPajakType = new PstPajakType(entPajakType.getOID());
                pstPajakType.setString(FLD_PAJAK_NAME, entPajakType.getPajakTypeName());
                pstPajakType.update();
                return entPajakType.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakType(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((PajakType) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPajakType pstPajakType = new PstPajakType(oid);
            pstPajakType.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakType(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }

        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(PajakType entPajakType) throws DBException {
        try {
            PstPajakType pstPajakType = new PstPajakType(0);
            pstPajakType.setString(FLD_PAJAK_NAME, entPajakType.getPajakTypeName());
            pstPajakType.insert();
            entPajakType.setOID(pstPajakType.getLong(FLD_PAJAK_TYPE_ID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPajakType(0), DBException.UNKNOWN);
        }
        return entPajakType.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((PajakType) entity);
    }

    public static void resultToObject(ResultSet rs, PajakType entPajakType) {
        try {
            entPajakType.setOID(rs.getLong(PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID]));
            entPajakType.setPajakTypeName(rs.getString(PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_NAME]));
        } catch (Exception e) {
        }
    }

    public static Vector listAll() {
        return list(0, 0, "", "");
    }

    public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM " + TBL_PAJAKTYPE;
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
                PajakType entPajakType = new PajakType();
                resultToObject(rs, entPajakType);
                lists.add(entPajakType);
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

    public static boolean checkOID(long entPajakTypeId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_PAJAKTYPE + " WHERE "
                    + PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID] + " = " + entPajakTypeId;
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
    
    
    public static PajakType checkPajakTypeWithTypeDetailID(long entPajakTypeDetailId) {
        DBResultSet dbrs = null;
        PajakType pajakType = null;
        try {
            
//            String sql = "SELECT * FROM " + TBL_PAJAKTYPE + " WHERE "
//                    + PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID] + " = " + entPajakTypeId;
            
            String sql = " SELECT pt.* FROM bi_pajak_type pt "+
                         " INNER JOIN bi_pajak_type_detail pdi "+
                         " ON pdi.PAJAK_TYPE_ID=pt.PAJAK_TYPE_ID "+
                         " WHERE pdi.PAJAK_DETAIL_ID='"+entPajakTypeDetailId+"'";
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                pajakType = new PajakType();
                resultToObject(rs, pajakType);
            }
            rs.close();
            return pajakType;
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return pajakType;
        }
    }

    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstPajakType.fieldNames[PstPajakType.FLD_PAJAK_TYPE_ID] + ") FROM " + TBL_PAJAKTYPE;
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
                    PajakType entPajakType = (PajakType) list.get(ls);
                    if (oid == entPajakType.getOID()) {
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
