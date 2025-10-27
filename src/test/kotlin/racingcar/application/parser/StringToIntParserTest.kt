package racingcar.application.parser

import org.junit.jupiter.api.Assertions.assertEquals
import racingcar.domain.error.ErrorCode.INVALID_ATTEMPT_COUNT_NUMBER
import org.junit.jupiter.api.assertThrows
import racingcar.domain.error.ErrorCode.ATTEMPT_COUNT_MUST_BE_GREATER_THAN_ZERO
import kotlin.test.Test

class StringToIntParserTest {
    private val parser = StringToIntParser()

    @Test
    fun `숫자 문자열은 Int로 변환`() {
        //given
        val input = "123"

        //when
        val result = parser.parse(input)

        //then
        assertEquals(123, result)
    }

    @Test
    fun `0 보다 작은 숫자는 예외 처리`() {
        //given
        val input = "-1"

        //when
        val ex = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        //then
        assertEquals(ATTEMPT_COUNT_MUST_BE_GREATER_THAN_ZERO, ex.message)
    }

    @Test
    fun `빈 값일때 예외 처리`() {
        //given
        val input = ""

        //when
        val ex = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        //then
        assertEquals(INVALID_ATTEMPT_COUNT_NUMBER, ex.message)
    }

    @Test
    fun `숫자가 아닌 문자가 포함되면 예외를 던진다`() {
        //given
        val input = "123test"

        //when
        val ex = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        //then
        assertEquals(INVALID_ATTEMPT_COUNT_NUMBER, ex.message)
    }

}