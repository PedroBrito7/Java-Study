1. O que é BlockingQueue (ideia central)

BlockingQueue é uma fila thread-safe usada para comunicação entre threads.

👉 Ela bloqueia automaticamente:

quem tenta consumir quando a fila está vazia

quem tenta produzir quando a fila está cheia (dependendo da implementação)

Ou seja:
📌 você não precisa usar synchronized, wait() ou notify() manualmente.

2. Problema real que ela resolve (vida real)

Imagine um sistema assim:

Produtores: recebem pedidos (API, mensagens, eventos)

Consumidores: processam esses pedidos (salvar no banco, enviar e-mail, gerar relatório)

Sem BlockingQueue:

risco de race condition

código cheio de lock, wait, notify

fácil errar e causar deadlock

Com BlockingQueue:

comunicação segura

código limpo

controle de fluxo automático

3. Exemplo clássico: Produtor x Consumidor
   Cenário real:

Uma thread recebe pedidos

Outra thread processa pedidos