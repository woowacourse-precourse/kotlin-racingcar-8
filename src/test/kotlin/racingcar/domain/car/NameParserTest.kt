package racingcar.domain.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Test

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores::class)
class NameParserTest {

    @Test
    fun 입력값을_쉼표를_기준으로_올바르게_분리한다() {
        // given
        val input = "pobi,woni , jun"

        // when
        val names = NameParser.splitByComma(input)

        // then
        Assertions.assertEquals(names[0], "pobi")
        Assertions.assertEquals(names[1], "woni")
        Assertions.assertEquals(names[2], "jun")
    }
}