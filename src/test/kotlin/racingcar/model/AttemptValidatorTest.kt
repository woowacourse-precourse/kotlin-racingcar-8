package racingcar.model

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.model.domain.Attempt

class AttemptValidatorTest : NsTest() {

    @Nested
    @DisplayName("정상 입력")
    inner class NormalCase {
        @Test
        fun `정상 입력 테스트`() {
            assertSimpleTest {
                assertDoesNotThrow { runException("3") }
            }
        }
    }

    @Nested
    @DisplayName("예외")
    inner class Validator {
        @Test
        fun `음수 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("-1") }
            }
        }

        @Test
        fun `0회 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("0") }
            }
        }

        @Test
        fun `소수점 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("3.14") }
            }
        }

        @Test
        fun `숫자가 아닌 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("일") }
            }
        }

        @Test
        fun `공백 시도 횟수`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("\n") }
            }
        }


    }

    override fun runMain() {
        val input = Console.readLine()
        Attempt.toInt(input)
    }
}