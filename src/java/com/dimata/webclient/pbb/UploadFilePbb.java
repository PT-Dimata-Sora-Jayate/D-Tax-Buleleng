package com.dimata.webclient.pbb;

import com.dimata.dtaxintegration.entity.inquery.InqueryProses;
import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstPaymentPbb;
import com.dimata.dtaxintegration.entity.tagihan.FileSent;
import com.dimata.dtaxintegration.entity.tagihan.Tagihan;
import com.dimata.dtaxintegration.entity.tagihan.TagihanDelete;
import com.dimata.dtaxintegration.session.DTaxIntegrationMonitor;
import com.dimata.dtaxintegration.session.DTaxManagerPbb;
import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.util.Formater;
import com.dimata.webclient.AppSetting;
import com.dimata.webclient.EchoTagihanDeleteByRecordId;
import com.dimata.webclient.Inquery;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class UploadFilePbb {

    public String autoUploadPBB(FileSent fileSent) {
        DTaxManagerPbb dTaxManagerPbbx = new DTaxManagerPbb();

        try {
            Date dtNow = new Date();
            new SimpleDateFormat("yyyy-MM-dd");
            String date = Formater.formatDate(dtNow, "yyyy-MM-dd");
            String oDate = Formater.formatDate(dtNow, "yyyy-MM-dd HH:mm:ss");
            String sql = "";
            if (AppSetting.SQL_VERSION == 3) {
                sql = "SELECT * FROM VIEW_PBB WHERE TGL_CETAK_SPPT BETWEEN TO_DATE('" + date + " 00:00:00','YYYY-MM-DD HH24:MI:SS') AND TO_DATE('" + date + " 23:59:00','YYYY-MM-DD HH24:MI:SS') OR TGL_TERBIT_SPPT = TO_DATE('" + date + "','YYYY-MM-DD')";
            } else if (AppSetting.SQL_VERSION == 4) {
                //Update untuk promo merdeka (mengambil thn 2022-2026)
                //sql = "SELECT * FROM VIEW_PBB WHERE (TGL_CETAK_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime) OR TGL_TERBIT_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime)) order by TGL_CETAK_SPPT desc";
                sql = "SELECT * FROM VIEW_PBB WHERE ((TGL_CETAK_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime)) OR (TGL_TERBIT_SPPT BETWEEN CAST('" + date + " 00:00:00' as datetime) AND CAST('" + date + " 23:59:00' as datetime))) AND TAHUN BETWEEN 2022 AND 2026 order by TGL_CETAK_SPPT desc";
            }

            DBResultSet dbrs = null;

            try {
                dbrs = DBHandler.execQueryResultNew(sql);
                DTaxManagerPbb.statusAutoUpload = dTaxManagerPbbx.getStatusAutoUpload() + " Proses Auto Upload penetapan baru dimulai :" + Formater.formatDate(new Date(), "dd-MM-yyyy kk:mm") + "<br>";
                ResultSet rs = dbrs.getResultSet();
                int no = 0;

                while (rs.next()) {

                    no++;
                    String nop = rs.getString("NOP");
                    String tahun = rs.getString("TAHUN");
                    int tahunTagihan = rs.getInt("TAHUN");
                    int tahunSampai = Integer.parseInt(fileSent.getTahunStart());
                    
                    if (tahunTagihan > tahunSampai) {
                        continue;
                    }

                    double jumlahTagihan = rs.getDouble("JUMLAH_TAGIHAN_MURNI");
                    Date tglJatuhTempo = rs.getDate("TGL_JATUH_TEMPO_SPPT");
                    Calendar startCalendar = Calendar.getInstance();
                    Calendar endCalendar = Calendar.getInstance();
                    String strJatuhTempoNew = "2021-01-31";
                    Date dtJatuhTempo = (new SimpleDateFormat("yyyy-MM-dd")).parse(strJatuhTempoNew);
                    int thn = 0;

                    try {
                        thn = Integer.valueOf(tahun);
                        if (thn < 2021) {
                            startCalendar.setTime(dtJatuhTempo);
                        } else {
                            startCalendar.setTime(tglJatuhTempo);
                        }
                    } catch (Exception var61) {
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
                    if (listPembayaran.size() > 0) {
                        for (int i = 0; i < listPembayaran.size(); ++i) {
                            PaymentPbb paymentPbb = (PaymentPbb) listPembayaran.get(i);
                            totalPembayaran += paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                            pembayaranDenda += paymentPbb.getDendaSppt();
                            if (paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt() > 0.0D) {
                                tglDendaSeharusnya = paymentPbb.getTglPembayaranSppt();
                            }

                            if (paymentPbb.getPembayaranSpptKe() == 1.0D) {
                                tglDendaPembayaranPertama = paymentPbb.getTglPembayaranSppt();
                                pembayaranPertama = paymentPbb.getJmlSpptYgDibayar() - paymentPbb.getDendaSppt();
                            }
                        }
                    }

                    if (tahunTagihan == 2026) {
                        int jumlahTunggakan = 0;
                        String sqlTunggakan = "SELECT COUNT(*) FROM VIEW_PBB WHERE NOP = " + nop;
                        DBResultSet dbrs2 = DBHandler.execQueryResultNew(sqlTunggakan);
                        ResultSet rs2 = dbrs2.getResultSet();

                        if (rs2.next()) {
                            jumlahTunggakan = rs2.getInt(1);
                        }
                        DBResultSet.close(dbrs2);

                        if (jumlahTunggakan > 1) {
                            if (jumlahTagihan <= 2000000) {
                                jumlahTagihan = jumlahTagihan - (jumlahTagihan * 0.01);
                            } else {
                                jumlahTagihan = jumlahTagihan - (jumlahTagihan * 0.005);
                            }
                        }
                    }

                    diffYear = endCalendar.get(1) - startCalendar.get(1);
                    diffMonth = diffYear * 12 + endCalendar.get(2) - startCalendar.get(2);
                    if (endCalendar.get(5) > startCalendar.get(5)) {
                        ++diffMonth;
                    }

                    if (diffMonth > 0) {
                        tunggakan = diffMonth;
                    }

                    double persentaseDenda = 0.0D;
                    if (tunggakan > 0) {
                        if (tunggakan > 24) {
                            persentaseDenda = 0.48D;
                        } else {
                            persentaseDenda = (double) tunggakan * 0.02D;
                        }
                    }

                    double denda = 0.0D;
                    denda = Math.ceil((jumlahTagihan - totalPembayaran) * persentaseDenda);
                    if (denda < 0.0D || thn < 2019) {
                        denda = 0.0D;
                    }

                    try {
                        String sDate1 = "2021-02-01";
                        Date dateDenda = (new SimpleDateFormat("yyyy-MM-dd")).parse(sDate1);
                        if ((new Date()).before(dateDenda)) {
                            denda = 0.0D;
                        }
                    } catch (Exception var60) {
                    }

                    double totPambayaran1 = 0.0D;
                    if (jumlahTagihan - totPambayaran1 > 0.0D) {
                        totPambayaran1 = jumlahTagihan - totPambayaran1;
                    }

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

                        Tagihan tagihan;
                        int i;
                        for (i = 0; i < listBank.size(); ++i) {
                            tagihan = (Tagihan) listBank.get(i);
                            if (tahun.equals(tagihan.getTahun())) {
                                isYearAlready = true;
                            }
                        }

                        if (isYearAlready) {
                            for (i = 0; i < listBank.size(); ++i) {
                                tagihan = (Tagihan) listBank.get(i);
                                double tagihanBank = Double.valueOf(tagihan.getTagihan());
                                if (tahun.equals(tagihan.getTahun()) && ygHarusDibayar != tagihanBank) {
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
                        } else {
                            DTaxIntegrationMonitor dTaxIntegrationMonitor = new DTaxIntegrationMonitor();
                            String str = " WHERE NOP=" + nop + " AND TAHUN=" + tahun + "";
                            if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
                                dTaxIntegrationMonitor.sentPBBIpRotax(str);
                            } else if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
                                dTaxIntegrationMonitor.sentPBBIpRotaxV2(str);
                            } else {
                                dTaxIntegrationMonitor.sentPBB(str);
                            }
                        }
                    } else {
                        DTaxIntegrationMonitor dtax = new DTaxIntegrationMonitor();
                        String whereSent = " WHERE NOP=" + nop + " AND TAHUN=" + tahun + "";
                        if (AppSetting.TYPE_APP_BACKOFFICE == 1) {
                            dtax.sentPBBIpRotax(whereSent);
                        } else if (AppSetting.TYPE_APP_BACKOFFICE == 5) {
                            dtax.sentPBBIpRotaxV2(whereSent);
                        } else {
                            dtax.sentPBB(whereSent);
                        }
                    }
                }
            } catch (Exception var62) {
                System.out.println(var62.getMessage());
            }
        } catch (Exception var63) {
            System.out.println(var63.getMessage());
        }

        return "";
    }
}
