/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.payment;

/**
 *
 * @author dimata005
 */
import com.dimata.dtaxintegration.entity.payment.PaymentPhr;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.qdep.form.I_FRMInterface;
import com.dimata.qdep.form.I_FRMType;
import javax.servlet.http.HttpServletRequest;

public class FrmPaymentPhr extends FRMHandler implements I_FRMInterface, I_FRMType {

    private PaymentPhr entPaymentPhr;
    public static final String FRM_NAME_PAYMENTPHR = "FRM_NAME_PAYMENTPHR";
    public static final int FRM_FIELD_PAYMENTID = 0;
    public static final int FRM_FIELD_NOSSPD = 1;
    public static final int FRM_FIELD_NPWD = 2;
    public static final int FRM_FIELD_MASAPAJAK = 3;
    public static final int FRM_FIELD_TAHUNPAJAK = 4;
    public static final int FRM_FIELD_JUMLAHBAYAR = 5;
    public static final int FRM_FIELD_NAMA = 6;
    public static final int FRM_FIELD_BIAYAADMINISTRASI = 7;
    public static final int FRM_FIELD_TANGGAL = 8;
    public static final int FRM_FIELD_IDPAYMENT = 9;
    public static final int FRM_FIELD_STATUS = 10;
    public static String[] fieldNames = {
        "FRM_FIELD_PAYMENTID",
        "FRM_FIELD_NOSSPD",
        "FRM_FIELD_NPWD",
        "FRM_FIELD_MASAPAJAK",
        "FRM_FIELD_TAHUNPAJAK",
        "FRM_FIELD_JUMLAHBAYAR",
        "FRM_FIELD_NAMA",
        "FRM_FIELD_BIAYAADMINISTRASI",
        "FRM_FIELD_TANGGAL",
        "FRM_FIELD_IDPAYMENT",
        "FRM_FIELD_STATUS"
    };
    public static int[] fieldTypes = {
        TYPE_LONG,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_DATE,
        TYPE_STRING,
        TYPE_STRING
    };

    public FrmPaymentPhr() {
    }

    public FrmPaymentPhr(PaymentPhr entPaymentPhr) {
        this.entPaymentPhr = entPaymentPhr;
    }

    public FrmPaymentPhr(HttpServletRequest request, PaymentPhr entPaymentPhr) {
        super(new FrmPaymentPhr(entPaymentPhr), request);
        this.entPaymentPhr = entPaymentPhr;
    }

    public String getFormName() {
        return FRM_NAME_PAYMENTPHR;
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

    public PaymentPhr getEntityObject() {
        return entPaymentPhr;
    }

    public void requestEntityObject(PaymentPhr entPaymentPhr) {
        try {
            this.requestParam();
            entPaymentPhr.setNoSspd(getString(FRM_FIELD_NOSSPD));
            entPaymentPhr.setNpwpd(getString(FRM_FIELD_NPWD));
            entPaymentPhr.setMasaPajak(getString(FRM_FIELD_MASAPAJAK));
            entPaymentPhr.setTahunPajak(getString(FRM_FIELD_TAHUNPAJAK));
            entPaymentPhr.setJumlahBayar(getFloat(FRM_FIELD_JUMLAHBAYAR));
            entPaymentPhr.setNama(getString(FRM_FIELD_NAMA));
            entPaymentPhr.setBiayaAdministrasi(getFloat(FRM_FIELD_BIAYAADMINISTRASI));
            entPaymentPhr.setTanggal(getDate(FRM_FIELD_TANGGAL));
            entPaymentPhr.setIdPayment(getString(FRM_FIELD_IDPAYMENT));
            entPaymentPhr.setStatus(getString(FRM_FIELD_STATUS));
        } catch (Exception e) {
            System.out.println("Error on requestEntityObject : " + e.toString());
        }
    }
}