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


public class dTaxMonitorPaymentPbb implements Runnable {
    
    private FileSent fileSent=null;
    private String Proggess="";
    
    public dTaxMonitorPaymentPbb() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxIntegrationManagerPaymentPbb.running) {
            
            try {
                Date newDay=new Date();
                String startDate = Formater.formatDate(newDay,"yyyy-MM-dd");
				
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				Date prevDay = cal.getTime();
				
				String prevDate =Formater.formatDate(prevDay,"yyyy-MM-dd");
				
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                
                System.out.println("Sinkronisasi data hari ini..");
                if(AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX || AppSetting.TYPE_APP_BACKOFFICE == AppSetting.APP_IPROTAX_V2){
					//dTaxIntegrationMonitor.inputPaymentPBBIproTax(prevDate, "");
                    dTaxIntegrationMonitor.inputPaymentPBBIproTax(startDate, "");
                }else{
                    dTaxIntegrationMonitor.inputPaymentPBB(startDate, "");
                }
                
                Thread.sleep((long) (60000));//milisecond tiap 4 jam = 240 menit
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            //DTaxIntegrationManagerPaymentPbb.running=false;
        }
        System.out.println("stop .... ");
    }
}
