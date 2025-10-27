package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
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

    @Test
    fun `전진_정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에_대한_예외_처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `시도_횟수에_대한_예외_처리_숫자아님`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    @Test
    fun `시도_횟수에_대한_예외_처리_음수`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `이름에_대한_예외_처리_공백`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,jun", "1") }
        }
    }

    @Test
    fun `이름에_대한_예외_처리_빈값`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `공동_우승자_처리`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "2")
                assertThat(output()).contains(
                    "pobi : -", "woni : -", "jun : ",
                    "pobi : --", "woni : --", "jun : -",
                    "최종 우승자 : pobi, woni"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `모든_자동차가_정지하는_경우`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains(
                    "pobi : ", "woni : ",
                    "최종 우승자 : pobi, woni"
                )
            },
            STOP, STOP
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
