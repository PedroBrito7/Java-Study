package javacore.dsa.test;

import java.util.LinkedList;
import java.util.Queue;

public class MainQueue {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.offer("Cliente1");
        fila.offer("Cliente2");
        System.out.println(fila.poll());
        System.out.println(fila.peek());

//    PriorityQueue    Queue<Integer> fila = new PriorityQueue<>();
//
//        fila.offer(30);
//        fila.offer(10);
//        fila.offer(20);
//
//        while (!fila.isEmpty()) {
//            System.out.println(fila.poll());
//        }
    }
}
