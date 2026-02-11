package javacore.ZZFThreads.Dominio;

import com.sun.source.tree.BreakTree;

public class Account {
    private int balance = 50;

    public int withDrawl(int amount) {
        this.balance = this.balance - amount;
        return amount;
    }

    public int getBalance() {
        return balance;
    }
}
