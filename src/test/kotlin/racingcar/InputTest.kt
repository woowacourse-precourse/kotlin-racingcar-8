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

    @ParameterizedTest
    @ValueSource(strings = ["", "-1", "2.5", "0", "#"])
    fun `라운드 입력 시 양의 정수가 아니면 에러`(given: String) {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Validator.validateRoundInput(given)
            }
        }
    }

    override fun runMain() {
        main()
    }
}