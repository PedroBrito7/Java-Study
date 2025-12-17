package javacore.dsa;

// LIFO (last in first out  push adc topo, pop remove top, peek visualiza
public class PilhasArray {
private int[] dados;
private int topo;
public PilhasArray (int capacidade){
    dados = new int [capacidade];
    topo = -1;
}
public void push(int valor){
    if (topo == dados.length -1){
        throw new RuntimeException("OverFlow");
    }
    dados [++topo] = valor;
}

public int pop(){
    if(topo==-1){
        throw new RuntimeException("Underflow");
    }
    return dados[topo--];
}
public int peek(){
    return dados[topo];
}
    }

