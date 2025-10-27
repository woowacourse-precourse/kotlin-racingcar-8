package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest : NsTest() {
    @Test
    fun `게임 진행 기능 테스트`() {
        // given
        val round = 3
        val cars = listOf(Car("pobi"), Car("tobi"))
        val racingGame = RacingGame(round, cars)

        // when
        assertRandomNumberInRangeTest(
            {
                racingGame.play()
                // then
                assertThat(output()).contains("\n실행 결과", "pobi : ---", "tobi : --")
            }, MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `게임 진행 결과 반환 기능 테스트`() {
        // given
        val round = 3
        val cars = listOf(Car("pobi"), Car("tobi"), Car("jun"))
        val racingGame = RacingGame(3, cars)

        // when
        assertRandomNumberInRangeTest(
            {
                racingGame.play()
            }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        )

        // then
        assertThat(racingGame.getWinners()).extracting("name").containsOnly("pobi", "jun")
    }

    override fun runMain() {
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}