package javacore.Zgenerics.test;

import javacore.Zgenerics.Service.CarroRentavelService;
import javacore.Zgenerics.dominio.Carro;

public class ClasseGenericaTest01 {
    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscarCarroDisponivel();
        System.out.println("Usando o carro por um periodo...");
        carroRentavelService.retornarCarroAlugado(carro);
    }
}
