package javacore.ZZFThreads.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames{
    private final List<String> names = Collections.synchronizedList(new ArrayList<>());

    public void add( String name){
        names.add(name);
    }
    public synchronized void removeFirst(){
// se tiver dois threads ele iria dar erro, pq os dois acessaria ao mesmo tempo para nao ocorrer : sync
        if(names.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}
public class ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Junkrat");
        Runnable r = threadSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();

    }
}
