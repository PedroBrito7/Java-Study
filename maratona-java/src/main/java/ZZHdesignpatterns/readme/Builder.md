# Builder (Construtor)
   O padrão Builder é usado para construir objetos complexos passo a passo. Ele é a solução ideal para evitar o "Anti-padrão do Construtor Telescópico" (quando você tem construtores com 10 argumentos, onde muitos são opcionais).

## Quando usar:
Objetos com muitos atributos (alguns obrigatórios, outros opcionais).

Quando o objeto final deve ser imutável (sem métodos set).

## Exemplo
````
Java
class Carro {
private final String motor;  // Obrigatório
private final boolean arCondicionado; // Opcional
private final int portas; // Opcional

    private Carro(Builder builder) {
        this.motor = builder.motor;
        this.arCondicionado = builder.arCondicionado;
        this.portas = builder.portas;
    }

    
    
    public static class Builder {
        private String motor;
        private boolean arCondicionado = false;
        private int portas = 4;

        public Builder(String motor) { this.motor = motor; }

        public Builder comAr(boolean ar) { this.arCondicionado = ar; return this; }
        public Builder comPortas(int portas) { this.portas = portas; return this; }

        public Carro build() { return new Carro(this); }
    }
}

// Uso:
Carro meuCarro = new Carro.Builder("V8").comAr(true).build();
````