/*
 * SessUserSession.java
 *
 * Created on April 11, 2002, 6:54 AM
 */

package com.dimata.dslik.session.admin;

import com.dimata.dslik.entity.admin.*;
import com.dimata.dslik.session.proses.ProsesTransferDataBank;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author  ktanjana
 * @version
 * @objective represent access session of a user loggin into he system
 */
public class SessUserSession  {
    public final static String HTTP_SESSION_NAME = "USER_SESSION";
    public final static String HTTP_SESSION_SALES = "SALES_SESSION";
    public final static int DO_LOGIN_OK = 0;
    public final static int DO_LOGIN_ALREADY_LOGIN =1;
    public final static int DO_LOGIN_NOT_VALID =2;
    public final static int DO_LOGIN_SYSTEM_FAIL =3;
    public final static int DO_LOGIN_GET_PRIV_ERROR =4;
    public final static int DO_LOGIN_NO_PRIV_ASIGNED =5;

    public final static String[] soLoginTxt={"Login succeed","User is already logged in",
    "Login ID or Password are invalid","System cannot login you", "Can't get privilege",
    "No access asigned, please contact your system administrator"};

    private Vector  privObj= new Vector();
    private AppUser appUser = new AppUser();
    private Hashtable<String, Boolean> appG1G2 = new Hashtable(); // contains privilege level G1+G2(key) -> True  added by kartika 2050326 
    private Hashtable<String, Boolean> appG1G2Obj = new Hashtable();
    /** Creates new SessUserSession */
    public SessUserSession() {
        appUser.setUserStatus(AppUser.STATUS_LOGOUT);
    }

    public SessUserSession(String hostIP) {
        appUser.setUserStatus(AppUser.STATUS_LOGOUT);
        appUser.setLastLoginIp(hostIP);
    }

    public AppUser getAppUser(){
    	return this.appUser;
    }

    public boolean isLoggedIn(){
        if( /*(this.appUser!=null) && (this.appUser.getOID()!=0) && */
             (this.appUser.getUserStatus()==AppUser.STATUS_LOGIN))
            return true;
        else
            return false;
    }


   public boolean checkPrivilege(int objCode){
       if(!isLoggedIn())
           return false;
       return SessAppPrivilegeObj.existCode(this.privObj, objCode);
   }

   
    
   public boolean checkPrivG1G2(int privG1, int privG2){
        if(!isLoggedIn())
           return false;
        if(appG1G2==null){
            appG1G2 = new Hashtable();
        }
        String strG1G2 = ""+ AppObjInfo.composeObjCode(privG1, privG2);
        Boolean privG1G2= appG1G2.contains(strG1G2);
        if((privG1G2==null || privG1G2==false) && this.privObj!=null ){
          for(int i=0; i<this.privObj.size();i++){
            if(((privG1 << AppObjInfo.SHIFT_CODE_G1) + (privG2 << AppObjInfo.SHIFT_CODE_G2))==
                    ( (( (Integer) this.privObj.get(i)).intValue() ) & ( AppObjInfo.FILTER_CODE_G1 + AppObjInfo.FILTER_CODE_G2 ) )){
               appG1G2.put(strG1G2, new Boolean(true));
               return true;
            }
          }
        }else {
            return true;
        }
        return false;
   }
   
    public boolean checkPrivG1(int privG1){
        if(!isLoggedIn())
           return false;
        if(appG1G2==null){
            appG1G2 = new Hashtable();
        }
        String strG1 = ""+ AppObjInfo.composeObjCode(privG1);
        Boolean bPrivG1 = appG1G2.contains(strG1);
        if((bPrivG1==null || bPrivG1==false) && this.privObj!=null ){
          for(int i=0; i<this.privObj.size();i++){
            if((privG1 << AppObjInfo.SHIFT_CODE_G1)==
                    ( (( (Integer) this.privObj.get(i)).intValue() ) & ( AppObjInfo.FILTER_CODE_G1 ) )){
               appG1G2.put(strG1, new Boolean(true));
               return true;
            }
          }
        }else {
            return true;
        }
        return false;
   }
   
    public boolean checkPrivG1G2Obj(int privG1, int privG2, int objIdx){
        if(!isLoggedIn())
           return false;
        if(appG1G2Obj==null){
            appG1G2Obj = new Hashtable();
        }
        int strG1G2Obj = AppObjInfo.composeObjCode(privG1, privG2, objIdx);
        
        return SessAppPrivilegeObj.existCode(this.privObj, strG1G2Obj);
   }
   
     public boolean checkPrivG1G2ObjCommand(int privG1, int privG2, int objIdx,int command){
        if(!isLoggedIn())
           return false;
        if(appG1G2Obj==null){
            appG1G2Obj = new Hashtable();
        }
        int strG1G2Obj = AppObjInfo.composeCode(privG1, privG2, objIdx, command);
        
        return SessAppPrivilegeObj.existCode(this.privObj, strG1G2Obj);
   }
   
