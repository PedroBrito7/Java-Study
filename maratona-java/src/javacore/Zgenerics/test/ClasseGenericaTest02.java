package javacore.Zgenerics.test;

import javacore.Zgenerics.Service.BarcoRentavelService;
import javacore.Zgenerics.dominio.Barco;

public class ClasseGenericaTest02 {
    public static void main(String[] args) {
        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando o barco por um periodo...");
        barcoRentavelService.retornarBarcoAlugado(barco);
    }
}
