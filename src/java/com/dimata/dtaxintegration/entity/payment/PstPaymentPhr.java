/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.payment;

/**
 *
 * @author dimata005
 */
import java.sql.*;
import com.dimata.util.lang.I_Language;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import java.util.Vector;

public class PstPaymentPhr extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_PAYMENTPHR = "PEMBAYARAN_SIMPATDA_BANK";
    public static final int FLD_PAYMENTID = 0;
    public static final int FLD_NPWD = 1;
    public static final int FLD_MASAPAJAK = 2;
    public static final int FLD_TAHUNPAJAK = 3;
    public static final int FLD_JUMLAHBAYAR = 4;
    public static final int FLD_NAMA = 5;
    public static final int FLD_BIAYAADMINISTRASI = 6;
    public static final int FLD_TANGGAL = 7;
    public static final int FLD_IDPAYMENT = 8;
    public static final int FLD_STATUS = 9;
    public static final int FLD_POKOK = 10;
    public static final int FLD_DENDA = 11;
    public static final int FLD_TGL_REKAM = 12;
    public static final int FLD_ID_REKAM = 13;
    public static final int FLD_ID_KEY = 14;
    public static String[] fieldNames = {
        "ID_PHR",
        "NPWPD",
        "MASA_PAJAK",
        "TAHUN_PAJAK",
        "JUMLAH",
        "NAMA_PENYETOR",
        "BIAYA_ADMINISTRASI",
        "TGL_SSPD",
        "ID_PAYMENT_BANK",
        "STATUS_REVERSAL",
        "POKOK",
        "DENDA",
        "TGL_REKAM",
        "ID_REKAM",
        "ID_KEY"
    };
    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING
    };

    public PstPaymentPhr() {
    }

    public PstPaymentPhr(int i) throws DBException {
        super(new PstPaymentPhr());
    }

    public PstPaymentPhr(String sOid) throws DBException {
        super(new PstPaymentPhr(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPaymentPhr(long lOid) throws DBException {
        super(new PstPaymentPhr(0));
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
        return TBL_PAYMENTPHR;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPaymentPhr().getClass().getName();
    }

    public static PaymentPhr fetchExc(long oid) throws DBException {
        try {
            PaymentPhr entPaymentPhr = new PaymentPhr();
            PstPaymentPhr pstPaymentPhr = new PstPaymentPhr(oid);
            entPaymentPhr.setOID(oid);
            entPaymentPhr.setNpwpd(pstPaymentPhr.getString(FLD_NPWD));
            entPaymentPhr.setMasaPajak(pstPaymentPhr.getString(FLD_MASAPAJAK));
            entPaymentPhr.setTahunPajak(pstPaymentPhr.getString(FLD_TAHUNPAJAK));
            entPaymentPhr.setJumlahBayar(pstPaymentPhr.getdouble(FLD_JUMLAHBAYAR));
            entPaymentPhr.setNama(pstPaymentPhr.getString(FLD_NAMA));
            entPaymentPhr.setBiayaAdministrasi(pstPaymentPhr.getdouble(FLD_BIAYAADMINISTRASI));
            entPaymentPhr.setTanggal(pstPaymentPhr.getDate(FLD_TANGGAL));
            entPaymentPhr.setIdPayment(pstPaymentPhr.getString(FLD_IDPAYMENT));
            entPaymentPhr.setStatus(pstPaymentPhr.getString(FLD_STATUS));
            
            entPaymentPhr.setDenda(pstPaymentPhr.getdouble(FLD_DENDA));
            entPaymentPhr.setPokok(pstPaymentPhr.getdouble(FLD_POKOK));
            entPaymentPhr.setTglRekam(pstPaymentPhr.getDate(FLD_TGL_REKAM));
            entPaymentPhr.setIdRekam(pstPaymentPhr.getString(FLD_ID_REKAM));
            entPaymentPhr.setIdKey(pstPaymentPhr.getString(FLD_ID_KEY));
            
            return entPaymentPhr;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhr(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        PaymentPhr entPaymentPhr = fetchExc(entity.getOID());
        entity = (Entity) entPaymentPhr;
        return entPaymentPhr.getOID();
    }

    public static synchronized long updateExc(PaymentPhr entPaymentPhr) throws DBException {
        try {
            if (entPaymentPhr.getOID() != 0) {
                PstPaymentPhr pstPaymentPhr = new PstPaymentPhr(entPaymentPhr.getOID());
                //pstPaymentPhr.setString(FLD_NOSSPD, entPaymentPhr.getNoSspd());
                pstPaymentPhr.setString(FLD_NPWD, entPaymentPhr.getNpwpd());
                pstPaymentPhr.setString(FLD_MASAPAJAK, entPaymentPhr.getMasaPajak());
                pstPaymentPhr.setString(FLD_TAHUNPAJAK, entPaymentPhr.getTahunPajak());
                pstPaymentPhr.setDouble(FLD_JUMLAHBAYAR, entPaymentPhr.getJumlahBayar());
                pstPaymentPhr.setString(FLD_NAMA, entPaymentPhr.getNama());
                pstPaymentPhr.setDouble(FLD_BIAYAADMINISTRASI, entPaymentPhr.getBiayaAdministrasi());
                pstPaymentPhr.setDate(FLD_TANGGAL, entPaymentPhr.getTanggal());
                pstPaymentPhr.setString(FLD_IDPAYMENT, entPaymentPhr.getIdPayment());
                pstPaymentPhr.setString(FLD_STATUS, entPaymentPhr.getStatus());
                
                pstPaymentPhr.setDouble(FLD_POKOK, entPaymentPhr.getPokok());
                pstPaymentPhr.setDouble(FLD_DENDA, entPaymentPhr.getDenda());
                pstPaymentPhr.setString(FLD_ID_REKAM, entPaymentPhr.getIdRekam());
                pstPaymentPhr.setDate(FLD_TGL_REKAM, entPaymentPhr.getTglRekam());
                pstPaymentPhr.setString(FLD_ID_KEY, entPaymentPhr.getIdKey());
                
                pstPaymentPhr.update();
                return entPaymentPhr.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhr(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((PaymentPhr) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPaymentPhr pstPaymentPhr = new PstPaymentPhr(oid);
            pstPaymentPhr.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhr(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(PaymentPhr entPaymentPhr) throws DBException {
        try {
            PstPaymentPhr pstPaymentPhr = new PstPaymentPhr(0);
            //pstPaymentPhr.setString(FLD_NOSSPD, entPaymentPhr.getNoSspd());
            pstPaymentPhr.setString(FLD_NPWD, entPaymentPhr.getNpwpd());
            pstPaymentPhr.setString(FLD_MASAPAJAK, entPaymentPhr.getMasaPajak());
            pstPaymentPhr.setString(FLD_TAHUNPAJAK, entPaymentPhr.getTahunPajak());
            pstPaymentPhr.setDouble(FLD_JUMLAHBAYAR, entPaymentPhr.getJumlahBayar());
            pstPaymentPhr.setString(FLD_NAMA, entPaymentPhr.getNama());
            pstPaymentPhr.setDouble(FLD_BIAYAADMINISTRASI, entPaymentPhr.getBiayaAdministrasi());
            pstPaymentPhr.setDate(FLD_TANGGAL, entPaymentPhr.getTanggal());
            pstPaymentPhr.setString(FLD_IDPAYMENT, entPaymentPhr.getIdPayment());
            pstPaymentPhr.setString(FLD_STATUS, entPaymentPhr.getStatus());
            
            //pstPaymentPhr.setString(FLD_BULAN, entPaymentPhr.getBulan());
            
            pstPaymentPhr.setDouble(FLD_POKOK, entPaymentPhr.getPokok());
            pstPaymentPhr.setDouble(FLD_DENDA, entPaymentPhr.getDenda());
            pstPaymentPhr.setString(FLD_ID_REKAM, entPaymentPhr.getIdRekam());
            pstPaymentPhr.setDate(FLD_TGL_REKAM, entPaymentPhr.getTglRekam());
            pstPaymentPhr.setString(FLD_ID_KEY, entPaymentPhr.getIdKey());
            pstPaymentPhr.insert();
            entPaymentPhr.setOID(pstPaymentPhr.getlong(FLD_PAYMENTID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhr(0), DBException.UNKNOWN);
        }
        return entPaymentPhr.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((PaymentPhr) entity);
    }

    public static void resultToObject(ResultSet rs, PaymentPhr entPaymentPhr) {
        try {
            entPaymentPhr.setOID(rs.getLong(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_PAYMENTID]));
            entPaymentPhr.setNpwpd(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_NPWD]));
            entPaymentPhr.setMasaPajak(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_MASAPAJAK]));
            entPaymentPhr.setTahunPajak(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TAHUNPAJAK]));
            entPaymentPhr.setJumlahBayar(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_JUMLAHBAYAR]));
            entPaymentPhr.setNama(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_NAMA]));
            entPaymentPhr.setBiayaAdministrasi(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_BIAYAADMINISTRASI]));
            entPaymentPhr.setTanggal(rs.getDate(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]));
            entPaymentPhr.setIdPayment(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_IDPAYMENT]));
            entPaymentPhr.setStatus(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS]));
            
            //entPaymentPhr.setBulan(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_BULAN]));
            entPaymentPhr.setPokok(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_POKOK]));
            entPaymentPhr.setDenda(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_DENDA]));
            entPaymentPhr.setTglRekam(rs.getDate(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TGL_REKAM]));
            entPaymentPhr.setIdRekam(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_ID_REKAM]));
            entPaymentPhr.setIdKey(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_ID_KEY]));
            
        } catch (Exception e) {
        }
    }
    
    
    public static void resultToObjectJoin(ResultSet rs, PaymentPhr entPaymentPhr) {
        try {
            entPaymentPhr.setOID(rs.getLong(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_PAYMENTID]));
            entPaymentPhr.setNpwpd(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_NPWD]));
            entPaymentPhr.setMasaPajak(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_MASAPAJAK]));
            entPaymentPhr.setTahunPajak(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TAHUNPAJAK]));
            entPaymentPhr.setJumlahBayar(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_JUMLAHBAYAR]));
            entPaymentPhr.setNama(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_NAMA]));
            entPaymentPhr.setBiayaAdministrasi(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_BIAYAADMINISTRASI]));
            entPaymentPhr.setTanggal(rs.getDate(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]));
            entPaymentPhr.setIdPayment(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_IDPAYMENT]));
            entPaymentPhr.setStatus(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_STATUS]));
            
            //entPaymentPhr.setBulan(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_BULAN]));
            entPaymentPhr.setPokok(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_POKOK]));
            entPaymentPhr.setDenda(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_DENDA]));
            entPaymentPhr.setTglRekam(rs.getDate(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TGL_REKAM]));
            entPaymentPhr.setIdRekam(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_ID_REKAM]));
            entPaymentPhr.setIdKey(rs.getString(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_ID_KEY]));
            entPaymentPhr.setAlamat(rs.getString("ALAMAT"));
        } catch (Exception e) {
        }
    }
    
    
    public static void resultToObjectHarian(ResultSet rs, PaymentPhr entPaymentPhr) {
        try {
            entPaymentPhr.setJumlahBayar(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_JUMLAHBAYAR]));
            entPaymentPhr.setTanggal(rs.getDate(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_TANGGAL]));
            entPaymentPhr.setPokok(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_POKOK]));
            entPaymentPhr.setDenda(rs.getDouble(PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_DENDA]));
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
            String sql = "SELECT * FROM " + TBL_PAYMENTPHR;
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
                PaymentPhr entPaymentPhr = new PaymentPhr();
                resultToObject(rs, entPaymentPhr);
                lists.add(entPaymentPhr);
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
    
    
    public static Vector listSum(int limitStart, int recordToGet, String whereClause, String order, String groupBy) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT SUM("+fieldNames[FLD_POKOK]+") "+fieldNames[FLD_POKOK]+", "
                    + "SUM("+fieldNames[FLD_DENDA]+") "+fieldNames[FLD_DENDA]+", "
                    + "SUM("+fieldNames[FLD_JUMLAHBAYAR]+") "+fieldNames[FLD_JUMLAHBAYAR]+", "
                    + fieldNames[FLD_TANGGAL]+" FROM " + TBL_PAYMENTPHR;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            
            if(groupBy != null && groupBy.length() > 0){
                sql = sql + " GROUP BY "+ groupBy;
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
                PaymentPhr entPaymentPhr = new PaymentPhr();
                resultToObjectHarian(rs, entPaymentPhr);
                lists.add(entPaymentPhr);
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
    
     public static Vector listInnerJoin(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = " SELECT DISTINCT psb.*, vs.ALAMAT FROM " + TBL_PAYMENTPHR+" psb "+
                         " INNER JOIN VIEW_ALL_SIMPATDA vs ON psb.NPWPD = vs.ID and psb.MASA_PAJAK = vs.MASA_PAJAK ";
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
                PaymentPhr entPaymentPhr = new PaymentPhr();
                resultToObjectJoin(rs, entPaymentPhr);
                lists.add(entPaymentPhr);
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
    
    public static Vector listSum(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            //String sql = "SELECT * FROM " + TBL_PAYMENTPHR;
            String sql = " SELECT SUBSTR(NPWPD, 0, 1) NPWPD, SUM(POKOK) POKOK, SUM(DENDA) DENDA, SUM(JUMLAH) JUMLAH FROM "+TBL_PAYMENTPHR;

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
                PaymentPhr entPaymentPhr = new PaymentPhr();
                entPaymentPhr.setNpwpd(rs.getString("NPWPD"));
                entPaymentPhr.setPokok(rs.getDouble("POKOK"));
                entPaymentPhr.setDenda(rs.getDouble("DENDA"));
                entPaymentPhr.setJumlahBayar(rs.getDouble("JUMLAH"));
                lists.add(entPaymentPhr);
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

    public static boolean checkOID(long entPaymentPhrId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_PAYMENTPHR + " WHERE "
                    + PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_PAYMENTID] + " = " + entPaymentPhrId;
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
            String sql = "SELECT COUNT(" + PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_PAYMENTID] + ") FROM " + TBL_PAYMENTPHR;
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
                    PaymentPhr entPaymentPhr = (PaymentPhr) list.get(ls);
                    if (oid == entPaymentPhr.getOID()) {
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
