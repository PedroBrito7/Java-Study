package javacore.Ycolections.test;

import javacore.Ycolections.dominio.Manga;
import javacore.Ycolections.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;
class SmartphoneMarcaComparator implements Comparator<Smartphone>{
    @Override
    public int compare(Smartphone o1, Smartphone o2){
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "NOKIA");
        set.add(smartphone);
        NavigableSet<Manga> mangas = new TreeSet<>();
        mangas.add(new Manga(5L,"Hellsing ultimate", 1.9,0));
        mangas.add(new Manga(1L,"Bersek",9.5,5));
        mangas.add(new Manga(4L,"Pokemon",3.2,0));
        mangas.add(new Manga(3L,"Attack on titan",11.20,2));
        mangas.add(new Manga( 2L,"Dragon ball Z",2.99,0));
        for (Manga manga : mangas){
            System.out.println(manga);
        }

    }
}
