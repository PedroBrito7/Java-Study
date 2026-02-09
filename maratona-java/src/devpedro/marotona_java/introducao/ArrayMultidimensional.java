package devpedro.marotona_java.introducao;

public class ArrayMultidimensional {
    public static void main(String[] args) {
        // 1,2,3,4,5 meses
        // 31,28,31,30 dias
        int[][] dias = new int[3][3];
        //    i  j   qtde dias
        dias[0][0] = 31;
        dias[0][1] = 28;
        dias[0][2] = 31;

        dias[1][0] = 31;
        dias[1][1] = 28;
        dias[1][2] = 31;

        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < dias[i].length; j++) {
                System.out.println(dias[i][j]);
            }
        }
        System.out.println("---------------");
        /* ambos fazem mesma coisa porem sem precisar do J
        for int arrBase cria um ref que pega cada um dos indices do 0 e dps passa no num percorrendo o proximo array
        * */
        for (int[] arrBase : dias) {
            for (int num : arrBase) {
                System.out.println(num);
            }
        }
        ;

    }
}
