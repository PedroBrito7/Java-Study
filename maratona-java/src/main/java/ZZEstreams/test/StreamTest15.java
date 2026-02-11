package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.Category;
import javacore.ZZEstreams.classes.LightNovel;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTest15 {
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
        // agrupamento por categoarias seguindo precos, por exemplo dentro da categoria fantasy qual o maior preco, qual o menor preco
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));
        System.out.println(collect);
        // ter o under promotion e ter o normal promotion por categoria, - dentro de fantasy mostra qual é under promotion e normal
        lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));

//        private static PROMOTION getPromotion (LightNovel ln){
//            return ln.getPrice() < 6 ? PROMOTION.UNDER_PROMOTION : PROMOTION.NORMAL_PRICE;
//
//
//            Map<Category, Set<PROMOTION>> collect1 = lightNovels.stream()
//                    .collect(groupingBy(LightNovel::getCategory, mapping(StreamTest15::getPromotion, toSet())));
//            System.out.println(collect1);
//        }
    }
}


