package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {

    protected BankAccount account;

    @BeforeEach
    void init() {
        this.account = this.getAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int amount = 1000;
        int withdraw = 200;
        this.account.deposit(amount);
        this.account.withdraw(withdraw);
        int fee = getCalculatedFee(amount);
        assertEquals(amount - withdraw - fee, this.account.getBalance());
    }

    protected abstract BankAccount getAccount();

    protected abstract int getCalculatedFee(int amount);


}
