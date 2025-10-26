package racingcar.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `이름 검증 성공`() {
        val result = Validator.nameValidate("pobi,woni")
        assert(result.size == 2)
    }

    @Test
    fun `이름 5자 이상 예외`() {
        assertThrows<IllegalArgumentException> {
            Validator.nameValidate("abcde")
        }
    }

    @Test
    fun `횟수 검증 성공`() {
        val result = Validator.attemptValidator("5")
        assert(result == 5)
    }

    @Test
    fun `횟수 문자열 널 예외`() {
        assertThrows<IllegalArgumentException> {
            Validator.attemptValidator(" ")
        }
    }

    @Test
    fun `횟수 문자열 문자열 예외`() {
        assertThrows<IllegalArgumentException> {
            Validator.attemptValidator("abc")
        }
    }
}