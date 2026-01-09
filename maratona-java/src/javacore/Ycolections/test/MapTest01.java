package javacore.Ycolections.test;

import java.util.HashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("teclado", "tecrado");
        map.put("mouse", "mause");
        map.put("micro", "maicro");
        System.out.println(map);
    }
}
