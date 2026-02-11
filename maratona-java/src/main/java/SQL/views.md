# Views em SQL

## O que são Views?

Uma **View** é uma **tabela virtual** criada a partir de uma consulta (`SELECT`). Ela **não armazena dados fisicamente** (na maioria dos SGBDs), apenas guarda a consulta, exibindo os dados sempre atualizados conforme as tabelas base.

👉 Pense em uma view como um **atalho para uma consulta complexa**.

---

## Para que usar Views?

* Simplificar consultas complexas
* Reutilizar SQL sem repetir código
* Melhorar organização do banco
* Aumentar a segurança (expor apenas colunas necessárias)
* Facilitar relatórios e análises

---

## Sintaxe básica

```sql
CREATE VIEW vw_UsuariosAtivos AS
SELECT UsuarioId, Nome, Email
FROM Usuario
WHERE Ativo = 1;
```

Agora a view pode ser usada como uma tabela:

```sql
SELECT * FROM vw_UsuariosAtivos;
```

---

## View com JOIN

Views são muito usadas para esconder `JOINs` complexos.

```sql
CREATE VIEW vw_PedidosClientes AS
SELECT
    p.PedidoId,
    c.Nome AS Cliente,
    p.DataPedido,
    p.Total
FROM Pedido p
JOIN Cliente c ON p.ClienteId = c.ClienteId;
```

---

## View com agregações

```sql
CREATE VIEW vw_TotalPedidosPorCliente AS
SELECT
    ClienteId,
    COUNT(*) AS QuantidadePedidos,
    SUM(Total) AS ValorTotal
FROM Pedido
GROUP BY ClienteId;
```

---

## ALTER VIEW

Para alterar uma view existente:

```sql
ALTER VIEW vw_UsuariosAtivos AS
SELECT UsuarioId, Nome, Email, DataCadastro
FROM Usuario
WHERE Ativo = 1;
```

---

## DROP VIEW

Para remover uma view:

```sql
DROP VIEW vw_UsuariosAtivos;
```

---

## View é atualizada automaticamente?

✅ Sim. Como a view executa a consulta sempre que é chamada, os dados refletem **o estado atual das tabelas base**.

---

## Views podem receber INSERT, UPDATE e DELETE?

Depende da view:

✔️ Geralmente **funciona** quando:

* A view usa apenas **uma tabela**
* Não possui `GROUP BY`, `DISTINCT`, `JOIN`, `SUM`, `COUNT`

❌ Geralmente **não funciona** quando:

* Possui agregações
* Possui múltiplas tabelas
* Usa funções

---

## View x Tabela

| Tabela         | View                             |
| -------------- | -------------------------------- |
| Armazena dados | Não armazena dados               |
| Ocupa espaço   | Não ocupa (exceto materializada) |
| Dados fixos    | Dados sempre atualizados         |

---

## View x Stored Procedure

| View              | Stored Procedure         |
| ----------------- | ------------------------ |
| Retorna dados     | Pode retornar ou não     |
| Executa SELECT    | Pode ter lógica complexa |
| Usada como tabela | Executada com EXEC       |

---

## Views Materializadas (conceito)

Alguns bancos possuem **Views Materializadas**, que **armazenam o resultado da consulta** para melhorar performance.

📌 No SQL Server, o equivalente é a **Indexed View**.

---

## Boas práticas

* Use prefixo `vw_` para identificar views
* Evite `SELECT *`
* Use views para segurança e padronização
* Não coloque lógica de negócio pesada

---

## Quando usar Views?

Use views quando:

* Consultas forem repetidas muitas vezes
* Houver JOINs complexos
* Você quiser limitar acesso aos dados
* Criar relatórios e dashboards

---

## Conclusão

Views tornam o SQL **mais limpo, reutilizável e organizado**. Elas são ideais para abstrair complexidade, melhorar segurança e facilitar o uso do banco de dados, especialmente em sistemas maiores.

> Boa prática: se você escreve a mesma consulta várias vezes, transforme em uma view.
