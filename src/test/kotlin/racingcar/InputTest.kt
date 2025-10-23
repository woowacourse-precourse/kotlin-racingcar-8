package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.validator.Validator

class InputTest : NsTest() {
    @Test
    fun `이름 입력시 공백이면 에러`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateNotBlank(" ")
            }
        }
    }

    override fun runMain() {
        main()
    }
}