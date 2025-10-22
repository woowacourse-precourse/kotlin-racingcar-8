package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarNameParserTest {

    @Test
    fun `자동차 이름 파싱하기` () {
        val parser = CarNameParser()
        assertEquals(listOf("pobi","woni","jun"), parser.parseCarsNames("pobi,woni,jun"))
    }

}