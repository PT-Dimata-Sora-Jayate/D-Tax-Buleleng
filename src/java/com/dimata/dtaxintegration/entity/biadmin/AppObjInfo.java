/*
 * AppObjInfo.java
 *
 * Created on April 3, 2002, 4:09 PM
 * Modified on November 27, 2002, 10:14 AM by karya
 */

package com.dimata.dtaxintegration.entity.biadmin;

import java.util.*;

/**
 *
 * @author  ktanjana
 * @version
 * @Purpose Describe application object as binary coded (integer)
 * @CodeMapping
 * bit 0 - 7   : command CMD
 * bit 8 - 15  : page , menu or other objects  OBJ
 * bit 16 - 23 :  level 2 sub-application G2
 * bit 24 - 31 :  level 1 sub-application G1
 */
public class AppObjInfo {
    
    /** Creates new AppObjInfo */
    public AppObjInfo() {
    }
    
    // filter code (contain of 32 bit)
    public static final int FILTER_CODE_G1= 0xFF000000;
    public static final int FILTER_CODE_G2= 0x00FF0000;
    public static final int FILTER_CODE_OBJ=0x0000FF00;
    public static final int FILTER_CODE_CMD=0x000000FF;
    
    public static final int SHIFT_CODE_G1= 24;   // untuk shift sampai 24 bit ke kiri dari belakang, sehingga kita mendapatkan 8 bit pertama/0xFF (G1)
    public static final int SHIFT_CODE_G2= 16;   // untuk shift sampai 16 bit ke kiri dari belakang, sehingga kita mendapatkan 8 bit pertama/0x00FF (G2)
    public static final int SHIFT_CODE_OBJ=8;    // untuk shift sampai 8 bit ke kiri dari belakang, sehingga kita mendapatkan 8 bit pertama/0x0000FF (OBJ)
    //public static final int SHIFT_CODE_CMD=0;
    
    
    // OBJECT COMMAND
    public static final int COMMAND_VIEW    = 0;
    public static final int COMMAND_ADD     = 1;
    public static final int COMMAND_UPDATE  = 2;
    public static final int COMMAND_DELETE  = 3;
    public static final int COMMAND_PRINT   = 4;
    public static final int COMMAND_SUBMIT  = 5;
    public static final int COMMAND_START   = 6;
    public static final int COMMAND_STOP    = 7;
    public static final int COMMAND_APPROVE = 8;
    public static final int COMMAND_VIEW_VALUE = 9; //update opie-eyek 20131201
    public static final int COMMAND_VIEW_STOCK = 10; //update opie-eyek 20131201
    public static final int COMMAND_FINAL = 11;
    public static final int COMMAND_UPLOAD = 12;
    public static final int COMMAND_DOWNLOAD = 13;
    
    /** untuk membatasi informasi yang ditampilkan */
   // public static final int SHOW_ALL_INFO   = 8;
    
    public static final String[] strCommand = {
        "View", "Add New", "Update", "Delete", "Print", "Submit","Start", "Stop", "Approve","View Price","View Stock","Final","Upload","Download" //update opie-eyek 20131201
    };
    
    // *** Application Structure ****** //
    public static final int G1_LOGIN = 0;
    /**/public static final int G2_LOGIN = 0;
    /******/public static final int OBJ_LOGIN_LOGIN = 0;
    /******/public static final int OBJ_LOGIN_LOGOUT = 1;
    
     public static final int G1_ADMIN = 1;
    /**/public static final int G2_ADMIN_USER = 0;
    /******/public static final int OBJ_ADMIN_USER_PRIVILEGE = 0;
    /******/public static final int OBJ_ADMIN_USER_GROUP = 1;
    /******/public static final int OBJ_ADMIN_USER_USER = 2;
    
