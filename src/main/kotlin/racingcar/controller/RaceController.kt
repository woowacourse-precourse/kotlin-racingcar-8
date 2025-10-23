package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.util.InputParser
import racingcar.view.InputView
import racingcar.view.ResultView.printFinalWinner

class RaceController(
    private val inputView: InputView,
    private val inputParser: InputParser,
) {
    fun run() {
        val readCarNames = inputView.readCarNames()
        val readTryCount = inputView.readTryCount()

        val carNames = inputParser.parseCarNames(readCarNames)
        val cars : List<Car> = carNames.map { Car(it) }

        val race = Race(cars, readTryCount)
        race.run()

        val maxPosition = race.findFinalMaxPosition(cars)
        printFinalWinner(cars, maxPosition)
    }
}