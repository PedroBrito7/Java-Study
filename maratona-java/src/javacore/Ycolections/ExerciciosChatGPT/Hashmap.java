package javacore.Ycolections.ExerciciosChatGPT;

import javacore.Ycolections.dominio.Pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Map<Pessoa, Integer> mapa = new HashMap<>();
        pessoas.add(new Pessoa("Ana", 111));
        pessoas.add(new Pessoa("Pedro", 222));
        pessoas.add(new Pessoa("Ana Silva", 111));
        pessoas.add(new Pessoa("Lucas", 333));
        pessoas.add(new Pessoa("Pedro Rodrigues", 222));
        pessoas.add(new Pessoa("Ana", 111));
        pessoas.add(new Pessoa("Ana ju", 444));

        for(Pessoa pessoa : pessoas){
            mapa.put(pessoa,  mapa.getOrDefault(pessoa, 0) + 1);

        }
        System.out.println(mapa);
    }
}
