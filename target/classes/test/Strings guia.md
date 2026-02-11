🔴 1. Comparação de Strings (MUITO importante)
equals() e equalsIgnoreCase()
String a = "admin";
String b = "ADMIN";

a.equals(b);              // false
a.equalsIgnoreCase(b);    // true


➡ Usado em login, permissões, validações, regras de negócio
❌ Nunca use == para comparar texto.

🔴 2. Verificação de conteúdo
isEmpty() e isBlank() (Java 11+)
String s1 = "";
String s2 = "   ";

s1.isEmpty(); // true
s2.isEmpty(); // false

s2.isBlank(); // true


➡ Usado em validação de formulário e API

if (nome == null || nome.isBlank()) {
throw new IllegalArgumentException("Nome obrigatório");
}

🔴 3. Verificar se contém algo
contains()
String email = "pedro@gmail.com";

email.contains("@"); // true


➡ Validação simples, filtros, buscas

🔴 4. Começa ou termina com
startsWith() / endsWith()
String arquivo = "foto.png";

arquivo.endsWith(".png"); // true


➡ Upload de arquivos, URLs, rotas, logs

🔴 5. Quebrar String (MUITO usado)
split()
String csv = "joao,20,SP";

String[] dados = csv.split(",");

dados[0]; // joao
dados[1]; // 20


➡ Leitura de CSV, parâmetros, tokens, parsing

🔴 6. Converter para número
Integer.parseInt() / Double.parseDouble()
String idade = "25";

int i = Integer.parseInt(idade);


➡ Entrada de usuário, APIs, banco de dados

🔴 7. Remover ou trocar padrões
replace() vs replaceAll()
String cpf = "123.456.789-00";

cpf.replace(".", "").replace("-", "");
// 12345678900

cpf.replaceAll("[^0-9]", "");


➡ Limpeza de dados (MUITO comum)

🔴 8. Converter para array de caracteres
toCharArray()
char[] letras = nome.toCharArray();


➡ Algoritmos, validações avançadas, DSA

🔴 9. Formatação de texto (produção real)
String.format()
String msg = String.format(
"Usuário %s tem %d anos",
"Pedro",
22
);


➡ Logs, respostas de API, mensagens

🔴 10. Performance: StringBuilder

⚠️ Essencial no trabalho

StringBuilder sb = new StringBuilder();
sb.append("Olá ");
sb.append(nome);
sb.append("!");

String resultado = sb.toString();


➡ Usado em loops, geração de texto grande, relatórios
❌ Evita concatenação com + em laços

🔴 11. Converter qualquer coisa em String
valueOf()
String s = String.valueOf(10);


➡ Evita NullPointerException

📌 Resumo — o que você PRECISA dominar

Você já sabe:

charAt

length

replace

toLowerCase / toUpperCase

substring

trim

👉 Adicione obrigatoriamente:

equals / equalsIgnoreCase

isEmpty / isBlank

contains

startsWith / endsWith

split

parseInt / parseDouble

replaceAll

StringBuilder

String.format