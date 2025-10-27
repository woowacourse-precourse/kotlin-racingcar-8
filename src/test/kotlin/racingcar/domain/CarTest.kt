package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 생성 시 초기 위치는 0이다`() {
        val car = Car("pobi")

        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `무작위 값이 4 이상이면 전진한다`() {
        val car = Car("pobi")

        car.move(4)

        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 4 미만이면 정지한다`() {
        val car = Car("pobi")

        car.move(3)

        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `여러 번 전진할 수 있다`() {
        val car = Car("pobi")

        car.move(4)
        car.move(5)
        car.move(9)

        assertThat(car.getPosition()).isEqualTo(3)
    }
}
