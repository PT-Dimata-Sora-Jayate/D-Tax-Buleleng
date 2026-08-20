/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.session.proses;

import com.dimata.dslik.entity.agunan.Agunan;
import com.dimata.dslik.entity.agunan.PstAgunan;
import com.dimata.dslik.entity.bankgaransi.BankGaransi;
import com.dimata.dslik.entity.bankgaransi.PstBankGaransi;
import com.dimata.dslik.entity.bpdmapping.MappingDebiturBpd;
import com.dimata.dslik.entity.debiturbdnusaha.DebiturBdnUsaha;
import com.dimata.dslik.entity.debiturbdnusaha.PstDebiturBdnUsaha;
import com.dimata.dslik.entity.debiturindividu.DebiturIndividu;
import com.dimata.dslik.entity.debiturindividu.PstDebiturIndividu;
import com.dimata.dslik.entity.fasilitaslain.FasilitasLain;
import com.dimata.dslik.entity.fasilitaslain.PstFasilitasLain;
import com.dimata.dslik.entity.irrevocablelc.IrrevocableLc;
import com.dimata.dslik.entity.irrevocablelc.PstIrrevocableLc;
import com.dimata.dslik.entity.kredit.Kredit;
import com.dimata.dslik.entity.kredit.PstKredit;
import com.dimata.dslik.entity.kreditjoinaccount.KreditJoinAccount;
import com.dimata.dslik.entity.kreditjoinaccount.PstKreditJoinAccount;
import com.dimata.dslik.entity.laporankeuangandebitur.LaporanKeuanganDebitur;
import com.dimata.dslik.entity.laporankeuangandebitur.PstLaporanKeuanganDebitur;
import com.dimata.dslik.entity.masterdata.CabangBank;
import com.dimata.dslik.entity.masterdata.OutletConnection;
import com.dimata.dslik.entity.masterdata.Periode;
import com.dimata.dslik.entity.masterdata.PstCabangBank;
import com.dimata.dslik.entity.masterdata.PstPeriode;
import com.dimata.dslik.entity.pengurusataupemilik.PengurusAtauPemilik;
import com.dimata.dslik.entity.pengurusataupemilik.PstPengurusAtauPemilik;
import com.dimata.dslik.entity.penjamin.Penjamin;
import com.dimata.dslik.entity.penjamin.PstPenjamin;
import com.dimata.dslik.entity.summaryfasilitas.PstSummaryFasilitas;
import com.dimata.dslik.entity.summaryfasilitas.SummaryFasilitas;
import com.dimata.dslik.entity.suratberharga.PstSuratBerharga;
import com.dimata.dslik.entity.suratberharga.SuratBerharga;
import com.dimata.util.Formater;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author dimata005
 */
public class CreateFile {

    public static String sentDataToDilimited(FileSent fileSent, OutletConnection outletConnection) {

        PrintWriter pw = null;
        String patchFle = "";
        try {
            //buatkan lokasi dan tempat file yang akan di upload
            //ProsesTransferDataBank prosesTransferDataBank = new ProsesTransferDataBank();
            //OutletConnection outletConnection = prosesTransferDataBank.getConfigurasiConnection();
            String namaFile = "";
            Vector vCabang = new Vector();
            int perCabang = 1;
            if(perCabang==1){
                vCabang = PstCabangBank.listParent(0, 1, "", PstCabangBank.fieldNames[PstCabangBank.FLD_NO_URUT] + " ASC ");
            }else{
                vCabang = PstCabangBank.listParent(0, 0, "", PstCabangBank.fieldNames[PstCabangBank.FLD_NO_URUT] + " ASC ");
            }
            
            boolean ujiCoba=false;
            if(outletConnection.getTypeCreateFile()==1){
                ujiCoba=true;
            }
            
            long prevPeriodeId=0;
            try{
                Periode periode = new Periode();
                Vector listPeriode = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'", "");
                if(listPeriode != null){
                    periode = (Periode) listPeriode.get(0);
                    periode.getTglAwal().setMonth(periode.getTglAwal().getMonth()-1);

                    Vector listPeriodex = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_TGL_AWAL]+" BETWEEN '"+Formater.formatDate(periode.getTglAwal(),"yyyy-MM-dd") +"' AND '"+Formater.formatDate(periode.getTglAwal(),"yyyy-MM-dd")+"'", "");
                    if(listPeriodex != null){
                        if(listPeriodex.size()>0){
                            periode = (Periode) listPeriodex.get(0);
                            prevPeriodeId = periode.getOID();
                        }
                     }
                }
            }catch(Exception ex){
            }
            
            switch (fileSent.getTypeSegment()) {
                case Configurasi.FLD_SEGMENT_DEBITUR_PERORANGAN:
                    
                    int totDebiturIndividu = PstDebiturIndividu.getCount(PstDebiturIndividu.fieldNames[PstDebiturIndividu.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"' AND KODE_JENIS_NSB=1 ");
                    int totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vDebiturIndividu = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where = where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND ";
                                    }
                                    where = where + " KODE_JENIS_NSB=1 AND "+PstDebiturIndividu.fieldNames[PstDebiturIndividu.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'" ;
                            vDebiturIndividu = PstDebiturIndividu.listJoinParentCabang(0, 0, "" + where, "");
                            if (vDebiturIndividu.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_PERORANGAN] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");//0
                                pw.print("" + outletConnection.getJenisLJK() + "|");//1
                                pw.print("" + outletConnection.getKodeLJK() + "|");//2
                                pw.print("" + fileSent.getTahun() + "|");//3
                                pw.print("" + fileSent.getBulan() + "|");//4
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_PERORANGAN] + "|");//5
                                pw.print("" + vDebiturIndividu.size() + "|");//6
                                pw.print("" + totDebiturIndividu + "");//7
                                pw.println();
                                
