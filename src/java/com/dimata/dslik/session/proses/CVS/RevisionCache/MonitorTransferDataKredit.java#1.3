/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

import com.dimata.util.Formater;
import java.util.Date;

/**
 *
 * @author dimata005
 */
public class MonitorTransferDataKredit implements Runnable {
     private String Proggess="";
    
    public MonitorTransferDataKredit() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (ManagerTransferDataKredit.running) {
            
            try {
                
                /*proses transfer*/
                ProsesTransferDataBank prosesTransferDataBank = new ProsesTransferDataBank();
                //ManagerTransferData xx =  new ManagerTransferData();
                //cek periode berjalan
                ManagerTransferDataKredit.setStatusProses("Start Periode <br>");
                long periodeId = 0;
                try{
                    periodeId = prosesTransferDataBank.cekOidPeriode("",2);
                }catch(Exception ex){
                }
                
                //Cek jumlah data
                int countKredit = prosesTransferDataBank.countTransferDataKredit("",periodeId);
                
                ManagerTransferDataKredit.setStatusProses("Kredit :"+countKredit+" <br>");
                
                ManagerTransferDataKredit.setStatusProses("Get Kredit <br>");
                String kredit = prosesTransferDataBank.actionTransferDataKredit("",periodeId,countKredit,0);
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            
            Date newDate = new Date();
            ManagerTransferDataKredit.statusEnd =" Proses Berakhir  .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
            ManagerTransferDataKredit.running=false;
        }
        System.out.println("stop .... ");
    }
    
}
