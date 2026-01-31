
# Comandos SQL - Resumo

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
```sql
SELECT a.nome AS funcionario, b.nome AS gerente
FROM funcionarios a
LEFT JOIN funcionarios b ON a.gerente_id = b.id;
```