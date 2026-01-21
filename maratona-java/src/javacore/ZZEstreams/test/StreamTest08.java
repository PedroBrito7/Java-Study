package javacore.ZZEstreams.test;

import javacore.ZZEstreams.classes.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class StreamTest08 {
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
        // quero que some todos os precos acima de 3 e retorno o preco acima deles
lightNovels.stream()
        .map(LightNovel::getPrice)
        .filter(price ->price > 3)
        .reduce(Double::sum)// sum já é uma soma pronta
        .ifPresent(System.out::println);

        DoubleStream doubleStream = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice);
                 System.out.println(doubleStream.sum());
    }

}
