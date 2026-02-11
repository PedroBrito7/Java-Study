package ZZIjdbc.service;

import ZZIjdbc.dominio.Producer;
import ZZIjdbc.repository.ProducerRepository;

import java.util.List;

public class ProducerService {
    public static void save(Producer producer){
        ProducerRepository.save(producer); // camada a mais para dividir responsabilidade do sistema para o save
    }
    public static void delete(int id){
      requireValidId(id);
      ProducerRepository.delete(id);
    }
    public static void update(Producer producer){
        requireValidId(producer.getId());
        ProducerRepository.update(producer);
    }
    public static List<Producer> findAll(){
      return ProducerRepository.findAll();
    }
    private static void requireValidId(Integer id){ // metodo q vai ser usado mais vezes |  Princípio DRY (Don't Repeat Yourself)
        if(id == null && id <=0){
            throw new IllegalArgumentException("invalid value for id");
        }
    }

}
