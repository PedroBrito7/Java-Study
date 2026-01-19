package ZZDoptinal.Exercicios;

import java.util.Optional;

public class PalavraOptional {
    public static void main(String[] args) {
        Optional<String> palavraOptional = Optional.of("DevBrito");
        Optional<Integer> palavraRetorna = palavraOptional.map(String::length);
        palavraRetorna.ifPresent( System.out::println);;


    }
}
