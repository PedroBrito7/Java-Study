 ## RESUMO FINAL 
(o mais importante)

 primitivo 

(int, double, boolean…)

usar quando for 

cálculos

loops

performance

memória baixa

variáveis internas simples

4 kb

--------------------------
<b>Use wrapper</B> 

(Integer, Double, Boolean…)

usar quando for

quando precisa usar List, Set, Map (coletions)

quando precisa permitir null

quando precisa usar métodos utilitários


quando trabalha com APIs que exigem objetos

Caracteristicas

É uma classe imutável que representa um tipo primitivo como objeto

Wrappers são imutaveis mesmo sendo objetos(não altera o valor)Você não muda o valor, você cria um novo objeto.
A referência é passada por cópia.

16kb

Se passar do seu limite vira outro tipo primitivo

* NUNCA usar wrappers

❌ Em loops de milhões de iterações

❌ Para somas acumulativas

❌ Para contadores

❌ Em código crítico de performance

❌ Em objetos que nunca podem ser null
