# NotNullConstraint
Se utiliza quando a tabela precisa ser prenchida, ou seja é uma resticao que força a inserir dados na tabela 
## Sintaxe
````
CREATE TABLE CarteiraDeMotorista(
Id int NOT NULL;
Nome varchar(255) NOT NULL, 
Idade int CHECK (Idade >= 18)
)
````
Precisa ter o id sempre preenchido, e para ter o 
id preenchido o nome precisa estar prrenchido 
então fazemos do jeito que estava
