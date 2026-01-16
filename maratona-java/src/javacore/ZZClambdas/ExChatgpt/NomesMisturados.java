package javacore.ZZClambdas.ExChatgpt;

import java.util.List;

public class NomesMisturados {
    public static void main(String[] args) {
        List<String> nomes = List.of(
                "ana",
                "Pedro",
                "cARLos",
                "Amanda",
                "bruno",
                "ALICE"
        );
        nomes.stream()
                .sorted(String::compareToIgnoreCase)
                .forEach(System.out::println);
    }
}
