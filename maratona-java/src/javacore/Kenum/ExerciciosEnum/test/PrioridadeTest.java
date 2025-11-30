package javacore.Kenum.ExerciciosEnum.test;

import javacore.Kenum.ExerciciosEnum.dominio.Prioridade;

public class PrioridadeTest {
    public static void main(String[] args) {
        // 1. Iterando sobre todas as constantes do Enum, usando Prioridade.values()
        for (Prioridade p : Prioridade.values()){
            // 2. Imprimindo o nome da constante e acessando o atributo via getter
            System.out.println(p.name() + " tem o valor numérico: " + p.getVALOR());
        }
        System.out.println("\nPrioridade Média tem o valor: " + Prioridade.MEDIA.getVALOR());
    }
}