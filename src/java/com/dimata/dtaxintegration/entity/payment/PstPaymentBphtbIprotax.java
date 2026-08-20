    package com.dimata.dtaxintegration.entity.payment;

import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.qdep.db.I_DBInterface;
import com.dimata.qdep.db.I_DBType;
import com.dimata.qdep.entity.Entity;
import com.dimata.qdep.entity.I_PersintentExc;
import com.dimata.util.lang.I_Language;
import com.dimata.webclient.AppSetting;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class PstPaymentBphtbIprotax extends DBHandler implements I_DBInterface, I_DBType, I_PersintentExc, I_Language {
   public static final String TBL_PAYMENTBPHTBIPROTAX = "IPROTAXBPHTB.PEMBAYARAN_SSPD";
   public static final int FLD_KDPROPINSI = 0;
   public static final int FLD_KDDATI2 = 1;
   public static final int FLD_THNBPHTB = 2;
   public static final int FLD_BLNBPHTB = 3;
   public static final int FLD_TGLBPHTB = 4;
   public static final int FLD_NOURUTBPHTB = 5;
   public static final int FLD_INDEKSBPHTB = 6;
   public static final int FLD_KDPEJABAT = 7;
   public static final int FLD_KDBANKTUNGGAL = 8;
   public static final int FLD_KDBANKPERSEPSI = 9;
   public static final int FLD_TGLPEMBAYARAN = 10;
   public static final int FLD_NAMAWP = 11;
   public static final int FLD_BPHTBKURANGBAYAR = 12;
   public static final int FLD_BPHTBSUDAHBAYAR = 13;
   public static final int FLD_KDTP = 14;
   public static final int FLD_USERBANKREKAM = 15;
   public static final int FLD_NMPENYETOR = 16;
   public static final int FLD_KDSUMBERDATA = 17;
   public static final int FLD_NOTRANSAKSIBYRBANK = 18;
   public static final int FLD_ISO_MESSAGE_ID = 19;
   public static final int FLD_NOTRANSAKSIBYR = 20;
   public static final int FLD_REKAM_BAYAR = 21;
   public static final int FLD_REKON_BAYAR = 22;
   public static String[] fieldNames = new String[]{"KD_PROPINSI", "KD_DATI2", "THN_BPHTB", "BLN_BPHTB", "TGL_BPHTB", "NO_URUT_BPHTB", "INDEKS_BPHTB", "KD_PEJABAT", "KD_BANK_TUNGGAL", "KD_BANK_PERSEPSI", "TGL_PEMBAYARAN", "NAMA_WP", "BPHTB_KURANG_BAYAR", "BPHTB_SDH_DIBAYAR", "KD_TP", "USER_BANK_REKAM", "NM_PENYETOR", "KD_SUMBER_DATA", "NO_TRANSAKSI_BYR_BANK", "ISO_MESSAGE_ID", "NO_TRANSAKSI_BYR", "TGL_REKAM_BYR", "TGL_REKON_BAYAR"};
   public static int[] fieldTypes = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 3, 3};

   public PstPaymentBphtbIprotax() {
   }

   public PstPaymentBphtbIprotax(int i) throws DBException {
      super(new PstPaymentBphtbIprotax());
   }

   public PstPaymentBphtbIprotax(String sOid) throws DBException {
      super(new PstPaymentBphtbIprotax(0));
      if (!this.locate(sOid)) {
         throw new DBException(this, 14);
      }
   }

   public PstPaymentBphtbIprotax(long lOid) throws DBException {
      super(new PstPaymentBphtbIprotax(0));
      String sOid = "0";

      try {
         sOid = String.valueOf(lOid);
      } catch (Exception var5) {
         throw new DBException(this, 14);
      }

      if (!this.locate(sOid)) {
         throw new DBException(this, 14);
      }
   }

   public int getFieldSize() {
      return fieldNames.length;
   }

   public String getTableName() {
      return "IPROTAXBPHTB.PEMBAYARAN_SSPD";
   }

   public String[] getFieldNames() {
      return fieldNames;
   }

   public int[] getFieldTypes() {
      return fieldTypes;
   }

   public String getPersistentName() {
      return (new PstPaymentPbbIprotax()).getClass().getName();
   }

   public static PaymentBphtbIprotax fetchExc(long oid) throws DBException {
      try {
         PaymentBphtbIprotax entPaymentBphtbprotax = new PaymentBphtbIprotax();
         PstPaymentBphtbIprotax pstPaymentBphtbIprotax = new PstPaymentBphtbIprotax(oid);
         entPaymentBphtbprotax.setOID(oid);
         entPaymentBphtbprotax.setKdDati2(pstPaymentBphtbIprotax.getString(1));
         entPaymentBphtbprotax.setThbBphtb(pstPaymentBphtbIprotax.getString(2));
         entPaymentBphtbprotax.setBlnBphtb(pstPaymentBphtbIprotax.getString(3));
         entPaymentBphtbprotax.setTglBphtb(pstPaymentBphtbIprotax.getString(4));
         entPaymentBphtbprotax.setNoUrutBphtb(pstPaymentBphtbIprotax.getString(5));
         entPaymentBphtbprotax.setIndeksBphtb(pstPaymentBphtbIprotax.getString(6));
         entPaymentBphtbprotax.setKdPejabat(pstPaymentBphtbIprotax.getString(7));
         entPaymentBphtbprotax.setKdBankPersepsi(pstPaymentBphtbIprotax.getString(9));
         entPaymentBphtbprotax.setTglPembayaran(pstPaymentBphtbIprotax.getDate(10));
         entPaymentBphtbprotax.setNamaWP(pstPaymentBphtbIprotax.getString(11));
         entPaymentBphtbprotax.setBphtbKurangBayar(pstPaymentBphtbIprotax.getdouble(12));
         entPaymentBphtbprotax.setBphtbSdhBayar(pstPaymentBphtbIprotax.getdouble(13));
         entPaymentBphtbprotax.setKdTp(pstPaymentBphtbIprotax.getString(14));
         entPaymentBphtbprotax.setUserBankRekam(pstPaymentBphtbIprotax.getString(15));
         entPaymentBphtbprotax.setNmPenyetor(pstPaymentBphtbIprotax.getString(16));
         entPaymentBphtbprotax.setKdSumberData(pstPaymentBphtbIprotax.getString(17));
         entPaymentBphtbprotax.setNoTransaksiBayar(pstPaymentBphtbIprotax.getString(20));
         entPaymentBphtbprotax.setNoTransaksiBayarBank(pstPaymentBphtbIprotax.getString(18));
         return entPaymentBphtbprotax;
      } catch (DBException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new DBException(new PstPaymentPbbIprotax(0), 1);
      }
   }

   public long fetchExc(Entity entity) throws Exception {
      PaymentBphtbIprotax entPaymentBphtbIprotax = fetchExc(entity.getOID());
      return entPaymentBphtbIprotax.getOID();
   }

   public static synchronized long updateExc(PaymentBphtbIprotax entPaymentBphtbIprotax) throws DBException {
      try {
         if (entPaymentBphtbIprotax.getOID() != 0L) {
            PstPaymentBphtbIprotax pstPaymentBphtbIprotax = new PstPaymentBphtbIprotax(entPaymentBphtbIprotax.getOID());
            pstPaymentBphtbIprotax.setString(1, entPaymentBphtbIprotax.getKdDati2());
            pstPaymentBphtbIprotax.setString(2, entPaymentBphtbIprotax.getThbBphtb());
            pstPaymentBphtbIprotax.setString(3, entPaymentBphtbIprotax.getBlnBphtb());
            pstPaymentBphtbIprotax.setString(4, entPaymentBphtbIprotax.getTglBphtb());
            pstPaymentBphtbIprotax.setString(5, entPaymentBphtbIprotax.getNoUrutBphtb());
            pstPaymentBphtbIprotax.setString(6, entPaymentBphtbIprotax.getIndeksBphtb());
            pstPaymentBphtbIprotax.setString(7, entPaymentBphtbIprotax.getKdPejabat());
            pstPaymentBphtbIprotax.setString(8, entPaymentBphtbIprotax.getKdBankTunggal());
            pstPaymentBphtbIprotax.setString(9, entPaymentBphtbIprotax.getKdBankPersepsi());
            pstPaymentBphtbIprotax.setDate(10, entPaymentBphtbIprotax.getTglPembayaran());
            pstPaymentBphtbIprotax.setString(11, entPaymentBphtbIprotax.getNamaWP());
            pstPaymentBphtbIprotax.setDouble(12, entPaymentBphtbIprotax.getBphtbKurangBayar());
            pstPaymentBphtbIprotax.setDouble(13, entPaymentBphtbIprotax.getBphtbSdhBayar());
            pstPaymentBphtbIprotax.setString(14, entPaymentBphtbIprotax.getKdTp());
            pstPaymentBphtbIprotax.setString(15, entPaymentBphtbIprotax.getUserBankRekam());
            pstPaymentBphtbIprotax.setString(16, entPaymentBphtbIprotax.getNmPenyetor());
            pstPaymentBphtbIprotax.setString(17, entPaymentBphtbIprotax.getKdSumberData());
            pstPaymentBphtbIprotax.setString(18, entPaymentBphtbIprotax.getNoTransaksiBayarBank());
            pstPaymentBphtbIprotax.setString(20, entPaymentBphtbIprotax.getNoTransaksiBayar());
            pstPaymentBphtbIprotax.setDate(21, entPaymentBphtbIprotax.getTglPembayaran());
            pstPaymentBphtbIprotax.update();
            return entPaymentBphtbIprotax.getOID();
         } else {
            return 0L;
         }
      } catch (DBException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new DBException(new PstPaymentBphtbIprotax(0), 1);
      }
   }

   public long updateExc(Entity entity) throws Exception {
      return updateExc((PaymentBphtbIprotax)entity);
   }

   public static synchronized long deleteExc(long oid) throws DBException {
      try {
         PstPaymentBphtbIprotax pstPaymentBphtbIprotax = new PstPaymentBphtbIprotax(oid);
         pstPaymentBphtbIprotax.delete();
         return oid;
      } catch (DBException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new DBException(new PstPaymentPbbIprotax(0), 1);
      }
   }

   public long deleteExc(Entity entity) throws Exception {
      if (entity == null) {
         throw new DBException(this, 14);
      } else {
         return deleteExc(entity.getOID());
      }
   }

   public static synchronized long insertExc(PaymentBphtbIprotax entPaymentBphtbIprotax) throws DBException {
      try {
         PstPaymentBphtbIprotax pstPaymentBphtbIprotax = new PstPaymentBphtbIprotax(0);
         pstPaymentBphtbIprotax.setString(0, entPaymentBphtbIprotax.getKdProvinsi());
         pstPaymentBphtbIprotax.setString(1, entPaymentBphtbIprotax.getKdDati2());
         pstPaymentBphtbIprotax.setString(2, entPaymentBphtbIprotax.getThbBphtb());
         pstPaymentBphtbIprotax.setString(3, entPaymentBphtbIprotax.getBlnBphtb());
         pstPaymentBphtbIprotax.setString(4, entPaymentBphtbIprotax.getTglBphtb());
         pstPaymentBphtbIprotax.setString(5, entPaymentBphtbIprotax.getNoUrutBphtb());
         pstPaymentBphtbIprotax.setString(6, entPaymentBphtbIprotax.getIndeksBphtb());
         pstPaymentBphtbIprotax.setString(7, entPaymentBphtbIprotax.getKdPejabat());
         pstPaymentBphtbIprotax.setString(8, entPaymentBphtbIprotax.getKdBankTunggal());
         pstPaymentBphtbIprotax.setString(9, entPaymentBphtbIprotax.getKdBankPersepsi());
         pstPaymentBphtbIprotax.setDate(10, entPaymentBphtbIprotax.getTglPembayaran());
         pstPaymentBphtbIprotax.setString(11, entPaymentBphtbIprotax.getNamaWP());
         pstPaymentBphtbIprotax.setDouble(12, entPaymentBphtbIprotax.getBphtbKurangBayar());
         pstPaymentBphtbIprotax.setDouble(13, entPaymentBphtbIprotax.getBphtbSdhBayar());
         pstPaymentBphtbIprotax.setString(14, entPaymentBphtbIprotax.getKdTp());
         pstPaymentBphtbIprotax.setString(15, entPaymentBphtbIprotax.getUserBankRekam());
         pstPaymentBphtbIprotax.setString(16, entPaymentBphtbIprotax.getNmPenyetor());
         pstPaymentBphtbIprotax.setString(17, entPaymentBphtbIprotax.getKdSumberData());
         pstPaymentBphtbIprotax.setString(18, entPaymentBphtbIprotax.getNoTransaksiBayarBank());
         pstPaymentBphtbIprotax.setString(20, entPaymentBphtbIprotax.getNoTransaksiBayar());
         pstPaymentBphtbIprotax.setDate(21, entPaymentBphtbIprotax.getTglPembayaran());
         pstPaymentBphtbIprotax.insert();
         entPaymentBphtbIprotax.setOID(1L);
      } catch (DBException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new DBException(new PstPaymentBphtbIprotax(0), 1);
      }

      return entPaymentBphtbIprotax.getOID();
   }

   public long insertExc(Entity entity) throws Exception {
      return this.insertExc((Entity)((PaymentPbbIprotax)entity));
   }

   public static void resultToObject(ResultSet rs, PaymentBphtbIprotax entPaymentBphtbIprotax) {
      try {
         entPaymentBphtbIprotax.setKdProvinsi(rs.getString(fieldNames[0]));
         entPaymentBphtbIprotax.setKdDati2(rs.getString(fieldNames[1]));
         entPaymentBphtbIprotax.setThbBphtb(rs.getString(fieldNames[2]));
         entPaymentBphtbIprotax.setBlnBphtb(rs.getString(fieldNames[3]));
         entPaymentBphtbIprotax.setTglBphtb(rs.getString(fieldNames[4]));
         entPaymentBphtbIprotax.setNoUrutBphtb(rs.getString(fieldNames[5]));
         entPaymentBphtbIprotax.setIndeksBphtb(rs.getString(fieldNames[6]));
         entPaymentBphtbIprotax.setKdPejabat(rs.getString(fieldNames[7]));
         entPaymentBphtbIprotax.setKdBankPersepsi(rs.getString(fieldNames[9]));
         entPaymentBphtbIprotax.setTglPembayaran(rs.getDate(fieldNames[10]));
         entPaymentBphtbIprotax.setNamaWP(rs.getString(fieldNames[11]));
         entPaymentBphtbIprotax.setBphtbKurangBayar(rs.getDouble(fieldNames[12]));
         entPaymentBphtbIprotax.setBphtbSdhBayar(rs.getDouble(fieldNames[13]));
         entPaymentBphtbIprotax.setKdTp(rs.getString(fieldNames[14]));
         entPaymentBphtbIprotax.setUserBankRekam(rs.getString(fieldNames[15]));
         entPaymentBphtbIprotax.setNmPenyetor(rs.getString(fieldNames[16]));
         entPaymentBphtbIprotax.setKdSumberData(rs.getString(fieldNames[17]));
         entPaymentBphtbIprotax.setNoTransaksiBayarBank(rs.getString(fieldNames[18]));
         entPaymentBphtbIprotax.setNoTransaksiBayar(rs.getString(fieldNames[20]));
         entPaymentBphtbIprotax.setTglPembayaran(rs.getDate(fieldNames[21]));
      } catch (Exception var3) {
      }

   }

   public static Vector listAll() {
      return list(0, 500, "", "");
   }

   public static Vector list(int limitStart, int recordToGet, String whereClause, String order) {
      Vector lists = new Vector();
      DBResultSet dbrs = null;

      try {
         String sql = "SELECT * FROM IPROTAXBPHTB.PEMBAYARAN_SSPD";
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

         while(rs.next()) {
            PaymentBphtbIprotax entPaymentBphtbIprotax = new PaymentBphtbIprotax();
            resultToObject(rs, entPaymentBphtbIprotax);
            lists.add(entPaymentBphtbIprotax);
         }

         rs.close();
         Vector var14 = lists;
         return var14;
      } catch (Exception var12) {
         System.out.println(var12);
      } finally {
         DBResultSet.close(dbrs);
      }

      return new Vector();
   }

   public static boolean checkOID(long entPaymentBphtbIprotaxId) {
      DBResultSet dbrs = null;
      boolean result = false;

      try {
         String sql = "SELECT * FROM IPROTAXBPHTB.PEMBAYARAN_SSPD WHERE " + fieldNames[0] + " = " + entPaymentBphtbIprotaxId;
         dbrs = DBHandler.execQueryResult(sql);

         ResultSet rs;
         for(rs = dbrs.getResultSet(); rs.next(); result = true) {
         }

         rs.close();
      } catch (Exception var9) {
         System.out.println("err : " + var9.toString());
      } finally {
         DBResultSet.close(dbrs);
         return result;
      }
   }

   public static BphtbIprotax checkNOp(String entNop, String tahun) {
      DBResultSet dbrs = null;
      BphtbIprotax entBphtbIprotax = null;

      try {
         String sql = "SELECT * FROM VIEW_BPHTB_ALL WHERE NO_ID  = '" + entNop + "'";
         dbrs = DBHandler.execQueryResult(sql);
         ResultSet rs = dbrs.getResultSet();

         while(rs.next()) {
            entBphtbIprotax = new BphtbIprotax();
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
      } catch (Exception var10) {
         System.out.println("err : " + var10.toString());
      } finally {
         DBResultSet.close(dbrs);
         return entBphtbIprotax;
      }
   }

   public static int DeleteDataPembayaran(String idPaymentBank) {
      int iResult = 0;
      DBResultSet dbrs = null;
      String stSql = " DELETE FROM IPROTAXPBB.PEMBAYARAN_BPHTB WHERE NO_TRANSAKSI_BYR_BANK='" + idPaymentBank + "'";

      try {
         iResult = DBHandler.execUpdate(stSql);
      } catch (DBException var8) {
         var8.printStackTrace();
      } finally {
         DBResultSet.close((DBResultSet)dbrs);
      }

      return iResult;
   }

   public static Vector listPerBulan(int limitStart, int recordToGet, String whereClause, String order, String groupBy) {
      Vector lists = new Vector();
      DBResultSet dbrs = null;

      try {
         String sql = "";
         if (AppSetting.SQL_VERSION == 3) {
            sql = "SELECT SUM(" + fieldNames[13] + ") " + fieldNames[13] + ", TO_DATE(TO_CHAR(" + fieldNames[10] + ",'Month YYYY'),'MM YYYY') " + fieldNames[10] + " FROM " + "IPROTAXBPHTB.PEMBAYARAN_SSPD";
            if (whereClause != null && whereClause.length() > 0) {
               sql = sql + " WHERE " + whereClause;
            }

            if (groupBy != null && groupBy.length() > 0) {
               sql = sql + " GROUP BY " + groupBy;
            }

            if (order != null && order.length() > 0) {
               sql = sql + " ORDER BY " + order;
            }

            if (limitStart == 0 && recordToGet == 0) {
               sql = sql + "";
            } else {
               sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
         } else {
            sql = "SELECT SUM(" + fieldNames[13] + ") " + fieldNames[13] + ", CONCAT(convert(varchar(7), TGL_PEMBAYARAN_SPPT, 126),'-01') AS " + fieldNames[10] + " FROM " + "IPROTAXBPHTB.PEMBAYARAN_SSPD";
            if (whereClause != null && whereClause.length() > 0) {
               sql = sql + " WHERE " + whereClause;
            }

            if (groupBy != null && groupBy.length() > 0) {
               sql = sql + " GROUP BY " + groupBy;
            }

            if (order != null && order.length() > 0) {
               sql = sql + " ORDER BY " + order;
            }

            if (limitStart == 0 && recordToGet == 0) {
               sql = sql + "";
            } else {
               sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
         }

         dbrs = DBHandler.execQueryResult(sql);
         ResultSet rs = dbrs.getResultSet();

         while(rs.next()) {
            PaymentBphtbIprotax entPaymentBphtb = new PaymentBphtbIprotax();
            entPaymentBphtb.setTglPembayaran(rs.getDate(2));
            entPaymentBphtb.setBphtbSdhBayar(rs.getDouble(1));
            lists.add(entPaymentBphtb);
         }

         rs.close();
         Vector var15 = lists;
         return var15;
      } catch (Exception var13) {
         System.out.println(var13);
      } finally {
         DBResultSet.close(dbrs);
      }

      return new Vector();
   }

   public static Vector listPaymentBphtbDaily(int limitStart, int recordToGet, String whereClause, String order, String group) {
      Vector lists = new Vector();
      DBResultSet dbrs = null;

      try {
         String sql = "";
         if (AppSetting.SQL_VERSION == 3) {
            sql = "SELECT TO_DATE(TO_CHAR(TGL_PEMBAYARAN,'DD Month YYYY'),'DD MM YYYY') TGL_PEMBAYARAN, SUM(BPHTB_SDH_DIBAYAR) AS BPHTB_SDH_DIBAYAR FROM IPROTAXBPHTB.PEMBAYARAN_SSPD";
            if (whereClause != null && whereClause.length() > 0) {
               sql = sql + " WHERE " + whereClause;
            }

            if (group != null && group.length() > 0) {
               sql = sql + " GROUP BY " + group;
            }

            if (order != null && order.length() > 0) {
               sql = sql + " ORDER BY " + order;
            }

            if (limitStart == 0 && recordToGet == 0) {
               sql = sql + "";
            } else {
               sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
         } else {
            sql = "SELECT CAST(TGL_PEMBAYARAN AS DATE) TGL_PEMBAYARAN, SUM(BPHTB_SDH_DIBAYAR) AS BPHTB_SDH_DIBAYAR FROM IPROTAXBPHTB.PEMBAYARAN_SSPD";
            if (whereClause != null && whereClause.length() > 0) {
               sql = sql + " WHERE " + whereClause;
            }

            if (group != null && group.length() > 0) {
               sql = sql + " GROUP BY " + group;
            }

            if (order != null && order.length() > 0) {
               sql = sql + " ORDER BY " + order;
            }

            if (limitStart == 0 && recordToGet == 0) {
               sql = sql + "";
            } else {
               sql = sql + " LIMIT " + limitStart + "," + recordToGet;
            }
         }

         dbrs = DBHandler.execQueryResult(sql);
         System.out.println(sql);
         ResultSet rs = dbrs.getResultSet();

         while(rs.next()) {
            PaymentBphtbIprotax entPaymentBphtb = new PaymentBphtbIprotax();
            entPaymentBphtb.setTglPembayaran(rs.getDate(1));
            entPaymentBphtb.setBphtbSdhBayar(rs.getDouble(2));
            lists.add(entPaymentBphtb);
         }

         rs.close();
         Vector var15 = lists;
         return var15;
      } catch (Exception var13) {
         System.out.println(var13);
      } finally {
         DBResultSet.close(dbrs);
      }

      return new Vector();
   }

   public static Vector listPaymentBphtbMoth(int limitStart, int recordToGet, String whereClause, String order, String group) {
      Vector lists = new Vector();
      DBResultSet dbrs = null;

      try {
         String sql = "";
         sql = "SELECT\n\tBULAN,\n\tTAHUN,\n\tSUM(BPHTB_SDH_DIBAYAR) AS PEMBAYARAN \nfrom(\n\tSELECT \n\tDATEPART(M, TGL_PEMBAYARAN) as BULAN,\n\tDATENAME(YEAR, TGL_PEMBAYARAN) as TAHUN,\n\t*\n\tFROM IPROTAXBPHTB.PEMBAYARAN_SSPD \n) as data ";
         if (whereClause != null && whereClause.length() > 0) {
            sql = sql + " WHERE " + whereClause;
         }

         if (group != null && group.length() > 0) {
            sql = sql + " GROUP BY " + group;
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
         System.out.println(sql);
         ResultSet rs = dbrs.getResultSet();

         while(rs.next()) {
            HashMap data = new HashMap();
            data.put("BULAN", rs.getString("BULAN"));
            data.put("TAHUN", rs.getString("TAHUN"));
            data.put("PEMBAYARAN", rs.getString("PEMBAYARAN"));
            lists.add(data);
         }

         rs.close();
         Vector var15 = lists;
         return var15;
      } catch (Exception var13) {
         System.out.println(var13);
      } finally {
         DBResultSet.close(dbrs);
      }

      return new Vector();
   }

   public static Vector listSum(int limitStart, int recordToGet, String whereClause, String order) {
      Vector lists = new Vector();
      DBResultSet dbrs = null;

      try {
         String sql = "SELECT SUM(BPHTB_SDH_DIBAYAR) AS JUMLAH FROM IPROTAXBPHTB.PEMBAYARAN_SSPD";
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

         while(rs.next()) {
            PaymentBphtbIprotax entPaymentBphtb = new PaymentBphtbIprotax();
            entPaymentBphtb.setBphtbSdhBayar(rs.getDouble("JUMLAH"));
            lists.add(entPaymentBphtb);
         }

         rs.close();
         Vector var14 = lists;
         return var14;
      } catch (Exception var12) {
         System.out.println(var12);
      } finally {
         DBResultSet.close(dbrs);
      }

      return new Vector();
   }
}