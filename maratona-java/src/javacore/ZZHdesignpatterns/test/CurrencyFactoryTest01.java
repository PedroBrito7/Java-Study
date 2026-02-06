package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.Country;
import javacore.ZZHdesignpatterns.dominio.Currency;
import javacore.ZZHdesignpatterns.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
