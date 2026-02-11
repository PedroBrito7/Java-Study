package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;

public class IdadeOPtional {
    public static void main(String[] args) {
        Optional<Integer> idadeOptional = Optional.ofNullable(25);
        Integer i = idadeOptional.orElseGet(() -> 18);

    }
}
