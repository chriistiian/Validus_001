/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileUploadTester;

import static fileUploadTester.Alcaldia.act_sifilis;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UNILLANOS
 */
public class Validacion {

    String Texto;
    String Genero;
    String edad;
    public String[] Matriz;
    public int y;
    public static int posicionX;
    public static int posicionY;
    public String entidades[] = {" 500010054010", " 500010054009", " 500010054008"};
    public static String respuesta;
    private static String fecha_registro;
    private static String Edad;
    String[] Matrix;
    String[] Matrix1;
    String[] Inf_personal;
    String[] Iden_riesgo;
    String[] Act_ISR_1;
    String[] Act_ISR_2;
    String[] Act_ISR_3;
    String[] Act_ISR_4;
    String[] Act_ISR_5;
    String[] Act_ISR_6;
    String[] Act_ISR_7;
    String[] Act_ISR_8;

    Vector Persona = new Vector();
    Vector P_4505 = new Vector();
    public Validacion_Estructural V_E = new Validacion_Estructural();

    public Validacion() {
        respuesta = " ";
    }

    private boolean Entidad(String ent) {
        boolean existe_ent = false;

        for (int i = 0; i < entidades.length; i++) {
            if (entidades[i].equals(ent)) {
                existe_ent = true;
            }
        }

        return existe_ent;
    }

