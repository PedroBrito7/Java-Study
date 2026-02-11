# Para enteder FlatMap 

primeiro entenda-se que map transforma um elemento em outro elemento, ou seja, 1 para 1. Já o flatMap transforma um elemento em uma Stream de elementos, ou seja, 1 para N.

ja o flatmap "achata" várias streams em uma única stream.

```java
List<List<String>> listasDeNomes = List.of(
    List.of("Ana", "Bia"),
    List.of("Carlos", "Daniel"),
    List.of("Eduardo", "Fabio")
);
List<String> nomes = listasDeNomes.stream()
    .flatMap(List::stream) // Transforma cada lista em uma stream e "achata" tudo em uma única stream
    .collect(Collectors.toList());
nomes.forEach(System.out::println);
```
**Use quando:** quiser transformar um elemento em múltiplos elementos e "achatar" várias streams em uma única stream.

Comparase com um array de arrays mentalmente porem com streams

---
Em palavras bem simples

map → troca uma coisa por outra

flatMap → abre, espalha e junta tudo

--- 

