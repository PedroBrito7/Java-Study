package javacore.ZZEstreams.test;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMapUsoReal {
    public static void main(String[] args) {
        class Pedido {
            private List<String> produtos;

            public Pedido(List<String> produtos) {
                this.produtos = produtos;
            }

            public List<String> getProdutos() {
                return produtos;
            }
        }

        List<Pedido> pedidos = List.of(
                new Pedido(List.of("Camisa", "Meias")),
                new Pedido(List.of("Calça", "Tênis")),
                new Pedido(List.of("Boné"))
        );

        List<String> todosProdutos = pedidos.stream()
                .flatMap(p -> p.getProdutos().stream())
                .collect(Collectors.toList());

        System.out.println(todosProdutos);
    }
}