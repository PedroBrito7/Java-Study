package ZZJcrud.service;

import ZZJcrud.dominio.Producer;
import ZZJcrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
    private static Scanner scanner = new Scanner(System.in);

    public static void BuildMenu(int op) {
        switch (op) {
            case 1: findByName();

        }
    }

    private static void findByName(String name){
        System.out.println("Type the name or empty to all");
      String name = scanner.nextLine()
        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size(); i++) {
            System.out.printf("[%d] - %s%n", i, producers.get(i).getName());
        }
    }
}
