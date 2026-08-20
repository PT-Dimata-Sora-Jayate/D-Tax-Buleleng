/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.inquery;

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

public class PstPbbIprotax extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_PBBIPROTAX = "VIEW_PBB";
    public static final String TBL_PBBIPROTAX_ALL = "VIEW_PBB_ALL";
    public static final int FLD_NOP = 0;
    public static final int FLD_KDPROVINSI = 1;
    public static final int FLD_KDDATI2 = 2;
    public static final int FLD_KDKECAMATAN = 3;
    public static final int FLD_KDKELURAHAN = 4;
    public static final int FLD_KDBLOCK = 5;
    public static final int FLD_NOURUT = 6;
    public static final int FLD_NOJNSOP = 7;
    public static final int FLD_THNPAJAKSPPT = 8;
    public static final int FLD_KDBANKTUNGGAL = 9;
    public static final int FLD_KDBANKPERSEPSI = 10;
    public static final int FLD_KDTP = 11;
    public static final int FLD_NPWPD = 12;
    public static final int FLD_NAMA = 13;
    public static final int FLD_JUMLAHTAGIHAN = 14;
    public static final int FLD_ALAMAT = 15;
    public static final int FLD_TAHUN = 16;
    public static final int FLD_TGLJATUHTEMPO = 17;
    public static final int FLD_LUASBUMI = 18;
    public static final int FLD_LUASBANGUNAN = 19;
    public static final int FLD_NJOPBUMI = 20;
    public static final int FLD_NJOPBANGUNAN = 21;
    public static final int FLD_NJOPTKP = 22;
    public static final int FLD_POKOK = 23;
    public static final int FLD_DENDA = 24;
    public static final int FLD_LETAK = 25;
    public static final int FLD_FORMULA = 26;
    public static final int FLD_TERBILANG = 27;
    public static final int FLD_INSTANSI = 28;

    public static String[] fieldNames = {
        "NOP",
        "KD_PROPINSI",
        "KD_DATI2",
        "KD_KECAMATAN",
        "KD_KELURAHAN",
        "KD_BLOK",
        "NO_URUT",
        "KD_JNS_OP",
        "THN_PAJAK_SPPT",
        "KD_BANK_TUNGGAL",
        "KD_BANK_PERSEPSI",
        "KD_TP",
        "NPWPD",
        "NAMA",
        "JUMLAH_TAGIHAN",
        "ALAMAT_WP",
        "TAHUN",
        "JATUH_TEMPO",
        "LUAS_BUMI_SPPT",
        "LUAS_BNG_SPPT",
        "NJOP_BUMI_SPPT",
        "NJOP_BNG_SPPT",
        "NJOPTKP_SPPT",
        "POKOK",
        "DENDA",
        "LETAK",
        "FORMULA",
        "TERBILANG",
        "INSTANSI"
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
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING
    };

    public PstPbbIprotax() {
    }

    public PstPbbIprotax(int i) throws DBException {
        super(new PstPbbIprotax());
    }

    public PstPbbIprotax(String sOid) throws DBException {
        super(new PstPbbIprotax(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPbbIprotax(long lOid) throws DBException {
        super(new PstPbbIprotax(0));
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
        return TBL_PBBIPROTAX;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPbbIprotax().getClass().getName();
    }

    public static PbbIprotax fetchExc(long oid) throws DBException {
        try {
            PbbIprotax entPbbIprotax = new PbbIprotax();
            PstPbbIprotax pstPbbIprotax = new PstPbbIprotax(oid);
            entPbbIprotax.setOID(oid);
            entPbbIprotax.setKdProvinsi(pstPbbIprotax.getString(FLD_KDPROVINSI));
            entPbbIprotax.setKdDati2(pstPbbIprotax.getString(FLD_KDDATI2));
            entPbbIprotax.setKdKecamatan(pstPbbIprotax.getString(FLD_KDKECAMATAN));
            entPbbIprotax.setKdKelurahan(pstPbbIprotax.getString(FLD_KDKELURAHAN));
            entPbbIprotax.setKdBlock(pstPbbIprotax.getString(FLD_KDBLOCK));
            entPbbIprotax.setNoUrut(pstPbbIprotax.getString(FLD_NOURUT));
            entPbbIprotax.setNoJnsOp(pstPbbIprotax.getString(FLD_NOJNSOP));
            entPbbIprotax.setThnPajakSppt(pstPbbIprotax.getString(FLD_THNPAJAKSPPT));
            entPbbIprotax.setKdBankTunggal(pstPbbIprotax.getString(FLD_KDBANKTUNGGAL));
            entPbbIprotax.setKdBankPersepsi(pstPbbIprotax.getString(FLD_KDBANKPERSEPSI));
            entPbbIprotax.setKdTp(pstPbbIprotax.getString(FLD_KDTP));
            entPbbIprotax.setNpwpd(pstPbbIprotax.getString(FLD_NPWPD));
            entPbbIprotax.setNama(pstPbbIprotax.getString(FLD_NAMA));
            entPbbIprotax.setJumlahTagihan(pstPbbIprotax.getString(FLD_JUMLAHTAGIHAN));
            entPbbIprotax.setAlamat(pstPbbIprotax.getString(FLD_ALAMAT));
            entPbbIprotax.setTahun(pstPbbIprotax.getString(FLD_TAHUN));
            entPbbIprotax.setTglJatuhTempo(pstPbbIprotax.getString(FLD_TGLJATUHTEMPO));
            entPbbIprotax.setLuasBumi(pstPbbIprotax.getString(FLD_LUASBUMI));
            entPbbIprotax.setLuasBangunan(pstPbbIprotax.getString(FLD_LUASBANGUNAN));
            entPbbIprotax.setnJOPBumi(pstPbbIprotax.getString(FLD_NJOPBUMI));
            entPbbIprotax.setnJOPBangunan(pstPbbIprotax.getString(FLD_NJOPBANGUNAN));
            entPbbIprotax.setnJOPTKP(pstPbbIprotax.getString(FLD_NJOPTKP));
            entPbbIprotax.setPokok(pstPbbIprotax.getString(FLD_POKOK));
            entPbbIprotax.setDenda(pstPbbIprotax.getString(FLD_DENDA));
            entPbbIprotax.setLetak(pstPbbIprotax.getString(FLD_LETAK));
            entPbbIprotax.setFormula(pstPbbIprotax.getString(FLD_FORMULA));
            entPbbIprotax.setTerbilang(pstPbbIprotax.getString(FLD_TERBILANG));
            entPbbIprotax.setInstansi(pstPbbIprotax.getString(FLD_INSTANSI));
            return entPbbIprotax;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPbbIprotax(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        PbbIprotax entPbbIprotax = fetchExc(entity.getOID());
        entity = (Entity) entPbbIprotax;
        return entPbbIprotax.getOID();
    }

    public static synchronized long updateExc(PbbIprotax entPbbIprotax) throws DBException {
        try {
            if (entPbbIprotax.getOID() != 0) {
                PstPbbIprotax pstPbbIprotax = new PstPbbIprotax(entPbbIprotax.getOID());
                pstPbbIprotax.setString(FLD_KDPROVINSI, entPbbIprotax.getKdProvinsi());
                pstPbbIprotax.setString(FLD_KDDATI2, entPbbIprotax.getKdDati2());
                pstPbbIprotax.setString(FLD_KDKECAMATAN, entPbbIprotax.getKdKecamatan());
                pstPbbIprotax.setString(FLD_KDKELURAHAN, entPbbIprotax.getKdKelurahan());
                pstPbbIprotax.setString(FLD_KDBLOCK, entPbbIprotax.getKdBlock());
                pstPbbIprotax.setString(FLD_NOURUT, entPbbIprotax.getNoUrut());
                pstPbbIprotax.setString(FLD_NOJNSOP, entPbbIprotax.getNoJnsOp());
                pstPbbIprotax.setString(FLD_THNPAJAKSPPT, entPbbIprotax.getThnPajakSppt());
                pstPbbIprotax.setString(FLD_KDBANKTUNGGAL, entPbbIprotax.getKdBankTunggal());
                pstPbbIprotax.setString(FLD_KDBANKPERSEPSI, entPbbIprotax.getKdBankPersepsi());
                pstPbbIprotax.setString(FLD_KDTP, entPbbIprotax.getKdTp());
                pstPbbIprotax.setString(FLD_NPWPD, entPbbIprotax.getNpwpd());
                pstPbbIprotax.setString(FLD_NAMA, entPbbIprotax.getNama());
                pstPbbIprotax.setString(FLD_JUMLAHTAGIHAN, entPbbIprotax.getJumlahTagihan());
                pstPbbIprotax.setString(FLD_ALAMAT, entPbbIprotax.getAlamat());
                pstPbbIprotax.setString(FLD_TAHUN, entPbbIprotax.getTahun());
                pstPbbIprotax.setString(FLD_TGLJATUHTEMPO, entPbbIprotax.getTglJatuhTempo());
                pstPbbIprotax.setString(FLD_LUASBUMI, entPbbIprotax.getLuasBumi());
                pstPbbIprotax.setString(FLD_LUASBANGUNAN, entPbbIprotax.getLuasBangunan());
                pstPbbIprotax.setString(FLD_NJOPBUMI, entPbbIprotax.getnJOPBumi());
                pstPbbIprotax.setString(FLD_NJOPBANGUNAN, entPbbIprotax.getnJOPBangunan());
                pstPbbIprotax.setString(FLD_NJOPTKP, entPbbIprotax.getnJOPTKP());
                pstPbbIprotax.setString(FLD_POKOK, entPbbIprotax.getPokok());
                pstPbbIprotax.setString(FLD_DENDA, entPbbIprotax.getDenda());
                pstPbbIprotax.setString(FLD_LETAK, entPbbIprotax.getLetak());
                pstPbbIprotax.setString(FLD_FORMULA, entPbbIprotax.getFormula());
                pstPbbIprotax.setString(FLD_TERBILANG, entPbbIprotax.getTerbilang());
                pstPbbIprotax.setString(FLD_INSTANSI, entPbbIprotax.getInstansi());
                pstPbbIprotax.update();
                return entPbbIprotax.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPbbIprotax(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((PbbIprotax) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPbbIprotax pstPbbIprotax = new PstPbbIprotax(oid);
            pstPbbIprotax.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPbbIprotax(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(PbbIprotax entPbbIprotax) throws DBException {
        try {
            PstPbbIprotax pstPbbIprotax = new PstPbbIprotax(0);
            pstPbbIprotax.setString(FLD_KDPROVINSI, entPbbIprotax.getKdProvinsi());
            pstPbbIprotax.setString(FLD_KDDATI2, entPbbIprotax.getKdDati2());
            pstPbbIprotax.setString(FLD_KDKECAMATAN, entPbbIprotax.getKdKecamatan());
            pstPbbIprotax.setString(FLD_KDKELURAHAN, entPbbIprotax.getKdKelurahan());
            pstPbbIprotax.setString(FLD_KDBLOCK, entPbbIprotax.getKdBlock());
            pstPbbIprotax.setString(FLD_NOURUT, entPbbIprotax.getNoUrut());
            pstPbbIprotax.setString(FLD_NOJNSOP, entPbbIprotax.getNoJnsOp());
            pstPbbIprotax.setString(FLD_THNPAJAKSPPT, entPbbIprotax.getThnPajakSppt());
            pstPbbIprotax.setString(FLD_KDBANKTUNGGAL, entPbbIprotax.getKdBankTunggal());
            pstPbbIprotax.setString(FLD_KDBANKPERSEPSI, entPbbIprotax.getKdBankPersepsi());
            pstPbbIprotax.setString(FLD_KDTP, entPbbIprotax.getKdTp());
            pstPbbIprotax.setString(FLD_NPWPD, entPbbIprotax.getNpwpd());
            pstPbbIprotax.setString(FLD_NAMA, entPbbIprotax.getNama());
            pstPbbIprotax.setString(FLD_JUMLAHTAGIHAN, entPbbIprotax.getJumlahTagihan());
            pstPbbIprotax.setString(FLD_ALAMAT, entPbbIprotax.getAlamat());
            pstPbbIprotax.setString(FLD_TAHUN, entPbbIprotax.getTahun());
            pstPbbIprotax.setString(FLD_TGLJATUHTEMPO, entPbbIprotax.getTglJatuhTempo());
            pstPbbIprotax.setString(FLD_LUASBUMI, entPbbIprotax.getLuasBumi());
            pstPbbIprotax.setString(FLD_LUASBANGUNAN, entPbbIprotax.getLuasBangunan());
            pstPbbIprotax.setString(FLD_NJOPBUMI, entPbbIprotax.getnJOPBumi());
            pstPbbIprotax.setString(FLD_NJOPBANGUNAN, entPbbIprotax.getnJOPBangunan());
            pstPbbIprotax.setString(FLD_NJOPTKP, entPbbIprotax.getnJOPTKP());
            pstPbbIprotax.setString(FLD_POKOK, entPbbIprotax.getPokok());
            pstPbbIprotax.setString(FLD_DENDA, entPbbIprotax.getDenda());
            pstPbbIprotax.setString(FLD_LETAK, entPbbIprotax.getLetak());
            pstPbbIprotax.setString(FLD_FORMULA, entPbbIprotax.getFormula());
            pstPbbIprotax.setString(FLD_TERBILANG, entPbbIprotax.getTerbilang());
            pstPbbIprotax.setString(FLD_INSTANSI, entPbbIprotax.getInstansi());
            pstPbbIprotax.insert();
            entPbbIprotax.setOID(pstPbbIprotax.getLong(FLD_NOP));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPbbIprotax(0), DBException.UNKNOWN);
        }
        return entPbbIprotax.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((PbbIprotax) entity);
    }

    public static void resultToObject(ResultSet rs, PbbIprotax entPbbIprotax) {
        try {

            entPbbIprotax.setNop(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOP]));
            entPbbIprotax.setKdProvinsi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDPROVINSI]));
            entPbbIprotax.setKdDati2(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDDATI2]));
            entPbbIprotax.setKdKecamatan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDKECAMATAN]));
            entPbbIprotax.setKdKelurahan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDKELURAHAN]));
            entPbbIprotax.setKdBlock(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDBLOCK]));
            entPbbIprotax.setNoUrut(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOURUT]));
            entPbbIprotax.setNoJnsOp(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOJNSOP]));
            entPbbIprotax.setThnPajakSppt(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_THNPAJAKSPPT]));
            entPbbIprotax.setKdBankTunggal(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDBANKTUNGGAL]));
            entPbbIprotax.setKdBankPersepsi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDBANKPERSEPSI]));
            entPbbIprotax.setKdTp(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDTP]));
            entPbbIprotax.setNpwpd(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NPWPD]));
            entPbbIprotax.setNama(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NAMA]));
            entPbbIprotax.setJumlahTagihan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_JUMLAHTAGIHAN]));
            entPbbIprotax.setAlamat(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_ALAMAT]));
            entPbbIprotax.setTahun(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TAHUN]));
            entPbbIprotax.setTglJatuhTempo(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TGLJATUHTEMPO]));
            entPbbIprotax.setLuasBumi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_LUASBUMI]));
            entPbbIprotax.setLuasBangunan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_LUASBANGUNAN]));
            entPbbIprotax.setnJOPBumi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NJOPBUMI]));
            entPbbIprotax.setnJOPBangunan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NJOPBANGUNAN]));
            entPbbIprotax.setnJOPTKP(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NJOPTKP]));
            entPbbIprotax.setPokok(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_POKOK]));
            entPbbIprotax.setDenda(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_DENDA]));
            entPbbIprotax.setLetak(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_LETAK]));
            entPbbIprotax.setFormula(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_FORMULA]));
            entPbbIprotax.setTerbilang(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TERBILANG]));
            entPbbIprotax.setInstansi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_INSTANSI]));
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
            String sql = "SELECT * FROM " + TBL_PBBIPROTAX;
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
                PbbIprotax entPbbIprotax = new PbbIprotax();
                resultToObject(rs, entPbbIprotax);
                lists.add(entPbbIprotax);
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

    public static boolean checkOID(long entPbbIprotaxId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_PBBIPROTAX + " WHERE "
                    + PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOP] + " = " + entPbbIprotaxId;
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
    
    
     public static PbbIprotax checkNOp(String  entNop, String tahun) {
        DBResultSet dbrs = null;
        PbbIprotax entPbbIprotax = null;
        try {
            String sql = "SELECT * FROM " + TBL_PBBIPROTAX_ALL + " WHERE "
                    + PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOP] + " = '" + entNop+"' AND "
                    + PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TAHUN] + " = '" + tahun+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                entPbbIprotax=new PbbIprotax();
                entPbbIprotax.setNop(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOP]));
                entPbbIprotax.setKdProvinsi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDPROVINSI]));
                entPbbIprotax.setKdDati2(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDDATI2]));
                entPbbIprotax.setKdKecamatan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDKECAMATAN]));
                entPbbIprotax.setKdKelurahan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDKELURAHAN]));
                entPbbIprotax.setKdBlock(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDBLOCK]));
                entPbbIprotax.setNoUrut(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOURUT]));
                entPbbIprotax.setNoJnsOp(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOJNSOP]));
                entPbbIprotax.setThnPajakSppt(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_THNPAJAKSPPT]));
                entPbbIprotax.setKdBankTunggal(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDBANKTUNGGAL]));
                entPbbIprotax.setKdBankPersepsi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDBANKPERSEPSI]));
                entPbbIprotax.setKdTp(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_KDTP]));
                entPbbIprotax.setNpwpd(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NPWPD]));
                entPbbIprotax.setNama(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NAMA]));
                entPbbIprotax.setJumlahTagihan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_JUMLAHTAGIHAN]));
                entPbbIprotax.setAlamat(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_ALAMAT]));
                entPbbIprotax.setTahun(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TAHUN]));
                entPbbIprotax.setTglJatuhTempo(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TGLJATUHTEMPO]));
                entPbbIprotax.setLuasBumi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_LUASBUMI]));
                entPbbIprotax.setLuasBangunan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_LUASBANGUNAN]));
                entPbbIprotax.setnJOPBumi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NJOPBUMI]));
                entPbbIprotax.setnJOPBangunan(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NJOPBANGUNAN]));
                entPbbIprotax.setnJOPTKP(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NJOPTKP]));
                entPbbIprotax.setPokok(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_POKOK]));
                entPbbIprotax.setDenda(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_DENDA]));
                entPbbIprotax.setLetak(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_LETAK]));
                entPbbIprotax.setFormula(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_FORMULA]));
                entPbbIprotax.setTerbilang(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_TERBILANG]));
                entPbbIprotax.setInstansi(rs.getString(PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_INSTANSI]));
            }
            rs.close();
            return entPbbIprotax;
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return entPbbIprotax;
        }
    }

    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstPbbIprotax.fieldNames[PstPbbIprotax.FLD_NOP] + ") FROM " + TBL_PBBIPROTAX;
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
                    PbbIprotax entPbbIprotax = (PbbIprotax) list.get(ls);
                    if (oid == entPbbIprotax.getOID()) {
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
}
