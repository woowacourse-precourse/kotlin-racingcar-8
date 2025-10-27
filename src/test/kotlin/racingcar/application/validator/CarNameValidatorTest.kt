package racingcar.application.validator

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.error.ErrorCode
import kotlin.test.assertEquals

class CarNameValidatorTest {
    private lateinit var validator: Validator

    @BeforeEach
    fun setUp() {
        validator = CarNameValidator()
    }

    @Test
    fun `자동차 이름들의 쉼표가 없으면 에러를 던진다`() {

        //given
        val input = "pobi woni"
        // when + then
        val ex = assertThrows<IllegalArgumentException> {
            validator.validate(input)
        }
        assertEquals(ErrorCode.NAMES_MUST_BE_COMMA_SEPARATED, ex.message)
    }

    @Test
    fun `자동차 이름이 공백일때`() {
        val input = "  "
        val ex = assertThrows<IllegalArgumentException> {
            validator.validate(input)
        }
        assertEquals(ErrorCode.NAMES_MUST_BE_COMMA_SEPARATED, ex.message)
    }

    @Test
    fun `문자열이 쉼표 로 끝날때 에러 발생`(){
        val input = "pobkj,"
        val ex = assertThrows<IllegalArgumentException> {
            validator.validate(input)
        }
        assertEquals(ErrorCode.NAMES_MUST_BE_COMMA_SEPARATED, ex.message)
    }
}