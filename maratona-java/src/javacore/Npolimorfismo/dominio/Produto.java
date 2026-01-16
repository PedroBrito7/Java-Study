package javacore.Npolimorfismo.dominio;

public abstract class Produto implements Taxavel {
    // abstract aquele que "nao" pode existir e criar instancias diretadmente dela
    protected String nome;
    protected int valor;

    public Produto(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}
