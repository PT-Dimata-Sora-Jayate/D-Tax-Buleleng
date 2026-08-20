
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.payment.ViewPaymentBphtb;
import com.dimata.dtaxintegration.entity.payment.PstViewPaymentBphtb;
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

public class AjaxPaymentBphtb extends HttpServlet{
    private String searchTerm;
    private String colName;
    private int colOrder;
    private String dir;
    private int start;
    private int amount;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int command = Integer.parseInt(request.getParameter("Command"));
        if (command==Command.LIST){
            JSONObject result = new JSONObject();
            result = listViewPaymentBphtb(request, response);
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-store");
            PrintWriter out = response.getWriter();
            out.print(result);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {}
    
    public JSONObject listViewPaymentBphtb(HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        
        String[] cols = { ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_NO_TIB]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_REGISTER]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_JUMLAH_PAJAK]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_JUMLAH_BAYAR]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_TANGGAL_BAYAR]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_DIBUAT_OLEH]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_DIBUAT_TANGGAL]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_JUMLAH_BAYAR_VALIDASI]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_NILAI_TKP]+"",
                          ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_VALIDASI_BAYAR_PPAT]+"",
                         };
        
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
            if (amount < 10 ) {
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
        
        String tib = request.getParameter("tib");
        
        String whereClause = ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_NO_TIB]+"='"+tib+"'";
        
        String colName = cols[col];
        int total = -1;
        total = PstViewPaymentBphtb.getCount(whereClause);
        
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
    
    public JSONObject getData(int total, HttpServletRequest request) throws JSONException{
        
        int totalAfterFilter = total;
        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();
        ViewPaymentBphtb viewPaymentBphtb = new ViewPaymentBphtb();
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
        String tib = request.getParameter("tib");
        
        String whereClause = ""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_NO_TIB]+"='"+tib+"'";
        String order ="";
        
        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
            whereClause +=" and(";
            whereClause +=""+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_REGISTER]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_JUMLAH_PAJAK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_JUMLAH_BAYAR]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_TANGGAL_BAYAR]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_DIBUAT_OLEH]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_DIBUAT_TANGGAL]+" like '%"+this.searchTerm+"%'";           
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_JUMLAH_BAYAR_VALIDASI]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_NILAI_TKP]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstViewPaymentBphtb.fieldNames[PstViewPaymentBphtb.FLD_VALIDASI_BAYAR_PPAT]+" like '%"+this.searchTerm+"%'";
            whereClause += ")";
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
        
        Vector listViewPaymentBphtb = PstViewPaymentBphtb.list(this.start, this.amount,whereClause,order);
        
        
        for (int i =0 ; i<=listViewPaymentBphtb.size()-1;i++){
            viewPaymentBphtb = (ViewPaymentBphtb) listViewPaymentBphtb.get(i);
            JSONArray ja = new JSONArray();

            ja.put(viewPaymentBphtb.getNoTib());
            ja.put(viewPaymentBphtb.getRegister());
            ja.put("Rp. " +decimalFormat.format(viewPaymentBphtb.getJumlahPajak()));
            ja.put("Rp. " +decimalFormat.format(viewPaymentBphtb.getJumlahBayar()));
            ja.put(viewPaymentBphtb.getTanggalBayar());
            ja.put(viewPaymentBphtb.getDibuatOleh());
            ja.put(viewPaymentBphtb.getDibuatTanggal());
            ja.put("Rp. " +decimalFormat.format(viewPaymentBphtb.getJumlahBayarValidasi()));
            ja.put("Rp. " +decimalFormat.format(viewPaymentBphtb.getNilaiTkp()));
            ja.put(viewPaymentBphtb.getValidasiBayarPpat());
          
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
}
