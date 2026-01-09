package javacore.Zgenerics.Service;

import javacore.Zgenerics.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class CarroRentavelService {
    private List<Carro> carroDisponiveis = new ArrayList<>(List.of(new Carro("Fusca"),
            new Carro("BMW"),
            new Carro("Audi"),
            new Carro("Mercedes")
    ));
    public Carro buscarCarroDisponivel(){
        System.out.println("Buscando carro disponivel...");
        Carro carro = carroDisponiveis.remove(0);
        System.out.println("Alugando o carro: " + carro);
        System.out.println("Carros disponiveis para alugar: ");
        System.out.println(carroDisponiveis);
        return carro;
    }
    public void retornarCarroAlugado(Carro carro){
        System.out.println("Devolvendo o carro: " + carro);
        carroDisponiveis.add(carro);
        System.out.println("Carros disponiveis para alugar: ");
        System.out.println(carroDisponiveis);
    }
}
