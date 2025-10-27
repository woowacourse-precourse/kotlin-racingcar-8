package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차가 전진한다`() {
        val car = Car("pobi")
        car.move(4)

        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `랜덤 값이 4 미만이면 정지한다`() {
        val car = Car("pobi")
        car.move(3)

        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `여러 번 이동할 수 있다`() {
        val car = Car("pobi")
        car.move(4)
        car.move(5)
        car.move(3)
        car.move(9)

        assertThat(car.getPosition()).isEqualTo(3)
    }

    @Test
    fun `위치를 문자열로 표시한다`() {
        val car = Car("pobi")
        car.move(4)
        car.move(5)

        assertThat(car.getPositionDisplay()).isEqualTo("--")
    }
}