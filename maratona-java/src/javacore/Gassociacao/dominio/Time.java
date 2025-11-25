package javacore.Gassociacao.dominio;

public class Time {
    private String nome;
    private Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time(String nome) {
        this.nome = nome;
    }

}
