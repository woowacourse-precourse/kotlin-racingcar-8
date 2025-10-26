package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    @DisplayName("playRound는 모든 자동차의 move를 실행하고 새로운 RacingGame 객체를 반환한다")
    fun `playRound_MovesAllCars_ReturnsNewRacingGame`() {
        val cars = listOf(Car("pobi", 0), Car("woni", 1))
        val game = RacingGame(cars)
        val alwaysMove = MoveStrategy { true }

        val nextGame = game.playRound(alwaysMove)

        assertThat(nextGame).isNotSameAs(game)
        assertThat(nextGame.cars).extracting("position").containsExactly(1, 2)
    }

    @Test
    @DisplayName("getWinners는 가장 멀리 간 자동차를 정확히 반환한다 (단독 우승)")
    fun `getWinners_WhenOneWinner_ReturnsCorrectCar`() {
        val winner = Car("pobi", 5)
        val cars = listOf(winner, Car("woni", 3), Car("jun", 4))
        val game = RacingGame(cars)

        val winners = game.getWinners()

        assertThat(winners).containsExactly(winner)
    }

    @Test
    @DisplayName("getWinners는 가장 멀리 간 자동차들을 모두 반환한다 (공동 우승)")
    fun `getWinners_WhenMultipleWinners_ReturnsAllCorrectCars`() {
        val winner1 = Car("pobi", 5)
        val winner2 = Car("jun", 5)
        val cars = listOf(winner1, Car("woni", 3), winner2)
        val game = RacingGame(cars)

        val winners = game.getWinners()

        assertThat(winners).containsExactlyInAnyOrder(winner1, winner2)
    }

    @Test
    @DisplayName("getWinners는 자동차가 없을 때 빈 리스트를 반환한다")
    fun `getWinners_WhenNoCars_ReturnsEmptyList`() {
        val game = RacingGame(emptyList())

        val winners = game.getWinners()

        assertThat(winners).isEmpty()
    }
}
