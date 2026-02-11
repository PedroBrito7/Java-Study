package javacore.dsa.test;


import java.util.Stack;

public class Main1Pilhas {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("Pagina1");
        stack.push("Pagina2");
        System.out.println(stack.pop());
    }
}
