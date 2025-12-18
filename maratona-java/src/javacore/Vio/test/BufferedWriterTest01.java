package javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try(FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw)) { // buffered more optimized
            bw.write(" O DevBrito é nerdzão e vai ser o melhor dev java da gringaaaaaaaaaaaa \n continuando a cantoria da proxima linha");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
