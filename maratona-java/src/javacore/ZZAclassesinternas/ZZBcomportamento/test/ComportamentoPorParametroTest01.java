package javacore.ZZAclassesinternas.ZZBcomportamento.test;

import javacore.ZZAclassesinternas.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars =List.of(new Car("green",  2011), new Car("blue",  2008), new Car("white",  1995));

public static void main(String[] args) {
    System.out.println(filterCarByColor(cars,"green"));
    System.out.println(filterCarByColor(cars,"blue"));
    System.out.println(filterCarByYear(cars,2010));
}
private static List<Car> filterGreenCar(List<Car> cars) {
    List<Car> greensCars = new ArrayList<>();
    for (Car car : cars) {
        if (car.getColor().equals("green")) {
            greensCars.add(car);
        }
    }
    return greensCars;
}
    private static List<Car> filterCarByColor(List<Car> cars,String cor ) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(cor)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
    private static List<Car> filterCarByYear(List<Car> cars, int year) {
        List<Car> filtereYear = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year) {
                filtereYear.add(car);
            }
        }
        return filtereYear;
    }
}


