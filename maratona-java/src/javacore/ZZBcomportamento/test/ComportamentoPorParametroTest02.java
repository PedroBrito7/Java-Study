package javacore.ZZBcomportamento.test;

import javacore.ZZBcomportamento.Interfaces.CarPredicate;
import javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars =List.of(new Car("green",  2011), new Car("blue",  2008), new Car("white",  1995));

    public static void main(String[] args) {
List<Car> greenCars = filter(cars,car ->car.getColor().equals("green"));
List<Car> yearsBefore = filter(cars,car ->car.getYear() < 2018);
        System.out.println(greenCars);
        System.out.println(yearsBefore);
    }
    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if(carPredicate.test(car)){
                filteredCar.add(car);
}
        }
        return filteredCar;
    }

}


