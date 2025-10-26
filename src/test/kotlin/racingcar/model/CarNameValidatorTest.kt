package racingcar.model

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.domain.CarName

class CarNameValidatorTest : NsTest() {
    @Test
    fun `빈 문자 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    @Test
    fun `연속 쉼표 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,,") }
        }
    }

    @Test
    fun `5자 초과 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi:woni") }
        }
    }

    @Test
    fun `5자 초과-2 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("poooooobi") }
        }
    }

    override fun runMain() {
        val input = Console.readLine()
        CarName.split(input)
    }
}