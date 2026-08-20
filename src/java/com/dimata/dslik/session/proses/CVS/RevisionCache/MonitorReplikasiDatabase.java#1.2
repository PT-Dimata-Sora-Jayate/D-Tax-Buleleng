/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class MonitorReplikasiDatabase {
    
     public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        //DBResultSet dbrs = null;
        Connection connection = null;
        java.sql.Statement s;
        java.sql.ResultSet rs;
        java.sql.PreparedStatement pst;

        connection = null;
        s = null;
        pst = null;
        rs = null;
        
        String url = "jdbc:mysql://192.168.168.100:3306/d_slik_bpd";
        //String url = "jdbc:mysql://localhost:3308/d_slik_bpd";
        String id  = "admin";
        String pass = "admindimata";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //connection = new Connection();
            connection = java.sql.DriverManager.getConnection(url, id, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            
            String sql = "SHOW SLAVE STATUS ";
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
            if (limitStart == 0 && recordToGet == 0) {
                sql = sql + "";
            } else {
                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
            
            s = connection.createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                ReplikasiDatabase replikasiDatabase = new ReplikasiDatabase();
                try{
                    replikasiDatabase.setSlaveIoState(rs.getString("Slave_IO_State"));
                    replikasiDatabase.setMasterHost(rs.getString("Master_Host"));
                    replikasiDatabase.setMasterUser(rs.getString("Master_User"));
                    replikasiDatabase.setMasterPort(rs.getString("Master_Port"));
                    replikasiDatabase.setConnectRetry(rs.getString("Connect_Retry"));

                    replikasiDatabase.setMasterLogFile(rs.getString("Master_Log_File"));
                    replikasiDatabase.setReadMasterLogPos(rs.getString("Read_Master_Log_Pos"));
                    replikasiDatabase.setRelayLogFile(rs.getString("Relay_Log_File"));
                    replikasiDatabase.setRelayLogPos(rs.getString("Relay_Log_Pos"));

                    replikasiDatabase.setRelayMasterLogFile(rs.getString("Relay_Master_Log_File"));
                    replikasiDatabase.setSlaveIoRunning(rs.getString("Slave_IO_Running"));
                    replikasiDatabase.setSlaveSQLRunning(rs.getString("Slave_SQL_Running"));

                    replikasiDatabase.setReplicateDoDB(rs.getString("Replicate_Do_DB"));
                    replikasiDatabase.setReplicateIgnoreDb(rs.getString("Replicate_Ignore_DB"));
                    replikasiDatabase.setReplicateDoTable(rs.getString("Replicate_Do_Table"));

                    replikasiDatabase.setReplicateIgnoreTable(rs.getString("Replicate_Ignore_Table"));
                    replikasiDatabase.setReplicateWildDoTable(rs.getString("Replicate_Wild_Do_Table"));
                    replikasiDatabase.setReplicateWildIgnoreTable(rs.getString("Replicate_Wild_Ignore_Table"));
                    replikasiDatabase.setLastErrno(rs.getString("Last_Errno"));
                    replikasiDatabase.setLastError(rs.getString("Last_Error"));

                    replikasiDatabase.setSkipCounter(rs.getString("Skip_Counter"));
                    replikasiDatabase.setExecMasterLogPos(rs.getString("Exec_Master_Log_Pos"));
                    replikasiDatabase.setRelayLogSpace(rs.getString("Relay_Log_Space"));
                    replikasiDatabase.setUntilcondition(rs.getString("Until_Condition"));
                    replikasiDatabase.setUntilLogFile(rs.getString("Until_Log_File"));
                    replikasiDatabase.setUntilLogPos(rs.getString("Until_Log_Pos"));

                    replikasiDatabase.setMasterSSLAllowed(rs.getString("Master_SSL_Allowed"));
                    replikasiDatabase.setMasterSSLCAFile(rs.getString("Master_SSL_CA_File"));
                    replikasiDatabase.setMasterSSLCAPath(rs.getString("Master_SSL_CA_Path"));

                    replikasiDatabase.setMasterSSLCert(rs.getString("Master_SSL_Cert"));
                    replikasiDatabase.setMasterSSLCipher(rs.getString("Master_SSL_Cipher"));
                    replikasiDatabase.setMasterSSLKey(rs.getString("Master_SSL_Key"));
                    replikasiDatabase.setSecondBehindMaster(rs.getString("Seconds_Behind_Master"));

                    replikasiDatabase.setMasterSSLVerifyServerCert(rs.getString("Master_SSL_Verify_Server_Cert"));
                    replikasiDatabase.setLastIOErrno(rs.getString("Last_IO_Errno"));
                    replikasiDatabase.setLastIOError(rs.getString("Last_IO_Error"));
                    replikasiDatabase.setLastSQLErrno(rs.getString("Last_SQL_Errno"));
                    replikasiDatabase.setLastSQLError(rs.getString("Last_SQL_Error"));
                    replikasiDatabase.setReplicateIgnoreServerIds(rs.getString("Replicate_Ignore_Server_Ids"));
                }catch( Exception es){}
                
                lists.add(replikasiDatabase);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }
        return new Vector();
    }
     
     
    
    public static String slaveRunning() {
        DBResultSet dbrs = null;
        String result="";
        try {
            String sql = "SHOW GLOBAL STATUS WHERE variable_name LIKE '%slave_running%'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result=rs.getString("Value");
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
    
    public static Vector lisMasterStatus() {
        DBResultSet dbrs = null;
        Vector lists = new Vector();
        try {
            String sql = "SHOW MASTER STATUS";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                ReplikasiDatabase replikasiDatabase = new ReplikasiDatabase();
                replikasiDatabase.setMasterFile(rs.getString("File"));
                replikasiDatabase.setMasterPosition(rs.getString("Position"));
                replikasiDatabase.setBinLogDoDb(rs.getString("Binlog_Do_DB"));
                replikasiDatabase.setBinLogIgnoreDb(rs.getString("Binlog_Ignore_DB"));
                lists.add(replikasiDatabase);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return lists;
        }
    }
     
}