    /**/public static final int G2_ADMIN_SYSTEM = 1;
    /******/public static final int OBJ_ADMIN_SYSTEM_BACK_UP = 0;
    /******/public static final int OBJ_ADMIN_SYSTEM_APP_SET = 1;
    /******/public static final int OBJ_ADMIN_SYSTEM_TRANSFER_DATA = 2;
    /******/public static final int OBJ_ADMIN_SYSTEM_RESTORE_DATA = 3;
    /******/public static final int OBJ_ADMIN_SYSTEM_CLOSING_PERIOD = 4;
    
    public static final int G1_PENDAPATAN_PER_JENIS_PAJAK = 2;
    /**/public static final int G2_PENCAPAIAN_HARI_INI = 0;
    /******/public static final int OBJ_PENCAPAIAN_HARI_INI = 0;
    
    /**/public static final int G2_PENCAPAIAN_PADA_BULAN = 1;
    /******/public static final int OBJ_PENCAPAIAN_PADA_BULAN = 0;
    
    /**/public static final int G2_PERBANDINGAN_2_TAHUN = 2;
    /******/public static final int OBJ_PERBANDINGAN_2_TAHUN = 0;
    
    /**/public static final int G2_PERKEMBANGAN_3_TAHUN = 3;
    /******/public static final int OBJ_PERKEMBANGAN_3_TAHUN = 0;
    
    /**/public static final int G2_PROYEKSI_PENDAPATAN = 4;
    /******/public static final int OBJ_PROYEKSI_PENDAPATAN = 0;
    
    public static final int G1_PENDAPATAN_PHR_DETAIL = 3;
    /**/public static final int G2_KOMPOSISI_PHR = 0;
    /******/public static final int OBJ_KOMPOSISI_PHR = 0;
    
    public static final int G1_PENDAPATAN_PER_WP = 4;
    /**/public static final int G2_TOP_10_WAJIB_PAJAK = 0;
    /******/public static final int OBJ_TOP_10_WAJIB_PAJAK = 0;
    
    public static final int G1_PER_AREA_WP = 5;
    /**/public static final int G2_PER_KECAMATAN = 0;
    /******/public static final int OBJ_PER_KECAMATAN = 0;
    
    /**/public static final int G2_PER_DESA_TOP_20 = 1;
    /******/public static final int OBJ_PER_DESA_TOP_20 = 0;
    
    public static final int G1_PERENCANAAN = 6;
    /**/public static final int G2_INPUT_TARGET = 0;
    /******/public static final int OBJ_INPUT_TARGET = 0;
    
    /**/public static final int G2_TAMPILKAN_TARGET = 1;
    /******/public static final int OBJ_TAMPILKAN_TARGET = 0;
    
    public static final int G1_DATA_PAJAK = 7;
    /**/public static final int G2_MANUAL_DATA_PAJAK = 0;
    /******/public static final int OBJ_MANUAL_DATA_PAJAK = 0;
    
