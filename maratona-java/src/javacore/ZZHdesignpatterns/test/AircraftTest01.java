package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.Aircraft;

public class AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }
    private static void bookSeat(String seat){
        Aircraft aircraft = new Aircraft("787-900"); // pegando assentos do 787-900 imaginando que seja único
        System.out.println(aircraft.bookSeat(seat));
    }
}
