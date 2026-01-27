package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.Category;
import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// finding and matching
public class StreamTest06 {
    private static List<LightNovel> lightNovels = new ArrayList<>( List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY ),
            new LightNovel("Naruto", 3.99, Category.FANTASY),
            new LightNovel("Overloard", 5.99, Category.FANTASY),
            new LightNovel("violet evergarden", 2.99, Category.DRAMA),
            new LightNovel("No game no life", 4.99, Category.FANTASY),
            new LightNovel("Fullmetal alchemist", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.FANTASY)
    ));
    public static void main(String[] args) {
        System.out.println( lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8)); // filtragem, tem alguma light novel maior que 8
        System.out.println(lightNovels.stream().allMatch(ln-> ln.getPrice() > 0)); // filtragem todos elementos são maiores que 0 ?
        System.out.println(lightNovels.stream().noneMatch(ln-> ln.getPrice() > 0)); // filtragem nenhum elemento é maior do que zero ?
        lightNovels.stream()
                .filter(ln ->ln.getPrice() > 3)
                .findAny()// ele acha qualquer elemento
                .ifPresent(System.out::println);
        lightNovels.stream()
                .filter(ln ->ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);
    }
}
