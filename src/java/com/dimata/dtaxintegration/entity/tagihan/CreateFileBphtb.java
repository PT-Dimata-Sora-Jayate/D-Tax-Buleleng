/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.tagihan;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
import com.dimata.dtaxintegration.entity.inquery.BphtbIprotax;
import com.dimata.dtaxintegration.entity.loghistory.LogHistoryTransaksi;
import com.dimata.dtaxintegration.entity.loghistory.PstLogHistoryTransaksi;
import com.dimata.dtaxintegration.session.ConvertAngkaToHuruf;
import com.dimata.dtaxintegration.session.bphtb.DTaxManagerBphtb;
import com.dimata.dtaxintegration.session.bphtb.SessSimpatdaBphtb;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.AppSettingBphtb;
import java.io.FileNotFoundException;
import java.util.Date;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateFileBphtb{
    /**
     *
     * @param createDate
     * @param patch
     * @param type -> 0:cdr lama alamat email adalah alamat email hotel && 1 : cdr baru dengan alamat email alamat email customer
     * @return
     */
    public static String sentBphtbIprotax(FileSent fileSent) {
        PrintWriter pw = null;
        String patchFle = "";
        String patchFleZip = "";
        DecimalFormat df = new DecimalFormat("#");
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
            String whereClause = ""; 
            int startYear=0;
            int endYear=0;
            
//            if(!(fileSent.getTahunStart().equals("") && fileSent.equals(""))){
//                whereClause = " WHERE THN_BPHTB BETWEEN "+fileSent.getTahunStart()+""
//                              +" AND "+fileSent.getTahunEnd()+"";
//                startYear = Integer.parseInt(fileSent.getTahunStart());
//                endYear = Integer.parseInt(fileSent.getTahunEnd());
//            }
            int count = SessSimpatdaBphtb.countBPHTB(whereClause);
            DTaxManagerBphtb.countTotal=count;
            
            String whereDelete = "" + PstLogHistoryTransaksi.fieldNames[1] + "='" + AppSettingBphtb.INSTANSI_BPHTB + "'";
            SessSimpatdaBphtb.deleteExc(whereDelete);
            
            Vector<BphtbIprotax> vSimpatda = new Vector();
            pw.print("NO_ID\t");
            pw.print("NAMA\t");
            pw.print("JUM_TAGIHAN\t");
            pw.print("INSTANSI_ID\t");
            pw.print("sNoId\t");
            pw.print("PPAT\t");
            pw.print("Terbilang"+"\t");
            pw.println();
            
//            if(startYear!=endYear){
//                for (int k=startYear; k<=endYear; k++){
//                    DTaxManagerBphtb.prosesData += "<div>Proses Data Tahun "+k+"</div>";
//                    whereClause = " WHERE THN_BPHTB BETWEEN "+k+""+" AND "+k+"";
                    vSimpatda = SessSimpatdaBphtb.getListBphtbThread(whereClause);
                    
                    if (vSimpatda.size() > 0){
                        for (int i = 0; i < vSimpatda.size(); i++) {
                            BphtbIprotax bphtb = vSimpatda.get(i);
                            if (!DTaxManagerBphtb.running){
                                return patchFle; 
                            }
                            pw.print(bphtb.getNoId() + "\t");
                            pw.print(bphtb.getNama() + "\t");
                            pw.print(df.format(Double.valueOf(bphtb.getJumTagihan())) + "\t");
                            pw.print(AppSettingBphtb.INSTANSI_BPHTB + "\t");
                            pw.print(bphtb.getsNoId() + "\t");
                            pw.print(bphtb.getPpat() + "\t");
                            if (!bphtb.getJumTagihan().equals("")) {
                                double total = Double.valueOf(bphtb.getJumTagihan()).doubleValue();
                                long mylong = (long)total;
                                ConvertAngkaToHuruf convert = new ConvertAngkaToHuruf(mylong);
                                bphtb.setTerbilang(convert.getText() + " rupiah");
                                pw.print(bphtb.getTerbilang() + "\t");
                            } else {
                                pw.print(bphtb.getTerbilang() + "\t");
                            } 
                            pw.println(); 
                            LogHistoryTransaksi logHistory = new LogHistoryTransaksi();
                            logHistory.setId(bphtb.getNoId()); 
                            logHistory.setInstansi(AppSettingBphtb.INSTANSI_BPHTB);
                            logHistory.setNama(bphtb.getNama()); 
                            logHistory.setLuasBumi(Double.valueOf(bphtb.getLuasBumi())); 
                            logHistory.setLuasBangunan(Double.valueOf(bphtb.getLuasBangunan())); 
                            logHistory.setJumlahPajak(Double.valueOf(bphtb.getJumTagihan()).doubleValue());
                            long oid = PstLogHistoryTransaksi.insertExc(logHistory);
                            DTaxManagerBphtb.count++;
                        }  
                    //} 
                //}
            }
        } catch (Exception exc) {
            System.out.println("ini eornya" + exc);
            DTaxManagerBphtb.statusProses += "<br>Gagal Kirim<br>Cause :"+exc.getMessage();
            DTaxManagerBphtb.running = false;
            DTaxManagerBphtb.code = "99";
        } 
        pw.flush();
        return patchFle;
    }
    
    
   public static String makeZip(String patch) {
       String patchFleZip="";
       try {
                FileOutputStream fos = new FileOutputStream(AppSetting.INSTANSI_BPHTB+".zip");
                ZipOutputStream zos = new ZipOutputStream(fos);
                String file1Name = patch;
                addToZipFile(file1Name, zos);

                zos.close();
                fos.close();
                patchFleZip=patch+System.getProperty("file.separator")+AppSetting.INSTANSI_BPHTB+".zip";
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
       return patchFleZip;
   }
   
   
   //public static void zipFile(File inputFile, String zipFilePath) {
   public static String zipFile(File inputFile, FileSent fileSent, int type)  {   
        String patchFleZip="";
        
        if(type==0){
           patchFleZip =fileSent.getLocation()+System.getProperty("file.separator")+fileSent.getFileName()+".zip";
        }else{
            patchFleZip =fileSent.getLocation()+System.getProperty("file.separator")+fileSent.getFileNameZip()+"";
        }
        
        try {

            // Wrap a FileOutputStream around a ZipOutputStream
            // to store the zip stream to a file. Note that this is
            // not absolutely necessary
            FileOutputStream fileOutputStream = new FileOutputStream(patchFleZip);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

            // a ZipEntry represents a file entry in the zip archive
            // We name the ZipEntry after the original file's name
            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            FileInputStream fileInputStream = new FileInputStream(inputFile);
            byte[] buf = new byte[1024];
            int bytesRead;

            // Read the input file by chucks of 1024 bytes
            // and write the read bytes to the zip stream
            while ((bytesRead = fileInputStream.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, bytesRead);
            }

            // close ZipEntry to store the stream to the file
            zipOutputStream.closeEntry();

            zipOutputStream.close();
            fileOutputStream.close();

           // System.out.println("Regular file :" + inputFile.getCanonicalPath()+" is zipped to archive :"+zipFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return patchFleZip;
    }
   
   public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

}