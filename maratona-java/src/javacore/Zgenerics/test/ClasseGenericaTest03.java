package javacore.Zgenerics.test;

import javacore.Zgenerics.Service.BarcoRentavelService;
import javacore.Zgenerics.Service.RentalService;
import javacore.Zgenerics.dominio.Barco;
import javacore.Zgenerics.dominio.Carro;

import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
       List<Carro> carrosDisponiveis = List.of(new Carro("BMW"), new Carro("Fusca"));
       List<Barco> barcosDisponiveis = List.of(new Barco("Lancha"), new Barco("Iate"));
        RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);
        Carro carro = rentalService.buscarObjetoDisponivel();
        System.out.println("Usando o carro por um periodo...");
        rentalService.retornarObjetoAlugado(carro);

        System.out.println("-------------------");
        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcosDisponiveis);
        Carro carro1 = rentalService.buscarObjetoDisponivel();
        System.out.println("Usando o carro por um periodo...");
        rentalService.retornarObjetoAlugado(carro1);
    }
}
