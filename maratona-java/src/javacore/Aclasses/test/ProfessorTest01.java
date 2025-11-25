package javacore.Aclasses.test;

import javacore.Aclasses.dominio.Professor;

public class ProfessorTest01 {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome= "Mestre Kami";
        professor.age= 148;
        professor.sex = 'M';

        System.out.printf("Nome do professor : " +professor.nome + " sua idade é "+ professor.age +" Por fim seu sexo: "+ professor.sex );
    }
}
