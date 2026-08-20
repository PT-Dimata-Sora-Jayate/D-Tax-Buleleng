/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.dtaxintegration.entity.payment;

import com.dimata.qdep.entity.Entity;
import java.util.Date;

/**
 *
 * @author IanRizky
 */
public class PaymentBphtbIprotax extends Entity{
	private String kdProvinsi="";
    private String kdDati2="";
	private String thbBphtb="";
	private String blnBphtb="";
	private String tglBphtb="";
	private String noUrutBphtb="";
	private String indeksBphtb="";
	private String kdPejabat="";
	private String kdBankTunggal="";
	private String kdBankPersepsi="";
	private Date tglPembayaran= new Date();
	private String noTransBayar="" ;
	private String namaWP="";
	private double bphtbKurangBayar=0;
	private double bphtbSdhBayar=0;
	private String kdKecamatanOp="";
	private String kdKelurahanOp="";
	private String kdBlokOp="";
	private String noUrutOp="";
	private String kdJnsOp="";
	private String kdTp="";
	private String userBankRekam="";
	private String nmPenyetor="";
	private String kdSumberData="";
	private String noTransaksiBayar="";
	private String noTransaksiBayarBank="";
	private int status=0;
	private Date tglPembayaranReal= new Date();

	/**
	 * @return the kdProvinsi
	 */
	public String getKdProvinsi() {
		return kdProvinsi;
	}

	/**
	 * @param kdProvinsi the kdProvinsi to set
	 */
	public void setKdProvinsi(String kdProvinsi) {
		this.kdProvinsi = kdProvinsi;
	}

	/**
	 * @return the kdDati2
	 */
	public String getKdDati2() {
		return kdDati2;
	}

	/**
	 * @param kdDati2 the kdDati2 to set
	 */
	public void setKdDati2(String kdDati2) {
		this.kdDati2 = kdDati2;
	}

	/**
	 * @return the thbBphtb
	 */
	public String getThbBphtb() {
		return thbBphtb;
	}

	/**
	 * @param thbBphtb the thbBphtb to set
	 */
	public void setThbBphtb(String thbBphtb) {
		this.thbBphtb = thbBphtb;
	}

	/**
	 * @return the blnBphtb
	 */
	public String getBlnBphtb() {
		return blnBphtb;
	}

	/**
	 * @param blnBphtb the blnBphtb to set
	 */
	public void setBlnBphtb(String blnBphtb) {
		this.blnBphtb = blnBphtb;
	}

	/**
	 * @return the tglBphtb
	 */
	public String getTglBphtb() {
		return tglBphtb;
	}

	/**
	 * @param tglBphtb the tglBphtb to set
	 */
	public void setTglBphtb(String tglBphtb) {
		this.tglBphtb = tglBphtb;
	}

	/**
	 * @return the noUrutBphtb
	 */
	public String getNoUrutBphtb() {
		return noUrutBphtb;
	}

	/**
	 * @param noUrutBphtb the noUrutBphtb to set
	 */
	public void setNoUrutBphtb(String noUrutBphtb) {
		this.noUrutBphtb = noUrutBphtb;
	}

	/**
	 * @return the indeksBphtb
	 */
	public String getIndeksBphtb() {
		return indeksBphtb;
	}

	/**
	 * @param indeksBphtb the indeksBphtb to set
	 */
	public void setIndeksBphtb(String indeksBphtb) {
		this.indeksBphtb = indeksBphtb;
	}

	/**
	 * @return the kdPejabat
	 */
	public String getKdPejabat() {
		return kdPejabat;
	}

	/**
	 * @param kdPejabat the kdPejabat to set
	 */
	public void setKdPejabat(String kdPejabat) {
		this.kdPejabat = kdPejabat;
	}

	/**
	 * @return the kdBankTunggal
	 */
	public String getKdBankTunggal() {
		return kdBankTunggal;
	}

	/**
	 * @param kdBankTunggal the kdBankTunggal to set
	 */
	public void setKdBankTunggal(String kdBankTunggal) {
		this.kdBankTunggal = kdBankTunggal;
	}

	/**
	 * @return the kdBankPersepsi
	 */
	public String getKdBankPersepsi() {
		return kdBankPersepsi;
	}

	/**
	 * @param kdBankPersepsi the kdBankPersepsi to set
	 */
	public void setKdBankPersepsi(String kdBankPersepsi) {
		this.kdBankPersepsi = kdBankPersepsi;
	}

	/**
	 * @return the tglPembayaran
	 */
	public Date getTglPembayaran() {
		return tglPembayaran;
	}

	/**
	 * @param tglPembayaran the tglPembayaran to set
	 */
	public void setTglPembayaran(Date tglPembayaran) {
		this.tglPembayaran = tglPembayaran;
	}

	/**
	 * @return the noTransBayar
	 */
	public String getNoTransBayar() {
		return noTransBayar;
	}

	/**
	 * @param noTransBayar the noTransBayar to set
	 */
	public void setNoTransBayar(String noTransBayar) {
		this.noTransBayar = noTransBayar;
	}

