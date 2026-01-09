O que são Generics?

Generics é você avisar pro Java qual tipo de dado vai ser usado, antes do programa rodar.
“Java, aqui dentro só entra String”
ou
“Aqui só entra número”

Generics permitem definir tipos parametrizados, deixando o código:

Mais seguro (evita ClassCastException)

Mais legível

Mais reutilizável

👉 Você define o tipo só quando usa a classe/método, não quando cria.

- Exemplo sem Generics (problema) 

List lista = new ArrayList();

lista.add("Texto");

lista.add(10);

String s = (String) lista.get(1); // ClassCastException


- Exemplo com Generics (correto)

List<String> lista = new ArrayList<>();

lista.add("Texto");
// lista.add(10); // ERRO de compilação

- 
✔ Erro acontece em tempo de compilação, não em runtime.

Sintaxe Básica
Classe<T>
Classe<T, U>
Classe<T extends Algo>


Exemplo:

List<Integer>
Map<String, Pessoa>
Optional<Usuario>

Generics em Classes
public class Caixa<T> {
private T valor;

    public void guardar(T valor) {
        this.valor = valor;
    }

    public T pegar() {
        return valor;
    }
}


Uso:

Caixa<String> caixa = new Caixa<>();
caixa.guardar("Java");
String v = caixa.pegar();

Generics em Métodos
public class Util {

    public static <T> void imprimir(T valor) {
        System.out.println(valor);
    }
}


Uso:

Util.imprimir("Texto");
Util.imprimir(10);
Util.imprimir(true);

Generics com Limite (extends)

Restringe os tipos aceitos.

public class Calculadora<T extends Number> {

    public double dobrar(T numero) {
        return numero.doubleValue() * 2;
    }
}


✔ Aceita Integer, Double, Long
❌ Não aceita String

Wildcards (?)

Usado quando não importa o tipo exato.

? (qualquer tipo)
List<?> lista;

? extends Tipo (somente leitura)
List<? extends Number> numeros;


✔ Pode ler como Number
❌ Não pode adicionar elementos

? super Tipo (somente escrita)
List<? super Integer> numeros;


✔ Pode adicionar Integer
❌ Leitura só como Object

Generics nas Collections (mais comuns)
List<String>
Set<Integer>
Map<String, Pessoa>
Queue<Pedido>

Convenções de Letras
Letra	Significado
T	Type
E	Element
K	Key
V	Value
N	Number
Importante Saber

Generics não existem em runtime (Type Erasure)

Não pode:

new T();
T[] array = new T[10];

Quando Usar Generics?

✔ Quando sua classe/método trabalha com tipos variáveis
✔ Quando quer evitar casts
✔ Quando cria estruturas reutilizáveis

Resumo Rápido

Generics = tipo definido no uso, não na implementação

List<String> nomes = new ArrayList<>();