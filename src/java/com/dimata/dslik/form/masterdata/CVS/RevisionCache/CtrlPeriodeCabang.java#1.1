/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.form.masterdata;

import com.dimata.dslik.entity.masterdata.PeriodeCabang;
import com.dimata.dslik.entity.masterdata.PstPeriodeCabang;
import javax.servlet.http.*;
import com.dimata.util.*;
import com.dimata.util.lang.*;
import com.dimata.qdep.system.*;
import com.dimata.qdep.form.*;
import com.dimata.qdep.db.*;

/**
 *
 * @author Dewa
 */
/*
 Description : Controll PeriodeCabang
 Date : Tue Oct 04 2016
 Author : Dewa
 */
public class CtrlPeriodeCabang extends Control implements I_Language {

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
    private PeriodeCabang entPeriodeCabang;
    private PstPeriodeCabang pstPeriodeCabang;
    private FrmPeriodeCabang frmPeriodeCabang;
    int language = LANGUAGE_DEFAULT;

    public CtrlPeriodeCabang(HttpServletRequest request) {
        msgString = "";
        entPeriodeCabang = new PeriodeCabang();
        try {
            pstPeriodeCabang = new PstPeriodeCabang(0);
        } catch (Exception e) {;
        }
        frmPeriodeCabang = new FrmPeriodeCabang(request, entPeriodeCabang);
    }

    private String getSystemMessage(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                this.frmPeriodeCabang.addError(frmPeriodeCabang.FRM_FIELD_PERIODE_CABANG_ID, resultText[language][RSLT_EST_CODE_EXIST]);
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

    public PeriodeCabang getPeriodeCabang() {
        return entPeriodeCabang;
    }

    public FrmPeriodeCabang getForm() {
        return frmPeriodeCabang;
    }

    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }

    public int action(int cmd, long oidPeriodeCabang, String oidDelete) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                if (oidPeriodeCabang != 0) {
                    try {
                        entPeriodeCabang = PstPeriodeCabang.fetchExc(oidPeriodeCabang);
                    } catch (Exception exc) {
                    }
                }

                frmPeriodeCabang.requestEntityObject(entPeriodeCabang);

                if (frmPeriodeCabang.errorSize() > 0) {
                    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
                    return RSLT_FORM_INCOMPLETE;
                }

                if (entPeriodeCabang.getOID() == 0) {
                    try {
                        long oid = pstPeriodeCabang.insertExc(this.entPeriodeCabang);
                        msgString = FRMMessage.getMsg(FRMMessage.MSG_SAVED);
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
                        long oid = pstPeriodeCabang.updateExc(this.entPeriodeCabang);
                        msgString = FRMMessage.getMsg(FRMMessage.MSG_UPDATED);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }

                }
                break;

            case Command.EDIT:
                if (oidPeriodeCabang != 0) {
                    try {
                        entPeriodeCabang = PstPeriodeCabang.fetchExc(oidPeriodeCabang);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidPeriodeCabang != 0) {
                    try {
                        entPeriodeCabang = PstPeriodeCabang.fetchExc(oidPeriodeCabang);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidPeriodeCabang != 0) {
                    try {
                        long oid = PstPeriodeCabang.deleteExc(oidPeriodeCabang);
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
    
    public int actionUpdateStatus(int cmd, long oidPeriodeCabang, String oidDelete) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                if (oidPeriodeCabang != 0) {
                    try {
                        entPeriodeCabang = PstPeriodeCabang.fetchExc(oidPeriodeCabang);
                    } catch (Exception exc) {
                    }
                }

//                frmPeriodeCabang.requestEntityObject(entPeriodeCabang);
//
//                if (frmPeriodeCabang.errorSize() > 0) {
//                    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
//                    return RSLT_FORM_INCOMPLETE;
//                }

                if (entPeriodeCabang.getOID() == 0) {
                    try {
                        long oid = pstPeriodeCabang.insertExc(this.entPeriodeCabang);
                        msgString = FRMMessage.getMsg(FRMMessage.MSG_SAVED);
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
                        entPeriodeCabang.setStatus(1);
                        long oid = pstPeriodeCabang.updateExc(this.entPeriodeCabang);
                        msgString = FRMMessage.getMsg(FRMMessage.MSG_UPDATED);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }

                }
                break;

            case Command.EDIT:
                if (oidPeriodeCabang != 0) {
                    try {
                        entPeriodeCabang = PstPeriodeCabang.fetchExc(oidPeriodeCabang);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidPeriodeCabang != 0) {
                    try {
                        entPeriodeCabang = PstPeriodeCabang.fetchExc(oidPeriodeCabang);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidPeriodeCabang != 0) {
                    try {
                        long oid = PstPeriodeCabang.deleteExc(oidPeriodeCabang);
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
