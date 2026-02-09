
# Comandos SQL - Resumo (Básico ao avançado)

## SELECT
Usado para selecionar dados de uma ou mais colunas de uma tabela.
```sql
SELECT nome, idade FROM usuarios;
```

## FROM
Define de qual tabela os dados serão buscados.
```sql
SELECT * FROM produtos;
```

## DISTINCT
Remove valores duplicados do resultado da consulta.
```sql
SELECT DISTINCT cidade FROM clientes;
```

## COUNT
Conta a quantidade de registros retornados.
```sql
SELECT COUNT(*) FROM pedidos;
```

## TOP / LIMIT
Limita a quantidade de registros retornados.
```sql
SELECT TOP 5 * FROM produtos;
-- MySQL/PostgreSQL
SELECT * FROM produtos LIMIT 5;
```

## ORDER BY
Ordena o resultado da consulta.
```sql
SELECT nome, preco FROM produtos ORDER BY preco DESC;
```

## BETWEEN
Filtra valores dentro de um intervalo.
```sql
SELECT * FROM vendas WHERE data_venda BETWEEN '2024-01-01' AND '2024-12-31';
```

## IN
Verifica se um valor corresponde a uma lista ou subconsulta.
```sql
SELECT * FROM clientes WHERE id IN (1, 3, 5);
```

## LIKE
Busca padrões em textos.
```sql
SELECT * FROM usuarios WHERE nome LIKE 'A%';
SELECT * FROM empresas WHERE nome LIKE '%tech%';
```

## Funções de Agregação
MIN, MAX, SUM, AVG retornam valores agregados.
```sql
SELECT MIN(preco), MAX(preco), AVG(preco) FROM produtos;
```

## GROUP BY
Agrupa registros para funções de agregação.
```sql
SELECT categoria, COUNT(*) FROM produtos GROUP BY categoria;
```

## HAVING
Filtra resultados após o agrupamento.
```sql
SELECT categoria, COUNT(*) 
FROM produtos 
GROUP BY categoria 
HAVING COUNT(*) > 5;
```

## JOIN
Usado para combinar dados de duas ou mais tabelas relacionadas por uma chave.

### INNER JOIN
Retorna apenas os registros que possuem correspondência em ambas as tabelas.
```sql
SELECT clientes.nome, pedidos.valor_total
FROM clientes
INNER JOIN pedidos ON clientes.id = pedidos.cliente_id;
```

### LEFT JOIN (LEFT OUTER JOIN)
Retorna todos os registros da tabela da esquerda e os correspondentes da direita.
Se nao houver registros correspondentes ele retorna null
```sql
SELECT clientes.nome, pedidos.valor_total
FROM clientes
LEFT JOIN pedidos ON clientes.id = pedidos.cliente_id;
```

### RIGHT JOIN (RIGHT OUTER JOIN)
Retorna todos os registros da tabela da direita e os correspondentes da esquerda.
```sql
SELECT clientes.nome, pedidos.valor_total
FROM clientes
RIGHT JOIN pedidos ON clientes.id = pedidos.cliente_id;
```

### FULL JOIN (FULL OUTER JOIN)
Retorna todos os registros quando houver correspondência em qualquer uma das tabelas.
Imagem dois circulos que se ligam e estao todos prenchidos. e se estiver vazio prenche com null
```sql
SELECT clientes.nome, pedidos.valor_total
FROM clientes
FULL JOIN pedidos ON clientes.id = pedidos.cliente_id;
```

### CROSS JOIN
Retorna o produto cartesiano entre as tabelas.

```sql
SELECT clientes.nome, produtos.nome
FROM clientes
CROSS JOIN produtos;
```

### SELF JOIN
Usado quando a tabela se relaciona com ela mesma.
Só usa self quando estar usando AS 
```
SELECT NOME_COLUNA 
FROM TABELA A, TABELA B
WHERE CONDICAO 
```
```sql
SELECT a.nome AS funcionario, b.nome AS gerente
FROM funcionarios a
LEFT JOIN funcionarios b ON a.gerente_id = b.id;
```
### OUTER JOIN 
```sql

```

## UNION
Usado para combinar dois ou mais resultados de um select em um resultado maior apenas.

estrutura:
```sql
SELECT coluna1, coluna2
FROM tabela1
UNION 
SELECT coluna1, coluna 2 
FROM tabela2
```
Precisa selecionar as mesmas quantidades de colunas, e o mesmo tipo de dado (string,int..)
exemplo coluna1 de cima e coluna 2 sao os mesmo da de baixo : string por exemplo. o union ele exclui as duplicatas, e junta tudo
excecao do union all (Mantém as duplicatas dos dados) usa-se em tabelas nao normalizadas (Incosistencia)

## SUBQUERY 
Usado para aninhar uma consulta dentro de outra e subselect é um select dentro de outro.

