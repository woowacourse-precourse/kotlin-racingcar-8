package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
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

    @Nested
    @DisplayName("예외 테스트")
    inner class ExceptionTest {

        @Test
        fun `1-빈 문자`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("", "3")
                }
            }
        }

        @Test
        fun `2-연속 쉼표`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi,,,", "3")
                }
            }
        }

        @Test
        fun `3-5자 초과(구분자 미사용)`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi:woni", "3")
                }
            }
        }

        @Test
        fun `4-5자 초과`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pooooobi", "3")
                }
            }
        }

        @Test
        fun `8-음수 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi,woni", "-1")
                }
            }
        }

        @Test
        fun `9-0회 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi,woni", "0")
                }
            }
        }

        @Test
        fun `10-소수점 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi,woni", "3.14")
                }
            }
        }

        @Test
        fun `11-숫자가 아닌 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi,woni", "일")
                }
            }
        }

        @Test
        fun `12-공백 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException("pobi,woni", "\n")
                }
            }
        }
    }

    @Nested
    @DisplayName("정상 입력 테스트")
    inner class NormalTest {

        @Test
        fun `5-space 사용`() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi,wo ni", "1")
                    assertThat(output()).contains("최종 우승자")
                },
                MOVING_FORWARD, STOP
            )
        }

        @Test
        fun `6-중복 이름`() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi,pobi,pobi", "1")
                    assertThat(output()).contains("최종 우승자 : pobi")
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            )
        }

        @Test
        fun `7-이름으로 숫자 입력`() {
            assertRandomNumberInRangeTest(
                {
                    run("jun32", "1")
                    assertThat(output()).contains("최종 우승자 : jun32")
                },
                MOVING_FORWARD
            )
        }

        @Test
        fun `13-3회 시도`() {
            assertRandomNumberInRangeTest(
                {
                    run("pobi", "3")
                    assertThat(output()).contains("최종 우승자 : pobi")
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
            )
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
