/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import java.util.Date;


public class DTaxManagerPhr {

    public static boolean running = false;
    
    public static String statusStart ="";
    
    public static String statusEnd ="";
    public static String statusProses ="";
    
    
    public static DTaxMonitorPhr lck = new DTaxMonitorPhr();
    
    public static int count = 0;
    
    public static int countQuery = 0;
    
    public static int countTotal = 0;

    //private static Hashtable fileTransfer = new Hashtable();
    
    //public DTaxManagerPbb(FileSent fileSent) {
        
    //}

    //public void startMonitor() {
    public static void startTransfer(FileSent fileSent){    
        
        if(running) return;

            Date newDate = new Date();
            
            statusStart="";
            statusEnd="";
            statusProses="";
            count = 0;
            countQuery =0;
            countTotal = 0;
            
            statusStart =" Proses Dimulai  .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
        
            DTaxManagerPhr objMan = new  DTaxManagerPhr();

            Thread thLocker = new Thread(new DTaxMonitorPhr(fileSent));

            thLocker.setDaemon(false);

            running = true;
            
            count=0;
            
            thLocker.start();

    }

    public void stopMonitor() {

        running = false;
        Date newDate = new Date();
        statusEnd =" Proses Selesai  .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
        System.out.println("monitoring stopped .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));

    }

    public boolean getStatus() {

        return running;

    }
    
    public int getCount() {

        return count;

    }
    
    public int getCountQuery() {

        return countQuery;

    }
    
    public int getCountTotal() {

        return countTotal;

    }
    
    
    public String getStart() {

        return statusStart;

    }
    
    
    public String getEnd() {

        return statusEnd;

    }
    
    public String getProses() {

        return statusProses;

    }

}