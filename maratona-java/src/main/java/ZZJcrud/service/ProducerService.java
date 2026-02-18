package ZZJcrud.service;

import ZZJcrud.dominio.Producer;
import ZZJcrud.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Scanner;
@Log4j2

public class ProducerService {
    private static Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1:
                findByName();
                break;

            case 2:
                delete();
                break;
            default:
                throw new IllegalArgumentException("Not valid option");
        }
    }

    private static void findByName(){
        System.out.println("Type the name or empty to all");
      String name = SCANNER.nextLine();
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            Producer producer = producers.get(i);
            System.out.printf("[%d] - %d | %s%n", i, producer.getId(),producer.getName());
        }
    }
    private static void delete(){
        System.out.println("Type one of the ids below to delete");
        findByName();
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("are you sure");
        String choice =SCANNER.nextLine();
        if("s".equalsIgnoreCase(choice));
        ProducerRepository.delete(id);
    }



}
