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
public class MonitorTransferDataPengurusPemilik implements Runnable {
    
    private String Proggess="";
    
    public MonitorTransferDataPengurusPemilik() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (ManagerTransferDataPengurusPemilik.running) {
            
            try {
                
                /*proses transfer*/
                ProsesTransferDataBank prosesTransferDataBank = new ProsesTransferDataBank();
                //cek periode berjalan
                ManagerTransferDataPengurusPemilik.setStatusProses("Start Periode <br>");
                long periodeId = 0;
                try{
                    periodeId = prosesTransferDataBank.cekOidPeriode("",5);
                }catch(Exception ex){
                }
                
                //Cek jumlah data
                int countPengurusatauPemilik = prosesTransferDataBank.countTransferDataPengurusAtauPemilik("",periodeId);
                
                ManagerTransferDataPengurusPemilik.setStatusProses("Pengurus/Pemilik :"+countPengurusatauPemilik+" <br>");
                
                ManagerTransferDataPengurusPemilik.setStatusProses("Get Pengurus <br>");
                String pengurusataupemilik = prosesTransferDataBank.actionTransferDataPengurusAtauPemilik("",periodeId,countPengurusatauPemilik);
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            Date newDate = new Date();
            ManagerTransferDataDebitur.statusEnd =" Proses Berakhir  .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
 
            ManagerTransferDataPengurusPemilik.running=false;
        }
        System.out.println("stop .... ");
    }
    
}
