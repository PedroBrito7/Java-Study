- **Serialização em Java**
  
-A serialização em Java é o processo de converter o estado de um objeto em uma sequência de bytes, permitindo que ele seja salvo em um arquivo, enviado por rede ou armazenado de forma persistente.

- Quando um objeto é serializado, todos os seus atributos (exceto os marcados como `transient`) são convertidos em bytes.
- O processo inverso, chamado desserialização, reconstrói o objeto a partir da sequência de bytes.
- Para que uma classe seja serializável, ela deve implementar a interface `java.io.Serializable`.
- construtor nao é executado em seriazable
  se tiver trabalhando com herança e a superclasse nao for serializavel o construtor da superclasse n sera executado
- Assim podendo guardar em um file ou enviar por rede


- Caso trabalhar com API que nao pode mexer no codigo fonte para tornar serializavel, pode usar o Externalizable 

🧩 Como lidar com atributos não serializáveis

Imagine que você tem uma classe `Aluno` que possui um atributo `Turma`, mas a classe `Turma` não implementa `Serializable`. Para serializar `Aluno`, você pode usar os métodos `writeObject` e `readObject` para lidar com esse atributo não serializável.

```java
@Serial
private void writeObject(ObjectOutputStream oos) {
try {
// escreve todos os atributos serializáveis normalmente
oos.defaultWriteObject();

        // escreve manualmente o que não é serializável
        oos.writeUTF(turma.getNome());

    } catch (IOException e) {
        e.printStackTrace();
    }
}

@Serial
private void readObject(ObjectInputStream ois) {
try {
// lê os atributos serializáveis
ois.defaultReadObject();

        // lê manualmente os dados extras
        String nomeTurma = ois.readUTF();

        // reconstrói o objeto não serializável
        turma = new Turma(nomeTurma);

    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
🧩 O que cada parte faz (entendimento real)
🔹 defaultWriteObject()
Serializa todos os atributos normais

Ignora os transient

🔹 writeUTF(...)
Você escolhe qual informação salvar

Não salva o objeto inteiro, só o necessário

🔹 defaultReadObject()
Reconstrói os atributos serializados automaticamente

🔹 new Turma(nomeTurma)
Você recria manualmente o objeto que não era serializável

👉 Isso é chamado de reconstrução manual do estado.
































🧸 Imagine this story

You have a toy robot 🦾
This robot has:
a name
a color
a power level

Now imagine you want to:

put this robot in a box, send it to a friend, or save it to play with later

But… you can’t put the robot itself into a computer file 🤔 
So what do you do?

📦 Serialization = turning the toy into instructions

Serialization is like:

👉 Turning the toy robot into a list of instructions
So the computer knows:

how the robot looks

what values it has

how to rebuild it later

Instead of the toy, you save:

“Robot name = Max, color = red, power = 100”

That list of instructions goes into a file 💾



























