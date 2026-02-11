package javacore.ZZBcomportamento.Interfaces;

import javacore.ZZBcomportamento.dominio.Car;

@FunctionalInterface
public interface CarPredicate {
    Boolean test(Car car);

}
