package javacore.Zgenerics.test;

import java.util.List;

public class WildcardTest02{
    public static void main(String[] args) {
        List <Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List <Gato> gatos = List.of(new Gato(), new Gato());
        //printConsulta(cachorros);// uma vez q é compilado ele nao sabe oq ta dentro da lista



    }
    private static void printConsulta(List<? extends Animal> animals){
        Cachorro a = new Cachorro();
        Cachorro a = new Gato();

        for (Animal animal : animals) {
            animal.consulta();
        }
        animals.add(new Cachorro()); // assim nao funciona pq pode ser uma lista de gatos ou de outro animal
        //animals[1] = new Gato(); //  1 é cachorro o java sabe e vai retornar um exception, mas se fosse um animals ele deixaria

    }
}

