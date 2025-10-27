package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {

    private lateinit var inputParser: InputParser

    @BeforeEach
    fun setUp() {
        inputParser = InputParser()
    }

    @ParameterizedTest(name = "정상적인 자동차 이름 입력 테스트")
    @CsvSource(value = [
        "pobi,woni,jun;pobi,woni,jun",
        "a,b;a,b",
        "car1,car2,car3,car4;car1,car2,car3,car4",
        "aCar;aCar"
    ], delimiter = ';')
    fun parseCarTest(input: String, expectedString: String) {
        val expected = expectedString.split(",")

        val actual = inputParser.parseCar(input)

        assertEquals(expected, actual)
    }

    @ParameterizedTest(name = "정상적인 자동차 이름 입력 테스트")
    @ValueSource(strings = [
        "pobi,woni,junmmm",
        "1.3",
        "",
        "20000000000000000000000"
    ])
    fun parseCarTest(invalidInput: String) {
        assertThrows<IllegalArgumentException> {
            inputParser.parseCar(invalidInput)
        }
    }
}