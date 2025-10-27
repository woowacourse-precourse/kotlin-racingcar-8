package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Judge
import racingcar.view.InputView
import racingcar.view.OutputView
import java.io.ByteArrayInputStream

class RacingControllerTest {
    @Test
    fun `자동차 이름에 공백을 넣을 시 IllegalArgumentException이 발생한다`() {
        // given
        val fakeInput = "sam, ,toby"
        val inputStream = ByteArrayInputStream(fakeInput.toByteArray())

        val inputView = InputView()
        val outputView = OutputView()
        val judge = Judge()

        System.setIn(inputStream)

        // when & then
        assertThrows<IllegalArgumentException> { RacingController(inputView, outputView, judge).run() }
    }

    @Test
    fun `라운드 횟수 입력 시 숫자가 아닌 값을 넣으면 IllegalArgumentException 발생한다`() {
        val fakeInput = "hello"
        val inputStream = ByteArrayInputStream(fakeInput.toByteArray())

        val inputView = InputView()
        val outputView = OutputView()
        val judge = Judge()

        System.setIn(inputStream)

        assertThrows<IllegalArgumentException> { RacingController(inputView, outputView, judge).handleRepeatTime() }
    }
}