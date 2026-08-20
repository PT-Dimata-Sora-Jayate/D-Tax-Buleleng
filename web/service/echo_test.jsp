<%-- 
    Document   : echo_test
    Created on : May 8, 2015, 4:23:54 PM
    Author     : dimata005
--%>

<%@page import="com.dimata.webclient.EchoTest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        EchoTest echoTest = new EchoTest();
        String result = echoTest.action();
        %>
        <%=result%>
    </body>
</html>
