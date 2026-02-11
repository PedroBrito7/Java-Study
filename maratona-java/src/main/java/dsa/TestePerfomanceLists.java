package javacore.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestePerfomanceLists {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> LinkedList = new LinkedList<Integer>();
        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(i);
            LinkedList.add(i);
        }
        long inicioArray = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            arrayList.get(i * 100);
        }
        long fimArray = System.currentTimeMillis();

        long inicioLinked = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            LinkedList.get(i * 100);
        }
        long fimLinked = System.currentTimeMillis();

        System.out.println("ArrayList - Tempo de acesso: " + (fimArray - inicioArray) + " ms");
        System.out.println("LinkedList - Tempo de acesso: " + (fimLinked - inicioLinked) + " ms");
    }
}
