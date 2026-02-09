[# O que é uma Thread

Thread = fluxo de execução dentro do programa.

Um programa Java começa com 1 thread (main)

Você pode criar outras

## Estados de threads
Não pode dar 2 start na threads se não da Exception
E seus estados são New 
-> Runnable -> Running -> (poder ir pro) - > Waiting / Blocked -> (Volta pro Runable -> Runing) -> Dead

## Prioridade e Sleep
### Prioridade 
Todas threads tem sua prioridade e um jeito de colocar ela para dormir

- a sintaxe é a mesma porem o valor do parametro 
depende da jvm que estiver usando, tem a da oracle, da jdk
1 menor prioridade | 10 a maior, mas aconselhavel é sempre usar Thread.MAX_PRIORITY ou min 
porem seu codigo nunca deve ser pensado assim por que ela é variavel a jvm que vai comandar.
**tente evitar orientar seu código a isso** 

````
t4.setPriority(Thread.MIN_PRIORITY);
````

### Sleep 


````
Thread.sleep(2000)
````

## Yield 
Serve para a THREAD monstrar/Indicação para java que é uma pausa(voltando pro runnable)

## Join
Thread main é a que executa tudo, a t1 e t2 executam um método o (run),
Rodando as duas ao "mesmo tempo" o main liga os dois | e o t1 e t2 são ligados ao método run
Mas ai digamos que vc precisa que antes de chamar o thread t2 vc precisa terminar thread t1 e para fazer isso 
usa-se o JOIN (ou seja uma especie de escolher qual vai ser o primeiro a ser finalizado.)

## Sicronismo de Threads