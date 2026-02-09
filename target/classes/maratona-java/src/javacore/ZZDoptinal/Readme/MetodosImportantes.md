# Pra que serve
Se usa o Optional para evitar nulls e tornar o código mais seguro e expressivo.
Quando voce sabe que um valor pode estar ausente, o Optional é uma ótima escolha.
ex: passar String nome, ele pode ser null, então voce usa Optional<String> nomeOpt.(leia se os exercicios anteriores nao estiverem claros)


# Métodos principais do Optional (o essencial)

🔹 of(valor)

Use quando o valor NUNCA pode ser null.

Optional.of("Pedro");

🔹 ofNullable(valor)
Use quando o valor PODE ser null.

Java

Optional.ofNullable(nome);

🔹 isPresent()

Pergunta: Tem valor? Retorna um booleano.

Java

if (opt.isPresent()) { ... }

⚠️ Nota: Pouco recomendado hoje em favor de abordagens funcionais.



🔹 ifPresent()
Executa uma ação (Consumer) apenas se existir um valor.

Java

opt.ifPresent(v -> System.out.println(v));

🔹 orElse()
Retorna o valor contido ou um valor padrão fixo.

Java

opt.orElse("padrão");

🔹 orElseGet()

Retorna o valor ou executa uma lógica/função para gerar o padrão.

Java

opt.orElseGet(() -> gerarValor());

🔹 orElseThrow()

Lança uma exceção caso o valor não exista (falha controlada).

Java

opt.orElseThrow();

🔹 map()

Transforma o valor interno se ele existir.

Java

opt.map(v -> v.toUpperCase());

🔹 filter()
Aplica uma condição. Se não atender, o Optional fica vazio.

Java

opt.filter(v -> v.length() > 3);