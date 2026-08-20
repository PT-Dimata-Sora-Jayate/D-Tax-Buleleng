

package com.dimata.dtaxintegration.entity.inquery;

import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;
import com.dimata.util.Command;
import com.dimata.util.lang.I_Language;
import static java.lang.String.format;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class PstBphtbAll extends DBHandler 
implements I_DBInterface, I_DBType, I_PersintentExc, I_Language{
    
    public static final String TBL_VIEW_ALL_BPHTB = "view_all_bphtb";
    public static final int FLD_ID=0;
    public static final int FLD_MASA_PAJAK=1;
    public static final int FLD_TAHUN_PAJAK=2;
    public static final int FLD_NAMA=3;
    public static final int FLD_POKOK=4;
    public static final int FLD_DENDA=5;
    public static final int FLD_JUMLAH=6;
    public static final int FLD_INSTANSI=7;
    public static final int FLD_NOP=8;
    public static final int FLD_ID_KEY=9;
    
    public static String[] fieldNames = {
        "ID",
        "MASA_PAJAK",
        "TAHUN_PAJAK",
        "NAMA",
        "POKOK",
        "DENDA",
        "JUMLAH",
        "INSTANSI",
        "NOP",
        "ID_KEY"  
    };
    
    public static int[] fieldTypes = {
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING      
    };
    
    public PstBphtbAll() {}
    
    public PstBphtbAll(int i) throws DBException{
        super (new PstBphtbAll(0));
    }
    
    public PstBphtbAll(String sOid) throws DBException {
        super(new PstPbbAll(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }
    
    public PstBphtbAll(long lOid) throws DBException{
        super(new PstPbbAll(0));
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
        return TBL_VIEW_ALL_BPHTB;
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
        return new PstBphtbAll().getClass().getName();
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
    
    public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {

        Vector lists = new Vector();
        DBResultSet dbrs = null;

        try {
            String sql = "SELECT * FROM " + TBL_VIEW_ALL_BPHTB;

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
                Bphtb bphtb = new Bphtb();
                resultToObject(rs, bphtb);
                lists.add(bphtb);
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
    
    public static Vector listAll() {
        return list(0, 500, "", "");
    }
    
    public static void resultToObject(ResultSet rs, Bphtb bphtb) {

        try {
            bphtb.setId(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID]));
            bphtb.setMasaPajak(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_MASA_PAJAK]));
            bphtb.setTahunPajak(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_TAHUN_PAJAK]));
            bphtb.setNama(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_NAMA]));
            bphtb.setPokok(Long.toString(rs.getLong(PstBphtbAll.fieldNames[PstBphtbAll.FLD_POKOK])));
            bphtb.setDenda(Long.toString(rs.getLong(PstBphtbAll.fieldNames[PstBphtbAll.FLD_DENDA])));
            bphtb.setJumlahTagihan(Long.toString(rs.getLong(PstBphtbAll.fieldNames[PstBphtbAll.FLD_JUMLAH])));
            bphtb.setInstansi(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_INSTANSI]));
            bphtb.setNop(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_NOP]));
            bphtb.setIdKey(rs.getString(PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID_KEY]));

        } catch (Exception e) {
        }

    }
    
    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID_KEY] 
                    + ") FROM " + TBL_VIEW_ALL_BPHTB;
            if (whereClause != null && whereClause.length() > 0) {
                sql = sql + " WHERE " + whereClause;
            }
            dbrs = DBHandler.execQueryResult(sql);//execute query sql
            ResultSet rs = dbrs.getResultSet();
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);//ambil isi ResultSet yg 1 atau PstEmployee.fieldNames[PstEmployee.FLD_JENIS_ITEM_ID] 
            }
            rs.close();
            return count;
        } catch (Exception e) {
            return 0;
        } finally {
            DBResultSet.close(dbrs);
        }
    }
    
    
    
    public static int findLimitCommand(int start, int recordToGet, int vectSize) {
        int cmd = Command.LIST;
        int mdl = vectSize % recordToGet;
        vectSize = vectSize + (recordToGet - mdl);
        if (start == 0) {
            cmd = Command.FIRST;
        } else {
            if (start == (vectSize - recordToGet)) {
                cmd = Command.LAST;
            } else {
                start = start + recordToGet;
                if (start <= (vectSize - recordToGet)) {
                    cmd = Command.NEXT;
                    System.out.println("next.......................");
                } else {
                    start = start - recordToGet;
                    if (start > 0) {
                        cmd = Command.PREV;
                        System.out.println("prev.......................");
                    }
                }
            }
        }
        return cmd;
    }
    
}
