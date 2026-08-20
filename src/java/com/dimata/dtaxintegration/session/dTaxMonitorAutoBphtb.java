/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.webclient.UploadFile;

/**
 *
 * @author IanRizky
 */
public class dTaxMonitorAutoBphtb implements Runnable {
	private FileSent fileSent=null;
    private String Proggess="";
    
    public dTaxMonitorAutoBphtb() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxIntegrationManagerAutoBphtb.running) {
            
            try {
                UploadFile upload = new UploadFile();
                DTaxManagerBphtb.statusAutoUpload = "";
                String result = upload.autoUploadBPHTB();
                
                Thread.sleep((long) (60000));//milisecond tiap 4 jam = 240 menit
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            //DTaxIntegrationManagerPaymentPbb.running=false;
        }
        System.out.println("stop .... ");
    }
}
