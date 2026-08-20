/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.bi;

import com.dimata.dtaxintegration.entity.bi.PajakType;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ardiadi
 */
public class FrmPajakType extends FRMHandler implements I_FRMInterface, I_FRMType {
  private PajakType entPajakType;
  public static final String FRM_NAME_PAJAKTYPE = "FRM_NAME_PAJAKTYPE";
  public static final int FRM_FIELD_PAJAK_TYPE_ID = 0;
  public static final int FRM_FIELD_PAJAK_NAME = 1;


public static String[] fieldNames = {
    "FRM_FIELD_PAJAK_TYPE_ID",
    "FRM_FIELD_PAJAK_NAME"
};

public static int[] fieldTypes = {
    TYPE_LONG,
    TYPE_STRING
};

public FrmPajakType() {
}

public FrmPajakType(PajakType entPajakType) {
this.entPajakType = entPajakType;
}

public FrmPajakType(HttpServletRequest request, PajakType entPajakType) {
super(new FrmPajakType(entPajakType), request);
this.entPajakType = entPajakType;
}

public String getFormName() {
return FRM_NAME_PAJAKTYPE;
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

public PajakType getEntityObject() {
return entPajakType;
}

public void requestEntityObject(PajakType entPajakType) {
try {
this.requestParam();
    entPajakType.setPajakTypeId(getLong(FRM_FIELD_PAJAK_TYPE_ID));
    entPajakType.setPajakTypeName(getString(FRM_FIELD_PAJAK_NAME));
} catch (Exception e) {
System.out.println("Error on requestEntityObject : " + e.toString());
}
}

}
