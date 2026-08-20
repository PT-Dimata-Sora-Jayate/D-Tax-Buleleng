/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dslik.entity.bankgaransi;

import com.dimata.common.entity.logger.I_LogHistory;
import com.dimata.common.entity.logger.I_Validasi;
import com.dimata.qdep.entity.Entity;
import com.dimata.util.Formater;
import java.util.Date;

/**
 *
 * @author Dewa
 */
public class BankGaransi extends Entity implements I_LogHistory, I_Validasi{

    private String flagDetail = "";
    private String noRekening = "";
    private String cif = "";
    private String kodeJenisGaransi = "";
    private String kodeTujuanGaransi = "";
    private Date tglDiterbitkan = null;
    private Date tglJatuhTempo = null;
    private String noAkadAwal = "";
    private Date tglAkadAwal = null;
    private String noAkadAkhir = "";
    private Date tglAkadAkhir = null;
    private String namaYgDijamin = "";
    private String kodeValuta = "";
    private double plafon = 0;
    private double nominal = 0;
    private double setoranJaminan = 0;
    private String kodeKolektibilitas = "";
    private Date tglWanPrestasi = null;
    private String kodeKondisi = "";
    private Date tglKondisi = null;
    private String keterangan = "";
    private String kodeKantorCabang = "";
    private String operasiData = "";
    private Date openDate = null;
    private int statusData = 0;
    private String tujuanGransi="";
    private String jenisGaranasi="";
    private String sqlHistory = "";
    
    //ADD BY ARI
    private long periodeId = 0;
    private long debiturOid = 0;
    private int debiturType = 0;
    private int statusOperasiData = 0;
    private int statusPerubahanData=0;
    
    //report by opie-eyek
    private String kodeBankGransiReport="";
    private String namaBankGaransiReport="";
    private int totalBankGaransi=0;
    private double totNominalBankGaransi=0.0;
    
    //validasi
    private boolean isNotValid=false;
    private String validasiNoRekening = "";
    private String validasiCif = "";
    private String validasiKodeJenisGaransi = "";
    private String validasiKodeTujuanGaransi = "";
    private String validasiTglDiterbitkan = "";
    private String validasiTglJatuhTempo = "";
    private String validasiNoAkadAwal = "";
    private String validasiTglAkadAwal = "";
    private String validasiNoAkadAkhir = "";
    private String validasiTglAkadAkhir = "";
    private String validasiNamaYgDijamin = "";
    private String validasiKodeValuta = "";
    private String validasiPlafon = "";
    private String validasiNominal = "";
    private String validasiSetoranJaminan = "";
    private String validasiKodeKolektibilitas = "";
    private String validasiTglWanPrestasi = "";
    private String validasiKodeKondisi = "";
    private String validasiTglKondisi = "";
    private String validasiKeterangan = "";
    private String validasiTujuanGransi="";
    private String validasiJenisGaranasi="";
    
    private String errorNoRekening = "";
    private String errorCif = "";
    private String errorKodeJenisGaransi = "";
    private String errorKodeTujuanGaransi = "";
    private String errorTglDiterbitkan = "";
    private String errorTglJatuhTempo = "";
    private String errorNoAkadAwal = "";
    private String errorTglAkadAwal = "";
    private String errorNoAkadAkhir = "";
    private String errorTglAkadAkhir = "";
    private String errorNamaYgDijamin = "";
    private String errorKodeValuta = "";
    private String errorPlafon = "";
    private String errorNominal = "";
    private String errorSetoranJaminan = "";
    private String errorKodeKolektibilitas = "";
    private String errorTglWanPrestasi = "";
    private String errorKodeKondisi = "";
    private String errorTglKondisi = "";
    private String errorKeterangan = "";
    private String errorTujuanGransi="";
    private String errorJenisGaranasi="";
    
    
    
    public String getFlagDetail() {
        return flagDetail;
    }

    public void setFlagDetail(String flagDetail) {
        if (flagDetail==null){
            this.flagDetail = "";
        }else{
            this.flagDetail = flagDetail;
        }
        
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        if (noRekening==null){
            this.noRekening = "";
        }else{
            this.noRekening = noRekening;
        }
        
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        if (cif==null){
            this.cif = "";
        }else{
            this.cif = cif;
        }
        
    }

    public String getKodeJenisGaransi() {
        return kodeJenisGaransi;
    }

    public void setKodeJenisGaransi(String kodeJenisGaransi) {
        if (kodeJenisGaransi==null){
            this.kodeJenisGaransi = "";
        }else{
            this.kodeJenisGaransi = kodeJenisGaransi;
        }
        
    }

    public String getKodeTujuanGaransi() {
        return kodeTujuanGaransi;
    }

    public void setKodeTujuanGaransi(String kodeTujuanGaransi) {
        if (kodeTujuanGaransi==null){
            kodeTujuanGaransi ="";
        }else{
            this.kodeTujuanGaransi = kodeTujuanGaransi;
        }
        
    }

    public Date getTglDiterbitkan() {
        return tglDiterbitkan;
    }

    public void setTglDiterbitkan(Date tglDiterbitkan) {
        this.tglDiterbitkan = tglDiterbitkan;
    }

    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public String getNoAkadAwal() {
        return noAkadAwal;
    }

    public void setNoAkadAwal(String noAkadAwal) {
        if (noAkadAwal==null){
            this.noAkadAwal = "";
        }else{
            this.noAkadAwal = noAkadAwal;
        }
        
    }

