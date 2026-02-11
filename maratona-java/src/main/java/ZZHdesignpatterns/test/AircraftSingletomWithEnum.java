package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.AircraftSingletonEnum;

public class AircraftSingletomWithEnum {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1B");
    }

    public static boolean bookSeat(String seat) {
        System.out.println(AircraftSingletonEnum.INSTANCE.hashCode());
        AircraftSingletonEnum instance = AircraftSingletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));
        return false;
    }
}