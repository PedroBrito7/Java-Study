
# ResultSetMetaData
ResultSetMetaData é uma interface do JDBC que fornece informações sobre as colunas do resultado de uma consulta SQL.
## Quando usar
Trabalhando com sistemas que tem mt relatorio, 
precisa fazer varios selects e querys, e no final muitas colunas terao que ser prenchidas dentro do db
utilizar o ResultSetMetaData é uma boa forme de descobrir 

### Utilizacao 
Criar algo dinâmico (ex: imprimir qualquer tabela)

````
public static void printQuery(String sql) throws SQLException {
    try (Connection conn = ConnectionFactory.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        ResultSetMetaData meta = rs.getMetaData();
        int columns = meta.getColumnCount();

        while (rs.next()) {
            for (int i = 1; i <= columns; i++) {
                System.out.print(meta.getColumnName(i) + ": ");
                System.out.print(rs.getObject(i) + " | ");
            }
            System.out.println();
        }
    }
}
````
####  Criar exportação para CSV ou Excel

-Exportar relatórios

-Gerar planilhas automáticas

-Criar relatórios genéricos

#### Construir um mini-ORM manual

#### Ferramentas administrativas

-Sistemas internos usam para:

-Mostrar estrutura do banco

-Criar painéis administrativos

-Criar sistemas tipo phpMyAdmin

# Existem tipos de result set
Quando você faz um SELECT, o banco devolve um ResultSet.

O tipo define como você pode navegar e como ele reage a alterações no banco.


## TYPE_FORWARD_ONLY

- Só anda pra frente.
````
ResultSet.TYPE_FORWARD_ONLY
````
Como funciona:

Você só pode usar next(), Não pode usar previous(), Não pode voltar pro começo

- Na prática (vida real)

É o tipo mais usado em APIs REST.

Exemplo:
````
SELECT * FROM users;
````

Você só vai:

- Ler

- Converter em objeto

- Retornar no JSON

- Você não precisa voltar nem atualizar nada.

✔ Mais leve
✔ Mais rápido
✔ Melhor performance

É o padrão da maioria dos drivers.

##  TYPE_SCROLL_INSENSITIVE

- Pode ir pra frente e pra trás
Mas NÃO enxerga mudanças feitas depois da consulta

ResultSet.TYPE_SCROLL_INSENSITIVE

Você pode usar:

next()

previous()

first()

last()

absolute(5)

- Na prática

Imagina um sistema desktop antigo (tipo ERP Java Swing).

Você carrega uma tabela inteira:
`````
SELECT * FROM products;
`````
E o usuário pode:

Clicar "próximo"

Clicar "anterior"

Voltar pro início

Mas…

Se outra pessoa alterar o produto no banco,
esse ResultSet não vai atualizar sozinho.

Ele é uma “foto congelada”.

## TYPE_SCROLL_SENSITIVE

👉 Pode ir pra frente e pra trás

👉 E enxerga alterações feitas por outras conexões
`````
ResultSet.TYPE_SCROLL_SENSITIVE
`````
💡 Na prática

Teoricamente:
Se outro usuário atualizar um registro enquanto você está navegando,
o ResultSet mostraria a alteração.

🚨 Mas aqui vem a realidade:

⚠ Quase nenhum driver implementa isso direito.

⚠ Muitos bancos ignoram e tratam como INSENSITIVE.

⚠ É pesado.

### ⚠ Raramente usado.

Hoje em dia praticamente ninguém usa isso em APIs modernas.

## E sobre CONCUR_UPDATABLE?



Isso permite fazer:

resultSet.updateString("name", "Pedro");
resultSet.updateRow();


Ou seja: atualizar direto pelo ResultSet.

💡 Vida real:

❌ Quase ninguém usa isso.
✔ É muito mais comum usar:

UPDATE table SET name = ? WHERE id = ?


Ou usar:

Spring Data JPA

Hibernate

Query normal

🏆 O que realmente se usa hoje (mercado)

Em projetos modernos (Spring Boot, APIs REST, microserviços):

✔ TYPE_FORWARD_ONLY
✔ CONCUR_READ_ONLY

Porque:

Você só consulta

Converte em DTO

Retorna no JSON

Fecha conexão

Simples e performático.

🧠 Quando isso faz diferença?

Só quando você trabalha com:

JDBC puro

Sistemas desktop antigos

Grandes volumes de dados

Processamento batch

Em API REST comum?
Você quase nunca mexe nisso.

🎯 Resumo direto pra entrevista

Se alguém perguntar:

Qual a diferença entre TYPE_SCROLL_INSENSITIVE e SENSITIVE?

Você responde:

INSENSITIVE não reflete alterações feitas após a consulta.
SENSITIVE tenta refletir alterações, mas raramente é implementado corretamente pelos drivers.

---
