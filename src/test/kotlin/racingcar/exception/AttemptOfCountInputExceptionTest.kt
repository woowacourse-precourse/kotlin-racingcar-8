package racingcar.exception

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.api.assertThrows
import java.util.stream.Stream
import org.junit.jupiter.params.provider.Arguments

class AttemptOfCountInputExceptionTest {
    @ParameterizedTest
    @MethodSource("readAttemptOfCountInput")
    fun `시도 횟수 입력이 잘못 되었을 경우 예외`(input: String) {
        assertThrows<IllegalArgumentException> {
            CountAttemptInputValidator().validateCountAttempt(input)
        }
    }

    private companion object {
        @JvmStatic
        fun readAttemptOfCountInput(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(""),
                Arguments.of("0"),
                Arguments.of("-1"),
                Arguments.of("1,2"),
                Arguments.of("a"),
                Arguments.of(","),
                Arguments.of("2147483648"),
            )
        }
    }
}
