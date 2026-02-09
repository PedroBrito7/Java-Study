package javacore.ZZClambdas.ExChatgpt;

import javacore.ZZClambdas.ExChatgpt.Dominio.Funcionario;
import javacore.ZZClambdas.ExChatgpt.Dominio.Pedido;

import java.util.Comparator;
import java.util.List;

public class RelatorioFuncionario {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = List.of(
                new Funcionario("Ana", "TI", 5200),
                new Funcionario("Pedro", "RH", 3100),
                new Funcionario("Carlos", "TI", 4800),
                new Funcionario("Amanda", "Financeiro", 4500),
                new Funcionario("Bruno", "TI", 3900),
                new Funcionario("Alice", "Financeiro", 6000)
        );
        funcionarios.stream()
                .filter(d -> d.getDepartamento().equals("TI"))
                .filter(p -> p.getSalario() > 4000)
                .sorted(Comparator.comparingDouble(Funcionario::getSalario).reversed())
                .map(Funcionario::getNome)
                .forEach(System.out::println);
    }
}
