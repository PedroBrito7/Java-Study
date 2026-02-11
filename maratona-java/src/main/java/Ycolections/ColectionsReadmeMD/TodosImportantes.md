📦 Java Collections Framework
O Java Collections Framework é um conjunto de interfaces e classes prontas para armazenar, organizar e manipular dados (objetos).

Principais grupos:
List

Set

Map

Queue

🗂️ LIST (Ordem + Permite Repetição)
Usada quando a ordem de inserção importa e valores podem se repetir.

🔹 ArrayList
Base: Array dinâmico.

Vantagem: Acesso rápido por índice (get).

Desvantagem: Inserção ou remoção no meio da lista é lenta (requer deslocar elementos).

👉 Use quando: Você precisa ler dados com frequência e raramente alterar o meio da lista.

🔹 LinkedList
Base: Lista ligada (cada elemento aponta para o próximo).

Vantagem: Inserção e remoção rápidas em qualquer posição.

Desvantagem: Acesso por índice é lento (precisa percorrer a lista).

👉 Use quando: O sistema exige muitas inserções e remoções constantes. Também funciona como uma fila (Queue).

🧮 SET (Não Permite Repetição)
Usado quando a unicidade dos elementos é o requisito principal.

🔹 HashSet
Não mantém nenhuma ordem.

Extremamente rápido para busca e inserção.

Baseia-se nos métodos hashCode() e equals().

👉 Use quando: Você só precisa garantir que os elementos sejam únicos e a ordem não importa.

🔹 TreeSet
Mantém os elementos em sua ordem natural ou via Comparator.

Mais lento que o HashSet (logarítmico).

👉 Use quando: Você precisa de unicidade e ordem automática (ex: lista alfabética).

🗺️ MAP (Chave → Valor)
Tecnicamente não estende a interface Collection, mas é parte fundamental do framework. Associa uma chave única a um valor.

🔹 HashMap
Não mantém ordem.

Chaves devem ser únicas; valores podem repetir.

Alta performance para busca.

👉 Use quando: O desempenho é a prioridade e a ordem dos dados é irrelevante.

🔹 TreeMap
Mantém as chaves ordenadas.

👉 Use quando: Você precisa recuperar os dados em uma ordem específica de chaves.

🔹 LinkedHashMap
Mantém a ordem em que os elementos foram inseridos.

Ligeiramente mais lento que o HashMap devido à manutenção dos links.

👉 Use quando: Você precisa de um mapa que preserve a sequência de entrada.

📬 QUEUE (Fila)
Usada para seguir regras específicas de processamento de dados.

🔹 Queue / Deque
FIFO (First-In, First-Out): O primeiro a entrar é o primeiro a sair.

Essencial para buffers, sistemas de mensagens e filas de tarefas.

Implementações comuns:

LinkedList

ArrayDeque (geralmente mais eficiente que o LinkedList para pilhas e filas).