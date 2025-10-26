package racingcar.validator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {
    @Test
    fun `자동차 이름이 5자 이하면 통과한다`() {
        val names = listOf("pobi", "crong", "honux")

        InputValidator.validateCarNames(names)
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외가 발생한다`() {
        val names = listOf("pobi", "javaji")

        assertThatThrownBy { InputValidator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름이 빈 문자열이면 예외가 발생한다`() {
        val names = listOf("pobi", "")

        assertThatThrownBy { InputValidator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `시도 횟수가 양수면 통과한다`() {
        val result = InputValidator.validateRoundCount("5")

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `시도 횟수가 양수가 아니면 예외가 발생한다`() {
        assertThatThrownBy { InputValidator.validateRoundCount("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`() {
        assertThatThrownBy { InputValidator.validateRoundCount("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
