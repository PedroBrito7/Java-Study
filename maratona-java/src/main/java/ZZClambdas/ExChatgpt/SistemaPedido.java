package javacore.ZZClambdas.ExChatgpt;

import javacore.ZZClambdas.ExChatgpt.Dominio.Pedido;

import java.util.Comparator;
import java.util.List;

public class SistemaPedido {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Ana", 250.0, true),
                new Pedido("Pedro", 120.0, false),
                new Pedido("Carlos", 600.0, true),
                new Pedido("Amanda", 90.0, true),
                new Pedido("Bruno", 450.0, false),
                new Pedido("Alice", 700.0, true)
        );
        pedidos.stream()
                .filter(Pedido::isPago)
                .filter(p -> p.getValor() > 200)
                .sorted(Comparator.comparingDouble(Pedido::getValor))
                .map(Pedido::getCliente)
                .forEach(System.out::println);
        System.out.println(pedidos);
    }
}
