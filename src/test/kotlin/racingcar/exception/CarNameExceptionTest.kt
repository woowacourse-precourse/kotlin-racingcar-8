package racingcar.exception

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.api.assertThrows
import java.util.stream.Stream
import org.junit.jupiter.params.provider.Arguments


class CarNameExceptionTest {
    @ParameterizedTest
    @MethodSource("provideCarNameInput")
    fun `자동차 이름이 잘못 입력 되었을 경우 예외`(input: String) {
        assertThrows<IllegalArgumentException> {
            CarNameInputValidator().validateCarName(input)
        }
    }

    private companion object {
        @JvmStatic
        fun provideCarNameInput(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(""),
                Arguments.of("pobi,javaji"),
                Arguments.of("pobi, woni"),
                Arguments.of(","),
                Arguments.of("pobi,"),
                Arguments.of(",pobi"),
                Arguments.of("pobi,,woni"),
                Arguments.of("pobi,pobi")
            )
        }
    }
}
