package javacore.ZZFThreads.Dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen(){
        return open;
    }
    public int pendingEmails(){
        synchronized (emails){
            return emails.size();
        }
    }

    public void addMemberEmail(String email){
        synchronized (this.emails){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "Add email na lista");
            this.emails.add(email);
            this.emails.notifyAll(); // avisa quando adiciounou os email para as threads
            // todo voltar quando a thread estiver esperando
        }
    }
    public String  retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "Chekling if there are emails");
        synchronized (this.emails){
            while(this.emails.size() == 0){
                if(!open) return null;
                System.out.println(Thread.currentThread().getName() + " not there are emails in list, enter in mode wait");
                this.emails.wait();
            }
            return this.emails.poll();
        }
    }
    public void close(){
        open = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName()+ "notifying everyone that we are no longer reading emails");
        }

    }
}
// metodo retrieve email logica : Ele é uma chegagem de email, sincroniza pq apenas uma thread pode acessas
// sincronizar e seleciona o lock (no caso email) e a regra de negocio, ele poder ter email
// mas tambem nao pode ter, faz entao um percusso, se ele for igual 0 vai ser diferente de open
// entao ele retorna que nao tem email (null)  e entra no modo de espera (wait)
// se n retorna true e ja era.  comm poll q ainda vai retornar
