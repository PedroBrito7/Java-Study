package javacore.Oexception.Exception.test;

import javacore.Oexception.Exception.dominio.Leitor1;
import javacore.Oexception.Exception.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {

        lerArquivo();

    }


    public static void lerArquivo() {
        //  try( Reader reader = new BufferedReader(new FileReader("test.txt")) ) da pra usar assim
        // porem fica melhor usando desse jeito chamando a classe Closeable
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2();) {
        } catch (IOException e) {
        }

    }


    public static void lerArquivo2() {
        Reader reader = null; // declara fora pra poder mexer com ela dentro
        try {
            reader = new BufferedReader(new FileReader("test.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
