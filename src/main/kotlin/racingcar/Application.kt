package racingcar

import racingcar.controller.RaceController
import racingcar.model.CarManager
import racingcar.model.InputParser
import racingcar.model.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val raceController = RaceController(CarManager(RandomNumberGenerator()), InputParser(), InputView, OutputView)
    raceController.startRace()
}
