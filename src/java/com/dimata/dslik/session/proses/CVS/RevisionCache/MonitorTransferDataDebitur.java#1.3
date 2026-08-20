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
public class MonitorTransferDataDebitur implements Runnable {
     private String Proggess="";
    
    public MonitorTransferDataDebitur() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (ManagerTransferDataDebitur.running) {
            
            try {
                
                /*proses transfer*/
                ProsesTransferDataBank prosesTransferDataBank = new ProsesTransferDataBank();
                //cek periode berjalan
                ManagerTransferDataDebitur.setStatusProses("Start Periode <br>");
                long periodeId = 0;
                try{
                    periodeId = prosesTransferDataBank.cekOidPeriode("",1);
                }catch(Exception ex){
                }
                
                //Cek jumlah data
                int countDebitur = prosesTransferDataBank.countTransferDataDebitur("",periodeId);
                
                ManagerTransferDataDebitur.setStatusProses("Debitur :"+countDebitur+" <br>");
                
                ManagerTransferDataDebitur.setStatusProses("Get Debitur <br>");
                
                String debitur = prosesTransferDataBank.actionTransferDataDebitur("",periodeId, countDebitur,0);
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            
            Date newDate = new Date();
            ManagerTransferDataDebitur.statusEnd =" Proses Berakhir  .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
            ManagerTransferDataDebitur.running=false;
            
        }
        System.out.println("stop .... ");
    }
    
}
