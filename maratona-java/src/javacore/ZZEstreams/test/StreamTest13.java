package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.Category;
import javacore.ZZEstreams.classes.LightNovel;
import javacore.ZZEstreams.classes.PROMOTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
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
// caso a price seja menor que 6 - UNDER_PROMOTION | caso seja maior que 6 normal promotion -> agrupe isso na chave do map

        Map<PROMOTION, List<LightNovel>> collect = lightNovels.stream()
                .collect(Collectors.groupingBy(ln -> {
                            return ln.getPrice() < 6 ? PROMOTION.UNDER_PROMOTION : PROMOTION.NORMAL_PRICE;
                        }
                ));
        System.out.println(collect);


        // Map <Category, Map <Promotion, List<lightNovel>>>
        Map<Category, Map<PROMOTION, List<LightNovel>>> collect1 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory,
                Collectors.groupingBy(ln ->
                        ln.getPrice() < 6 ? PROMOTION.UNDER_PROMOTION : PROMOTION.NORMAL_PRICE

                )));
        System.out.println(collect1);
        // Collectors.groupingBy(LightNovel::getCategory ESSA PARTE AGRUPA POR CATEGORIA OU SEJA FAZENDO ELE VIRA UM MAP CATEGORY
        // outro Grupo por  promotion =  ln.getPrice() < 6 ? PROMOTION.UNDER_PROMOTION : PROMOTION.NORMAL_PRICE
    }
}
