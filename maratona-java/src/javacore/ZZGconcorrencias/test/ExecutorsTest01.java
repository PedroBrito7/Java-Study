package javacore.ZZGconcorrencias.test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{
    private final int num;
    public Printer(int num){
        this.num = num ;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %s%n",Thread.currentThread().getName(),num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("$ Finalizou %n", Thread.currentThread().getName());
    }
}

public class ExecutorsTest01 {

    public static void main(String[] args) {
        Executors.newFixedThreadPool()  // poll de  threads fixos
    }
}
