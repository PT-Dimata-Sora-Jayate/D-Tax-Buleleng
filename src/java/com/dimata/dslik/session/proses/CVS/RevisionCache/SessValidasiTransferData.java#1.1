/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

import com.dimata.dslik.entity.debitur.Debitur;
import com.dimata.dslik.entity.debitur.PstDebitur;
import static com.dimata.dslik.entity.debitur.PstDebitur.FLD_KODE_BIDANG_USAHA;
import static com.dimata.dslik.entity.debitur.PstDebitur.resultToObject;
import com.dimata.dslik.entity.kredit.Kredit;
import com.dimata.dslik.entity.kredit.PstKredit;
import static com.dimata.dslik.entity.kredit.PstKredit.TBL_KREDIT;
import static com.dimata.dslik.entity.kredit.PstKredit.resultToObject;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class SessValidasiTransferData {
    public static Vector list(int limitStart, int recordToGet, String whereClause, String order, long periodeId, long prevPeriode) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = " SELECT * FROM dslik_debitur WHERE PERIODE_ID='"+prevPeriode+"'  AND CIF IN ( " +
                            " SELECT CIF FROM dslik_kredit WHERE PERIODE_ID='"+periodeId+"' AND CIF NOT IN (SELECT CIF FROM dslik_debitur WHERE PERIODE_ID='"+periodeId+"') " +
                         " )";
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
                Debitur entDebitur = new Debitur();
                resultToObject(rs, entDebitur, periodeId);
                lists.add(entDebitur);
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
    
   public static void resultToObject(ResultSet rs, Debitur entDebitur, long periodeId) {
        try {
            entDebitur.setOID(rs.getLong(PstDebitur.fieldNames[PstDebitur.FLD_DEBITUR_OID]));
            entDebitur.setFlagDetail(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_FLAG_DETAIL]));
            entDebitur.setCif(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_CIF]));
            entDebitur.setJenisIdentitas(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_JENIS_IDENTITAS]));
            entDebitur.setNik(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NIK]));
            entDebitur.setNamaIdentitas(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NAMA_IDENTITAS]));
            entDebitur.setNamaLengkap(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NAMA_LENGKAP]));
            entDebitur.setKodeStatusGelar(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_STATUS_GELAR]));
            entDebitur.setJekel(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_JEKEL]));
            entDebitur.setTempatLahir(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_TEMPAT_LAHIR]));
            entDebitur.setTglLahir(rs.getDate(PstDebitur.fieldNames[PstDebitur.FLD_TGL_LAHIR]));
            entDebitur.setNpwp(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NPWP]));
            entDebitur.setAlamat(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_ALAMAT]));
            entDebitur.setKelurahan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KELURAHAN]));
            entDebitur.setKecamatan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KECAMATAN]));
            entDebitur.setKodeKab(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_KAB]));
            entDebitur.setKodePos(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_POS]));
            entDebitur.setTelepon(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_TELEPON]));
            entDebitur.setNomorHp(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NOMOR_HP]));
            entDebitur.setEmail(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_EMAIL]));
            entDebitur.setKodeDomisili(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_DOMISILI]));
            entDebitur.setKodePekerjaan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_PEKERJAAN]));
            entDebitur.setTempatBekerja(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_TEMPAT_BEKERJA]));
            entDebitur.setKodeUsahaTempatBekerja(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_USAHA_TEMPAT_BEKERJA]));
            entDebitur.setAlamatTempatBekerja(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_ALAMAT_TEMPAT_BEKERJA]));
            entDebitur.setPenghasilanKotor(rs.getDouble(PstDebitur.fieldNames[PstDebitur.FLD_PENGHASILAN_KOTOR]));
            entDebitur.setKodePenghasilan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_PENGHASILAN]));
            entDebitur.setJmlTanggungan(rs.getInt(PstDebitur.fieldNames[PstDebitur.FLD_JML_TANGGUNGAN]));
            entDebitur.setKodeHub(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_HUB]));
            entDebitur.setKodeGol(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_GOL]));
            entDebitur.setStatus(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_STATUS]));
            entDebitur.setNikPasangan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NIK_PASANGAN]));
            entDebitur.setNamaPasangan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NAMA_PASANGAN]));
            entDebitur.setTglLahirPasangan(rs.getDate(PstDebitur.fieldNames[PstDebitur.FLD_TGL_LAHIR_PASANGAN]));
            entDebitur.setPerjanjianPisahHarga(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_PERJANJIAN_PISAH_HARGA]));
            entDebitur.setMelanggarBmpk(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_MELANGGAR_BMPK]));
            entDebitur.setMelampauiBmpk(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_MELAMPAUI_BMPK]));
            entDebitur.setNamaIbuKandung(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NAMA_IBU_KANDUNG]));
            entDebitur.setKodeKantorCabang(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_KANTOR_CABANG]));
            entDebitur.setOperasiData(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_OPERASI_DATA]));
            entDebitur.setNoIdentitas(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NO_IDENTITAS]));
            entDebitur.setNamaBadanUsaha(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NAMA_BADAN_USAHA]));
            entDebitur.setKodeJenisUsaha(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_JENIS_USAHA]));
            entDebitur.setTempatPendirian(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_TEMPAT_PENDIRIAN]));
            entDebitur.setNoAkte(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NO_AKTE]));
            entDebitur.setTglAktePendirian(rs.getDate(PstDebitur.fieldNames[PstDebitur.FLD_TGL_AKTE_PENDIRIAN]));
            entDebitur.setNoAktePerubahan(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NO_AKTE_PERUBAHAN]));
            entDebitur.setTglAktePerubahan(rs.getDate(PstDebitur.fieldNames[PstDebitur.FLD_TGL_AKTE_PERUBAHAN]));
            entDebitur.setKodeBidangUsaha(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_BIDANG_USAHA]));
            entDebitur.setKodeHubLjk(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_KODE_HUB_LJK]));
            entDebitur.setGoPublic(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_GO_PUBLIC]));
            entDebitur.setPeringkat(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_PERINGKAT]));
            entDebitur.setLembagaPemeringkat(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_LEMBAGA_PEMERINGKAT]));
            entDebitur.setTglPemeringkat(rs.getDate(PstDebitur.fieldNames[PstDebitur.FLD_TGL_PEMERINGKAT]));
            entDebitur.setNamaGroup(rs.getString(PstDebitur.fieldNames[PstDebitur.FLD_NAMA_GROUP]));
            entDebitur.setOpenDate(rs.getDate(PstDebitur.fieldNames[PstDebitur.FLD_OPEN_DATE]));
            entDebitur.setKodeJenisNsb(rs.getInt(PstDebitur.fieldNames[PstDebitur.FLD_KODE_JENIS_NSB]));
            entDebitur.setPeriodeId(rs.getLong(PstDebitur.fieldNames[PstDebitur.FLD_PERIODE_ID]));
            
        } catch (Exception e) {
        }
    }
    
}
