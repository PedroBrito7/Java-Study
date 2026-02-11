package javacore.ZZAclassesinternas.test;

// classes que vao existir brevemente no codigo que nao vao ser utilizadas em nenhum outro lugar
class Animal {
    public void walk() {
        System.out.println("Animal walking...");
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void walk() {
                System.out.println("Walking in the shadows...");
            }
        };
        animal.walk();

    }
}
