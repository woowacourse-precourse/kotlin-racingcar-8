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
    fun `이름 5자 초과 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `이름 입력 시 공백 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi, ,jun", "1")
            }
        }
    }

    @Test
    fun `라운드 횟수에 숫자가 아닌 값 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "two")
            }
        }
    }

    @Test
    fun `라운드 반복 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output())
                    .contains(
                        "실행 결과",
                        "pobi : -",
                        "woni : ",
                        "pobi : --",
                        "woni : -"
                    )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `라운드 횟수 0 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,woni", "0")
            }
        }
    }

    @Test
    fun `공동 우승자 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
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
