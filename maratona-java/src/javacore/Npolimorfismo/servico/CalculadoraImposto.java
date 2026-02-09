package javacore.Npolimorfismo.servico;

import javacore.Npolimorfismo.dominio.Computador;
import javacore.Npolimorfismo.dominio.Produto;
import javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {

    public static void calcularImposto(Produto produto) {
        System.out.println(" Relatório de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Preço: " + produto.getValor());
        System.out.println("Preço: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);
    }
}
//Então para pegar o atributo é mesma sintaxe que com metod

//

//if (dt instanceof TextoFormatado) {
//int tamanhoFonte = ((TextoFormatado) dt).tamanhoFonte;
//int tamFonte3 = tamanhoFonte + 3;
//
//    ((TextoFormatado) dt).aplicarFonte(tamFonte3);
//}
