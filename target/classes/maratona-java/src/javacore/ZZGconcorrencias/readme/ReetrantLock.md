# Locks em Java: `Lock` e `ReentrantLock`

## 1. O que é um Lock?

Um **lock** é um mecanismo de **exclusão mútua** que garante que apenas **uma thread por vez** acesse uma seção crítica do código.

Em Java, locks são usados para:
- Proteger estado compartilhado
- Evitar race conditions
- Garantir consistência de dados

> Todo lock resolve concorrência? ❌ Não. Ele apenas controla acesso.

---

## 2. `synchronized` vs `Lock`

### `synchronized`
- Implícito
- Mais simples
- Controle limitado

```java
synchronized void increment() {
    value++;
}
```

### `Lock` (interface)
- Explícito
- Mais controle
- Mais verboso

```java
Lock lock = new ReentrantLock();

lock.lock();
try {
    value++;
} finally {
    lock.unlock();
}
```

---

## 3. A Interface `Lock`

Pacote:
```text
java.util.concurrent.locks
```

Principais métodos:

```java
void lock();
boolean tryLock();
boolean tryLock(long time, TimeUnit unit);
void unlock();
Condition newCondition();
```

---

## 4. ReentrantLock

`ReentrantLock` é a implementação mais usada da interface `Lock`.

### O que significa "Reentrant"?

A **mesma thread pode adquirir o mesmo lock mais de uma vez**, sem causar deadlock.

```java
lock.lock();
lock.lock(); // permitido
```

O lock só será liberado quando `unlock()` for chamado o mesmo número de vezes.

---

## 5. Exemplo Básico com `ReentrantLock`

```java
class Counter {
    private int value = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }
}
```

🔴 **Nunca esqueça o `finally`** — evita deadlock em caso de exceção.

---

## 6. `tryLock()` – Evitando Bloqueio

Permite tentar adquirir o lock **sem bloquear a thread**.

```java
if (lock.tryLock()) {
    try {
        value++;
    } finally {
        lock.unlock();
    }
} else {
    // não conseguiu o lock
}
```

Muito usado quando:
- Performance é crítica
- Não pode esperar indefinidamente

---

## 7. `tryLock` com Timeout

```java
if (lock.tryLock(2, TimeUnit.SECONDS)) {
    try {
        value++;
    } finally {
        lock.unlock();
    }
} else {
    // timeout
}
```

Evita **deadlocks eternos**.

---

## 8. Fair Lock (Justiça)

Por padrão, `ReentrantLock` **não é justo**.

```java
Lock lock = new ReentrantLock(true); // fair lock
```

### Diferença:
- ❌ Não justo: melhor performance
- ✅ Justo: threads atendidas por ordem de chegada

---

## 9. Reentrância na Prática

```java
class Service {
    private final Lock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();
        try {
            methodB();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            // lógica
        } finally {
            lock.unlock();
        }
    }
}
```

Sem reentrância → deadlock.

---

## 10. `Lock` vs `synchronized` (Resumo)

| Critério | synchronized | ReentrantLock |
|-------|-------------|---------------|
| Simplicidade | ✅ | ❌ |
| Try Lock | ❌ | ✅ |
| Timeout | ❌ | ✅ |
| Fairness | ❌ | ✅ |
| Controle | Baixo | Alto |

---

## 11. `Condition` (Avançado)

`Condition` substitui `wait()` / `notify()`.

```java
Condition condition = lock.newCondition();

condition.await();
condition.signal();
```

Uso comum:
- Filas
- Produtor / Consumidor

---

## 12. Exemplo: Produtor e Consumidor

```java
lock.lock();
try {
    while (queue.isEmpty()) {
        condition.await();
    }
    queue.poll();
    condition.signal();
} finally {
    lock.unlock();
}
```

---

## 13. Erros Comuns

❌ Esquecer `unlock()`

❌ Usar lock grande demais

❌ Lock dentro de loop sem critério

❌ Misturar `synchronized` com `Lock`

---

## 14. Quando Usar `ReentrantLock`?

Use quando precisar:
- Timeout
- Controle fino
- Alta concorrência
- Evitar starvation

Caso contrário, prefira:
```java
synchronized
```

---

## 15. Uso Real (Ex: Sistemas Bancários)

Exemplos:
- Atualização de saldo
- Processamento de transações
- Controle de recursos críticos

Concorrência errada = **inconsistência financeira**.

---

## 16. Checklist Mental

- Preciso de lock explícito?
- `synchronized` resolve?
- Preciso de timeout?
- Existe risco de deadlock?

---

## 17. Resumo Final

`ReentrantLock` é:
- Poderoso
- Flexível
- Mais complexo

Use quando precisar de **controle avançado** sobre concorrência.

> Lock mal usado é tão perigoso quanto código sem lock.
