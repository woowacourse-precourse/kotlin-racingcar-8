package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `Car는 자동차 이름, 초기 점수 0점을 가짐`() {
        val car = Car("testCar")

        assertThat(car.name).isEqualTo("testCar")
        assertThat(car.score).isEqualTo(0)
    }

    @Test
    fun `자동차 점수 추가 로직 확인`() {
        var car = Car("testCar")
        car.score++

        assertThat(car.score).isEqualTo(1)
    }
}