package com.dimata.webclient;

public class AppSettingBphtb {
   public static final int DBSVR_MYSQL = 0;
   public static final int DBSVR_POSTGRESQL = 1;
   public static final int DBSVR_SYBASE = 2;
   public static final int DBSVR_ORACLE = 3;
   public static final int DBSVR_MSSQL = 4;
   public static int SQL_VERSION = 4; 
//   public static String IP_BANK_BPD_BPHTB = "http://wsgen1.bpdbali.co.id:99/index.asmx";
//   public static String IP_BANK_BPD_BPHTB = "";
   public static String IP_BANK_BPD_BPHTB = "https://portal.bpdbali.id/ws_bpd_payment/interkoneksi/v1/ws_interkoneksi.php?wsdl";
   public static String KABUPATEN_NAME = "BULELENG";
   public static String USERNAME_BPHTB = "BPHTB_BULELENG";
   public static String PWD_BPHTB = "jf98@Bphtbbll08ds";
   public static String INSTANSI_BPHTB = "BPHTB_BULELENG"; 
   public static String BPHTB_LOCATION_FILE = "C:\\dimata\\File";
   public static String BPHTB_FILE_ZIP_NAME = "BPHTB_BULELENG.zip";
   public static String KABUPATEN = "BULELENG";
   public static int APP_IPROTAX = 1;
   public static int TYPE_APP_BACKOFFICE;

   static {
      TYPE_APP_BACKOFFICE = APP_IPROTAX;
   }
}