package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.util.InputParser
import racingcar.view.InputView

class RaceController(
    private val inputView: InputView,
    private val inputParser: InputParser
) {
    fun run() {
        val readCarNames = inputView.readCarNames()
        val readTryCount = inputView.readTryCount()

        val carNames = inputParser.parseCarNames(readCarNames)
        val cars : List<Car> = carNames.map { Car(it) }

        val game = Race(cars, readTryCount)
        game.run()
    }
}