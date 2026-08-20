/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.form.bi;

import com.dimata.dtaxintegration.entity.bi.PajakType;
import com.dimata.dtaxintegration.entity.bi.PstPajakType;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.form.FRMMessage;
import com.dimata.qdep.system.I_DBExceptionInfo;
import com.dimata.util.Command;
import com.dimata.util.lang.I_Language;
import java.util.ResourceBundle.Control;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ardiadi
 */
public class CtrlPajakType extends Control implements I_Language {
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
private PajakType entPajakType;
private PstPajakType pstPajakType;
private FrmPajakType frmPajakType;
int language = LANGUAGE_DEFAULT;

public CtrlPajakType(HttpServletRequest request) {
msgString = "";
entPajakType = new PajakType();
try {
pstPajakType = new PstPajakType(0);
} catch (Exception e) {;
}
frmPajakType = new FrmPajakType(request, entPajakType);
}

private String getSystemMessage(int msgCode) {
switch (msgCode) {
case I_DBExceptionInfo.MULTIPLE_ID:
this.frmPajakType.addError(frmPajakType.FRM_FIELD_PAJAK_TYPE_ID, resultText[language][RSLT_EST_CODE_EXIST]);
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

public PajakType getPajakType() {
return entPajakType;
}

public FrmPajakType getForm() {
return frmPajakType;
}

public String getMessage() {
return msgString;
}

public int getStart() {
return start;
}

public int action(int cmd, long oidPajakType) {
msgString = "";
int excCode = I_DBExceptionInfo.NO_EXCEPTION;
int rsCode = RSLT_OK;
switch (cmd) {
case Command.ADD:
break;

case Command.SAVE:
if (oidPajakType != 0) {
try {
entPajakType = PstPajakType.fetchExc(oidPajakType);
} catch (Exception exc) {
}
}

frmPajakType.requestEntityObject(entPajakType);

if (frmPajakType.errorSize() > 0) {
msgString = FRMMessage.getMsg(FRMMessage.MSG_INCOMPLATE);
return RSLT_FORM_INCOMPLETE;
}

if (entPajakType.getOID() == 0) {
try {
long oid = pstPajakType.insertExc(this.entPajakType);
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
long oid = pstPajakType.updateExc(this.entPajakType);
} catch (DBException dbexc) {
excCode = dbexc.getErrorCode();
msgString = getSystemMessage(excCode);
} catch (Exception exc) {
msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
}

}
break;

case Command.EDIT:
if (oidPajakType != 0) {
try {
entPajakType = PstPajakType.fetchExc(oidPajakType);
} catch (DBException dbexc) {
excCode = dbexc.getErrorCode();
msgString = getSystemMessage(excCode);
} catch (Exception exc) {
msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
}
}
break;

case Command.ASK:
if (oidPajakType != 0) {
try {
entPajakType = PstPajakType.fetchExc(oidPajakType);
} catch (DBException dbexc) {
excCode = dbexc.getErrorCode();
msgString = getSystemMessage(excCode);
} catch (Exception exc) {
msgString = getSystemMessage(I_DBExceptionInfo.UNKNOWN);
}
}
break;

case Command.DELETE:
if (oidPajakType != 0) {
try {
long oid = PstPajakType.deleteExc(oidPajakType);
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