package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;

public class NomeOptional {
    public static void main(String[] args) {

        Optional<String> nomeOptional = Optional.ofNullable("Pedro");
        nomeOptional.ifPresent(nome -> System.out.println(nome));

    }

}
