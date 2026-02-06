package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.Aircraft;
import javacore.ZZHdesignpatterns.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }
    private static void bookSeat(String seat){
        System.out.println(AircraftSingletonEager.getInstance());
        AircraftSingletonEager aircraft = AircraftSingletonEager.getInstance(); // pegando assentos do 787-900 imaginando que seja único
        System.out.println(aircraft.bookSeat(seat));
    }
}
