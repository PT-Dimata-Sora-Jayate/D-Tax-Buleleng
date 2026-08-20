/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.entity.debiturbdnusaha;

/**
 *
 * @author m20n9
 */
import com.dimata.dslik.entity.bankgaransi.PstBankGaransi;
import com.dimata.dslik.entity.kredit.PstKredit;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.entity.pengurusataupemilik.PstPengurusAtauPemilik;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import com.dimata.util.lang.I_Language;
import java.sql.*;
import java.util.Vector;

public class PstDebiturBdnUsaha extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    
    private String sqlQueryHistory = "";

    public static final String TBL_DEBITUR_BDN_USAHA = "dslik_debitur";
    public static final int FLD_DEBITUR_BDN_USHA_OID = 0;
    public static final int FLD_FLAG_DETAIL= 1;
    public static final int FLD_CIF = 2;
    public static final int FLD_NO_IDENTITAS = 3;
    public static final int FLD_NAMA = 4;
    public static final int FLD_KODE_JENIS = 5;
    public static final int FLD_TEMPAT = 6;
    public static final int FLD_NO_AKTE = 7;
    public static final int FLD_TGL_AKTE_PENDIRIAN = 8;
    public static final int FLD_NO_AKTE_PERUBAHAN = 9;
    public static final int FLD_TGL_AKTE_PERUBAHAN = 10;
    public static final int FLD_TELEPON = 11;
    public static final int FLD_EMAIL = 12;
    public static final int FLD_ALAMAT = 13;
    public static final int FLD_KELURAHAN = 14;
    public static final int FLD_KECAMATAN = 15;
    public static final int FLD_KODE_KAB = 16;
    public static final int FLD_KODE_POS = 17;
    public static final int FLD_KODE_NEGARA = 18;
    public static final int FLD_KODE_BIDANG_USAHA = 19;
    public static final int FLD_KODE_HUB_LJK = 20;
    public static final int FLD_MELANGGAR_BMPK = 21;
    public static final int FLD_MELAMPAUI_BMPK = 22;
    public static final int FLD_GO_PUBLIC = 23;
    public static final int FLD_KODE_GOL = 24;
    public static final int FLD_PERINGKAT = 25;
    public static final int FLD_LEMBAGA_PEMERINGKAT = 26;
    public static final int FLD_TGL_PEMERINGKAT = 27;
    public static final int FLD_NAMA_GROUP = 28;
    public static final int FLD_KODE_KTR_CABANG = 29;
    public static final int FLD_OPERASI_DATA = 30;
    public static final int FLD_PERIODE_ID = 31;
    public static final int FLD_KODE_JENIS_NSB = 32;
    public static final int FLD_STATUS_DATA = 33;
    public static final int FLD_TELEPON_SELULER = 34;
    public static final int FLD_STATUS_PERUBAHAN_DATA = 35;
    public static String[] fieldNames = {
        "DEBITUR_OID", //0 long
        "FLAG_DETAIL", //1 string
        "CIF", //2 string
        "NO_IDENTITAS", //3 string
        "NAMA_BADAN_USAHA", //4 string
        "KODE_JENIS_USAHA", //5 string
        "TEMPAT_PENDIRIAN", //6 string
        "NO_AKTE", //7 string
        "TGL_AKTE_PENDIRIAN", //8 date
        "NO_AKTE_PERUBAHAN", //9 string
        "TGL_AKTE_PERUBAHAN", //10 date
        "TELEPON", //11 string
        "EMAIL", //12 string
        "ALAMAT",//13 string
        "KELURAHAN",//14 string
        "KECAMATAN",//15 string
        "KODE_KAB",//16 string
        "KODE_POS",//17 string
        "KODE_DOMISILI",//18 string
        "KODE_BIDANG_USAHA",//19  string
        "KODE_HUB_LJK",//20 string
        "MELANGGAR_BMPK",//21 string
        "MELAMPAUI_BMPK",//22 string
        "GO_PUBLIC",//23 string
        "KODE_GOL",//24 string
        "PERINGKAT",//25 string
        "LEMBAGA_PEMERINGKAT",//26 string
        "TGL_PEMERINGKAT",//27 date
        "NAMA_GROUP",//28 string
        "KODE_KANTOR_CABANG",//29 string
        "OPERASI_DATA",//30 string
        "PERIODE_ID",//31 long
        "KODE_JENIS_NSB",//32 string
        "STATUS_OPERASI_DATA",
        "NOMOR_HP",
        "STATUS_DATA"
    };
    public static int[] fieldTypes = {
        TYPE_LONG + TYPE_PK + TYPE_ID, //0 
        TYPE_STRING, //1
        TYPE_STRING, //2
        TYPE_STRING, //3
        TYPE_STRING, //4
        TYPE_STRING, //5
        TYPE_STRING, //6
        TYPE_STRING, //7
        TYPE_DATE, //8
        TYPE_STRING, //9
        TYPE_DATE, //10
        TYPE_STRING, //11
        TYPE_STRING, //12
        TYPE_STRING, //13
        TYPE_STRING, //14
        TYPE_STRING, //15
        TYPE_STRING, //16
        TYPE_STRING, //17
        TYPE_STRING, //18
        TYPE_STRING, //19
        TYPE_STRING, //20
        TYPE_STRING, //21
        TYPE_STRING, //22
        TYPE_STRING, //23
        TYPE_STRING, //24
        TYPE_STRING, //25
        TYPE_STRING, //26
        TYPE_DATE, //27
        TYPE_STRING, //28
        TYPE_STRING, //29
        TYPE_STRING, //30
        TYPE_LONG, //31
        TYPE_STRING,
        TYPE_INT,
        TYPE_STRING,
        TYPE_INT
    };

    public PstDebiturBdnUsaha() {
    }

    public PstDebiturBdnUsaha(int i) throws DBException {
        super(new PstDebiturBdnUsaha());
    }

    public PstDebiturBdnUsaha(String sOid) throws DBException {
        super(new PstDebiturBdnUsaha(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstDebiturBdnUsaha(long lOid) throws DBException {
        super(new PstDebiturBdnUsaha(0));
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
        return TBL_DEBITUR_BDN_USAHA;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstDebiturBdnUsaha().getClass().getName();
    }

    public static DebiturBdnUsaha fetchExc(long oid) throws DBException {
        try {
            DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
            PstDebiturBdnUsaha pstDebiturBdnUsaha = new PstDebiturBdnUsaha(oid);
            entDebiturBdnUsaha.setOID(oid);
            entDebiturBdnUsaha.setFlagDetail(pstDebiturBdnUsaha.getString(FLD_FLAG_DETAIL));
            entDebiturBdnUsaha.setCif(pstDebiturBdnUsaha.getString(FLD_CIF));
            entDebiturBdnUsaha.setNoIdentitas(pstDebiturBdnUsaha.getString(FLD_NO_IDENTITAS));
            entDebiturBdnUsaha.setNama(pstDebiturBdnUsaha.getString(FLD_NAMA));
            entDebiturBdnUsaha.setKodeJenis(pstDebiturBdnUsaha.getString(FLD_KODE_JENIS));
            entDebiturBdnUsaha.setTempat(pstDebiturBdnUsaha.getString(FLD_TEMPAT));
            entDebiturBdnUsaha.setNoAkte(pstDebiturBdnUsaha.getString(FLD_NO_AKTE));
            entDebiturBdnUsaha.setTglAktePendirian(pstDebiturBdnUsaha.getDate(FLD_TGL_AKTE_PENDIRIAN));
            entDebiturBdnUsaha.setNoAktePerubahan(pstDebiturBdnUsaha.getString(FLD_NO_AKTE_PERUBAHAN));
            entDebiturBdnUsaha.setTglAktePerubahan(pstDebiturBdnUsaha.getDate(FLD_TGL_AKTE_PERUBAHAN));
            entDebiturBdnUsaha.setTelepon(pstDebiturBdnUsaha.getString(FLD_TELEPON));
            entDebiturBdnUsaha.setEmail(pstDebiturBdnUsaha.getString(FLD_EMAIL));
            entDebiturBdnUsaha.setAlamat(pstDebiturBdnUsaha.getString(FLD_ALAMAT));
            entDebiturBdnUsaha.setKelurahan(pstDebiturBdnUsaha.getString(FLD_KELURAHAN));
            entDebiturBdnUsaha.setKecamatan(pstDebiturBdnUsaha.getString(FLD_KECAMATAN));
            entDebiturBdnUsaha.setKodeKab(pstDebiturBdnUsaha.getString(FLD_KODE_KAB));
            entDebiturBdnUsaha.setKodePos(pstDebiturBdnUsaha.getString(FLD_KODE_POS));
            entDebiturBdnUsaha.setKodeNegara(pstDebiturBdnUsaha.getString(FLD_KODE_NEGARA));
            entDebiturBdnUsaha.setKodeBidangUsaha(pstDebiturBdnUsaha.getString(FLD_KODE_BIDANG_USAHA));
            entDebiturBdnUsaha.setKodeHubLjk(pstDebiturBdnUsaha.getString(FLD_KODE_HUB_LJK));
            entDebiturBdnUsaha.setMelanggarBmpk(pstDebiturBdnUsaha.getString(FLD_MELANGGAR_BMPK));
            entDebiturBdnUsaha.setMelampauiBmpk(pstDebiturBdnUsaha.getString(FLD_MELAMPAUI_BMPK));
            entDebiturBdnUsaha.setGoPublic(pstDebiturBdnUsaha.getString(FLD_GO_PUBLIC));
            entDebiturBdnUsaha.setKodeGol(pstDebiturBdnUsaha.getString(FLD_KODE_GOL));
            entDebiturBdnUsaha.setPeringkat(pstDebiturBdnUsaha.getString(FLD_PERINGKAT));
            entDebiturBdnUsaha.setLembagaPemeringkat(pstDebiturBdnUsaha.getString(FLD_LEMBAGA_PEMERINGKAT));
            entDebiturBdnUsaha.setTglPemeringkat(pstDebiturBdnUsaha.getDate(FLD_TGL_PEMERINGKAT));
            entDebiturBdnUsaha.setNamaGroup(pstDebiturBdnUsaha.getString(FLD_NAMA_GROUP));
            entDebiturBdnUsaha.setKodeKtrCabang(pstDebiturBdnUsaha.getString(FLD_KODE_KTR_CABANG));
            entDebiturBdnUsaha.setOperasiData(pstDebiturBdnUsaha.getString(FLD_OPERASI_DATA));
            entDebiturBdnUsaha.setPeriodeId(pstDebiturBdnUsaha.getlong(FLD_PERIODE_ID));
            entDebiturBdnUsaha.setKodeJenisNsb(pstDebiturBdnUsaha.getString(FLD_KODE_JENIS_NSB));
            entDebiturBdnUsaha.setStatusData(pstDebiturBdnUsaha.getInt(FLD_STATUS_PERUBAHAN_DATA));
            return entDebiturBdnUsaha;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDebiturBdnUsaha(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        DebiturBdnUsaha entDebiturBdnUsaha = fetchExc(entity.getOID());
        entity = (Entity) entDebiturBdnUsaha;
        return entDebiturBdnUsaha.getOID();
    }

    public static synchronized long updateExc(DebiturBdnUsaha entDebiturBdnUsaha) throws DBException {
        try {
            if (entDebiturBdnUsaha.getOID() != 0) {
                PstDebiturBdnUsaha pstDebiturBdnUsaha = new PstDebiturBdnUsaha(entDebiturBdnUsaha.getOID());
                pstDebiturBdnUsaha.setString(FLD_FLAG_DETAIL, entDebiturBdnUsaha.getFlagDetail());
                pstDebiturBdnUsaha.setString(FLD_CIF, entDebiturBdnUsaha.getCif());
                pstDebiturBdnUsaha.setString(FLD_NO_IDENTITAS, entDebiturBdnUsaha.getNoIdentitas());
                pstDebiturBdnUsaha.setString(FLD_NAMA, entDebiturBdnUsaha.getNama());
                pstDebiturBdnUsaha.setString(FLD_KODE_JENIS, entDebiturBdnUsaha.getKodeJenis());
                pstDebiturBdnUsaha.setString(FLD_TEMPAT, entDebiturBdnUsaha.getTempat());
                pstDebiturBdnUsaha.setString(FLD_NO_AKTE, entDebiturBdnUsaha.getNoAkte());
                pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PENDIRIAN, entDebiturBdnUsaha.getTglAktePendirian());
                pstDebiturBdnUsaha.setString(FLD_NO_AKTE_PERUBAHAN, entDebiturBdnUsaha.getNoAktePerubahan());
                pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PERUBAHAN, entDebiturBdnUsaha.getTglAktePerubahan());
                pstDebiturBdnUsaha.setString(FLD_TELEPON, entDebiturBdnUsaha.getTelepon());
                pstDebiturBdnUsaha.setString(FLD_EMAIL, entDebiturBdnUsaha.getEmail());
                pstDebiturBdnUsaha.setString(FLD_ALAMAT, entDebiturBdnUsaha.getAlamat());
                pstDebiturBdnUsaha.setString(FLD_KELURAHAN, entDebiturBdnUsaha.getKelurahan());
                pstDebiturBdnUsaha.setString(FLD_KECAMATAN, entDebiturBdnUsaha.getKecamatan());
                pstDebiturBdnUsaha.setString(FLD_KODE_KAB, entDebiturBdnUsaha.getKodeKab());
                pstDebiturBdnUsaha.setString(FLD_KODE_POS, entDebiturBdnUsaha.getKodePos());
                pstDebiturBdnUsaha.setString(FLD_KODE_NEGARA, entDebiturBdnUsaha.getKodeNegara());
                pstDebiturBdnUsaha.setString(FLD_KODE_BIDANG_USAHA, entDebiturBdnUsaha.getKodeBidangUsaha());
                pstDebiturBdnUsaha.setString(FLD_KODE_HUB_LJK, entDebiturBdnUsaha.getKodeHubLjk());
                pstDebiturBdnUsaha.setString(FLD_MELANGGAR_BMPK, entDebiturBdnUsaha.getMelanggarBmpk());
                pstDebiturBdnUsaha.setString(FLD_MELAMPAUI_BMPK, entDebiturBdnUsaha.getMelampauiBmpk());
                pstDebiturBdnUsaha.setString(FLD_GO_PUBLIC, entDebiturBdnUsaha.getGoPublic());
                pstDebiturBdnUsaha.setString(FLD_KODE_GOL, entDebiturBdnUsaha.getKodeGol());
                pstDebiturBdnUsaha.setString(FLD_PERINGKAT, entDebiturBdnUsaha.getPeringkat());
                pstDebiturBdnUsaha.setString(FLD_LEMBAGA_PEMERINGKAT, entDebiturBdnUsaha.getLembagaPemeringkat());
                pstDebiturBdnUsaha.setDate(FLD_TGL_PEMERINGKAT, entDebiturBdnUsaha.getTglPemeringkat());
                pstDebiturBdnUsaha.setString(FLD_NAMA_GROUP, entDebiturBdnUsaha.getNamaGroup());
                pstDebiturBdnUsaha.setString(FLD_KODE_KTR_CABANG, entDebiturBdnUsaha.getKodeKtrCabang());
                pstDebiturBdnUsaha.setString(FLD_OPERASI_DATA, entDebiturBdnUsaha.getOperasiData());
                pstDebiturBdnUsaha.setLong(FLD_PERIODE_ID, entDebiturBdnUsaha.getPeriodeId());
                pstDebiturBdnUsaha.setString(FLD_KODE_JENIS_NSB, entDebiturBdnUsaha.getKodeJenisNsb());
                pstDebiturBdnUsaha.setInt(FLD_STATUS_PERUBAHAN_DATA, entDebiturBdnUsaha.getStatusData());
                pstDebiturBdnUsaha.update();
                
                pstDebiturBdnUsaha.setSqlQueryHistory("");
                pstDebiturBdnUsaha.setSqlQueryHistory(pstDebiturBdnUsaha.getUpdateSQL());
                
                return entDebiturBdnUsaha.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDebiturBdnUsaha(0), DBException.UNKNOWN);
        }
        return 0;
    }
    
    public static synchronized DebiturBdnUsaha updateExcObj(DebiturBdnUsaha entDebiturBdnUsaha) throws DBException {
        try {
            if (entDebiturBdnUsaha.getOID() != 0) {
                PstDebiturBdnUsaha pstDebiturBdnUsaha = new PstDebiturBdnUsaha(entDebiturBdnUsaha.getOID());
                pstDebiturBdnUsaha.setString(FLD_FLAG_DETAIL, entDebiturBdnUsaha.getFlagDetail());
                pstDebiturBdnUsaha.setString(FLD_CIF, entDebiturBdnUsaha.getCif());
                pstDebiturBdnUsaha.setString(FLD_NO_IDENTITAS, entDebiturBdnUsaha.getNoIdentitas());
                pstDebiturBdnUsaha.setString(FLD_NAMA, entDebiturBdnUsaha.getNama());
                pstDebiturBdnUsaha.setString(FLD_KODE_JENIS, entDebiturBdnUsaha.getKodeJenis());
                pstDebiturBdnUsaha.setString(FLD_TEMPAT, entDebiturBdnUsaha.getTempat());
                pstDebiturBdnUsaha.setString(FLD_NO_AKTE, entDebiturBdnUsaha.getNoAkte());
                pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PENDIRIAN, entDebiturBdnUsaha.getTglAktePendirian());
                pstDebiturBdnUsaha.setString(FLD_NO_AKTE_PERUBAHAN, entDebiturBdnUsaha.getNoAktePerubahan());
                pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PERUBAHAN, entDebiturBdnUsaha.getTglAktePerubahan());
                pstDebiturBdnUsaha.setString(FLD_TELEPON, entDebiturBdnUsaha.getTelepon());
                pstDebiturBdnUsaha.setString(FLD_EMAIL, entDebiturBdnUsaha.getEmail());
                pstDebiturBdnUsaha.setString(FLD_ALAMAT, entDebiturBdnUsaha.getAlamat());
                pstDebiturBdnUsaha.setString(FLD_KELURAHAN, entDebiturBdnUsaha.getKelurahan());
                pstDebiturBdnUsaha.setString(FLD_KECAMATAN, entDebiturBdnUsaha.getKecamatan());
                pstDebiturBdnUsaha.setString(FLD_KODE_KAB, entDebiturBdnUsaha.getKodeKab());
                pstDebiturBdnUsaha.setString(FLD_KODE_POS, entDebiturBdnUsaha.getKodePos());
                pstDebiturBdnUsaha.setString(FLD_KODE_NEGARA, entDebiturBdnUsaha.getKodeNegara());
                pstDebiturBdnUsaha.setString(FLD_KODE_BIDANG_USAHA, entDebiturBdnUsaha.getKodeBidangUsaha());
                pstDebiturBdnUsaha.setString(FLD_KODE_HUB_LJK, entDebiturBdnUsaha.getKodeHubLjk());
                pstDebiturBdnUsaha.setString(FLD_MELANGGAR_BMPK, entDebiturBdnUsaha.getMelanggarBmpk());
                pstDebiturBdnUsaha.setString(FLD_MELAMPAUI_BMPK, entDebiturBdnUsaha.getMelampauiBmpk());
                pstDebiturBdnUsaha.setString(FLD_GO_PUBLIC, entDebiturBdnUsaha.getGoPublic());
                pstDebiturBdnUsaha.setString(FLD_KODE_GOL, entDebiturBdnUsaha.getKodeGol());
                pstDebiturBdnUsaha.setString(FLD_PERINGKAT, entDebiturBdnUsaha.getPeringkat());
                pstDebiturBdnUsaha.setString(FLD_LEMBAGA_PEMERINGKAT, entDebiturBdnUsaha.getLembagaPemeringkat());
                pstDebiturBdnUsaha.setDate(FLD_TGL_PEMERINGKAT, entDebiturBdnUsaha.getTglPemeringkat());
                pstDebiturBdnUsaha.setString(FLD_NAMA_GROUP, entDebiturBdnUsaha.getNamaGroup());
                pstDebiturBdnUsaha.setString(FLD_KODE_KTR_CABANG, entDebiturBdnUsaha.getKodeKtrCabang());
                pstDebiturBdnUsaha.setString(FLD_OPERASI_DATA, entDebiturBdnUsaha.getOperasiData());
                pstDebiturBdnUsaha.setLong(FLD_PERIODE_ID, entDebiturBdnUsaha.getPeriodeId());
                pstDebiturBdnUsaha.setString(FLD_KODE_JENIS_NSB, entDebiturBdnUsaha.getKodeJenisNsb());
                pstDebiturBdnUsaha.setInt(FLD_STATUS_PERUBAHAN_DATA, entDebiturBdnUsaha.getStatusData());
                pstDebiturBdnUsaha.update();
                
                pstDebiturBdnUsaha.setSqlQueryHistory("");
                pstDebiturBdnUsaha.setSqlQueryHistory(pstDebiturBdnUsaha.getUpdateSQL());
                entDebiturBdnUsaha.setSqlHistory(pstDebiturBdnUsaha.getUpdateSQL());
                return entDebiturBdnUsaha;
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDebiturBdnUsaha(0), DBException.UNKNOWN);
        }
        return entDebiturBdnUsaha;
    }
    
    public static String getCif(int kodeJenisNasabah, long periodeId){
        String cif = "";
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT "+ fieldNames[FLD_DEBITUR_BDN_USHA_OID]+", "
                    + fieldNames[FLD_NO_IDENTITAS]+", "
                    + fieldNames[FLD_NAMA]+", "
                    + fieldNames[FLD_CIF]+", "
                    + "COUNT(*) c "
                    + "FROM "+TBL_DEBITUR_BDN_USAHA+" WHERE "+fieldNames[FLD_PERIODE_ID]+"='"+periodeId+"' "
                    + "AND "+fieldNames[FLD_KODE_JENIS_NSB]+"!='"+kodeJenisNasabah+"' "
                    + "GROUP BY "+fieldNames[FLD_NO_IDENTITAS]+" "
                    + "HAVING c > 1";
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                if(cif.length() > 0){
                    cif+=",'"+rs.getString(fieldNames[FLD_NO_IDENTITAS])+"'";
                }else{
                    cif+="'"+rs.getString(fieldNames[FLD_NO_IDENTITAS])+"'";
                }
            }
            rs.close();
            return cif;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return cif;
    }
    
    public static Vector listDoubleNik(int limitStart, int recordToGet, String kodeCabang, long periodeId) {
        String cif = getCif(1, periodeId);
        //String cif = listDoubleNik2(0, 0, kodeCabang, periodeId);
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT dup."+PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+", "
                    + "debitur."+fieldNames[FLD_CIF]+", "
                    + "debitur."+fieldNames[FLD_NO_IDENTITAS]+","
                    + "debitur."+fieldNames[FLD_NAMA]+" "
                    + "FROM "+TBL_DEBITUR_BDN_USAHA+" AS debitur "
                    + "LEFT JOIN ("
                        + "SELECT DISTINCT "+PstKredit.fieldNames[PstKredit.FLD_CIF]+","
                        + PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+","
                        + PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+" "
                        + "FROM ("
                            + "SELECT DISTINCT "+PstKredit.fieldNames[PstKredit.FLD_CIF]+","
                            + PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+","
                            + PstKredit.fieldNames[PstKredit.FLD_TGL_AWAL]+","
                            + PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+" "
                            + "FROM "+PstKredit.TBL_KREDIT+" "
                            + "WHERE "+PstKredit.TBL_KREDIT+"."+PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+periodeId+"' "
                            + "UNION "
                            + "SELECT DISTINCT "+PstBankGaransi.fieldNames[PstBankGaransi.FLD_CIF]+","
                            + PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]+","
                            + PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_DITERBITKAN]+" AS "+PstKredit.fieldNames[PstKredit.FLD_TGL_AWAL]+","
                            + PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KANTOR_CABANG]+" "
                            + "FROM "+PstBankGaransi.TBL_BANK_GARANSI+" "
                            + "WHERE "+PstBankGaransi.TBL_BANK_GARANSI+"."+PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+periodeId+"'"
                    + ") AS CUP"
                    + " ORDER BY CUP."+PstKredit.fieldNames[PstKredit.FLD_TGL_AWAL]+" DESC"
                + ") AS dup "
                + "ON debitur."+fieldNames[FLD_CIF]+" = dup."+PstKredit.fieldNames[PstKredit.FLD_CIF]+" "
                + "WHERE debitur."+fieldNames[FLD_PERIODE_ID]+"='"+periodeId+"' "
                + "AND debitur."+fieldNames[FLD_KODE_JENIS_NSB]+"!='1'";
                
                if(cif.length() > 0){
                    sql+=" AND debitur."+fieldNames[FLD_NO_IDENTITAS]+" IN ("+cif+")";
                }
                
                if (kodeCabang != null && kodeCabang.length() > 0) {
                    sql = sql + " AND dup." +fieldNames[FLD_KODE_KTR_CABANG]+"='"+kodeCabang+"'" ;
                }
            
            sql+=" ORDER BY debitur."+fieldNames[FLD_NO_IDENTITAS]+" ASC";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObjectDoubleNik(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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
    
    
    public static String listDoubleNik2(int limitStart, int recordToGet, String kodeCabang, long periodeId) {
        String cif2 = getCif(1, periodeId);
        Vector lists = new Vector();
        DBResultSet dbrs = null;
         String cif ="";
        try {
            String sql = "SELECT DISTINCT dup."+PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+", "
                    + "debitur."+fieldNames[FLD_CIF]+", "
                    + "debitur."+fieldNames[FLD_NO_IDENTITAS]+","
                    + "debitur."+fieldNames[FLD_NAMA]+" "
                    + "FROM "+TBL_DEBITUR_BDN_USAHA+" AS debitur "
                    + "INNER JOIN ("
                        + "SELECT DISTINCT "+PstKredit.fieldNames[PstKredit.FLD_CIF]+","
                        + PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+","
                        + PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+" "
                        + "FROM ("
                            + "SELECT DISTINCT "+PstKredit.fieldNames[PstKredit.FLD_CIF]+","
                            + PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+","
                            + PstKredit.fieldNames[PstKredit.FLD_TGL_AWAL]+","
                            + PstKredit.fieldNames[PstKredit.FLD_KODE_KANTOR_CABANG]+" "
                            + "FROM "+PstKredit.TBL_KREDIT+" "
                            + "WHERE "+PstKredit.TBL_KREDIT+"."+PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+periodeId+"' "
                            + "UNION "
                            + "SELECT DISTINCT "+PstBankGaransi.fieldNames[PstBankGaransi.FLD_CIF]+","
                            + PstBankGaransi.fieldNames[PstBankGaransi.FLD_NO_REKENING]+","
                            + PstBankGaransi.fieldNames[PstBankGaransi.FLD_TGL_DITERBITKAN]+" AS "+PstKredit.fieldNames[PstKredit.FLD_TGL_AWAL]+","
                            + PstBankGaransi.fieldNames[PstBankGaransi.FLD_KODE_KANTOR_CABANG]+" "
                            + "FROM "+PstBankGaransi.TBL_BANK_GARANSI+" "
                            + "WHERE "+PstBankGaransi.TBL_BANK_GARANSI+"."+PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+periodeId+"'"
                    + ") AS CUP"
                    + " ORDER BY CUP."+PstKredit.fieldNames[PstKredit.FLD_TGL_AWAL]+" DESC"
                + ") AS dup "
                + "ON debitur."+fieldNames[FLD_CIF]+" = dup."+PstKredit.fieldNames[PstKredit.FLD_CIF]+" "
                + "WHERE debitur."+fieldNames[FLD_PERIODE_ID]+"='"+periodeId+"' "
                + "AND debitur."+fieldNames[FLD_KODE_JENIS_NSB]+"!='1'";
                
                if(cif2.length() > 0){
                    sql+=" AND debitur."+fieldNames[FLD_CIF]+" IN ("+cif2+")";
                }
            
            if (kodeCabang != null && kodeCabang.length() > 0) {
                sql = sql + " AND debitur." +fieldNames[FLD_KODE_KTR_CABANG]+"='"+kodeCabang+"'" ;
            }
            
            sql+=" ORDER BY debitur."+fieldNames[FLD_NO_IDENTITAS]+" ASC";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                if(cif.length() > 0){
                    cif+=",'"+rs.getString(fieldNames[FLD_NO_IDENTITAS])+"'";
                }else{
                    cif+="'"+rs.getString(fieldNames[FLD_NO_IDENTITAS])+"'";
                }
            }
            rs.close();
            return cif;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return cif;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((DebiturBdnUsaha) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstDebiturBdnUsaha pstDebiturBdnUsaha = new PstDebiturBdnUsaha(oid);
            pstDebiturBdnUsaha.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDebiturBdnUsaha(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(DebiturBdnUsaha entDebiturBdnUsaha) throws DBException {
        try {
            PstDebiturBdnUsaha pstDebiturBdnUsaha = new PstDebiturBdnUsaha(0);
            pstDebiturBdnUsaha.setString(FLD_FLAG_DETAIL, entDebiturBdnUsaha.getFlagDetail());
            pstDebiturBdnUsaha.setString(FLD_CIF, entDebiturBdnUsaha.getCif());
            pstDebiturBdnUsaha.setString(FLD_NO_IDENTITAS, entDebiturBdnUsaha.getNoIdentitas());
            pstDebiturBdnUsaha.setString(FLD_NAMA, entDebiturBdnUsaha.getNama());
            pstDebiturBdnUsaha.setString(FLD_KODE_JENIS, entDebiturBdnUsaha.getKodeJenis());
            pstDebiturBdnUsaha.setString(FLD_TEMPAT, entDebiturBdnUsaha.getTempat());
            pstDebiturBdnUsaha.setString(FLD_NO_AKTE, entDebiturBdnUsaha.getNoAkte());
            pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PENDIRIAN, entDebiturBdnUsaha.getTglAktePendirian());
            pstDebiturBdnUsaha.setString(FLD_NO_AKTE_PERUBAHAN, entDebiturBdnUsaha.getNoAktePerubahan());
            pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PERUBAHAN, entDebiturBdnUsaha.getTglAktePerubahan());
            pstDebiturBdnUsaha.setString(FLD_TELEPON, entDebiturBdnUsaha.getTelepon());
            pstDebiturBdnUsaha.setString(FLD_EMAIL, entDebiturBdnUsaha.getEmail());
            pstDebiturBdnUsaha.setString(FLD_ALAMAT, entDebiturBdnUsaha.getAlamat());
            pstDebiturBdnUsaha.setString(FLD_KELURAHAN, entDebiturBdnUsaha.getKelurahan());
            pstDebiturBdnUsaha.setString(FLD_KECAMATAN, entDebiturBdnUsaha.getKecamatan());
            pstDebiturBdnUsaha.setString(FLD_KODE_KAB, entDebiturBdnUsaha.getKodeKab());
            pstDebiturBdnUsaha.setString(FLD_KODE_POS, entDebiturBdnUsaha.getKodePos());
            pstDebiturBdnUsaha.setString(FLD_KODE_NEGARA, entDebiturBdnUsaha.getKodeNegara());
            pstDebiturBdnUsaha.setString(FLD_KODE_BIDANG_USAHA, entDebiturBdnUsaha.getKodeBidangUsaha());
            pstDebiturBdnUsaha.setString(FLD_KODE_HUB_LJK, entDebiturBdnUsaha.getKodeHubLjk());
            pstDebiturBdnUsaha.setString(FLD_MELANGGAR_BMPK, entDebiturBdnUsaha.getMelanggarBmpk());
            pstDebiturBdnUsaha.setString(FLD_MELAMPAUI_BMPK, entDebiturBdnUsaha.getMelampauiBmpk());
            pstDebiturBdnUsaha.setString(FLD_GO_PUBLIC, entDebiturBdnUsaha.getGoPublic());
            pstDebiturBdnUsaha.setString(FLD_KODE_GOL, entDebiturBdnUsaha.getKodeGol());
            pstDebiturBdnUsaha.setString(FLD_PERINGKAT, entDebiturBdnUsaha.getPeringkat());
            pstDebiturBdnUsaha.setString(FLD_LEMBAGA_PEMERINGKAT, entDebiturBdnUsaha.getLembagaPemeringkat());
            pstDebiturBdnUsaha.setDate(FLD_TGL_PEMERINGKAT, entDebiturBdnUsaha.getTglPemeringkat());
            pstDebiturBdnUsaha.setString(FLD_NAMA_GROUP, entDebiturBdnUsaha.getNamaGroup());
            pstDebiturBdnUsaha.setString(FLD_KODE_KTR_CABANG, entDebiturBdnUsaha.getKodeKtrCabang());
            pstDebiturBdnUsaha.setString(FLD_OPERASI_DATA, entDebiturBdnUsaha.getOperasiData());
            pstDebiturBdnUsaha.setLong(FLD_PERIODE_ID, entDebiturBdnUsaha.getPeriodeId());
            pstDebiturBdnUsaha.setString(FLD_KODE_JENIS_NSB, entDebiturBdnUsaha.getKodeJenisNsb());
            pstDebiturBdnUsaha.setInt(FLD_STATUS_PERUBAHAN_DATA, entDebiturBdnUsaha.getStatusData());
            pstDebiturBdnUsaha.insert();
            
            pstDebiturBdnUsaha.setSqlQueryHistory("");
            pstDebiturBdnUsaha.setSqlQueryHistory(pstDebiturBdnUsaha.getInsertSQL());
            
            entDebiturBdnUsaha.setOID(pstDebiturBdnUsaha.getLong(FLD_DEBITUR_BDN_USHA_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDebiturBdnUsaha(0), DBException.UNKNOWN);
        }
        return entDebiturBdnUsaha.getOID();
    }
    
    public static synchronized DebiturBdnUsaha insertExcObj(DebiturBdnUsaha entDebiturBdnUsaha) throws DBException {
        try {
            PstDebiturBdnUsaha pstDebiturBdnUsaha = new PstDebiturBdnUsaha(0);
            pstDebiturBdnUsaha.setString(FLD_FLAG_DETAIL, entDebiturBdnUsaha.getFlagDetail());
            pstDebiturBdnUsaha.setString(FLD_CIF, entDebiturBdnUsaha.getCif());
            pstDebiturBdnUsaha.setString(FLD_NO_IDENTITAS, entDebiturBdnUsaha.getNoIdentitas());
            pstDebiturBdnUsaha.setString(FLD_NAMA, entDebiturBdnUsaha.getNama());
            pstDebiturBdnUsaha.setString(FLD_KODE_JENIS, entDebiturBdnUsaha.getKodeJenis());
            pstDebiturBdnUsaha.setString(FLD_TEMPAT, entDebiturBdnUsaha.getTempat());
            pstDebiturBdnUsaha.setString(FLD_NO_AKTE, entDebiturBdnUsaha.getNoAkte());
            pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PENDIRIAN, entDebiturBdnUsaha.getTglAktePendirian());
            pstDebiturBdnUsaha.setString(FLD_NO_AKTE_PERUBAHAN, entDebiturBdnUsaha.getNoAktePerubahan());
            pstDebiturBdnUsaha.setDate(FLD_TGL_AKTE_PERUBAHAN, entDebiturBdnUsaha.getTglAktePerubahan());
            pstDebiturBdnUsaha.setString(FLD_TELEPON, entDebiturBdnUsaha.getTelepon());
            pstDebiturBdnUsaha.setString(FLD_EMAIL, entDebiturBdnUsaha.getEmail());
            pstDebiturBdnUsaha.setString(FLD_ALAMAT, entDebiturBdnUsaha.getAlamat());
            pstDebiturBdnUsaha.setString(FLD_KELURAHAN, entDebiturBdnUsaha.getKelurahan());
            pstDebiturBdnUsaha.setString(FLD_KECAMATAN, entDebiturBdnUsaha.getKecamatan());
            pstDebiturBdnUsaha.setString(FLD_KODE_KAB, entDebiturBdnUsaha.getKodeKab());
            pstDebiturBdnUsaha.setString(FLD_KODE_POS, entDebiturBdnUsaha.getKodePos());
            pstDebiturBdnUsaha.setString(FLD_KODE_NEGARA, entDebiturBdnUsaha.getKodeNegara());
            pstDebiturBdnUsaha.setString(FLD_KODE_BIDANG_USAHA, entDebiturBdnUsaha.getKodeBidangUsaha());
            pstDebiturBdnUsaha.setString(FLD_KODE_HUB_LJK, entDebiturBdnUsaha.getKodeHubLjk());
            pstDebiturBdnUsaha.setString(FLD_MELANGGAR_BMPK, entDebiturBdnUsaha.getMelanggarBmpk());
            pstDebiturBdnUsaha.setString(FLD_MELAMPAUI_BMPK, entDebiturBdnUsaha.getMelampauiBmpk());
            pstDebiturBdnUsaha.setString(FLD_GO_PUBLIC, entDebiturBdnUsaha.getGoPublic());
            pstDebiturBdnUsaha.setString(FLD_KODE_GOL, entDebiturBdnUsaha.getKodeGol());
            pstDebiturBdnUsaha.setString(FLD_PERINGKAT, entDebiturBdnUsaha.getPeringkat());
            pstDebiturBdnUsaha.setString(FLD_LEMBAGA_PEMERINGKAT, entDebiturBdnUsaha.getLembagaPemeringkat());
            pstDebiturBdnUsaha.setDate(FLD_TGL_PEMERINGKAT, entDebiturBdnUsaha.getTglPemeringkat());
            pstDebiturBdnUsaha.setString(FLD_NAMA_GROUP, entDebiturBdnUsaha.getNamaGroup());
            pstDebiturBdnUsaha.setString(FLD_KODE_KTR_CABANG, entDebiturBdnUsaha.getKodeKtrCabang());
            pstDebiturBdnUsaha.setString(FLD_OPERASI_DATA, entDebiturBdnUsaha.getOperasiData());
            pstDebiturBdnUsaha.setLong(FLD_PERIODE_ID, entDebiturBdnUsaha.getPeriodeId());
            pstDebiturBdnUsaha.setString(FLD_KODE_JENIS_NSB, entDebiturBdnUsaha.getKodeJenisNsb());
            pstDebiturBdnUsaha.setInt(FLD_STATUS_PERUBAHAN_DATA, entDebiturBdnUsaha.getStatusData());
            pstDebiturBdnUsaha.insert();
            
            pstDebiturBdnUsaha.setSqlQueryHistory("");
            pstDebiturBdnUsaha.setSqlQueryHistory(pstDebiturBdnUsaha.getInsertSQL());
            entDebiturBdnUsaha.setSqlHistory(pstDebiturBdnUsaha.getInsertSQL());
            
            entDebiturBdnUsaha.setOID(pstDebiturBdnUsaha.getLong(FLD_DEBITUR_BDN_USHA_OID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstDebiturBdnUsaha(0), DBException.UNKNOWN);
        }
        return entDebiturBdnUsaha;
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((DebiturBdnUsaha) entity);
    }
    
    public static void resultToObjectDoubleNik(ResultSet rs, DebiturBdnUsaha entDebiturIndividu) {
        try {
            entDebiturIndividu.setNoRekening(rs.getString(PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]));
            entDebiturIndividu.setCif(rs.getString(fieldNames[FLD_CIF]));
            entDebiturIndividu.setNoIdentitas(rs.getString(fieldNames[FLD_NO_IDENTITAS]));
            entDebiturIndividu.setNama(rs.getString(fieldNames[FLD_NAMA]));
        } catch (Exception e) {
        }
    }
    
    public static void resultToObject(ResultSet rs, DebiturBdnUsaha entDebiturBdnUsaha) {
        try {
            entDebiturBdnUsaha.setOID(rs.getLong(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID]));
            entDebiturBdnUsaha.setFlagDetail(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_FLAG_DETAIL]));
            entDebiturBdnUsaha.setCif(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_CIF]));
            entDebiturBdnUsaha.setNoIdentitas(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_IDENTITAS]));
            entDebiturBdnUsaha.setNama(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NAMA]));
            entDebiturBdnUsaha.setKodeJenis(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS]));
            entDebiturBdnUsaha.setTempat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TEMPAT]));
            entDebiturBdnUsaha.setNoAkte(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_AKTE]));
            entDebiturBdnUsaha.setTglAktePendirian(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_AKTE_PENDIRIAN]));
            entDebiturBdnUsaha.setNoAktePerubahan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_AKTE_PERUBAHAN]));
            entDebiturBdnUsaha.setTglAktePerubahan(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_AKTE_PERUBAHAN]));
            entDebiturBdnUsaha.setTelepon(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TELEPON]));
            entDebiturBdnUsaha.setEmail(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_EMAIL]));
            entDebiturBdnUsaha.setAlamat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_ALAMAT]));
            entDebiturBdnUsaha.setKelurahan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KELURAHAN]));
            entDebiturBdnUsaha.setKecamatan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KECAMATAN]));
            entDebiturBdnUsaha.setKodeKab(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_KAB]));
            entDebiturBdnUsaha.setKodePos(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_POS]));
            entDebiturBdnUsaha.setKodeNegara(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_NEGARA]));
            entDebiturBdnUsaha.setKodeBidangUsaha(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_BIDANG_USAHA]));
            entDebiturBdnUsaha.setKodeHubLjk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_HUB_LJK]));
            entDebiturBdnUsaha.setMelanggarBmpk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_MELANGGAR_BMPK]));
            entDebiturBdnUsaha.setMelampauiBmpk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_MELAMPAUI_BMPK]));
            entDebiturBdnUsaha.setGoPublic(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_GO_PUBLIC]));
            entDebiturBdnUsaha.setKodeGol(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_GOL]));
            entDebiturBdnUsaha.setPeringkat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERINGKAT]));
            entDebiturBdnUsaha.setLembagaPemeringkat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_LEMBAGA_PEMERINGKAT]));
            entDebiturBdnUsaha.setTglPemeringkat(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_PEMERINGKAT]));
            entDebiturBdnUsaha.setNamaGroup(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NAMA_GROUP]));
            entDebiturBdnUsaha.setKodeKtrCabang(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_KTR_CABANG]));
            entDebiturBdnUsaha.setOperasiData(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_OPERASI_DATA]));
            entDebiturBdnUsaha.setKodeJenisNsb(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS_NSB]));
            entDebiturBdnUsaha.setPeriodeId(rs.getLong(fieldNames[FLD_PERIODE_ID]));
            entDebiturBdnUsaha.setStatusOperasiData(rs.getInt("STATUS_OPERASI_DATA"));
            entDebiturBdnUsaha.setTeleponSeluler(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TELEPON_SELULER]));
            entDebiturBdnUsaha.setStatusData(rs.getInt(fieldNames[FLD_STATUS_PERUBAHAN_DATA]));
        } catch (Exception e) {
        }
    }
    
    public static void resultToObjectParentCabang(ResultSet rs, DebiturBdnUsaha entDebiturBdnUsaha) {
        try {
            entDebiturBdnUsaha.setOID(rs.getLong(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID]));
            entDebiturBdnUsaha.setFlagDetail(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_FLAG_DETAIL]));
            entDebiturBdnUsaha.setCif(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_CIF]));
            entDebiturBdnUsaha.setNoIdentitas(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_IDENTITAS]));
            entDebiturBdnUsaha.setNama(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NAMA]));
            entDebiturBdnUsaha.setKodeJenis(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS]));
            entDebiturBdnUsaha.setTempat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TEMPAT]));
            entDebiturBdnUsaha.setNoAkte(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_AKTE]));
            entDebiturBdnUsaha.setTglAktePendirian(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_AKTE_PENDIRIAN]));
            entDebiturBdnUsaha.setNoAktePerubahan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_AKTE_PERUBAHAN]));
            entDebiturBdnUsaha.setTglAktePerubahan(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_AKTE_PERUBAHAN]));
            entDebiturBdnUsaha.setTelepon(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TELEPON]));
            entDebiturBdnUsaha.setEmail(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_EMAIL]));
            entDebiturBdnUsaha.setAlamat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_ALAMAT]));
            entDebiturBdnUsaha.setKelurahan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KELURAHAN]));
            entDebiturBdnUsaha.setKecamatan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KECAMATAN]));
            entDebiturBdnUsaha.setKodeKab(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_KAB]));
            entDebiturBdnUsaha.setKodePos(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_POS]));
            entDebiturBdnUsaha.setKodeNegara(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_NEGARA]));
            entDebiturBdnUsaha.setKodeBidangUsaha(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_BIDANG_USAHA]));
            entDebiturBdnUsaha.setKodeHubLjk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_HUB_LJK]));
            entDebiturBdnUsaha.setMelanggarBmpk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_MELANGGAR_BMPK]));
            entDebiturBdnUsaha.setMelampauiBmpk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_MELAMPAUI_BMPK]));
            entDebiturBdnUsaha.setGoPublic(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_GO_PUBLIC]));
            entDebiturBdnUsaha.setKodeGol(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_GOL]));
            entDebiturBdnUsaha.setPeringkat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERINGKAT]));
            entDebiturBdnUsaha.setLembagaPemeringkat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_LEMBAGA_PEMERINGKAT]));
            entDebiturBdnUsaha.setTglPemeringkat(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_PEMERINGKAT]));
            entDebiturBdnUsaha.setNamaGroup(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NAMA_GROUP]));
            entDebiturBdnUsaha.setKodeKtrCabang(rs.getString("PARENT_CODE"));
            entDebiturBdnUsaha.setOperasiData(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_OPERASI_DATA]));
            entDebiturBdnUsaha.setKodeJenisNsb(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS_NSB]));
            entDebiturBdnUsaha.setPeriodeId(rs.getLong(fieldNames[FLD_PERIODE_ID]));
            entDebiturBdnUsaha.setStatusOperasiData(rs.getInt("STATUS_OPERASI_DATA"));
            entDebiturBdnUsaha.setTeleponSeluler(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TELEPON_SELULER]));
            entDebiturBdnUsaha.setStatusData(rs.getInt(fieldNames[FLD_STATUS_PERUBAHAN_DATA]));
        } catch (Exception e) {
        }
    }


    public static void resultToObjectJoinReport(ResultSet rs, DebiturBdnUsaha entDebiturBdnUsaha) {
        try {
            entDebiturBdnUsaha.setOID(rs.getLong(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID]));
            entDebiturBdnUsaha.setFlagDetail(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_FLAG_DETAIL]));
            entDebiturBdnUsaha.setCif(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_CIF]));
            entDebiturBdnUsaha.setNoIdentitas(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_IDENTITAS]));
            entDebiturBdnUsaha.setNama(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NAMA]));
            entDebiturBdnUsaha.setKodeJenis(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS]));
            entDebiturBdnUsaha.setTempat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TEMPAT]));
            entDebiturBdnUsaha.setNoAkte(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_AKTE]));
            entDebiturBdnUsaha.setTglAktePendirian(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_AKTE_PENDIRIAN]));
            entDebiturBdnUsaha.setNoAktePerubahan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NO_AKTE_PERUBAHAN]));
            entDebiturBdnUsaha.setTglAktePerubahan(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_AKTE_PERUBAHAN]));
            entDebiturBdnUsaha.setTelepon(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TELEPON]));
            entDebiturBdnUsaha.setEmail(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_EMAIL]));
            entDebiturBdnUsaha.setAlamat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_ALAMAT]));
            entDebiturBdnUsaha.setKelurahan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KELURAHAN]));
            entDebiturBdnUsaha.setKecamatan(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KECAMATAN]));
            entDebiturBdnUsaha.setKodeKab(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_KAB]));
            entDebiturBdnUsaha.setKodePos(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_POS]));
            entDebiturBdnUsaha.setKodeNegara(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_NEGARA]));
            entDebiturBdnUsaha.setKodeBidangUsaha(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_BIDANG_USAHA]));
            entDebiturBdnUsaha.setKodeHubLjk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_HUB_LJK]));
            entDebiturBdnUsaha.setMelanggarBmpk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_MELANGGAR_BMPK]));
            entDebiturBdnUsaha.setMelampauiBmpk(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_MELAMPAUI_BMPK]));
            entDebiturBdnUsaha.setGoPublic(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_GO_PUBLIC]));
            entDebiturBdnUsaha.setKodeGol(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_GOL]));
            entDebiturBdnUsaha.setPeringkat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERINGKAT]));
            entDebiturBdnUsaha.setLembagaPemeringkat(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_LEMBAGA_PEMERINGKAT]));
            entDebiturBdnUsaha.setTglPemeringkat(rs.getDate(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TGL_PEMERINGKAT]));
            entDebiturBdnUsaha.setNamaGroup(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_NAMA_GROUP]));
            entDebiturBdnUsaha.setKodeKtrCabang(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_KTR_CABANG]));
            entDebiturBdnUsaha.setOperasiData(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_OPERASI_DATA]));
            entDebiturBdnUsaha.setKodeJenisNsb(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_KODE_JENIS_NSB]));
            entDebiturBdnUsaha.setPeriodeId(rs.getLong(fieldNames[FLD_PERIODE_ID]));
            entDebiturBdnUsaha.setStatusOperasiData(rs.getInt("STATUS_OPERASI_DATA"));
            entDebiturBdnUsaha.setTeleponSeluler(rs.getString(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_TELEPON_SELULER]));
            entDebiturBdnUsaha.setStatusData(rs.getInt(fieldNames[FLD_STATUS_PERUBAHAN_DATA]));
            entDebiturBdnUsaha.setNoRekening(rs.getString("NO_REKENING"));
            //entDebiturBdnUsaha.setTglAkadAkhir(rs.getDate("TGL_AKAD_AKHIR"));
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
                    + "TRIM(DEBITUR_OID) AS DEBITUR_OID, " +
                    "TRIM(FLAG_DETAIL) AS  FLAG_DETAIL, " +
                    "TRIM(CIF) AS  CIF, " +
                    "TRIM(NO_IDENTITAS) AS  NO_IDENTITAS, " +
                    "TRIM(NAMA_BADAN_USAHA) AS  NAMA_BADAN_USAHA, " +
                    "TRIM(KODE_JENIS_USAHA) AS  KODE_JENIS_USAHA, " +
                    "TRIM(TEMPAT_PENDIRIAN) AS  TEMPAT_PENDIRIAN, " +
                    "TRIM(NO_AKTE) AS  NO_AKTE, " +
                    "TRIM(TGL_AKTE_PENDIRIAN) AS  TGL_AKTE_PENDIRIAN, " +
                    "TRIM(NO_AKTE_PERUBAHAN) AS  NO_AKTE_PERUBAHAN, " +
                    "TRIM(TGL_AKTE_PERUBAHAN) AS  TGL_AKTE_PERUBAHAN, " +
                    "TRIM(TELEPON) AS  TELEPON, " +
                    "TRIM(NOMOR_HP) AS  NOMOR_HP, " +
                    "TRIM(EMAIL) AS  EMAIL, " +
                    "TRIM(ALAMAT) AS  ALAMAT, " +
                    "TRIM(KELURAHAN) AS  KELURAHAN, " +
                    "TRIM(KECAMATAN) AS  KECAMATAN, " +
                    "TRIM(KODE_KAB) AS  KODE_KAB, " +
                    "TRIM(KODE_POS) AS  KODE_POS, " +
                    "TRIM(KODE_DOMISILI) AS  KODE_DOMISILI, " +
                    "TRIM(KODE_BIDANG_USAHA ) AS  KODE_BIDANG_USAHA , " +
                    "TRIM(KODE_HUB_LJK) AS  KODE_HUB_LJK, " +
                    "TRIM(MELANGGAR_BMPK) AS  MELANGGAR_BMPK, " +
                    "TRIM(MELAMPAUI_BMPK) AS  MELAMPAUI_BMPK, " +
                    "TRIM(GO_PUBLIC) AS  GO_PUBLIC, " +
                    "TRIM(KODE_GOL) AS  KODE_GOL, " +
                    "TRIM(PERINGKAT) AS  PERINGKAT, " +
                    "TRIM(LEMBAGA_PEMERINGKAT) AS  LEMBAGA_PEMERINGKAT, " +
                    "TRIM(TGL_PEMERINGKAT) AS  TGL_PEMERINGKAT, " +
                    "TRIM(NAMA_GROUP) AS  NAMA_GROUP, " +
                    "TRIM(KODE_KANTOR_CABANG) AS  KODE_KANTOR_CABANG, " +
                    "TRIM(OPERASI_DATA) AS  OPERASI_DATA, " +
                    "TRIM(PERIODE_ID) AS  PERIODE_ID, " +
                    "TRIM(KODE_JENIS_NSB) AS  KODE_JENIS_NSB, " +
                    "TRIM(STATUS_DATA) AS  STATUS_DATA, "
                    + "STATUS_OPERASI_DATA"
                    + " FROM " + TBL_DEBITUR_BDN_USAHA;
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
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObject(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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
    
    
    public static Vector list(int limitStart, int recordToGet, String whereClause, String order, String periodeId, String kodeCabang) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT "
                    + "TRIM(DEBITUR_OID) AS DEBITUR_OID, " +
                    "TRIM(FLAG_DETAIL) AS  FLAG_DETAIL, " +
                    "TRIM(CIF) AS  CIF, " +
                    "TRIM(NO_IDENTITAS) AS  NO_IDENTITAS, " +
                    "TRIM(NAMA_BADAN_USAHA) AS  NAMA_BADAN_USAHA, " +
                    "TRIM(KODE_JENIS_USAHA) AS  KODE_JENIS_USAHA, " +
                    "TRIM(TEMPAT_PENDIRIAN) AS  TEMPAT_PENDIRIAN, " +
                    "TRIM(NO_AKTE) AS  NO_AKTE, " +
                    "TRIM(TGL_AKTE_PENDIRIAN) AS  TGL_AKTE_PENDIRIAN, " +
                    "TRIM(NO_AKTE_PERUBAHAN) AS  NO_AKTE_PERUBAHAN, " +
                    "TRIM(TGL_AKTE_PERUBAHAN) AS  TGL_AKTE_PERUBAHAN, " +
                    "TRIM(TELEPON) AS  TELEPON, " +
                    "TRIM(NOMOR_HP) AS  NOMOR_HP, " +
                    "TRIM(EMAIL) AS  EMAIL, " +
                    "TRIM(ALAMAT) AS  ALAMAT, " +
                    "TRIM(KELURAHAN) AS  KELURAHAN, " +
                    "TRIM(KECAMATAN) AS  KECAMATAN, " +
                    "TRIM(KODE_KAB) AS  KODE_KAB, " +
                    "TRIM(KODE_POS) AS  KODE_POS, " +
                    "TRIM(KODE_DOMISILI) AS  KODE_DOMISILI, " +
                    "TRIM(KODE_BIDANG_USAHA ) AS  KODE_BIDANG_USAHA , " +
                    "TRIM(KODE_HUB_LJK) AS  KODE_HUB_LJK, " +
                    "TRIM(MELANGGAR_BMPK) AS  MELANGGAR_BMPK, " +
                    "TRIM(MELAMPAUI_BMPK) AS  MELAMPAUI_BMPK, " +
                    "TRIM(GO_PUBLIC) AS  GO_PUBLIC, " +
                    "TRIM(KODE_GOL) AS  KODE_GOL, " +
                    "TRIM(PERINGKAT) AS  PERINGKAT, " +
                    "TRIM(LEMBAGA_PEMERINGKAT) AS  LEMBAGA_PEMERINGKAT, " +
                    "TRIM(TGL_PEMERINGKAT) AS  TGL_PEMERINGKAT, " +
                    "TRIM(NAMA_GROUP) AS  NAMA_GROUP, " +
                    "TRIM(KODE_KANTOR_CABANG) AS  KODE_KANTOR_CABANG, " +
                    "TRIM(OPERASI_DATA) AS  OPERASI_DATA, " +
                    "TRIM(PERIODE_ID) AS  PERIODE_ID, " +
                    "TRIM(KODE_JENIS_NSB) AS  KODE_JENIS_NSB, " +
                    "TRIM(STATUS_DATA) AS  STATUS_DATA, "+ " STATUS_OPERASI_DATA "+ " FROM " + TBL_DEBITUR_BDN_USAHA +" AS debitur WHERE debitur.PERIODE_ID='"+periodeId+"' ";
            
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " AND " + whereClause;
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
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObject(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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
                    + "TRIM(DEBITUR_OID) AS DEBITUR_OID, " +
                    "TRIM(FLAG_DETAIL) AS  FLAG_DETAIL, " +
                    "TRIM(CIF) AS  CIF, " +
                    "TRIM(NO_IDENTITAS) AS  NO_IDENTITAS, " +
                    "TRIM(NAMA_BADAN_USAHA) AS  NAMA_BADAN_USAHA, " +
                    "TRIM(KODE_JENIS_USAHA) AS  KODE_JENIS_USAHA, " +
                    "TRIM(TEMPAT_PENDIRIAN) AS  TEMPAT_PENDIRIAN, " +
                    "TRIM(NO_AKTE) AS  NO_AKTE, " +
                    "TRIM(TGL_AKTE_PENDIRIAN) AS  TGL_AKTE_PENDIRIAN, " +
                    "TRIM(NO_AKTE_PERUBAHAN) AS  NO_AKTE_PERUBAHAN, " +
                    "TRIM(TGL_AKTE_PERUBAHAN) AS  TGL_AKTE_PERUBAHAN, " +
                    "TRIM(TELEPON) AS  TELEPON, " +
                    "TRIM(NOMOR_HP) AS  NOMOR_HP, " +
                    "TRIM(EMAIL) AS  EMAIL, " +
                    "TRIM(ALAMAT) AS  ALAMAT, " +
                    "TRIM(KELURAHAN) AS  KELURAHAN, " +
                    "TRIM(KECAMATAN) AS  KECAMATAN, " +
                    "TRIM(KODE_KAB) AS  KODE_KAB, " +
                    "TRIM(KODE_POS) AS  KODE_POS, " +
                    "TRIM(KODE_DOMISILI) AS  KODE_DOMISILI, " +
                    "TRIM(KODE_BIDANG_USAHA ) AS  KODE_BIDANG_USAHA , " +
                    "TRIM(KODE_HUB_LJK) AS  KODE_HUB_LJK, " +
                    "TRIM(MELANGGAR_BMPK) AS  MELANGGAR_BMPK, " +
                    "TRIM(MELAMPAUI_BMPK) AS  MELAMPAUI_BMPK, " +
                    "TRIM(GO_PUBLIC) AS  GO_PUBLIC, " +
                    "TRIM(KODE_GOL) AS  KODE_GOL, " +
                    "TRIM(PERINGKAT) AS  PERINGKAT, " +
                    "TRIM(LEMBAGA_PEMERINGKAT) AS  LEMBAGA_PEMERINGKAT, " +
                    "TRIM(TGL_PEMERINGKAT) AS  TGL_PEMERINGKAT, " +
                    "TRIM(NAMA_GROUP) AS  NAMA_GROUP, " +
                    "TRIM(KODE_KANTOR_CABANG) AS  KODE_KANTOR_CABANG, " +
                    "TRIM(OPERASI_DATA) AS  OPERASI_DATA, " +
                    "TRIM(PERIODE_ID) AS  PERIODE_ID, " +
                    "TRIM(KODE_JENIS_NSB) AS  KODE_JENIS_NSB, " 
//                    "TRIM(STATUS_DATA) AS  STATUS_DATA, "
//                    + "STATUS_OPERASI_DATA"
//                    + " FROM " + TBL_DEBITUR_BDN_USAHA;
                      + "TRIM(STATUS_DATA) AS STATUS_DATA, "
                      + "STATUS_OPERASI_DATA, "
                      + "TRIM(PARENT_CODE) AS PARENT_CODE "  
                      + "FROM " + TBL_DEBITUR_BDN_USAHA+" "
                      + "INNER JOIN dslik_cabang_bank ON "+TBL_DEBITUR_BDN_USAHA+"."+fieldNames[FLD_KODE_KTR_CABANG]+"=dslik_cabang_bank.KODE_CABANG";
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
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObjectParentCabang(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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
    
    
    
     public static Vector listJoinReport(int limitStart, int recordToGet, String whereClause, String order, long periodeId, String kodecabang) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT "
                      + "TRIM(dslik_debitur.DEBITUR_OID) AS DEBITUR_OID, " +
                        "TRIM(dslik_debitur.FLAG_DETAIL) AS  FLAG_DETAIL, " +
                        "TRIM(dslik_debitur.CIF) AS  CIF, "+ 
                        "TRIM(dup.NO_REKENING) AS NO_REKENING, " +
                        "TRIM(dslik_debitur.NO_IDENTITAS) AS  NO_IDENTITAS, " +
                        "TRIM(dslik_debitur.NAMA_BADAN_USAHA) AS  NAMA_BADAN_USAHA, " +
                        "TRIM(dslik_debitur.KODE_JENIS_USAHA) AS  KODE_JENIS_USAHA, " +
                        "TRIM(dslik_debitur.TEMPAT_PENDIRIAN) AS  TEMPAT_PENDIRIAN, " +
                        "TRIM(dslik_debitur.NO_AKTE) AS  NO_AKTE, " +
                        "TRIM(dslik_debitur.TGL_AKTE_PENDIRIAN) AS  TGL_AKTE_PENDIRIAN, " +
                        "TRIM(dslik_debitur.NO_AKTE_PERUBAHAN) AS  NO_AKTE_PERUBAHAN, " +
                        "TRIM(dslik_debitur.TGL_AKTE_PERUBAHAN) AS  TGL_AKTE_PERUBAHAN, " +
                        "TRIM(dslik_debitur.TELEPON) AS  TELEPON, " +
                        "TRIM(dslik_debitur.NOMOR_HP) AS  NOMOR_HP, " +
                        "TRIM(dslik_debitur.EMAIL) AS  EMAIL, " +
                        "TRIM(dslik_debitur.ALAMAT) AS  ALAMAT, " +
                        "TRIM(dslik_debitur.KELURAHAN) AS  KELURAHAN, " +
                        "TRIM(dslik_debitur.KECAMATAN) AS  KECAMATAN, " +
                        "TRIM(dslik_debitur.KODE_KAB) AS  KODE_KAB, " +
                        "TRIM(dslik_debitur.KODE_POS) AS  KODE_POS, " +
                        "TRIM(dslik_debitur.KODE_DOMISILI) AS  KODE_DOMISILI, " +
                        "TRIM(dslik_debitur.KODE_BIDANG_USAHA ) AS  KODE_BIDANG_USAHA , " +
                        "TRIM(dslik_debitur.KODE_HUB_LJK) AS  KODE_HUB_LJK, " +
                        "TRIM(dslik_debitur.MELANGGAR_BMPK) AS  MELANGGAR_BMPK, " +
                        "TRIM(dslik_debitur.MELAMPAUI_BMPK) AS  MELAMPAUI_BMPK, " +
                        "TRIM(dslik_debitur.GO_PUBLIC) AS  GO_PUBLIC, " +
                        "TRIM(dslik_debitur.KODE_GOL) AS  KODE_GOL, " +
                        "TRIM(dslik_debitur.PERINGKAT) AS  PERINGKAT, " +
                        "TRIM(dslik_debitur.LEMBAGA_PEMERINGKAT) AS  LEMBAGA_PEMERINGKAT, " +
                        "TRIM(dslik_debitur.TGL_PEMERINGKAT) AS  TGL_PEMERINGKAT, " +
                        "TRIM(dslik_debitur.NAMA_GROUP) AS  NAMA_GROUP, " +
                        "TRIM(dslik_debitur.KODE_KANTOR_CABANG) AS  KODE_KANTOR_CABANG, " +
                        "TRIM(dslik_debitur.OPERASI_DATA) AS  OPERASI_DATA, " +
                        "TRIM(dslik_debitur.PERIODE_ID) AS  PERIODE_ID, " +
                        "TRIM(dslik_debitur.KODE_JENIS_NSB) AS  KODE_JENIS_NSB, " +
                        "TRIM(dslik_debitur.STATUS_DATA) AS  STATUS_DATA, "
                      + "STATUS_OPERASI_DATA"
                      + " FROM " + TBL_DEBITUR_BDN_USAHA+""
                      
//                      + " INNER JOIN " +
//                        " (" +
//                        " SELECT DISTINCT CIF, NO_REKENING, TGL_AKAD_AKHIR, KODE_KANTOR_CABANG FROM dslik_kredit WHERE dslik_kredit.PERIODE_ID = '"+periodeId+"' " +
//                        " GROUP BY CIF ORDER BY dslik_kredit.TGL_AKAD_AKHIR DESC " +
//                        " ) AS dup" +
                    + " INNER JOIN " +
                        "(" +
                            "SELECT DISTINCT CIF, NO_REKENING FROM (" +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_kredit" +
                            " WHERE dslik_kredit.PERIODE_ID = '"+periodeId+"' ";
                            if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_kredit.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                sql = sql + " GROUP BY CIF" +
                            " UNION " +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_DITERBITKAN AS TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_bank_garansi" +
                            " WHERE dslik_bank_garansi.PERIODE_ID = '"+periodeId+"' ";
                if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_bank_garansi.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                    sql = sql +" GROUP BY CIF ) AS CUP " +
                            " ORDER BY CUP.TGL_AWAL DESC "+
                        ") AS dup " +
                    
                    
                    
                        " ON dslik_debitur.CIF=dup.CIF ";
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
            int urut=0;
            String cif1 = "";
            String cif2 = "";
            while (rs.next()) {
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObjectJoinReport(rs, entDebiturBdnUsaha);
                if(urut==0){
                    lists.add(entDebiturBdnUsaha);
                    cif1 = entDebiturBdnUsaha.getCif();
                }else{
                    cif2 = entDebiturBdnUsaha.getCif();
                    if(!cif1.equals(cif2)){
                        lists.add(entDebiturBdnUsaha);
                        cif1=entDebiturBdnUsaha.getCif();
                    }
                }
                urut=urut+1;
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
            String sql = "SELECT DISTINCT debitur.* FROM " + TBL_DEBITUR_BDN_USAHA+" AS debitur "
                    + "INNER JOIN "+PstPeriode.TBL_PERIODE+" AS periode "
                    + "ON debitur."+fieldNames[FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+" "
                    + "AND periode."+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'";
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
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObject(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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
    
    public static Vector listJoinTanpaPengurus(int limitStart, int recordToGet, String whereClause, String order, String periodeId, String kodecabang) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT debitur.* FROM " + TBL_DEBITUR_BDN_USAHA +" AS debitur "
                        + " INNER JOIN " +
                        "(" +
                            "SELECT DISTINCT CIF FROM (" +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_kredit" +
                            " WHERE dslik_kredit.PERIODE_ID = '"+periodeId+"' ";
                            if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_kredit.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                sql = sql + " GROUP BY CIF" +
                            " UNION " +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_DITERBITKAN AS TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_bank_garansi" +
                            " WHERE dslik_bank_garansi.PERIODE_ID = '"+periodeId+"' ";
                if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_bank_garansi.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                    sql = sql +" GROUP BY CIF ) AS CUP " +
                            " ORDER BY CUP.TGL_AWAL DESC "+
                        ") AS dup " +
                        "ON debitur.CIF=dup.CIF";
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
                sql = sql + " AND debitur.CIF NOT IN (SELECT CIF FROM "+PstPengurusAtauPemilik.TBL_PENGURUS_ATAU_PEMILIK+" WHERE periode_id='"+periodeId+"') ";
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
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObject(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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
    
    public static Vector listJoin(int limitStart, int recordToGet, String whereClause, String order, String xxx, String kodecabang) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT debitur.* FROM " + TBL_DEBITUR_BDN_USAHA +" AS debitur "
                        + " INNER JOIN " +
                        "(" +
                            "SELECT DISTINCT CIF FROM (" +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_kredit" +
                            " WHERE dslik_kredit.PERIODE_ID = '"+xxx+"' ";
                            if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_kredit.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                sql = sql + " GROUP BY CIF" +
                            " UNION " +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_DITERBITKAN AS TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_bank_garansi" +
                            " WHERE dslik_bank_garansi.PERIODE_ID = '"+xxx+"' ";
                if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_bank_garansi.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                    sql = sql +" GROUP BY CIF ) AS CUP " +
                            " ORDER BY CUP.TGL_AWAL DESC "+
                        ") AS dup " +
                        "ON debitur.CIF=dup.CIF";
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
                DebiturBdnUsaha entDebiturBdnUsaha = new DebiturBdnUsaha();
                resultToObject(rs, entDebiturBdnUsaha);
                lists.add(entDebiturBdnUsaha);
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

    public static boolean checkOID(long entDebiturBdnUsahaId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT DISTINCT * FROM " + TBL_DEBITUR_BDN_USAHA + " WHERE "
                    + PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID] + " = " + entDebiturBdnUsahaId;
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
            String sql = "SELECT DISTINCT COUNT(" + PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID] + ") FROM " + TBL_DEBITUR_BDN_USAHA;
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
    
    
     public static int getCountGlobal(String whereClause, String periodeId, String cabang) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT COUNT(" + PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID] + ") FROM " + TBL_DEBITUR_BDN_USAHA+
                         " AS debitur WHERE PERIODE_ID='"+periodeId+"'";
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " AND " + whereClause;
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
    
    public static int getCountTidakAdaPengurus(String whereClause, String periodeId, String kodecabang) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT DISTINCT COUNT(debitur." + PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID] + ") "
                    + "FROM " + TBL_DEBITUR_BDN_USAHA+" AS debitur "
                    + " INNER JOIN " +
                        "(" +
                            "SELECT DISTINCT CIF FROM (" +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_kredit" +
                            " WHERE dslik_kredit.PERIODE_ID = '"+periodeId+"' ";
                            if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_kredit.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                sql = sql + " GROUP BY CIF" +
                            " UNION " +
                            " SELECT DISTINCT" +
                            " CIF," +
                            " NO_REKENING," +
                            " TGL_DITERBITKAN AS TGL_AWAL," +
                            " KODE_KANTOR_CABANG" +
                            " FROM dslik_bank_garansi" +
                            " WHERE dslik_bank_garansi.PERIODE_ID = '"+periodeId+"' ";
                if(!kodecabang.equals("")){
                                sql = sql + " AND dslik_bank_garansi.KODE_KANTOR_CABANG='"+kodecabang+"'";
                            }
                    sql = sql +" GROUP BY CIF ) AS CUP " +
                            " ORDER BY CUP.TGL_AWAL DESC "+
                    ") AS dup " +
                    "ON debitur.CIF=dup.CIF";
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
                sql = sql + " AND debitur.CIF NOT IN (SELECT CIF FROM dslik_pengurus_atau_pemilik WHERE periode_id='"+periodeId+"') ";
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
            String sql = "SELECT DISTINCT COUNT(debitur." + PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID] + ") "
                    + "FROM " + TBL_DEBITUR_BDN_USAHA+" AS debitur "
                    + "INNER JOIN "+PstPeriode.TBL_PERIODE+" AS periode "
                    + "ON debitur."+fieldNames[FLD_PERIODE_ID]+"=periode."+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+" "
                    + "AND periode."+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'";
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
                    DebiturBdnUsaha entDebiturBdnUsaha = (DebiturBdnUsaha) list.get(ls);
                    if (oid == entDebiturBdnUsaha.getOID()) {
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
    
    
    public static long updateStatusData(long oidDebitur) throws DBException {
        if(oidDebitur==0){
            return 0;
        }
        int iResult = 0;
        DBResultSet dbrs = null;
        String stSql = "UPDATE "+TBL_DEBITUR_BDN_USAHA+" SET STATUS_DATA=0 WHERE "+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID]+"='"+oidDebitur+"'";
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
        String stSql = "UPDATE "+TBL_DEBITUR_BDN_USAHA+" SET STATUS_OPERASI_DATA='"+statusOperasiData+"' WHERE "+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_DEBITUR_BDN_USHA_OID]+"='"+oidDebitur+"'";
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