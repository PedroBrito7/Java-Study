package javacore.Hherenca.dominio;

public class Pessoa {
    protected String nome;
    private String cpf;
    protected Endereco endereco;

    static {
        System.out.println("inside block static");
    }

    {
        System.out.println("inside  block de inicializacao de pessoa 1");
    }

    {
        System.out.println("dentro do bloco inicializacao de pessoa 2 ");
    }

    public Pessoa(String nome) {
        System.out.println(" insidade of block static of the people");
        this.nome = nome;
    }

    public Pessoa(String nome, String cpf) {
        this(nome); // this precisa primeira linha do constructor
        this.cpf = cpf;
    }

    public void imprime() {
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.endereco.getRua() + " " + this.endereco.getCep());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
