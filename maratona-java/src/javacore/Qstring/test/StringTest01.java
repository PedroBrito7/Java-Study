package javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "willian"; // String Constant POOL
        String nome2 = "willian";
        nome = nome.concat(" Suane");
        System.out.println(nome);
        System.out.println(nome == nome2);
        String nome3 = new String("willian"); // 1 variavel de refrencia, 2 objeto de tipo string, 3 uma string no pool
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());


    }
}
