/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.bi;

import com.dimata.dtaxintegration.entity.bi.DataTarget;
import com.dimata.dtaxintegration.entity.bi.PstDataTarget;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.form.Control;
import com.dimata.qdep.form.FRMMessage;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.qdep.system.I_DBExceptionInfo;
import com.dimata.util.Command;
import com.dimata.util.lang.I_Language;
import java.util.Arrays;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ardiadi
 */
public class CtrlDataTarget extends Control implements I_Language {
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
private DataTarget entDataTarget;
private PstDataTarget pstDataTarget;
private FrmDataTarget frmDataTarget;
int language = LANGUAGE_DEFAULT;

public CtrlDataTarget(HttpServletRequest request) {
msgString = "";
entDataTarget = new DataTarget();
try {
pstDataTarget = new PstDataTarget(0);
} catch (Exception e) {;
}
frmDataTarget = new FrmDataTarget(request, entDataTarget);
}

private String getSystemMessage(int msgCode) {
switch (msgCode) {
case I_DBExceptionInfo.MULTIPLE_ID:
this.frmDataTarget.addError(frmDataTarget.FRM_FIELD_TARGET_ID, resultText[language][RSLT_EST_CODE_EXIST]);
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

public DataTarget getDataTarget() {
return entDataTarget;
}

public FrmDataTarget getForm() {
return frmDataTarget;
}

public String getMessage() {
return msgString;
}

public int getStart() {
return start;
}

public int action(int cmd, long oidDataTarget, HttpServletRequest request) {
msgString = "";
int excCode = I_DBExceptionInfo.NO_EXCEPTION;
int rsCode = RSLT_OK;
switch (cmd) {
case Command.ADD:
break;

case Command.SAVE:
if (oidDataTarget != 0) {
try {
entDataTarget = PstDataTarget.fetchExc(oidDataTarget);
} catch (Exception exc) {
}
}

frmDataTarget.requestEntityObject(entDataTarget);

if (frmDataTarget.errorSize() > 0) {
msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
return RSLT_FORM_INCOMPLETE;
}

if (entDataTarget.getOID() == 0) {
try {
    String[] bulanData = FRMQueryString.requestStringValues(request, FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_BULAN]);
    String[] jumlahData = FRMQueryString.requestStringValues(request, FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_JUMLAH]);
    String[] kenaikanData = FRMQueryString.requestStringValues(request, FrmDataTarget.fieldNames[FrmDataTarget.FRM_FIELD_KENAIKAN]);
    
    DataTarget dataTarget;
    try{
	Vector listTarget = PstDataTarget.list(0, 0, 
		""+PstDataTarget.fieldNames[PstDataTarget.FLD_TAHUN_TARGET]+"='"+entDataTarget.getTahunTarget()+"'", "");
	if(listTarget.size() != 0){
	    dataTarget = (DataTarget) listTarget.get(0);
	}else{
	    dataTarget = new DataTarget();
	}
    }catch(Exception ex){
	dataTarget = new DataTarget();
    }
    
    for(int i = 0; i<bulanData.length; i++){
	int bulan = Integer.parseInt(bulanData[i]);
	double jumlah = Double.parseDouble(jumlahData[i].replaceAll(",", ""));
	double kenaikan = Double.parseDouble(kenaikanData[i].replaceAll(",", ""));
	
	
	Vector listDataTarget = PstDataTarget.list(0, 0, 
		""+PstDataTarget.fieldNames[PstDataTarget.FLD_BULAN]+"='"+bulan+"' "
		+ "AND "+PstDataTarget.fieldNames[PstDataTarget.FLD_PAJAK_DETAIL_ID]+"='"+entDataTarget.getPajakDetailId()+"' "
		+ "AND "+PstDataTarget.fieldNames[PstDataTarget.FLD_TAHUN_TARGET]+"='"+entDataTarget.getTahunTarget()+"'", "");
	
	
	if(listDataTarget.size() != 0){
	    DataTarget dataTargetCheck = (DataTarget) listDataTarget.get(0);
	    dataTargetCheck.setJumlah(jumlah);
	    dataTargetCheck.setKenaikan(kenaikan);
	    long oid = pstDataTarget.updateExc(dataTargetCheck);
	    msgString = "Sukses menyimpan data";
	}else{
	    entDataTarget.setJumlah(jumlah);
	    entDataTarget.setBulan(bulan);
	    entDataTarget.setKenaikan(kenaikan);
	    long oid = pstDataTarget.insertExc(this.entDataTarget);
	    msgString = "Sukses menyimpan data";
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
long oid = pstDataTarget.updateExc(this.entDataTarget);
} catch (DBException dbexc) {
excCode = dbexc.getErrorCode();
msgString = getSystemMessage(excCode);
} catch (Exception exc) {
msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
}

}
break;

case Command.EDIT:
if (oidDataTarget != 0) {
try {
entDataTarget = PstDataTarget.fetchExc(oidDataTarget);
} catch (DBException dbexc) {
excCode = dbexc.getErrorCode();
msgString = getSystemMessage(excCode);
} catch (Exception exc) {
msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
}
}
break;

case Command.ASK:
if (oidDataTarget != 0) {
try {
entDataTarget = PstDataTarget.fetchExc(oidDataTarget);
} catch (DBException dbexc) {
excCode = dbexc.getErrorCode();
msgString = getSystemMessage(excCode);
} catch (Exception exc) {
msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
}
}
break;

case Command.DELETE:
if (oidDataTarget != 0) {
try {
long oid = PstDataTarget.deleteExc(oidDataTarget);
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