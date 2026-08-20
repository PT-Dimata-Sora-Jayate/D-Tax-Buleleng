/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.webclient.AppSetting;

/**
 *
 * @author dimata005
 */
public class DTaxMonitorAutomaticPhr implements Runnable {
    
    public DTaxMonitorAutomaticPhr() {

    }
    
    public void run() {
        System.out.println("start .... ");
        while (DTaxManagerAutomaticPhr.running) {
            try {
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                switch (AppSetting.TYPE_APP_BACKOFFICE) {
                    case AppSetting.APP_OPEN_PHR:
                        dTaxIntegrationMonitor.sentAutoOpenPhr("");
                        break;
                    case AppSetting.APP_PHRH:
                        dTaxIntegrationMonitor.sentAutoPhrH("");               
                        break;
                    default:
                        dTaxIntegrationMonitor.sentAutoPhr("");
                        break;
                }
                Thread.sleep((long) (0.1 * 60000));
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
        }
        System.out.println("stop .... ");
    }
}
