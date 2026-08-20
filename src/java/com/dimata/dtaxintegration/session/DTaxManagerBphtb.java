/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import java.util.Date;

/**
 *
 * @author xml
 */

public class DTaxManagerBphtb {

    public static boolean running = false;
	
	public static String statusStart ="";
    
    public static String statusEnd ="";
    public static String statusProses ="";
	
	public static int count = 0;
    
    public static int countQuery = 0;
    
    public static int countTotal = 0;
    
    public static DTaxMonitorBphtb lck = new DTaxMonitorBphtb();
	
	public static String resStatus="";
	
	public static String statusAutoUpload = "";

    
    public DTaxManagerBphtb() {

    }
	
	public static void startTransfer(FileSent fileSent){    
        
        if(running) return;

            Date newDate = new Date();
            
            statusStart="";
            statusEnd="";
            statusProses="";
            count = 0;
            countQuery =0;
            countTotal = 0;
            
            statusStart =" Proses Dimulai  .... date/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
        
            DTaxManagerBphtb objMan = new  DTaxManagerBphtb();

            Thread thLocker = new Thread(new DTaxMonitorBphtb(fileSent));

            thLocker.setDaemon(false);

            running = true;
            
            count=0;
            
            thLocker.start();

    }

    public void startMonitor() {

        if(running) return;

            DTaxManagerBphtb objMan = new  DTaxManagerBphtb();

            Thread thLocker = new Thread(new DTaxMonitorBphtb());

            thLocker.setDaemon(false);

        running = true;
       
        thLocker.start();

    }





    public void stopMonitor() {

        running = false;
        Date newDate = new Date();
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
	
	public String getResponStatus() {

        return resStatus;

    }
	
	public String getStatusAutoUpload() {

        return statusAutoUpload;

    }

}