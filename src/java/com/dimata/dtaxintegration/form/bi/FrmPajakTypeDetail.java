/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.bi;

import com.dimata.dtaxintegration.entity.bi.PajakTypeDetail;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ardiadi
 */
public class FrmPajakTypeDetail extends FRMHandler implements I_FRMInterface, I_FRMType {
  private PajakTypeDetail entPajakTypeDetail;
  public static final String FRM_NAME_PAJAKTYPEDETAIL = "FRM_NAME_PAJAKTYPEDETAIL";
  public static final int FRM_FIELD_PAJAK_DETAIL_ID = 0;
  public static final int FRM_FIELD_PAJAK_TYPE_ID = 1;
  public static final int FRM_FIELD_PAJAK_DETAIL_NAME = 2;


public static String[] fieldNames = {
    "FRM_FIELD_PAJAK_DETAIL_ID",
    "FRM_FIELD_PAJAK_TYPE_ID",
    "FRM_FIELD_PAJAK_DETAIL_NAME"
};

public static int[] fieldTypes = {
    TYPE_LONG,
    TYPE_LONG,
    TYPE_STRING
};

public FrmPajakTypeDetail() {
}

public FrmPajakTypeDetail(PajakTypeDetail entPajakTypeDetail) {
this.entPajakTypeDetail = entPajakTypeDetail;
}

public FrmPajakTypeDetail(HttpServletRequest request, PajakTypeDetail entPajakTypeDetail) {
super(new FrmPajakTypeDetail(entPajakTypeDetail), request);
this.entPajakTypeDetail = entPajakTypeDetail;
}

public String getFormName() {
return FRM_NAME_PAJAKTYPEDETAIL;
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

public PajakTypeDetail getEntityObject() {
return entPajakTypeDetail;
}

public void requestEntityObject(PajakTypeDetail entPajakTypeDetail) {
try {
this.requestParam();
    entPajakTypeDetail.setPajakDetailId(getLong(FRM_FIELD_PAJAK_DETAIL_ID));
    entPajakTypeDetail.setPajakTypeId(getLong(FRM_FIELD_PAJAK_TYPE_ID));
    entPajakTypeDetail.setPajakDetailName(getString(FRM_FIELD_PAJAK_DETAIL_NAME));
} catch (Exception e) {
System.out.println("Error on requestEntityObject : " + e.toString());
}
}

}
