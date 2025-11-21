package devpedro.marotona_java;

public class Array02 {
    public static void main(String[] args) {
        /** inicializando o array e ele nao receber algum valor o default dele é  :
        byte, short, int, long, float e double o array recebe 0
       char '\ u000' unicode vai receber " "
        bolean recebe false
         String rebe null */
        String[] ages = new String[3];
        ages[0] = "Goku";
        ages[1] = "Kurosaki";
        ages[2] = "Luffy";

        for (int i = 0; i < ages.length ; i++) {
            System.out.println(ages[i]);
        }


    }
}
