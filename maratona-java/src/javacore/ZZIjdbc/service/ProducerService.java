package ZZIjdbc.service;

import ZZIjdbc.dominio.Producer;
import ZZIjdbc.repository.ProducerRepository;

public class ProducerService {
    public static void save(Producer producer){
        ProducerRepository.save(producer); // camada a mais para dividir responsabilidade do sistema para o save
    }
    public static void delete(int id){
        if(id<= 0){
            throw new IllegalArgumentException("invalid value for id");
        }
        ProducerRepository.delete(id);
    }
    public static void update(Producer producer){
        if(producer<= 0){
            throw new IllegalArgumentException("invalid value for id");
        }
        ProducerRepository.delete(id);
    }


}
