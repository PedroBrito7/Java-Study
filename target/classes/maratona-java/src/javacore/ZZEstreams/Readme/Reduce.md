# O que é reduce?

 reduce serve para transformar vários valores de uma stream em um único valor final.

Pensa assim:

- Você tem vários elementos

- Aplica uma regra de combinação

- No final sobra apenas um resultado

📌 Exemplos de resultado final:

- uma soma

- um produto

- o maior número

- uma concatenação de strings

- um objeto agregado

- Ideia mental (bem simples)

- Imagine uma lista:

[1, 2, 3, 4]


- Usando reduce, o Java faz algo como:
````
1 + 2 = 3
3 + 3 = 6
6 + 4 = 10
````

➡ Resultado final: 10

Ou seja:

reduce é como ir “juntando” os elementos, um por um, até sobrar só um.

Forma geral do reduce

A mais comum é:
````
reduce(identidade, acumulador)
````

Identidade

É o valor inicial

Deve ser neutro para a operação

Exemplos:

Soma → 0

Multiplicação → 1

String → ""

Acumulador

É a regra de combinação

Recebe dois valores:

o acumulado até agora

o próximo elemento da stream

Exemplo básico: soma
````
int soma = lista.stream()
.reduce(0, (acumulado, valor) -> acumulado + valor);
````

O que acontece internamente:

- Começa com acumulado = 0

- Soma com o primeiro valor

- O resultado vira o novo acumulado

- Repete até acabar a stream

- Pensando como um for

- Esse código com reduce:
````
lista.stream().reduce(0, Integer::sum);
````

É mentalmente igual a:
````
int acumulado = 0;
for (int valor : lista) {
acumulado += valor;
}
````

📌 Essa comparação é muito importante
reduce é a versão funcional desse for.

- Reduce sem identidade (retorna Optional)
````
Optional<Integer> soma = lista.stream()
.reduce((a, b) -> a + b);
````
Por que Optional?

Porque:

A lista pode estar vazia

Não existe valor inicial garantido

📌 Use essa forma quando não existe um valor neutro claro.

Exemplo real: maior número
````
Optional<Integer> maior = lista.stream()
.reduce(Integer::max);
````

Fluxo mental:

compara 2 números → guarda o maior → compara com o próximo → ...

Exemplo com String (concatenação)
````
String frase = palavras.stream()
.reduce("", (acc, palavra) -> acc + palavra + " ");
````

📌 Junta várias strings em uma só.

Reduce com objetos (conceito importante)
````
double total = pedidos.stream()
.map(Pedido::getValor)
.reduce(0.0, Double::sum);
````

Fluxo:

Converte objetos em valores

Reduz tudo para um número final

# Quando usar reduce?

Use reduce quando:

✅ Você quer um único resultado final

✅ Esse resultado depende de todos os elementos

✅ Existe uma regra clara de combinação

🚫 Não use reduce quando:

Dá pra usar sum(), count(), max() (são mais claros)

Você quer alterar objetos (Streams são imutáveis)

Frase-chave para gravar

reduce pega muitos valores e reduz tudo a um só, aplicando uma regra repetidamente.