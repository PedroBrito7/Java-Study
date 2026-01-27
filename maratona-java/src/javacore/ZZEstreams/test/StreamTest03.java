package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.Category;
import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
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
        Stream<LightNovel> stream = lightNovels.stream();
        lightNovels.forEach(System.out::println);
        long count = stream.filter(ln -> ln.getPrice()<=4).count();
        long count2 = lightNovels.stream()
                .distinct()
                .filter(ln -> ln.getPrice() <=4)
                .count();
        System.out.println(count);
        System.out.println(count2);


    }
}
