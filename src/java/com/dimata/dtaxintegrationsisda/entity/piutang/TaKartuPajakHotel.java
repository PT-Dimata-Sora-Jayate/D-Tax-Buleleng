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
public class TaKartuPajakHotel extends Entity{
    private int tahun =0;
    private String noSpt ="";
    private int kdRek1 =0;
    private int kdRek2 =0;
    private int kdRek3 =0;
    private int kdRek4 =0;
    private int kdRek5 =0;
    private int kdRek6 =0;
    private double dasarPengenaan =0;
    private double pajakTerhutang =0;
    private double tarifPajak=0;
    private int kas =0;
    private int pembukuan =0;

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
     * @return the kdRek1
     */
    public int getKdRek1() {
        return kdRek1;
    }

    /**
     * @param kdRek1 the kdRek1 to set
     */
    public void setKdRek1(int kdRek1) {
        this.kdRek1 = kdRek1;
    }

    /**
     * @return the kdRek2
     */
    public int getKdRek2() {
        return kdRek2;
    }

    /**
     * @param kdRek2 the kdRek2 to set
     */
    public void setKdRek2(int kdRek2) {
        this.kdRek2 = kdRek2;
    }

    /**
     * @return the kdRek3
     */
    public int getKdRek3() {
        return kdRek3;
    }

    /**
     * @param kdRek3 the kdRek3 to set
     */
    public void setKdRek3(int kdRek3) {
        this.kdRek3 = kdRek3;
    }

    /**
     * @return the kdRek4
     */
    public int getKdRek4() {
        return kdRek4;
    }

    /**
     * @param kdRek4 the kdRek4 to set
     */
    public void setKdRek4(int kdRek4) {
        this.kdRek4 = kdRek4;
    }

    /**
     * @return the kdRek5
     */
    public int getKdRek5() {
        return kdRek5;
    }

    /**
     * @param kdRek5 the kdRek5 to set
     */
    public void setKdRek5(int kdRek5) {
        this.kdRek5 = kdRek5;
    }

    /**
     * @return the kdRek6
     */
    public int getKdRek6() {
        return kdRek6;
    }

    /**
     * @param kdRek6 the kdRek6 to set
     */
    public void setKdRek6(int kdRek6) {
        this.kdRek6 = kdRek6;
    }

    /**
     * @return the dasarPengenaan
     */
    public double getDasarPengenaan() {
        return dasarPengenaan;
    }

    /**
     * @param dasarPengenaan the dasarPengenaan to set
     */
    public void setDasarPengenaan(double dasarPengenaan) {
        this.dasarPengenaan = dasarPengenaan;
    }

    /**
     * @return the pajakTerhutang
     */
    public double getPajakTerhutang() {
        return pajakTerhutang;
    }

    /**
     * @param pajakTerhutang the pajakTerhutang to set
     */
    public void setPajakTerhutang(double pajakTerhutang) {
        this.pajakTerhutang = pajakTerhutang;
    }

    /**
     * @return the tarifPajak
     */
    public double getTarifPajak() {
        return tarifPajak;
    }

    /**
     * @param tarifPajak the tarifPajak to set
     */
    public void setTarifPajak(double tarifPajak) {
        this.tarifPajak = tarifPajak;
    }

    /**
     * @return the kas
     */
    public int getKas() {
        return kas;
    }

    /**
     * @param kas the kas to set
     */
    public void setKas(int kas) {
        this.kas = kas;
    }

    /**
     * @return the pembukuan
     */
    public int getPembukuan() {
        return pembukuan;
    }

    /**
     * @param pembukuan the pembukuan to set
     */
    public void setPembukuan(int pembukuan) {
        this.pembukuan = pembukuan;
    }
}
    

