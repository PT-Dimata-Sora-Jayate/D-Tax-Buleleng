package com.dimata.dtaxintegration.session.bphtb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */  

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import java.util.Date;

public class DTaxMonitorPaymentStlBuktiBphtb implements Runnable {
    
    private FileSent fileSent=null;
    private String Proggess="";
    
    public DTaxMonitorPaymentStlBuktiBphtb() {
            
    }
     
    public void run() {
        System.out.println("start .... ");
        while (DTaxIntegrationManagerPaymentBphtb.running) {
            try {
                Date newDay=new Date();
                String startDate = Formater.formatDate(newDay,"yyyy-MM-dd");
                DTaxIntegrationMonitorBphtb dTaxIntegrationMonitor = new DTaxIntegrationMonitorBphtb();
                dTaxIntegrationMonitor.inputPaymentBphtbIprotaxStlBukti(startDate, "");
                
                Thread.sleep((long) (2000));//2000 ms = 2 detik
                
            } catch (Exception e) {
                DTaxIntegrationManagerPaymentBphtb.status = "Error Cause : "+e.getMessage();
                DTaxIntegrationManagerPaymentBphtb.running = false;
            }
        }
        System.out.println("stop .... ");
    }
}