    public Date getTglAkadAwal() {
        return tglAkadAwal;
    }

    public void setTglAkadAwal(Date tglAkadAwal) {
        this.tglAkadAwal = tglAkadAwal;
    }

    public String getNoAkadAkhir() {
        return noAkadAkhir;
    }

    public void setNoAkadAkhir(String noAkadAkhir) {
        if (noAkadAkhir==null){
            this.noAkadAkhir = "";
        }else{
            this.noAkadAkhir = noAkadAkhir;
        }
        
    }

    public Date getTglAkadAkhir() {
        return tglAkadAkhir;
    }

    public void setTglAkadAkhir(Date tglAkadAkhir) {
        this.tglAkadAkhir = tglAkadAkhir;
    }

    public String getNamaYgDijamin() {
        return namaYgDijamin;
    }

    public void setNamaYgDijamin(String namaYgDijamin) {
        if (namaYgDijamin==null){
            this.namaYgDijamin = "";
        }else{
            this.namaYgDijamin = namaYgDijamin;
        }
        
    }

    public String getKodeValuta() {
        return kodeValuta;
    }

    public void setKodeValuta(String kodeValuta) {
        if(kodeValuta==null){
            this.kodeValuta = "";
        }else{
            this.kodeValuta = kodeValuta;
        }
        
    }

    public double getPlafon() {
        return plafon;
    }

