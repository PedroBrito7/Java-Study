package javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//File
//FileWriter
//FileReader
//BufferedWriter
//BufferedReader
public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(" O DevBrito é nerdzão e vai ser o melhor dev java da gringaaaaaaaaaaaa \n continuando a cantoria da proxima linha");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
