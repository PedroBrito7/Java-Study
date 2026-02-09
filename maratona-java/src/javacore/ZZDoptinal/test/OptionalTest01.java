package javacore.ZZDoptinal.test;

import java.util.Optional;

public class OptionalTest01 {
    // Optional é tentar evitar muito o uso de exception, falar que o retorno é opcional
    public static void main(String[] args) {
        // Simulando um valor que pode ou não existir
        String nome = "Pedro";
        Optional<String> nomeOptional = Optional.ofNullable(nome);

        if (nomeOptional.isPresent()) {
            System.out.println("Nome: " + nomeOptional.get());
        }
        nomeOptional.ifPresent(n ->
                System.out.println("Nome em maiúsculo: " + n.toUpperCase())
        );
        String resultado = nomeOptional.orElse("Nome não informado");
        System.out.println(resultado);
        String resultado2 = nomeOptional.orElseGet(() -> {
            return "Valor gerado dinamicamente";
        });
        System.out.println(resultado2);
        String nomeSeguro = nomeOptional.orElseThrow(() ->
                new IllegalArgumentException("Nome é obrigatório")
        );
        System.out.println(nomeSeguro);

        Optional<Integer> tamanhoNome = nomeOptional.map(String::length);
        tamanhoNome.ifPresent(t ->
                System.out.println("Tamanho do nome: " + t)
        );
    }
}
