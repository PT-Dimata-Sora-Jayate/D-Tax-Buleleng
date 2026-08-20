/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.UploadFile;
import java.util.Date;

/**
 *
 * @author IanRizky
 */
public class dTaxMonitorAutoPbb implements Runnable {
	private FileSent fileSent=null;
    private String Proggess="";
    
    public dTaxMonitorAutoPbb() {
            
    }
	
	public dTaxMonitorAutoPbb(FileSent fileSent) {
        try{
            this.fileSent = fileSent;
            
            this.Proggess ="";

        }catch(Exception e){
            System.out.println(" ! EXC : initiate thread =  "+e.toString());

        }

    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxIntegrationManagerAutoPbb.running) {
            
            try {
                UploadFile upload = new UploadFile();
                DTaxManagerPbb.statusAutoUpload = "";
                String result = upload.autoUploadPBB(fileSent);
                
                Thread.sleep((long) (60000));//milisecond tiap 4 jam = 240 menit
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            //DTaxIntegrationManagerPaymentPbb.running=false;
        }
        System.out.println("stop .... ");
    }
}
