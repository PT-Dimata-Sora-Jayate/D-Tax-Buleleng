/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.bi;

import com.dimata.dtaxintegration.entity.bi.DataTarget;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ardiadi
 */
public class FrmDataTarget extends FRMHandler implements I_FRMInterface, I_FRMType {
  private DataTarget entDataTarget;
  public static final String FRM_NAME_DATATARGET = "FRM_NAME_DATATARGET";
  public static final int FRM_FIELD_TARGET_ID = 0;
  public static final int FRM_FIELD_PAJAK_DETAIL_ID = 1;
  public static final int FRM_FIELD_BULAN = 2;
  public static final int FRM_FIELD_TAHUN_SUMBER = 3;
  public static final int FRM_FIELD_JUMLAH = 4;
  public static final int FRM_FIELD_KENAIKAN = 5;
  public static final int FRM_FIELD_TAHUN_TARGET = 6;


public static String[] fieldNames = {
    "FRM_FIELD_TARGET_ID",
    "FRM_FIELD_PAJAK_DETAIL_ID",
    "FRM_FIELD_BULAN",
    "FRM_FIELD_TAHUN_SUMBER",
    "FRM_FIELD_JUMLAH",
    "FRM_FIELD_KENAIKAN",
    "FRM_FIELD_TAHUN_TARGET"
};

public static int[] fieldTypes = {
    TYPE_LONG,
    TYPE_LONG,
    TYPE_INT,
    TYPE_INT,
    TYPE_FLOAT,
    TYPE_FLOAT,
    TYPE_INT
};

public FrmDataTarget() {
}

public FrmDataTarget(DataTarget entDataTarget) {
this.entDataTarget = entDataTarget;
}

public FrmDataTarget(HttpServletRequest request, DataTarget entDataTarget) {
super(new FrmDataTarget(entDataTarget), request);
this.entDataTarget = entDataTarget;
}

public String getFormName() {
return FRM_NAME_DATATARGET;
}

public int[] getFieldTypes() {
return fieldTypes;
}

public String[] getFieldNames() {
return fieldNames;
}

public int getFieldSize() {
return fieldNames.length;
}

public DataTarget getEntityObject() {
return entDataTarget;
}

public void requestEntityObject(DataTarget entDataTarget) {
try {
this.requestParam();
    entDataTarget.setTargetId(getLong(FRM_FIELD_TARGET_ID));
    entDataTarget.setPajakDetailId(getLong(FRM_FIELD_PAJAK_DETAIL_ID));
    entDataTarget.setBulan(getInt(FRM_FIELD_BULAN));
    entDataTarget.setTahunSumber(getInt(FRM_FIELD_TAHUN_SUMBER));
    entDataTarget.setJumlah(getFloat(FRM_FIELD_JUMLAH));
    entDataTarget.setKenaikan(getFloat(FRM_FIELD_KENAIKAN));
    entDataTarget.setTahunTarget(getInt(FRM_FIELD_TAHUN_TARGET));
} catch (Exception e) {
System.out.println("Error on requestEntityObject : " + e.toString());
}
}

}