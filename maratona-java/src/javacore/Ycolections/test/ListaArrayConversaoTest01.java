package javacore.Ycolections.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        Integer[] ListToArray = numeros.toArray(numeros.toArray(new Integer[0]));
        System.out.println(ListToArray);
        System.out.println("--------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1 ;
        numerosArray[1] = 2 ;
        numerosArray[2] = 3 ;
        // transformar esse cara em lista assim :
        List<Integer> ArrayToList = Arrays.asList(numerosArray);
        // agora pra alterar algum
        ArrayToList.set(0,12);
        System.out.println(Arrays.toString(numerosArray)); // to string para aparacer
        System.out.println(ArrayToList);

        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray)); // outra maneira de adicionar
        numerosList.add(15);// adicionar um numero na lista
        System.out.println(numerosList);

        List<String> strings = Arrays.asList("1","23","4","5","6");




    }
}
