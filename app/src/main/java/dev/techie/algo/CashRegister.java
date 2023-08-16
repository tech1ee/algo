package dev.techie.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CashRegister {

    Map<Coin, Integer> getChange(
            Map<Coin, Integer> registerAmount,
            int price,
            Map<Coin, Integer> paid
    ) {

        return getChangeBruteForce(registerAmount, price, paid);
    }

    Map<Coin, Integer> getChangeBruteForce(
            Map<Coin, Integer> register,
            int price,
            Map<Coin, Integer> paid
    ) {

        TreeMap<Coin, Integer> registerAmount = new TreeMap<>(register);
        HashMap<Coin, Integer> changeMap = new HashMap<>();

        int paidAmount = 0;

        for (Map.Entry<Coin, Integer> entry : paid.entrySet()) {
            int valuePaid = entry.getKey().value * entry.getValue();
            paidAmount += valuePaid;

            int registerValue = 0;

            if (registerAmount.containsKey(entry.getKey())) {
                registerValue = registerAmount.get(entry.getKey());
            }

            registerAmount.put(entry.getKey(), registerValue + entry.getValue());

            int changeAmount = paidAmount - price;

            if (changeAmount > 0) {
                for (Map.Entry<Coin, Integer> registerEntry : registerAmount.descendingMap().entrySet()) {
                    int currentAmount = registerEntry.getKey().value;
                    int count = 0;
                    while (currentAmount <= changeAmount) {
                        count++;
                        changeMap.put(registerEntry.getKey(), count);
                        changeAmount -= currentAmount;
                    }
                }
            }
        }

        if (changeMap.isEmpty()) return null;

        return changeMap;
    }

    static enum Coin {
        ONE_CENT(1),
        TWO_CENTS(2),
        FIVE_CENTS(5),
        TEN_CENTS(10),
        TWENTY_CENTS(20),
        FIFTY_CENTS(50),
        ONE_EURO(100),
        TWO_EURO(200),
        FIVE_EURO(500),
        TEN_EURO(1000),
        TWENTY_EURO(2000),
        FIFTY_EURO(5000),
        HUNDRED_EURO(10000),
        TWO_HUNDRED_EURO(20000),
        FIVE_HUNDRED_EURO(50000);
        private final int value;

        public int getValue() {
            return value;
        }

        Coin(int value) {
            this.value = value;
        }
    }
}
