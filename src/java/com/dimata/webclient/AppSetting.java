/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.webclient;

/**
 *
 * @author dimata005
 */
public class AppSetting {
    
    public static final int DBSVR_MYSQL = 0;
    public static final int DBSVR_POSTGRESQL = 1;
    public static final int DBSVR_SYBASE = 2;
    public static final int DBSVR_ORACLE = 3;
    public static final int DBSVR_MSSQL = 4;
    
    public static int SQL_VERSION = DBSVR_MSSQL;
    
    public static final int DISPENDA_GIANYAR = 0;
    public static final int DISPENDA_KLUNGKUNG = 1;
    public static final int DISPENDA_TABANAN = 2;
    public static final int DISPENDA_BULELENG = 3;
    
    public static String NAMA_VIEW_BADAN ="nama_badan";
    public static String NAMA_VIEW_ESPTPD ="e_sptpd";
    public static String NAMA_KABUPATEN ="KABUPATEN BULELENG";
    public static String NAMA_BUPATI ="BUPATI BULELENG";
    
    public static int TYPE_KOP_WPONLINE = DISPENDA_TABANAN;
    public static int LAMPIRAN_PRINT = DISPENDA_BULELENG;
    
    public static String REPORT_INSTANSI ="PEMERINTAH KABUPATEN BULELENG";
    public static String REPORT_DINAS ="BADAN PENDAPATAN DAERAH KABUPATEN BULELENG";
    public static String REPORT_INSTANSI_ALAMAT ="Jl. Ngurah Rai No.2, Paket Agung, Kec. Buleleng, Kabupaten Buleleng, Bali 81117 Telepon (0362) 3301977";
    
    public static final int APP_TYPE_GIANYAR=0; //pak nana
    public static final int APP_IPROTAX=1; // aplikasi bangli
    public static final int APP_OPEN_PHR=3; // aplikasi nuka
    public static final int APP_PHRH=4; // aplikasi telematika tabanan
	public static final int APP_IPROTAX_V2=5; // aplikasi telematika tabanan
    
    public static int TYPE_APP_BACKOFFICE=APP_IPROTAX_V2;
    
    //
    ///***JEMBRANA***///
    /*---------------------------------------------------------------------------*/
//    development start 
//    public static String IP_BANK_BPD ="http://192.168.201.98:89/index.asmx?wsdl";
//    
//    public static String USERNAME_PBB ="DIMATA";
//    public static String PWD_PBB ="123456";
//    public static String INSTANSI_PBB ="PBB_BULELENG";
//    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File";
//    public static String PBB_FILE_ZIP_NAME ="PBB_BULELENG.zip";
//    
//    public static String USERNAME_PHR ="PHR_JEMBRANA";
//    public static String PWD_PHR ="123456";
//    public static String INSTANSI_PHR ="PHR_JEMBRANA";
//    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
//    public static String PHR_FILE_ZIP_NAME ="PHR_BANGLI.zip";
//    
//    public static String USERNAME_BPHTB ="BPHTB_JEMBRANA";
//    public static String PWD_BPHTB ="123456";
//    public static String INSTANSI_BPHTB ="BPHTB_JEMBRANA";
//	public static String BPHTB_LOCATION_FILE ="C:\\Dimata\\File";
//    public static String BPHTB_FILE_ZIP_NAME ="BPHTB_JEMBRANA.zip";
//    
//    public static String USERNAME_RETRIBUSI ="RETRIBUSI_JEMBRANA";
//    public static String PWD_RETRIBUSI ="123456";
//    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_JEMBRANA";
//    
//    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    
//    development end
	
	//* produksi start 
//    public static String IP_BANK_BPD ="http://192.168.202.166:99/index.asmx";
//    public static String IP_BANK_BPD ="http://wsgen1.bpdbali.co.id:99/index.asmx";
    public static String IP_BANK_BPD ="";
    
    public static String USERNAME_PBB ="PBB_BULELENG";
    public static String PWD_PBB ="PBB_bUL3L3N613022019";
    public static String INSTANSI_PBB ="PBB_BULELENG";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PBB_FILE_ZIP_NAME ="PBB_BULELENG.zip";
    
