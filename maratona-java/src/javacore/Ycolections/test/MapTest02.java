package javacore.Ycolections.test;

import javacore.Ycolections.dominio.Consumidor;
import javacore.Ycolections.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor(12312321L, "Pedro da massa");
        Consumidor consumidor2 = new Consumidor(12312321L, "Britao da massa");
        Manga hellsingUltimate = new Manga(5L, "Hellsing ultimate", 1.9);
        Manga naruto = new Manga(5L, "Naruto ultimate", 1.9);
        Manga jiraya = new Manga(5L, "Jiraya ultimate", 1.9);
        Manga zoro = new Manga(5L, "Zoro ultimate", 1.9);
        Manga luffy = new Manga(5L, "LUffy ultimate", 1.9);
        Map<Consumidor, Manga> consumidorMangaMap = new HashMap<>();
        consumidorMangaMap.put(consumidor1, naruto);
        consumidorMangaMap.put(consumidor2, luffy);
        for (Map.Entry<Consumidor, Manga> entry : consumidorMangaMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue().getNome());
        }

    }
}
