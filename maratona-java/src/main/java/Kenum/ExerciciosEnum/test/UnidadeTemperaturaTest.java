package javacore.Kenum.ExerciciosEnum.test;

import javacore.Kenum.ExerciciosEnum.dominio.UnidadeTemperatura;


public class UnidadeTemperaturaTest {
    public static void main(String[] args) {

        double fahrenheit = 80.0;
        double celsius = 30.0;

        double c1 = UnidadeTemperatura.FAHRENHEIT.converterParaCelsius(fahrenheit);
        System.out.println(fahrenheit + "°F é igual a " + c1 + "°C.");


        double c2 = UnidadeTemperatura.CELSIUS.converterParaCelsius(celsius);
        System.out.println(celsius + "°C é igual a " + c2 + "°C.");
    }
}
