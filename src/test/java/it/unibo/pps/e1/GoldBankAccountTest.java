package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest extends BankAccountTest {

    private static final int AMOUNT_TO_FAIL = 1600;


    @Override
    protected BankAccount getAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getCalculatedFee(int amount) {
        return 0;
    }

    @Override
    protected int getAmountToFail() {
        return AMOUNT_TO_FAIL;
    }

    @Test
    public void testCanWithdrawTillNegativeValue() {
        int amount = 500;
        this.account.withdraw(amount);
        assertEquals(-amount, this.account.getBalance());
    }
}
