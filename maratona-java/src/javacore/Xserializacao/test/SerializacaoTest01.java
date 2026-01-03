package javacore.Xserializacao.test;

import javacore.Xserializacao.dominio.Aluno;
import javacore.Xserializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L, "itachi", "123456");
        Turma turma = new Turma("Akatsuki");
        aluno.setTurma(turma);
        serializar(aluno);
        deserializar();
    }

    private static void serializar(Aluno aluno) {
        Path path = Path.of("pasta/aluno.ser");

        try {

            Files.createDirectories(path.getParent());

            try (ObjectOutputStream oos =
                         new ObjectOutputStream(Files.newOutputStream(path))) {
                oos.writeObject(aluno);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deserializar() {
        Path path = Path.of("pasta/aluno.ser");

        try (ObjectInputStream ois =
                     new ObjectInputStream(Files.newInputStream(path))) {

            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
