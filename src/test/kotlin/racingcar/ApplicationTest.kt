package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ApplicationTest : NsTest() {
    @ParameterizedTest
    @MethodSource("slowMotionRacing")
    fun `pobi와 jun이 승리하는 5턴 전체 게임 플레이`(currentRound: Round, randomNumbers: List<Int>, winner: List<Car>) {
        assertSimpleTest {
            assertThat(currentRound.tryMoveForward(randomNumbers).getWinners()).isEqualTo(winner)
        }
    }

    @Test
    fun `기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3

        @JvmStatic
        private fun slowMotionRacing(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Round(listOf(Car("pobi", 0), Car("jun", 0), Car("woni", 0))),
                    listOf(4, 3, 4),
                    listOf(Car("pobi", 1), Car("woni", 1))
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 1), Car("jun", 0), Car("woni", 1))),
                    listOf(4, 4, 4),
                    listOf(Car("pobi", 2), Car("woni", 2))
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 2), Car("jun", 1), Car("woni", 2))),
                    listOf(4, 4, 4),
                    listOf(Car("pobi", 3), Car("woni", 3))
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 3), Car("jun", 2), Car("woni", 3))),
                    listOf(4, 3, 4),
                    listOf(Car("pobi", 4), Car("woni", 4))
                ),
                Arguments.of(
                    Round(listOf(Car("pobi", 4), Car("jun", 3), Car("woni", 4))),
                    listOf(4, 4, 4),
                    listOf(Car("pobi", 5), Car("woni", 5))
                ),
            )
        }
    }
}
