package ZZIjdbc.repository;

import ZZIjdbc.conn.ConnectionFactory;
import ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@Log4j2

public class ProducerRepository {
    public static void save(Producer producer){
        String sql = String.format("INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');", producer.getName());;
        try(Connection conn= ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int rowsAffected= stmt.executeUpdate(sql);
            log.info("Database rows affected {}",rowsAffected );
            System.out.println(rowsAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