	/**
	 * @return the namaWP
	 */
	public String getNamaWP() {
		return namaWP;
	}

	/**
	 * @param namaWP the namaWP to set
	 */
	public void setNamaWP(String namaWP) {
		this.namaWP = namaWP;
	}

	/**
	 * @return the bphtbKurangBayar
	 */
	public double getBphtbKurangBayar() {
		return bphtbKurangBayar;
	}

	/**
	 * @param bphtbKurangBayar the bphtbKurangBayar to set
	 */
	public void setBphtbKurangBayar(double bphtbKurangBayar) {
		this.bphtbKurangBayar = bphtbKurangBayar;
	}

	/**
	 * @return the bphtbSdhBayar
	 */
	public double getBphtbSdhBayar() {
		return bphtbSdhBayar;
	}

	/**
	 * @param bphtbSdhBayar the bphtbSdhBayar to set
	 */
	public void setBphtbSdhBayar(double bphtbSdhBayar) {
		this.bphtbSdhBayar = bphtbSdhBayar;
	}

	/**
	 * @return the kdKecamatanOp
	 */
	public String getKdKecamatanOp() {
		return kdKecamatanOp;
	}

	/**
	 * @param kdKecamatanOp the kdKecamatanOp to set
	 */
	public void setKdKecamatanOp(String kdKecamatanOp) {
		this.kdKecamatanOp = kdKecamatanOp;
	}

	/**
	 * @return the kdKelurahanOp
	 */
	public String getKdKelurahanOp() {
		return kdKelurahanOp;
	}

	/**
	 * @param kdKelurahanOp the kdKelurahanOp to set
	 */
	public void setKdKelurahanOp(String kdKelurahanOp) {
		this.kdKelurahanOp = kdKelurahanOp;
	}

	/**
	 * @return the kdBlokOp
	 */
	public String getKdBlokOp() {
		return kdBlokOp;
	}

	/**
	 * @param kdBlokOp the kdBlokOp to set
	 */
	public void setKdBlokOp(String kdBlokOp) {
		this.kdBlokOp = kdBlokOp;
	}

	/**
	 * @return the noUrutOp
	 */
	public String getNoUrutOp() {
		return noUrutOp;
	}

	/**
	 * @param noUrutOp the noUrutOp to set
	 */
	public void setNoUrutOp(String noUrutOp) {
		this.noUrutOp = noUrutOp;
	}

	/**
	 * @return the kdJnsOp
	 */
	public String getKdJnsOp() {
		return kdJnsOp;
	}

	/**
	 * @param kdJnsOp the kdJnsOp to set
	 */
	public void setKdJnsOp(String kdJnsOp) {
		this.kdJnsOp = kdJnsOp;
	}

	/**
	 * @return the kdTp
	 */
	public String getKdTp() {
		return kdTp;
	}

	/**
	 * @param kdTp the kdTp to set
	 */
	public void setKdTp(String kdTp) {
		this.kdTp = kdTp;
	}

	/**
	 * @return the userBankRekam
	 */
	public String getUserBankRekam() {
		return userBankRekam;
	}

	/**
	 * @param userBankRekam the userBankRekam to set
	 */
	public void setUserBankRekam(String userBankRekam) {
		this.userBankRekam = userBankRekam;
	}

	/**
	 * @return the nmPenyetor
	 */
	public String getNmPenyetor() {
		return nmPenyetor;
	}

	/**
	 * @param nmPenyetor the nmPenyetor to set
	 */
	public void setNmPenyetor(String nmPenyetor) {
		this.nmPenyetor = nmPenyetor;
	}

	/**
	 * @return the kdSumberData
	 */
	public String getKdSumberData() {
		return kdSumberData;
	}

	/**
	 * @param kdSumberData the kdSumberData to set
	 */
	public void setKdSumberData(String kdSumberData) {
		this.kdSumberData = kdSumberData;
	}

	/**
	 * @return the noTransaksiBayar
	 */
	public String getNoTransaksiBayar() {
		return noTransaksiBayar;
	}

	/**
	 * @param noTransaksiBayar the noTransaksiBayar to set
	 */
	public void setNoTransaksiBayar(String noTransaksiBayar) {
		this.noTransaksiBayar = noTransaksiBayar;
	}

	/**
	 * @return the noTransaksiBayarBank
	 */
	public String getNoTransaksiBayarBank() {
		return noTransaksiBayarBank;
	}

	/**
	 * @param noTransaksiBayarBank the noTransaksiBayarBank to set
	 */
	public void setNoTransaksiBayarBank(String noTransaksiBayarBank) {
		this.noTransaksiBayarBank = noTransaksiBayarBank;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the tglPembayaranReal
	 */
	public Date getTglPembayaranReal() {
		return tglPembayaranReal;
	}

	/**
	 * @param tglPembayaranReal the tglPembayaranReal to set
	 */
	public void setTglPembayaranReal(Date tglPembayaranReal) {
		this.tglPembayaranReal = tglPembayaranReal;
	}
   
}
