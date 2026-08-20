/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.loghistory;

import com.dimata.dtaxintegration.entity.loghistory.LogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import javax.servlet.http.*;
import com.dimata.util.*;
import com.dimata.util.lang.*;
import com.dimata.qdep.system.*;
import com.dimata.qdep.form.*;
import com.dimata.qdep.db.*;

/*
Description : Controll LogHistoryTransaksi
Date : Mon May 11 2015
Author : opie-eyek
 */
public class CtrlLogHistoryTransaksi extends Control implements I_Language {

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
    private LogHistoryTransaksi entLogHistoryTransaksi;
    private PstLogHistoryTransaksi pstLogHistoryTransaksi;
    private FrmLogHistoryTransaksi frmLogHistoryTransaksi;
    int language = LANGUAGE_DEFAULT;

    public CtrlLogHistoryTransaksi(HttpServletRequest request) {
        msgString = "";
        entLogHistoryTransaksi = new LogHistoryTransaksi();
        try {
            pstLogHistoryTransaksi = new PstLogHistoryTransaksi(0);
        } catch (Exception e) {;
        }
        frmLogHistoryTransaksi = new FrmLogHistoryTransaksi(request, entLogHistoryTransaksi);
    }

    private String getSystemMessage(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                this.frmLogHistoryTransaksi.addError(frmLogHistoryTransaksi.FRM_FIELD_LOGHISTORYID, resultText[language][RSLT_EST_CODE_EXIST]);
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

    public LogHistoryTransaksi getLogHistoryTransaksi() {
        return entLogHistoryTransaksi;
    }

    public FrmLogHistoryTransaksi getForm() {
        return frmLogHistoryTransaksi;
    }

    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }

    public int action(int cmd, long oidLogHistoryTransaksi) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                if (oidLogHistoryTransaksi != 0) {
                    try {
                        entLogHistoryTransaksi = PstLogHistoryTransaksi.fetchExc(oidLogHistoryTransaksi);
                    } catch (Exception exc) {
                    }
                }

                frmLogHistoryTransaksi.requestEntityObject(entLogHistoryTransaksi);

                if (frmLogHistoryTransaksi.errorSize() > 0) {
                    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
                    return RSLT_FORM_INCOMPLETE;
                }

                if (entLogHistoryTransaksi.getOID() == 0) {
                    try {
                        long oid = pstLogHistoryTransaksi.insertExc(this.entLogHistoryTransaksi);
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
                        long oid = pstLogHistoryTransaksi.updateExc(this.entLogHistoryTransaksi);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }

                }
                break;

            case Command.EDIT:
                if (oidLogHistoryTransaksi != 0) {
                    try {
                        entLogHistoryTransaksi = PstLogHistoryTransaksi.fetchExc(oidLogHistoryTransaksi);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidLogHistoryTransaksi != 0) {
                    try {
                        entLogHistoryTransaksi = PstLogHistoryTransaksi.fetchExc(oidLogHistoryTransaksi);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidLogHistoryTransaksi != 0) {
                    try {
                        long oid = PstLogHistoryTransaksi.deleteExc(oidLogHistoryTransaksi);
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