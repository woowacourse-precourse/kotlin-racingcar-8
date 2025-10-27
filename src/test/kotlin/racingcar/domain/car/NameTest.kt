package racingcar.domain.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.ErrorMessage

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class NameTest {

    @Test
    fun 다섯_자리_이하의_이름을_입력하면_이름_객체가_생성된다() {
        // given
        val input = "pobi"

        // when
        val name = Name(input)

        // then
        assertEquals(input, name.value)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun 이름이_비어있거나_공백이라면_IllegalArgumentException이_발생한다(input: String) {
        val exception = assertThrows<IllegalArgumentException> { Name(input) }
        assertEquals(exception.message, ErrorMessage.CAR_NAME_BLANK.message)
    }

    @Test
    fun 이름이_다섯_자리를_넘으면_IllegalArgumentException이_발생한다() {
        // given
        val input = "aaaaaa"

        // when
        val exception = assertThrows<IllegalArgumentException> { Name(input) }

        // then
        assertEquals(exception.message, ErrorMessage.CAR_NAME_TOO_LONG.message)
    }
}