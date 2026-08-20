/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

/**
 *
 * @author Administrator
 */

import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class SessionData {
     public static Vector getCustomeSql(String sql) {
        DBResultSet dbrs = null;
        Vector result = new Vector(1, 1);
        Vector resultType = new Vector(1, 1);
        Vector resultHeader = new Vector(1, 1);
        Vector resultData = new Vector(1, 1);
        
        try {
            sql = sql;
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            ResultSetMetaData rsmd=rs.getMetaData();
            int count=0;
            if(rsmd.getColumnCount()!=0){
                count=0;
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        count=count+1;
                        resultHeader.add(""+rsmd.getColumnName(count));
                }
                result.add(resultHeader);
            }
            count=0;
            if(rsmd.getColumnCount()!=0){
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                        count=count+1;
                        resultType.add(""+rsmd.getColumnTypeName(count));
                }
                result.add(resultType);
            }
            
            int typeSQL=0;
            while (rs.next()) {
                Vector data = new Vector(1, 1);
                count=0;
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                     count=count+1;
                     typeSQL = rsmd.getColumnType(count);
                     Object datax = action(typeSQL,rs,count);
                     data.add(""+datax); 
                }
                resultData.add(data);
            }
            result.add(resultData);
            
            rs.close();
            
        } catch (Exception e) {
            System.out.println("SessOrderMaterial.getVectPOItem() err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        
        return result;
    }
     
     
     public static String action(int data, ResultSet rs, int count) {
         String result="";
          switch(data){
            case -7 ://BIT
                break;
            case -6 ://TINYINT
                break;
            case -5 : // BIGINT
               try {
                    result=String.valueOf(rs.getLong(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case -4 ://LONGVARBINARY 
                break;
            case-3 ://VARBINARY
                break;
            case-2 ://BINARY
                break;
            case-1 ://LONGVARCHAR
                try {
                    result=rs.getString(count);
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 0 ://NULL
                break;
            case 1 ://CHAR
                break;
            case 2 ://NUMERIC
                break;
            case 3 ://DECIMAL
                try {
                    result=String.valueOf(rs.getDouble(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 4 ://INTEGER
                try {
                    result=String.valueOf(rs.getInt(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 5 ://SMALLINT
                break;
            case 6 ://FLOAT
                 try {
                    result=String.valueOf(rs.getDouble(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 7 ://REAL
                break;
            case 8 ://DOUBLE
                 try {
                    result=String.valueOf(rs.getDouble(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 12 ://VARCHAR
                try {
                    result=rs.getString(count);
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 91 ://DATE
                try {
                    result=String.valueOf(rs.getDate(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 92 ://TIME
                try {
                    result=String.valueOf(rs.getDate(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 93 ://TIMESTAMP
                try {
                    result=String.valueOf(rs.getDate(count));
                } catch (SQLException ex) {
                    result="";
                }
                break;
            case 1111://OTHER    
                break;
            default:   
          }       
         return result;
     }
     
     
     public static Object actionObject(int data, ResultSet rs, int count) {
          
          switch(data){
            case -7 ://BIT
                break;
            case -6 ://TINYINT
                break;
            case -5 : // BIGINT
               try {
                    return (rs.getLong(count));
                } catch (SQLException ex) {
                    return null;
                }
            case -4 ://LONGVARBINARY 
                break;
            case-3 ://VARBINARY
                break;
            case-2 ://BINARY
                break;
            case-1 ://LONGVARCHAR
                try {
                    return (rs.getLong(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 0 ://NULL
                break;
            case 1 ://CHAR
                break;
            case 2 ://NUMERIC
                break;
            case 3 ://DECIMAL
                try {
                    return (rs.getDouble(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 4 ://INTEGER
                try {
                    return (rs.getInt(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 5 ://SMALLINT
                break;
            case 6 ://FLOAT
                 try {
                    return (rs.getDouble(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 7 ://REAL
                break;
            case 8 ://DOUBLE
                 try {
                    return (rs.getDouble(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 12 ://VARCHAR
                try {
                    //result=rs.getString(count);
                    return (rs.getString(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 91 ://DATE
                try {
                    return (rs.getDate(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 92 ://TIME
                try {
                    return (rs.getDate(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 93 ://TIMESTAMP
                try {
                    return (rs.getDate(count));
                } catch (SQLException ex) {
                    return null;
                }
            case 1111://OTHER    
                break;
            default:   
          }   
          
          return null;
     }
}
