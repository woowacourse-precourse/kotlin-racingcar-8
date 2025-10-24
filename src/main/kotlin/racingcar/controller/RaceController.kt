package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.port.InputPort
import racingcar.port.OutputPort
import racingcar.util.InputParser
import racingcar.util.InputValidator

class RaceController(
    private val inputPort: InputPort,
    private val outputPort: OutputPort,
    private val inputParser: InputParser,
    private val inputValidator: InputValidator
) {
    fun run() {
        val readCarNames: String? = inputPort.readCarNames()
        val readTryCount: String? = inputPort.readTryCount()

        val carNames = inputParser.parseCarNames(readCarNames ?: "")
        inputValidator.validateCarNames(carNames)
        val cars: List<Car> = carNames.map { Car(it) }
        val tryCount = inputValidator.validateTryCount(readTryCount)

        val race = Race(cars)

        outputPort.printFirstResult()
        repeat (tryCount) {
            race.runOneRound()

            cars.forEach { car ->
                outputPort.printRoundResult(car)
            }

            outputPort.printBlankLine()
        }

        val winners = race.findWinners()
        outputPort.printFinalWinner(winners)
    }
}