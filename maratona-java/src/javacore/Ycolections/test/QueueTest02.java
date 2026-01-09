package javacore.Ycolections.test;

import javacore.Ycolections.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        mangas.add(new Manga(53L, "Hellsing ultimate", 19.9));
        mangas.add(new Manga(52L, "Naruto ultimate", 9.9));
        mangas.add(new Manga(51L, "Jiraya ultimate", 29.9));
        mangas.add(new Manga(4L, "Zoro ultimate", 15.9));
        mangas.add(new Manga(3L, "Luffy ultimate", 25.9));
        while (!mangas.isEmpty()) {
            System.out.println(mangas.poll());
        }
    }
}
