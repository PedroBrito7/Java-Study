# ReadLock em Java — Uso Real e Prático

## 1. O problema que o ReadLock resolve

Em sistemas concorrentes, vários *threads* podem acessar o mesmo recurso ao mesmo tempo. Esses acessos se dividem em dois tipos:

- **Leitura** → não altera o estado do dado
- **Escrita** → altera o estado do dado

O problema surge quando uma **escrita ocorre enquanto outras leituras ou escritas estão em andamento**, causando inconsistência de dados — o famoso **race condition**.

Exemplo clássico:
- Um thread atualiza o saldo bancário
- Outro thread lê o saldo no meio da atualização

Sem controle adequado, o valor lido pode estar incorreto.

---

## 2. O que é ReadLock

O `ReadLock` faz parte da interface:

```java
java.util.concurrent.locks.ReadWriteLock
```

A implementação mais comum é:

```java
ReentrantReadWriteLock
```

### Ideia principal

- ✅ Vários threads podem **ler ao mesmo tempo**
- ❌ Apenas **um thread pode escrever**
- ❌ Enquanto alguém escreve, **ninguém lê**
- ❌ Enquanto alguém lê, **ninguém escreve**

Esse modelo melhora a **performance e escalabilidade** em sistemas onde a leitura é muito mais frequente que a escrita.

---

## 3. Comparação com synchronized

### synchronized
- Apenas **um thread por vez** (leitura ou escrita)
- Mais simples
- Menor escalabilidade

### ReadWriteLock
- Múltiplas leituras simultâneas
- Escrita exclusiva
- Mais complexo, porém mais eficiente em cenários *read-heavy*

---

## 4. Estrutura básica do ReadLock

```java
ReadWriteLock lock = new ReentrantReadWriteLock();

Lock readLock = lock.readLock();
Lock writeLock = lock.writeLock();
```

---

## 5. Exemplo simples de uso

```java
import java.util.concurrent.locks.*;

public class SharedData {
    private int value = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public int read() {
        readLock.lock();
        try {
            return value;
        } finally {
            readLock.unlock();
        }
    }

    public void write(int newValue) {
        writeLock.lock();
        try {
            value = newValue;
        } finally {
            writeLock.unlock();
        }
    }
}
```

### Comportamento
- Várias chamadas de `read()` podem ocorrer simultaneamente
- `write()` bloqueia todas as leituras e outras escritas

---

## 6. Exemplo real: sistema bancário

### Cenário
- Muitas consultas de saldo
- Poucas operações de saque ou depósito

Esse é um cenário **ideal para ReadLock**.

### Implementação completa

```java
import java.util.concurrent.locks.*;

public class ContaBancaria {

    private double saldo;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Leitura
    public double consultarSaldo() {
        readLock.lock();
        try {
            return saldo;
        } finally {
            readLock.unlock();
        }
    }

    // Escrita
    public void sacar(double valor) {
        writeLock.lock();
        try {
            if (saldo >= valor) {
                saldo -= valor;
            }
        } finally {
            writeLock.unlock();
        }
    }
}
```

### Teste com múltiplos threads

```java
public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(1000);

        Runnable leitura = () -> {
            for (int i = 0; i < 3; i++) {
                conta.consultarSaldo();
            }
        };

        Runnable escrita = () -> conta.sacar(100);

        new Thread(leitura).start();
        new Thread(leitura).start();
        new Thread(escrita).start();
    }
}
```

---

## 7. ReadLock é usado na vida real?

### Sim, é útil e usado

Principalmente em sistemas com:

- Muitas leituras
- Poucas escritas
- Dados compartilhados em memória

### Exemplos comuns

- 🏦 Sistemas bancários
- 🌐 APIs corporativas (GETs frequentes)
- 🧠 Cache em memória
- ⚙️ Sistemas de configuração
- 📊 Sistemas de monitoramento

---

## 8. Uso direto vs uso indireto

### Uso direto

Menos comum no código de aplicação, pois:

- Frameworks já resolvem concorrência
- Locks explícitos aumentam a complexidade
- Risco maior de deadlock

### Uso indireto (mais comum)

Mesmo sem escrever `ReadWriteLock`, você usa estruturas que aplicam esse conceito internamente:

- `ConcurrentHashMap`
- Caches (Caffeine, Ehcache)
- Pools e estruturas thread-safe

---

## 9. Quando vale a pena usar ReadLock

✔ Muitas leituras concorrentes
✔ Escritas raras
✔ Código crítico de performance
✔ Cache local ou dados de referência

---

## 10. Quando NÃO usar

❌ CRUD simples
❌ Muitas escritas
❌ Aplicações pequenas
❌ Quando `synchronized` já resolve

---

## 11. Erro comum

Nunca esquecer de liberar o lock:

❌ Errado
```java
readLock.lock();
// exception pode ocorrer
```

✅ Correto
```java
readLock.lock();
try {
    // código
} finally {
    readLock.unlock();
}
```

---

## 12. Resumo final

> **ReadLock permite múltiplas leituras simultâneas, garantindo exclusividade na escrita, sendo ideal para sistemas com alta taxa de leitura e baixa taxa de escrita.**

É muito usado na vida real, frequentemente de forma indireta através de frameworks e estruturas concorrentes, e seu entendimento é essencial para escrever sistemas escaláveis e seguros.
