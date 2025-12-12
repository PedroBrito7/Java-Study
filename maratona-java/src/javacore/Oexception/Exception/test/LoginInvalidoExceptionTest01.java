package javacore.Oexception.Exception.test;

import javacore.Oexception.Exception.dominio.LoginInvalidoException;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
try {
    logar();
} catch (LoginInvalidoException e) {
  e.printStackTrace();
}
    }
    private static void logar() throws LoginInvalidoException{
        Scanner scanner = new Scanner(System.in);
        String usernameDB = "goku";
        String passwordDB = "ssj";
        System.out.println("Usuario");
        String usernameDigitado = scanner.nextLine();
        System.out.println("Senha");
        String senhaDigitada = scanner.nextLine();
        if(!usernameDB.equals(usernameDigitado) || !passwordDB.equals(senhaDigitada)){
            throw new LoginInvalidoException("User or Passwords invalids");
        }
        System.out.println("User logado sucess");

    }
}
