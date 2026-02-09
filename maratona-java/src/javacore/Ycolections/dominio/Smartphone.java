package javacore.Ycolections.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    // reflexivity : x.equals(x) tem que ser true para tudo que for diferente de null
    // simétrico : se x.equals(y) é true, y.equals(x) tem que ser true
    // Transtitividade : se x.equals(y) é true e y.equals(z) é true, x.equals(z) tem que ser true
    // consistente : x.equals(x) sempre retorna true se x for diferente de null
    // para x diferente de null x.equals(null) tem que retornar false.
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        Smartphone smartphone = (Smartphone) obj;
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber);
    }
    // regras
    // se x.euquals(y) == true,  y.hashCode() == x.hashCode() tem que ser exatamente o mesmo
    // y.hashCode() == x.hashCode() pode ser true , mesmo se x.equals(y) for false
    // alex e bob na mesma gaveta, o equals vai falar que são diferentes, mas o hashcode fala que estão na mesma gaveta
    // se x.equals(y) == false
    // y.hashCode() != x.hashCode()  x.equals(y) deve ser false se nao o código ta errado


    @Override
    public int hashCode() {
        return serialNumber == null ? 0 : this.serialNumber.hashCode();
        // java ja faz o proprio hashcode para String e conferi se é null

    }


    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


}
