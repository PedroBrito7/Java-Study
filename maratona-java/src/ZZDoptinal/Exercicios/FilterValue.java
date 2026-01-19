package ZZDoptinal.Exercicios;

import java.util.Optional;

public class FilterValue {
    public static void main(String[] args) {
        Optional<Integer> numeroOptional =  Optional.ofNullable(15);
        Optional<Integer> filteredNumber = numeroOptional.filter(n -> n > 10);
        System.out.println(filteredNumber);


    }
}
