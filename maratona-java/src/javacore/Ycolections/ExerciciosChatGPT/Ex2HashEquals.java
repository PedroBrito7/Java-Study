package javacore.Ycolections.ExerciciosChatGPT;

import javacore.Ycolections.dominio.Pessoa;

public class Ex2HashEquals {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Ana Silva", "123.456.789-00");
        Pessoa p2 = new Pessoa("Ana Silva", "123.456.789-00");
        System.out.println(p1.equals(p2));
    }
}
