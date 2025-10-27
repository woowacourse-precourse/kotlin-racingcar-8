package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTest {
    @Test
    fun `시도 횟수가 0 이하일 경우 예외가 발생한다`() {
        val cars = listOf(Car("1234"))
        val exception = assertThrows<IllegalArgumentException> { Race(0, cars) }
        assertThat(exception.message).contains("시도 횟수는 1 이상의 숫자이어야 합니다.")
    }

    @Test
    fun `시도 횟수만큼 라운드를 반복하며 진행한다`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val race = Race(3, cars)

        val result = race.start { 9 }
        assertThat(cars.all { it.position == 3 }).isTrue()
        assertThat(result.progress()).contains("pobi : ---", "woni : ---")
    }

    @Test
    fun `우승자를 올바르게 결정한다`() {
        val cars = listOf(Car("pobi"), Car("jun"))
        val race = Race(1, cars)

        val result = race.start { 9 }
        assertThat(result.winners).containsExactlyInAnyOrder("pobi", "jun")
    }
}