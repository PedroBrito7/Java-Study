package javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmailsSeparadosFlatMap {
    public static void main(String[] args) {
        List<String> registros = List.of(
                "joao@mail.com, maria@mail.com",
                "ana@mail.com, joao@mail.com",
                "carlos@mail.com"
        );

        List<String> emails = registros.stream()
                .flatMap(r -> Arrays.stream(r.split(",")))
                .map(String::trim)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(emails);
    }
}
