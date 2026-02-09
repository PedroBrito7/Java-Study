package devpedro.marotona_java.introducao;

public class ConditionalsStructure {
    public static void main(String[] args) {
        int idade = 10;
        boolean isAutorizadoComprarBebida = idade >= 18;
        if (isAutorizadoComprarBebida) {
            System.out.println("Autorizado pode comprar bebida alcólica");
        } else {
            System.out.println("Não pode commprar bebida");
        }
        if (!isAutorizadoComprarBebida) {
            System.out.println("Não pode commprar bebida");
        }
    }
}
