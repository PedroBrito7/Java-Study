package ZZIjdbc.repository;

import ZZIjdbc.conn.ConnectionFactory;
import ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j2

public class ProducerRepository {
    public static void save(Producer producer){
        String sql = String.format("INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');", producer.getName());;
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

    public static List<Producer>  findByName() {
        log.info("Finding by name producers");
        String sql = "SELECT id, name by FROM anime_store.producer;";
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
            log.error("Error while trying to find all producers", e);
        }
        return producers;
    }
}

