--- quero descobrirr quais pessoas tem um cartao de credito registrado
SELECT *
FROM Person.Person PP
INNER JOIN Sales.PersonCreditCard PC
ON PP.BusinessEntityID = PC.BusinessEntityID
--- INNER JOIN RETORNA : 19118
--- LEFT JOIN RETORNA : 19972 - Ele retornar todos q estão na esquerda até os que estão null

SELECT 19972 - 19118  as "Nao tem cartao registrado"


