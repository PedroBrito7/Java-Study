package javacore.Kenum.ExerciciosEnum.dominio;

public enum UnidadeTemperatura {
    CELSIUS,
    FAHRENHEIT;

   public double  converterParaCelsius(double valor) {
        if(this == CELSIUS){
            return valor;
        }
        else if(this == FAHRENHEIT){
           return (valor -32) * 5/9;
        }
            return valor;

    }




}
