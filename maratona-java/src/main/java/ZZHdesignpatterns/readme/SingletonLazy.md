# Lazy
Trabalhando com multithreads : 
dois usuarios podem pegar o mesmo acento, e se usar o syncronizhed diminui a perfomance 
entao faz se um double lock: 
````
public static AircraftSingletonLazy getInstance(){
        if(INSTANCE == null){
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }
````


# Singleton Lazy em Java (gemini fez esse)

O **Singleton Lazy** (inicialização preguiçosa) é um padrão de projeto criacional que garante que uma classe tenha apenas uma instância, mas com um diferencial: essa instância só é criada no momento em que for solicitada pela primeira vez.

## 1. Implementação Recomendada (Thread-Safe)

Para garantir que o Singleton funcione corretamente em ambientes onde várias threads rodam simultaneamente, utilizamos o método de **Double-Checked Locking** com a palavra-chave `volatile`.

```java
public class SingletonLazy {
    // volatile garante que as alterações na variável sejam visíveis para todas as threads
    private static volatile SingletonLazy instance;

    // Construtor privado impede que outras classes instanciem o objeto diretamente
    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        // Primeira verificação (sem bloqueio para manter a performance)
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                // Segunda verificação (garante que apenas uma thread crie a instância)
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
}
2. Componentes ChaveConstrutor Privado: Impede o uso do operador new fora da classe.Atributo Estático: Armazena a única referência da instância.Método getInstance(): Ponto de acesso global que contém a lógica de "preguiça" (instancia apenas se for nulo).Sincronização: O bloco synchronized evita que duas threads criem duas instâncias distintas simultaneamente.3. Vantagens vs. DesvantagensCaracterísticaSingleton LazyConsumo de MemóriaExcelente. Só aloca memória se o método for chamado.PerformanceLeve impacto na primeira chamada devido à sincronização.Uso IdealObjetos pesados que podem não ser utilizados em todas as execuções.4. Alternativa: Bill Pugh SingletonSe você utiliza Java moderno, a forma mais elegante de obter o efeito Lazy sem usar synchronized explicitamente é através de uma classe interna estática:Javapublic class SingletonBillPugh {
    private SingletonBillPugh() {}

    // A JVM só carrega esta classe quando o método getInstance for chamado
    private static class Holder {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return Holder.INSTANCE;
    }
}

---
```
