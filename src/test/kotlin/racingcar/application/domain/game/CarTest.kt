package racingcar.application.domain.game

import racingcar.domain.game.Car
import racingcar.domain.game.DefaultMoveRule
import racingcar.domain.game.NumberProvider

import kotlin.test.Test
import kotlin.test.assertEquals

class CarTest {

    class FixedNumberProvider(private val n: Int) : NumberProvider {
        override fun generateNumbers(): Int = n
    }

    @Test
    fun `한 라운드에 조건이 만족인 차만 전진`() {
        val car = Car("pobi")
        car.race(FixedNumberProvider(4), DefaultMoveRule())
        assertEquals(1, car.position)
    }

    @Test
    fun `한 라운드에 조건이 만족하지 않으면 차는 멈춘다`() {
        val car = Car("pobi")
        car.race(FixedNumberProvider(3), DefaultMoveRule())
        assertEquals(0, car.position)
    }

}