    /**/public static final int G2_OTOMATIS_DATA_PAJAK = 1;
    /******/public static final int OBJ_OTOMATIS_DATA_PAJAK = 0;
    
    
    
    
    public static final String[] titleG1 = {
        "Login Access",
        "Admin",
        "Pendapatan Per Jenis Pajak",
        "Pendapatan PHR Detail",
        "Pendapatan Per Wajib Pajak",
	"Per Area WP",
	"Perencanaan",
	"Data Pajak"
    };
    
    
    public static final String[][] titleG2 = {
        /* login */ {"Login Access"},
        /* admin */ {"User Management", "System Management"},
        /* Chart Perjenis Pajak */ {"Pencapaian Hari Ini","Pencapaian Pada Bulan","Perbandingan 2 Tahun","Perbandingan 3 Tahun", "Proyeksi Pendapatan"},
        /* Chart PHR Detail */{"Komposisi PHR"},
        /* Chart Per WP */ {"TOP 10 Wajib Pajak"},
	/* Chart Area WP */ {"Per Kecamatan", "Per Desa (Top 20)"},
	/* Perencanaan */ {"Input Target", "Tampilkan Target"},
	/* Data Pajak */ {"Manual Data Pajak", "Otomatis Data Pajak"}
    };
    
    
    public static final String[][][] objectTitles = {
        // Login
        {   // Login
            {"Login Page", "Logout page"}
        },
        // Admin
        {   // User
            {"Pivilege", "Group", "User"},
            // System
            {"Data Backup", "Application Setting", "Transfer Data", "Restore Data", "Closing Period"}
        },
	
	//Pendapatan Per Jenis Pajak
        {   // Pencapaian Hari Ini
            {"Pencapaian Hari Ini"},
            // Pencapaian Pada Bulan
            {"Pencapaian Pada Bulan"},
            // Perbandingan 2 Tahun
            {"Perbandingan 2 Tahun"},
            // Perkembangan 3 Tahun
            {"Perkembangan 3 Tahun"},
	    // Proyeksi Pendaptan
	    {"Proyeksi Pendapatan"}
        },
	
	//Pendapatan PHR Detail
        {   // Komposisi PHR
            {"Komposisi PHR"}
        },
	
	//Pendapatan Per WP
        {
            {"Top 10 Wajib Pajak"}
        },
	
	//Per Area WP
	{
	    {"Per Kecamatan"},
	    {"Per Desa (Top 20)"}
	},
	
	//Perencanaan
	{
	    {"Input Target"},
	    {"Tampilkan Target"}
	},
	
	//DATA PAJAK
	{
	    {"Manual Data Pajak"},
	    {"Otomatis Data Pajak"}
	}
	    
    };
    
    
    public static final int[][][][] objectCommands = {
        // Login
        {   // Login
            {
                //Login Page
                {COMMAND_VIEW, COMMAND_SUBMIT} ,
                //"Logout page"
                {COMMAND_VIEW, COMMAND_SUBMIT}
            }
        },
        
        // Admin
        {   // user
            {
                //"Pivilege"
                {COMMAND_VIEW, COMMAND_ADD, COMMAND_DELETE, COMMAND_UPDATE},
                //"Group"
                {COMMAND_VIEW, COMMAND_ADD, COMMAND_DELETE, COMMAND_UPDATE},
                //"User"
                {COMMAND_VIEW, COMMAND_ADD, COMMAND_DELETE, COMMAND_UPDATE}
            },
            // system
            {
                //"Data Backup"
                {COMMAND_VIEW, COMMAND_START, COMMAND_STOP},
                //"Application Setting"
                {COMMAND_VIEW, COMMAND_ADD, COMMAND_UPDATE, COMMAND_DELETE},
                // Transfer Data
                {COMMAND_VIEW, COMMAND_START},
                // Restore Data
                {COMMAND_VIEW, COMMAND_START},
                // Closing Period
                {COMMAND_VIEW, COMMAND_START}
            }
        },
        
        {   // PENDAPATAN PER JENIS PAJAK
            {
                //"Pencapaian Hari Ini"
                {COMMAND_VIEW}
	    },
	    {
		//Pencapaian Pada Bulan
                {COMMAND_VIEW}
	    },
	    {
		//Perbandingan 2 Tahun
                {COMMAND_VIEW}
	    },
	    {
		//Perbandingan 3 Tahun
                {COMMAND_VIEW}
	    },
	    {
		//Peroyeksi Pendapatan
                {COMMAND_VIEW}
	    }
           
	},
	{
	    //Pendapatan PHR Detail
	    {
		//"Komposisi PHR"
		{COMMAND_VIEW}
	    }
	},
	{
	    //Pendapatan Per WP
	    {
		{COMMAND_VIEW}
	    }
	},
	{   
	    //Per Area WP
            {
		//Per Kecamatan
                {COMMAND_VIEW}
	    },
	    {
		//Per Desa (Top 20)
		{COMMAND_VIEW}
            }
	},
	{    
	    //PERENCANAAN
	    {
		//Input Target
		{COMMAND_VIEW, COMMAND_ADD, COMMAND_UPDATE}
	    },
	    {
		//Tampilkan Target
		{COMMAND_VIEW}
	    }
	},
	{
	    //Data Pajak
	    {
		{COMMAND_VIEW, COMMAND_DOWNLOAD}
	    },
	    {
		{COMMAND_VIEW, COMMAND_START, COMMAND_STOP}
	    }
        }
    };
    
    
    public static String getStrCommand(int command){
        if((command<0) || (command > strCommand.length) ){
            System.out.println(" ERR: getStrCommand - commmand out of range");
            return "";
        }
        return strCommand[command];
        
    }
    
