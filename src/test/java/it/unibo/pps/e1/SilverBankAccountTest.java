package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest{

    private static final int FEE = 1;
    private static final int AMOUNT_TO_FAIL = 1500;


    @Override
    protected BankAccount getAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getAmountToFail() {
        return AMOUNT_TO_FAIL;
    }

    @Override
    protected int getCalculatedFee(int amount) {
        return FEE;
    }
}
