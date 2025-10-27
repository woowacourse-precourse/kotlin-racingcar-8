package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `모든 자동차가 한 번씩 전진한다`() {
        val cars = Cars(listOf(Car("pobi"), Car("woni")))
        cars.moveAll(listOf(4, 5)) // 모두 전진
        assertThat(cars.getStatus()).containsExactly("pobi : -", "woni : -")
    }

    @Test
    fun `최대 위치를 가진 자동차가 우승자로 선정된다`() {
        val pobi = Car("pobi")
        val woni = Car("woni")
        repeat(3) { pobi.move(4) } // pobi 3번 전진
        repeat(2) { woni.move(4) } // woni 2번 전진

        val cars = Cars(listOf(pobi, woni))
        val winners = cars.getWinners()

        assertThat(winners.map { it.name }).containsExactly("pobi")
    }
}
