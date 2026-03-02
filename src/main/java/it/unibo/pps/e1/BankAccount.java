package it.unibo.pps.e1;

public interface BankAccount {
    void deposit(int amount);
    void withdraw(int amount);
    int getBalance();
}
