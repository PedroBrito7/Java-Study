package javacore.ZZClambdas.test;

import javacore.ZZClambdas.dominio.Pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdasTest03 {
    // lambdas com filter
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("Java", "lambda", "javanautas", "spring");
        List<String> palavrasFiltradas = new ArrayList<>();
        for (String palavra : palavras) {
            if (palavra.length() > 5) {
                palavrasFiltradas.add(palavra);
            }
        }
        System.out.println("Palavras com mais de 5 letras sem função lambda" + palavrasFiltradas);
        List<String> palavrasFiltradasFL = palavras.stream().filter(s -> s.length() > 5).toList();
        System.out.println("Palavras com mais de 5 letras com função lambda" + palavrasFiltradasFL);
    }

    // filtros com objetos
    List<Pessoa> pessoas = Arrays.asList(
            new Pessoa("Alice", 25),
            new Pessoa("Bob", 30),
            new Pessoa("Charlie", 22)
    );
    List<String> nomes = pessoas.stream().map(pessoa -> pessoa.getNome()).toList();
    List<Integer> idade = pessoas.stream().map(Pessoa::getIdade).toList();
}
