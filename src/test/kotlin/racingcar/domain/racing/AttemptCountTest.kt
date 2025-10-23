package racingcar.domain.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.ErrorMessage

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class AttemptCountTest {

    @Test
    fun 입력값이_정수라면_시도할_횟수_객체를_생성한다() {
        // given
        val input = "5"

        // when
        val attemptCount = AttemptCount.from(input)

        // then
        assertEquals(attemptCount.value, 5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun 시도할_횟수가_비어있거나_공백이라면_IllegalArgumentException이_발생한다(input: String) {
        val exception = assertThrows<IllegalArgumentException> { AttemptCount.from(input) }
        assertEquals(exception.message, ErrorMessage.ATTEMPT_COUNT_BLANK.message)
    }

    @Test
    fun 입력값이_정수가_아니라면_llegalArgumentException이_발생한다() {
        // given
        val input = "a"

        // when
        val exception = assertThrows<IllegalArgumentException> { AttemptCount.from(input) }

        // then
        assertEquals(exception.message, ErrorMessage.ATTEMPT_COUNT_NOT_INTEGER.message)
    }
}