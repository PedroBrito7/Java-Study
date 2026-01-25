package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
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
        System.out.println(lightNovels.stream().count());
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        lightNovels.stream().max(Comparator.comparing(LightNovel::getPrice)).ifPresent(System.out::println);
        lightNovels.stream().collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))).ifPresent(System.out::println);
        lightNovels.stream().map(Comparator.comparing(LightNovel::getTitle)).ifPresent(souut);

        }
}