    public boolean Nombre_archivo(String ruta) {
        boolean nom_arc = true;
        int i = 0;
        StringTokenizer tokens = new StringTokenizer(ruta, " /");
        int nDatos = tokens.countTokens();
        String nom_archivo;
        while (tokens.hasMoreTokens()) {
            nom_archivo = tokens.nextToken();
            //System.out.println(nom_archivo);
            if (nom_archivo.length() == 39) {
                //VARIABLE 0
                if (V_E.NombreArchivo1(nom_archivo.substring(0, 3)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, NO TIENE SGD " + nom_archivo.substring(0, 3) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }
                //VARIABLE 1
                if (V_E.NombreArchivo2(nom_archivo.substring(3, 6)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, NO TIENE 280" + nom_archivo.substring(3, 6) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }
                //VARIABLE 2
                if (V_E.NombreArchivo3(nom_archivo.substring(6, 10)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, NO TIENE RPED" + nom_archivo.substring(6, 10) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }
                //VARIABLE 3
                if (V_E.NombreArchivo4(nom_archivo.substring(10, 18)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, FECHA NO VALIDAD" + nom_archivo.substring(10, 18) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }
                //VARIABLE 4
                if (V_E.NombreArchivo5(nom_archivo.substring(18, 20)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, TIPO DE IDENTIFICACIÓN DE LA ENTIDAD REPORTADORA NO VALIDAD " + nom_archivo.substring(18, 20) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }
                //VARIABLE 5--REVISAR 
                if (nom_archivo.substring(20, 32).length() == 12) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, NUMERO DE IDENTIFICACIÓN DE LA ENTIDAD REPORTADORA NO VALIDAD " + nom_archivo.substring(20, 32) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }

                //VARIABLE 6
                if (V_E.NombreArchivo7(nom_archivo.substring(32, 33)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, TIPO DE RÉGIMEN DE LA INFORMACIÓN REPORTADA EN EL ARCHIVO " + nom_archivo.substring(32, 33) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }

                //VARIABLE 7
                if (V_E.NombreArchivo8(nom_archivo.substring(33, 35)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, CONSECUTIVO DE ARCHIVO  " + nom_archivo.substring(33, 35) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }

                //VARIABLE 8
                if (V_E.NombreArchivo9(nom_archivo.substring(35, 39)) == true) {
                } else {
                    nom_arc = false;
                    respuesta += " ERROR NOMBRE ARCHIVO, EXTENSIÓN DEL ARCHIVO " + nom_archivo.substring(35, 39) + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
                }

            } else {

                // System.out.println(" Nombre del archivo no esta correto " );
            }

        }

        /* for (int j = 0; j < i; j++) {
         System.out.println(Matriz[j] + "  * "  + posicionY + "  * "  + nDatos);
         }*/
        return nom_arc;
    }
    /*
     Informacion_personal
     *Esta funcion validad los 13 primeras variables , la informacion personal del  paciente
     *Los datos
     * TIPO DE REGISTRO, CONSECUTIVO DEL REGISTRO, CODIGO DE HABILITACION DE IPS, TIPO DE IDENTIFICACION DEL USUARIO
     * NUMERO DE IDENTIFICACION DEL USUARIO, PRIMER APELLIDO, SEGUNDO APELLIDO, PRIMER NOMBRE, SEGUNDO NOMBRE	
     * FECHA DE NACIMIENTO, SEXO, CODIGO PERTENENCIA ETNICA, CODIGO DE OCUPACION, CODIGO DE NIVEL EDUCATIVO
    
     */

    private void Informacion_personal(String[] txt) {
        System.out.println(" Informacion_personal");
        String[] Inf_persona_1 = new String[14];
        Inf_persona_1 = txt;
        /*for (int k = 0; k < 13; k++) {
         System.out.println(Inf_persona_1[k]);

         }*/

        //VARIABLES 0
        if (V_E.Variable0(Inf_persona_1[0]) == true) {
            y = 0;
        } else {
            y = 0;
            respuesta += " NO VALIDO VAR-0" + Inf_persona_1[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 1
        if (V_E.Variable1(Inf_persona_1[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-1" + Inf_persona_1[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 2

        if (V_E.Variable2(Inf_persona_1[2]) == true) {
            y++;
        } else {
            y++;
            // respuesta += " NO VALIDO VAR-2"  + Inf_persona_1[j] + " POSICION [ "+posicionX+" ] \n\n<br><br>" ;
        }

        //VARIABLES 3
        if (V_E.Variable3(Inf_persona_1[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-3" + Inf_persona_1[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

        //VARIABLES 4
        if (V_E.Variable4(Inf_persona_1[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-4" + Inf_persona_1[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 5 
        if (V_E.Variable5(Inf_persona_1[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR 5" + Inf_persona_1[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 6
        if (V_E.Variable6(Inf_persona_1[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR 5" + Inf_persona_1[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 7
        if (V_E.Variable7(Inf_persona_1[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR 5" + Inf_persona_1[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 8
        if (V_E.Variable8(Inf_persona_1[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR 5" + Inf_persona_1[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

        //VARIABLES 9
        if (V_E.Variable9(Inf_persona_1[9]) == true) {
            // calcular_anos(Inf_persona_1[j]);

            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-9" + Inf_persona_1[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //respuesta +=Inf_persona_1[j]);
        //VARIABLES 10
        if (V_E.Variable10(Inf_persona_1[10]) == true) {
            Genero = Inf_persona_1[10];

            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-10" + Inf_persona_1[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

        //VARIABLES 11
        if (V_E.Variable11(Inf_persona_1[11]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-11+" + Inf_persona_1[11] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLES 12
        if (V_E.Variable12(Inf_persona_1[12]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-12" + Inf_persona_1[12] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

        //VARIABLES 13
        if (V_E.Variable13(Inf_persona_1[13]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO VALIDO VAR-13" + Inf_persona_1[13] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
    }

    /*
     Identificacion_riesgo
     * Esta funcion validad las variables 14 hasta 28, la identificacion de riesgos de los paciente
     * Los datos
     *GESTACION, SIFILIS GESTACIONAL O CONGENITA, HIPERTENSION INDUCIDA POR LA GESTACION, HIPOTIROIDISMO, CONGENITO,
     *  *SINTOMATICO RESPIRATORIO, TUBERCULOSIS MULTIDROGORESISTENTE, LEPRA, OBESIDAD O DESNUTRICION PROTEICO CALORICA,
     *  *VICTIMA DEL MALTRATO,	VICTIMA DE VIOLENCIA SEXUAL, INFECCIONES DE TRANSMISION SEXUAL, ENFERMEDAD MENTAL, CANCER DE CERVIX	CANCER DE SENO	FLUOROSIS DENTAL
    
     */
    private void Identificacion_riesgo(String[] txt) {
        System.out.println(" Identificacion_riesgo");
        String[] i_riesgo = new String[14];
        i_riesgo = txt;

        //VARIABLE 14
        if (V_E.Variable14(i_riesgo[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - GESTACIÓN" + i_riesgo[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 15
        if (V_E.Variable15(i_riesgo[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,21 - SÍFILIS GESTACIONAL O CONGÉNITA" + i_riesgo[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 16
        if (V_E.Variable16(i_riesgo[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - HIPERTENSIÓN INDUCIDA POR LA GESTACIÓN " + i_riesgo[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 17
        if (V_E.Variable17(i_riesgo[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - HIPOTIROIDISMO CONGÉNITO" + i_riesgo[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 18
        if (V_E.Variable18(i_riesgo[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - SINTOMÁTICO RESPIRATORIO " + i_riesgo[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 19
        if (V_E.Variable19(i_riesgo[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,21 - TUBERCULOSIS MULTIDROGORESISTENTE" + i_riesgo[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 20
        if (V_E.Variable20(i_riesgo[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,3,21 - LEPRA" + i_riesgo[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 21
        if (V_E.Variable21(i_riesgo[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,3,21 - OBESIDAD O DESNUTRICIÓN PROTEICO CALÓRICA " + i_riesgo[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 22
        if (V_E.Variable22(i_riesgo[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,3,21 - VÍCTIMA DE MALTRATO" + i_riesgo[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 23
        if (V_E.Variable23(i_riesgo[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - VÍCTIMA DE VIOLENCIA  SEXUAL" + i_riesgo[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 24
        if (V_E.Variable24(i_riesgo[10]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - INFECCIONES DE TRASMISIÓN SEXUAL " + i_riesgo[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 25
        if (V_E.Variable25(i_riesgo[11]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1-7, 21 - ENFERMEDAD MENTAL " + i_riesgo[11] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 26
        if (V_E.Variable26(i_riesgo[12]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - CÁNCER DE CÉRVIX" + i_riesgo[12] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 27
        if (V_E.Variable27(i_riesgo[13]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - CÁNCER DE SENO" + i_riesgo[13] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 28
        System.out.println(i_riesgo[14]);
        if (V_E.Variable28(i_riesgo[14]) == true) {
            // System.out.println(" Variable28" );
            y++;
        } else {
            y++;

            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,21 - FLUOROSIS DENTAL" + i_riesgo[14] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    /*
     Actividad_I_S_R_CNP
     * Esta funcion validad las variables 29 hasta 34, actividad de  intervencion segun el riesgo de los paciente
     *Los Datos
     *FECHA DEL PESO	PESO EN KILOGRAMOS, FECHA DE LA TALLA, TALLA EN CENTIMETROS, FECHA PROBABLE DE PARTO
     * EDAD GESTACIONAL AL NACER
    
     */
    private void Actividad_I_S_R_CNP(String[] txt) {
        System.out.println(" Actividad_I_S_R_CNP");
        String A_ISR_11[] = new String[7];
        A_ISR_11 = txt;

        //VARIABLE 29
        if (V_E.Variable29(A_ISR_11[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - FECHA DEL PESO" + A_ISR_11[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 30
        if (V_E.Variable30(A_ISR_11[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 999,  >0- PESO EN KILOGRAMOS" + A_ISR_11[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 31
        if (V_E.Variable31(A_ISR_11[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - FECHA DE LA TALLA" + A_ISR_11[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 32
        if (V_E.Variable32(A_ISR_11[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 999, > 0 - TALLA EN CENTÍMETROS " + A_ISR_11[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 33
        if (V_E.Variable33(A_ISR_11[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - FECHA PROBABLE DE PARTO " + A_ISR_11[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 34
        if (V_E.Variable34(A_ISR_11[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,999 - EDAD GESTACIONAL AL NACER " + A_ISR_11[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
    }

    /*
     Actividad_I_S_R_VACUNACION
     * Esta funcion validad las variables 35 hasta 47, actividad de  intervencion segun el riesgo de los paciente (VACUNACION)
     *Los Datos
     * BCG, HEPATITIS B MENOR DE 1 AÑO, PENTAVALENTE, POLIO,	DPT MENORES DE 5 AÑOS, ROTAVIRUS, NEUMOCOCO
     * INFLUENZA EN NIÑOS, FIEBRE AMARILLA NIÑOS DE 1 AÑO, HEPATITIS A, TRIPLE VIRAL NIÑOS, 
     * VIRUS DEL PAPILOMA HUMANO (VPH),TD o TT MUJERES EN EDAD FERTIL 15 a 49 AÑOS
    
     */
    private void Actividad_I_S_R_VACUNACION(String[] txt) {
        System.out.println(" Actividad_I_S_R_VACUNACION");
        String A_ISR_V1[] = new String[13];
        A_ISR_V1 = txt;

        //VARIABLE 35
        if (V_E.Variable35(A_ISR_V1[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - BCG" + A_ISR_V1[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 36
        if (V_E.Variable36(A_ISR_V1[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - HEPATITIS B MENORES DE 1 AÑO" + A_ISR_V1[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 37
        if (V_E.Variable37(A_ISR_V1[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-3,16-20,22 - PENTAVALENTE " + A_ISR_V1[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 38
        if (V_E.Variable38(A_ISR_V1[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-5, 16-20,22 - POLIO" + A_ISR_V1[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 39
        if (V_E.Variable39(A_ISR_V1[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,4,5,16-20,22 - DPT MENORES DE 5 AÑOS" + A_ISR_V1[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 40
        if (V_E.Variable40(A_ISR_V1[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-2,16-20,22 - ROTAVIRUS" + A_ISR_V1[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 41
        if (V_E.Variable41(A_ISR_V1[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-3, 16-20,22 - NEUMOCOCO" + A_ISR_V1[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 42
        if (V_E.Variable42(A_ISR_V1[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-3,16-20, 22 - INFLUENZA NIÑOS" + A_ISR_V1[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 43
        if (V_E.Variable43(A_ISR_V1[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - FIEBRE AMARILLA NIÑOS DE 1 AÑO" + A_ISR_V1[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 44
        if (V_E.Variable44(A_ISR_V1[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,16-20,22 - HEPATITIS A " + A_ISR_V1[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 45
        if (V_E.Variable45(A_ISR_V1[10]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-2,16-20, 22 - TRIPLE VIRAL NIÑOS  " + A_ISR_V1[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 46
        if (V_E.Variable46(A_ISR_V1[11]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-4,16-20,22 - VIRUS DEL PAPILOMA HUMANO (VPH)" + A_ISR_V1[11] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 47
        if (V_E.Variable47(A_ISR_V1[12]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-20,22 - TD O TT MUJERES EN EDAD FÉRTIL 15 A 49 AÑOS" + A_ISR_V1[12] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    /*
     Actividad_I_S_R_SPP
     * Esta funcion validad las variables 48 hasta 61, actividad de  intervencion segun el riesgo de los paciente (PLANIFICACION,PARTO,RECIEN NACIDO)
     *Los Datos
     * CONTROL DE PLACA BACTERIANA, FECHA DE ATENCION DEL PARTO O CESAREA, FECHA DE SALIDA DE LA ATENCION DEL PARTO O CESAREA,
     * FECHA DE CONSEJERIA EN LACTANCIA MATERNA, CONTROL DEL RECIEN NACIDO, PLANIFICACION FAMILIAR PRIMERA VEZ,
     * SUMINISTRO DE METODO ANTICONCEPTIVO, FECHA SUMINISTRO DE METODO ANTICONCEPTIVO, CONTROL PRENATAL PRIMERA VEZ,
     * CONTROL PRENATAL, ULTIMO CONTROL PRENATAL, SUMINISTRO DE ACIDO FOLICO EN EL ULTIMO CONTROL PRENATAL,
     * SUMINISTRO DE SULFATO FERROSO EN SU ULTIMO CONTROL PRENATAL, SUMINISTRO DE CARBONATO DE CALCIO EN EL ULTIMO CONTROL PRENATAL
    
     */
    private void Actividad_I_S_R_SPP(String[] txt) {
        System.out.println(" Actividad_I_S_R_SPP");
        String A_ISR_SPP1[] = new String[14];

        A_ISR_SPP1 = txt;

        //VARIABLE 48
        if (V_E.Variable48(A_ISR_SPP1[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - CONTROL DE PLACA BACTERIANA" + A_ISR_SPP1[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 49
        if (V_E.Variable49(A_ISR_SPP1[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - ATENCIÓN PARTO O CESÁREA" + A_ISR_SPP1[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 50
        if (V_E.Variable50(A_ISR_SPP1[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - SALIDA DE LA ATENCIÓN DEL PARTO O CESÁREA" + A_ISR_SPP1[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 51
        if (V_E.Variable51(A_ISR_SPP1[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSEJERÍA EN LACTANCIA MATERNA" + A_ISR_SPP1[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 52
        if (V_E.Variable52(A_ISR_SPP1[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONTROL RECIÉN NACIDO" + A_ISR_SPP1[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 53
        if (V_E.Variable53(A_ISR_SPP1[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - PLANIFICACIÓN FAMILIAR PRIMERA VEZ" + A_ISR_SPP1[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 54
        if (V_E.Variable54(A_ISR_SPP1[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0-18,20,21 - SUMINISTRO DE MÉTODO ANTICONCEPTIVO" + A_ISR_SPP1[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 55
        if (V_E.Variable55(A_ISR_SPP1[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - SUMINISTRO DE MÉTODO ANTICONCEPTIVO" + A_ISR_SPP1[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 56
        if (V_E.Variable56(A_ISR_SPP1[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONTROL PRENATAL DE PRIMERA VEZ" + A_ISR_SPP1[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 57
        if (V_E.Variable57(A_ISR_SPP1[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,999 - CONTROL PRENATAL" + A_ISR_SPP1[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 58
        if (V_E.Variable58(A_ISR_SPP1[10]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - ÚLTIMO CONTROL PRENATAL " + A_ISR_SPP1[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 59
        if (V_E.Variable59(A_ISR_SPP1[11]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,21 - SUMINISTRO DE ÁCIDO FÓLICO EN EL ÚLTIMO CONTROL PRENATAL  " + A_ISR_SPP1[11] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 60
        if (V_E.Variable60(A_ISR_SPP1[12]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,21 - SUMINISTRO DE SULFATO FERROSO EN EL ÚLTIMO CONTROL PRENATAL  " + A_ISR_SPP1[12] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 61
        if (V_E.Variable61(A_ISR_SPP1[13]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,21 - SUMINISTRO DE CARBONATO DE CALCIO EN EL ÚLTIMO CONTROL PRENATAL  " + A_ISR_SPP1[13] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    /*
     Actividad_I_S_R_AMCD
     * Esta funcion validad las variables 62 hasta 71, actividad de  intervencion segun el riesgo de los paciente (AGUDEZA VISUAL, MALTRATO,CRECIMIENTO Y DESARROLLO)
     *Los Datos
     * VALORACION DE AGUDEZA VISUAL, CONSULTA POR OFTALMOLOGIA, FECHA DE DIAGNOSTICO DESNUTRICION PROTEICO CALORICA,
     * CONSULTA MUJER O MENOR VICTIMA DE MALTRATO, CONSULTA VICTIMAS DE VIOLENCIA SEXUAL, CONSULTA NUTRICION
     * CONSULTA DE PSICOLOGIA, CONSULTA DE CRECIMIENTO Y DESARROLLO PRIMERA VEZ, 
     * SUMINISTRO DE SULFATO FERROSO EN LA ULTIMA CONSULTA DEL MENOR DE 10 AÑOS, SUMINISTRO DE VITAMINA A EN LA ULTIMA CONSULTA DEL MENOR DE 10 AÑOS

     */
    private void Actividad_I_S_R_AMCD(String[] txt) {
        System.out.println(" Actividad_I_S_R_AMCD");
        String A_ISR_AMCD1[] = new String[10];
        A_ISR_AMCD1 = txt;

        //VARIABLE 62
        if (V_E.Variable62(A_ISR_AMCD1[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - VALORACIÓN DE LA AGUDEZA VISUAL " + A_ISR_AMCD1[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 63
        if (V_E.Variable63(A_ISR_AMCD1[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA POR OFTALMOLOGÍA  " + A_ISR_AMCD1[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 64
        if (V_E.Variable64(A_ISR_AMCD1[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - FECHA DIAGNÓSTICO DESNUTRICIÓN PROTEICO CALÓRICA " + A_ISR_AMCD1[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 65
        if (V_E.Variable65(A_ISR_AMCD1[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA MUJER O MENOR VÍCTIMA DEL MALTRATO " + A_ISR_AMCD1[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 66
        if (V_E.Variable66(A_ISR_AMCD1[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA VÍCTIMAS DE VIOLENCIA SEXUAL " + A_ISR_AMCD1[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 67
        if (V_E.Variable67(A_ISR_AMCD1[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA NUTRICIÓN " + A_ISR_AMCD1[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 68
        if (V_E.Variable68(A_ISR_AMCD1[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA DE PSICOLOGÍA " + A_ISR_AMCD1[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 69
        if (V_E.Variable69(A_ISR_AMCD1[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA DE CRECIMIENTO Y DESARROLLO PRIMERA VEZ " + A_ISR_AMCD1[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 70
        if (V_E.Variable70(A_ISR_AMCD1[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,16,17,18,20,21 - SUMINISTRO DE SULFATO FERROSO EN LA ÚLTIMA CONSULTA DEL MENOR DE 10 AÑOS  " + A_ISR_AMCD1[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 71

        // System.out.println(A_ISR_AMCD1[9]);
        if (V_E.Variable71(A_ISR_AMCD1[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,16,17,18,20,21 - SUMINISTRO DE VITAMINA A EN LA ÚLTIMA CONSULTA DEL MENOR DE 10 AÑOS" + A_ISR_AMCD1[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        // respuesta +=" Actividad_I_S_R_AMCD" );

    }

    /*
     Actividad_I_S_R_JA_1
     * Esta funcion validad las variables 72 hasta 81, actividad de  intervencion segun el riesgo de los paciente (JOVEN,ADULTO,HEPATITIS,SIFILES)
     *Los Datos
     * CONSULTA DE JOVEN DE PRIMERA VEZ, CONSULTA DE ADULTO DE PRIMERA VEZ, PRESERVATIVOS ENTREGADOS A PACIENTES CON ITS, ASESORIA PRE TEST ELISA PARA VIH,
     * ASESORIA POST TEST ELISA PARA VIH, PACIENTE CON DIAGNOSTICO DE ANSIEDAD, DEPRESION, ESQUIZOFRENIA, DEFICIT DE ATENCION, CONSUMO DE PSA Y BIPOLARIDAD, 
     * RECIBIÓ ATENCIÓN EN LOS ULTIMOS 6 MESES POR EQUIPO INTERDISCIPLINARIO COMPLETO,	FECHA DE ANTIGENO DE SUPERFICIE HEPATITIS B EN GESTANTES, 
     * RESULTADO ANTIGENO DE SUPERFICIE HEPATITIS B EN GESTANTES, FECHA SEROLOGIA PARA SIFILIS,	RESULTADO SEROLOGIA PARA SIFILIS
    
     */
    private void Actividad_I_S_R_JA_1(String[] txt) {
        System.out.println(" Actividad_I_S_R_JA_1");
        String A_ISR_JA_11[] = new String[10];
        A_ISR_JA_11 = txt;
        //VARIABLE 72

        if (V_E.Variable72(A_ISR_JA_11[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA DE JOVEN PRIMERA VEZ " + A_ISR_JA_11[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 73
        if (V_E.Variable73(A_ISR_JA_11[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CONSULTA DE ADULTO PRIMERA VEZ " + A_ISR_JA_11[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 74
        if (V_E.Variable74(A_ISR_JA_11[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO  - PRESERVATIVOS ENTREGADOS A PACIENTES CON ITS" + A_ISR_JA_11[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 75
        if (V_E.Variable75(A_ISR_JA_11[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - ASESORÍA PRE TEST ELISA PARA VIH" + A_ISR_JA_11[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 76
        if (V_E.Variable76(A_ISR_JA_11[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - ASESORÍA POS TEST ELISA PARA VIH" + A_ISR_JA_11[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 77
        if (V_E.Variable77(A_ISR_JA_11[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - PACIENTE CON DIAGNÓSTICO DE: ANSIEDAD, DEPRESIÓN, ESQUIZOFRENIA, DÉFICIT DE ATENCIÓN, CONSUMO SPA Y BIPOLARIDAD RECIBIÓ ATENCIÓN EN LOS ÚLTIMOS 6 MESES POR EQUIPO INTERDISCIPLINARIO COMPLETO " + A_ISR_JA_11[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 78
        if (V_E.Variable78(A_ISR_JA_11[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - FECHA ANTÍGENO DE SUPERFICIE HEPATITIS B EN GESTANTES " + A_ISR_JA_11[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 79
        if (V_E.Variable79(A_ISR_JA_11[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO ANTÍGENO DE SUPERFICIE HEPATITIS B EN GESTANTES" + A_ISR_JA_11[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 80
        if (V_E.Variable80(A_ISR_JA_11[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - SEROLOGÍA PARA SÍFILIS" + A_ISR_JA_11[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 81
        if (V_E.Variable81(A_ISR_JA_11[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO SEROLOGÍA PARA SÍFILIS" + A_ISR_JA_11[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    /*
     Actividad_I_S_R_JA_2
     * Esta funcion validad las variables 82 hasta 92, actividad de  intervencion segun el riesgo de los paciente (VIH,TSH,CANCER,COLPOSCOPIA)
     *Los Datos
     *FECHA DE TOMA DE ELISA PARA VIH, RESULTADO ELISA PARA VIH	FECHA TSH NEONATAL, RESULTADO TSH NEONATAL, TAMIZAJE CANCER DE CUELLO UTERINO,
     * CITOLOGIA CERVICO UTERINA, CITOLOGIA CERVICOUTERINA RESULTADOS SEGÚN BETHESDA, CALIDAD EN LA MUESTRA DE CITOLOGIA CERVICO UTERINA,
     * CODIGO DE HABILITACION IPS DONDE SE TOMA CITOLOGIA CERVICOUTERINA, FECHA COLPOSCOPIA, CODIGO HABILITACION DONDE SE TOMA COLPOSCOPIA
    
     */
    private void Actividad_I_S_R_JA_2(String[] txt) {
        String A_ISR_JA_21[] = new String[11];
        A_ISR_JA_21 = txt;
        //VARIABLE 82
        System.out.println(" Actividad_I_S_R_JA_2");
        if (V_E.Variable82(A_ISR_JA_21[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA DE ELISA PARA VIH " + A_ISR_JA_21[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 83
        if (V_E.Variable83(A_ISR_JA_21[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO ELISA PARA VIH " + A_ISR_JA_21[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 84
        if (V_E.Variable84(A_ISR_JA_21[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TSH NEONATAL" + A_ISR_JA_21[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 85
        if (V_E.Variable85(A_ISR_JA_21[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,22 - RESULTADO DE TSH NEONATAL" + A_ISR_JA_21[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 86
        if (V_E.Variable86(A_ISR_JA_21[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,16,17,18,19,20,22 -  CÁNCER DE CUELLO UTERINO" + A_ISR_JA_21[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 87
        if (V_E.Variable87(A_ISR_JA_21[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CERVICO UTERINA" + A_ISR_JA_21[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 88
        if (V_E.Variable88(A_ISR_JA_21[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,999 - CITOLOGÍA CERVICO UTERINA RESULTADOS SEGÚN BETHESDA" + A_ISR_JA_21[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 89
        if (V_E.Variable89(A_ISR_JA_21[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,999 - CALIDAD EN LA MUESTRA DE CITOLOGÍA CERVICOUTERINA" + A_ISR_JA_21[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 90
        if (V_E.Variable90(A_ISR_JA_21[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA CITOLOGÍA CERVICOUTERINA" + A_ISR_JA_21[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 91
        if (V_E.Variable91(A_ISR_JA_21[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDA - COLPOSCOPIA" + A_ISR_JA_21[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 92
        if (V_E.Variable92(A_ISR_JA_21[10]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA COLPOSCOPIA" + A_ISR_JA_21[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    /*
     Actividad_I_S_R_JA_3
     * Esta funcion validad las variables 93 hasta 104, actividad de  intervencion segun el riesgo de los paciente (BIOPSIA CERVICAL,MAMOGRAFIA, BIOPSIA SENO,HEMOGLOBINA)
     *Los Datos
     *FECHA DE BIOPSIA CERVICAL	RESULTADO DE BIOPSIA CERVICAL, CODIGO DE HABILITACION DONDE SE TOMA BIOPSIA CERVICAL, FECHA MAMOGRAFIA,
     * RESULTADO DE MAMOGRAFIA, CODIGO DE HABILITACION DONDE SE TOMA MOMOGRAFIA, FECHA TOMA DE BIOPSIA SENO POR BACAF, FECHA DE RESULTADO
     * BIOPSIA DE SENO,	RESULTADO BIOPSIA SENO,	CODIGO DE HABILITACION IPS DONDE SE TOMA BIOPSIA SENO, FECHA TOMA DE HEMOGLOBINA, HEMOGLOBINA

     */
    private void Actividad_I_S_R_JA_3(String[] txt) {
        String A_ISR_JA_31[] = new String[12];
        A_ISR_JA_31 = txt;
        System.out.println(" Actividad_I_S_R_JA_3");
        //VARIABLE 93
        if (V_E.Variable93(A_ISR_JA_31[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - BIOPSIA CERVICAL" + A_ISR_JA_31[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 94
        if (V_E.Variable94(A_ISR_JA_31[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,6,999 - RESULTADO DE BIOPSIA CERVICAL" + A_ISR_JA_31[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 95 REVISAR " REPS" 
        if (V_E.Variable95(A_ISR_JA_31[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA BIOPSIA CERVICAL" + A_ISR_JA_31[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 96
        if (V_E.Variable96(A_ISR_JA_31[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - MAMOGRAFIA" + A_ISR_JA_31[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 97
        if (V_E.Variable97(A_ISR_JA_31[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,6,7,999 -  RESULTADO MAMOGRAFIA" + A_ISR_JA_31[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 98  REVISAR " REPS" 
        if (V_E.Variable98(A_ISR_JA_31[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA MAMOGRAFÍA " + A_ISR_JA_31[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 99
        if (V_E.Variable99(A_ISR_JA_31[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA BIOPSIA SENO POR BACAF" + A_ISR_JA_31[6] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 100
        if (V_E.Variable100(A_ISR_JA_31[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - RESULTADO BIOPSIA SENO " + A_ISR_JA_31[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 101
        if (V_E.Variable101(A_ISR_JA_31[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,3,4,5,999 - RESULTADO BIOPSIA SENO " + A_ISR_JA_31[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 102 CODIGO REPS
        if (V_E.Variable102(A_ISR_JA_31[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " NO SE ENCONTRO ENTIDAD EN LA TABLA REPS - CÓDIGO DE HABILITACIÓN IPS DONDE SE TOMA BIOPSIA SENO " + A_ISR_JA_31[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 103
        if (V_E.Variable103(A_ISR_JA_31[10]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA DE HEMOGLOBINA " + A_ISR_JA_31[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 104
        if (V_E.Variable104(A_ISR_JA_31[11]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO - HEMOGLOBINA " + A_ISR_JA_31[11] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    /*
     Actividad_I_S_R_JA_4
     * Esta funcion validad las variables 105 hasta 118, actividad de  intervencion segun el riesgo de los paciente (HEMOGLOBINA,HDL,BACILOSCOPIA,HIPOTIROIDISMO CONGENITO,SIFILIS GESTACIONAL,LEPRA)
     *Los Datos
     *FECHA DE LA TOMA DE GLICEMIA BASAL, FECHA DE CREATININA, CREATININA, FECHA DE HEMOGLOBINA GLICOSILADA, HEMOGLOBINA GLICOSILADA
     * FECHA DE TOMA DE MICROALBUMINURIA, FECHA DE TOMA DE HDL, FECHA TOMA DE BACILOSCOPIA DE DIAGNÓSTICO, BASILOSCOPIA DE DIAGNOSTICO
     * TRATAMIENTO PARA HIPOTIROIDISMO CONGENITO, TRATAMIENTO PARA SIFILIS GESTACIONAL,	TRATAMIENTO PARA SIFILIS CONGENITA,TRATAMIENTO PARA LEPRA
     * FECHA DE TERMINACION, TRATAMIENTO PARA LEISHMANIASIS

     */
    private void Actividad_I_S_R_JA_4(String[] txt) {
        System.out.println(" Actividad_I_S_R_JA_4");
        String A_ISR_JA_41[] = new String[14];
        A_ISR_JA_41 = txt;
        //VARIABLE 105
        if (V_E.Variable105(A_ISR_JA_41[0]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA DE GLICEMIA BASAL " + A_ISR_JA_41[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 106
        if (V_E.Variable106(A_ISR_JA_41[1]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - CREATININA " + A_ISR_JA_41[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 107 
        if (V_E.Variable107(A_ISR_JA_41[2]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO - CREATININA   " + A_ISR_JA_41[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 108
        if (V_E.Variable108(A_ISR_JA_41[3]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - HEMOGLOBINA GLICOSILADA " + A_ISR_JA_41[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 109
        if (V_E.Variable109(A_ISR_JA_41[4]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO  - HEMOGLOBINA GLICOSILADA" + A_ISR_JA_41[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 110
        if (V_E.Variable110(A_ISR_JA_41[5]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA DE MICROALBUMINURIA ";
        }
        //VARIABLE 111
        if (V_E.Variable111(A_ISR_JA_41[6]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA DE HDL " + A_ISR_JA_41[5] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 112
        if (V_E.Variable112(A_ISR_JA_41[7]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMATO FECHA NO VALIDO - TOMA DE BACILOSCOPIA DE DIAGNÓSTICO" + A_ISR_JA_41[7] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 113
        if (V_E.Variable113(A_ISR_JA_41[8]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 1,2,3,4,22 - BACILOSCOPIA DE DIAGNÓSTICO  " + A_ISR_JA_41[8] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 114 
        if (V_E.Variable114(A_ISR_JA_41[9]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - TRATAMIENTO PARA HIPOTIROIDISMO CONGÉNITO" + A_ISR_JA_41[9] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 115
        if (V_E.Variable115(A_ISR_JA_41[10]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 -  TRATAMIENTO PARA SÍFILIS GESTACIONAL" + A_ISR_JA_41[10] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 116
        if (V_E.Variable116(A_ISR_JA_41[11]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - TRATAMIENTO PARA SÍFILIS CONGÉNITA" + A_ISR_JA_41[11] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 117
        if (V_E.Variable117(A_ISR_JA_41[12]) == true) {
            y++;
        } else {
            y++;
            respuesta += " DATO INCORRECTO DATOS PERMITIDOS 0,1,2,16,17,18,19,20,22 - TRATAMIENTO PARA LEPRA " + A_ISR_JA_41[12] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 118
        if (V_E.Variable118(A_ISR_JA_41[13]) == true) {
            y++;
        } else {
            y++;
            respuesta += " FORMARTO FECHA NO VALIDAD - TERMINACIÓN TRATAMIENTO PARA LEISHMANIASIS" + A_ISR_JA_41[13] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    private boolean validar_Fecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat(" yyyy-MM-dd");
            Date fechas = formatoFecha.parse(fecha);
        } catch (Exception e) {
            return false;

        }
        return true;
    }

    private void Control_Registro(String txt) {
        System.out.println(txt + " ---");
        /*Control Registro*/
        String[] C_Matrix;
        int i = 0;
        StringTokenizer token = new StringTokenizer(txt, " |");
        int nDatos = token.countTokens();
        C_Matrix = new String[nDatos];
        while (token.hasMoreTokens()) {
            for (int j = 0; j < nDatos; j++) {
                C_Matrix[j] = token.nextToken();
                System.out.println(C_Matrix[j]);
            }
        }
        //VARIABLE 1

        if (V_E.ControlDatos1(C_Matrix[0]) == true) {
            // System.out.println("  VALIDO VAR 0 " );
        } else {
            respuesta += " REGISTRO DE CONTROL DATOS ORIGINALES, VARIABLE 1 " + C_Matrix[0] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 2
        if (V_E.ControlDatos2(C_Matrix[1]) == true) {
            // System.out.println("  VALIDO VAR 0 " );
        } else {
            respuesta += " REGISTRO DE CONTROL DATOS ORIGINALES, VARIABLE 2 CORRESPONDE AL CÓDIGO ASIGNADO POR LA SUPERINTENDENCIA NACIONAL  DE SALUD " + C_Matrix[1] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

        //VARIABLE 3
        if (V_E.ControlDatos3(C_Matrix[2]) == true) {
            // System.out.println("  VALIDO VAR 0 " );
        } else {
            respuesta += " REGISTRO DE CONTROL DATOS ORIGINALES, VARIABLE 3 FECHA NO PERMITIDAD " + C_Matrix[2] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 4
        System.out.println(C_Matrix[3] + " <----->" + validar_Fecha(C_Matrix[3]));
        if (V_E.ControlDatos4(C_Matrix[3]) == true) {
            // System.out.println("  VALIDO VAR 0 " );
        } else {
            respuesta += " REGISTRO DE CONTROL DATOS ORIGINALES, VARIABLE 4 FECHA NO PERMITIDAD " + C_Matrix[3] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }
        //VARIABLE 5
        if (V_E.ControlDatos5(C_Matrix[4]) == true) {
            // System.out.println("  VALIDO VAR 0 " );
        } else {
            respuesta += " REGISTRO DE CONTROL DATOS ORIGINALES, VARIABLE  " + C_Matrix[4] + " POSICION [ " + posicionX + " ][" + y + "] \n\n<br><br>";
        }

    }

    private void Valida(String txt) {

        int i = 0;
        StringTokenizer tokens = new StringTokenizer(txt, " |");
        int nDatos = tokens.countTokens();

        Inf_personal = new String[14];
        Iden_riesgo = new String[16];
        Act_ISR_1 = new String[7];
        Act_ISR_2 = new String[13];
        Act_ISR_3 = new String[14];
        Act_ISR_4 = new String[10];
        Act_ISR_5 = new String[10];
        Act_ISR_6 = new String[11];
        Act_ISR_7 = new String[12];
        Act_ISR_8 = new String[14];

        for (int j1 = 0; j1 < 14; j1++) {

            Inf_personal[j1] = tokens.nextToken();
            // System.out.println(Inf_personal[j1] + " ("  + j1 + " )"  + " -->1" );

        }
        for (int j2 = 0; j2 < 15; j2++) {

            Iden_riesgo[j2] = tokens.nextToken();
            // System.out.println(Iden_riesgo[j2] + " ("  + (+14 + j2) + " )"  + " -->2" );

        }
        for (int j3 = 0; j3 < 6; j3++) {

            Act_ISR_1[j3] = tokens.nextToken();
            // System.out.println(Act_ISR_1[j3] + " ("  + (29 + j3) + " )" +" -->3" );

        }
        for (int j4 = 0; j4 < 13; j4++) {

            Act_ISR_2[j4] = tokens.nextToken();
            // System.out.println(Act_ISR_2[j4] + " ("  + (35 + j4) + " )" +" -->4" );

        }
        for (int j5 = 0; j5 < 14; j5++) {

            Act_ISR_3[j5] = tokens.nextToken();
            // System.out.println(Act_ISR_3[j5] + " ("  + (48+j5) + " )" +" -->5" );

        }
        for (int j6 = 0; j6 < 10; j6++) {

            Act_ISR_4[j6] = tokens.nextToken();
            // System.out.println(Act_ISR_4[j6] + " ("  + (62 + j6) + " )" +" -->6" );

        }
        for (int j7 = 0; j7 < 10; j7++) {

            Act_ISR_5[j7] = tokens.nextToken();
            // System.out.println(Act_ISR_5[j7] + " ("  + (72 + j7) + " )" +" -->7" );

        }
        for (int j8 = 0; j8 < 11; j8++) {

            Act_ISR_6[j8] = tokens.nextToken();
            // System.out.println(Act_ISR_6[j8] + " ("  + (82 + j8) + " )" +" -->8" );

        }
        for (int j9 = 0; j9 < 12; j9++) {

            Act_ISR_7[j9] = tokens.nextToken();
            // System.out.println(Act_ISR_7[j9] + " ("  + (93+j9) + " )" +" -->9" );

        }
        for (int j10 = 0; j10 < 14; j10++) {

            Act_ISR_8[j10] = tokens.nextToken();
            // System.out.println(Act_ISR_8[j10] + " ("  + (105 + j10) + " )" +" -->10" );

        }

        Informacion_personal(Inf_personal);
        Identificacion_riesgo(Iden_riesgo);
        Actividad_I_S_R_CNP(Act_ISR_1);
        Actividad_I_S_R_VACUNACION(Act_ISR_2);
        Actividad_I_S_R_SPP(Act_ISR_3);
        Actividad_I_S_R_AMCD(Act_ISR_4);
        Actividad_I_S_R_JA_1(Act_ISR_5);
        Actividad_I_S_R_JA_2(Act_ISR_6);
        Actividad_I_S_R_JA_3(Act_ISR_7);
        Actividad_I_S_R_JA_4(Act_ISR_8);

    }

    public void Recorer(String txt) {
        //System.out.println(" Entra a recorrer" );

        posicionY = 0;

        Edad = " ";
        int i = 0, pos = 0;
        StringTokenizer tokens = new StringTokenizer(txt, " |"); // Separa tokens de la fila
        int nDatos = tokens.countTokens(); // Numero de tokens

        if (nDatos == 5) {
            Control_Registro(txt);

            posicionY++;
        } else if (nDatos == 119) {

            Valida(txt);

            if (uploadError.SaveFile(respuesta, true)) {
            } else {
                respuesta += " LA INFOR ESTA EN EL ERROR.TXT\n\n<br>\n\n<br><br>";
            }
            posicionY++;
        }

    }

}
