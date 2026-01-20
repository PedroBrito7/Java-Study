package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.List;

// finding and matching
public class StreamTest06 {
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
        System.out.println( lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
        System.out.println(lightNovels.stream().allMatch(ln-> ln.getPrice() > 0));
        System.out.println(lightNovels.stream().noneMatch(ln-> ln.getPrice() > 0));
    }
}
