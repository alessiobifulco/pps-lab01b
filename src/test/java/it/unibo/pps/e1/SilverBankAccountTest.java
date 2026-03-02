package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest{

    private static final int FEE = 1;

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int amount = 1000;
        int withdraw = 1200;
        this.account.deposit(amount);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdraw));
    }

    @Override
    protected BankAccount getAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getAmountToFail() {
        return 1500;
    }

    @Override
    protected int getCalculatedFee(int amount) {
        return FEE;
    }
}
