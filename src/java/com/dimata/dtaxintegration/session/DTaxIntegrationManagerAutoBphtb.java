package com.dimata.dtaxintegration.session;

import com.dimata.util.Formater;
import java.util.Date;

public class DTaxIntegrationManagerAutoBphtb {
   public static boolean running = false;
   public static String erorStatus = "";
   public static int jmlTagihan = 0;
   public static int tagihanBank = 0;
   public static String code = "";
   public static String message = "";
   public static DTaxIntegrationMonitor lck = new DTaxIntegrationMonitor();

   public void startMonitor() {
      if (!running) {
         new DTaxIntegrationManagerAutoBphtb();
         Thread thLocker = new Thread(new dTaxMonitorAutoBphtb());
         thLocker.setDaemon(false);
         running = true;
         thLocker.start();
      }
   }

   public void stopMonitor() {
      running = false;
      Date newDate = new Date();
      System.out.println("auto upload stopped .... date/time : " + Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));
      erorStatus = "";
   }

   public String getErorStatus() {
      return erorStatus;
   }

   public boolean getStatus() {
      return running;
   }

   public static int getJmlTagihan() {
      return jmlTagihan;
   }

   public static int getTagihanBank() {
      return tagihanBank;
   }

   public static String getCode() {
      return code;
   }

   public static String getMessage() {
      return message;
   }
}