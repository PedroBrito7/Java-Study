package javacore.Kenum.dominio;

public enum TipoPagamento{
        DEBITO {
            @Override
            public double calcularDesconto(double valor) {
                return valor * 0.1;
            }
        }, CREDITO{
        @Override
        public double calcularDesconto(double valor) {
            return valor *0.05;
        }
    };

    public abstract double calcularDesconto(double valor);
    // abstract  = o metodo nao existe nao tem implementacao propria oq existe é a substituicao do codigo com debito e credito
    // abstract  = ele também não tem corpo

    }