package javacore.ZZClambdas;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {

List<String> strings = List.of("Pedro", "Brito", "luffy", "zoro");
        forEach(strings,(String s) -> System.out.println(s));

    }
    private  static <T> void forEach(List<T> list, Consumer<T> consumer){
        for(T e : list){
            consumer.accept(e);
        }
    }
}
