package devpedro.marotona_java.introducao;

public class ConditionalsStructure2 {
    public static void main(String[] args) {
        // idade < 15 categoria Infatil
        // idade >= 15 && idade <18 categoria juvenil
        // idade > 18 categoria Adulto
        int idade = 18;
        String categoria;
        if (idade < 15) {
            categoria = "Categoria Infantil";
        } else if (idade >= 15 && idade < 18) {
            categoria = "Categoria juvenil";
        } else {
            categoria = "adulto";
        }
    }
}
