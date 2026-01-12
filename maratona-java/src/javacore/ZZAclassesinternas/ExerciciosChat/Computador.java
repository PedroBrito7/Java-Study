package javacore.ZZAclassesinternas.ExerciciosChat;

public class Computador {
    private String marca;
    public Computador(String marca) {
        this.marca = marca;
    }

    public void ligar() {
        System.out.println("Computador ligado");
    }

    class Processador {
        void mostrarMarca() {
            System.out.println(marca);
        }

    }
    public static void main(String[] args) {
        Computador computador = new Computador("Dell");
        Computador.Processador processador = computador.new Processador();

        processador.mostrarMarca();
    }
}