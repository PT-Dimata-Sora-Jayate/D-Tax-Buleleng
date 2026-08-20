/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.util.Formater;
import java.util.Date;

/**
 *
 * @author IanRizky
 */
public class DTaxIntegrationManagerAutoPbb {

    public static boolean running = false;
	
	public static String erorStatus = "";

    public static DTaxIntegrationMonitor lck = new DTaxIntegrationMonitor();

    

    public DTaxIntegrationManagerAutoPbb() {

    }

    public void startMonitor(FileSent fileSent) {

        if(running) return;
			DTaxIntegrationManagerAutoPbb objMan = new  DTaxIntegrationManagerAutoPbb();

            Thread thLocker = new Thread(new dTaxMonitorAutoPbb(fileSent));

            thLocker.setDaemon(false);

            running = true;

            thLocker.start();

    }





    public void stopMonitor() {
		
        running = false;
        Date newDate = new Date();
        System.out.println("auto upload stopped .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));
		erorStatus="";
    }

	public String getErorStatus() {

        return erorStatus;

    }



    public boolean getStatus() {

        return running;

    }

}
