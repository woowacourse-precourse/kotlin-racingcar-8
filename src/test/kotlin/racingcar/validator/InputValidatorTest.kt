package racingcar.validator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Test
    fun `자동차 이름을 쉼표로 분리한다`() {
        val input = "pobi,woni,jun"
        val result = InputValidator.validateCarNames(input)

        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `자동차 이름 앞뒤 공백을 제거한다`() {
        val input = " pobi , woni , jun "
        val result = InputValidator.validateCarNames(input)

        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `자동차 이름이 빈 값이면 예외가 발생한다`(input: String) {
        assertThatThrownBy { InputValidator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("빈 값")
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외가 발생한다`() {
        val input = "pobi,wonderfulname"

        assertThatThrownBy { InputValidator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("5자 이하")
    }

    @Test
    fun `자동차 이름에 중복이 있으면 예외가 발생한다`() {
        val input = "pobi,woni,pobi"

        assertThatThrownBy { InputValidator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("중복")
    }

    @Test
    fun `시도 횟수가 유효한 숫자면 정수로 반환한다`() {
        val result = InputValidator.validateRounds("5")

        assertThat(result).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1.5", ""])
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`(input: String) {
        assertThatThrownBy { InputValidator.validateRounds(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1"])
    fun `시도 횟수가 양수가 아니면 예외가 발생한다`(input: String) {
        assertThatThrownBy { InputValidator.validateRounds(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("양수")
    }
}