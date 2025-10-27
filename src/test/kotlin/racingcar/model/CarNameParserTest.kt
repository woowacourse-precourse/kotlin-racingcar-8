package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarNameParserTest {

    @Test
    fun `자동차 이름 파싱하기`() {
        assertEquals(listOf("pobi", "woni", "jun"), CarNameParser.parseCarsNames("pobi,woni,jun"))
    }
}