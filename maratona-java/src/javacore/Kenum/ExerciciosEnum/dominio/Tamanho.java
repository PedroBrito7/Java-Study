package javacore.Kenum.ExerciciosEnum.dominio;

public enum Tamanho {
    P("Pequeno (Small)"),
    M("Médio (Medium)"),
    G("Grande (Large)"),
    GG("Extra Grande (Extra Large)");

    private final String descricaoCompleta;

    Tamanho(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

}
