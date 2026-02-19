package ZZJcrud.repository;


import ZZJcrud.conn.ConnectionFactory;
import ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Log4j2
public class ProducerRepository {
    public static List<Producer> findByName(String name) {
        log.info("Finding producers by name '{}'", name);
        String sql = "SELECT * FROM anime_store.producer WHERE NAME LIKE ? ;";
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPrepareStatementFindByName(conn,name);
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
    private static PreparedStatement createPrepareStatementFindByName(Connection conn, String name) throws SQLException{
      String sql = "SELECT * FROM anime_store.producer WHERE NAME LIKE ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%", name));
        return ps;
    }
    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(conn, id)) {

            int rowsAffected = ps.executeUpdate();
            log.info("Deleted producer '{}' in database, rows affected '{}'", id, rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    public static void save(Producer producer) {
        String sql = "INSERT INTO anime_store.producer (name) VALUES (?);"; //O ? é um placeholder será substituído pelo valor

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producer.getName());

            int rowsAffected = ps.executeUpdate();
            log.info("Inserted producer '{}' in database, rows affected '{}'",
                    producer.getName(), rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'",
                    producer.getName(), e);
        }
    }
    public static void update(Producer producer) {
        String sql = "UPDATE anime_store.producer SET name = ? WHERE id = ?;";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producer.getName());
            ps.setInt(2, producer.getId());

            int rowsAffected = ps.executeUpdate();
            log.info("Updated producer '{}', rows affected '{}'",
                    producer.getId(), rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'",
                    producer.getId(), e);
        }
    }
    private static PreparedStatement createdPreparedStatement(Connection conn, Integer id) throws SQLException{
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
}
