package racingcar

import racingcar.controller.RaceController
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputPort = InputView
    val outputPort = OutputView
    val inputParser = InputParser
    val inputValidator = InputValidator

    val raceController = RaceController(inputPort, outputPort, inputParser, inputValidator)

    raceController.run()
}
