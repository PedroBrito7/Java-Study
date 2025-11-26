package javacore.GerencieSeminario.dominio;

public class Aluno {
    private String nome;
    private int idade;
    private Seminario seminario;

    public void imprime(){
        System.out.println(this.nome);
        if(seminario != null){
            System.out.println(seminario.getNome());
        }
    }

    public Seminario getSeminario() {
        return seminario;
    }

    public void setSeminario(Seminario seminario) {
        this.seminario = seminario;
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
