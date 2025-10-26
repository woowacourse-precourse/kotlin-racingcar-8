package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상이면 자동차가 전진하거나 가지 않는다")
    fun move_shouldIncreaseOrStay() {
        val car = Car("pobi")
        val before = car.position

        car.move()

        assertThat(car.position).isGreaterThanOrEqualTo(before)
    }

    @Test
    @DisplayName("자동차 상태는 '이름 : ---' 형식으로 출력된다")
    fun getStatus_shouldReturnProperFormat() {
        val car = Car("pobi")
        car.move()
        val result = car.getStatus()

        assertThat(result)
            .startsWith("pobi")
            .contains(":")
    }
}
