<%-- --%>
<%@page import="com.dimata.common.entity.system.PstSystemProperty"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0" background="<%=approot%>/images/bg_header.gif" >
  <tr> 
    <td width="15%" height="25"> 
      <div align="left" title="Enterprise Resource Planning and Management System"><img src="<%=approot%>/images/header_logo.gif" width="219" height="50"></div>
    </td>
    <td width="70%" height="25" valign="middle"> 
      <div align="center"><font size="3"><b><font size="3"><b></b></font></b></font></div>
	</td> 
    <td align="right" height="25" ><img src="<%=approot%>/images/company.gif"></td><!--width="180" height="45"-->   
  </tr>
<%
String information = PstSystemProperty.getValueByName("INFORMATION");
if(!information.equals("stop")){
%>
  <tr>
    <td width="15%" height="25"></td>
    <td width="70%" height="25" valign="middle" nowrap>
        <div align="center"><blink><font size="3" color="red" ><b><%=information%></b></font></blink></div>
    </td>
    <td align="right" height="25" ></td>
  </tr>
<%}%>
</table>
