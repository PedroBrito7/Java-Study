package javacore.Kenum.ExerciciosEnum.dominio;

public enum Moeda {
    REAL(1),
    DOLAR(5.25),
    EURO(6.25);
    private final double taxaDeConversao;

    Moeda(double taxaDeConversao) {
        this.taxaDeConversao = taxaDeConversao;
    }

    public double converterParaBase(double valor) {
        return valor * this.taxaDeConversao;
    }

    public double getTaxaDeConversao() {
        return taxaDeConversao;
    }
}
