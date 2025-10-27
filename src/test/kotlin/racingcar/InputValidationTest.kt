package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

import org.junit.jupiter.api.Test

class InputValidationTest {
    @Test
    fun `자동차 이름 입력 특수 문자 예외 테스트`() {
        // given
        val testInput = "pobi,woni.jun"

        // when
        val exception = assertThrows<IllegalArgumentException> { validateCarNamesInput(testInput) }

        // then
        assertThat(exception.message).isEqualTo("이름을 올바르게 입력해주세요.")
    }

    @Test
    fun `자동차 이름 입력 첫글자 이후 공백 예외 테스트`() {
        // given (newline feed char)
        val testInput = "pobi, "

        // when
        val exception = assertThrows<IllegalArgumentException> { validateCarNamesInput(testInput) }

        // then
        assertThat(exception.message).isEqualTo("이름을 올바르게 입력해주세요.")
    }

    @Test
    fun `자동차 이름 입력 빈 문자열 예외 테스트`() {
        // given (newline feed char)
        val testInput = "\n"
        // when
        val exception = assertThrows<IllegalArgumentException> { validateCarNamesInput(testInput) }

        // then
        assertThat(exception.message).isEqualTo("이름이 입력되지 않았습니다.")
    }

    @Test
    fun `자동차 이름 입력 whitespace 예외 테스트`() {
        // given (newline feed char)
        val testInput = " "

        // when
        val exception = assertThrows<IllegalArgumentException> { validateCarNamesInput(testInput) }

        // then
        assertThat(exception.message).isEqualTo("이름이 입력되지 않았습니다.")
    }
}