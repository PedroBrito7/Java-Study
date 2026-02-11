# Sincronismo de Threads em Java

## 1. O que é sincronismo de threads?

Sincronismo de threads é o conjunto de técnicas usadas para **controlar o acesso concorrente a recursos compartilhados** (memória, objetos, arquivos, conexões, etc.) quando múltiplas threads executam ao mesmo tempo.

Em Java, várias threads podem acessar o mesmo objeto simultaneamente. Sem sincronização adequada, isso pode gerar **condições de corrida (race conditions)**, **dados inconsistentes** e **erros difíceis de reproduzir**.
- Race condition : resultado de um programa depende da ordem em que threads (ou processos) são executados, e essa ordem não é garantida.
> **Ideia central:** garantir que apenas uma thread por vez execute um trecho crítico de código.

---

## 2. Problema clássico: race condition

```java
class ContaBancaria {
    private int saldo = 1000;

    public void sacar(int valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}
```

Se duas threads chamarem `sacar(500)` ao mesmo tempo:
- Ambas podem passar na condição `saldo >= valor`
- O saldo pode ficar incorreto

Esse trecho é chamado de **seção crítica**.

---

## 3. Palavra-chave `synchronized`

O `synchronized` é o mecanismo mais básico de sincronização em Java. Ele usa o **monitor (lock)** de um objeto.

### 3.1 Método sincronizado

```java
public synchronized void sacar(int valor) {
    if (saldo >= valor) {
        saldo -= valor;
    }
}
```

- Apenas **uma thread por vez** pode executar esse método por instância
- O lock é o **objeto atual (`this`)** 

Definição de lock:
(Um lock é um mecanismo de bloqueio usado para controlar o acesso a um recurso compartilhado quando várias threads existem.
Em termos simples:
Lock = “quem está usando agora”)

---

### 3.2 Bloco sincronizado

Mais flexível e recomendado em muitos casos:

```java
public void sacar(int valor) {
    synchronized (this) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }
}
```

Vantagens:
- Sincroniza apenas o trecho necessário
- Menor impacto de performance

---

## 4. Lock em nível de classe (static)

Quando o método é `static`, o lock é na **classe**, não na instância.

```java
public static synchronized void registrarLog() {
    // lock em ContaBancaria.class
}
```

Equivalente a:

```java
synchronized (ContaBancaria.class) {
    // código
}
```

---

## 5. Problemas do `synchronized`

Apesar de simples, ele tem custos:

- **Bloqueio total**: threads ficam paradas esperando
- **Escalabilidade limitada**
- Pode causar **deadlock** se usado incorretamente

Por isso, Java oferece alternativas mais avançadas.

---
## Por isso, Java oferece alternativas mais avançadas dentr elas :
## 6. `volatile` (visibilidade, não atomicidade)

`volatile` garante que uma variável:
- Sempre seja lida da memória principal
- Seja visível entre threads

```java
private volatile boolean ativo = true;
```

⚠️ Importante:
- **Não garante exclusão mútua**
- Não resolve operações como `contador++`

Use para **flags de controle**, não para cálculos.

---

## 7. Locks explícitos (`java.util.concurrent.locks`)

### 7.1 `ReentrantLock`

```java
Lock lock = new ReentrantLock();

public void sacar(int valor) {
    lock.lock();
    try {
        if (saldo >= valor) {
            saldo -= valor;
        }
    } finally {
        lock.unlock();
    }
}
```

Vantagens sobre `synchronized`:
- `tryLock()` (não bloqueia indefinidamente)
- Locks justos (fairness)
- Mais controle

---

## 8. Classes atômicas

Java oferece classes prontas para operações thread-safe:

```java
AtomicInteger contador = new AtomicInteger(0);
contador.incrementAndGet();
```

Principais:
- `AtomicInteger`
- `AtomicLong`
- `AtomicBoolean`

Internamente usam **CAS (Compare-And-Swap)**, evitando bloqueios.

---

## 9. Comunicação entre threads: `wait`, `notify`, `notifyAll`

Usados para **coordenação**, não para exclusão mútua.

```java
synchronized (this) {
    while (!condicao) {
        wait();
    }
}
```

```java
synchronized (this) {
    condicao = true;
    notifyAll();
}
```

Regras importantes:
- Devem ser chamados dentro de bloco `synchronized`
- `wait()` libera o lock

---

## 10. Deadlock

Deadlock ocorre quando:
- Thread A espera recurso da Thread B
- Thread B espera recurso da Thread A

```java
synchronized (recurso1) {
    synchronized (recurso2) {
        // risco de deadlock
    }
}
```

Boas práticas:
- Ordem fixa de aquisição de locks
- Evitar múltiplos locks
- Preferir APIs de alto nível

---

## 11. Sincronismo em aplicações reais (ex: bancos)

Em sistemas bancários:
- Atualização de saldo → **atômica e sincronizada**
- Logs → sincronização em nível de classe
- Processamento em massa → uso de **locks + filas**

Hoje, é comum usar:
- `ExecutorService`
- `ConcurrentHashMap`
- Filas thread-safe (`BlockingQueue`)

---

## 12. Boas práticas

- Sincronize **o mínimo possível**
- Prefira classes de `java.util.concurrent`
- Evite `synchronized` em métodos grandes
- Sempre pense em **escala e contenção**

---

## 13. Quando estudar sincronismo mais a fundo?

Você deve aprofundar quando:
- Lidar com alta concorrência
- Trabalhar com sistemas distribuídos
- Desenvolver sistemas financeiros ou de mensageria

---

## 14. Resumo

- `synchronized` → simples, porém custoso
- `volatile` → visibilidade
- `Lock` → mais controle
- `Atomic` → alta performance

Sincronismo é essencial para **correção**, mas deve ser usado com cuidado para não comprometer **performance e escalabilidade**.
