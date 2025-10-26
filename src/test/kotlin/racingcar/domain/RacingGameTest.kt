package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `우승자는 가장 높은 점수를 가진 자동차`() {
        val carA = Car("carA", 3)
        val carB = Car("carB", 5)
        val carC = Car("carC", 10)
        val game = RacingGame(listOf(carA, carB, carC))

        val winner = game.winner()

        assertThat(winner.map { it.name })
            .containsExactly("carC")
    }

    @Test
    fun `모두가 동일한 점수라면 모두 우승자`() {
        val cars = listOf(Car("carA", 1), Car("carB", 1), Car("carC", 1))
        val game = RacingGame(cars)

        val winner = game.winner()

        assertThat(winner.map { it.name })
            .containsExactlyInAnyOrder("carA", "carB", "carC")
    }
}