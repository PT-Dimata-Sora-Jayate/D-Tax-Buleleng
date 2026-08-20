/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.payment;

/**
 *
 * @author IanRizky
 */

import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import java.sql.*;
import com.dimata.util.lang.I_Language;
import com.dimata.qdep.db.*;
import com.dimata.qdep.entity.*;
import com.dimata.util.Command;
import java.util.Vector;

public class PstPaymentBphtbRaversalIprotax extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {

    public static final String TBL_PAYMENTBPHTBREVERSALIPROTAX = "IPROTAXBPHTB.PEMBAYARAN_BPHTB_REVERSAL";
    public static final int FLD_KDPROPINSI = 0;
    public static final int FLD_KDDATI2 = 1;
    public static final int FLD_THNBPHTB = 2;
    public static final int FLD_BLNBPHTB = 3;
    public static final int FLD_TGLBPHTB = 4;
    public static final int FLD_NOURUTBPHTB = 5;
    public static final int FLD_INDEKSBPHTB = 6;
	public static final int FLD_NOTRANSAKSIBYR = 7;
    public static final int FLD_KDPEJABAT = 8;
    public static final int FLD_KDBANKTUNGGAL = 9;
    public static final int FLD_KDBANKPERSEPSI = 10;
	public static final int FLD_KDTP = 11;
    public static final int FLD_TGLPEMBAYARAN = 12;
    public static final int FLD_NAMAWP = 13;
	public static final int FLD_NAMAPENYETOR = 14;
    public static final int FLD_BPHTBKURANGBAYAR = 15;
    public static final int FLD_BPHTBSUDAHBAYAR = 16;
    public static final int FLD_KDKECAMATANOP = 17;
    public static final int FLD_KDKELURAHANOP = 18;
    public static final int FLD_KDBLOKOP = 19;
    public static final int FLD_NOURUTOP = 20;
    public static final int FLD_KDJENISOP = 21;
    public static final int FLD_TGLKETETAPAN = 22;
	public static final int FLD_KETREVERSALBYR = 23;
	public static final int FLD_TGLREVERSALBYR = 24;
    public static final int FLD_USERBANKREKAM = 25;
	public static final int FLD_USERBANKREVERSAL = 26;
    public static final int FLD_KDSUMBERDATA = 27;
	public static final int FLD_NOTRANSAKSIBYRBANK = 28;
	public static final int FLD_ID_REVERSAL = 29;

    public static String[] fieldNames = {
		"KD_PROPINSI",
		"KD_DATI2",
		"THN_BPHTB",
		"BLN_BPHTB",
		"TGL_BPHTB",
		"NO_URUT_BPHTB",
		"INDEKS_BPHTB",
		"NO_TRANSAKSI_BYR",
		"KD_PEJABAT",
		"KD_BANK_TUNGGAL",
		"KD_BANK_PERSEPSI",
		"KD_TP",
		"TGL_PEMBAYARAN",
		"NAMA_WP",
		"NM_PENYETOR",
		"BPHTB_KURANG_BAYAR",
		"BPHTB_SDH_DIBAYAR",
		"KD_KECAMATAN_OP",
		"KD_KELURAHAN_OP",
		"KD_BLOK_OP",
		"NO_URUT_OP",
		"KD_JNS_OP",
		"TGL_KETETAPAN",
		"KET_REVERSAL_BYR",
		"TGL_REVERSAL_BYR",
		"USER_BANK_REKAM",
		"USER_BANK_REVERSAL",
		"KD_SUMBER_DATA",
		"NO_TRANSAKSI_BYR_BANK",
		"ID_REVERSAL"
    };

