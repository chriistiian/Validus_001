<%-- 
    Document   : principal
    Created on : 5/05/2014, 10:12:35 PM
    Author     : Nab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Validacion y Seguimiento</title>

        <!-- Cargar Javascript -->
        <script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript" src="../js/mainP.js"></script>
        <script type="text/javascript" src="../js/uploadJS.js"></script>
        <!-- // Cargar Javascript -->
        <!-- Cargar stylesheets -->
        <link type="text/css" rel="stylesheet" href="../css/tabstyle.css" media="screen" />
        <!-- // Cargar stylesheets -->
    </head>
    <body>
        <div id="sesion">
            <%
            String username = (String) session.getAttribute("user");
            if (username != null) {
                out.print("Bienvenido, " + username);
                out.print("<br> <a href='session/logout.jsp'>Cerrar Sesion</a>");
            %>
        </div>
        <div id="container">
            <center><img src="../images/logo-villavicencio.png" width="400px" height="200px"/> </center>
            <ul class="tabs"> 
                <li class="active" rel="tab1" id="tab_1"> Sistema de Validacion</li>
                <li rel="tab2" id="tab_2"> Historial de Seguimiento</li>                
            </ul>
            <div class="tab_container"> 
                <div id="tab1" class="tab_content"> <!-- Validacion -->
                    <p><br />
                        <form action="#" enctype="multipart/form-data" method="post">
                            <input type="file"  name="file_upload" id="file">                        
                            <input type="button" onClick="performAjaxSubmit();" value="Subir Archivo" >  
                        </form>
                    </p>
                    <div id="doc">
                    </div>
                </div><!-- #tab1 -->
                <div id="tab2" class="tab_content"> <!-- Seguimiento -->
                    <div class="example">
                        <ul id="nav">
                            <li  id="alarm" class="inactivo" data-option='{"name":"alarm"}'>Alarmas</li>
                            <li  id="est" class="inactivo" data-option='{"name":"est"}'>Estadisticas</li>
                            <li id="rep" class="inactivo" data-option='{"name":"rep"}'>Reportes</li>
                        </ul>
                    </div>
                    <div id="cont"></div>
                </div>
            </div> <!-- .tab_container --> 
        </div>
    </body>
</html>
<% } else {
        response.sendRedirect("../index.html");
    }
%>