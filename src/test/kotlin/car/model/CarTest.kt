package car.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차가 전진하면 위치가 1 증가한다`() {
        val car = Car("pobi", 0)
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `자동차 위치를 대시로 표현한다`() {
        val car = Car("pobi", 3)
        assertThat(car.getPositionDisplay()).isEqualTo("---")
    }

    @Test
    fun `자동차 초기 위치는 0이다`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }
}

