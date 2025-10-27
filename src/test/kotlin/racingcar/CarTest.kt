package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `이름이 1~5자면 유효하다`() {
        assertThat(Car("pobi").name).isEqualTo("pobi")
    }

    @Test
    fun `이름이 6자 이상이면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> { Car("pobiii") }
        assertThat(exception.message).isEqualTo("자동차 이름은 1자 이상, 5자 이하만 가능합니다.")
    }

    @Test
    fun `이름이 0자이면 예외가 발생한다`() {
        val exception = assertThrows<IllegalArgumentException> { Car("") }
        assertThat(exception.message).isEqualTo("자동차 이름은 1자 이상, 5자 이하만 가능합니다.")
    }

    @Test
    fun `랜덤 값이 4 이상이면 전진한다`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `랜덤 값이 3 이하면 멈춘다`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }
}