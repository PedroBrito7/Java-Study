package javacore.DConstrutores.test;

import javacore.DConstrutores.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("Haikyuu", "TV", 12, "Sports", "Production IG");
        Anime anime2 = new Anime();

        anime.print();
        System.out.println("-------------");
        anime2.print();
    }
}
