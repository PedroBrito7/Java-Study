# Java Streams – Guia Prático

## O que são Streams em Java?

Streams em Java são uma **API introduzida no Java 8** que permite processar coleções de dados (List, Set, Map, etc.) de forma **funcional, declarativa e eficiente**.

Eles **não armazenam dados**, apenas **processam** dados de uma fonte (coleções, arrays, arquivos, etc.).

> Pense em Stream como uma *linha de produção*: os dados passam por várias etapas até gerar um resultado final.

---

## Características principais

* Não modificam a coleção original
* Avaliação preguiçosa (*lazy evaluation*)
* Código mais limpo e legível
* Facilitam operações como filtro, transformação e agregação
* Podem ser sequenciais ou paralelos

---

## Como criar uma Stream

```java
List<Integer> numeros = List.of(1, 2, 3, 4, 5);
Stream<Integer> stream = numeros.stream();
```

Outras formas:

```java
Stream.of(1, 2, 3);
Arrays.stream(array);
```

---

## Tipos de operações em Streams

As operações se dividem em **intermediárias** e **terminais**.

### Operações Intermediárias

* Retornam uma nova Stream
* Não executam nada sozinhas
* São encadeáveis

Exemplo:

```java
stream.filter(n -> n > 3)
      .map(n -> n * 2);
```

### Operações Terminais

* Encerram a Stream
* Produzem um resultado ou efeito colateral

Exemplo:

```java
stream.forEach(System.out::println);
```

---

## Principais métodos de Stream

### filter()

Filtra elementos com base em uma condição.

```java
numeros.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

**Use quando:** quiser selecionar apenas elementos específicos.

---

### map()

Transforma os elementos da Stream.

```java
numeros.stream()
       .map(n -> n * 2)
       .forEach(System.out::println);
```

**Use quando:** precisar converter ou modificar dados.

---

### flatMap()

Achata estruturas aninhadas.

```java
List<List<String>> listas = List.of(
    List.of("A", "B"),
    List.of("C", "D")
);

listas.stream()
      .flatMap(List::stream)
      .forEach(System.out::println);
```

**Use quando:** trabalhar com listas dentro de listas.

---

### sorted()

Ordena os elementos.

```java
numeros.stream()
       .sorted()
       .forEach(System.out::println);
```

Com Comparator:

```java
.sorted(Comparator.reverseOrder())
```

**Use quando:** precisar ordenar dados.

---

### distinct()

Remove elementos duplicados.

```java
numeros.stream()
       .distinct()
       .forEach(System.out::println);
```

**Use quando:** quiser eliminar repetições.

---

### limit() e skip()

Controlam a quantidade de elementos.

```java
numeros.stream()
       .limit(3)
       .forEach(System.out::println);
```

```java
numeros.stream()
       .skip(2)
       .forEach(System.out::println);
```

**Use quando:** trabalhar com paginação ou recortes.

---

## Métodos Terminais mais usados

### forEach()

Executa uma ação para cada elemento.

```java
numeros.stream().forEach(System.out::println);
```

---

### collect()

Transforma a Stream em uma coleção.

```java
List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
```

---

### findFirst() e findAny()

Retornam um `Optional`.

```java
Optional<Integer> primeiro = numeros.stream().findFirst();
```

---

### anyMatch(), allMatch(), noneMatch()

Verificações booleanas.

```java
boolean temPar = numeros.stream().anyMatch(n -> n % 2 == 0);
```

---

### count()

Conta elementos.

```java
long total = numeros.stream().count();
```

---

### reduce()

Reduz os elementos a um único valor.

```java
int soma = numeros.stream()
    .reduce(0, Integer::sum);
```

**Use quando:** precisar somar, multiplicar ou combinar valores.

---

## Quando usar Streams?

### Use Streams quando:

* Precisar de código mais limpo e expressivo
* Trabalhar com filtros, mapeamentos e agregações
* Evitar loops complexos
* Processar dados de forma funcional

### Evite Streams quando:

* A lógica for muito simples (um `for` é mais claro)
* Precisar de muitas modificações de estado
* Depuração passo a passo for essencial

---

## Exemplo completo

```java
List<String> nomes = List.of("Ana", "Bruno", "Carlos", "Amanda");

List<String> resultado = nomes.stream()
    .filter(n -> n.startsWith("A"))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

System.out.println(resultado);
```

---

## Conclusão

Streams tornam o código Java:

* Mais legível
* Mais declarativo
* Menos verboso

Elas são ideais para **processamento de dados**, especialmente em projetos modernos com Java 8+.
