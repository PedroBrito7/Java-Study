package javacore.Eblocosinicializacao.dominio;

public class Anime {
    private String nome;
    private int[] episodios;
    // 1- alocado espaco em memoria pro obj
    // 2- cada atributo de classe é criado e inicializado com valores default ou oq for passado
    // 3- bloco de inicialização é executado
    // 4- Construtor é executado
    //  ordem vai ser alterado quando aprender herança em java etc

    {
        System.out.println(" Dentro do bloco de inicialização");
        episodios = new int [100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i +1;
        }
    }
    public Anime(String nome) {
        this.nome = nome;
    }
    public Anime(){
        for (int episodio: this.episodios){
            System.out.print(episodio + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}
