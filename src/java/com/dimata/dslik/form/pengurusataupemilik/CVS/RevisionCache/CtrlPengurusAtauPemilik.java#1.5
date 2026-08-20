package com.dimata.dslik.form.pengurusataupemilik;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.dimata.common.entity.logger.LogSysHistory;
import com.dimata.common.entity.logger.PstLogSysHistory;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.entity.pengurusataupemilik.PengurusAtauPemilik;
import com.dimata.dslik.entity.pengurusataupemilik.PstPengurusAtauPemilik;
import javax.servlet.http.*;
import com.dimata.util.*;
import com.dimata.util.lang.*;
import com.dimata.qdep.system.*;
import com.dimata.qdep.form.*;
import com.dimata.qdep.db.*;
import java.util.Date;
import java.util.Vector;

/*
 Description : Controll PengurusAtauPemilik
 Date : Tue Sep 20 2016
 Author : Dewa
 */
public class CtrlPengurusAtauPemilik extends Control implements I_Language {

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
    private PengurusAtauPemilik entPengurusAtauPemilik;
    private PstPengurusAtauPemilik pstPengurusAtauPemilik;
    private FrmPengurusAtauPemilik frmPengurusAtauPemilik;
    int language = LANGUAGE_DEFAULT;
    PengurusAtauPemilik prevPengurusPemilik = null;

    public CtrlPengurusAtauPemilik(HttpServletRequest request) {
        msgString = "";
        entPengurusAtauPemilik = new PengurusAtauPemilik();
        try {
            pstPengurusAtauPemilik = new PstPengurusAtauPemilik(0);
        } catch (Exception e) {;
        }
        frmPengurusAtauPemilik = new FrmPengurusAtauPemilik(request, entPengurusAtauPemilik);
    }

    private String getSystemMessage(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                this.frmPengurusAtauPemilik.addError(frmPengurusAtauPemilik.FRM_FIELD_PENGURUS_ATAU_PEMILIK_OID, resultText[language][RSLT_EST_CODE_EXIST]);
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

    public PengurusAtauPemilik getPengurusAtauPemilik() {
        return entPengurusAtauPemilik;
    }

    public FrmPengurusAtauPemilik getForm() {
        return frmPengurusAtauPemilik;
    }

    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }

    public int action(int cmd, long oidPengurusAtauPemilik, long userId, String namaUser) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                if (oidPengurusAtauPemilik != 0) {
                    try {
                        entPengurusAtauPemilik = PstPengurusAtauPemilik.fetchExc(oidPengurusAtauPemilik);
                    } catch (Exception exc) {
                    }
                    
                    //history
                    try {
                        prevPengurusPemilik = PstPengurusAtauPemilik.fetchExc(oidPengurusAtauPemilik);
                    } catch (Exception e) {
                    }
                }

                frmPengurusAtauPemilik.requestEntityObject(entPengurusAtauPemilik);

                if (frmPengurusAtauPemilik.errorSize() > 0) {
                    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
                    return RSLT_FORM_INCOMPLETE;
                }
                
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
                
                if(entPengurusAtauPemilik.getPeriodeId()==0){
                    entPengurusAtauPemilik.setPeriodeId(periodeId);
                }
                entPengurusAtauPemilik.setFlagDetail("D");
                
                if (entPengurusAtauPemilik.getOID() == 0) {
                    try {
                        entPengurusAtauPemilik.setOperasiData("0");
                        entPengurusAtauPemilik = pstPengurusAtauPemilik.insertExcObj(this.entPengurusAtauPemilik);
                        msgString = FRMMessage.getMsg(FRMMessage.MSG_SAVED);
                        //history
                        if(entPengurusAtauPemilik.getOID() != 0){
                            //history
                            String queryInsertData = entPengurusAtauPemilik.getSqlHistory();
                            insertHistory(userId, namaUser, cmd, entPengurusAtauPemilik.getOID(), queryInsertData);
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
                        entPengurusAtauPemilik.setOperasiData("1");
                        entPengurusAtauPemilik = pstPengurusAtauPemilik.updateExcObj(this.entPengurusAtauPemilik);
                        msgString = FRMMessage.getMsg(FRMMessage.MSG_UPDATED);
                        if (entPengurusAtauPemilik.getOID() != 0) {
                            //history
                            String queryInsertData  = entPengurusAtauPemilik.getSqlHistory();
                            insertHistory(userId, namaUser, cmd, entPengurusAtauPemilik.getOID(),queryInsertData);
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
                if (oidPengurusAtauPemilik != 0) {
                    try {
                        entPengurusAtauPemilik = PstPengurusAtauPemilik.fetchExc(oidPengurusAtauPemilik);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidPengurusAtauPemilik != 0) {
                    try {
                        entPengurusAtauPemilik = PstPengurusAtauPemilik.fetchExc(oidPengurusAtauPemilik);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidPengurusAtauPemilik != 0) {
                    try {
                        long oid = PstPengurusAtauPemilik.deleteExc(oidPengurusAtauPemilik);
                        try {
                            prevPengurusPemilik = PstPengurusAtauPemilik.fetchExc(oidPengurusAtauPemilik);
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
            logSysHistory.setLogOpenUrl("pengurusAtauPemilik.jsp");
            logSysHistory.setLogUpdateDate(dateLog);
            logSysHistory.setLogDocumentType("PengurusAtauPemilik");
            logSysHistory.setLogUserAction(Command.commandString[cmd]);
            logSysHistory.setLogDocumentNumber(this.entPengurusAtauPemilik.getCif());
            logSysHistory.setLogDocumentId(oid);
            try {
                logSysHistory.setLogDetail(this.entPengurusAtauPemilik.getLogDetail(prevPengurusPemilik));
            } catch (Exception e) {
            }
            
            logSysHistory.setQueryRoleBack(querySql);
            
            if (!logSysHistory.getLogDetail().equals("") || cmd == Command.DELETE) {
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
                                long oid = pstPengurusAtauPemilik.deleteExc(oidRel);
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
