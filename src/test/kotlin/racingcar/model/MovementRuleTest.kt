package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class MovementRuleTest {
    @ParameterizedTest
    @MethodSource("hasMoveAndStop")
    fun `랜덤 번호가 3보다 크면 true를 반환`(number: Int, expected: Boolean) {
        val rule = MovementRule(number)
        val result = rule.hasMoveAndStop()
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `랜덤값이 0~9일 때 결과는 항상 Boolean으로 반환`() {
        val randomNumber = RandomNumberGenerator().getRandomNumber()
        val result = MovementRule(randomNumber).hasMoveAndStop()
        assertThat(result).isIn(true, false)
    }

    private companion object {
        @JvmStatic
        fun hasMoveAndStop(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true),
                Arguments.of(8, true),
                Arguments.of(9, true)
            )
        }
    }
} // 통과