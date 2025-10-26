package racingcar.controller

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.*
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest

class RacingGameTest() {
    @Test
    fun `이동 결과 누적 테스트`() {
        assertSimpleTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"))
                val number = List(4) { 4 }
                val carsMover = CarsMover(
                    SingleCarMover(),
                    MovementRule(FakeRandomNumberGenerator((number)))
                )
                val game = RacingGame(cars, 2)
                game.start(carsMover)
                assertThat(cars.map { it.position }).containsExactly(2, 2)
            }
        )
    }

    @Test
    fun `랜덤 번호에 따른 위치 변화 테스트`() {
        assertSimpleTest(
            {
                val cars = listOf(Car("pobi"), Car("woni"))
                val mover = SingleCarMover()

                mover.move(
                    cars[0], MovementRule(
                        FakeRandomNumberGenerator(listOf(4, 3))
                    ).hasMoveAndStop()
                )

                val carMove = cars[0].position
                val carStop = cars[1].position

                assertThat(carMove).isEqualTo(1)
                assertThat(carStop).isEqualTo(0)
            }
        )
    }
}

