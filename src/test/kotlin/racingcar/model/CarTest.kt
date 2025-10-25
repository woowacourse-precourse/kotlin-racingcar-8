package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    // given
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("tori")
    }

    @Test
    @DisplayName("자동차가 앞으로 움직이는지 테스트")
    fun `랜덤 값이 4이상일 때 자동차가 움직인다` () {
        assertRandomNumberInRangeTest(
            {
                // when
                car.moving()

                // then
                assertThat(car.moves).isEqualTo(1)
            }, MOVING_FORWARD
        )
    }

    @Test
    @DisplayName("자동차가 멈추는지 테스트")
    fun `랜덤 값이 4미만일 때 자동차가 멈춘다` () {
        assertRandomNumberInRangeTest(
            {
                // when
                car.moving()

                // then
                assertThat(car.moves).isEqualTo(0)
            }, STOP
        )
    }
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}