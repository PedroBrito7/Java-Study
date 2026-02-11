package javacore.ZZHdesignpatterns.dominio;

public interface Currency {
    String getSymbol();

}

class Real implements Currency {
    @Override
    public String getSymbol() {
        return "R$";
    }
}

class UsDollar implements Currency {
    @Override
    public String getSymbol() {
        return "$";
    }
    // 2 classes implementando uma moeda, porem quero desagrupar e criar uma moeda pensando em paramentro.


}
