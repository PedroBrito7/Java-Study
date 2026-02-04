package javacore.ZZGconcorrencias.test;

public class Main {

        public static void main(String[] args) {

            ReentrantReadWriteLockTest01 conta = new ReentrantReadWriteLockTest01(1000);

            Runnable leitura = () -> {
                for (int i = 0; i < 3; i++) {
                    conta.consultarSaldo();
                }
            };

            Runnable escrita = () -> {
                conta.sacar(100);
            };

            new Thread(leitura, "Leitor-1").start();
            new Thread(leitura, "Leitor-2").start();
            new Thread(escrita, "Escritor-1").start();
        }
    }