                                for (int p = 0; p < vDebiturIndividu.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        DebiturIndividu debiturIndividu = (DebiturIndividu) vDebiturIndividu.get(p);
                                        //D    |NIKPENG1 |CIFBUDUMMY1|1          |Margo Joyo    |L              |JL Sujartijo no 123 Jakarta Timur|Grogol Utara|Grogol    |0117          |01              |100                |1               |001                 |C
                                        //flag | no iden | cif       | jenis idn | nama pemilik | jenis kelamin | alamat                          | kelurahan  |kecamatan |kode kab dati |kode jabatan    |pangsa pemilik     |status pengurus | kode kantor cabang | operasi data 
                                        //1    | 2       | 3         | 4         | 5            | 6             | 7                               |8           | 9        | 10           | 11             | 12                |13              | 14                 | 15                                                
                                        pw.print("" + debiturIndividu.getFlagDetail() + "|");//1
                                        pw.print("" + debiturIndividu.getCif() + "|");//2
                                        pw.print("" + debiturIndividu.getJenisIdentitas() + "|");//3
                                        pw.print("" + debiturIndividu.getNik() + "|");//4
                                        pw.print("" + debiturIndividu.getNamaIdentitas() + "|");//5
                                        pw.print("" + debiturIndividu.getNamaLengkap() + "|");//6
                                        pw.print("" + debiturIndividu.getKodeStatusGelar() + "|");//7
                                        pw.print("" + debiturIndividu.getJekel() + "|");//8
                                        pw.print("" + debiturIndividu.getTempatLahir() + "|");//9
                                        try{
                                            pw.print("" +Formater.formatDate(debiturIndividu.getTglLahir() ,"yyyyMMdd")+ "|");//10
                                        }catch(Exception es){
                                            pw.print(" |");//10
                                        }
                                        pw.print("" + debiturIndividu.getNpwp() + "|");//11
                                        pw.print("" + debiturIndividu.getAlamat() + "|");//12
                                        pw.print("" + debiturIndividu.getKelurahan() + "|");//13
                                        pw.print("" + debiturIndividu.getKecamatan() + "|");//14
                                        pw.print("" + debiturIndividu.getKodeKab() + "|");//15
                                        pw.print("" + debiturIndividu.getKodePos() + "|");//16
                                        pw.print("" + debiturIndividu.getTelepon() + "|");//17
                                        pw.print("" + debiturIndividu.getNomorHp()+ "|");//18
                                        pw.print("" + MappingDebiturBpd.checkAlamatEmail(debiturIndividu.getEmail()) + "|");//19
                                        pw.print("" + debiturIndividu.getKodeDomisili() + "|");//20
                                        pw.print("" + debiturIndividu.getKodePekerjaan() + "|");//21
                                        pw.print("" + debiturIndividu.getTempatBekerja() + "|");//22
                                        pw.print("" + debiturIndividu.getKodeUsahaTempatBekerja() + "|");//23
                                        pw.print("" + debiturIndividu.getAlamatTempatBekerja() + "|");//24
                                        pw.print("" + Formater.formatNumberNoDecimal(debiturIndividu.getPenghasilanKotor()) + "|");//25
                                        pw.print("" + debiturIndividu.getKodePenghasilan() + "|");//26
                                        pw.print("" + debiturIndividu.getJmlTanggungan() + "|");//27
                                        pw.print("" + debiturIndividu.getKodeHub() + "|");//28
                                        pw.print("" + debiturIndividu.getKodeGol() + "|");//29
                                        pw.print("" + debiturIndividu.getStatus() + "|");//30
                                        pw.print("" + debiturIndividu.getNikPasangan() + "|");//31
                                        pw.print("" + debiturIndividu.getNamaPasangan() + "|");//32
                                        try{
                                            pw.print("" +Formater.formatDate(debiturIndividu.getTglLahirPasangan()  ,"yyyyMMdd")+ "|");//33
                                        }catch(Exception es){
                                             pw.print(" |");
                                        }
                                        pw.print("" + debiturIndividu.getPerjanjianPisahHarga() + "|");//34
                                        pw.print("" + debiturIndividu.getMelanggarBmpk() + "|");//35
                                        pw.print("" + debiturIndividu.getMelampauiBmpk() + "|");//36
                                        pw.print("" + debiturIndividu.getNamaIbuKandung() + "|");//37
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + debiturIndividu.getKodeKantorCabang() + "|");//38
                                        }
                                        
                                        
                                        String operasiData="";
                                        switch (debiturIndividu.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" +operasiData+ "");//39
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusDebiturPerOrangan("Proses Delimited Text : "+totalProses+"/"+totDebiturIndividu);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_PERORANGAN] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_PERORANGAN] + "|");
                                pw.print("" + vDebiturIndividu.size() + "|");
                                pw.print("" + totDebiturIndividu + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }

                    break;
                    
                case Configurasi.FLD_SEGMENT_DEBITUR_BADAN_USAHA:
                    
                    int totDebiturBadanUsaha = PstDebiturBdnUsaha.getCount(PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"' AND KODE_JENIS_NSB !=1 ");
                    totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vBadanUsaha = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where=where+"dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND ";
                                    }
                                   where=where + "KODE_JENIS_NSB !=1 AND "+PstDebiturBdnUsaha.fieldNames[PstDebiturBdnUsaha.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'" ;
                            vBadanUsaha = PstDebiturBdnUsaha.listJoinParentCabang(0, 0, "" + where, "");
                            if (vBadanUsaha.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_BADAN_USAHA] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_BADAN_USAHA] + "|");
                                pw.print("" + vBadanUsaha.size() + "|");
                                pw.print("" + totDebiturBadanUsaha + "");
                                pw.println();
                                for (int p = 0; p < vBadanUsaha.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        DebiturBdnUsaha  debiturBdnUsaha = (DebiturBdnUsaha) vBadanUsaha.get(p);
                                        //D    |NIKPENG1 |CIFBUDUMMY1|1          |Margo Joyo    |L              |JL Sujartijo no 123 Jakarta Timur|Grogol Utara|Grogol    |0117          |01              |100                |1               |001                 |C
                                        //flag | no iden | cif       | jenis idn | nama pemilik | jenis kelamin | alamat                          | kelurahan  |kecamatan |kode kab dati |kode jabatan    |pangsa pemilik     |status pengurus | kode kantor cabang | operasi data 
                                        //1    | 2       | 3         | 4         | 5            | 6             | 7                               |8           | 9        | 10           | 11             | 12                |13              | 14                 | 15                                                
                                        pw.print("" + debiturBdnUsaha.getFlagDetail() + "|");//1
                                        pw.print("" + debiturBdnUsaha.getCif() + "|");//2
                                        pw.print("" + debiturBdnUsaha.getNoIdentitas() + "|");//3
                                        pw.print("" + debiturBdnUsaha.getNama() + "|");//4
                                        pw.print("" + debiturBdnUsaha.getKodeJenis() + "|");//5
                                        pw.print("" + debiturBdnUsaha.getTempat() + "|");//6
                                        pw.print("" + debiturBdnUsaha.getNoAkte() + "|");//7
                                        
                                        try{
                                            if(debiturBdnUsaha.getTglAktePendirian()!=null){
                                                pw.print("" +Formater.formatDate(debiturBdnUsaha.getTglAktePendirian()  ,"yyyyMMdd")  + "|");//8
                                            }else{
                                                pw.print("|");
                                            }
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        
                                        pw.print("" + debiturBdnUsaha.getNoAktePerubahan() + "|");//9
                                        try{
                                            //pw.print("" + debiturBdnUsaha.getTglAktePerubahan() + "|");//10
                                            if(debiturBdnUsaha.getTglAktePerubahan()!=null){
                                                pw.print("" +Formater.formatDate(debiturBdnUsaha.getTglAktePerubahan()  ,"yyyyMMdd")  + "|");//8
                                            }else{
                                                pw.print("|");
                                            }
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + debiturBdnUsaha.getTelepon() + "|");//11
                                        pw.print("" + debiturBdnUsaha.getTeleponSeluler() + "|");//12
                                        pw.print("" + debiturBdnUsaha.getEmail() + "|");//13
                                        pw.print("" + debiturBdnUsaha.getAlamat() + "|");//14
                                        pw.print("" + debiturBdnUsaha.getKelurahan() + "|");//15
                                        pw.print("" + debiturBdnUsaha.getKecamatan() + "|");//16
                                        pw.print("" + debiturBdnUsaha.getKodeKab() + "|");//17
                                        pw.print("" + debiturBdnUsaha.getKodePos() + "|");//18
                                        pw.print("" + debiturBdnUsaha.getKodeNegara() + "|");//19
                                        pw.print("" + debiturBdnUsaha.getKodeBidangUsaha() + "|");//20
                                        pw.print("" + debiturBdnUsaha.getKodeHubLjk()+ "|");//21
                                        pw.print("" + debiturBdnUsaha.getMelanggarBmpk() + "|");//22
                                        pw.print("" + debiturBdnUsaha.getMelampauiBmpk() + "|");//23
                                        pw.print("" + debiturBdnUsaha.getGoPublic() + "|");//24
                                        pw.print("" + debiturBdnUsaha.getKodeGol() + "|");//25
                                        pw.print("" + debiturBdnUsaha.getPeringkat() + "|");//26
                                        pw.print("" + debiturBdnUsaha.getLembagaPemeringkat() + "|");//27
                                        
                                        try{
                                            if(debiturBdnUsaha.getTglPemeringkat()!=null){
                                                pw.print("" + Formater.formatDate(debiturBdnUsaha.getTglPemeringkat(),"yyyyMMdd") + "|");//28
                                            }else{
                                                pw.print("|");
                                            }
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        
                                        pw.print("" + debiturBdnUsaha.getNamaGroup() + "|");//29
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + debiturBdnUsaha.getKodeKtrCabang() + "|");//30
                                        }
//                                        String operasiData="";
//                                        if(debiturBdnUsaha.getStatusOperasiData()==0){
//                                            operasiData="C";
//                                        }else{
//                                            operasiData="U";
//                                        }
                                        String operasiData="";
                                        switch (debiturBdnUsaha.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" +operasiData+ "");//31
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusDebiturBadanUsaha("Proses Delimited Text : "+totalProses+"/"+totDebiturBadanUsaha);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_BADAN_USAHA] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DEBITUR_BADAN_USAHA] + "|");
                                pw.print("" + vBadanUsaha.size() + "|");
                                pw.print("" + totDebiturBadanUsaha + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;

                case Configurasi.FLD_SEGMENT_KREDIT:
                    totalProses=0;
                    int totKredit = PstKredit.getCount(PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vKredit = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where=where+"dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND ";
                                    }
                                    where=where+""+PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vKredit = PstKredit.listParentCabang(0, 0, "" + where, "");
                            if (vKredit.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT] + "|");
                                pw.print("" + vKredit.size() + "|");
                                pw.print("" + totKredit + "");
                                pw.println();
                                for (int p = 0; p < vKredit.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        Kredit kredit = (Kredit) vKredit.get(p);                                                                         
                                        pw.print("" + kredit.getFlagDetail() + "|");//1
                                        pw.print("" + kredit.getNoRekening()+ "|");//2
                                        pw.print("" + kredit.getCif() + "|");//3
                                        pw.print("" + kredit.getKodeSifat()+ "|");//4
                                        pw.print("" + kredit.getKodeJenisKredit()+ "|");//5
                                        pw.print("" + kredit.getKodeAkad()+ "|");//6
                                        pw.print("" + kredit.getNoAkadAwal()+ "|");//7
                                        String tglAkadAwal = "";
                                        if (kredit.getTglAkadAwal()!=null){
                                            tglAkadAwal = Formater.formatDate(kredit.getTglAkadAwal(),"yyyyMMdd");
                                        }
                                        pw.print("" +tglAkadAwal + "|");//8
                                        pw.print("" + kredit.getNoAkadAkhir()+ "|");//9
                                        String tglAkadAkhir ="";
                                        if (kredit.getTglAkadAkhir()!=null){
                                            tglAkadAkhir = Formater.formatDate(kredit.getTglAkadAkhir(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglAkadAkhir + "|");//10
                                        pw.print("" + kredit.getBaruPerpanjangan()+ "|");//11
                                        String tglAwal = "";
                                        if (kredit.getTglAwal()!=null){
                                            tglAwal = Formater.formatDate(kredit.getTglAwal(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglAwal + "|");//12
                                        String tglMulai = "";
                                        if (kredit.getTglMulai()!=null){
                                            tglMulai = Formater.formatDate(kredit.getTglMulai(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglMulai + "|");//13
                                        String tglTempo = "";
                                        if (kredit.getTglTempo()!=null){
                                            if(kredit.getKodeJenisKredit().equals("99")){
                                                tglTempo = "";
                                            }else{
                                                tglTempo = Formater.formatDate(kredit.getTglTempo(),"yyyyMMdd");
                                            }
                                        }
                                        pw.print("" + tglTempo+ "|");//14
                                        pw.print("" + kredit.getKodeKatDbitur()+ "|");//15
                                        pw.print("" + kredit.getKodeJenisPenggunaan()+ "|");//16
                                        pw.print("" + kredit.getKodeOrientasiPenggunaan()+ "|");//17
                                        pw.print("" + kredit.getKodeSektorEkonomi()+ "|");//18
                                        pw.print("" + kredit.getKodeKab()+ "|");//19
                                        
                                        if(kredit.getKodeJenisPenggunaan().equals("3")){
                                            pw.print("|");//20
                                        }else{
                                            pw.print("" + Formater.formatNumberNoDecimal(kredit.getNilai())+ "|");//20
                                        }
                                        
                                        pw.print("" + kredit.getKodeValuta()+ "|");//21
                                        pw.print("" + kredit.getProsentaseBunga()+ "|");//22
                                        pw.print("" + kredit.getJenisBunga()+ "|");//23
                                        pw.print("" + kredit.getKreditPemerintah()+ "|");//24
                                        pw.print("" + kredit.getTakeover()+ "|");//25
                                        pw.print("" + kredit.getSumberDana()+ "|");//26
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getPlafonAwal())+ "|");//27
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getPlafon())+ "|");//28
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getRealisasi())+ "|");//29
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getDenda())+ "|");//30
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getBakiDebet())+ "|");//31
                                        
                                        if(kredit.getKodeValuta().equals("IDR")){
                                            pw.print("|");//32
                                        }else{
                                            pw.print("" + Formater.formatNumberNoDecimal(kredit.getNilaiUangAsal())+ "|");//32
                                        }
                                        
                                        pw.print("" + kredit.getKodeKolektibilitas()+ "|");//33
                                        String tglMacet = "";
                                        if (kredit.getTglMacet()!=null){
                                            if(kredit.getKodeKolektibilitas().equals("5")){
                                                tglMacet = Formater.formatDate(kredit.getTglMacet(),"yyyyMMdd");
                                            }
                                        }
                                        pw.print("" + tglMacet + "|");//34
                                        if(kredit.getKodeKolektibilitas().equals("5")){
                                            pw.print(""+kredit.getKodeSebabMacet()+ "|");//35
                                        }else{
                                            pw.print(""+"|");//35
                                        }
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getTunggakanPokok())+ "|");//36
                                        pw.print("" + Formater.formatNumberNoDecimal(kredit.getTunggakanBunga())+ "|");//37
                                        pw.print("" + kredit.getJmlHariTunggakan()+ "|");//38
                                        pw.print("" + kredit.getFrekuensiTunggakan()+ "|");//39
                                        pw.print("" + kredit.getFrekuensiRestrukturisasi()+ "|");//40
                                        String tglRestrukturisasiAwal = "";
                                        if (kredit.getTglRestrukturisasiAwal()!=null){
                                            tglRestrukturisasiAwal = Formater.formatDate(kredit.getTglRestrukturisasiAwal(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglRestrukturisasiAwal + "|");//41
                                        pw.print("" + Formater.formatDate(kredit.getTglRestrukturisasiAkhir(),"yyyyMMdd")+ "|");//42
                                        pw.print("" + kredit.getKodeCara()+ "|");//43
                                        pw.print("" + kredit.getKodeKondisi()+ "|");//44
                                        String tglKondisi = "";
                                        if (kredit.getTglKondisi()!=null){
                                            if(kredit.getKodeKondisi().equals("")){
                                                tglKondisi = "";
                                            }else{
                                                tglKondisi = Formater.formatDate(kredit.getTglKondisi(),"yyyyMMdd");
                                            }
                                        }
                                        pw.print("" + tglKondisi + "|");//45
                                        pw.print("" + kredit.getKeterangan()+ "|");//46
                                        //pw.print("" + kredit.getKodeKantorCabang()+ "|");//47
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + kredit.getKodeKantorCabang() + "|");//47
                                        }
