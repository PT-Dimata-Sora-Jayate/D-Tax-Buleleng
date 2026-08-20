/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.webservice;

import com.dimata.qdep.db.DBHandler;
import com.dimata.qdep.db.DBResultSet;
import com.dimata.qdep.form.FRMQueryString;
import com.dimata.util.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author IanRizky
 */
public class phrService extends HttpServlet {

	private String idCategory = "";
	private String idType = "";
	private String idKabupaten = "";
	private String tahun = "";
	
	private boolean error = true;
    private String message = "belum ada data";
	
	private JSONObject jSONObject = new JSONObject();
    private JSONArray jSONArray = new JSONArray();
    private JSONObject dataCostum = null;
	
    private int iCommand = 0;
    private int iErrCode = 0;
	
	private int KODE_PAJAK_HOTEL = 0;
	private int KODE_PAJAK_RESTO = 1;
	
	private String[] kodePajak = {
		"none","41101","41102"
	};
	
	private String[] kodePajakIdType = {
		"0","1","2"
	};
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		this.idCategory = FRMQueryString.requestString(request, "id_category");
		this.idType = FRMQueryString.requestString(request, "id_type");
		this.idKabupaten = FRMQueryString.requestString(request, "id_kabupaten");
		this.tahun = FRMQueryString.requestString(request, "tahun");
		this.iCommand = FRMQueryString.requestCommand(request);
		this.iErrCode = 0;
		
		this.jSONObject = new JSONObject();
        this.jSONArray = new JSONArray();
        this.dataCostum = null;
		
		
		String authValue = request.getHeader("cti-auth-token");
		
