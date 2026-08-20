
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

public class PstPbbAll extends DBHandler 
implements I_DBInterface, I_DBType, I_PersintentExc, I_Language{
    
    public static final String TBL_VIEW_ALL_PBB = "view_all_pbb";
    public static final int FLD_NOP=0;
    public static final int FLD_NAMA=1;
    public static final int FLD_INSTANSI=2;
    public static final int FLD_NPWPD=3;
    public static final int FLD_ALAMAT_WP=4;
    public static final int FLD_LETAK=5;
    public static final int FLD_TAHUN=6;
    public static final int FLD_JATUH_TEMPO=7;
    public static final int FLD_LUAS_BUMI_SPPT=8;
    public static final int FLD_LUAS_BNG_SPPT=9;
    public static final int FLD_NJOP_BUMI_SPPT=10;
    public static final int FLD_NJOP_BNG_SPPT=11;
    public static final int FLD_NJOPTKP_SPPT=12;
    public static final int FLD_POKOK=13;
    public static final int FLD_DENDA=14;
    public static final int FLD_JUMLAH_TAGIHAN=15;
    public static final int FLD_ID_KEY=16;
    
    public static String[] fieldNames = {
        "NOP",
        "NAMA",
        "INSTANSI",
        "NPWPD",
        "ALAMAT_WP",
        "LETAK",
        "TAHUN",
        "JATUH_TEMPO",
        "LUAS_BUMI_SPPT",
        "LUAS_BNG_SPPT",
        "NJOP_BUMI_SPPT",
        "NJOP_BNG_SPPT",
        "NJOPTKP_SPPT",
        "POKOK",
        "DENDA",
        "JUMLAH_TAGIHAN",
        "ID_KEY"   
    };
    
    public static int[] fieldTypes = {
        TYPE_STRING, //0
        TYPE_STRING, //1
        TYPE_STRING, 
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_STRING,
        TYPE_DATE,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_LONG,
        TYPE_STRING
    };
    
    public PstPbbAll() {}
    
    public PstPbbAll(int i)throws DBException{
        super(new PstPbbAll());
    }
    
    public PstPbbAll(String sOid) throws DBException {
        super(new PstPbbAll(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }
    
    public PstPbbAll(long lOid) throws DBException {
        super(new PstPbbAll(0));//merupakan induk construktor dari DBHandler, 0 fungsinya sebagai default PSTGEJALA
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
        return TBL_VIEW_ALL_PBB;
    }

    @Override
    public String[] getFieldNames() {
       return  fieldNames;
    }

    @Override
    public int[] getFieldTypes() {
        return fieldTypes;
    }

    @Override
    public String getPersistentName() {
        return new PstPbbAll().getClass().getName();
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
            String sql = "SELECT * FROM " + TBL_VIEW_ALL_PBB;

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
                Pbb pbb = new Pbb();
                resultToObject(rs, pbb);
                lists.add(pbb);
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
    
    public static void resultToObject(ResultSet rs, Pbb pbb) {

        try {
            pbb.setNop(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_NOP]));
            pbb.setNama(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_NAMA]));
            pbb.setInstansi(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_INSTANSI]));
            pbb.setNpwpd(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_NPWPD]));
            pbb.setAlamat(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_ALAMAT_WP]));
            pbb.setLetakObjectPajak(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_LETAK]));
            pbb.setTahun(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_TAHUN]));
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
            pbb.setTglJatuhTempo(df.format(rs.getDate(PstPbbAll.fieldNames[PstPbbAll.FLD_JATUH_TEMPO])));
            pbb.setLuasBumi(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_LUAS_BUMI_SPPT])));
            pbb.setLuasBangunan(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_LUAS_BNG_SPPT])));
            pbb.setnJOPBumi(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_NJOP_BUMI_SPPT])));
            pbb.setnJOPBangunan(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_NJOP_BNG_SPPT])));
            pbb.setnJOPTKP(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_NJOPTKP_SPPT])));
            pbb.setPokok(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_POKOK])));
            pbb.setDenda(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_DENDA])));
            pbb.setJumlahTagihan(Long.toString(rs.getLong(PstPbbAll.fieldNames[PstPbbAll.FLD_JUMLAH_TAGIHAN])));
            pbb.setId(rs.getString(PstPbbAll.fieldNames[PstPbbAll.FLD_ID_KEY]));
        } catch (Exception e) {
        }

    }
    
    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstPbbAll.fieldNames[PstPbbAll.FLD_ID_KEY] 
                    + ") FROM " + TBL_VIEW_ALL_PBB;
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