    public static boolean existObject(int g1, int g2, int objIdx){
        if( (g1<0) || (g1> titleG1.length)){
            System.out.println(" ERR: composeCode g1 out of range");
            return false;
        }
        
        if((g2<0) || (g2 > (titleG2[g1]).length))  {
            System.out.println(" ERR: composeCode g2 out of range");
            return false;
        }
        
        if((objIdx<0) || (objIdx> (objectTitles[g1][g2]).length)){
            System.out.println(" ERR: composeCode objIdx out of range");
            return false;
        }
        
        return true;
    }
    
    public static int composeCode(int g1, int g2, int objIdx, int command) {
        if(!existObject(g1,g2, objIdx))
            return -1;
        
        if((command<0) || (command > strCommand.length)){
            System.out.println(" ERR: composeCode commmand out of range");
            return -1;
        }
        
        if(!privExistCommand(g1,g2, objIdx, command)){
            System.out.println(" ERR: composeCode commmand out not exist on object "+
            getTitleGroup1(g1)+"-"+getTitleGroup2(g2)+"-"+getTitleObject(objIdx));
            return -1;
        }
        
        return (g1 << SHIFT_CODE_G1) + (g2 << SHIFT_CODE_G2) + (objIdx << SHIFT_CODE_OBJ ) + command;
    }
    
    public static int composeCode(int objCode, int command) {
        if((command<0) || (command > strCommand.length) ){
            System.out.println(" ERR: composeCode commmand out of range");
            return -1;
        }
        //System.out.println("objCode + command ="+objCode + command);
        return objCode + command;
    }
    
    public static int composeObjCode(int g1, int g2, int objIdx) {
        if(!existObject(g1,g2, objIdx))
            return -1;
        
        return (g1 << SHIFT_CODE_G1) + (g2 << SHIFT_CODE_G2) + (objIdx << SHIFT_CODE_OBJ);
    }
    
   public static int composeObjCode(int g1, int g2) {
        if ((g1 < 0) || (g1 > titleG1.length)) {
            System.out.println(" ERR: composeCode g1 out of range");
            return -1;
        }

        if ((g2 < 0) || (g2 > (titleG2[g1]).length)) {
            System.out.println(" ERR: composeCode g2 out of range");
            return -1;
        }

        return (g1 << SHIFT_CODE_G1) + (g2 << SHIFT_CODE_G2) ;
    }
    
      public static int composeObjCode(int g1) {
            if ((g1 < 0) || (g1 > titleG1.length)) {
                System.out.println(" ERR: composeCode g1 out of range");
                return -1;
            }

            return (g1 << SHIFT_CODE_G1) ;
        }    
    
    private static boolean privExistCommand(int g1, int g2, int objIdx, int command){
        for(int i=0; i< objectCommands[g1][g2][objIdx].length;i++){
            if(objectCommands[g1][g2][objIdx][i]==command)
                return true;
        }
        return false;
    }
    
    public static boolean existCommand(int g1, int g2, int objIdx, int command){
        if(!existObject(g1,g2, objIdx))
            return false;
        
        return privExistCommand(g1,g2, objIdx, command);
    }
    
