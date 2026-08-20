
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.payment.PaymentPbb;
import com.dimata.dtaxintegration.entity.payment.PstViewPaymentPbb;
import com.dimata.util.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AjaxPaymentPbb extends HttpServlet{
    private String searchTerm;
    private String colName;
    private int colOrder;
    private String dir;
    private int start;
    private int amount;
    
    public JSONObject listViewPaymentPBB (HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        
        String[] cols = { ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NOP]+"", 
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_PROPINSI]+"", 
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_DATI2]+"", 
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KECAMATAN]+"", 
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KELURAHAN]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BLOK]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NO_URUT]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_JNS_OP]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_THN_PAJAK_SPPT]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_PEMBAYARAN_SPPT_KE]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KANWIL_BANK]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KPPBB_BANK]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BANK_TUNGGAL]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BANK_PERSEPSI]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_TP]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_DENDA_SPPT]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_JML_SPPT_YG_DIBAYAR]+"",
                          ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_TGL_PEMBAYARAN_SPPT]+""};
    
        int amount = 10;
        int start = 0;
        int col = 0;
        String dir = "asc";
        String sStart = request.getParameter("iDisplayStart");
        String sAmount = request.getParameter("iDisplayLength");
        String sCol = request.getParameter("iSortCol_0");
        String sdir = request.getParameter("sSortDir_0");
        
        if (sStart != null) {
            start = Integer.parseInt(sStart);
            if (start < 0) {
                start = 0;
            }
        }
        if (sAmount != null) {
            amount = Integer.parseInt(sAmount);
            if (amount < 10) {
                amount = 10;
            }
        }
        if (sCol != null) {
            col = Integer.parseInt(sCol);
            if (col < 0 )
                col = 0;
        }
        if (sdir != null) {
            if (!sdir.equals("asc"))
            dir = "desc";
        }
        
        String colName = cols[col];
        int total = -1;
        String nop = request.getParameter("nop");
        String whereClause = ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NOP]+"='"+nop+"'";
        total = PstViewPaymentPbb.getCount(""+whereClause);
        
        this.amount = amount;
        this.searchTerm = request.getParameter("sSearch");
        this.colName = colName;
        this.dir = dir;
        this.start = start;
        this.colOrder = col;
        
        try {
            result = getData(total, request);
        } catch(Exception ex){
            System.out.println(ex);
        }
       
       return result;
    }
    
    public JSONObject getData(int total, HttpServletRequest request){
        
        int totalAfterFilter = total;
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        PaymentPbb paymentPbb = new PaymentPbb();
        
            
        String nop = request.getParameter("nop");
        
        String whereClause = ""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NOP]+"='"+nop+"'";
        String order ="";
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
            whereClause +=" and(";
            whereClause +=""+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_PROPINSI]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_DATI2]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KECAMATAN]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KELURAHAN]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BLOK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_NO_URUT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_JNS_OP]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_THN_PAJAK_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_PEMBAYARAN_SPPT_KE]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KANWIL_BANK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_KPPBB_BANK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BANK_TUNGGAL]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_BANK_PERSEPSI]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_KD_TP]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_DENDA_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_JML_SPPT_YG_DIBAYAR]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentPbb.fieldNames[PstViewPaymentPbb.FLD_TGL_PEMBAYARAN_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause += ")";
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
        
        Vector listPaymentPbb = PstViewPaymentPbb.list(this.start, this.amount,whereClause,order);
        
        
        for (int i =0 ; i<=listPaymentPbb.size()-1;i++){
            paymentPbb = (PaymentPbb) listPaymentPbb.get(i);
            JSONArray ja = new JSONArray();
  
            ja.put(String.valueOf(paymentPbb.getNop()));
            ja.put(paymentPbb.getKdPropinsi());
            ja.put(paymentPbb.getKdDati2());
            ja.put(paymentPbb.getKdKecamata());
            ja.put(paymentPbb.getKdKelurahan());
            ja.put(paymentPbb.getKdBlok());
            ja.put(paymentPbb.getNoUrut());
            ja.put(paymentPbb.getKdJnsOp());
            ja.put(paymentPbb.getThnPajakSppt());
            ja.put(String.valueOf(paymentPbb.getPembayaranSpptKe()));
            ja.put(paymentPbb.getKdKanwilBank());
            ja.put(paymentPbb.getKdKppbbBank());
            ja.put(paymentPbb.getKdBankTunggal());
            ja.put(paymentPbb.getKdBankPersepsi());
            ja.put(paymentPbb.getKdTp());
            ja.put("Rp. "+decimalFormat.format(paymentPbb.getDendaSppt()));
            ja.put("Rp. " +decimalFormat.format(paymentPbb.getJmlSpptYgDibayar()));
            ja.put(paymentPbb.getTglPembayaranSppt());
            
            array.put(ja);
            
            
        }
        
        totalAfterFilter = total;
        
        try {
            result.put("iTotalRecords", total);
            result.put("iTotalDisplayRecords", totalAfterFilter);
            result.put("aaData", array);
        } catch (Exception e) {

        }
        
        return result;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int command = Integer.parseInt(request.getParameter("Command"));
        if (command==Command.LIST){
            JSONObject result = new JSONObject();
            result = listViewPaymentPBB(request, response);
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            PrintWriter out = response.getWriter();
            out.print(result);
        }
    }
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int command = Integer.parseInt(request.getParameter("Command"));
    }
}
