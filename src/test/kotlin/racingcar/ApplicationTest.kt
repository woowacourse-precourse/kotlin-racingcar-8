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
    fun `자동차 이름이 비어있을 때 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,woni", "1") }
        }
    }

    @Test
    fun `자동차 이름에 문자가 아닌 값이 있을 때 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,123", "1") }
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아닐 때 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    @Test
    fun `시도 횟수가 0 이하일 때 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `시도 횟수가 음수일 때 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
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
