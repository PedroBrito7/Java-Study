package ZZIjdbc.test;

import ZZIjdbc.dominio.Producer;
import ZZIjdbc.service.ProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConnectionFactoryTest01 {
    private static final Logger log = LogManager.getLogger(ConnectionFactoryTest01.class);

    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//        ProducerService.save(producer);
//        ProducerService.delete(3);
//        ProducerService.update(producerToUpdate);
//        List<Producer> producers = ProducerService.findAll();
//        List<Producer> producers = ProducerService.findByName("MAD");
//        log.info("Producers found '{}' ", producers);
//        ProducerService.showProducerMetadata();
//        ProducerService.showDriverMetaData();
        ProducerService.showTypeScrollWorking();
    }
}