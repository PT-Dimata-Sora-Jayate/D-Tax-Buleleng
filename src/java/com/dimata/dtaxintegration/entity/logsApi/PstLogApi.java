package com.dimata.dtaxintegration.entity.logsApi;

 
import java.sql.*;
import com.dimata.util.lang.I_Language;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import java.util.Vector;

public class PstLogApi extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_LOG_API = "LOGS_API";
    public static final int FLD_OID_API = 0;
    public static final int FLD_API_NAME = 1;
    public static final int FLD_MODUL_NAME = 2;
    public static final int FLD_REQ_DATE = 3;
    public static final int FLD_STATUS = 4;
    public static final int FLD_MESSAGE = 5;

    public static String[] fieldNames = {
        "OID_API",
        "API_NAME",
        "MODUL_NAME",
        "REQ_DATE",
        "STATUS",
        "MESSAGE"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING
    };

    public PstLogApi() {
    }

    public PstLogApi(int i) throws DBException {
        super(new PstLogApi());
    }

    public PstLogApi(String sOid) throws DBException {
        super(new PstLogApi(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstLogApi(long lOid) throws DBException {
        super(new PstLogApi(0));
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
        return TBL_LOG_API;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstLogApi().getClass().getName();
    }

    public static LogApi fetchExc(long oid) throws DBException {
        try {
            LogApi entLogApi = new LogApi();
            PstLogApi pstLogApi = new PstLogApi(oid);
            entLogApi.setOID(oid);
            entLogApi.setApiName(pstLogApi.getString(FLD_API_NAME));
            entLogApi.setModulName(pstLogApi.getString(FLD_MODUL_NAME));
            entLogApi.setReqDate(pstLogApi.getDate(FLD_REQ_DATE));
            entLogApi.setStatus(pstLogApi.getString(FLD_STATUS));
            entLogApi.setMessage(pstLogApi.getString(FLD_MESSAGE));
            return entLogApi;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstLogApi(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        LogApi entLogApi = fetchExc(entity.getOID());
        entity = (Entity) entLogApi;
        return entLogApi.getOID();
    }

    public static synchronized long updateExc(LogApi entLogApi) throws DBException {
        try {
            if (entLogApi.getOID() != 0) {
                PstLogApi pstLogApi = new PstLogApi(entLogApi.getOID());
                pstLogApi.setString(FLD_API_NAME, entLogApi.getApiName());
                pstLogApi.setString(FLD_MODUL_NAME, entLogApi.getModulName());
                pstLogApi.setDate(FLD_REQ_DATE, entLogApi.getReqDate());
                pstLogApi.setString(FLD_STATUS, entLogApi.getStatus());
                pstLogApi.setString(FLD_MESSAGE, entLogApi.getMessage());
                pstLogApi.update();
                return entLogApi.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstLogApi(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((LogApi) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstLogApi pstLogApi = new PstLogApi(oid);
            pstLogApi.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstLogApi(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(LogApi entLogApi) throws DBException {
        try {
            PstLogApi pstLogApi = new PstLogApi(0);
            pstLogApi.setString(FLD_API_NAME, entLogApi.getApiName());
            pstLogApi.setString(FLD_MODUL_NAME, entLogApi.getModulName());
            pstLogApi.setDate(FLD_REQ_DATE, entLogApi.getReqDate());
            pstLogApi.setString(FLD_STATUS, entLogApi.getStatus());
            pstLogApi.setString(FLD_MESSAGE, entLogApi.getMessage());
            pstLogApi.insert();
            entLogApi.setOID(pstLogApi.getlong(FLD_OID_API));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstLogApi(0), DBException.UNKNOWN);
        }
        return entLogApi.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((LogApi) entity);
    }

    public static void resultToObject(ResultSet rs, LogApi entLogApi) {
        try {
            entLogApi.setOID(rs.getLong(PstLogApi.fieldNames[PstLogApi.FLD_OID_API]));
            entLogApi.setApiName(rs.getString(PstLogApi.fieldNames[PstLogApi.FLD_API_NAME]));
            entLogApi.setModulName(rs.getString(PstLogApi.fieldNames[PstLogApi.FLD_MODUL_NAME]));
            entLogApi.setReqDate(rs.getDate(PstLogApi.fieldNames[PstLogApi.FLD_REQ_DATE]));
            entLogApi.setStatus(rs.getString(PstLogApi.fieldNames[PstLogApi.FLD_STATUS]));
            entLogApi.setMessage(rs.getString(PstLogApi.fieldNames[PstLogApi.FLD_MESSAGE]));
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
            String sql = "SELECT * FROM " + TBL_LOG_API;
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
                LogApi entLogApi = new LogApi();
                resultToObject(rs, entLogApi);
                lists.add(entLogApi);
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

    public static boolean checkOID(long entLogApiId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_LOG_API + " WHERE "
                    + PstLogApi.fieldNames[PstLogApi.FLD_OID_API] + " = " + entLogApiId;
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
            String sql = "SELECT COUNT(" + PstLogApi.fieldNames[PstLogApi.FLD_OID_API] + ") FROM " + TBL_LOG_API;
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
                    LogApi entLogApi = (LogApi) list.get(ls);
                    if (oid == entLogApi.getOID()) {
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
    
    public String resBpdApi(String res){
        String status = "";
        
        switch (res){
            case "00": status = "Sukses"; break;
            case "01": status = "Sukses"; break;
            case "02": status = "Tidak Memiliki Wewenang Fungsi"; break;
            case "03": status = "Data Tagihan Kosong atau Tidak Ditemukan"; break;
            case "05": status = "Tidak Memiliki Wewenang Akses Instansi"; break;
            case "06": status = "Transaksi Tidak Dapat Dilakukan"; break;
            case "09": status = "Update Data Payment Master Gagal"; break;
            case "11": status = "Proses Upload Data Tidak Diijinkan Pada Jam Operasional Bank"; break;
            case "12": status = "Update Data Payment Master Reversal Gagal"; break;
            case "13": status = "Proses Payment Tagihan Gagal / Commit Gagal"; break;
            case "14": status = "Rekening VA Sudah Ada"; break;
            case "15": status = "Insert Data Payment Master Log Gagal"; break;
            case "16": status = "Insert Data Payment Master Gagal"; break;
            case "17": status = "Proses Insert Gagal / Commit Gagal"; break;
            case "18": status = "Upload Bulk Gagal"; break;
            case "99": status = "Error Exception"; break;
        }
        
        return status;
    }
    
    public boolean setLogApiBpd(String apiName,String msg,String modul,String status){
        boolean res = false;
        LogApi entApi = new LogApi();
        try {
            entApi.setApiName(apiName);
            entApi.setReqDate(new java.util.Date());
            entApi.setMessage(msg);
            entApi.setModulName(modul);
            entApi.setStatus(resBpdApi(status));

            insertExc(entApi);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}   
