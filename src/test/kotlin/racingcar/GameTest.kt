package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest : NsTest() {

    @Test
    fun `우승자가 한 명일 때`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,crong,honux", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "crong : ",
                    "honux : ",
                    "최종 우승자 : pobi"
                )
            },
            MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `우승자가 두 명 이상일 때`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,crong,honux", "1")
                assertThat(output()).contains(
                    "pobi : -",
                    "crong : -",
                    "honux : ",
                    "최종 우승자 : pobi, crong"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `자동차 이름이 5자를 넘는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,looong", "1")
            }
        }
    }

    @Test
    fun `자동차 이름이 비어있는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,,crong", "1")
            }
        }
    }

    @Test
    fun `입력이 없는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("", "1")
            }
        }
    }

    @Test
    fun `공백이 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("   ", "1")
            }
        }
    }

    @Test
    fun `자동차 이름이 중복인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,pobi", "1")
            }
        }
    }

    @Test
    fun `라운드 횟수가 숫자가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,crong", "abc")
            }
        }
    }

    @Test
    fun `라운드 횟수가 음수인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,crong", "-1")
            }
        }
    }

    @Test
    fun `라운드 횟수가 0인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("pobi,crong", "0")
            }
        }
    }

    @Test
    fun `쉼표만 입력한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(",,,", "1")
            }
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
