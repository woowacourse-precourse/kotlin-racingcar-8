package racingcar

import racingcar.controller.RaceController
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView
    val inputParser = InputParser
    val inputValidator = InputValidator
    val resultView = ResultView

    val raceController = RaceController(inputView, inputParser, inputValidator, resultView)

    raceController.run()
}
