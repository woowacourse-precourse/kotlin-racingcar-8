package racingcar.application.domain.game

import racingcar.domain.game.RacingCar
import racingcar.domain.rule.DefaultMoveRule
import racingcar.domain.port.NumberProvider

import kotlin.test.Test
import kotlin.test.assertEquals

class CarTest {

    class FixedNumberProvider(private val n: Int) : NumberProvider {
        override fun generateNumbers(): Int = n
    }

    @Test
    fun `한 라운드에 조건이 만족인 차만 전진`() {
        val racingCar = RacingCar("pobi")
        racingCar.race(FixedNumberProvider(4), DefaultMoveRule())
        assertEquals(1, racingCar.position)
    }

    @Test
    fun `한 라운드에 조건이 만족하지 않으면 차는 멈춘다`() {
        val racingCar = RacingCar("pobi")
        racingCar.race(FixedNumberProvider(3), DefaultMoveRule())
        assertEquals(0, racingCar.position)
    }

}