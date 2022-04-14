package dev.techie.algo

import junit.framework.TestCase
import org.junit.Test

class CashRegisterKotlinTest : TestCase() {

    private val cashRegister = CashRegisterKotlin()

    @Test
    fun `test if there is no change return null`() {
        val register = hashMapOf<CashRegisterKotlin.Coin, Int>()
        register[CashRegisterKotlin.Coin.TWO_EURO] = 1
        register[CashRegisterKotlin.Coin.ONE_EURO] = 1
        register[CashRegisterKotlin.Coin.FIFTY_CENTS] = 2
        register[CashRegisterKotlin.Coin.FIVE_CENTS] = 3

        val paid = hashMapOf<CashRegisterKotlin.Coin, Int>()

        paid[CashRegisterKotlin.Coin.TWO_EURO] = 1
        paid[CashRegisterKotlin.Coin.ONE_EURO] = 2
        paid[CashRegisterKotlin.Coin.TWENTY_CENTS] = 1
        paid[CashRegisterKotlin.Coin.TEN_CENTS] = 1
        paid[CashRegisterKotlin.Coin.FIVE_CENTS] = 1

        val price = 485

        val result = cashRegister.getChange(register, price, paid)

        assertNull(result)
    }

    @Test
    fun `test if there is change return it`() {
        val register = hashMapOf<CashRegisterKotlin.Coin, Int>()
        register[CashRegisterKotlin.Coin.TWO_EURO] = 1
        register[CashRegisterKotlin.Coin.ONE_EURO] = 1
        register[CashRegisterKotlin.Coin.FIFTY_CENTS] = 2
        register[CashRegisterKotlin.Coin.TEN_CENTS] = 1
        register[CashRegisterKotlin.Coin.FIVE_CENTS] = 2

        val paid = hashMapOf<CashRegisterKotlin.Coin, Int>()

        paid[CashRegisterKotlin.Coin.TWO_EURO] = 2
        paid[CashRegisterKotlin.Coin.ONE_EURO] = 1

        val price = 485

        val expected = hashMapOf<CashRegisterKotlin.Coin?, Int?>()
        expected[CashRegisterKotlin.Coin.TEN_CENTS] = 1
        expected[CashRegisterKotlin.Coin.FIVE_CENTS] = 1

        val result = cashRegister.getChange(register, price, paid)

        assertEquals(expected, result)
    }

    @Test
    fun `test if there is change and no coins return null`() {
        val register = hashMapOf<CashRegisterKotlin.Coin, Int>()
        register[CashRegisterKotlin.Coin.TWO_EURO] = 1
        register[CashRegisterKotlin.Coin.ONE_EURO] = 1
        register[CashRegisterKotlin.Coin.FIFTY_CENTS] = 2

        val paid = hashMapOf<CashRegisterKotlin.Coin, Int>()

        paid[CashRegisterKotlin.Coin.TWO_EURO] = 2
        paid[CashRegisterKotlin.Coin.ONE_EURO] = 1

        val price = 485

        val result = cashRegister.getChange(register, price, paid)

        assertNull(result)
    }

    @Test
    fun `test if paid not enough return null`() {
        val register = hashMapOf<CashRegisterKotlin.Coin, Int>()
        register[CashRegisterKotlin.Coin.TWO_EURO] = 1
        register[CashRegisterKotlin.Coin.ONE_EURO] = 1
        register[CashRegisterKotlin.Coin.FIFTY_CENTS] = 2

        val paid = hashMapOf<CashRegisterKotlin.Coin, Int>()

        paid[CashRegisterKotlin.Coin.TWO_EURO] = 2
        paid[CashRegisterKotlin.Coin.FIFTY_CENTS] = 1
        paid[CashRegisterKotlin.Coin.TEN_CENTS] = 1
        paid[CashRegisterKotlin.Coin.FIVE_CENTS] = 1

        val price = 485

        val result = cashRegister.getChange(register, price, paid)

        assertNull(result)
    }

    @Test
    fun `test if paid more return change`() {
        val register = hashMapOf<CashRegisterKotlin.Coin, Int>()
        register[CashRegisterKotlin.Coin.TWO_EURO] = 1
        register[CashRegisterKotlin.Coin.ONE_EURO] = 1
        register[CashRegisterKotlin.Coin.FIFTY_CENTS] = 2
        register[CashRegisterKotlin.Coin.FIVE_CENTS] = 3

        val paid = hashMapOf<CashRegisterKotlin.Coin, Int>()
        paid[CashRegisterKotlin.Coin.FIVE_EURO] = 1

        val change = hashMapOf<CashRegisterKotlin.Coin?, Int?>()
        change[CashRegisterKotlin.Coin.FIVE_CENTS] = 3

        val price = 485

        val result = cashRegister.getChange(register, price, paid)

        assertEquals(change, result)
    }

    @Test
    fun `test if paid more with extra for change return change`() {
        val register = hashMapOf<CashRegisterKotlin.Coin, Int>()
        register[CashRegisterKotlin.Coin.TWO_EURO] = 1
        register[CashRegisterKotlin.Coin.ONE_EURO] = 1
        register[CashRegisterKotlin.Coin.TWENTY_CENTS] = 2

        val paid = hashMapOf<CashRegisterKotlin.Coin, Int>()
        paid[CashRegisterKotlin.Coin.FIVE_EURO] = 1
        paid[CashRegisterKotlin.Coin.FIVE_CENTS] = 1

        val change = hashMapOf<CashRegisterKotlin.Coin?, Int?>()
        change[CashRegisterKotlin.Coin.TWENTY_CENTS] = 1

        val price = 485

        val result = cashRegister.getChange(register, price, paid)

        assertEquals(change, result)
    }

}