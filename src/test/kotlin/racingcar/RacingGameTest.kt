package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `게임을 생성한다`() {
        val carNames = listOf("pobi", "woni", "jun")
        val game = RacingGame(carNames)

        assertThat(game).isNotNull
    }

    @Test
    fun `라운드를 진행한다`() {
        val carNames = listOf("pobi", "woni")
        val game = RacingGame(carNames)

        game.playRound()
        val status = game.getCurrentStatus()

        assertThat(status).contains("pobi :")
        assertThat(status).contains("woni :")
    }

    @Test
    fun `현재 상태를 문자열로 반환한다`() {
        val carNames = listOf("pobi")
        val game = RacingGame(carNames)

        val status = game.getCurrentStatus()

        assertThat(status).isEqualTo("pobi : ")
    }

    @Test
    fun `우승자를 찾는다`() {
        val carNames = listOf("pobi", "woni", "jun")
        val game = RacingGame(carNames)

        repeat(5) {
            game.playRound()
        }

        val winners = game.getWinners()

        assertThat(winners).isNotEmpty()
    }

    @Test
    fun `우승자가 여러 명일 수 있다`() {
        val carNames = listOf("car1", "car2", "car3", "car4", "car5")
        val game = RacingGame(carNames)

        repeat(10) {
            game.playRound()
        }

        val winners = game.getWinners()

        assertThat(winners.size).isGreaterThanOrEqualTo(1)
    }
}