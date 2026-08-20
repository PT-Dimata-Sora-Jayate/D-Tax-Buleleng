/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import java.util.Date;

public class DTaxMonitorPaymentBphtb implements Runnable {
    
    private FileSent fileSent=null;
    private String Proggess="";
    
    public DTaxMonitorPaymentBphtb() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxIntegrationManagerPaymentBphtb.running) {
            
            try {
                Date newDay=new Date();
                String startDate = Formater.formatDate(newDay,"yyyy-MM-dd");
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                dTaxIntegrationMonitor.inputPaymentBphtb(startDate, "");
                
                Thread.sleep((long) (2 * 60000));//milisecond tiap 4 jam = 240 menit
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
        }
        System.out.println("stop .... ");
    }
}