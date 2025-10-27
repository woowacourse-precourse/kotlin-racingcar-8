package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `유효한 자동차 이름을 검증한다`() {
        val names = listOf("pobi", "woni", "jun")

        InputValidator.validateCarNames(names)
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외가 발생한다`() {
        val names = listOf("pobi", "toolong")

        assertThatThrownBy { InputValidator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("5자 이하")
    }

    @Test
    fun `자동차 이름이 중복되면 예외가 발생한다`() {
        val names = listOf("pobi", "pobi", "jun")

        assertThatThrownBy { InputValidator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("중복")
    }

    @Test
    fun `자동차 이름이 공백이면 예외가 발생한다`() {
        val names = listOf("pobi", "", "jun")

        assertThatThrownBy { InputValidator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("공백")
    }

    @Test
    fun `자동차 이름이 없으면 예외가 발생한다`() {
        val names = emptyList<String>()

        assertThatThrownBy { InputValidator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("최소 1개")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10])
    fun `유효한 시도 횟수를 검증한다`(count: Int) {
        InputValidator.validateAttemptCount(count)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -10])
    fun `시도 횟수가 0 이하면 예외가 발생한다`(count: Int) {
        assertThatThrownBy { InputValidator.validateAttemptCount(count) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("1 이상")
    }
}