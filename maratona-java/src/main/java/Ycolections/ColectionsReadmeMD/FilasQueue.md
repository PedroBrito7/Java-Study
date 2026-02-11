Em Java, Queue é uma interface da Collections Framework usada para representar uma fila, ou seja, uma estrutura FIFO (First In, First Out).

👉 Quem entra primeiro, sai primeiro.

O que é Queue

Está no pacote java.util

Estende Collection

Muito usada para processamento em ordem, filas de tarefas, eventos, requisições, threads, etc.

Implementações comuns:

LinkedList

PriorityQueue

ArrayDeque

Métodos principais da Queue
1️⃣ Inserção
add(E e)

Insere o elemento na fila

Lança exceção se não conseguir inserir

queue.add("A");

offer(E e)

Insere o elemento na fila

Não lança exceção, retorna true ou false

queue.offer("B");


📌 Na prática, prefira offer.

2️⃣ Remoção
remove()

Remove o primeiro elemento da fila

Lança exceção se a fila estiver vazia

queue.remove();

poll()

Remove o primeiro elemento

Retorna null se a fila estiver vazia

queue.poll();


📌 Na prática, prefira poll.

3️⃣ Consulta (sem remover)
element()

Retorna o primeiro elemento

Lança exceção se estiver vazia

queue.element();

peek()

Retorna o primeiro elemento

Retorna null se estiver vazia

queue.peek();


📌 Na prática, prefira peek.

Resumo rápido dos métodos
Operação	Com exceção	Sem exceção
Inserir	add()	offer()
Remover	remove()	poll()
Consultar	element()	peek()
Exemplo simples (FIFO)
Queue<String> fila = new LinkedList<>();

fila.offer("Cliente 1");
fila.offer("Cliente 2");
fila.offer("Cliente 3");

System.out.println(fila.poll()); // Cliente 1
System.out.println(fila.poll()); // Cliente 2
System.out.println(fila.poll()); // Cliente 3

PriorityQueue (não é FIFO)

⚠️ Importante:

PriorityQueue não respeita ordem de inserção

Ela organiza pelos critérios de prioridade (Comparable ou Comparator)

Queue<Integer> fila = new PriorityQueue<>();

fila.offer(10);
fila.offer(1);
fila.offer(5);

System.out.println(fila.poll()); // 1
System.out.println(fila.poll()); // 5
System.out.println(fila.poll()); // 10

Quando usar Queue

Fila de atendimento

Processamento de tarefas

Controle de requisições

Mensageria

Algoritmos (BFS, por exemplo)

Se quiser, no próximo passo eu te mostro:

Deque vs Queue

ArrayDeque vs LinkedList

Um case real tipo fila de pedidos ou tarefas de sistema