# 📖 Guia Avançado e Completo de Exceptions em Java

Este documento organiza os 21 pontos essenciais sobre como lidar com erros (Exceptions) em Java, desde o básico até as práticas avançadas de performance e concorrência.

## 1. 🏗️ Terminologia Básica e Hierarquia

| Tipo | Descrição Simples | Regra |
| :--- | :--- | :--- |
| **Throwable** | A raiz de toda a hierarquia de erros. | Não capture em código normal. |
| **Error** | Problemas graves da JVM (Ex: falta de memória). | Não trate, deixe o sistema falhar. |
| **Exception** | Erros de aplicação que você deve tratar. | O foco do tratamento de erros. |
| **Checked** | O compilador te obriga a declarar/tratar. | Erros esperados de ambiente (I/O, DB). |
| **Unchecked** (RuntimeException) | Não obrigatórias pelo compilador. | Erros de programação (Ex: NullPointer). |

> ⚠️ **Observação:** Evitar capturar `Error` ou `Throwable` para não esconder falhas sérias.

## 2. ⚡ Criação e Propagação (Stack Unwinding)

1.  **Criação:** A JVM cria a instância da exceção e gera o **stack trace** (o histórico de chamadas) — **isso é custoso**.
2.  **Propagação:** A exceção "sobe" a pilha de chamadas (*unwinding*) até encontrar um `catch` compatível.
3.  **Fim:** Se ninguém tratar, a thread termina, e o stack trace vai para o `System.err`.

> 💡 **Dica de Performance:** Evite usar exceções para controle de fluxo em locais que rodam repetidamente (loops), pois a criação do stack trace é lenta.

## 3. 🎯 Checked vs Unchecked: Design e Controvérsias

* **Checked:** Forçam tratamento, boas para falhas ambientais **recuperáveis** (I/O, rede).
* **Unchecked:** Geralmente erros de lógica de programação.

**Padrões:** É comum em APIs modernas usar `Unchecked` (Runtime Wrappers) para evitar poluir o contrato dos métodos, traduzindo exceções de baixo nível (`SQLException`) para exceções de domínio (`DataAccessException` - runtime) nas camadas superiores.

## 4. 🔗 Exception Chaining (Preservando a Causa)

Sempre que você relançar uma exceção, inclua a exceção original para não perder o rastro do erro:


try {
    // ...
} catch (IOException e) {
    // Lança uma nova, mas carrega 'e' como a causa original
    throw new MinhaExcecaoDeNegocio("Falha ao ler", e); 
}
// Use getCause() para recuperar a original. initCause() liga depois (uma única vez).
## 5. 🤫 Suppressed Exceptions (Exceções Suprimidas)

Isso ocorre principalmente com o `try-with-resources`. Se houver uma falha no bloco `try` e também no fechamento automático (`close()`):

* A exceção do bloco `try` é a **principal**.
* A exceção do `close()` é **suprimida** (guardada dentro da principal).

**APIs Úteis:**
* `Throwable#addSuppressed(Throwable)`: Adiciona uma exceção como suprimida.
* `Throwable#getSuppressed()`: Retorna uma lista de exceções suprimidas.
* `printStackTrace()`: Exibe as exceções suprimidas automaticamente.

## 6. 🔄 `finally` vs `try-with-resources`

| Característica | `finally` | `try-with-resources` (Java 7+) |
| :--- | :--- | :--- |
| **Fechamento** | Manual (você precisa chamar `close()`). | Automático, para objetos que implementam `AutoCloseable`. |
| **Exceções** | Se o `close()` no `finally` falhar, pode *ocultar* a exceção original. | Preserva as exceções suprimidas (melhor diagnóstico). |
| **Recomendação** | Usado para lógica geral ou código Java antigo. | **PREFERIR** para recursos que precisam ser fechados (arquivos, conexões). |

**Exemplo:**

try (BufferedReader br = new BufferedReader(...)) {
    // ...
} // O recurso 'br' é fechado automaticamente

Com certeza! Vou aplicar o mesmo nível de detalhe e organização para os tópicos restantes (do 5 ao 21), garantindo que a formatação Markdown seja clara e mantenha a linguagem simples.

Aqui está o restante do seu guia, pronto para ser copiado e colado no seu arquivo .md:



## 5. 🤫 Suppressed Exceptions (Exceções Suprimidas)

Isso ocorre principalmente com o `try-with-resources`. Se houver uma falha no bloco `try` e também no fechamento automático (`close()`):

* A exceção do bloco `try` é a **principal**.
* A exceção do `close()` é **suprimida** (guardada dentro da principal).

**APIs Úteis:**
* `Throwable#addSuppressed(Throwable)`: Adiciona uma exceção como suprimida.
* `Throwable#getSuppressed()`: Retorna uma lista de exceções suprimidas.
* `printStackTrace()`: Exibe as exceções suprimidas automaticamente.

## 6. 🔄 `finally` vs `try-with-resources`

| Característica | `finally` | `try-with-resources` (Java 7+) |
| :--- | :--- | :--- |
| **Fechamento** | Manual (você precisa chamar `close()`). | Automático, para objetos que implementam `AutoCloseable`. |
| **Exceções** | Se o `close()` no `finally` falhar, pode *ocultar* a exceção original. | Preserva as exceções suprimidas (melhor diagnóstico). |
| **Recomendação** | Usado para lógica geral ou código Java antigo. | **PREFERIR** para recursos que precisam ser fechados (arquivos, conexões). |

**Exemplo:**

try (BufferedReader br = new BufferedReader(...)) {
    // ...
} // O recurso 'br' é fechado automaticamente
7. 📥 Multi-catch (Captura Múltipla)
Permite capturar vários tipos de exceção em um único bloco catch, útil quando o tratamento é idêntico. (Java 7+).



