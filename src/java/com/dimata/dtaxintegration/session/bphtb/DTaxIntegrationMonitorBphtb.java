package com.dimata.dtaxintegration.session.bphtb;

import com.dimata.dtaxintegration.entity.inquery.Bphtb;
import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.dtaxintegration.entity.inquery.Payment;
import com.dimata.dtaxintegration.entity.laporan.LaporanPayment;
import com.dimata.dtaxintegration.entity.loghistory.LogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.payment.PaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PaymentBphtbIprotax;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtbIprotax;
import com.dimata.dtaxintegration.entity.tagihan.TagihanInsert;
import com.dimata.dtaxintegration.session.DTaxIntegrationManager;
import com.dimata.dtaxintegration.session.SessSimpatda;
import com.dimata.dtaxintegration.session.bphtb.DTaxIntegrationManagerPaymentBphtb;
import com.dimata.dtaxintegration.session.bphtb.SessSimpatdaBphtb;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSettingBphtb;
import com.dimata.webclient.bphtb.EchoLaporanPaymentDetailBphtb;
import com.dimata.webclient.bphtb.EchoTagihanDeleteByRecordIdBphtb;
import com.dimata.webclient.bphtb.EchoTagihanInsertBphtb;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class DTaxIntegrationMonitorBphtb implements Runnable {
  private boolean updateFinish = false;
  
  private long sleepTimeMinute = 3600L;
  
  public static String massage = "";
  
  public void run() {
    System.out.println("start .... ");
    while (DTaxIntegrationManager.running) {
      try {
        Date newDay = new Date();
        String startDate = Formater.formatDate(newDay, "yyyy-MM-dd");
        Thread.sleep(120000L);
      } catch (Exception e) {
        System.out.println("Interrupted " + e);
      } 
    } 
    System.out.println("stop .... ");
  }
  
  public void prosesBphtb(String var) {
    String[] splits = var.split(",");
    int count = 0;
    String idTagihan = "";
    String NOP = "";
    for (String asset : splits) {
      if (asset != "") {
        String[] splitsDua = asset.split(";");
        for (String value : splitsDua) {
          count++;
          if (count == 1)
            idTagihan = value; 
          if (count == 2) {
            NOP = value;
            String whereSent = " WHERE NO_ID='" + idTagihan + "' AND sNoid='" + NOP + "'";
            sentBphtb(whereSent);
            count = 0;
          } 
        } 
      } 
    } 
  }
  
  public void sentBphtb(String where) {
    try {
      try {
        Vector<Bphtb> vSimpatda = new Vector();
        vSimpatda = SessSimpatdaBphtb.getListBphtb(where);
        EchoTagihanInsertBphtb echo = new EchoTagihanInsertBphtb();
        if (vSimpatda.size() > 0)
          for (int i = 0; i < vSimpatda.size(); i++) {
            Bphtb bphtb = vSimpatda.get(i);
            TagihanInsert tagihanInsert = new TagihanInsert();
            tagihanInsert.setsUser(AppSettingBphtb.USERNAME_BPHTB);
            tagihanInsert.setSPassword(AppSettingBphtb.PWD_BPHTB);
            tagihanInsert.setSNoId("" + bphtb.getId());
            tagihanInsert.setSNama("" + bphtb.getNama());
            tagihanInsert.setJumTagihan(Double.valueOf(bphtb.getJumlahTagihan()).doubleValue());
            tagihanInsert.setSInstansi(AppSettingBphtb.INSTANSI_BPHTB);
            tagihanInsert.setSKet_1("" + bphtb.getNop());
            tagihanInsert.setSKet_2("" + bphtb.getPpat());
            String resp_code = "";
            boolean cekHistory = false;
            cekHistory = SessSimpatdaBphtb.check(bphtb.getId(), "", bphtb.getJumlahTagihan(), "", bphtb.getInstansi());
            if (!cekHistory) {
              resp_code = echo.action(tagihanInsert);
              massage = "Insert ID " + bphtb.getId() + " Proses : " + resp_code;
              if (resp_code.equals("00")) {
                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                logHistory.setId(bphtb.getId());
                logHistory.setNama(bphtb.getNama());
                if (!bphtb.getJumlahTagihan().equals("")) {
                  logHistory.setJumlahPajak(Double.valueOf(bphtb.getJumlahTagihan()).doubleValue());
                } else {
                  logHistory.setJumlahPajak(0.0D);
                } 
                logHistory.setTahun("");
                logHistory.setBulan("");
                logHistory.setInstansi(AppSettingBphtb.INSTANSI_BPHTB);
                logHistory.setInstansi(bphtb.getInstansi());
                logHistory.setDenda(0.0D);
                long l = PstLogHistoryTransaksi.insertExc(logHistory);
              } 
            } else {
              EchoTagihanDeleteByRecordIdBphtb.status = "Data Tagihan Sudah Ada Pada Bank";
            } 
          }  
      } catch (Exception e) {
        System.out.println("Err Sent CDR :" + e);
      } 
    } catch (Exception e) {
      System.out.println("Err Err Sent CDR :" + e);
    } 
  }
  
  public void inputPaymentBphtb(String dateLaporan, String noID) {
    try {
      try {
        Vector<Payment> vPaymentBphtb = new Vector();
        EchoLaporanPaymentDetailBphtb echoLaporan = new EchoLaporanPaymentDetailBphtb();
        Date newDay = new Date();
        LaporanPayment laporanPayment = new LaporanPayment();
        laporanPayment.setsUser(AppSettingBphtb.USERNAME_BPHTB);
        laporanPayment.setsPassword(AppSettingBphtb.PWD_BPHTB);
        laporanPayment.setsInstansi(AppSettingBphtb.INSTANSI_BPHTB);
        laporanPayment.setsNoId("" + noID);
        laporanPayment.setsDate("" + dateLaporan);
        vPaymentBphtb = echoLaporan.getListPaymentDetailBPHTB(laporanPayment);
        if (vPaymentBphtb.size() > 0)
          for (int i = 0; i < vPaymentBphtb.size(); i++) {
            Payment payment = vPaymentBphtb.get(i);
            PaymentBphtb paymentBphtb = new PaymentBphtb();
            paymentBphtb.setNoTib(Long.valueOf(payment.getNoId()).longValue());
            paymentBphtb.setIdPaymentBank(Long.valueOf(payment.getId()).longValue());
            if (!payment.getTagihan().equals(""))
              paymentBphtb.setJumlahBayar(Double.valueOf(payment.getTagihan()).doubleValue()); 
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateStringTransaksi = "" + payment.getTglTx();
            try {
              Date transaksiDate = formatter.parse(dateStringTransaksi);
              paymentBphtb.setTglBayar(transaksiDate);
            } catch (Exception e) {
              e.printStackTrace();
            } 
            paymentBphtb.setStatus(Integer.parseInt(payment.getStsReversal()));
            try {
              boolean cekHistory = SessSimpatdaBphtb.checkPaymentBphtb(payment.getId());
              if (cekHistory) {
                String idKey = SessSimpatda.checkKeyIdBphtb(payment.getNoId(), payment.getTahun(), payment.getBulan(), 0.0D);
                paymentBphtb.setIdKey(idKey);
                long oid = PstPaymentBphtb.insertExc(paymentBphtb);
                if (payment.getStsReversal().equals("1")){
                  String str = SessSimpatda.updateStatusRaversalBphtb(payment.getNoId(), payment.getTahun(), payment.getBulan(), 0.0D); 
                }
              } 
            } catch (Exception ex) {
              System.out.print("Tidak bisa proses input payment");
            } 
          }  
      } catch (Exception e) {
        DTaxIntegrationManagerPaymentBphtb.status = "Error Cause : " + e.getMessage();
        DTaxIntegrationManagerPaymentBphtb.running = false;
      } 
    } catch (Exception e) {
      DTaxIntegrationManagerPaymentBphtb.status = "Error Cause : " + e.getMessage();
      DTaxIntegrationManagerPaymentBphtb.running = false;
    } 
  }
  
  public void inputPaymentBphtbIprotax(String dateLaporan, String noID) {
    try {
      try {
        int count = 0;
        Vector<Payment> vPaymentBphtb = new Vector();
        EchoLaporanPaymentDetailBphtb echoLaporan = new EchoLaporanPaymentDetailBphtb();
        Date newDay = new Date();
        LaporanPayment laporanPayment = new LaporanPayment();
        laporanPayment.setsUser(AppSettingBphtb.USERNAME_BPHTB);
        laporanPayment.setsPassword(AppSettingBphtb.PWD_BPHTB);
        laporanPayment.setsInstansi(AppSettingBphtb.INSTANSI_BPHTB);
        laporanPayment.setsNoId("" + noID);
        laporanPayment.setsDate("" + dateLaporan);
        vPaymentBphtb = echoLaporan.getListPaymentDetailIprotax(laporanPayment);
        if (vPaymentBphtb.size() > 0)
          for (int i = 0; i < vPaymentBphtb.size(); i++) {
            try {
              Payment payment = vPaymentBphtb.get(i);
              PaymentBphtbIprotax paymentBphtb = new PaymentBphtbIprotax();
              String nop = payment.getNoId();
              System.out.println(nop);
              try {
                BphtbIprotax bphtbIprotax = PstPaymentBphtbIprotax.checkNOp(nop, payment.getTahun());
                paymentBphtb.setKdProvinsi(bphtbIprotax.getKdPropinsi());
                paymentBphtb.setKdDati2(bphtbIprotax.getKdDati2());
                paymentBphtb.setThbBphtb(bphtbIprotax.getThnBphtb());
                paymentBphtb.setBlnBphtb(bphtbIprotax.getBlnBphtb());
                paymentBphtb.setTglBphtb(bphtbIprotax.getTglBphtb());
                paymentBphtb.setNoUrutBphtb(bphtbIprotax.getNoUrutBphtb());
                paymentBphtb.setIndeksBphtb(bphtbIprotax.getIndeksBphtb());
                paymentBphtb.setKdPejabat(bphtbIprotax.getKdPejabat());
                paymentBphtb.setKdBankTunggal("00");
                paymentBphtb.setKdBankPersepsi("00");
                try {
                  paymentBphtb.setTglPembayaranReal(bphtbIprotax.getTglBayar());
                } catch (Exception exception) {}
                if (!payment.getTagihan().equals(""))
                  paymentBphtb.setBphtbSdhBayar(Math.abs(Double.valueOf(payment.getTagihan()).doubleValue())); 
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStringTransaksi = "" + payment.getTglTx();
                try {
                  Date transaksiDate = formatter.parse(dateStringTransaksi);
                  paymentBphtb.setTglPembayaran(transaksiDate);
                } catch (Exception e) {
                  SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  Date transaksiDate = formatter1.parse(dateStringTransaksi);
                  paymentBphtb.setTglPembayaran(transaksiDate);
                  e.printStackTrace();
                } 
                paymentBphtb.setNoTransBayar(payment.getId());
                paymentBphtb.setNamaWP(bphtbIprotax.getNama());
                if (!bphtbIprotax.getJumTagihan().equals(""))
                  paymentBphtb.setBphtbKurangBayar(Math.abs(Double.valueOf(bphtbIprotax.getJumTagihan()).doubleValue() - paymentBphtb.getBphtbSdhBayar())); 
                paymentBphtb.setKdKecamatanOp(bphtbIprotax.getKdKecamatanOp());
                paymentBphtb.setKdKelurahanOp(bphtbIprotax.getKdKelurahanOp());
                paymentBphtb.setKdBlokOp(bphtbIprotax.getKdBlokOp());
                paymentBphtb.setNoUrutOp(bphtbIprotax.getNoUrutOp());
                paymentBphtb.setKdJnsOp(bphtbIprotax.getKdJenisOp());
                paymentBphtb.setKdTp("05");
                paymentBphtb.setUserBankRekam(payment.getKdUser());
                paymentBphtb.setNmPenyetor(payment.getNama());
                paymentBphtb.setKdSumberData("0");
                paymentBphtb.setNoTransaksiBayar(bphtbIprotax.getNoId());
                paymentBphtb.setNoTransaksiBayarBank(payment.getId());
                paymentBphtb.setStatus(Integer.parseInt(payment.getStsReversal()));
                boolean cekHistory = SessSimpatdaBphtb.checkPaymentBphtb(payment.getId());
                if (payment.getStsReversal().equals("1")) {
                  if (paymentBphtb.getBphtbSdhBayar() > 0.0D) {
                    count++;
                    DTaxIntegrationManagerPaymentBphtb.status = "Download Data Payment : " + count;
                    boolean cekHistoryReversal = SessSimpatdaBphtb.checkPaymentBphtbReversal(payment.getId());
                    if (cekHistoryReversal) {
                      int oid = SessSimpatdaBphtb.DeleteDataPembayaranBPHTB(payment.getId());
                      String whereUpdate = "KD_PROPINSI = '" + bphtbIprotax.getKdPropinsi() + "' AND KD_DATI2 = '" + bphtbIprotax.getKdDati2() + "' AND THN_BPHTB = '" + bphtbIprotax.getThnBphtb() + "'  AND BLN_BPHTB = '" + bphtbIprotax.getBlnBphtb() + "'  AND TGL_BPHTB = '" + bphtbIprotax.getTglBphtb() + "'  AND NO_URUT_BPHTB = '" + bphtbIprotax.getNoUrutBphtb() + "' AND INDEKS_BPHTB = '" + bphtbIprotax.getIndeksBphtb() + "'";
                      String sql = " UPDATE IPROTAXBPHTB.DAT_SSPD SET KD_BANK_TUNGGAL = '00', KD_BANK_PERSEPSI = '00', NO_TRANS_BAYAR = '0', TGL_BAYAR_SSB_WP = NULL WHERE " + whereUpdate;
                      try {
                        int j = DBHandler.execUpdate(sql);
                      } catch (DBException e) {
                        e.printStackTrace();
                      } 
                      String sqlOpSspd = " UPDATE IPROTAXBPHTB.DAT_OP_SSPD SET NO_TRANSAKSI = '0' WHERE " + whereUpdate;
                      try {
                        int j = DBHandler.execUpdate(sqlOpSspd);
                      } catch (DBException e) {
                        e.printStackTrace();
                      } 
                    } 
                  } 
                } else if (cekHistory) {
                  count++;
                  DTaxIntegrationManagerPaymentBphtb.status = "Dwonload Data Payment : " + count;
                  long oid = PstPaymentBphtbIprotax.insertExc(paymentBphtb);
                  String whereUpdate = "KD_PROPINSI = '" + bphtbIprotax.getKdPropinsi() + "' AND KD_DATI2 = '" + bphtbIprotax.getKdDati2() + "' AND THN_BPHTB = '" + bphtbIprotax.getThnBphtb() + "'  AND BLN_BPHTB = '" + bphtbIprotax.getBlnBphtb() + "'  AND TGL_BPHTB = '" + bphtbIprotax.getTglBphtb() + "'  AND NO_URUT_BPHTB = '" + bphtbIprotax.getNoUrutBphtb() + "' AND INDEKS_BPHTB = '" + bphtbIprotax.getIndeksBphtb() + "'";
                  String sql = " UPDATE IPROTAXBPHTB.DAT_SSPD SET KD_BANK_TUNGGAL = '00', KD_BANK_PERSEPSI = '00', NO_TRANS_BAYAR = '" + payment.getId() + "', TGL_BAYAR_SSB_WP = '" + Formater.formatDate(paymentBphtb.getTglPembayaran(), "yyyy-MM-dd") + "' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sql);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                  sql = " UPDATE IPROTAXBPHTB.DAT_BPHTB SET NO_TRANS_BAYAR = '" + payment.getId() + "' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sql);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                  String sqlTelitiSSB = " UPDATE IPROTAXBPHTB.DAFTAR_TELITI_SSPD SET STATUS_DOKUMEN = '2' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sqlTelitiSSB);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                  String sqlOpSspd = " UPDATE IPROTAXBPHTB.DAT_OP_SSPD SET NO_TRANSAKSI = '" + payment.getId() + "' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sqlOpSspd);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                } 
              } catch (Exception exc) {
                System.out.println(exc.toString());
              } 
            } catch (Exception ex) {
              System.out.print("Tidak bisa proses input payment");
              DTaxIntegrationManagerPaymentBphtb.status += "<br> Tidak dapat menarik data pembayaran : " + ex.toString();
            } 
          }  
      } catch (Exception e) {
        System.out.println("inputPaymentBphtb :" + e);
        DTaxIntegrationManagerPaymentBphtb.status += "<br> Tidak dapat menarik data pembayaran : " + e.toString();
      } 
    } catch (Exception e) {
      System.out.println("inputPaymentBphtb :" + e);
      DTaxIntegrationManagerPaymentBphtb.status += "<br> Tidak dapat menarik data pembayaran : " + e.toString();
    } 
  }
  
  public void inputPaymentBphtbIprotaxStlBukti(String dateLaporan, String noID) {
    try {
      try {
        int count = 0;
        Vector<Payment> vPaymentBphtb = new Vector();
        EchoLaporanPaymentDetailBphtb echoLaporan = new EchoLaporanPaymentDetailBphtb();
        Date newDay = new Date();
        LaporanPayment laporanPayment = new LaporanPayment();
        laporanPayment.setsUser(AppSettingBphtb.USERNAME_BPHTB);
        laporanPayment.setsPassword(AppSettingBphtb.PWD_BPHTB);
        laporanPayment.setsInstansi(AppSettingBphtb.INSTANSI_BPHTB);
        laporanPayment.setsNoId("" + noID);
        laporanPayment.setsDate("" + dateLaporan);
        vPaymentBphtb = echoLaporan.getListPaymentDetailIprotaxStlBukti(laporanPayment);
        if (vPaymentBphtb.size() > 0)
          for (int i = 0; i < vPaymentBphtb.size(); i++) {
            try {
              Payment payment = vPaymentBphtb.get(i);
              PaymentBphtbIprotax paymentBphtb = new PaymentBphtbIprotax();
              String nop = payment.getNoId();
              System.out.println(nop);
              try {
                BphtbIprotax bphtbIprotax = PstPaymentBphtbIprotax.checkNOp(nop, payment.getTahun());
                paymentBphtb.setKdProvinsi(bphtbIprotax.getKdPropinsi());
                paymentBphtb.setKdDati2(bphtbIprotax.getKdDati2());
                paymentBphtb.setThbBphtb(bphtbIprotax.getThnBphtb());
                paymentBphtb.setBlnBphtb(bphtbIprotax.getBlnBphtb());
                paymentBphtb.setTglBphtb(bphtbIprotax.getTglBphtb());
                paymentBphtb.setNoUrutBphtb(bphtbIprotax.getNoUrutBphtb());
                paymentBphtb.setIndeksBphtb(bphtbIprotax.getIndeksBphtb());
                paymentBphtb.setKdPejabat(bphtbIprotax.getKdPejabat());
                paymentBphtb.setKdBankTunggal("00");
                paymentBphtb.setKdBankPersepsi("00");
                try {
                  paymentBphtb.setTglPembayaranReal(bphtbIprotax.getTglBayar());
                } catch (Exception exception) {}
                if (!payment.getTagihan().equals(""))
                  paymentBphtb.setBphtbSdhBayar(Math.abs(Double.valueOf(payment.getTagihan()).doubleValue())); 
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateStringTransaksi = "" + payment.getTglTx();
                try {
                  Date transaksiDate = formatter.parse(dateStringTransaksi);
                  paymentBphtb.setTglPembayaran(transaksiDate);
                } catch (Exception e) {
                  SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  Date transaksiDate = formatter1.parse(dateStringTransaksi);
                  paymentBphtb.setTglPembayaran(transaksiDate);
                  e.printStackTrace();
                } 
                paymentBphtb.setNoTransBayar(payment.getId());
                paymentBphtb.setNamaWP(bphtbIprotax.getNama());
                if (!bphtbIprotax.getJumTagihan().equals(""))
                  paymentBphtb.setBphtbKurangBayar(Math.abs(Double.valueOf(bphtbIprotax.getJumTagihan()).doubleValue() - paymentBphtb.getBphtbSdhBayar())); 
                paymentBphtb.setKdKecamatanOp(bphtbIprotax.getKdKecamatanOp());
                paymentBphtb.setKdKelurahanOp(bphtbIprotax.getKdKelurahanOp());
                paymentBphtb.setKdBlokOp(bphtbIprotax.getKdBlokOp());
                paymentBphtb.setNoUrutOp(bphtbIprotax.getNoUrutOp());
                paymentBphtb.setKdJnsOp(bphtbIprotax.getKdJenisOp());
                paymentBphtb.setKdTp("05");
                paymentBphtb.setUserBankRekam(payment.getKdUser());
                paymentBphtb.setNmPenyetor(payment.getNama());
                paymentBphtb.setKdSumberData("0");
                paymentBphtb.setNoTransaksiBayar(payment.getNoId());
                paymentBphtb.setNoTransaksiBayarBank(payment.getId());
                paymentBphtb.setStatus(Integer.parseInt(payment.getStsReversal()));
                boolean cekHistory = SessSimpatdaBphtb.checkPaymentBphtb(payment.getId());
                if (payment.getStsReversal().equals("1")) {
                  if (paymentBphtb.getBphtbSdhBayar() > 0.0D) {
                    count++;
                    DTaxIntegrationManagerPaymentBphtb.status = "Dwonload Data Payment : " + count;
                    boolean cekHistoryReversal = SessSimpatdaBphtb.checkPaymentBphtbReversal(payment.getId());
                    if (cekHistoryReversal) {
                      int oid = SessSimpatdaBphtb.DeleteDataPembayaranBPHTB(payment.getId());
                      String whereUpdate = "KD_PROPINSI = '" + bphtbIprotax.getKdPropinsi() + "' AND KD_DATI2 = '" + bphtbIprotax.getKdDati2() + "' AND THN_BPHTB = '" + bphtbIprotax.getThnBphtb() + "'  AND BLN_BPHTB = '" + bphtbIprotax.getBlnBphtb() + "'  AND TGL_BPHTB = '" + bphtbIprotax.getTglBphtb() + "'  AND NO_URUT_BPHTB = '" + bphtbIprotax.getNoUrutBphtb() + "' AND INDEKS_BPHTB = '" + bphtbIprotax.getIndeksBphtb() + "'";
                      String sql = " UPDATE IPROTAXBPHTB.DAT_SSPD SET KD_BANK_TUNGGAL = '00', KD_BANK_PERSEPSI = '00', NO_TRANS_BAYAR = '0', TGL_BAYAR_SSB_WP = NULL WHERE " + whereUpdate;
                      try {
                        int j = DBHandler.execUpdate(sql);
                      } catch (DBException e) {
                        e.printStackTrace();
                      } 
                      String sqlOpSspd = " UPDATE IPROTAXBPHTB.DAT_OP_SSPD SET NO_TRANSAKSI = '0' WHERE " + whereUpdate;
                      try {
                        int j = DBHandler.execUpdate(sqlOpSspd);
                      } catch (DBException e) {
                        e.printStackTrace();
                      } 
                    } 
                  } 
                } else if (cekHistory) {
                  count++;
                  DTaxIntegrationManagerPaymentBphtb.status = "Dwonload Data Payment : " + count;
                  long oid = PstPaymentBphtbIprotax.insertExc(paymentBphtb);
                  String whereUpdate = "KD_PROPINSI = '" + bphtbIprotax.getKdPropinsi() + "' AND KD_DATI2 = '" + bphtbIprotax.getKdDati2() + "' AND THN_BPHTB = '" + bphtbIprotax.getThnBphtb() + "'  AND BLN_BPHTB = '" + bphtbIprotax.getBlnBphtb() + "'  AND TGL_BPHTB = '" + bphtbIprotax.getTglBphtb() + "'  AND NO_URUT_BPHTB = '" + bphtbIprotax.getNoUrutBphtb() + "' AND INDEKS_BPHTB = '" + bphtbIprotax.getIndeksBphtb() + "'";
                  String sql = " UPDATE IPROTAXBPHTB.DAT_SSPD SET KD_BANK_TUNGGAL = '00', KD_BANK_PERSEPSI = '00', NO_TRANS_BAYAR = '" + payment.getId() + "', TGL_BAYAR_SSB_WP = '" + Formater.formatDate(paymentBphtb.getTglPembayaran(), "yyyy-MM-dd") + "' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sql);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                  sql = " UPDATE IPROTAXBPHTB.DAT_BPHTB SET NO_TRANS_BAYAR = '" + payment.getId() + "' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sql);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                  String sqlTelitiSSB = " UPDATE IPROTAXBPHTB.DAFTAR_TELITI_SSPD SET STATUS_DOKUMEN = '2' WHERE " + whereUpdate; 
                  try {
                    int j = DBHandler.execUpdate(sqlTelitiSSB);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                  String sqlOpSspd = " UPDATE IPROTAXBPHTB.DAT_OP_SSPD SET NO_TRANSAKSI = '" + payment.getId() + "' WHERE " + whereUpdate;
                  try {
                    int j = DBHandler.execUpdate(sqlOpSspd);
                  } catch (DBException e) {
                    e.printStackTrace();
                  } 
                } 
              } catch (Exception exc) {
                System.out.println(exc.toString());
              } 
            } catch (Exception ex) {
              System.out.print("Tidak bisa proses input payment");
              DTaxIntegrationManagerPaymentBphtb.status += "<br> Tidak dapat menarik data pembayaran : " + ex.toString();
            } 
          }  
      } catch (Exception e) {
        System.out.println("inputPaymentBphtb :" + e);
        DTaxIntegrationManagerPaymentBphtb.status += "<br> Tidak dapat menarik data pembayaran : " + e.toString();
      } 
    } catch (Exception e) {
      System.out.println("inputPaymentBphtb :" + e);
      DTaxIntegrationManagerPaymentBphtb.status += "<br> Tidak dapat menarik data pembayaran : " + e.toString();
    } 
  }
  
  public static int getIdleSleepTime(long current, long delay, long quarter, long day, long night) {
    long gap = 0L;
    if (current < delay) {
      System.out.println("_______________ start service monitoy sebelum delay");
      gap = delay - current - 100L;
      return (int)gap;
    } 
    if (current == delay) {
      System.out.println("_______________ start service monitoy sama delay");
      return 0;
    } 
    if (current > delay && current < quarter) {
      System.out.println("_______________ start service monitoy sebelum quarter");
      gap = quarter - current - 100L;
      return (int)gap;
    } 
    if (current == quarter) {
      System.out.println("_______________  start service monitoy sama delay");
      return 0;
    } 
    if (current > quarter && current < day) {
      System.out.println("_______________  start service monitoy sebelum day");
      gap = day - current - 100L;
      return (int)gap;
    } 
    if (current == day) {
      System.out.println("_______________  start service monitoy sama day");
      return 0;
    } 
    if (current > day && current < night) {
      System.out.println("_______________  start service monitoy sebelum night");
      gap = night - current - 100L;
      return (int)gap;
    } 
    if (current == night) {
      System.out.println("_______________  start service monitoy sama delay");
      return 0;
    } 
    System.out.println("_______________  start service monitoy sebelum delay besoknya");
    gap = delay - current - 100L;
    return (int)gap;
  }
  
  public static String dateConvert(String dateString) {
    String[] arr = dateString.split("-");
    String day = arr[0];
    String month = arr[1];
    String year = arr[2];
    String date = "";
    String realMonth = "";
    switch (month) {
      case "JAN":
        realMonth = "01";
        break;
      case "FEB":
        realMonth = "02";
        break;
      case "MAR":
        realMonth = "03";
        break;
      case "APR":
        realMonth = "04";
        break;
      case "MEI":
        realMonth = "05";
        break;
      case "JUN":
        realMonth = "06";
        break;
      case "JUL":
        realMonth = "07";
        break;
      case "AGT":
        realMonth = "08";
        break;
      case "SEP":
        realMonth = "09";
        break;
      case "OKT":
        realMonth = "10";
        break;
      case "NOV":
        realMonth = "11";
        break;
      case "DES":
        realMonth = "12";
        break;
    } 
    date = day + "-" + realMonth + "-" + year;
    return date;
  }
  
  public static int getIdleSleepTime(long current, long delay) {
    long gap = 0L;
    if (current < delay) {
      System.out.println("_______________ start service monitoy sebelum delay");
      gap = delay - current - 100L;
      return (int)gap;
    } 
    return (int)gap;
  }
  
  public long getSleepTimeMinute() {
    return this.sleepTimeMinute;
  }
  
  public void setSleepTimeMinute(long sleepTimeMinute) {
    this.sleepTimeMinute = sleepTimeMinute;
  }
}
