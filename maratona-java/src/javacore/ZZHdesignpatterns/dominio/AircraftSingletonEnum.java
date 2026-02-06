package javacore.ZZHdesignpatterns.dominio;

import java.util.HashSet;
import java.util.Set;

public enum AircraftSingletonEnum {
    INSTANCE;
    private final Set<String> availableSeats ;

    AircraftSingletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1a");
        this.availableSeats.add("1b");
    }
    public boolean bookSeat(String seat){
        return availableSeats.remove(seat);
    }

}
