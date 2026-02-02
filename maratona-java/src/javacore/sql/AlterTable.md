# Alter Table 
Alterar estruturas de tabelas

## Sintaxe
```
ALTER TABLE NomeTabela
acao
 ```
## Examples
-- add, removerm or alter col
-- Set valors, default for col
-- add or remove restrictions of col
-- rename one table 

``` 
CREATE TABLE youtube(
id int primary key,
nome varchar (150) not null unique,
categoria varchar (200) not NULL ,
dataCriacao dateTime not null
);

ALTER TABLE youtube
ALTER COLUMN categoria varchar (300) not null
Select * from youtube
```
### Alterar nome da coluna 
```
EXEC sp_RENAME 'nomeTabela.nomeColunaATUAL','nomeColunaNova', 'COLUMN'
``` 
### Exemplo real : 
```
EXEC sp_RENAME 'youtube.nome', 'nomeCanal', 'COLUMN'

select * from youtube
```
### Alterar nome da tabela
```
EXEC sp_RENAME 'nomeTabelaAtual','nomeTabelaNova'
``` 
### Exemplo real :
```
EXEC sp_RENAME 'youtube', 'Youtube2'

select * from youtube2
```