package javacore.ZZDoptinal.Exercicios;

import java.util.Optional;


public class CenarioReal {
    static class Usuario {
        private String nome;

        public Usuario(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    static Optional<Usuario> buscarUsuarioPorEmail(String email) {
        Usuario user = new Usuario("Pedro"); // simulação

        if (email.equals("pedro@email.com")) {
            return Optional.of(user);
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        Usuario user = new Usuario("Pedro");
        Optional<Usuario> nomeExiste = Optional.ofNullable(user);
        Optional<Usuario> usuario = buscarUsuarioPorEmail("Pedro@gmail.com");
        usuario
                .map(Usuario::getNome)
                .map(String::toUpperCase)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuário não encontrado")
                );


    }
}
