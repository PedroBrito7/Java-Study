package javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) {
        File fileDir = new File("pasta");
        boolean isDirCreated = fileDir.mkdir();
        System.out.println(isDirCreated);
        File fileArquivoDiretorio = new File("/home/pedro/Documents/Java-Study/pasta/arquivo.text");
        try {
            boolean isFileCreated = fileArquivoDiretorio.createNewFile();
            System.out.println(isFileCreated);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fileRenamed = new File(fileDir, "arq_renomeado_txt");
        boolean isRenamed =  fileArquivoDiretorio.renameTo(fileRenamed);
        System.out.println(isRenamed);


        File dirRenamed = new File("pasta2");
        boolean isDirRenamed1 =  fileDir.renameTo(dirRenamed);
        System.out.println(isDirRenamed1);
    }
}
