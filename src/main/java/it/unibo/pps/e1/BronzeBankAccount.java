package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount{

    private final BankAccount base;
    private static final int THRESHOLD = 100;

    public BronzeBankAccount(BankAccount account){
        this.base = account;
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int fee = amount < THRESHOLD ? 0 : 1;
        int totalAmount = amount + fee;
        if (this.base.getBalance() < totalAmount) {
            throw new IllegalStateException();
        }
        this.base.withdraw(totalAmount);
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }


}
