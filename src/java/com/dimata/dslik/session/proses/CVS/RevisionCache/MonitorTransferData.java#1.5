/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

/**
 *
 * @author dimata005
 */
public class MonitorTransferData implements Runnable {
    
    private String Proggess="";
    
    public MonitorTransferData() {
            
    }
    
    public void run() {

        System.out.println("start .... ");
    
        while (ManagerTransferData.running) {
            
            try {
                
                /*proses transfer*/
                ProsesTransferDataBank prosesTransferDataBank = new ProsesTransferDataBank();
                //ManagerTransferData xx =  new ManagerTransferData();
                //cek periode berjalan
                ManagerTransferData.setStatusProses("Start Periode <br>");
                long periodeId = 0;
                try{
                    periodeId = prosesTransferDataBank.cekOidPeriode("",0);
                }catch(Exception ex){
                }
                
                //Cek jumlah data
                int countDebitur = prosesTransferDataBank.countTransferDataDebitur("",periodeId);
                int countKredit = prosesTransferDataBank.countTransferDataKredit("",periodeId);
                int countBankGaransi = prosesTransferDataBank.countTransferDataBankGaransi("",periodeId);
                int countAgunan = prosesTransferDataBank.countTransferDataAgunan("",periodeId);
                int countPengurusatauPemilik = prosesTransferDataBank.countTransferDataPengurusAtauPemilik("",periodeId);
                
                ManagerTransferData.setStatusProses("Debitur :"+countDebitur+" <br>");
                ManagerTransferData.setStatusProses("Kredit :"+countKredit+" <br>");
                ManagerTransferData.setStatusProses("Bank Garansi :"+countBankGaransi+" <br>");
                ManagerTransferData.setStatusProses("Agunan :"+countAgunan+" <br>");
                ManagerTransferData.setStatusProses("Pengurus/Pemilik :"+countPengurusatauPemilik+" <br>");
                
                ManagerTransferData.setStatusProses("Get Debitur <br>");
                String debitur = prosesTransferDataBank.actionTransferDataDebitur("",periodeId, countDebitur,0);
                
                ManagerTransferData.setStatusProses("Get Kredit <br>");
                String kredit = prosesTransferDataBank.actionTransferDataKredit("",periodeId,countKredit,0);
                
                ManagerTransferData.setStatusProses("Get Bank Garansi <br> ");
                String bankGaransi = prosesTransferDataBank.actionTransferDataBankGaransi("",periodeId,countBankGaransi,0);
                
                ManagerTransferData.setStatusProses("Get Data Agunan <br>");
                String agunan = prosesTransferDataBank.actionTransferDataAgunan("",periodeId,countAgunan,0,"");
                
                ManagerTransferData.setStatusProses("Get Pengurus <br>");
                String pengurusataupemilik = prosesTransferDataBank.actionTransferDataPengurusAtauPemilik("",periodeId,countPengurusatauPemilik);
                
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
            
            ManagerTransferData.running=false;
        }
        System.out.println("stop .... ");
    }
    
}
