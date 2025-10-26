package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputViewTest {

    @Test
    fun `쉼표로 구분된 자동차 이름을 올바르게 파싱한다`() {
        // given
        val input = "pobi,woni,jun"

        // when
        val result = InputView.parseCarNames(input)

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `자동차 이름 파싱 시 각 이름의 공백을 제거한다`() {
        // given
        val input = " pobi , woni , jun "

        // when
        val result = InputView.parseCarNames(input)

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `연속된 쉼표가 있으면 빈 토큰이 포함된다`() {
        // given
        val input = "pobi,,jun"

        // when
        val result = InputView.parseCarNames(input)

        // then
        assertThat(result).containsExactly("pobi", "", "jun")
    }

    @Test
    fun `숫자 문자열을 정수로 변환한다`() {
        // given
        val input = "5"

        // when
        val result = InputView.parseRoundCount(input)

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `숫자가 아닌 문자열은 예외를 발생시킨다`() {
        // given
        val input = "abc"

        // when & then
        assertThatThrownBy {
            InputView.parseRoundCount(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도 횟수는 숫자여야 합니다")
    }

    @Test
    fun `빈 문자열은 예외를 발생시킨다`() {
        // given
        val input = ""

        // when & then
        assertThatThrownBy {
            InputView.parseRoundCount(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("시도 횟수는 숫자여야 합니다")
    }
}