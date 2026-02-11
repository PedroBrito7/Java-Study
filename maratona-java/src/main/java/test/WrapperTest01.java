package javacore.Pwrappers.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 1;
        float floatP = 1;
        double doubleP = 10D;
        char charP = 'W';
        boolean booleanP = false;
// Wrapper autoboxing jeito que o java ja transforma
        Byte byteW = 127;
        Short shortW = 1;
        Integer intW = 1;
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        char charW = 'W';
        Boolean booleanW = false;

        int i = intW; // unboxing é do wrapper pro primitivo
        Integer intW2 = Integer.parseInt("1"); // todos tem um parse
        Integer intW3 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("True");

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toLowerCase('a'));

    }
}
