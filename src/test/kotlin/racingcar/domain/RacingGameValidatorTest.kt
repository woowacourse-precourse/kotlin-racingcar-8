package racingcar.domain

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameValidatorTest {

    private val validator: GameValidator = RacingGameValidator

    @Test
    @DisplayName("올바른 자동차 이름은 예외를 발생시키지 않는다")
    fun `validateCarNames_WithValidNames_DoesNotThrowException`() {
        val validNames = "pobi,woni,jun"

        assertThatCode {
            validator.validateCarNames(validNames)
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,woni,javaji", "longname", ",pobi", "pobi,,jun"])
    @DisplayName("5자를 초과하거나 공백인 이름이 있으면 IllegalArgumentException을 발생시킨다")
    fun `validateCarNames_WithInvalidNames_ThrowsIllegalArgumentException`(invalidNames: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { validator.validateCarNames(invalidNames) }
    }

    @Test
    @DisplayName("올바른 시도 횟수는 예외를 발생시키지 않는다")
    fun `validateRaceCount_WithValidCount_DoesNotThrowException`() {
        val validCount = "5"

        assertThatCode {
            validator.validateRaceCount(validCount)
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "0", "-1", "1.5"])
    @DisplayName("숫자가 아니거나 0 이하인 시도 횟수는 IllegalArgumentException을 발생시킨다")
    fun `validateRaceCount_WithInvalidCount_ThrowsIllegalArgumentException`(invalidCount: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { validator.validateRaceCount(invalidCount) }
    }
}
