/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import java.util.Date;

import com.dimata.util.*;

public class DTaxIntegrationManager {

    public static boolean running = false;

    public static DTaxIntegrationMonitor lck = new DTaxIntegrationMonitor();

    

    public DTaxIntegrationManager() {

    }

    public void startMonitor() {

        if(running) return;

            DTaxIntegrationManager objMan = new  DTaxIntegrationManager();

            Thread thLocker = new Thread(new DTaxIntegrationMonitor());

            thLocker.setDaemon(false);

            running = true;

            thLocker.start();

    }





    public void stopMonitor() {

        running = false;
        Date newDate = new Date();
        System.out.println("monitoring stopped .... datae/time : "+Formater.formatDate(newDate, "dd-MM-yyyy kk:mm"));

    }





    public boolean getStatus() {

        return running;

    }







    /*

     *  LITLE NOTE ABOUT THIS CLASS - THREAD

     *	1. comment this main method if this runs from jsp

     *	2. set thread deamon to be false -> refers to deamon and user thread in RTFM :)

     *	3. you need a statis variable in the jvm to control the thread

     *	   (in this case "running" variable)

	 *  4. the thread will be start ufter start() method is called,

     *	   and run immidiately after return from main or from other caller method that calls the start()

     *  5. set the "running" var to be false to stop the tread

     *

     */

//    public static void main(String[] args) {
//
// 		try{
//
//            RsvMonitorManager objMan = new  RsvMonitorManager();
//
//            Thread thLocker = new Thread(objMan.lck);
//
//            objMan.running = true;
//
//            thLocker.setDaemon(false);
//
//            thLocker.start();
//
//            return;
//
//
//
//        }catch(Exception e) {
//
//            System.out.println(e.toString());
//
//        }
//
//    } // end of main





}

