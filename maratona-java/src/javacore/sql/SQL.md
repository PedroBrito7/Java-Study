
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