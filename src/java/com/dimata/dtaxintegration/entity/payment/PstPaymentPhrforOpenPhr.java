/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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

public class PstPaymentPhrforOpenPhr extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_PAYMENTPHRFOROPENPHR = "integrasi_pembayaran_phr_bank";
    public static final int FLD_PEMBAYARANID = 0;
    public static final int FLD_IDBANK = 1;
    public static final int FLD_INSTANSI = 2;
    public static final int FLD_NOID = 3;
    public static final int FLD_NAMA = 4;
    public static final int FLD_TAGIHAN = 5;
    public static final int FLD_KETTAGIHAN = 6;
    public static final int FLD_TAGIHANLAIN = 7;
    public static final int FLD_BIAYAADM = 8;
    public static final int FLD_ALAMAT = 9;
    public static final int FLD_BULAN = 10;
    public static final int FLD_TAHUN = 11;
    public static final int FLD_POKOK = 12;
    public static final int FLD_DENDA = 13;
    public static final int FLD_KETERANGAN = 14;
    public static final int FLD_NPWPD = 15;
    public static final int FLD_TANGGALAWAL = 16;
    public static final int FLD_TANGGALAKHIR = 17;
    public static final int FLD_VALENTRY = 18;
    public static final int FLD_TGLTRANSAKSI = 19;
    public static final int FLD_STATUSBAYAR = 20;
    public static final int FLD_KDCAB = 21;
    public static final int FLD_KDUSER = 22;
    public static final int FLD_STATUSREVERSAL = 23;

    public static String[] fieldNames = {
        "PEMBAYARAN_ID",
        "ID_BANK",
        "INSTANSI",
        "NO_ID",
        "NAMA",
        "TAGIHAN",
        "KET_TAGIHAN",
        "TAGIHAN_LAIN",
        "BIAYA_ADM",
        "ALAMAT",
        "BULAN",
        "TAHUN",
        "POKOK",
        "DENDA",
        "KETERANGAN",
        "NPWPD",
        "TANGGAL_AWAL",
        "TANGGAL_AKHIR",
        "VAL_ENTRI_1_TAGIHAN_LAIN",
        "TGL_TX",
        "STS_BAYAR",
        "KD_CAB",
        "KD_USER",
        "STS_REVERSAL"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_INT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_INT
    };

    public PstPaymentPhrforOpenPhr() {
    }

    public PstPaymentPhrforOpenPhr(int i) throws DBException {
        super(new PstPaymentPhrforOpenPhr());
    }

    public PstPaymentPhrforOpenPhr(String sOid) throws DBException {
        super(new PstPaymentPhrforOpenPhr(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPaymentPhrforOpenPhr(long lOid) throws DBException {
        super(new PstPaymentPhrforOpenPhr(0));
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
        return TBL_PAYMENTPHRFOROPENPHR;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPaymentPhrforOpenPhr().getClass().getName();
    }

    public static PaymentPhrforOpenPhr fetchExc(long oid) throws DBException {
        try {
            PaymentPhrforOpenPhr entPaymentPhrforOpenPhr = new PaymentPhrforOpenPhr();
            PstPaymentPhrforOpenPhr pstPaymentPhrforOpenPhr = new PstPaymentPhrforOpenPhr(oid);
            entPaymentPhrforOpenPhr.setOID(oid);
            entPaymentPhrforOpenPhr.setIdBank(pstPaymentPhrforOpenPhr.getString(FLD_IDBANK));
            entPaymentPhrforOpenPhr.setInstansi(pstPaymentPhrforOpenPhr.getString(FLD_INSTANSI));
            entPaymentPhrforOpenPhr.setNoId(pstPaymentPhrforOpenPhr.getString(FLD_NOID));
            entPaymentPhrforOpenPhr.setNama(pstPaymentPhrforOpenPhr.getString(FLD_NAMA));
            entPaymentPhrforOpenPhr.setTagihan(pstPaymentPhrforOpenPhr.getdouble(FLD_TAGIHAN));
            entPaymentPhrforOpenPhr.setKetTagihan(pstPaymentPhrforOpenPhr.getString(FLD_KETTAGIHAN));
            entPaymentPhrforOpenPhr.setTagihanLain(pstPaymentPhrforOpenPhr.getdouble(FLD_TAGIHANLAIN));
            entPaymentPhrforOpenPhr.setBiayaAdm(pstPaymentPhrforOpenPhr.getdouble(FLD_BIAYAADM));
            entPaymentPhrforOpenPhr.setAlamat(pstPaymentPhrforOpenPhr.getString(FLD_ALAMAT));
            entPaymentPhrforOpenPhr.setBulan(pstPaymentPhrforOpenPhr.getString(FLD_BULAN));
            entPaymentPhrforOpenPhr.setTahun(pstPaymentPhrforOpenPhr.getString(FLD_TAHUN));
            entPaymentPhrforOpenPhr.setPokok(pstPaymentPhrforOpenPhr.getdouble(FLD_POKOK));
            entPaymentPhrforOpenPhr.setDenda(pstPaymentPhrforOpenPhr.getdouble(FLD_DENDA));
            entPaymentPhrforOpenPhr.setKeterangan(pstPaymentPhrforOpenPhr.getString(FLD_KETERANGAN));
            entPaymentPhrforOpenPhr.setNpwpd(pstPaymentPhrforOpenPhr.getString(FLD_NPWPD));
            entPaymentPhrforOpenPhr.setTanggalAwal(pstPaymentPhrforOpenPhr.getDate(FLD_TANGGALAWAL));
            entPaymentPhrforOpenPhr.setTanggalAkhir(pstPaymentPhrforOpenPhr.getDate(FLD_TANGGALAKHIR));
            entPaymentPhrforOpenPhr.setValEntry(pstPaymentPhrforOpenPhr.getdouble(FLD_VALENTRY));
            entPaymentPhrforOpenPhr.setTglTransaksi(pstPaymentPhrforOpenPhr.getDate(FLD_TGLTRANSAKSI));
            entPaymentPhrforOpenPhr.setStatusBayar(pstPaymentPhrforOpenPhr.getInt(FLD_STATUSBAYAR));
            entPaymentPhrforOpenPhr.setKdCab(pstPaymentPhrforOpenPhr.getString(FLD_KDCAB));
            entPaymentPhrforOpenPhr.setKdUser(pstPaymentPhrforOpenPhr.getString(FLD_KDUSER));
            entPaymentPhrforOpenPhr.setStatusReversal(pstPaymentPhrforOpenPhr.getInt(FLD_STATUSREVERSAL));
            return entPaymentPhrforOpenPhr;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhrforOpenPhr(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        PaymentPhrforOpenPhr entPaymentPhrforOpenPhr = fetchExc(entity.getOID());
        entity = (Entity) entPaymentPhrforOpenPhr;
        return entPaymentPhrforOpenPhr.getOID();
    }

    public static synchronized long updateExc(PaymentPhrforOpenPhr entPaymentPhrforOpenPhr) throws DBException {
        try {
            if (entPaymentPhrforOpenPhr.getOID() != 0) {
                PstPaymentPhrforOpenPhr pstPaymentPhrforOpenPhr = new PstPaymentPhrforOpenPhr(entPaymentPhrforOpenPhr.getOID());
                pstPaymentPhrforOpenPhr.setString(FLD_IDBANK, entPaymentPhrforOpenPhr.getIdBank());
                pstPaymentPhrforOpenPhr.setString(FLD_INSTANSI, entPaymentPhrforOpenPhr.getInstansi());
                pstPaymentPhrforOpenPhr.setString(FLD_NOID, entPaymentPhrforOpenPhr.getNoId());
                pstPaymentPhrforOpenPhr.setString(FLD_NAMA, entPaymentPhrforOpenPhr.getNama());
                pstPaymentPhrforOpenPhr.setDouble(FLD_TAGIHAN, entPaymentPhrforOpenPhr.getTagihan());
                pstPaymentPhrforOpenPhr.setString(FLD_KETTAGIHAN, entPaymentPhrforOpenPhr.getKetTagihan());
                pstPaymentPhrforOpenPhr.setDouble(FLD_TAGIHANLAIN, entPaymentPhrforOpenPhr.getTagihanLain());
                pstPaymentPhrforOpenPhr.setDouble(FLD_BIAYAADM, entPaymentPhrforOpenPhr.getBiayaAdm());
                pstPaymentPhrforOpenPhr.setString(FLD_ALAMAT, entPaymentPhrforOpenPhr.getAlamat());
                pstPaymentPhrforOpenPhr.setString(FLD_BULAN, entPaymentPhrforOpenPhr.getBulan());
                pstPaymentPhrforOpenPhr.setString(FLD_TAHUN, entPaymentPhrforOpenPhr.getTahun());
                pstPaymentPhrforOpenPhr.setDouble(FLD_POKOK, entPaymentPhrforOpenPhr.getPokok());
                pstPaymentPhrforOpenPhr.setDouble(FLD_DENDA, entPaymentPhrforOpenPhr.getDenda());
                pstPaymentPhrforOpenPhr.setString(FLD_KETERANGAN, entPaymentPhrforOpenPhr.getKeterangan());
                pstPaymentPhrforOpenPhr.setString(FLD_NPWPD, entPaymentPhrforOpenPhr.getNpwpd());
                pstPaymentPhrforOpenPhr.setDate(FLD_TANGGALAWAL, entPaymentPhrforOpenPhr.getTanggalAwal());
                pstPaymentPhrforOpenPhr.setDate(FLD_TANGGALAKHIR, entPaymentPhrforOpenPhr.getTanggalAkhir());
                pstPaymentPhrforOpenPhr.setDouble(FLD_VALENTRY, entPaymentPhrforOpenPhr.getValEntry());
                pstPaymentPhrforOpenPhr.setDate(FLD_TGLTRANSAKSI, entPaymentPhrforOpenPhr.getTglTransaksi());
                pstPaymentPhrforOpenPhr.setInt(FLD_STATUSBAYAR, entPaymentPhrforOpenPhr.getStatusBayar());
                pstPaymentPhrforOpenPhr.setString(FLD_KDCAB, entPaymentPhrforOpenPhr.getKdCab());
                pstPaymentPhrforOpenPhr.setString(FLD_KDUSER, entPaymentPhrforOpenPhr.getKdUser());
                pstPaymentPhrforOpenPhr.setInt(FLD_STATUSREVERSAL, entPaymentPhrforOpenPhr.getStatusReversal());
                pstPaymentPhrforOpenPhr.update();
                return entPaymentPhrforOpenPhr.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhrforOpenPhr(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((PaymentPhrforOpenPhr) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPaymentPhrforOpenPhr pstPaymentPhrforOpenPhr = new PstPaymentPhrforOpenPhr(oid);
            pstPaymentPhrforOpenPhr.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhrforOpenPhr(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(PaymentPhrforOpenPhr entPaymentPhrforOpenPhr) throws DBException {
        try {
            PstPaymentPhrforOpenPhr pstPaymentPhrforOpenPhr = new PstPaymentPhrforOpenPhr(0);
            pstPaymentPhrforOpenPhr.setString(FLD_IDBANK, entPaymentPhrforOpenPhr.getIdBank());
            pstPaymentPhrforOpenPhr.setString(FLD_INSTANSI, entPaymentPhrforOpenPhr.getInstansi());
            pstPaymentPhrforOpenPhr.setString(FLD_NOID, entPaymentPhrforOpenPhr.getNoId());
            pstPaymentPhrforOpenPhr.setString(FLD_NAMA, entPaymentPhrforOpenPhr.getNama());
            pstPaymentPhrforOpenPhr.setDouble(FLD_TAGIHAN, entPaymentPhrforOpenPhr.getTagihan());
            pstPaymentPhrforOpenPhr.setString(FLD_KETTAGIHAN, entPaymentPhrforOpenPhr.getKetTagihan());
            pstPaymentPhrforOpenPhr.setDouble(FLD_TAGIHANLAIN, entPaymentPhrforOpenPhr.getTagihanLain());
            pstPaymentPhrforOpenPhr.setDouble(FLD_BIAYAADM, entPaymentPhrforOpenPhr.getBiayaAdm());
            pstPaymentPhrforOpenPhr.setString(FLD_ALAMAT, entPaymentPhrforOpenPhr.getAlamat());
            pstPaymentPhrforOpenPhr.setString(FLD_BULAN, entPaymentPhrforOpenPhr.getBulan());
            pstPaymentPhrforOpenPhr.setString(FLD_TAHUN, entPaymentPhrforOpenPhr.getTahun());
            pstPaymentPhrforOpenPhr.setDouble(FLD_POKOK, entPaymentPhrforOpenPhr.getPokok());
            pstPaymentPhrforOpenPhr.setDouble(FLD_DENDA, entPaymentPhrforOpenPhr.getDenda());
            pstPaymentPhrforOpenPhr.setString(FLD_KETERANGAN, entPaymentPhrforOpenPhr.getKeterangan());
            pstPaymentPhrforOpenPhr.setString(FLD_NPWPD, entPaymentPhrforOpenPhr.getNpwpd());
            pstPaymentPhrforOpenPhr.setDate(FLD_TANGGALAWAL, entPaymentPhrforOpenPhr.getTanggalAwal());
            pstPaymentPhrforOpenPhr.setDate(FLD_TANGGALAKHIR, entPaymentPhrforOpenPhr.getTanggalAkhir());
            pstPaymentPhrforOpenPhr.setDouble(FLD_VALENTRY, entPaymentPhrforOpenPhr.getValEntry());
            pstPaymentPhrforOpenPhr.setDate(FLD_TGLTRANSAKSI, entPaymentPhrforOpenPhr.getTglTransaksi());
            pstPaymentPhrforOpenPhr.setInt(FLD_STATUSBAYAR, entPaymentPhrforOpenPhr.getStatusBayar());
            pstPaymentPhrforOpenPhr.setString(FLD_KDCAB, entPaymentPhrforOpenPhr.getKdCab());
            pstPaymentPhrforOpenPhr.setString(FLD_KDUSER, entPaymentPhrforOpenPhr.getKdUser());
            pstPaymentPhrforOpenPhr.setInt(FLD_STATUSREVERSAL, entPaymentPhrforOpenPhr.getStatusReversal());
            pstPaymentPhrforOpenPhr.insert();
            entPaymentPhrforOpenPhr.setOID(pstPaymentPhrforOpenPhr.getlong(FLD_PEMBAYARANID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPhrforOpenPhr(0), DBException.UNKNOWN);
        }
        return entPaymentPhrforOpenPhr.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((PaymentPhrforOpenPhr) entity);
    }

    public static void resultToObject(ResultSet rs, PaymentPhrforOpenPhr entPaymentPhrforOpenPhr) {
        try {
            entPaymentPhrforOpenPhr.setOID(rs.getLong(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_PEMBAYARANID]));
            entPaymentPhrforOpenPhr.setIdBank(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_IDBANK]));
            entPaymentPhrforOpenPhr.setInstansi(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_INSTANSI]));
            entPaymentPhrforOpenPhr.setNoId(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_NOID]));
            entPaymentPhrforOpenPhr.setNama(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_NAMA]));
            entPaymentPhrforOpenPhr.setTagihan(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TAGIHAN]));
            entPaymentPhrforOpenPhr.setKetTagihan(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_KETTAGIHAN]));
            entPaymentPhrforOpenPhr.setTagihanLain(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TAGIHANLAIN]));
            entPaymentPhrforOpenPhr.setBiayaAdm(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_BIAYAADM]));
            entPaymentPhrforOpenPhr.setAlamat(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_ALAMAT]));
            entPaymentPhrforOpenPhr.setBulan(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_BULAN]));
            entPaymentPhrforOpenPhr.setTahun(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TAHUN]));
            entPaymentPhrforOpenPhr.setPokok(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_POKOK]));
            entPaymentPhrforOpenPhr.setDenda(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_DENDA]));
            entPaymentPhrforOpenPhr.setKeterangan(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_KETERANGAN]));
            entPaymentPhrforOpenPhr.setNpwpd(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_NPWPD]));
            entPaymentPhrforOpenPhr.setTanggalAwal(rs.getDate(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TANGGALAWAL]));
            entPaymentPhrforOpenPhr.setTanggalAkhir(rs.getDate(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TANGGALAKHIR]));
            entPaymentPhrforOpenPhr.setValEntry(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_VALENTRY]));
            entPaymentPhrforOpenPhr.setTglTransaksi(rs.getDate(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TGLTRANSAKSI]));
            entPaymentPhrforOpenPhr.setStatusBayar(rs.getInt(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_STATUSBAYAR]));
            entPaymentPhrforOpenPhr.setKdCab(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_KDCAB]));
            entPaymentPhrforOpenPhr.setKdUser(rs.getString(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_KDUSER]));
            entPaymentPhrforOpenPhr.setStatusReversal(rs.getInt(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_STATUSREVERSAL]));
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
            String sql = "SELECT * FROM " + TBL_PAYMENTPHRFOROPENPHR;
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
                PaymentPhrforOpenPhr entPaymentPhrforOpenPhr = new PaymentPhrforOpenPhr();
                resultToObject(rs, entPaymentPhrforOpenPhr);
                lists.add(entPaymentPhrforOpenPhr);
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

    public static boolean checkOID(long entPaymentPhrforOpenPhrId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_PAYMENTPHRFOROPENPHR + " WHERE "
                    + PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_PEMBAYARANID] + " = " + entPaymentPhrforOpenPhrId;
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
            String sql = "SELECT COUNT(" + PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_PEMBAYARANID] + ") FROM " + TBL_PAYMENTPHRFOROPENPHR;
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
                    PaymentPhrforOpenPhr entPaymentPhrforOpenPhr = (PaymentPhrforOpenPhr) list.get(ls);
                    if (oid == entPaymentPhrforOpenPhr.getOID()) {
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
        } else if (start == (vectSize - recordToGet)) {
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
        return cmd;
    }
    
    
    public static Vector list2(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM " + TBL_PAYMENTPHRFOROPENPHR;
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
                entPaymentPhr.setMasaPajak(rs.getString("BULAN"));
                entPaymentPhr.setTahunPajak(rs.getString("TAHUN"));
                entPaymentPhr.setJumlahBayar(rs.getDouble("TAGIHAN"));
                entPaymentPhr.setNama(rs.getString("NAMA"));
                entPaymentPhr.setBiayaAdministrasi(rs.getDouble("BIAYA_ADM"));
                entPaymentPhr.setTanggal(rs.getDate("TGL_TX"));
                entPaymentPhr.setIdPayment(rs.getString("ID_BANK"));
                entPaymentPhr.setStatus(rs.getString("STS_REVERSAL"));
                entPaymentPhr.setPokok(rs.getDouble("POKOK"));
                entPaymentPhr.setDenda(rs.getDouble("DENDA"));
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
                    + "SUM("+fieldNames[FLD_TAGIHAN]+") "+fieldNames[FLD_TAGIHAN]+", "
                    + fieldNames[FLD_TGLTRANSAKSI]+" FROM " + TBL_PAYMENTPHRFOROPENPHR;
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
                entPaymentPhr.setJumlahBayar(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TAGIHAN]));
                entPaymentPhr.setTanggal(rs.getDate(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_TANGGALAWAL]));
                entPaymentPhr.setPokok(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_POKOK]));
                entPaymentPhr.setDenda(rs.getDouble(PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_DENDA]));
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
            String sql = " SELECT SUBSTR(NPWPD, 1, 1) NPWPD, SUM(POKOK) POKOK, SUM(DENDA) DENDA, SUM(TAGIHAN) JUMLAH FROM "+TBL_PAYMENTPHRFOROPENPHR;

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
    
}
