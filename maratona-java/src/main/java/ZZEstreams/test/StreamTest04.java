package javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// flatMap -
public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Wiliam siane", "Catarina santos", "Sandy");
        List<String> developers = List.of("Wiliam siane", "Pedro", "Ana");
        List<String> students = List.of("édipo", "Gustavo", "tomate", "Banana");
        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);
        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }
        }
        Stream<String> stringStream = devdojo.stream()
                .flatMap(l -> l.stream());

    }
}