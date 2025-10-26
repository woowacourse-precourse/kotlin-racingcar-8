package racingcar.application.converter

import org.junit.jupiter.api.Assertions.assertEquals
import racingcar.domain.error.ErrorCode
import racingcar.domain.error.ErrorCode.INVALID_ATTEMPT_COUNT_NUMBER
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class StringToIntConverterTest {
    private val converter = StringToIntConverter()

    @Test
    fun `숫자 문자열은 Int로 변환`() {
        //given
        val input = "123"

        //when
        val result = converter.convert(input)

        //then
        assertEquals(123, result)
    }

    @Test
    fun `숫자가 아닌 문자가 포함되면 예외를 던진다`() {
        //given
        val input = "123test"

        //when
        val ex = assertThrows<IllegalArgumentException> {
            converter.convert(input)
        }

        //then
        assertEquals(INVALID_ATTEMPT_COUNT_NUMBER, ex.message)
    }

}