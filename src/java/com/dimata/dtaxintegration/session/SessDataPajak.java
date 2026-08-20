/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.bi.DataPajak;
import com.dimata.dtaxintegration.entity.bi.PajakType;
import com.dimata.dtaxintegration.entity.bi.PajakTypeDetail;
import com.dimata.dtaxintegration.entity.bi.PstDataPajak;
import com.dimata.dtaxintegration.entity.bi.PstPajakType;
import com.dimata.dtaxintegration.entity.bi.SearchDataPajak;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.util.Command;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class SessDataPajak {
    
    public static final int TARIK_MANUAL_DATA    	= 0;  
    public static final int TARIK_AUTOMATIC_DATA    	= 1;  
    public static final int CEK_NOTE_TARIK_DATA     	= 2; 
    public static final int CEK_STATUS_THREAD_TARIK_DATA  = 3; 
    
    public static Vector getListDataPajak(SearchDataPajak searchDataPajak) {
        
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = ""+searchDataPajak.getQueryPajak(); 

            sql = sql+  " AND "+searchDataPajak.getColomDate();

            if(AppSetting.SQL_VERSION == AppSetting.DBSVR_ORACLE){
                sql= sql+" BETWEEN TO_DATE ('"+searchDataPajak.getStartDate()+"','YYYY-MM-DD HH24:MI:SS')"
                        +" AND TO_DATE ('"+searchDataPajak.getEndDate()+"','YYYY-MM-DD HH24:MI:SS')";
            }else{
                 sql =sql+" BETWEEN ('"+searchDataPajak.getStartDate()+"')"
                     +" AND ('"+searchDataPajak.getEndDate()+"')";
            }             
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                DataPajak  dataPajak = new DataPajak();
                dataPajak.setTanggalBayar(rs.getDate("TANGGAL_PEMBAYARAN"));
                dataPajak.setId(rs.getString("ID"));
                dataPajak.setNama(rs.getString("NAMA_WP"));
                dataPajak.setJumlahPajak(rs.getDouble("JUMLAH_BAYAR"));
                dataPajak.setTahun(rs.getString("TAHUN"));
                dataPajak.setBulan(rs.getString("BULAN"));
                dataPajak.setKodeKecamatan(rs.getString("KODE_KEC"));
                dataPajak.setKodeKelurahan(rs.getString("KODE_KEL"));
                dataPajak.setKodeProv(rs.getString("KODE_PROV"));
                dataPajak.setKodeDati2(rs.getString("KODE_DATI"));
                dataPajak.setNoSPTPD(rs.getString("NO_SPTPD"));
                dataPajak.setPokok(rs.getDouble("POKOK"));
                dataPajak.setDenda(rs.getDouble("DENDA"));
                dataPajak.setPajakDetailId(searchDataPajak.getPajakDetailId());
                result.add(dataPajak);
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
    
    
    
    //public static void deleteDataPajak(SearchDataPajak searchDataPajak){
    public static int deleteDataPajak(SearchDataPajak searchDataPajak){
        int hasil=0;
        try{

            String sql = "DELETE FROM "+ PstDataPajak.TBL_DATAPAJAK+" WHERE "+PstDataPajak.fieldNames[PstDataPajak.FLD_PAJAKDETAILID]+"='"+searchDataPajak.getPajakDetailId()+"'"
                        + " AND TANGGAL_BAYAR ";
            if(AppSetting.SQL_VERSION == AppSetting.DBSVR_ORACLE){
                sql= sql+" BETWEEN TO_DATE ('"+searchDataPajak.getStartDate()+"','YYYY-MM-DD HH24:MI:SS')"
                        +" AND TO_DATE ('"+searchDataPajak.getEndDate()+"','YYYY-MM-DD HH24:MI:SS')";
            }else{
                 sql =sql+" BETWEEN ('"+searchDataPajak.getStartDate()+"')"
                     +" AND ('"+searchDataPajak.getEndDate()+"')";
            } 
            
            DBHandler.execUpdate(sql);

        }catch(Exception e){
        }finally{
        }
        return hasil;
    }
    
    
     public static Vector getListDataPajakMeaning(SearchDataPajak searchDataPajak) {
        Vector result = new Vector(1, 1);
        DBResultSet dbrs = null;
        String sql = "";
        try {
            sql = " SELECT * FROM "+PstDataPajak.TBL_DATAPAJAK+
                  " WHERE "+PstDataPajak.fieldNames[PstDataPajak.FLD_PAJAKDETAILID]+"='"+searchDataPajak.getPajakDetailId()+"'"+
                    " AND "+PstDataPajak.fieldNames[PstDataPajak.FLD_TANGGALBAYAR];

            if(AppSetting.SQL_VERSION == AppSetting.DBSVR_ORACLE){
                sql= sql+" BETWEEN TO_DATE ('"+searchDataPajak.getStartDate()+"','YYYY-MM-DD HH24:MI:SS')"
                        +" AND TO_DATE ('"+searchDataPajak.getEndDate()+"','YYYY-MM-DD HH24:MI:SS') ORDER BY "+PstDataPajak.fieldNames[PstDataPajak.FLD_DATA_ID]+" ASC";
            }else{
                 sql =sql+" BETWEEN ('"+searchDataPajak.getStartDate()+"')"
                     +" AND ('"+searchDataPajak.getEndDate()+"') ORDER BY "+PstDataPajak.fieldNames[PstDataPajak.FLD_DATA_ID]+" ASC";
            }
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                
                DataPajak  dataPajak = new DataPajak();
                
                dataPajak.setTanggalBayar(rs.getDate(PstDataPajak.fieldNames[PstDataPajak.FLD_TANGGALBAYAR]));
                dataPajak.setId(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_ID]));
                dataPajak.setNama(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_NAMA]));
                dataPajak.setJumlahPajak(rs.getDouble(PstDataPajak.fieldNames[PstDataPajak.FLD_JUMLAHPAJAK]));
                dataPajak.setTahun(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_TAHUN]));
                dataPajak.setBulan(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_BULAN]));
                dataPajak.setKodeKecamatan(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_KECAMATAN]));
                dataPajak.setKodeKelurahan(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_KELURAHAN]));
                dataPajak.setKodeProv(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_PROV]));
                dataPajak.setKodeDati2(rs.getString(PstDataPajak.fieldNames[PstDataPajak.FLD_DATI]));
                dataPajak.setPajakDetailId(rs.getLong(PstDataPajak.fieldNames[PstDataPajak.FLD_PAJAKDETAILID]));
                dataPajak.setDenda(rs.getDouble(PstDataPajak.fieldNames[PstDataPajak.FLD_DENDA]));
                dataPajak.setPokok(rs.getDouble(PstDataPajak.fieldNames[PstDataPajak.FLD_POKOK]));
                
                result.add(dataPajak);
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
    
    
    
    public static int action(int cmd,SearchDataPajak searchDataPajak, Vector vDataPajak, PajakTypeDetail pajakTypeDetail ) {
        int result=0;
        DBResultSet dbrs = null;
        String sql = "";
        
        switch (cmd) {
            
            case Command.ADD:
                 break;
                
            case Command.SAVE:
                 //cari typenya berdasarkan detail
                 PajakType pajakType = PstPajakType.checkPajakTypeWithTypeDetailID(searchDataPajak.getPajakDetailId());
                 int noUrut=0;
                 if(vDataPajak.size()>0){
                     
                     if(pajakType.getPajakTypeName().equals(PstPajakType.TBL_PAJAK_PHR)){
                         //PHR
                         if (DTaxManagerAutomaticDataPajakBI.running) {
                              DTaxManagerAutomaticDataPajakBI.note =DTaxManagerAutomaticDataPajakBI.note+ " Proses Data "+pajakTypeDetail.getPajakDetailName()+" Total : " +vDataPajak.size()+" <br>";
                         }
                         noUrut=0;
                         
                         for (int i = 0; i < vDataPajak.size(); i++) {
                               DataPajak dataPajak = (DataPajak) vDataPajak.get(i);
                               noUrut=noUrut+1;
                                try {
                                    //disini cek apakah data sudah ada atau tidak
                                   // boolean check=checkPHR(""+dataPajak.getId(), ""+dataPajak.getTahun(), ""+dataPajak.getBulan(), dataPajak.getJumlahPajak(), dataPajak.getNoSPTPD());
                                    
                                    //if(check){
                                        long oid = PstDataPajak.insertExc(dataPajak);
                                    //}
                                    
                                    if (DTaxManagerAutomaticDataPajakBI.running) {
                                        DTaxManagerAutomaticDataPajakBI.noteDetail = " Proses insert data "+pajakTypeDetail.getPajakDetailName()+" "+noUrut+"dari"+vDataPajak.size()+" <br>";
                                    }
                                    
                                } catch (DBException ex) {
                                    if (DTaxManagerAutomaticDataPajakBI.running) {
                                        DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses Stop insert PHR <br>";
                                        DTaxManagerAutomaticDataPajakBI.running=false;
                                    }
                                    
                                }
                         }
                         
                         if (DTaxManagerAutomaticDataPajakBI.running) {
                              DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note + " Proses Data "+pajakTypeDetail.getPajakDetailName()+" Done, Jumlah Masuk "+noUrut+"<br>";
                         }
                         
                     }else if(pajakType.getPajakTypeName().equals(PstPajakType.TBL_PAJAK_PBB)){//PBB
                          if (DTaxManagerAutomaticDataPajakBI.running) {
                              DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses data PBB "+vDataPajak.size()+" <br>";
                          }
                          for (int i = 0; i < vDataPajak.size(); i++) {
                               DataPajak dataPajak = (DataPajak) vDataPajak.get(i);
                                try {
                                    //disini cek apakah data sudah ada atau tidak
                                    //boolean check=checkPbb(""+dataPajak.getId(), ""+dataPajak.getTahun(), ""+dataPajak.getBulan());
                                   // if(check){
                                        long oid = PstDataPajak.insertExc(dataPajak);
                                    //}
                                } catch (DBException ex) {
                                    if (DTaxManagerAutomaticDataPajakBI.running) {
                                        DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses Stop insert PBB <br>";
                                        DTaxManagerAutomaticDataPajakBI.running=false;
                                    }
                                }
                         }
                     }else if(pajakType.getPajakTypeName().equals(PstPajakType.TBL_PAJAK_BPHTB)){
                         if (DTaxManagerAutomaticDataPajakBI.running) {
                              DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses data BPHTB "+vDataPajak.size()+" <br>";
                         }
                         for (int i = 0; i < vDataPajak.size(); i++) {
                               DataPajak dataPajak = (DataPajak) vDataPajak.get(i);
                                try {
                                    //disini cek apakah data sudah ada atau tidak
                                    //boolean check=checkBphtb(""+dataPajak.getId());
                                    //if(check){
                                        long oid = PstDataPajak.insertExc(dataPajak);
                                    //}
                                } catch (DBException ex) {
                                    if (DTaxManagerAutomaticDataPajakBI.running) {
                                        DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses Stop insert BPHTB <br>";
                                        DTaxManagerAutomaticDataPajakBI.running=false;
                                    }
                                }
                         }
                     }else if(pajakType.getPajakTypeName().equals(PstPajakType.TBL_PAJAK_RETRIBUSI)){
                         
                         if (DTaxManagerAutomaticDataPajakBI.running) {
                              DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses data Retribusi "+vDataPajak.size()+" <br>";
                         }
                         
                         for (int i = 0; i < vDataPajak.size(); i++) {
                               DataPajak dataPajak = (DataPajak) vDataPajak.get(i);
                                try {
                                    //disini cek apakah data sudah ada atau tidak
                                    //String tanggalBayar= Formater.formatDate(dataPajak.getTanggalBayar(),"yyyy-MM-dd HH:mm:ss");
                                    //boolean check= checkRetribusi(dataPajak.getId(), dataPajak.getTahun(), dataPajak.getBulan(),tanggalBayar);
                                    //if(check){
                                        long oid = PstDataPajak.insertExc(dataPajak);
                                    //}
                                } catch (DBException ex) {
                                    if (DTaxManagerAutomaticDataPajakBI.running) {
                                        DTaxManagerAutomaticDataPajakBI.note = DTaxManagerAutomaticDataPajakBI.note+" Proses Stop insert Retribusi <br>";
                                        DTaxManagerAutomaticDataPajakBI.running=false;
                                    }
                                }
                         }
                     }else{
                         //jangan melakukan apa2
                     }
                 }
                 break;      
            default:  
        }
        return 0;
    }
    
    
     public static boolean checkPbb(String id, String tahun, String masaPajak){
        boolean checkHistory=true;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "SELECT ID FROM BI_DATA_PAJAK"+
                  " WHERE ID='"+id+"' AND TAHUN='"+tahun+"'";
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            
            while (rs.next()) {
                checkHistory=false;
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
    
    public static boolean checkPHR(String id, String tahun, String masaPajak, double tagihan, String noSptpd){
        boolean checkHistory=true;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "SELECT ID FROM BI_DATA_PAJAK"+
                  " WHERE ID='"+id+"' AND TAHUN='"+tahun+"'"+" AND BULAN ='"+masaPajak+"' AND JUMLAH_PAJAK='"+tagihan+"' AND NO_SPTPD='"+noSptpd+"'";
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            
            while (rs.next()) {
                checkHistory=false;
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
    
    
    public static boolean checkBphtb(String id){
        boolean checkHistory=true;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "SELECT ID FROM BI_DATA_PAJAK"+
                  " WHERE ID='"+id+"'";
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            
            while (rs.next()) {
                checkHistory=false;
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
    
    
    public static boolean checkRetribusi(String id, String tahun, String masaPajak, String tanggal){
        boolean checkHistory=true;
        DBResultSet dbrs = null;
        String sql = "";
        try {
            
            sql = "SELECT ID FROM BI_DATA_PAJAK"+
                  " WHERE ID='"+id+"'";
            
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            
            while (rs.next()) {
                checkHistory=false;
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
    
}
