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
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhr;
import javax.servlet.http.*;
import com.dimata.util.*;
import com.dimata.util.lang.*;
import com.dimata.qdep.system.*;
import com.dimata.qdep.form.*;
import com.dimata.qdep.db.*;

/*
Description : Controll PaymentPhr
Date : Mon May 11 2015
Author : opie-eyek
 */
public class CtrlPaymentPhr extends Control implements I_Language {

    public static int RSLT_OK = 0;
    public static int RSLT_UNKNOWN_ERROR = 1;
    public static int RSLT_EST_CODE_EXIST = 2;
    public static int RSLT_FORM_INCOMPLETE = 3;
    public static String[][] resultText = {
        {"Berhasil", "Tidak dapat diproses", "NoPerkiraan sudah ada", "Data tidak lengkap"},
        {"Succes", "Can not process", "Estimation code exist", "Data incomplete"}
    };
    private int start;
    private String msgString;
    private PaymentPhr entPaymentPhr;
    private PstPaymentPhr pstPaymentPhr;
    private FrmPaymentPhr frmPaymentPhr;
    int language = LANGUAGE_DEFAULT;

    public CtrlPaymentPhr(HttpServletRequest request) {
        msgString = "";
        entPaymentPhr = new PaymentPhr();
        try {
            pstPaymentPhr = new PstPaymentPhr(0);
        } catch (Exception e) {;
        }
        frmPaymentPhr = new FrmPaymentPhr(request, entPaymentPhr);
    }

    private String getSystemMessage(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                this.frmPaymentPhr.addError(frmPaymentPhr.FRM_FIELD_IDPAYMENT, resultText[language][RSLT_EST_CODE_EXIST]);
                return resultText[language][RSLT_EST_CODE_EXIST];
            default:
                return resultText[language][RSLT_UNKNOWN_ERROR];
        }
    }

    private int getControlMsgId(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                return RSLT_EST_CODE_EXIST;
            default:
                return RSLT_UNKNOWN_ERROR;
        }
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public PaymentPhr getPaymentPhr() {
        return entPaymentPhr;
    }

    public FrmPaymentPhr getForm() {
        return frmPaymentPhr;
    }

    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }

    public int action(int cmd, long oidPaymentPhr) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                if (oidPaymentPhr != 0) {
                    try {
                        entPaymentPhr = PstPaymentPhr.fetchExc(oidPaymentPhr);
                    } catch (Exception exc) {
                    }
                }

                frmPaymentPhr.requestEntityObject(entPaymentPhr);

                if (frmPaymentPhr.errorSize() > 0) {
                    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
                    return RSLT_FORM_INCOMPLETE;
                }

                if (entPaymentPhr.getOID() == 0) {
                    try {
                        long oid = pstPaymentPhr.insertExc(this.entPaymentPhr);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                        return getControlMsgId(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                        return getControlMsgId(I_DBExceptionInfo.UNKNOWN);
                    }

                } else {
                    try {
                        long oid = pstPaymentPhr.updateExc(this.entPaymentPhr);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }

                }
                break;

            case Command.EDIT:
                if (oidPaymentPhr != 0) {
                    try {
                        entPaymentPhr = PstPaymentPhr.fetchExc(oidPaymentPhr);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidPaymentPhr != 0) {
                    try {
                        entPaymentPhr = PstPaymentPhr.fetchExc(oidPaymentPhr);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidPaymentPhr != 0) {
                    try {
                        long oid = PstPaymentPhr.deleteExc(oidPaymentPhr);
                        if (oid != 0) {
                            msgString = FRMMessage.getMessage(FRMMessage.MSG_DELETED);
                            excCode = RSLT_OK;
                        } else {
                            msgString = FRMMessage.getMessage(FRMMessage.ERR_DELETED);
                            excCode = RSLT_FORM_INCOMPLETE;
                        }
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            default:

        }
        return rsCode;
    }
}
