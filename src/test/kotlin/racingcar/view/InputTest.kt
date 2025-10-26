package racingcar.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.view.domain.InputView

class InputTest : NsTest() {
    private lateinit var actualInput: String

    @Test
    fun `자동차 이름 사용자 입력`() {
        assertSimpleTest {
            run("pobi,woni,jun")
            assertThat(actualInput).isEqualTo("pobi,woni,jun")
        }
    }

    @Test
    fun `시도 횟수 사용자 입력`() {
        assertSimpleTest {
            run("3")
            assertThat(actualInput).isEqualTo("3")
        }
    }

    override fun runMain() {
        actualInput = InputView.console()
    }
}