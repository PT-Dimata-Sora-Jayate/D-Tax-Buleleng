package com.dimata.util;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diskon
{
    public String jatuhTempo;
    public String jatuhTempo21;
    public String jatuhTempo22;
    public String jatuhTempo23;
    public String jatuhTempo24;
    public String tglKompensasi;
    
    public Diskon() {
        this.jatuhTempo = "2021-01-31";
        this.jatuhTempo21 = "2021-09-30";
        this.jatuhTempo22 = "2023-12-31";
        this.jatuhTempo23 = "2023-12-31";
        this.jatuhTempo24 = "2024-09-30";
        this.tglKompensasi = "2023-12-31";
    }
    
    public double diskonPajak(final int tahun, final double tagihan) {
        return tagihan;
    }
    
    public double jumlahDiskon(final int tahun, final double tagihan) {
        final double jmlhDiskon = 0.0;
        return jmlhDiskon;
    }
    
    public double diskonDenda(final int tahun, final double denda) {
        double total = denda;
        if (denda < 0.0 || tahun < 2022) {
            total = 0.0;
        }
        return total;
    }
    
    public double konpensasiDenda(final int tahun, final double denda, final double besardenda, final double jmlhBayar) {
        double total = denda;
        try {
            final Date dateNow = new Date();
            final Date limit = new SimpleDateFormat("yyyy-MM-dd").parse(this.tglKompensasi);
            if (tahun <= 2021) {
                total = 0.0;
            }
//            else if (tahun >= 2020 && tahun <= 2023) {  //edit by dhama
//                total = 0.0;
//            }
            else {
                final double besarKompensasi = 0.0;
                if (dateNow.equals(limit) || dateNow.after(limit)) {
                    total = denda;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Diskon->konpensasiDenda() " + e.getMessage());
        }
        return total;
    }
    
    public double jumlahKonpensasiDenda(final int tahun, final double denda, final double besardenda, final double jmlhBayar) {
        final double total = 0.0;
        return total;
    }
    
    public double perdentaseDenda(final Calendar endCalendar, final int tahun, Date tglJatuhTempo) {
        double persentaseDenda = 0.0;
        int diffYear = 0;
        int diffMonth = 0;
        int tunggakan = 0;
        final Calendar startCalendar = Calendar.getInstance();
        final Date nowDate = new Date();
        try {
            final Date dtJatuhTempo = new SimpleDateFormat("yyyy-MM-dd").parse(this.jatuhTempo);
            final Date dtJatuhTempo2 = new SimpleDateFormat("yyyy-MM-dd").parse(this.jatuhTempo21);
            final Date dtJatuhTempo3 = new SimpleDateFormat("yyyy-MM-dd").parse(this.jatuhTempo22);
            final Date dtJatuhTempo4 = new SimpleDateFormat("yyyy-MM-dd").parse(this.jatuhTempo23);
            final Date dtJatuhTempo5 = new SimpleDateFormat("yyyy-MM-dd").parse(this.jatuhTempo24);
            final Date dateEnd = endCalendar.getTime();
            try {
                if (tahun > 2018 && tahun < 2020) {
                    startCalendar.setTime(dtJatuhTempo);
                }
                else if (tahun == 2021) {
                    startCalendar.setTime(dtJatuhTempo2);
                }
                else if (tahun == 2022) {
                    startCalendar.setTime(dtJatuhTempo3);
                }
                else if (tahun == 2023) {
                    startCalendar.setTime(dtJatuhTempo4);
                }
                else if (tahun == 2024) {
                    startCalendar.setTime(dtJatuhTempo5);
                }
                else {
                    startCalendar.setTime(tglJatuhTempo);
                }
            }
            catch (Exception exc) {
                startCalendar.setTime(tglJatuhTempo);
            }
            long dif = 0;
//            if (tahun == 2021 || tahun == 2022) {     //edit by dhama
            if (tahun == 2022 || tahun == 2023) {
                final Date tglKompensasis = new SimpleDateFormat("yyyy-MM-dd").parse(this.tglKompensasi);
                final long difference = (nowDate.getTime() - tglKompensasis.getTime()) / 86400000;
                dif = Math.abs(difference);
                if (dif > 0) {
                    tglJatuhTempo = new SimpleDateFormat("yyyy-MM-dd").parse(this.tglKompensasi);
                    startCalendar.setTime(tglKompensasis);
                } else {
                    tglJatuhTempo = new SimpleDateFormat("yyyy-MM-dd").parse(this.tglKompensasi);
                }
            } 
            
            diffYear = endCalendar.get(1) - startCalendar.get(1);
            diffMonth = diffYear * 12 + (dateEnd.getMonth() + 1) - (tglJatuhTempo.getMonth() + 1);
            if (diffMonth > 0) {
                tunggakan = diffMonth;
            }
            if (tunggakan > 0) {
                    persentaseDenda = tunggakan * 0.01;
                if (dif > 0) {
                    if (tunggakan > 9 && tahun == 2022) { 
                        persentaseDenda = 0.09;
                    }
                    else if (tunggakan > 21 && tahun == 2023) {
                        persentaseDenda = 0.21;
                    }
                    else if (tahun <= 2021) {
                        persentaseDenda = 0;
                    }
                }
            }
        } 
        catch (Exception e) { 
            System.out.println("Diskon->perdentaseDenda() " + e.getMessage());
        }
        return persentaseDenda;
    }
}