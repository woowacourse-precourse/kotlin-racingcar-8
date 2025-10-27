package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InputValidatorTest {

    private lateinit var validator: InputValidator

    @BeforeEach
    fun setUp() {
        validator = InputValidator()
    }

    @Test
    fun `유효한 자동차 이름 리스트는 정상적으로 반환된다`() {
        val carNames = listOf("car1", "car2", "car3")

        val result = validator.validateCarNames(carNames)

        assertThat(result).isEqualTo(carNames)
    }

    @Test
    fun `빈 자동차 이름 리스트는 예외를 발생시킨다`() {
        val carNames = emptyList<String>()

        assertThatThrownBy { validator.validateCarNames(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 비어있을 수 없습니다.")
    }

    @Test
    fun `공백이 포함된 자동차 이름은 예외를 발생시킨다`() {
        val carNames = listOf("car1", " ", "car3")

        assertThatThrownBy { validator.validateCarNames(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 비어있을 수 없습니다.")
    }

    @Test
    fun `5자를 초과하는 자동차 이름은 예외를 발생시킨다`() {
        val carNames = listOf("car1", "toolong", "car3")

        assertThatThrownBy { validator.validateCarNames(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름 'toolong'은 5자를 초과할 수 없습니다.")
    }

    @Test
    fun `중복된 자동차 이름은 예외를 발생시킨다`() {
        val carNames = listOf("car1", "car1", "car2")

        assertThatThrownBy { validator.validateCarNames(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 중복될 수 없습니다.")
    }

    @Test
    fun `유효한 입력은 정수로 변환되어 반환된다`() {
        val input = "5"

        val result = validator.validateRaceCount(input)

        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `0 이하의 입력은 예외를 발생시킨다`() {
        val inputZero = "0"
        val inputNegative = "-1"

        assertThatThrownBy { validator.validateRaceCount(inputZero) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 양의 정수여야 합니다.")

        assertThatThrownBy { validator.validateRaceCount(inputNegative) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 양의 정수여야 합니다.")
    }

    @Test
    fun `정수가 아닌 입력은 예외를 발생시킨다`() {
        val inputNonNumeric = "abc"
        val inputDecimal = "1.5"

        assertThatThrownBy { validator.validateRaceCount(inputNonNumeric) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 정수여야 합니다.")

        assertThatThrownBy { validator.validateRaceCount(inputDecimal) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 정수여야 합니다.")
    }

    @Test
    fun `빈 문자열 입력은 예외를 발생시킨다`() {
        val input = ""

        assertThatThrownBy { validator.validateRaceCount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("시도 횟수는 정수여야 합니다.")
    }
}