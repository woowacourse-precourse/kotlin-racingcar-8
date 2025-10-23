package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class CarRacingController {
    fun run() {
        OutputView.displayCarNamePrompt()
        val input = InputView.readCarNames()

        OutputView.displayAttemptCountPrompt()
    }
}