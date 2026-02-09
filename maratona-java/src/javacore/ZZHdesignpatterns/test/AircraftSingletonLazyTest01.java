package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.AircraftSingletonLazy;

public class AircraftSingletonLazyTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
        System.out.println(AircraftSingletonLazy.getInstance());
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonLazy.getInstance());
        AircraftSingletonLazy aircraft = AircraftSingletonLazy.getInstance(); // pegando assentos do 787-900 imaginando que seja único
        System.out.println(aircraft.bookSeat(seat));
    }
}
