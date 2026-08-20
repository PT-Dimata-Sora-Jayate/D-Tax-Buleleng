/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegrationsisda.session;

import java.sql.Connection;

/**
 *
 * @author dimata005
 */
public class SqlServerConnection {
    public static Connection getConnection() throws Exception {

        java.sql.Connection con;
        con = null;
        String url = "jdbc:jtds:sqlserver://SVR-BACKUP/PENDAPATAN2016;instance=simpadadbs";
        String id  = "simda";
        String pass = "123";
        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = java.sql.DriverManager.getConnection(url, id, pass);

        } catch (ClassNotFoundException cnfex) {
            cnfex.printStackTrace();

        }
        return con;
        
    }
}
