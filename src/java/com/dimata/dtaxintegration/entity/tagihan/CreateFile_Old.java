package com.dimata.dtaxintegration.entity.tagihan;

import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.dtaxintegration.entity.inquery.Pbb;
import com.dimata.dtaxintegration.entity.inquery.Simpatda;
import com.dimata.dtaxintegration.entity.loghistory.LogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.tagihan.CreateFile;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.dtaxintegration.session.ConvertAngkaToHuruf;
import com.dimata.dtaxintegration.session.DTaxManagerBphtb;
import com.dimata.dtaxintegration.session.DTaxManagerPbb;
import com.dimata.dtaxintegration.session.DTaxManagerPhr;
import com.dimata.dtaxintegration.session.SessPbbIprotax;
import com.dimata.dtaxintegration.session.SessSimpatda;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.util.Diskon;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateFile_Old {
  public static String sentPbb(FileSent fileSent) {
    PrintWriter pw = null;
    String patchFle = "";
    DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = fileSent.getLocation() + System.getProperty("file.separator") + AppSetting.INSTANSI_PBB + ".txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      Vector<Pbb> vPBB = new Vector();
      String whereClause = "";
      int startYear = 0;
      int endYear = 0;
      String whereDelete = "" + PstLogHistoryTransaksi.fieldNames[1] + "='" + AppSetting.INSTANSI_PBB + "'";
      SessSimpatda.deleteExc(whereDelete);
      if (!fileSent.getTahunStart().equals("") || !fileSent.equals("")) {
        whereClause = " WHERE TAHUN BETWEEN " + fileSent.getTahunStart() + " AND " + fileSent.getTahunEnd() + "";
        startYear = Integer.parseInt(fileSent.getTahunStart());
        endYear = Integer.parseInt(fileSent.getTahunEnd());
      } 
      int count = SessSimpatda.countPBB(whereClause);
      DTaxManagerPbb.countTotal = count;
      pw.print("id\t");
      pw.print("nama\t");
      pw.print("jum_tagihan\t");
      pw.print("instansi\t");
      pw.print("NPWP\t");
      pw.print("Alamat WP\t");
      pw.print("Letak Objek Pajak\t");
      pw.print("Tahun\t");
      pw.print("Tgl Jatuh Tempo\t");
      pw.print("Luas Bumi\t");
      pw.print("Luas Bangunan\t");
      pw.print("NJOP Bumi\t");
      pw.print("NJOP Bangunan\t");
      pw.print("NJOPTKP\t");
      pw.print("Denda\t");
      pw.print("Formula\t");
      pw.print("Terbilang\t");
      pw.println();
      if (startYear != endYear) {
        for (int k = startYear; k <= endYear; k++) {
          whereClause = " WHERE TAHUN BETWEEN " + k + " AND " + k + "";
          DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br> Proses file tahun " + k;
          DBResultSet dbrs = null;
          String nop = "";
          int counterRs = 0;
        } 
      } else {
        vPBB = SessSimpatda.getListPBBThread(whereClause);
        if (vPBB.size() > 0)
          for (int i = 0; i < vPBB.size(); i++) {
            Pbb pbb = vPBB.get(i);
            if (!DTaxManagerPbb.running)
              return patchFle; 
            pw.print(pbb.getId() + "\t");
            pw.print(pbb.getNama() + "\t");
            pw.print(pbb.getJumlahTagihan() + "\t");
            pw.print("PBB_GIANYAR\t");
            pw.print(pbb.getNpwpd() + "\t");
            pw.print(pbb.getAlamat() + "\t");
            pw.print(pbb.getLetakObjectPajak() + "\t");
            pw.print(pbb.getTahun() + "\t");
            pw.print(pbb.getTglJatuhTempo() + "\t");
            pw.print(pbb.getLuasBumi() + "\t");
            pw.print(pbb.getLuasBangunan() + "\t");
            pw.print(pbb.getnJOPBumi() + "\t");
            pw.print(pbb.getnJOPBangunan() + "\t");
            pw.print(pbb.getnJOPTKP() + "\t");
            pw.print(pbb.getDenda() + "\t");
            pw.print(pbb.getFormula() + "\t");
            if (!pbb.getJumlahTagihan().equals("")) {
              double total = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
              long mylong = (long)total;
              ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
              pbb.setTerbilang(convert.getText());
              pw.print(pbb.getTerbilang() + "\t");
            } else {
              pw.print(pbb.getTerbilang() + "\t");
            } 
            pw.println();
            LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
            logHistory.setId(pbb.getId());
            logHistory.setNama(pbb.getNama());
            if (!pbb.getJumlahTagihan().equals("")) {
              logHistory.setJumlahPajak(Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
            } else {
              logHistory.setJumlahPajak(0.0D);
            } 
            logHistory.setTahun(pbb.getTahun());
            logHistory.setBulan("");
            logHistory.setInstansi(pbb.getInstansi());
            if (!pbb.getDenda().equals("")) {
              logHistory.setDenda(Double.valueOf(pbb.getDenda()).doubleValue());
            } else {
              logHistory.setDenda(0.0D);
            } 
            logHistory.setAlamat(pbb.getAlamat());
            logHistory.setLetakObjeckPajak(pbb.getLetakObjectPajak());
            if (!pbb.getLuasBangunan().equals("")) {
              logHistory.setLuasBangunan(Double.valueOf(pbb.getLuasBangunan()).doubleValue());
            } else {
              logHistory.setLuasBangunan(0.0D);
            } 
            if (!pbb.getLuasBumi().equals("")) {
              logHistory.setLuasBumi(Double.valueOf(pbb.getLuasBumi()).doubleValue());
            } else {
              logHistory.setLuasBumi(0.0D);
            } 
            if (!pbb.getnJOPBangunan().equals("")) {
              logHistory.setnJOPBangunan(Double.valueOf(pbb.getnJOPBangunan()).doubleValue());
            } else {
              logHistory.setnJOPBangunan(0.0D);
            } 
            if (!pbb.getnJOPBumi().equals("")) {
              logHistory.setnJOPBumi(Double.valueOf(pbb.getnJOPBumi()).doubleValue());
            } else {
              logHistory.setnJOPBumi(0.0D);
            } 
            if (!pbb.getnJOPTKP().equals("")) {
              logHistory.setnJOPTKP(Double.valueOf(pbb.getnJOPTKP()).doubleValue());
            } else {
              logHistory.setnJOPTKP(0.0D);
            } 
            long oid = PstLogHistoryTransaksi.insertExc(logHistory);
            DTaxManagerPbb.count++;
          }  
      } 
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static String sentPbbIpRotax(FileSent fileSent) {
    PrintWriter pw = null;
    String patchFle = "";
    DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = fileSent.getLocation() + System.getProperty("file.separator") + fileSent.getFileName() + ".txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      double totalTagihan = 0.0D;
      Vector<Pbb> vPBB = new Vector();
      String whereClause = "";
      int startYear = 0;
      int endYear = 0;
      if (!fileSent.getTahunStart().equals("") || !fileSent.equals("")) {
        whereClause = " WHERE TAHUN BETWEEN " + fileSent.getTahunStart() + " AND " + fileSent.getTahunEnd() + " ";
        startYear = Integer.parseInt(fileSent.getTahunStart());
        endYear = Integer.parseInt(fileSent.getTahunEnd());
      } 
      int count = SessSimpatda.countPBB(whereClause);
      DTaxManagerPbb.countTotal = count;
      pw.print("id\t");
      pw.print("nama\t");
      pw.print("jum_tagihan\t");
      pw.print("instansi\t");
      pw.print("NPWP\t");
      pw.print("Alamat WP\t");
      pw.print("Letak Objek Pajak\t");
      pw.print("Tahun\t");
      pw.print("Tgl Jatuh Tempo\t");
      pw.print("Luas Bumi\t");
      pw.print("Luas Bangunan\t");
      pw.print("NJOP Bumi\t");
      pw.print("NJOP Bangunan\t");
      pw.print("NJOPTKP\t");
      pw.print("Denda\t");
      pw.print("Formula\t");
      pw.print("Terbilang\t");
      pw.println();
      if (startYear != endYear) {
        for (int k = startYear; k <= endYear; k++) {
          whereClause = " WHERE TAHUN BETWEEN " + k + " AND " + k;
          DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br> Proses file tahun " + k;
          DBResultSet dbrs = null;
          String nop = "";
          int counterRs = 0;
        } 
      } else {
        vPBB = SessSimpatda.getListPBBThreadIProtax(whereClause);
        if (vPBB.size() > 0)
          for (int i = 0; i < vPBB.size(); i++) {
            Pbb pbb = vPBB.get(i);
            if (!DTaxManagerPbb.running)
              return patchFle; 
            double totPambayaran = SessPbbIprotax.PerhitunganPbbYangHarusDibayar(pbb.getId(), pbb.getTahun(), pbb.getJumlahTagihan());
            double denda = SessPbbIprotax.PerhitunganDenda(pbb.getId(), pbb.getTahun(), pbb.getTglJatuhTempo(), pbb.getJumlahTagihan(), totPambayaran);
            double ygHarusDibayar = totPambayaran + denda;
            try {
              pbb.setJumlahTagihan(String.format("%.0f", new Object[] { Double.valueOf(ygHarusDibayar) }));
            } catch (Exception exception) {}
            try {
              pbb.setDenda(Formater.formatNumber(denda, "#,###,##0"));
            } catch (Exception exception) {}
            pbb.setFormula("(" + pbb.getnJOPBumi() + " + " + pbb.getnJOPBangunan() + " - " + pbb.getnJOPTKP() + ") X " + (pbb.getTarifSppt() * pbb.getNjkpSppt() / 100.0D) + " % + " + pbb.getDenda());
            pw.print(pbb.getId() + "\t");
            pw.print(pbb.getNama() + "\t");
            pw.print(pbb.getJumlahTagihan() + "\t");
            pw.print("" + AppSetting.INSTANSI_PBB + "\t");
            pw.print(pbb.getNpwpd() + "\t");
            pw.print(pbb.getAlamat() + "\t");
            pw.print(pbb.getLetakObjectPajak() + "\t");
            pw.print(pbb.getTahun() + "\t");
            pw.print(pbb.getTglJatuhTempo() + "\t");
            pw.print(pbb.getLuasBumi() + "\t");
            pw.print(pbb.getLuasBangunan() + "\t");
            pw.print(pbb.getnJOPBumi() + "\t");
            pw.print(pbb.getnJOPBangunan() + "\t");
            pw.print(pbb.getnJOPTKP() + "\t");
            pw.print(pbb.getDenda() + "\t");
            pw.print(pbb.getFormula() + "\t");
            if (!pbb.getJumlahTagihan().equals("")) {
              double total = Double.valueOf(pbb.getJumlahTagihan()).doubleValue();
              long mylong = (long)total;
              ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
              pbb.setTerbilang(convert.getText() + " rupiah ");
              pw.print(pbb.getTerbilang() + "\t");
            } else {
              pw.print(pbb.getTerbilang() + "\t");
            } 
            pw.println();
            LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
            logHistory.setId(pbb.getId());
            logHistory.setNama(pbb.getNama());
            if (!pbb.getJumlahTagihan().equals("")) {
              logHistory.setJumlahPajak(Double.valueOf(pbb.getJumlahTagihan()).doubleValue());
            } else {
              logHistory.setJumlahPajak(0.0D);
            } 
            logHistory.setTahun(pbb.getTahun());
            logHistory.setBulan("");
            logHistory.setInstansi(pbb.getInstansi());
            if (!pbb.getDenda().equals("")) {
              logHistory.setDenda(denda);
            } else {
              logHistory.setDenda(0.0D);
            } 
            logHistory.setAlamat(pbb.getAlamat());
            logHistory.setLetakObjeckPajak(pbb.getLetakObjectPajak());
            if (!pbb.getLuasBangunan().equals("")) {
              logHistory.setLuasBangunan(Double.valueOf(pbb.getLuasBangunan()).doubleValue());
            } else {
              logHistory.setLuasBangunan(0.0D);
            } 
            if (!pbb.getLuasBumi().equals("")) {
              logHistory.setLuasBumi(Double.valueOf(pbb.getLuasBumi()).doubleValue());
            } else {
              logHistory.setLuasBumi(0.0D);
            } 
            if (!pbb.getnJOPBangunan().equals("")) {
              logHistory.setnJOPBangunan(Double.valueOf(pbb.getnJOPBangunan()).doubleValue());
            } else {
              logHistory.setnJOPBangunan(0.0D);
            } 
            if (!pbb.getnJOPBumi().equals("")) {
              logHistory.setnJOPBumi(Double.valueOf(pbb.getnJOPBumi()).doubleValue());
            } else {
              logHistory.setnJOPBumi(0.0D);
            } 
            if (!pbb.getnJOPTKP().equals("")) {
              logHistory.setnJOPTKP(Double.valueOf(pbb.getnJOPTKP()).doubleValue());
            } else {
              logHistory.setnJOPTKP(0.0D);
            } 
            long oid = PstLogHistoryTransaksi.insertExc(logHistory);
            DTaxManagerPbb.count++;
          }  
      } 
      DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br> Total tagihan + denda keseluruhan : " + Formater.formatNumber(totalTagihan, "#,###");
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static String sentPbbIpRotaxV2(FileSent fileSent) {
    Diskon diskon = new Diskon();
    PrintWriter pw = null;
    String patchFle = "";
    DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = fileSent.getLocation() + System.getProperty("file.separator") + fileSent.getFileName() + ".txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      double totalTagihan = 0.0D;
      Vector vPBB = new Vector();
      String whereClause = "";
      int startYear = 0;
      int endYear = 0;
      if (!fileSent.getTahunStart().equals("") || !fileSent.equals("")) {
        startYear = Integer.parseInt(fileSent.getTahunStart());
        endYear = Integer.parseInt(fileSent.getTahunEnd());
      } 
      pw.print("id\t");
      pw.print("nama\t");
      pw.print("jum_tagihan\t");
      pw.print("instansi\t");
      pw.print("NPWP\t");
      pw.print("Alamat WP\t");
      pw.print("Letak Objek Pajak\t");
      pw.print("Tahun\t");
      pw.print("Tgl Jatuh Tempo\t");
      pw.print("Luas Bumi\t");
      pw.print("Luas Bangunan\t");
      pw.print("NJOP Bumi\t");
      pw.print("NJOP Bangunan\t");
      pw.print("NJOPTKP\t");
      pw.print("Denda\t");
      pw.print("Formula\t");
      pw.print("Terbilang\t");
      pw.println();
      int data = 0;
      for (int k = startYear; k <= endYear; k++) {
        whereClause = " WHERE TAHUN BETWEEN " + k + " AND " + k;
        DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br> Proses file tahun " + k;
        DBResultSet dbrs = null;
        String nop = "";
        int counterRs = 0;
      } 
      DTaxManagerPbb.statusProses = dTaxManagerPbbx.getProses() + "<br> Total tagihan + denda keseluruhan : " + Formater.formatNumber(totalTagihan, "#,###");
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static String sentBphtbIprotax(FileSent fileSent) {
    PrintWriter pw = null;
    String patchFle = "";
    String patchFleZip = "";
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = fileSent.getLocation() + System.getProperty("file.separator") + fileSent.getFileName() + ".txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      String whereDelete = "" + PstLogHistoryTransaksi.fieldNames[1] + "='" + AppSetting.INSTANSI_BPHTB + "'";
      SessSimpatda.deleteExc(whereDelete);
      Vector<BphtbIprotax> vSimpatda = new Vector();
      int count = SessSimpatda.countBPHTB(" WHERE THN_BPHTB = 2021");
      DTaxManagerBphtb.countTotal = count;
      vSimpatda = SessSimpatda.getListBphtbThread(" WHERE THN_BPHTB = 2021");
      pw.print("NO_ID\t");
      pw.print("NAMA\t");
      pw.print("JUM_TAGIHAN\t");
      pw.print("INSTANSI_ID\t");
      pw.print("sNoId\t");
      pw.print("PPAT\t");
      pw.print("Terbilang\t");
      pw.println();
      if (vSimpatda.size() > 0)
        for (int i = 0; i < vSimpatda.size(); i++) {
          BphtbIprotax bphtb = vSimpatda.get(i);
          if (!DTaxManagerBphtb.running)
            return patchFle; 
          pw.print(bphtb.getNoId() + "\t");
          pw.print(bphtb.getNama() + "\t");
          pw.print(bphtb.getJumTagihan() + "\t");
          pw.print(AppSetting.INSTANSI_BPHTB + "\t");
          pw.print(bphtb.getsNoId() + "\t");
          pw.print(bphtb.getPpat() + "\t");
          if (!bphtb.getJumTagihan().equals("")) {
            double total = Double.valueOf(bphtb.getJumTagihan()).doubleValue();
            long mylong = (long)total;
            ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
            bphtb.setTerbilang(convert.getText() + " rupiah ");
            pw.print(bphtb.getTerbilang() + "\t");
          } else {
            pw.print(bphtb.getTerbilang() + "\t");
          } 
          pw.println();
          LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
          logHistory.setId(bphtb.getNoId());
          logHistory.setNama(bphtb.getNama());
          logHistory.setInstansi(bphtb.getInstansi());
          logHistory.setJumlahPajak(Double.valueOf(bphtb.getJumTagihan()).doubleValue());
          long oid = PstLogHistoryTransaksi.insertExc(logHistory);
          DTaxManagerBphtb.count++;
        }  
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static String makeZip(String patch) {
    String patchFleZip = "";
    try {
      FileOutputStream fos = new FileOutputStream("PBB_GIANYAR.zip");
      ZipOutputStream zos = new ZipOutputStream(fos);
      String file1Name = patch;
      addToZipFile(file1Name, zos);
      zos.close();
      fos.close();
      patchFleZip = patch + System.getProperty("file.separator") + "PBB_GIANYAR.zip";
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    return patchFleZip;
  }
  
  public static String zipFile(File inputFile, FileSent fileSent, int type) {
    String patchFleZip = "";
    if (type == 0)
      patchFleZip = fileSent.getLocation() + System.getProperty("file.separator") + fileSent.getFileName() + ".zip"; 
    if (type == 1) {
      patchFleZip = fileSent.getLocation() + System.getProperty("file.separator") + fileSent.getFileName() + ".zip";
    } else {
      patchFleZip = fileSent.getLocation() + System.getProperty("file.separator") + fileSent.getFileName() + ".zip";
    } 
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(patchFleZip);
      ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
      zipOutputStream.setLevel(9);
      ZipEntry zipEntry = new ZipEntry(inputFile.getName());
      zipOutputStream.putNextEntry(zipEntry);
      FileInputStream fileInputStream = new FileInputStream(inputFile);
      byte[] buf = new byte[1024];
      int bytesRead;
      while ((bytesRead = fileInputStream.read(buf)) > 0)
        zipOutputStream.write(buf, 0, bytesRead); 
      zipOutputStream.closeEntry();
      zipOutputStream.close();
      fileOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    return patchFleZip;
  }
  
  public static String sentPhr(String patch) {
    PrintWriter pw = null;
    String patchFle = "";
    String patchFleZip = "";
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = patch + System.getProperty("file.separator") + "PHR_GIANYAR.txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      String whereDelete = "" + PstLogHistoryTransaksi.fieldNames[1] + "='" + AppSetting.INSTANSI_PHR + "'";
      SessSimpatda.deleteExc(whereDelete);
      Vector<Simpatda> vSimpatda = new Vector();
      int count = SessSimpatda.countPHR("");
      DTaxManagerPhr.countTotal = count;
      vSimpatda = SessSimpatda.getListSimpatdaThread("");
      pw.print("id\t");
      pw.print("nama\t");
      pw.print("jum_tagihan\t");
      pw.print("instansi\t");
      pw.print("Alamat\t");
      pw.print("Bulan\t");
      pw.print("Tahun\t");
      pw.print("Pokok\t");
      pw.print("Denda\t");
      pw.print("No_Sptpd\t");
      pw.println();
      if (vSimpatda.size() > 0)
        for (int i = 0; i < vSimpatda.size(); i++) {
          Simpatda simpatda = vSimpatda.get(i);
          if (!DTaxManagerPhr.running)
            return patchFle; 
          pw.print(simpatda.getId() + "\t");
          pw.print(simpatda.getNamaSimpatda() + "\t");
          pw.print(simpatda.getJumlahPajakSimpatda() + "\t");
          pw.print(AppSetting.INSTANSI_PHR + "\t");
          pw.print(simpatda.getAlamat() + "\t");
          pw.print(simpatda.getBulanSimpatda() + "\t");
          pw.print(simpatda.getTahunSimpatda() + "\t");
          pw.print(simpatda.getPokok() + "\t");
          pw.print(simpatda.getDenda() + "\t");
          pw.print(simpatda.getNoSspdSimpatda() + "\t");
          pw.println();
          LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
          logHistory.setId(simpatda.getId());
          logHistory.setNama(simpatda.getNamaSimpatda());
          if (!simpatda.getJumlahPajakSimpatda().equals("")) {
            logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
          } else {
            logHistory.setJumlahPajak(0.0D);
          } 
          logHistory.setTahun(simpatda.getTahunSimpatda());
          logHistory.setBulan(simpatda.getBulanSimpatda());
          logHistory.setInstansi(simpatda.getInstansi());
          if (!simpatda.getDenda().equals("")) {
            logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
          } else {
            logHistory.setDenda(0.0D);
          } 
          if (!simpatda.getPokok().equals("")) {
            logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
          } else {
            logHistory.setPokok(0.0D);
          } 
          logHistory.setAlamat(simpatda.getAlamat());
          long oid = PstLogHistoryTransaksi.insertExc(logHistory);
          DTaxManagerPhr.count++;
        }  
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static String sentPhrOpenPhr(String patch) {
    PrintWriter pw = null;
    String patchFle = "";
    String patchFleZip = "";
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = patch + System.getProperty("file.separator") + AppSetting.INSTANSI_PHR + ".txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      String whereDelete = "" + PstLogHistoryTransaksi.fieldNames[1] + "='" + AppSetting.INSTANSI_PHR + "'";
      SessSimpatda.deleteExc(whereDelete);
      Vector<Simpatda> vSimpatda = new Vector();
      int count = 0;
      if (AppSetting.TYPE_APP_BACKOFFICE == 3) {
        count = SessSimpatda.countPHROpenPHR("");
      } else {
        count = SessSimpatda.countPHR("");
      } 
      DTaxManagerPhr.countTotal = count;
      vSimpatda = SessSimpatda.getListSimpatdaThreadOpenPhr("");
      pw.print("id\t");
      pw.print("nama\t");
      pw.print("jum_tagihan\t");
      pw.print("instansi\t");
      pw.print("Alamat\t");
      pw.print("Bulan\t");
      pw.print("Tahun\t");
      pw.print("Pokok\t");
      pw.print("Denda\t");
      pw.print("Keteran\t");
      pw.print("NPWPD\t");
      pw.print("TanggalAwal\t");
      pw.print("TanggalAkhir\t");
      pw.println();
      if (vSimpatda.size() > 0)
        for (int i = 0; i < vSimpatda.size(); i++) {
          Simpatda simpatda = vSimpatda.get(i);
          if (!DTaxManagerPhr.running)
            return patchFle; 
          pw.print(simpatda.getId() + "\t");
          pw.print(simpatda.getNamaSimpatda() + "\t");
          pw.print(simpatda.getJumlahPajakSimpatda() + "\t");
          pw.print(AppSetting.INSTANSI_PHR + "\t");
          pw.print(simpatda.getAlamat() + "\t");
          pw.print(simpatda.getBulanSimpatda() + "\t");
          pw.print(simpatda.getTahunSimpatda() + "\t");
          pw.print(simpatda.getPokok() + "\t");
          pw.print(simpatda.getDenda() + "\t");
          pw.print(simpatda.getKeterangan() + "\t");
          pw.print(simpatda.getNpwpd() + "\t");
          pw.print(simpatda.getTanggalAwal() + "\t");
          pw.print(simpatda.getTanggalAkhir() + "\t");
          pw.println();
          LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
          logHistory.setId(simpatda.getId());
          logHistory.setNama(simpatda.getNamaSimpatda());
          if (!simpatda.getJumlahPajakSimpatda().equals("")) {
            logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
          } else {
            logHistory.setJumlahPajak(0.0D);
          } 
          logHistory.setTahun(simpatda.getTahunSimpatda());
          logHistory.setBulan(simpatda.getBulanSimpatda());
          logHistory.setInstansi(simpatda.getInstansi());
          if (!simpatda.getDenda().equals("")) {
            logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
          } else {
            logHistory.setDenda(0.0D);
          } 
          if (!simpatda.getPokok().equals("")) {
            logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
          } else {
            logHistory.setPokok(0.0D);
          } 
          logHistory.setAlamat(simpatda.getAlamat());
          long oid = PstLogHistoryTransaksi.insertExc(logHistory);
          DTaxManagerPhr.count++;
        }  
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static String sentPhrPhrH(String patch) {
    PrintWriter pw = null;
    String patchFle = "";
    String patchFleZip = "";
    try {
      Date dateNow = new Date();
      Date transaksiCreate = dateNow;
      String strYear = String.valueOf(transaksiCreate.getYear() + 1900);
      String strMonth = String.valueOf(transaksiCreate.getMonth() + 1);
      String strDate = String.valueOf(transaksiCreate.getDate());
      patchFle = patch + System.getProperty("file.separator") + AppSetting.INSTANSI_PHR + ".txt";
      pw = new PrintWriter(patchFle);
    } catch (FileNotFoundException fileNotFoundException) {}
    try {
      String whereDelete = "" + PstLogHistoryTransaksi.fieldNames[1] + "='" + AppSetting.INSTANSI_PHR + "'";
      SessSimpatda.deleteExc(whereDelete);
      Vector<Simpatda> vSimpatda = new Vector();
      int count = SessSimpatda.countPHRPHRH("");
      DTaxManagerPhr.countTotal = count;
      vSimpatda = SessSimpatda.getListSimpatdaThreadPhrH("");
      pw.print("id\t");
      pw.print("nama\t");
      pw.print("jum_tagihan\t");
      pw.print("instansi\t");
      pw.print("NPWPD\t");
      pw.print("JenisUsaha\t");
      pw.print("Alamat\t");
      pw.print("Bulan\t");
      pw.print("Tahun\t");
      pw.print("TanggalJatuhTempo\t");
      pw.print("TagihanPajak\t");
      pw.print("TagihanAdmin\t");
      pw.print("TagihanDenda\t");
      pw.print("Waktu\t");
      pw.println();
      if (vSimpatda.size() > 0)
        for (int i = 0; i < vSimpatda.size(); i++) {
          Simpatda simpatda = vSimpatda.get(i);
          if (!DTaxManagerPhr.running)
            return patchFle; 
          pw.print(simpatda.getId() + "\t");
          pw.print(simpatda.getNamaSimpatda() + "\t");
          pw.print(simpatda.getJumlahPajakSimpatda() + "\t");
          pw.print(AppSetting.INSTANSI_PHR + "\t");
          pw.print(simpatda.getNpwpd() + "\t");
          pw.print(simpatda.getJenisUsaha() + "\t");
          pw.print(simpatda.getAlamat() + "\t");
          pw.print(simpatda.getBulanSimpatda() + "\t");
          pw.print(simpatda.getTahunSimpatda() + "\t");
          pw.print(simpatda.getJatuhTempo() + "\t");
          pw.print(simpatda.getPokok() + "\t");
          pw.print(simpatda.getTagihanAdmin() + "\t");
          pw.print(simpatda.getDenda() + "\t");
          pw.print(simpatda.getWaktu() + "\t");
          pw.println();
          LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
          logHistory.setId(simpatda.getId());
          logHistory.setNama(simpatda.getNamaSimpatda());
          if (!simpatda.getJumlahPajakSimpatda().equals("")) {
            logHistory.setJumlahPajak(Double.valueOf(simpatda.getJumlahPajakSimpatda()).doubleValue());
          } else {
            logHistory.setJumlahPajak(0.0D);
          } 
          logHistory.setTahun(simpatda.getTahunSimpatda());
          logHistory.setBulan(simpatda.getBulanSimpatda());
          logHistory.setInstansi(simpatda.getInstansi());
          if (!simpatda.getDenda().equals("")) {
            logHistory.setDenda(Double.valueOf(simpatda.getDenda()).doubleValue());
          } else {
            logHistory.setDenda(0.0D);
          } 
          if (!simpatda.getPokok().equals("")) {
            logHistory.setPokok(Double.valueOf(simpatda.getPokok()).doubleValue());
          } else {
            logHistory.setPokok(0.0D);
          } 
          logHistory.setAlamat(simpatda.getAlamat());
          long oid = PstLogHistoryTransaksi.insertExc(logHistory);
          DTaxManagerPhr.count++;
        }  
    } catch (Exception exc) {
      System.out.println("ini eornya" + exc);
    } 
    pw.flush();
    return patchFle;
  }
  
  public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {
    System.out.println("Writing '" + fileName + "' to zip file");
    File file = new File(fileName);
    FileInputStream fis = new FileInputStream(file);
    ZipEntry zipEntry = new ZipEntry(fileName);
    zos.putNextEntry(zipEntry);
    byte[] bytes = new byte[1024];
    int length;
    while ((length = fis.read(bytes)) >= 0)
      zos.write(bytes, 0, length); 
    zos.closeEntry();
    fis.close();
  }
}
