package javacore.Ycolections.dominio;

import java.util.Objects;

public class Pessoa {
    String nome;
    int cpf;

    public Pessoa(String nome, int cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return pessoa.equals(cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

}
