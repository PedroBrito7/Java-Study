## 📌 O que é o PreparedStatement?

O PreparedStatement é uma interface do JDBC usada para executar comandos SQL parametrizados.

Ele resolve principalmente 3 coisas:

- ✅ Evita SQL Injection

- ✅ Deixa o código mais organizado

- ✅ Pode ter melhor performance (pré-compilação do SQL)

Ele é uma evolução do Statement.

🔎 Diferença entre Statement e PreparedStatement

- ❌ Statement (ERRADO – vulnerável)

```String sql = "SELECT * FROM producer WHERE name = '" + name + "'";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);
```


Se alguém passar:
````
' OR '1'='1
````

- Você já sabe… 💀 SQL Injection.

✅ PreparedStatement (CORRETO)
```
String sql = "SELECT * FROM producer WHERE name = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, name);

ResultSet rs = ps.executeQuery();
```

Aqui o `?` é um parâmetro.

O banco entende que aquilo é um valor, não parte do SQL.

- 🧠 Como funciona internamente?

Quando você faz:
````
String sql = "INSERT INTO producer (name) VALUES (?)";
````

O banco:

- Compila o SQL

- Guarda o plano de execução

- Depois só troca os valores

Isso melhora performance quando executado várias vezes.

📌 Estrutura básica

String sql = "SQL AQUI COM ?";
````
try (Connection conn = ConnectionFactory.getConnection();
PreparedStatement ps = conn.prepareStatement(sql)) {

    // definir parâmetros
    ps.setTipo(indice, valor);

    // executar
}
```` 

🎯 Métodos mais usados
- Método | 	Tipo

setString()	   | String

setInt() | int

setDouble()	 | double

setDate() |	Date

setBoolean() | boolean


⚠ O índice começa em 1, não em 0.

🚀 Exemplos Práticos

- 🟢 1️⃣ INSERT

````
public static void saveProducer(String name) {
String sql = "INSERT INTO producer (name) VALUES (?)";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, name);

        int rowsAffected = ps.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```` 

executeUpdate() é usado para:

INSERT

UPDATE

DELETE

- 🔵 2️⃣ SELECT
````
public static void findByName(String name) {
String sql = "SELECT * FROM producer WHERE name = ?";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println("Id: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("name"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
````

executeQuery() é usado para SELECT.

- 🟡 3️⃣ UPDATE
````
public static void updateProducer(int id, String newName) {
String sql = "UPDATE producer SET name = ? WHERE id = ?";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setString(1, newName);
        ps.setInt(2, id);

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
````
- 🔴 4️⃣ DELETE
````
public static void deleteProducer(int id) {
String sql = "DELETE FROM producer WHERE id = ?";

    try (Connection conn = ConnectionFactory.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
````
🧠 Dica importante (Muito usada em projetos reais)
Retornar ID gerado automaticamente

Se sua tabela tem:

id INT AUTO_INCREMENT


Você pode pegar o ID gerado:
````
String sql = "INSERT INTO producer (name) VALUES (?)";

try (Connection conn = ConnectionFactory.getConnection();
PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

    ps.setString(1, name);
    ps.executeUpdate();

    ResultSet rs = ps.getGeneratedKeys();
    if (rs.next()) {
        int id = rs.getInt(1);
        System.out.println("Generated ID: " + id);
    }
}
````

Isso é muito usado em APIs REST.

🎯 Quando usar PreparedStatement?

- 👉 Sempre que tiver parâmetros.
- 👉 Em 99% dos casos.
- 👉 Statement quase nunca é usado em sistemas reais.

💡 Resumão mental
Statement → SQL direto (ruim)
PreparedStatement → SQL com ? (correto)