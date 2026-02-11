package javacore.Npolimorfismo.test;

import javacore.Npolimorfismo.repositorio.Repositorio;
import javacore.Npolimorfismo.servico.RepositorioArquivos;

import java.util.LinkedList;
import java.util.List;

public class RepositorioTeste {
    public static void main(String[] args) {
        // Em interfaces se utiliza de forma GENERICA o polimorfismo
        Repositorio repositorio = new RepositorioArquivos();
        repositorio.salvar();

        List<String> list = new LinkedList<>();
        list.add("GOKU");
        list.add("VEGETA");
        list.add("KURIRIN");
        list.add("BROOLY");

    }
}
