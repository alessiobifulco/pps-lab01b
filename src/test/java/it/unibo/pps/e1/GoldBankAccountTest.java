package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {

    @Override
    protected BankAccount getAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(501));
    }

    @Test
    public void testCanWithdrawTillNegativeValue(){
        int amount = 500;
        this.account.withdraw(amount);
        assertEquals(-500, this.account.getBalance());
    }
}
