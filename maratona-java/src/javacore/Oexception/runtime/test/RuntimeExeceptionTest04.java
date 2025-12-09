package javacore.Oexception.runtime.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
// multiplos catchs for ex error 401 404 405
public class RuntimeExeceptionTest04 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" Dentro ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(" Dentro IndexOutOfBoundsException");
        } catch (IllegalArgumentException e) {
            System.out.println(" Dentro IllegalArgumentException");
        }catch (ArithmeticException e) {
            System.out.println(" Dentro ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println(" Dentro RuntimeException");
        }
        try{
            talvezLanceException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) { // pai do filenotFoundException
            throw new RuntimeException(e);
        }
    }
    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}
// dentro do try o primeiro  throw q ele encontra ele vai retornar. caso ele nao esteja lá, vai pegar a classe pai
// regra do polimorfismo - essa e a classe pai das exceptions (RuntimeException)
// todas exececoes genericas como essa que é pai precisa ser a ultima para que as filhas sejam
// deetectadas primeiro
// essas exceptions de cima, (talvezLanceException) nao segue o polimorfismo pq nn sao filhas nao podem ser colocadas
// dentro do catch assim criasse outro try dentro da classe e repetem podem chamar a classe pai por ultimo