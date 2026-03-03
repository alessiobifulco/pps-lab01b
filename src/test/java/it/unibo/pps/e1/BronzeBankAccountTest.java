package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends BankAccountTest {

    private static final int AMOUNT_TO_FAIL = 1600;
    private static final int THRESHOLD = 100;

    @Override
    protected BankAccount getAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getAmountToFail() {
        return AMOUNT_TO_FAIL;
    }

    @Override
    protected int getCalculatedFee(int amount) {
        return amount < THRESHOLD ? 0 : 1;
    }


    @Test
    public void testWithdrawWithZeroFee(){
        int deposit = 1000;
        int withdraw = 50;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw, this.account.getBalance());
    }

    @Test
    public void testWithdrawWithOneFee(){
        int deposit = 1000;
        int withdraw = 150;
        this.account.deposit(deposit);
        this.account.withdraw(withdraw);
        assertEquals(deposit - withdraw -1, this.account.getBalance());
    }
}
