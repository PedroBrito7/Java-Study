package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;

public class NomeMaiusculo {
    public static void main(String[] args) {
        String nome = "Jackson"; // ou null
        Optional<String> nomeOptional = Optional.ofNullable(nome);
        Optional<String> nomeReformado = nomeOptional
                .map(String::toUpperCase)
                .filter(n -> n.length() > 4);
        nomeReformado.ifPresent(System.out::println);
    }
}
