package javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        extracted();
    }

    private static String extracted() {
        try {
            System.out.println("Abrindo arquivo...");
            System.out.println("Escrevendo dados no arquivo...");
            return "conexão aberta";
        } catch (Exception e) {
            e.printStackTrace(); // relatorio total do error
        }finally {
            // sempre vai ser executado indepedente se tem exceçao ou nao
            System.out.println("Fechando recurso liberado pelo SO...");
        }
        return null ;
    }
}
