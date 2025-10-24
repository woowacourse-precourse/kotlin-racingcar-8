package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerCalculatorTest {

    @Test
    fun `공동 우승자 선정`() {
        val cars = mutableListOf<Car>(Car("A", 5), Car("B", 5), Car("C", 3))
        assertEquals(listOf("A","B"), WinnerCalculator.calculateWinners(cars))
    }

    @Test
    fun `단독 우승자 선정`() {
        val cars = mutableListOf<Car>(Car("A", 3), Car("B", 2), Car("C", 1))
        assertEquals(listOf("A"), WinnerCalculator.calculateWinners(cars))
    }

}