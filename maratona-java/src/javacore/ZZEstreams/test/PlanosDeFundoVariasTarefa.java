package javacore.ZZEstreams.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlanosDeFundoVariasTarefa {
    public static void main(String[] args) {
        record Tarefa(String nome, List<String> tags) {}

        List<Tarefa> tarefas = List.of(
                new Tarefa("Estudar", List.of("Importante", "Urgente")),
                new Tarefa("Comprar comida", List.of("Casa")),
                new Tarefa("Treinar", List.of("Saúde", "Importante"))
        );

        Set<String> todosTags = tarefas.stream()
                .flatMap(t -> t.tags().stream())
                .collect(Collectors.toSet());

        System.out.println(todosTags);
    }
}
