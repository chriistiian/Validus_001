<%@page import="java.sql.Connection"%>
<%@page import= "conex.conx" %> 
<%
    conx con = new conx();
    if (con.conecta()) {
        String user = request.getParameter("un");
        String pss = request.getParameter("pw");
        if (con.reg_log(user, pss,1).equals("OK")) {
            out.print(con.conLog(user, "", 2));
        } else {
            out.print("ERROR");
        }
    }
%>