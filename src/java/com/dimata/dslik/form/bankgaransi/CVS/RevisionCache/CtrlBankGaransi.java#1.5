/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.form.bankgaransi;

import com.dimata.common.entity.logger.LogSysHistory;
import com.dimata.common.entity.logger.PstLogSysHistory;
import com.dimata.dslik.entity.bankgaransi.BankGaransi;
import com.dimata.dslik.entity.bankgaransi.PstBankGaransi;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import javax.servlet.http.*;
import com.dimata.util.*;
import com.dimata.util.lang.*;
import com.dimata.qdep.system.*;
import com.dimata.qdep.form.*;
import com.dimata.qdep.db.*;
import java.util.Date;
import java.util.Vector;


/*
 Description : Controll BankGaransi
 Date : Wed Sep 21 2016
 Author : Dewa
 */
public class CtrlBankGaransi extends Control implements I_Language {

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
    private BankGaransi entBankGaransi;
    private PstBankGaransi pstBankGaransi;
    private FrmBankGaransi frmBankGaransi;
    int language = LANGUAGE_DEFAULT;
    BankGaransi prevBankGaransi = null;

    public CtrlBankGaransi(HttpServletRequest request) {
        msgString = "";
        entBankGaransi = new BankGaransi();
        try {
            pstBankGaransi = new PstBankGaransi(0);
        } catch (Exception e) {;
        }
        frmBankGaransi = new FrmBankGaransi(request, entBankGaransi);
    }

    private String getSystemMessage(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                this.frmBankGaransi.addError(frmBankGaransi.FRM_FIELD_BANK_GARANSI_OID, resultText[language][RSLT_EST_CODE_EXIST]);
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

    public BankGaransi getBankGaransi() {
        return entBankGaransi;
    }

    public FrmBankGaransi getForm() {
        return frmBankGaransi;
    }

    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }

    public int action(int cmd, long oidBankGaransi, long userId, String namaUser) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                if (oidBankGaransi != 0) {
                    try {
                        entBankGaransi = PstBankGaransi.fetchExc(oidBankGaransi);
                    } catch (Exception exc) {
                    }
                    try {
                        prevBankGaransi = PstBankGaransi.fetchExc(oidBankGaransi);
                    } catch (Exception exc) {
                    }
                }

                frmBankGaransi.requestEntityObject(entBankGaransi);

                if (frmBankGaransi.errorSize() > 0) {
                    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
                    return RSLT_FORM_INCOMPLETE;
                }
                //tambahkan fungsi pengecekan periode yang aktive, update dengan periode tsb
                Periode periode = new Periode();
                long periodeId=0;
                try{
                    Vector listPeriode = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'", "");
                    if(listPeriode != null){
                        periode = (Periode) listPeriode.get(0);
                        periodeId = periode.getOID();
                    }
                }catch(Exception ex){
                }
                
                if(entBankGaransi.getPeriodeid()==0){
                    entBankGaransi.setPeriodeid(periodeId);
                }
                entBankGaransi.setFlagDetail("D");
                
                if (entBankGaransi.getOID() == 0) {
                    try {
                        entBankGaransi.setOperasiData("0");
                        entBankGaransi = pstBankGaransi.insertExcObj(this.entBankGaransi);
                        msgString = FRMMessage.getMessage(FRMMessage.MSG_SAVED);
                        if (entBankGaransi.getOID() != 0) {
                            String queryInsertData  = pstBankGaransi.getSqlQueryHistory();
                            insertHistory(userId, namaUser, cmd, entBankGaransi.getOID(), queryInsertData);
                        }
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
                        entBankGaransi.setOperasiData("1");
                        entBankGaransi = pstBankGaransi.updateExcObj(this.entBankGaransi);
                        msgString = FRMMessage.getMessage(FRMMessage.MSG_UPDATED);
                        if (entBankGaransi.getOID() != 0) {
                            String queryInsertData  = pstBankGaransi.getSqlQueryHistory();
                            insertHistory(userId, namaUser, cmd, entBankGaransi.getOID(),queryInsertData);
                        }
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }

                }
                break;

            case Command.EDIT:
                if (oidBankGaransi != 0) {
                    try {
                        entBankGaransi = PstBankGaransi.fetchExc(oidBankGaransi);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidBankGaransi != 0) {
                    try {
                        entBankGaransi = PstBankGaransi.fetchExc(oidBankGaransi);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidBankGaransi != 0) {
                    try {
                        long oid = PstBankGaransi.deleteExc(oidBankGaransi);
                        try {
                            prevBankGaransi = PstBankGaransi.fetchExc(oidBankGaransi);
                        } catch (Exception exc) {
                        }
                        if (oid != 0) {
                            if (oid != 0) {
                                insertHistory(userId, namaUser, cmd, oid,"");
                            }
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
    
    /**
     * 
     * history
     */
    public void insertHistory(long userID, String nameUser, int cmd, long oid, String querySql) {
        try {
            Date dateLog = new  Date();
            LogSysHistory logSysHistory = new LogSysHistory();
            logSysHistory.setLogUserId(userID);
            logSysHistory.setLogLoginName(nameUser);
            logSysHistory.setLogApplication("DSlik");
            logSysHistory.setLogOpenUrl("bankGaransi.jsp");
            logSysHistory.setLogUpdateDate(dateLog);
            logSysHistory.setLogDocumentType("BankGaransi");
            logSysHistory.setLogUserAction(Command.commandString[cmd]);
            logSysHistory.setLogDocumentNumber(this.entBankGaransi.getCif());
            logSysHistory.setLogDocumentId(oid);
            try {
                logSysHistory.setLogDetail(this.entBankGaransi.getLogDetail(prevBankGaransi));
            } catch (Exception e) {
            }
            
            logSysHistory.setQueryRoleBack(querySql);
            
            if (logSysHistory!=null || cmd == Command.DELETE) {
                long oid2 = PstLogSysHistory.insertLog(logSysHistory);
            }
            
        } catch (Exception e) {

        }
    }
    
    public int action(int cmd, long oidReligion, String religionDeleteReligion) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {

            case Command.DELETEALL:
                //splits => untuk mengurutkan beberapa data menjadi baris data
                String[] splits = religionDeleteReligion.split(",");
                for (String asset : splits) {
                    if (asset != "") {
                        long oidRel = Long.parseLong(asset);
                        if (oidRel != 0) {
                            try {
                                long oid = pstBankGaransi.deleteExc(oidRel);
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
                    }
                }
                break;

            default:

        }
        return rsCode;

    }
}
