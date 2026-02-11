# Concorrência em Java

## 1. O que é Concorrência?

Concorrência acontece quando **múltiplas tarefas progridem ao mesmo tempo**, competindo por recursos compartilhados, como CPU, memória, arquivos ou conexões de banco de dados.

Em Java, concorrência está diretamente ligada a **threads**, mas o foco não é apenas executar várias coisas ao mesmo tempo, e sim **garantir consistência, segurança e desempenho**.

> Concorrência ≠ Paralelismo
>
> - **Concorrência**: várias tarefas em progresso (intercaladas)
> - **Paralelismo**: várias tarefas executando literalmente ao mesmo tempo (múltiplos núcleos)

---

## 2. Por que Concorrência é Difícil?

Porque **threads compartilham estado**.

Problemas clássicos:
- Dados inconsistentes
- Resultados imprevisíveis
- Bugs intermitentes (difíceis de reproduzir)
- Deadlocks

---

## 3. Estado Compartilhado

Estado compartilhado é qualquer dado acessado por mais de uma thread.

```java
class Counter {
    int value = 0;

    void increment() {
        value++;
    }
}
```

Se duas threads chamarem `increment()` ao mesmo tempo, o resultado pode ser incorreto.

Motivo: `value++` **não é atômico**.

---

## 4. Race Condition

Uma **race condition** ocorre quando o resultado do programa depende da ordem de execução das threads.

```java
counter.increment();
counter.increment();
```

Esperado: `2`

Possível resultado: `1`

Por quê?
1. Thread A lê `value = 0`
2. Thread B lê `value = 0`
3. Ambas escrevem `1`

---

## 5. Atomicidade

Uma operação é **atômica** quando acontece por completo ou não acontece.

❌ Não atômico:
```java
value++;
```

✅ Atômico:
```java
AtomicInteger value = new AtomicInteger(0);
value.incrementAndGet();
```

Pacote importante:
```text
java.util.concurrent.atomic
```

---

## 6. Visibilidade de Memória

Threads podem trabalhar com **cópias locais** das variáveis (cache da CPU).

Problema:
- Uma thread altera o valor
- Outra thread não enxerga a mudança

### Palavra-chave `volatile`

```java
volatile boolean running = true;
```

Garante:
- Visibilidade entre threads

Não garante:
- Atomicidade

---

## 7. Exclusão Mútua (Lock)

Lock garante que **apenas uma thread por vez** execute um trecho crítico.

### `synchronized`

```java
synchronized void increment() {
    value++;
}
```

Ou:
```java
synchronized (this) {
    value++;
}
```

---

## 8. Locks Explícitos

Java oferece locks mais avançados que `synchronized`.

### `ReentrantLock`

```java
Lock lock = new ReentrantLock();

lock.lock();
try {
    value++;
} finally {
    lock.unlock();
}
```

Vantagens:
- Try lock
- Timeout
- Fairness

---

## 9. Deadlock

Deadlock ocorre quando duas ou mais threads ficam esperando indefinidamente.

Exemplo clássico:
- Thread A segura Lock 1 e espera Lock 2
- Thread B segura Lock 2 e espera Lock 1

Prevenção:
- Ordem fixa de locks
- Evitar locks desnecessários
- Timeout em locks

---

## 10. Imutabilidade

Objetos imutáveis são **thread-safe por definição**.

```java
public final class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

Muito usado em:
- `String`
- `LocalDate`
- `LocalDateTime`

---

## 11. Coleções Concorrentes

Coleções tradicionais **não são thread-safe**.

```java
List<Integer> list = new ArrayList<>();
```

Alternativas seguras:
- `ConcurrentHashMap`
- `CopyOnWriteArrayList`
- `BlockingQueue`

---

## 12. Thread-Safety

Um código é **thread-safe** quando pode ser usado por múltiplas threads sem causar erros.

Formas de garantir:
- Sincronização
- Imutabilidade
- Confinamento de thread
- Estruturas concorrentes

---

## 13. Confinamento de Thread

Cada thread trabalha com seus próprios dados.

```java
ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
```

Muito usado em:
- Frameworks web
- Contexto de requisição

---

## 14. Performance vs Segurança

Mais sincronização = mais segurança, mas:
- Menos paralelismo
- Mais contenção

Objetivo:
> **Sincronizar o mínimo necessário**

---

## 15. Concorrência no Mundo Real (Ex: Bancos)

Exemplos reais:
- Processamento de transações
- Controle de saldo
- Filas de pagamento
- Pools de conexões

Erro de concorrência em banco = **dinheiro errado**.

Por isso:
- Atomicidade
- Consistência
- Isolamento

---

## 16. Quando Estudar Concorrência?

Antes de:
- Spring
- Microservices
- Arquitetura distribuída

Porque frameworks **não corrigem código concorrente mal feito**.

---

## 17. Checklist Mental

Antes de escrever código concorrente, pergunte:
- Existe estado compartilhado?
- Preciso sincronizar?
- Atomic ou lock?
- Dá para tornar imutável?
- Impacto na performance?

---

## 18. Resumo Final

Concorrência em Java é sobre:
- Controle de acesso
- Consistência de dados
- Previsibilidade

Quem domina concorrência:
- Escreve código mais seguro
- Evita bugs críticos
- Escala melhor sistemas reais

---

> Se você entende concorrência, threads deixam de ser perigo e viram ferramenta.
