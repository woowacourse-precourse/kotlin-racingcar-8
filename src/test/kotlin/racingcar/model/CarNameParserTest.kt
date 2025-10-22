package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class CarNameParserTest {

    @Test
    fun `자동차 이름 파싱하기` () {
        val parser = CarNameParser()
        assertEquals(listOf("pobi","woni","jun"), parser.parseCarsNames("pobi,woni,jun"))
    }

    @Test
    fun `자동차 이름 길이 검증 통과` () {
        val parser = CarNameParser()
        assertDoesNotThrow {
            parser.validateCarName(listOf("pobi","woni","jun"))
        }
    }

    @Test
    fun `자동차 이름 길이 검증 실패` () {
        val parser = CarNameParser()
        assertThrows(IllegalArgumentException::class.java) {
            parser.validateCarName(listOf("abcsdwdds", "ace", "oddvvvd"))
        }
    }



}