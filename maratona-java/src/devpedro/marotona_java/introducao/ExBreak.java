package devpedro.marotona_java.introducao;

public class ExBreak {
    // dado valor de um carro descubra quantas vezes ele pode ser parcelado
    public static void main(String[] args) {
        double valorTotal = 30000;
        for (int installment = 1; installment <= valorTotal; installment++) {
            double valorInstallment = valorTotal / installment;
            if (valorInstallment < 1000) {
                break;
            }
            System.out.println("Parcela " + installment + " R$ " + valorInstallment);
        }
    }
}

