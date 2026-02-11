# Factory Method 
   O objetivo deste padrão é criar objetos sem expor a lógica de instanciação ao cliente. Em vez de usar o operador new diretamente no código principal, você chama um método que decide qual classe instanciar.

## Quando usar:
Quando a classe não sabe antecipadamente qual subclasse precisa criar.

Para centralizar a criação de objetos de uma mesma "família".

## Exemplo em Java:
````
Java
// Interface comum
interface Notificacao {
void enviar(String mensagem);
}

// Implementações concretas
class EmailNotificacao implements Notificacao {
public void enviar(String msg) { System.out.println("Enviando Email: " + msg); }
}

class SMSNotificacao implements Notificacao {
public void enviar(String msg) { System.out.println("Enviando SMS: " + msg); }
}
````
````
// Factory
class NotificacaoFactory {
public Notificacao criarNotificacao(String tipo) {
if (tipo.equals("EMAIL")) return new EmailNotificacao();
if (tipo.equals("SMS")) return new SMSNotificacao();
throw new IllegalArgumentException("Tipo desconhecido");
}
}
````