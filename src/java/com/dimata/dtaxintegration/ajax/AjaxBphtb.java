
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.inquery.Bphtb;
import com.dimata.dtaxintegration.entity.inquery.PstBphtbAll;
import com.dimata.util.Command;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class AjaxBphtb extends HttpServlet{
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
            result = listBphtb(request, response);
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
    
    public JSONObject listBphtb (HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        
        String[] cols = { ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_MASA_PAJAK]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_TAHUN_PAJAK]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_NAMA]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_POKOK]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_DENDA]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_JUMLAH]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_INSTANSI]+"",
                          ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_NOP]+""};
    
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
        
        String nop = request.getParameter("nop");
        String tib = request.getParameter("tib");
        
        //String whereClause = ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_NOP]+"="+nop+" and "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID]+"='"+tib+"'";
        String whereClause = PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID]+"='"+tib+"'";
        
        String colName = cols[col];
        int total = -1;
        total = PstBphtbAll.getCount(whereClause);
        
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
        Bphtb bphtb = new Bphtb();
        
        String nop = request.getParameter("nop");
        String tib = request.getParameter("tib");
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
        
       // String whereClause = ""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_NOP]+"="+nop+" and "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID]+"='"+tib+"'";
        String whereClause = PstBphtbAll.fieldNames[PstBphtbAll.FLD_ID]+"='"+tib+"'";
        String order ="";
        
        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
            whereClause +=" and(";
            whereClause +=""+PstBphtbAll.fieldNames[PstBphtbAll.FLD_MASA_PAJAK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_TAHUN_PAJAK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_NAMA]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_POKOK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_DENDA]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_JUMLAH]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstBphtbAll.fieldNames[PstBphtbAll.FLD_INSTANSI]+" like '%"+this.searchTerm+"%'";
            whereClause += ")";
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
        
        Vector listBphtb = PstBphtbAll.list(this.start, this.amount,whereClause,order);
        
        
        for (int i =0 ; i<=listBphtb.size()-1;i++){
            bphtb = (Bphtb) listBphtb.get(i);
            JSONArray ja = new JSONArray();
        
            ja.put(bphtb.getMasaPajak());
            ja.put(bphtb.getTahunPajak());
            ja.put(bphtb.getNama());
            ja.put("Rp. " +decimalFormat.format(Double.parseDouble(bphtb.getPokok())));
            ja.put("Rp. " +decimalFormat.format(Double.parseDouble(bphtb.getDenda())));
            ja.put("Rp. " +decimalFormat.format(Double.parseDouble(bphtb.getJumlahTagihan())));
            ja.put(bphtb.getInstansi());
            ja.put(bphtb.getNop());
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


