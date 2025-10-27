package racingcar.application.converter

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import racingcar.domain.error.ErrorCode.INVALID_CAR_NAME_LENGTH
import kotlin.test.Test
import kotlin.test.assertEquals

class StringToListConverterTest {
    private lateinit var converter: Converter<Collection<String>>

    @BeforeEach
    fun setUp() {
        converter = StringToListConverter()
    }

    @Test
    fun `문자열을 리스트로 변환`() {
        // given
        val input: String = "pobi,woni,jun"

        // when
        val result = converter.convert(input)

        //then
        assertEquals(result.size, 3)
        assertEquals(listOf("pobi", "woni", "jun"), result)
    }

    @Test
    fun `이름이 6글자 이상일때 예외 발생`() {
        // given
        val input: String = "pobibb,woni,jun"

        // when
        val errorMessage = assertThrows<IllegalArgumentException> {
            converter.convert(input)
        }

        // then
        assertEquals(INVALID_CAR_NAME_LENGTH, errorMessage.message)
    }
}