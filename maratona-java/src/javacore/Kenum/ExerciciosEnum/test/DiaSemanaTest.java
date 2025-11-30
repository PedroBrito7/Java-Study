package javacore.Kenum.ExerciciosEnum.test;

import javacore.Kenum.ExerciciosEnum.dominio.DiaSemana;

public class DiaSemanaTest {
    public static void main(String[] args) {
        // 1. Declara a variável que será testada
        DiaSemana dia = DiaSemana.QUARTA;
        System.out.println("O dia de hoje é: " + dia.name()); // name ja e um metodo q ja tem no objeto do enum
        switch (dia){
            case SEGUNDA:
            case TERCA:
            case QUARTA:
            case QUINTA:
                System.out.println("Dia de trabalho. Foco!");
                break;
            case SEXTA:
                System.out.println("Sextou! Quase lá...");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("Fim de semana! Descanse.");
                break;

            default:
                System.out.println("Dia inválido.");
        }
    }
}