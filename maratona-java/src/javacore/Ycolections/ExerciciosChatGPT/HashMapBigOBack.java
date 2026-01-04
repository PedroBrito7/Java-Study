package javacore.Ycolections.ExerciciosChatGPT;

import java.util.*;

public class HashMapBigOBack {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        String[] users = {"Ana", "Pedro", "Ana", "Lucas", "Pedro", "Ana"};
        for(String user :users){
            int contador = map.getOrDefault(user, 0) + 1;
            map.put(user, contador);
        }
        System.out.println(map);
    }
}
