package devpedro.marotona_java;

public class ExarrayMultidimensional {
    /*
    Crie uma matriz 3x2 com estes valores:
    5   12
    8   20
    3   15
    Use dois foreach para contar quantos números são maiores que 10.
     */
    public static void main(String[] args) {
        int[][] arrBase= new int[3][2];
        arrBase[0][0] = 5;
        arrBase[0][1] = 12;

        arrBase[1][0] = 8;
        arrBase[1][1] = 20;

        arrBase[2][0] = 3;
        arrBase[2][1] = 15;

        int contador = 0;

        for (int[] arrOri : arrBase) {
            for (int num : arrOri) {
                if (num >= 10) {
                    contador++;
                }
            }
        }

        System.out.println("Quantidade de números >= 10: " + contador);
    }
}