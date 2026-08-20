/*
 * SessSystemProperty.java
 *
 * Created on April 30, 2002, 10:11 AM
 */

package com.dimata.common.session.system;

import com.dimata.common.entity.system.*;

public class SessSystemProperty {


    public static boolean loaded      = false;
    public static String[] groups = {"APPLICATION SETUP"};    
    public static String[][] subGroups = {     
        {"Application"}        
    };

    
    /**
     *  static and permanent system property should be hard coded here
     */
    public static final String PROP_APPURL      =  "http://192.168.0.10:8080"; //own
	//public static final String PROP_APPURL      =  "http://192.168.0.16:8080";//server

    /**
     *  loadable properties are loaded here
     */    
  /*  public static String ADMIN_EMAIL        = "Not initialized";*/
 
    public static String PROP_IMGCACHE         = "";//"C:\\tomcat\\webapps\\prochain\\imgchace\\";
    public static String MATERIAL_PERIOD       = "0";//MATERIAL_PERIOD";
    public static String LOC_TRANS_ID          = "0";
    public static String NO_COLOR_ID           = "0";
    public static String FINISH_ID             = "0";
    public static String UNFINISH_ID           = "0";
    public static String TARITA_ID             = "0";
    public static String COST_GROUP_TARITA_ID  = "0";
    

    /** Creates new SessSystemProperty */
    public SessSystemProperty() {
        if(!loaded) {            
            boolean ok = loadFromDB();
            String okStr = "OK";
            if(!ok) okStr = "FAILED";
            System.out.println("Loading system proerties ............................. ["+ okStr +"]");
            loaded = true;
        }
    } 
    
    
    public boolean loadFromDB() {
        try {

            PROP_IMGCACHE    = PstSystemProperty.getValueByName("PROP_IMGCACHE");
            LOC_TRANS_ID	 = PstSystemProperty.getValueByName("LOC_TRANS_ID");
            NO_COLOR_ID      = PstSystemProperty.getValueByName("NO_COLOR_ID");
            FINISH_ID      = PstSystemProperty.getValueByName("FINISH_PACKED_ID");
            UNFINISH_ID     = PstSystemProperty.getValueByName("UNFINISH_ID");
            //TARITA_ID     = PstSystemProperty.getValueByName("TARITA_ID");
            TARITA_ID     = PstSystemProperty.getValueByName("COMPANY_ID");
            //COST_GROUP_TARITA_ID = PstSystemProperty.getValueByName("COST_GROUP_TARITA_ID");
            COST_GROUP_TARITA_ID = PstSystemProperty.getValueByName("COST_GROUP_COMPANY_ID");
            
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    
    
    
    public static void main(String[] args) {
        SessSystemProperty prop = new SessSystemProperty();
    }


}
