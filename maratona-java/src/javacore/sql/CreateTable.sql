CREATE TABLE nomeTabela(
coluna1 tipo resticaoDaColuna,
coluna1 tipo,
coluna1 tipo,
...
);
-- As principais restrições de coluna incluem:

   NOT NULL: Garante que a coluna não aceite valores nulos. Exemplo: nome VARCHAR(50) NOT NULL.
   UNIQUE: Assegura que todos os valores em uma coluna sejam diferentes. Permite um único valor nulo (em bancos como PostgreSQL e SQL Server). Exemplo: email VARCHAR(100) UNIQUE.
   PRIMARY KEY: Identifica exclusivamente cada linha da tabela. Combina as restrições NOT NULL e UNIQUE.  Exemplo: id INT PRIMARY KEY.
   DEFAULT: Define um valor padrão para a coluna caso nenhum valor seja fornecido durante a inserção. Exemplo: ativo BOOLEAN DEFAULT TRUE.
   CHECK: Impõe uma condição específica que os valores devem atender. Exemplo: idade INT CHECK (idade >= 18).