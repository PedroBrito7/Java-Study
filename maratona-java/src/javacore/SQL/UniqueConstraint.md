# UNIQUE Constraint em SQL

## O que é o UNIQUE Constraint?

O **UNIQUE Constraint** é uma restrição usada em SQL para garantir que os valores de uma coluna (ou conjunto de colunas) **não se repitam** dentro de uma tabela. Ele é muito utilizado para evitar duplicidade de dados, como e-mails, CPF, usernames ou códigos únicos.

Em outras palavras: **nenhuma linha pode ter o mesmo valor que outra na coluna marcada como UNIQUE**.

---

## Por que usar UNIQUE?

* Garante **integridade dos dados**
* Evita **registros duplicados**
* Facilita validações no banco, sem depender apenas da aplicação
* Melhora a organização e confiabilidade do sistema

---

## Sintaxe básica

```sql
CREATE TABLE Usuario (
    UsuarioId INT PRIMARY KEY,
    Email VARCHAR(150) UNIQUE
);
```

Nesse exemplo, dois usuários **não podem ter o mesmo e-mail**.

---

## UNIQUE em múltiplas colunas

Também é possível criar um UNIQUE que funcione com **mais de uma coluna**, garantindo que a combinação entre elas seja única.

```sql
CREATE TABLE Matricula (
    AlunoId INT,
    CursoId INT,
    CONSTRAINT UQ_AlunoCurso UNIQUE (AlunoId, CursoId)
);
```

➡️ Aqui, um aluno pode estar em vários cursos, mas **não pode se matricular duas vezes no mesmo curso**.

---

## UNIQUE no CREATE TABLE

```sql
CREATE TABLE Produto (
    ProdutoId INT PRIMARY KEY,
    Codigo VARCHAR(50),
    CONSTRAINT UQ_CodigoProduto UNIQUE (Codigo)
);
```

Usar `CONSTRAINT` permite dar um **nome** à restrição, facilitando manutenção e remoção.

---

## UNIQUE com ALTER TABLE

Caso a tabela já exista, você pode adicionar o UNIQUE depois:

```sql
ALTER TABLE Cliente
ADD CONSTRAINT UQ_EmailCliente UNIQUE (Email);
```

---

## UNIQUE x PRIMARY KEY

| PRIMARY KEY           | UNIQUE                              |
| --------------------- | ----------------------------------- |
| Não aceita NULL       | Pode aceitar NULL (depende do SGBD) |
| Apenas uma por tabela | Pode haver várias                   |
| Identifica o registro | Garante apenas unicidade            |

⚠️ Uma tabela pode ter **vários UNIQUE**, mas apenas **uma PRIMARY KEY**.

---

## UNIQUE aceita NULL?

Depende do banco de dados:

* **SQL Server**: permite apenas **um NULL**
* **MySQL**: permite vários NULL
* **PostgreSQL**: permite vários NULL

---

## Quando usar UNIQUE?

Use UNIQUE quando:

* O campo precisa ser único, mas **não é chave primária**
* Você quer evitar duplicidade de dados críticos
* A identificação principal já é outra coluna

Exemplos comuns:

* Email
* CPF
* Username
* Código de produto

---

## Conclusão

O **UNIQUE Constraint** é essencial para manter a integridade e confiabilidade dos dados. Ele ajuda a evitar erros, simplifica validações e torna o banco de dados mais seguro e profissional.

> Boa prática: sempre que um campo **não pode se repetir**, considere usar UNIQUE direto no banco.
