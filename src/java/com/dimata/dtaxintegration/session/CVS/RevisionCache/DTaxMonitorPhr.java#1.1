/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import com.dimata.webclient.UploadFile;
import java.util.Date;


public class DTaxMonitorPhr implements Runnable {
    
    private FileSent fileSent=null;
    private String Proggess="";
    
    public DTaxMonitorPhr() {
            
    }
    
    public DTaxMonitorPhr(FileSent fileSent) {
        try{
            this.fileSent = fileSent;
            
            this.Proggess ="";

        }catch(Exception e){
            System.out.println(" ! EXC : initiate thread =  "+e.toString());

        }

    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (DTaxManagerPhr.running) {
            
            try {
                
                UploadFile upload = new UploadFile();
                
                String result = upload.actionPHR(fileSent);  
                
                Date newDate = new Date();
                
                DTaxManagerPhr.statusEnd =" Proses "+result+" datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            DTaxManagerPhr.running=false;
        }
        System.out.println("stop .... ");
    }
}