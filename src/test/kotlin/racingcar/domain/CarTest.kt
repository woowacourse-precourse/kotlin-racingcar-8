package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차를 생성하면 초기 위치는 0이다`() {
        // given & when
        val car = Car("pobi")

        // then
        assertThat(car.getName()).isEqualTo("pobi")
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `자동차가 전진하면 위치가 1 증가한다`() {
        // given
        val car = Car("pobi")

        // when
        car.moveForward()

        // then
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `자동차가 여러 번 전진하면 위치가 누적된다`() {
        // given
        val car = Car("pobi")

        // when
        car.moveForward()
        car.moveForward()
        car.moveForward()

        // then
        assertThat(car.getPosition()).isEqualTo(3)
    }
}