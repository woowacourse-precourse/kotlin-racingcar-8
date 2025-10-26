package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CheckWinnerTest {
    @Test
    fun `check winner`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 3),
            Car("jun", 2),
            Car("tom", 1)
        )

        val winners = checkWinner(cars)

        assertThat(winners).containsExactly("pobi", "woni")
    }
}