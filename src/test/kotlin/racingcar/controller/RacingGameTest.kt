package racingcar.controller


import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.applicationTest.ApplicationTest.Companion.MOVING_FORWARD
import racingcar.applicationTest.ApplicationTest.Companion.STOP
import racingcar.model.CarsMover
import racingcar.model.MovementRule
import racingcar.model.SingleCarMover

class RacingGameTest() {
    @Test
    fun `이동 결과 누적 테스트`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"))
                val carsMover = CarsMover(
                    SingleCarMover(),
                    MovementRule()
                )
                val game = RacingGame(cars, 2)
                game.start(carsMover)
                assertThat(cars.map { it.position }).containsExactly(2, 2)
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `이동 조건이 랜덤일 때 결과 테스트`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"))
                val carsMover = CarsMover(
                    SingleCarMover(),
                    MovementRule()
                )
                val game = RacingGame(cars, 1)

                game.start(carsMover)

                val carMove = cars[0].position
                val carStop = cars[1].position

                assertThat(carMove).isEqualTo(1)
                assertThat(carStop).isEqualTo(0)
            },
            MOVING_FORWARD, STOP
        )
    }
}

