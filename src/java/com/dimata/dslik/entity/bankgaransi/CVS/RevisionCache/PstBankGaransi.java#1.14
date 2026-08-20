/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.entity.bankgaransi;

import com.dimata.dslik.entity.debitur.PstDebitur;
import java.sql.*;
import com.dimata.dslik.entity.contentdata.PstContentDataJenisGaransi;
import com.dimata.dslik.entity.contentdata.PstContentDataTujuanGaransi;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import com.dimata.util.lang.I_Language;
import java.util.Vector;

/**
 *
 * @author Dewa
 */
public class PstBankGaransi extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    
    private String sqlQueryHistory = "";

    public static final String TBL_BANK_GARANSI = "dslik_bank_garansi";
    public static final int FLD_BANK_GARANSI_OID = 0;
    public static final int FLD_FLAG_DETAIL = 1;
    public static final int FLD_NO_REKENING = 2;
    public static final int FLD_CIF = 3;
    public static final int FLD_KODE_JENIS_GARANSI = 4;
    public static final int FLD_KODE_TUJUAN_GARANSI = 5;
    public static final int FLD_TGL_DITERBITKAN = 6;
    public static final int FLD_TGL_JATUH_TEMPO = 7;
    public static final int FLD_NO_AKAD_AWAL = 8;
    public static final int FLD_TGL_AKAD_AWAL = 9;
    public static final int FLD_NO_AKAD_AKHIR = 10;
    public static final int FLD_TGL_AKAD_AKHIR = 11;
    public static final int FLD_NAMA_YG_DIJAMIN = 12;
    public static final int FLD_KODE_VALUTA = 13;
    public static final int FLD_PLAFON = 14;
    public static final int FLD_NOMINAL = 15;
    public static final int FLD_SETORAN_JAMINAN = 16;
    public static final int FLD_KODE_KOLEKTIBILITAS = 17;
    public static final int FLD_TGL_WAN_PRESTASI = 18;
    public static final int FLD_KODE_KONDISI = 19;
    public static final int FLD_TGL_KONDISI = 20;
    public static final int FLD_KETERANGAN = 21;
    public static final int FLD_KODE_KANTOR_CABANG = 22;
    public static final int FLD_OPERASI_DATA = 23;
    public static final int FLD_OPEN_DATE = 24;
    public static final int FLD_STATUS_DATA = 25;
    public static final int FLD_PERIODE_ID = 26;
    public static final int FLD_STATUS_PERUBAHAN_DATA = 27;

    public static String[] fieldNames = {
        "BANK_GARANSI_OID",
        "FLAG_DETAIL",
        "NO_REKENING",
        "CIF",
        "KODE_JENIS_GARANSI",
        "KODE_TUJUAN_GARANSI",
        "TGL_DITERBITKAN",
        "TGL_JATUH_TEMPO",
        "NO_AKAD_AWAL",
        "TGL_AKAD_AWAL",
        "NO_AKAD_AKHIR",
        "TGL_AKAD_AKHIR",
        "NAMA_YG_DIJAMIN",
        "KODE_VALUTA",
        "PLAFON",
        "NOMINAL",
        "SETORAN_JAMINAN",
        "KODE_KOLEKTIBILITAS",
        "TGL_WAN_PRESTASI",
        "KODE_KONDISI",
        "TGL_KONDISI",
        "KETERANGAN",
        "KODE_KANTOR_CABANG",
        "OPERASI_DATA",
        "OPEN_DATE",
        "STATUS_OPERASI_DATA",
        "PERIODE_ID",
        "STATUS_DATA"
    };

    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_INT,
        TYPE_LONG,
        TYPE_INT
    };

    public PstBankGaransi() {
    }

    public PstBankGaransi(int i) throws DBException {
        super(new PstBankGaransi());
    }

    public PstBankGaransi(String sOid) throws DBException {
        super(new PstBankGaransi(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstBankGaransi(long lOid) throws DBException {
        super(new PstBankGaransi(0));
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
        return TBL_BANK_GARANSI;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstBankGaransi().getClass().getName();
    }

    public static BankGaransi fetchExc(long oid) throws DBException {
        try {
            BankGaransi entBankGaransi = new BankGaransi();
            PstBankGaransi pstBankGaransi = new PstBankGaransi(oid);
            entBankGaransi.setOID(oid);
            entBankGaransi.setFlagDetail(pstBankGaransi.getString(FLD_FLAG_DETAIL));
            entBankGaransi.setNoRekening(pstBankGaransi.getString(FLD_NO_REKENING));
            entBankGaransi.setCif(pstBankGaransi.getString(FLD_CIF));
            entBankGaransi.setKodeJenisGaransi(pstBankGaransi.getString(FLD_KODE_JENIS_GARANSI));
            entBankGaransi.setKodeTujuanGaransi(pstBankGaransi.getString(FLD_KODE_TUJUAN_GARANSI));
            entBankGaransi.setTglDiterbitkan(pstBankGaransi.getDate(FLD_TGL_DITERBITKAN));
            entBankGaransi.setTglJatuhTempo(pstBankGaransi.getDate(FLD_TGL_JATUH_TEMPO));
            entBankGaransi.setNoAkadAwal(pstBankGaransi.getString(FLD_NO_AKAD_AWAL));
            entBankGaransi.setTglAkadAwal(pstBankGaransi.getDate(FLD_TGL_AKAD_AWAL));
            entBankGaransi.setNoAkadAkhir(pstBankGaransi.getString(FLD_NO_AKAD_AKHIR));
            entBankGaransi.setTglAkadAkhir(pstBankGaransi.getDate(FLD_TGL_AKAD_AKHIR));
            entBankGaransi.setNamaYgDijamin(pstBankGaransi.getString(FLD_NAMA_YG_DIJAMIN));
            entBankGaransi.setKodeValuta(pstBankGaransi.getString(FLD_KODE_VALUTA));
            entBankGaransi.setPlafon(pstBankGaransi.getdouble(FLD_PLAFON));
            entBankGaransi.setNominal(pstBankGaransi.getdouble(FLD_NOMINAL));
            entBankGaransi.setSetoranJaminan(pstBankGaransi.getdouble(FLD_SETORAN_JAMINAN));
            entBankGaransi.setKodeKolektibilitas(pstBankGaransi.getString(FLD_KODE_KOLEKTIBILITAS));
            entBankGaransi.setTglWanPrestasi(pstBankGaransi.getDate(FLD_TGL_WAN_PRESTASI));
            entBankGaransi.setKodeKondisi(pstBankGaransi.getString(FLD_KODE_KONDISI));
            entBankGaransi.setTglKondisi(pstBankGaransi.getDate(FLD_TGL_KONDISI));
            entBankGaransi.setKeterangan(pstBankGaransi.getString(FLD_KETERANGAN));
            entBankGaransi.setKodeKantorCabang(pstBankGaransi.getString(FLD_KODE_KANTOR_CABANG));
            entBankGaransi.setOperasiData(pstBankGaransi.getString(FLD_OPERASI_DATA));
            entBankGaransi.setOpenDate(pstBankGaransi.getDate(FLD_OPEN_DATE));
            entBankGaransi.setStatusData(pstBankGaransi.getInt(FLD_STATUS_DATA));
            entBankGaransi.setPeriodeid(pstBankGaransi.getlong(FLD_PERIODE_ID));
            
            entBankGaransi.setStatusPerubahanData(pstBankGaransi.getInt(FLD_STATUS_PERUBAHAN_DATA));
            
            return entBankGaransi;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBankGaransi(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        BankGaransi entBankGaransi = fetchExc(entity.getOID());
        entity = (Entity) entBankGaransi;
        return entBankGaransi.getOID();
    }

    public static synchronized long updateExc(BankGaransi entBankGaransi) throws DBException {
        try {
            if (entBankGaransi.getOID() != 0) {
                PstBankGaransi pstBankGaransi = new PstBankGaransi(entBankGaransi.getOID());
                pstBankGaransi.setString(FLD_FLAG_DETAIL, entBankGaransi.getFlagDetail());
                pstBankGaransi.setString(FLD_NO_REKENING, entBankGaransi.getNoRekening());
                pstBankGaransi.setString(FLD_CIF, entBankGaransi.getCif());
                pstBankGaransi.setString(FLD_KODE_JENIS_GARANSI, entBankGaransi.getKodeJenisGaransi());
                pstBankGaransi.setString(FLD_KODE_TUJUAN_GARANSI, entBankGaransi.getKodeTujuanGaransi());
                pstBankGaransi.setDate(FLD_TGL_DITERBITKAN, entBankGaransi.getTglDiterbitkan());
                pstBankGaransi.setDate(FLD_TGL_JATUH_TEMPO, entBankGaransi.getTglJatuhTempo());
                pstBankGaransi.setString(FLD_NO_AKAD_AWAL, entBankGaransi.getNoAkadAwal());
                pstBankGaransi.setDate(FLD_TGL_AKAD_AWAL, entBankGaransi.getTglAkadAwal());
                pstBankGaransi.setString(FLD_NO_AKAD_AKHIR, entBankGaransi.getNoAkadAkhir());
                pstBankGaransi.setDate(FLD_TGL_AKAD_AKHIR, entBankGaransi.getTglAkadAkhir());
                pstBankGaransi.setString(FLD_NAMA_YG_DIJAMIN, entBankGaransi.getNamaYgDijamin());
                pstBankGaransi.setString(FLD_KODE_VALUTA, entBankGaransi.getKodeValuta());
                pstBankGaransi.setDouble(FLD_PLAFON, entBankGaransi.getPlafon());
                pstBankGaransi.setDouble(FLD_NOMINAL, entBankGaransi.getNominal());
                pstBankGaransi.setDouble(FLD_SETORAN_JAMINAN, entBankGaransi.getSetoranJaminan());
                pstBankGaransi.setString(FLD_KODE_KOLEKTIBILITAS, entBankGaransi.getKodeKolektibilitas());
                pstBankGaransi.setDate(FLD_TGL_WAN_PRESTASI, entBankGaransi.getTglWanPrestasi());
                pstBankGaransi.setString(FLD_KODE_KONDISI, entBankGaransi.getKodeKondisi());
                pstBankGaransi.setDate(FLD_TGL_KONDISI, entBankGaransi.getTglKondisi());
                pstBankGaransi.setString(FLD_KETERANGAN, entBankGaransi.getKeterangan());
                pstBankGaransi.setString(FLD_KODE_KANTOR_CABANG, entBankGaransi.getKodeKantorCabang());
                pstBankGaransi.setString(FLD_OPERASI_DATA, entBankGaransi.getOperasiData());
                pstBankGaransi.setDate(FLD_OPEN_DATE, entBankGaransi.getOpenDate());
                pstBankGaransi.setInt(FLD_STATUS_DATA, entBankGaransi.getStatusData());
                pstBankGaransi.setLong(FLD_PERIODE_ID, entBankGaransi.getPeriodeid());
                pstBankGaransi.setInt(FLD_STATUS_PERUBAHAN_DATA, entBankGaransi.getStatusPerubahanData());
                
                pstBankGaransi.update();
                
                pstBankGaransi.setSqlQueryHistory("");
                pstBankGaransi.setSqlQueryHistory(pstBankGaransi.getUpdateSQL());
                
                return entBankGaransi.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBankGaransi(0), DBException.UNKNOWN);
        }
        return 0;
    }
    
    public static synchronized BankGaransi updateExcObj(BankGaransi entBankGaransi) throws DBException {
        try {
            if (entBankGaransi.getOID() != 0) {
                PstBankGaransi pstBankGaransi = new PstBankGaransi(entBankGaransi.getOID());
                pstBankGaransi.setString(FLD_FLAG_DETAIL, entBankGaransi.getFlagDetail());
                pstBankGaransi.setString(FLD_NO_REKENING, entBankGaransi.getNoRekening());
                pstBankGaransi.setString(FLD_CIF, entBankGaransi.getCif());
                pstBankGaransi.setString(FLD_KODE_JENIS_GARANSI, entBankGaransi.getKodeJenisGaransi());
                pstBankGaransi.setString(FLD_KODE_TUJUAN_GARANSI, entBankGaransi.getKodeTujuanGaransi());
                pstBankGaransi.setDate(FLD_TGL_DITERBITKAN, entBankGaransi.getTglDiterbitkan());
                pstBankGaransi.setDate(FLD_TGL_JATUH_TEMPO, entBankGaransi.getTglJatuhTempo());
                pstBankGaransi.setString(FLD_NO_AKAD_AWAL, entBankGaransi.getNoAkadAwal());
                pstBankGaransi.setDate(FLD_TGL_AKAD_AWAL, entBankGaransi.getTglAkadAwal());
                pstBankGaransi.setString(FLD_NO_AKAD_AKHIR, entBankGaransi.getNoAkadAkhir());
                pstBankGaransi.setDate(FLD_TGL_AKAD_AKHIR, entBankGaransi.getTglAkadAkhir());
                pstBankGaransi.setString(FLD_NAMA_YG_DIJAMIN, entBankGaransi.getNamaYgDijamin());
                pstBankGaransi.setString(FLD_KODE_VALUTA, entBankGaransi.getKodeValuta());
                pstBankGaransi.setDouble(FLD_PLAFON, entBankGaransi.getPlafon());
                pstBankGaransi.setDouble(FLD_NOMINAL, entBankGaransi.getNominal());
                pstBankGaransi.setDouble(FLD_SETORAN_JAMINAN, entBankGaransi.getSetoranJaminan());
                pstBankGaransi.setString(FLD_KODE_KOLEKTIBILITAS, entBankGaransi.getKodeKolektibilitas());
                pstBankGaransi.setDate(FLD_TGL_WAN_PRESTASI, entBankGaransi.getTglWanPrestasi());
                pstBankGaransi.setString(FLD_KODE_KONDISI, entBankGaransi.getKodeKondisi());
                pstBankGaransi.setDate(FLD_TGL_KONDISI, entBankGaransi.getTglKondisi());
                pstBankGaransi.setString(FLD_KETERANGAN, entBankGaransi.getKeterangan());
                pstBankGaransi.setString(FLD_KODE_KANTOR_CABANG, entBankGaransi.getKodeKantorCabang());
                pstBankGaransi.setString(FLD_OPERASI_DATA, entBankGaransi.getOperasiData());
                pstBankGaransi.setDate(FLD_OPEN_DATE, entBankGaransi.getOpenDate());
                pstBankGaransi.setInt(FLD_STATUS_DATA, entBankGaransi.getStatusData());
                pstBankGaransi.setLong(FLD_PERIODE_ID, entBankGaransi.getPeriodeid());
                pstBankGaransi.setInt(FLD_STATUS_PERUBAHAN_DATA, entBankGaransi.getStatusPerubahanData());
                
                pstBankGaransi.update();
                
                pstBankGaransi.setSqlQueryHistory("");
                pstBankGaransi.setSqlQueryHistory(pstBankGaransi.getUpdateSQL());
                entBankGaransi.setSqlHistory(pstBankGaransi.getUpdateSQL());
                
                return entBankGaransi;
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBankGaransi(0), DBException.UNKNOWN);
        }
        return entBankGaransi;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((BankGaransi) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstBankGaransi pstBankGaransi = new PstBankGaransi(oid);
            pstBankGaransi.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBankGaransi(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(BankGaransi entBankGaransi) throws DBException {
        try {
            PstBankGaransi pstBankGaransi = new PstBankGaransi(0);
            pstBankGaransi.setString(FLD_FLAG_DETAIL, entBankGaransi.getFlagDetail());
            pstBankGaransi.setString(FLD_NO_REKENING, entBankGaransi.getNoRekening());
            pstBankGaransi.setString(FLD_CIF, entBankGaransi.getCif());
            pstBankGaransi.setString(FLD_KODE_JENIS_GARANSI, entBankGaransi.getKodeJenisGaransi());
            pstBankGaransi.setString(FLD_KODE_TUJUAN_GARANSI, entBankGaransi.getKodeTujuanGaransi());
            pstBankGaransi.setDate(FLD_TGL_DITERBITKAN, entBankGaransi.getTglDiterbitkan());
            pstBankGaransi.setDate(FLD_TGL_JATUH_TEMPO, entBankGaransi.getTglJatuhTempo());
            pstBankGaransi.setString(FLD_NO_AKAD_AWAL, entBankGaransi.getNoAkadAwal());
            pstBankGaransi.setDate(FLD_TGL_AKAD_AWAL, entBankGaransi.getTglAkadAwal());
            pstBankGaransi.setString(FLD_NO_AKAD_AKHIR, entBankGaransi.getNoAkadAkhir());
            pstBankGaransi.setDate(FLD_TGL_AKAD_AKHIR, entBankGaransi.getTglAkadAkhir());
            pstBankGaransi.setString(FLD_NAMA_YG_DIJAMIN, entBankGaransi.getNamaYgDijamin());
            pstBankGaransi.setString(FLD_KODE_VALUTA, entBankGaransi.getKodeValuta());
            pstBankGaransi.setDouble(FLD_PLAFON, entBankGaransi.getPlafon());
            pstBankGaransi.setDouble(FLD_NOMINAL, entBankGaransi.getNominal());
            pstBankGaransi.setDouble(FLD_SETORAN_JAMINAN, entBankGaransi.getSetoranJaminan());
            pstBankGaransi.setString(FLD_KODE_KOLEKTIBILITAS, entBankGaransi.getKodeKolektibilitas());
            pstBankGaransi.setDate(FLD_TGL_WAN_PRESTASI, entBankGaransi.getTglWanPrestasi());
            pstBankGaransi.setString(FLD_KODE_KONDISI, entBankGaransi.getKodeKondisi());
            pstBankGaransi.setDate(FLD_TGL_KONDISI, entBankGaransi.getTglKondisi());
            pstBankGaransi.setString(FLD_KETERANGAN, entBankGaransi.getKeterangan());
            pstBankGaransi.setString(FLD_KODE_KANTOR_CABANG, entBankGaransi.getKodeKantorCabang());
            pstBankGaransi.setString(FLD_OPERASI_DATA, entBankGaransi.getOperasiData());
            pstBankGaransi.setDate(FLD_OPEN_DATE, entBankGaransi.getOpenDate());
            pstBankGaransi.setInt(FLD_STATUS_DATA, entBankGaransi.getStatusData());
            pstBankGaransi.setLong(FLD_PERIODE_ID, entBankGaransi.getPeriodeid());
            
            pstBankGaransi.setInt(FLD_STATUS_PERUBAHAN_DATA, entBankGaransi.getStatusPerubahanData());
            
            pstBankGaransi.insert();
            
            pstBankGaransi.setSqlQueryHistory("");
            pstBankGaransi.setSqlQueryHistory(pstBankGaransi.getInsertSQL());
                
            entBankGaransi.setOID(pstBankGaransi.getlong(FLD_BANK_GARANSI_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBankGaransi(0), DBException.UNKNOWN);
        }
        return entBankGaransi.getOID();
    }
    
    public static synchronized BankGaransi insertExcObj(BankGaransi entBankGaransi) throws DBException {
        try {
            PstBankGaransi pstBankGaransi = new PstBankGaransi(0);
            pstBankGaransi.setString(FLD_FLAG_DETAIL, entBankGaransi.getFlagDetail());
            pstBankGaransi.setString(FLD_NO_REKENING, entBankGaransi.getNoRekening());
            pstBankGaransi.setString(FLD_CIF, entBankGaransi.getCif());
            pstBankGaransi.setString(FLD_KODE_JENIS_GARANSI, entBankGaransi.getKodeJenisGaransi());
            pstBankGaransi.setString(FLD_KODE_TUJUAN_GARANSI, entBankGaransi.getKodeTujuanGaransi());
            pstBankGaransi.setDate(FLD_TGL_DITERBITKAN, entBankGaransi.getTglDiterbitkan());
            pstBankGaransi.setDate(FLD_TGL_JATUH_TEMPO, entBankGaransi.getTglJatuhTempo());
            pstBankGaransi.setString(FLD_NO_AKAD_AWAL, entBankGaransi.getNoAkadAwal());
            pstBankGaransi.setDate(FLD_TGL_AKAD_AWAL, entBankGaransi.getTglAkadAwal());
            pstBankGaransi.setString(FLD_NO_AKAD_AKHIR, entBankGaransi.getNoAkadAkhir());
            pstBankGaransi.setDate(FLD_TGL_AKAD_AKHIR, entBankGaransi.getTglAkadAkhir());
            pstBankGaransi.setString(FLD_NAMA_YG_DIJAMIN, entBankGaransi.getNamaYgDijamin());
            pstBankGaransi.setString(FLD_KODE_VALUTA, entBankGaransi.getKodeValuta());
            pstBankGaransi.setDouble(FLD_PLAFON, entBankGaransi.getPlafon());
            pstBankGaransi.setDouble(FLD_NOMINAL, entBankGaransi.getNominal());
            pstBankGaransi.setDouble(FLD_SETORAN_JAMINAN, entBankGaransi.getSetoranJaminan());
            pstBankGaransi.setString(FLD_KODE_KOLEKTIBILITAS, entBankGaransi.getKodeKolektibilitas());
            pstBankGaransi.setDate(FLD_TGL_WAN_PRESTASI, entBankGaransi.getTglWanPrestasi());
            pstBankGaransi.setString(FLD_KODE_KONDISI, entBankGaransi.getKodeKondisi());
            pstBankGaransi.setDate(FLD_TGL_KONDISI, entBankGaransi.getTglKondisi());
            pstBankGaransi.setString(FLD_KETERANGAN, entBankGaransi.getKeterangan());
            pstBankGaransi.setString(FLD_KODE_KANTOR_CABANG, entBankGaransi.getKodeKantorCabang());
            pstBankGaransi.setString(FLD_OPERASI_DATA, entBankGaransi.getOperasiData());
            pstBankGaransi.setDate(FLD_OPEN_DATE, entBankGaransi.getOpenDate());
            pstBankGaransi.setInt(FLD_STATUS_DATA, entBankGaransi.getStatusData());
            pstBankGaransi.setLong(FLD_PERIODE_ID, entBankGaransi.getPeriodeid());
            
            pstBankGaransi.setInt(FLD_STATUS_PERUBAHAN_DATA, entBankGaransi.getStatusPerubahanData());
            
            pstBankGaransi.insert();
            
            pstBankGaransi.setSqlQueryHistory("");
            pstBankGaransi.setSqlQueryHistory(pstBankGaransi.getInsertSQL());
            
            entBankGaransi.setSqlHistory(pstBankGaransi.getInsertSQL());
                
            entBankGaransi.setOID(pstBankGaransi.getlong(FLD_BANK_GARANSI_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstBankGaransi(0), DBException.UNKNOWN);
        }
        return entBankGaransi;
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((BankGaransi) entity);
    }

    public static void resultToObject(ResultSet rs, BankGaransi entBankGaransi) {
        try {
            entBankGaransi.setOID(rs.getLong(PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID]));
            entBankGaransi.setFlagDetail(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_FLAG_DETAIL]));
            entBankGaransi.setNoRekening(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]));
            entBankGaransi.setCif(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_CIF]));
            entBankGaransi.setKodeJenisGaransi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_JENIS_GARANSI]));
            entBankGaransi.setKodeTujuanGaransi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_TUJUAN_GARANSI]));
            entBankGaransi.setTglDiterbitkan(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_DITERBITKAN]));
            entBankGaransi.setTglJatuhTempo(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_JATUH_TEMPO]));
            entBankGaransi.setNoAkadAwal(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_AKAD_AWAL]));
            entBankGaransi.setTglAkadAwal(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_AKAD_AWAL]));
            entBankGaransi.setNoAkadAkhir(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_AKAD_AKHIR]));
            entBankGaransi.setTglAkadAkhir(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_AKAD_AKHIR]));
            entBankGaransi.setNamaYgDijamin(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NAMA_YG_DIJAMIN]));
            entBankGaransi.setKodeValuta(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_VALUTA]));
            entBankGaransi.setPlafon(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_PLAFON]));
            entBankGaransi.setNominal(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NOMINAL]));
            entBankGaransi.setSetoranJaminan(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_SETORAN_JAMINAN]));
            entBankGaransi.setKodeKolektibilitas(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KOLEKTIBILITAS]));
            entBankGaransi.setTglWanPrestasi(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_WAN_PRESTASI]));
            entBankGaransi.setKodeKondisi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KONDISI]));
            entBankGaransi.setTglKondisi(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_KONDISI]));
            entBankGaransi.setKeterangan(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KETERANGAN]));
            entBankGaransi.setKodeKantorCabang(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KANTOR_CABANG]));
            entBankGaransi.setOperasiData(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_OPERASI_DATA]));
            entBankGaransi.setOpenDate(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_OPEN_DATE]));
            entBankGaransi.setStatusData(rs.getInt(PstBankGaransi.fieldNames[PstBankGaransi.FLD_STATUS_DATA]));
            entBankGaransi.setPeriodeid(rs.getLong(fieldNames[FLD_PERIODE_ID]));
            entBankGaransi.setStatusOperasiData(rs.getInt("STATUS_OPERASI_DATA"));

        } catch (Exception e) {
        }
    }
    
    
    public static void resultToObjectParentCabang(ResultSet rs, BankGaransi entBankGaransi) {
        try {
            entBankGaransi.setOID(rs.getLong(PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID]));
            entBankGaransi.setFlagDetail(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_FLAG_DETAIL]));
            entBankGaransi.setNoRekening(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]));
            entBankGaransi.setCif(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_CIF]));
            entBankGaransi.setKodeJenisGaransi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_JENIS_GARANSI]));
            entBankGaransi.setKodeTujuanGaransi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_TUJUAN_GARANSI]));
            entBankGaransi.setTglDiterbitkan(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_DITERBITKAN]));
            entBankGaransi.setTglJatuhTempo(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_JATUH_TEMPO]));
            entBankGaransi.setNoAkadAwal(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_AKAD_AWAL]));
            entBankGaransi.setTglAkadAwal(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_AKAD_AWAL]));
            entBankGaransi.setNoAkadAkhir(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_AKAD_AKHIR]));
            entBankGaransi.setTglAkadAkhir(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_AKAD_AKHIR]));
            entBankGaransi.setNamaYgDijamin(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NAMA_YG_DIJAMIN]));
            entBankGaransi.setKodeValuta(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_VALUTA]));
            entBankGaransi.setPlafon(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_PLAFON]));
            entBankGaransi.setNominal(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NOMINAL]));
            entBankGaransi.setSetoranJaminan(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_SETORAN_JAMINAN]));
            entBankGaransi.setKodeKolektibilitas(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KOLEKTIBILITAS]));
            entBankGaransi.setTglWanPrestasi(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_WAN_PRESTASI]));
            entBankGaransi.setKodeKondisi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KONDISI]));
            entBankGaransi.setTglKondisi(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_KONDISI]));
            entBankGaransi.setKeterangan(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KETERANGAN]));
            entBankGaransi.setKodeKantorCabang(rs.getString("PARENT_CODE"));
            entBankGaransi.setOperasiData(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_OPERASI_DATA]));
            entBankGaransi.setOpenDate(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_OPEN_DATE]));
            entBankGaransi.setStatusData(rs.getInt(PstBankGaransi.fieldNames[PstBankGaransi.FLD_STATUS_DATA]));
            entBankGaransi.setPeriodeid(rs.getLong(fieldNames[FLD_PERIODE_ID]));
            entBankGaransi.setStatusOperasiData(rs.getInt("STATUS_OPERASI_DATA"));

        } catch (Exception e) {
        }
    }
    
    public static void resultToObjectJoin(ResultSet rs, BankGaransi entBankGaransi) {
        try {
            entBankGaransi.setOID(rs.getLong(PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID]));
            entBankGaransi.setFlagDetail(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_FLAG_DETAIL]));
            entBankGaransi.setNoRekening(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]));
            entBankGaransi.setCif(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_CIF]));
            entBankGaransi.setKodeJenisGaransi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_JENIS_GARANSI]));
            entBankGaransi.setKodeTujuanGaransi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_TUJUAN_GARANSI]));
            entBankGaransi.setTglDiterbitkan(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_DITERBITKAN]));
            entBankGaransi.setTglJatuhTempo(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_JATUH_TEMPO]));
            entBankGaransi.setNoAkadAwal(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_AKAD_AWAL]));
            entBankGaransi.setTglAkadAwal(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_AKAD_AWAL]));
            entBankGaransi.setNoAkadAkhir(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_AKAD_AKHIR]));
            entBankGaransi.setTglAkadAkhir(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_AKAD_AKHIR]));
            entBankGaransi.setNamaYgDijamin(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NAMA_YG_DIJAMIN]));
            entBankGaransi.setKodeValuta(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_VALUTA]));
            entBankGaransi.setPlafon(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_PLAFON]));
            entBankGaransi.setNominal(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NOMINAL]));
            entBankGaransi.setSetoranJaminan(rs.getDouble(PstBankGaransi.fieldNames[PstBankGaransi.FLD_SETORAN_JAMINAN]));
            entBankGaransi.setKodeKolektibilitas(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KOLEKTIBILITAS]));
            entBankGaransi.setTglWanPrestasi(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_WAN_PRESTASI]));
            entBankGaransi.setKodeKondisi(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KONDISI]));
            entBankGaransi.setTglKondisi(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_KONDISI]));
            entBankGaransi.setKeterangan(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KETERANGAN]));
            entBankGaransi.setKodeKantorCabang(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KANTOR_CABANG]));
            entBankGaransi.setOperasiData(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_OPERASI_DATA]));
            entBankGaransi.setOpenDate(rs.getDate(PstBankGaransi.fieldNames[PstBankGaransi.FLD_OPEN_DATE]));
            entBankGaransi.setStatusData(rs.getInt(PstBankGaransi.fieldNames[PstBankGaransi.FLD_STATUS_DATA]));
            entBankGaransi.setJenisGaransi(rs.getString(PstContentDataJenisGaransi.fieldNames[PstContentDataJenisGaransi.FLD_JENIS_GARANSI]));
            entBankGaransi.setTujuanGaransi(rs.getString(PstContentDataTujuanGaransi.fieldNames[PstContentDataTujuanGaransi.FLD_TUJUAN_GARANSI]));
            entBankGaransi.setPeriodeid(rs.getLong(PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]));
            entBankGaransi.setDebiturOid(rs.getLong(PstDebitur.fieldNames[PstDebitur.FLD_DEBITUR_OID]));
            entBankGaransi.setDebiturType(rs.getInt(PstDebitur.fieldNames[PstDebitur.FLD_KODE_JENIS_NSB]));
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
            String sql = "SELECT DISTINCT "
                      + "TRIM(BANK_GARANSI_OID) AS BANK_GARANSI_OID," +
                        "TRIM(FLAG_DETAIL) AS FLAG_DETAIL," +
                        "TRIM(NO_REKENING) AS NO_REKENING," +
                        "TRIM(CIF) AS CIF," +
                        "TRIM(KODE_JENIS_GARANSI) AS KODE_JENIS_GARANSI," +
                        "TRIM(KODE_TUJUAN_GARANSI) AS KODE_TUJUAN_GARANSI," +
                        "TRIM(TGL_DITERBITKAN) AS TGL_DITERBITKAN," +
                        "TRIM(TGL_JATUH_TEMPO) AS TGL_JATUH_TEMPO," +
                        "TRIM(NO_AKAD_AWAL) AS NO_AKAD_AWAL," +
                        "TRIM(TGL_AKAD_AWAL) AS TGL_AKAD_AWAL," +
                        "TRIM(NO_AKAD_AKHIR) AS NO_AKAD_AKHIR," +
                        "TRIM(TGL_AKAD_AKHIR) AS TGL_AKAD_AKHIR," +
                        "TRIM(NAMA_YG_DIJAMIN) AS NAMA_YG_DIJAMIN," +
                        "TRIM(KODE_VALUTA) AS KODE_VALUTA," +
                        "TRIM(PLAFON) AS PLAFON," +
                        "TRIM(NOMINAL) AS NOMINAL," +
                        "TRIM(SETORAN_JAMINAN) AS SETORAN_JAMINAN," +
                        "TRIM(KODE_KOLEKTIBILITAS) AS KODE_KOLEKTIBILITAS," +
                        "TRIM(TGL_WAN_PRESTASI) AS TGL_WAN_PRESTASI," +
                        "TRIM(KODE_KONDISI) AS KODE_KONDISI," +
                        "TRIM(TGL_KONDISI) AS TGL_KONDISI," +
                        "TRIM(KETERANGAN) AS KETERANGAN," +
                        "TRIM(KODE_KANTOR_CABANG) AS KODE_KANTOR_CABANG," +
                        "TRIM(OPERASI_DATA) AS OPERASI_DATA," +
                        "TRIM(OPEN_DATE) AS OPEN_DATE," +
                        "TRIM(STATUS_DATA) AS STATUS_DATA," +
                        "TRIM(PERIODE_ID) AS PERIODE_ID, STATUS_OPERASI_DATA "
                    + " FROM " + TBL_BANK_GARANSI;
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
                BankGaransi entBankGaransi = new BankGaransi();
                resultToObject(rs, entBankGaransi);
                lists.add(entBankGaransi);
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
    
    public static Vector listJoinParentCabang(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT "
                      + "TRIM(BANK_GARANSI_OID) AS BANK_GARANSI_OID," +
                        "TRIM(FLAG_DETAIL) AS FLAG_DETAIL," +
                        "TRIM(NO_REKENING) AS NO_REKENING," +
                        "TRIM(CIF) AS CIF," +
                        "TRIM(KODE_JENIS_GARANSI) AS KODE_JENIS_GARANSI," +
                        "TRIM(KODE_TUJUAN_GARANSI) AS KODE_TUJUAN_GARANSI," +
                        "TRIM(TGL_DITERBITKAN) AS TGL_DITERBITKAN," +
                        "TRIM(TGL_JATUH_TEMPO) AS TGL_JATUH_TEMPO," +
                        "TRIM(NO_AKAD_AWAL) AS NO_AKAD_AWAL," +
                        "TRIM(TGL_AKAD_AWAL) AS TGL_AKAD_AWAL," +
                        "TRIM(NO_AKAD_AKHIR) AS NO_AKAD_AKHIR," +
                        "TRIM(TGL_AKAD_AKHIR) AS TGL_AKAD_AKHIR," +
                        "TRIM(NAMA_YG_DIJAMIN) AS NAMA_YG_DIJAMIN," +
                        "TRIM(KODE_VALUTA) AS KODE_VALUTA," +
                        "TRIM(PLAFON) AS PLAFON," +
                        "TRIM(NOMINAL) AS NOMINAL," +
                        "TRIM(SETORAN_JAMINAN) AS SETORAN_JAMINAN," +
                        "TRIM(KODE_KOLEKTIBILITAS) AS KODE_KOLEKTIBILITAS," +
                        "TRIM(TGL_WAN_PRESTASI) AS TGL_WAN_PRESTASI," +
                        "TRIM(KODE_KONDISI) AS KODE_KONDISI," +
                        "TRIM(TGL_KONDISI) AS TGL_KONDISI," +
                        "TRIM(KETERANGAN) AS KETERANGAN," +
                        "TRIM(KODE_KANTOR_CABANG) AS KODE_KANTOR_CABANG," +
                        "TRIM(OPERASI_DATA) AS OPERASI_DATA," +
                        "TRIM(OPEN_DATE) AS OPEN_DATE," +
                        "TRIM(STATUS_DATA) AS STATUS_DATA," +
                        "TRIM(PERIODE_ID) AS PERIODE_ID, STATUS_OPERASI_DATA, "
                    //+ " FROM " + TBL_BANK_GARANSI;
                      + "TRIM(PARENT_CODE) AS PARENT_CODE "  
                      + "FROM " + TBL_BANK_GARANSI+" "
                      + "INNER JOIN dslik_cabang_bank ON "+TBL_BANK_GARANSI+"."+fieldNames[FLD_KODE_KANTOR_CABANG]+"=dslik_cabang_bank.KODE_CABANG";
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
                BankGaransi entBankGaransi = new BankGaransi();
                resultToObjectParentCabang(rs, entBankGaransi);
                lists.add(entBankGaransi);
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
    
    public static Vector listDistinct(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT TRIM(SUBSTRING(NO_REKENING,6,2)) AS NO_REKENING FROM " + TBL_BANK_GARANSI;
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
                BankGaransi entBankGaransi = new BankGaransi();
                entBankGaransi.setNoRekening(rs.getString(PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]));
                lists.add(entBankGaransi);
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
            String sql = ""
                + " SELECT DISTINCT bg.*, "
                + " tg."+PstContentDataTujuanGaransi.fieldNames[PstContentDataTujuanGaransi.FLD_TUJUAN_GARANSI]+", "
                + " jg."+PstContentDataJenisGaransi.fieldNames[PstContentDataJenisGaransi.FLD_JENIS_GARANSI]+", "
                + " debitur."+PstDebitur.fieldNames[PstDebitur.FLD_DEBITUR_OID]+","
                + " debitur."+PstDebitur.fieldNames[PstDebitur.FLD_KODE_JENIS_NSB]+" "
                + " FROM "+TBL_BANK_GARANSI+" bg "
                + " LEFT JOIN "+PstContentDataTujuanGaransi.TBL_CONTENT_DATA_TUJUAN_GARANSI+" tg "
                + " ON bg."+fieldNames[FLD_KODE_TUJUAN_GARANSI]+" = tg."+PstContentDataTujuanGaransi.fieldNames[PstContentDataTujuanGaransi.FLD_KODE_OJK]+" "
                + " LEFT JOIN "+PstContentDataJenisGaransi.TBL_CONTENT_DATA_JENIS_GARANSI+" jg "
                + " ON bg."+fieldNames[FLD_KODE_JENIS_GARANSI]+" = jg."+PstContentDataJenisGaransi.fieldNames[PstContentDataJenisGaransi.FLD_KODE_OJK]+" "
                + " INNER JOIN "+PstPeriode.TBL_PERIODE+" AS periode "
                + " ON bg."+fieldNames[FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+" "
                + " AND periode."+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0' "
                + " INNER JOIN "+PstDebitur.TBL_DEBITUR_INDIVIDU+" AS debitur "
                + " ON bg."+fieldNames[FLD_CIF]+"=debitur."+PstDebitur.fieldNames[PstDebitur.FLD_CIF]+" "
                + " AND debitur."+PstDebitur.fieldNames[PstDebitur.FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID];
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
                BankGaransi entBankGaransi = new BankGaransi();
                resultToObjectJoin(rs, entBankGaransi);
                lists.add(entBankGaransi);
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
    
    
    public static Vector listSummaryBankGaransi(String kodeKantorCabang, String tglAwal, String tglAkhir, long periodeId) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
           String sql = "SELECT  " +
                        "'00' AS KODE,'LUNAS' AS NAMA, COUNT(dslik_bank_garansi.NO_REKENING) AS TOT, SUM(dslik_bank_garansi.NOMINAL) AS NOMINAL  " +
                        "FROM dslik_bank_garansi  " +
                        "WHERE  " +
                        "kode_kondisi='02' AND KODE_KANTOR_CABANG='"+kodeKantorCabang+"' " +
                        "AND TGL_JATUH_TEMPO BETWEEN '"+tglAwal+"' AND '"+tglAkhir+"' AND dslik_bank_garansi.PERIODE_ID='"+periodeId+"' " +
                        "UNION  " +
                        "SELECT  " +
                        "'02' AS KODE, 'ACTIVE' AS NAMA, COUNT(dslik_bank_garansi.NO_REKENING) AS TOT, SUM(dslik_bank_garansi.NOMINAL) AS NOMINAL " +
                        "FROM dslik_bank_garansi  " +
                        "WHERE (kode_kondisi='00' OR (kode_kondisi='02' AND TGL_JATUH_TEMPO > '"+tglAkhir+"')) AND KODE_KANTOR_CABANG='"+kodeKantorCabang+"' AND dslik_bank_garansi.PERIODE_ID='"+periodeId+"' " +
                        "UNION  " +
                        "SELECT  " +
                        "'' AS KODE, 'LAIN-LAIN' AS NAMA, COUNT(dslik_bank_garansi.NO_REKENING) AS TOT, SUM(dslik_bank_garansi.NOMINAL) AS NOMINAL " +
                        "FROM dslik_bank_garansi  " +
                        "WHERE (kode_kondisi!='00' AND kode_kondisi!='02') AND KODE_KANTOR_CABANG='"+kodeKantorCabang+"' AND dslik_bank_garansi.PERIODE_ID='"+periodeId+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                BankGaransi entBankGaransi = new BankGaransi();
                entBankGaransi.setKodeBankGransiReport(rs.getString("KODE"));
                entBankGaransi.setNamaBankGaransiReport(rs.getString("NAMA"));
                entBankGaransi.setTotalBankGaransi(rs.getInt("TOT"));
                entBankGaransi.setTotNominalBankGaransi(rs.getDouble("NOMINAL"));
                lists.add(entBankGaransi);
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


    public static Vector listSummaryBankGaransiLBU(String kodeKantorCabang, String tglAwal, String tglAkhir, long periodeId) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
           String sql = "SELECT * FROM (SELECT  " +
                        "'00' AS KODE,'LUNAS' AS NAMA, COUNT(dslik_bank_garansi.NO_REKENING) AS TOT, SUM(dslik_bank_garansi.NOMINAL) AS NOMINAL  " +
                        "FROM dslik_bank_garansi  " +
                        "WHERE  " +
                        "kode_kondisi='02' AND KODE_KANTOR_CABANG='"+kodeKantorCabang+"' " +
                        "AND TGL_JATUH_TEMPO BETWEEN '"+tglAwal+"' AND '"+tglAkhir+"' AND dslik_bank_garansi.PERIODE_ID='"+periodeId+"' " +
                        "UNION  " +
                        "SELECT  " +
                        "'02' AS KODE, 'ACTIVE' AS NAMA, COUNT(dslik_bank_garansi.NO_REKENING) AS TOT, SUM(dslik_bank_garansi.NOMINAL) AS NOMINAL " +
                        "FROM dslik_bank_garansi  " +
                        "WHERE (kode_kondisi='00' OR (kode_kondisi='02' AND TGL_JATUH_TEMPO > '"+tglAkhir+"')) AND KODE_KANTOR_CABANG='"+kodeKantorCabang+"' AND dslik_bank_garansi.PERIODE_ID='"+periodeId+"' " +
                        "UNION  " +
                        "SELECT  " +
                        "'' AS KODE, 'LAIN-LAIN' AS NAMA, COUNT(dslik_bank_garansi.NO_REKENING) AS TOT, SUM(dslik_bank_garansi.NOMINAL) AS NOMINAL " +
                        "FROM dslik_bank_garansi  " +
                        "WHERE (kode_kondisi!='00' AND kode_kondisi!='02') AND KODE_KANTOR_CABANG='"+kodeKantorCabang+"' AND dslik_bank_garansi.PERIODE_ID='"+periodeId+"'"
                   + ") AS TAB WHERE TAB.KODE='02'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                BankGaransi entBankGaransi = new BankGaransi();
                entBankGaransi.setKodeBankGransiReport(rs.getString("KODE"));
                entBankGaransi.setNamaBankGaransiReport(rs.getString("NAMA"));
                entBankGaransi.setTotalBankGaransi(rs.getInt("TOT"));
                entBankGaransi.setTotNominalBankGaransi(rs.getDouble("NOMINAL"));
                lists.add(entBankGaransi);
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

    public static boolean checkOID(long entBankGaransiId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT DISTINCT * FROM " + TBL_BANK_GARANSI + " WHERE "
                    + PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID] + " = " + entBankGaransiId;
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
            String sql = "SELECT DISTINCT COUNT(" + PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID] + ") FROM " + TBL_BANK_GARANSI;
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
            String sql = ""
                + " SELECT DISTINCT COUNT(DISTINCT bg." + PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID] + ") "
                + " FROM "+TBL_BANK_GARANSI+" bg "
                + " LEFT JOIN "+PstContentDataTujuanGaransi.TBL_CONTENT_DATA_TUJUAN_GARANSI+" tg "
                + " ON bg."+fieldNames[FLD_KODE_TUJUAN_GARANSI]+" = tg."+PstContentDataTujuanGaransi.fieldNames[PstContentDataTujuanGaransi.FLD_KODE_OJK]+" "
                + " LEFT JOIN "+PstContentDataJenisGaransi.TBL_CONTENT_DATA_JENIS_GARANSI+" jg "
                + " ON bg."+fieldNames[FLD_KODE_JENIS_GARANSI]+" = jg."+PstContentDataJenisGaransi.fieldNames[PstContentDataJenisGaransi.FLD_KODE_OJK]+""
                + " INNER JOIN "+PstPeriode.TBL_PERIODE+" AS periode "
                + " ON bg."+fieldNames[FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+" "
                + " AND periode."+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0' "
                + " INNER JOIN "+PstDebitur.TBL_DEBITUR_INDIVIDU+" AS debitur "
                + " ON bg."+fieldNames[FLD_CIF]+"=debitur."+PstDebitur.fieldNames[PstDebitur.FLD_CIF]+" "
                + " AND debitur."+PstDebitur.fieldNames[PstDebitur.FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID];
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
                    BankGaransi entBankGaransi = (BankGaransi) list.get(ls);
                    if (oid == entBankGaransi.getOID()) {
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
    
    public static long updateStatusData(long oidsegment) throws DBException {
        if(oidsegment==0){
            return 0;
        }
        int iResult = 0;
        DBResultSet dbrs = null;
        String stSql = "UPDATE "+TBL_BANK_GARANSI+" SET STATUS_DATA=0 WHERE "+fieldNames[FLD_BANK_GARANSI_OID]+"='"+oidsegment+"'";
        try {
            iResult = DBHandler.execUpdate(stSql);
        } catch (DBException e) {
            e.printStackTrace();
        } finally {
            DBResultSet.close(dbrs);
        }
        return iResult;
    }

    public static long updateStatusOperasiData(long oidDebitur, int statusOperasiData) throws DBException {
        if(oidDebitur==0){
            return 0;
        }
        int iResult = 0;
        DBResultSet dbrs = null;
        String stSql = "UPDATE "+TBL_BANK_GARANSI+" SET STATUS_OPERASI_DATA='"+statusOperasiData+"' WHERE "+PstBankGaransi.fieldNames[PstBankGaransi.FLD_BANK_GARANSI_OID]+"='"+oidDebitur+"'";
        try {
            iResult = DBHandler.execUpdate(stSql);
        } catch (DBException e) {
            e.printStackTrace();
        } finally {
            DBResultSet.close(dbrs);
        }
        return iResult;
    }
    
}
