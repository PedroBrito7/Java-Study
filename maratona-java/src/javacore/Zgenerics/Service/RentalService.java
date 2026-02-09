package javacore.Zgenerics.Service;

import javacore.Zgenerics.dominio.Carro;

import java.util.List;

public class RentalService<T> {
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }


    public T buscarObjetoDisponivel() {
        System.out.println("Buscando carro disponivel...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando o Objeto: " + t);
        System.out.println("Objeto disponiveis para alugar: ");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t) {
        System.out.println("Devolvendo o carro: " + t);
        objetosDisponiveis.add(t);
        System.out.println("Carros disponiveis para alugar: ");
        System.out.println(objetosDisponiveis);
    }
}
