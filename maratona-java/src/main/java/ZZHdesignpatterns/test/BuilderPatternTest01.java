package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        //new Person("Pedro","Brito", "Viradonojiraya", "pedrobrito@gmail.com");
        // Construtor com mt argumento - Design pattern Builder = organiza isso
        new Person.PersonBuilder()
                .firstName("pedro")
                .lastName("brito")
                .username("pedro7brito")
                .email("pedro.ff@gmail.com");

    }
}
