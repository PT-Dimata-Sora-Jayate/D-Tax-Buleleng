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
//public class FrmDataPajak {
//    
//}
import com.dimata.dtaxintegration.entity.bi.DataPajak;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import javax.servlet.http.HttpServletRequest;

public class FrmDataPajak extends FRMHandler implements I_FRMInterface, I_FRMType {

    private DataPajak entDataPajak;
    public static final String FRM_NAME_DATAPAJAK = "FRM_NAME_DATAPAJAK";
    public static final int FRM_FIELD_PAJAKDETAILID = 0;
    public static final int FRM_FIELD_TANGGALBAYAR = 1;
    public static final int FRM_FIELD_ID = 2;
    public static final int FRM_FIELD_NAMA = 3;
    public static final int FRM_FIELD_JUMLAHPAJAK = 4;
    public static final int FRM_FIELD_TAHUN = 5;
    public static final int FRM_FIELD_BULAN = 6;
    public static final int FRM_FIELD_KELURAHAN = 7;
    public static final int FRM_FIELD_KECAMATAN = 8;
    public static final int FRM_FIELD_PROV = 9;
    public static final int FRM_FIELD_DATI= 10;
    

    public static String[] fieldNames = {
        "FRM_FIELD_PAJAKDETAILID",
        "FRM_FIELD_TANGGALBAYAR",
        "FRM_FIELD_ID",
        "FRM_FIELD_NAMA",
        "FRM_FIELD_JUMLAHPAJAK",
        "FRM_FIELD_TAHUN",
        "FRM_FIELD_BULAN",
        "FRM_FIELD_KELURAHAN",
        "FRM_FIELD_KECAMATAN",
        "FRM_FIELD_PROV",
        "FRM_FIELD_DATI"
    };

    public static int[] fieldTypes = {
        TYPE_LONG,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING
    };

    public FrmDataPajak() {
    }

    public FrmDataPajak(DataPajak entDataPajak) {
        this.entDataPajak = entDataPajak;
    }

    public FrmDataPajak(HttpServletRequest request, DataPajak entDataPajak) {
        super(new FrmDataPajak(entDataPajak), request);
        this.entDataPajak = entDataPajak;
    }

    public String getFormName() {
        return FRM_NAME_DATAPAJAK;
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

    public DataPajak getEntityObject() {
        return entDataPajak;
    }

    public void requestEntityObject(DataPajak entDataPajak) {
        try {
            
            this.requestParam();
            entDataPajak.setPajakDetailId(getLong(FRM_FIELD_PAJAKDETAILID));
            entDataPajak.setTanggalBayar(getDate(FRM_FIELD_TANGGALBAYAR));
            entDataPajak.setId(getString(FRM_FIELD_ID));
            entDataPajak.setNama(getString(FRM_FIELD_NAMA));
            entDataPajak.setJumlahPajak(getFloat(FRM_FIELD_JUMLAHPAJAK));
            entDataPajak.setTahun(getString(FRM_FIELD_TAHUN));
            entDataPajak.setBulan(getString(FRM_FIELD_BULAN));
            entDataPajak.setKodeKelurahan(getString(FRM_FIELD_KELURAHAN));
            entDataPajak.setKodeKecamatan(getString(FRM_FIELD_KECAMATAN));
            entDataPajak.setKodeProv(getString(FRM_FIELD_PROV));
            entDataPajak.setKodeDati2(getString(FRM_FIELD_DATI));
            
        } catch (Exception e) {
            System.out.println("Error on requestEntityObject : " + e.toString());
        }
    }

}
