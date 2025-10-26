package racingcar;

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

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

        // when
        setInput(testInput)
        val inputNames = getInputCarNames()

        // then
        assertThat(inputNames).isEqualTo(testInput)
    }

    @Test
    fun `차수 입력 기능 테스트`() {
        // given
        val testInput = "5"

        // when
        setInput(testInput)
        val inputRound = getInputRound()

        // then
        assertThat(inputRound).isEqualTo(5)
    }

    @Test
    fun `차수 입력 기능 반 뮨저욜 테스트`() {
        // given
        val testInput = "\n"

        // when
        setInput(testInput)
        val inputRound = getInputRound()

        // then
        assertThat(inputRound).isEqualTo(0)
    }

    @Test
    fun `자동차 이름 입력 특수문자 예외 테스트`() {
        // given
        val testInput = "pobi,woni.jun"

        // when
        setInput(testInput)
        val exception = assertThrows<IllegalArgumentException> { getInputCarNames() }

        // then
        assertThat(exception.message).isEqualTo("이름을 올바르게 입력해주세요.")
    }

    @Test
    fun `자동차 이름 입력 빈 문자열 예외 테스트`() {
        // given (newline feed char)
        val testInput = "\n"

        // when
        setInput(testInput)
        val exception = assertThrows<IllegalArgumentException> { getInputCarNames() }

        // then
        assertThat(exception.message).isEqualTo("이름이 입력되지 않았습니다.")
    }

    @Test
    fun `차수 입력 숫자가 아닌 문자 예외 테스트`() {
        // given
        val testInput = "W"

        // when
        setInput(testInput)
        val exception = assertThrows<IllegalArgumentException> { getInputRound() }

        // then
        assertThat(exception.message).isEqualTo("숫자를 입력해주세요.")
    }

    @AfterEach
    fun closeConsole() {
        Console.close()
    }
}
