package javacore.Bmetodos.test;

import javacore.Bmetodos.dominio.Calculadora;

public class CalculadoraTest1 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.somaTwoNumbers();
        System.out.println("Finalizando CalculadoraTest01");
        calculadora.substraiTwoNumbers();
    }
}