--- monte um relatório de todos os produtos cadastrados que tem preço de venda acima da média
Fazendo do jeito antigo (sem subquery)
```sql
SLECT AVG (ListPrice) * 
FROM Production.Product

select *
FROM Production.Product
where listprice > 437.66
```
Fazendo com subselect
```sql
SELECT *
FROM Production.Product
WHERE listprice > (SELECE AVG(ListPrice) from Production.Product)
```

--- agora quero saber o nome dos funcionario q tem o cargo de desing engineer
sem subquery
```sql
SELECT *
FROM Person.Person
WHERE BusinessEntityID in (5,6,15) --- so é bom usar o dado assim quando ele for imutavel

SELECT *
FROM HumanResources.Employee
WHERE JobTitle = 'Design Engineer'
``` 
Com Subquery
```
SELECT FirstName
From Person.Person 
WHERE BusinessEntityID IN (
SELECT BusinessEntityID FROM HumanResources.Employee 
WHERE JobTitle = 'Design Engineer')
```

## DatePart 
https://learn.microsoft.com/en-us/sql/t-sql/functions/datepart-transact-sql?view=sql-server-ver17

Usado para extrair uma parte específica de uma date
```
SELECT AVG(TotalDue) Media,DATEPART(year,OrderDate) as Mes
FROM Sales.SalesOrderHeader 
GROUP BY  DATEPART(year,OrderDate ) 
-- Sempre que fazer datepart  ou qualquer funcao de agregar (avg,sum), tem que ser feito o agrupamento 
ORDER BY Mes
```
Poderia trocar o year por month, day, hour, minutes etc..

## Manipulação De Strings 
https://learn.microsoft.com/en-us/sql/t-sql/functions/string-functions-transact-sql?view=sql-server-ver17

### CONCAT
Usado para concatenar strings 
```
SELECT CONCAT(FirstName,' ', LastName ) 
FROM Person.Person 
```
-- Literalmente só junta | adicionando as ' ' ele cria o espaço que nao tinha entre First e Last Name

### UPPER / LOWER 
Deixa tudo maiusculo ou minusculo 
```
SELECT UPPER(FirstName), LOWER(LastName)
FROM Person.Person 
```
### LEN
Igual o lenght em java, Conta quantas string tem 
```
SELECT LEN(FirstName) AS TamanhoNome
FROM Person.Person
```
### Substring 
Extrair um pedaço dentro de uma string
```
SELECT FirstName,SUBSTRING (FirstName, 1, 3)
FROM Person.Person
```
Percorreu desde do 1 até o 3 (Retornou as 3 primeira letra)

### Replace

Ele Substitui o item.
segue a estrutura: 

qual coluna ele vai pegar = ProductNumber -> Qual item ele vai replace = '-' ? -> e qual vai colocar no lugar da antiga = "#"? 
```
Select replace(ProductNumber,'-', '#')
FROM Production.Product
```
### Funções Matemáticas
Busca quando precisar, essas são as mais comuns, 
pórem pesquisar sempre: Functions mathematics in sql 

```
SELECT AVG(LineTotal)
FROM Sales.SalesOrderDetail
```
média

---

```
SELECT SUM(LineTotal)
FROM Sales.SalesOrderDetail
```
Soma

---
```
SELECT MIN(LineTotal)
FROM Sales.SalesOrderDetail
```
Valor Minimo

---
```
SELECT MAX(LineTotal)
FROM Sales.SalesOrderDetail
```
Valor maximo

---
```
SELECT ROUND(LineTotal,2) 
FROM Sales.SalesOrderDetail
```
Arredondamento pra x

---
```
SELECT SQRT(LineTotal,2) 
FROM Sales.SalesOrderDetail
```
Raiz quadrada dos valores 




## Tipos De dados
### 1- Boleanos:
(bit em sql 
0 e 1 )


### 2 - Caracteres:
(Char em sql)
Permite inserir até uma quantidade 
fixa de caracteres e sempre ocupa 
todo o espaço reservado 10/50

Os tamanhos podem ser variaveis e recebem o nome 
#### Varchar ou nvarchar 
q permite inserir uma quantidade que for definida, porem so usa o espaco que for prenchido
Ex: Definiu tamanho pra 35 e vc usou so 10, oq vai contar é so o tamanho 10


### 3 - Numbers
#### Tinyint
Nao tem parte do valor fracionado é somente 1,123331 etc...
#### SMALLINT 
Mesma coisa porem limite maior
#### INT
Mesma coisa porem limite maior
#### BIGINT
Mesma coisa porem limite maior
#### Numeric ou decimal
Valores exatos, porem permite ter parte fracionados -ex: Numeric (5,2)


### 4 - Temporais
https://learn.microsoft.com/pt-br/sql/relational-databases/tables/temporal-tables?view=sql-server-ver16

## Chave Primária and FK 
 Uma chave primária em SQL é um campo ou conjunto de campos em uma tabela que identifica de forma única e exclusiva cada registro (linha) da tabela.  Ela é essencial para garantir a integridade dos dados e facilitar relacionamentos entre tabelas.

