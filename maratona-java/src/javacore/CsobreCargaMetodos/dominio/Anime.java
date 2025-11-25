package javacore.CsobreCargaMetodos.dominio;

public class Anime {
    private String name;
    private String tipo;
    private int ep;
    private String genero;

    public Anime(){

    }

    public void init(String name,String tipo, int ep){
        this.name = name;
        this.tipo = tipo;
        this.ep = ep;
    }
    public void init(String name,String tipo, int ep, String genero){
        this.init(name,tipo,ep);
        this.genero = genero;
    }
    public void print(){
        System.out.println(this.name);
        System.out.println(this.tipo);
        System.out.println(this.ep);
        System.out.println(this.genero);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getName(){
        return this.name;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setEp(int ep){
        this.ep = ep;
    }
    public int getEp(){
        return this.ep;
    }
}
