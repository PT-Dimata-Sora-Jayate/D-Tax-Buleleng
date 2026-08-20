/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import com.dimata.webclient.UploadFile;
import java.util.Date;


public class DTaxMonitorPbb implements Runnable {
    
    private FileSent fileSent=null;
    private String Proggess="";
    
    public DTaxMonitorPbb() {
            
    }
    
     public DTaxMonitorPbb(FileSent fileSent) {
        try{
            this.fileSent = fileSent;
            
            this.Proggess ="";

        }catch(Exception e){
            System.out.println(" ! EXC : initiate thread =  "+e.toString());

        }

    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxManagerPbb.running) {
            
            try {
                
                UploadFile upload = new UploadFile();
                
                String result = upload.actionPBB(fileSent);  
                
                Date newDate = new Date();
                
                DTaxManagerPbb.statusEnd =" Proses "+result+" datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            DTaxManagerPbb.running=false;
        }
        System.out.println("stop .... ");
    }
}
