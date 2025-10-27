package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.port.InputPort
import racingcar.port.OutputPort
import racingcar.util.InputParser
import racingcar.util.InputValidator

class StubInputPort(private val carNames: String?, private val tryCount: String?) : InputPort {
    override fun readCarNames(): String? = carNames
    override fun readTryCount(): String? = tryCount
}

class StubOutputPort : OutputPort {
    val bar = "-"
    val messages = mutableListOf<String>()

    override fun printFirstResult() {
        messages.add("실행 결과")
    }

    override fun printRoundResult(car: Car) {
        val positionBar = bar.repeat(car.position)
        val resultLine = "${car.name} : $positionBar"

        messages.add(resultLine)
    }

    override fun printBlankLine() {
        messages.add("")
    }

    override fun printFinalWinner(winners: List<Car>) {
        val winnersName = winners.joinToString(", ") { it.name }
        messages.add("최종 우승자 : $winnersName")
    }
}

class RaceControllerTest {
    @Test
    fun `run() 실행 시 전체 게임이 정상적으로 진행되고 우승자를 출력한다`() {
        val carNames = "pobi,woni,jun"
        val tryCount = "5"
        val inputPort = StubInputPort(carNames, tryCount)
        val outputPort = StubOutputPort()
        val inputParser = InputParser
        val inputValidator = InputValidator

        val raceController = RaceController(inputPort, outputPort, inputParser, inputValidator)

        raceController.run()

        val allMessages = outputPort.messages

        assertThat(allMessages[0]).isEqualTo("실행 결과")

        // 전체 라인 수 검증: 헤더 1줄 + (차 3대 * 5번 시도) + 빈줄 5줄 + 우승자 1줄
        val expectedLineCount = 1 + (3 * 5) + 5 + 1
        assertThat(allMessages.size).isEqualTo(expectedLineCount)

        // 형식 검증
        val raceResultRegex = Regex("""\w+ : -*""")
        val linesWithBlanks = allMessages.subList(1, allMessages.size - 1)
        val raceLines = linesWithBlanks.filter { it.isNotBlank() }
        assertThat(raceLines).allMatch { it.matches(raceResultRegex) }

        // 마지막 줄(우승자) 검증
        assertThat(allMessages.last()).startsWith("최종 우승자 : ")
    }

    @Test
    fun `run() 실행 시 자동차 이름이 유효하지 않으면 예외 메시지를 출력한다`() {
        val carNames = "pobi,,jun"
        val tryCount = "5"
        val inputPort = StubInputPort(carNames, tryCount)
        val outputPort = StubOutputPort()
        val inputParser = InputParser
        val inputValidator = InputValidator

        val raceController = RaceController(inputPort, outputPort, inputParser, inputValidator)

        assertThatThrownBy {
            raceController.run()
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("공백")
    }

    @Test
    fun `run() 실행 시 시도 횟수가 유효하지 않으면 예외 메시지를 출력한다`() {
        val carNames = "pobi,woni,jun"
        val tryCount = "pobi"
        val inputPort = StubInputPort(carNames, tryCount)
        val outputPort = StubOutputPort()
        val inputParser = InputParser
        val inputValidator = InputValidator

        val raceController = RaceController(inputPort, outputPort, inputParser, inputValidator)

        assertThatThrownBy {
            raceController.run()
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("유효하지 않은 값")
    }
}