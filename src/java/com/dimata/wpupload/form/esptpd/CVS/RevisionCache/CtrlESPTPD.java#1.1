/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.wpupload.form.esptpd;

import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.OIDFactory;
import com.dimata.qdep.form.Control;
import com.dimata.qdep.form.FRMMessage;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.qdep.system.I_DBExceptionInfo;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import com.dimata.util.lang.I_Language;
import com.dimata.wpupload.entity.esptpd.ESPTPD;
import com.dimata.wpupload.entity.esptpd.PstESPTPD;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ardiadi
 */
public class CtrlESPTPD extends Control implements I_Language {
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
    private ESPTPD entESPTPD;
    private PstESPTPD pstESPTPD;
    private FrmESPTPD frmESPTPD;
    int language = LANGUAGE_DEFAULT;

    public CtrlESPTPD(HttpServletRequest request) {
	msgString = "";
	entESPTPD = new ESPTPD();
	try {
	    pstESPTPD = new PstESPTPD(0);
	} catch (Exception e) {;
	}
	frmESPTPD = new FrmESPTPD(request, entESPTPD);
    }

    private String getSystemMessage(int msgCode) {
	switch (msgCode) {
	    case I_DBExceptionInfo.MULTIPLE_ID:
		this.frmESPTPD.addError(frmESPTPD.FRM_FIELD_E_NPWPD, resultText[language][RSLT_EST_CODE_EXIST]);
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

    public ESPTPD getESPTPD() {
	return entESPTPD;
    }

    public FrmESPTPD getForm() {
	return frmESPTPD;
    }

    public String getMessage() {
	return msgString;
    }

    public int getStart() {
	return start;
    }

    public int action(int cmd, long oidESPTPD, HttpServletRequest request) {
	msgString = "";
	int excCode = I_DBExceptionInfo.NO_EXCEPTION;
	int rsCode = RSLT_OK;
	switch (cmd) {
	    case Command.ADD:
	    break;

	    case Command.SAVE:
		if (oidESPTPD != 0) {
		    try {
			entESPTPD = PstESPTPD.fetchExc(oidESPTPD);
		    } catch (Exception exc) {
		    }
		}

		frmESPTPD.requestEntityObject(entESPTPD);

		if (frmESPTPD.errorSize() > 0) {
		    msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
		    return RSLT_FORM_INCOMPLETE;
		}

		if (entESPTPD.getOID() == 0) {
		    try {
			String getSecondCommand = FRMQueryString.requestString(request, "secondCommand");
			Date currentDate = new Date();
			//String noSPTPD = String.valueOf(OIDFactory.generateOID());
			//String noSSPD = String.valueOf(OIDFactory.generateOID());
			entESPTPD.setETglInput(Formater.reFormatDate(currentDate, "yyyy-MM-dd"));
			entESPTPD.setETglRekam(Formater.reFormatDate(currentDate, "yyyy-MM-dd"));
			entESPTPD.setETglUbah(Formater.reFormatDate(currentDate, "yyyy-MM-dd"));
			//entESPTPD.setENoSPTPD(noSPTPD);
			//entESPTPD.setENoSSPD(noSSPD);
			
			int existData = PstESPTPD.checkExistData(0, 0,
				PstESPTPD.fieldNames[PstESPTPD.FLD_NPWPD]+"='"+entESPTPD.getENPWPD()+"' "
				+ "AND "+PstESPTPD.fieldNames[PstESPTPD.FLD_TAHUN_PAJAK]+"='"+entESPTPD.getETahunPajak()+"' "
				+ "AND "+PstESPTPD.fieldNames[PstESPTPD.FLD_MASA_PAJAK]+"='"+entESPTPD.getEMasaPajak()+"'", "");
			if(existData==0){
			    long oid = pstESPTPD.insertExc(this.entESPTPD);
			    msgString = "SUCCESS";
			}else{
			    if(getSecondCommand.length() == 0){
				msgString = "EXIST";
			    }else{
				long oid = pstESPTPD.updateExcCustom(this.entESPTPD);
			    }
			    
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
			long oid = pstESPTPD.updateExc(this.entESPTPD);
		    } catch (DBException dbexc) {
			excCode = dbexc.getErrorCode();
			msgString = getSystemMessage(excCode);
		    } catch (Exception exc) {
			msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
		    }

		}
	    break;

	    case Command.EDIT:
		if (oidESPTPD != 0) {
		    try {
			entESPTPD = PstESPTPD.fetchExc(oidESPTPD);
		    } catch (DBException dbexc) {
			excCode = dbexc.getErrorCode();
			msgString = getSystemMessage(excCode);
		    } catch (Exception exc) {
			msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
		    }
		}
	    break;

	    case Command.ASK:
		if (oidESPTPD != 0) {
		    try {
			entESPTPD = PstESPTPD.fetchExc(oidESPTPD);
		    } catch (DBException dbexc) {
			excCode = dbexc.getErrorCode();
			msgString = getSystemMessage(excCode);
		    } catch (Exception exc) {
			msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
		    }
		}
	    break;

	    case Command.DELETE:
		if (oidESPTPD != 0) {
		    try {
			long oid = PstESPTPD.deleteExc(oidESPTPD);
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
