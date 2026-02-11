Collectors como se fosse um framework dentro dos Streams
dá para fazer muita coisa,

Sintaxe:
````
System.out.println(lightNovels.stream().collect(Collectors.ALGUMMETODODENTRODELE)));
````
Agora vamos ver alguns métodos dele. 

# Collectors em Java – Métodos mais úteis

Este documento lista os **Collectors mais usados em contextos profissionais** e também **muito úteis em LeetCode / DSA**, com foco em legibilidade, performance e resolução de problemas com Streams.

---

## 🔹 Collectors Básicos (fundamentais)

### `toList()`

* Converte um Stream em `List`
* **Uso comum:** retorno de dados, filtros, mapeamentos

```java
list.stream().filter(x -> x > 0).collect(Collectors.toList());
```

---

### `toSet()`

* Converte em `Set`, removendo duplicados
* **LeetCode:** remover duplicatas rapidamente

```java
list.stream().collect(Collectors.toSet());
```

---

### `toMap(keyMapper, valueMapper)`

* Converte para `Map`
* **Muito usado profissionalmente**

```java
list.stream().collect(Collectors.toMap(User::getId, User::getName));
```

⚠️ Cuidado com chaves duplicadas

---

### `toMap(keyMapper, valueMapper, mergeFunction)`

* Resolve conflitos de chave
* **LeetCode:** frequências, agregações

```java
Collectors.toMap(
  x -> x,
  x -> 1,
  Integer::sum
);
```

---

## 🔹 Contagem e Agregação (DSA 🔥)

### `counting()`

* Conta elementos do stream

```java
long total = stream.collect(Collectors.counting());
```

---

### `summingInt / summingLong / summingDouble`

* Soma valores

```java
Collectors.summingInt(User::getAge);
```

---

### ` averagingInt `
### `averagingLong `
### ` averagingDouble ` 

* Média de valores

```java
Collectors.averagingDouble(Product::getPrice);
```

---

### `maxBy()` / `minBy()`

* Retorna maior ou menor elemento
* **LeetCode:** máximo/mínimo com critério

```java
Collectors.maxBy(Comparator.comparingInt(User::getAge));
```

---

## 🔹 Grouping (ESSENCIAL)

### `groupingBy(classifier)`

* Agrupa elementos
* **Um dos mais importantes para LeetCode**

```java
Collectors.groupingBy(User::getCountry);
```

Resultado: `Map<Country, List<User>>`

---

### `groupingBy(classifier, downstream)`

* Agrupa + aplica outro collector

```java
Collectors.groupingBy(
  User::getCountry,
  Collectors.counting()
);
```

---

### `groupingBy(classifier, mapFactory, downstream)`

* Define tipo do Map (`TreeMap`, `LinkedHashMap`)
* **Profissional:** controle de ordenação

```java
Collectors.groupingBy(
  User::getCountry,
  TreeMap::new,
  Collectors.toList()
);
```

---

## 🔹 Partitioning (variação de grouping)

### `partitioningBy(predicate)`

* Divide em `true` e `false`
* **LeetCode:** separar pares/ímpares, válidos/inválidos

```java
Collectors.partitioningBy(x -> x % 2 == 0);
```

Resultado: `Map<Boolean, List<T>>`

---

### `partitioningBy(predicate, downstream)`

```java
Collectors.partitioningBy(
  x -> x > 0,
  Collectors.counting()
);
```

---

## 🔹 Strings e Joining

### `joining()`

* Junta Strings

```java
Collectors.joining();
```

---

### `joining(delimiter)`

```java
Collectors.joining(", ");
```

---

### `joining(delimiter, prefix, suffix)`

* **Muito usado em logs e APIs**

```java
Collectors.joining(", ", "[", "]");
```

---

## 🔹 Mapping e Transformações

### `mapping(mapper, downstream)`

* Transforma antes de coletar

```java
Collectors.mapping(User::getName, Collectors.toList());
```

---

### `flatMapping(mapper, downstream)` *(Java 9+)*

* Achata streams internos
* **LeetCode:** listas dentro de listas

```java
Collectors.flatMapping(
  user -> user.getRoles().stream(),
  Collectors.toSet()
);
```

---

## 🔹 Estatísticas (DSA e performance)

### `summarizingInt / Long / Double`

* Retorna min, max, média, soma e count

```java
IntSummaryStatistics stats =
  stream.collect(Collectors.summarizingInt(User::getAge));
```

---

## 🔹 Collectors Customizados

### `collectingAndThen(downstream, finisher)`

* Aplica transformação final

```java
Collectors.collectingAndThen(
  Collectors.toList(),
  Collections::unmodifiableList
);
```

---

### `reducing()`

* Redução manual
* **LeetCode:** soma, produto, concatenação

```java
Collectors.reducing(Integer::sum);
```

---

## 🔹 TOP 10 para LeetCode / DSA 🚀

1. `toList()`
2. `toMap()` (com merge)
3. `groupingBy()`
4. `partitioningBy()`
5. `counting()`
6. `mapping()`
7. `flatMapping()`
8. `summarizingInt()`
9. `maxBy()` / `minBy()`
10. `joining()`

---

## 🔹 Dica prática

> Se você domina **groupingBy + toMap + mergeFunction**, você resolve **80% dos problemas de Stream em entrevistas**.

---

Se quiser, posso:

* adicionar **exemplos reais de LeetCode**
* criar uma **tabela-resumo rápida**
* ou adaptar isso para **Java 8 only**