    public static String USERNAME_PHR ="PHR_BULELENG";
    public static String PWD_PHR ="123456";
    public static String INSTANSI_PHR ="PHR_BULELENG";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_BULELENG.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_BULELENG";
    public static String PWD_BPHTB ="BPHTBjembran@BPD123";
    public static String INSTANSI_BPHTB ="BPHTB_BULELENG";
	public static String BPHTB_LOCATION_FILE ="C:\\Dimata\\File";
    public static String BPHTB_FILE_ZIP_NAME ="BPHTB_BULELENG.zip";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_BULELENG";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_BULELENG";
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    
    //produksi end*/
    
    /* development start
    public static String IP_BANK_BPD ="http://192.168.201.78:89/index.asmx";
    
    public static String USERNAME_PBB ="PBB_BADUNG";
    public static String PWD_PBB ="123456";
    public static String INSTANSI_PBB ="PBB_BADUNG";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PBB_FILE_ZIP_NAME ="PBB_BADUNG.zip";
    
    public static String USERNAME_PHR ="PHR_GIANYAR";
    public static String PWD_PHR ="gianyar123";
    public static String INSTANSI_PHR ="PHR_GIANYAR";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_GIANYAR.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_BADUNG";
    public static String PWD_BPHTB ="123456";
    public static String INSTANSI_BPHTB ="BPHTB_BADUNG";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_GIANYAR";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_GIANYAR";
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    
    development end*/
    
    /*produksi start 
     
    public static String IP_BANK_BPD ="http://192.168.202.166:99/index.asmx";
    
    public static String USERNAME_PBB ="PBB_GIANYAR";
    public static String PWD_PBB ="gyrpbb2014*";
    public static String INSTANSI_PBB ="PBB_GIANYAR";
    public static String PBB_LOCATION_FILE ="C:\\payment\\file";
    public static String PBB_FILE_ZIP_NAME ="PBB_GIANYAR.zip";
    
    public static String USERNAME_PHR ="PHR_GIANYAR";
    public static String PWD_PHR ="Gianyar0264825";
    public static String INSTANSI_PHR ="PHR_GIANYAR";
    public static String PHR_LOCATION_FILE ="C:\\payment\\file";
    public static String PHR_FILE_ZIP_NAME ="PHR_GIANYAR.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_GIANYAR";
    public static String PWD_BPHTB ="Gianyar0264825";
    public static String INSTANSI_BPHTB ="BPHTB_GIANYAR";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_GIANYAR";
    public static String PWD_RETRIBUSI ="Gianyar0264825";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_GIANYAR";
    
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    produksi end*/
    
    
    
    ///***BANGLI***///
    /*---------------------------------------------------------------------------*/
    /* development start 
    public static String IP_BANK_BPD ="http://192.168.201.78:89/index.asmx";
    
    public static String USERNAME_PBB ="PBB_BANGLI";
    public static String PWD_PBB ="123456";
    public static String INSTANSI_PBB ="PBB_BANGLI";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PBB_FILE_ZIP_NAME ="PBB_BANGLI.zip";
    
    public static String USERNAME_PHR ="PHR_BANGLI";
    public static String PWD_PHR ="123456";
    public static String INSTANSI_PHR ="PHR_BANGLI";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_BANGLI.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_BANGLI";
    public static String PWD_BPHTB ="123456";
    public static String INSTANSI_BPHTB ="BPHTB_BANGLI";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_BANGLI";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_BANGLI";
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    
    /* development end*/
    
    
    
