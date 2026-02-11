package javacore.Qstring.test;

public class StringPerfomanceTest {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatStrinBuilder(100_000);
        long fim = System.currentTimeMillis();
        System.out.println("tempo gasto para string " + (fim - inicio) + " ms");
    }

    private static void concatString(int tamanho) {
        String texto = "";
        for (int i = 0; i < tamanho; i++) {
            texto += 1;
        }
    }

    private static void concatStrinBuilder(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
}
