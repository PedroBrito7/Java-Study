package javacore.Kenum.ExerciciosEnum.dominio;

public enum Prioridade {
    BAIXA(1),
    MEDIA(5),
    ALTA(10);
    private final int VALOR;

    Prioridade(int VALOR) {
        this.VALOR = VALOR;
    }

    public int getVALOR() {
        return VALOR;
    }

}
