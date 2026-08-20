/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author gndiw
 */
public class dTaxMonitorPaymentPbbYesterday implements Runnable {
    
    private FileSent fileSent=null;
    private String Proggess="";
    
    public dTaxMonitorPaymentPbbYesterday() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxIntegrationManagerPaymentPbbYesterday.running) {
            
            try {
                Date newDay=new Date();
                String startDate = Formater.formatDate(newDay,"yyyy-MM-dd");
				
				
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -1);
                Date prevDay = cal.getTime();

                String prevDate =Formater.formatDate(prevDay,"yyyy-MM-dd");
				
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                
                System.out.println("Sinkronisasi data kemarin..");
                if(AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX || AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX_V2){
                        dTaxIntegrationMonitor.inputPaymentPBBIproTax(prevDate, "");
                }
                
                Thread.sleep((long) (12000000));//milisecond tiap 4 jam = 240 menit
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            //DTaxIntegrationManagerPaymentPbb.running=false;
        }
        System.out.println("stop .... ");
    }
}
