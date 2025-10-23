package racingcar.model

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RaceCountValidatorTest {

    @ParameterizedTest
    @CsvSource(
        "0",
        "-4",
        "d4",
    )
    fun `경주 횟수를 잘못 입력 시`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            RaceCountValidator.validateRaceCount(input)
        }
    }

    @Test
    fun `경주 횟수 정상 입력 시`() {
        assertDoesNotThrow {
            RaceCountValidator.validateRaceCount("5")
        }
    }
}