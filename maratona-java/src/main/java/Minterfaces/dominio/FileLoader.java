package javacore.Minterfaces.dominio;

public class FileLoader implements DataLoader, DataRemover {
    public void load() {
        System.out.println("loading data from a file");
    }

    @Override
    public void remove() {
        System.out.println("deleting a file");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checking permission in data base");
    }
}