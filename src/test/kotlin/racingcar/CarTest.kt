package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("무작위 숫자가 4 이상이면 자동차는 전진한다.")
    fun moveForwardWhenFourMore(){
        val car = Car("pobi")
        val randomNumber = 4

        car.moveForward(randomNumber)

        assertThat (car.position).isEqualTo(1)
    }

    @Test
    @DisplayName("무작위 숫자가 3 이하이면 자동차는 멈춘다.")
    fun stopWhenUnderThree(){
        val car = Car("jun")

        car.moveForward(5)
        car.moveForward(3)
        car.moveForward(9)

        assertThat (car.position).isEqualTo(2)
    }
}