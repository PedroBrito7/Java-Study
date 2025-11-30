package javacore.Minterfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover{

    @Override
    public void load() {
        System.out.println("loading datas from a data base");
    }

    @Override
    public void remove() {
        System.out.println("Removing from date base");

    }

    @Override
    public void checkPermission() {
        System.out.println("Checking permision in data base");
    }
}
