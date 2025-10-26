package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarNameParserTest {

    @Test
    fun `문자열 자동차 이름 리스트 변환`() {
        val input = "carA,carB,carC"
        val result = CarNameParser.parse(input)

        assertThat(result).containsExactly("carA", "carB", "carC")
    }

    @Test
    fun `이름 사이 공백 제거`() {
        val input = "carA , carB , carC"
        val result = CarNameParser.parse(input)

        assertThat(result).containsExactly("carA", "carB", "carC")
    }

    @Test
    fun `빈 이름 무시`() {
        val input = "carA,carB,"
        val result = CarNameParser.parse(input)

        assertThat(result).containsExactly("carA", "carB")
    }

    @Test
    fun `입력 공백 시 빈 리스트 반환`() {
        val input = "   "
        val result = CarNameParser.parse(input)

        assertThat(result).isEmpty()
    }
}