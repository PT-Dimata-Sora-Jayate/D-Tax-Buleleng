package com.dimata.dtaxintegration.session;

import com.dimata.common.session.email.SessEmail;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.dtaxintegration.session.DTaxManagerPbb;
import com.dimata.dtaxintegration.session.DTaxMonitorPbb;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.UploadFile;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Date;

public class DTaxMonitorPbb implements Runnable {
  private FileSent fileSent = null;
  
  private String Proggess = "";
  
  public DTaxMonitorPbb() {}
  
  public DTaxMonitorPbb(FileSent fileSent) {
    try {
      this.fileSent = fileSent;
      this.Proggess = "";
    } catch (Exception e) {
      System.out.println(" ! EXC : initiate thread =  " + e.toString());
    } 
  }
  
  public void run() {
    System.out.println("start .... ");
    while (DTaxManagerPbb.running) {
      try {
        UploadFile upload = new UploadFile();
        String result = upload.actionPBB(this.fileSent);
        Date newDate = new Date();
        DTaxManagerPbb.statusEnd = " Proses " + result + " date/time : " + Formater.formatDate(newDate, "dd-MM-yyyy kk:mm");
        String message = "Dear Team, Berikut hasil proses pengiriman tagihan<br><br>";
        DTaxManagerPbb dTaxManagerPbb1 = new DTaxManagerPbb();
        message = message + dTaxManagerPbb1.getProses() + "<br>";
        message = message + dTaxManagerPbb1.getEnd() + "<br><br>";
        message = message + "<small>" + dTaxManagerPbb1.getResponStatus() + "</small> " + result + " dengan total " + dTaxManagerPbb1.getCountTotal() + " Tagihan<br>Terima Kasih<br><br>";
        NumberFormat nf = NumberFormat.getNumberInstance();
        long mb = 1048576L;
        for (Path root : FileSystems.getDefault().getRootDirectories()) {
          try {
            FileStore store = Files.getFileStore(root);
            message = message + root + " : Space Sisa : " + nf.format(store.getUsableSpace() / mb) + " MB,  Space Total : " + nf.format(store.getTotalSpace() / mb) + " MB <br>";
          } catch (IOException iOException) {}
        } 
        String subject = "";
        if (dTaxManagerPbb1.getResponStatus().equals("00")) {
          subject = subject + "[BERHASIL]";
        } else {
          subject = subject + "[GAGAL]";
        } 
        subject = subject + " Notifikasi Pengiriman Integrasi Pajak PBB " + AppSetting.INSTANSI_PBB + "_" + Formater.formatDate(new Date(), "yyyyMMdd");
        SessEmail sessEmail = new SessEmail();
        String str1 = sessEmail.sendEamil("notifikasi@bpdbali.co.id", subject, message);
      } catch (Exception e) {
        System.out.println("Interrupted " + e);
      } 
      DTaxManagerPbb.running = false;
    } 
    System.out.println("stop .... ");
    DTaxManagerPbb dTaxManagerPbb = new DTaxManagerPbb();
    dTaxManagerPbb.stopMonitor();
  }
}
