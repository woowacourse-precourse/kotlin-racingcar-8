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
    fun `예외 테스트 -시도 횟수에 문자열 입력 시`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("ka", "김")
            }
        }
    }

    @Test
    fun `렌덤값이 4이상이면 자동차 전진한다`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output().contains("pobi : -"))
            },
            4
        )
    }

    @Test
    fun `단독우승자 있는 경우`(){
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output().contains("최종우승자: pobi"))
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `공동 우승자 있는 경우`(){
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output().contains("최종우승자: pobi, woni"))
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
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
