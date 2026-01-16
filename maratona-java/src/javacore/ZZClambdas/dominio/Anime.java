package javacore.ZZClambdas.dominio;

public class Anime {
    private String title;
    private int episodes;

    public Anime(String title, int quatity) {
        this.title = title;
        this.episodes = quatity;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", quatity=" + episodes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getEpisodes() {
        return episodes;
    }
}
