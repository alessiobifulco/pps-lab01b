package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class BankAccountTest {

    protected BankAccount account;

    @BeforeEach
    void init() {
        this.account = this.getAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        int expected = 0;
        assertEquals(expected, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int amount = 1000;
        this.account.deposit(amount);
        assertEquals(amount, this.account.getBalance());
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

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        int amount = 1000;
        this.account.deposit(amount);
        int amountToFail = getAmountToFail();
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(amountToFail));
    }

    protected abstract BankAccount getAccount();
    protected abstract int getAmountToFail();
    protected abstract int getCalculatedFee(int amount);
}
