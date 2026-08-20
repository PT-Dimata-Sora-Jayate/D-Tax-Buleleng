
package com.dimata.dtaxintegration.entity.payment;

import java.sql.*;
import com.dimata.util.lang.I_Language;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import java.util.Vector;

public class PstViewPaymentPbb extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
    
    public static final String TBL_VIEW_PEMBAYARAN_PBB = "VIEW_PEMBAYARAN_PBB";
    public static final int FLD_NOP = 0;
    public static final int FLD_KD_PROPINSI = 1;
    public static final int FLD_KD_DATI2 = 2;
    public static final int FLD_KD_KECAMATAN = 3;
    public static final int FLD_KD_KELURAHAN = 4;
    public static final int FLD_KD_BLOK = 5;
    public static final int FLD_NO_URUT = 6;
    public static final int FLD_KD_JNS_OP = 7;
    public static final int FLD_THN_PAJAK_SPPT = 8;
    public static final int FLD_PEMBAYARAN_SPPT_KE = 9;
    public static final int FLD_KD_KANWIL_BANK = 10;
    public static final int FLD_KD_KPPBB_BANK = 11;
    public static final int FLD_KD_BANK_TUNGGAL = 12;
    public static final int FLD_KD_BANK_PERSEPSI = 13;
    public static final int FLD_KD_TP = 14;
    public static final int FLD_DENDA_SPPT = 15;
    public static final int FLD_JML_SPPT_YG_DIBAYAR = 16;
    public static final int FLD_TGL_PEMBAYARAN_SPPT = 17;
    public static final int FLD_TGL_REKAM_BYR_SPPT = 18;
    public static final int FLD_NIP_REKAM_BYR_SPPT = 19;
    
    
   public static String[] fieldNames = {
        "NOP",
        "KD_PROPINSI",
        "KD_DATI2",
        "KD_KECAMATAN",
        "KD_KELURAHAN",
        "KD_BLOK",
        "NO_URUT",
        "KD_JNS_OP",
        "THN_PAJAK_SPPT",
        "PEMBAYARAN_SPPT_KE",
        "KD_KANWIL_BANK",
        "KD_KPPBB_BANK",
        "KD_BANK_TUNGGAL",
        "KD_BANK_PERSEPSI",
        "KD_TP",
        "DENDA_SPPT",
        "JML_SPPT_YG_DIBAYAR",
        "TGL_PEMBAYARAN_SPPT",
        "TGL_REKAM_BYR_SPPT",
        "NIP_REKAM_BYR_SPPT"
    };
    
    public static int[] fieldTypes = {
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_DATE,
        TYPE_DATE,
        TYPE_STRING 
    }; 
    
    public PstViewPaymentPbb() {
    }

    public PstViewPaymentPbb(int i) throws DBException {
        super(new PstViewPaymentPbb());
    }

    public PstViewPaymentPbb(String sOid) throws DBException {
        super(new PstViewPaymentPbb(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstViewPaymentPbb(long lOid) throws DBException {
        super(new PstViewPaymentPbb(0));
        String sOid = "0";
        try {
            sOid = String.valueOf(lOid);
        } catch (Exception e) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    @Override
    public int getFieldSize() {
        return fieldNames.length;
    }

    @Override
    public String getTableName() {
        return TBL_VIEW_PEMBAYARAN_PBB;
    }

    @Override
    public String[] getFieldNames() {
        return fieldNames;
    }

    @Override
    public int[] getFieldTypes() {
        return fieldTypes;
    }

    @Override
    public String getPersistentName() {
        return new PstViewPaymentPbb().getClass().getName();
    }

    @Override
    public long fetchExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long updateExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long deleteExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long insertExc(Entity ent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void resultToObject(ResultSet rs, PaymentPbb entPaymentPbb) {
        try {
            entPaymentPbb.setNop(Long.parseLong(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NOP])));
            entPaymentPbb.setKdPropinsi(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_PROPINSI]));
            entPaymentPbb.setKdDati2(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_DATI2]));
            entPaymentPbb.setKdKecamata(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KECAMATAN]));
            entPaymentPbb.setKdKelurahan(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KELURAHAN]));
            entPaymentPbb.setKdBlok(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BLOK]));
            entPaymentPbb.setNoUrut(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NO_URUT]));
            entPaymentPbb.setKdJnsOp(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_JNS_OP]));
            entPaymentPbb.setThnPajakSppt(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_THN_PAJAK_SPPT]));
            entPaymentPbb.setPembayaranSpptKe(rs.getDouble(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_PEMBAYARAN_SPPT_KE]));
            entPaymentPbb.setKdKanwilBank(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KANWIL_BANK]));
            entPaymentPbb.setKdKppbbBank(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KPPBB_BANK]));
            entPaymentPbb.setKdBankTunggal(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BANK_TUNGGAL]));
            entPaymentPbb.setKdBankPersepsi(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BANK_PERSEPSI]));
            entPaymentPbb.setKdTp(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_TP]));
            entPaymentPbb.setDendaSppt(rs.getDouble(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_DENDA_SPPT]));
            entPaymentPbb.setJmlSpptYgDibayar(rs.getDouble(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_JML_SPPT_YG_DIBAYAR]));
            entPaymentPbb.setTglPembayaranSppt(rs.getDate(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_TGL_PEMBAYARAN_SPPT]));
            entPaymentPbb.setTglRekamByrSppt(rs.getDate(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_TGL_REKAM_BYR_SPPT]));
            entPaymentPbb.setNipRekamByrSppt(rs.getString(PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NIP_REKAM_BYR_SPPT]));
           
            
        } catch (Exception e) {
        }
    }
    
    public static Vector listAll() {
        return list(0, 500, "", "");
    }

    public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
        Vector lists = new Vector();
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT * FROM " + TBL_VIEW_PEMBAYARAN_PBB;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            if (order != null && order.length() > 0) {
                sql = sql + " ORDER BY " + order;
            }
//            if (limitStart == 0 && recordToGet == 0) {
//                sql = sql + "";
//            } else {
//                sql = sql + " LIMIT " + limitStart + "," + recordToGet;
//            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                PaymentPbb entPaymentPbb = new PaymentPbb();
                resultToObject(rs, entPaymentPbb);
                lists.add(entPaymentPbb);
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
    
    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NO_URUT] + ") FROM " + TBL_VIEW_PEMBAYARAN_PBB;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            return count;
        } catch (Exception e) {
            return 0;
        } finally {
            DBResultSet.close(dbrs);
        }
    }
}
