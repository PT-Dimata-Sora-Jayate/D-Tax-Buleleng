/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.util.Formater;
import java.util.Date;

/**
 *
 * @author dimata005
 */
public class DTaxManagerAutomaticDataPajakBI {

    public static boolean running = false;
    public static String note = "";
    public static String noteDetail = "";
    public static DTaxManagerAutomaticDataPajakBI lck = new DTaxManagerAutomaticDataPajakBI();

    public DTaxManagerAutomaticDataPajakBI() {

    }

    public void startMonitor() {

        if(running) return;
        
        DTaxManagerAutomaticDataPajakBI objMan = new DTaxManagerAutomaticDataPajakBI();

        Thread thLockerx = new Thread(new DTaxMonitorAutomaticDataPajakBI());

        thLockerx.setDaemon(false);

        running = true;

        thLockerx.start();

    }

    public void stopMonitor() {

        running = false;
        Date newDate = new Date();
        System.out.println("monitoring stopped .... datae/time : " + Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));

    }

    public boolean getStatus() {

        return running;

    }

    public String getNote() {

        return note+""+noteDetail;

    }
}
