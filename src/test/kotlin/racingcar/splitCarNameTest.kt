package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class splitCarNameTest {
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

}