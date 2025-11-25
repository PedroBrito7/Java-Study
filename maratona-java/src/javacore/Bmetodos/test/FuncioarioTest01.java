package javacore.Bmetodos.test;

import javacore.Bmetodos.dominio.Funcionario;

public class FuncioarioTest01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setName("Sanji");
        funcionario.setAge(23);
        funcionario.setWages(new double []{1200, 987.32, 2000});
        funcionario.printDatas();

    }
}
