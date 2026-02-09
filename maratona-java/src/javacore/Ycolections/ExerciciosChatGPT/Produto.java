package javacore.Ycolections.ExerciciosChatGPT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int compareTo(Produto outro) {
        return Double.compare(this.preco, outro.preco);
    }

    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Mouse", 80));
        produtos.add(new Produto("Teclado", 120));
        produtos.add(new Produto("Monitor", 900));

        Collections.sort(produtos);

        System.out.println(produtos);
    }
}
