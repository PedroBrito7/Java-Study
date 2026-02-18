package ZZIjdbc.repository;

import ZZIjdbc.conn.ConnectionFactory;
import ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2

public class ProducerRepository {
    public static void save(Producer producer){
        String sql = String.format("INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');", producer.getName());
        try(Connection conn= ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected= stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in database, rows affected '{}' ", producer.getName(),rowsAffected );
            System.out.println(rowsAffected);
        }catch (SQLException e){
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` ='%d' );".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' in database, rows affected '{}' ", id, rowsAffected);
            System.out.println(rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

        public static void update(Producer producer){
            String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s ' WHERE (`id` = '%d');"
                    .formatted(producer.getName(),producer.getId());
            try(Connection conn= ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()){
                int rowsAffected= stmt.executeUpdate(sql);
                log.info("updated producer '{}', rows affected '{}' ",producer.getId(),rowsAffected );
                System.out.println(rowsAffected);
            }catch (SQLException e){
                log.error("Error while trying to update producer '{}'",producer.getId(), e);
            }
    }

    public static List<Producer>  findAll() { // normalmente nao tem em bancos no dia a dia de trabalho por trazer tudo de uma vez
        log.info("Finding all producers"); // funciona como se fosse um for enquanto for true ele vai ir pro prox ate dar false
        String sql = "SELECT id, name FROM anime_store.producer;";
        List<Producer> producers = new ArrayList<>(); // cada linha do db vai virar um "objeto guardando nessa lista
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer // aq ele cria o objeto, transforma para objeto
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();

                producers.add(producer);
                // para cada umas das colunas do db, vai pegar o id e o name, vai criar um objeto producer e adcionar na list producers

            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    public static List<Producer>  findByName(String name) {
        log.info("Finding by name producers");
        String sql = "SELECT * FROM anime_store.producer WHERE NAME LIKE '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();

                producers.add(producer);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find by name producers", e);
        }
        return producers;
    }
    public static void  showProducerMetaData() {
        log.info("Showing Producer Metadata");
        String sql = "SELECT * FROM anime_store.producer ";
        try (Connection conn = ConnectionFactory.getConnection(); // conexao com db
             Statement stmt = conn.createStatement(); // Ele serve para enviar comandos SQL simples para o banco.
             ResultSet rs = stmt.executeQuery(sql)) { // ta pegando a query q escrevemos e executando
             ResultSetMetaData rsMetaData = rs.getMetaData();// ta pegando os metadados (dados dos dados, oq tem dentro do id, name etc..)
             rs.next(); // Rs comeca dando referencia nenhuma, com esse next, ele comeca a dar referencia pro primeiro item
             int columnCount = rs.getMetaData().getColumnCount();
             log.info("Columns count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", rsMetaData.getTableName(i));
                log.info("Column name '{}'", rsMetaData.getColumnName(i));
                log.info("Column name '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Column name '{}'", rsMetaData.getColumnType(i));

            }

        } catch (SQLException e) {
            log.error("Error while trying to find by name producers", e);
        }
    }
    public static void  showDriverMetaData() {
        log.info("showing Driver Metadata");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){ // ele vai passar os dados de cima pra baixo como se fosse uma varredura
                log.info("Supports TYPE_FORWARD_ONLY");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE)); // se ele suportar alterar os dados que vc estivar passando
                log.info("and Supports CONCUR_UPDATABLE"); // e se ele suporta aparece o log
            }

            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){ // ele pode navegar de baixo pra cima de cima pra baixo e ele nao atualiza os dados em tempo real(se alguem mexer no mesmo tempo q vc e atualizar ela sem vc saber ele nn mostra),
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE));// se ele suportar alterar os dados que vc estivar passando
                log.info("and Supports CONCUR_UPDATABLE"); // e se ele suporta aparece o log
            }

            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){  // ao contrário do insensitive, se tiver navegando no result set e alguem mudar ele possibilita mostrar oq foi att, POREM extremamente dificil de ser implementado
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)); // se ele suportar alterar os dados que vc estivar passando
                log.info("and Supports CONCUR_UPDATABLE"); // e se ele suporta aparece o log
            }

        } catch (SQLException e) {
            log.error("Error while trying to find by name producers", e);
        }
    }

    public static List<Producer>  showTypeScrollWorking() {
        log.info("Finding by name producers");
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); // queremos criar um statamente com essas caracteriscas de navegacao
             ResultSet rs = stmt.executeQuery(sql)) {
            // vai pra ultima linha
             log.info("Last rows?'{}'", rs.last());
             log.info("Row number '{}'", rs.getRow());
             log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());
            // vai pra primeira linha
            log.info("First rows? '{}'", rs.first());//
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());

            log.info("Row Absolute?'{}'", rs.absolute(2));
            log.info("Row number '{}'", rs.getRow());
            log.info(Producer.builder().id(rs.getInt("id")).name(rs.getString("name")).build());


        } catch (SQLException e) {
            log.error("Error while trying to find by name producers", e);
        }
        return List.of();
    }

    // muda o determinado valor

    public static void updateProducerName(int id, String newName) {
        String sql = "SELECT id, name FROM anime_store.producer WHERE id = " + id;

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_SENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                rs.updateString("name", newName); // altera o valor na linha atual
                rs.updateRow(); // confirma a atualização no banco
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com esse ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<Producer>  findByNamePreparedStatement(String name) {
        log.info("Finding producers by name");
        String sql = "SELECT * FROM anime_store.producer WHERE NAME LIKE ? ;";
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(conn,sql,name);
        ResultSet rs = ps.executeQuery()){ // pré compilando o prepareStatement -
            while (rs.next()) {
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();

                producers.add(producer);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }

    private static PreparedStatement createdPreparedStatement(Connection conn,String sql,String name) throws SQLException{
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%"+name+"%");
        return ps;
    }



}

