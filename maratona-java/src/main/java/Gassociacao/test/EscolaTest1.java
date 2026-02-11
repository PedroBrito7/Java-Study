package javacore.Gassociacao.test;

import javacore.Gassociacao.dominio.Escola;
import javacore.Gassociacao.dominio.Professor;

public class EscolaTest1 {
    public static void main(String[] args) {
        Professor professor1 = new Professor("jiraya sensei");
        Professor professor2 = new Professor("Kakashi sensei");

        Professor[] professores = {professor1, professor2};
        Escola escola = new Escola("Konoha", professores);

        escola.imprime();

    }
}
