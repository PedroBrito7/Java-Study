package javacore.DConstrutores.dominio;

public class Anime {
    private String name;
    private String tipo;
    private int ep;
    private String genero;
    private String estudio;

    public Anime(String name, String tipo, int ep, String genero) {
        this();
        this.name = name;
        this.tipo = tipo;
        this.ep = ep;
        this.genero = genero;
    }

    public Anime(String name, String tipo, int ep, String genero, String estudio) {
        this(name, tipo, ep, genero);
        this.name = name;
        this.tipo = tipo;
        this.ep = ep;
        this.genero = genero;
        this.estudio = estudio;
    }

    public Anime() {
        System.out.println(" Dentro do construtor sem args");
    }

    public void print() {
        System.out.println(this.name);
        System.out.println(this.tipo);
        System.out.println(this.ep);
        System.out.println(this.genero);
        System.out.println(this.estudio);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getName() {
        return this.name;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public int getEp() {
        return this.ep;
    }
}
