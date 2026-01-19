package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1 . order lightnovel by title
// 2 . retrieve the first 3 light novel with price less than 4
public class StreamTest01 {
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
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));
        List<String> titles = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels){
            if(lightNovel.getPrice() <=4){
                titles.add(lightNovel.getTitle());
            }
            if (titles.size()>=3){
                break;
            }
        }
        System.out.println(titles);
    }
}
