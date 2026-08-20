/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

//import com.dimata.dtaxintegration.entity.bi.PajakTypeDetail;
//import com.dimata.dtaxintegration.entity.bi.PstPajakTypeDetail;
//import com.dimata.dtaxintegration.entity.bi.SearchDataPajak;
//import com.dimata.util.Formater;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class DTaxMonitorAutomaticDataPajakBI implements Runnable {

    public DTaxMonitorAutomaticDataPajakBI() {

    }

    public void run() {
        
        while (DTaxManagerAutomaticDataPajakBI.running) {
            
            try {
                
//                SearchDataPajak searchDataPajak = new SearchDataPajak();
//                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//                Date dStartDate = new Date();
//                String startDate="";
//                String endDate="";
//                try {
//                    startDate = Formater.formatDate(dStartDate, "yyyy-MM-dd");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                
//                try {
//                    endDate = Formater.formatDate(dStartDate, "yyyy-MM-dd");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                
//                DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses data per tanggal "+startDate+" <br>";
//                
//                Vector vPajakDetail = new Vector();
//                vPajakDetail = PstPajakTypeDetail.list(0, 0, "","");
//                if( vPajakDetail.size()>0){
//                    for (int i = 0; i < vPajakDetail.size(); i++) {
//                        PajakTypeDetail pajakTypeDetail = (PajakTypeDetail) vPajakDetail.get(i);
//                        searchDataPajak = new SearchDataPajak();
//
//                        searchDataPajak.setPajakDetailId(pajakTypeDetail.getOID());
//                        searchDataPajak.setStartDate(startDate);
//                        searchDataPajak.setEndDate(endDate);
//                        searchDataPajak.setQueryPajak(pajakTypeDetail.getPajakQuery());
//                        searchDataPajak.setColomDate(pajakTypeDetail.getColomDate());
//
//                        //ambil data
//                        Vector vDataPajak = SessDataPajak.getListDataPajak(searchDataPajak);
//                        
//                        //simpan data
//                        try{
//                            int xxx = SessDataPajak.action(4, searchDataPajak, vDataPajak, pajakTypeDetail);
//                        }catch(Exception ex){
//                        
//                        }
//                    }
//                }
                
                /// Thread.sleep((long) (0.1 * 60));
                DTaxManagerAutomaticDataPajakBI.noteDetail ="";
                DTaxManagerAutomaticDataPajakBI.note="";
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                dTaxIntegrationMonitor.sentDataBI("");               
                Thread.sleep((long) (60000));

            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
        }
    }
}
