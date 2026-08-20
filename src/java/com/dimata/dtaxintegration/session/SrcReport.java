/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import java.util.Date;

/**
 *
 * @author dimata005
 */
public class SrcReport {
    private String startDate = "";//new Date();
    private String endDate = "";//new Date();
    private int sortBy=0;
    private double exchangeRate=0.0;
    private double pemotonganKomisi=0.0;
    

    /**
     * @return the sortBy
     */
    public int getSortBy() {
        return sortBy;
    }

    /**
     * @return the exchangeRate
     */
    public double getExchangeRate() {
        return exchangeRate;
    }

    /**
     * @param exchangeRate the exchangeRate to set
     */
    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    /**
     * @return the pemotonganKomisi
     */
    public double getPemotonganKomisi() {
        return pemotonganKomisi;
    }

    /**
     * @param pemotonganKomisi the pemotonganKomisi to set
     */
    public void setPemotonganKomisi(double pemotonganKomisi) {
        this.pemotonganKomisi = pemotonganKomisi;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

   
}
