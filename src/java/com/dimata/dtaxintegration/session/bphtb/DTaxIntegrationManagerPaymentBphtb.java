/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */ 
package com.dimata.dtaxintegration.session.bphtb;

import com.dimata.util.Formater;
import java.util.Date;

public class DTaxIntegrationManagerPaymentBphtb {

    public static boolean running = false;
    public static String status = "";
    public static String code = "";

    public static DTaxIntegrationMonitorBphtb lck = new DTaxIntegrationMonitorBphtb();

    public DTaxIntegrationManagerPaymentBphtb() {

    }

    public void startMonitor() {

        if(running) return;
            DTaxIntegrationManagerPaymentBphtb.status = "";
            DTaxIntegrationManagerPaymentBphtb objMan = new  DTaxIntegrationManagerPaymentBphtb();
            
            Thread thLocker = new Thread(new DTaxMonitorPaymentBphtb());
            thLocker.setDaemon(false);
            thLocker.start();
            
            Thread thLocker2 = new Thread(new DTaxMonitorPaymentStlBuktiBphtb());
            thLocker2.setDaemon(false);
            thLocker2.start();
            
            running = true;
    }

    public void stopMonitor() {
        running = false;
        Date newDate = new Date();
        System.out.println("monitoring stopped .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));
    }

    public boolean getrunning() {
        return running;
    }

    public static String getStatus() {
        return status;
    }
    
    public static String getCode() {
        return code;
    }
}
