package javacore.Oexception.Exception.test;

import javacore.Oexception.Exception.dominio.Funcionario;
import javacore.Oexception.Exception.dominio.LoginInvalidoException;
import javacore.Oexception.Exception.dominio.Pessoa;

import java.io.FileNotFoundException;

public class SobreescritaComExcptionTest01 {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        Funcionario f= new Funcionario();
        try {
            f.salvar();
        } catch (LoginInvalidoException  e) {
            e.printStackTrace();
        }
    }
}
