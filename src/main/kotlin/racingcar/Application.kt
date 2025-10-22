package racingcar

import racingcar.controller.RaceController
import racingcar.util.InputParser
import racingcar.view.InputView

fun main() {
    val inputView = InputView
    val inputParser = InputParser

    val raceController = RaceController(inputView, inputParser)

    raceController.run()
}
