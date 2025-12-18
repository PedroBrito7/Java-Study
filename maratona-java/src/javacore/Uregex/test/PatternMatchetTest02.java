package javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchetTest02 {
    public static void main(String[] args) {
        // Regex: Serve para encontrar, validar e manipular padrões complexos dentro de textos (strings)
        // \d = anything that is digits
        // \D = all what no it's digits
        // \s = Espaços em branco \t \n \f \r
        // \S = all chars removing all spaces
        // \w = all chars of a-z,A-Z digits


        String regex = "\\w";
        // String texto = "abaaba";
        String texto2 = "jh2h j213";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("Texto : " + texto2);
        System.out.println("Índice: 0123456789 ");
        System.out.println("Regex: " + regex);
        System.out.println("Posições encontradas: ");
        while (matcher.find()){
            System.out.print(matcher.start()+" " +matcher.group()+ "\n");
        }
    }
}
