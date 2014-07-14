/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileUploadTester;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author christian
 */
public class Validacion_Estructural {

    public boolean TablaREP(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("500010054010");
        v.addElement("500010054009");
        v.addElement("500010054008");
        v.addElement("500010054001");
        v.addElement("500010054007");
        v.addElement("5000100540");

        v.addElement("50001");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean TablaC_EPS(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("500010054010");
        v.addElement("500010054009");
        v.addElement("500010054008");
        v.addElement("50001");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    private boolean validar_Fecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechas = formatoFecha.parse(fecha);
        } catch (Exception e) {
            return false;

        }
        return true;
    }

    private boolean validar_Fecha1(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
            Date fechas = formatoFecha.parse(fecha);
        } catch (Exception e) {
            return false;

        }
        return true;
    }

    /*RESOLUCION 4505  --NOMBRE ARCHIVO*/
    public boolean NombreArchivo1(String dato) {
        System.out.println("Variable0->" + dato);
        boolean var = false;

        if ("SGD".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean NombreArchivo2(String dato) {
        boolean var = false;

        if ("280".equals(dato)) {
            var = true;
        }
        return var;
    }

    public boolean NombreArchivo3(String dato) {
        boolean var = false;
        ///FALTA FECHAS
        if ("RPED".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean NombreArchivo4(String dato) {
        boolean var = false;
        ///FALTA FECHAS
        if (validar_Fecha1(dato) == true) {
            var = true;
        }
        return var;
    }

    public boolean NombreArchivo5(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("MU");
        v.addElement("DE");
        v.addElement("DI");
        v.addElement("NI");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean NombreArchivo6(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("12");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean NombreArchivo7(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("C");
        v.addElement("S");
        v.addElement("P");
        v.addElement("E");
        v.addElement("N");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean NombreArchivo8(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("01");
        v.addElement("02");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean NombreArchivo9(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement(".txt");
        v.addElement(".TXT");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    /*RESOLUCION 4505  --CONTROL DATOS */
    public boolean ControlDatos1(String dato) {
        System.out.println("Variable0->" + dato);
        boolean var = false;

        if ("1".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean ControlDatos2(String dato) {
        boolean var = false;

        if (TablaC_EPS(dato) == true) {
            var = true;
        }
        return var;
    }

    public boolean ControlDatos3(String dato) {
        boolean var = false;
        ///FALTA FECHAS
        if (validar_Fecha(dato) == true) {
            var = true;
        }

        return var;
    }

    public boolean ControlDatos4(String dato) {
        boolean var = false;
        ///FALTA FECHAS
        if (validar_Fecha(dato) == true) {
            var = true;
        }
        return var;
    }

    public boolean ControlDatos5(String dato) {
        boolean var = false;
        int v = Integer.parseInt(dato);
        if (v > 1) {
            var = true;
        }

        return var;
    }

    /*RESOLUCION 4505  --118 CAMPOS */
    public boolean Variable0(String dato) {
        System.out.println("Variable0->" + dato);
        boolean var = false;
        Vector v = new Vector();
        v.addElement("2");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable1(String dato) {
        boolean var = false;
        int cantidad = Integer.parseInt(dato);
        if (cantidad >= 0) {
            var = true;
        }

        return var;
    }

    public boolean Variable2(String dato) {
        boolean var = false;

        if (TablaREP(dato) == true) {
            var = true;
        }

        return var;
    }

    public boolean Variable3(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("RC");
        v.addElement("TI");
        v.addElement("CE");
        v.addElement("CC");
        v.addElement("PA");
        v.addElement("MS");
        v.addElement("AS");
        v.addElement("CD");
        v.addElement("NV");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable4(String dato) {
        boolean var = false;
        String v = dato;
        if (v.length() <= 18) {
            var = true;
        }

        return var;
    }

    public boolean Variable5(String dato) {
        boolean var = false;
        String v = dato;
        if (v.length() <= 30) {
            var = true;
        }

        return var;
    }

    public boolean Variable6(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("NONE");
        if (v.contains(dato) || dato.length() <= 30) {
            var = true;
        }

        return var;
    }

    public boolean Variable7(String dato) {
        boolean var = false;
        String v = dato;
        if (v.length() <= 30) {
            var = true;
        }

        return var;
    }

    public boolean Variable8(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("NONE");
        if (v.contains(dato) || dato.length() <= 30) {
            var = true;
        }

        return var;
    }

    public boolean Variable9(String dato) {
        boolean var = false;

        if (validar_Fecha(dato) == true) {
            var = true;
        }

        return var;
    }

    public boolean Variable10(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("F");
        v.addElement("M");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable11(String dato) {
        boolean var = false;
        System.out.println("Variable11->" + dato);
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable12(String dato) {
        boolean var = false;
        int cantidad = Integer.parseInt(dato);
        if (cantidad >= 0 && cantidad <= 9999) {
            var = true;
        }

        return var;
    }

    public boolean Variable13(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");
        v.addElement("7");
        v.addElement("8");
        v.addElement("9");
        v.addElement("10");
        v.addElement("11");
        v.addElement("12");
        v.addElement("13");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable14(String dato) {
        System.out.println("Variable14->" + dato);
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable15(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable16(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable17(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable18(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable19(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable20(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable21(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable22(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable23(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable24(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable25(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");
        v.addElement("7");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }
        return var;
    }

    public boolean Variable26(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable27(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable28(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1");
        v.addElement("2");
        v.addElement("21");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable29(String dato) {
        boolean var = false;

        if (validar_Fecha(dato) == true || "1800-01-01".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable30(String dato) {
        boolean var = false;
        double cantidad = Double.parseDouble(dato);
        if (cantidad >= 0 || "999".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable31(String dato) {
        boolean var = false;

        if (validar_Fecha(dato) == true || "1800-01-01".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable32(String dato) {
        boolean var = false;
        double cantidad = Double.parseDouble(dato);
        if ((cantidad >= 0 && cantidad <= 200) || "999".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable33(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1845-01-01");

        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable34(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");
        double cantidad = Double.parseDouble(dato);
        if (cantidad >= 0 || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable35(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable36(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable37(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable38(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable39(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("4");
        v.addElement("5");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable40(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable41(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable42(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable43(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable44(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable45(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable46(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable47(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable48(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable49(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1845-01-01");

        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable50(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable51(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable52(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable53(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable54(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");
        v.addElement("7");
        v.addElement("8");
        v.addElement("9");
        v.addElement("10");
        v.addElement("11");
        v.addElement("12");
        v.addElement("13");
        v.addElement("14");
        v.addElement("15");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("20");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable55(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable56(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable57(String dato) {
        boolean var = false;
        int cantidad = Integer.parseInt(dato);
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");
        if (cantidad > 0 || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable58(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable59(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("20");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable60(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("20");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable61(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("20");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable62(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable63(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable64(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable65(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable66(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable67(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable68(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable69(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable70(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("20");
        v.addElement("21");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable71(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("20");
        v.addElement("21");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable72(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable73(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable74(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("993");
        v.addElement("994");
        v.addElement("995");
        v.addElement("996");
        v.addElement("997");
        v.addElement("999");
        double cantidad = Double.parseDouble(dato);
        if ((cantidad > 0 && cantidad < 100) || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable75(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable76(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable77(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable78(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable79(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable80(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable81(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable82(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable83(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable84(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable85(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable86(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable87(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable88(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");
        v.addElement("7");
        v.addElement("8");
        v.addElement("9");
        v.addElement("10");
        v.addElement("11");
        v.addElement("12");
        v.addElement("13");
        v.addElement("14");
        v.addElement("15");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("999");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable89(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("999");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable90(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");

        if (TablaREP(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable91(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable92(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");

        if (TablaREP(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable93(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable94(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");
        v.addElement("999");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable95(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");

        if (TablaREP(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable96(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable97(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("6");
        v.addElement("7");
        v.addElement("999");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable98(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");

        if (TablaREP(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable99(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable100(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable101(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("5");
        v.addElement("999");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable102(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("999");

        if (TablaREP(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable103(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable104(String dato) {
        boolean var = false;
        double cantidad = Double.parseDouble(dato);
        if (cantidad >= 0 || "999".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable105(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable106(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable107(String dato) {
        boolean var = false;
        double cantidad = Double.parseDouble(dato);
        if (cantidad >= 0 || "999".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable108(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable109(String dato) {
        boolean var = false;
        double cantidad = Double.parseDouble(dato);
        if (cantidad >= 0 || "999".equals(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable110(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable111(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable112(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable113(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("1");
        v.addElement("2");
        v.addElement("3");
        v.addElement("4");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable114(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable115(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable116(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");
        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable117(String dato) {
        boolean var = false;
        Vector v = new Vector();

        v.addElement("0");
        v.addElement("1");
        v.addElement("2");
        v.addElement("16");
        v.addElement("17");
        v.addElement("18");
        v.addElement("19");
        v.addElement("20");
        v.addElement("22");

        if (v.contains(dato)) {
            var = true;
        }

        return var;
    }

    public boolean Variable118(String dato) {
        boolean var = false;
        Vector v = new Vector();
        v.addElement("1800-01-01");
        v.addElement("1805-01-01");
        v.addElement("1810-01-01");
        v.addElement("1825-01-01");
        v.addElement("1830-01-01");
        v.addElement("1835-01-01");
        v.addElement("1845-01-01");
        if (validar_Fecha(dato) == true || v.contains(dato)) {
            var = true;
        }

        return var;
    }

}
