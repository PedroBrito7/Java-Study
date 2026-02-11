# Singleton
O padrão Singleton tem como objetivo garantir que uma classe 
tenha apenas uma única instância em toda a execução do 
programa e fornecer um ponto de acesso global a ela. ou seja 
a mesma referencia na memoria, nas outras pastas fizemos isso com
assentos de avião, ele foi "comprado" selecionado a primeira vez
quando acionamos a segunda ele retorna false pq foi selecionado 
graças ao nosso Singleton Eager

## Quando usar:
- Gerenciamento de conexão com banco de dados.

- Logs de sistema.

- Configurações globais da aplicação (Cache).
----

Implementação Clássica (Thread-Safe)

Em Java, a forma mais segura e performática de implementar o Singleton (considerando ambientes multi-thread) é usando o método Lazy Initialization com Double-Checked Locking.
```
public class GerenciadorConfiguracao {
// A instância é volátil para garantir visibilidade entre threads
private static volatile GerenciadorConfiguracao instancia;
private String valorConfig;

    // Construtor privado impede que outras classes usem 'new'
    private GerenciadorConfiguracao() {
        this.valorConfig = "Configuração Padrão";
    }

    public static GerenciadorConfiguracao getInstancia() {
        if (instancia == null) { // Primeiro check (sem bloqueio)
            synchronized (GerenciadorConfiguracao.class) {
                if (instancia == null) { // Segundo check (com bloqueio)
                    instancia = new GerenciadorConfiguracao();
                }
            }
        }
        return instancia;
    }

    public void exibirConfig() {
        System.out.println(valorConfig);
    }
}
```
## Abordagem Moderna: Enum Singleton

A partir do Java 5, a forma mais recomendada por especialistas (como Joshua Bloch) é usar Enums. É inerentemente thread-safe e protege contra ataques de reflexão ou serialização.

```
Java
public enum ConexaoBanco {
INSTANCIA;

    public void conectar() {
        System.out.println("Conectado ao banco com sucesso!");
    }
}
```

// Uso:
```
ConexaoBanco.INSTANCIA.conectar();
```
## Pontos de Atenção

- Acoplamento: O Singleton pode tornar o código difícil de testar (testes unitários), pois cria um estado global.

- Violação do Princípio de Responsabilidade Única: A classe controla seu próprio ciclo de vida além de sua lógica de negócio.