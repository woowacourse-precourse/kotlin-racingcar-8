package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("Car 객체 생성 시 초기 위치는 0이어야 한다.")
    fun `Car 객체 생성 시 초기 위치는 0이어야 한다`() {
        val car = Car("pobi")

        assertThat(car.position).isEqualTo(Car.INITIAL_POSITION)
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 position이 1 증가한 새로운 Car 객체를 반환한다.")
    fun `랜덤 값이 4 이상이면 position이 1 증가한다`() {
        val car = Car("pobi", 0)
        val numberGenerator = NumberGenerator { 4 }

        val movedCar = car.move(numberGenerator)

        assertThat(movedCar.position).isEqualTo(car.position + Car.MOVE_DISTANCE)
        assertThat(movedCar).isNotSameAs(car)
    }

    @Test
    @DisplayName("랜덤 값이 4 미만이면 position이 변하지 않은 기존 Car 객체를 반환한다.")
    fun `랜덤 값이 4 미만이면 position이 변하지 않는다`() {
        val car = Car("pobi", 0)
        val numberGenerator = NumberGenerator { 3 }

        val stoppedCar = car.move(numberGenerator)

        assertThat(stoppedCar.position).isEqualTo(car.position)
        assertThat(stoppedCar).isSameAs(car)
    }
}