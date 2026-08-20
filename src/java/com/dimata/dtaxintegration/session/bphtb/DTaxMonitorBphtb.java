/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package com.dimata.dtaxintegration.session.bphtb;

import com.dimata.common.session.email.SessEmail;
import com.dimata.common.session.email.blangkoEmail;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.AppSettingBphtb;
import com.dimata.webclient.UploadFile;
import com.dimata.webclient.bphtb.UploadFileBphtb;
import java.util.Date;

/**
 *
 * @author xml
 */
public class DTaxMonitorBphtb implements Runnable {
    private FileSent fileSent = null;
    private String Proggess = "";
    
    public DTaxMonitorBphtb() {

    }
    
    public DTaxMonitorBphtb(FileSent fileSent) {
        try {
            this.fileSent = fileSent;
            this.Proggess = "";
        } catch (Exception e) {
          System.out.println(" ! EXC : initiate thread =  " + e.toString());
        } 
    }
    
    public void run() {
        System.out.println("start .... ");
        while (DTaxManagerBphtb.running) { 
            try {
                UploadFileBphtb upload = new UploadFileBphtb();
                String result = upload.actionBPHTB(this.fileSent);
                Date newDate = new Date();
                DTaxManagerBphtb.statusEnd = " Proses " + result + " date/time : " + Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
                String message = "Dear Team, Berikut hasil proses pengiriman tagihan<br><br>";
                DTaxManagerBphtb dTaxManagerBphtb = new DTaxManagerBphtb();
                message = message + dTaxManagerBphtb.getProses() + "<br>";
                message = message + dTaxManagerBphtb.getEnd() + "<br><br>";
                message = message + "Jumlah Tagihan " + result + dTaxManagerBphtb.getCountTotal() + "<br>Terima Kasih";
                String subject = "";
                if (DTaxManagerBphtb.getCode().equals("00")) {
                  subject = "[BERHASIL]";
                } else {
                  subject = "[GAGAL]"; 
                } 
                subject += " Notifikasi Pengiriman Integrasi Pajak BPHTB Kabupaten Buleleng";
                SessEmail sessEmail = new SessEmail();
                blangkoEmail bEmail = new blangkoEmail();
                String messages = bEmail.blangkoEmail(""+DTaxManagerBphtb.getCode(), message, ""+dTaxManagerBphtb.getCountTotal(), AppSettingBphtb.KABUPATEN);
                String str1 = sessEmail.sendEamil("wirasubawa12@gmail.com", subject, messages);
            } catch (Exception e) { 
                System.out.println("Interrupted " + e); 
                DTaxManagerBphtb.statusProses += e.getMessage();
                DTaxManagerBphtb.running = false;
            } 
            DTaxManagerBphtb.running = false;
        } 
        System.out.println("stop .... ");
  }
}
