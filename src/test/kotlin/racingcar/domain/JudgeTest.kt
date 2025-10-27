package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JudgeTest {
    @Test
    fun `우승자를 판별한다`() {
        // given
        val cars = mutableListOf<Car>()
        val car1 = Car("h1", RandomNumberGenerator())
        val car2 = Car("h2", RandomNumberGenerator())
        val car3 = Car("h3", RandomNumberGenerator())

        car1.distance = 1
        car2.distance = 2
        car3.distance = 2

        cars.add(element = car1)
        cars.add(element = car2)
        cars.add(element = car3)

        // when
        val judge = Judge()

        // then
        assertEquals(listOf("h2", "h3"), judge.judgeWinner(cars))
    }
}