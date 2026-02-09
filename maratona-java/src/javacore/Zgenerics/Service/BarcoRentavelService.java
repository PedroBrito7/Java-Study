package javacore.Zgenerics.Service;

import javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
    private List<Barco> barcoDisponiveis = new ArrayList<>(List.of(
            new Barco("Lancha"),
            new Barco("Canoa"),
            new Barco("Iate"),
            new Barco("Jetski")
    ));

    public Barco buscarBarcoDisponivel() {
        System.out.println("Buscando barco disponivel...");
        Barco barco = barcoDisponiveis.remove(0);
        System.out.println("Alugando o barco: " + barco);
        System.out.println("Barcos disponiveis para alugar: ");
        System.out.println(barcoDisponiveis);
        return barco;
    }

    public void retornarBarcoAlugado(Barco barco) {
        System.out.println("Devolvendo o barco: " + barco);
        barcoDisponiveis.add(barco);
        System.out.println("Barcos disponiveis para alugar: ");
        System.out.println(barcoDisponiveis);
    }
}
