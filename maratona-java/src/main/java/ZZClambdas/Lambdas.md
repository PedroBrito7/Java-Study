1️⃣ Lambdas (expressões lambda)
📌 O que são?

Lambdas são uma forma curta de escrever classes anônimas que implementam interfaces funcionais
(interface funcional = só 1 método abstrato).

👉 Antes do Java 8:

Runnable r = new Runnable() {
@Override
public void run() {
System.out.println("Rodando");
}
};


👉 Com lambda:

Runnable r = () -> System.out.println("Rodando");

📌 Estrutura de uma lambda
(parâmetros) -> { corpo }


Exemplos:

Sem parâmetros
() -> System.out.println("Olá");

Um parâmetro
nome -> System.out.println(nome);

Dois parâmetros
(a, b) -> a + b;

📌 Exemplo real com interface funcional
@FunctionalInterface
interface Calculadora {
int calcular(int a, int b);
}


Uso com lambda:

Calculadora soma = (a, b) -> a + b;
System.out.println(soma.calcular(2, 3)); // 5

📌 Lambdas com Collections
List<String> nomes = List.of("Pedro", "Ana", "João");

nomes.forEach(nome -> System.out.println(nome));

2️⃣ Method References
📌 O que são?

Method reference é uma forma ainda mais curta de escrever uma lambda
quando a lambda apenas chama um método existente.

👉 Regra de ouro:

Se a lambda só chama um método → dá pra usar method reference

📌 Comparação direta

Lambda:

nomes.forEach(nome -> System.out.println(nome));


Method reference:

nomes.forEach(System.out::println);

3️⃣ Tipos de Method Reference
🔹 1. Referência a método estático
Classe::metodoEstatico


Exemplo:

Integer.parseInt("10");

Function<String, Integer> f = Integer::parseInt;
System.out.println(f.apply("10"));

🔹 2. Referência a método de um objeto específico
objeto::metodo


Exemplo:

PrintStream out = System.out;
Consumer<String> c = out::println;

c.accept("Olá");

🔹 3. Referência a método de instância (genérico)
Classe::metodo


Exemplo:

List<String> nomes = List.of("ana", "pedro");

nomes.sort(String::compareToIgnoreCase);


👉 Aqui o Java entende que:

o primeiro elemento é o this

o segundo é o parâmetro

🔹 4. Referência a construtor
Classe::new


Exemplo:

Supplier<List<String>> lista = ArrayList::new;
List<String> l = lista.get();

4️⃣ Lambda vs Method Reference (quando usar)

✔ Use lambda quando:

Tem lógica dentro

Precisa de condição ou mais de uma linha

x -> {
if (x > 10) return x;
return 0;
}


✔ Use method reference quando:

Só chama um método

Quer código mais limpo

System.out::println

5️⃣ Resumo rápido (cola mental)

Lambda = função anônima curta

Method reference = lambda ainda mais curta

Só funcionam com interfaces funcionais

Muito usadas com Streams, Collections e APIs modernas