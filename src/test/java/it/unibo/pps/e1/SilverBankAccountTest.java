package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest{

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

    @Override
    protected BankAccount getAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getCalculatedFee(int amount) {
        return 1;
    }
}
