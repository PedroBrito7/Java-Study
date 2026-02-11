package javacore.ZZClambdas.ExChatgpt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Func {
    static class Funcionario {
        private String nome;
        private double salario;

        public Funcionario(String nome, double salario) {
            this.nome = nome;
            this.salario = salario;
        }

        public String getNome() {
            return nome;
        }

        public double getSalario() {
            return salario;
        }

        @Override
        public String toString() {
            return "Funcionario{" +
                    "nome='" + nome + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>(List.of(
                new Funcionario("Ana", 3500),
                new Funcionario("Pedro", 2800),
                new Funcionario("Carlos", 4200),
                new Funcionario("Amanda", 3000),
                new Funcionario("Bruno", 3900)
        ));
        List<String> funcionariosSalarioMaiorque3000 =
                funcionarios.stream()
                        .filter(f -> f.getSalario() > 3000)
                        .sorted(Comparator.comparingDouble(Funcionario::getSalario))
                        .map(Funcionario::getNome)
                        .toList();

        System.out.println(funcionariosSalarioMaiorque3000);

    }
}
