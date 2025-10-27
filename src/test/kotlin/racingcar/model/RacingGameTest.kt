package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    @DisplayName("자동차 이름과 시도 횟수로 게임이 올바르게 설정된다")
    fun racingGameSetUpTest() {
        // given
        val game = RacingGame()
        game.setup("pobi,woni,jun", "5")

        // when
        val state = game.getCurrentState()

        // then
        assertThat(game.rounds).isEqualTo(5)
        assertThat(state).hasSize(3)
        assertThat(state).isEqualTo(listOf("pobi" to 0, "woni" to 0, "jun" to 0))
    }

    @Test
    @DisplayName("이동 후 상태를 올바르게 반환한다")
    fun afterMoveCarStateTest() {
        // given
        val generator = FakeNumberGenerator(listOf(5, 3))
        val game = RacingGame(generator)
        game.setup("pobi,woni", "1")

        // when
        game.runOneRound()
        val state = game.getCurrentState()

        // then
        assertThat(state).isEqualTo(listOf("pobi" to 1, "woni" to 0))
    }

    @Test
    @DisplayName("단독 우승자를 올바르게 반환한다")
    fun singleWinnerTest() {
        // given
        val generator = FakeNumberGenerator(listOf(5, 3, 2))
        val game = RacingGame(generator)
        game.setup("pobi,woni,jun", "1")

        // when
        game.runOneRound()
        val winners = game.getWinners()

        // then
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    @DisplayName("공동 우승자를 올바르게 반환한다")
    fun multipleWinnerTest() {
        // given
        val generator = FakeNumberGenerator(listOf(5, 3, 5))
        val game = RacingGame(generator)
        game.setup("pobi,woni,jun", "1")

        // when
        game.runOneRound()
        val winners = game.getWinners()

        // then
        assertThat(winners).containsExactly("pobi", "jun")
    }
}
