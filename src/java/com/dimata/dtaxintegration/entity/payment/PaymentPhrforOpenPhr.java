/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.payment;

import com.dimata.qdep.entity.Entity;
import java.util.Date;

/**
 *
 * @author dimata005
 */
public class PaymentPhrforOpenPhr extends Entity{
    private String idBank = "";
    private String instansi = "";
    private String noId = "";
    private String nama = "";
    private double tagihan = 0;
    private String ketTagihan = "";
    private double tagihanLain = 0;
    private double biayaAdm = 0;
    private String alamat = "";
    private String bulan = "";
    private String tahun = "";
    private double pokok=0;
    private double denda=0;
    private String keterangan = "";
    private String npwpd = "";
    private Date tanggalAwal = new Date();
    private Date tanggalAkhir = new Date();
    private double valEntry=0;
    private Date tglTransaksi= new Date();
    private int statusBayar = 0;
    private String kdCab="";
    private String kdUser="";
    private int statusReversal = 0;

    /**
     * @return the idBank
     */
    public String getIdBank() {
        return idBank;
    }

    /**
     * @param idBank the idBank to set
     */
    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }

    /**
     * @return the instansi
     */
    public String getInstansi() {
        return instansi;
    }

    /**
     * @param instansi the instansi to set
     */
    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    /**
     * @return the noId
     */
    public String getNoId() {
        return noId;
    }

    /**
     * @param noId the noId to set
     */
    public void setNoId(String noId) {
        this.noId = noId;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the tagihan
     */
    public double getTagihan() {
        return tagihan;
    }

    /**
     * @param tagihan the tagihan to set
     */
    public void setTagihan(double tagihan) {
        this.tagihan = tagihan;
    }

    /**
     * @return the ketTagihan
     */
    public String getKetTagihan() {
        return ketTagihan;
    }

    /**
     * @param ketTagihan the ketTagihan to set
     */
    public void setKetTagihan(String ketTagihan) {
        this.ketTagihan = ketTagihan;
    }

    /**
     * @return the tagihanLain
     */
    public double getTagihanLain() {
        return tagihanLain;
    }

    /**
     * @param tagihanLain the tagihanLain to set
     */
    public void setTagihanLain(double tagihanLain) {
        this.tagihanLain = tagihanLain;
    }

    /**
     * @return the biayaAdm
     */
    public double getBiayaAdm() {
        return biayaAdm;
    }

    /**
     * @param biayaAdm the biayaAdm to set
     */
    public void setBiayaAdm(double biayaAdm) {
        this.biayaAdm = biayaAdm;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the bulan
     */
    public String getBulan() {
        return bulan;
    }

    /**
     * @param bulan the bulan to set
     */
    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    /**
     * @return the tahun
     */
    public String getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    /**
     * @return the pokok
     */
    public double getPokok() {
        return pokok;
    }

    /**
     * @param pokok the pokok to set
     */
    public void setPokok(double pokok) {
        this.pokok = pokok;
    }

    /**
     * @return the denda
     */
    public double getDenda() {
        return denda;
    }

    /**
     * @param denda the denda to set
     */
    public void setDenda(double denda) {
        this.denda = denda;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the npwpd
     */
    public String getNpwpd() {
        return npwpd;
    }

    /**
     * @param npwpd the npwpd to set
     */
    public void setNpwpd(String npwpd) {
        this.npwpd = npwpd;
    }

    /**
     * @return the tanggalAwal
     */
    public Date getTanggalAwal() {
        return tanggalAwal;
    }

    /**
     * @param tanggalAwal the tanggalAwal to set
     */
    public void setTanggalAwal(Date tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
    }

    /**
     * @return the tanggalAkhir
     */
    public Date getTanggalAkhir() {
        return tanggalAkhir;
    }

    /**
     * @param tanggalAkhir the tanggalAkhir to set
     */
    public void setTanggalAkhir(Date tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    /**
     * @return the valEntry
     */
    public double getValEntry() {
        return valEntry;
    }

    /**
     * @param valEntry the valEntry to set
     */
    public void setValEntry(double valEntry) {
        this.valEntry = valEntry;
    }

    /**
     * @return the tglTransaksi
     */
    public Date getTglTransaksi() {
        return tglTransaksi;
    }

    /**
     * @param tglTransaksi the tglTransaksi to set
     */
    public void setTglTransaksi(Date tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    /**
     * @return the statusBayar
     */
    public int getStatusBayar() {
        return statusBayar;
    }

    /**
     * @param statusBayar the statusBayar to set
     */
    public void setStatusBayar(int statusBayar) {
        this.statusBayar = statusBayar;
    }

    /**
     * @return the kdCab
     */
    public String getKdCab() {
        return kdCab;
    }

    /**
     * @param kdCab the kdCab to set
     */
    public void setKdCab(String kdCab) {
        this.kdCab = kdCab;
    }

    /**
     * @return the kdUser
     */
    public String getKdUser() {
        return kdUser;
    }

    /**
     * @param kdUser the kdUser to set
     */
    public void setKdUser(String kdUser) {
        this.kdUser = kdUser;
    }

    /**
     * @return the statusReversal
     */
    public int getStatusReversal() {
        return statusReversal;
    }

    /**
     * @param statusReversal the statusReversal to set
     */
    public void setStatusReversal(int statusReversal) {
        this.statusReversal = statusReversal;
    }
    
    
}
