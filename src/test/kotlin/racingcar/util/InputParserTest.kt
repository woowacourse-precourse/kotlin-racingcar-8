package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputParserTest {
    @Test
    fun `parseCarNames()는 쉼표로 구분된 문자열을 리스트로 변환한다`() {
        val carNames = InputParser.parseCarNames("pobi,woni")
        assertThat(carNames).isEqualTo(listOf("pobi", "woni"))
    }

    @Test
    fun `parseCarNames()는 이름이 하나일 때도 리스트로 변환한다`() {
        val carName = InputParser.parseCarNames("pobi")
        assertThat(carName).isEqualTo(listOf("pobi"))
    }
}