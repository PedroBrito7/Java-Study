package javacore.Vio.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileReader fr = new FileReader(file)) {
//            char[] in = new char[30];
//            int size = fr.read(in);
//            System.out.println(size);
//            for(char c : in){
//                System.out.print(c);
//            }
            int i;
            while ((i = fr.read()) != -1) {// fr.read ja comeca com -1, vai percorrer o texto         System.out.print((char) i);
                System.out.print((char) i);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
