package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class AttemptCountParserTest {

    @Test
    fun `정상 숫자는 Int 로 변환된다`() {
        val result = AttemptCountParser.parse("5")
        assertEquals(5, result)
    }

    @Test
    fun `음수면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            AttemptCountParser.parse("-1")
        }
    }

    @Test
    fun `숫자가 아니면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            AttemptCountParser.parse("abc")
        }
    }
}
