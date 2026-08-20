/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dimata.dtaxintegrationsisda.entity.piutang;

/**
 *
 * @author AYUKI
 */
import java.sql.*;

/* package qdep */
import com.dimata.util.lang.I_Language;
import com.dimata.dtaxintegrationsisda.db.*;
import static com.dimata.dtaxintegrationsisda.db.I_DBType.TYPE_FLOAT;
import static com.dimata.dtaxintegrationsisda.db.I_DBType.TYPE_STRING;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;
import com.dimata.util.Command;
import java.util.Vector;

public class PstTaKartuPajakHiburan extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language  {
    
    public static final String TBL_TAKARTUPAJAKHIBURAN = "TA_KARTU_PAJAK_HIBURAN";
    public static final int FLD_TAHUN = 0;
    public static final int FLD_NO_SPT = 1;
    public static final int FLD_KD_REK_1 = 2;
    public static final int FLD_KD_REK_2 = 3;
    public static final int FLD_KD_REK_3 = 4;
    public static final int FLD_KD_REK_4 = 5;
    public static final int FLD_KD_REK_5 = 6;
    public static final int FLD_KD_REK_6 = 7;
    public static final int FLD_DASAR_PENGENAAN = 8;
    public static final int FLD_PAJAK_TERHUTANG = 9;
    public static final int FLD_TARIF_PAJAK = 10;
    public static final int FLD_JML_PERTUNJUKAN1 = 11;
    public static final int FLD_JML_PERTUNJUKAN2 = 12;
    public static final int FLD_JML_PENGUNJUNG1 = 13;
    public static final int FLD_JML_PENGUNJUNG2 = 14;
    public static final int FLD_HTM = 15;
    public static final int FLD_JML_MESIN = 16;
    public static final int FLD_TARIF_MEJA = 17;
    public static final int FLD_RATA_KEGIATAN = 18;
    public static final int FLD_JML_RUANGAN = 19;
    public static final int FLD_KARCIS_BEBAS = 20;
    public static final int FLD_JML_KARCIS_BEBAS = 21;
    public static final int FLD_MESIN_TIKET = 22;
    public static final int FLD_PEMBUKUAN = 23;
    
      public static String[] fieldNames = {
        "Tahun",
        "No_SPT",
        "Kd_Rek_1",
        "Kd_Rek_2",
        "Kd_Rek_3",
        "Kd_Rek_4",
        "Kd_Rek_5",
        "Kd_Rek_6",
        "DasarPengenaan",
        "PajakTerhutang",
        "TarifPajak",
        "Jml_Pertunjukan1",
        "Jml_Pertunjukan2",
        "Jml_Pengunjung1",
        "Jml_Pengunjung2",
        "HTM",
        "Jml_Mesin",
        "TarifMeja",
        "RataKegiatan",
        "Jml_Ruangan",
        "Karcis_Bebas",
        "Jml_Karcis_Bebas",
        "Mesin_Tiket",
        "Pembukuan"
    };
    
    public static int[] fieldTypes = {
        TYPE_INT,
        TYPE_STRING,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_FLOAT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_FLOAT,
        TYPE_INT,
        TYPE_FLOAT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT,
        TYPE_INT
    };
    
    public PstTaKartuPajakHiburan(){
        
    }
    
    public PstTaKartuPajakHiburan(int i) throws DBException {
        super(new PstTaKartuPajakHiburan());
    }
    
