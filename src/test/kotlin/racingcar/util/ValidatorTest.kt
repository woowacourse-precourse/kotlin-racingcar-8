package racingcar.util

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `라운드 수가 0이상이면 예외를 발생하지 않음`() {
        assertThatCode { Validator.validateRoundCheck(0) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `라운드 수가 음수면 예외 발생`() {
        assertThatCode { Validator.validateRoundCheck(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음수 라운드는 존재할 수 없습니다.")
    }

    @Test
    fun `모든 자동차 이름이 유효하면 예외가 발생하지 않음`() {
        val carNames = listOf("carA", "carB", "carC")

        assertThatCode { Validator.validateCarNames(carNames) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `자동차 이름이 비어 있으면 예외 발생`() {
        val carNames = listOf("carA", "", "carC")

        assertThatCode { Validator.validateCarNames(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름이 비어 있습니다")
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외 발생`() {
        val carNames = listOf("fivecar", "crong")

        assertThatCode { Validator.validateCarNames(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.")
    }
}