/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimata.common.session.convertfile;

/**
 *
 * @author dimata005
 */
import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConvertHTMLToPDF {

    private static String FILE = "D:/pdfhtml.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public static void main(String[] args) {
        try {
            // step 1
            Document document = new Document(PageSize.A4_LANDSCAPE, 20, 20, 20, 20);
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            writer.setViewerPreferences(PdfWriter.FitWindow);
            document.open();
            // step 4
            String str = ""
                    + "<table border=1>" +
"   <tr>" +
"      <td>" +
"         <table>" +
"            <tr>" +
"               <td>NO</td>" +
"               <td>Cabang</td>" +
"               <td>CIF</td>" +
"               <td>NO REKENING</td>" +
"               <td>Tgl Akad Akhir</td>" +
"               <td>Jenis Identitas</td>" +
"               <td>NIK</td>" +
"               <td>Nama Identitas</td>" +
"               <td>Nama Lengkap</td>" +
"               <td>Kode Status Gelar</td>" +
"               <td>Jenis Kelamin</td>" +
"               <td>Tempat Lahir</td>" +
"               <td>Tgl Lahir</td>" +
"               <td>NPWP</td>" +
"               <td>Alamat</td>" +
"               <td>Kelurahan</td>" +
"               <td>Kecamatan</td>" +
"               <td>Kode Kab</td>" +
"               <td>Kode Pos</td>" +
"               <td>Telepon</td>" +
"               <td>Nomor HP</td>" +
"               <td>Email</td>" +
"               <td>Kode Domisili</td>" +
"               <td>Kode Pekerjaan</td>" +
"               <td>Tempat Bekerja</td>" +
"               <td>Kode Usaha Tempat Bekerja</td>" +
"               <td>Alamat Tempat Bekerja</td>" +
"               <td>Penghasilan Kotor</td>" +
"               <td>Kode Penghasilan</td>" +
"               <td>Jumlah Tanggungan</td>" +
"               <td>Kode Hub</td>" +
"               <td>Kode Golongan</td>" +
"               <td>Status</td>" +
"               <td>NIK Pasangan</td>" +
"               <td>Nama Pasangan</td>" +
"               <td>Tanggal Lahir Pasangan</td>" +
"               <td>Perjanjian Pisah Harga</td>" +
"               <td>Melanggar BMPK</td>" +
"               <td>Melampaui BMPK</td>" +
"               <td>Nama Ibu Kandung</td>" +
"            </tr>" +
"            <tr >" +
"               <td>1</td>" +
"               <td>019</td>" +
"               <td>00016241</td>" +
"               <td>0190626055389</td>" +
"               <td>2014-07-08</td>" +
"               <td>1</td>" +
"               <td>5104050102550002</td>" +
"               <td>IR I GUSTI NGURAH ASTIKA</td>" +
"               <td>IR I GUSTI NGURAH ASTIKA</td>" +
"               <td>00</td>" +
"               <td>L</td>" +
"               <td>GIANYAR</td>" +
"               <td>1955-02-01</td>" +
"               <td>000000000000</td>" +
"               <td>BR TEBESAYA PELIATAN UBUD GIANYAR</td>" +
"               <td>PELIATAN</td>" +
"               <td>0026</td>" +
"               <td>7205</td>" +
"               <td>80571</td>" +
"               <td>973214</td>" +
"               <td>08179717986</td>" +
"               <td></td>" +
"               <td>ID</td>" +
"               <td>099</td>" +
"               <td>DINAS PERTANIAN PROV BALI</td>" +
"               <td>009000</td>" +
"               <td>JL WR SUPRATMAN DENPASAR TIMUR</td>" +
"               <td>1.0</td>" +
"               <td>1</td>" +
"               <td>1</td>" +
"               <td>9900</td>" +
"               <td>9000</td>" +
"               <td>1</td>" +
"               <td></td>" +
"               <td></td>" +
"               <td></td>" +
"               <td></td>" +
"               <td>T</td>" +
"               <td>T</td>" +
"               <td>I GUSTI PUTU RESI</td>" +
"            </tr>" +
                    
"         </table>" +
"      </td>" +
"   </tr>" +
"</table>" +
"";

            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
            // step 5
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
