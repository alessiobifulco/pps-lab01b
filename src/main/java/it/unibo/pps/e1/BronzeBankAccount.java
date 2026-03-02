package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount{

    private final BankAccount base;

    public BronzeBankAccount(BankAccount account){
        this.base = account;
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int fee = (amount < 100) ? 0 : 1;
        int totalAmount = amount + fee;
        if (base.getBalance() < totalAmount) {
            throw new IllegalStateException();
        }
        base.withdraw(totalAmount);
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }
}
