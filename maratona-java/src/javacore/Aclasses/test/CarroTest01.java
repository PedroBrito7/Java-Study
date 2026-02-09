package javacore.Aclasses.test;

import javacore.Aclasses.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.modelo = "Mazda";
        carro1.nome = "Miata";
        carro1.ano = 1995;

        carro2.modelo = "Sport";
        carro2.nome = "Fusca";
        carro2.ano = 1972;

        carro1 = carro2;
        System.out.println("Carro 1");
        System.out.println(carro1.nome);
        System.out.println(carro1.modelo);
        System.out.println(carro1.ano);


        System.out.println("------------");

        System.out.println("Carro 2");
        System.out.println(carro2.nome);
        System.out.println(carro2.modelo);
        System.out.println(carro2.ano);


    }
}
