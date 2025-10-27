package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputHandlerTest {
    private lateinit var outputHandler: OutputHandler
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputHandler = OutputHandler()
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @Test
    fun `자동차 이름과 현재 진행 상태를 출력한다`() {
        val carsPosition = mapOf("car1" to 2, "car2" to 0, "car3" to 3)
        val lineSeparator = System.lineSeparator()

        outputHandler.printRaceResult(carsPosition)

        val expectedOutput = "car1 : --${lineSeparator}car2 : ${lineSeparator}car3 : ---${lineSeparator}${lineSeparator}"
        assertThat(outputStream.toString()).isEqualTo(expectedOutput)
    }

    @Test
    fun `printWinners는 단일 우승자 이름을 출력한다`() {
        val winners = listOf("car1")
        val lineSeparator = System.lineSeparator()

        outputHandler.printWinners(winners)

        val expectedOutput = "최종 우승자 : car1${lineSeparator}"
        assertThat(outputStream.toString()).isEqualTo(expectedOutput)
    }

    @Test
    fun `printWinners는 여러 우승자 이름을 쉼표로 구분하여 출력한다`() {
        val winners = listOf("car1", "car2", "car3")
        val lineSeparator = System.lineSeparator()

        outputHandler.printWinners(winners)

        val expectedOutput = "최종 우승자 : car1, car2, car3${lineSeparator}"
        assertThat(outputStream.toString()).isEqualTo(expectedOutput)
    }
}