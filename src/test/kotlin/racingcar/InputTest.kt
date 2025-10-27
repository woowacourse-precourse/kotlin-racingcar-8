package racingcar;

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

public class InputTest {

    // Custom function for System Input test
    // this code is referred by command() from NsTest.java
    private fun setInput(input: String) {
        System.setIn(input.byteInputStream())
    }

    // Custom functions for invalidating setInput() custom function's side effect
    private val initSystemInput = System.`in`

    @BeforeEach
    fun resetInput() {
        System.setIn(initSystemInput)
    }

    @Test
    fun `자동차 이름 입력 기능 테스트`() {
        // given
        val testInput = "pobi,woni,jun"
        val inputView = InputView()

        // when
        setInput(testInput)
        val inputNames = inputView.getInputCarNames()

        // then
        assertThat(inputNames).isEqualTo(testInput)
    }

    @Test
    fun `차수 입력 기능 테스트`() {
        // given
        val testInput = "5"
        val inputView = InputView()

        // when
        setInput(testInput)
        val inputRound = inputView.getInputRound()

        // then
        assertThat(inputRound).isEqualTo(testInput)
    }

    @Test
    fun `차수 입력 기능 빈 문자열 테스트`() {
        // given
        val testInput = "\n"
        val inputView = InputView()

        // when
        setInput(testInput)
        val inputRound = inputView.getInputRound()

        // then (it's Console.readLine() to blame)
        assertThat(inputRound).isEqualTo("")
    }

    @Test
    fun `차수 입력 기능 숫자가 아닌 문자열 테스트`() {
        // given
        val testInput = "O"
        val inputView = InputView()

        // when
        setInput(testInput)
        val inputRound = inputView.getInputRound()

        // then
        assertThat(inputRound).isEqualTo(testInput)
    }

    @AfterEach
    fun closeConsole() {
        Console.close()
    }
}