    public PstTaKartuPajakHiburan(String sOid) throws DBException {
        super(new PstTaKartuPajakHiburan(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstTaKartuPajakHiburan(long lOid) throws DBException {
        super(new PstTaKartuPajakHiburan(0));
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
        return TBL_TAKARTUPAJAKHIBURAN;
    }

      public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }
    @Override
    public String getPersistentName() {
        return new PstTaKartuPajakHiburan().getClass().getName();
    }
    
    public static TaKartuPajakHiburan fetchExc(long oid) throws DBException {
        try {
            TaKartuPajakHiburan entTaKartuPajakHiburan = new TaKartuPajakHiburan();
            PstTaKartuPajakHiburan pstTaKartuPajakHiburan = new PstTaKartuPajakHiburan(oid);
            entTaKartuPajakHiburan.setOID(oid);
            entTaKartuPajakHiburan.setTahun(pstTaKartuPajakHiburan.getInt(FLD_TAHUN));
            entTaKartuPajakHiburan.setNoSPT(pstTaKartuPajakHiburan.getString(FLD_NO_SPT));
            entTaKartuPajakHiburan.setKdRek1(pstTaKartuPajakHiburan.getInt(FLD_KD_REK_1));
            entTaKartuPajakHiburan.setKdRek2(pstTaKartuPajakHiburan.getInt(FLD_KD_REK_2));
            entTaKartuPajakHiburan.setKdRek3(pstTaKartuPajakHiburan.getInt(FLD_KD_REK_3));
            entTaKartuPajakHiburan.setKdRek4(pstTaKartuPajakHiburan.getInt(FLD_KD_REK_4));
            entTaKartuPajakHiburan.setKdRek5(pstTaKartuPajakHiburan.getInt(FLD_KD_REK_5));
            entTaKartuPajakHiburan.setKdRek6(pstTaKartuPajakHiburan.getInt(FLD_KD_REK_6));
            entTaKartuPajakHiburan.setDasarPengenaan(pstTaKartuPajakHiburan.getdouble(FLD_DASAR_PENGENAAN));
            entTaKartuPajakHiburan.setPajakTerhutang(pstTaKartuPajakHiburan.getdouble(FLD_PAJAK_TERHUTANG));
            entTaKartuPajakHiburan.setTarifPajak(pstTaKartuPajakHiburan.getdouble(FLD_TARIF_PAJAK));
            
            entTaKartuPajakHiburan.setJmlPertunjukan1(pstTaKartuPajakHiburan.getInt(FLD_JML_PERTUNJUKAN1));
            entTaKartuPajakHiburan.setJmlPertunjukan2(pstTaKartuPajakHiburan.getInt(FLD_JML_PERTUNJUKAN2)); 
            entTaKartuPajakHiburan.setJmlPengunjung1(pstTaKartuPajakHiburan.getInt(FLD_JML_PENGUNJUNG1));
            entTaKartuPajakHiburan.setJmlPengunjung2(pstTaKartuPajakHiburan.getInt(FLD_JML_PENGUNJUNG2));
            entTaKartuPajakHiburan.setHtm(pstTaKartuPajakHiburan.getdouble(FLD_HTM));
            entTaKartuPajakHiburan.setJmlMesin(pstTaKartuPajakHiburan.getInt(FLD_JML_MESIN));
            entTaKartuPajakHiburan.setTarifMeja(pstTaKartuPajakHiburan.getdouble(FLD_TARIF_MEJA));
            entTaKartuPajakHiburan.setRataKegiatan(pstTaKartuPajakHiburan.getInt(FLD_RATA_KEGIATAN));
            entTaKartuPajakHiburan.setJmlRuangan(pstTaKartuPajakHiburan.getInt(FLD_JML_RUANGAN));
            entTaKartuPajakHiburan.setKarcisBebas(pstTaKartuPajakHiburan.getInt(FLD_KARCIS_BEBAS));
            entTaKartuPajakHiburan.setJmlKarcisBebas(pstTaKartuPajakHiburan.getInt(FLD_JML_KARCIS_BEBAS));
            entTaKartuPajakHiburan.setMesinTiket(pstTaKartuPajakHiburan.getInt(FLD_MESIN_TIKET));
            entTaKartuPajakHiburan.setPembukuan(pstTaKartuPajakHiburan.getInt(FLD_PEMBUKUAN));
           
            return entTaKartuPajakHiburan;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHiburan(0), DBException.UNKNOWN);
        }
    }
    
    
    @Override
    public long fetchExc(Entity entity) throws Exception {
        TaKartuPajakHiburan entTaKartuPajakHiburan = fetchExc(entity.getOID());
        entity = (Entity) entTaKartuPajakHiburan;
        return entTaKartuPajakHiburan.getOID();
    }
    
    public static synchronized long updateExc(TaKartuPajakHiburan entTaKartuPajakHiburan) throws DBException {
        try {
            if (entTaKartuPajakHiburan.getOID() != 0) {
                
                PstTaKartuPajakHiburan pstTaKartuPajakHiburan = new PstTaKartuPajakHiburan(entTaKartuPajakHiburan.getOID());
                pstTaKartuPajakHiburan.setInt(FLD_TAHUN, entTaKartuPajakHiburan.getTahun());
                pstTaKartuPajakHiburan.setString(FLD_NO_SPT, entTaKartuPajakHiburan.getNoSPT());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_1, entTaKartuPajakHiburan.getKdRek1());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_2, entTaKartuPajakHiburan.getKdRek2());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_3, entTaKartuPajakHiburan.getKdRek3());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_4, entTaKartuPajakHiburan.getKdRek4());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_5, entTaKartuPajakHiburan.getKdRek5());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_6, entTaKartuPajakHiburan.getKdRek6());
                pstTaKartuPajakHiburan.setDouble(FLD_DASAR_PENGENAAN, entTaKartuPajakHiburan.getDasarPengenaan());
                pstTaKartuPajakHiburan.setDouble(FLD_PAJAK_TERHUTANG, entTaKartuPajakHiburan.getPajakTerhutang());
                pstTaKartuPajakHiburan.setDouble(FLD_TARIF_PAJAK, entTaKartuPajakHiburan.getTarifPajak());
                
                pstTaKartuPajakHiburan.setInt(FLD_JML_PERTUNJUKAN1, entTaKartuPajakHiburan.getJmlPertunjukan1());
                pstTaKartuPajakHiburan.setInt(FLD_JML_PERTUNJUKAN2, entTaKartuPajakHiburan.getJmlPertunjukan2());
                pstTaKartuPajakHiburan.setInt(FLD_JML_PENGUNJUNG1, entTaKartuPajakHiburan.getJmlPengunjung2());
                pstTaKartuPajakHiburan.setInt(FLD_JML_PENGUNJUNG2, entTaKartuPajakHiburan.getJmlPengunjung2());
                pstTaKartuPajakHiburan.setDouble(FLD_HTM, entTaKartuPajakHiburan.getHtm());
                pstTaKartuPajakHiburan.setInt(FLD_JML_MESIN, entTaKartuPajakHiburan.getJmlMesin());
                pstTaKartuPajakHiburan.setDouble(FLD_TARIF_MEJA, entTaKartuPajakHiburan.getTarifMeja());
                pstTaKartuPajakHiburan.setInt(FLD_RATA_KEGIATAN, entTaKartuPajakHiburan.getRataKegiatan());
                pstTaKartuPajakHiburan.setInt(FLD_JML_RUANGAN, entTaKartuPajakHiburan.getJmlRuangan());
                pstTaKartuPajakHiburan.setInt(FLD_KARCIS_BEBAS, entTaKartuPajakHiburan.getKarcisBebas());
                pstTaKartuPajakHiburan.setInt(FLD_JML_KARCIS_BEBAS, entTaKartuPajakHiburan.getJmlKarcisBebas());
                pstTaKartuPajakHiburan.setInt(FLD_MESIN_TIKET, entTaKartuPajakHiburan.getMesinTiket());
                pstTaKartuPajakHiburan.setInt(FLD_PEMBUKUAN, entTaKartuPajakHiburan.getPembukuan());
                
                pstTaKartuPajakHiburan.update();
                
                return entTaKartuPajakHiburan.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHiburan(0), DBException.UNKNOWN);
        }
        return 0;
    }


    @Override
    public long updateExc(Entity entity) throws Exception {
        return updateExc((TaKartuPajakHiburan) entity);
    }
    
    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstTaKartuPajakHiburan pstTaKartuPajakHiburan = new PstTaKartuPajakHiburan(oid);
            pstTaKartuPajakHiburan.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHiburan(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

     public static synchronized long insertExc(TaKartuPajakHiburan entTaKartuPajakHiburan) throws DBException {
        try {
            
                PstTaKartuPajakHiburan pstTaKartuPajakHiburan = new PstTaKartuPajakHiburan(0);
                pstTaKartuPajakHiburan.setInt(FLD_TAHUN, entTaKartuPajakHiburan.getTahun());
                pstTaKartuPajakHiburan.setString(FLD_NO_SPT, entTaKartuPajakHiburan.getNoSPT());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_1, entTaKartuPajakHiburan.getKdRek1());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_2, entTaKartuPajakHiburan.getKdRek2());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_3, entTaKartuPajakHiburan.getKdRek3());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_4, entTaKartuPajakHiburan.getKdRek4());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_5, entTaKartuPajakHiburan.getKdRek5());
                pstTaKartuPajakHiburan.setInt(FLD_KD_REK_6, entTaKartuPajakHiburan.getKdRek6());
                pstTaKartuPajakHiburan.setDouble(FLD_DASAR_PENGENAAN, entTaKartuPajakHiburan.getDasarPengenaan());
                pstTaKartuPajakHiburan.setDouble(FLD_PAJAK_TERHUTANG, entTaKartuPajakHiburan.getPajakTerhutang());
                pstTaKartuPajakHiburan.setDouble(FLD_TARIF_PAJAK, entTaKartuPajakHiburan.getTarifPajak());
                
                pstTaKartuPajakHiburan.setInt(FLD_JML_PERTUNJUKAN1, entTaKartuPajakHiburan.getJmlPertunjukan1());
                pstTaKartuPajakHiburan.setInt(FLD_JML_PERTUNJUKAN2, entTaKartuPajakHiburan.getJmlPertunjukan2());
                pstTaKartuPajakHiburan.setInt(FLD_JML_PENGUNJUNG1, entTaKartuPajakHiburan.getJmlPengunjung2());
                pstTaKartuPajakHiburan.setInt(FLD_JML_PENGUNJUNG2, entTaKartuPajakHiburan.getJmlPengunjung2());
                pstTaKartuPajakHiburan.setDouble(FLD_HTM, entTaKartuPajakHiburan.getHtm());
                pstTaKartuPajakHiburan.setInt(FLD_JML_MESIN, entTaKartuPajakHiburan.getJmlMesin());
                pstTaKartuPajakHiburan.setDouble(FLD_TARIF_MEJA, entTaKartuPajakHiburan.getTarifMeja());
                pstTaKartuPajakHiburan.setInt(FLD_RATA_KEGIATAN, entTaKartuPajakHiburan.getRataKegiatan());
                pstTaKartuPajakHiburan.setInt(FLD_JML_RUANGAN, entTaKartuPajakHiburan.getJmlRuangan());
                pstTaKartuPajakHiburan.setInt(FLD_KARCIS_BEBAS, entTaKartuPajakHiburan.getKarcisBebas());
                pstTaKartuPajakHiburan.setInt(FLD_JML_KARCIS_BEBAS, entTaKartuPajakHiburan.getJmlKarcisBebas());
                pstTaKartuPajakHiburan.setInt(FLD_MESIN_TIKET, entTaKartuPajakHiburan.getMesinTiket());
                pstTaKartuPajakHiburan.setInt(FLD_PEMBUKUAN, entTaKartuPajakHiburan.getPembukuan());
            
            
            pstTaKartuPajakHiburan.insert();
           // entTaKartuPajakHiburan.setOID(pstTaKartuPajakHiburan.getlong(FLD_TAKARTUPAJAKHIBURANID));
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstTaKartuPajakHiburan(0), DBException.UNKNOWN);
        }
        return entTaKartuPajakHiburan.getOID();
    }
    @Override
    public long insertExc(Entity entity) throws Exception {
        return insertExc((TaKartuPajakHiburan) entity);
    }
    
    public static void resultToObject(ResultSet rs, TaKartuPajakHiburan entTaKartuPajakHiburan) {
        
        try {
            
//            entTaKartuPajakHiburan.setOID(rs.getLong(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_TAKARTUPAJAKHIBURANID]));
            entTaKartuPajakHiburan.setTahun(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_TAHUN]));
            entTaKartuPajakHiburan.setNoSPT(rs.getString(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_NO_SPT]));
            entTaKartuPajakHiburan.setKdRek1(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KD_REK_1]));
            entTaKartuPajakHiburan.setKdRek2(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KD_REK_2]));
            entTaKartuPajakHiburan.setKdRek3(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KD_REK_3]));
            entTaKartuPajakHiburan.setKdRek4(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KD_REK_4]));
            entTaKartuPajakHiburan.setKdRek5(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KD_REK_5]));
            entTaKartuPajakHiburan.setKdRek6(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KD_REK_6]));
            entTaKartuPajakHiburan.setDasarPengenaan(rs.getDouble(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_DASAR_PENGENAAN]));
            entTaKartuPajakHiburan.setPajakTerhutang(rs.getDouble(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_PAJAK_TERHUTANG]));
            entTaKartuPajakHiburan.setTarifPajak(rs.getDouble(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_TARIF_PAJAK]));
           
            entTaKartuPajakHiburan.setJmlPertunjukan1(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_PERTUNJUKAN1]));
            entTaKartuPajakHiburan.setJmlPertunjukan2(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_PERTUNJUKAN2]));
            entTaKartuPajakHiburan.setJmlPengunjung1(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_PENGUNJUNG2]));
            entTaKartuPajakHiburan.setJmlPengunjung2(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_PENGUNJUNG2]));
            entTaKartuPajakHiburan.setHtm(rs.getDouble(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_HTM]));
            entTaKartuPajakHiburan.setJmlMesin(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_MESIN]));
            entTaKartuPajakHiburan.setTarifMeja(rs.getDouble(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_TARIF_MEJA]));
            entTaKartuPajakHiburan.setRataKegiatan(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_RATA_KEGIATAN]));
            entTaKartuPajakHiburan.setJmlRuangan(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_RUANGAN]));
            entTaKartuPajakHiburan.setKarcisBebas(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_KARCIS_BEBAS]));
            entTaKartuPajakHiburan.setJmlKarcisBebas(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_JML_KARCIS_BEBAS]));
            entTaKartuPajakHiburan.setMesinTiket(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_MESIN_TIKET]));
            entTaKartuPajakHiburan.setPembukuan(rs.getInt(PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_PEMBUKUAN]));
            
            
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
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKHIBURAN;
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
                TaKartuPajakHiburan entTaKartuPajakHiburan = new TaKartuPajakHiburan();
                resultToObject(rs, entTaKartuPajakHiburan);
                lists.add(entTaKartuPajakHiburan);
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

    public static boolean checkOID(long entTaKartuPajakHiburanId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_TAKARTUPAJAKHIBURAN + " WHERE "
                    + PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_HTM] + " = " + entTaKartuPajakHiburanId;
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }

    public static int getCount(String whereClause) {
        DBResultSet dbrs = null;
        try {
            String sql = "SELECT COUNT(" + PstTaKartuPajakHiburan.fieldNames[PstTaKartuPajakHiburan.FLD_DASAR_PENGENAAN] + ") FROM " + TBL_TAKARTUPAJAKHIBURAN;
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

    public static int findLimitStart(long oid, int recordToGet, String whereClause, String orderClause) {
        int size = getCount(whereClause);
        int start = 0;
        boolean found = false;
        for (int i = 0; (i < size) && !found; i = i + recordToGet) {
            Vector list = list(i, recordToGet, whereClause, orderClause);
            start = i;
            if (list.size() > 0) {
                for (int ls = 0; ls < list.size(); ls++) {
                    TaKartuPajakHiburan entTaKartuPajakHiburan = (TaKartuPajakHiburan) list.get(ls);
                    if (oid == entTaKartuPajakHiburan.getOID()) {
                        found = true;
                    }
                }
            }
        }
        if ((start >= size) && (size > 0)) {
            start = start - recordToGet;
        }
        return start;
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
