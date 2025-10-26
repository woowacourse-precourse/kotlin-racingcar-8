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
    fun `여러 시도 횟수 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "3")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `다중 우승자 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `중복 이름 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,pobi", "2")
                assertThat(output()).contains("최종 우승자 : pobi, pobi")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `이름 길이 초과 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobiii,woni", "1") }
        }
    }

    @Test
    fun `자연수 아닌 시도 횟수 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `빈 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(",pobi", "1") }
        }
    }

    @Test
    fun `이름 사이 여백 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("   pobi   , woni ", "3")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
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
