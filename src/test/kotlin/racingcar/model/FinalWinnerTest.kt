package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FinalWinnerTest() {
    @Test
    fun `단독 우승자 테스트`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("Woni", 1)
        )
        val winner = FinalWinner()
        val finalWinner = winner.findWinners(cars)

        assertThat(finalWinner).contains("pobi")
    }

    @Test
    fun `공동 우승자인 경우 테스트`() {
        val cars = listOf(
            Car("pobi", 3),
            Car("woni", 3)
        )
        val winner = FinalWinner()
        val finalWinner = winner.findWinners(cars)

        assertThat(finalWinner).contains("pobi", "woni")
    }

    @Test
    fun `모두 전진하지 못하고 위치가 0일때`() {
        val cars = listOf(
            Car("pobi", 0),
            Car("woni", 0),
            Car("jun", 0)
        )
        val winner = FinalWinner()
        val finalWinner = winner.findWinners(cars)

        assertThat(finalWinner).contains("pobi", "woni", "jun")
    }
}

