package javacore.ZZClambdas.ExChatgpt.Dominio;

public class Pedido {
    private String cliente;
    private double valor;
    private boolean pago;

    public Pedido(String cliente, double valor, boolean pago) {
        this.cliente = cliente;
        this.valor = valor;
        this.pago = pago;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public boolean isPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                '}';
    }
}