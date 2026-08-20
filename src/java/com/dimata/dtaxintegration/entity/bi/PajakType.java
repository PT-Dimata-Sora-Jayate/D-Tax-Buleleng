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
public class PajakType extends Entity {

    private long pajakTypeId = 0;
    private String pajakTypeName = "";

    public long getPajakTypeId(){
	return pajakTypeId;
    }

    public void setPajakTypeId(long pajakTypeId){
	this.pajakTypeId = pajakTypeId;
    }

    public String getPajakTypeName(){
	return pajakTypeName;
    }

    public void setPajakTypeName(String pajakTypeName){
	this.pajakTypeName = pajakTypeName;
    }

}