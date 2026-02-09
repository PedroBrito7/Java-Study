package javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "  luffy     ";
        String numeros = "012345";
        String a = "admin";
        String b = "ADMIN";
        String s1 = "";
        String s2 = "   ";
        String email = "luffy@gmail.com";
        String csv = "joao,20,SP";
        String idade = "25";
        String arquivo = "foto.png";
        String cpf = "123.456.789-00";

        System.out.println(nome.charAt(4)); // retorna na posicao correspondente
        System.out.println(nome.length()); // conta os caracteres
        System.out.println(nome.replace("f", "l")); // troca de f por l
        System.out.println(nome.toLowerCase());
        System.out.println(nome.toUpperCase());
        System.out.println(numeros.length());
        System.out.println(numeros.substring(0, 2));
        System.out.println(nome.trim()); // remove espaços e valores em branco
        System.out.println(a.equals(b));
        System.out.println(a.equalsIgnoreCase(b));

        s1.isEmpty(); // verifica se escreveu algo, usado para validacao de formulario api
        s2.isEmpty(); // verifica se escreveu algo, usado para validacao de formulario api
        s2.isBlank(); //se ta em branco ? true

        System.out.println(email.contains("@")); // verifica se contém um trecho
        System.out.println(arquivo.startsWith("foto")); // verifica se começa com
        System.out.println(arquivo.endsWith(".png")); // verifica se termina com

        /* Quebra de string */
        System.out.println(csv.split(",")[0]); // divide a string e acessa a posição desejada
        System.out.println(csv.split(",")[1]); // segunda posição após o split

        /* Conversão */
        System.out.println(Integer.parseInt(idade)); // converte string para inteiro
        System.out.println(String.valueOf(100)); // converte valor para string

        /* Substituição avançada */
        System.out.println(cpf.replace(".", "").replace("-", "")); // remove pontos e traço
        System.out.println(cpf.replaceAll("[^0-9]", "")); // remove tudo que não é número

        /* Conversão para caracteres */
        System.out.println(nome.toCharArray()[0]); // converte para array de char e acessa posição

        /* Formatação */
        System.out.println(String.format("Nome: %s | Idade: %d", "Luffy", 19)); // formata texto

        /* Performance */
        StringBuilder sb = new StringBuilder();
        sb.append("Olá "); // adiciona texto
        sb.append(nome.trim()); // adiciona string sem espaços
        sb.append("!"); // adiciona caractere
        System.out.println(sb.toString()); // converte StringBuilder para String
    }
}
