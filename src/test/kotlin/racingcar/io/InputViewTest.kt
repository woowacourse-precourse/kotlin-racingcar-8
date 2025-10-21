package racingcar.io

import racingcar.main

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest: NsTest() {
    @Test
    fun `readNoneEmptyLine CAR 정상 입력`() {
        run("a,b,c")
        val result = InputView.readNoneEmptyLine(InputMessageType.CAR)

        assertThat(result).isEqualTo("a,b,c")
    }


    @Test
    fun `readNoneEmptyLine ROUND 정상 입력`() {
        run("5")
        val result = InputView.readNoneEmptyLine(InputMessageType.ROUND)

        assertThat(result).isEqualTo("5")
    }

    @Test
    fun `readNoneEmptyLine 빈 문자열 입력`() {
        run(" ")
        val error = assertThrows<IllegalArgumentException> {
            InputView.readNoneEmptyLine(InputMessageType.CAR)
        }

        assertThat(error.message).isEqualTo(InputError.EMPTY.message)
    }

    override fun runMain() {
        main()
    }
}
