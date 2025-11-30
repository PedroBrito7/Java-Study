package javacore.Kenum.ExerciciosEnum.test;

import javacore.Kenum.ExerciciosEnum.dominio.Moeda;

public class MoedaTest {
    public static void main(String[] args) {
        Moeda moeda = Moeda.REAL;
        double valorEmDolar = 100.0;
        double valorConvertido = Moeda.DOLAR.converterParaBase(valorEmDolar);

        System.out.println(valorEmDolar + " Dólares equivalem a: R$" + valorConvertido);
    }
}
