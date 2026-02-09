package javacore.ZZDoptinal.test;

import java.util.List;
import java.util.Optional;

public class OptinalTest {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aha uhu o DevNinja chgegou");
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();

        System.out.println(o1);
        System.out.println(o2);
        String name = findName("pedro");

    }

    private static String findName(String name) {
        // vc tem um nome, caso tenha esse nome ele vai retornar o nome, caso não tenha ele retorna null
        List<String> list = List.of("Pedro", "DevNinja");
        int i = list.indexOf(name);
        if (i > 0) {
            return list.get(i);
        } else {
            return null;
        }

    }
}
