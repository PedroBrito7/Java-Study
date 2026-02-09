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

