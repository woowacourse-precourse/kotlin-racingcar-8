package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.view.InputView
import racingcar.view.ResultView.printFinalWinner

class RaceController(
    private val inputView: InputView,
    private val inputParser: InputParser,
    private val inputValidator: InputValidator
) {
    fun run() {
        val readCarNames: String? = inputView.readCarNames()
        val readTryCount : Int? = inputView.readTryCount()

        val carNames = inputParser.parseCarNames(readCarNames ?: "")
        inputValidator.validateCarNames(carNames)
        val cars : List<Car> = carNames.map { Car(it) }

        val tryCount = inputValidator.validateTryCount(readTryCount)
        val race = Race(cars, tryCount)
        race.run()

        val maxPosition = race.findFinalMaxPosition(cars)
        printFinalWinner(cars, maxPosition)
    }
}