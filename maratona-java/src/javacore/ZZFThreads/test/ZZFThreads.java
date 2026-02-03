package javacore.ZZFThreads.test;

//Threads type daemon(não tem tanta predomincancia,
// cuida do garbage collector, e se o java for encerrado daemon encerra e o user fica)  x
// User(Java encerra o programa quando sao terminadas)
class ThreadExample extends Thread{
    private char c;
    public ThreadExample(char c){
        this.c = c;
    }
    @Override
    public void run(){
        System.out.print(Thread.currentThread().getName());
        for(int i = 0; i< 500; i++){
            System.out.print(c);
            if ( i% 100 == 0){
                System.out.println();
            }
        }
        try {
            Thread.sleep(2000); // Precisa tá dentro de um try catch pq pode ocorrer uma exceção dela não dormir
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class ZZFThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExample('A'), "T1A");
        Thread t2 = new Thread(new ThreadExample('b'), "T2b");
        Thread t3 = new Thread(new ThreadExample('c'), "T3c");
        Thread t4 = new Thread(new ThreadExample('d'), "T4d");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
