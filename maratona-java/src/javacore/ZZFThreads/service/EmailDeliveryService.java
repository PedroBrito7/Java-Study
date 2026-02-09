package javacore.ZZFThreads.service;

import javacore.ZZFThreads.Dominio.Members;

public class EmailDeliveryService implements Runnable {
    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " starting to deliver emails...");
        while (members.isOpen() || members.pendingEmails() > 0) {
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.println(threadName + " sending email for " + email);
                Thread.sleep(2000);
                System.out.println(threadName + " sended email with sucess for " + email);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("All emails sent successfully");
    }
}


// no try e catch dessa :
// vai dar continue para continuar esperando o email que nao tiver nd (ele sempre vai retornar n o loop)