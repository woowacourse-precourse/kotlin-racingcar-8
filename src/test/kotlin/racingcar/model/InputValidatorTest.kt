package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.model.InputValidator.findDuplicateName
import racingcar.model.InputValidator.validateCarName
import racingcar.model.InputValidator.validateRaceCount

class InputValidatorTest {
    @Test
    fun `자동차 이름 길이 검증 통과`() {
        assertDoesNotThrow {
            validateCarName(listOf("pobi", "woni", "jun"))
        }
    }

    @Test
    fun `자동차 이름 길이 검증 실패`() {
        assertThrows(IllegalArgumentException::class.java) {
            validateCarName(listOf("abcsdwdds", "ace", "oddvvvd"))
        }
    }

    @Test
    fun `빈 문자열 입력 시`() {
        assertThrows(IllegalArgumentException::class.java) {
            validateCarName(listOf(""))
        }
    }

    @Test
    fun `중복된 이름 입력`() {
        val input = listOf("pobi", "pobi", "jun", "woni", "woni")
        val answer = mutableMapOf<String, Set<Int>>()
        answer["pobi"] = mutableSetOf(0, 1)
        answer["woni"] = mutableSetOf(3, 4)
        assertEquals(answer, findDuplicateName(input))
    }

    @ParameterizedTest
    @CsvSource(
        "0",
        "-4",
        "d4",
    )
    fun `경주 횟수를 잘못 입력 시`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
           validateRaceCount(input)
        }
    }

    @Test
    fun `경주 횟수 정상 입력 시`() {
        assertDoesNotThrow {
            validateRaceCount("5")
        }
    }
}