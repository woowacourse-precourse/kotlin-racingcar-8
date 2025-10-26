package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.racing.NumberPicker
import racingcar.exception.ErrorMessage

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class ApplicationTest : NsTest() {
    @Test
    fun 기능_테스트() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun ", "5")
                assertThat(output()).contains(
                    """
                        실행 결과
                        pobi : -
                        woni : 
                        jun : -

                        pobi : --
                        woni : -
                        jun : --

                        pobi : ---
                        woni : --
                        jun : ---

                        pobi : ----
                        woni : ---
                        jun : ----

                        pobi : -----
                        woni : ----
                        jun : -----
                    """.trimIndent(),
                    "최종 우승자 : pobi, jun"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun 이름이_비어있으면_IllegalArgumentException이_발생한다() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,,", "1") }
            assertEquals(exception.message, ErrorMessage.CAR_NAME_BLANK.message)
        }
    }

    @Test
    fun 이름이_다섯_자리를_넘으면_IllegalArgumentException이_발생한다() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
            assertEquals(exception.message, ErrorMessage.CAR_NAME_TOO_LONG.message)
        }
    }

    @Test
    fun 시도할_횟수가_비어있으면_IllegalArgumentException이_발생한다() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", " ") }
            assertEquals(exception.message, ErrorMessage.ATTEMPT_COUNT_BLANK.message)
        }
    }

    @Test
    fun 시도할_횟수가_정수가_아니라면_llegalArgumentException이_발생한다() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
            assertEquals(exception.message, ErrorMessage.ATTEMPT_COUNT_NOT_INTEGER.message)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
