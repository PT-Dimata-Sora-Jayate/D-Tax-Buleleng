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
 * @author AYUKI
 */
public class ViewSptpdSimda extends Entity {
    private String noSptpd = "";
    private String noSspd = "";
    private String npwdp = "";
    private String masaPajak = "";
    private String tahunPajak = "";
    private String kodePajak = "";
    private String noRekening = "";
    private String noSubrekening = "";
    private double tarif = 0;
    private double omzet = 0;
    private double pajak = 0;
    private double serviceTax = 0;
    private double denda = 0;
    private double pengurangan = 0;
    private double harusDibayar = 0;
    private Date tglRekam = new Date();
    private String typePajak="";
    /**
     * @return the noSptspd
     */
    public String getNoSptpd() {
        return noSptpd;
    }

    /**
     * @param noSptpd the noSptspd to set
     */
    public void setNoSptpd(String noSptpd) {
        this.noSptpd = noSptpd;
    }

    /**
     * @return the noSspd
     */
    public String getNoSspd() {
        return noSspd;
    }

    /**
     * @param noSspd the noSspd to set
     */
    public void setNoSspd(String noSspd) {
        this.noSspd = noSspd;
    }

    /**
     * @return the npwdp
     */
    public String getNpwdp() {
        return npwdp;
    }

    /**
     * @param npwdp the npwdp to set
     */
    public void setNpwdp(String npwdp) {
        this.npwdp = npwdp;
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
     * @return the tahunPajak
     */
    public String getTahunPajak() {
        return tahunPajak;
    }

    /**
     * @param tahunPajak the tahunPajak to set
     */
    public void setTahunPajak(String tahunPajak) {
        this.tahunPajak = tahunPajak;
    }

    /**
     * @return the kodePajak
     */
    public String getKodePajak() {
        return kodePajak;
    }

    /**
     * @param kodePajak the kodePajak to set
     */
    public void setKodePajak(String kodePajak) {
        this.kodePajak = kodePajak;
    }

    /**
     * @return the noRekening
     */
    public String getNoRekening() {
        return noRekening;
    }

    /**
     * @param noRekening the noRekening to set
     */
    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    /**
     * @return the noSubrekening
     */
    public String getNoSubrekening() {
        return noSubrekening;
    }

    /**
     * @param noSubrekening the noSubrekening to set
     */
    public void setNoSubrekening(String noSubrekening) {
        this.noSubrekening = noSubrekening;
    }

    /**
     * @return the tarif
     */
    public double getTarif() {
        return tarif;
    }

    /**
     * @param tarif the tarif to set
     */
    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    /**
     * @return the omzet
     */
    public double getOmzet() {
        return omzet;
    }

    /**
     * @param omzet the omzet to set
     */
    public void setOmzet(double omzet) {
        this.omzet = omzet;
    }

    /**
     * @return the pajak
     */
    public double getPajak() {
        return pajak;
    }

    /**
     * @param pajak the pajak to set
     */
    public void setPajak(double pajak) {
        this.pajak = pajak;
    }

    /**
     * @return the serviceTax
     */
    public double getServiceTax() {
        return serviceTax;
    }

    /**
     * @param serviceTax the serviceTax to set
     */
    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
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
     * @return the pengurangan
     */
    public double getPengurangan() {
        return pengurangan;
    }

    /**
     * @param pengurangan the pengurangan to set
     */
    public void setPengurangan(double pengurangan) {
        this.pengurangan = pengurangan;
    }

    /**
     * @return the harusDibayar
     */
    public double getHarusDibayar() {
        return harusDibayar;
    }

    /**
     * @param harusDibayar the harusDibayar to set
     */
    public void setHarusDibayar(double harusDibayar) {
        this.harusDibayar = harusDibayar;
    }

    /**
     * @return the tglRekam
     */
    public Date getTglRekam() {
        return tglRekam;
    }

    /**
     * @param tglRekam the tglRekam to set
     */
    public void setTglRekam(Date tglRekam) {
        this.tglRekam = tglRekam;
    }

    /**
     * @return the typePajak
     */
    public String getTypePajak() {
        return typePajak;
    }

    /**
     * @param typePajak the typePajak to set
     */
    public void setTypePajak(String typePajak) {
        this.typePajak = typePajak;
    }
    

    
   
}
