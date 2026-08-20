/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.session;

import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.wpupload.entity.esptpd.ESPTPD;
import com.dimata.wpupload.entity.esptpd.PstESPTPD;
import com.dimata.wpupload.entity.wpnamabadan.PstNamaBadan;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class SessReportWp {
    
    public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT "+PstNamaBadan.TBL_NAMABADAN+".*, "+PstESPTPD.TBL_ESPTPD+".* FROM " +PstESPTPD.TBL_ESPTPD+
                    
                         " INNER JOIN "+PstNamaBadan.TBL_NAMABADAN+" ON "+PstESPTPD.TBL_ESPTPD+"."+PstESPTPD.fieldNames[PstESPTPD.FLD_NPWPD]+" = "+PstNamaBadan.TBL_NAMABADAN+"."+PstNamaBadan.fieldNames[PstNamaBadan.FLD_NPWPD]+" " ;
            
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
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                ESPTPD entESPTPD = new ESPTPD();
                entESPTPD.setNamaBadan(rs.getString(PstNamaBadan.fieldNames[PstNamaBadan.FLD_NAMA_BADAN]));
                entESPTPD.setEMasaPajak(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_MASA_PAJAK]));
                entESPTPD.setETahunPajak(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_TAHUN_PAJAK]));
                entESPTPD.setETglRekam(rs.getDate(PstESPTPD.fieldNames[PstESPTPD.FLD_TGL_REKAM]));
                entESPTPD.setEIdRekam(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_ID_REKAM]));
                entESPTPD.setEJumlahOmzet(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_JUMLAH_OMZET]));
                entESPTPD.setETarif(rs.getDouble(PstESPTPD.fieldNames[PstESPTPD.FLD_TARIF]));
                entESPTPD.setEJumlahPajak(rs.getDouble(PstESPTPD.fieldNames[PstESPTPD.FLD_JUMLAH_PAJAK]));
                entESPTPD.setEServiceTax(rs.getDouble(PstESPTPD.fieldNames[PstESPTPD.FLD_SERVICE_TAX]));
                entESPTPD.setEHarusBayar(rs.getDouble(PstESPTPD.fieldNames[PstESPTPD.FLD_HARUS_DIBAYAR]));
                entESPTPD.setENoRekening(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_NO_REKENING]));
                entESPTPD.setEKodeLokasi(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_KODE_LOKASI]));
                entESPTPD.setENoSPTPD(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_NO_SPTPD]));
                entESPTPD.setEKeterangan(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_KETERANGAN]));
                entESPTPD.setENPWPD(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_NPWPD]));
                entESPTPD.setENIPRekam(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_NIP_REKAM]));
                entESPTPD.setEIdRekam(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_ID_REKAM]));
                entESPTPD.setEKodePajak(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_KODE_PAJAK]));
                entESPTPD.setENoSubrekening(rs.getString(PstESPTPD.fieldNames[PstESPTPD.FLD_NO_SUBREKENING]));
                lists.add(entESPTPD);
            }
            rs.close();
            return lists;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            DBResultSet.close(dbrs);
        }
        return new Vector();
    }
}
