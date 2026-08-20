/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session.bphtb;
 
/**
 *
 * @author dimata005
 */
import com.dimata.dtaxintegration.entity.inquery.Bphtb;
import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtbIprotax;
import java.sql.*;

/* package qdep */
import com.dimata.qdep.db.*;
import com.dimata.webclient.AppSettingBphtb;
import java.util.Vector;
public class SessSimpatdaBphtb {
    public static Vector getListBphtbIprotax(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_BPHTB_ALL";
            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                BphtbIprotax bphtbIprotax = new BphtbIprotax();
                bphtbIprotax.setNoId(rs.getString("NO_ID"));
                bphtbIprotax.setNama(rs.getString("NAMA"));
                bphtbIprotax.setJumTagihan(rs.getString("JUM_TAGIHAN"));
                bphtbIprotax.setsNoId(rs.getString("SNOID"));
                bphtbIprotax.setPpat(rs.getString("PPAT"));
                bphtbIprotax.setNoSerif(rs.getString("NO_SERTIFIKAT"));
                bphtbIprotax.setLuasBumi(rs.getString("LUAS_TANAH"));
                bphtbIprotax.setLuasBangunan(rs.getString("LUAS_BANGUNAN"));
                result.add(bphtbIprotax);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
    
    public static Vector getListBphtbIprotaxBlm(String where) {

        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {

            sql = "SELECT * FROM VIEW_BPHTB";
            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                BphtbIprotax bphtbIprotax = new BphtbIprotax();
                bphtbIprotax.setNoId(rs.getString("NO_ID"));
                bphtbIprotax.setNama(rs.getString("NAMA"));
                bphtbIprotax.setJumTagihan(rs.getString("JUM_TAGIHAN"));
                bphtbIprotax.setsNoId(rs.getString("SNOID"));
                bphtbIprotax.setPpat(rs.getString("PPAT"));
                bphtbIprotax.setNoSerif(rs.getString("NO_SERTIFIKAT"));
                bphtbIprotax.setLuasBumi(rs.getString("LUAS_TANAH"));
                bphtbIprotax.setLuasBangunan(rs.getString("LUAS_BANGUNAN"));
                result.add(bphtbIprotax);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
    
    public static Vector getListBphtbThread(String where) {
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {
            sql = "SELECT * FROM VIEW_BPHTB";

            if (!where.equals("")) {
                sql = sql + where;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {

                BphtbIprotax bphtbIprotax = new BphtbIprotax();
                if (!DTaxManagerBphtb.running) {
                    return new Vector();
                } 
                
                bphtbIprotax.setNoId(rs.getString("NO_ID"));
                bphtbIprotax.setNama(rs.getString("NAMA"));
                bphtbIprotax.setJumTagihan(rs.getString("JUM_TAGIHAN"));
                bphtbIprotax.setsNoId(rs.getString("SNOID"));
                bphtbIprotax.setPpat(rs.getString("PPAT"));
                bphtbIprotax.setNoSerif(rs.getString("NO_SERTIFIKAT"));
                bphtbIprotax.setLuasBumi(rs.getString("LUAS_TANAH"));
                bphtbIprotax.setLuasBangunan(rs.getString("LUAS_BANGUNAN"));

                result.add(bphtbIprotax);
                DTaxManagerBphtb.countQuery = DTaxManagerBphtb.countQuery + 1;
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
            DTaxManagerBphtb.code = "99";
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
    
    public static Vector getListBphtb(String where) {
        
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        String whereClause = "";
        try {
            sql = "SELECT * FROM VIEW_BPHTB";
            if(!where.equals("")){
                sql=sql+where;
            }
            System.out.println("Manual Select => "+sql);
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                Bphtb bphtb = new Bphtb();
                bphtb.setId(rs.getString("NO_ID"));
                bphtb.setNama(rs.getString("NAMA"));
                bphtb.setJumlahTagihan(rs.getString("JUM_TAGIHAN"));
                bphtb.setNop(rs.getString("sNoid"));
                bphtb.setInstansi(AppSettingBphtb.INSTANSI_BPHTB);
                
                bphtb.setNoSertif(rs.getString("NO_SERTIFIKAT"));
                bphtb.setLuasTanah(rs.getString("LUAS_TANAH"));
                bphtb.setLuasBangunan(rs.getString("LUAS_BANGUNAN"));
                bphtb.setPpat(rs.getString("PPAT"));
                result.add(bphtb);
            }
            rs.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
    
    public static int countBPHTB(String where){
        int checkHistory=0;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "SELECT COUNT(NAMA) FROM VIEW_BPHTB";
            
            if(!where.equals("")){
                sql=sql+where;
            }
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            
            while (rs.next()) {
                checkHistory=rs.getInt(1);
            }
            
            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        
        return checkHistory;
    }
    
    public static void deleteExc(String whereClause) throws DBException {
        DBResultSet dbrs = null;
        int iResult = 0;
        try {
            String sql = "DELETE FROM " + PstLogHistoryTransaksi.TBL_LOGHISTORYTRANSAKSI;
            if (whereClause != null && whereClause.length() > 0){
                    sql = sql + " WHERE " + whereClause;
            }
            try {
                iResult = DBHandler.execUpdate(sql);
            } catch (DBException e) {
                e.printStackTrace();
            } finally {
                DBResultSet.close(dbrs);
            }
            
            //dbrs = DBHandler.execQueryResult(sql);
            //ResultSet rs = dbrs.getResultSet();
            //rs.close();
            
        } catch (Exception e) {
            System.out.println("Err: delete item " + e.toString());
        }
    } 
    
    public static boolean check(String npwd, String tahun, String tagihan, String bulan, String instansi){
        boolean checkHistory=false;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "SELECT * FROM "+PstLogHistoryTransaksi.TBL_LOGHISTORYTRANSAKSI+
                  " WHERE "+
                  ""+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_ID]+"='"+npwd+"'"+
                  " AND "+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_INSTANSI]+"='"+instansi+"'"+  
                  " AND "+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_JUMLAHPAJAK]+"="+tagihan;
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            
            while (rs.next()) {
                checkHistory=true;
            }
            
            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        
        return checkHistory;
    }
    
    public static boolean deleteHistory(String noId, String instansi){
        boolean checkHistory=false;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "DELETE  FROM "+PstLogHistoryTransaksi.TBL_LOGHISTORYTRANSAKSI+
                  " WHERE "+
                  ""+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_ID]+"='"+noId+"'"+
                  " AND "+PstLogHistoryTransaksi.fieldNames[PstLogHistoryTransaksi.FLD_INSTANSI]+"='"+instansi+"'";
            
            DBHandler.execUpdate(sql);
            
            return true;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }
        
        return checkHistory;
    }
    
    public static boolean checkPaymentBphtb(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM " + PstPaymentBphtbIprotax.TBL_PAYMENTBPHTBIPROTAX
                    + " WHERE "
                    + PstPaymentBphtbIprotax.fieldNames[PstPaymentBphtbIprotax.FLD_NOTRANSAKSIBYRBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            DTaxIntegrationManagerPaymentBphtb.status = "Error Cause : "+e.getMessage();
            DTaxIntegrationManagerPaymentBphtb.running = false;
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }
    
    public static boolean checkPaymentBphtbReversal(String idPayment) {
        boolean checkHistory = true;
        DBResultSet dbrs = null;
        String sql = "";
        try {

            sql = "SELECT * FROM IPROTAXBPHTB.PEMBAYARAN_BPHTB_REVERSAL"
                    + " WHERE "
                    + PstPaymentBphtbIprotax.fieldNames[PstPaymentBphtbIprotax.FLD_NOTRANSAKSIBYRBANK] + "='" + idPayment + "'";

            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();

            while (rs.next()) {
                checkHistory = false;
            }

            rs.close();
            return checkHistory;
        } catch (Exception e) {
            System.out.println("Exc in getListAP >>> " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
        }

        return checkHistory;
    }
    
    public static int DeleteDataPembayaranBPHTB(String idPaymentBank) {

        int iResult = 0;
        DBResultSet dbrs = null;
        //schema lama
        //String stSql = " DELETE FROM IPROTAXBPHTB.PEMBAYARAN_BPHTB WHERE "+
        //                            "NO_TRANSAKSI_BYR_BANK='"+idPaymentBank+"'";
        //schema baru
        String stSql = " DELETE FROM IPROTAXBPHTB."+PstPaymentBphtbIprotax.TBL_PAYMENTBPHTBIPROTAX+" WHERE "+
                                    "NO_TRANSAKSI_BYR_BANK='"+idPaymentBank+"'";
//                                  " KD_PROPINSI='"+kdprovinsi+"' "+ 
//                                  " AND KD_DATI2='"+kddati+"' "+ 
//                                  " AND KD_KECAMATAN='"+kecamatan+"' " +
//                                  " AND KD_KELURAHAN='"+kelurahan+"'" +
//                                  " AND KD_BLOK='"+kdBlock+"'" +
//                                  " AND NO_URUT='"+noUrut+"'" +
//                                  " AND KD_JNS_OP='"+kdjnsop+"'" +
//                                  " AND THN_PAJAK_SPPT='"+thnPajk+"'";
        try {
            iResult = DBHandler.execUpdate(stSql);
        } catch (DBException e) {
            e.printStackTrace();
        } finally {
            DBResultSet.close(dbrs);
        }
        return iResult;
    }
}
