# Finding & Matching em Java (Streams)

1️⃣ O que é Finding (buscar)

São métodos usados para encontrar elementos dentro de uma stream.

🔹 findFirst()

➡️ Retorna o primeiro elemento que aparecer na stream.
````
List<Integer> numeros = List.of(10, 20, 30, 40);

Optional<Integer> primeiro = numeros.stream()
.findFirst();

System.out.println(primeiro.get()); // 10
````
🔹 findAny()

➡️ Retorna qualquer elemento da stream.
````
Optional<Integer> qualquer = numeros.stream()
.findAny();
````

📌 Em listas normais, quase sempre retorna o primeiro.
📌 Em streams paralelas, pode retornar qualquer um (é mais rápido).

🔹 Usando filter + findFirst

Aqui sim você procura algo específico:
````
Optional<Integer> maiorQue25 = numeros.stream()
.filter(n -> n > 25)
.findFirst();

System.out.println(maiorQue25.get()); // 30
````

💡 Mentalmente:

“Percorre a stream → filtra → para quando achar o primeiro que bate”

2️⃣ O que é Matching (verificar condições)
São métodos usados para verificar se os elementos da stream atendem a certas condições.
🔹 anyMatch()
````
boolean temMaiorQue30 = numeros.stream()
.anyMatch(n -> n > 30);

System.out.println(temMaiorQue30); // true
````
🔹 allMatch()

➡️ Todos os elementos atendem a condição?
````
boolean todosPositivos = numeros.stream()
.allMatch(n -> n > 0);

System.out.println(todosPositivos); // true
````

🧠

“Todo mundo passa nessa regra?”

🔹 noneMatch()

➡️ Nenhum elemento atende a condição?
````
boolean nenhumNegativo = numeros.stream()
.noneMatch(n -> n < 0);

System.out.println(nenhumNegativo); // true
````

🧠

“Ninguém pode quebrar essa regra”

3️⃣ Comparação mental (bem simples)

Método	O que responde

findFirst()	Me dá o primeiro elemento

findAny()	Me dá qualquer elemento

anyMatch()	Existe pelo menos um?

allMatch()	Todos satisfazem?

noneMatch()	Nenhum satisfaz?

4️⃣ Exemplo REAL (uso profissional)

🔹 Verificar se um usuário existe
````
boolean existeAdmin = usuarios.stream()
.anyMatch(u -> u.getRole().equals("ADMIN"));
````
🔹 Buscar um produto pelo ID
````
Optional<Produto> produto = produtos.stream()
.filter(p -> p.getId() == 10)
.findFirst();
````

🔹 Verificar se todos os pedidos estão pagos
````
boolean todosPagos = pedidos.stream()
.allMatch(p -> p.isPago());
````

5️⃣ Diferença IMPORTANTE

❌ Errado
````
stream.forEach(...)

````

👉 percorre tudo sempre

✅ Certo
````
stream.anyMatch(...)
````

👉 para na primeira resposta válida


 📌 Finding e Matching são mais performáticos, porque encerram a stream antes.

6️⃣ Resumo em 1 frase

Finding → “me devolve um elemento”

Matching → “me devolve true ou false”