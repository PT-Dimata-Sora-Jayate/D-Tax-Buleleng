/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.common.session.email.SessEmail;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import com.dimata.webclient.UploadFile;
import java.util.Date;

/**
 *
 * @author xml
 */
public class DTaxMonitorBphtb implements Runnable {
    
	private FileSent fileSent=null;
    private String Proggess="";
	
    public DTaxMonitorBphtb() {

    }
	
	public DTaxMonitorBphtb(FileSent fileSent) {
        try{
            this.fileSent = fileSent;
            
            this.Proggess ="";

        }catch(Exception e){
            System.out.println(" ! EXC : initiate thread =  "+e.toString());

        }

    }
    
    /*public void run() {

        System.out.println("start .... ");

    
        while (DTaxManagerBphtb.running) {
            
            try {
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                dTaxIntegrationMonitor.sentAutoBphtb("");               
                Thread.sleep((long) (5 * 60000));//milisecond tiap 4 jam = 240 menit
               
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
        }
        System.out.println("stop .... ");
    }*/
	
	public void run() {

        System.out.println("start .... ");
    
        while (DTaxManagerBphtb.running) {
            
            try {
                
                UploadFile upload = new UploadFile();
                
                String result = upload.actionBPHTB(fileSent);  
                
                Date newDate = new Date();
                
                DTaxManagerBphtb.statusEnd =" Proses "+result+" date/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
				
				String message = "Dear Team, Berikut hasil proses pengiriman tagihan<br><br>";
				DTaxManagerBphtb dTaxManagerBphtb = new DTaxManagerBphtb();
				message+=dTaxManagerBphtb.getProses()+"<br>";
				message+=dTaxManagerBphtb.getEnd()+"<br><br>";
				message+="<small>"+dTaxManagerBphtb.getResponStatus()+"</small>"+result+dTaxManagerBphtb.getCountTotal()+"<br>Terima Kasih";
				
				String subject = "";
				if (dTaxManagerBphtb.getResponStatus().equals("00")){
					subject+="[BERHASIL]";
				} else {
					subject+="[GAGAL]";
				}
				subject+=" Notifikasi Pengiriman Integrasi Pajak BPHTB BPHTB_BADUNG_"+Formater.formatDate(new Date(), "yyyyMMdd");
				
				SessEmail sessEmail = new SessEmail();
				
				String resultEmail = sessEmail.sendEamil("notifikasipajak@bpdbali.co.id", subject, message);
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            DTaxManagerBphtb.running=false;
        }
        System.out.println("stop .... ");
    }
	
	
}
