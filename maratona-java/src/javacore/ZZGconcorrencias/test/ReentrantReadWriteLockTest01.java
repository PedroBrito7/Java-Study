package javacore.ZZGconcorrencias.test;
import java.util.concurrent.locks.*;

    public class ReentrantReadWriteLockTest01 {
        private double saldo;

        private final ReadWriteLock lock = new ReentrantReadWriteLock();
        private final Lock readLock = lock.readLock();
        private final Lock writeLock = lock.writeLock();

        public ReentrantReadWriteLockTest01(double saldoInicial) {
            this.saldo = saldoInicial;
        }

        // LEITURA (muitos usuários consultando saldo)
        public double consultarSaldo() {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() +
                        " lendo saldo: " + saldo);
                return saldo;
            } finally {
                readLock.unlock();
            }
        }

        // ESCRITA (operação crítica)
        public void sacar(double valor) {
            writeLock.lock();
            try {
                if (saldo >= valor) {
                    System.out.println(Thread.currentThread().getName() +
                            " sacando: " + valor);
                    saldo -= valor;
                }
            } finally {
                writeLock.unlock();
            }
        }
    }



