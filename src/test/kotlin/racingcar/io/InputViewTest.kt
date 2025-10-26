package racingcar.io

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.ErrorType

class InputViewTest : NsTest() {
    @Test
    fun `readNonEmptyLine CAR 매개변수 정상 입력`() {
        run(CORRECT_CAR_NAMES)

        val result = InputView.readNonEmptyLine(type = InputMessageType.CAR)
        assertThat(result).isEqualTo(CORRECT_CAR_NAMES)
    }


    @Test
    fun `readNonEmptyLine ROUND 정상 입력`() {
        run(CORRECT_ROUND)

        val result = InputView.readNonEmptyLine(type = InputMessageType.ROUND)
        assertThat(result).isEqualTo(CORRECT_ROUND)
    }

    @Test
    fun `readNonEmptyLine 빈 문자열 입력`() {
        run(BLANK)

        val error = assertThrows<IllegalArgumentException> {
            InputView.readNonEmptyLine(InputMessageType.CAR)
        }
        assertThat(error.message).isEqualTo(ErrorType.EMPTY_INPUT.message)
    }

    @Test
    fun `readNonEmptyLine CAR 입력 reader 사용`() {
        val mockReader = { CORRECT_CAR_NAMES }

        val result = InputView.readNonEmptyLine(InputMessageType.CAR, reader = mockReader)
        assertThat(result).isEqualTo(CORRECT_CAR_NAMES)
    }

    @Test
    fun `readNonEmptyLine ROUND 입력 reader 사용`() {
        val mockReader = { CORRECT_ROUND }

        val result = InputView.readNonEmptyLine(InputMessageType.ROUND, reader = mockReader)
        assertThat(result).isEqualTo(CORRECT_ROUND)
    }

    @Test
    fun `readNonEmptyLine 빈 문자열 reader 사용`() {
        val mockReader = { BLANK }

        val error = assertThrows<IllegalArgumentException> {
            InputView.readNonEmptyLine(InputMessageType.CAR, reader = mockReader)
        }
        assertThat(error.message).isEqualTo(ErrorType.EMPTY_INPUT.message)
    }

    @Test
    fun `readNonEmptyLine 특수문자 입력`() {
        run(SPECIAL_CHARACTERS)

        val result = InputView.readNonEmptyLine(InputMessageType.CAR)
        assertThat(result).isEqualTo(SPECIAL_CHARACTERS)
    }

    @Test
    fun `readNonEmptyLine 숫자 입력`() {
        run(TEST_NUMBERS)

        val result = InputView.readNonEmptyLine(InputMessageType.CAR)
        assertThat(result).isEqualTo(TEST_NUMBERS)
    }

    @Test
    fun `readNonEmptyLine 여러번 연속 호출`() {
        run(CORRECT_CAR_NAMES, CORRECT_ROUND)

        val carInput = InputView.readNonEmptyLine(InputMessageType.CAR)
        assertThat(carInput).isEqualTo(CORRECT_CAR_NAMES)

        val roundInput = InputView.readNonEmptyLine(InputMessageType.ROUND)
        assertThat(roundInput).isEqualTo(CORRECT_ROUND)
    }

    @Test
    fun `readNonEmptyLine 연속 호출 중 에러 발생`() {
        run(CORRECT_CAR_NAMES, BLANK)

        val carInput = InputView.readNonEmptyLine(InputMessageType.CAR)
        assertThat(carInput).isEqualTo(CORRECT_CAR_NAMES)

        val result = assertThrows<IllegalArgumentException> { InputView.readNonEmptyLine(InputMessageType.ROUND) }
        assertThat(result.message).isEqualTo(ErrorType.EMPTY_INPUT.message)
    }

    override fun runMain() {}

    companion object {
        const val CORRECT_CAR_NAMES = "pobi,woni,jun"
        const val CORRECT_ROUND = "5"
        const val BLANK = " "
        const val SPECIAL_CHARACTERS = "@@@,###"
        const val TEST_NUMBERS = "123,456"
    }
}
