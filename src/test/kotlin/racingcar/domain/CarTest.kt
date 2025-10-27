package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `자동차 생성 시 초기 위치는 0이다`() {
        val car = Car("pobi")

        assertThat(car.getPosition()).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `무작위 값이 4 이상이면 전진한다`(randomValue: Int) {
        val car = Car("pobi")
        car.move(randomValue)

        assertThat(car.getPosition()).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `무작위 값이 4 미만이면 정지한다`(randomValue: Int) {
        val car = Car("pobi")
        car.move(randomValue)

        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `여러 번 전진할 수 있다`() {
        val car = Car("pobi")
        car.move(4)
        car.move(5)
        car.move(9)

        assertThat(car.getPosition()).isEqualTo(3)
    }

    @Test
    fun `자동차 이름을 가져올 수 있다`() {
        val car = Car("pobi")

        assertThat(car.name).isEqualTo("pobi")
    }
}