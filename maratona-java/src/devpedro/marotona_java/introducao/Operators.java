package devpedro.marotona_java.introducao;

public class Operators {
    public static void main(String[] args) {
        // + - / *
        int number01 = 10;
        int number02 = 20;
        double resultado = number01 / (double) number02;
        System.out.println(resultado);
        // %
        int rest = 21 % 7;
        System.out.println(rest);

        // < > <= >= == !=
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualaVinte = 10 == 20;
        boolean isDezIgualaDez = 10 == 10;
        boolean isDezDiferenteDez = 10 != 10;
        System.out.println("isDezmenorQueVinte " + isDezMenorQueVinte);
        System.out.println("isDezMaiorQueVinte " + isDezMaiorQueVinte);
        System.out.println("isDezIgualaVinte " + isDezIgualaVinte);
        System.out.println("isDezIgualDez " + isDezIgualaDez);
        // && (AND)  || (or)  ! (not)
        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;
        System.out.println("isDentroDaLeiMaiorQueTrinta " + isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta " + isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPsCinco = 5000F;

        boolean isPsCincoCompravel = valorTotalContaCorrente > valorPsCinco || valorTotalContaPoupanca > valorPsCinco;
        System.out.println("isPsCincoCompravel " + isPsCincoCompravel);

        // = += -= *= /= %=
        double bonus = 1800;
        bonus += 1000;
        bonus -= 1000;
        bonus *= 2;
        System.out.println(bonus);

        //
        int contador = 0;
        contador += 1; // contador = contador +1
        contador++;
        contador--;
        ++contador;
        --contador;
        int contador2 = 0;
        System.out.println(contador2++);
        System.out.println(++contador2);

        System.out.println(contador);


    }
}
