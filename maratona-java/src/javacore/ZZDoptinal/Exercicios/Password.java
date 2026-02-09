package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;

public class Password {
    public static void main(String[] args) {
        Optional<String> senhaOptional = Optional.ofNullable(null);
        senhaOptional.orElseThrow(() ->
                new IllegalArgumentException("Senha obrigatória"));
    }
}
