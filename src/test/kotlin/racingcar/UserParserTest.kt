package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserParserTest : NsTest() {

    @Test
    fun `이름 입력시 공백이면 에러`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(" ")
            }
        }
    }

    @ParameterizedTest(name = "입력: \"{0}\" -> IllegalArgumentException")
    @ValueSource(strings = ["pobi, ,jun", "pobi, jun,", ",pobi,jun"])
    fun `쉼표로 구분된 문자열이 공백이면 에러`(given: String) {
        assertThrows<IllegalArgumentException> {
            UserParser(given)
        }
    }

    @Test
    fun `쉼표로 구분된 문자열이 5자 초과면 에러`() {
        assertThrows<IllegalArgumentException> {
            UserParser("pobi,junjun")
        }
    }


    override fun runMain() {
        main()
    }
}