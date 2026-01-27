package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.Category;
import javacore.ZZEstreams.classes.LightNovel;
import javacore.ZZEstreams.classes.PROMOTION;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;

public class StreamTest14 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overloard", 10.99, Category.FANTASY),
            new LightNovel("violet evergarden", 5.99, Category.DRAMA),
            new LightNovel("No game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
// Contar quantas light novels existe por categoria, e maiores preços
        Map<Category, Long> collect = lightNovels.stream().collect(groupingBy(LightNovel::getCategory, Collectors.counting()));
        System.out.println(collect);

        Map<Category, Optional<LightNovel>> collect1 = lightNovels.stream().collect(groupingBy(LightNovel::getCategory, Collectors.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println(collect1);

        // para remover o optional acima faca o de baixo

        lightNovels.stream().collect(groupingBy(LightNovel::getCategory,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)),Optional::get)));
    }
}