    public int doLogin(String loginID, String password, boolean login, int typeLogin){
        AppUser user = new AppUser();
        if(typeLogin==0 && login==true){//modus online
            user = PstAppUser.getByLoginID(loginID, password);
        }else{//modus offline
            user = new AppUser();
        }
        if(typeLogin==1){
            user = PstAppUser.getByLoginIDAndPassword(loginID, password);
        }
        if(user==null)
            return DO_LOGIN_SYSTEM_FAIL;

        if(user.getOID()==0)
            return DO_LOGIN_NOT_VALID;

        user.setLastLoginIp(this.appUser.getLastLoginIp());
        user.setUserStatus(AppUser.STATUS_LOGIN);
        user.setLastLoginDate(new Date());

        this.appUser = user;

        privObj = PstAppUser.getUserPrivObj(this.appUser.getOID());

        if(privObj==null){
            privObj= new Vector(1,1);
            return DO_LOGIN_GET_PRIV_ERROR;
        }

        System.out.println(" User login OK status ->" + appUser.getUserStatus());
        return DO_LOGIN_OK;
    }

   
    /**
     * doApprovalSupervisor
     * add Ari Wiweka 11/06/2013
     */
    public int doApproval(String loginID, String password){
        AppUser user = PstAppUser.getByLoginIDAndPassword(loginID, password);

        if(user==null)
            return DO_LOGIN_SYSTEM_FAIL;

        if(user.getOID()==0)
            return DO_LOGIN_NOT_VALID;

        if(user.getUserGroupNew()==4)
            return DO_LOGIN_OK;

        return DO_LOGIN_NOT_VALID;
    }

    public void doLogout(){
        if((this.appUser!=null) && (this.appUser.getUserStatus() == AppUser.STATUS_LOGIN)){
        	//PstAppUser.updateUserStatus(appUser.getOID(), AppUser.STATUS_LOGOUT);
        }
    }


    public void printAppUser(){
        System.out.println(" ==== AppUser ====");
        System.out.println(" user ID = "+ this.appUser.getOID());
        System.out.println(" login ID = "+ this.appUser.getLoginId());
        System.out.println(" employee = "+ this.appUser.getEmployeeId());
        System.out.println(" status = "+ this.appUser.getUserStatus());
    }

    public int uniOrd(String s){
        byte[] bytes = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        bb.order( ByteOrder.LITTLE_ENDIAN);
        int getInt = 0;
        while( bb.hasRemaining()) {
           int v = bb.getInt();
           getInt = v;
        }
        return getInt;
    }
    
    
    public String charEncoding(String s, Charset inCharset, Charset outCharset){
        byte[] bytes = s.getBytes(inCharset);
        return new String(bytes, outCharset);
    }
    
    public int uniOrd2(String s){
//        int ascii =0;
//        String xxx = charEncoding(s, StandardCharsets.UTF_8 , StandardCharsets.UTF_16BE);
//        ascii = uniOrd(xxx);
          char character = s.charAt(0);
          int ascii = (int) character;
        return ascii;
    }
    
    public int encryptNew(String sData, String username){
        int sResult=0;
        //cek password di online database
        ProsesTransferDataBank prosesTransferDataBank = new ProsesTransferDataBank();
        String passwordOnline = prosesTransferDataBank.getDataPasswordUserBank(""+sData);
        int i = 0;
        int nResult = 0;
        int decVal =0;
        String mKey = "CIPOLIBS2000";
        String mKeyGab = sData+""+mKey;
        UCSReader uCSReader = new UCSReader();
        if(!passwordOnline.equals("")){
            if(passwordOnline.equals("hakakses")){
                sResult=2;
            }else if (passwordOnline.equals("databaseeror")){
               sResult=3;
            }else{
                int lengPassword=0;
                for ( int k=0; k < username.length(); k++) {
                    nResult = 0;
                    try{
                        int data=0;
                        try{
                         data= uniOrd2(Character.toString(username.charAt(k)));
                        }catch(Exception ex){
                        }  
                        int key=0;
                        try{
                         key= uniOrd2(Character.toString(mKeyGab.charAt(k)));
                        }catch(Exception ex){
                        }
                        
                        nResult = data + key;
                        if(nResult>255){
                            nResult=nResult-255;
                        }
                        char c = passwordOnline.charAt(k);
                        decVal = (int) c;
                        if(nResult!=decVal){
                            return sResult=1;
                        }
                    }catch(Exception ex){
                        return sResult=1;
                    }
                }
            }
        }else{
            sResult=1;
        }
        return sResult;
    }
    
    
    public String passs(String sData){
        String xxxx = PstAppUser.checkPass(sData);
         for ( int k=0; k < xxxx.length(); k++) {
             char c = xxxx.charAt(k);
             int decVal = (int) c;
             System.out.println(""+decVal);
         }
        return xxxx;
    }
    
    public int reDoLogin(long idUser){
        AppUser user = new AppUser();
        if(idUser!=0){
            user = PstAppUser.fetch(idUser);
            user.setLastLoginIp(this.appUser.getLastLoginIp());
            user.setUserStatus(AppUser.STATUS_LOGIN);
            user.setLastLoginDate(new Date());
            this.appUser = user;
            privObj = PstAppUser.getUserPrivObj(this.appUser.getOID());
            if(privObj==null){
                privObj= new Vector(1,1);
                return DO_LOGIN_GET_PRIV_ERROR;
            }
        }
        return DO_LOGIN_OK;
    }
    
    
}

