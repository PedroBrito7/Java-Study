package javacore.dsa.test;

import javacore.dsa.Vetor;

public class Main {
    public static void main(String[] args) {
        try {
            Vetor nomes = new Vetor(5);
            nomes.adicionar("Pedro");
            nomes.adicionar("Ana");
            nomes.adicionar("Julia");
            nomes.adicionar("Julia");
            nomes.adicionar("Julia");
            nomes.adicionar("Julia");
            nomes.adicionar("Julia");
            nomes.adicionar("Julia");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
