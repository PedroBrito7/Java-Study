package javacore.Bmetodos.test;

import javacore.Bmetodos.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
       /* pessoa.nome= "Pedro";
         pessoa.idade = 70; */
        pessoa.setNome("jiraya");
        pessoa.setIdade(89);
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());
    }
}
