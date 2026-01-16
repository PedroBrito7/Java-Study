package javacore.ZZClambdas.test;

import javacore.ZZClambdas.dominio.Anime;
import javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest04 {
    public static void main(String[] args) {
        // reference to a constructor
        Supplier<AnimeComparators> newAnimeAcomparators = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimeAcomparators.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Bersek", 43), new Anime("One piece", 900), new Anime("Naruto", 500)));

        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);
        // bi funciton recebe um s , i e retorna um R
        BiFunction<String, Integer, Anime> animeBiFunction =  (title,episodes) -> new Anime(title,episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;
        System.out.println(animeBiFunction2.apply("Super onze", 29));

    }
}
