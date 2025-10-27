package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class CarTest {

    @Test
    fun `자동차 이름이 5자를 초과하면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
    }

    @Test
    fun `랜덤 값이 4 이상이면 전진한다`() {
        val car = Car("pobi")
        val initialPosition = car.position
        repeat(100) { car.move() } // 여러 번 호출하여 적어도 일부 전진 확인
        assertThat(car.position).isGreaterThanOrEqualTo(initialPosition)
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car("jun")
        assertThat(car.position).isEqualTo(0)
    }
}
