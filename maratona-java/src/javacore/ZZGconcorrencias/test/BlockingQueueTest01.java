package javacore.ZZGconcorrencias.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//Este código resolve o problema clássico de comunicação segura entre múltiplas threads
//que produzem e consomem dados em velocidades diferentes. Em sistemas reais, é comum
//existirem threads responsáveis por receber tarefas (produtores) e outras responsáveis
//por processá-las (consumidores). Sem um mecanismo adequado, essa comunicação pode gerar
//race conditions, acesso concorrente inconsistente, uso excessivo de CPU ou até estouro
//de memória.
public class BlockingQueueTest01 {
    // Fila com capacidade máxima de 5 itens
    private static final BlockingQueue<String> queue =
            new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String task = "Task " + i;
                    queue.put(task); // BLOQUEIA se a fila estiver cheia
                    System.out.println("Produziu: " + task);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String task = queue.take(); // BLOQUEIA se a fila estiver vazia
                    System.out.println("Consumiu: " + task);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
/*
PROBLEMA
Em aplicações que utilizam múltiplas threads, é comum existir uma separação entre
quem produz tarefas (por exemplo, recebendo requisições, eventos ou mensagens) e
quem consome essas tarefas para processamento. Quando produtores e consumidores
executam em velocidades diferentes, surgem problemas como acesso concorrente não
seguro aos dados, race conditions, loops de espera ativa (busy waiting) e dificuldade
em controlar o volume de tarefas em memória.

SOLUÇÃO
Para resolver esses problemas, foi utilizada a interface BlockingQueue, que fornece
uma fila thread-safe com mecanismos de bloqueio automático. Ela garante que o produtor
seja bloqueado quando a fila atinge sua capacidade máxima e que o consumidor seja
bloqueado quando a fila está vazia, eliminando a necessidade de controle manual de
sincronização com synchronized, wait e notify.

IMPLEMENTAÇÃO
O código implementa o padrão Produtor–Consumidor utilizando um ArrayBlockingQueue
com capacidade limitada. Uma thread produtora insere tarefas na fila usando o método
put(), que bloqueia automaticamente caso a fila esteja cheia. Uma thread consumidora
remove tarefas da fila usando o método take(), que bloqueia quando não há elementos
disponíveis. Esse mecanismo garante comunicação segura entre as threads, controle de
fluxo (backpressure) e processamento ordenado das tarefas, tornando a aplicação mais
estável, escalável e adequada para cenários reais como processamento assíncrono,
filas de eventos e sistemas corporativos.
*/