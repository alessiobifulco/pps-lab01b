package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private final BankAccount base;
    private static final int NEGATIVE_AMOUNT_VALID = -500;

    public GoldBankAccount(BankAccount bankAccount){
        this.base = bankAccount;
    }
    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if ((base.getBalance() - amount) < NEGATIVE_AMOUNT_VALID){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

}
