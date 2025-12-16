package javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "Pedro Henrique";
        nome.concat("DevViradoNoJiraya");
        System.out.println(nome);
        StringBuilder sb = new StringBuilder("OutroNome"); // ele nao é uma string ele converte pra string, sem precisa jogar no stringpool
        System.out.println(sb.toString());
        sb.append(" Olá ").append(" Mundo");
        sb.substring(0,2);
        System.out.println(sb);
    }
}