#### Características principais:
Não permite valores nulos (NOT NULL).
#### Garante unicidade: 
nenhum valor ou combinação de valores pode se repetir.
Existe apenas uma chave primária por tabela.
Pode ser composta por mais de uma coluna (chave primária composta), desde que a combinação seja única.

### Chave Primária Para criar se usa: 
``` 
CREATE TABLE nome_tabela(
nomeColuna TipoDeDado PRIMARY KEY
nomeColuna tipoDeDado ...
)
```
### Chave Estrangeira (FK) : 
Uma chave estrangeira (foreign key) em SQL é um campo ou conjunto de campos em uma tabela que faz referência à chave primária de outra tabela, criando uma ligação entre elas.  Sua principal função é garantir a integridade referencial dos dados, assegurando que os valores armazenados na tabela de chave estrangeira correspondam a registros existentes na tabela referenciada.

#### Objetivo: 
Estabelecer relações entre tabelas para manter a consistência dos dados.
#### Funcionamento: 
Impede que sejam inseridos valores que não existam na tabela referenciada e controla operações de exclusão e atualização (como CASCADE, SET NULL, etc.).
#### Exemplo prático: 
Na tabela Pedidos, a coluna ClienteID pode ser uma chave estrangeira que referencia a ClienteID da tabela Clientes, garantindo que cada pedido esteja associado a um cliente válido. 
### Chave Estrangeira (FK) Para criar se usa:
``` 
CREATE TABLE nome_tabela(
nomeColuna TipoDeDado PRIMARY KEY
nomeColuna tipoDeDado ...
)
```
## Create Table 
Para criar segue a sintaxe:
``` 
CREATE TABLE nomeTabela(
coluna1 tipo resticaoDaColuna,
coluna1 tipo,
coluna1 tipo,
...
);
``` 
### Mas oq é restrições:
são regras aplicadas a colunas específicas de uma tabela para garantir a integridade, precisão e consistência dos dados.

-- As **principais** restrições de coluna incluem:

### NOT NULL: 
Garante que a coluna não aceite valores nulos. Exemplo: nome VARCHAR(50) NOT NULL.
### UNIQUE: 
Assegura que todos os valores em uma coluna sejam diferentes. Permite um único valor nulo (em bancos como PostgreSQL e SQL Server). Exemplo: email VARCHAR(100) UNIQUE.
### PRIMARY KEY: 
Identifica exclusivamente cada linha da tabela. Combina as restrições NOT NULL e UNIQUE.  Exemplo: id INT PRIMARY KEY.
### DEFAULT: 
Define um valor padrão para a coluna caso nenhum valor seja fornecido durante a inserção. Exemplo: ativo BOOLEAN DEFAULT TRUE.
### CHECK: 
Impõe uma condição específica que os valores devem atender. Exemplo: idade INT CHECK (idade >= 18).

# Insert into 
O comando INSERT INTO no SQL é utilizado para adicionar novos registros (linhas) em uma tabela de banco de dados.  Ele permite inserir dados em todas as colunas ou apenas em colunas específicas, dependendo da necessidade.

## Sintaxe Básica
Para inserir valores em colunas específicas:
``` 
INSERT INTO tabela (coluna1, coluna2, ...) 
VALUES (valor1, valor2, ...);
``` 
Para inserir valores em todas as colunas (na ordem em que foram definidas):
```  INSERT INTO tabela 
VALUES (valor1, valor2, ...);
``` 
## Exemplos Práticos
USADO NA AULA MINUTO 3:17:10
``` 
INSERT INTO aula(id, nome)
VALUES (1,'AULA1')  -- insere o valor insert into, o values é os valores do parametro id = 1 nome = aula1

SELECT * FROM aula
``` 

Inserir um único registro:
``` 
INSERT INTO clientes (nome, email, cidade)
 VALUES ('Ana Silva', 'ana@email.com', 'São Paulo');
 ``` 

Inserir múltiplos registros de uma vez:
``` 
INSERT INTO clientes (nome, email, cidade)
VALUES
('João Oliveira', 'joao@email.com', 'Rio de Janeiro'),
('Maria Santos', 'maria@email.com', 'Belo Horizonte');
``` 

Inserir dados de uma tabela para outra usando SELECT:
``` 
INSERT INTO tabela_destino (coluna1, coluna2)
SELECT coluna1, coluna2 FROM tabela_origem;
``` 

## Regras Importantes

O número de valores deve corresponder ao número de colunas especificadas.
Os tipos de dados dos valores devem ser compatíveis com os tipos das colunas.
Valores de strings devem estar entre aspas simples (').
Restrições como NOT NULL, PRIMARY KEY ou UNIQUE devem ser respeitadas para evitar erros.
Este comando é essencial para popular tabelas com dados iniciais ou migrar informações entre estruturas de banco de dados. 

