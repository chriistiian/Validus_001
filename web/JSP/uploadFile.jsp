<%-- 
    Document   : uploadFile
    Created on : 7/04/2014, 02:36:24 PM
    Author     : Nab
--%>

<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="java.util.*" %> 

<%@ page import="fileUploadTester.*;" %> 
<%@ page import="java.io.*" %> 

<%
    Alcaldia al = new Alcaldia();
    Validacion vl = new Validacion();
    String ubicacionArchivo = "C:\\Users\\christian\\Documents\\a";
    String nombreA = "";

    DiskFileItemFactory factory = new DiskFileItemFactory();
    factory.setSizeThreshold(1024);

    factory.setRepository(new File(ubicacionArchivo));
    System.out.print("ENTRA");

    ServletFileUpload upload = new ServletFileUpload(factory);

    try {
        List<FileItem> partes = upload.parseRequest(request);

        for (FileItem item : partes) {
            File file = new File(ubicacionArchivo, item.getName());
            nombreA = item.getName();
            item.write(file);
        }
        out.write("El archivo se a subido correctamente " + ubicacionArchivo + "/" + nombreA);
    } catch (FileUploadException ex) {
        out.write("Error al subir archivo " + ex.getMessage());
    }
    System.out.print("cnatidad " + nombreA.length());
    al.archivoTXT(ubicacionArchivo + "/" + nombreA);
    out.write(" <br><br> ERRORES <br> \n  " + vl.respuesta);
    out.print(vl.respuesta);


%>