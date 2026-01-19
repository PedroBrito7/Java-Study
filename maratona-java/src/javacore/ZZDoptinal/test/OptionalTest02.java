//package javacore.ZZDoptinal.test;
//
//import javacore.ZZDoptinal.Dominio.Manga;
//import javacore.ZZDoptinal.Repository.MangaRepository;
//
//import java.util.Optional;
//
//public class OptionalTest02 {
//    public static void main(String[] args) {
//       Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
//        mangaByTitle.ifPresent(m -> m.setTitle("Boku no hero 2"));
//        System.out.println(mangaByTitle);
//
//        Manga mangaById = MangaRepository.findById(2);
////                .orElseThrow(IllegalAccessException::new);
//        System.out.println(mangaById);
//
//        Manga newManga = MangaRepository.findByTitle("Drifters")
//                .orElseGet(() ->new Manga(3, "Drifters", 20));
//        System.out.println(newManga);
//
//    }
//}
