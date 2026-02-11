package javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        //Reference to an instance method of an arbitrary object of a particular type,
        // inves de usar objeto, vai usar a classe + metodo nao estatico
        List<String> list = new ArrayList<>(List.of("Pedro", "Veldora", "Obito"));
        list.sort(String::compareTo);
        System.out.println(list);
        // criar um funcao q tem um numero em string e vai transformar para int
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("10");
        System.out.println(num);
        // digamos que vc quer verificar se tem elemento dentro de uma lista
        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(list, "Rimuru"));


    }
}
