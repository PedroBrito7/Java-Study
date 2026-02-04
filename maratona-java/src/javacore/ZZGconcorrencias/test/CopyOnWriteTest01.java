package javacore.ZZGconcorrencias.test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

// copyonwrite leva em consideracao classe imutaveis - Nao pode modificar a mesma tendo q criar outra
// precisa ser tudo imutavel
public class CopyOnWriteTest01 {
    public static void main(String[] args) {
      List<Integer> list = new CopyOnWriteArrayList<>();
      // vc tem o valor [1]
      // ele copia e transforma no [1,2] smp criando novas (mas da b.o na memoria)
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }
        Runnable runnableIterator = () -> {
            Iterator<Integer> iterator = list.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println); // acao a ser executa por cada iteracao
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable runnableRemover= () -> {
            for (int i = 0; i < 500; i++) {
                System.out.printf("%s removed %d%n", Thread.currentThread().getName(), i);
                        }
        };
        new Thread(runnableIterator).start();
        new Thread(runnableIterator).start();
        new Thread(runnableRemover).start();
    }
}
