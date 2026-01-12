package javacore.ZZAclassesinternas.ExerciciosChat;

public class Banco {

    static String nomeBanco = "Banco Central";

    static class Conta {
        void mostrarBanco() {
            System.out.println(nomeBanco);
        }
    }

    public static void main(String[] args) {
        Banco.Conta conta = new Banco.Conta();
        conta.mostrarBanco();

    }
}
