package javacore.ZZFThreads.test;

import javacore.ZZFThreads.Dominio.Account;

public class ThreadAccountTest01 implements Runnable  {
    private Account account = new Account();
    public static void main(String[] args) {
ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
Thread t1 = new Thread(threadAccountTest01, "Hestia ");
Thread t2 = new Thread(threadAccountTest01, "Bell Cranel ");
t1.start();
t2.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            withdrawal(10);
            if(account.getBalance() < 0 ){
                System.out.println("FODEO");
            }
        }   
    }

    private void withdrawal(int amount) { // agora com synchronized apenas 1 thread de cada vez para executar
        synchronized (account) {
            System.out.println(getThreadName()+ "Dentro do synchronized");
            System.out.println();
            if (account.getBalance() >= amount) {
                System.out.println(Thread.currentThread().getName() + " está indo sacar dinheiro");
                account.withDrawl(amount);
                System.out.println(Thread.currentThread().getName() + " Completou o saque, valor da  atual da conta " + account.getBalance());
            } else {
                System.out.println("Sem dinheiro para" + Thread.currentThread().getName() + "Efetuar o saque" + account.getBalance());
            }
        }
    }
    private String getThreadName(){
        return Thread.currentThread().getName();
    }
}
