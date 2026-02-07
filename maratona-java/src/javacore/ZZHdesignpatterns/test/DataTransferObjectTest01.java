package javacore.ZZHdesignpatterns.test;

import javacore.ZZHdesignpatterns.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        ReportDto.ReportDtoBuilder.builder()
                .Country(country)
                .currency(currency);
    }
}
