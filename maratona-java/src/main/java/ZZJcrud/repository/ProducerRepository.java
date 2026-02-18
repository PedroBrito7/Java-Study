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
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
        try (Connection conn = ZZIjdbc.conn.ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' in database, rows affected '{}' ", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }
    private static PreparedStatement createdPreparedStatement(Connection conn, Integer id) throws SQLException{
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }
}
