package javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchetTest01 {
    public static void main(String[] args) {
        // Regex: Serve para encontrar, validar e manipular padrões complexos dentro de textos (strings)
        String regex = "aba";
        // String texto = "abaaba";
        String texto2 = "abababa";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("Texto : " + texto2);
        System.out.println("Índice: 0123456789 ");
        System.out.println("Regex: " + regex);
        System.out.println("Posições encontradas: ");
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
    }
}
