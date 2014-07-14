/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileUploadTester;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

/**
 *
 * @author root
 */
public class uploadError {
    public static boolean SaveFile( String FileContent, boolean CleanFileContent) {       
        String FilePath="C:\\Users\\christian\\Documents\\a\\errores.txt";
        //System.out.println("LLEGA CON "+FileContent);
        FileWriter file;
        BufferedWriter writer;

        try {
            file = new FileWriter(FilePath, !CleanFileContent);
            writer = new BufferedWriter(file);
            writer.write(FileContent, 0, FileContent.length());

            writer.close();
            file.close();

            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
