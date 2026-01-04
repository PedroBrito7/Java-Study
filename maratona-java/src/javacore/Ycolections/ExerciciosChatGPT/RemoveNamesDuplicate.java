package javacore.Ycolections.ExerciciosChatGPT;

import java.util.ArrayList;
import java.util.Collections;


public class RemoveNamesDuplicate {
    public static void main(String[] args) {
        String[] nomes = {"Ana", "Pedro", "Ana", "Lucas", "Pedro"};
        ArrayList<String> original = new ArrayList<>();

        Collections.addAll(original, nomes);


        ArrayList<String> semDuplicados = new ArrayList<>();
        for (String nome : original) {
            if (!semDuplicados.contains(nome)) {
                semDuplicados.add(nome);
            }
        }

        System.out.println(semDuplicados);
    }
}
