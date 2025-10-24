package racingcar.util

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {
    @Test
    fun `이름이 5자를 초과하면 IllegalArgumentException을 던진다`() {
        assertThatThrownBy {
            InputValidator.validateCarNames(listOf("pobiii"))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("5자를 초과")
    }

    @Test
    fun `이름이 공백이거나 비어있으면 IllegalArgumentException을 던진다`() {
        assertThatThrownBy {
            InputValidator.validateCarNames(listOf(" "))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("공백")
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 IllegalArgumentException을 던진다`() {
        assertThatThrownBy {
            InputValidator.validateTryCount("일")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("유효하지 않은 값")
    }

    @Test
    fun `시도 횟수가 0 이하이면 IllegalArgumentException을 던진다`() {
        assertThatThrownBy {
            InputValidator.validateTryCount("-2")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("음수")
    }

    @Test
    fun `유효한 이름과 시도 횟수는 예외를 던지지 않는다`() {
        assertThatCode {
            InputValidator.validateCarNames(listOf("pobi"))
            InputValidator.validateTryCount("2")
        }
            .doesNotThrowAnyException()
    }
}