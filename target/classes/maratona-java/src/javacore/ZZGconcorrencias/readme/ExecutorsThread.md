# Executors em Java – Concorrência na Prática

## Introdução
O **Executor Framework** (`java.util.concurrent`) é a forma **padrão e recomendada** de trabalhar com concorrência em Java moderno. Ele resolve os principais problemas do uso direto de `Thread`, trazendo **controle**, **performance**, **escala** e **manutenibilidade**.

Neste documento você vai ver:
- Qual problema os Executors resolvem
- O conceito central do framework
- Tipos de Executors
- Como funcionam na prática
- Exemplos reais de uso
- Boas práticas

---

## O problema que existia antes dos Executors
Antes do Executor Framework, o desenvolvedor precisava:
- Criar threads manualmente
- Controlar quando iniciar e finalizar
- Evitar criar threads demais
- Reaproveitar threads

Exemplo de problema real:
- API recebe centenas de requisições simultâneas
- Cada requisição cria uma `Thread`
- Resultado:
    - Consumo excessivo de memória
    - Context switch alto
    - Sistema instável

**Executors surgem para gerenciar isso automaticamente.**

---

## Ideia central dos Executors
> **Você envia tarefas, o Executor gerencia as threads.**

Você não cria threads diretamente.
Você apenas define **o que deve ser executado**.

---

## ExecutorService
`ExecutorService` é a interface principal.

Ela oferece:
- Pool de threads reutilizáveis
- Fila de tarefas
- Controle de ciclo de vida
- Encerramento controlado

---

## Tipos principais de Executors

### FixedThreadPool
```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

- Número fixo de threads
- Tarefas extras entram em fila
- Ideal para:
    - APIs
    - Sistemas bancários
    - Processamento controlado

---

### SingleThreadExecutor
```java
ExecutorService executor = Executors.newSingleThreadExecutor();
```

- Apenas uma thread
- Execução sequencial
- Garante ordem
- Ideal para:
    - Logs
    - Escrita em arquivo
    - Processos críticos

---

### CachedThreadPool
```java
ExecutorService executor = Executors.newCachedThreadPool();
```

- Cria threads conforme demanda
- Reutiliza threads inativas
- Pode crescer muito
- Usar com cuidado

Ideal para:
- Tarefas curtas
- Picos imprevisíveis

---

### ScheduledExecutorService
```java
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
```

Permite:
- Execução atrasada
- Execução periódica

```java
scheduler.schedule(() -> {
    System.out.println("Executado após 5 segundos");
}, 5, TimeUnit.SECONDS);
```

Uso comum:
- Jobs
- Monitoramento
- Tarefas recorrentes

---

## Enviando tarefas ao Executor

### Runnable (sem retorno)
```java
executor.execute(() -> {
    System.out.println("Executando tarefa");
});
```

### Callable (com retorno)
```java
Callable<Integer> tarefa = () -> 10 + 20;

Future<Integer> future = executor.submit(tarefa);

Integer resultado = future.get();
```

---

## O que acontece internamente
1. A tarefa é enviada ao Executor
2. Ela entra em uma fila
3. Uma thread livre executa
4. Ao terminar, a thread volta para o pool

Nenhuma thread é desperdiçada.

---

## Encerrando o Executor (obrigatório)

```java
executor.shutdown();
```

- Finaliza tarefas pendentes
- Libera recursos

Ou de forma forçada:
```java
executor.shutdownNow();
```

---

## Exemplo real: API simulada
```java
ExecutorService executor = Executors.newFixedThreadPool(5);

for (int i = 0; i < 20; i++) {
    int requestId = i;

    executor.execute(() -> {
        System.out.println("Processando request " + requestId);
    });
}

executor.shutdown();
```

### O que esse código resolve
- Limita concorrência
- Evita criar threads infinitas
- Garante estabilidade

---

## Boas práticas
- Prefira Executors ao invés de `new Thread()`
- Sempre finalize o Executor
- Escolha o tipo certo de pool
- Evite `CachedThreadPool` sem limites
- Pense em capacidade da CPU

---

## Quando Executors são usados na vida real
- Servidores web
- Bancos
- Filas de processamento
- Sistemas distribuídos
- Microserviços

**Executors são amplamente usados em produção.**

---

## Conclusão
O Executor Framework é essencial para qualquer desenvolvedor Java.

Ele resolve:
- Problemas de escala
- Gerenciamento de threads
- Performance
- Organização do código

Se você entende Executors, você entende concorrência real em Java.
