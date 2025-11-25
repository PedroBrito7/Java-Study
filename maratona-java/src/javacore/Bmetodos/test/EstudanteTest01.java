package javacore.Bmetodos.test;

import javacore.Bmetodos.dominio.Estudante;
import javacore.Bmetodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();

        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante01.name = "Midoriya";
        estudante01.age = 15;
        estudante01.sex = 'M';

        estudante02.name = "Kurosaki";
        estudante02.age = 17;
        estudante02.sex = 'F';

        impressora.imprime(estudante01);
        impressora.imprime(estudante02);
        System.out.println("##########");
        impressora.imprime(estudante01);
        impressora.imprime(estudante02);




    }
}
