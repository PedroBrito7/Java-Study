package javacore.Zgenerics.test;

import javacore.Zgenerics.dominio.Barco;

import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Barco> barcoList = criarArrayComUmObjeto(new Barco("Lancha"));
        System.out.println(barcoList);
    }

    private static <T> void criarArrayComUmObjetor(T t) { // metodo generico sem retorno
        List<T> list = List.of(t);
        System.out.println(list);
    }

    private static <T> List<T> criarArrayComUmObjeto(T t) { // metodo generico com retorno
        return List.of(t);
    }
}
