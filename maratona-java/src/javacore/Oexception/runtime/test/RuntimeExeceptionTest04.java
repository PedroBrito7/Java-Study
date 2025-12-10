package javacore.Oexception.runtime.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
public class RuntimeExeceptionTest04 {
    public static void main(String[] args) {
        try {
            throw new ArrayIndexOutOfBoundsException();
           // Lança explicitamente um novo objeto RuntimeException. A execução do bloco try para aí e
            // procura um catch que case com o tipo da exceção
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
            System.out.println(" Dentro ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(" Dentro IndexOutOfBoundsException");
        } catch (RuntimeException e) {
            System.out.println(" Dentro RuntimeException");
        }


        try {
            talvezLanceException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}

