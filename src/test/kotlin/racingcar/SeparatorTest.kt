package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeparatorTest {
    @Test
    fun `이름을 ,를 기준으로 구분한다`() {
        // given
        val testString = "sam,goh,swe"
        val result = listOf<String>("sam", "goh", "swe")

        // when
        val separator: Separator = Separator()

        // then
        assertEquals(result, separator.separateName(testString))
    }
}