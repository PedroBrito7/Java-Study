NavigableSet

 Ideia principal:

Mexe direto com um objeto.

Um conjunto ordenado que permite navegar pelos elementos (antes, depois, menor, maior, etc).
- É uma subinterface de SortedSet que fornece métodos para navegação em um conjunto ordenado.
- Permite operações como encontrar o maior ou menor elemento, bem como elementos 
imediatamente acima ou abaixo da chave especificada.

- Implementações mais comuns: TreeSet
- So aceita 1 elemento null (se o comparator permitir)
- Mantém os elementos ordenados de acordo com a ordem natural ou um Comparator fornecido.
- Permite navegação bidirecional (ascendente e descendente) através dos elementos do conjunto.
- Fornece métodos adicionais, como lower(), floor(), ceiling() e 
higher() para encontrar elementos com base em sua ordem.
-  Nao tem compareble e comparator padrao (caso voce usa um objeto padrao normalmente tem Integer, String etc.) 
na interface NavigableSet, 
mas as implementações como TreeSet exigem que os elementos sejam comparáveis
ou que um Comparator seja fornecido no momento da criação do conjunto, sendo necessario 
compareble ou comparator para ordenar os elementos.
- Permite a criação de subconjuntos (subsets) com base em intervalos de valores,
- como headSet(), tailSet() e subSet(), com opções para incluir ou excluir os limites.

- descendingSet(): Retorna uma visão do conjunto em ordem decrescente.
- pollFirst() e pollLast(): Removem e retornam o primeiro e o último elemento do conjunto, respectivamente.

  
