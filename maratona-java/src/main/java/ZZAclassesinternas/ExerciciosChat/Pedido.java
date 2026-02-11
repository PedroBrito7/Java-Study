package javacore.ZZAclassesinternas.ExerciciosChat;

public class Pedido {

    public double calcularTotal(double valor) {

        double taxa = 0.1; // 10%

        // CLASSE LOCAL
        class Calculadora {
            double calcular(double valor) {
                // implemente aqui
                return valor + (valor * taxa);
            }
        }

        Calculadora calc = new Calculadora();
        return calc.calcular(valor);
    }

    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println(pedido.calcularTotal(100));

    }
}