//                                        String operasiData="";
//                                        if(kredit.getStatusOperasiData()==0){
//                                            operasiData="C";
//                                        }else{
//                                            operasiData="U";
//                                        }

                                         //cek apakah fasilitas sudah lunas, kalau lunas ubah jadi delete
                                         //cek apaka
                                        try{
                                            String whereFasilitas = PstKredit.fieldNames[PstKredit.FLD_KODE_KONDISI]+" IN ('02','05','06') AND "
                                                                  +PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+"='"+kredit.getNoRekening()+"' AND "
                                                                  +PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                                           int statusData = PstKredit.getCount(whereFasilitas);
                                           if(statusData>0){
                                               long xxx = PstKredit.moveDataAgunanHapus(fileSent.getPeriodeId(),kredit.getNoRekening());
                                           }
                                        }catch(Exception ex){
                                        }

                                        String operasiData="";
                                        switch (kredit.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" +operasiData+ "");//48
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusKredit("Proses Delimited Text : "+totalProses+"/"+totKredit);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT] + "|");
                                pw.print("" + vKredit.size() + "|");
                                pw.print("" + totKredit + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;

                case Configurasi.FLD_SEGMENT_KREDIT_JOIN_ACCOUNT:
                     totalProses=0;
                     int totKreditJoinAccount = PstKreditJoinAccount.getCount(PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                     if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vKreditJoinAccount = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where=where+ " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND ";
                                    }
                                    where=where+ ""+PstKreditJoinAccount.fieldNames[PstKreditJoinAccount.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vKreditJoinAccount = PstKreditJoinAccount.list(0, 0, "" + where, "");
                            if (vKreditJoinAccount.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT_JOIN_ACCOUNT] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT_JOIN_ACCOUNT] + "|");
                                pw.print("" + vKreditJoinAccount.size() + "|");
                                pw.print("" + totKreditJoinAccount + "");
                                pw.println();
                                for (int p = 0; p < vKreditJoinAccount.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        KreditJoinAccount kreditJoinAccount = (KreditJoinAccount) vKreditJoinAccount.get(p);
                                        //D    |NIKPENG1 |CIFBUDUMMY1|1          |Margo Joyo    |L              |JL Sujartijo no 123 Jakarta Timur|Grogol Utara|Grogol    |0117          |01              |100                |1               |001                 |C
                                        //flag | no iden | cif       | jenis idn | nama pemilik | jenis kelamin | alamat                          | kelurahan  |kecamatan |kode kab dati |kode jabatan    |pangsa pemilik     |status pengurus | kode kantor cabang | operasi data 
                                        //1    | 2       | 3         | 4         | 5            | 6             | 7                               |8           | 9        | 10           | 11             | 12                |13              | 14                 | 15                                                
                                        pw.print("" + kreditJoinAccount.getFlagDetail() + "|");//1
                                        pw.print("" + kreditJoinAccount.getNoRekening() + "|");//2
                                        pw.print("" + kreditJoinAccount.getCif() + "|");//3
                                        pw.print("" + kreditJoinAccount.getSquenceDebJoin()  + "|");//4
                                        pw.print("" + kreditJoinAccount.getKodeSifat() + "|");//5
                                        pw.print("" + kreditJoinAccount.getKodeJenis() + "|");//6
                                        pw.print("" + kreditJoinAccount.getKodeAkad() + "|");//7
                                        pw.print("" + kreditJoinAccount.getNoAkadAwal() + "|");//8
                                        
                                        try{
                                            pw.print("" + Formater.formatDate(kreditJoinAccount.getTglAkadAwal(),"yyyyMMdd")  + "|");//9
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + Formater.formatDate(kreditJoinAccount.getNoAkadAkhir(),"yyyyMMdd")  + "|");//10
                                        try{
                                            pw.print("" +  Formater.formatDate(kreditJoinAccount.getTglAkadAkhir(),"yyyyMMdd")  + "|");//11
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + kreditJoinAccount.getBaruPerpanjangan() + "|");//12
                                        
                                        try{
                                            pw.print("" + Formater.formatDate(kreditJoinAccount.getTglAwalKredit(),"yyyyMMdd")   + "|");//13
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        try{
                                            pw.print("" + Formater.formatDate(kreditJoinAccount.getTglMulai(),"yyyyMMdd") + "|");//14
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        try{
                                            pw.print("" +  Formater.formatDate(kreditJoinAccount.getTglJatuhTempo(),"yyyyMMdd")  + "|");//15
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + kreditJoinAccount.getKodeKatDeb() + "|");//16
                                        pw.print("" + kreditJoinAccount.getKodeJenisPenggunaan() + "|");//17
                                        pw.print("" + kreditJoinAccount.getKodeOrientasiPenggunaan()+ "|");//18
                                        pw.print("" + kreditJoinAccount.getKodeSektorEkonomi() + "|");//19
                                        pw.print("" + kreditJoinAccount.getKodeKab() + "|");//20
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getNilaiProyek()) + "|");//21
                                        pw.print("" + kreditJoinAccount.getKodeValuta() + "|");//22
                                        pw.print("" + kreditJoinAccount.getProsentaseBunga() + "|");//23
                                        pw.print("" + kreditJoinAccount.getJenisBunga() + "|");//24
                                        pw.print("" + kreditJoinAccount.getKreditPrgPemerintah() + "|");//25
                                        pw.print("" + kreditJoinAccount.getTakeover() + "|");//26
                                        pw.print("" + kreditJoinAccount.getSumberDana() + "|");//27
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getPlafonAwal()) + "|");//28
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getPlafon()) + "|");//29
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getRealisasi())+ "|");//30
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getDenda()) + "|");//31
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getBakiDebet()) + "|");//32
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getNilaiUangAsal()) + "|");//33
                                        pw.print("" + kreditJoinAccount.getKodeKolektibilitas() + "|");//34
                                        try{
                                            pw.print("" + Formater.formatDate(kreditJoinAccount.getTglMacet(),"yyyyMMdd")    + "|");//35
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + kreditJoinAccount.getKodeSebabMacet() + "|");//36
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getTunggakanPokok()) + "|");//37
                                        pw.print("" + Formater.formatNumberNoDecimal(kreditJoinAccount.getTunggakanBunga()) + "|");//38
                                        pw.print("" + kreditJoinAccount.getJmlHariTunggakan() + "|");//39
                                        pw.print("" + kreditJoinAccount.getFrekuensiTunggakan() + "|");//40
                                        pw.print("" + kreditJoinAccount.getFrekuensiRestrukturisasi() + "|");//41
                                        try{
                                            pw.print("" +  Formater.formatDate(kreditJoinAccount.getTglRestrukturisasiAwal(),"yyyyMMdd")   + "|");//42
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        try{
                                            pw.print("" + Formater.formatDate(kreditJoinAccount.getTglRestruktirisasiAkhir(),"yyyyMMdd")  + "|");//43
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + kreditJoinAccount.getKodeCara() + "|");//44
                                        pw.print("" + kreditJoinAccount.getKodeKondisi() + "|");//45
                                        try{
                                            pw.print("" +  Formater.formatDate(kreditJoinAccount.getTglKondisi(),"yyyyMMdd")   + "|");//46
                                        }catch(Exception es){
                                            pw.print("|");
                                        }
                                        pw.print("" + kreditJoinAccount.getKeterangan() + "|");//47
                                        pw.print("" + kreditJoinAccount.getKodeKantorCabang() + "|");//48
                                        String operasiData="";
                                        switch (kreditJoinAccount.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" +operasiData+ "");//49
                                        
                                        pw.println();
                                        ManagerDilimitedText.setStatusKreditJoin("Proses Delimited Text : "+totalProses+"/"+totKreditJoinAccount);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT_JOIN_ACCOUNT] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_KREDIT_JOIN_ACCOUNT] + "|");
                                pw.print("" + vKreditJoinAccount.size() + "|");
                                pw.print("" + totKreditJoinAccount + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    break;

                case Configurasi.FLD_SEGMENT_SURAT_BERHARGA:
                    totalProses=0;
                    int totSuratBerharga = PstSuratBerharga.getCount(PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vSuratBerharga = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    where=where + " AND "+PstSuratBerharga.fieldNames[PstSuratBerharga.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vSuratBerharga = PstSuratBerharga.list(0, 0, "" + where, "");
                            if (vSuratBerharga.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SURAT_BERHARGA] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SURAT_BERHARGA] + "|");
                                pw.print("" + vSuratBerharga.size() + "|");
                                pw.print("" + totSuratBerharga + "");
                                pw.println();
                                for (int p = 0; p < vSuratBerharga.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        SuratBerharga suratBerharga = new SuratBerharga();
                                        suratBerharga = (SuratBerharga) vSuratBerharga.get(p);
                                        pw.print("" + suratBerharga.getFlagDetail() + "|");//1
                                        pw.print("" + suratBerharga.getNoRekening()+ "|");//2
                                        pw.print("" + suratBerharga.getCif()+ "|");//3
                                        pw.print("" + suratBerharga.getKodeJenis()+ "|");//4
                                        pw.print("" + suratBerharga.getSovereignRate()+ "|");//5
                                        pw.print("" + suratBerharga.getListing()+ "|");//6
                                        pw.print("" + suratBerharga.getPeringkat()+ "|");//7
                                        pw.print("" + suratBerharga.getKodeTujuan()+ "|");//8
                                        String tglTerbit = "";
                                        if (suratBerharga.getTglTerbit()!=null){
                                            tglTerbit = Formater.formatDate(suratBerharga.getTglTerbit(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglTerbit+ "|");//9
                                        String tglBeli = "";
                                        if (suratBerharga.getTglBeli()!=null){
                                            tglBeli = Formater.formatDate(suratBerharga.getTglBeli(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglBeli+ "|");//10
                                        String tglJatuhTempo = "";
                                        if (suratBerharga.getTglJatuhTempo()!=null){
                                            tglJatuhTempo = Formater.formatDate(suratBerharga.getTglJatuhTempo(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglJatuhTempo+ "|");//11
                                        pw.print("" + suratBerharga.getKodeValuta()+ "|");//12
                                        pw.print("" + Formater.formatNumberNoDecimal(suratBerharga.getNominal())+ "|");//13
                                        pw.print("" + Formater.formatNumberNoDecimal(suratBerharga.getNilaiUangAsal())+ "|");//14
                                        pw.print("" + Formater.formatNumberNoDecimal(suratBerharga.getNilaiPasar())+ "|");//15
                                        pw.print("" + Formater.formatNumberNoDecimal(suratBerharga.getNilaiPerolehan())+ "|");//16
                                        pw.print("" + suratBerharga.getSukuBunga()+ "|");//17
                                        pw.print("" + Formater.formatNumberNoDecimal(suratBerharga.getTunggakan())+ "|");//18
                                        pw.print("" + suratBerharga.getJmlHariTunggakan()+ "|");//19
                                        pw.print("" + suratBerharga.getKodeKolektibilitas()+ "|");//20
                                        String tglMacet = "";
                                        if (suratBerharga.getTglMacet()!=null){
                                            tglMacet = Formater.formatDate(suratBerharga.getTglMacet(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglMacet + "|");//21
                                        pw.print("" + suratBerharga.getKodeSebabMacet()+ "|");//22
                                        pw.print("" + suratBerharga.getKodeKondisi()+ "|");//23
                                        String tglKondisi = "";
                                        if (suratBerharga.getTglKondisi()!=null){
                                            tglKondisi = Formater.formatDate(suratBerharga.getTglKondisi(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglKondisi + "|");//24
                                        pw.print("" + suratBerharga.getKeterangan()+ "|");//25
                                        pw.print("" + suratBerharga.getKodeKantorCabang()+ "|");//26
                                        //pw.print("" + suratBerharga.getOperasiData() + "");//27
                                        String operasiData="";
                                        switch (suratBerharga.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        
                                        pw.print("" +operasiData+ "");//28
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusSuratBerharga("Proses Delimited Text : "+totalProses+"/"+totSuratBerharga);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SURAT_BERHARGA] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SURAT_BERHARGA] + "|");
                                pw.print("" + vSuratBerharga.size() + "|");
                                pw.print("" + totSuratBerharga + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;
                case Configurasi.FLD_SEGMENT_IRREVOCABLE_LC:
                    totalProses=0;
                    int totIrrLc = PstIrrevocableLc.getCount(PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vIrrevocable = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    where=where+ ""+PstIrrevocableLc.fieldNames[PstIrrevocableLc.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vIrrevocable = PstIrrevocableLc.list(0, 0, "" + where, "");
                            if (vIrrevocable.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_IRREVOCABLE_LC] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_IRREVOCABLE_LC] + "|");
                                pw.print("" + vIrrevocable.size() + "|");
                                pw.print("" + totIrrLc + "");
                                pw.println();
                                for (int p = 0; p < vIrrevocable.size(); p++) {
                                    try {

                                        IrrevocableLc irrevocableLc = (IrrevocableLc) vIrrevocable.get(p);
                                        totalProses=totalProses+1;                                                                         
                                        pw.print("" + irrevocableLc.getFlagDetail() + "|");//1
                                        pw.print("" + irrevocableLc.getNoRekening()+ "|");//2
                                        pw.print("" + irrevocableLc.getCif() + "|");//3
                                        pw.print("" + irrevocableLc.getKodeJenis()+ "|");//4
                                        pw.print("" + irrevocableLc.getKodeTujuan()+ "|");//5
                                        String tglKeluar= "";
                                        if (irrevocableLc.getTglKeluar()!=null){
                                            tglKeluar = Formater.formatDate(irrevocableLc.getTglKeluar(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglKeluar+ "|");//6
                                        String tglJatuhTempo = "";
                                        if (irrevocableLc.getTglJatuhTempo()!=null){
                                            tglJatuhTempo = Formater.formatDate(irrevocableLc.getTglJatuhTempo(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglJatuhTempo + "|");//7
                                        pw.print("" + irrevocableLc.getNoAkadAwal()+ "|");//8
                                        String tglAkadAwal = "";
                                        if (irrevocableLc.getTglAkadAwal()!=null){
                                            tglAkadAwal = Formater.formatDate(irrevocableLc.getTglAkadAwal(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglAkadAwal + "|");//9
                                        pw.print("" + irrevocableLc.getNoAkadAkhr()+ "|");//10
                                        String tglAkadAkhir = "";
                                        if (irrevocableLc.getTglAkadAkhir()!=null){
                                            tglAkadAkhir = Formater.formatDate(irrevocableLc.getTglAkadAkhir(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglAkadAkhir+ "|");//11
                                        pw.print("" + irrevocableLc.getBankCounterparty()+ "|");//12
                                        pw.print("" + irrevocableLc.getKodeValuta()+ "|");//13
                                        pw.print("" + Formater.formatNumberNoDecimal(irrevocableLc.getPlafon())+ "|");//14
                                        pw.print("" + Formater.formatNumberNoDecimal(irrevocableLc.getNominal())+ "|");//15
                                        pw.print("" + Formater.formatNumberNoDecimal(irrevocableLc.getSetoranJaminan())+ "|");//16
                                        pw.print("" + irrevocableLc.getKodeKolektibilitas()+ "|");//17
                                        String tglWanPrestasi = "";
                                        if (irrevocableLc.getTglWanPrestasi()!=null){
                                            tglWanPrestasi = Formater.formatDate(irrevocableLc.getTglWanPrestasi(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglWanPrestasi + "|");//18
                                        pw.print("" + irrevocableLc.getKodeKondisi()+ "|");//19
                                        String tglKondisi = "";
                                        if (irrevocableLc.getTglKondisi()!=null){
                                            tglKondisi = Formater.formatDate(irrevocableLc.getTglKondisi(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglKondisi + "|");//20
                                        pw.print("" + irrevocableLc.getKeterangan()+ "|");//21
                                        pw.print("" + irrevocableLc.getKodeKantorCabang()+ "|");//22
                                        //pw.print("" + irrevocableLc.getOperasiData()+ "");
                                        
                                        String operasiData="";
                                        switch (irrevocableLc.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//23
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusIrrevocable("Proses Delimited Text : "+totalProses+"/"+totIrrLc);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_IRREVOCABLE_LC] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_IRREVOCABLE_LC] + "|");
                                pw.print("" + vIrrevocable.size() + "|");
                                pw.print("" + totIrrLc + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;

                case Configurasi.FLD_SEGMENT_BANK_GARANSI:
                    int totBankGaransi = PstBankGaransi.getCount(PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vBankGaransi = new Vector();
                            String where = " ";
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    //+ "dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND "
                                    where=where + ""+PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vBankGaransi = PstBankGaransi.listJoinParentCabang(0, 0, "" + where, "");
                            if (vBankGaransi.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_BANK_GARANSI] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");//1
                                pw.print("" + outletConnection.getJenisLJK() + "|");//2
                                pw.print("" + outletConnection.getKodeLJK() + "|");//3
                                pw.print("" + fileSent.getTahun() + "|");//4
                                pw.print("" + fileSent.getBulan() + "|");//5
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_BANK_GARANSI] + "|");//
                                pw.print("" + vBankGaransi.size() + "|");
                                pw.print("" + totBankGaransi + "");
                                pw.println();
                                for (int p = 0; p < vBankGaransi.size(); p++) {
                                    try {

                                        BankGaransi bankGaransi = (BankGaransi) vBankGaransi.get(p);
                                        totalProses=totalProses+1;                                           
                                        pw.print("" + bankGaransi.getFlagDetail() + "|");//1
                                        pw.print("" + bankGaransi.getNoRekening() + "|");//2
                                        pw.print("" + bankGaransi.getCif() + "|");//3
                                        pw.print("" + bankGaransi.getKodeJenisGaransi() + "|");//4
                                        pw.print("" + bankGaransi.getKodeTujuanGaransi() + "|");//5
                                        
                                        try{
                                            pw.print("" +  Formater.formatDate(bankGaransi.getTglDiterbitkan() ,"yyyyMMdd") + "|");//6
                                        }catch(Exception es){
                                            pw.print(" |");
                                        }
                                        try{
                                            pw.print("" + Formater.formatDate(bankGaransi.getTglJatuhTempo(),"yyyyMMdd")   + "|");//7
                                        }catch(Exception es){
                                            pw.print(" |");
                                        }
                                        
                                        pw.print("" + bankGaransi.getNoAkadAwal() + "|");//8
                                        
                                        try{
                                            pw.print("" + Formater.formatDate( bankGaransi.getTglAkadAwal(),"yyyyMMdd")   + "|");//9
                                        }catch(Exception es){
                                            pw.print(" | ");
                                        }
                                        pw.print("" +bankGaransi.getNoAkadAkhir()+ "|");//10
                                        
                                        try{
                                           pw.print("" + Formater.formatDate( bankGaransi.getTglAkadAkhir() ,"yyyyMMdd") + "|");//11
                                        }catch(Exception es){
                                            pw.print(" |");
                                        }
                                        pw.print("" + bankGaransi.getNamaYgDijamin() + "|");//12
                                        pw.print("" + bankGaransi.getKodeValuta() + "|");//13
                                        pw.print("" + Formater.formatNumberNoDecimal(bankGaransi.getPlafon()) + "|");//14
                                        pw.print("" + Formater.formatNumberNoDecimal(bankGaransi.getNominal()) + "|");//15
                                        pw.print("" + Formater.formatNumberNoDecimal(bankGaransi.getSetoranJaminan()) + "|");//16
                                        pw.print("" + bankGaransi.getKodeKolektibilitas() + "|");//17
                                        try{
                                           pw.print("" + Formater.formatDate(bankGaransi.getTglWanPrestasi() ,"yyyyMMdd")  + "|");//18
                                        }catch(Exception es){
                                            pw.print(" |");
                                        }
                                        pw.print("" + bankGaransi.getKodeKondisi() + "|");//19
                                        try{
                                           String tglKondisi = Formater.formatDate(bankGaransi.getTglKondisi() ,"yyyyMMdd");
                                           if(!bankGaransi.getKodeKondisi().equals("00")){
                                               pw.print("" + tglKondisi + "|");//20
                                           }else{
                                               pw.print("|");//20
                                           }
                                        }catch(Exception es){
                                            pw.print(" |");
                                        }
                                        pw.print("" + bankGaransi.getKeterangan() + "|");//21
                                        //pw.print("" + bankGaransi.getKodeKantorCabang() + "|");//22
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + bankGaransi.getKodeKantorCabang() + "|");//22
                                        }
//                                        String  operasiData="";
//                                        if(bankGaransi.getStatusOperasiData()==0){
//                                            operasiData="C";
//                                        }else{
//                                            operasiData="U";
//                                        }
                                        String operasiData="";
                                        switch (bankGaransi.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//23
                                        
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusBankGaransi("Proses Delimited Text : "+totalProses+"/"+totBankGaransi);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_BANK_GARANSI] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_BANK_GARANSI] + "|");
                                pw.print("" + vBankGaransi.size() + "|");
                                pw.print("" + totBankGaransi + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;

                case Configurasi.FLD_SEGMENT_FASILITAS_LAINNYA:
                    totalProses=0;
                    int totFasilitasLain = PstFasilitasLain.getCount(PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vFasilitasLainnya = new Vector();
                            String where = "";
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    //+ "dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND "
                                    where=where + ""+PstFasilitasLain.fieldNames[PstFasilitasLain.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vFasilitasLainnya = PstFasilitasLain.list(0, 0, "" + where, "");
                            if (vFasilitasLainnya.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_FASILITAS_LAINNYA] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_FASILITAS_LAINNYA] + "|");
                                pw.print("" + vFasilitasLainnya.size() + "|");
                                pw.print("" + totFasilitasLain + "");
                                pw.println();
                                for (int p = 0; p < vFasilitasLainnya.size(); p++) {
                                    try {

                                        FasilitasLain fasilitasLain = (FasilitasLain) vFasilitasLainnya.get(p);
                                        totalProses=totalProses+1;                                               
                                        pw.print("" + fasilitasLain.getFlagDetail() + "|");//1
                                        pw.print("" + fasilitasLain.getNoRekening()+ "|");//2
                                        pw.print("" + fasilitasLain.getCif() + "|");//3
                                        pw.print("" + fasilitasLain.getKodeJenisFasilitas()+ "|");//4
                                        pw.print("" + fasilitasLain.getSumberDana()+ "|");//5
                                        String tglMulai = "";
                                        if (fasilitasLain.getTglMulai()!=null){
                                            tglMulai = Formater.formatDate(fasilitasLain.getTglMulai(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglMulai + "|");//6
                                        String tglJatuhTempo = "";
                                        if (fasilitasLain.getTglJatuhTempo()!=null){
                                            tglJatuhTempo = Formater.formatDate(fasilitasLain.getTglJatuhTempo(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglJatuhTempo + "|");//7
                                        pw.print("" + fasilitasLain.getSukuBunga()+ "|");//8
                                        pw.print("" + fasilitasLain.getKodeValuta()+ "|");//9
                                        pw.print("" + Formater.formatNumberNoDecimal(fasilitasLain.getNominalJmlKewajiban())+ "|");//10
                                        pw.print("" + Formater.formatNumberNoDecimal(fasilitasLain.getNilaiMataUangAsal())+ "|");//11
                                        pw.print("" + fasilitasLain.getKodeKolektibilitas()+ "|");//12
                                        String tglMacet = "";
                                        if (fasilitasLain.getTglMacet()!=null){
                                            tglMacet = Formater.formatDate(fasilitasLain.getTglMacet(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglMacet + "|");//13
                                        pw.print("" + fasilitasLain.getKodeSebabMacet()+ "|");//14
                                        pw.print("" + Formater.formatNumberNoDecimal(fasilitasLain.getTunggakan())+ "|");//15
                                        pw.print("" + fasilitasLain.getJmlHariTunggakan()+ "|");//16
                                        pw.print("" + fasilitasLain.getKodeKondisi()+ "|");//17
                                        String tglKondisi = "";
                                        if (fasilitasLain.getTglKondisi()!=null){
                                            tglKondisi = Formater.formatDate(fasilitasLain.getTglKondisi(),"yyyyMMdd");
                                        }
                                        pw.print("" + tglKondisi + "|");//18
                                        pw.print("" + fasilitasLain.getKeterangan()+ "|");//19
                                        pw.print("" + fasilitasLain.getKodeKantorCabang()+ "|");//20
                                        //pw.print("" + fasilitasLain.getOperasiData() + "|");//21
                                        
//                                        String  operasiData="";
//                                        if(fasilitasLain.getStatusOperasiData()==0){
//                                            operasiData="C";
//                                        }else{
//                                            operasiData="U";
//                                        }
                                        String operasiData="";
                                        switch (fasilitasLain.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//23
                                        
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusFasilitasLainnya("Proses Delimited Text : "+totalProses+"/"+totFasilitasLain);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_FASILITAS_LAINNYA] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_FASILITAS_LAINNYA] + "|");
                                pw.print("" + vFasilitasLainnya.size() + "|");
                                pw.print("" + totFasilitasLain + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;

                case Configurasi.FLD_SEGMENT_DATA_AGUNAN:
                    int totAgunan = PstAgunan.getCount(PstAgunan.fieldNames[PstAgunan.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    int totAgunanHapus = 0;//PstAgunan.getCount("PERIODE_ID='"+fileSent.getPeriodeId()+"'");
                    totAgunan=totAgunan+totAgunanHapus;
                    totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vDataAgunan = new Vector();
                            String where = " ";
                            if(perCabang==0){
                                where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                            }
                            //+ " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND "
                            where=where + ""+PstAgunan.fieldNames[PstAgunan.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vDataAgunan = PstAgunan.listJoinParentCabang(0, 0, "" + where, "");
                            
                            //cek list data agunan yg sudah lunas
                            String whereHapusKarenaLunas = " ";
                            Vector vDataAgunanLunas = new Vector();
                            whereHapusKarenaLunas=whereHapusKarenaLunas + "dslik_agunan."+PstAgunan.fieldNames[PstAgunan.FLD_PERIODE_ID]+"='"+prevPeriodeId+"'";
                            vDataAgunanLunas = new Vector();//PstAgunan.listJoinParentCabangAgunanHapus(0, 0, "" + whereHapusKarenaLunas, "");
                            if(vDataAgunanLunas!=null){
                                if(vDataAgunanLunas.size()>0){
                                    totAgunanHapus=vDataAgunanLunas.size();
                                }
                            }
                            totAgunan=totAgunan+totAgunanHapus;
                            if (vDataAgunan.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DATA_AGUNAN] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");//0
                                pw.print("" + outletConnection.getJenisLJK() + "|");//1
                                pw.print("" + outletConnection.getKodeLJK() + "|");//2
                                pw.print("" + fileSent.getTahun() + "|");//3
                                pw.print("" + fileSent.getBulan() + "|");//4
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DATA_AGUNAN] + "|");//5
                                pw.print("" + totAgunan+ "|");//6
                                pw.print("" + totAgunan + "");//7
                                pw.println();
                                //data bulan pelaporan
                                for (int p = 0; p < vDataAgunan.size(); p++) {
                                    try {

                                        Agunan agunan = (Agunan) vDataAgunan.get(p);
                                        totalProses=totalProses+1;                                             
                                        pw.print("" + agunan.getFlagDetail() + "|");//1
                                        pw.print("" + agunan.getKodeRegisterAgunan()+ "|");//2
                                        pw.print("" + agunan.getNoRekening()+ "|");//3
                                        pw.print("" + agunan.getCif()+ "|");//4
                                        pw.print("F01|");//5
                                        pw.print("" + agunan.getKodeStatusAgunan()+ "|");//6
                                        pw.print("" + agunan.getKodeJenisAgunan()+ "|");//7
                                        pw.print("" + agunan.getPeringkatAgunan()+ "|");//8
                                        pw.print("" + agunan.getKodeLembagaPemeringkat()+ "|");//9
                                        if(agunan.getKodeStatusAgunan().equals("1")){
                                            pw.print("" + agunan.getKodeJenisPengikatan()+ "|");//10
                                        }else{
                                            pw.print("|");//10
                                        }
                                        String tglPengikatan = "";
                                        if (agunan.getTglPengikatan()!=null){
                                            tglPengikatan = Formater.formatDate(agunan.getTglPengikatan(),"yyyyMMdd");
                                        }
                                        
                                        pw.print("" + tglPengikatan + "|");//11
                                        pw.print("" + agunan.getNamaPemilikAgunan()+ "|");//12
                                        pw.print("" + agunan.getBuktiKepemilikan()+ "|");//13
                                        pw.print("" + agunan.getAlamatAgunan()+ "|");//14
                                        pw.print("" + agunan.getKodeKabLokasiAgunan()+ "|");//15
                                        
                                        if(agunan.getKodeStatusAgunan().equals("1")){
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getNilaiAgunanNjop())+ "|");//16
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getNilaiAgunanLjk())+ "|");//17
                                        }else{
                                            pw.print("|");//16
                                            pw.print("|");//17
                                        }
                                        
                                        String tglPenilaianLjk = "";
                                        if (agunan.getTglPenilaianLjk()!=null){
                                            tglPenilaianLjk = Formater.formatDate(agunan.getTglPenilaianLjk(),"yyyyMMdd");
                                        }
                                        if(agunan.getKodeStatusAgunan().equals("1")){
                                            pw.print("" + tglPenilaianLjk+ "|");//18
                                        }else{
                                            pw.print("|");//18
                                        }
                                        
                                        if(agunan.getNilaiAguPenilaiIndep()==0){
                                            pw.print("|");//19
                                            pw.print("|");//20
                                        }else{
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getNilaiAguPenilaiIndep())+ "|");//19
                                            pw.print("" + agunan.getNamaPenilaiIndep()+ "|");//20
                                        }
                                        
                                        String tglPenilaianPenilaiIndep = "";
                                        if (agunan.getTglPenilaianPenilaiIndep()!=null){
                                            tglPenilaianPenilaiIndep = Formater.formatDate(agunan.getTglPenilaianPenilaiIndep(),"yyyyMMdd");
                                        }
                                        if(agunan.getKodeStatusAgunan().equals("2")){
                                            pw.print("|");//21
                                        }else{
                                            if(agunan.getNilaiAguPenilaiIndep()==0){
                                                pw.print("|");//21
                                            }else{
                                                pw.print("" + tglPenilaianPenilaiIndep + "|");//21
                                            }
                                        }
                                        
                                        //disini di cek apakah
                                        boolean paripasu = PstAgunan.checkParipasu(fileSent.getPeriodeId(), agunan.getKodeRegisterAgunan());
                                        if(paripasu){
                                            agunan.setStatusParipasu("Y");
                                        }else{
                                            agunan.setStatusParipasu("T");
                                        }
                                        
                                        pw.print("" + agunan.getStatusParipasu()+ "|");//22
                                        if(agunan.getStatusParipasu().equals("Y")){
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getProsentaseParipasu())+ "|");//23
                                        }else{
                                            pw.print("|");//23
                                        }
                                        pw.print("" + agunan.getStatusKreditJoin()+ "|");//24
                                        pw.print("" + agunan.getDiasuransikan()+ "|");//25
                                        pw.print("" + agunan.getKeterangan()+ "|");//26
                                        //pw.print("" + agunan.getKodeKantorCabang() + "|");//27
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + agunan.getKodeKantorCabang() + "|");//27
                                        }
                                        String operasiData="";
                                        if(agunan.getStatusOperasiData()!=0){
                                            //cek apakah fasilitas sudah lunas, kalau lunas ubah jadi delete
                                            String whereFasilitas = PstKredit.fieldNames[PstKredit.FLD_KODE_KONDISI]+" IN ('02','05','06') AND "
                                                                   +PstKredit.fieldNames[PstKredit.FLD_NO_REKENING]+"='"+agunan.getNoRekening()+"' AND "
                                                                   +PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                                            int statusData = PstKredit.getCount(whereFasilitas);
                                            if(statusData>0){
                                                agunan.setStatusOperasiData(3);
                                            }
                                        }
                                        switch (agunan.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            case 2:
                                                operasiData="N";
                                                break;    
                                            default :
                                                operasiData="D";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//28
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusDataAgunan("Proses Delimited Text : "+totalProses+"/"+totAgunan);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                
                                //data yang di hapus karena sudah lunas
                                for (int p = 0; p < vDataAgunanLunas.size(); p++) {
                                    try {
                                        Agunan agunan = (Agunan) vDataAgunanLunas.get(p);
                                        totalProses=totalProses+1;                                             
                                        pw.print("" + agunan.getFlagDetail() + "|");//1
                                        pw.print("" + agunan.getKodeRegisterAgunan()+ "|");//2
                                        pw.print("" + agunan.getNoRekening()+ "|");//3
                                        pw.print("" + agunan.getCif()+ "|");//4
                                        pw.print("F01|");//5
                                        pw.print("" + agunan.getKodeStatusAgunan()+ "|");//6
                                        pw.print("" + agunan.getKodeJenisAgunan()+ "|");//7
                                        pw.print("" + agunan.getPeringkatAgunan()+ "|");//8
                                        pw.print("" + agunan.getKodeLembagaPemeringkat()+ "|");//9
                                        if(agunan.getKodeStatusAgunan().equals("1")){
                                            pw.print("" + agunan.getKodeJenisPengikatan()+ "|");//10
                                        }else{
                                            pw.print("|");//10
                                        }
                                        String tglPengikatan = "";
                                        if (agunan.getTglPengikatan()!=null){
                                            tglPengikatan = Formater.formatDate(agunan.getTglPengikatan(),"yyyyMMdd");
                                        }
                                        
                                        pw.print("" + tglPengikatan + "|");//11
                                        pw.print("" + agunan.getNamaPemilikAgunan()+ "|");//12
                                        pw.print("" + agunan.getBuktiKepemilikan()+ "|");//13
                                        pw.print("" + agunan.getAlamatAgunan()+ "|");//14
                                        pw.print("" + agunan.getKodeKabLokasiAgunan()+ "|");//15
                                        
                                        if(agunan.getKodeStatusAgunan().equals("1")){
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getNilaiAgunanNjop())+ "|");//16
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getNilaiAgunanLjk())+ "|");//17
                                        }else{
                                            pw.print("|");//16
                                            pw.print("|");//17
                                        }
                                        
                                        String tglPenilaianLjk = "";
                                        if (agunan.getTglPenilaianLjk()!=null){
                                            tglPenilaianLjk = Formater.formatDate(agunan.getTglPenilaianLjk(),"yyyyMMdd");
                                        }
                                        if(agunan.getKodeStatusAgunan().equals("1")){
                                            pw.print("" + tglPenilaianLjk+ "|");//18
                                        }else{
                                            pw.print("|");//18
                                        }
                                        
                                        if(agunan.getNilaiAguPenilaiIndep()==0){
                                            pw.print("|");//19
                                            pw.print("|");//20
                                        }else{
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getNilaiAguPenilaiIndep())+ "|");//19
                                            pw.print("" + agunan.getNamaPenilaiIndep()+ "|");//20
                                        }
                                        
                                        String tglPenilaianPenilaiIndep = "";
                                        if (agunan.getTglPenilaianPenilaiIndep()!=null){
                                            tglPenilaianPenilaiIndep = Formater.formatDate(agunan.getTglPenilaianPenilaiIndep(),"yyyyMMdd");
                                        }
                                        if(agunan.getKodeStatusAgunan().equals("2")){
                                            pw.print("|");//21
                                        }else{
                                            if(agunan.getNilaiAguPenilaiIndep()==0){
                                                pw.print("|");//21
                                            }else{
                                                pw.print("" + tglPenilaianPenilaiIndep + "|");//21
                                            }
                                        }
                                        
                                        //disini di cek apakah
                                        boolean paripasu = PstAgunan.checkParipasu(fileSent.getPeriodeId(), agunan.getKodeRegisterAgunan());
                                        if(paripasu){
                                            agunan.setStatusParipasu("Y");
                                        }else{
                                            agunan.setStatusParipasu("T");
                                        }
                                        
                                        pw.print("" + agunan.getStatusParipasu()+ "|");//22
                                        if(agunan.getStatusParipasu().equals("Y")){
                                            pw.print("" + Formater.formatNumberNoDecimal(agunan.getProsentaseParipasu())+ "|");//23
                                        }else{
                                            pw.print("|");//23
                                        }
                                        pw.print("" + agunan.getStatusKreditJoin()+ "|");//24
                                        pw.print("" + agunan.getDiasuransikan()+ "|");//25
                                        pw.print("" + agunan.getKeterangan()+ "|");//26
                                        //pw.print("" + agunan.getKodeKantorCabang() + "|");//27
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + agunan.getKodeKantorCabang() + "|");//27
                                        }
                                        String operasiData="";
                                        agunan.setStatusOperasiData(3);
                                        switch (agunan.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            case 2:
                                                operasiData="N";
                                                break;    
                                            default :
                                                operasiData="D";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//28
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusDataAgunan("Proses Delimited Text : "+totalProses+"/"+totAgunan);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DATA_AGUNAN] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_DATA_AGUNAN] + "|");
                                pw.print("" + vDataAgunan.size() + "|");
                                pw.print("" + totAgunan + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;

                case Configurasi.FLD_SEGMENT_PENJAMIN:
                    int totPenjamin = PstPenjamin.getCount(PstPenjamin.fieldNames[PstPenjamin.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vPenjamin = new Vector();
                            String where = " ";
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    //+ " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' "
                                    where=where + " AND "+PstPenjamin.fieldNames[PstPenjamin.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vPenjamin = PstPenjamin.list(0, 0, "" + where, "");
                            if (vPenjamin.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENJAMIN] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENJAMIN] + "|");
                                pw.print("" + vPenjamin.size() + "|");
                                pw.print("" + totPenjamin + "");
                                pw.println();
                                for (int p = 0; p < vPenjamin.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        Penjamin penjamin = (Penjamin) vPenjamin.get(p);
                                        //D    |NIKPENG1 |CIFBUDUMMY1|1          |Margo Joyo    |L              |JL Sujartijo no 123 Jakarta Timur|Grogol Utara|Grogol    |0117          |01              |100                |1               |001                 |C
                                        //flag | no iden | cif       | jenis idn | nama pemilik | jenis kelamin | alamat                          | kelurahan  |kecamatan |kode kab dati |kode jabatan    |pangsa pemilik     |status pengurus | kode kantor cabang | operasi data 
                                        //1    | 2       | 3         | 4         | 5            | 6             | 7                               |8           | 9        | 10           | 11             | 12                |13              | 14                 | 15                                                
                                        pw.print("" + penjamin.getFlagDetail() + "|");//1
                                        pw.print("" + penjamin.getNoIdPenjamin() + "|");//2
                                        pw.print("" + penjamin.getNoRekening() + "|");//3
                                        pw.print("" + penjamin.getCif() + "|");//4
                                        pw.print("" + penjamin.getJenisIdentitas() + "|");//5
                                        pw.print("" + penjamin.getNamaIdentitas() + "|");//6
                                        pw.print("" + penjamin.getNamaLengkap() + "|");//7
                                        pw.print("" + penjamin.getKodeGolPenjamin() + "|");//8
                                        pw.print("" + penjamin.getAlamatPenjamin() + "|");//9
                                        pw.print("" + penjamin.getProsentaseDijamin() + "|");//10
                                        pw.print("" + penjamin.getKeterangan() + "|");//11
                                        pw.print("" + penjamin.getKodeKantorCabang() + "|");//12
                                        //pw.print("" + penjamin.getOperasiData() + "|");
                                        
                                        String operasiData="";
                                        switch (penjamin.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//23
                                        
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusPenjamin("Proses Delimited Text : "+totalProses+"/"+totPenjamin);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENJAMIN] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENJAMIN] + "|");
                                pw.print("" + vPenjamin.size() + "|");
                                pw.print("" + totPenjamin + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    break;

                case Configurasi.FLD_SEGMENT_PENGURUS_PEMILIK:
                    int totPengurusPemilik = PstPengurusAtauPemilik.getCount(PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;
                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vPengurusPemilik = new Vector();
                            String where = " ";
                                    //+ " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND "
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    where=where + " "+PstPengurusAtauPemilik.fieldNames[PstPengurusAtauPemilik.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vPengurusPemilik = PstPengurusAtauPemilik.listJoinParentCabang(0, 0, "" + where, "");
                            if (vPengurusPemilik.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENGURUS_PEMILIK] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENGURUS_PEMILIK] + "|");
                                pw.print("" + vPengurusPemilik.size() + "|");
                                pw.print("" + totPengurusPemilik + "");
                                pw.println();
                                for (int p = 0; p < vPengurusPemilik.size(); p++) {
                                    try {
                                        totalProses=totalProses+1;
                                        PengurusAtauPemilik pengurusPemilik = (PengurusAtauPemilik) vPengurusPemilik.get(p);
                                        //D    |NIKPENG1 |CIFBUDUMMY1|1          |Margo Joyo    |L              |JL Sujartijo no 123 Jakarta Timur|Grogol Utara|Grogol    |0117          |01              |100                |1               |001                 |C
                                        //flag | no iden | cif       | jenis idn | nama pemilik | jenis kelamin | alamat                          | kelurahan  |kecamatan |kode kab dati |kode jabatan    |pangsa pemilik     |status pengurus | kode kantor cabang | operasi data 
                                        //1    | 2       | 3         | 4         | 5            | 6             | 7                               |8           | 9        | 10           | 11             | 12                |13              | 14                 | 15                                                
                                        pw.print("" + pengurusPemilik.getFlagDetail() + "|");//1
                                        pw.print("" + pengurusPemilik.getNoIdentitas() + "|");//2
                                        pw.print("" + pengurusPemilik.getCif() + "|");//3
                                        pw.print("" + pengurusPemilik.getJenisIdentitas() + "|");//4
                                        pw.print("" + pengurusPemilik.getNamaPengurus() + "|");//5
                                        pw.print("" + pengurusPemilik.getJenisKelamin() + "|");//6
                                        pw.print("" + pengurusPemilik.getAlamat() + "|");//7
                                        pw.print("" + pengurusPemilik.getKelurahan() + "|");//8
                                        pw.print("" + pengurusPemilik.getKecamatan() + "|");//9
                                        pw.print("" + pengurusPemilik.getKodeKabupaten() + "|");//10
                                        pw.print("" + pengurusPemilik.getKodeJabatan() + "|");//11
                                        
                                        //harus decimal
                                        try{
                                            double angka2 = Double.valueOf(pengurusPemilik.getPangsaKepemilikan());
                                            pw.print("" + Formater.formatNumberNoDecimal(angka2) + "|");//11
                                        }catch(Exception ex){
                                            pw.print("0|");//11
                                        }
                                        
                                        pw.print("" + pengurusPemilik.getStatusPengurus() + "|");//13
                                        if(ujiCoba){
                                            pw.print("001|");//38
                                        }else{
                                            pw.print("" + pengurusPemilik.getKodeKantorCabang() + "|");//14
                                        }
                                        //pw.print("" + fileSent.getOperasiData() + "|");
                                        
                                        String operasiData="";
                                        switch (pengurusPemilik.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//23
                                        
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusPengurusPemilik("Proses Delimited Text : "+totalProses+"/"+totPengurusPemilik);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENGURUS_PEMILIK] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_PENGURUS_PEMILIK] + "|");
                                pw.print("" + vPengurusPemilik.size() + "|");
                                pw.print("" + totPengurusPemilik + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }

                    break;

                case Configurasi.FLD_SEGMENT_LAPORAN_KEUANGAN_DEBITUR:
                    int totLaporanKeungan = PstLaporanKeuanganDebitur.getCount(PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                    totalProses=0;
                    if (vCabang.size() > 0) {
                        for (int i = 0; i < vCabang.size(); i++) {
                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
                            int noCabang = 0;

                            try {
                                noCabang = cabangBank.getNoUrut();
                            } catch (Exception ex) {

                            }//Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            Vector vLaporanKeuanganDebitur = new Vector();
                            String where = " ";
                                    //+ " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' AND "
                                    if(perCabang==0){
                                        where=where + " dslik_cabang_bank.PARENT_CODE" + "='" + cabangBank.getKodeCabang() + "' ";
                                    }
                                    where=where + " "+PstLaporanKeuanganDebitur.fieldNames[PstLaporanKeuanganDebitur.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'";
                            vLaporanKeuanganDebitur = PstLaporanKeuanganDebitur.list(0, 0, "" + where, "");
                            if (vLaporanKeuanganDebitur.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_LAPORAN_KEUANGAN_DEBITUR] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_LAPORAN_KEUANGAN_DEBITUR] + "|");
                                pw.print("" + vLaporanKeuanganDebitur.size() + "|");
                                pw.print("" + totLaporanKeungan + "");
                                pw.println();
                                for (int p = 0; p < vLaporanKeuanganDebitur.size(); p++) {
                                    try {

                                        LaporanKeuanganDebitur laporanKeuanganDebitur = (LaporanKeuanganDebitur) vLaporanKeuanganDebitur.get(p);
                                        totalProses=totalProses+1;                                           
                                        pw.print("" + laporanKeuanganDebitur.getFlagDetail() + "|");//1
                                        pw.print("" + laporanKeuanganDebitur.getCif()+ "|");//2
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getAset())+ "|");//3
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getAsetLancar())+ "|");//4
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getKasDanSetaraKas())+ "|");//5
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getPiutangUsahaAstLncr())+ "|");//6
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getInvestasiAstLncr())+ "|");//7
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getAsetLancarLain())+ "|");//8
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getAsetTidakLancar())+ "|");//9
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getPiutangUsahaAstTdkLncr())+ "|");//10
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getInvestasiAstTdkLncr())+ "|");//11
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getAsetTdkLncrLain())+ "|");//12
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLiabilitas())+ "|");//13
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLiabilitasJnkPndk())+ "|");//14
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getPinjamanJnkPndk())+ "|");//15
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getUtangUsahaLiaJnkPndk())+ "|");//16
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLiabilitasJnkPndkLain())+ "|");//17
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLiabilitasJnkPnjg())+ "|");//18
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getPinjamanJnkPnjg())+ "|");//19
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getUtangUsahaLiaJnkPnjg())+ "|");//20
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLiabilitasJnkPnjgLain())+ "|");//21
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getEkuitas())+ "|");//22
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getPendapatanUsahaOpr())+ "|");//23
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getBebanPokokPend())+ "|");//24
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLabaRugiBruto())+ "|");//25
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getPendLainNonOpr())+ "|");//26
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getBebanLainNonOpr())+ "|");//27
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLabaRugiSblmPajak())+ "|");//28
                                        pw.print("" + Formater.formatNumberNoDecimal(laporanKeuanganDebitur.getLabaRugiPeriode())+ "|");//29
                                        pw.print("" + laporanKeuanganDebitur.getKodeKantorCabang() + "|");//30
                                        //pw.print("" + laporanKeuanganDebitur.getOperasiData() + "|"); //31
                                        
                                         String operasiData="";
                                        switch (laporanKeuanganDebitur.getStatusOperasiData()) {
                                            case 0:
                                                operasiData="C";
                                                break;
                                            case 1:
                                                operasiData="U";
                                                break;
                                            default:
                                                operasiData="N";
                                                break;
                                        }
                                        pw.print("" + operasiData+ "");//23
                                        
                                        
                                        pw.println();
                                        //isi
                                        //buatkan file nya
                                        ManagerDilimitedText.setStatusLaporanKeuangan("Proses Delimited Text : "+totalProses+"/"+totLaporanKeungan);
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_LAPORAN_KEUANGAN_DEBITUR] + "." + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_LAPORAN_KEUANGAN_DEBITUR] + "|");
                                pw.print("" + vLaporanKeuanganDebitur.size() + "|");
                                pw.print("" + totLaporanKeungan + "");
                                pw.println();
                                pw.flush();
                            }
                        }
                    }
                    
                    break;
                    
                case Configurasi.FLD_SEGMENT_SUMMARY_FASILITAS:
                   // if (vCabang.size() > 0) {
                        //for (int i = 0; i < vCabang.size(); i++) {
