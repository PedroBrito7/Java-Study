package javacore.Ycolections.ExerciciosChatGPT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchSortingBigO {
    public static void main(String[] args) {
        List<Integer> ids = new ArrayList<>();
        Collections.addAll(ids, 10, 3, 7, 1, 9, 5);

        Collections.sort(ids);

        int index = Collections.binarySearch(ids, 7);

        if(index >=0){
            System.out.println("Encontrado na posição " + index);
        }else {
            System.out.println("Não encontrado");
        }

    }
}
