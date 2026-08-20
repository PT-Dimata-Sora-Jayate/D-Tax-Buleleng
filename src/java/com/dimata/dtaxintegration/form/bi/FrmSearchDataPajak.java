/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.bi;

/**
 *
 * @author dimata005
 */
//public class FrmSearchDataPajak {
//    
//}
import com.dimata.dtaxintegration.entity.bi.SearchDataPajak;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import javax.servlet.http.HttpServletRequest;

public class FrmSearchDataPajak extends FRMHandler implements I_FRMInterface, I_FRMType {

    private SearchDataPajak entSearchDataPajak;
    public static final String FRM_NAME_SEARCHDATAPAJAK = "FRM_NAME_SEARCHDATAPAJAK";
    public static final int FRM_FIELD_PAJAKDETAILID = 0;
    public static final int FRM_FIELD_STARTDATE = 1;
    public static final int FRM_FIELD_ENDDATE = 2;
    public static final int FRM_FIELD_RANGEDATE = 3;
    public static final int FRM_FIELD_TYPE_INPUT_DATA = 4;
    
    public static String[] fieldNames = {
        "FRM_FIELD_PAJAKDETAILID",
        "FRM_FIELD_STARTDATE",
        "FRM_FIELD_ENDDATE",
        "FRM_FIELD_RANGEDATE",
        "FRM_FIELD_TYPE_INPUT_DATA"
    };

    public static int[] fieldTypes = {
        TYPE_LONG,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_INT
    };

    public FrmSearchDataPajak() {
    }

    public FrmSearchDataPajak(SearchDataPajak entSearchDataPajak) {
        this.entSearchDataPajak = entSearchDataPajak;
    }

    public FrmSearchDataPajak(HttpServletRequest request, SearchDataPajak entSearchDataPajak) {
        super(new FrmSearchDataPajak(entSearchDataPajak), request);
        this.entSearchDataPajak = entSearchDataPajak;
    }

    public String getFormName() {
        return FRM_NAME_SEARCHDATAPAJAK;
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

    public SearchDataPajak getEntityObject() {
        return entSearchDataPajak;
    }

    public void requestEntityObject(SearchDataPajak entSearchDataPajak) {
        try {
            
            this.requestParam();
            entSearchDataPajak.setPajakDetailId(getLong(FRM_FIELD_PAJAKDETAILID));
            entSearchDataPajak.setStartDate(getString(FRM_FIELD_STARTDATE));
            entSearchDataPajak.setEndDate(getString(FRM_FIELD_ENDDATE));
            entSearchDataPajak.setRangeDate(getString(FRM_FIELD_RANGEDATE));
            entSearchDataPajak.setTypeInputData(getInt(FRM_FIELD_TYPE_INPUT_DATA));
            
        } catch (Exception e) {
            System.out.println("Error on requestEntityObject : " + e.toString());
        }
    }

}
