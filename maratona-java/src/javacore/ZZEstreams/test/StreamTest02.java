package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest02 {
        private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
                new LightNovel("Tensei Shittara", 8.99),
                new LightNovel("Naruto", 3.99),
                new LightNovel("Overloard", 5.99),
                new LightNovel("violet evergarden", 2.99),
                new LightNovel("No game no life", 4.99),
                new LightNovel("Fullmetal alchemist", 1.99),
                new LightNovel("Monogatari", 4.00)
        ));
    public static void main(String[] args) {
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(ln -> ln.getPrice() <= 4)
                .limit(3)
                .map(LightNovel::getTitle) // retorna outro string
                .collect(Collectors.toList());
        System.out.println(titles);
    }
}
