package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `랜덤값이 4 이상이면 자동차가 전진한다`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `랜덤값이 3 이하면 자동차는 멈춘다`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
    }

    @Test
    fun `자동차 이름이 비어 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }
}
