package racingcar.controller

import calculator.view.InputView
import racingcar.model.RacingGame

class Controller {
    fun run() {
        val carNames = InputView.getCarNames()
        val tries = InputView.getTries()

        val game = RacingGame(carNames, tries)
    }
}