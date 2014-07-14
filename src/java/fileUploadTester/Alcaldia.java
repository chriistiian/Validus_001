/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileUploadTester;

import static fileUploadTester.Validacion.respuesta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author Administrador
 */
public class Alcaldia {

    public String Texto = "";
    public String[] Matriz;
    public Validacion ob = new Validacion();
    public static String act_sifilis;

    public void archivoTXT(String Ruta) {
        act_sifilis = "";
        try {
            FileReader fr = new FileReader(Ruta);
            BufferedReader br = new BufferedReader(fr);
            String txt, ruta = Ruta;
            if (ob.Nombre_archivo(ruta) == true) {
                ob.posicionX = 0;
                int aux = 0;
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    ob.Recorer(line);
                    ob.posicionX++;

                    System.out.println("NUMERO DE LINEAS (" + ob.posicionX + ")");
                    // System.out.println(line);
                }


                /* while ((txt = br.readLine()) != null) {
                 ob.Recorer(txt);
                 ob.posicionX++;   
                 aux++;
                 System.err.println("POSICIONES "+br.readLine());
                 }*/
            }

        } catch (Exception e) {
        }

    }
}
