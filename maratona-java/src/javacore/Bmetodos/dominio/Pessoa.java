package javacore.Bmetodos.dominio;

public class Pessoa {
    // so pode usar o private no mesmo objeto eles não conseguem ser utilizado em outros obj
    private String nome;
    private int idade;

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.idade);
    }
    public void setNome(String nome){ // ela altera e ou recebe um valor
         this.nome = nome;
    }
    public void setIdade(int idade){
        if(idade<0 ){
            System.out.println("idade invalida");
            return;
        }
        this.idade = idade;
    }
    public String getNome(){ // get obtem valor do atributo
        return this.nome;
    }
    public int getIdade(){
        return getIdade();
    }
}
