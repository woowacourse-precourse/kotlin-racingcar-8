package racingcar.domain


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `validateCarName 정상 입력`() {
        val testNames = listOf("a", "ab", "abc", "abcd", "abcde")
        for (name in testNames) {
            assertDoesNotThrow { Validator.validateCarName(name) }
        }
    }

    @Test
    fun `validateCarName 공백 이름 입력`() {
        val testName = " "
        val result = assertThrows<IllegalArgumentException> { Validator.validateCarName(testName) }

        assertThat(result.message).isEqualTo(ErrorType.EMPTY_NAME.message)
    }

    @Test
    fun `validateCarName 이름 제한길이 초과 입력`() {
        val testName = "abcdef"
        val result = assertThrows<IllegalArgumentException> { Validator.validateCarName(testName) }

        assertThat(result.message).isEqualTo(ErrorType.INVALID_NAME_LENGTH.message)
    }

    @Test
    fun `validateRound 정상 입력`() {
        val testRounds = listOf(1, 10, 100, 1000)
        for (round in testRounds) {
            assertDoesNotThrow { Validator.validateRound(round) }
        }
    }

    @Test
    fun `validateCarName 음수 입력`() {
        val testRound = -1
        val result = assertThrows<IllegalArgumentException> { Validator.validateRound(testRound) }

        assertThat(result.message).isEqualTo(ErrorType.NOT_POSITIVE_NUMBER.message)
    }

    @Test
    fun `validateCarName 0 입력`() {
        val testRound = 0
        val result = assertThrows<IllegalArgumentException> { Validator.validateRound(testRound) }

        assertThat(result.message).isEqualTo(ErrorType.NOT_POSITIVE_NUMBER.message)
    }
}