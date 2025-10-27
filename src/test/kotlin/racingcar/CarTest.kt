package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarTest {
    @Test
    fun `랜덤 값이 4 이상이면 자동차 위치가 증가한다`() {
        val car = Car { 4 } // 항상 4 반환
        car.addCar(listOf("car1", "car2"))

        car.moveCar()

        assertThat(car.carsPosition).containsExactlyInAnyOrderEntriesOf(
            mapOf("car1" to 1, "car2" to 1)
        )
    }

    @Test
    fun `랜덤 값이 4 미만이면 자동차 위치가 증가하지 않는다`() {
        val car = Car { 3 } // 항상 3 반환
        car.addCar(listOf("car1", "car2"))

        car.moveCar()

        assertThat(car.carsPosition).containsExactlyInAnyOrderEntriesOf(
            mapOf("car1" to 0, "car2" to 0)
        )
    }
}