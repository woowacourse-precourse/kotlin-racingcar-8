package racingcar.validator

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Test
    fun `정상적인 자동차 이름들은 예외가 발생하지 않는다`() {
        val validNames = listOf("pobi", "woni", "jun", "a", "12345")
        
        assertThatCode {
            InputValidator.validateCarNames(validNames)
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "\t", "\n"])
    fun `빈 값이나 공백만 있는 자동차 이름은 예외를 발생시킨다`(invalidName: String) {
        val invalidNames = listOf("pobi", invalidName, "jun")
        
        assertThatThrownBy {
            InputValidator.validateCarNames(invalidNames)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다")
    }

    @Test
    fun `6자 이상의 자동차 이름은 예외를 발생시킨다`() {
        val longName = "toolongname"
        
        assertThatThrownBy {
            InputValidator.validateCarNames(listOf(longName))
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 5자 이하여야 합니다")
    }

    @Test
    fun `자동차 이름 목록이 비어있으면 예외를 발생시킨다`() {
        val emptyNames = emptyList<String>()
        
        assertThatThrownBy {
            InputValidator.validateCarNames(emptyNames)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("최소 1대의 자동차가 필요합니다")
    }

    @Test
    fun `연속된 쉼표로 인한 빈 토큰이 있으면 예외를 발생시킨다`() {
        val namesWithEmptyToken = listOf("pobi", "", "jun")
        
        assertThatThrownBy {
            InputValidator.validateCarNames(namesWithEmptyToken)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 100])
    fun `양의 정수인 시도 횟수는 예외가 발생하지 않는다`(validCount: Int) {
        assertThatCode {
            InputValidator.validateRoundCount(validCount)
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -5, -100])
    fun `0 이하의 시도 횟수는 예외를 발생시킨다`(invalidCount: Int) {
        assertThatThrownBy {
            InputValidator.validateRoundCount(invalidCount)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도 횟수는 1 이상이어야 합니다")
    }
}