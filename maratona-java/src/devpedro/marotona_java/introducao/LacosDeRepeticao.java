package devpedro.marotona_java.introducao;

public class LacosDeRepeticao {
    public static void main(String[] args) {
        // while, do while, for
        int count = 0;
        while (count < 10) {
            System.out.println(count++);
        }
        do {
            System.out.println("Inside the Do - While");
        } while (count < 10);
        for (int i = 0; i < 10; i++) {
            System.out.println("for " + i);

        }

    }
}