    public void setPlafon(double plafon) {
        this.plafon = plafon;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public double getSetoranJaminan() {
        return setoranJaminan;
    }

    public void setSetoranJaminan(double setoranJaminan) {
        this.setoranJaminan = setoranJaminan;
    }

    public String getKodeKolektibilitas() {
        return kodeKolektibilitas;
    }

    public void setKodeKolektibilitas(String kodeKolektibilitas) {
        if (kodeKolektibilitas==null){
            this.kodeKolektibilitas = "";
        }else{
            this.kodeKolektibilitas = kodeKolektibilitas;
        }
        
    }

    public Date getTglWanPrestasi() {
        return tglWanPrestasi;
    }

    public void setTglWanPrestasi(Date tglWanPrestasi) {
        this.tglWanPrestasi = tglWanPrestasi;
    }

    public String getKodeKondisi() {
        return kodeKondisi;
    }

    public void setKodeKondisi(String kodeKondisi) {
        if (kodeKondisi==null){
            this.kodeKondisi = "";
        }else{
            this.kodeKondisi = kodeKondisi;
        }
        
    }

    public Date getTglKondisi() {
        return tglKondisi;
    }

    public void setTglKondisi(Date tglKondisi) {
        this.tglKondisi = tglKondisi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        if (keterangan==null){
            this.keterangan = "";
        }else{
            this.keterangan = keterangan;
        }
        
    }

    public String getKodeKantorCabang() {
        return kodeKantorCabang;
    }

    public void setKodeKantorCabang(String kodeKantorCabang) {
        if (kodeKantorCabang==null){
            this.kodeKantorCabang = "";
        }else{
            this.kodeKantorCabang = kodeKantorCabang;
        }
        
    }

    public String getOperasiData() {
        return operasiData;
    }

    public void setOperasiData(String operasiData) {
        if (operasiData==null){
            this.operasiData = "";
        }else{
            this.operasiData = operasiData;
        }
        
    }

    /**
     * @return the OpenDate
     */
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * @param OpenDate the OpenDate to set
     */
    public void setOpenDate(Date OpenDate) {
        this.openDate = OpenDate;
    }

    /**
     * @return the StatusData
     */
    public int getStatusData() {
        return statusData;
    }

    /**
     * @param StatusData the StatusData to set
     */
    public void setStatusData(int statusData) {
        this.statusData = statusData;
    }

    
    @Override
    public String getLogDetail(Entity prevDoc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String history="";
        BankGaransi prevMat = (BankGaransi)prevDoc;
        
        try {
            //0
            if(prevMat == null || !prevMat.getFlagDetail().equals(this.getFlagDetail())){
                if (prevMat== null){
                    history=history+" Flag Detail : "+this.getFlagDetail()+"<br>";
                }else{
                    history=history+" Flag Detail diubah dari "+prevMat.getFlagDetail()+" menjadi "+this.getFlagDetail()+"<br>";
                }
            }
            
            //1
            if (prevMat == null || !prevMat.getNoRekening().equals(this.getNoRekening())) {
                    if (prevMat == null) {
                        history = history + " Nomor Rekening : " + this.getNoRekening() + "<br>";
                    } else {
                        history = history + " Nomor Rekening diubah dari " + prevMat.getNoRekening() + " menjadi " + this.getNoRekening() + "<br>";
                    }
            }
            
            //2
            if (prevMat == null || !prevMat.getCif().equals(this.getCif())) {
                if (prevMat == null) {
                    history = history + " Nomor Rekening : " + this.getNoRekening() + "<br>";
                } else {
                    history = history + " CIF diubah dari " + prevMat.getCif()+ " menjadi " + this.getCif()+ "<br>";
                }
            }
            
            //3
            if (prevMat == null ||!prevMat.getKodeJenisGaransi().equals(this.getKodeJenisGaransi())) {
                if (prevMat == null) {
                    history = history + " Kode Jenis Garansi : " + this.getKodeJenisGaransi() + "<br>";
                } else {
                    history = history + " Kode Jenis Garansi diubah dari " + prevMat.getKodeJenisGaransi()+ " menjadi " + this.getKodeJenisGaransi()+ "<br>";
                }
            }
            
            //4
            if (prevMat == null || !prevMat.getKodeTujuanGaransi().equals(this.getKodeTujuanGaransi())) {
                if (prevMat == null) {
                    history = history + " Kode Tujuan Garansi : " + this.getKodeTujuanGaransi() + "<br>";
                } else {
                    history = history + " Kode Tujuan Garansi diubah dari " + prevMat.getKodeTujuanGaransi()+ " menjadi " + this.getKodeTujuanGaransi()+ "<br>";
                }
            }
            
            //5
            if (prevMat == null || !prevMat.getTglDiterbitkan().equals(this.getTglDiterbitkan())) {
                if (prevMat == null) {
                    history = history + " Tanggal diterbitkan : " + this.getTglDiterbitkan() + "<br>";
                } else {
                    history = history + " Tanggal diterbitkan diubah dari " + prevMat.getTglDiterbitkan()+ " menjadi " + this.getTglDiterbitkan()+ "<br>";
                }
            }
            
            //6
            if (prevMat == null || !prevMat.getTglJatuhTempo().equals(this.getTglJatuhTempo())) {
                if (prevMat == null) {
                    history = history + " Tanggal Jatuh Tempo : " + this.getTglJatuhTempo() + "<br>";
                } else {
                    history = history + " Tanggal Jatuh Tempo diubah dari " + prevMat.getTglJatuhTempo()+ " menjadi " + this.getTglJatuhTempo()+ "<br>";
                }
            }
            
            //7
            if (prevMat == null || !prevMat.getNoAkadAwal().equals(this.getNoAkadAwal())) {
                if (prevMat == null) {
                    history = history + " Nomor akad awal : " + this.getNoAkadAwal() + "<br>";
                } else {
                    history = history + " Nomor akad awal diubah dari " + prevMat.getNoAkadAwal()+ " menjadi " + this.getNoAkadAwal()+ "<br>";
                }
            }
            
            //8
            if (prevMat == null || !prevMat.getTglAkadAwal().equals(this.getTglAkadAwal())) {
                if (prevMat == null) {
                    history = history + " Tanggal akad awal : " + this.getTglAkadAwal() + "<br>";
                } else {
                    history = history + " Tanggal akad awal diubah dari " + prevMat.getTglAkadAwal()+ " menjadi " + this.getTglAkadAwal()+ "<br>";
                }               
            }
            
            //9
            if (prevMat == null || !prevMat.getNoAkadAkhir().equals(this.getNoAkadAkhir())) {
                if (prevMat == null) {
                    history = history + " Nomor akad akhir : " + this.getNoAkadAkhir() + "<br>";
                } else {
                    history = history + " Nomor akad akhir diubah dari " + prevMat.getNoAkadAkhir()+ " menjadi " + this.getNoAkadAkhir()+ "<br>";
                }
            }
            
            //10
            if (prevMat == null || !prevMat.getTglAkadAkhir().equals(this.getTglAkadAkhir())) {
                if (prevMat == null) {
                    history = history + " Tanggal akad akhir : " + this.getTglAkadAkhir() + "<br>";
                } else {
                    history = history + " Tanggal akad akhir diubah dari " + prevMat.getTglAkadAkhir()+ " menjadi " + this.getTglAkadAkhir()+ "<br>";
                }
            }
            
            //11
            if (prevMat == null || !prevMat.getNamaYgDijamin().equals(this.getNamaYgDijamin())) {
                if (prevMat == null) {
                    history = history + " Nama yang dijamin : " + this.getNamaYgDijamin() + "<br>";
                } else {
                    history = history + " Nama yang dijamin diubah dari " + prevMat.getNamaYgDijamin()+ " menjadi " + this.getNamaYgDijamin()+ "<br>";
                }
            }
            
            //12
            if (prevMat == null || !prevMat.getKodeValuta().equals(this.getKodeValuta())) {
                if (prevMat == null) {
                    history = history + " Kode valuta : " + this.getKodeValuta() + "<br>";
                } else {
                    history = history + " Kode valuta diubah dari " + prevMat.getKodeValuta()+ " menjadi " + this.getKodeValuta()+ "<br>";
                }
            }
            
            //13
            if (prevMat == null || prevMat.getPlafon()!= this.getPlafon()) {
                if (prevMat == null) {
                    history = history + " Plafon : " + Formater.formatNumber(this.getPlafon(),"#,###") + "<br>";
                } else {
                    history = history + " Plafon diubah dari " + Formater.formatNumber(prevMat.getPlafon(),"#,###")+ " menjadi " + Formater.formatNumber(this.getPlafon(),"#,###")+ "<br>"; 
                }
            }
            
            //14
            if (prevMat == null || prevMat.getNominal()!= this.getNominal()) {
                if (prevMat == null) {
                    history = history + " Nominal : " + Formater.formatNumber(this.getNominal(),"#,###") + "<br>";
                } else {
                    history = history + " Nominal diubah dari " + Formater.formatNumber(prevMat.getNominal(),"#,###")+ " menjadi " + Formater.formatNumber(this.getNominal(),"#,###")+ "<br>";
                }
            }
            
            //15
            if (prevMat == null || prevMat.getSetoranJaminan()!= this.getSetoranJaminan()) {
                if (prevMat == null) {
                    history = history + " Setoran jaminan : " + Formater.formatNumber(this.getSetoranJaminan(),"#,###") + "<br>";
                } else {
                     history = history + " Setoran jaminan diubah dari " + Formater.formatNumber(prevMat.getSetoranJaminan(),"#,###")+ " menjadi " + Formater.formatNumber(this.getSetoranJaminan(),"#,###")+ "<br>";
                }
            }
            
            //16
            if (prevMat == null || !prevMat.getKodeKolektibilitas().equals(this.getKodeKolektibilitas())) {
                if (prevMat == null) {
                    history = history + " Kode kolektibilitas : " + this.getKodeKolektibilitas() + "<br>";
                } else {
                    history = history + " Kode kolektibilitas diubah dari " + prevMat.getKodeKolektibilitas()+ " menjadi " + this.getKodeKolektibilitas()+ "<br>";
                }
            }
            
            //17
            if (prevMat == null || !prevMat.getTglWanPrestasi().equals(this.getTglWanPrestasi())) {
                if (prevMat == null) {
                    history = history + " Tanggal wan prestasi : " + this.getTglWanPrestasi() + "<br>";
                } else {
                    history = history + " Tanggal wan prestasi diubah dari " + prevMat.getTglWanPrestasi()+ " menjadi " + this.getTglWanPrestasi()+ "<br>";
                }
            }
            
            //18
            if (prevMat == null || !prevMat.getKodeKondisi().equals(this.getKodeKondisi())) {
                if (prevMat == null) {
                    history = history + " Kode kondisi : " + this.getKodeKondisi() + "<br>";
                } else {
                    history = history + " Kode kondisi diubah dari " + prevMat.getKodeKondisi()+ " menjadi " + this.getKodeKondisi()+ "<br>";
                }
            }
            
            //19
            if (prevMat == null || !prevMat.getTglKondisi().equals(this.getTglKondisi())) {
                if (prevMat == null) {
                    history = history + " Tanggal kondisi : " + this.getTglKondisi() + "<br>";
                } else {
                    history = history + " Tanggal kondisi diubah dari " + prevMat.getTglKondisi()+ " menjadi " + this.getTglKondisi()+ "<br>";
                }
            }
            
            //20
            if (prevMat == null || !prevMat.getKeterangan().equals(this.getKeterangan())) {
                if (prevMat == null) {
                    history = history + " Keterangan : " + this.getKeterangan() + "<br>";
                } else {
                    history = history + " Keterangan diubah dari " + prevMat.getKeterangan()+ " menjadi " + this.getKeterangan()+ "<br>";
                }
            }
            
            //21
            if (prevMat == null || !prevMat.getKodeKantorCabang().equals(this.getKodeKantorCabang())) {
                if (prevMat == null) {
                    history = history + " Kode kantor : " + this.getKodeKantorCabang() + "<br>";
                } else {
                    history = history + " Kode kantor cabang diubah dari " + prevMat.getKodeKantorCabang()+ " menjadi " + this.getKodeKantorCabang()+ "<br>";
                }
            }
            
            //22
            if (prevMat == null || !prevMat.getOperasiData().equals(this.getOperasiData())) {
                if (prevMat == null) {
                    history = history + " Operasi data : " + this.getOperasiData() + "<br>";
                } else {
                     history = history + " Operasi data diubah dari " + prevMat.getOperasiData()+ " menjadi " + this.getOperasiData()+ "<br>";
                }
            }
            
            //23
            if (prevMat == null || !prevMat.getOpenDate().equals(this.getOpenDate())) {
                if (prevMat == null) {
                    history = history + " Open date  : " + this.getOpenDate() + "<br>";
                } else {
                    history = history + " Open date diubah dari " + prevMat.getOpenDate()+ " menjadi " + this.getOpenDate()+ "<br>";
                }
            }
            
            //24
            if (prevMat == null || prevMat.getStatusData() != this.getStatusData()) {
                if (prevMat == null) {
                    history = history + " Status data  : " + this.getStatusData() + "<br>";
                } else {
                    history = history + " Status data diubah dari " + prevMat.getStatusData()+ " menjadi " + this.getStatusData()+ "<br>";
                }
            }
            
        } catch (Exception e) {
            System.out.println(""+e.toString()+"");
        }
       
        
        return history;
    }

    /**
     * @return the tujuanGransi
     */
    public String getTujuanGaransi() {
        if (getTujuanGransi()==null){
            setTujuanGransi("");
        }
        return getTujuanGransi();
    }

    /**
     * @param tujuanGransi the tujuanGransi to set
     */
    public void setTujuanGaransi(String tujuanGransi) {
        if (tujuanGransi==null){
            this.setTujuanGransi("");
        }else{
            this.setTujuanGransi(tujuanGransi);
        }
        
    }

    /**
     * @return the jenisGaranasi
     */
    public String getJenisGaransi() {
        if (getJenisGaranasi()==null){
            setJenisGaranasi("");
        }
        return getJenisGaranasi();
    }

    /**
     * @param jenisGaranasi the jenisGaranasi to set
     */
    public void setJenisGaransi(String jenisGaranasi) {
        if (jenisGaranasi==null){
            this.setJenisGaranasi("");
        }else{
            this.setJenisGaranasi(jenisGaranasi);
        }
        
    }

    /**
     * @return the sqlHistory
     */
    public String getSqlHistory() {
        return sqlHistory;
    }

    /**
     * @param sqlHistory the sqlHistory to set
     */
    public void setSqlHistory(String sqlHistory) {
        this.sqlHistory = sqlHistory;
    }

    /**
     * @return the periodeid
     */
    public long getPeriodeid() {
        return getPeriodeId();
    }

    /**
     * @param periodeid the periodeid to set
     */
    public void setPeriodeid(long periodeid) {
        this.setPeriodeId(periodeid);
    }

    /**
     * @return the debiturOid
     */
    public long getDebiturOid() {
        return debiturOid;
    }

    /**
     * @param debiturOid the debiturOid to set
     */
    public void setDebiturOid(long debiturOid) {
        this.debiturOid = debiturOid;
    }

    /**
     * @return the debiturType
     */
    public int getDebiturType() {
        return debiturType;
    }

    /**
     * @param debiturType the debiturType to set
     */
    public void setDebiturType(int debiturType) {
        this.debiturType = debiturType;
    }

    /**
     * @return the statusOperasiData
     */
    public int getStatusOperasiData() {
        return statusOperasiData;
    }

    /**
     * @param statusOperasiData the statusOperasiData to set
     */
    public void setStatusOperasiData(int statusOperasiData) {
        this.statusOperasiData = statusOperasiData;
    }

    /**
     * @return the statusPerubahanData
     */
    public int getStatusPerubahanData() {
        return statusPerubahanData;
    }

    /**
     * @param statusPerubahanData the statusPerubahanData to set
     */
    public void setStatusPerubahanData(int statusPerubahanData) {
        this.statusPerubahanData = statusPerubahanData;
    }

    /**
     * @return the kodeBankGransiReport
     */
    public String getKodeBankGransiReport() {
        return kodeBankGransiReport;
    }

    /**
     * @param kodeBankGransiReport the kodeBankGransiReport to set
     */
    public void setKodeBankGransiReport(String kodeBankGransiReport) {
        this.kodeBankGransiReport = kodeBankGransiReport;
    }

    /**
     * @return the namaBankGaransiReport
     */
    public String getNamaBankGaransiReport() {
        return namaBankGaransiReport;
    }

    /**
     * @param namaBankGaransiReport the namaBankGaransiReport to set
     */
    public void setNamaBankGaransiReport(String namaBankGaransiReport) {
        this.namaBankGaransiReport = namaBankGaransiReport;
    }

    /**
     * @return the totalBankGaransi
     */
    public int getTotalBankGaransi() {
        return totalBankGaransi;
    }

    /**
     * @param totalBankGaransi the totalBankGaransi to set
     */
    public void setTotalBankGaransi(int totalBankGaransi) {
        this.totalBankGaransi = totalBankGaransi;
    }

    /**
     * @return the totNominalBankGaransi
     */
    public double getTotNominalBankGaransi() {
        return totNominalBankGaransi;
    }

    /**
     * @param totNominalBankGaransi the totNominalBankGaransi to set
     */
    public void setTotNominalBankGaransi(double totNominalBankGaransi) {
        this.totNominalBankGaransi = totNominalBankGaransi;
    }

    

    /**
     * @return the tujuanGransi
     */
    public String getTujuanGransi() {
        return tujuanGransi;
    }

    /**
     * @param tujuanGransi the tujuanGransi to set
     */
    public void setTujuanGransi(String tujuanGransi) {
        this.tujuanGransi = tujuanGransi;
    }

    /**
     * @return the jenisGaranasi
     */
    public String getJenisGaranasi() {
        return jenisGaranasi;
    }

    /**
     * @param jenisGaranasi the jenisGaranasi to set
     */
    public void setJenisGaranasi(String jenisGaranasi) {
        this.jenisGaranasi = jenisGaranasi;
    }

    /**
     * @return the periodeId
     */
    public long getPeriodeId() {
        return periodeId;
    }

    /**
     * @param periodeId the periodeId to set
     */
    public void setPeriodeId(long periodeId) {
        this.periodeId = periodeId;
    }

    /**
     * @return the validasiNoRekening
     */
    public String getValidasiNoRekening() {
        return validasiNoRekening;
    }

    /**
     * @param validasiNoRekening the validasiNoRekening to set
     */
    public void setValidasiNoRekening(String validasiNoRekening) {
        this.validasiNoRekening = validasiNoRekening;
    }

    /**
     * @return the validasiCif
     */
    public String getValidasiCif() {
        return validasiCif;
    }

    /**
     * @param validasiCif the validasiCif to set
     */
    public void setValidasiCif(String validasiCif) {
        this.validasiCif = validasiCif;
    }

    /**
     * @return the validasiKodeJenisGaransi
     */
    public String getValidasiKodeJenisGaransi() {
        return validasiKodeJenisGaransi;
    }

    /**
     * @param validasiKodeJenisGaransi the validasiKodeJenisGaransi to set
     */
    public void setValidasiKodeJenisGaransi(String validasiKodeJenisGaransi) {
        this.validasiKodeJenisGaransi = validasiKodeJenisGaransi;
    }

    /**
     * @return the validasiKodeTujuanGaransi
     */
    public String getValidasiKodeTujuanGaransi() {
        return validasiKodeTujuanGaransi;
    }

    /**
     * @param validasiKodeTujuanGaransi the validasiKodeTujuanGaransi to set
     */
    public void setValidasiKodeTujuanGaransi(String validasiKodeTujuanGaransi) {
        this.validasiKodeTujuanGaransi = validasiKodeTujuanGaransi;
    }

    /**
     * @return the validasiTglDiterbitkan
     */
    public String getValidasiTglDiterbitkan() {
        return validasiTglDiterbitkan;
    }

    /**
     * @param validasiTglDiterbitkan the validasiTglDiterbitkan to set
     */
    public void setValidasiTglDiterbitkan(String validasiTglDiterbitkan) {
        this.validasiTglDiterbitkan = validasiTglDiterbitkan;
    }

    /**
     * @return the validasiTglJatuhTempo
     */
    public String getValidasiTglJatuhTempo() {
        return validasiTglJatuhTempo;
    }

    /**
     * @param validasiTglJatuhTempo the validasiTglJatuhTempo to set
     */
    public void setValidasiTglJatuhTempo(String validasiTglJatuhTempo) {
        this.validasiTglJatuhTempo = validasiTglJatuhTempo;
    }

    /**
     * @return the validasiNoAkadAwal
     */
    public String getValidasiNoAkadAwal() {
        return validasiNoAkadAwal;
    }

    /**
     * @param validasiNoAkadAwal the validasiNoAkadAwal to set
     */
    public void setValidasiNoAkadAwal(String validasiNoAkadAwal) {
        this.validasiNoAkadAwal = validasiNoAkadAwal;
    }

    /**
     * @return the validasiTglAkadAwal
     */
    public String getValidasiTglAkadAwal() {
        return validasiTglAkadAwal;
    }

    /**
     * @param validasiTglAkadAwal the validasiTglAkadAwal to set
     */
    public void setValidasiTglAkadAwal(String validasiTglAkadAwal) {
        this.validasiTglAkadAwal = validasiTglAkadAwal;
    }

    /**
     * @return the validasiNoAkadAkhir
     */
    public String getValidasiNoAkadAkhir() {
        return validasiNoAkadAkhir;
    }

    /**
     * @param validasiNoAkadAkhir the validasiNoAkadAkhir to set
     */
    public void setValidasiNoAkadAkhir(String validasiNoAkadAkhir) {
        this.validasiNoAkadAkhir = validasiNoAkadAkhir;
    }

    /**
     * @return the validasiTglAkadAkhir
     */
    public String getValidasiTglAkadAkhir() {
        return validasiTglAkadAkhir;
    }

    /**
     * @param validasiTglAkadAkhir the validasiTglAkadAkhir to set
     */
    public void setValidasiTglAkadAkhir(String validasiTglAkadAkhir) {
        this.validasiTglAkadAkhir = validasiTglAkadAkhir;
    }

    /**
     * @return the validasiNamaYgDijamin
     */
    public String getValidasiNamaYgDijamin() {
        return validasiNamaYgDijamin;
    }

    /**
     * @param validasiNamaYgDijamin the validasiNamaYgDijamin to set
     */
    public void setValidasiNamaYgDijamin(String validasiNamaYgDijamin) {
        this.validasiNamaYgDijamin = validasiNamaYgDijamin;
    }

    /**
     * @return the validasiKodeValuta
     */
    public String getValidasiKodeValuta() {
        return validasiKodeValuta;
    }

    /**
     * @param validasiKodeValuta the validasiKodeValuta to set
     */
    public void setValidasiKodeValuta(String validasiKodeValuta) {
        this.validasiKodeValuta = validasiKodeValuta;
    }

    /**
     * @return the validasiPlafon
     */
    public String getValidasiPlafon() {
        return validasiPlafon;
    }

    /**
     * @param validasiPlafon the validasiPlafon to set
     */
    public void setValidasiPlafon(String validasiPlafon) {
        this.validasiPlafon = validasiPlafon;
    }

    /**
     * @return the validasiNominal
     */
    public String getValidasiNominal() {
        return validasiNominal;
    }

    /**
     * @param validasiNominal the validasiNominal to set
     */
    public void setValidasiNominal(String validasiNominal) {
        this.validasiNominal = validasiNominal;
    }

    /**
     * @return the validasiSetoranJaminan
     */
    public String getValidasiSetoranJaminan() {
        return validasiSetoranJaminan;
    }

    /**
     * @param validasiSetoranJaminan the validasiSetoranJaminan to set
     */
    public void setValidasiSetoranJaminan(String validasiSetoranJaminan) {
        this.validasiSetoranJaminan = validasiSetoranJaminan;
    }

    /**
     * @return the validasiKodeKolektibilitas
     */
    public String getValidasiKodeKolektibilitas() {
        return validasiKodeKolektibilitas;
    }

    /**
     * @param validasiKodeKolektibilitas the validasiKodeKolektibilitas to set
     */
    public void setValidasiKodeKolektibilitas(String validasiKodeKolektibilitas) {
        this.validasiKodeKolektibilitas = validasiKodeKolektibilitas;
    }

    /**
     * @return the validasiTglWanPrestasi
     */
    public String getValidasiTglWanPrestasi() {
        return validasiTglWanPrestasi;
    }

    /**
     * @param validasiTglWanPrestasi the validasiTglWanPrestasi to set
     */
    public void setValidasiTglWanPrestasi(String validasiTglWanPrestasi) {
        this.validasiTglWanPrestasi = validasiTglWanPrestasi;
    }

    /**
     * @return the validasiKodeKondisi
     */
    public String getValidasiKodeKondisi() {
        return validasiKodeKondisi;
    }

    /**
     * @param validasiKodeKondisi the validasiKodeKondisi to set
     */
    public void setValidasiKodeKondisi(String validasiKodeKondisi) {
        this.validasiKodeKondisi = validasiKodeKondisi;
    }

    /**
     * @return the validasiTglKondisi
     */
    public String getValidasiTglKondisi() {
        return validasiTglKondisi;
    }

    /**
     * @param validasiTglKondisi the validasiTglKondisi to set
     */
    public void setValidasiTglKondisi(String validasiTglKondisi) {
        this.validasiTglKondisi = validasiTglKondisi;
    }

    /**
     * @return the validasiKeterangan
     */
    public String getValidasiKeterangan() {
        return validasiKeterangan;
    }

    /**
     * @param validasiKeterangan the validasiKeterangan to set
     */
    public void setValidasiKeterangan(String validasiKeterangan) {
        this.validasiKeterangan = validasiKeterangan;
    }

    /**
     * @return the validasiTujuanGransi
     */
    public String getValidasiTujuanGransi() {
        return validasiTujuanGransi;
    }

    /**
     * @param validasiTujuanGransi the validasiTujuanGransi to set
     */
    public void setValidasiTujuanGransi(String validasiTujuanGransi) {
        this.validasiTujuanGransi = validasiTujuanGransi;
    }

    /**
     * @return the validasiJenisGaranasi
     */
    public String getValidasiJenisGaranasi() {
        return validasiJenisGaranasi;
    }

    /**
     * @param validasiJenisGaranasi the validasiJenisGaranasi to set
     */
    public void setValidasiJenisGaranasi(String validasiJenisGaranasi) {
        this.validasiJenisGaranasi = validasiJenisGaranasi;
    }

    /**
     * @return the errorNoRekening
     */
    public String getErrorNoRekening() {
        return errorNoRekening;
    }

    /**
     * @param errorNoRekening the errorNoRekening to set
     */
    public void setErrorNoRekening(String errorNoRekening) {
        this.errorNoRekening = errorNoRekening;
    }

    /**
     * @return the errorCif
     */
    public String getErrorCif() {
        return errorCif;
    }

    /**
     * @param errorCif the errorCif to set
     */
    public void setErrorCif(String errorCif) {
        this.errorCif = errorCif;
    }

    /**
     * @return the errorKodeJenisGaransi
     */
    public String getErrorKodeJenisGaransi() {
        return errorKodeJenisGaransi;
    }

    /**
     * @param errorKodeJenisGaransi the errorKodeJenisGaransi to set
     */
    public void setErrorKodeJenisGaransi(String errorKodeJenisGaransi) {
        this.errorKodeJenisGaransi = errorKodeJenisGaransi;
    }

    /**
     * @return the errorKodeTujuanGaransi
     */
    public String getErrorKodeTujuanGaransi() {
        return errorKodeTujuanGaransi;
    }

    /**
     * @param errorKodeTujuanGaransi the errorKodeTujuanGaransi to set
     */
    public void setErrorKodeTujuanGaransi(String errorKodeTujuanGaransi) {
        this.errorKodeTujuanGaransi = errorKodeTujuanGaransi;
    }

    /**
     * @return the errorTglDiterbitkan
     */
    public String getErrorTglDiterbitkan() {
        return errorTglDiterbitkan;
    }

    /**
     * @param errorTglDiterbitkan the errorTglDiterbitkan to set
     */
    public void setErrorTglDiterbitkan(String errorTglDiterbitkan) {
        this.errorTglDiterbitkan = errorTglDiterbitkan;
    }

    /**
     * @return the errorTglJatuhTempo
     */
    public String getErrorTglJatuhTempo() {
        return errorTglJatuhTempo;
    }

    /**
     * @param errorTglJatuhTempo the errorTglJatuhTempo to set
     */
    public void setErrorTglJatuhTempo(String errorTglJatuhTempo) {
        this.errorTglJatuhTempo = errorTglJatuhTempo;
    }

    /**
     * @return the errorNoAkadAwal
     */
    public String getErrorNoAkadAwal() {
        return errorNoAkadAwal;
    }

    /**
     * @param errorNoAkadAwal the errorNoAkadAwal to set
     */
    public void setErrorNoAkadAwal(String errorNoAkadAwal) {
        this.errorNoAkadAwal = errorNoAkadAwal;
    }

    /**
     * @return the errorTglAkadAwal
     */
    public String getErrorTglAkadAwal() {
        return errorTglAkadAwal;
    }

    /**
     * @param errorTglAkadAwal the errorTglAkadAwal to set
     */
    public void setErrorTglAkadAwal(String errorTglAkadAwal) {
        this.errorTglAkadAwal = errorTglAkadAwal;
    }

    /**
     * @return the errorNoAkadAkhir
     */
    public String getErrorNoAkadAkhir() {
        return errorNoAkadAkhir;
    }

    /**
     * @param errorNoAkadAkhir the errorNoAkadAkhir to set
     */
    public void setErrorNoAkadAkhir(String errorNoAkadAkhir) {
        this.errorNoAkadAkhir = errorNoAkadAkhir;
    }

    /**
     * @return the errorTglAkadAkhir
     */
    public String getErrorTglAkadAkhir() {
        return errorTglAkadAkhir;
    }

    /**
     * @param errorTglAkadAkhir the errorTglAkadAkhir to set
     */
    public void setErrorTglAkadAkhir(String errorTglAkadAkhir) {
        this.errorTglAkadAkhir = errorTglAkadAkhir;
    }

    /**
     * @return the errorNamaYgDijamin
     */
    public String getErrorNamaYgDijamin() {
        return errorNamaYgDijamin;
    }

    /**
     * @param errorNamaYgDijamin the errorNamaYgDijamin to set
     */
    public void setErrorNamaYgDijamin(String errorNamaYgDijamin) {
        this.errorNamaYgDijamin = errorNamaYgDijamin;
    }

    /**
     * @return the errorKodeValuta
     */
    public String getErrorKodeValuta() {
        return errorKodeValuta;
    }

    /**
     * @param errorKodeValuta the errorKodeValuta to set
     */
    public void setErrorKodeValuta(String errorKodeValuta) {
        this.errorKodeValuta = errorKodeValuta;
    }

    /**
     * @return the errorPlafon
     */
    public String getErrorPlafon() {
        return errorPlafon;
    }

    /**
     * @param errorPlafon the errorPlafon to set
     */
    public void setErrorPlafon(String errorPlafon) {
        this.errorPlafon = errorPlafon;
    }

    /**
     * @return the errorNominal
     */
    public String getErrorNominal() {
        return errorNominal;
    }

    /**
     * @param errorNominal the errorNominal to set
     */
    public void setErrorNominal(String errorNominal) {
        this.errorNominal = errorNominal;
    }

    /**
     * @return the errorSetoranJaminan
     */
    public String getErrorSetoranJaminan() {
        return errorSetoranJaminan;
    }

    /**
     * @param errorSetoranJaminan the errorSetoranJaminan to set
     */
    public void setErrorSetoranJaminan(String errorSetoranJaminan) {
        this.errorSetoranJaminan = errorSetoranJaminan;
    }

    /**
     * @return the errorKodeKolektibilitas
     */
    public String getErrorKodeKolektibilitas() {
        return errorKodeKolektibilitas;
    }

    /**
     * @param errorKodeKolektibilitas the errorKodeKolektibilitas to set
     */
    public void setErrorKodeKolektibilitas(String errorKodeKolektibilitas) {
        this.errorKodeKolektibilitas = errorKodeKolektibilitas;
    }

    /**
     * @return the errorTglWanPrestasi
     */
    public String getErrorTglWanPrestasi() {
        return errorTglWanPrestasi;
    }

    /**
     * @param errorTglWanPrestasi the errorTglWanPrestasi to set
     */
    public void setErrorTglWanPrestasi(String errorTglWanPrestasi) {
        this.errorTglWanPrestasi = errorTglWanPrestasi;
    }

    /**
     * @return the errorKodeKondisi
     */
    public String getErrorKodeKondisi() {
        return errorKodeKondisi;
    }

    /**
     * @param errorKodeKondisi the errorKodeKondisi to set
     */
    public void setErrorKodeKondisi(String errorKodeKondisi) {
        this.errorKodeKondisi = errorKodeKondisi;
    }

    /**
     * @return the errorTglKondisi
     */
    public String getErrorTglKondisi() {
        return errorTglKondisi;
    }

    /**
     * @param errorTglKondisi the errorTglKondisi to set
     */
    public void setErrorTglKondisi(String errorTglKondisi) {
        this.errorTglKondisi = errorTglKondisi;
    }

    /**
     * @return the errorKeterangan
     */
    public String getErrorKeterangan() {
        return errorKeterangan;
    }

    /**
     * @param errorKeterangan the errorKeterangan to set
     */
    public void setErrorKeterangan(String errorKeterangan) {
        this.errorKeterangan = errorKeterangan;
    }

    /**
     * @return the errorTujuanGransi
     */
    public String getErrorTujuanGransi() {
        return errorTujuanGransi;
    }

    /**
     * @param errorTujuanGransi the errorTujuanGransi to set
     */
    public void setErrorTujuanGransi(String errorTujuanGransi) {
        this.errorTujuanGransi = errorTujuanGransi;
    }

    /**
     * @return the errorJenisGaranasi
     */
    public String getErrorJenisGaranasi() {
        return errorJenisGaranasi;
    }

    /**
     * @param errorJenisGaranasi the errorJenisGaranasi to set
     */
    public void setErrorJenisGaranasi(String errorJenisGaranasi) {
        this.errorJenisGaranasi = errorJenisGaranasi;
    }

    /**
     * @return the isNotValid
     */
    public boolean isIsNotValid() {
        return isNotValid;
    }

    /**
     * @param isNotValid the isNotValid to set
     */
    public void setIsNotValid(boolean isNotValid) {
        this.isNotValid = isNotValid;
    }
    
    
    @Override
    public Entity getValidasiDetail(Entity prevDoc) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        BankGaransi bankGaransiValidasi = (BankGaransi)prevDoc;
        bankGaransiValidasi.setIsNotValid(false);
        
        try{
            if(bankGaransiValidasi.getKodeKondisi().equals("02")){
                if(bankGaransiValidasi.getNominal()!=0){
                    bankGaransiValidasi.setNominal(0);
                    bankGaransiValidasi.setValidasiNominal("data-required='required'");
                    bankGaransiValidasi.setErrorNominal("NOMINAL  (IDR), nilai field NOMINAL  (IDR) harus sama dengan 0, karena kode kondisi '02' dengan kategori kondisi 'DEBITUR TIDAK MEMILIKI KEWAJIBAN'");
                    bankGaransiValidasi.setIsNotValid(true);
                }
            }
        }catch(Exception ex){
        
        }
        
        try{
            if(!bankGaransiValidasi.getKodeKondisi().equals("00")){
                if(bankGaransiValidasi.getTglKondisi()==null){
                    bankGaransiValidasi.setValidasiTglKondisi("data-required='required'");
                    bankGaransiValidasi.setErrorTglKondisi("TANGGAL KONDISI, wajib diisi. KODE KONDISI tidak sama dengan 00");
                    bankGaransiValidasi.setIsNotValid(true);
                }
            }
        }catch(Exception ex){
        
        }
        
        return  bankGaransiValidasi;
    }
}