    public static int getG1G2ObjIdx(int code){
        return (code & (FILTER_CODE_G1 + FILTER_CODE_G2 + FILTER_CODE_OBJ));
    }
    
    public static int getCommand(int code){
        return (code & FILTER_CODE_CMD);
    }
    
    public static int getIdxGroup1(int code){
        int g1 = (code & FILTER_CODE_G1) >> SHIFT_CODE_G1;
        if( (g1<0) || (g1> titleG1.length)){
            System.out.println(" ERR: getIdxGroup1 g1 on code out of range");
            return -1;
        }
        return g1;
    }
    
    public static String getTitleGroup1(int code){
        int g1 = getIdxGroup1(code);
        if(g1<0)
            return "";
        
        return titleG1[g1];
    }
    
    public static int getIdxGroup2(int code){
        int g1 = getIdxGroup1(code);
        if(g1<0)
            return -1;
        
        int g2 = (code & FILTER_CODE_G2) >> SHIFT_CODE_G2;
        if( (g2<0) || (g2> titleG2[g1].length)){
            System.out.println(" ERR: getIdxGroup2 g2 on code out of range");
            return -1;
        }
        return g2;
    }
    
    public static String getTitleGroup2(int code){
        int g1 = getIdxGroup1(code);
        if(g1<0)
            return "";
        
        int g2 = getIdxGroup2(code);
        if(g2<0)
            return "";
        
        return titleG2[g1][g2];
    }
    
    public static int getIdxObject(int code){
        int g1 = getIdxGroup1(code);
        if(g1<0)
            return -1;
        
        int g2 = getIdxGroup2(code);
        if(g2<0)
            return -1;
        
        int oidx = (code & FILTER_CODE_OBJ) >> SHIFT_CODE_OBJ;
        if( (oidx<0) || (oidx> objectTitles[g1][g2].length)){
            System.out.println(" ERR: getIdxObject, oidx on code out of range");
            return -1;
        }
        return oidx;
    }
    
    public static String getTitleObject(int code){
        int g1 = getIdxGroup1(code);
        if(g1<0)
            return "";
        
        int g2 = getIdxGroup2(code);
        if(g2<0)
            return "";
        
        int oidx = getIdxObject(code);
        if(oidx<0)
            return "";
        
        return objectTitles[g1][g2][oidx];
    }
    
    /*
     * parse privobj code into title/string of g1, g2, objidx and command
     * return Vector of String: 0=g1, 1=g, 2=objIdx, 3=command, 4=Integer error code (0=false, -1=falses),
     *
     */
    public static Vector parseStringCode(int code){
        Vector titleCodes= new Vector(4,1);
        titleCodes.add(new String(""));
        titleCodes.add(new String(""));
        titleCodes.add(new String(""));
        titleCodes.add(new String(""));
        titleCodes.add(new Integer(0));
        
        int g1 = getIdxGroup1(code);
        if(g1<0){
            titleCodes.set(0, "Invalid G1 Idx");
            titleCodes.set(4, new Integer(-1));
            return titleCodes;
        }
        titleCodes.set(0, titleG1[g1]);
        
        int g2 = getIdxGroup2(code);
        if(g2<0){
            titleCodes.set(1, "Invalid G2 Idx");
            titleCodes.set(4, new Integer(-1));
            return titleCodes;
        }
        titleCodes.set(1, titleG2[g1][g2]);
        
        int oidx = getIdxObject(code);
        if(oidx<0){
            titleCodes.set(2, "Invalid Obj. Idx");
            titleCodes.set(4, new Integer(-1));
            return titleCodes;
        }
        titleCodes.set(2, objectTitles[g1][g2][oidx]);
        
        int cmd = getCommand(code);
        if(cmd<0){
            titleCodes.set(3, "Invalid Command");
            titleCodes.set(4, new Integer(-1));
            return titleCodes;
        }
        titleCodes.set(3, strCommand[cmd]);
        
        return titleCodes;
    }
    
}
