
package com.dimata.dtaxintegration.ajax;

import com.dimata.dtaxintegration.entity.inquery.Pbb;
import com.dimata.dtaxintegration.entity.inquery.PstPbbAll;
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


public class AjaxPbb extends HttpServlet{
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
            result = listPBB(request, response);
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
    
    public JSONObject listPBB (HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        
        String[] cols = { ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NOP]+"", 
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NAMA]+"", 
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_INSTANSI]+"", 
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NPWPD]+"", 
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_ALAMAT_WP]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_LETAK]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_TAHUN]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_JATUH_TEMPO]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_LUAS_BUMI_SPPT]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_LUAS_BNG_SPPT]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NJOP_BUMI_SPPT]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NJOP_BNG_SPPT]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NJOPTKP_SPPT]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_POKOK]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_DENDA]+"",
                          ""+PstPbbAll.fieldNames[PstPbbAll.FLD_JUMLAH_TAGIHAN]+""};
    
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
        String whereClause = ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NOP]+"='"+nop+"'";
        total = PstPbbAll.getCount(whereClause);
        
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
        Pbb pbb = new Pbb();
        
        String nop = request.getParameter("nop");
        
        String whereClause = ""+PstPbbAll.fieldNames[PstPbbAll.FLD_NOP]+"='"+nop+"'";
        String order ="";
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        
        if (this.searchTerm == null){
            whereClause += "";                  
        }else{
            whereClause +=" and(";
            whereClause +=""+PstPbbAll.fieldNames[PstPbbAll.FLD_NAMA]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_INSTANSI]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_NPWPD]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_ALAMAT_WP]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_LETAK]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_TAHUN]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_JATUH_TEMPO]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_LUAS_BUMI_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_LUAS_BNG_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_NJOP_BUMI_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_NJOP_BNG_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_NJOPTKP_SPPT]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_POKOK]+" like '%"+this.searchTerm+"%'"; 
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_DENDA]+" like '%"+this.searchTerm+"%'";
            whereClause +=" or "+PstPbbAll.fieldNames[PstPbbAll.FLD_JUMLAH_TAGIHAN]+" like '%"+this.searchTerm+"%'";
            whereClause += ")";
        }
        
        if (this.colOrder>=0){
            order += ""+colName+" "+dir+"";
        }
        
        Vector listPbb = PstPbbAll.list(this.start, this.amount,whereClause,order);
        
        
        for (int i =0 ; i<=listPbb.size()-1;i++){
            pbb = (Pbb) listPbb.get(i);
            JSONArray ja = new JSONArray();
            
            
            ja.put(pbb.getNop());
            ja.put(pbb.getNama());
            ja.put(pbb.getInstansi());
            ja.put(pbb.getNpwpd());
            ja.put(pbb.getAlamat());
            ja.put(pbb.getLetakObjectPajak());
            ja.put(pbb.getTahun());
            ja.put(pbb.getTglJatuhTempo());
            ja.put(decimalFormat.format(Double.parseDouble(pbb.getLuasBumi())));
            ja.put(decimalFormat.format(Double.parseDouble(pbb.getLuasBangunan())));
            ja.put(pbb.getnJOPBumi());
            ja.put(pbb.getnJOPBangunan());
            ja.put(pbb.getnJOPTKP());
            ja.put("Rp. "+decimalFormat.format(Double.parseDouble(pbb.getPokok())));
            ja.put("Rp. "+decimalFormat.format(Double.parseDouble(pbb.getDenda())));
            ja.put("Rp. "+decimalFormat.format(Double.parseDouble(pbb.getJumlahTagihan())));
            
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
