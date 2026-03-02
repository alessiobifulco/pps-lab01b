package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest {

    @Override
    protected BankAccount getAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(500));
    }

    @Test
    public void testWithdrawWithZeroFee(){
        this.account.deposit(1000);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
    }
}
