package javacore.ZZEstreams.test;

import java.util.List;

// reduce
public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1,2,3,4,5,6);
        integers.stream().reduce((a, b) -> a + b).ifPresent(System.out::println); // tem como fazer com lambda
        System.out.println(integers.stream().reduce(0,(a,b)->a+b)); // 0 é o valor que inicia a soma

        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, Integer::sum));

        integers.stream().reduce((x,y)->x +y ).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0,(x,y)->x+y));// tem como fazer com lambda

    }
}
