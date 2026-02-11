package javacore.Oexception.runtime.test;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        divisao(1, 0);
        System.out.println(" Codigo Finalizado");
    }

    private static int divisao(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("argumaento ilegal, nao pode ser 0");
        }
        return 0;
    }
}
