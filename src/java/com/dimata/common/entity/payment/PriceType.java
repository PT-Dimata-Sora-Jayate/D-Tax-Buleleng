/*
 * PriceType.java
 *
 * Created on July 25, 2005, 3:35 PM
 */

package com.dimata.common.entity.payment;

/* package java */
import java.util.Date;

/* package qdep */
import com.dimata.qdep.entity.*;

/**
 *
 * @author  gedhy
 */
public class PriceType extends Entity {
    
    private String code = "";
    private String name = "";
    private int index = 1;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCode(){
        return code;
    }
    
    public void setCode(String code){
        if ( code == null ) {
            code = "";
        }
        this.code = code;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        if ( name == null ) {
            name = "";
        }
        this.name = name;
    }
}
