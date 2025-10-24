package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Car 생성 시 position은 0이다`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `move() 호출 시 4 이상이면 position이 1 증가한다`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `move() 호출 시 3 이하이면 position이 0을 유지한다`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }
}