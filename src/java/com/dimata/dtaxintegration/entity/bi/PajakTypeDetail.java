/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.bi;

import com.dimata.qdep.entity.Entity;

/**
 *
 * @author Ardiadi
 */
public class PajakTypeDetail extends Entity {

    private long pajakDetailId = 0;
    private long pajakTypeId = 0;
    private String pajakDetailName = "";
    private String pajakQuery="";
    private String colomDate="";
    
    public long getPajakDetailId() {
        return pajakDetailId;
    }

    public void setPajakDetailId(long pajakDetailId) {
        this.pajakDetailId = pajakDetailId;
    }

    public long getPajakTypeId() {
        return pajakTypeId;
    }

    public void setPajakTypeId(long pajakTypeId) {
        this.pajakTypeId = pajakTypeId;
    }

    public String getPajakDetailName() {
        return pajakDetailName;
    }

    public void setPajakDetailName(String pajakDetailName) {
        this.pajakDetailName = pajakDetailName;
    }

    /**
     * @return the pajakQuery
     */
    public String getPajakQuery() {
        return pajakQuery;
    }

    /**
     * @param pajakQuery the pajakQuery to set
     */
    public void setPajakQuery(String pajakQuery) {
        this.pajakQuery = pajakQuery;
    }

    /**
     * @return the colomDate
     */
    public String getColomDate() {
        return colomDate;
    }

    /**
     * @param colomDate the colomDate to set
     */
    public void setColomDate(String colomDate) {
        this.colomDate = colomDate;
    }

}