     ///***KLUNGKUNG***///
    /*---------------------------------------------------------------------------*/
    /* development start 
    public static String IP_BANK_BPD ="http://192.168.201.78:89/index.asmx";
    
    public static String USERNAME_PBB ="PBB_BADUNG";
    public static String PWD_PBB ="123456";
    public static String INSTANSI_PBB ="PBB_BADUNG";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PBB_FILE_ZIP_NAME ="PBB_BADUNG.zip";
    
    public static String USERNAME_PHR ="dimata";
    public static String PWD_PHR ="123456";
    public static String INSTANSI_PHR ="PHR_KLUNGKUNG";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_KLUNGKUNG.zip";
    
    public static String USERNAME_ABT ="dimata";
    public static String PWD_ABT ="123456";
    public static String INSTANSI_ABT ="ABT_KLUNGKUNG";
    public static String ABT_LOCATION_FILE ="C:\\Dimata\\File";
    public static String ABT_FILE_ZIP_NAME ="ABT_KLUNGKUNG.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_BADUNG";
    public static String PWD_BPHTB ="123456";
    public static String INSTANSI_BPHTB ="BPHTB_BADUNG";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_KLUNGKUNG";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_KLUNGKUNG";
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    
    development end*/
    
   
    /*produksi start 
     
    public static String IP_BANK_BPD ="http://192.168.202.166:99/index.asmx";
    
    public static String USERNAME_PBB ="PBB_KLUNGKUNG";
    public static String PWD_PBB ="P3B3B3_KLUN6KUN62019";
    public static String INSTANSI_PBB ="PBB_KLUNGKUNG";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PBB_FILE_ZIP_NAME ="PBB_KLUNGKUNG.zip";
    
    public static String USERNAME_PHR ="dimata";
    public static String PWD_PHR ="123456";
    public static String INSTANSI_PHR ="PHR_KLUNGKUNG";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_KLUNGKUNG.zip";
    
    public static String USERNAME_ABT ="dimata";
    public static String PWD_ABT ="123456";
    public static String INSTANSI_ABT ="ABT_KLUNGKUNG";
    public static String ABT_LOCATION_FILE ="C:\\Dimata\\File";
    public static String ABT_FILE_ZIP_NAME ="ABT_KLUNGKUNG.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_KLUNGKUNG";
    public static String PWD_BPHTB ="123456";
    public static String INSTANSI_BPHTB ="BPHTB_KLUNGKUNG";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_KLUNGKUNG";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_KLUNGKUNG";
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
     produksi end*/
    
    
    
     ///***TABANAN***///
    /*---------------------------------------------------------------------------*/
    /* development start 
    public static String IP_BANK_BPD ="http://192.168.201.78:89/index.asmx";
    
    public static String USERNAME_PBB ="PBB_GIANYAR";
    public static String PWD_PBB ="123456";
    public static String INSTANSI_PBB ="PBB_GIANYAR";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File_OpenPHR";
    public static String PBB_FILE_ZIP_NAME ="PBB_GIANYAR.zip";
    
    public static String USERNAME_PHR ="PHR_TABANAN";
    public static String PWD_PHR ="123456";
    public static String INSTANSI_PHR ="PHR_TABANAN";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_TABANAN.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_GIANYAR";
    public static String PWD_BPHTB ="123456";
    public static String INSTANSI_BPHTB ="BPHTB_GIANYAR";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_GIANYAR";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_GIANYAR";
    
    public static String WP_UPLOAD_LOCATION_FILE ="C:\\Dimata\\wpupload";
    
   /*development end*/
    
    /*produksi start
     
    public static String IP_BANK_BPD ="http://192.168.202.166:99/index.asmx";
    
    public static String USERNAME_PBB ="PBB_GIANYAR";
    public static String PWD_PBB ="123456";
    public static String INSTANSI_PBB ="PBB_GIANYAR";
    public static String PBB_LOCATION_FILE ="C:\\Dimata\\File_OpenPHR";
    public static String PBB_FILE_ZIP_NAME ="PBB_GIANYAR.zip";
    
    public static String USERNAME_PHR ="PHR_TABANAN";
    public static String PWD_PHR ="PHRtabanan123";
    public static String INSTANSI_PHR ="PHR_TABANAN";
    public static String PHR_LOCATION_FILE ="C:\\Dimata\\File";
    public static String PHR_FILE_ZIP_NAME ="PHR_TABANAN.zip";
    
    public static String USERNAME_BPHTB ="BPHTB_GIANYAR";
    public static String PWD_BPHTB ="123456";
    public static String INSTANSI_BPHTB ="BPHTB_GIANYAR";
    
    public static String USERNAME_RETRIBUSI ="RETRIBUSI_GIANYAR";
    public static String PWD_RETRIBUSI ="123456";
    public static String INSTANSI_RETRIBUSI ="RETRIBUSI_GIANYAR";
    
    public static String WP_UPLOAD_LOCATION_FILE ="/home/dimata/jvm/apache-tomcat-7.0.75/domains/intan.dimatasystem.com/ROOT/wpupload/document";
    //public static String WP_UPLOAD_LOCATION_FILE ="D:\\Diani Opiari\\Project\\Java\\2016\\dTaxIntegration_2016\\build\\web\\wpupload\\document";
    produksi end*/
}
