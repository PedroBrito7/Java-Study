package javacore.Ycolections.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("One Piece");
        mangas.add("Bersek");
        mangas.add("Hellsing");
        mangas.add("Pokemon");
        mangas.add("Dragon Ball Z");

        Collections.sort(mangas);

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(21.21);
        dinheiros.add(29.19);
        dinheiros.add(92.19);

        Collections.sort(dinheiros);

        for(String manga: mangas){
            System.out.println(manga);
        }

        System.out.println(dinheiros);

    }
}
