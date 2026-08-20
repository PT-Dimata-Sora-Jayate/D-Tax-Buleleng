/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.payment;

/**
 *
 * @author dimata005
 */
import com.dimata.qdep.entity.Entity;
import java.util.Date;

public class PaymentRetribusi extends Entity {

    private long idPaymentBank = 0;
    private String nama = "";
    private String noRekening = "";
    private Date tanggalTagihan = new Date();
    private double jumlahTagihan = 0;
    private int statusReversal = 0;
    private Date tanggalPembayaran = new Date();
    private String idKey="";
    private String idRekam="";
    private String tahun="";
    private String masaPajak="";
    private double pokok=0;
    private double denda=0;
    
    public long getIdPaymentBank() {
        return idPaymentBank;
    }

    public void setIdPaymentBank(long idPaymentBank) {
        this.idPaymentBank = idPaymentBank;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public Date getTanggalTagihan() {
        return tanggalTagihan;
    }

    public void setTanggalTagihan(Date tanggalTagihan) {
        this.tanggalTagihan = tanggalTagihan;
    }

    public double getJumlahTagihan() {
        return jumlahTagihan;
    }

    public void setJumlahTagihan(double jumlahTagihan) {
        this.jumlahTagihan = jumlahTagihan;
    }

    public int getStatusReversal() {
        return statusReversal;
    }

    public void setStatusReversal(int statusReversal) {
        this.statusReversal = statusReversal;
    }

    public Date getTanggalPembayaran() {
        return tanggalPembayaran;
    }

    public void setTanggalPembayaran(Date tanggalPembayaran) {
        this.tanggalPembayaran = tanggalPembayaran;
    }

    /**
     * @return the idKey
     */
    public String getIdKey() {
        return idKey;
    }

    /**
     * @param idKey the idKey to set
     */
    public void setIdKey(String idKey) {
        this.idKey = idKey;
    }

    /**
     * @return the idRekam
     */
    public String getIdRekam() {
        return idRekam;
    }

    /**
     * @param idRekam the idRekam to set
     */
    public void setIdRekam(String idRekam) {
        this.idRekam = idRekam;
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
     * @return the masaPajak
     */
    public String getMasaPajak() {
        return masaPajak;
    }

    /**
     * @param masaPajak the masaPajak to set
     */
    public void setMasaPajak(String masaPajak) {
        this.masaPajak = masaPajak;
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
}