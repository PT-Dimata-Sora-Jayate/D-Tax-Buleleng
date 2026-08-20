/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.util.Formater;
import java.util.Date;

/**
 *
 * @author dimata005
 */
public class DTaxManagerAutomaticPhr {
    public static boolean running = false;
    
    public static String note="";
    public static DTaxManagerAutomaticPhr lck = new DTaxManagerAutomaticPhr();

    
    public DTaxManagerAutomaticPhr() {

    }

    public void startMonitor() {

        if(running) return;

            DTaxManagerAutomaticPhr objMan = new  DTaxManagerAutomaticPhr();

            Thread thLocker = new Thread(new DTaxMonitorAutomaticPhr());

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
    
    public String getNote() {

        return note;

    }
}
