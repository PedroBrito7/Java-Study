package javacore.ZZAclassesinternas.test;

import javacore.Zgenerics.dominio.Barco;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = List.of(new Barco("Lancha"), new Barco ("Canoa"));
//        new Comparator<Barco>() {
//            @Override
//            public int compare(Barco barco, Barco t1) {
//                return barco.getNome().compareTo(t1.getNome());
//            }
//        }); Classes anonimas Sem lambda
        barcoList.sort((barco, t1) -> barco.getNome().compareTo(t1.getNome()));
        System.out.println(barcoList);

    }
}
