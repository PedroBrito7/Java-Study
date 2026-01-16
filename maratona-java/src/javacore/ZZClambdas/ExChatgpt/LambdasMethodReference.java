package javacore.ZZClambdas.ExChatgpt;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdasMethodReference {
static class Produto {
        protected String nome;
        protected double valor;

        public Produto(String nome, double valor) {
            this.nome = nome;
            this.valor = valor;
        }
    @Override
    public String toString() {
        return nome + " - R$ " + valor;
    }
        public String getNome() {
            return nome;
        }

        public double getValor() {
            return valor;
        }
    }
    public static void main(String[] args) {
        List<String> names = List.of("Pedro", "ana", "Henri");
        names.forEach(name -> System.out.println(name.toUpperCase()));

        // Lambda com Predicate
        List<Integer> numPar = List.of(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = n -> n % 2==0;
        numPar.stream()
                .filter(isEven)
                .forEach(System.out::println);
        // Exercício 3 — Function<T, R> com Lambda - jogar dados da lista para minusculo
        List<String> palavras = List.of("Java", "LAMBDA", "Stream", "Funcional");

        Function<String, String> toLower = s -> s.toLowerCase();

        List<String> resultado = palavras.stream()
                .map(toLower)
                .collect(Collectors.toList());

        System.out.println(resultado);
        //Exercício 4 -  Metodo reduce
        List<Double> precos = List.of(20.0,32.23,20.3,55.5,6.7,899.5);
        double soma = precos.stream().reduce(0.0, (subtotal, element) -> subtotal + element);
        System.out.println(soma);

        // Exercicio 5 - Ordenação com Lambda e Method Reference
        List<Produto> produtos = new ArrayList<>(List.of(
                new Produto("Teclado", 150),
                new Produto("Mouse", 80),
                new Produto("Monitor", 1200),
                new Produto("Headset", 300.0),
                new Produto("Webcam", 250.0)
        ));

       produtos.sort((p1, p2) -> Double.compare(p1.getValor(), p2.getValor()));
        System.out.println(produtos);

    // Exercício 6 — Contagem com condição (count)
        List<String> list3 = List.of("Ana", "Ametista", "pedro", "Dono ricado", "Ace");
        long count = list3.stream()
                .filter(s-> s.toUpperCase().startsWith("A"))
                .count();
        System.out.println(count);
    }



}
