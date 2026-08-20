package com.dimata.webclient;

import com.dimata.dtaxintegration.entity.inquery.InqueryProses;
import com.dimata.util.Diskon;
import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbb;
import com.dimata.dtaxintegration.entity.tagihan.CreateFile;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.dtaxintegration.entity.tagihan.Tagihan;
import com.dimata.dtaxintegration.entity.tagihan.TagihanDelete;
import com.dimata.dtaxintegration.session.DTaxIntegrationMonitor;
import com.dimata.dtaxintegration.session.DTaxManagerBphtb;
import com.dimata.dtaxintegration.session.DTaxManagerPbb;
import com.dimata.dtaxintegration.session.DTaxManagerPhr;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.EchoTagihanDeleteByRecordId;
import com.dimata.webclient.Inquery;
import com.dimata.webclient.UploadFile;
import com.oschrenk.io.Base64;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.commons.lang.StringUtils;

public class UploadFile {
  public String actionPBB(FileSent fileSent) {
    String resp_status = new String();
    String resp_code = new String();
    String resp_row_count = new String();
    DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();
      String url = AppSetting.IP_BANK_BPD;
      String patchFileUpload = "";
      String patchFileUploadZip = "";
      String statusProses = "";
      try {
        CreateFile sent = new CreateFile();
        if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
          patchFileUpload = CreateFile.sentPbbIpRotax(fileSent);
        } else if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
          patchFileUpload = CreateFile.sentPbbIpRotaxV2(fileSent);
        } else {
          patchFileUpload = CreateFile.sentPbb(fileSent);
        } 
        if (!DTaxManagerPbb.running) {
          resp_status = "Stop";
          return resp_status;
        } 
        statusProses = " / Proses ZIP File on Location " + fileSent.getLocation();
        DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br>" + statusProses;
        patchFileUploadZip = CreateFile.zipFile(new File(patchFileUpload), fileSent, 0);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      } 
      if (!DTaxManagerPbb.running) {
        resp_status = "Stop";
        return resp_status;
      } 
      DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br> / Proses Transfer File to BPD Jangan di STOP! ";
      int retryCount = 0;
      int maxRetry = 3;
      boolean success = true;
      do {
        try {
          retryCount++;
          DTaxManagerPbb.statusProses += "<br> / Proses Transfer File Percobaan " + retryCount + " dari " + maxRetry + " Percobaan";
          SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(fileSent, patchFileUploadZip), url);
          soapResponse.writeTo(System.out);
          soapResponse.writeTo(out);
          String raw_respon = new String(out.toByteArray());
          System.out.println("SOAP Respon = " + raw_respon);
          resp_code = StringUtils.substringBetween(raw_respon, "<code>", "</code>");
          resp_status = StringUtils.substringBetween(raw_respon, "<message>", "</message>");
          resp_row_count = StringUtils.substringBetween(raw_respon, "<row_count>", "</row_count>");
          System.out.println("=============================================");
          System.out.println("GET STATUS");
          System.out.println("Respone Code = " + resp_code);
          System.out.println("Berhasil  " + resp_status);
          System.out.println("=============================================");
          DTaxManagerPbb.resStatus = resp_code;
          DTaxManagerPbb.resCount = resp_row_count;
          if (!resp_code.equals("00")) {
            success = false;
            if (retryCount < maxRetry) {
              DTaxManagerPbb.statusProses += "<br>Gagal Kirim, Tidak ada respon dari server, Mencoba ulang dalam 5 Menit";
            } else {
              DTaxManagerPbb.statusProses += "<br>Gagal Kirim, Tidak ada respon dari server";
            } 
            Thread.sleep(300000L);
          } else {
            success = true;
          } 
        } catch (Exception exc) {
          success = false;
          if (retryCount < maxRetry) {
            DTaxManagerPbb.statusProses += "<br>Gagal Kirim";
            DTaxManagerPbb.statusProses += "<br>Error Message : ";
            DTaxManagerPbb.statusProses += "<br>" + exc.toString();
            DTaxManagerPbb.statusProses += "<br> Mencoba ulang dalam 5 Menit";
          } else {
            DTaxManagerPbb.statusProses += "<br>Gagal Kirim";
            DTaxManagerPbb.statusProses += "<br>Error Message : ";
            DTaxManagerPbb.statusProses += "<br>" + exc.toString();
          } 
          Thread.sleep(300000L);
        } 
      } while (retryCount < maxRetry && !success);
    } catch (Exception ex) {
      ex.printStackTrace();
      DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br>Gagal Kirim";
      DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br>Error Message : ";
      DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br>" + ex.toString();
    } 
    return resp_status;
  }
  
  public synchronized String actionPHR(FileSent fileSent) {
    String resp_status = new String();
    String resp_code = new String();
    String statusProses = "";
    String raw_respon = "";
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();
      String url = AppSetting.IP_BANK_BPD;
      String patchFileUpload = "";
      String patchFileUploadZip = "";
      try {
        switch (AppSetting.TYPE_APP_BACKOFFICE) {
          case 3:
            patchFileUpload = CreateFile.sentPhrOpenPhr(fileSent.getLocation());
            break;
          case 4:
            patchFileUpload = CreateFile.sentPhrPhrH(fileSent.getLocation());
            break;
          default:
            patchFileUpload = CreateFile.sentPhr(fileSent.getLocation());
            break;
        } 
        if (!DTaxManagerPhr.running) {
          resp_status = "Stop";
          return resp_status;
        } 
        statusProses = " / Proses ZIP File on Location " + fileSent.getLocation();
        DTaxManagerPhr.statusProses = statusProses;
        patchFileUploadZip = CreateFile.zipFile(new File(patchFileUpload), fileSent, 1);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      } 
      if (!DTaxManagerPhr.running) {
        resp_status = "Stop";
        return resp_status;
      } 
      statusProses = statusProses + " / Proses Transfer File to BPD Jangan di STOP! ";
      DTaxManagerPhr.statusProses = statusProses;
      SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(fileSent, patchFileUploadZip), url);
      soapResponse.writeTo(System.out);
      soapResponse.writeTo(out);
      raw_respon = new String(out.toByteArray());
      System.out.println("SOAP Respon = " + raw_respon);
      resp_code = StringUtils.substringBetween(raw_respon, "<code>", "</code>");
      resp_status = StringUtils.substringBetween(raw_respon, "<message>", "</message>");
      System.out.println("=============================================");
      System.out.println("GET STATUS");
      System.out.println("Respone Code = " + resp_code);
      System.out.println("status = " + resp_status);
      System.out.println("=============================================");
      if (resp_code.equals("00")) {
        DTaxManagerPhr.statusProses = statusProses + " / Proses pengiriman Berhasil ";
      } else if (resp_code.equals("03")) {
        DTaxManagerPhr.statusProses = statusProses + " / Proses pengiriman Gagal ";
      } else if (resp_code.equals("05")) {
        DTaxManagerPhr.statusProses = statusProses + " / Format atau nama file tidak cocok ";
      } else if (resp_code.equals("01")) {
        DTaxManagerPhr.statusProses = statusProses + " / Tidak memiliki wewenang akses ";
      } else if (resp_code.equals("06")) {
        DTaxManagerPhr.statusProses = statusProses + " / Tidak diijinkan mengupload data pada jam operasional bank";
      } else {
        DTaxManagerPhr.statusProses = statusProses + " / Proses pengiriman Gagal ";
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
      DTaxManagerPhr.statusProses = statusProses + " Proses Gagal, Cek Koneksi Jaringan Respon :" + raw_respon;
    } 
    return resp_status;
  }
  
  public String actionBPHTB(FileSent fileSent) {
    String resp_status = new String();
    String resp_code = new String();
    DTaxManagerBphtb dTaxManagerBphtbx = new DTaxManagerBphtb();
    String statusProses = "";
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
      SOAPConnection soapConnection = soapConnectionFactory.createConnection();
      String url = AppSettingBphtb.IP_BANK_BPD_BPHTB;
      String patchFileUpload = "";
      String patchFileUploadZip = "";
      try {
        CreateFile sent = new CreateFile();
        if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
          patchFileUpload = CreateFile.sentBphtbIprotax(fileSent);
        } else {
          patchFileUpload = CreateFile.sentPbb(fileSent);
        } 
        if (!DTaxManagerBphtb.running) {
          resp_status = "Stop";
          return resp_status;
        } 
        statusProses = " / Proses ZIP File on Location " + fileSent.getLocation();
        DTaxManagerBphtb.statusProses = statusProses;
        patchFileUploadZip = CreateFile.zipFile(new File(patchFileUpload), fileSent, 1);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
      } 
      if (!DTaxManagerBphtb.running) {
        resp_status = "Stop";
        return resp_status;
      } 
      DTaxManagerBphtb.statusProses += "<br> / Proses Transfer File to BPD Jangan di STOP!";
      int retryCount = 0;
      int maxRetry = 3;
      boolean success = true;
      do {
        try {
          retryCount++;
          DTaxManagerBphtb.statusProses += "<br> / Proses Transfer File Percobaan " + retryCount + " dari " + maxRetry + " Percobaan";
          success = true;
          SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(fileSent, patchFileUploadZip), url);
          soapResponse.writeTo(System.out);
          soapResponse.writeTo(out);
          String raw_respon = new String(out.toByteArray());
          System.out.println("SOAP Respon = " + raw_respon);
          resp_code = StringUtils.substringBetween(raw_respon, "<code>", "</code>");
          resp_status = StringUtils.substringBetween(raw_respon, "<message>", "</message>");
          System.out.println("=============================================");
          System.out.println("GET STATUS");
          System.out.println("Respone Code = " + resp_code);
          System.out.println("Berhasil  " + resp_status);
          System.out.println("=============================================");
          DTaxManagerPbb.resStatus = resp_code;
          if (resp_code.equals("00")) {
            DTaxManagerBphtb.statusProses += "<br> / Proses pengiriman Berhasil ";
            success = true;
          } else if (resp_code.equals("03")) {
            DTaxManagerBphtb.statusProses += "<br> / Proses pengiriman Gagal ";
          } else if (resp_code.equals("05")) {
            DTaxManagerBphtb.statusProses += "<br> / Format atau nama file tidak cocok ";
            success = true;
          } else if (resp_code.equals("01")) {
            DTaxManagerBphtb.statusProses += "<br> / Tidak memiliki wewenang akses ";
            success = true;
          } else if (resp_code.equals("06")) {
            DTaxManagerBphtb.statusProses += "<br> / Tidak diijinkan mengupload data pada jam operasional bank";
            success = true;
          } else {
            success = false;
            if (retryCount < maxRetry) {
              DTaxManagerBphtb.statusProses += "<br>Gagal Kirim, Tidak ada Respon dari server, Mencoba ulang dalam 5 Menit";
            } else {
              DTaxManagerBphtb.statusProses += "<br>Gagal Kirim, Tidak ada Respon dari server";
            } 
            Thread.sleep(60000L);
          } 
          DTaxManagerBphtb.resStatus = resp_code;
        } catch (Exception exc) {
          success = false;
          if (retryCount < maxRetry) {
            DTaxManagerBphtb.statusProses += "<br>Gagal Kirim";
            DTaxManagerBphtb.statusProses += "<br>Error Message : ";
            DTaxManagerBphtb.statusProses += "<br> Tidak terkoneksi ke BPD Payment";
            DTaxManagerBphtb.statusProses += "<br> Mencoba ulang dalam 5 Menit";
          } else {
            DTaxManagerBphtb.statusProses += "<br>Gagal Kirim";
            DTaxManagerBphtb.statusProses += "<br>Error Message : ";
            DTaxManagerBphtb.statusProses += "<br> Tidak terkoneksi ke BPD Payment";
          } 
          Thread.sleep(60000L);
        } 
      } while (retryCount < maxRetry && !success);
    } catch (Exception ex) {
      ex.printStackTrace();
      System.out.println(ex.getMessage());
      DTaxManagerBphtb.statusProses += "<br>Gagal Kirim";
    } 
    return resp_status;
  }
  
  public String autoUploadPBB(FileSent fileSent) {
    DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
    try {
      double jumlahTagihan = 0;
      Diskon diskon =  new Diskon();
      Date dtNow = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String date = Formater.formatDate(dtNow, "yyyy-MM-dd");
      String oDate = Formater.formatDate(dtNow, "yyyy-MM-dd HH:mm:ss");
      String sql = "";
      if (AppSetting.SQL_VERSION == 3) {
        sql = "SELECT * FROM VIEW_PBB WHERE TGL_CETAK_SPPT BETWEEN TO_DATE('" + date + " 00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + date + " 23:59:00','YYYY-MM-DD HH24:MI:SS') OR TGL_TERBIT_SPPT = TO_DATE('" + date + "','YYYY-MM-DD')";
      } else if (AppSetting.SQL_VERSION == 4) {
        //Update untuk promo merdeka (mengambil thn 2021-2025)
        //sql = "SELECT * FROM VIEW_PBB WHERE TGL_CETAK_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime) OR TGL_TERBIT_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime) order by TGL_CETAK_SPPT desc";
        sql = "SELECT * FROM VIEW_PBB WHERE ((TGL_CETAK_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime)) OR (TGL_TERBIT_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime))) AND TAHUN BETWEEN 2021 AND 2025 order by TGL_CETAK_SPPT desc";
      } 
      DBResultSet dbrs = null;
      System.out.println("query pbb =>" + sql);
      try {
        dbrs = DBHandler.execQueryResultNew(sql);
        DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Proses Auto Upload penetapan baru dimulai :" + Formater.formatDate(new Date(), "dd-MM-yyyy kk:mm") + "<br>";
        ResultSet rs = dbrs.getResultSet();
        int no = 0;
        while (rs.next()) {
          no++;
          String nop = rs.getString("NOP");
          String tahun  = rs.getString("TAHUN");
          int tahunTagihan = rs.getInt("TAHUN");
          int tahunSampai = Integer.parseInt(fileSent.getTahunStart());
//          if (tahunTagihan == 2019){ 
//          String asd = "";
//          }
          if (tahunTagihan >= 2021){
          if (tahunTagihan > tahunSampai)
            continue; 
            if (tahunTagihan == 2019){
                    double tagihanDiskon = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
                    jumlahTagihan = tagihanDiskon * 0.5;

            }else{		
                jumlahTagihan = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
            }
//          double jumlahTagihan = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
          Date tglJatuhTempo = rs.getDate("TGL_JATUH_TEMPO_SPPT");
          Calendar startCalendar = Calendar.getInstance();
          Calendar endCalendar = Calendar.getInstance();
            String strJatuhTempoNew = diskon.jatuhTempo;//untuk menghitung denda
            String strJatuhTempoNew21 = diskon.jatuhTempo21;//untuk menghitung denda
            String strJatuhTempoNew22 = diskon.jatuhTempo22;//untuk menghitung denda
            String strJatuhTempoNew23 = diskon.jatuhTempo23;//untuk menghitung denda
            String strJatuhTempoNew24 = diskon.jatuhTempo24;//untuk menghitung denda

            Date dtJatuhTempo = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew);
            Date dtJatuhTempo21 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew21);
            Date dtJatuhTempo22 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew22);
            Date dtJatuhTempo23 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew23);
            Date dtJatuhTempo24 = new SimpleDateFormat("yyyy-MM-dd").parse(strJatuhTempoNew24);
                //endCalendar.setTime(new Date());
          int thn = 0;
          try {
            thn = Integer.valueOf(tahun).intValue();
            if (thn > 2018 && thn < 2021){
                startCalendar.setTime(dtJatuhTempo);
            }else if(thn == 2021){
                startCalendar.setTime(dtJatuhTempo21);
            }else if(thn == 2022){
                startCalendar.setTime(dtJatuhTempo22);
            }else if(thn == 2023){
                startCalendar.setTime(dtJatuhTempo23);
            }else if(thn == 2024){
                startCalendar.setTime(dtJatuhTempo24);
            }else {
                startCalendar.setTime(tglJatuhTempo);
            }
          } catch (Exception exc) {
            startCalendar.setTime(tglJatuhTempo);
          } 
          int tunggakan = 0;
          int diffYear = 0;
          int diffMonth = 0;
          int typePembayaran = 0;
          String wherePembayaran = "NOP=" + nop + " AND THN_PAJAK_SPPT=" + tahun;
          Vector<PaymentPbb> listPembayaran = PstPaymentPbb.listIpprotax(0, 0, wherePembayaran, "PEMBAYARAN_SPPT_KE");
          double totalPembayaran = 0.0D;
          double pembayaranPertama = 0.0D;
          double pembayaranDenda = 0.0D;
          Date tglDendaSeharusnya = null;
          Date tglDendaPembayaranPertama = null;
          if (listPembayaran.size() > 0)
            for (int i = 0; i < listPembayaran.size(); i++) {
              PaymentPbb paymentPbb = listPembayaran.get(i);
              totalPembayaran += paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
              pembayaranDenda += paymentPbb.getDendaSppt();
              if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0.0D)
                tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt(); 
              if (paymentPbb.getPembayaranSpptKe() == 1.0D) {
                tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
              } 
            }  
          diffYear = endCalendar.get(1) - startCalendar.get(1);
          diffMonth = diffYear * 12 + endCalendar.get(2) - startCalendar.get(2);
          if (endCalendar.get(5) > startCalendar.get(5))
            diffMonth++; 
          if (diffMonth > 0)
            tunggakan = diffMonth; 
          double persentaseDenda = 0.0D;
          if (tunggakan > 0) {
              thn = Integer.valueOf(tahun).intValue();
            if (thn == 2022 ){
                if (tunggakan > 9){
                    persentaseDenda = 9.0 * (1.0 / 100.0);
                }else{
                    persentaseDenda = tunggakan * (1.0 / 100.0);
                }
            }else if (thn == 2023){
                if (tunggakan > 21){
                    persentaseDenda = 21.0 * (1.0 / 100.0);
                }else{
                    persentaseDenda = tunggakan * (1.0 / 100.0);
                }
            }else if (thn == 2024){
                persentaseDenda = tunggakan * (1.0 / 100.0);
            }
//                                if (tunggakan > 24) {
//                                    persentaseDenda = 24.0 * (2.0 / 100.0);
//                                } else {
//                                    persentaseDenda = tunggakan * (2.0 / 100.0);
//                                }
        }
          
          persentaseDenda = diskon.perdentaseDenda(endCalendar, thn, tglJatuhTempo);
          double denda = 0.0D;
          double countDenda = (jumlahTagihan-totalPembayaran) * persentaseDenda;
            try {
                NumberFormat formatterr = new DecimalFormat("#0.00");
                String condenda = formatterr.format(countDenda);
                countDenda = Double.valueOf(condenda);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            denda = Math.round(countDenda);
//          denda = Math.ceil((jumlahTagihan - totalPembayaran) * persentaseDenda);
          if (denda < 0.0D || thn < 2022)
            denda = 0.0D; 
          try {
            String sDate1 = "2021-02-01";
            Date dateDenda = (new SimpleDateFormat("yyyy-MM-dd")).parse(sDate1);
            if ((new Date()).before(dateDenda))
              denda = 0.0D; 
          } catch (Exception exception) {}
          double totPambayaran1 = 0.0D;
          if (jumlahTagihan - totPambayaran1 > 0.0D)
            totPambayaran1 = jumlahTagihan - totPambayaran1; 
          double ygHarusDibayar = totPambayaran1 + denda;
          Inquery inquery = new Inquery();
          InqueryProses inqueryProses = new InqueryProses();
          inqueryProses.setsUser(AppSetting.USERNAME_PBB);
          inqueryProses.setsPassword(AppSetting.PWD_PBB);
          inqueryProses.setsInstansi(AppSetting.INSTANSI_PBB);
          inqueryProses.setsNoId(nop);
          Vector<Tagihan> listBank = inquery.InqueryPBB(inqueryProses);
          DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + no + ". Proses NOP :" + nop + ", Tahun : " + tahun + ", Tagihan Pokok : " + totPambayaran1 + ", Denda : " + denda + "<br>";
          if (listBank.size() > 0) {
            boolean isYearAlready = false;
            int i;
            for (i = 0; i < listBank.size(); i++) {
              Tagihan tagihan = listBank.get(i);
              if (tahun.equals(tagihan.getTahun()))
                isYearAlready = true;  
            } 
            if (isYearAlready) {
              for (i = 0; i < listBank.size(); i++) {
                Tagihan tagihan = listBank.get(i);
                double totalTagihan = ygHarusDibayar;
                double tagihanBank = Double.valueOf(tagihan.getTagihan()).doubleValue();
                if (tahun.equals(tagihan.getTahun()) && totalTagihan != tagihanBank) {
                  DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Tagihan sudah ada pada bank, namun total tagihan berbeda, mencoba menghapus..<br>";
                  EchoTagihanDeleteByRecordId echoTagihanDeleteByRecordId = new EchoTagihanDeleteByRecordId();
                  TagihanDelete tagihanDelete = new TagihanDelete();
                  tagihanDelete.setsUser(AppSetting.USERNAME_PBB);
                  tagihanDelete.setsPassword(AppSetting.PWD_PBB);
                  tagihanDelete.setsInstansi(AppSetting.INSTANSI_PBB);
                  tagihanDelete.setsNoId(nop);
                  tagihanDelete.setsRecordId(tagihan.getId());
                  String respCode = echoTagihanDeleteByRecordId.action(tagihanDelete);
                  if (respCode.equals("00")) {
                    DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Berhasil dihapus<br>";
                    DTaxIntegrationMonitor dTaxIntegrationMonitor1 = new DTaxIntegrationMonitor();
                    String str1 = " WHERE NOP='" + nop + "' AND TAHUN='" + tahun + "'";
                    if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
                      dTaxIntegrationMonitor1.sentPBBIpRotax(str1);
                    } else if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
                      dTaxIntegrationMonitor1.sentPBBIpRotaxV2(str1);
                    } else {
                      dTaxIntegrationMonitor1.sentPBB(str1);
                    } 
                  } else {
                    DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Gagal dihapus!<br>";
                  } 
                } else {
                  DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Tagihan sudah ada pada bank!<br><br>";
                } 
              } 
              continue;
            } 
            DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
            String str = " WHERE NOP=" + nop + " AND TAHUN=" + tahun + "";
            if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
              dTaxIntegrationMonitor.sentPBBIpRotax(str);
              continue;
            } 
            if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
              dTaxIntegrationMonitor.sentPBBIpRotaxV2(str);
              continue;
            } 
            dTaxIntegrationMonitor.sentPBB(str);
            continue;
          } 
          DTaxIntegrationMonitor dtax = new DTaxIntegrationMonitor();
          String whereSent = " WHERE NOP=" + nop + " AND TAHUN=" + tahun + "";
          if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
            dtax.sentPBBIpRotax(whereSent);
            continue;
          } 
          if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
            dtax.sentPBBIpRotaxV2(whereSent);
            continue;
          } 
          dtax.sentPBB(whereSent);
        }
        }
      } catch (Exception exc) {
        System.out.println(exc.toString());
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  public String autoUploadBPHTB() {
    DTaxManagerBphtb dTaxManagerBphtbx = new DTaxManagerBphtb();
    try {
      Date dtNow = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String date = Formater.formatDate(dtNow, "yyyy-MM-dd");
      String oDate = Formater.formatDate(dtNow, "yyyy-MM-dd HH:mm:ss");
      String sql = "";
      if (AppSetting.SQL_VERSION == 3)
        sql = "SELECT * FROM VIEW_BPHTB WHERE TGL_REKAM BETWEEN TO_DATE('" + date + " 00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + date + " 23:59:00','YYYY-MM-DD HH24:MI:SS') OR TGL_TERBIT_SSB_WP = TO_DATE('" + date + "','YYYY-MM-DD')"; 
      DBResultSet dbrs = null;
      try {
        dbrs = DBHandler.execQueryResultNew(sql);
        DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Proses Auto Upload penetapan baru dimulai :" + Formater.formatDate(new Date(), "dd-MM-yyyy kk:mm") + "<br>";
        ResultSet rs = dbrs.getResultSet();
        int no = 0;
        while (rs.next()) {
          no++;
          String noId = rs.getString("NO_ID");
          String strJumlahTagihan = rs.getString("JUM_TAGIHAN");
          String sNoId = rs.getString("SNOID");
          Inquery inquery = new Inquery();
          InqueryProses inqueryProses = new InqueryProses();
          inqueryProses.setsUser(AppSetting.USERNAME_BPHTB);
          inqueryProses.setsPassword(AppSetting.PWD_BPHTB);
          inqueryProses.setsInstansi(AppSetting.INSTANSI_BPHTB);
          inqueryProses.setsNoId(noId);
          Vector<Tagihan> listBank = inquery.InqueryBPHTBIprotax(inqueryProses);
          DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + no + ". Proses NO ID :" + noId + ", Tagihan Pokok : " + strJumlahTagihan + "<br>";
          if (listBank.size() > 0) {
            Tagihan tagihan = listBank.get(0);
            double totalTagihan = Double.valueOf(strJumlahTagihan).doubleValue();
            double tagihanBank = Double.valueOf(tagihan.getTagihan()).doubleValue();
            if (totalTagihan != tagihanBank) {
              DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Tagihan sudah ada pada bank, namun total tagihan berbeda, mencoba menghapus..<br>";
              EchoTagihanDeleteByRecordId echoTagihanDeleteByRecordId = new EchoTagihanDeleteByRecordId();
              TagihanDelete tagihanDelete = new TagihanDelete();
              tagihanDelete.setsUser(AppSetting.USERNAME_BPHTB);
              tagihanDelete.setsPassword(AppSetting.PWD_BPHTB);
              tagihanDelete.setsInstansi(AppSetting.INSTANSI_BPHTB);
              tagihanDelete.setsNoId(noId);
              tagihanDelete.setsRecordId(tagihan.getId());
              String respCode = echoTagihanDeleteByRecordId.action(tagihanDelete);
              if (respCode.equals("00")) {
                DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Berhasil dihapus<br>";
                DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                String str = " WHERE NO_ID='" + noId + "' AND SNOID='" + sNoId + "'";
                if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
                  dTaxIntegrationMonitor.sentBphtbIprotax(str);
                  continue;
                } 
                dTaxIntegrationMonitor.sentBphtb(str);
              } 
              continue;
            } 
            DTaxManagerBphtb.statusAutoUpload = dTaxManagerBphtbx.getStatusAutoUpload() + " Tagihan sudah ada pada bank!<br><br>";
            continue;
          } 
          DTaxIntegrationMonitor dtax = new DTaxIntegrationMonitor();
          String whereSent = " WHERE NO_ID='" + noId + "' AND SNOID='" + sNoId + "'";
          if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
            dtax.sentBphtbIprotax(whereSent);
            continue;
          } 
          dtax.sentBphtb(whereSent);
        } 
      } catch (Exception exc) {
        System.out.println(exc.toString());
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return "";
  }
  
  public static SOAPMessage createSOAPRequest(FileSent fileSent, String lokasi) throws Exception {
    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();
    try {
      String serverURI = "http://tempuri.org/";
      System.out.println(" --------------------------------------- ");
      System.out.println(" LOKASI PATH " + lokasi);
      SOAPEnvelope envelope = soapPart.getEnvelope();
      envelope.addNamespaceDeclaration("example", serverURI);
      SOAPBody soapBody = envelope.getBody();
      SOAPElement soapBodyElem = soapBody.addChildElement("upload_file", "example");
      SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("sUser", "example");
      soapBodyElem1.addTextNode("" + fileSent.getsUser());
      SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("sPassword", "example");
      soapBodyElem2.addTextNode("" + fileSent.getsPassword());
      SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("sInstansi", "example");
      soapBodyElem3.addTextNode("" + fileSent.getsInstansi());
      File file = new File(lokasi);
      String res1 = Base64.encodeFromFile(lokasi);
      SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("Data", "example");
      soapBodyElem4.addTextNode(res1);
      SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("fileName", "example");
      soapBodyElem5.addTextNode("" + fileSent.getFileNameZip());
      MimeHeaders headers = soapMessage.getMimeHeaders();
      headers.addHeader("SOAPAction", serverURI + "upload_file");
      soapMessage.saveChanges();
      System.out.print("n/Request SOAP Message: n/");
      soapMessage.writeTo(System.out);
      System.out.println();
    } catch (Exception exc) {
      System.out.println("Exception kirim data :" + exc.toString());
    } 
    return soapMessage;
  }
  
  private static String hexEncode(String in) {
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < in.length() - 2 + 1; i += 2) {
      int c = Integer.parseInt(in.substring(i, i + 2), 16);
      char chr = (char)c;
      sb.append(chr);
    } 
    return sb.toString();
  }
  
  private static byte[] loadFile(File file) throws IOException {
    InputStream is = new FileInputStream(file);
    long length = file.length();
    if (length > 2147483647L);
    byte[] bytes = new byte[(int)length];
    int offset = 0;
    int numRead = 0;
    while (offset < bytes.length && (
      numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)
      offset += numRead; 
    if (offset < bytes.length)
      throw new IOException("Could not completely read file " + file.getName()); 
    is.close();
    return bytes;
  }
  
  private static String readFile(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    try {
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
        sb.append(line);
        sb.append("\n");
        line = br.readLine();
      } 
      return sb.toString();
    } finally {
      br.close();
    } 
  }
}
