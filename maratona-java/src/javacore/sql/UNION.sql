--Exemplo Prático:
--Suponha que você tenha duas tabelas: professores e coordenadores,
--ambas com a coluna nome. Para obter uma lista única de todos os nomes, use:
SELECT nome FROM professores
UNION
SELECT nome FROM coordenadores;

--Requisitos para usar UNION:
--As consultas devem ter o mesmo número de colunas.
--As colunas correspondentes devem ter tipos de dados compatíveis.
--A ordem das colunas deve ser a mesma nas consultas.

--Diferença entre UNION e UNION ALL:
--UNION: Elimina duplicatas (recomendado quando você quer resultados únicos).
--UNION ALL: Inclui todas as linhas, mesmo as duplicadas
--(mais rápido, pois não faz verificação de duplicidade).
--Exemplo com UNION ALL:

SELECT nome FROM professores
UNION ALL
SELECT nome FROM coordenadores;

--Exemplo com múltiplas tabelas:
--Se você tem cursos de pós-graduação, graduação e aperfeiçoamento,
--pode unir todos os nomes de cursos:

SELECT nome FROM curso_pos
UNION
SELECT nome FROM curso_graduacao
UNION
SELECT nome FROM curso_aperfeicoamento;

--Este comando retorna todos os nomes de cursos sem repetições.


--Exemplo real
SELECT [ProductID], [Name], [ProductNumber] FROM
Production.Product WHERE name like '%Chain%'
UNION
SELECT [ProductID], [Name], [ProductNumber] FROM
Production.Product WHERE Name like '%Decal%'

-- 1 antes do union -- selecionando col Productid name e product
--number da tabela x, e vai retornar tudo que se parecee com chain alguma coisa

-- pos union ocorre mesma coisa, o resultado aparece os dois resultados
