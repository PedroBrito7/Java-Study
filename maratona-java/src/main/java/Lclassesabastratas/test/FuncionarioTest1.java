package javacore.Lclassesabastratas.test;

import javacore.Lclassesabastratas.dominio.Desenvolvedor;
import javacore.Lclassesabastratas.dominio.Gerente;

public class FuncionarioTest1 {
    public static void main(String[] args) {
//        Funcionario funcionario = new Funcionario("Zoro", 2000);
        Gerente gerente = new Gerente("Nami", 8000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 1200);
//        System.out.println(funcionario);
        gerente.imprime();
        desenvolvedor.imprime();
        System.out.println(gerente);
        System.out.println(desenvolvedor);


    }
}
