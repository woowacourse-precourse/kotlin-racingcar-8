package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class InputProcessingTest {
    @Test
    fun `자동차 이름 입력 분할 기능 테스트`() {
        // given
        val testInput = "miso,seroi,hasta"

        // when
        val splitInput = splitCarName(testInput)

        // then
        assertThat(splitInput).containsOnly("miso", "seroi", "hasta")
    }

    @Test
    fun `차수 입력 정수 변환 기능 테스트`() {
        // given
        val testInput = "5"

        // when
        val intInput = stringToInt(testInput)

        // then
        assertThat(intInput).isEqualTo(5)
    }

    @Test
    fun `차수 입력 빈 문자열 테스트`() {
        // given
        val testInput = ""

        // when
        val intInput = stringToInt(testInput)

        // then
        assertThat(intInput).isEqualTo(0)
    }

    @Test
    fun `차수 입력 whitespace 테스트`() {
        // given
        val testInput = " "

        // when
        val intInput = stringToInt(testInput)

        // then
        assertThat(intInput).isEqualTo(0)
    }

    @Test
    fun `입력 분할 5글자 초과 예외 테스트`() {
        // given
        val testInput = "miso,saeroi,hasta"

        // when
        val exception = assertThrows<IllegalArgumentException> { splitCarName(testInput) }

        // then
        assertThat(exception.message).isEqualTo("이름은 5글자를 초과하거나 비어있을 수 없습니다.")
    }

    @Test
    fun `입력 분할 빈 문자열 예외 테스트`() {
        // given
        val testInput = "miso,seroi,hasta,"

        // when
        val exception = assertThrows<IllegalArgumentException> { splitCarName(testInput) }

        // then
        assertThat(exception.message).isEqualTo("이름은 5글자를 초과하거나 비어있을 수 없습니다.")
    }

    @Test
    fun `차수 입력 숫자가 아닌 문자 테스트`() {
        // given
        val testInput = "YourAreEverglowing"

        // when
        val exception = assertThrows<IllegalArgumentException> { stringToInt(testInput) }

        // then
        assertThat(exception.message).isEqualTo("숫자를 입력해주세요.")
    }

}