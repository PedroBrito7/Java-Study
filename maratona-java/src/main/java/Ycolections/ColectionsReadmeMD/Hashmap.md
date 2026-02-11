1- Map - Hash Map
u m mapa e uma colecao que armazena os dados em pares
chave/valor, onde cada chave e unica e mapeia para um valor.

ele sobreescreve um valor caso a chave ja exista, 
caso vc quer adicionar um valor apenas se a chave 
nao existir vc pode usar o metodo putifabsent

2-  principais implementacoes de Map - HashMap
Para iterar ele é um for each normal porem escreve
map.keyset() para pegar as chaves
map.values() para pegar os valores
map.entryset() para pegar os pares chave/valor
Para criar o for each de entryset() voce pode usar o atalho
map.entryset.for e o ide ja cria o for each para voce


- HashMap: implementacao mais comum, nao garante ordem dos elementos.
- LinkedHashMap: mantem a ordem de insercao dos elementos.
- TreeMap: ordena os elementos com base na ordem natural das chaves ou em um comparador fornecido.

Cria 2 consumidores  e um map que
guarda o consumidor e o manga (copia do new manga e cola) que o consumidor comprou 
associar um consuidor a um manga map<tipo da chave(consumidor) , valor da chave(mmanga)>
percorrer com um for each os consumidores 
coloca o map.entry pra pegar os pares chaves e dps o sout com entrykey