		if (authValue.equals("vARIvmKf8dmTnB0TH7DVHNol0OGkOzOzxDHiNZ0FNwb5e8TfwLaiFN0p7G9GfIeVzPQ0efEyFm3QW8vYADc0rWmBNIwHfdIbj585DWtgPBpdfRnsTguM3QuIWwsbxLPIWPqpeHuZIdqy4ny5oKiZ7kohoq4PBBGGrjlw7d6mXS4khlDvfq5z5eOKQLWnK3gnLDXlV7gQ")){
			if (idCategory.equals("1")){

				if (idType.equals("")){
					for (int i = 0 ; i < kodePajak.length; i++){
						String sql = "SELECT * FROM (SELECT BULAN,TARGET FROM VIEW_TARGET WHERE TAHUN='"+tahun+"'";
						sql += " AND NO_REKENING LIKE '"+kodePajak[i]+"%') PIVOT (SUM(TARGET) FOR BULAN IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[i]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
					}
				} else {
					String sql = "SELECT * FROM (SELECT BULAN,TARGET FROM VIEW_TARGET WHERE TAHUN='"+tahun+"'";
						sql += " AND NO_REKENING LIKE '"+kodePajak[Integer.valueOf(idType)]+"%') PIVOT (SUM(TARGET) FOR BULAN IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[Integer.valueOf(idType)]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
				}
			} else if (idCategory.equals("2")){

				if (idType.equals("")){
					for (int i = 0 ; i < kodePajak.length; i++){
						String sql = "SELECT * FROM (SELECT TO_CHAR(TGL_SSPD, 'mm') AS M,SETORAN FROM VIEW_PEMBAYARAN_SIMPATDA WHERE TO_CHAR(TGL_SSPD, 'yyyy')='"+tahun+"'";
						sql += " AND NO_REKENING = '"+kodePajak[i]+"') PIVOT (SUM(SETORAN) FOR M IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[i]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
					}
				} else {
					String sql = "SELECT * FROM (SELECT TO_CHAR(TGL_SSPD, 'mm') AS M,SETORAN FROM VIEW_PEMBAYARAN_SIMPATDA WHERE TO_CHAR(TGL_SSPD, 'yyyy')='"+tahun+"'";
						sql += " AND NO_REKENING = '"+kodePajak[Integer.valueOf(idType)]+"') PIVOT (SUM(SETORAN) FOR M IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[Integer.valueOf(idType)]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
				}
			} else if (idCategory.equals("3")){

				if (idType.equals("")){
					for (int i = 0 ; i < kodePajak.length; i++){
						String sql = "SELECT * FROM (SELECT TO_CHAR(TGL_REKAM, 'mm') AS M,HARUS_DIBAYAR FROM VIEW_ALL_SIMPATDA WHERE TO_CHAR(TGL_REKAM, 'yyyy')='"+tahun+"'";
						sql += " AND NO_REKENING = '"+kodePajak[i]+"') PIVOT (SUM(HARUS_DIBAYAR) FOR M IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[i]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
					}
				} else {
					String sql = "SELECT * FROM (SELECT TO_CHAR(TGL_REKAM, 'mm') AS M,HARUS_DIBAYAR FROM VIEW_ALL_SIMPATDA WHERE TO_CHAR(TGL_REKAM, 'yyyy')='"+tahun+"'";
						sql += " AND NO_REKENING = '"+kodePajak[Integer.valueOf(idType)]+"') PIVOT (SUM(HARUS_DIBAYAR) FOR M IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[Integer.valueOf(idType)]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
				}
			} else if (idCategory.equals("5")){

				if (idType.equals("")){
					for (int i = 0 ; i < kodePajak.length; i++){
						String sql = "SELECT * FROM (SELECT TO_CHAR(TGL_REKAM, 'mm') AS M,NAMA FROM VIEW_ALL_SIMPATDA WHERE TO_CHAR(TGL_REKAM, 'yyyy')='"+tahun+"'";
						sql += " AND NO_REKENING = '"+kodePajak[i]+"') PIVOT (COUNT(NAMA) FOR M IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[i]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
					}
				} else {
					String sql = "SELECT * FROM (SELECT TO_CHAR(TGL_REKAM, 'mm') AS M,NAMA FROM VIEW_ALL_SIMPATDA WHERE TO_CHAR(TGL_REKAM, 'yyyy')='"+tahun+"'";
						sql += " AND NO_REKENING = '"+kodePajak[Integer.valueOf(idType)]+"') PIVOT (COUNT(NAMA) FOR M IN ('01','02','03','04','05','06','07','08','09','10','11','12'))";
						DBResultSet dbrs = null;
						try {
							dbrs = DBHandler.execQueryResult(sql);
							ResultSet rs = dbrs.getResultSet();
							message = "data tidak ditemukan";
							while (rs.next()) {
								error = false;
								message = "data berhasil";
								String januari = rs.getString(1);
								if (januari == null){
									januari = "0";
								}
								String februari = rs.getString(2);
								if (februari == null){
									februari = "0";
								}
								String maret = rs.getString(3);
								if (maret == null){
									maret = "0";
								}
								String april = rs.getString(4);
								if (april == null){
									april = "0";
								}
								String mei = rs.getString(5);
								if (mei == null){
									mei = "0";
								}
								String juni = rs.getString(6);
								if (juni == null){
									juni = "0";
								}
								String juli = rs.getString(7);
								if (juli == null){
									juli = "0";
								}
								String agustus = rs.getString(8);
								if (agustus == null){
									agustus = "0";
								}
								String september = rs.getString(9);
								if (september == null){
									september = "0";
								}
								String oktober = rs.getString(10);
								if (oktober == null){
									oktober = "0";
								}
								String november = rs.getString(11);
								if (november == null){
									november = "0";
								}
								String desember = rs.getString(12);
								if (desember == null){
									desember = "0";
								}
								this.dataCostum = new JSONObject();
								dataCostum.put("tahun", tahun);
								dataCostum.put("id_category", idCategory);
								dataCostum.put("id_type", kodePajakIdType[Integer.valueOf(idType)]);
								dataCostum.put("id_kabupaten", "5");
								dataCostum.put("januari", januari+".00");
								dataCostum.put("februari", februari+".00");
								dataCostum.put("maret", maret+".00");
								dataCostum.put("april", april+".00");
								dataCostum.put("mei", mei+".00");
								dataCostum.put("juni", juni+".00");
								dataCostum.put("juli", juli+".00");
								dataCostum.put("agustus", agustus+".00");
								dataCostum.put("september", september+".00");
								dataCostum.put("oktober", oktober+".00");
								dataCostum.put("november", november+".00");
								dataCostum.put("desember", desember+".00");
								jSONArray.put(dataCostum);
							}
						} catch (Exception e) {
							message = "error saat mengambil data";
						} finally {
							DBResultSet.close(dbrs);
						}
				}
			}
		}
        
		
		try {
            jSONObject.put("error", error);
            jSONObject.put("message", message);
            if (dataCostum != null) {
                jSONObject.put("data", jSONArray);
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
        }
		response.getWriter().print(this.jSONObject);
        
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
