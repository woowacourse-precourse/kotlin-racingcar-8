package racingcar.controller

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarControllerTest {
    @Test
    fun `자동차 여러대가 동시에 움직이거나 멈출 수 있다` () {
        // given
        val carList = listOf(Car("tori"), Car("pobi"), Car("woni"))
        val afterMove = listOf(1, 1, 0)
        val carController = CarController(carList)

        assertRandomNumberInRangeTest(
            {
                // when
                carController.currentMoving()

                // then
                assertThat(carList.map{ it.moves }).isEqualTo(afterMove)
            }, 4, 4, 3
        )
    }

    @Test
    fun `가장 많이 움직인 자동차가 우승자다` () {
        val carList = listOf(
            Car("tori").apply { moves = 1 },
            Car("pobi").apply { moves = 1 },
            Car("woni").apply { moves = 0 }
        )
        val carController = CarController(carList)
        val winner = listOf("tori", "pobi")

        // when & then
        assertThat(carController.winner()).isEqualTo(winner)
    }
}