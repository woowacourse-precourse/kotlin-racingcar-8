package racingcar.domain.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test
import racingcar.util.Util

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class UtilTest {

    @Test
    fun 입력값을_쉼표를_기준으로_올바르게_분리한다() {
        // given
        val input = "pobi,woni , jun"

        // when
        val names = Util.splitByComma(input)

        // then
        assertEquals(names[0], "pobi")
        assertEquals(names[1], "woni")
        assertEquals(names[2], "jun")
    }
}