<%-- 
    Document   : test_insert_data
    Created on : Feb 23, 2016, 4:42:27 PM
    Author     : dimata005
--%>

<%@page import="java.sql.Connection"%>
<%-- 
    Document   : test_koneksi
    Created on : Feb 23, 2016, 12:53:20 AM
    Author     : dimata005
--%>
<%-- 
    Document   : test_koneksi
    Created on : Feb 23, 2016, 12:11:50 AM
    Author     : Administrator
--%>

<html>
    <head><title>Enter to database</title></head>
    <body>
        <table>
            <%

                Connection connection = null;
                java.sql.Statement s;
                java.sql.ResultSet rs;
                java.sql.PreparedStatement pst;

                connection = null;
                s = null;
                pst = null;
                rs = null;

                // Remember to change the next line with your own environment
                //Server Gianyar
                //String url = "jdbc:jtds:sqlserver://SVR-BACKUP/PENDAPATAN2016;instance=simpadadbs";
                
                //WITAR-PC\SQLEXPRESS
                String url = "jdbc:jtds:sqlserver://localhost:1433/IPROTAX";
                String id  = "sa";
                String pass = "123";
                try {

                    Class.forName("net.sourceforge.jtds.jdbc.Driver");
                    connection = java.sql.DriverManager.getConnection(url, id, pass);
                    
                } catch (ClassNotFoundException cnfex) {
                    cnfex.printStackTrace();

                }
                
                String sql = "select top 10 KD_PROPINSI, KD_DATI2 from [IPROTAX].[IPROTAXPBB].[SPPT]";
                
                try {
                    
                    s = connection.createStatement();
                    
                    //fungsi insert
                    //String command = "INSERT INTO Ref_Kelas (Kd_Kelas, Nm_Kelas) VALUES (5, 'Klasifikasi E')";
                    //s.executeUpdate(command);
                    
                    //fungsi query
                    rs = s.executeQuery(sql);
            %>

            <%
                while (rs.next()) {
            %><tr>
                <td><%= rs.getString("KD_DATI2")%></td>
                <td><%= rs.getString("KD_PROPINSI")%></td>
            </tr>
            <%
                }
            %>

            <%
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (rs != null) {
                        rs.close();
                    }
                    if (s != null) {
                        s.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                }

            %>

    </body>
</html>