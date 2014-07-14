package conex;

import javax.swing.*;
import MD5.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class conx {

    static Connection conexion;
    static Statement sentencia;
    public ResultSet resultado;
    public static String fecha_ingreso, hora_ingreso;

    /*----- Lineas de Conexion-----*/
    public conx() {
    }

    public boolean conecta() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/alcaldia", "postgres", "1234");
            sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*---- Lineas de Consultas ----*/
    public String conLog(String user, String pss, int opc) {
        String rtado = "";
        String md5_pss=md5.getStringMessageDigest(pss,"MD5");
        String sql = "";
        if (opc == 1) {
            sql = "select id_dat, pass from  login_dat where  id_dat='" + user + "' and  pass='" + md5_pss + "'"; // Verificar existencia de usuario
        } else if (opc == 2) {
            sql = "select nombre from  login_dat where id_dat='" + user + "'";  // Nombre del Usuario
        }
        
        try {// Consultar existencia de usuario
            resultado = sentencia.executeQuery(sql);
            while (resultado.next()) {
                rtado = resultado.getString(1);
            }
        } catch (SQLException ex) {}
         return rtado;
    }

    public String reg_log(String user, String pss, int opc) { // Ingresa los datos de login (Fechas)
        String log = "OK";
        Date now = new Date();
        SimpleDateFormat fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        String sql = "";

        if (opc == 1) {

            String fun = conLog(user, pss, 1);
            if (!fun.equals("")) {
                fecha_ingreso = fecha.format(now);
                hora_ingreso = hora.format(now);
                sql = "insert into  login_reg(id_dat,fecha_ingreso,fecha_salida) "
                        + "values('" + user + "','" + fecha_ingreso + "','2000/12/20 11:59:59')";
            } else {
                log = "ERROR";
            }
        } else if (opc == 2) {
            String fecha_salida = fecha.format(now);
            sql = "update login_reg set fecha_salida='"+fecha_salida+"' where fecha_ingreso='"+fecha_ingreso+"'";

        }
        try {
            int rta = sentencia.executeUpdate(sql);
            if (rta != 0) {} else {
                System.out.print("ERROR T-T");
            }
        } catch (SQLException ex) {
            Logger.getLogger(conx.class.getName()).log(Level.SEVERE, null, ex);
        }
        return log;
    }
}
