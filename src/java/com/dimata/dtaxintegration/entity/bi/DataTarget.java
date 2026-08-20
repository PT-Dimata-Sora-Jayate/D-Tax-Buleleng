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
public class DataTarget extends Entity {

private long targetId = 0;
private long pajakDetailId = 0;
private int bulan = 0;
private int tahunSumber = 0;
private double jumlah = 0;
private double kenaikan = 0;
private int tahunTarget = 0;
private String pajakName = "";

public long getTargetId(){
return targetId;
}

public void setTargetId(long targetId){
this.targetId = targetId;
}

public long getPajakDetailId(){
return pajakDetailId;
}

public void setPajakDetailId(long pajakDetailId){
this.pajakDetailId = pajakDetailId;
}

public int getBulan(){
return bulan;
}

public void setBulan(int bulan){
this.bulan = bulan;
}

public int getTahunSumber(){
return tahunSumber;
}

public void setTahunSumber(int tahunSumber){
this.tahunSumber = tahunSumber;
}

public double getJumlah(){
return jumlah;
}

public void setJumlah(double jumlah){
this.jumlah = jumlah;
}

public double getKenaikan(){
return kenaikan;
}

public void setKenaikan(double kenaikan){
this.kenaikan = kenaikan;
}

public int getTahunTarget(){
return tahunTarget;
}

public void setTahunTarget(int tahunTarget){
this.tahunTarget = tahunTarget;
}

    /**
     * @return the pajakName
     */
    public String getPajakName() {
	return pajakName;
    }

    /**
     * @param pajakName the pajakName to set
     */
    public void setPajakName(String pajakName) {
	this.pajakName = pajakName;
    }

}