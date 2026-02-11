🔹 Diferença entre Stream.iterate e Stream.generate

1️⃣ Stream.iterate

Conceito

Gera valores baseados no valor anterior

Existe uma lógica de progressão

Tem dependência de estado

Exemplo simples
````
Stream.iterate(1, n -> n + 1)
.limit(5)
.forEach(System.out::println);
````

Saída:
````
1
2
3
4
5
````

📌 Aqui:

Começa em 1

Cada próximo valor depende do anterior

Exemplo com números aleatórios (controle)
````
Stream.iterate(new Random(), r -> r)
.map(r -> r.nextInt(100))
.limit(5)
.forEach(System.out::println);
````

➡️ Ainda existe um objeto base sendo reutilizado.

2️⃣ Stream.generate → valores independentes (sem estado)
Conceito

Gera valores sem depender do anterior

Cada chamada é isolada

Usa um Supplier<T>

Exemplo simples
````
Stream.generate(() -> new Random().nextInt(100))
.limit(5)
.forEach(System.out::println);
````

📌 Aqui:

Cada número é gerado do zero

Não existe relação entre um valor e outro

🔹 Qual usar com RANDOM?

❌ Uso errado (comum em iniciantes)
````
Stream.iterate(0, n -> new Random().nextInt(100))
````

🚫 Não faz sentido:

Não usa o valor anterior

Perde a ideia do iterate

✅ Uso correto
````
Stream.generate(() -> random.nextInt(100))
````
🔹 Uso no mundo corporativo (sistemas reais)

Agora o que realmente importa 👇

🏦 Bancos / Fintechs
iterate

Usado quando existe sequência lógica:

✔ Parcelas:
````
Stream.iterate(1, n -> n + 1)
.limit(qtdParcelas)
````

✔ Datas:
````
Stream.iterate(dataInicial, d -> d.plusMonths(1))

````
✔ Tentativas de retry:
````
Stream.iterate(1, t -> t + 1)
.limit(3)
````

📌 Regra clara + previsibilidade

generate

Usado para valores independentes:

✔ Token de sessão:
````
Stream.generate(UUID::randomUUID)
.limit(1)
.findFirst();
````

✔ Massa de teste:
````
Stream.generate(() -> faker.name().firstName())
````

✔ Simulação de carga:
````
Stream.generate(() -> random.nextDouble())
````

📌 Sem relação entre os valores

🧪 Testes automatizados
Situação	Método
Dados sequenciais	iterate
Dados aleatórios	generate
⚠️ Atenção (erro comum em produção)

TANTO iterate QUANTO generate:

Criam streams infinitos

SEMPRE use:
````
.limit()
````

❌ Sem limit() = CPU 100% / travamento