try {
    // ...
} catch (IOException | SQLException ex) {
    // Tratamento comum para ambas
}
Regras:

ex é tratado como efetivamente final (não pode reatribuir ex).

Você não pode listar tipos que estão na mesma hierarquia (Ex: Exception | IOException é inválido, pois IOException já é uma Exception).

8. 🔄 Rethrow com Inferência de Tipo (Java 7+)
O compilador consegue ser mais esperto. Se você capturar e simplesmente relançar (throw e), ele pode inferir o tipo exato de exceção que será propagado.

Java

public void precisaLancar() throws IOException { // Assinatura precisa
    try {
        mayThrowIOExceptionOrSQLException();
    } catch (IOException | SQLException e) {
        throw e; // Compilador infere corretamente o tipo (apenas o necessário)
    }
}
9. 🚧 Regras de return + finally (Armadilhas)
O valor do return é guardado antes do finally começar.

O bloco finally sempre roda.

ARMADILHA: Se o bloco finally também contiver um return, esse último valor prevalece, descartando o return original do try.

Java

int bad() {
    try { return 1; }
    finally { return 2; } // ⚠️ Retorna 2. EVITE ISSO!
}
10. 🛠️ fillInStackTrace() e Manipulação do Stack Trace
fillInStackTrace(): Atualiza o stack trace para o ponto onde o método é chamado (reinicia o histórico). Cuidado: é caro.

setStackTrace(StackTraceElement[]): Permite customizar ou limpar o stack trace (usado para otimizar performance ou não vazar detalhes).

💡 Padrão: Não manipule o stack trace a menos que tenha razões fortes (performance ou segurança).

11. 📈 Performance: Custo de Exceções
Custo: Criar e preencher o stack trace tem um custo significativo.

Melhor Prática: Evite usar exceções em caminhos críticos (loops). Em vez de deixar estourar, use checagens condicionais (if) para evitar exceções previsíveis.

12. 🎨 Boas Práticas de Design de Exceptions
Crie exceções customizadas e específicas (Ex: UserNotFoundException extends RuntimeException).

Use mensagens claras e ricas em contexto (IDs, parâmetros).

Prefira Unchecked em APIs públicas quando o erro for irrecuperável.

Sempre preserve a causa (new XException(msg, cause)) em I/O ou rede.

Não use exceções para controle de fluxo.

13. 🛡️ Padrões de Tratamento
Fail-fast: Detecte e lance erros cedo (Objects.requireNonNull), simplificando o debugging.

Exception Translation: Converter exceções de baixo nível (SQLException) para exceções de domínio mais amigáveis (DataAccessException).

Exception Wrapping: Encapsular exceções checked em runtime para não propagar o checked por todas as camadas.

Normalize Errors: Em APIs, documente e normalize os tipos de erro retornados.

14. 🤝 Concurrency e Exceptions
Threads: Uma exceção não tratada mata a thread. Use Thread.setUncaughtExceptionHandler() para tratamento global.

Futures: Future.get() e CompletableFuture.join() propagam exceções enroladas em ExecutionException ou CompletionException.

SEMPRE use getCause() para desempacotar e encontrar a exceção original.

15. 🪵 Logging e Diagnóstico
Não use e.printStackTrace() em produção. Use frameworks de logging estruturado (SLF4J, Log4j2).

Logar a pilha inteira (stack trace) é crucial; inclua contexto (usuário, ID da requisição).

Evite "swallowing" (engolir): jamais capture uma exceção sem fazer registro (log) dela.

16. 📤 Exceções Serializáveis
Throwable implementa Serializable. Se planejar enviar objetos de exceção pela rede, garanta que todos os campos da sua exceção customizada sejam serializáveis.

17. 📝 Exemplos Avançados
Exemplo: Exception Chaining e Rethrow
Java

public void metodo() throws MinhaCheckedException {
    try {
        // I/O...
    } catch (IOException e) {
        throw new MinhaCheckedException("falha", e); // Preserve a causa
    }
}
Exemplo: InterruptedException Correto
Java

try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt(); // MUITO IMPORTANTE: Preservar o sinal de interrupção
    throw new IllegalStateException("thread interrompida", e);
}
18. 🚨 Armadilhas Comuns
Swallowing: catch (Exception e) {} sem logar.

Catching Throwable: Esconde Error da JVM (evitar).

Return em finally: Sobrescreve e oculta informações (evitar).

Exceptions como fluxo: Prejudica performance e clareza.

Ignorar InterruptedException: Falha em preservar o estado de interrupção da thread.

19. 💻 Advanced: Bytecode e finally
O compilador traduz o finally garantindo sua execução, mesmo com return ou throw. Antigamente usava-se instruções JSR/RET no bytecode, mas hoje compilers modernos geralmente replicam o bloco finally ou usam estruturas de exceção no bytecode.

20. ✅ Checklist Prático para Consulta Rápida
Throwable: raiz; Error vs Exception.

Checked vs Unchecked: diferenças e design.

Chaining: new X(msg, cause).

Suppressed: try-with-resources.

Fechamento: try-with-resources > finally.

finally: Evitar return.

Performance: Exceptions são caras.

Concurrency: ExecutionException, InterruptedException (preservar flag).

Logging: Usar frameworks, não printStackTrace().

Boas Práticas: Mensagens ricas, preservar causas, não engolir.

21. 📚 Referência Rápida de APIs Úteis
Throwable#getCause()

Throwable#initCause(Throwable)

Throwable#addSuppressed(Throwable)

Throwable#getSuppressed()

AutoCloseable / try-with-resources

Objects.requireNonNull(obj, msg)