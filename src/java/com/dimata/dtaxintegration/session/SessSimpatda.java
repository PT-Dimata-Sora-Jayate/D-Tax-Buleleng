/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

/**
 *
 * @author dimata005
 */
/**
 *
 * @author dimata005
 */
/* java package */
import com.dimata.dtaxintegration.entity.inquery.Bphtb;
import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.dtaxintegration.entity.inquery.Pbb;
import com.dimata.dtaxintegration.entity.inquery.Retribusi;
import com.dimata.dtaxintegration.entity.inquery.Simpatda;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.payment.PaymentBphtbIprotax;
import com.dimata.dtaxintegration.entity.payment.PaymentBphtbRaversalIprotax;
import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtbIprotax;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtbRaversalIprotax;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhr;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhrforOpenPhr;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhrforPhrH;
import com.dimata.dtaxintegration.entity.payment.PstPaymentRetribusi;
import java.sql.*;

/* package qdep */
import com.dimata.qdep.db.*;
import com.dimata.util.ChekPenghilanganPiutang;
import com.dimata.util.Diskon;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class SessSimpatda {

    public static Vector getListSimpatda(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT ID, replace(NAMA, '''', '') AS NAMA, JUMLAH, INSTANSI, MASA_PAJAK, TAHUN_PAJAK, ALAMAT, POKOK, DENDA, ID_KEY, NO_SPTPD FROM VIEW_SIMPATDA ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("ID"));
                simpatda.setNpwpd(rs.getString("ID"));
                simpatda.setNamaSimpatda(rs.getString("NAMA"));
                simpatda.setJumlahPajakSimpatda(rs.getString("JUMLAH"));
                simpatda.setInstansi(rs.getString("INSTANSI"));
                simpatda.setAlamat(rs.getString("ALAMAT"));
                simpatda.setBulanSimpatda(rs.getString("MASA_PAJAK"));
                simpatda.setTahunSimpatda(rs.getString("TAHUN_PAJAK"));
                simpatda.setPokok(rs.getString("POKOK"));
                simpatda.setDenda(rs.getString("DENDA"));
                simpatda.setNoSspdSimpatda(rs.getString("NO_SPTPD"));
                simpatda.setKeterangan(rs.getString("ID_KEY"));

                result.add(simpatda);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public synchronized static Vector getListSimpatdaOpenPhr(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " sNoId,"
                    + //id
                    " sNama,"
                    + //nama
                    " jum_tagihan,"
                    + //jumlah
                    " sKet_1,"
                    + //alamat
                    " sKet_2,"
                    + //bulan
                    " sKet_3,"
                    + //tahun
                    " sKet_4,"
                    + //pokok
                    " sKet_5,"
                    + //denda
                    " sKet_6,"
                    + //keterangan
                    " sKet_7,"
                    + //npwpd
                    " sKet_8,"
                    + //tanggal awal
                    " sKet_9,"
                    + // tanggal akhir
                    " npwpd "
                    + " FROM view_simpatda ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("sNoId"));
                simpatda.setNpwpd(rs.getString("sKet_7"));
                simpatda.setNamaSimpatda(rs.getString("sNama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jum_tagihan"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("sKet_1"));
                simpatda.setBulanSimpatda(rs.getString("sKet_2"));
                simpatda.setTahunSimpatda(rs.getString("sKet_3"));
                simpatda.setPokok(rs.getString("sKet_4"));
                simpatda.setDenda(rs.getString("sKet_5"));
                simpatda.setKeterangan(rs.getString("sKet_6"));
                simpatda.setTanggalAwal(Formater.formatDate(rs.getDate("sKet_8"), "yyyy-MM-dd"));
                simpatda.setTanggalAkhir(Formater.formatDate(rs.getDate("sKet_9"), "yyyy-MM-dd"));
                result.add(simpatda);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaPhrH(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " kode_id,"
                    + //id
                    " nama,"
                    + //nama
                    " jumlah,"
                    + //jumlah
                    " alamat,"
                    + //alamat
                    " bulan,"
                    + //bulan
                    " tahun,"
                    + //tahun
                    " tagihan_pajak,"
                    + //pokok
                    " tagihan_denda,"
                    + //denda
                    " tagihan_admin, "
                    +//tagihan admin
                    " npwpd_search,"
                    + //npwpd
                    " waktu,"
                    + //tanggal awal
                    " jenis_usaha,"
                    + // tanggal akhir
                    " npwpd, jatuh_tempo "
                    + " FROM view_simpatda ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("kode_id"));
                simpatda.setNpwpd(rs.getString("npwpd"));
                simpatda.setNamaSimpatda(rs.getString("nama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jumlah"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("alamat"));
                simpatda.setBulanSimpatda(rs.getString("bulan"));
                simpatda.setTahunSimpatda(rs.getString("tahun"));
                simpatda.setPokok(rs.getString("tagihan_pajak"));
                simpatda.setDenda(rs.getString("tagihan_denda"));
                simpatda.setTagihanAdmin(rs.getString("tagihan_admin"));

                simpatda.setWaktu(Formater.formatDate(rs.getDate("waktu"), "yyyy-MM-dd hh:mm:ss"));
                simpatda.setJenisUsaha(rs.getString("jenis_usaha"));
                simpatda.setJatuhTempo(Formater.formatDate(rs.getDate("jatuh_tempo"), "yyyy-MM-dd"));
                simpatda.setKeterangan("-");
                result.add(simpatda);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaPhrHLengkap(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " kode_id,"
                    + //id
                    " nama,"
                    + //nama
                    " jumlah,"
                    + //jumlah
                    " alamat,"
                    + //alamat
                    " bulan,"
                    + //bulan
                    " tahun,"
                    + //tahun
                    " tagihan_pajak,"
                    + //pokok
                    " tagihan_denda,"
                    + //denda
                    " tagihan_admin, "
                    +//tagihan admin
                    " npwpd_search,"
                    + //npwpd
                    " waktu,"
                    + //tanggal awal
                    " jenis_usaha,"
                    + // tanggal akhir
                    " npwpd, jatuh_tempo "
                    + " FROM view_simpatda_lengkap ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("kode_id"));
                simpatda.setNpwpd(rs.getString("npwpd"));
                simpatda.setNamaSimpatda(rs.getString("nama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jumlah"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("alamat"));
                simpatda.setBulanSimpatda(rs.getString("bulan"));
                simpatda.setTahunSimpatda(rs.getString("tahun"));
                simpatda.setPokok(rs.getString("tagihan_pajak"));
                simpatda.setDenda(rs.getString("tagihan_denda"));
                simpatda.setTagihanAdmin(rs.getString("tagihan_admin"));

                simpatda.setWaktu(Formater.formatDate(rs.getDate("waktu"), "yyyy-MM-dd hh:mm:ss"));
                simpatda.setJenisUsaha(rs.getString("jenis_usaha"));
                simpatda.setJatuhTempo(Formater.formatDate(rs.getDate("jatuh_tempo"), "yyyy-MM-dd"));
                simpatda.setKeterangan("-");
                result.add(simpatda);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaOpenPhrAuto(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " sNoId,"
                    + //id
                    " sNama,"
                    + //nama
                    " jum_tagihan,"
                    + //jumlah
                    " sKet_1,"
                    + //alamat
                    " sKet_2,"
                    + //bulan
                    " sKet_3,"
                    + //tahun
                    " sKet_4,"
                    + //pokok
                    " sKet_5,"
                    + //denda
                    " sKet_6,"
                    + //keterangan
                    " sKet_7,"
                    + //npwpd
                    " sKet_8,"
                    + //tanggal awal
                    " sKet_9,"
                    + // tanggal akhir
                    " npwpd "
                    + " FROM view_simpatda_compare ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("sNoId"));
                simpatda.setNpwpd(rs.getString("sKet_7"));
                simpatda.setNamaSimpatda(rs.getString("sNama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jum_tagihan"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("sKet_1"));
                simpatda.setBulanSimpatda(rs.getString("sKet_2"));
                simpatda.setTahunSimpatda(rs.getString("sKet_3"));
                simpatda.setPokok(rs.getString("sKet_4"));
                simpatda.setDenda(rs.getString("sKet_5"));
                simpatda.setKeterangan(rs.getString("sKet_6"));
                simpatda.setTanggalAwal(Formater.formatDate(rs.getDate("sKet_8"), "yyyy-MM-dd"));
                simpatda.setTanggalAkhir(Formater.formatDate(rs.getDate("sKet_9"), "yyyy-MM-dd"));
                result.add(simpatda);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaPhrHAuto(String where) {
        if (DTaxIntegrationManager.running) {
            return new Vector();
        }
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " kode_id,"
                    + //id
                    " nama,"
                    + //nama
                    " jumlah,"
                    + //jumlah
                    " alamat,"
                    + //alamat
                    " bulan,"
                    + //bulan
                    " tahun,"
                    + //tahun
                    " tagihan_pajak,"
                    + //pokok
                    " tagihan_denda,"
                    + //denda
                    " tagihan_admin, "
                    +//tagihan admin
                    " npwpd_search,"
                    + //npwpd
                    " waktu,"
                    + //tanggal awal
                    " jenis_usaha,"
                    + // tanggal akhir
                    " npwpd, jatuh_tempo "
                    + " FROM view_simpatda_compare ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("kode_id"));
                simpatda.setNpwpd(rs.getString("npwpd"));
                simpatda.setNamaSimpatda(rs.getString("nama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jumlah"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("alamat"));
                simpatda.setBulanSimpatda(rs.getString("bulan"));
                simpatda.setTahunSimpatda(rs.getString("tahun"));
                simpatda.setPokok(rs.getString("tagihan_pajak"));
                simpatda.setDenda(rs.getString("tagihan_denda"));
                simpatda.setTagihanAdmin(rs.getString("tagihan_admin"));

                simpatda.setWaktu(Formater.formatDate(rs.getDate("waktu"), "yyyy-MM-dd hh:mm:ss"));
                simpatda.setJenisUsaha(rs.getString("jenis_usaha"));
                simpatda.setJatuhTempo(Formater.formatDate(rs.getDate("jatuh_tempo"), "yyyy-MM-dd"));
                simpatda.setKeterangan("-");
                result.add(simpatda);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaAuto(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT ID, replace(NAMA, '''', '') AS NAMA, JUMLAH, INSTANSI, MASA_PAJAK, TAHUN_PAJAK, ALAMAT, POKOK, DENDA, ID_KEY, NO_SPTPD  FROM VIEW_SIMPATDA_COMPARE ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                try {
                    simpatda.setId(rs.getString("ID"));
                    simpatda.setNpwpd(rs.getString("ID"));
                    simpatda.setNamaSimpatda(rs.getString("NAMA"));
                    simpatda.setJumlahPajakSimpatda(rs.getString("JUMLAH"));
                    simpatda.setInstansi(rs.getString("INSTANSI"));
                    simpatda.setAlamat(rs.getString("ALAMAT"));
                    simpatda.setBulanSimpatda(rs.getString("MASA_PAJAK"));
                    simpatda.setTahunSimpatda(rs.getString("TAHUN_PAJAK"));
                    simpatda.setPokok(rs.getString("POKOK"));
                    simpatda.setDenda(rs.getString("DENDA"));
                    simpatda.setNoSspdSimpatda("NO_SPTPD");
                    simpatda.setKeterangan(rs.getString("ID_KEY"));

                    result.add(simpatda);
                } catch (Exception ex) {

                }

            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaThread(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT ID, replace(NAMA, '''', '') AS NAMA, JUMLAH, INSTANSI, MASA_PAJAK, TAHUN_PAJAK, ALAMAT, POKOK, DENDA, ID_KEY, NO_SPTPD FROM VIEW_SIMPATDA ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();
                if (!DTaxManagerPhr.running) {
                    return new Vector();
                }
                simpatda.setId(rs.getString("ID"));
                simpatda.setNpwpd(rs.getString("ID"));
                simpatda.setNamaSimpatda(rs.getString("NAMA"));
                simpatda.setJumlahPajakSimpatda(rs.getString("JUMLAH"));
                simpatda.setInstansi(rs.getString("INSTANSI"));
                simpatda.setAlamat(rs.getString("ALAMAT"));
                simpatda.setBulanSimpatda(rs.getString("MASA_PAJAK"));
                simpatda.setTahunSimpatda(rs.getString("TAHUN_PAJAK"));
                simpatda.setPokok(rs.getString("POKOK"));
                simpatda.setDenda(rs.getString("DENDA"));
                simpatda.setNoSspdSimpatda("NO_SPTPD");
                simpatda.setKeterangan(rs.getString("ID_KEY"));

                result.add(simpatda);
                DTaxManagerPhr.countQuery = DTaxManagerPhr.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaThreadOpenPhr(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " sNoId,"
                    + //id
                    " sNama,"
                    + //nama
                    " jum_tagihan,"
                    + //jumlah
                    " sKet_1,"
                    + //alamat
                    " sKet_2,"
                    + //bulan
                    " sKet_3,"
                    + //tahun
                    " sKet_4,"
                    + //pokok
                    " sKet_5,"
                    + //denda
                    " sKet_6,"
                    + //keterangan
                    " sKet_7,"
                    + //npwpd
                    " sKet_8,"
                    + //tanggal awal
                    " sKet_9,"
                    + // tanggal akhir
                    " npwpd "
                    + " FROM view_simpatda";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();

                simpatda.setId(rs.getString("sNoId"));
                simpatda.setNpwpd(rs.getString("sKet_7"));
                simpatda.setNamaSimpatda(rs.getString("sNama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jum_tagihan"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("sKet_1"));
                simpatda.setBulanSimpatda(rs.getString("sKet_2"));
                simpatda.setTahunSimpatda(rs.getString("sKet_3"));
                simpatda.setPokok(rs.getString("sKet_4"));
                simpatda.setDenda(rs.getString("sKet_5"));
                simpatda.setKeterangan(rs.getString("sKet_6"));
                simpatda.setTanggalAwal(Formater.formatDate(rs.getDate("sKet_8"), "yyyy-MM-dd"));
                simpatda.setTanggalAkhir(Formater.formatDate(rs.getDate("sKet_9"), "yyyy-MM-dd"));
                result.add(simpatda);
                DTaxManagerPhr.countQuery = DTaxManagerPhr.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListSimpatdaThreadPhrH(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {
            sql = "SELECT sUser,"
                    + " sPassword,"
                    + " sInstansi,"
                    + " kode_id,"
                    + //id
                    " nama,"
                    + //nama
                    " jumlah,"
                    + //jumlah
                    " alamat,"
                    + //alamat
                    " bulan,"
                    + //bulan
                    " tahun,"
                    + //tahun
                    " tagihan_pajak,"
                    + //pokok
                    " tagihan_denda,"
                    + //denda
                    " tagihan_admin, "
                    +//tagihan admin
                    " npwpd_search,"
                    + //npwpd
                    " waktu,"
                    + //tanggal awal
                    " jenis_usaha,"
                    + // tanggal akhir
                    " npwpd, jatuh_tempo "
                    + " FROM view_simpatda ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Simpatda simpatda = new Simpatda();
                simpatda.setId(rs.getString("kode_id"));
                simpatda.setNpwpd(rs.getString("npwpd"));
                simpatda.setNamaSimpatda(rs.getString("nama"));
                simpatda.setJumlahPajakSimpatda(rs.getString("jumlah"));
                simpatda.setInstansi(rs.getString("sInstansi"));
                simpatda.setAlamat(rs.getString("alamat"));
                simpatda.setBulanSimpatda(rs.getString("bulan"));
                simpatda.setTahunSimpatda(rs.getString("tahun"));
                simpatda.setPokok(rs.getString("tagihan_pajak"));
                simpatda.setDenda(rs.getString("tagihan_denda"));
                simpatda.setTagihanAdmin(rs.getString("tagihan_admin"));

                simpatda.setWaktu(Formater.formatDate(rs.getDate("waktu"), "yyyy-MM-dd hh:mm:ss"));
                simpatda.setJenisUsaha(rs.getString("jenis_usaha"));
                simpatda.setJatuhTempo(Formater.formatDate(rs.getDate("jatuh_tempo"), "yyyy-MM-dd"));
                simpatda.setKeterangan("-");
                result.add(simpatda);
                DTaxManagerPhr.countQuery = DTaxManagerPhr.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListBphtbThread(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_BPHTB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                BphtbIprotax bphtbIprotax = new BphtbIprotax();
                if (!DTaxManagerBphtb.running) {
                    return new Vector();
                }
                bphtbIprotax.setNoId(rs.getString("NO_ID"));
                bphtbIprotax.setNama(rs.getString("NAMA"));
                bphtbIprotax.setJumTagihan(rs.getString("JUM_TAGIHAN"));
                bphtbIprotax.setsNoId(rs.getString("SNOID"));
                bphtbIprotax.setPpat(rs.getString("PPAT"));

                result.add(bphtbIprotax);
                DTaxManagerBphtb.countQuery = DTaxManagerBphtb.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListPBB(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));//14

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));//NJOPTKP_SPPT

                pbb.setDenda(rs.getString("DENDA"));
                pbb.setPokok(rs.getString("POKOK"));
                if (AppSetting.USERNAME_PBB.equals("PBB_BANGLI")) {
                    pbb.setNjkpSppt(rs.getDouble("NJKP_SPPT"));
                    pbb.setTarifSppt(rs.getDouble("TARIF_SPPT"));
                } else {
                    pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");
                }

                pbb.setTerbilang("");

                result.add(pbb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListPBBV2(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));//14

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));//NJOPTKP_SPPT

                double jumlahTagihan = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
                Date tglJatuhTempo = rs.getDate("TGL_JATUH_TEMPO_SPPT");
                Calendar startCalendar = Calendar.getInstance();
                Calendar endCalendar = Calendar.getInstance();
                startCalendar.setTime(tglJatuhTempo);
                int tunggakan = 0;
                int diffYear = 0;
                int diffMonth = 0;
                int typePembayaran = 0;

                String wherePembayaran = "NOP=" + pbb.getId() + " AND THN_PAJAK_SPPT=" + pbb.getTahun();
                Vector listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");
                double totalPembayaran = 0;
                double pembayaranPertama = 0;
                double pembayaranDenda = 0;
                java.util.Date tglDendaSeharusnya = null;
                java.util.Date tglDendaPembayaranPertama = null;
                if (listPembayaran.size() > 0) {
                    for (int i = 0; i < listPembayaran.size(); i++) {
                        PaymentPbb paymentPbb = (PaymentPbb) listPembayaran.get(i);
                        totalPembayaran += (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt());
                        pembayaranDenda += paymentPbb.getDendaSppt();
                        if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0) {
                            tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                        }
                        if (paymentPbb.getPembayaranSpptKe() == 1) {
                            tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                            pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                        }
                    }
                }

                if (tglDendaSeharusnya != null && totalPembayaran >= jumlahTagihan) {

                    endCalendar.setTime(tglDendaSeharusnya);

                    /*diffYear = tglDendaSeharusnya.getYear() - tglJatuhTempo.getYear();
					diffMonth = diffYear * 12 + tglDendaSeharusnya.getMonth() - tglJatuhTempo.getMonth();*/
                    diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                    diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                    if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                            && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                        diffMonth += 1;
                    }

                    if (diffMonth < 0 && totalPembayaran >= jumlahTagihan) {
                        tunggakan = 0;
                        typePembayaran = 2;
                    } else {

                        if (diffMonth < 0) {
                            String date = "2018-09-28";
                            typePembayaran = 1;
                            java.util.Date dtNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                            endCalendar.setTime(new java.util.Date());
                            /*diffYear = dtNow.getYear() - tglJatuhTempo.getYear();
							diffMonth = diffYear * 12 + dtNow.getMonth() - tglJatuhTempo.getMonth();*/

                            diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                            diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                            if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                                    && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                                diffMonth += 1;
                            }

                            if (diffMonth > 0) {
                                tunggakan = diffMonth;
                            }

                        } else {
                            tunggakan = diffMonth;
                            typePembayaran = 1;
                            if (tglDendaPembayaranPertama != null) {
                                endCalendar.setTime(tglDendaPembayaranPertama);

                                /*diffYear = tglDendaPembayaranPertama.getYear() - tglJatuhTempo.getYear();
								diffMonth = diffYear * 12 + tglDendaPembayaranPertama.getMonth() - tglJatuhTempo.getMonth();*/
                                diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                                diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                                if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                                        && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                                    diffMonth += 1;
                                }

                                if (jumlahTagihan - pembayaranPertama >= 0 && diffMonth > 0) {
                                    typePembayaran = 2;
                                }
                            }
                        }
                    }

                } else if (tglDendaPembayaranPertama != null && jumlahTagihan - pembayaranPertama <= 0) {
                    endCalendar.setTime(tglDendaPembayaranPertama);
                    typePembayaran = 2;
                    /*diffYear = tglDendaPembayaranPertama.getYear() - tglJatuhTempo.getYear();
					diffMonth = diffYear * 12 + tglDendaPembayaranPertama.getMonth() - tglJatuhTempo.getMonth();
					tunggakan = diffMonth;*/

                    diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                    diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                    if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                            && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                        diffMonth += 1;
                    }

                    tunggakan = diffMonth;
                } else {
                    String date = "2018-09-28";
                    typePembayaran = 3;
                    java.util.Date dtNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                    endCalendar.setTime(new java.util.Date());

                    diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                    diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                    if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                            && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                        diffMonth += 1;
                    }

                    if (diffMonth > 0) {
                        tunggakan = diffMonth;
                    }
                }

                double persentaseDenda = 0;
                if (tunggakan > 0) {
                    if (tunggakan > 24) {
                        persentaseDenda = 24.0 * (2.0 / 100.0);
                    } else {
                        persentaseDenda = tunggakan * (2.0 / 100.0);
                    }
                }
                double denda = 0;
                if (typePembayaran == 1) {
                    denda = Math.ceil(((jumlahTagihan - pembayaranPertama) * persentaseDenda) - pembayaranDenda);
                } else if (typePembayaran == 2) {
                    denda = Math.ceil((jumlahTagihan * persentaseDenda) - pembayaranDenda);
                } else if (typePembayaran == 3) {
                    denda = Math.ceil((jumlahTagihan - totalPembayaran) * persentaseDenda);
                }

                if (denda < 0) {
                    denda = 0;
                }
                //pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");
                pbb.setTerbilang("");

                //proses perhitungan jumlah tagihan dan denda
                double totPambayaran = 0; //Double.valueOf(pbb.getJumlahTagihan());//0;//SessPbbIprotax.PerhitunganPbbYangHarusDibayar(pbb.getId(), pbb.getTahun(), pbb.getJumlahTagihan());
                if ((jumlahTagihan - totalPembayaran) > 0) {
                    totPambayaran = (jumlahTagihan - totalPembayaran);
                }

                /*count denda adm sppt*/
                //double denda=Math.ceil(Double.valueOf(pbb.getDenda()));//SessPbbIprotax.PerhitunganDenda(pbb.getId(),  pbb.getTahun(), pbb.getTglJatuhTempo(), pbb.getJumlahTagihan(),totPambayaran);
                /*total yang harus dibayarkan*/
                double ygHarusDibayar = totPambayaran + denda;
                if (ygHarusDibayar <= 0) {
                    continue;
                }
                pbb.setJumlahTagihan(String.valueOf(ygHarusDibayar));
                try {
                    pbb.setPokok(String.valueOf(totPambayaran));
                } catch (Exception ex) {
                }
                try {
                    pbb.setDenda(String.valueOf(denda));
                } catch (Exception ex) {
                }

                //pbb.setDenda(rs.getString("DENDA"));
                //pbb.setPokok(rs.getString("POKOK"));
                pbb.setNjkpSppt(rs.getDouble("NJKP_SPPT"));
                pbb.setTarifSppt(rs.getDouble("TARIF_SPPT"));

                pbb.setTerbilang("");

                result.add(pbb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListPBBIprotax(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan
                pbb.setDluasBumi(luasBumiSppt);

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13
                pbb.setDluasBangunan(luasBgnSppt);

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));//14
                pbb.setDnJOPBumi(NjopBumi);

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));
                pbb.setDnJOPBangunan(NjopBgn);

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));//NJOPTKP_SPPT
                pbb.setDnJOPTKP(nJOPTKP);

                pbb.setDenda(rs.getString("DENDA"));
                pbb.setPokok(rs.getString("POKOK"));
                if (AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX || AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX_V2) {
                    pbb.setNjkpSppt(rs.getDouble("NJKP_SPPT"));
                    pbb.setTarifSppt(rs.getDouble("TARIF_SPPT"));
                } else {
                    pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");
                }

                pbb.setTerbilang("");

                result.add(pbb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListPBBIprotaxV2(String where) {

        double jumlahTagihan = 0;
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN_MURNI"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan
                pbb.setDluasBumi(luasBumiSppt);

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13
                pbb.setDluasBangunan(luasBgnSppt);

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));//14
                pbb.setDnJOPBumi(NjopBumi);

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));
                pbb.setDnJOPBangunan(NjopBgn);

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));//NJOPTKP_SPPT
                pbb.setDnJOPTKP(nJOPTKP);

                //pbb.setDenda(rs.getString("DENDA"));
                pbb.setPokok(rs.getString("POKOK"));
                if (AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX || AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX_V2) {
                    pbb.setNjkpSppt(rs.getDouble("NJKP_SPPT"));
                    pbb.setTarifSppt(rs.getDouble("TARIF_SPPT"));
                } else {
                    pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");
                }

                pbb.setTerbilang("");

                result.add(pbb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListPBBThread(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);

            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                if (!DTaxManagerPbb.running) {
                    return new Vector();
                }

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo
                pbb.setLuasBumi(rs.getString("LUAS_BUMI_SPPT"));//12//luas bangunan
                pbb.setLuasBangunan(rs.getString("LUAS_BNG_SPPT"));//13
                pbb.setnJOPBumi(rs.getString("NJOP_BUMI_SPPT"));//14
                pbb.setnJOPBangunan(rs.getString("NJOP_BNG_SPPT"));
                pbb.setnJOPTKP(rs.getString("NJOPTKP_SPPT"));//NJOPTKP_SPPT
                pbb.setDenda(rs.getString("DENDA"));
                pbb.setPokok(rs.getString("POKOK"));
                pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");

                pbb.setTerbilang("");

                result.add(pbb);

                DTaxManagerPbb.countQuery = DTaxManagerPbb.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListPBBThreadIProtax(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);

            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();

                if (!DTaxManagerPbb.running) {
                    return new Vector();
                }

                pbb.setId(rs.getString("NOP"));
                pbb.setNpwpd(rs.getString("NPWPD"));//3//sNoId
                pbb.setNama(rs.getString("NAMA"));//4//sNama
                pbb.setInstansi(rs.getString("INSTANSI"));
                pbb.setJumlahTagihan(rs.getString("JUMLAH_TAGIHAN"));//5 jum_tagihan
                pbb.setAlamat(rs.getString("ALAMAT_WP"));//sKet_2//Alamat
                pbb.setLetakObjectPajak(rs.getString("LETAK"));//Letak Objek Pajak
                pbb.setTahun(rs.getString("TAHUN"));//tahun//10
                pbb.setTglJatuhTempo(rs.getString("JATUH_TEMPO"));//11//jatuh tempo

//                pbb.setLuasBumi(rs.getString("LUAS_BUMI_SPPT"));//12//luas bangunan
//                pbb.setLuasBangunan(rs.getString("LUAS_BNG_SPPT"));//13
//                pbb.setnJOPBumi(rs.getString("NJOP_BUMI_SPPT"));//14
//                pbb.setnJOPBangunan(rs.getString("NJOP_BNG_SPPT"));
//                pbb.setnJOPTKP(rs.getString("NJOPTKP_SPPT"));//NJOPTKP_SPPT
                String sLuasBumiSppt = rs.getString("LUAS_BUMI_SPPT");
                double luasBumiSppt = Double.valueOf(sLuasBumiSppt);
                pbb.setLuasBumi(Formater.formatNumber(luasBumiSppt, "#,###,##0"));//12//luas bangunan

                String sLuasBgnSppt = rs.getString("LUAS_BNG_SPPT");
                double luasBgnSppt = Double.valueOf(sLuasBgnSppt);
                pbb.setLuasBangunan(Formater.formatNumber(luasBgnSppt, "#,###,##0"));//13

                String sNjopBumi = rs.getString("NJOP_BUMI_SPPT");
                double NjopBumi = Double.valueOf(sNjopBumi);
                pbb.setnJOPBumi(Formater.formatNumber(NjopBumi, "#,###,##0"));//14

                String sNjopBgn = rs.getString("NJOP_BNG_SPPT");
                double NjopBgn = Double.valueOf(sNjopBgn);
                pbb.setnJOPBangunan(Formater.formatNumber(NjopBgn, "#,###,##0"));

                String snJOPTKP = rs.getString("NJOPTKP_SPPT");
                double nJOPTKP = Double.valueOf(snJOPTKP);
                pbb.setnJOPTKP(Formater.formatNumber(nJOPTKP, "#,###,##0"));//NJOPTKP_SPPT

                pbb.setDenda(rs.getString("DENDA"));
                pbb.setPokok(rs.getString("POKOK"));
                pbb.setFormula("(NJOP Bumi + NJOP Bangunan - NJOPTKP) X 0,1 Persen + Denda");
                pbb.setTerbilang("");

                //proses perhitungan jumlah tagihan dan denda
                double totPambayaran = SessPbbIprotax.PerhitunganPbbYangHarusDibayar(pbb.getId(), pbb.getTahun(), pbb.getJumlahTagihan());
                /*count denda adm sppt*/
                double denda = SessPbbIprotax.PerhitunganDenda(pbb.getId(), pbb.getTahun(), pbb.getTglJatuhTempo(), pbb.getJumlahTagihan(), totPambayaran);
                /*total yang harus dibayarkan*/
                double ygHarusDibayar = totPambayaran + denda;
                try {
                    pbb.setJumlahTagihan(String.valueOf(ygHarusDibayar));
                } catch (Exception ex) {
                }
                try {
                    // pbb.setDenda(String.valueOf(denda));
                    pbb.setDenda(Formater.formatNumber(denda, "#,###,##0"));
                } catch (Exception ex) {
                }

                pbb.setFormula("(" + pbb.getnJOPBumi() + " + " + pbb.getnJOPBangunan() + " - " + pbb.getnJOPTKP() + ") X " + (pbb.getTarifSppt() * (pbb.getNjkpSppt() / 100)) + " % + " + pbb.getDenda());

                result.add(pbb);

                DTaxManagerPbb.countQuery = DTaxManagerPbb.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static int countPBB(String where) {
        int checkHistory = 0;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT COUNT(NAMA) FROM VIEW_PBB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getInt(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static void deleteExc(String whereClause) throws DBException {
        DBResultSet dbrs = null;
        int iResult = 0;
        try {
            String sql = "DELETE FROM " + PstLogHistoryTransaksi.TBL_LOGHISTORYTRANSAKSI;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            try {
                iResult = DBHandler.execUpdate(sql);
            } catch (DBException e) {
                e.printStackTrace();
            } finally {
                DBResultSet.close(dbrs);
            }

            //dbrs = DBHandler.execQueryResult(sql);
            //ResultSet rs = dbrs.getResultSet();
            //rs.close();
        } catch (Exception e) {
            System.out.println("Err: delete item " + e.toString());
        }
    }

    public static int countBPHTB(String where) {
        int checkHistory = 0;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT COUNT(NO_ID) FROM VIEW_BPHTB";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getInt(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static int countPHR(String where) {
        int checkHistory = 0;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT COUNT(ID) FROM VIEW_SIMPATDA";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getInt(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static int countPHROpenPHR(String where) {
        int checkHistory = 0;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT COUNT(sNoId) FROM view_simpatda";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getInt(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static int countPHRPHRH(String where) {
        int checkHistory = 0;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT COUNT(kode_id) FROM view_simpatda";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getInt(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static Vector getListBphtb(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_BPHTB";
            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Bphtb bphtb = new Bphtb();
                bphtb.setId(rs.getString("ID"));
                bphtb.setNama(rs.getString("NAMA"));
                bphtb.setJumlahTagihan(rs.getString("JUMLAH"));
                bphtb.setNop(rs.getString("NOP"));
                bphtb.setInstansi(rs.getString("INSTANSI"));
                bphtb.setPokok(rs.getString("POKOK"));
                bphtb.setDenda(rs.getString("DENDA"));
                bphtb.setLetakObjectPajak(rs.getString("ALAMAT"));
                result.add(bphtb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListBphtbIprotax(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_BPHTB";
            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                BphtbIprotax bphtbIprotax = new BphtbIprotax();
                bphtbIprotax.setNoId(rs.getString("NO_ID"));
                bphtbIprotax.setNama(rs.getString("NAMA"));
                bphtbIprotax.setJumTagihan(rs.getString("JUM_TAGIHAN"));
                bphtbIprotax.setsNoId(rs.getString("SNOID"));
                bphtbIprotax.setPpat(rs.getString("PPAT"));
                result.add(bphtbIprotax);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListAutoBphtb(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_BPHTB_COMPARE";

            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Bphtb bphtb = new Bphtb();
                bphtb.setId(rs.getString("ID"));
                bphtb.setNama(rs.getString("NAMA"));
                bphtb.setJumlahTagihan(rs.getString("JUMLAH"));
                bphtb.setNop(rs.getString("NOP"));
                bphtb.setInstansi(rs.getString("INSTANSI"));
                bphtb.setPokok(rs.getString("POKOK"));
                bphtb.setDenda(rs.getString("DENDA"));
                bphtb.setLetakObjectPajak(rs.getString("ALAMAT"));
                result.add(bphtb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static Vector getListRetribusi(String where) {
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM VIEW_RETRIBUSI";
            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                Retribusi retribusi = new Retribusi();
                retribusi.setNoRekening(rs.getString("ID"));
                retribusi.setNama(rs.getString("NAMA"));
                retribusi.setJumlahTagihan(rs.getString("JUMLAH"));
                retribusi.setTanggalPenerimaan(rs.getString("TGL_RETRIBUSI"));
                retribusi.setInstansi(rs.getString("INSTANSI"));
                retribusi.setTahun(rs.getString("TAHUN"));
                retribusi.setBulan(rs.getString("BULAN"));
                retribusi.setTanggal(rs.getString("TANGGAL"));
                retribusi.setPokok(rs.getString("POKOK"));
                retribusi.setDenda(rs.getString("DENDA"));
                retribusi.setIdKey(rs.getString("ID_KEY"));

                result.add(retribusi);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

    public static boolean check(String npwd, String tahun, String tagihan, String bulan, String instansi) {
        boolean checkHistory = false;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstLogHistoryTransaksi.TBL_LOGHISTORYTRANSAKSI
                    + " WHERE "
                    + "" + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_ID] + "='" + npwd + "'"
                    + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_INSTANSI] + "='" + instansi + "'"
                    + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_JUMLAHPAJAK] + "!=" + tagihan;

            if (tahun.equals("")) {
                sql = sql + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_TAHUN] + "='" + tahun + "'";
            }

            if (bulan.equals("")) {
                sql = sql + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_BULAN] + "='" + bulan + "'";
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = true;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkHistoryRetribusi(String npwd, String tahun, String bulan, String tanggal) {
        boolean checkHistory = false;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstLogHistoryTransaksi.TBL_LOGHISTORYTRANSAKSI
                    + " WHERE "
                    + "" + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_ID] + "='" + npwd + "'"
                    + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_TANGGAL] + "='" + tanggal + "'";

            if (tahun.equals("")) {
                sql = sql + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_TAHUN] + "='" + tahun + "'";
            }

            if (bulan.equals("")) {
                sql = sql + " AND " + PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_BULAN] + "='" + bulan + "'";
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = true;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentPhr(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentPhr.TBL_PAYMENTPHR
                    + " WHERE "
                    + PstPaymentPhr.fieldNames[PstPaymentPhr.FLD_IDPAYMENT] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentPhrOpenPhr(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentPhrforOpenPhr.TBL_PAYMENTPHRFOROPENPHR
                    + " WHERE "
                    + PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_IDBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public synchronized static boolean checkPaymentPhrForPhrH(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentPhrforPhrH.TBL_PAYMENTPHRFORPHRH
                    + " WHERE "
                    + PstPaymentPhrforOpenPhr.fieldNames[PstPaymentPhrforOpenPhr.FLD_IDBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String checkKeyId(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "AAAaO4AAFAACmClAAJ";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT ID_KEY FROM VIEW_SIMPATDA"
                    + " WHERE ID='" + Npwpd + "' AND MASA_PAJAK='" + masaPajak + "' AND TAHUN_PAJAK='" + tahun + "' AND JUMLAH='" + tagihan + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getString(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String checkKeyIdBphtb(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "1";
        try {

            sql = "SELECT ID_KEY FROM VIEW_BPHTB"
                    + " WHERE ID='" + Npwpd + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getString(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String checkKeyIdPbb(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "1";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT ID_KEY FROM VIEW_PBB"
                    + " WHERE NOP='" + Npwpd + "' AND TAHUN='" + tahun + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getString(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String checkKeyIdRetribusi(String Npwpd, String tahun, String bulan, String tanggal) {
        String checkHistory = "AAAaO4AAFAACmClAAJ";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT ID_KEY FROM LOG_HISTORY_TRANSAKSI"
                    + " WHERE ID='" + Npwpd + "' AND TAHUN='" + tahun + "' AND BULAN='" + bulan + "' AND TANGGAL='" + tanggal + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = rs.getString(1);
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String updateStatusRaversal(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = " UPDATE PEMBAYARAN_SIMPATDA_BANK SET STATUS_REVERSAL='1'"
                    + " WHERE NPWPD='" + Npwpd + "' AND MASA_PAJAK='" + masaPajak + "' AND TAHUN_PAJAK='" + tahun + "' AND JUMLAH='" + tagihan + "'";
            try {
                DBHandler.execUpdate(sql);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return checkHistory;
    }

    public static String updateStatusRaversalPhrAll(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {
            sql = " UPDATE PEMBAYARAN_SIMPATDA_BANK_ALL SET STATUS_REVERSAL='1'"
                    + " WHERE NPWPD='" + Npwpd + "' AND MASA_PAJAK='" + masaPajak + "' AND TAHUN_PAJAK='" + tahun + "' AND JUMLAH='" + tagihan + "'";
            try {
                DBHandler.execUpdate(sql);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return checkHistory;
    }

    public static String updateStatusRaversalOpenPhr(String noId) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = " UPDATE integrasi_pembayaran_phr_bank SET STS_REVERSAL='1'"
                    + " WHERE NO_ID='" + noId + "'";

            try {

                DBHandler.execUpdate(sql);

            } catch (Exception e) {

                //oidNew = 0;
            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String updateStatusRaversalPhrH(String noId) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = " UPDATE integrasi_pembayaran_phr_bank SET STS_REVERSAL='1'"
                    + " WHERE NO_ID='" + noId + "'";

            try {

                DBHandler.execUpdate(sql);

            } catch (Exception e) {

                //oidNew = 0;
            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String updateStatusRaversalBphtb(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = " UPDATE PEMBAYARAN_BPHTB_BANK SET STATUS='1'"
                    + " WHERE NO_TIB='" + Npwpd + "'";

            try {

                DBHandler.execUpdate(sql);

            } catch (Exception e) {

            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String updateStatusRaversalPbb(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = " UPDATE PEMBAYARAN_SPPT_BANK SET STATUS='1'"
                    + " WHERE NOP='" + Npwpd + "' AND THN_PAJAK_SPPT='" + tahun + "'";

            try {

                DBHandler.execUpdate(sql);

            } catch (Exception e) {

            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static String updateStatusRaversalRetribusi(String Npwpd, String tahun, String masaPajak, double tagihan) {
        String checkHistory = "";
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = " UPDATE PEMBAYARAN_RETRIBUSI_BANK SET STATUS_REVERSAL='1'"
                    + " WHERE NPWRD='" + Npwpd + "' AND TGL_SSPD='" + tahun + "' AND JUMLAH='" + tagihan + "'";

            try {

                DBHandler.execUpdate(sql);

            } catch (Exception e) {

            }
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentPBB(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentPbb.TBL_PAYMENTPBB
                    + " WHERE "
                    + PstPaymentPbb.fieldNames[PstPaymentPbb.FLD_ID_PAYMENT_BANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentBphtb(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentBphtbIprotax.TBL_PAYMENTBPHTBIPROTAX
                    + " WHERE "
                    + PstPaymentBphtbIprotax.fieldNames[PstPaymentBphtbIprotax.FLD_NOTRANSAKSIBYRBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentBphtbReversal(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM IPROTAXBPHTB.PEMBAYARAN_BPHTB_REVERSAL"
                    + " WHERE "
                    + PstPaymentBphtbIprotax.fieldNames[PstPaymentBphtbIprotax.FLD_NOTRANSAKSIBYRBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentBphtbIprotax(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentBphtb.TBL_PAYMENTBPHTB_IPROTAX
                    + " WHERE "
                    + PstPaymentBphtb.fieldNames[PstPaymentBphtb.FLD_ID_PAYMENT_BANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean checkPaymentRetribusi(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentRetribusi.TBL_PAYMENTRETRIBUSI
                    + " WHERE "
                    + PstPaymentRetribusi.fieldNames[PstPaymentRetribusi.FLD_IDPAYMENTBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }

    public static boolean insertPaymentPbbRaversalIprotax(PaymentBphtbIprotax paymentBphtbIprotax) {
        boolean checkHistory = true;
        String sql = "";
        try {
            PaymentBphtbRaversalIprotax entPaymentBphtbRaversalIprotax = new PaymentBphtbRaversalIprotax();

            int countMax = PstPaymentBphtbRaversalIprotax.getLastId();

            entPaymentBphtbRaversalIprotax.setIdReversal(countMax);
            entPaymentBphtbRaversalIprotax.setKdProvinsi(paymentBphtbIprotax.getKdProvinsi());
            entPaymentBphtbRaversalIprotax.setKdDati2(paymentBphtbIprotax.getKdDati2());
            entPaymentBphtbRaversalIprotax.setThbBphtb(paymentBphtbIprotax.getThbBphtb());
            entPaymentBphtbRaversalIprotax.setBlnBphtb(paymentBphtbIprotax.getBlnBphtb());
            entPaymentBphtbRaversalIprotax.setTglBphtb(paymentBphtbIprotax.getTglBphtb());
            entPaymentBphtbRaversalIprotax.setNoUrutBphtb(paymentBphtbIprotax.getNoUrutBphtb());
            entPaymentBphtbRaversalIprotax.setIndeksBphtb(paymentBphtbIprotax.getIndeksBphtb());
            entPaymentBphtbRaversalIprotax.setNoTransaksiBayar(paymentBphtbIprotax.getNoTransBayar());

            entPaymentBphtbRaversalIprotax.setKdPejabat(paymentBphtbIprotax.getKdPejabat());
            entPaymentBphtbRaversalIprotax.setKdBankTunggal(paymentBphtbIprotax.getKdBankTunggal());
            entPaymentBphtbRaversalIprotax.setKdBankPersepsi(paymentBphtbIprotax.getKdBankPersepsi());
            entPaymentBphtbRaversalIprotax.setKdTp(paymentBphtbIprotax.getKdTp());
            entPaymentBphtbRaversalIprotax.setTglPembayaran(paymentBphtbIprotax.getTglPembayaranReal());
            entPaymentBphtbRaversalIprotax.setNamaWP(paymentBphtbIprotax.getNamaWP());
            entPaymentBphtbRaversalIprotax.setNmPenyetor(paymentBphtbIprotax.getNmPenyetor());
            entPaymentBphtbRaversalIprotax.setBphtbKurangBayar(paymentBphtbIprotax.getBphtbKurangBayar());
            entPaymentBphtbRaversalIprotax.setBphtbSdhBayar(paymentBphtbIprotax.getBphtbSdhBayar());
            entPaymentBphtbRaversalIprotax.setKdKecamatanOp(paymentBphtbIprotax.getKdKecamatanOp());
            entPaymentBphtbRaversalIprotax.setKdKelurahanOp(paymentBphtbIprotax.getKdKelurahanOp());
            entPaymentBphtbRaversalIprotax.setKdBlokOp(paymentBphtbIprotax.getKdBlokOp());
            entPaymentBphtbRaversalIprotax.setNoUrutOp(paymentBphtbIprotax.getNoUrutOp());
            entPaymentBphtbRaversalIprotax.setKdJnsOp(paymentBphtbIprotax.getKdJnsOp());
            entPaymentBphtbRaversalIprotax.setKetReversalByr("Payment Cancellation by Interkoneksi");
            entPaymentBphtbRaversalIprotax.setTglReversalByr(paymentBphtbIprotax.getTglPembayaran());
            entPaymentBphtbRaversalIprotax.setUserBankRekam(paymentBphtbIprotax.getUserBankRekam());
            entPaymentBphtbRaversalIprotax.setUserBankReversal("Interkoneksi");
            entPaymentBphtbRaversalIprotax.setKdSumberData(paymentBphtbIprotax.getKdSumberData());
            entPaymentBphtbRaversalIprotax.setNoTransBayarBank(paymentBphtbIprotax.getNoTransaksiBayarBank());

            long oid = PstPaymentBphtbRaversalIprotax.insertExc(entPaymentBphtbRaversalIprotax);

        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
        }

        return checkHistory;
    }

    public static int DeleteDataPembayaranBPHTB(String idPaymentBank) {

        int iResult = 0;
        DBResultSet dbrs = null;
        String stSql = " DELETE FROM IPROTAXBPHTB.PEMBAYARAN_BPHTB WHERE "
                + "NO_TRANSAKSI_BYR_BANK='" + idPaymentBank + "'";
        try {
            iResult = DBHandler.execUpdate(stSql);
        } catch (DBException e) {
            e.printStackTrace();
        } finally {
            DBResultSet.close(dbrs);
        }
        return iResult;
    }

    public static Vector getListPBBALL(String where, java.util.Date tglBayar) {

        Diskon diskon = new Diskon();
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_PBB_ALL ";

            if (!where.equals("")) {
                sql = sql + where;
            }

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {

                Pbb pbb = new Pbb();
                pbb.setId(rs.getString("NOP"));
                pbb.setTahun(rs.getString("TAHUN"));

                //get denda
                double jumlahTagihan = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
                Date tglJatuhTempo = rs.getDate("TGL_JATUH_TEMPO_SPPT");
                Calendar startCalendar = Calendar.getInstance();
                Calendar endCalendar = Calendar.getInstance();
                endCalendar.setTime(tglBayar);

                String strJatuhTempoNew = diskon.jatuhTempo;//untuk menghitung denda
                String strJatuhTempoNew21 = diskon.jatuhTempo21;//untuk menghitung denda
                String strJatuhTempoNew22 = diskon.jatuhTempo22;//untuk menghitung denda

                java.util.Date dtJatuhTempo = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew);
                java.util.Date dtJatuhTempo21 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew21);
                java.util.Date dtJatuhTempo22 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew22);

                int tahun = 0;
                try {
                    tahun = Integer.valueOf(pbb.getTahun());
                    if (tahun > 2018 && tahun < 2021) {
                        startCalendar.setTime(dtJatuhTempo);
                    } else if (tahun == 2021) {
                        startCalendar.setTime(dtJatuhTempo21);
                    } else if (tahun == 2022) {
                        startCalendar.setTime(dtJatuhTempo22);
                    } else {
                        startCalendar.setTime(tglJatuhTempo);
                    }
                } catch (Exception exc) {
                    startCalendar.setTime(tglJatuhTempo);
                }

                int tunggakan = 0;
                int diffYear = 0;
                int diffMonth = 0;
                int typePembayaran = 0;

                String wherePembayaran = "NOP=" + pbb.getId() + " AND THN_PAJAK_SPPT=" + pbb.getTahun();
                Vector listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");

                double totalPembayaran = 0;
                double pembayaranPertama = 0;
                double pembayaranDenda = 0;
                java.util.Date tglDendaSeharusnya = null;
                java.util.Date tglDendaPembayaranPertama = null;
                if (listPembayaran.size() > 0) {
                    for (int i = 0; i < listPembayaran.size(); i++) {
                        PaymentPbb paymentPbb = (PaymentPbb) listPembayaran.get(i);
                        totalPembayaran += (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt());
                        pembayaranDenda += paymentPbb.getDendaSppt();
                        if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0) {
                            tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                        }
                        if (paymentPbb.getPembayaranSpptKe() == 1) {
                            tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                            pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                        }
                    }
                }

                if (tglDendaSeharusnya != null && totalPembayaran >= jumlahTagihan) {
                    endCalendar.setTime(tglDendaSeharusnya);
                    diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                    diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
                    if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                            && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                        diffMonth += 1;
                    }

                    if (diffMonth < 0 && totalPembayaran >= jumlahTagihan) {
                        tunggakan = 0;
                        typePembayaran = 2;
                    } else {
                        if (diffMonth < 0) {
                            String date = "2018-09-28";
                            typePembayaran = 1;
                            java.util.Date dtNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                            endCalendar.setTime(new java.util.Date());
                            diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                            diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                            if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                                    && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                                diffMonth += 1;
                            }

                            if (diffMonth > 0) {
                                tunggakan = diffMonth;
                            }

                        } else {
                            tunggakan = diffMonth;
                            typePembayaran = 1;
                            if (tglDendaPembayaranPertama != null) {
                                endCalendar.setTime(tglDendaPembayaranPertama);
                                diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                                diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                                if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                                        && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                                    diffMonth += 1;
                                }

                                if (jumlahTagihan - pembayaranPertama >= 0 && diffMonth > 0) {
                                    typePembayaran = 2;
                                }
                            }
                        }
                    }
                } else if (tglDendaPembayaranPertama != null && jumlahTagihan - pembayaranPertama <= 0) {
                    endCalendar.setTime(tglDendaPembayaranPertama);
                    typePembayaran = 2;
                    diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                    diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                    if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                            && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                        diffMonth += 1;
                    }

                    tunggakan = diffMonth;
                } else {
                    String date = "2018-09-28";
                    typePembayaran = 3;
                    java.util.Date dtNow = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                    endCalendar.setTime(new java.util.Date());

                    diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
                    diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

                    if (endCalendar.get(Calendar.DAY_OF_MONTH) > startCalendar.get(Calendar.DAY_OF_MONTH) && endCalendar.get(Calendar.DAY_OF_MONTH) != 31
                            && endCalendar.get(Calendar.DAY_OF_MONTH) != 30 && startCalendar.get(Calendar.DAY_OF_MONTH) != 31 && startCalendar.get(Calendar.DAY_OF_MONTH) != 30) {
                        diffMonth += 1;
                    }

                    if (diffMonth > 0) {
                        tunggakan = diffMonth;
                    }
                }

                double persentaseDenda = 0;
                if (tunggakan > 0) {
                    if (tunggakan > 24) {
                        persentaseDenda = 24.0 * (2.0 / 100.0);
                    } else {
                        persentaseDenda = tunggakan * (2.0 / 100.0);
                    }
                }

                persentaseDenda = diskon.perdentaseDenda(endCalendar, tahun, tglJatuhTempo);
                double denda = 0;
                double countDenda = (jumlahTagihan - totalPembayaran) * persentaseDenda;
                try {
                    NumberFormat formatter = new DecimalFormat("#0.00");
                    String condenda = formatter.format(countDenda);
                    countDenda = Double.valueOf(condenda);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                denda = Math.ceil(countDenda);
                pbb.setTahun(rs.getString("TAHUN"));
                pbb.setJumlahTagihan("" + jumlahTagihan);
                pbb.setDenda("" + denda);
                result.add(pbb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }

}
