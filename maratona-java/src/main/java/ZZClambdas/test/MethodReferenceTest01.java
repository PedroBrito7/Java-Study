package javacore.ZZClambdas.test;

import javacore.ZZClambdas.dominio.Anime;
import javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Bersek", 43), new Anime("One piece", 900), new Anime("Naruto", 500)));
        //Collections.sort(animeList, (a1,a2)->a1.getTitle().compareTo(a2.getTitle()));
        //Collections.sort(animeList,(a1,a2)-> AnimeComparators.compareByTitle(a1,a2));
        animeList.sort(AnimeComparators::compareByTitle);
        //animeList.sort(AnimeComparators ::compareByEpisodes);
        System.out.println(animeList);
    }
}
