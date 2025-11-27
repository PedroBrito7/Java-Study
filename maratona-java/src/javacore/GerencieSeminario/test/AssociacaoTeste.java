package javacore.GerencieSeminario.test;

import javacore.GerencieSeminario.dominio.Aluno;
import javacore.GerencieSeminario.dominio.Local;
import javacore.GerencieSeminario.dominio.Professor;
import javacore.GerencieSeminario.dominio.Seminario;

public class AssociacaoTeste {
    public static void main(String[] args) {
        Local local = new Local ("rua nestor joao de oliveira");
        Aluno aluno = new Aluno("Luffy", 18);
        Professor professor = new Professor("Barba Branca", "Pirata");
        Aluno[] alunosParaSeminario = {aluno};
        Seminario seminario = new Seminario ("Onde achar o one piece",alunosParaSeminario, local);

        Seminario[] seminariosDisponiveis = {seminario};

        professor.setSeminarios(seminariosDisponiveis);

        professor.imprime();
    }
}
