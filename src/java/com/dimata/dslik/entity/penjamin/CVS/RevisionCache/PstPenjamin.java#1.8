/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.entity.penjamin;

import com.dimata.dslik.entity.debitur.PstDebitur;
import com.dimata.dslik.entity.masterdata.PstPeriode;
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
public class PstPenjamin extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    private String sqlQueryHistory = "";
    public static final String TBL_PENJAMIN = "dslik_penjamin";
    public static final int FLD_PENJAMIN_OID = 0;
    public static final int FLD_FLAG_DETAIL = 1;
    public static final int FLD_NO_ID_PENJAMIN = 2;
    public static final int FLD_NO_REKENING = 3;
    public static final int FLD_CIF = 4;
    public static final int FLD_JENIS_IDENTITAS = 5;
    public static final int FLD_NAMA_IDENTITAS = 6;
    public static final int FLD_NAMA_LENGKAP = 7;
    public static final int FLD_KODE_GOL_PENJAMIN = 8;
    public static final int FLD_ALAMAT_PENJAMIN = 9;
    public static final int FLD_PROSENTASE_DIJAMIN = 10;
    public static final int FLD_KETERANGAN = 11;
    public static final int FLD_KODE_KANTOR_CABANG = 12;
    public static final int FLD_OPERASI_DATA = 13;
    public static final int FLD_OPEN_DATE = 14;
    public static final int FLD_STATUS_DATA = 15;
    public static final int FLD_PERIODE_ID = 16;
    public static final int FLD_STATUS_PERUBAHAN_DATA = 17;
    public static final int FLD_KODE_JENIS_SEGMEN_FASILITAS = 18;
    public static String[] fieldNames = {
        "PENJAMIN_OID",
        "FLAG_DETAIL",
        "NO_ID_PENJAMIN",
        "NO_REKENING",
        "CIF",
        "JENIS_IDENTITAS",
        "NAMA_IDENTITAS",
        "NAMA_LENGKAP",
        "KODE_GOL_PENJAMIN",
        "ALAMAT_PENJAMIN",
        "PROSENTASE_DIJAMIN",
        "KETERANGAN",
        "KODE_KANTOR_CABANG",
        "OPERASI_DATA",
        "OPEN_DATE",
        "STATUS_OPERASI_DATA",
        "PERIODE_ID",
        "STATUS_DATA",
        "KODE_JENIS_SEGMENT_FASILITAS"
    };
    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_INT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_INT,
        TYPE_LONG,
        TYPE_INT,
        TYPE_STRING
    };
    
    public static String[] operasiDataKey = {
        "0",
        "1",
        "2",
        "3"
    };
    
    public static String[] operasiDataValue = {
        "Create",
        "Update",
        "Not Change",
        "Delete"
    };
    
    public PstPenjamin() {
    }

    public PstPenjamin(int i) throws DBException {
        super(new PstPenjamin());
    }

    public PstPenjamin(String sOid) throws DBException {
        super(new PstPenjamin(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPenjamin(long lOid) throws DBException {
        super(new PstPenjamin(0));
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
        return TBL_PENJAMIN;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPenjamin().getClass().getName();
    }

    public static Penjamin fetchExc(long oid) throws DBException {
        try {
            Penjamin entPenjamin = new Penjamin();
            PstPenjamin pstPenjamin = new PstPenjamin(oid);
            entPenjamin.setOID(oid);
            entPenjamin.setFlagDetail(pstPenjamin.getString(FLD_FLAG_DETAIL));
            entPenjamin.setNoIdPenjamin(pstPenjamin.getString(FLD_NO_ID_PENJAMIN));
            entPenjamin.setNoRekening(pstPenjamin.getString(FLD_NO_REKENING));
            entPenjamin.setCif(pstPenjamin.getString(FLD_CIF));
            entPenjamin.setJenisIdentitas(pstPenjamin.getString(FLD_JENIS_IDENTITAS));
            entPenjamin.setNamaIdentitas(pstPenjamin.getString(FLD_NAMA_IDENTITAS));
            entPenjamin.setNamaLengkap(pstPenjamin.getString(FLD_NAMA_LENGKAP));
            entPenjamin.setKodeGolPenjamin(pstPenjamin.getString(FLD_KODE_GOL_PENJAMIN));
            entPenjamin.setAlamatPenjamin(pstPenjamin.getString(FLD_ALAMAT_PENJAMIN));
            entPenjamin.setProsentaseDijamin(pstPenjamin.getInt(FLD_PROSENTASE_DIJAMIN));
            entPenjamin.setKeterangan(pstPenjamin.getString(FLD_KETERANGAN));
            entPenjamin.setKodeKantorCabang(pstPenjamin.getString(FLD_KODE_KANTOR_CABANG));
            entPenjamin.setOperasiData(pstPenjamin.getString(FLD_OPERASI_DATA));
            entPenjamin.setOpenDate(pstPenjamin.getDate(FLD_OPEN_DATE));
            entPenjamin.setStatusData(pstPenjamin.getInt(FLD_STATUS_DATA));
            entPenjamin.setPeriodeId(pstPenjamin.getlong(FLD_PERIODE_ID));
            entPenjamin.setStatusPerubahanData(pstPenjamin.getInt(FLD_STATUS_PERUBAHAN_DATA));
            entPenjamin.setKodeJenisSegmentFasilitas(pstPenjamin.getString(FLD_KODE_JENIS_SEGMEN_FASILITAS));
            return entPenjamin;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPenjamin(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        Penjamin entPenjamin = fetchExc(entity.getOID());
        entity = (Entity) entPenjamin;
        return entPenjamin.getOID();
    }

    public static synchronized long updateExc(Penjamin entPenjamin) throws DBException {
        try {
            if (entPenjamin.getOID() != 0) {
                PstPenjamin pstPenjamin = new PstPenjamin(entPenjamin.getOID());
                pstPenjamin.setString(FLD_FLAG_DETAIL, entPenjamin.getFlagDetail());
                pstPenjamin.setString(FLD_NO_ID_PENJAMIN, entPenjamin.getNoIdPenjamin());
                pstPenjamin.setString(FLD_NO_REKENING, entPenjamin.getNoRekening());
                pstPenjamin.setString(FLD_CIF, entPenjamin.getCif());
                pstPenjamin.setString(FLD_JENIS_IDENTITAS, entPenjamin.getJenisIdentitas());
                pstPenjamin.setString(FLD_NAMA_IDENTITAS, entPenjamin.getNamaIdentitas());
                pstPenjamin.setString(FLD_NAMA_LENGKAP, entPenjamin.getNamaLengkap());
                pstPenjamin.setString(FLD_KODE_GOL_PENJAMIN, entPenjamin.getKodeGolPenjamin());
                pstPenjamin.setString(FLD_ALAMAT_PENJAMIN, entPenjamin.getAlamatPenjamin());
                pstPenjamin.setInt(FLD_PROSENTASE_DIJAMIN, entPenjamin.getProsentaseDijamin());
                pstPenjamin.setString(FLD_KETERANGAN, entPenjamin.getKeterangan());
                pstPenjamin.setString(FLD_KODE_KANTOR_CABANG, entPenjamin.getKodeKantorCabang());
                pstPenjamin.setString(FLD_OPERASI_DATA, entPenjamin.getOperasiData());
                pstPenjamin.setDate(FLD_OPEN_DATE, entPenjamin.getOpenDate());
                pstPenjamin.setInt(FLD_STATUS_DATA, entPenjamin.getStatusData());
                pstPenjamin.setLong(FLD_PERIODE_ID, entPenjamin.getPeriodeId());
                pstPenjamin.setInt(FLD_STATUS_PERUBAHAN_DATA, entPenjamin.getStatusPerubahanData());
                pstPenjamin.setString(FLD_KODE_JENIS_SEGMEN_FASILITAS, entPenjamin.getKodeJenisSegmentFasilitas());
                pstPenjamin.update();

                pstPenjamin.setSqlQueryHistory("");
                pstPenjamin.setSqlQueryHistory(pstPenjamin.getInsertSQL());

                return entPenjamin.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPenjamin(0), DBException.UNKNOWN);
        }
        return 0;
    }
    
    public static synchronized Penjamin updateExcObj(Penjamin entPenjamin) throws DBException {
        try {
            if (entPenjamin.getOID() != 0) {
                PstPenjamin pstPenjamin = new PstPenjamin(entPenjamin.getOID());
                pstPenjamin.setString(FLD_FLAG_DETAIL, entPenjamin.getFlagDetail());
                pstPenjamin.setString(FLD_NO_ID_PENJAMIN, entPenjamin.getNoIdPenjamin());
                pstPenjamin.setString(FLD_NO_REKENING, entPenjamin.getNoRekening());
                pstPenjamin.setString(FLD_CIF, entPenjamin.getCif());
                pstPenjamin.setString(FLD_JENIS_IDENTITAS, entPenjamin.getJenisIdentitas());
                pstPenjamin.setString(FLD_NAMA_IDENTITAS, entPenjamin.getNamaIdentitas());
                pstPenjamin.setString(FLD_NAMA_LENGKAP, entPenjamin.getNamaLengkap());
                pstPenjamin.setString(FLD_KODE_GOL_PENJAMIN, entPenjamin.getKodeGolPenjamin());
                pstPenjamin.setString(FLD_ALAMAT_PENJAMIN, entPenjamin.getAlamatPenjamin());
                pstPenjamin.setInt(FLD_PROSENTASE_DIJAMIN, entPenjamin.getProsentaseDijamin());
                pstPenjamin.setString(FLD_KETERANGAN, entPenjamin.getKeterangan());
                pstPenjamin.setString(FLD_KODE_KANTOR_CABANG, entPenjamin.getKodeKantorCabang());
                pstPenjamin.setString(FLD_OPERASI_DATA, entPenjamin.getOperasiData());
                pstPenjamin.setDate(FLD_OPEN_DATE, entPenjamin.getOpenDate());
                pstPenjamin.setInt(FLD_STATUS_DATA, entPenjamin.getStatusData());
                pstPenjamin.setLong(FLD_PERIODE_ID, entPenjamin.getPeriodeId());
                pstPenjamin.setInt(FLD_STATUS_PERUBAHAN_DATA, entPenjamin.getStatusPerubahanData());
                pstPenjamin.setString(FLD_KODE_JENIS_SEGMEN_FASILITAS, entPenjamin.getKodeJenisSegmentFasilitas());
                pstPenjamin.update();

                pstPenjamin.setSqlQueryHistory("");
                pstPenjamin.setSqlQueryHistory(pstPenjamin.getInsertSQL());
                entPenjamin.setSqlHistory(pstPenjamin.getInsertSQL());
                return entPenjamin;
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPenjamin(0), DBException.UNKNOWN);
        }
        return entPenjamin;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((Penjamin) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPenjamin pstPenjamin = new PstPenjamin(oid);
            pstPenjamin.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPenjamin(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(Penjamin entPenjamin) throws DBException {
        try {
            PstPenjamin pstPenjamin = new PstPenjamin(0);
            pstPenjamin.setString(FLD_FLAG_DETAIL, entPenjamin.getFlagDetail());
            pstPenjamin.setString(FLD_NO_ID_PENJAMIN, entPenjamin.getNoIdPenjamin());
            pstPenjamin.setString(FLD_NO_REKENING, entPenjamin.getNoRekening());
            pstPenjamin.setString(FLD_CIF, entPenjamin.getCif());
            pstPenjamin.setString(FLD_JENIS_IDENTITAS, entPenjamin.getJenisIdentitas());
            pstPenjamin.setString(FLD_NAMA_IDENTITAS, entPenjamin.getNamaIdentitas());
            pstPenjamin.setString(FLD_NAMA_LENGKAP, entPenjamin.getNamaLengkap());
            pstPenjamin.setString(FLD_KODE_GOL_PENJAMIN, entPenjamin.getKodeGolPenjamin());
            pstPenjamin.setString(FLD_ALAMAT_PENJAMIN, entPenjamin.getAlamatPenjamin());
            pstPenjamin.setInt(FLD_PROSENTASE_DIJAMIN, entPenjamin.getProsentaseDijamin());
            pstPenjamin.setString(FLD_KETERANGAN, entPenjamin.getKeterangan());
            pstPenjamin.setString(FLD_KODE_KANTOR_CABANG, entPenjamin.getKodeKantorCabang());
            pstPenjamin.setString(FLD_OPERASI_DATA, entPenjamin.getOperasiData());
            pstPenjamin.setDate(FLD_OPEN_DATE, entPenjamin.getOpenDate());
            pstPenjamin.setInt(FLD_STATUS_DATA, entPenjamin.getStatusData());
            pstPenjamin.setLong(FLD_PERIODE_ID, entPenjamin.getPeriodeId());
            pstPenjamin.setInt(FLD_STATUS_PERUBAHAN_DATA, entPenjamin.getStatusPerubahanData());
            pstPenjamin.setString(FLD_KODE_JENIS_SEGMEN_FASILITAS, entPenjamin.getKodeJenisSegmentFasilitas());
            pstPenjamin.insert();

            pstPenjamin.setSqlQueryHistory("");
            pstPenjamin.setSqlQueryHistory(pstPenjamin.getInsertSQL());

            entPenjamin.setOID(pstPenjamin.getLong(FLD_PENJAMIN_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPenjamin(0), DBException.UNKNOWN);
        }
        return entPenjamin.getOID();
    }
    
    public static synchronized Penjamin insertExcObj(Penjamin entPenjamin) throws DBException {
        try {
            PstPenjamin pstPenjamin = new PstPenjamin(0);
            pstPenjamin.setString(FLD_FLAG_DETAIL, entPenjamin.getFlagDetail());
            pstPenjamin.setString(FLD_NO_ID_PENJAMIN, entPenjamin.getNoIdPenjamin());
            pstPenjamin.setString(FLD_NO_REKENING, entPenjamin.getNoRekening());
            pstPenjamin.setString(FLD_CIF, entPenjamin.getCif());
            pstPenjamin.setString(FLD_JENIS_IDENTITAS, entPenjamin.getJenisIdentitas());
            pstPenjamin.setString(FLD_NAMA_IDENTITAS, entPenjamin.getNamaIdentitas());
            pstPenjamin.setString(FLD_NAMA_LENGKAP, entPenjamin.getNamaLengkap());
            pstPenjamin.setString(FLD_KODE_GOL_PENJAMIN, entPenjamin.getKodeGolPenjamin());
            pstPenjamin.setString(FLD_ALAMAT_PENJAMIN, entPenjamin.getAlamatPenjamin());
            pstPenjamin.setInt(FLD_PROSENTASE_DIJAMIN, entPenjamin.getProsentaseDijamin());
            pstPenjamin.setString(FLD_KETERANGAN, entPenjamin.getKeterangan());
            pstPenjamin.setString(FLD_KODE_KANTOR_CABANG, entPenjamin.getKodeKantorCabang());
            pstPenjamin.setString(FLD_OPERASI_DATA, entPenjamin.getOperasiData());
            pstPenjamin.setDate(FLD_OPEN_DATE, entPenjamin.getOpenDate());
            pstPenjamin.setInt(FLD_STATUS_DATA, entPenjamin.getStatusData());
            pstPenjamin.setLong(FLD_PERIODE_ID, entPenjamin.getPeriodeId());
            pstPenjamin.setInt(FLD_STATUS_PERUBAHAN_DATA, entPenjamin.getStatusPerubahanData());
            pstPenjamin.setString(FLD_KODE_JENIS_SEGMEN_FASILITAS, entPenjamin.getKodeJenisSegmentFasilitas());
            pstPenjamin.insert();

            pstPenjamin.setSqlQueryHistory("");
            pstPenjamin.setSqlQueryHistory(pstPenjamin.getInsertSQL());
            entPenjamin.setSqlHistory(pstPenjamin.getInsertSQL());

            entPenjamin.setOID(pstPenjamin.getlong(FLD_PENJAMIN_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPenjamin(0), DBException.UNKNOWN);
        }
        return entPenjamin;
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((Penjamin) entity);
    }

    public static void resultToObject(ResultSet rs, Penjamin entPenjamin) {
        try {
            entPenjamin.setOID(rs.getLong(PstPenjamin.fieldNames[PstPenjamin.FLD_PENJAMIN_OID]));
            entPenjamin.setFlagDetail(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_FLAG_DETAIL]));
            entPenjamin.setNoIdPenjamin(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NO_ID_PENJAMIN]));
            entPenjamin.setNoRekening(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NO_REKENING]));
            entPenjamin.setCif(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_CIF]));
            entPenjamin.setJenisIdentitas(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_JENIS_IDENTITAS]));
            entPenjamin.setNamaIdentitas(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NAMA_IDENTITAS]));
            entPenjamin.setNamaLengkap(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NAMA_LENGKAP]));
            entPenjamin.setKodeGolPenjamin(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_KODE_GOL_PENJAMIN]));
            entPenjamin.setAlamatPenjamin(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_ALAMAT_PENJAMIN]));
            entPenjamin.setProsentaseDijamin(rs.getInt(PstPenjamin.fieldNames[PstPenjamin.FLD_PROSENTASE_DIJAMIN]));
            entPenjamin.setKeterangan(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_KETERANGAN]));
            entPenjamin.setKodeKantorCabang(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_KODE_KANTOR_CABANG]));
            entPenjamin.setOperasiData(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_OPERASI_DATA]));
            entPenjamin.setOpenDate(rs.getDate(PstPenjamin.fieldNames[PstPenjamin.FLD_OPEN_DATE]));
            entPenjamin.setStatusData(rs.getInt(PstPenjamin.fieldNames[PstPenjamin.FLD_STATUS_DATA]));
            entPenjamin.setPeriodeId(rs.getInt(PstPenjamin.fieldNames[PstPenjamin.FLD_PERIODE_ID]));
            entPenjamin.setStatusOperasiData(rs.getInt("STATUS_OPERASI_DATA"));
            entPenjamin.setStatusPerubahanData(rs.getInt(fieldNames[FLD_STATUS_PERUBAHAN_DATA]));
            entPenjamin.setKodeJenisSegmentFasilitas(rs.getString(fieldNames[FLD_KODE_JENIS_SEGMEN_FASILITAS]));

            
            
        } catch (Exception e) {
        }
    }
    
    public static void resultToObjectJoin(ResultSet rs, Penjamin entPenjamin) {
        try {
            entPenjamin.setOID(rs.getLong(PstPenjamin.fieldNames[PstPenjamin.FLD_PENJAMIN_OID]));
            entPenjamin.setFlagDetail(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_FLAG_DETAIL]));
            entPenjamin.setNoIdPenjamin(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NO_ID_PENJAMIN]));
            entPenjamin.setNoRekening(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NO_REKENING]));
            entPenjamin.setCif(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_CIF]));
            entPenjamin.setJenisIdentitas(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_JENIS_IDENTITAS]));
            entPenjamin.setNamaIdentitas(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NAMA_IDENTITAS]));
            entPenjamin.setNamaLengkap(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_NAMA_LENGKAP]));
            entPenjamin.setKodeGolPenjamin(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_KODE_GOL_PENJAMIN]));
            entPenjamin.setAlamatPenjamin(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_ALAMAT_PENJAMIN]));
            entPenjamin.setProsentaseDijamin(rs.getInt(PstPenjamin.fieldNames[PstPenjamin.FLD_PROSENTASE_DIJAMIN]));
            entPenjamin.setKeterangan(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_KETERANGAN]));
            entPenjamin.setKodeKantorCabang(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_KODE_KANTOR_CABANG]));
            entPenjamin.setOperasiData(rs.getString(PstPenjamin.fieldNames[PstPenjamin.FLD_OPERASI_DATA]));
            entPenjamin.setOpenDate(rs.getDate(PstPenjamin.fieldNames[PstPenjamin.FLD_OPEN_DATE]));
            entPenjamin.setStatusData(rs.getInt(PstPenjamin.fieldNames[PstPenjamin.FLD_STATUS_DATA]));
            entPenjamin.setPeriodeId(rs.getInt(PstPenjamin.fieldNames[PstPenjamin.FLD_PERIODE_ID]));
            entPenjamin.setDebiturOid(rs.getLong(PstDebitur.fieldNames[PstDebitur.FLD_DEBITUR_OID]));
            entPenjamin.setDebiturType(rs.getInt(PstDebitur.fieldNames[PstDebitur.FLD_KODE_JENIS_NSB]));
            entPenjamin.setStatusPerubahanData(rs.getInt(fieldNames[FLD_STATUS_PERUBAHAN_DATA]));
            entPenjamin.setKodeJenisSegmentFasilitas(rs.getString(fieldNames[FLD_KODE_JENIS_SEGMEN_FASILITAS]));
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
            String sql = "SELECT DISTINCT * FROM " + TBL_PENJAMIN;
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
                Penjamin entPenjamin = new Penjamin();
                resultToObject(rs, entPenjamin);
                lists.add(entPenjamin);
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
            String sql = "SELECT DISTINCT penjamin.*,"
                    + "debitur."+PstDebitur.fieldNames[PstDebitur.FLD_DEBITUR_OID]+", "
                    + "debitur."+PstDebitur.fieldNames[PstDebitur.FLD_KODE_JENIS_NSB]+" "
                    + "FROM " + TBL_PENJAMIN+" AS penjamin "
                    + "INNER JOIN "+PstPeriode.TBL_PERIODE+" AS periode "
                    + "ON penjamin."+fieldNames[FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+" "
                    + "AND periode."+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0' "
                    + "INNER JOIN "+PstDebitur.TBL_DEBITUR_INDIVIDU+" AS debitur "
                    + "ON penjamin."+fieldNames[FLD_CIF]+"=debitur."+PstDebitur.fieldNames[PstDebitur.FLD_CIF]+" "
                    + "AND debitur."+PstDebitur.fieldNames[PstDebitur.FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID];
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
                Penjamin entPenjamin = new Penjamin();
                resultToObjectJoin(rs, entPenjamin);
                lists.add(entPenjamin);
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

    public static boolean checkOID(long entPenjaminId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT DISTINCT * FROM " + TBL_PENJAMIN + " WHERE "
                    + PstPenjamin.fieldNames[PstPenjamin.FLD_PENJAMIN_OID] + " = " + entPenjaminId;
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
            String sql = "SELECT DISTINCT COUNT(" + PstPenjamin.fieldNames[PstPenjamin.FLD_PENJAMIN_OID] + ") FROM " + TBL_PENJAMIN;
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
    
    public static int getCountJoin(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT COUNT(penjamin." + PstPenjamin.fieldNames[PstPenjamin.FLD_PENJAMIN_OID] + ") "
                    + "FROM " + TBL_PENJAMIN+" AS penjamin "
                    + "INNER JOIN "+PstPeriode.TBL_PERIODE+" AS periode "
                    + "ON penjamin."+fieldNames[FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+" "
                    + "AND periode."+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0' "
                    + "INNER JOIN "+PstDebitur.TBL_DEBITUR_INDIVIDU+" AS debitur "
                    + "ON penjamin."+fieldNames[FLD_CIF]+"=debitur."+PstDebitur.fieldNames[PstDebitur.FLD_CIF]+" "
                    + "AND debitur."+PstDebitur.fieldNames[PstDebitur.FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID];
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
                    Penjamin entPenjamin = (Penjamin) list.get(ls);
                    if (oid == entPenjamin.getOID()) {
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

    /**
     * @return the sqlQueryHistory
     */
    public String getSqlQueryHistory() {
        return sqlQueryHistory;
    }

    /**
     * @param sqlQueryHistory the sqlQueryHistory to set
     */
    public void setSqlQueryHistory(String sqlQueryHistory) {
        this.sqlQueryHistory = sqlQueryHistory;
    }
}
