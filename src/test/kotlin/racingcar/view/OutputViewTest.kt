package racingcar.view

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.domain.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    @Test
    fun `라운드 결과를 정상적으로 출력한다`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        cars[0].move()
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val outputView = OutputView()
        outputView.printRound(cars)

        val output = outputStream.toString().trim()
        assertThat(output).contains("pobi", "woni")
    }

    @Test
    fun `우승자 출력 시 이름이 쉼표로 구분된다`() {
        val winners = listOf("pobi", "jun")
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val outputView = OutputView()
        outputView.printWinners(winners)

        val output = outputStream.toString().trim()
        assertThat(output).contains("최종 우승자", "pobi", "jun")
    }
}
