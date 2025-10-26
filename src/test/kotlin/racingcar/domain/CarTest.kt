package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("전진 전략(true)을 받으면 position이 1 증가한 새 Car 객체를 반환한다")
    fun `move_WhenCanMove_ReturnsNewCarWithIncrementedPosition`() {
        val car = Car("pobi", 0)
        val moveStrategy = MoveStrategy { true }

        val movedCar = car.move(moveStrategy)

        assertThat(movedCar).isEqualTo(Car("pobi", 1))
        assertThat(movedCar).isNotSameAs(car)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    @DisplayName("정지 전략(false)을 받으면 position이 변하지 않은 기존 객체를 반환한다")
    fun `move_WhenCannotMove_ReturnsSameCar`() {
        val car = Car("pobi", 0)
        val moveStrategy = MoveStrategy { false }

        val movedCar = car.move(moveStrategy)

        assertThat(movedCar).isEqualTo(Car("pobi", 0))
        assertThat(movedCar).isSameAs(car)
    }

    @Test
    @DisplayName("getPositionString이 position만큼 '-'를 반환한다")
    fun `getPositionString_ReturnsCorrectString`() {
        val car = Car("jun", 3)

        val positionString = car.getPositionString()

        assertThat(positionString).isEqualTo("---")
    }
}
