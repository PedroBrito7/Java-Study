package javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchetTest05 {
    public static void main(String[] args) {
        // Regex: Serve para encontrar, validar e manipular padrões complexos dentro de textos (strings)
        // \d = anything that is digits
        // \D = all what no it's digits
        // \s = Espaços em branco \t \n \f \r
        // \S = all chars removing all spaces
        // \w = all chars of a-z,A-Z digits
        // range is used to get a specific char >
        //  [abc] range > ou por a  ou por b  ou por c
        // Quantificadores te dar poder em pegar determinada expressao dada ao string q ce ta dando
        // ? zero ou uma
        //  * zero ou mais
        // + uma ou mais
        // { n,m} de n até m
        // ()
        // |
        // $
        // .  1.3 = 123, 133, 1@3, 1A3
        String regex = "([A-Za-z0-9._-]+)@([A-Za-z]+)(\\.([A-Za-z]+))+";
        String texto = "luffy@hotmail.com, 123jotaro@gmai.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail";
        System.out.println("Email válido:");
        System.out.println("zoro@mail.br".matches(regex));
        System.out.println(texto.split(",")[3].trim());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto: " + texto);
        System.out.println("Índice: 0123456789 ");
        System.out.println("Regex: " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()){
            System.out.println(matcher.start()+" " +matcher.group()+ "\n");
        }

    }
}
