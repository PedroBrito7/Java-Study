package javacore.Gassociacao.test;

import java.util.Scanner;

public class LeituradotecladoTest01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Fala dai chefe, qual seu nome :");
        String next = entrada.next();
        System.out.println("Digite sua idade: ");
        int idade = entrada.nextInt();
        System.out.println("Digite M ou F para o seu sexo");
        char sexo = entrada.next().charAt(0);
        System.out.println(" ------------------ ");
        System.out.println(next);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);

    }
}
