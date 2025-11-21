package devpedro.marotona_java;

public class ExContinue {
    // dado valor de um carro descubra quantas vezes ele pode ser parcelado
    public static void main(String[] args) {
        double valorTotal = 30000;
        for (int installment = (int) valorTotal; installment >= 1 ; installment--) {
            double valorInstallment = valorTotal / installment;
            if(valorInstallment < 1000){
                continue;
            }
            System.out.println("Parcela " + installment + " R$ " + valorInstallment);
        }
    }
}

