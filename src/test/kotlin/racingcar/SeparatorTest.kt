package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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

    @ParameterizedTest
    @CsvSource(value = ["cold,play,para,dise", "puth,one,call,away", "time,bomb,all"])
    fun `이름을 ,를 기준으로 구분한다2`(testString: String) {
        // given
        val expectedAnswer = testString.split(",")

        // when
        val separator = Separator()

        // then
        assertEquals(expectedAnswer, separator.separateName(testString))
    }
}