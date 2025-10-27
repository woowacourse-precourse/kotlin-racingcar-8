package racingcar.application.converter

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import racingcar.domain.error.ErrorCode.CAR_NAMES_MUST_BE_UNIQUE
import racingcar.domain.error.ErrorCode.INVALID_CAR_NAME_LENGTH
import kotlin.test.Test
import kotlin.test.assertEquals

class StringToSetConverterTest {
    private lateinit var converter: Converter<Set<String>>

    @BeforeEach
    fun setUp() {
        converter = StringToSetConverter()
    }

    @Test fun `중복시 예외 처리`() {
        //given
        val input = "pobi,woni,pobi"

        //when
        val ex = assertThrows<IllegalArgumentException> {
            converter.convert(input)
        }
        //then
        assertEquals(CAR_NAMES_MUST_BE_UNIQUE, ex.message)
    }

    @Test fun `이름이 6글자 이상일때 예외 발생`() {
        // given
        val input: String = "태용짱짱짱맨,woni,jun"

        // when
        val errorMessage = assertThrows<IllegalArgumentException> {
            converter.convert(input)
        }

        // then
        assertEquals(INVALID_CAR_NAME_LENGTH, errorMessage.message)
    }


}