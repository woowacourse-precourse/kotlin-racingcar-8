package racingcar.util

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.ErrorType
import racingcar.main

class ParserTest: NsTest() {
    @Test
    fun `splitWithDelimiters 기본 구분자 입력 케이스`() {
        val input = "a,b,c"
        val result = Parser.splitWithDelimiters(input)

        Assertions.assertThat(result).isEqualTo(listOf("a", "b", "c"))
    }

    @Test
    fun `splitWithDelimiters 커스텀 구분자 입력`() {
        val input = "a,b+c:d"
        val result = Parser.splitWithDelimiters(input, delimiters = listOf(',', '+', ':'))

        Assertions.assertThat(result).isEqualTo(listOf("a", "b", "c", "d"))
    }

    @Test
    fun `splitWithDelimiters 입력에 구분자가 포함 안된 경우`() {
        val input = "a b c"
        val result = Parser.splitWithDelimiters(input)

        Assertions.assertThat(result).isEqualTo(listOf("a b c"))
    }

    @Test
    fun `parseInt 정상 입력`() {
        val input = "10"
        val result = Parser.parseInt(input)

        Assertions.assertThat(result).isEqualTo(10)
    }

    @Test
    fun `parseInt 음수 입력`() {
        val input = "-10"
        val result = Parser.parseInt(input)

        Assertions.assertThat(result).isEqualTo(-10)
    }

    @Test
    fun `parseInt 숫자가 아닌 문자 입력`() {
        val input = "-A"
        val result = assertThrows<IllegalArgumentException> {
            Parser.parseInt(input)
        }

        Assertions.assertThat(result.message).isEqualTo(ErrorType.INVALID_NUMBER.message)
    }

    override fun runMain() {
        main()
    }
}