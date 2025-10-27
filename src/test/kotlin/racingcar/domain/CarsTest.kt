package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차 이름 목록으로 Cars 객체를 생성한다`() {
        val names = listOf("pobi", "woni", "jun")
        val cars = Cars.from(names)

        assertThat(cars.getCarStatus()).hasSize(3)
    }

    @Test
    fun `모든 자동차를 이동시킨다`() {
        val cars = Cars.from(listOf("pobi", "woni"))

        cars.moveAll { car -> car.move(4) }

        val status = cars.getCarStatus()
        assertThat(status).allMatch { it.second == 1 }
    }

    @Test
    fun `자동차 상태를 가져온다`() {
        val cars = Cars.from(listOf("pobi", "woni"))

        val status = cars.getCarStatus()

        assertThat(status).containsExactly(
            "pobi" to 0,
            "woni" to 0
        )
    }

    @Test
    fun `최대 이동 거리를 가진 자동차를 우승자로 찾는다`() {
        val car1 = Car("pobi", 3)
        val car2 = Car("woni", 5)
        val car3 = Car("jun", 2)
        val cars = Cars(listOf(car1, car2, car3))

        val winners = cars.findWinners()

        assertThat(winners).containsExactly("woni")
    }

    @Test
    fun `공동 우승자가 여러 명일 수 있다`() {
        val car1 = Car("pobi", 5)
        val car2 = Car("woni", 5)
        val car3 = Car("jun", 3)
        val cars = Cars(listOf(car1, car2, car3))

        val winners = cars.findWinners()

        assertThat(winners).containsExactly("pobi", "woni")
    }
}