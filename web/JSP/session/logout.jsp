<%@page import = "java.util.Date" session="true"%>
<%@page import= "conex.conx" %>
<%
    session.setAttribute("user", null);
    session.invalidate();
    conx con = new conx();
    con.reg_log("", "", 2);
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1 
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0 
    response.setDateHeader("Expires", 0);
    response.sendRedirect("../../index.html");
%>
