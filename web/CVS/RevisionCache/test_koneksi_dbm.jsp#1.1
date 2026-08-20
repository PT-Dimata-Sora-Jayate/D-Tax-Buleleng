<%-- 
    Document   : test_koneksi_dbm
    Created on : Sep 19, 2016, 9:19:48 PM
    Author     : dimata005
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            try {
                Class.forName("com.ibm.as400.access.AS400JDBCDriver");
                Connection con = DriverManager.getConnection("jdbc:as400://192.168.201.66/MASTER","O0812","O0812");
                PreparedStatement st = con.prepareStatement("select nasabah.kd_jns_nsb, sid.no_nsb, sid.nm_perusahaan,nasabah.jenis_usaha, "
                                        +"sid.tempat_akte, "
                                        +"sid.no_akte_awal, "
                                        +"sid.tgl_akte_awal, "
                                        +"sid.no_akte_akhir, "
                                        +"sid.tgl_akte_akhir, "
                                        +"sid.telepon, "
                                        +"email, "
                                        +"alamat, "
                                        +"sid.kelurahan, "
                                        +"kd_kecamatan, "
                                        +"sid.kd_dati_ii, "
                                        +"nasabah.kd_pos, "
                                        +"kd_negara, "
                                        +"sid.bidang_usaha, "
                                        +"hubungan_bank, "
                                        +"sid.langgar_bmk, "
                                        +"sid.lampau_bmk, "
                                        +"sid.go_public, "
                                        +"sid.gol_deb, "
                                        +"sid.rating_ush_deb, "
                                        +"sid.lembaga_pringkat, "
                                        +"sid.group_deb, "
                                        +"sid.kd_cab "
                                        +"from nasabah "
                                        +"inner join sid  "
                                        +"on nasabah.NO_NSB = sid.NO_NSB "
                                        +"where nasabah.kd_jns_nsb != '1' ");
                ResultSet rs = st.executeQuery();
                out.println("List of Product Info\n" + "<br >" + "——————–" + "<br >");
                while (rs.next()) {
                        %>
                           <%=rs.getString("no_nsb")%><br>
                        <%
                }
                rs.close();
                st.close();
            } catch (Exception e) {
                out.println(e);
            }

        %>
    </body>
</html>
