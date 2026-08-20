/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.dtaxintegrationsisda.entity.piutang;

import com.dimata.qdep.entity.Entity;
import java.util.Date;

/**
 *
 * @author Diana
 */
public class TaKartuPajakPungut extends Entity{
    private int tahun =0;
    private String noSpt ="";
    private Date tglSpt = new Date();
    private String noPokokWp ="";
    private int jnWajibPajak =0;
    private int jnUsahaWp =0;
    private int kdUsaha =0;
    private int jnPajak =0;
    private int jnPemungutan =0;
    private int jnPenetapan =0;
    private Date masa1 = new Date();
    private Date masa2 = new Date();
    private int kdUrusan =0;
    private int kdBidang =0;
    private int kdUnit =0;
    private int kdSub =0;
    private String nmPenerima ="";
    private String nipPenerima ="";
    private String jbtPenerima ="";
    private Date tglTerima = new Date();
    private String keterangan ="";
    private int kdNilai=0;
    

    /**
     * @return the tahun
     */
    public int getTahun() {
        return tahun;
    }

    /**
     * @param tahun the tahun to set
     */
    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    /**
     * @return the noSpt
     */
    public String getNoSpt() {
        return noSpt;
    }

    /**
     * @param noSpt the noSpt to set
     */
    public void setNoSpt(String noSpt) {
        this.noSpt = noSpt;
    }

    /**
     * @return the tglSpt
     */
    public Date getTglSpt() {
        return tglSpt;
    }

    /**
     * @param tglSpt the tglSpt to set
     */
    public void setTglSpt(Date tglSpt) {
        this.tglSpt = tglSpt;
    }

    /**
     * @return the noPokokWp
     */
    public String getNoPokokWp() {
        return noPokokWp;
    }

    /**
     * @param noPokokWp the noPokokWp to set
     */
    public void setNoPokokWp(String noPokokWp) {
        this.noPokokWp = noPokokWp;
    }

    /**
     * @return the jnWajibPajak
     */
    public int getJnWajibPajak() {
        return jnWajibPajak;
    }

    /**
     * @param jnWajibPajak the jnWajibPajak to set
     */
    public void setJnWajibPajak(int jnWajibPajak) {
        this.jnWajibPajak = jnWajibPajak;
    }

    /**
     * @return the jnUsahaWp
     */
    public int getJnUsahaWp() {
        return jnUsahaWp;
    }

    /**
     * @param jnUsahaWp the jnUsahaWp to set
     */
    public void setJnUsahaWp(int jnUsahaWp) {
        this.jnUsahaWp = jnUsahaWp;
    }

    /**
     * @return the kdUsaha
     */
    public int getKdUsaha() {
        return kdUsaha;
    }

    /**
     * @param kdUsaha the kdUsaha to set
     */
    public void setKdUsaha(int kdUsaha) {
        this.kdUsaha = kdUsaha;
    }

    /**
     * @return the jnPajak
     */
    public int getJnPajak() {
        return jnPajak;
    }

    /**
     * @param jnPajak the jnPajak to set
     */
    public void setJnPajak(int jnPajak) {
        this.jnPajak = jnPajak;
    }

    /**
     * @return the jnPemungutan
     */
    public int getJnPemungutan() {
        return jnPemungutan;
    }

    /**
     * @param jnPemungutan the jnPemungutan to set
     */
    public void setJnPemungutan(int jnPemungutan) {
        this.jnPemungutan = jnPemungutan;
    }

    /**
     * @return the jnPenetapan
     */
    public int getJnPenetapan() {
        return jnPenetapan;
    }

    /**
     * @param jnPenetapan the jnPenetapan to set
     */
    public void setJnPenetapan(int jnPenetapan) {
        this.jnPenetapan = jnPenetapan;
    }

    /**
     * @return the masa1
     */
    public Date getMasa1() {
        return masa1;
    }

    /**
     * @param masa1 the masa1 to set
     */
    public void setMasa1(Date masa1) {
        this.masa1 = masa1;
    }

    /**
     * @return the masa2
     */
    public Date getMasa2() {
        return masa2;
    }

    /**
     * @param masa2 the masa2 to set
     */
    public void setMasa2(Date masa2) {
        this.masa2 = masa2;
    }

    /**
     * @return the kdUrusan
     */
    public int getKdUrusan() {
        return kdUrusan;
    }

    /**
     * @param kdUrusan the kdUrusan to set
     */
    public void setKdUrusan(int kdUrusan) {
        this.kdUrusan = kdUrusan;
    }

    /**
     * @return the kdBidang
     */
    public int getKdBidang() {
        return kdBidang;
    }

    /**
     * @param kdBidang the kdBidang to set
     */
    public void setKdBidang(int kdBidang) {
        this.kdBidang = kdBidang;
    }

    /**
     * @return the kdUnit
     */
    public int getKdUnit() {
        return kdUnit;
    }

    /**
     * @param kdUnit the kdUnit to set
     */
    public void setKdUnit(int kdUnit) {
        this.kdUnit = kdUnit;
    }

    /**
     * @return the kdSub
     */
    public int getKdSub() {
        return kdSub;
    }

    /**
     * @param kdSub the kdSub to set
     */
    public void setKdSub(int kdSub) {
        this.kdSub = kdSub;
    }

    /**
     * @return the nmPenerima
     */
    public String getNmPenerima() {
        return nmPenerima;
    }

    /**
     * @param nmPenerima the nmPenerima to set
     */
    public void setNmPenerima(String nmPenerima) {
        this.nmPenerima = nmPenerima;
    }

    /**
     * @return the nipPenerima
     */
    public String getNipPenerima() {
        return nipPenerima;
    }

    /**
     * @param nipPenerima the nipPenerima to set
     */
    public void setNipPenerima(String nipPenerima) {
        this.nipPenerima = nipPenerima;
    }

    /**
     * @return the tglTerima
     */
    public Date getTglTerima() {
        return tglTerima;
    }

    /**
     * @param tglTerima the tglTerima to set
     */
    public void setTglTerima(Date tglTerima) {
        this.tglTerima = tglTerima;
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
     * @return the kdNilai
     */
    public int getKdNilai() {
        return kdNilai;
    }

    /**
     * @param kdNilai the kdNilai to set
     */
    public void setKdNilai(int kdNilai) {
        this.kdNilai = kdNilai;
    }

    /**
     * @return the jbtPenerima
     */
    public String getJbtPenerima() {
        return jbtPenerima;
    }

    /**
     * @param jbtPenerima the jbtPenerima to set
     */
    public void setJbtPenerima(String jbtPenerima) {
        this.jbtPenerima = jbtPenerima;
    }
}
