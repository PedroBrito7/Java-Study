package javacore.Bmetodos.dominio;

public class Calculadora {
    public void somaTwoNumbers() {
        System.out.println(10 + 10);
    }

    public void substraiTwoNumbers() {
        System.out.println(123 - 45);
    }

    public void multiplicaTwoNumbers(int num, int num2) {
        System.out.println(num * num2);
    }

    public double divideDoisNumeros(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Não existe divisão por zero");
            return 0;
        }
        return num1 / num2;
    }

    public void alteraDoisNumeros(int numero1, int numero2) {
        numero1 = 99;
        numero2 = 23;
        System.out.println("Dentro do altera dois numbers");
        System.out.println("Num1" + numero1);
        System.out.println("Num2" + numero2);
    }

    public void somaArray(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }

    public void somaVarArgs(int... numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        System.out.println(soma);
    }


}

