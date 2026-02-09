# Check 
Serve para fazer validações que veem de uma expressão
## Exemploo real: 
```
CREATE TABLE Funcionarios (
    ID INT PRIMARY KEY,
    Nome VARCHAR(100),
    Salario DECIMAL(10, 2) CONSTRAINT CHK_Salario CHECK (Salario > 0),
    Cargo VARCHAR(50) CONSTRAINT CHK_Cargo CHECK (Cargo IN ('Gerente', 'Analista', 'Desenvolvedor'))
);
```
A restrição CHK_Salario garante que o salário seja maior que zero.

A restrição CHK_Cargo limita os cargos aceitos a apenas três valores específicos.
Teste de Inserção

-- Funciona (valor válido)
```
INSERT INTO Funcionarios (ID, Nome, Salario, Cargo)
VALUES``` (1, 'Ana', 5000.00, 'Analista');

-- Falha (salário inválido)
```
---
```
INSERT INTO Funcionarios (ID, Nome, Salario, Cargo)
VALUES (2, 'João', -1000.00, 'Gerente');
```
 Erro: O valor do salário não satisfaz a condição CHECK.

---

Restrição com Múltiplas Colunas

```
ALTER TABLE Eventos
ADD CONSTRAINT CHK_DatasValidas
CHECK (DataFim > DataInicio);
```