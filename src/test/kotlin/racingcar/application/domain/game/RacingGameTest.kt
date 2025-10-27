package racingcar.application.domain.game

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.application.domain.game.CarTest.FixedNumberProvider
import racingcar.domain.error.ErrorCode.RACE_MUST_HAVE_PROGRESS
import racingcar.domain.game.Car
import racingcar.domain.game.DefaultMoveRule
import racingcar.domain.game.RacingGame
import kotlin.test.assertEquals

class RacingGameTest {

    @Test
    fun `모든 자동차가 0칸 이동했을때 예외 발생`() {
        //given
        val game = RacingGame(listOf("pobi", "xodyd"))

        val attemptCount = 5

        //when
        val ex = assertThrows<IllegalArgumentException> {
            game.winnerResult(attemptCount)
        }
        assertEquals(RACE_MUST_HAVE_PROGRESS, ex.message)
    }
}