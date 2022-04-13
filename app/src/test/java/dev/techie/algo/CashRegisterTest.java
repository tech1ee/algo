package dev.techie.algo;

import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

public class CashRegisterTest extends TestCase {

    private CashRegister cashRegister = new CashRegister();

    public void testIfThereIsNoChangeReturnNull() {
        Map<CashRegister.Coin, Integer> register = new HashMap();

        register.put(CashRegister.Coin.TWO_EURO, 1);
        register.put(CashRegister.Coin.ONE_EURO, 1);
        register.put(CashRegister.Coin.FIFTY_CENTS, 2);
        register.put(CashRegister.Coin.FIVE_CENTS, 3);

        Map<CashRegister.Coin, Integer> paid = new HashMap();

        paid.put(CashRegister.Coin.TWO_EURO, 1);
        paid.put(CashRegister.Coin.ONE_EURO, 2);
        paid.put(CashRegister.Coin.TWENTY_CENTS, 1);
        paid.put(CashRegister.Coin.TEN_CENTS, 1);
        paid.put(CashRegister.Coin.FIVE_CENTS, 1);

        int price = 485;

        Map<CashRegister.Coin, Integer> result = cashRegister.getChange(register, price, paid);

        assertNull(result);
    }

    public void testIfThereIsChangeReturnIt() {
        Map<CashRegister.Coin, Integer> register = new HashMap();

        register.put(CashRegister.Coin.TWO_EURO, 1);
        register.put(CashRegister.Coin.ONE_EURO, 1);
        register.put(CashRegister.Coin.FIFTY_CENTS, 2);
        register.put(CashRegister.Coin.TEN_CENTS, 1);
        register.put(CashRegister.Coin.FIVE_CENTS, 2);

        Map<CashRegister.Coin, Integer> paid = new HashMap();

        paid.put(CashRegister.Coin.TWO_EURO, 2);
        paid.put(CashRegister.Coin.ONE_EURO, 1);

        int price = 485;

        Map<CashRegister.Coin, Integer> result = cashRegister.getChange(register, price, paid);

        Map<CashRegister.Coin, Integer> expected = new HashMap();
        expected.put(CashRegister.Coin.TEN_CENTS, 1);
        expected.put(CashRegister.Coin.FIVE_CENTS, 1);

        assertEquals(expected, result);
    }

    public void testIfThereIsChangeAndNoCoinsInRegisterReturnNull() {
        Map<CashRegister.Coin, Integer> register = new HashMap();

        register.put(CashRegister.Coin.TWO_EURO, 1);
        register.put(CashRegister.Coin.ONE_EURO, 1);
        register.put(CashRegister.Coin.FIFTY_CENTS, 2);

        Map<CashRegister.Coin, Integer> paid = new HashMap();

        paid.put(CashRegister.Coin.TWO_EURO, 2);
        paid.put(CashRegister.Coin.ONE_EURO, 1);

        int price = 485;

        Map<CashRegister.Coin, Integer> result = cashRegister.getChange(register, price, paid);

        assertNull(result);
    }

    public void testIfPaidNotEnoughReturnNull() {
        Map<CashRegister.Coin, Integer> register = new HashMap();

        register.put(CashRegister.Coin.TWO_EURO, 1);
        register.put(CashRegister.Coin.ONE_EURO, 1);
        register.put(CashRegister.Coin.FIFTY_CENTS, 2);

        Map<CashRegister.Coin, Integer> paid = new HashMap();

        paid.put(CashRegister.Coin.TWO_EURO, 2);
        paid.put(CashRegister.Coin.FIFTY_CENTS, 1);
        paid.put(CashRegister.Coin.TEN_CENTS, 1);
        paid.put(CashRegister.Coin.FIVE_CENTS, 1);

        int price = 485;

        Map<CashRegister.Coin, Integer> result = cashRegister.getChange(register, price, paid);

        assertNull(result);
    }

    public void testIfPaidMoreReturnChange() {
        Map<CashRegister.Coin, Integer> register = new HashMap();

        register.put(CashRegister.Coin.TWO_EURO, 1);
        register.put(CashRegister.Coin.ONE_EURO, 1);
        register.put(CashRegister.Coin.FIFTY_CENTS, 2);
        register.put(CashRegister.Coin.FIVE_CENTS, 3);

        Map<CashRegister.Coin, Integer> paid = new HashMap();

        paid.put(CashRegister.Coin.FIVE_EURO, 1);

        int price = 485;

        Map<CashRegister.Coin, Integer> result = cashRegister.getChange(register, price, paid);

        Map<CashRegister.Coin, Integer> change = new HashMap();

        change.put(CashRegister.Coin.FIVE_CENTS, 3);

        assertEquals(change, result);
    }

    public void testIfPaidMoreWithExtraForChangeReturnChange() {
        Map<CashRegister.Coin, Integer> register = new HashMap();

        register.put(CashRegister.Coin.TWO_EURO, 1);
        register.put(CashRegister.Coin.ONE_EURO, 1);
        register.put(CashRegister.Coin.TWENTY_CENTS, 2);

        Map<CashRegister.Coin, Integer> paid = new HashMap();

        paid.put(CashRegister.Coin.FIVE_EURO, 1);
        paid.put(CashRegister.Coin.FIVE_CENTS, 1);

        int price = 485;

        Map<CashRegister.Coin, Integer> result = cashRegister.getChange(register, price, paid);

        Map<CashRegister.Coin, Integer> change = new HashMap();

        change.put(CashRegister.Coin.TWENTY_CENTS, 1);

        assertEquals(change, result);
    }

}