/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.form.debiturindividu;

/**
 *
 * @author m20n9
 */
import com.dimata.common.entity.logger.LogSysHistory;
import com.dimata.common.entity.logger.PstLogSysHistory;
import javax.servlet.http.*;
import com.dimata.util.*;
import com.dimata.util.lang.*;
import com.dimata.qdep.system.*;
import com.dimata.qdep.form.*;
import com.dimata.qdep.db.*;
import com.dimata.dslik.entity.debiturindividu.*;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import java.util.Date;
import java.util.Vector;

/*
 Description : Controll DebiturIndividu
 Date : Tue Sep 20 2016
 Author : surya
 */
public class CtrlDebiturIndividu extends Control implements I_Language {

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
    private DebiturIndividu entDebiturIndividu;
    private PstDebiturIndividu pstDebiturIndividu;
    private FrmDebiturIndividu frmDebiturIndividu;
    private long oidResult =0;
    int language = LANGUAGE_DEFAULT;
    DebiturIndividu prevDebiturIndividu = null;

    public CtrlDebiturIndividu(HttpServletRequest request) {
        msgString = "";
        entDebiturIndividu = new DebiturIndividu();
        try {
            pstDebiturIndividu = new PstDebiturIndividu(0);
        } catch (Exception e) {;
        }
        frmDebiturIndividu = new FrmDebiturIndividu(request, entDebiturIndividu);
    }

    private String getSystemMessage(int msgCode) {
        switch (msgCode) {
            case I_DBExceptionInfo.MULTIPLE_ID:
                this.frmDebiturIndividu.addError(frmDebiturIndividu.FRM_FIELD_DEBITUR_INDIVIDU_OID, resultText[language][RSLT_EST_CODE_EXIST]);
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

    public DebiturIndividu getDebiturIndividu() {
        return entDebiturIndividu;
    }

    public FrmDebiturIndividu getForm() {
        return frmDebiturIndividu;
    }

    public String getMessage() {
        return msgString;
    }

    public int getStart() {
        return start;
    }
    
    public void setOidReturn(long oidReturn){
        this.oidResult = oidReturn;
    }
    
    public long getOidReturn (){
        return this.oidResult;
    }

    public int action(int cmd, long oidDebiturIndividu, long userId, String namaUser) {
        msgString = "";
        int excCode = I_DBExceptionInfo.NO_EXCEPTION;
        int rsCode = RSLT_OK;
        switch (cmd) {
            case Command.ADD:
                break;

            case Command.SAVE:
                String kodeJenisNsb="";
                if (oidDebiturIndividu != 0) {
                    try {
                        entDebiturIndividu = PstDebiturIndividu.fetchExc(oidDebiturIndividu);
                        kodeJenisNsb =  entDebiturIndividu.getKodeJenisNsb();
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                    
                    //history
                    try {
                        prevDebiturIndividu = PstDebiturIndividu.fetchExc(oidDebiturIndividu);
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }

                frmDebiturIndividu.requestEntityObject(entDebiturIndividu);

                if (frmDebiturIndividu.errorSize() > 0) {
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
                
                if(entDebiturIndividu.getPeriodeId()==0){
                    entDebiturIndividu.setPeriodeId(periodeId);
                }
                entDebiturIndividu.setFlagDetail("D");
                entDebiturIndividu.setKodeJenisNsb(kodeJenisNsb);
                if (entDebiturIndividu.getOID() == 0) {
                    try {
                        entDebiturIndividu.setOperasiData("0");
                        entDebiturIndividu = pstDebiturIndividu.insertExcObj(this.entDebiturIndividu);
                        long oid = entDebiturIndividu.getOID();
                        setOidReturn(oid);
                        msgString = FRMMessage.getMessage(FRMMessage.MSG_SAVED);
                        if (oid != 0) {
                            //history
                            String queryInsertData  = entDebiturIndividu.getHistorySql();
                            insertHistory(userId, namaUser, cmd, oid, queryInsertData);
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
                        entDebiturIndividu.setOperasiData("1");
                        entDebiturIndividu = pstDebiturIndividu.updateExcObj(this.entDebiturIndividu);
                        long oid =entDebiturIndividu.getOID();
                        setOidReturn(oid);
                        msgString = FRMMessage.getMessage(FRMMessage.MSG_UPDATED);
                        if (oid != 0) {
                            //history
                            String queryInsertData  = entDebiturIndividu.getHistorySql();
                            insertHistory(userId, namaUser, cmd, oid,queryInsertData);
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
                if (oidDebiturIndividu != 0) {
                    try {
                        entDebiturIndividu = PstDebiturIndividu.fetchExc(oidDebiturIndividu);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.ASK:
                if (oidDebiturIndividu != 0) {
                    try {
                        entDebiturIndividu = PstDebiturIndividu.fetchExc(oidDebiturIndividu);
                    } catch (DBException dbexc) {
                        excCode = dbexc.getErrorCode();
                        msgString = getSystemMessage(excCode);
                    } catch (Exception exc) {
                        msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
                    }
                }
                break;

            case Command.DELETE:
                if (oidDebiturIndividu != 0) {
                    try {
                        long oid = PstDebiturIndividu.deleteExc(oidDebiturIndividu);
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
    
    public void insertHistory(long userID, String nameUser, int cmd, long oid, String querySql) {
        try {
            Date dateLog = new  Date();
            LogSysHistory logSysHistory = new LogSysHistory();
            logSysHistory.setLogUserId(userID);
            logSysHistory.setLogLoginName(nameUser);
            logSysHistory.setLogApplication("DSlik");
            logSysHistory.setLogOpenUrl("debitur.jsp");
            logSysHistory.setLogUpdateDate(dateLog);
            logSysHistory.setLogDocumentType("Debitur");
            logSysHistory.setLogUserAction(Command.commandString[cmd]);
            logSysHistory.setLogDocumentNumber(this.entDebiturIndividu.getCif());
            logSysHistory.setLogDocumentId(oid);
            try {
                logSysHistory.setLogDetail(this.entDebiturIndividu.getLogDetail(prevDebiturIndividu));
            } catch (Exception e) {
                logSysHistory.setLogDetail("-");
            }
            
            logSysHistory.setQueryRoleBack(querySql);
            
            if (logSysHistory!=null || cmd == Command.DELETE) {
                long oid2 = PstLogSysHistory.insertLog(logSysHistory);
            }
            
        } catch (Exception e) {

        }
    }
}