    public static int[] fieldTypes = {
        TYPE_STRING,//2
        TYPE_STRING,//3
        TYPE_STRING,//4
        TYPE_STRING,//5
        TYPE_STRING,//6
        TYPE_STRING,//7
        TYPE_STRING,//8
        TYPE_STRING,//9
        TYPE_STRING,//10
		TYPE_STRING,//11
        TYPE_STRING,//12
        TYPE_STRING,//13
        TYPE_DATE,//14
        TYPE_STRING,//15
        TYPE_STRING,//16
        TYPE_FLOAT,//17
        TYPE_FLOAT,//18
        TYPE_STRING,//19
        TYPE_STRING,//20
        TYPE_STRING,//21
        TYPE_STRING,//22
        TYPE_STRING,//23
        TYPE_DATE,//24
        TYPE_STRING,//25
		TYPE_DATE,//26
		TYPE_STRING,//27
		TYPE_STRING,//28
		TYPE_STRING,//29
		TYPE_STRING,//30
		TYPE_INT
    };

    public PstPaymentBphtbRaversalIprotax() {
    }

    public PstPaymentBphtbRaversalIprotax(int i) throws DBException {
        super(new PstPaymentBphtbRaversalIprotax());
    }

    public PstPaymentBphtbRaversalIprotax(String sOid) throws DBException {
        super(new PstPaymentBphtbRaversalIprotax(0));
        if (!locate(sOid)) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        } else {
            return;
        }
    }

    public PstPaymentBphtbRaversalIprotax(long lOid) throws DBException {
        super(new PstPaymentBphtbRaversalIprotax(0));
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

    public int getFieldSize() {
        return fieldNames.length;
    }

    public String getTableName() {
        return TBL_PAYMENTBPHTBREVERSALIPROTAX;
    }

    public String[] getFieldNames() {
        return fieldNames;
    }

    public int[] getFieldTypes() {
        return fieldTypes;
    }

    public String getPersistentName() {
        return new PstPaymentBphtbRaversalIprotax().getClass().getName();
    }

    public static PaymentBphtbRaversalIprotax fetchExc(long oid) throws DBException {
        try {
            PaymentBphtbRaversalIprotax entPaymentBphtbprotax = new PaymentBphtbRaversalIprotax();
            PstPaymentBphtbRaversalIprotax pstPaymentBphtbRaversalIprotax = new PstPaymentBphtbRaversalIprotax(oid);
            entPaymentBphtbprotax.setOID(oid);
            entPaymentBphtbprotax.setKdDati2(pstPaymentBphtbRaversalIprotax.getString(FLD_KDDATI2));
            entPaymentBphtbprotax.setThbBphtb(pstPaymentBphtbRaversalIprotax.getString(FLD_THNBPHTB));
            entPaymentBphtbprotax.setBlnBphtb(pstPaymentBphtbRaversalIprotax.getString(FLD_BLNBPHTB));
            entPaymentBphtbprotax.setTglBphtb(pstPaymentBphtbRaversalIprotax.getString(FLD_TGLBPHTB));
            entPaymentBphtbprotax.setNoUrutBphtb(pstPaymentBphtbRaversalIprotax.getString(FLD_NOURUTBPHTB));
            entPaymentBphtbprotax.setIndeksBphtb(pstPaymentBphtbRaversalIprotax.getString(FLD_INDEKSBPHTB));
			entPaymentBphtbprotax.setNoTransaksiBayar(pstPaymentBphtbRaversalIprotax.getString(FLD_NOTRANSAKSIBYR));
            entPaymentBphtbprotax.setKdPejabat(pstPaymentBphtbRaversalIprotax.getString(FLD_KDPEJABAT));
			entPaymentBphtbprotax.setKdBankTunggal(pstPaymentBphtbRaversalIprotax.getString(FLD_KDBANKTUNGGAL));
			entPaymentBphtbprotax.setKdBankPersepsi(pstPaymentBphtbRaversalIprotax.getString(FLD_KDBANKPERSEPSI));
			entPaymentBphtbprotax.setKdTp(pstPaymentBphtbRaversalIprotax.getString(FLD_KDTP));
            entPaymentBphtbprotax.setTglPembayaran(pstPaymentBphtbRaversalIprotax.getDate(FLD_TGLPEMBAYARAN));
            entPaymentBphtbprotax.setNamaWP(pstPaymentBphtbRaversalIprotax.getString(FLD_NAMAWP));
			entPaymentBphtbprotax.setNmPenyetor(pstPaymentBphtbRaversalIprotax.getString(FLD_NAMAPENYETOR));
            entPaymentBphtbprotax.setBphtbKurangBayar(pstPaymentBphtbRaversalIprotax.getdouble(FLD_BPHTBKURANGBAYAR));
            entPaymentBphtbprotax.setBphtbSdhBayar(pstPaymentBphtbRaversalIprotax.getdouble(FLD_BPHTBSUDAHBAYAR));
            entPaymentBphtbprotax.setKdKecamatanOp(pstPaymentBphtbRaversalIprotax.getString(FLD_KDKECAMATANOP));
            entPaymentBphtbprotax.setKdKelurahanOp(pstPaymentBphtbRaversalIprotax.getString(FLD_KDKELURAHANOP));
            entPaymentBphtbprotax.setKdBlokOp(pstPaymentBphtbRaversalIprotax.getString(FLD_KDBLOKOP));
            entPaymentBphtbprotax.setNoUrutOp(pstPaymentBphtbRaversalIprotax.getString(FLD_NOURUTOP));
            entPaymentBphtbprotax.setKdJnsOp(pstPaymentBphtbRaversalIprotax.getString(FLD_KDJENISOP));
            entPaymentBphtbprotax.setTglketetapan(pstPaymentBphtbRaversalIprotax.getDate(FLD_TGLKETETAPAN));
			entPaymentBphtbprotax.setKetReversalByr(pstPaymentBphtbRaversalIprotax.getString(FLD_KETREVERSALBYR));
			entPaymentBphtbprotax.setTglReversalByr(pstPaymentBphtbRaversalIprotax.getDate(FLD_TGLREVERSALBYR));
			entPaymentBphtbprotax.setUserBankRekam(pstPaymentBphtbRaversalIprotax.getString(FLD_USERBANKREKAM));
			entPaymentBphtbprotax.setUserBankReversal(pstPaymentBphtbRaversalIprotax.getString(FLD_USERBANKREVERSAL));
			entPaymentBphtbprotax.setKdSumberData(pstPaymentBphtbRaversalIprotax.getString(FLD_KDSUMBERDATA));
            entPaymentBphtbprotax.setNoTransBayarBank(pstPaymentBphtbRaversalIprotax.getString(FLD_NOTRANSAKSIBYRBANK));
			entPaymentBphtbprotax.setIdReversal(pstPaymentBphtbRaversalIprotax.getInt(FLD_ID_REVERSAL));
            return entPaymentBphtbprotax;
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPbbIprotax(0), DBException.UNKNOWN);
        }
    }

    public long fetchExc(Entity entity) throws Exception {
        PaymentBphtbRaversalIprotax entPaymentBphtbRaversalIprotax = fetchExc(entity.getOID());
        entity = (Entity) entPaymentBphtbRaversalIprotax;
        return entPaymentBphtbRaversalIprotax.getOID();
    }

    public static synchronized long updateExc(PaymentBphtbRaversalIprotax entPaymentBphtbRaversalIprotax) throws DBException {
        try {
            if (entPaymentBphtbRaversalIprotax.getOID() != 0) {
                PstPaymentBphtbRaversalIprotax pstPaymentBphtbRaversalIprotax = new PstPaymentBphtbRaversalIprotax(entPaymentBphtbRaversalIprotax.getOID());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KDPROPINSI, entPaymentBphtbRaversalIprotax.getKdProvinsi());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDDATI2, entPaymentBphtbRaversalIprotax.getKdDati2());
                pstPaymentBphtbRaversalIprotax.setString(FLD_THNBPHTB, entPaymentBphtbRaversalIprotax.getThbBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_BLNBPHTB, entPaymentBphtbRaversalIprotax.getBlnBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_TGLBPHTB, entPaymentBphtbRaversalIprotax.getTglBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_NOURUTBPHTB, entPaymentBphtbRaversalIprotax.getNoUrutBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_INDEKSBPHTB, entPaymentBphtbRaversalIprotax.getIndeksBphtb());
				pstPaymentBphtbRaversalIprotax.setString(FLD_NOTRANSAKSIBYR, entPaymentBphtbRaversalIprotax.getNoTransaksiBayar());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDPEJABAT, entPaymentBphtbRaversalIprotax.getKdPejabat());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDBANKTUNGGAL, entPaymentBphtbRaversalIprotax.getKdBankTunggal());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDBANKPERSEPSI, entPaymentBphtbRaversalIprotax.getKdBankPersepsi());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KDTP, entPaymentBphtbRaversalIprotax.getKdTp());
                pstPaymentBphtbRaversalIprotax.setDate(FLD_TGLPEMBAYARAN, entPaymentBphtbRaversalIprotax.getTglPembayaran());
                pstPaymentBphtbRaversalIprotax.setString(FLD_NAMAWP, entPaymentBphtbRaversalIprotax.getNamaWP());
				pstPaymentBphtbRaversalIprotax.setString(FLD_NAMAPENYETOR, entPaymentBphtbRaversalIprotax.getNmPenyetor());
                pstPaymentBphtbRaversalIprotax.setDouble(FLD_BPHTBKURANGBAYAR, entPaymentBphtbRaversalIprotax.getBphtbKurangBayar());
                pstPaymentBphtbRaversalIprotax.setDouble(FLD_BPHTBSUDAHBAYAR, entPaymentBphtbRaversalIprotax.getBphtbSdhBayar());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDKECAMATANOP, entPaymentBphtbRaversalIprotax.getKdKecamatanOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDKELURAHANOP, entPaymentBphtbRaversalIprotax.getKdKelurahanOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDBLOKOP, entPaymentBphtbRaversalIprotax.getKdBlokOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_NOURUTOP, entPaymentBphtbRaversalIprotax.getNoUrutOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDJENISOP, entPaymentBphtbRaversalIprotax.getKdJnsOp());
                pstPaymentBphtbRaversalIprotax.setDate(FLD_TGLKETETAPAN, entPaymentBphtbRaversalIprotax.getTglketetapan());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KETREVERSALBYR, entPaymentBphtbRaversalIprotax.getKetReversalByr());
				pstPaymentBphtbRaversalIprotax.setDate(FLD_TGLREVERSALBYR, entPaymentBphtbRaversalIprotax.getTglReversalByr());
                pstPaymentBphtbRaversalIprotax.setString(FLD_USERBANKREKAM, entPaymentBphtbRaversalIprotax.getUserBankRekam());
                pstPaymentBphtbRaversalIprotax.setString(FLD_USERBANKREVERSAL, entPaymentBphtbRaversalIprotax.getUserBankReversal());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KDSUMBERDATA, entPaymentBphtbRaversalIprotax.getKdSumberData());
				pstPaymentBphtbRaversalIprotax.setString(FLD_NOTRANSAKSIBYRBANK, entPaymentBphtbRaversalIprotax.getNoTransBayarBank());
				pstPaymentBphtbRaversalIprotax.setInt(FLD_ID_REVERSAL, entPaymentBphtbRaversalIprotax.getIdReversal());
                pstPaymentBphtbRaversalIprotax.update();
                return entPaymentBphtbRaversalIprotax.getOID();
            }
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentBphtbRaversalIprotax(0), DBException.UNKNOWN);
        }
        return 0;
    }

    public long updateExc(Entity entity) throws Exception {
        return updateExc((PaymentBphtbRaversalIprotax) entity);
    }

    public static synchronized long deleteExc(long oid) throws DBException {
        try {
            PstPaymentBphtbRaversalIprotax pstPaymentBphtbRaversalIprotax = new PstPaymentBphtbRaversalIprotax(oid);
            pstPaymentBphtbRaversalIprotax.delete();
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentPbbIprotax(0), DBException.UNKNOWN);
        }
        return oid;
    }

    public long deleteExc(Entity entity) throws Exception {
        if (entity == null) {
            throw new DBException(this, DBException.RECORD_NOT_FOUND);
        }
        return deleteExc(entity.getOID());
    }

    public static synchronized long insertExc(PaymentBphtbRaversalIprotax entPaymentBphtbRaversalIprotax) throws DBException {
        try {
            PstPaymentBphtbRaversalIprotax pstPaymentBphtbRaversalIprotax = new PstPaymentBphtbRaversalIprotax(0);
            pstPaymentBphtbRaversalIprotax.setString(FLD_KDPROPINSI, entPaymentBphtbRaversalIprotax.getKdProvinsi());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDDATI2, entPaymentBphtbRaversalIprotax.getKdDati2());
                pstPaymentBphtbRaversalIprotax.setString(FLD_THNBPHTB, entPaymentBphtbRaversalIprotax.getThbBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_BLNBPHTB, entPaymentBphtbRaversalIprotax.getBlnBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_TGLBPHTB, entPaymentBphtbRaversalIprotax.getTglBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_NOURUTBPHTB, entPaymentBphtbRaversalIprotax.getNoUrutBphtb());
                pstPaymentBphtbRaversalIprotax.setString(FLD_INDEKSBPHTB, entPaymentBphtbRaversalIprotax.getIndeksBphtb());
				pstPaymentBphtbRaversalIprotax.setString(FLD_NOTRANSAKSIBYR, entPaymentBphtbRaversalIprotax.getNoTransaksiBayar());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDPEJABAT, entPaymentBphtbRaversalIprotax.getKdPejabat());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDBANKTUNGGAL, entPaymentBphtbRaversalIprotax.getKdBankTunggal());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDBANKPERSEPSI, entPaymentBphtbRaversalIprotax.getKdBankPersepsi());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KDTP, entPaymentBphtbRaversalIprotax.getKdTp());
                pstPaymentBphtbRaversalIprotax.setDate(FLD_TGLPEMBAYARAN, entPaymentBphtbRaversalIprotax.getTglPembayaran());
                pstPaymentBphtbRaversalIprotax.setString(FLD_NAMAWP, entPaymentBphtbRaversalIprotax.getNamaWP());
				pstPaymentBphtbRaversalIprotax.setString(FLD_NAMAPENYETOR, entPaymentBphtbRaversalIprotax.getNmPenyetor());
                pstPaymentBphtbRaversalIprotax.setDouble(FLD_BPHTBKURANGBAYAR, entPaymentBphtbRaversalIprotax.getBphtbKurangBayar());
                pstPaymentBphtbRaversalIprotax.setDouble(FLD_BPHTBSUDAHBAYAR, entPaymentBphtbRaversalIprotax.getBphtbSdhBayar());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDKECAMATANOP, entPaymentBphtbRaversalIprotax.getKdKecamatanOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDKELURAHANOP, entPaymentBphtbRaversalIprotax.getKdKelurahanOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDBLOKOP, entPaymentBphtbRaversalIprotax.getKdBlokOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_NOURUTOP, entPaymentBphtbRaversalIprotax.getNoUrutOp());
                pstPaymentBphtbRaversalIprotax.setString(FLD_KDJENISOP, entPaymentBphtbRaversalIprotax.getKdJnsOp());
                pstPaymentBphtbRaversalIprotax.setDate(FLD_TGLKETETAPAN, entPaymentBphtbRaversalIprotax.getTglketetapan());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KETREVERSALBYR, entPaymentBphtbRaversalIprotax.getKetReversalByr());
				pstPaymentBphtbRaversalIprotax.setDate(FLD_TGLREVERSALBYR, entPaymentBphtbRaversalIprotax.getTglReversalByr());
                pstPaymentBphtbRaversalIprotax.setString(FLD_USERBANKREKAM, entPaymentBphtbRaversalIprotax.getUserBankRekam());
                pstPaymentBphtbRaversalIprotax.setString(FLD_USERBANKREVERSAL, entPaymentBphtbRaversalIprotax.getUserBankReversal());
				pstPaymentBphtbRaversalIprotax.setString(FLD_KDSUMBERDATA, entPaymentBphtbRaversalIprotax.getKdSumberData());
				pstPaymentBphtbRaversalIprotax.setString(FLD_NOTRANSAKSIBYRBANK, entPaymentBphtbRaversalIprotax.getNoTransBayarBank());
				pstPaymentBphtbRaversalIprotax.setInt(FLD_ID_REVERSAL, entPaymentBphtbRaversalIprotax.getIdReversal());
            
            pstPaymentBphtbRaversalIprotax.insert();
            entPaymentBphtbRaversalIprotax.setOID(1);
        } catch (DBException dbe) {
            throw dbe;
        } catch (Exception e) {
            throw new DBException(new PstPaymentBphtbRaversalIprotax(0), DBException.UNKNOWN);
        }
        return entPaymentBphtbRaversalIprotax.getOID();
    }

    public long insertExc(Entity entity) throws Exception {
        return insertExc((PaymentPbbIprotax) entity);
    }

    public static void resultToObject(ResultSet rs, PaymentBphtbRaversalIprotax entPaymentBphtbRaversalIprotax) {
        try {
            
            //entPaymentPbbIprotax.setOID(rs.getLong(PstPaymentPbbRaversalIprotax.fieldNames[PstPaymentPbbRaversalIprotax.FLD_IDRAVERSAL]));
			entPaymentBphtbRaversalIprotax.setKdProvinsi(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDPROPINSI]));
            entPaymentBphtbRaversalIprotax.setKdDati2(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDDATI2]));
            entPaymentBphtbRaversalIprotax.setThbBphtb(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_THNBPHTB]));
            entPaymentBphtbRaversalIprotax.setBlnBphtb(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_BLNBPHTB]));
            entPaymentBphtbRaversalIprotax.setTglBphtb(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_TGLBPHTB]));
            entPaymentBphtbRaversalIprotax.setNoUrutBphtb(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_NOURUTBPHTB]));
            entPaymentBphtbRaversalIprotax.setIndeksBphtb(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_INDEKSBPHTB]));
			entPaymentBphtbRaversalIprotax.setNoTransaksiBayar(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_NOTRANSAKSIBYR]));
            entPaymentBphtbRaversalIprotax.setKdPejabat(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDPEJABAT]));
			entPaymentBphtbRaversalIprotax.setKdBankTunggal(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDBANKTUNGGAL]));
            entPaymentBphtbRaversalIprotax.setKdBankPersepsi(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDBANKPERSEPSI]));
			entPaymentBphtbRaversalIprotax.setKdTp(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDTP]));
            entPaymentBphtbRaversalIprotax.setTglPembayaran(rs.getDate(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_TGLPEMBAYARAN]));
            entPaymentBphtbRaversalIprotax.setNamaWP(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_NAMAWP]));
			entPaymentBphtbRaversalIprotax.setNmPenyetor(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_NAMAPENYETOR]));
            entPaymentBphtbRaversalIprotax.setBphtbKurangBayar(rs.getDouble(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_BPHTBKURANGBAYAR]));
            entPaymentBphtbRaversalIprotax.setBphtbSdhBayar(rs.getDouble(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_BPHTBSUDAHBAYAR]));
            entPaymentBphtbRaversalIprotax.setKdKecamatanOp(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDKECAMATANOP]));
            entPaymentBphtbRaversalIprotax.setKdKelurahanOp(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDKELURAHANOP]));
            entPaymentBphtbRaversalIprotax.setKdBlokOp(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDBLOKOP]));
            entPaymentBphtbRaversalIprotax.setNoUrutOp(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_NOURUTOP]));
            entPaymentBphtbRaversalIprotax.setKdJnsOp(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDJENISOP]));
            entPaymentBphtbRaversalIprotax.setTglketetapan(rs.getDate(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_TGLKETETAPAN]));
			entPaymentBphtbRaversalIprotax.setKetReversalByr(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KETREVERSALBYR]));
			entPaymentBphtbRaversalIprotax.setTglReversalByr(rs.getDate(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_TGLREVERSALBYR]));
            entPaymentBphtbRaversalIprotax.setUserBankRekam(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_USERBANKREKAM]));
			entPaymentBphtbRaversalIprotax.setUserBankReversal(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_USERBANKREVERSAL]));
            entPaymentBphtbRaversalIprotax.setKdSumberData(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDSUMBERDATA]));
			entPaymentBphtbRaversalIprotax.setNoTransBayarBank(rs.getString(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_NOTRANSAKSIBYRBANK]));
			entPaymentBphtbRaversalIprotax.setIdReversal(rs.getInt(PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_ID_REVERSAL]));
            
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
            String sql = "SELECT * FROM " + TBL_PAYMENTBPHTBREVERSALIPROTAX;
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
			System.out.println("query bphtb raversal : "+sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                PaymentBphtbRaversalIprotax entPaymentBphtbRaversalIprotax = new PaymentBphtbRaversalIprotax();
                resultToObject(rs, entPaymentBphtbRaversalIprotax);
                lists.add(entPaymentBphtbRaversalIprotax);
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

    public static boolean checkOID(long entPaymentBphtbRaversalIprotaxId) {
        DBResultSet dbrs = null;
        boolean result = false;
        try {
            String sql = "SELECT * FROM " + TBL_PAYMENTBPHTBREVERSALIPROTAX + " WHERE "
                    + PstPaymentBphtbRaversalIprotax.fieldNames[PstPaymentBphtbRaversalIprotax.FLD_KDPROPINSI] + " = " + entPaymentBphtbRaversalIprotaxId;
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
	
	public static int getLastId() {
        DBResultSet dbrs = null;
        int result = 0;
        try {
            String sql = "SELECT MAX(ID_REVERSAL) FROM " + TBL_PAYMENTBPHTBREVERSALIPROTAX;
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return result;
        }
    }
	
	public static BphtbIprotax checkNOp(String  entNop, String tahun) {
        DBResultSet dbrs = null;
        BphtbIprotax entBphtbIprotax = null;
        try {
            String sql = "SELECT * FROM VIEW_BPHTB_ALL WHERE NO_ID  = '" + entNop+"'";
            dbrs = DBHandler.execQueryResult(sql);
            ResultSet rs = dbrs.getResultSet();
            while (rs.next()) {
                entBphtbIprotax=new BphtbIprotax();
                entBphtbIprotax.setNoId(rs.getString("NO_ID"));
                entBphtbIprotax.setKdPropinsi(rs.getString("KD_PROPINSI"));
                entBphtbIprotax.setKdDati2(rs.getString("KD_DATI2"));
                entBphtbIprotax.setThnBphtb(rs.getString("THN_BPHTB"));
				entBphtbIprotax.setBlnBphtb(rs.getString("BLN_BPHTB"));
                entBphtbIprotax.setTglBphtb(rs.getString("TGL_BPHTB"));
                entBphtbIprotax.setNoUrutBphtb(rs.getString("NO_URUT_BPHTB"));
                entBphtbIprotax.setIndeksBphtb(rs.getString("INDEKS_BPHTB"));
                entBphtbIprotax.setKdPejabat(rs.getString("KD_PEJABAT"));
                entBphtbIprotax.setKdBankTunggal(rs.getString("KD_BANK_TUNGGAL"));
                entBphtbIprotax.setKdBankPersepsi(rs.getString("KD_BANK_PERSEPSI"));
                entBphtbIprotax.setNama(rs.getString("NAMA"));
                entBphtbIprotax.setJumTagihan(rs.getString("JUM_TAGIHAN"));
                entBphtbIprotax.setsNoId(rs.getString("SNOID"));
                entBphtbIprotax.setPpat(rs.getString("PPAT"));
                entBphtbIprotax.setKdKecamatanOp(rs.getString("KD_KECAMATAN_OP"));
                entBphtbIprotax.setKdKelurahanOp(rs.getString("KD_KELURAHAN_OP"));
                entBphtbIprotax.setKdBlokOp(rs.getString("KD_BLOK_OP"));
                entBphtbIprotax.setNoUrutOp(rs.getString("NO_URUT_OP"));
                entBphtbIprotax.setKdJenisOp(rs.getString("KD_JNS_OP"));
 
            }
            rs.close();
            return entBphtbIprotax;
        } catch (Exception e) {
            System.out.println("err : " + e.toString());
        } finally {
            DBResultSet.close(dbrs);
            return entBphtbIprotax;
        }
    }
	
	public static int DeleteDataPembayaran(String idPaymentBank) {

        int iResult = 0;
        DBResultSet dbrs = null;
        String stSql = " DELETE FROM IPROTAXPBB.PEMBAYARAN_BPHTB WHERE "+
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