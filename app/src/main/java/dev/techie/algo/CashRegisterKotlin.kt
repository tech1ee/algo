package dev.techie.algo

import java.util.*

class CashRegisterKotlin {

    fun getChange(
        register: Map<Coin, Int>,
        price: Int,
        paid: Map<Coin, Int>
    ): Map<Coin, Int>? {
        val allCoins: TreeMap<Coin, Int> = TreeMap(register)
        val change = hashMapOf<Coin, Int>()

        var paidAmount = 0

        paid.forEach {
            val amount = it.key.value * it.value
            paidAmount += amount

            allCoins[it.key] = allCoins[it.key] ?: 0 + it.value
        }

        var changeAmount = paidAmount - price
        if (changeAmount > 0) {
            allCoins
                .descendingMap()
                .forEach { entry ->
                val currentAmount = entry.key.value
                var count = 0
                while (currentAmount <= changeAmount){
                    count++
                    change[entry.key] = count
                    changeAmount -= currentAmount
                }
            }
        }

        if (change.isEmpty()) return null

        return change
    }

    enum class Coin(val value: Int) {
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

    }
}