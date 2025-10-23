package racingcar

import racingcar.controller.RaceController
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.view.InputView

fun main() {
    val inputView = InputView
    val inputParser = InputParser
    val inputValidator = InputValidator

    val raceController = RaceController(inputView, inputParser, inputValidator)

    raceController.run()
}
