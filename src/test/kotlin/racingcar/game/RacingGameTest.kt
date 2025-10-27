package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Cars

class RacingGameTest {

    @Test
    fun `게임을 한 라운드 진행하면 모든 자동차가 이동 판단을 받는다`() {
        // given
        val cars = Cars(listOf("pobi", "woni"))
        var callCount = 0
        val testMoveDecider = object : MoveDecider {
            override fun shouldMove(): Boolean {
                callCount++
                return true
            }
        }
        val game = RacingGame(cars, testMoveDecider)

        // when
        game.playRound()

        // then
        assertThat(callCount).isEqualTo(2)  // 자동차 2대
    }

    @Test
    fun `게임을 여러 라운드 진행하면 라운드 수만큼 반복된다`() {
        // given
        val cars = Cars(listOf("pobi"))
        var callCount = 0
        val testMoveDecider = object : MoveDecider {
            override fun shouldMove(): Boolean {
                callCount++
                return false
            }
        }
        val game = RacingGame(cars, testMoveDecider)

        // when
        game.playGame(3)  // 3라운드

        // then
        assertThat(callCount).isEqualTo(3)  // 1대 × 3라운드
    }

    @Test
    fun `게임 진행 중 각 라운드 결과를 반환한다`() {
        // given
        val cars = Cars(listOf("pobi", "woni"))
        val alwaysMove = object : MoveDecider {
            override fun shouldMove() = true
        }
        val game = RacingGame(cars, alwaysMove)

        // when
        game.playRound()
        val result = game.getRoundResult()

        // then
        assertThat(result).hasSize(2)
        assertThat(result).allMatch { car -> car.getPosition() == 1 }
    }

    @Test
    fun `게임 종료 후 우승자를 반환한다`() {
        // given
        val cars = Cars(listOf("pobi", "woni"))
        val alwaysMove = object : MoveDecider {
            override fun shouldMove() = true
        }
        val game = RacingGame(cars, alwaysMove)

        // when
        game.playGame(1)
        val winners = game.getWinners()

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni")
    }
}