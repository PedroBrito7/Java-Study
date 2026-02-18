package ZZJcrud.test;

import ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       int op;
        while(true){
            producerMenu();
            op = Integer.parseInt(scanner.nextLine());
            ProducerService.menu(op);
            if (op == 0) break;
        }
    }

    private static void producerMenu(){
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for producer");
        System.out.println("2. Delete  producer");
        System.out.println("0. Exit ");
    }
}
