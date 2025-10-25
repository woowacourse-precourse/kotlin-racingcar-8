package racingcar.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarNameValidatorTest {
    @Test
    fun `자동차 이름 길이 검증 통과`() {
        assertDoesNotThrow {
            CarNameValidator.validateCarName(listOf("pobi", "woni", "jun"))
        }
    }

    @Test
    fun `자동차 이름 길이 검증 실패`() {
        assertThrows(IllegalArgumentException::class.java) {
            CarNameValidator.validateCarName(listOf("abcsdwdds", "ace", "oddvvvd"))
        }
    }

    @Test
    fun `빈 문자열 입력 시`() {
        assertThrows(IllegalArgumentException::class.java) {
            CarNameValidator.validateCarName(listOf(""))
        }
    }
}