package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AttemptTest {
    @Test
    fun `시도 횟수가 음수라면 예외로 처리한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Attempt(-1) }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123,", "1 ", " 2 ", " ", "abc"])
    fun `시도 횟수가 단일 숫자가 아니라면 예외로 처리한다`(userInput: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Attempt(userInput.toInt()) }
        }
    }

    @Test
    fun `시도 횟수가 최대 데이터 범위를 넘어가는 경우`() {
        val maxValue = ((Int.MAX_VALUE).toLong() + 1).toString()
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Attempt(maxValue.toInt()) }
        }
    }
}