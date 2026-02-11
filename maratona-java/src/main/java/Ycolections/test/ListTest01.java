package javacore.Ycolections.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();
        nomes.add("Pedro");
        nomes.add("Henrique");
        nomes2.add("DevBolado");
        nomes2.add("Coleções");

        nomes.addAll(nomes2); // faz a junção das duas listas, copiando os elementos de nomes2 para nomes

//        System.out.println(nomes.remove("Pedro")); remove atraves dos equals, pq o objeto e uma string

        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("-------------");
        int size = nomes.size();
        for (int i = 0; i < size; i++) {
            System.out.println(nomes.get(i));
            nomes.add("Brito");
            System.out.println(nomes.get(i));
        }

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
    }
}
