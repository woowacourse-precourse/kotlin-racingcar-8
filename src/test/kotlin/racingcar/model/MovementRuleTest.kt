package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class MovementRuleTest {
    @ParameterizedTest
    @MethodSource("hasMoveAndStop")
    fun `4 이상이면 true, 4 미만이면 false를 반환`(number: Int, expected: Boolean) {
        val rule = MovementRule()
        val result = rule.hasMoveAndStop(number)
        assertThat(result).isEqualTo(expected)
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
}