package javacore.ZZAclassesinternas.ExerciciosChat;

interface Notificacao {
    void enviar();
}

public class TesteNotificacao {
    public static void main(String[] args) {

        Notificacao notificacao = new Notificacao() {
            @Override
            public void enviar() {
                System.out.println("Notificação enviada");
            }
        };

        // chamada fora da classe anônima
        notificacao.enviar();
    }
}
