package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;

public class OptionalMap {
    public static void main(String[] args) {
        Optional<String> nameOptional = Optional.ofNullable("  DevNinja  ");
        nameOptional.orElseGet(() -> "Usuario nao informado");
        nameOptional
                .map(String::trim)
                .map(String::toUpperCase)
                .ifPresent(System.out::println);

    }

}
