package javacore.Xserializacao.test;

import javacore.Xserializacao.dominio.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Person p= new Person("Pedro", 19);
        Person person = deserializar();
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }

    private static void serializar(Person person) throws IOException {
        Path path = Path.of("data/person.ser");
        Files.createDirectories(path.getParent());
        try {
            Files.createDirectories(path.getParent());

            try (ObjectOutputStream oos =
                         new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(person);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Person deserializar() {
        Path path = Path.of("data/person.ser");

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {

            return (Person) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

