package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;

public class EmailOptional {
    public static void main(String[] args) {
        Optional<String> emailOptional = Optional.ofNullable(null);
        String email = emailOptional.orElseGet(() ->"usuario_anonimo@email.com");
        System.out.println(emailOptional);
    }
}
