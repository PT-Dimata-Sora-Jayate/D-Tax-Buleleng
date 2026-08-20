package com.dimata.dtaxintegration.session;

import com.dimata.dtaxintegration.entity.bi.PajakTypeDetail;
import com.dimata.dtaxintegration.entity.bi.PstPajakTypeDetail;
import com.dimata.dtaxintegration.entity.bi.SearchDataPajak;
import com.dimata.dtaxintegration.entity.inquery.Bphtb;
import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.dtaxintegration.entity.inquery.Payment;
import com.dimata.dtaxintegration.entity.inquery.Pbb;
import com.dimata.dtaxintegration.entity.inquery.PbbIprotax;
import com.dimata.dtaxintegration.entity.inquery.PstPbbIprotax;
import com.dimata.dtaxintegration.entity.inquery.Retribusi;
import com.dimata.dtaxintegration.entity.inquery.Simpatda;
import com.dimata.dtaxintegration.entity.laporan.LaporanPayment;
import com.dimata.dtaxintegration.entity.loghistory.LogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.payment.PaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PaymentBphtbIprotax;
import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PaymentPbbIprotax;
import com.dimata.dtaxintegration.entity.payment.PaymentPhr;
import com.dimata.dtaxintegration.entity.payment.PaymentPhrforOpenPhr;
import com.dimata.dtaxintegration.entity.payment.PaymentPhrforPhrH;
import com.dimata.dtaxintegration.entity.payment.PaymentRetribusi;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentBphtbIprotax;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbbHistory;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbbIprotax;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhr;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhrAll;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhrforOpenPhr;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPhrforPhrH;
import com.dimata.dtaxintegration.entity.payment.PstPaymentRetribusi;
import com.dimata.dtaxintegration.entity.tagihan.TagihanDelete;
import com.dimata.dtaxintegration.entity.tagihan.TagihanInsert;
import com.dimata.dtaxintegration.session.ConvertAngkaToHuruf;
import com.dimata.dtaxintegration.session.DTaxIntegrationManager;
import com.dimata.dtaxintegration.session.DTaxIntegrationMonitor;
import com.dimata.dtaxintegration.session.DTaxManagerAutomaticPhr;
import com.dimata.dtaxintegration.session.DTaxManagerBphtb;
import com.dimata.dtaxintegration.session.DTaxManagerPbb;
import com.dimata.dtaxintegration.session.SessDataPajak;
import com.dimata.dtaxintegration.session.SessPbbIprotax;
import com.dimata.dtaxintegration.session.SessSimpatda;
import com.dimata.qdep.db.DBException;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.qdep.form.FRMHandler;
import com.dimata.util.ChekPenghilanganPiutang;
import com.dimata.util.Diskon;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.EchoLaporanPaymentDetail;
import com.dimata.webclient.EchoLaporanPaymentDetailSetelahNoBukti;
import com.dimata.webclient.EchoTagihanDeleteById;
import com.dimata.webclient.EchoTagihanInsert;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class DTaxIntegrationMonitor implements Runnable {

    public static String getLogErorPosting() {
        return logErorPosting;
    }

    public static void setLogErorPosting(String aLogErorPosting) {
        logErorPosting = aLogErorPosting;
    }

    private boolean updateFinish = false;

    private long sleepTimeMinute = 3600;

    public static String massage = "";

    private static String logErorPosting = "";

    public void run() {
        System.out.println("start .... ");
        while (DTaxIntegrationManager.running) {
            try {
                Date newDay = new Date();
                String startDate = Formater.formatDate(newDay, "yyyy-MM-dd");
                switch (AppSetting.TYPE_APP_BACKOFFICE) {
                    case 3:
                        inputPaymentPHRforOpenPHR(startDate, "");
                        break;
                    case 4:
                        inputPaymentPHRforPhrH(startDate, "");
                        break;
                    default:
                        inputPaymentPHR(startDate, "");
                        break;
                }
                Thread.sleep(120000);
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
            }
        }
        System.out.println("stop .... ");
    }

    public void prosesSimpatda(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        String jumlah = "";
        String idkey = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                    }
                    if (count == 3) {
                        bulan = value;
                    }
                    if (count == 4) {
                        idkey = value;
                    }
                    if (count == 5) {
                        jumlah = value;
                        String whereSent = " WHERE ID='" + idTagihan + "' AND MASA_PAJAK='" + bulan + "' AND TAHUN_PAJAK='" + tahun + "' AND JUMLAH='" + jumlah + "' AND ID_KEY='" + idkey + "'";
                        sentSimpatda(whereSent);
                        count = 0;
                    }
                }
            }
        }
    }

    public synchronized void prosesSimpatdaOpenPhr(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        String jumlah = "";
        String idkey = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                    }
                    if (count == 3) {
                        bulan = value;
                    }
                    if (count == 4) {
                        idkey = value;
                    }
                    if (count == 5) {
                        jumlah = value;
                        String whereSent = " WHERE sNoId='" + idTagihan + "'";
                        sentSimpatdaOpenPhr(whereSent);
                        count = 0;
                    }
                }
            }
        }
    }

    public synchronized void prosesSimpatdaPhrH(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        String jumlah = "";
        String idkey = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                    }
                    if (count == 3) {
                        bulan = value;
                    }
                    if (count == 4) {
                        idkey = value;
                    }
                    if (count == 5) {
                        jumlah = value;
                        String whereSent = " WHERE kode_id='" + idTagihan + "'";
                        sentSimpatdaPhrH(whereSent);
                        count = 0;
                    }
                }
            }
        }
    }

    public void sentSimpatda(String where) {
        try {
            try {
                Vector<Simpatda> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListSimpatda(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Simpatda simpatda = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PHR);
                        tagihanInsert.setSPassword(AppSetting.PWD_PHR);
                        tagihanInsert.setSNoId("" + simpatda.getId());
                        tagihanInsert.setSNama("" + simpatda.getNamaSimpatda());
                        tagihanInsert.setJumTagihan(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PHR);
                        tagihanInsert.setSKet_1("" + simpatda.getAlamat());
                        tagihanInsert.setSKet_2("" + simpatda.getBulanSimpatda());
                        tagihanInsert.setSKet_3("" + simpatda.getTahunSimpatda());
                        tagihanInsert.setSKet_4("" + simpatda.getPokok());
                        tagihanInsert.setSKet_5("" + simpatda.getDenda());
                        tagihanInsert.setSKet_6("" + simpatda.getNoSspdSimpatda());
                        tagihanInsert.setSKet_7("" + simpatda.getKeterangan());
                        tagihanInsert.setSKet_8("");
                        tagihanInsert.setSKet_9("");
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + simpatda.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(simpatda.getId());
                                logHistory.setNama(simpatda.getNamaSimpatda());
                                if (!simpatda.getJumlahPajakSimpatda().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(simpatda.getTahunSimpatda());
                                logHistory.setBulan(simpatda.getBulanSimpatda());
                                logHistory.setInstansi(simpatda.getInstansi());
                                if (!simpatda.getDenda().equals("")) {
                                    logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                if (!simpatda.getPokok().equals("")) {
                                    logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
                                } else {
                                    logHistory.setPokok(0.0);
                                }
                                logHistory.setAlamat(simpatda.getAlamat());
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void sentSimpatdaOpenPhr(String where) {
        try {
            try {
                Vector<Simpatda> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListSimpatdaOpenPhr(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Simpatda simpatda = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PHR);
                        tagihanInsert.setSPassword(AppSetting.PWD_PHR);
                        tagihanInsert.setSNoId("" + simpatda.getId());
                        tagihanInsert.setSNama("" + simpatda.getNamaSimpatda());
                        tagihanInsert.setJumTagihan(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PHR);
                        tagihanInsert.setSKet_1("" + simpatda.getAlamat());
                        tagihanInsert.setSKet_2("" + simpatda.getBulanSimpatda());
                        tagihanInsert.setSKet_3("" + simpatda.getTahunSimpatda());
                        tagihanInsert.setSKet_4("" + simpatda.getPokok());
                        tagihanInsert.setSKet_5("" + simpatda.getDenda());
                        tagihanInsert.setSKet_6("" + simpatda.getKeterangan());
                        tagihanInsert.setSKet_7("" + simpatda.getNpwpd());
                        tagihanInsert.setSKet_8("" + simpatda.getTanggalAwal());
                        tagihanInsert.setSKet_9("" + simpatda.getTanggalAkhir());
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + simpatda.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(simpatda.getId());
                                logHistory.setNama(simpatda.getNamaSimpatda());
                                if (!simpatda.getJumlahPajakSimpatda().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(simpatda.getTahunSimpatda());
                                logHistory.setBulan(simpatda.getBulanSimpatda());
                                logHistory.setInstansi(simpatda.getInstansi());
                                if (!simpatda.getDenda().equals("")) {
                                    logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                if (!simpatda.getPokok().equals("")) {
                                    logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
                                } else {
                                    logHistory.setPokok(0.0);
                                }
                                logHistory.setAlamat(simpatda.getAlamat());
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public synchronized void sentSimpatdaPhrH(String where) {
        setLogErorPosting("");
        try {
            try {
                Vector<Simpatda> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListSimpatdaPhrH(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Simpatda simpatda = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PHR);
                        tagihanInsert.setSPassword(AppSetting.PWD_PHR);
                        tagihanInsert.setSNoId("" + simpatda.getId());
                        tagihanInsert.setSNama("" + simpatda.getNamaSimpatda());
                        tagihanInsert.setJumTagihan(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PHR);
                        tagihanInsert.setSKet_1("" + simpatda.getNpwpd());
                        tagihanInsert.setSKet_2("" + simpatda.getJenisUsaha());
                        tagihanInsert.setSKet_3("" + simpatda.getAlamat());
                        tagihanInsert.setSKet_4("" + simpatda.getBulanSimpatda());
                        tagihanInsert.setSKet_5("" + simpatda.getTahunSimpatda());
                        tagihanInsert.setSKet_6("" + simpatda.getJatuhTempo());
                        tagihanInsert.setSKet_7("" + simpatda.getPokok());
                        tagihanInsert.setSKet_8("" + simpatda.getTagihanAdmin());
                        tagihanInsert.setSKet_9("" + simpatda.getDenda());
                        tagihanInsert.setSKet_10("" + simpatda.getWaktu());
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + simpatda.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                setLogErorPosting(" Posting Data Pajak :  Berhasil");
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(simpatda.getId());
                                logHistory.setNama(simpatda.getNamaSimpatda());
                                if (!simpatda.getJumlahPajakSimpatda().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(simpatda.getTahunSimpatda());
                                logHistory.setBulan(simpatda.getBulanSimpatda());
                                logHistory.setInstansi(simpatda.getInstansi());
                                if (!simpatda.getDenda().equals("")) {
                                    logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                if (!simpatda.getPokok().equals("")) {
                                    logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
                                } else {
                                    logHistory.setPokok(0.0);
                                }
                                logHistory.setAlamat(simpatda.getAlamat());
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            } else {
                                setLogErorPosting(" Posting Data Pajak :  Gagal");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
                setLogErorPosting(" Posting Data Pajak :  Gagal " + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
            setLogErorPosting(" Posting Data Pajak :  Gagal " + e);
        }
    }

    public void sentAutoOpenPhr(String where) {
        try {
            try {
                Vector<Simpatda> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListSimpatdaOpenPhrAuto(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Simpatda simpatda = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PHR);
                        tagihanInsert.setSPassword(AppSetting.PWD_PHR);
                        tagihanInsert.setSNoId("" + simpatda.getId());
                        tagihanInsert.setSNama("" + simpatda.getNamaSimpatda());
                        tagihanInsert.setJumTagihan(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PHR);
                        tagihanInsert.setSKet_1("" + simpatda.getAlamat());
                        tagihanInsert.setSKet_2("" + simpatda.getBulanSimpatda());
                        tagihanInsert.setSKet_3("" + simpatda.getTahunSimpatda());
                        tagihanInsert.setSKet_4("" + simpatda.getPokok());
                        tagihanInsert.setSKet_5("" + simpatda.getDenda());
                        tagihanInsert.setSKet_6("" + simpatda.getKeterangan());
                        tagihanInsert.setSKet_7("" + simpatda.getNpwpd());
                        tagihanInsert.setSKet_8("" + simpatda.getTanggalAwal());
                        tagihanInsert.setSKet_9("" + simpatda.getTanggalAkhir());
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + simpatda.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(simpatda.getId());
                                logHistory.setNama(simpatda.getNamaSimpatda());
                                if (!simpatda.getJumlahPajakSimpatda().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(simpatda.getTahunSimpatda());
                                logHistory.setBulan(simpatda.getBulanSimpatda());
                                logHistory.setInstansi(simpatda.getInstansi());
                                if (!simpatda.getDenda().equals("")) {
                                    logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                if (!simpatda.getPokok().equals("")) {
                                    logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
                                } else {
                                    logHistory.setPokok(0.0);
                                }
                                logHistory.setAlamat(simpatda.getAlamat());
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public synchronized void sentAutoPhrH(String where) {
        if (DTaxIntegrationManager.running) {
            try {
                try {
                    Vector<Simpatda> vSimpatda = new Vector();
                    vSimpatda = SessSimpatda.getListSimpatdaPhrHAuto(where);
                    EchoTagihanInsert echo = new EchoTagihanInsert();
                    if (vSimpatda.size() > 0) {
                        for (int i = 0; i < vSimpatda.size(); i++) {
                            Simpatda simpatda = vSimpatda.get(i);
                            TagihanInsert tagihanInsert = new TagihanInsert();
                            TagihanDelete tagihanDelete = new TagihanDelete();
                            if (!simpatda.getId().equals("")) {
                                EchoTagihanDeleteById echoTagihanDeleteById = new EchoTagihanDeleteById();
                                EchoTagihanDeleteById.setLogErorDeteleDataTagihan("");
                                tagihanDelete.setsUser(AppSetting.USERNAME_PHR);
                                tagihanDelete.setsPassword(AppSetting.PWD_PHR);
                                tagihanDelete.setsInstansi(AppSetting.INSTANSI_PHR);
                                tagihanDelete.setsNoId(simpatda.getId());
                                tagihanDelete.setsRecordId("");
                                echoTagihanDeleteById.action(tagihanDelete);
                                try {
                                    int j = PstLogHistoryTransaksi.deleteloghistoryperid(simpatda.getId());
                                } catch (Exception exception) {
                                }
                            }
                            tagihanInsert.setsUser(AppSetting.USERNAME_PHR);
                            tagihanInsert.setSPassword(AppSetting.PWD_PHR);
                            tagihanInsert.setSNoId("" + simpatda.getId());
                            tagihanInsert.setSNama("" + simpatda.getNamaSimpatda());
                            tagihanInsert.setJumTagihan(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                            tagihanInsert.setSInstansi(AppSetting.INSTANSI_PHR);
                            tagihanInsert.setSKet_1("" + simpatda.getNpwpd());
                            tagihanInsert.setSKet_2("" + simpatda.getJenisUsaha());
                            tagihanInsert.setSKet_3("" + simpatda.getAlamat());
                            tagihanInsert.setSKet_4("" + simpatda.getBulanSimpatda());
                            tagihanInsert.setSKet_5("" + simpatda.getTahunSimpatda());
                            tagihanInsert.setSKet_6("" + simpatda.getJatuhTempo());
                            tagihanInsert.setSKet_7("" + simpatda.getPokok());
                            tagihanInsert.setSKet_8("" + simpatda.getTagihanAdmin());
                            tagihanInsert.setSKet_9("" + simpatda.getDenda());
                            tagihanInsert.setSKet_10("" + simpatda.getWaktu());
                            tagihanInsert.setSKet_11("");
                            tagihanInsert.setSKet_12("");
                            tagihanInsert.setSKet_13("");
                            String resp_code = "";
                            boolean cekHistory = false;
                            if (!cekHistory) {
                                resp_code = echo.action(tagihanInsert);
                                massage = "Insert ID " + simpatda.getNpwpd() + " Proses : " + resp_code;
                                if (resp_code.equals("00")) {
                                    LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                    logHistory.setId(simpatda.getId());
                                    logHistory.setNama(simpatda.getNamaSimpatda());
                                    if (!simpatda.getJumlahPajakSimpatda().equals("")) {
                                        logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                                    } else {
                                        logHistory.setJumlahPajak(0.0);
                                    }
                                    logHistory.setTahun(simpatda.getTahunSimpatda());
                                    logHistory.setBulan(simpatda.getBulanSimpatda());
                                    logHistory.setInstansi(simpatda.getInstansi());
                                    if (!simpatda.getDenda().equals("")) {
                                        logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
                                    } else {
                                        logHistory.setDenda(0.0);
                                    }
                                    if (!simpatda.getPokok().equals("")) {
                                        logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
                                    } else {
                                        logHistory.setPokok(0.0);
                                    }
                                    logHistory.setAlamat(simpatda.getAlamat());
                                    long l = PstLogHistoryTransaksi.insertExc(logHistory);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Err Sent CDR :" + e);
                }
            } catch (Exception e) {
                System.out.println("Err Err Sent CDR :" + e);
            }
        }
    }

    public void prosesBrr(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                        String whereSent = " WHERE NOP='" + idTagihan + "' AND TAHUN='" + tahun + "'";
                        if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
                            sentPBBIpRotax(whereSent);
                        } else if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
                            sentPBBIpRotaxV2(whereSent);
                        } else {
                            sentPBB(whereSent);
                        }
                        count = 0;
                    }
                }
            }
        }
    }

    public void sentPBB(String where) {
        try {
            try {
                Vector<Pbb> vPBB = new Vector();
                vPBB = SessSimpatda.getListPBB(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vPBB.size() > 0) {
                    for (int i = 0; i < vPBB.size(); i++) {
                        Pbb pbb = vPBB.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PBB);
                        tagihanInsert.setSPassword(AppSetting.PWD_PBB);
                        tagihanInsert.setSNoId("" + pbb.getId());
                        tagihanInsert.setSNama("" + pbb.getNama());
                        tagihanInsert.setJumTagihan(Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PBB);
                        tagihanInsert.setSKet_1("" + pbb.getNpwpd());
                        tagihanInsert.setSKet_2("" + pbb.getAlamat());
                        tagihanInsert.setSKet_3("" + pbb.getLetakObjectPajak());
                        tagihanInsert.setSKet_4("" + pbb.getTahun());
                        tagihanInsert.setSKet_5("" + pbb.getTglJatuhTempo());
                        tagihanInsert.setSKet_6("" + pbb.getLuasBumi());
                        tagihanInsert.setSKet_7("" + pbb.getLuasBangunan());
                        tagihanInsert.setSKet_8("" + pbb.getnJOPBumi());
                        tagihanInsert.setSKet_9("" + pbb.getnJOPBangunan());
                        tagihanInsert.setSKet_10("" + pbb.getnJOPTKP());
                        tagihanInsert.setSKet_11("" + pbb.getDenda());
                        tagihanInsert.setSKet_12("" + pbb.getFormula());
                        if (!pbb.getJumlahTagihan().equals("")) {
                            double total = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
                            long mylong = (long) total;
                            ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
                            pbb.setTerbilang(convert.getText());
                            tagihanInsert.setSKet_13("" + pbb.getTerbilang());
                        } else {
                            tagihanInsert.setSKet_13("" + pbb.getTerbilang());
                        }
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + pbb.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(pbb.getId());
                                logHistory.setNama(pbb.getNama());
                                if (!pbb.getJumlahTagihan().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(pbb.getTahun());
                                logHistory.setBulan("");
                                logHistory.setInstansi(pbb.getInstansi());
                                if (!pbb.getDenda().equals("")) {
                                    logHistory.setDenda(Double.valueOf(pbb.getDenda()).doubleValue());
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                logHistory.setAlamat(pbb.getAlamat());
                                logHistory.setLetakObjeckPajak(pbb.getLetakObjectPajak());
                                if (!pbb.getLuasBangunan().equals("")) {
                                    logHistory.setLuasBangunan(Double.valueOf(pbb.getLuasBangunan()).doubleValue());
                                } else {
                                    logHistory.setLuasBangunan(0.0);
                                }
                                if (!pbb.getLuasBumi().equals("")) {
                                    logHistory.setLuasBumi(Double.valueOf(pbb.getLuasBumi()).doubleValue());
                                } else {
                                    logHistory.setLuasBumi(0.0);
                                }
                                if (!pbb.getnJOPBangunan().equals("")) {
                                    logHistory.setnJOPBangunan(Double.valueOf(pbb.getnJOPBangunan()).doubleValue());
                                } else {
                                    logHistory.setnJOPBangunan(0.0);
                                }
                                if (!pbb.getnJOPBumi().equals("")) {
                                    logHistory.setnJOPBumi(Double.valueOf(pbb.getnJOPBumi()).doubleValue());
                                } else {
                                    logHistory.setnJOPBumi(0.0);
                                }
                                if (!pbb.getnJOPTKP().equals("")) {
                                    logHistory.setnJOPTKP(Double.valueOf(pbb.getnJOPTKP()).doubleValue());
                                } else {
                                    logHistory.setnJOPTKP(0.0);
                                }
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void sentPBBIpRotax(String where) {
        try {
            try {
                Vector<Pbb> vPBB = new Vector();
                vPBB = SessSimpatda.getListPBBIprotax(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vPBB.size() > 0) {
                    for (int i = 0; i < vPBB.size(); i++) {
                        Pbb pbb = vPBB.get(i);
                        double totPambayaran = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
                        double denda = Math.ceil(Double.valueOf(pbb.getDenda()).doubleValue());
                        double ygHarusDibayar = totPambayaran + denda;
                        try {
                            pbb.setJumlahTagihan(String.valueOf(ygHarusDibayar));
                        } catch (Exception exception) {
                        }
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PBB);
                        tagihanInsert.setSPassword(AppSetting.PWD_PBB);
                        tagihanInsert.setSNoId("" + pbb.getId());
                        tagihanInsert.setSNama("" + pbb.getNama());
                        tagihanInsert.setJumTagihan(ygHarusDibayar);
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PBB);
                        tagihanInsert.setSKet_1("" + pbb.getNpwpd());
                        tagihanInsert.setSKet_2("" + pbb.getAlamat());
                        tagihanInsert.setSKet_3("" + pbb.getLetakObjectPajak());
                        tagihanInsert.setSKet_4("" + pbb.getTahun());
                        tagihanInsert.setSKet_5("" + pbb.getTglJatuhTempo());
                        tagihanInsert.setSKet_6("" + pbb.getLuasBumi());
                        tagihanInsert.setSKet_7("" + pbb.getLuasBangunan());
                        tagihanInsert.setSKet_8("" + pbb.getnJOPBumi());
                        tagihanInsert.setSKet_9("" + pbb.getnJOPBangunan());
                        tagihanInsert.setSKet_10("" + pbb.getnJOPTKP());
                        try {
                            pbb.setDenda(Formater.formatNumber(denda, "#,###,##0"));
                        } catch (Exception exception) {
                        }
                        tagihanInsert.setSKet_11("" + pbb.getDenda());
                        pbb.setFormula("(" + pbb.getnJOPBumi() + " + " + pbb.getnJOPBangunan() + " - " + pbb.getnJOPTKP() + ") X " + (pbb.getTarifSppt() * pbb.getNjkpSppt() / 100.0) + " % + " + pbb.getDenda());
                        tagihanInsert.setSKet_12("" + pbb.getFormula());
                        if (!pbb.getJumlahTagihan().equals("")) {
                            double total = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
                            long mylong = (long) total;
                            ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
                            pbb.setTerbilang(convert.getText() + " rupiah ");
                            tagihanInsert.setSKet_13("" + pbb.getTerbilang());
                        } else {
                            tagihanInsert.setSKet_13("" + pbb.getTerbilang());
                        }
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + pbb.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
                                if (dTaxManagerPbbx.getStatusAutoUpload().length() > 0) {
                                    DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Upload berhasil<br><br>";
                                }
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(pbb.getId());
                                logHistory.setNama(pbb.getNama());
                                if (!pbb.getJumlahTagihan().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(pbb.getTahun());
                                logHistory.setBulan("");
                                logHistory.setInstansi(pbb.getInstansi());
                                if (!pbb.getDenda().equals("")) {
                                    logHistory.setDenda(denda);
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                logHistory.setAlamat(pbb.getAlamat());
                                logHistory.setLetakObjeckPajak(pbb.getLetakObjectPajak());
                                if (!pbb.getLuasBangunan().equals("")) {
                                    logHistory.setLuasBangunan(pbb.getDluasBangunan());
                                } else {
                                    logHistory.setLuasBangunan(0.0);
                                }
                                if (!pbb.getLuasBumi().equals("")) {
                                    logHistory.setLuasBumi(pbb.getDluasBumi());
                                } else {
                                    logHistory.setLuasBumi(0.0);
                                }
                                if (!pbb.getnJOPBangunan().equals("")) {
                                    logHistory.setnJOPBangunan(pbb.getDnJOPBangunan());
                                } else {
                                    logHistory.setnJOPBangunan(0.0);
                                }
                                if (!pbb.getnJOPBumi().equals("")) {
                                    logHistory.setnJOPBumi(pbb.getDnJOPBumi());
                                } else {
                                    logHistory.setnJOPBumi(0.0);
                                }
                                if (!pbb.getnJOPTKP().equals("")) {
                                    logHistory.setnJOPTKP(pbb.getDnJOPTKP());
                                } else {
                                    logHistory.setnJOPTKP(0.0);
                                }
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void sentPBBIpRotaxV2(String where) {
        Diskon diskon = new Diskon();
        try {
            try {
                double jumlahTagihan = 0;
                Vector<Pbb> vPBB = new Vector();
                vPBB = SessSimpatda.getListPBBIprotaxV2(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vPBB.size() > 0) {
                    for (int i = 0; i < vPBB.size(); i++) {
                        Pbb pbb = vPBB.get(i);
                        jumlahTagihan = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
                        Date tglJatuhTempo = (new SimpleDateFormat("dd-MM-yyyy")).parse(pbb.getTglJatuhTempo());
                        Calendar startCalendar = Calendar.getInstance();
                        Calendar endCalendar = Calendar.getInstance();
                        String strJatuhTempoNew = "2021-01-31";
                        Date dtJatuhTempo = (new SimpleDateFormat("yyyy-MM-dd")).parse(strJatuhTempoNew);
                        int tahun = 0;
                        try {
                            tahun = Integer.valueOf(pbb.getTahun()).intValue();
                            if (tahun < 2021) {
                                startCalendar.setTime(dtJatuhTempo);
                            } else {
                                startCalendar.setTime(tglJatuhTempo);
                            }
                        } catch (Exception exc) {
                            startCalendar.setTime(tglJatuhTempo);
                        }
                        int tunggakan = 0;
                        int diffYear = 0;
                        int diffMonth = 0;
                        int typePembayaran = 0;
                        String wherePembayaran = "NOP=" + pbb.getId() + " AND THN_PAJAK_SPPT=" + pbb.getTahun();
                        Vector<PaymentPbb> listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");
                        double totalPembayaran = 0.0;
                        double pembayaranPertama = 0.0;
                        double pembayaranDenda = 0.0;
                        Date tglDendaSeharusnya = null;
                        Date tglDendaPembayaranPertama = null;
                        if (listPembayaran.size() > 0) {
                            for (int x = 0; x < listPembayaran.size(); x++) {
                                PaymentPbb paymentPbb = listPembayaran.get(x);
                                totalPembayaran += paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                                pembayaranDenda += paymentPbb.getDendaSppt();
                                if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0.0) {
                                    tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                                }
                                if (paymentPbb.getPembayaranSpptKe() == 1.0) {
                                    tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                                    pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                                }
                            }
                        }

                        if(tahun == 2026){
                            int jumlahTunggakan = 0;
                            String sqlTunggakan = "SELECT COUNT(*) FROM VIEW_PBB WHERE NOP = "+pbb.getNop();
                            DBResultSet dbrs2 = DBHandler.execQueryResultNew(sqlTunggakan);
                            ResultSet rs2 = dbrs2.getResultSet();

                            if(rs2.next()){
                                jumlahTunggakan = rs2.getInt(1);
                            }
                            DBResultSet.close(dbrs2);

                            if(jumlahTunggakan > 1){
                                if(jumlahTagihan <= 2000000){
                                    jumlahTagihan = jumlahTagihan - (jumlahTagihan * 0.01);
                                }else {
                                    jumlahTagihan = jumlahTagihan - (jumlahTagihan * 0.005);
                                }
                            }                                
                        }
                        diffYear = endCalendar.get(1) - startCalendar.get(1);
                        diffMonth = diffYear * 12 + endCalendar.get(2) - startCalendar.get(2);
                        if (endCalendar.get(5) > startCalendar.get(5)) {
                            diffMonth++;
                        }
                        if (diffMonth > 0) {
                            tunggakan = diffMonth;
                        }
                        double persentaseDenda = 0.0;
                        if (tunggakan > 0) {
                            if (tunggakan > 24) {
                                persentaseDenda = 24.0 * (2.0 / 100.0);
                            } else {
                                persentaseDenda = tunggakan * (2.0 / 100.0);
                            }
                        }
                        persentaseDenda = diskon.perdentaseDenda(endCalendar, tahun, tglJatuhTempo);
                        double denda = 0.0;
                        double countDenda = (jumlahTagihan - totalPembayaran) * persentaseDenda;
                        try {
                            NumberFormat formatter = new DecimalFormat("#0.00");
                            String condenda = formatter.format(countDenda);
                            countDenda = Double.valueOf(condenda).doubleValue();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        denda = Math.round(countDenda);
                        denda = diskon.konpensasiDenda(tahun, denda, persentaseDenda, jumlahTagihan - totalPembayaran);
                        try {
                            String sDate1 = "2021-02-01";
                            Date dateDenda = (new SimpleDateFormat("yyyy-MM-dd")).parse(sDate1);
                            if ((new Date()).before(dateDenda)) {
                                denda = 0.0;
                            }
                        } catch (Exception exception) {
                        }
                        pbb.setTerbilang("");
                        double totPambayaran = 0.0;
                        if (jumlahTagihan - totalPembayaran > 0.0) {
                            totPambayaran = jumlahTagihan - totalPembayaran;
                        }
                        totPambayaran = diskon.diskonPajak(tahun, totPambayaran);
                        double ygHarusDibayar = totPambayaran + denda;

                        try {
                            pbb.setJumlahTagihan(String.format("%.0f", new Object[]{Double.valueOf(ygHarusDibayar)}));
                        } catch (Exception exception) {
                        }
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PBB);
                        tagihanInsert.setSPassword(AppSetting.PWD_PBB);
                        tagihanInsert.setSNoId("" + pbb.getId());
                        tagihanInsert.setSNama("" + pbb.getNama());
                        tagihanInsert.setJumTagihan(Double.valueOf(String.format("%.0f", new Object[]{Double.valueOf(ygHarusDibayar)})).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PBB);
                        tagihanInsert.setSKet_1("" + pbb.getNpwpd());
                        tagihanInsert.setSKet_2("" + pbb.getAlamat());
                        tagihanInsert.setSKet_3("" + pbb.getLetakObjectPajak());
                        tagihanInsert.setSKet_4("" + pbb.getTahun());
                        tagihanInsert.setSKet_5("" + pbb.getTglJatuhTempo());
                        tagihanInsert.setSKet_6("" + pbb.getLuasBumi());
                        tagihanInsert.setSKet_7("" + pbb.getLuasBangunan());
                        tagihanInsert.setSKet_8("" + pbb.getnJOPBumi());
                        tagihanInsert.setSKet_9("" + pbb.getnJOPBangunan());
                        tagihanInsert.setSKet_10("" + pbb.getnJOPTKP());
                        try {
                            pbb.setDenda(Formater.formatNumber(denda, "#,###,##0"));
                        } catch (Exception exception) {
                        }
                        tagihanInsert.setSKet_11("" + pbb.getDenda());
                        pbb.setFormula("(" + pbb.getnJOPBumi() + " + " + pbb.getnJOPBangunan() + " - " + pbb.getnJOPTKP() + ") X " + (pbb.getTarifSppt() * pbb.getNjkpSppt() / 100.0) + " % + " + pbb.getDenda());
                        tagihanInsert.setSKet_12("" + pbb.getFormula());
                        if (!pbb.getJumlahTagihan().equals("")) {
                            double total = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
                            long mylong = (long) total;
                            ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
                            pbb.setTerbilang(convert.getText() + " rupiah ");
                            tagihanInsert.setSKet_13("" + pbb.getTerbilang());
                        } else {
                            tagihanInsert.setSKet_13("" + pbb.getTerbilang());
                        }
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + pbb.getNpwpd() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
                                if (dTaxManagerPbbx.getStatusAutoUpload().length() > 0) {
                                    DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Upload berhasil<br><br>";
                                }
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(pbb.getId());
                                logHistory.setNama(pbb.getNama());
                                if (!pbb.getJumlahTagihan().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(pbb.getTahun());
                                logHistory.setBulan("");
                                logHistory.setInstansi(pbb.getInstansi());
                                if (!pbb.getDenda().equals("")) {
                                    logHistory.setDenda(denda);
                                } else {
                                    logHistory.setDenda(0.0);
                                }
                                logHistory.setAlamat(pbb.getAlamat());
                                logHistory.setLetakObjeckPajak(pbb.getLetakObjectPajak());
                                if (!pbb.getLuasBangunan().equals("")) {
                                    logHistory.setLuasBangunan(pbb.getDluasBangunan());
                                } else {
                                    logHistory.setLuasBangunan(0.0);
                                }
                                if (!pbb.getLuasBumi().equals("")) {
                                    logHistory.setLuasBumi(pbb.getDluasBumi());
                                } else {
                                    logHistory.setLuasBumi(0.0);
                                }
                                if (!pbb.getnJOPBangunan().equals("")) {
                                    logHistory.setnJOPBangunan(pbb.getDnJOPBangunan());
                                } else {
                                    logHistory.setnJOPBangunan(0.0);
                                }
                                if (!pbb.getnJOPBumi().equals("")) {
                                    logHistory.setnJOPBumi(pbb.getDnJOPBumi());
                                } else {
                                    logHistory.setnJOPBumi(0.0);
                                }
                                if (!pbb.getnJOPTKP().equals("")) {
                                    logHistory.setnJOPTKP(pbb.getDnJOPTKP());
                                } else {
                                    logHistory.setnJOPTKP(0.0);
                                }
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void prosesBphtb(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                        String whereSent = " WHERE ID='" + idTagihan + "' AND NOP='" + tahun + "'";
                        sentBphtb(whereSent);
                        count = 0;
                    }
                }
            }
        }
    }

    public void prosesBphtbIprotax(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                        String whereSent = " WHERE NO_ID='" + idTagihan + "' AND SNOID='" + tahun + "'";
                        sentBphtbIprotax(whereSent);
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
                vSimpatda = SessSimpatda.getListBphtb(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Bphtb bphtb = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_BPHTB);
                        tagihanInsert.setSPassword(AppSetting.PWD_BPHTB);
                        tagihanInsert.setSNoId("" + bphtb.getId());
                        tagihanInsert.setSNama("" + bphtb.getNama());
                        tagihanInsert.setJumTagihan(Double.valueOf(bphtb.getJumlahTagihan()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_BPHTB);
                        tagihanInsert.setSKet_1("" + bphtb.getNop());
                        tagihanInsert.setSKet_2("" + bphtb.getLetakObjectPajak());
                        String valStr = Formater.formatNumber(Double.valueOf(bphtb.getPokok()).doubleValue(), "#,###");
                        tagihanInsert.setSKet_3("" + valStr);
                        String denda = "0";
                        if (!bphtb.getDenda().equals("")) {
                            denda = Formater.formatNumber(Double.valueOf(bphtb.getDenda()).doubleValue(), "#,###");
                        }
                        tagihanInsert.setSKet_4("" + denda);
                        tagihanInsert.setSKet_5("");
                        tagihanInsert.setSKet_6("");
                        tagihanInsert.setSKet_7("");
                        tagihanInsert.setSKet_8("");
                        tagihanInsert.setSKet_9("");
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
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
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun("");
                                logHistory.setBulan("");
                                logHistory.setInstansi(bphtb.getInstansi());
                                logHistory.setDenda(0.0);
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void sentBphtbIprotax(String where) {
        try {
            try {
                Vector<BphtbIprotax> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListBphtbIprotax(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        BphtbIprotax bphtb = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_BPHTB);
                        tagihanInsert.setSPassword(AppSetting.PWD_BPHTB);
                        tagihanInsert.setSNoId("" + bphtb.getNoId());
                        tagihanInsert.setSNama("" + bphtb.getNama());
                        tagihanInsert.setJumTagihan(Double.valueOf(bphtb.getJumTagihan()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_BPHTB);
                        tagihanInsert.setSKet_1("" + bphtb.getsNoId());
                        tagihanInsert.setSKet_2("" + bphtb.getPpat());
                        if (!bphtb.getJumTagihan().equals("")) {
                            double total = Double.valueOf(bphtb.getJumTagihan()).doubleValue();
                            long mylong = (long) total;
                            ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
                            bphtb.setTerbilang(convert.getText());
                            tagihanInsert.setSKet_3("" + bphtb.getTerbilang());
                        } else {
                            tagihanInsert.setSKet_3("" + bphtb.getTerbilang());
                        }
                        tagihanInsert.setSKet_4("");
                        tagihanInsert.setSKet_5("");
                        tagihanInsert.setSKet_6("");
                        tagihanInsert.setSKet_7("");
                        tagihanInsert.setSKet_8("");
                        tagihanInsert.setSKet_9("");
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + bphtb.getNoId() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                DTaxManagerBphtb dTaxManagerBphtbx = new DTaxManagerBphtb();
                                if (dTaxManagerBphtbx.getStatusAutoUpload().length() > 0) {
                                    DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Upload berhasil<br><br>";
                                }
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(bphtb.getNoId());
                                logHistory.setNama(bphtb.getNama());
                                if (!bphtb.getJumTagihan().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(bphtb.getJumTagihan()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun("");
                                logHistory.setBulan("");
                                logHistory.setInstansi(bphtb.getInstansi());
                                logHistory.setDenda(0.0);
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void sentAutoBphtb(String where) {
        try {
            try {
                Vector<Bphtb> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListAutoBphtb(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Bphtb bphtb = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_BPHTB);
                        tagihanInsert.setSPassword(AppSetting.PWD_BPHTB);
                        tagihanInsert.setSNoId("" + bphtb.getId());
                        tagihanInsert.setSNama("" + bphtb.getNama());
                        tagihanInsert.setJumTagihan(Double.valueOf(bphtb.getJumlahTagihan()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_BPHTB);
                        tagihanInsert.setSKet_1("" + bphtb.getNop());
                        tagihanInsert.setSKet_2("" + bphtb.getLetakObjectPajak());
                        String valStr = Formater.formatNumber(Double.valueOf(bphtb.getPokok()).doubleValue(), "#,###");
                        tagihanInsert.setSKet_3("" + valStr);
                        String denda = "0";
                        if (!bphtb.getDenda().equals("")) {
                            denda = Formater.formatNumber(Double.valueOf(bphtb.getDenda()).doubleValue(), "#,###");
                        }
                        tagihanInsert.setSKet_4("" + denda);
                        tagihanInsert.setSKet_5("");
                        tagihanInsert.setSKet_6("");
                        tagihanInsert.setSKet_7("");
                        tagihanInsert.setSKet_8("");
                        tagihanInsert.setSKet_9("");
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + bphtb.getId() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(bphtb.getId());
                                logHistory.setTib(Long.parseLong(bphtb.getId()));
                                logHistory.setNama(bphtb.getNama());
                                if (!bphtb.getJumlahTagihan().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(bphtb.getJumlahTagihan()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun("");
                                logHistory.setBulan("");
                                logHistory.setInstansi(bphtb.getInstansi());
                                logHistory.setDenda(0.0);
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void sentAutoPhr(String where) {
        try {
            try {
                Vector<Simpatda> vSimpatda = new Vector();
                vSimpatda = SessSimpatda.getListSimpatdaAuto(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vSimpatda.size() > 0) {
                    for (int i = 0; i < vSimpatda.size(); i++) {
                        Simpatda simpatda = vSimpatda.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_PHR);
                        tagihanInsert.setSPassword(AppSetting.PWD_PHR);
                        tagihanInsert.setSNoId("" + simpatda.getId());
                        tagihanInsert.setSNama("" + simpatda.getNamaSimpatda());
                        tagihanInsert.setJumTagihan(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_PHR);
                        tagihanInsert.setSKet_1("" + simpatda.getAlamat());
                        tagihanInsert.setSKet_2("" + simpatda.getBulanSimpatda());
                        tagihanInsert.setSKet_3("" + simpatda.getTahunSimpatda());
                        tagihanInsert.setSKet_4("" + simpatda.getPokok());
                        tagihanInsert.setSKet_5("" + simpatda.getDenda());
                        tagihanInsert.setSKet_6("" + simpatda.getNoSspdSimpatda());
                        tagihanInsert.setSKet_7("" + simpatda.getKeterangan());
                        tagihanInsert.setSKet_8("");
                        tagihanInsert.setSKet_9("");
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        if (!cekHistory) {
                            try {
                                resp_code = echo.action(tagihanInsert);
                                massage = "Insert ID " + simpatda.getNpwpd() + " Proses : " + resp_code;
                                if (resp_code.equals("00")) {
                                    LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                    logHistory.setId(simpatda.getId());
                                    logHistory.setNama(simpatda.getNamaSimpatda());
                                    if (!simpatda.getJumlahPajakSimpatda().equals("")) {
                                        logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
                                    } else {
                                        logHistory.setJumlahPajak(0.0);
                                    }
                                    logHistory.setTahun(simpatda.getTahunSimpatda());
                                    logHistory.setBulan(simpatda.getBulanSimpatda());
                                    logHistory.setInstansi(simpatda.getInstansi());
                                    try {
                                        if (!simpatda.getDenda().equals("")) {
                                            logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
                                        } else {
                                            logHistory.setDenda(0.0);
                                        }
                                    } catch (Exception ex) {
                                        logHistory.setDenda(0.0);
                                    }
                                    try {
                                        if (!simpatda.getPokok().equals("")) {
                                            logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
                                        } else {
                                            logHistory.setPokok(0.0);
                                        }
                                    } catch (Exception ex) {
                                        logHistory.setPokok(0.0);
                                    }
                                    logHistory.setAlamat(simpatda.getAlamat());
                                    long l = PstLogHistoryTransaksi.insertExc(logHistory);
                                }
                            } catch (Exception ex) {
                                DTaxManagerAutomaticPhr.running = false;
                                DTaxManagerAutomaticPhr.note = " Service Stop Cek NPWPD : " + tagihanInsert.getSNoId();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
                DTaxManagerAutomaticPhr.running = false;
                DTaxManagerAutomaticPhr.note = " Service Stop Database view Compare";
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
            DTaxManagerAutomaticPhr.running = false;
        }
    }

    public void prosesRetribusi(String var) {
        String[] splits = var.split(",");
        int count = 0;
        String idTagihan = "";
        String tahun = "";
        String bulan = "";
        for (String asset : splits) {
            if (asset != "") {
                String[] splitsDua = asset.split(";");
                for (String value : splitsDua) {
                    count++;
                    if (count == 1) {
                        idTagihan = value;
                    }
                    if (count == 2) {
                        tahun = value;
                        String whereSent = " WHERE ID='" + idTagihan + "'";
                        sentRetribusi(whereSent);
                        count = 0;
                    }
                }
            }
        }
    }

    public void sentRetribusi(String where) {
        try {
            try {
                Vector<Retribusi> vRetribusi = new Vector();
                vRetribusi = SessSimpatda.getListRetribusi(where);
                EchoTagihanInsert echo = new EchoTagihanInsert();
                if (vRetribusi.size() > 0) {
                    for (int i = 0; i < vRetribusi.size(); i++) {
                        Retribusi retribusi = vRetribusi.get(i);
                        TagihanInsert tagihanInsert = new TagihanInsert();
                        tagihanInsert.setsUser(AppSetting.USERNAME_RETRIBUSI);
                        tagihanInsert.setSPassword(AppSetting.PWD_RETRIBUSI);
                        tagihanInsert.setSNoId("" + retribusi.getNoRekening());
                        tagihanInsert.setSNama("" + retribusi.getNama());
                        tagihanInsert.setJumTagihan(Double.valueOf(retribusi.getJumlahTagihan()).doubleValue());
                        tagihanInsert.setSInstansi(AppSetting.INSTANSI_RETRIBUSI);
                        tagihanInsert.setSKet_1("" + retribusi.getTanggalPenerimaan());
                        tagihanInsert.setSKet_2("");
                        tagihanInsert.setSKet_3("");
                        tagihanInsert.setSKet_4("");
                        tagihanInsert.setSKet_5("");
                        tagihanInsert.setSKet_6("");
                        tagihanInsert.setSKet_7("");
                        tagihanInsert.setSKet_8("");
                        tagihanInsert.setSKet_9("");
                        tagihanInsert.setSKet_10("");
                        tagihanInsert.setSKet_11("");
                        tagihanInsert.setSKet_12("");
                        tagihanInsert.setSKet_13("");
                        String resp_code = "";
                        boolean cekHistory = false;
                        cekHistory = SessSimpatda.checkHistoryRetribusi(retribusi.getNoRekening(), retribusi.getTahun(), retribusi.getBulan(), retribusi.getTanggal());
                        if (!cekHistory) {
                            resp_code = echo.action(tagihanInsert);
                            massage = "Insert ID " + retribusi.getNoRekening() + " Proses : " + resp_code;
                            if (resp_code.equals("00")) {
                                LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                                logHistory.setId(retribusi.getNoRekening());
                                logHistory.setNama(retribusi.getNama());
                                if (!retribusi.getJumlahTagihan().equals("")) {
                                    logHistory.setJumlahPajak(Double.valueOf(retribusi.getJumlahTagihan()).doubleValue());
                                } else {
                                    logHistory.setJumlahPajak(0.0);
                                }
                                logHistory.setTahun(retribusi.getTahun());
                                logHistory.setBulan(retribusi.getBulan());
                                logHistory.setTanggal(retribusi.getTanggal());
                                logHistory.setInstansi(retribusi.getInstansi());
                                logHistory.setIdKey(retribusi.getIdKey());
                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
                                String dateStringTransaksi = "" + retribusi.getTanggalPenerimaan();
                                try {
                                    Date transaksiDate = formatter.parse(dateStringTransaksi);
                                    logHistory.setTanggalRetribusi(transaksiDate);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                logHistory.setDenda(0.0);
                                long l = PstLogHistoryTransaksi.insertExc(logHistory);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void inputPaymentPHR(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentPhr = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_PHR);
                laporanPayment.setsPassword(AppSetting.PWD_PHR);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_PHR);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentPhr = echoLaporan.getListPaymentDetailPHR(laporanPayment);
                System.out.println(" data berhasil di ambil dari server ");
                if (vPaymentPhr.size() > 0) {
                    for (int i = 0; i < vPaymentPhr.size(); i++) {
                        System.out.println(" proses pengambilan data ");
                        Payment payment = vPaymentPhr.get(i);
                        PaymentPhr paymentPhr = new PaymentPhr();
                        paymentPhr.setNoSspd(payment.getId());
                        paymentPhr.setNpwpd(payment.getNoId());
                        paymentPhr.setMasaPajak("" + payment.getBulan());
                        paymentPhr.setTahunPajak("" + payment.getTahun());
                        double absoluteTagihan = 0.0;
                        if (!payment.getTagihan().equals("")) {
                            paymentPhr.setJumlahBayar(Double.valueOf(payment.getTagihan()).doubleValue());
                            absoluteTagihan = Math.abs(paymentPhr.getJumlahBayar());
                        } else {
                            paymentPhr.setJumlahBayar(0.0);
                        }
                        paymentPhr.setNama(payment.getNama());
                        if (!payment.getBiayaAdm().equals("")) {
                            paymentPhr.setBiayaAdministrasi(Double.valueOf(payment.getBiayaAdm()).doubleValue());
                        } else {
                            paymentPhr.setBiayaAdministrasi(0.0);
                        }
                        if (!payment.getDenda().equals("")) {
                            paymentPhr.setDenda(Double.valueOf(payment.getDenda()).doubleValue());
                        } else {
                            paymentPhr.setDenda(0.0);
                        }
                        if (!payment.getPokok().equals("")) {
                            paymentPhr.setPokok(Double.valueOf(payment.getPokok()).doubleValue());
                        } else {
                            paymentPhr.setPokok(0.0);
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateStringTransaksi = "" + payment.getTglTx();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            paymentPhr.setTglRekam(transaksiDate);
                            paymentPhr.setTanggal(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        paymentPhr.setIdPayment(payment.getId());
                        paymentPhr.setStatus(payment.getStsReversal());
                        paymentPhr.setIdRekam("090909090");
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentPhr(payment.getId());
                            if (cekHistory) {
                                String idKey = SessSimpatda.checkKeyId(payment.getNoId(), payment.getTahun(), payment.getBulan(), absoluteTagihan);
                                paymentPhr.setIdKey(idKey);
                                long oid = PstPaymentPhr.insertExc(paymentPhr);
                                long oid2 = PstPaymentPhrAll.insertExc(paymentPhr);
                                if (payment.getStsReversal().equals("1")) {
                                    String update = SessSimpatda.updateStatusRaversal(payment.getNoId(), payment.getTahun(), payment.getBulan(), absoluteTagihan);
                                    String str1 = SessSimpatda.updateStatusRaversalPhrAll(payment.getNoId(), payment.getTahun(), payment.getBulan(), absoluteTagihan);
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void inputPaymentPHRforOpenPHR(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentPhr = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_PHR);
                laporanPayment.setsPassword(AppSetting.PWD_PHR);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_PHR);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentPhr = echoLaporan.getListPaymentDetailPHRforOpenPhr(laporanPayment);
                if (vPaymentPhr.size() > 0) {
                    for (int i = 0; i < vPaymentPhr.size(); i++) {
                        Payment payment = vPaymentPhr.get(i);
                        PaymentPhrforOpenPhr paymentPhr = new PaymentPhrforOpenPhr();
                        paymentPhr.setIdBank(payment.getId());
                        paymentPhr.setInstansi(payment.getInstansi());
                        paymentPhr.setNoId(payment.getNoId());
                        paymentPhr.setNama(payment.getNama());
                        try {
                            if (!payment.getTagihan().equals("")) {
                                paymentPhr.setTagihan(Double.valueOf(payment.getTagihan()).doubleValue());
                            } else {
                                paymentPhr.setTagihan(0.0);
                            }
                        } catch (Exception exception) {
                        }
                        paymentPhr.setKetTagihan(payment.getKetTagihan());
                        try {
                            if (!payment.getTagihanLain().equals("")) {
                                paymentPhr.setTagihanLain(Double.valueOf(payment.getTagihanLain()).doubleValue());
                            } else {
                                paymentPhr.setTagihanLain(0.0);
                            }
                        } catch (Exception exception) {
                        }
                        try {
                            if (!payment.getBiayaAdm().equals("")) {
                                paymentPhr.setBiayaAdm(Double.valueOf(payment.getBiayaAdm()).doubleValue());
                            } else {
                                paymentPhr.setBiayaAdm(0.0);
                            }
                        } catch (Exception exception) {
                        }
                        paymentPhr.setAlamat(payment.getAlamatWp());
                        paymentPhr.setBulan("" + payment.getBulan());
                        paymentPhr.setTahun("" + payment.getTahun());
                        if (!payment.getPokok().equals("")) {
                            paymentPhr.setPokok(Double.valueOf(payment.getPokok()).doubleValue());
                        } else {
                            paymentPhr.setPokok(0.0);
                        }
                        if (!payment.getDenda().equals("")) {
                            paymentPhr.setDenda(Double.valueOf(payment.getDenda()).doubleValue());
                        } else {
                            paymentPhr.setDenda(0.0);
                        }
                        paymentPhr.setKeterangan(payment.getKeterangan());
                        paymentPhr.setNpwpd(payment.getNpwp());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        paymentPhr.setTanggalAkhir(newDay);
                        String dateStringTanggalAwal = "" + payment.getTglAwal();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTanggalAwal);
                            paymentPhr.setTanggalAwal(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String dateStringTanggalAkhir = "" + payment.getTglAkhir();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTanggalAkhir);
                            paymentPhr.setTanggalAkhir(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String dateStringTransaksi = "" + payment.getTglTx();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            paymentPhr.setTglTransaksi(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        paymentPhr.setStatusBayar(Integer.parseInt(payment.getStsBayar()));
                        paymentPhr.setKdCab(payment.getKdCab());
                        paymentPhr.setKdUser(payment.getKdUser());
                        paymentPhr.setStatusReversal(Integer.parseInt(payment.getStsReversal()));
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentPhrOpenPhr(payment.getId());
                            if (cekHistory) {
                                long oid = PstPaymentPhrforOpenPhr.insertExc(paymentPhr);
                                if (payment.getStsReversal().equals("1")) {
                                    String str = SessSimpatda.updateStatusRaversalOpenPhr(payment.getNoId());
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public synchronized void inputPaymentPHRforPhrH(String dateLaporan, String noID) {
        if (DTaxIntegrationManager.running) {
            inputPaymentPHRforPhrH(dateLaporan, noID, "");
        }
    }

    public synchronized void inputPaymentPHRforPhrH(String dateLaporan, String noID, String noBuktiBank) {
        try {
            try {
                Vector<Payment> vPaymentPhr = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                EchoLaporanPaymentDetailSetelahNoBukti echoLaporanSetelahNoBukti = new EchoLaporanPaymentDetailSetelahNoBukti();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_PHR);
                laporanPayment.setsPassword(AppSetting.PWD_PHR);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_PHR);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                if (noBuktiBank.equals("")) {
                    vPaymentPhr = echoLaporan.getListPaymentDetailPHRforPhrH(laporanPayment);
                } else {
                    laporanPayment.setsNoBuktiBank(noBuktiBank);
                    vPaymentPhr = echoLaporanSetelahNoBukti.getListPaymentDetailPHRforPhrH(laporanPayment);
                }
                if (vPaymentPhr.size() > 0) {
                    for (int i = 0; i < vPaymentPhr.size(); i++) {
                        Payment payment = vPaymentPhr.get(i);
                        PaymentPhrforPhrH paymentPhr = new PaymentPhrforPhrH();
                        paymentPhr.setIdBank(payment.getId());
                        paymentPhr.setInstansi(payment.getInstansi());
                        paymentPhr.setNoId(payment.getNoId());
                        paymentPhr.setNama(payment.getNama());
                        try {
                            if (!payment.getTagihan().equals("")) {
                                paymentPhr.setTagihan(Double.valueOf(payment.getTagihan()).doubleValue());
                            } else {
                                paymentPhr.setTagihan(0.0);
                            }
                        } catch (Exception exception) {
                        }
                        paymentPhr.setKetTagihan(payment.getKetTagihan());
                        try {
                            if (!payment.getTagihanLain().equals("")) {
                                paymentPhr.setTagihanLain(Double.valueOf(payment.getTagihanLain()).doubleValue());
                            } else {
                                paymentPhr.setTagihanLain(0.0);
                            }
                        } catch (Exception exception) {
                        }
                        try {
                            if (!payment.getBiayaAdm().equals("")) {
                                paymentPhr.setBiayaAdm(Double.valueOf(payment.getBiayaAdm()).doubleValue());
                            } else {
                                paymentPhr.setBiayaAdm(0.0);
                            }
                        } catch (Exception exception) {
                        }
                        paymentPhr.setAlamat(payment.getAlamatWp());
                        paymentPhr.setBulan("" + payment.getBulan());
                        paymentPhr.setTahun("" + payment.getTahun());
                        if (!payment.getPokok().equals("")) {
                            paymentPhr.setPokok(Double.valueOf(payment.getPokok()).doubleValue());
                        } else {
                            paymentPhr.setPokok(0.0);
                        }
                        if (!payment.getDenda().equals("")) {
                            paymentPhr.setDenda(Double.valueOf(payment.getDenda()).doubleValue());
                        } else {
                            paymentPhr.setDenda(0.0);
                        }
                        if (!payment.getTagihanAdmin().equals("")) {
                            paymentPhr.setTagihanAdmin(Double.valueOf(payment.getTagihanAdmin()).doubleValue());
                        } else {
                            paymentPhr.setTagihanAdmin(0.0);
                        }
                        paymentPhr.setNpwpd(payment.getNpwp());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateStringJatuhTempo = "" + payment.getTglJatuhTempo();
                        try {
                            Date transaksiDate = formatter.parse(dateStringJatuhTempo);
                            paymentPhr.setTglJatuhTemp(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String dateStringWaktu = "" + payment.getWaktu();
                        try {
                            Date transaksiDate = formatter.parse(dateStringWaktu);
                            paymentPhr.setWaktu(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String dateStringTransaksi = "" + payment.getTglTx();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            paymentPhr.setTglTransaksi(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        paymentPhr.setStatusBayar(Integer.parseInt(payment.getStsBayar()));
                        paymentPhr.setKdCab(payment.getKdCab());
                        paymentPhr.setKdUser(payment.getKdUser());
                        paymentPhr.setStatusReversal(Integer.parseInt(payment.getStsReversal()));
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentPhrForPhrH(payment.getId());
                            if (cekHistory) {
                                long oid = PstPaymentPhrforPhrH.insertExc(paymentPhr);
                                if (payment.getStsReversal().equals("1")) {
                                    String str = SessSimpatda.updateStatusRaversalPhrH(payment.getNoId());
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err Sent CDR :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err Err Sent CDR :" + e);
        }
    }

    public void inputPaymentPBB(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentPBB = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_PBB);
                laporanPayment.setsPassword(AppSetting.PWD_PBB);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_PBB);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentPBB = echoLaporan.getListPaymentDetailPBB(laporanPayment);
                if (vPaymentPBB.size() > 0) {
                    for (int i = 0; i < vPaymentPBB.size(); i++) {
                        Payment payment = vPaymentPBB.get(i);
                        PaymentPbb paymentPbb = new PaymentPbb();
                        paymentPbb.setIdPaymentBank(Long.parseLong(payment.getId()));
                        paymentPbb.setKdPropinsi("");
                        paymentPbb.setKdDati2("");
                        paymentPbb.setKdKecamata("");
                        paymentPbb.setKdKelurahan("");
                        paymentPbb.setKdBlok("");
                        paymentPbb.setNoUrut("");
                        paymentPbb.setKdJnsOp("");
                        paymentPbb.setThnPajakSppt("" + payment.getTahun());
                        paymentPbb.setPembayaranSpptKe(0.0);
                        paymentPbb.setKdKanwilBank("");
                        paymentPbb.setKdKppbbBank("");
                        paymentPbb.setKdBankTunggal("");
                        paymentPbb.setKdBankPersepsi("");
                        paymentPbb.setKdTp("");
                        if (!payment.getDenda().equals("")) {
                            paymentPbb.setDendaSppt(Double.valueOf(payment.getDenda()).doubleValue());
                        }
                        if (!payment.getTagihan().equals("")) {
                            paymentPbb.setJmlSpptYgDibayar(Double.valueOf(payment.getTagihan()).doubleValue());
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateStringTransaksi = "" + payment.getTglTx();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            paymentPbb.setTglPembayaranSppt(transaksiDate);
                            paymentPbb.setTglRekamByrSppt(transaksiDate);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        paymentPbb.setNop(Long.valueOf(payment.getNoId()).longValue());
                        paymentPbb.setNipRekamByrSppt("090909090");
                        paymentPbb.setStatus(Integer.parseInt(payment.getStsReversal()));
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentPBB(payment.getId());
                            if (cekHistory) {
                                String idKey = SessSimpatda.checkKeyIdPbb(payment.getNoId(), payment.getTahun(), payment.getBulan(), 0.0);
                                paymentPbb.setIdKey(idKey);
                                try {
                                    long l = PstPaymentPbbHistory.insertExc(paymentPbb);
                                } catch (Exception ex) {
                                    System.err.println("tidak masuk history payment pbb");
                                }
                                long oid = PstPaymentPbb.insertExc(paymentPbb);
                                if (payment.getStsReversal().equals("1")) {
                                    String str = SessSimpatda.updateStatusRaversalPbb(payment.getNoId(), payment.getTahun(), payment.getBulan(), 0.0);
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Err inputPaymentPBB :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err inputPaymentPBB :" + e);
        }
    }

    public void inputPaymentPBBIproTax(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentPBB = new Vector();
                Diskon diskon = new Diskon();
                Calendar endCalendar = Calendar.getInstance();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_PBB);
                laporanPayment.setsPassword(AppSetting.PWD_PBB);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_PBB);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentPBB = echoLaporan.getListPaymentDetailPBB(laporanPayment);
                if (vPaymentPBB.size() > 0) {
                    for (int i = 0; i < vPaymentPBB.size(); i++) {
                        Payment payment = vPaymentPBB.get(i);
                        boolean cekHistory = PstPaymentPbbIprotax.checkPaymentPBBIprotax(payment.getId());
                        if (payment.getStsReversal().equals("1") || cekHistory) {
                            System.out.println("ID dari Bank" + payment.getNoId());
                            PaymentPbbIprotax paymentPbb = new PaymentPbbIprotax();
                            String nop = payment.getNoId();
                            System.out.println("nop" + nop);
                            PbbIprotax pbbIprotax = PstPbbIprotax.checkNOp(nop, payment.getTahun());
                            System.out.println("Check NOP berhasil");
                            try {
                                paymentPbb.setKdProvinsi(pbbIprotax.getKdProvinsi());
                            } catch (Exception exc) {
                                System.out.println("set KD Provinsi");
                            }
                            try {
                                paymentPbb.setKdDati2(pbbIprotax.getKdDati2());
                            } catch (Exception exc) {
                                System.out.println("set KD Dati");
                            }
                            try {
                                paymentPbb.setKdKecamatan(pbbIprotax.getKdKecamatan());
                            } catch (Exception exc) {
                                System.out.println("set KD Kecamatan");
                            }
                            try {
                                paymentPbb.setKdKelurahan(pbbIprotax.getKdKelurahan());
                            } catch (Exception exc) {
                                System.out.println("set KD Kelurahan");
                            }
                            try {
                                paymentPbb.setKdBlock(pbbIprotax.getKdBlock());
                            } catch (Exception exc) {
                                System.out.println("set KD Block");
                            }
                            try {
                                paymentPbb.setNoUrut(pbbIprotax.getNoUrut());
                            } catch (Exception exc) {
                                System.out.println("set No Urut");
                            }
                            try {
                                paymentPbb.setNoJnsOp(pbbIprotax.getNoJnsOp());
                            } catch (Exception exc) {
                                System.out.println("set Jenis OP");
                            }
                            try {
                                paymentPbb.setThnPajakSppt("" + payment.getTahun());
                            } catch (Exception exc) {
                                System.out.println("set Tahun Pajak");
                            }
                            int noUrut = PstPaymentPbbIprotax.getCount(" NOP =" + nop + " AND THN_PAJAK_SPPT=" + payment.getTahun() + "");
                            if (noUrut == 0) {
                                noUrut++;
                            } else {
                                noUrut++;
                            }
                            paymentPbb.setPembayaranSpptKe(noUrut);
                            if (!payment.getDenda().equals("")) {
                                try {
                                    paymentPbb.setJmlDendaSppt(Double.parseDouble(FRMHandler.deFormatStringDecimal(payment.getDenda())));
                                } catch (Exception exc) {
                                    System.out.println("error parsing denda :" + exc.toString());
                                }
                            }
                            if (!payment.getTagihan().equals("")) {
                                try {
                                    paymentPbb.setJmlPbbYgDibayar(Double.valueOf(payment.getTagihan()).doubleValue());
                                } catch (Exception exc) {
                                    System.out.println("error parsing tagihan :" + exc.toString());
                                }
                            }
                            paymentPbb.setUraianBayarSppt("");
                            paymentPbb.setKdSumberData("9");
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                            String dateStringTransaksi = "" + payment.getTglTx();
                            try {
                                Date transaksiDate = formatter.parse(dateStringTransaksi);
                                paymentPbb.setTglPembayaranSppt(transaksiDate);
                                paymentPbb.setTglRekamByrSppt(transaksiDate);
                            } catch (Exception e) {
                                SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                                Date transaksiDate = formatter1.parse(dateStringTransaksi);
                                paymentPbb.setTglPembayaranSppt(transaksiDate);
                                paymentPbb.setTglRekamByrSppt(transaksiDate);
                                System.out.println("error parsing tanggal :" + e.toString());
                            }
                            try {
                                paymentPbb.setNoTransaksiByrSppt("" + payment.getKetTagihan());
                            } catch (Exception e) {
                                System.out.println("set keterangan tagihan");
                            }
                            paymentPbb.setNoTransaksiByrSpptKolektif("");
                            try {
                                paymentPbb.setNoTransaksiByrSpptBank("" + payment.getId());
                            } catch (Exception e) {
                                System.out.println("set No Bayar Bank");
                            }
                            paymentPbb.setKdBankTunggal("00");
                            paymentPbb.setKdBankPersepsi("00");
                            paymentPbb.setKdTp("05");
                            try {
                                paymentPbb.setUserBankRekam(payment.getKdUser());
                            } catch (Exception e) {
                                System.out.println("set User Bank Rekam");
                            }
                            try {
                                paymentPbb.setStatus(Integer.parseInt(payment.getStsReversal()));
                                paymentPbb.setStatusRaversal(Integer.parseInt(payment.getStsReversal()));
                            } catch (Exception exc) {
                                System.out.println("error get status reversal");
                            }
                            try {
                                paymentPbb.setNamaPenyetor(payment.getNama());
                            } catch (Exception e) {
                                System.out.println("set nama penyetor");
                            }
                            try {
                                System.out.println("cek History " + nop + " : " + cekHistory + " " + payment.getId());
                                if (payment.getStsReversal().equals("1")) {
                                    if (paymentPbb.getJmlPbbYgDibayar() > 0.0) {
                                        System.out.println("Insert Riversal");
                                        boolean cekRaversalData = SessPbbIprotax.checkPaymentPBBRaversalIprotax(payment.getId());
                                        if (cekRaversalData) {
                                            int oid = SessPbbIprotax.DeleteDataPembayaran(payment.getId(), paymentPbb.getKdProvinsi(), paymentPbb.getKdDati2(), paymentPbb.getKdKecamatan(), paymentPbb.getKdKelurahan(), paymentPbb.getKdBlock(), paymentPbb.getNoUrut(), paymentPbb.getNoJnsOp(), paymentPbb.getThnPajakSppt(), "0");
                                            if (oid != 0) {
                                                long l = SessPbbIprotax.UpdateDataTagihan(paymentPbb.getKdProvinsi(), paymentPbb.getKdDati2(), paymentPbb.getKdKecamatan(), paymentPbb.getKdKelurahan(), paymentPbb.getKdBlock(), paymentPbb.getNoUrut(), paymentPbb.getNoJnsOp(), paymentPbb.getThnPajakSppt(), "0");
                                            }
                                        } else {
                                            boolean bool = SessPbbIprotax.insertPaymentPbbRaversalIprotax(paymentPbb);
                                        }
                                    }
                                } else {
                                    if (Integer.valueOf(paymentPbb.getThnPajakSppt()).intValue() < 2023) {
                                        Date transaksiDate = formatter.parse(dateStringTransaksi);
                                        Vector<Pbb> listTagihanPbb = new Vector();
                                        Pbb pbb = new Pbb();
                                        String whereClause = " WHERE NOP='" + nop + "' AND TAHUN = '" + paymentPbb.getThnPajakSppt() + "' ";
                                        listTagihanPbb = SessSimpatda.getListPBBALL(whereClause, transaksiDate);
                                        if (listTagihanPbb.size() > 0) {
                                            pbb = listTagihanPbb.get(0);
                                            double potongan = 0.0;
                                            potongan = diskon.jumlahDiskon(Integer.valueOf(pbb.getTahun()).intValue(), Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                                            double persentaseDenda = diskon.jumlahDiskon(Integer.valueOf(pbb.getTahun()).intValue(), Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                                            double potonganDenda = 0.0;
                                            
                                            if (Integer.valueOf(paymentPbb.getThnPajakSppt()).intValue() < 2020) {
                                                potonganDenda = Double.valueOf(pbb.getDenda()).doubleValue();
                                            } else {
                                                potonganDenda = diskon.jumlahKonpensasiDenda(Integer.valueOf(pbb.getTahun()).intValue(), Double.valueOf(pbb.getDenda()).doubleValue(), persentaseDenda, Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
                                            }
                                            
                                            paymentPbb.setJmlpenguranganpokok(potongan);
                                            paymentPbb.setJmlpengurangandenda(potonganDenda);
                                        }
                                    } else if(Integer.valueOf(paymentPbb.getThnPajakSppt()) == 2026){
                                        Date transaksiDate = formatter.parse(dateStringTransaksi);
                                        Vector<Pbb> listTagihanPbb = new Vector();
                                        Pbb pbb = new Pbb();
                                        double penguranganPokok = 0;
                                        String whereClause = " WHERE NOP='" + nop + "' AND TAHUN = '" + paymentPbb.getThnPajakSppt() + "' ";
                                        listTagihanPbb = SessSimpatda.getListPBBALL(whereClause, transaksiDate);
                                        if(listTagihanPbb.size() > 0){
                                            pbb = listTagihanPbb.get(0);
                                            double pembayaran = Double.valueOf(payment.getTagihan());
                                            double pokok = Double.valueOf(pbb.getPokok());                                            
                                            if(pembayaran < pokok){
                                                penguranganPokok = pokok - pembayaran;
                                            }
                                        }                                        
                                        paymentPbb.setJmlpenguranganpokok(penguranganPokok);
                                        paymentPbb.setJmlpengurangandenda(0);
                                    }
                                    boolean cekHistory2 = PstPaymentPbbIprotax.checkPaymentPBBIprotax(payment.getId());
                                    if (cekHistory2) {
                                        long oid = PstPaymentPbbIprotax.insertExc(paymentPbb);
                                        if (oid != 0) {
                                            System.out.println("Insert Pembayran OK");
                                            long xxx = SessPbbIprotax.UpdateDataTagihan(paymentPbb.getKdProvinsi(), paymentPbb.getKdDati2(), paymentPbb.getKdKecamatan(), paymentPbb.getKdKelurahan(), paymentPbb.getKdBlock(), paymentPbb.getNoUrut(), paymentPbb.getNoJnsOp(), paymentPbb.getThnPajakSppt(), "1");
                                            System.out.println("Update Pembayran OK");
                                        }
                                    } else {
                                        System.out.println("Pembayaran Sudah Ada");
                                    }
                                }
                            } catch (Exception ex) {
                                System.out.print("Tidak bisa proses input payment");
                            }
                        }
                        System.out.println("penarikan NOP");
                    }
                }
            } catch (Exception e) {
                System.out.println("Err inputPaymentPBB :" + e);
            }
        } catch (Exception e) {
            System.out.println("Err inputPaymentPBB :" + e);
        }
    }

    public void inputPaymentBphtb(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentBphtb = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_BPHTB);
                laporanPayment.setsPassword(AppSetting.PWD_BPHTB);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_BPHTB);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentBphtb = echoLaporan.getListPaymentDetailBPHTB(laporanPayment);
                if (vPaymentBphtb.size() > 0) {
                    for (int i = 0; i < vPaymentBphtb.size(); i++) {
                        Payment payment = vPaymentBphtb.get(i);
                        PaymentBphtb paymentBphtb = new PaymentBphtb();
                        paymentBphtb.setNoTib(Long.valueOf(payment.getNoId()).longValue());
                        paymentBphtb.setIdPaymentBank(Long.valueOf(payment.getId()).longValue());
                        if (!payment.getTagihan().equals("")) {
                            paymentBphtb.setJumlahBayar(Double.valueOf(payment.getTagihan()).doubleValue());
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                        String dateStringTransaksi = "" + payment.getTglTx();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            paymentBphtb.setTglBayar(transaksiDate);
                        } catch (Exception e) {
                            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date transaksiDate = formatter1.parse(dateStringTransaksi);
                            paymentBphtb.setTglBayar(transaksiDate);
                            System.out.println("error parsing tanggal :" + e.toString());
                        }
                        paymentBphtb.setStatus(Integer.parseInt(payment.getStsReversal()));
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentBphtb(payment.getId());
                            if (cekHistory) {
                                String idKey = SessSimpatda.checkKeyIdBphtb(payment.getNoId(), payment.getTahun(), payment.getBulan(), 0.0);
                                paymentBphtb.setIdKey(idKey);
                                long oid = PstPaymentBphtb.insertExc(paymentBphtb);
                                if (payment.getStsReversal().equals("1")) {
                                    String str = SessSimpatda.updateStatusRaversalBphtb(payment.getNoId(), payment.getTahun(), payment.getBulan(), 0.0);
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("inputPaymentBphtb :" + e);
            }
        } catch (Exception e) {
            System.out.println("inputPaymentBphtb :" + e);
        }
    }

    public void inputPaymentBphtbIprotax(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentBphtb = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_BPHTB);
                laporanPayment.setsPassword(AppSetting.PWD_BPHTB);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_BPHTB);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentBphtb = echoLaporan.getListPaymentDetailIprotax(laporanPayment);
                if (vPaymentBphtb.size() > 0) {
                    for (int i = 0; i < vPaymentBphtb.size(); i++) {
                        Payment payment = vPaymentBphtb.get(i);
                        PaymentBphtbIprotax paymentBphtb = new PaymentBphtbIprotax();
                        String nop = payment.getNoId();
                        BphtbIprotax bphtbIprotax = PstPaymentBphtbIprotax.checkNOp(nop, payment.getTahun());
                        paymentBphtb.setKdProvinsi(bphtbIprotax.getKdPropinsi());
                        paymentBphtb.setKdDati2(bphtbIprotax.getKdDati2());
                        paymentBphtb.setThbBphtb(bphtbIprotax.getThnBphtb());
                        paymentBphtb.setBlnBphtb(bphtbIprotax.getBlnBphtb());
                        paymentBphtb.setTglBphtb(bphtbIprotax.getTglBphtb());
                        paymentBphtb.setNoUrutBphtb(bphtbIprotax.getNoUrutBphtb());
                        paymentBphtb.setIndeksBphtb(bphtbIprotax.getIndeksBphtb());
                        paymentBphtb.setKdPejabat(bphtbIprotax.getKdPejabat());
                        paymentBphtb.setKdBankTunggal("99");
                        paymentBphtb.setKdBankPersepsi("99");
                        paymentBphtb.setTglPembayaranReal(bphtbIprotax.getTglBayar());
                        if (!payment.getTagihan().equals("")) {
                            paymentBphtb.setBphtbSdhBayar(Math.abs(Double.valueOf(payment.getTagihan()).doubleValue()));
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateStringTransaksi = "" + payment.getTglTx();
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            paymentBphtb.setTglPembayaran(transaksiDate);
                        } catch (Exception e) {
                            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
                            Date transaksiDate = formatter1.parse(dateStringTransaksi);
                            paymentBphtb.setTglPembayaran(transaksiDate);
                            e.printStackTrace();
                        }
                        paymentBphtb.setNoTransBayar("" + (payment.getKetTagihan().equals("") ? "0" : payment.getKetTagihan()));
                        paymentBphtb.setNamaWP(bphtbIprotax.getNama());
                        if (!bphtbIprotax.getJumTagihan().equals("")) {
                            paymentBphtb.setBphtbKurangBayar(Math.abs(Double.valueOf(bphtbIprotax.getJumTagihan()).doubleValue() - paymentBphtb.getBphtbSdhBayar()));
                        }
                        paymentBphtb.setKdKecamatanOp(bphtbIprotax.getKdKecamatanOp());
                        paymentBphtb.setKdKelurahanOp(bphtbIprotax.getKdKelurahanOp());
                        paymentBphtb.setKdBlokOp(bphtbIprotax.getKdBlokOp());
                        paymentBphtb.setNoUrutOp(bphtbIprotax.getNoUrutOp());
                        paymentBphtb.setKdJnsOp(bphtbIprotax.getKdJenisOp());
                        paymentBphtb.setKdTp("05");
                        paymentBphtb.setUserBankRekam(payment.getKdUser());
                        paymentBphtb.setNmPenyetor(payment.getNama());
                        paymentBphtb.setKdSumberData("9");
                        paymentBphtb.setNoTransaksiBayar("0");
                        paymentBphtb.setNoTransaksiBayarBank(payment.getId());
                        paymentBphtb.setStatus(Integer.parseInt(payment.getStsReversal()));
                        System.out.print("" + payment.getNoId());
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentBphtb(payment.getId());
                            System.out.print("1");
                            if (payment.getStsReversal().equals("1")) {
                                if (paymentBphtb.getBphtbSdhBayar() > 0.0) {
                                    boolean cekHistoryReversal = SessSimpatda.checkPaymentBphtbReversal(payment.getId());
                                    System.out.print("2");
                                    if (cekHistoryReversal) {
                                        int oid = SessSimpatda.DeleteDataPembayaranBPHTB(payment.getId());
                                        System.out.print("3");
                                        String whereUpdate = "KD_PROPINSI = '" + bphtbIprotax.getKdPropinsi() + "' AND KD_DATI2 = '" + bphtbIprotax.getKdDati2() + "' AND THN_BPHTB = '" + bphtbIprotax.getThnBphtb() + "'  AND BLN_BPHTB = '" + bphtbIprotax.getBlnBphtb() + "'  AND TGL_BPHTB = '" + bphtbIprotax.getTglBphtb() + "'  AND NO_URUT_BPHTB = '" + bphtbIprotax.getNoUrutBphtb() + "' AND INDEKS_BPHTB = '" + bphtbIprotax.getIndeksBphtb() + "'";
                                        String sql = " UPDATE IPROTAXBPHTB.DAT_SSB_WP SET KD_BANK_TUNGGAL = '00', KD_BANK_PERSEPSI = 00', NO_TRANS_BAYAR = '0', TGL_BAYAR_SSB_WP = NULL WHERE " + whereUpdate;
                                        System.out.print("4");
                                        try {
                                            int j = DBHandler.execUpdate(sql);
                                        } catch (DBException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            } else if (cekHistory) {
                                long oid = PstPaymentBphtbIprotax.insertExc(paymentBphtb);
                                System.out.print("5");
                                String whereUpdate = "KD_PROPINSI = '" + bphtbIprotax.getKdPropinsi() + "' AND KD_DATI2 = '" + bphtbIprotax.getKdDati2() + "' AND THN_BPHTB = '" + bphtbIprotax.getThnBphtb() + "'  AND BLN_BPHTB = '" + bphtbIprotax.getBlnBphtb() + "'  AND TGL_BPHTB = '" + bphtbIprotax.getTglBphtb() + "'  AND NO_URUT_BPHTB = '" + bphtbIprotax.getNoUrutBphtb() + "' AND INDEKS_BPHTB = '" + bphtbIprotax.getIndeksBphtb() + "'";
                                String sql = " UPDATE IPROTAXBPHTB.DAT_SSB_WP SET KD_BANK_TUNGGAL = '99', KD_BANK_PERSEPSI = '99', NO_TRANS_BAYAR = '" + payment.getId() + "', TGL_BAYAR_SSB_WP = TO_DATE('" + Formater.formatDate(paymentBphtb.getTglPembayaran(), "yyyy-MM-dd") + "','YYYY-MM-DD') WHERE " + whereUpdate;
                                try {
                                    int iResult = DBHandler.execUpdate(sql);
                                    System.out.print("6");
                                } catch (DBException e) {
                                    e.printStackTrace();
                                }
                                String sqlTelitiSSB = " UPDATE IPROTAXBPHTB.DAFTAR_TELITI_SSB SET STATUS_DOKUMEN = '2' WHERE " + whereUpdate;
                                try {
                                    int j = DBHandler.execUpdate(sqlTelitiSSB);
                                } catch (DBException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("inputPaymentBphtb :" + e);
            }
        } catch (Exception e) {
            System.out.println("inputPaymentBphtb :" + e);
        }
    }

    public void inputPaymentRetribusi(String dateLaporan, String noID) {
        try {
            try {
                Vector<Payment> vPaymentRetribusi = new Vector();
                EchoLaporanPaymentDetail echoLaporan = new EchoLaporanPaymentDetail();
                Date newDay = new Date();
                LaporanPayment laporanPayment = new LaporanPayment();
                laporanPayment.setsUser(AppSetting.USERNAME_RETRIBUSI);
                laporanPayment.setsPassword(AppSetting.PWD_RETRIBUSI);
                laporanPayment.setsInstansi(AppSetting.INSTANSI_RETRIBUSI);
                laporanPayment.setsNoId("" + noID);
                laporanPayment.setsDate("" + dateLaporan);
                vPaymentRetribusi = echoLaporan.getListPaymentDetailRetribusi(laporanPayment);
                if (vPaymentRetribusi.size() > 0) {
                    for (int i = 0; i < vPaymentRetribusi.size(); i++) {
                        Payment payment = vPaymentRetribusi.get(i);
                        PaymentRetribusi paymentRetribusi = new PaymentRetribusi();
                        paymentRetribusi.setIdPaymentBank(Long.parseLong(payment.getId()));
                        paymentRetribusi.setNoRekening(payment.getNoId());
                        paymentRetribusi.setNama(payment.getNama());
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        DateFormat formatter2 = new SimpleDateFormat("dd-MM-yy");
                        String dateInString = "" + payment.getTanggalTagihan();
                        String dateStringTransaksi = "" + payment.getTglTx();
                        String dateSearch = "";
                        String strYear = "";
                        String strMonth = "";
                        String strDate = "";
                        try {
                            Date transaksiDate = formatter.parse(dateStringTransaksi);
                            Date date = formatter2.parse(dateConvert(dateInString));
                            paymentRetribusi.setTanggalTagihan(date);
                            paymentRetribusi.setTanggalPembayaran(transaksiDate);
                            dateSearch = Formater.formatDate(date, "yyyy-MM-dd");
                            strYear = String.valueOf(date.getYear() + 1900);
                            strMonth = String.valueOf(date.getMonth() + 1);
                            strDate = String.valueOf(date.getDate());
                            if (strMonth.length() == 1) {
                                strMonth = "0" + strMonth;
                            }
                            if (strDate.length() == 1) {
                                strDate = "0" + strDate;
                            }
                            paymentRetribusi.setMasaPajak(strMonth);
                            paymentRetribusi.setTahun(strYear);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (!payment.getTagihanLain().equals("")) {
                            paymentRetribusi.setJumlahTagihan(Double.valueOf(payment.getTagihanLain()).doubleValue());
                        }
                        paymentRetribusi.setIdRekam("090909090");
                        paymentRetribusi.setStatusReversal(Integer.valueOf(payment.getStsReversal()).intValue());
                        try {
                            boolean cekHistory = SessSimpatda.checkPaymentRetribusi(payment.getId());
                            if (cekHistory) {
                                String idKey = SessSimpatda.checkKeyIdRetribusi(payment.getNoId(), strYear, strMonth, strDate);
                                paymentRetribusi.setIdKey(idKey);
                                long oid = PstPaymentRetribusi.insertExc(paymentRetribusi);
                                if (payment.getStsReversal().equals("1")) {
                                    String str = SessSimpatda.updateStatusRaversalRetribusi(payment.getNoId(), dateSearch, payment.getBulan(), paymentRetribusi.getJumlahTagihan());
                                }
                            }
                        } catch (Exception ex) {
                            System.out.print("Tidak bisa proses input payment");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("inputPaymentBphtb :" + e);
            }
        } catch (Exception e) {
            System.out.println("inputPaymentBphtb :" + e);
        }
    }

    public static int getIdleSleepTime(long current, long delay, long quarter, long day, long night) {
        long gap = 0;
        if (current < delay) {
            System.out.println("_______________ start service monitoy sebelum delay");
            gap = delay - current - 100;
            return (int) gap;
        }
        if (current == delay) {
            System.out.println("_______________ start service monitoy sama delay");
            return 0;
        }
        if (current > delay && current < quarter) {
            System.out.println("_______________ start service monitoy sebelum quarter");
            gap = quarter - current - 100;
            return (int) gap;
        }
        if (current == quarter) {
            System.out.println("_______________  start service monitoy sama delay");
            return 0;
        }
        if (current > quarter && current < day) {
            System.out.println("_______________  start service monitoy sebelum day");
            gap = day - current - 100;
            return (int) gap;
        }
        if (current == day) {
            System.out.println("_______________  start service monitoy sama day");
            return 0;
        }
        if (current > day && current < night) {
            System.out.println("_______________  start service monitoy sebelum night");
            gap = night - current - 100;
            return (int) gap;
        }
        if (current == night) {
            System.out.println("_______________  start service monitoy sama delay");
            return 0;
        }
        System.out.println("_______________  start service monitoy sebelum delay besoknya");
        gap = delay - current - 100;
        return (int) gap;
    }

    public void sentDataBI(String where) {
        try {
            SearchDataPajak searchDataPajak = new SearchDataPajak();
            Date dStartDate = new Date();
            String startDate = "";
            String endDate = "";
            try {
                startDate = Formater.formatDate(dStartDate, "yyyy-MM-dd");
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                endDate = Formater.formatDate(dStartDate, "yyyy-MM-dd");
            } catch (Exception e) {
                e.printStackTrace();
            }
            Vector<PajakTypeDetail> vPajakDetail = new Vector();
            vPajakDetail = PstPajakTypeDetail.list(0, 0, "", "");
            if (vPajakDetail.size() > 0) {
                for (int i = 0; i < vPajakDetail.size(); i++) {
                    PajakTypeDetail pajakTypeDetail = vPajakDetail.get(i);
                    searchDataPajak = new SearchDataPajak();
                    searchDataPajak.setPajakDetailId(pajakTypeDetail.getOID());
                    searchDataPajak.setStartDate(startDate);
                    searchDataPajak.setEndDate(endDate);
                    searchDataPajak.setQueryPajak(pajakTypeDetail.getPajakQuery());
                    searchDataPajak.setColomDate(pajakTypeDetail.getColomDate());
                    int hasilDelete = SessDataPajak.deleteDataPajak(searchDataPajak);
                    Vector vDataPajak = SessDataPajak.getListDataPajak(searchDataPajak);
                    try {
                        int j = SessDataPajak.action(4, searchDataPajak, vDataPajak, pajakTypeDetail);
                    } catch (Exception exception) {
                    }
                }
            }
        } catch (Exception exception) {
        }
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
        long gap = 0;
        if (current < delay) {
            System.out.println("_______________ start service monitoy sebelum delay");
            gap = delay - current - 100;
            return (int) gap;
        }
        return (int) gap;
    }

    public long getSleepTimeMinute() {
        return this.sleepTimeMinute;
    }

    public void setSleepTimeMinute(long sleepTimeMinute) {
        this.sleepTimeMinute = sleepTimeMinute;
    }
}
