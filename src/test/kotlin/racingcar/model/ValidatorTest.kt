package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @Test
    @DisplayName("자동차 이름 목록이 유효하면 예외가 발생하지 않는다.")
    fun `유효한 자동차 이름 목록`() {
        val validCarNames = listOf("pobi", "crong", "hynw")

        Assertions.assertThatCode {
            Validator.validateCarNames(validCarNames)
        }.doesNotThrowAnyException()
    }

    @Test
    @DisplayName("자동차 이름에 5글자를 초과하는 이름이 있으면 예외를 발생시킨다.")
    fun `자동차 이름 길이 초과 예외`() {
        val invalidCarNames = listOf("pobi", "hyunwu")

        Assertions.assertThatThrownBy {
            Validator.validateCarNames(invalidCarNames)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.ERROR_CAR_NAME_TOO_LONG)
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 예외를 발생시킨다.")
    fun `자동차 이름 중복 예외`() {
        val duplicatedCarNames = listOf("pobi", "hynw", "pobi")

        Assertions.assertThatThrownBy {
            Validator.validateCarNames(duplicatedCarNames)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.ERROR_DUPLICATE_CAR_NAME)
    }

    @Test
    @DisplayName("자동차 이름 목록이 비어있으면 예외를 발생시킨다.")
    fun `자동차 이름 목록 없음 예외`() {
        val emptyCarNames = emptyList<String>()

        Assertions.assertThatThrownBy {
            Validator.validateCarNames(emptyCarNames)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Validator.ERROR_NO_CAR_NAMES)
    }

    @Test
    @DisplayName("자동차 이름이 공백이면 예외를 발생시킨다.")
    fun `자동차 이름 공백 예외`() {
        val invalidNames = listOf("pobi", " ")

        Assertions.assertThatThrownBy {
            Validator.validateCarNames(invalidNames)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.ERROR_BLANK_CAR_NAME)
    }

    @Test
    @DisplayName("자동차 이름이 빈 문자열이면 예외를 발생시킨다.")
    fun `자동차 이름 빈 문자열 예외`() {
        val invalidNames = listOf("pobi", "")

        Assertions.assertThatThrownBy {
            Validator.validateCarNames(invalidNames)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.ERROR_BLANK_CAR_NAME )
    }

    @DisplayName("시도 횟수가 유효하면 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = ["1", "12", "4"])
    fun `유효한 시도 횟수`(input: String) {
        Assertions.assertThatCode {
            Validator.validateRepeatNum(input)
        }.doesNotThrowAnyException()
    }

    @Test
    @DisplayName("시도 횟수가 빈 문자열이면 예외를 발생시킨다.")
    fun `시도 횟수 빈 문자열 예외`() {
        val emptyInput = ""

        Assertions.assertThatThrownBy {
            Validator.validateRepeatNum(emptyInput)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Validator.ERROR_EMPTY_TRIAL_COUNT)
    }

    @DisplayName("시도 횟수가 숫자가 아니면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = ["a", " ", "1a2"])
    fun `시도 횟수 숫자 아님 예외`(input: String) {
        Assertions.assertThatThrownBy {
            Validator.validateRepeatNum(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.ERROR_TRIAL_COUNT_NOT_A_NUMBER)
    }

    @DisplayName("시도 횟수가 1 미만이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-100"])
    fun `시도 횟수 1미만 예외`(input: String) {

        Assertions.assertThatThrownBy {
            Validator.validateRepeatNum(input)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Validator.ERROR_TRIAL_COUNT_NOT_POSITIVE)
    }
}