//                            CabangBank cabangBank = (CabangBank) vCabang.get(i);
//                            int noCabang = 0;
//
//                            try {
//                                noCabang = cabangBank.getNoUrut();
//                            } catch (Exception ex) {
//
//                            }
                            //Integer.parseInt(cabangBank.getKodeCabang());
                            //cek pengurus sesuai cabang
                            //tambahkan fungsi pengecekan periode yang aktive, update dengan periode tsb
                            Periode periode = new Periode();
                            long periodeId=0;
                            try{
                                Vector listPeriode = PstPeriode.list(0, 1, ""+PstPeriode.fieldNames[PstPeriode.FLD_POSTED]+"='0'", "");
                                if(listPeriode != null){
                                    periode = (Periode) listPeriode.get(0);
                                    periodeId = periode.getOID();
                                }
                            }catch(Exception ex){
                            }
                            //dapet kan total summary kredit dan bank garansi
                            int totKreditSummary = PstKredit.getCount(PstKredit.fieldNames[PstKredit.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                            int totBankGaransiSummary = PstBankGaransi.getCount(PstBankGaransi.fieldNames[PstBankGaransi.FLD_PERIODE_ID]+"='"+fileSent.getPeriodeId()+"'");
                            //total summary
                            int totalSummary = totKreditSummary+totBankGaransiSummary;
                            
                            Vector vSummaryFasilitas = new Vector();
                            String where = "";//PstSummaryFasilitas.fieldNames[PstSummaryFasilitas.FLD_KODE_KANTOR_CABANG] + "='" + cabangBank.getKodeCabang() + "'";
                            vSummaryFasilitas = PstSummaryFasilitas.list(0, 0, "" + where, ""+PstSummaryFasilitas.fieldNames[PstSummaryFasilitas.FLD_KODE_JENIS_FASILITAS]+" ASC ");
                            int countDataSummary=0;
                            if (vSummaryFasilitas.size() > 0) {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SUMMARY_FASILITAS] + ".1";// + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SUMMARY_FASILITAS] + "|");
                                pw.print("" + totalSummary + "|");
                                pw.print("" + totalSummary + "");
                                pw.println();
                                
                                
                                for (int p = 0; p < vSummaryFasilitas.size(); p++) {
                                    try {

                                        SummaryFasilitas summaryFasilitas = (SummaryFasilitas) vSummaryFasilitas.get(p);
                                                                                   
                                        
                                        
                                        boolean april = false;
                                        boolean mei = false;
                                        boolean juni = false;
                                        boolean july = false;
                                        boolean agustus = false;
                                        boolean september = false;
                                        boolean oktober = false;
                                        boolean november = false;
                                        boolean desember = false;
                                        boolean januari = false;
                                        boolean februari = false;
                                        boolean maret = false;
                                        boolean insertData=true;
                                        //cek no rekening di periode akhir
                                        Date xxx  = null;
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        Date dateA = sdf.parse("2016-04-30");
                                        Date dateM = sdf.parse("2016-05-31");
                                        Date dateJ = sdf.parse("2016-06-30");
                                        Date dateJL = sdf.parse("2016-07-31");
                                        Date dateAG = sdf.parse("2016-08-31");
                                        Date dateS = sdf.parse("2016-09-30");
                                        Date dateO = sdf.parse("2016-10-31");
                                        Date dateN = sdf.parse("2016-11-30");
                                        Date dateD = sdf.parse("2016-12-31");
                                        Date dateJAN = sdf.parse("2017-01-31");
                                        Date dateF = sdf.parse("2017-02-28");
                                        Date dateMR = sdf.parse("2017-03-31");
                                        if(summaryFasilitas.getKodeJenisFasilitas().equals("F01")){
                                            //summaryFasilitas.setNoRekening("0110403000593");
                                            xxx = MoveDataCrosPeriode.tanggalAwalKredit(periodeId, summaryFasilitas.getNoRekening(), summaryFasilitas.getCif());
                                            if(xxx!=null){
                                                if(xxx.compareTo(dateA)>0 || dateA.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    april = true;
                                                }
                                                if(xxx.compareTo(dateM)>0 || dateM.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    mei = true;
                                                }
                                                if(xxx.compareTo(dateJ)>0 || dateJ.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    juni = true;
                                                }
                                                if(xxx.compareTo(dateJL)>0 || dateJL.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    july = true;
                                                }
                                                if(xxx.compareTo(dateAG)>0 || dateAG.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    agustus = true;
                                                }
                                                if(xxx.compareTo(dateS)>0 || dateS.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    september = true;
                                                }
                                                if(xxx.compareTo(dateO)>0 || dateO.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    oktober = true;
                                                }
                                                if(xxx.compareTo(dateN)>0 || dateN.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    november = true;
                                                }
                                                if(xxx.compareTo(dateD)>0 || dateD.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    desember = true;
                                                }
                                                if(xxx.compareTo(dateJAN)>0 || dateJAN.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    januari = true;
                                                }
                                                if(xxx.compareTo(dateF)>0 || dateF.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    februari = true;
                                                }
                                                if(xxx.compareTo(dateMR)>0 || dateMR.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    maret = true;
                                                }
                                            }else{
                                                april = true;
                                                mei = true;
                                                juni = true;
                                                july = true;
                                                agustus = true;
                                                september = true;
                                                oktober = true;
                                                november = true;
                                                desember = true;
                                                januari = true;
                                                februari = true;
                                                maret = true;
                                                insertData=false;
                                            }
                                        } else if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                            //summaryFasilitas.setNoRekening("0110403000397");
                                            xxx = MoveDataCrosPeriode.tanggalAwalBankGaransi(periodeId, summaryFasilitas.getNoRekening(),summaryFasilitas.getCif());
                                            if(xxx!=null){
                                                if(xxx.compareTo(dateA)>0 || dateA.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    april = true;
                                                }
                                                if(xxx.compareTo(dateM)>0 || dateM.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    mei = true;
                                                }
                                                if(xxx.compareTo(dateJ)>0 || dateJ.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    juni = true;
                                                }
                                                if(xxx.compareTo(dateJL)>0 || dateJL.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    july = true;
                                                }
                                                if(xxx.compareTo(dateAG)>0 || dateAG.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    agustus = true;
                                                }
                                                if(xxx.compareTo(dateS)>0 || dateS.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    september = true;
                                                }
                                                if(xxx.compareTo(dateO)>0 || dateO.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    oktober = true;
                                                }
                                                if(xxx.compareTo(dateN)>0 || dateN.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    november = true;
                                                }
                                                if(xxx.compareTo(dateD)>0 || dateD.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    desember = true;
                                                }
                                                if(xxx.compareTo(dateJAN)>0 || dateJAN.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    januari = true;
                                                }
                                                if(xxx.compareTo(dateF)>0 || dateF.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    februari = true;
                                                }
                                                if(xxx.compareTo(dateMR)>0 || dateMR.compareTo(fileSent.getEndPeriodeDate())==0){
                                                    maret = true;
                                                }
                                            }else{
                                                april = true;
                                                mei = true;
                                                juni = true;
                                                july = true;
                                                agustus = true;
                                                september = true;
                                                oktober = true;
                                                november = true;
                                                desember = true;
                                                januari = true;
                                                februari = true;
                                                maret = true;
                                                insertData=false;
                                            }
                                        }
                                        
                                        if(insertData){
                                            pw.print("" + summaryFasilitas.getFlagDetail() + "|");//1
                                            pw.print("" + summaryFasilitas.getNoRekening()+ "|");//2
                                            pw.print("" + summaryFasilitas.getCif()+ "|");//3
                                            pw.print("" + summaryFasilitas.getKodeJenisFasilitas()+ "|");//4

                                            if(summaryFasilitas.getKodeKolektibilitas1().equals("0") || april){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas1()+ "|");//5
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    if(summaryFasilitas.getJmlHariTunggakan1()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan1()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas2().equals("0") || mei){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas2()+ "|");//7
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan2()+ "|");//8
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan2()+ "|");//8
                                                    if(summaryFasilitas.getJmlHariTunggakan2()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan2()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas3().equals("0") || juni){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas3()+ "|");//9
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan3()+ "|");//10
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan3()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan3()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan3()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas4().equals("0") || july){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                               pw.print("" + summaryFasilitas.getKodeKolektibilitas4()+ "|");//11
                                               // pw.print("" + summaryFasilitas.getJmlHariTunggakan4()+ "|");//12
                                               if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan4()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan4()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan4()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas5().equals("0") || agustus){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas5()+ "|");//13
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan5()+ "|");//14
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan5()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan5()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan5()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas6().equals("0") || september){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas6()+ "|");//15
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan6()+ "|");//16
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan6()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan6()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan6()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas7().equals("0") || oktober){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas7()+ "|");//17
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan7()+ "|");//18
                                                 if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan7()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan7()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan7()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas8().equals("0")  || november){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas8()+ "|");//19
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan8()+ "|");//20
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan8()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan8()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan8()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas9().equals("0") || desember){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas9()+ "|");//21
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan9()+ "|");//22
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan9()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan9()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan9()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas10().equals("0") || januari){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas10()+ "|");//23
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan10()+ "|");//24
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan10()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan10()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan10()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas11().equals("0") || februari){
                                                pw.print("|");//5
                                                pw.print("|");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas11()+ "|");//25
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan11()+ "|");//26
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan11()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan11()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan11()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            if(summaryFasilitas.getKodeKolektibilitas12().equals("0") || maret){
                                                pw.print("|");//5
                                                pw.print("");//6
                                            }else{
                                                pw.print("" + summaryFasilitas.getKodeKolektibilitas12()+ "|");//27
                                                //pw.print("" + summaryFasilitas.getJmlHariTunggakan12()+ "");//28
                                                if(summaryFasilitas.getKodeJenisFasilitas().equals("F05")){
                                                    pw.print("|");//6
                                                }else{
                                                    //pw.print("" + summaryFasilitas.getJmlHariTunggakan11()+ "|");//10
                                                    if(summaryFasilitas.getJmlHariTunggakan12()>0){
                                                        pw.print("" + summaryFasilitas.getJmlHariTunggakan12()+ "|");//6
                                                    }else{
                                                       pw.print("0|");//6
                                                    }
                                                }
                                            }

                                            pw.println();
                                            countDataSummary=countDataSummary+1;
                                            ManagerDilimitedTextSummary.setStatusDilimitedTextSummary("Proses Delimited Text : "+countDataSummary+"/"+totalSummary);

                                        }
                                        //isi
                                        //buatkan file nya
                                    } catch (Exception exc) {
                                        System.out.println("ini eornya" + exc);
                                    }
                                }
                                pw.flush();
                                //proses zip data
                                //zipFile(new File(patchFle),fileSent.getLocation(),0);
                            } else {
                                namaFile = "" + outletConnection.getJenisLJK() + "." + outletConnection.getKodeLJK() + "." + fileSent.getTahun() + "." + fileSent.getBulan() + "." + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SUMMARY_FASILITAS] + ".1";// + noCabang;
                                patchFle = fileSent.getLocation() + System.getProperty("file.separator") + "" + namaFile + ".txt";
                                pw = new PrintWriter(patchFle);
                                //Buat header
                                //H|0101|666|2016|10|M01|1|1
                                //H (header)
                                //0101 (jenis LJK)
                                //666 (kode LJK)
                                //2016 (tahun)
                                //10 (bulan
                                //M01 (kode segment)
                                //1 (jumlah data
                                pw.print("H" + "|");
                                pw.print("" + outletConnection.getJenisLJK() + "|");
                                pw.print("" + outletConnection.getKodeLJK() + "|");
                                pw.print("" + fileSent.getTahun() + "|");
                                pw.print("" + fileSent.getBulan() + "|");
                                pw.print("" + Configurasi.valSegment[Configurasi.FLD_SEGMENT_SUMMARY_FASILITAS] + "|");
                                pw.print("" + vSummaryFasilitas.size() + "|");
                                pw.print("" + vSummaryFasilitas.size() + "");
                                pw.println();
                                pw.flush();
                            }
                       // }
                   // }
                    //dicek apa saja parameternya
                    break;
                    
                default:
            }
        } catch (FileNotFoundException ex) {
        }
        return patchFle;
    }

}
