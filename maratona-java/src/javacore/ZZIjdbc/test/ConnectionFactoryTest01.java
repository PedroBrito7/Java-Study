package ZZIjdbc.test;

import ZZIjdbc.conn.ConnectionFactory;
import ZZIjdbc.dominio.Producer;
import ZZIjdbc.repository.ProducerRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        ProducerRepository.save(producer);
    }
}