package javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2)// aceita seed e unaryOperator(Metodo que retorna oq vc passo como argumento)
                .limit(10)
                .forEach(System.out::println);
        // 01,1,2,3,5,8,13,21,34
        // Somar o anterior com o proximo e assim por diante -(2,3) (3,5) ( 5,8 )
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1, 500))
                .limit(90)
                .forEach(System.out::println);

    }
}
// qual diferenca de random iterate de random generate, e quando e qual seu uso no mundo corporativo dentro de sistemas reais
