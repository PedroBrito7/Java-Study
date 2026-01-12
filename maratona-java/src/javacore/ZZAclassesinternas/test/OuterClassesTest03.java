package javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name = "Pedro";

    static class Nested{
        private String lastName = "Brito";
        void print(){
            // not can't access the name. You have to do: not access because his is private, inside class static
            System.out.println(new OuterClassesTest03().name + " " + lastName);
        }
    }
    public static void main(String[] args) {
Nested nested = new Nested();
nested.print();
    }
}
