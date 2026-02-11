package javacore.Kenum.ExerciciosEnum.test;

import javacore.Kenum.ExerciciosEnum.dominio.Tamanho;

public class TamanhoTest {
    public static void main(String[] args) {
        Tamanho tamanho;
        for (Tamanho t : Tamanho.values()) {
            System.out.println(t.getDescricaoCompleta());
        }
    }
}
