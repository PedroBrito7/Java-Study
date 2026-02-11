# Paralelismo em Java (Parallel Streams) 
— Quando usar e quais cuidados tomar

O paralelismo em Java, especialmente com Parallel Streams, permite executar operações em múltiplos núcleos da CPU ao mesmo tempo. Isso pode melhorar performance e escalabilidade, mas nem sempre é a melhor escolha. Usar paralelismo sem análise pode aumentar o tempo de execução, o custo computacional e gerar problemas difíceis de diagnosticar.

## O que é Parallel Stream?

Um parallelStream() divide o processamento de um stream em múltiplas tarefas, executadas pelo ForkJoinPool comum da JVM.
````
list.parallelStream()
.map(...)
.filter(...)
.forEach(...);
````

⚠️ A divisão das tarefas e o merge dos resultados têm custo. O ganho só aparece quando o trabalho compensa esse overhead.


Regra de ouro do paralelismo

Nunca assuma que parallel é mais rápido. Sempre meça.

## Quando se fala de paralelismo tomar cuidado com:
## Benchmark
Antes de usar paralelismo, faça benchmark.

Por quê?

O custo de criar, dividir e sincronizar tarefas é alto

Em muitos casos, o stream() sequencial é mais rápido

Boas práticas

Testar sequencial vs paralelo

Executar várias vezes (JVM tem warm-up)

Medir tempo médio
````
long start = System.nanoTime();
// código
long end = System.nanoTime();
````
Só use paralelismo se o ganho for real e consistente.
--- 
## Unboxing | Boxing 
Parallel streams amplificam custos escondidos.

Problema

Integer, Long, Double geram boxing/unboxing

Criação excessiva de objetos → mais GC → menos performance

Evite
````
Stream<Integer>
````
Prefira
````
IntStream
LongStream
DoubleStream
````

➡️ Em paralelo, tipos primitivos fazem muita diferença.

--- 
## ficar dividindo muitas tarefas as vezes acaba ficando mais pesado
 do que resolver em uma function
ou um code ao inves de parallel

Erro comum

“Quanto mais threads, melhor”

Errado.

Por quê?

Overhead de criação e sincronização

Context switching

Merge final dos resultados

Exemplo ruim

Muitas tarefas pequenas

Processamento simples (ex: soma, comparação)

--- 
## 4. Operações que quebram o paralelismo

Algumas operações reduzem ou anulam os ganhos do parallel stream.

### Operações problemáticas
- `limit()`
- `findFirst()`
- `forEachOrdered()`

### Motivo
- Necessidade de manter ordem
- Sincronização entre threads

### Alternativas
- Prefira `findAny()`
- Evite `limit()` em streams paralelos

➡️ Ordem e paralelismo geralmente entram em conflito.

---

## 5. Custo total da computação (n × p)

Antes de paralelizar, avalie:
- **n**: quantidade de dados
- **p**: custo do processamento por item

### Paralelismo faz sentido quando
- Grande volume de dados
- Processamento pesado

### Paralelismo não compensa quando
- Poucos dados
- Operações simples

➡️ Se `n × p` for pequeno, o overhead vence.

---

## 6. Quantidade de dados

- Poucos elementos → stream sequencial
- Muitos elementos → paralelismo pode escalar

➡️ Sempre teste, não presuma.

---

## 7. Tipos de coleções: benefícios e desvantagens

Nem toda coleção é adequada para paralelismo.

### Mais eficientes
- `ArrayList`
- Arrays

Motivos:
- Estrutura contígua na memória
- Fácil divisão em partes

### Menos eficientes
- `LinkedList`
- Streams baseados em I/O

Motivos:
- Dificuldade de particionamento
- Baixa previsibilidade

📌 Sempre pesquise **quando e por que** uma coleção funciona bem ou mal em paralelo.

---

## 8. Tamanho do stream

Parallel streams funcionam melhor quando:
- O tamanho é conhecido
- A divisão é equilibrada

Streams infinitos ou imprevisíveis:
- Má distribuição de carga
- Threads ociosas

➡️ Streams finitos e previsíveis escalam melhor.

---

## 9. Processamento do merge

Após o processamento paralelo, os resultados precisam ser combinados.

### Riscos
- Operações não associativas
- Estruturas sincronizadas
- Reduce mal definido

### Exemplo perigoso
```java
list.parallelStream().reduce((a, b) -> a - b);
```

❌ Não associativo
❌ Resultado inconsistente

➡️ O merge deve ser **simples, rápido e associativo**.

---

## Quando usar paralelismo?

Use parallel streams quando:
- Processamento é CPU-bound
- Operações são pesadas
- Volume de dados é grande
- Código é stateless
- Benchmark comprovou ganho

Evite quando:
- Operações simples
- Poucos dados
- Dependência de ordem
- Estado compartilhado

---

## Checklist antes de usar `parallelStream()`

- [ ] Fiz benchmark?
- [ ] Processamento é pesado?
- [ ] Volume de dados é grande?
- [ ] Coleção adequada?
- [ ] Ordem não é necessária?
- [ ] Merge é associativo?
- [ ] Evitei boxing/unboxing?

---

## Conclusão

> **Paralelismo é uma ferramenta, não um padrão automático.**

Em Java, performance vem de **decisão consciente**, análise e medição.
Sempre pesquise, teste e valide antes de adotar parallel streams.


➡️ Paralelismo funciona melhor com tarefas grandes e custosas.
